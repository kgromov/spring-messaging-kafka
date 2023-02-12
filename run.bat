# Start the ZooKeeper service
${KAFKA_HOME}\bin\windows\zookeeper-server-start.sh config\zookeeper.properties

# Start the Kafka broker service
${KAFKA_HOME}\bin\windows\kafka-server-start.sh config\server.properties