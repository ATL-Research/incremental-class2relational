#!/bin/bash

# stop on errors
set -e

# cd to script directory
cd "${0%/*}"

_VERBOSE=0
solutions=""

while [[ $# -gt 0 ]]; do
    case $1 in
        --help|-h)
            echo "Usage: ./check_solution.sh [-h|--help|--solutions|solution]"
            echo "      -h, --help: display this help"
            echo "      -v, --verbose: increase verbosity"
            echo "      --solutions: list available solutions"
            echo "      solution: space separeted list of names of the solutions to check (must be in solutions folder). If not provided, all solutions will be checked"
            exit 0
            ;;
        --solutions)
            echo "Available solutions:"
            for solution in $(ls ../solutions); do
                echo " - $solution"
            done
            exit 0
            ;;
        --verbose|-v)
            _VERBOSE=1
            shift
            ;;
        *)
            solutions="${solutions} $1"
            if [ ! -d "../solutions/$1" ]; then
                echo "Solution $1 not found"
                exit 1
            fi
            shift
            ;;
    esac
done


INPUT_DIR="../../models/"
OUTPUT_DIR="../../output/$(date +%Y-%m-%d_%H-%M)"
globalReport="$OUTPUT_DIR/report.csv"

function log {
    if [[ $_VERBOSE -eq 1 ]]; then
        echo "$@"
    fi
}

function log_error {
    echo "ERR: $@"
}

function buildComparator {
    pushd Comparator > /dev/null

    log "Build Comparator"

    ./gradlew -q build

    popd > /dev/null
}

function checkSolution {
    local solution="$1"
    local outputDir="$OUTPUT_DIR/$solution/"

    pushd "../solutions/$solution" > /dev/null

    echo "Checking $solution"

    if [ ! -f "launch.env" ]; then
        log_error "launch.env not found"
	popd
        return
    fi
    unset build
    unset run

    source launch.env

    eval "$build"

    for scenario in $(ls "$INPUT_DIR")
    do
        if [ -f "$INPUT_DIR/$scenario/class.xmi" ]; then
            log "Checking $solution with $scenario"
            checkScenario "$solution" "$scenario" "$outputDir"
        else
            log "Skipping $solution with $scenario"
            continue
        fi
    done


    popd > /dev/null
}

function checkScenario {
    local solution="$1"
    local scenario="$2"
    local outputDir="$3/$scenario"
    

    mkdir -p "$outputDir"

    # set common source and change
    export SOURCE_PATH="$(realpath $INPUT_DIR/$scenario/class.xmi)"
    export CHANGE_PATH="$(realpath $INPUT_DIR/$scenario/change.xmi)"

    # set target for incremental run
    local incrementalRunTarget="$outputDir/target_incremental.xmi"
    touch "$incrementalRunTarget"
    export TARGET_PATH="$(realpath $incrementalRunTarget)"
    export EXPECTED_MODEL="$TARGET_PATH"

    log "Running $solution in incremental mode"
    eval "$run" || true # ignore errors

    # set target for batch run
    local batchRunTarget="$outputDir/target_batch.xmi"
    touch "$batchRunTarget"
    export TARGET_PATH="$(realpath "$batchRunTarget")"
    export CURRENT_MODEL="$TARGET_PATH"
    export BATCH_MODE="1"

    log "Running $solution in batch mode"
    eval "$run" || true # ignore errors

    unset BATCH_MODE

    # compare results using comparator
    pushd ../../utils/Comparator > /dev/null

    log "Checking correctness"
    local correctness=$(checkCorrectness "$incrementalRunTarget" "$batchRunTarget")
    log "Correctness: $correctness"

    log "Checking completeness"
    local completeness=$(checkCompleteness "$scenario" "$incrementalRunTarget")
    log "Completeness: $completeness"

    local reportFile="$outputDir/../report.csv"
    local message="$solution,$scenario,$correctness,$completeness"
    
    if [ ! -f "$reportFile" ]; then
        echo "solution,scenario,correctness,completeness" > "$reportFile"
    fi
    echo "$message" >> "$reportFile"
    echo "$message" >> "$globalReport"

    popd > /dev/null
}

function checkCompleteness() {
    local scenario="$1"
    local target="$2"
    local scenarioDir="$INPUT_DIR/$scenario"

    if [ ! -f "$target" ]; then
        echo "no target"
        return
    fi

    local nb_expected=$(ls $scenarioDir/expected*.xmi 2> /dev/null | wc -l)
    if [ $nb_expected -eq 0 ]; then
        echo "OK"
        return
    fi

    for expected in $scenarioDir/expected*.xmi
    do
        if [ ! -f "$expected" ]; then
            continue
        fi

        local res=$(compareResults "$expected" "$target")
        if [ "$res" == "ok" ]; then
            echo "$(basename $expected)"
            return
        fi
    done
    echo "no match"
}

function checkCorrectness() {
    local incremental="$1"
    local batch="$2"

    compareResults "$incremental" "$batch"
}

function compareResults() {
    local left="$1"
    local right="$2"
    local error="ok"
    local logs="$OUTPUT_DIR/comparisons_logs.txt"

    pushd ../../utils/Comparator > /dev/null

    export EXPECTED_MODEL="$left"
    export CURRENT_MODEL="$right"

    echo "Comparing $left and $right" >> "$logs"

    java -jar build/libs/Comparator-all.jar 2>> "$logs"  || error="error" && true

    unset EXPECTED_MODEL
    unset CURRENT_MODEL

    popd > /dev/null

    echo $error
}

buildComparator

mkdir -p "$(dirname "$globalReport")"

if [ ! -f "$globalReport" ]; then
    echo "solution,scenario,correctness,completeness" > "$globalReport"
fi

if [ -z "$solutions" ]
then
    for solution in $(ls ../solutions)
    do
        checkSolution "$solution"
    done
else
    for s in $solutions;
    do
        checkSolution "$s"
    done
fi
