package com.amazonservices.mws.offamazonpayments.utilities;

public enum ParameterInformation {
    MWS_AUTH_TOKEN("MWSAuthToken", String.class),
    SELLER_ID("SellerId", String.class);

    private final String fieldName;
    private final Class fieldType;

    private ParameterInformation(String fieldName, Class fieldType) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    @Override
    public String toString() {
        return this.fieldName;
    }

    public String getFieldName() {
        return this.toString();
    }

    public Class getFieldType() {
        return this.fieldType;
    }
}
