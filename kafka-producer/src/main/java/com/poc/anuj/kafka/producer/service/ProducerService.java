package com.poc.anuj.kafka.producer.service;

import org.apache.kafka.clients.producer.Producer;

public interface ProducerService<K,V> {

	Producer<K, V> createProducer();
	Producer<K, V> getKafkaProducer();
	
}
