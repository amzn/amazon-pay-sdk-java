package com.amazon.payments.lpa.types;

public enum Region {

	DE("de"), UK("uk"), US("us"), JP("jp"), EU("eu");

	private String value;

	private Region(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
