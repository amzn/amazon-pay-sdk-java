package com.amazon.payments.lpa.types;

public enum Environment {
	
	LIVE("live"),
	
	SANDBOX("sandbox");
	
	private String value;
	
	private Environment(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}