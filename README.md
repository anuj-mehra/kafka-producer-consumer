# Project to demonstrate how to communicate with Kafka topics. This project has both kafka-producer and kafka-consumer. 

#This project produces two deployable jars:	
	kafka-producer.jar
	kafka-consumer.jar

##This project is having three modules
1. commons (kafka-producer-consumer-commons)
2. kafka-producer
3. kafka-consumer

## Configuring Kafka on windows local machine:
Version of kafka used: kafka_2.10-0.10.2.1

Placed on following location on harh-drove:
E:\apps\kafka\kafka_2.10-0.10.2.1\

###Start zookeeper:
E:\apps\kafka\kafka_2.10-0.10.2.1\bin\windows>zookeeper-server-start.bat  ../../config/zookeeper.properties

###Start Kafka:
cd E:\apps\kafka\kafka_2.10-0.10.2.1\
.\bin\windows\kafka-server-start.bat .\config\server.properties


###Create topic:
cd E:\apps\kafka\kafka_2.10-0.10.2.1\bin\windows
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic transactions
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic positions


### kafka-producer.brokers=localhost:2181

## Module: kafka-producer:
This module inserts data in two topics;
	(a) transactions
	(b) positions

	
Application configs are read from application.conf in case of tests.
For actual running, need to provide the fully qualified path of the application.conf when starting the jar.
Use following command to start kafka-producer jar:

 
 
 
## Module: kafka-consumer:
This module reads data from two topics;
	(a) transactions
	(b) positions
	
Application configs are read from application.conf in case of tests.
For actual running, need to provide the fully qualified path of the application.conf when starting the jar.
Use following command to start kafka-consumer jar:
