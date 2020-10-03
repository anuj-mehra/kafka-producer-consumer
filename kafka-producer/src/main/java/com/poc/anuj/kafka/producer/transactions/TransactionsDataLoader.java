package com.poc.anuj.kafka.producer.transactions;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poc.anuj.kafka.producer.config.KafkaProducerConfig;
import com.poc.anuj.kafka.producer.service.ProducerService;

@Component
public class TransactionsDataLoader {

	@Autowired
	private KafkaProducerConfig kafkaProducerConfig;

	@Autowired
	@Qualifier("transactionProducerService")
	private ProducerService<String, String> service;

	private String topicName = "";

	@PostConstruct
	public void setup(){
		topicName = kafkaProducerConfig.getTransactionsTopicName();
	}


	public void writeToKafka_FireAndForget(final String key, final String value){	

		final Producer<String,String> producer = service.getKafkaProducer();

		final ProducerRecord<String,String> record = new ProducerRecord<>(topicName, key , value);

		try{
			producer.send(record);	
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("---------value pushed to Kafka topic | fire-and-forget ------");
	}

	
	public void writeToKafka_SynchronousCall(final String key, final String value){	

		final Producer<String,String> producer = service.getKafkaProducer();

		final ProducerRecord<String,String> record = new ProducerRecord<>(topicName, key , value);

		try{
			// added a get here.
			producer.send(record).get();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("---------value pushed to Kafka topic | Synchronous ------");
	}
	
	
	public void writeToKafka_AsynchronousCall(final String key, final String value){	

		final Producer<String,String> producer = service.getKafkaProducer();

		final ProducerRecord<String,String> record = new ProducerRecord<>(topicName, key , value);

		try{
			producer.send(record).get();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("---------value pushed to Kafka topic | Asynchronous ------");
	}
	
	
	public void writeToKafka_CustomPartitioner(final String key, final String value){	

		final Producer<String,String> producer = service.getKafkaProducer();

		final ProducerRecord<String,String> record = new ProducerRecord<>(topicName, key , value);

		try{
			producer.send(record).get();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("---------value pushed to Kafka topic | CustomPartitioner ------");
	}

}
