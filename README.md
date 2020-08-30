This project is having three modules
1. commons (kafka-producer-consumer-commons)
2. kafka-producer
3. kafka-consumer

This project produces two deployable jars:	
	kafka-producer.jar
	kafka-consumer.jar


kafka-producer:
This module inserts data in two topics;
	(a) transactions
	(b) positions

	
Application configs are read from application.conf in case of tests.
For actual running, need to provide the fully qualified path of the application.conf when starting the jar.
Use following command to start kafka-producer jar:

 
 
 
kafka-consumer:
This module reads data from two topics;
	(a) transactions
	(b) positions
	
Application configs are read from application.conf in case of tests.
For actual running, need to provide the fully qualified path of the application.conf when starting the jar.
Use following command to start kafka-consumer jar: