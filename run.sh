#!/bin/bash

# Start the ZooKeeper service
${KAFKA_HOME}/bin/zookeeper-server-start.sh config/zookeeper.properties

# Start the Kafka broker service
${KAFKA_HOME}/bin/kafka-server-start.sh config/server.properties