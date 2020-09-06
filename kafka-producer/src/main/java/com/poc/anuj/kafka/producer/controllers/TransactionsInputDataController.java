package com.poc.anuj.kafka.producer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.anuj.kafka.producer.transactions.Transactions;
import com.poc.anuj.kafka.producer.transactions.TransactionsDataLoader;


/*
 * HTTP Success Codes:
 * 	GET: 200
 *  POST: 201
 *  DELETE: 204
 *  PUT:
 */
@RestController
@RequestMapping(path = "/transaction-data")
public class TransactionsInputDataController {

	@Autowired
	private TransactionsDataLoader transactionsDataLoader;

	// Create a new transactions in the Kafka topic.
	@PostMapping(path="/fire-and-forget/")
	public ResponseEntity.BodyBuilder pushTransaction_FireAndForget(@RequestBody Transactions transactions){

		transactionsDataLoader.writeToKafka_FireAndForget(transactions.toString());
		// this URI will be available in the Response header. 
		// Successful status of POST is 201
		return ResponseEntity.ok();

	}

	@PostMapping(path="/async-call/")
	public ResponseEntity.BodyBuilder pushTransaction_SynchronousCall(@RequestBody Transactions transactions){

		transactionsDataLoader.writeToKafka_SynchronousCall(transactions.toString());
		// this URI will be available in the Response header. 
		// Successful status of POST is 201
		return ResponseEntity.ok();

	}




}
