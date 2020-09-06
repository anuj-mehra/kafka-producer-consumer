package com.poc.anuj.kafka.producer.transactions;

import java.io.Serializable;

public class Transactions implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long tranId;
	private Double tranValue;
	private String toCurrency;
	private String fromCurrency;
	
	public Long getTranId() {
		return tranId;
	}
	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}
	public Double getTranValue() {
		return tranValue;
	}
	public void setTranValue(Double tranValue) {
		this.tranValue = tranValue;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	
	@Override
	public String toString(){
		return String.valueOf(tranId) + ":" + String.valueOf(tranValue) + ":" + fromCurrency + ":" + toCurrency;
	}
	
}
