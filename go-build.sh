#!/bin/bash

TEMP_ARG=$1
PATH_DIR=$(find ./ -type d -name "$TEMP_ARG*" -print -quit)

if [ -z "$PATH_DIR" ] || [ ! -f "$PATH_DIR"/*.go ]; then
    echo "Leetcode problem $TEMP_ARG written in go doesn't exist" >&2
    exit 1
fi
{
cd "$PATH_DIR"
EXENAME=$(find ./ -type f -name "*.go" -print0 -quit | xargs -0 basename | cut -f 1 -d ".")
go build -o "./build" && "./build/$EXENAME"
}