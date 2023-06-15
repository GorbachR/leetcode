#!/bin/bash

TEMP_ARG=$1
PATH_DIR=$(find ./ -type d -name "$TEMP_ARG*" -print -quit)

if [ -z "$PATH_DIR" ] || [ ! -f "$PATH_DIR"/*_test.go ]; then
    echo "Leetcode problem $TEMP_ARG written in go or tests don't exist" >&2
    exit 1
fi

go test "$PATH_DIR" -v
