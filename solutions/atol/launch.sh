#!/bin/bash

function build() {
    # TODO gradle in docker does not have access to github credentials to fetch dependencies

    # docker build -t atol .
    ./gradlew clean build
}

function run() {
    # docker run --rm \
    #     -v "$SOURCE_PATH":"$SOURCE_PATH" \
    #     -v "$CHANGE_PATH":"$CHANGE_PATH" \
    #     -v "$TARGET_PATH":"$TARGET_PATH" \
    #     -e "SOURCE_PATH=$SOURCE_PATH" \
    #     -e "CHANGE_PATH=$CHANGE_PATH" \
    #     -e "TARGET_PATH=$TARGET_PATH" \
    #     atol
    ./gradlew run
}
