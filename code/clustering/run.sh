#!/bin/bash
mvn exec:java -Dexec.mainClass=com.rhc.jdg.App -Djava.net.preferIPv4Stack=true -Djgroups.bind_addr=127.0.0.1 $@
