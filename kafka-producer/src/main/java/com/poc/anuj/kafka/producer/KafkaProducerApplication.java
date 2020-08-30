package com.poc.anuj.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages="com.poc.anuj.kafka.producer")
public class KafkaProducerApplication {
	
	public static void main(String[] args) {
	    SpringApplication.run(KafkaProducerApplication.class, args);
	}
	
}
