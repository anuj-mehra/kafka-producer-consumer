package com.poc.anuj.kafka.producer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties("kafka-producer")
public class KafkaProducerConfig {
	
	private String brokers;
	
	private String transactionsTopicName;
	
	private String positionsTopicName;
	
	
	public String getBrokers() {
		return brokers;
	}

	public void setBrokers(String brokers) {
		this.brokers = brokers;
	}

	public String getTransactionsTopicName() {
		return transactionsTopicName;
	}

	public void setTransactionsTopicName(String transactionsTopicName) {
		this.transactionsTopicName = transactionsTopicName;
	}

	public String getPositionsTopicName() {
		return positionsTopicName;
	}

	public void setPositionsTopicName(String positionsTopicName) {
		this.positionsTopicName = positionsTopicName;
	}
		
}
