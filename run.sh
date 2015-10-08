#!/bin/bash

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home

java -jar scout-search/build/libs/scout-search-0.1.0-SNAPSHOT-all.jar server scout-search/src/main/resources/scout.yml
