package com.poc.anuj.kafka.producer.transactions;

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

	public void produceData(){

		System.out.println("----------------" + kafkaProducerConfig.getTransactionsTopicName());
		final String value = "anuj-mehra";
		this.writeToKafka(value);
	}

	public void writeToKafka(String value){
		final String topicName = kafkaProducerConfig.getTransactionsTopicName();

		final Producer<String,String> producer = service.getKafkaProducer();

		final ProducerRecord<String,String> record = new ProducerRecord<>(topicName, value);

		try{
			producer.send(record);	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
