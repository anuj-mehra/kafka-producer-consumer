package com.poc.anuj.kafka.producer.transactions;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.record.InvalidRecordException;
import org.springframework.stereotype.Component;

@Component
public class TransactionCustomPartitioner implements Partitioner{

	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		if((null == keyBytes) && !(key instanceof String)){
			throw new InvalidRecordException("transaction topic expect all keys to be of type String");
		}
		
		return 0;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	
}
