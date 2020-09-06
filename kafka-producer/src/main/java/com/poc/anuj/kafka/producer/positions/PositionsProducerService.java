package com.poc.anuj.kafka.producer.positions;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.anuj.kafka.producer.config.KafkaProducerConfig;
import com.poc.anuj.kafka.producer.service.ProducerService;

//@Service("positionsProducerService")
public class PositionsProducerService  implements ProducerService<String, String>{

	@Autowired
	private KafkaProducerConfig kafkaProducerConfig;
		
	private Producer<String, String> producer;
	
	@PostConstruct
	@Override
	public Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProducerConfig.getBrokers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        
        producer = new KafkaProducer<String,String>(props);
        return producer;
    } 
	
	@Override
	public Producer<String, String> getKafkaProducer(){
		return producer;
	}
	
}

