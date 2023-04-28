#!/bin/bash

# stop on errors
set -e

if [ $# -ge 1 ]; then
    solution="$1"
fi

function buildComparator() {
    pushd Comparator > /dev/null

    echo "Build Comparator"

    ./gradlew -q build

    popd > /dev/null
}

function checkSolution() {
    local solution="$1"
    pushd "../solutions/$solution" > /dev/null

    echo "Checking $solution"

    if [ ! -f "launch.env" ]; then
        echo "launch.env not found"
        exit 1
    fi
    unset build
    unset run

    source launch.env

    local inputDir="../../models/"
    local outputDir="../../output/$solution/$(date +%Y-%m-%d_%H-%M-%S)"

    mkdir -p "$outputDir"

    # set common source and change
    export SOURCE_PATH="$(realpath $inputDir/SampleClass.xmi)"
    export CHANGE_PATH="$(realpath $inputDir/SampleClassChangeModel.xmi)"

    # set target for incremental run
    local incrementalRunTarget="$outputDir/SampleClass-incremental.xmi"
    touch "$incrementalRunTarget"
    export TARGET_PATH="$(realpath $incrementalRunTarget)"
    export EXPECTED_MODEL="$TARGET_PATH"

    echo "Running $solution in incremental mode"
    eval "$run"

    # set target for batch run
    local batchRunTarget="$outputDir/SampleClass-batch.xmi"
    export TARGET_PATH="$(realpath "$batchRunTarget")"
    export CURRENT_MODEL="$TARGET_PATH"
    export BATCH_MODE="1"

    echo "Running $solution in batch mode"
    eval "$run"

    unset BATCH_MODE

    # compare results using comparator
    cd ../../utils/Comparator > /dev/null

    echo "Comparing both runs"
    local error=0

    ./gradlew -q run || error=1 && true

    local reportFile="$outputDir/report.csv"
    local message=""
    if [ $error -eq 1 ]; then
        message="$SOURCE_PATH,$CHANGE_PATH,$EXPECTED_MODEL,$CURRENT_MODEL,error"
    else
        message="$SOURCE_PATH,$CHANGE_PATH,$EXPECTED_MODEL,$CURRENT_MODEL,ok"
    fi

    if [ ! -f "$reportFile" ]; then
        echo "source,change,incremental_output,batch_output,status" > "$reportFile"
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