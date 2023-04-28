#!/bin/bash

# stop on errors
set -e

if [ $# -ge 1 ]; then
    solution="$1"
fi

INPUT_DIR="../../models/"
OUTPUT_DIR="../../output/"

function buildComparator() {
    pushd Comparator > /dev/null

    echo "Build Comparator"

    ./gradlew -q build

    popd > /dev/null
}

function checkSolution() {
    local solution="$1"
    local outputDir="$OUTPUT_DIR/$solution/$(date +%Y-%m-%d_%H-%M)/"

    pushd "../solutions/$solution" > /dev/null

    echo "Checking $solution"

    if [ ! -f "launch.env" ]; then
        echo "launch.env not found"
        exit 1
    fi
    unset build
    unset run

    source launch.env

    eval "$build"

    for scenario in $(ls "$INPUT_DIR")
    do
        if [ -f "$INPUT_DIR/$scenario/class.xmi" ]; then
            echo "Checking $solution with $scenario"
            checkScenario "$solution" "$scenario" "$outputDir"
        else
            echo "Skipping $solution with $scenario"
            continue
        fi
    done


    popd > /dev/null
}

function checkScenario() {
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

    echo "Running $solution in incremental mode"
    eval "$run"

    # set target for batch run
    local batchRunTarget="$outputDir/target_batchbatch.xmi"
    export TARGET_PATH="$(realpath "$batchRunTarget")"
    export CURRENT_MODEL="$TARGET_PATH"
    export BATCH_MODE="1"

    echo "Running $solution in batch mode"
    eval "$run"

    unset BATCH_MODE

    # compare results using comparator
    pushd ../../utils/Comparator > /dev/null

    echo "Comparing both runs"
    local error=0

    ./gradlew -q run || error=1 && true

    local reportFile="$outputDir/../report.csv"
    local message=""
    if [ $error -eq 1 ]; then
        message="$solution,$scenario,error"
    else
        message="$solution,$scenario,ok"
    fi

    if [ ! -f "$reportFile" ]; then
        echo "solution,scenario,status" > "$reportFile"
    fi
    echo "$message" >> "$reportFile"

    popd > /dev/null
}



buildComparator

if [ -z $solution ]
then
    for solution in $(ls ../solutions)
    do
        checkSolution "$solution"
    done
else
    checkSolution "$solution"
fi