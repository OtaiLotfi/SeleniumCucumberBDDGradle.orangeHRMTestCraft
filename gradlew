#!/bin/sh
BASE_DIR=$(cd "$(dirname "$0")" && pwd)
exec "$BASE_DIR/gradle/wrapper/gradle-wrapper.jar" "$@"
