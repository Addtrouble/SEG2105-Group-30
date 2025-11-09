#!/usr/bin/env sh
# Minimal Gradle wrapper launcher

# Resolve script location
PRG="$0"
while [ -h "$PRG" ]; do
  ls=$(ls -ld "$PRG")
  link=$(expr "$ls" : '.*-> \(.*\)$')
  if expr "$link" : '/.*' >/dev/null; then
    PRG="$link"
  else
    PRG=$(dirname "$PRG")/"$link"
  fi
done
SAVED=$(pwd)
cd "$(dirname "$PRG")" >/dev/null
APP_HOME=$(pwd -P)
cd "$SAVED" >/dev/null

# Java exec
if [ -z "$JAVA_HOME" ]; then
  JAVA_EXE=java
else
  JAVA_EXE="$JAVA_HOME/bin/java"
fi

WRAPPER_JAR="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
WRAPPER_MAIN=org.gradle.wrapper.GradleWrapperMain

exec "$JAVA_EXE" -Xmx64m -Xms64m -cp "$WRAPPER_JAR" $WRAPPER_MAIN "$@"
