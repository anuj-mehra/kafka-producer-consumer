# Project to demonstrate how to communicate with Kafka topics. This project has both kafka-producer and kafka-consumer. 

#This project produces two deployable jars:	
	kafka-producer.jar
	kafka-consumer.jar

##This project is having three modules
1. commons (kafka-producer-consumer-commons)
2. kafka-producer
3. kafka-consumer

## Configuring Kafka on windows local machine:
Version of kafka used: kafka_2.11-2.0.1

Placed on following location on hard-drive:
E:\apps\kafka\working\kafka_2.11-2.0.1

###Start zookeeper:
cd E:\apps\kafka\working\kafka_2.11-2.0.1
.\bin\windows\zookeeper-server-start.bat  .\config\zookeeper.properties

###Start Kafka:
cd E:\apps\kafka\working\kafka_2.11-2.0.1
.\bin\windows\kafka-server-start.bat .\config\server.properties


###Create topic:
cd E:\apps\kafka\working\kafka_2.11-2.0.1
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic transactions
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic positions


### kafka-producer.brokers=localhost:9092
### kafka.bootstrap-server=localhost:2181


### Create dummy producer on command line
cd E:\apps\kafka\working\kafka_2.11-2.0.1
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic transactions
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic positions


### Create dummy consumers on command line (to test if producers are working fine)
cd E:\apps\kafka\working\kafka_2.11-2.0.1
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic transactions
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic positions


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
