package com.amazon.payments.lpa.request;

/**
 * Build request for SetOrderReferenceDetails API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201752640#201751960
 */

public class SetOrderReferenceDetailsRequest {
    
    //required parameters
    private String amazonOrderReferenceId;
    private String orderAmount;
    private String orderCurrencyCode;
    
    //optional parameters
    private String platformId;
    private String sellerNote;
    private String sellerOrderId;
    private String storeName;
    private String customInformation;
    private String mwsAuthToken;

    public SetOrderReferenceDetailsRequest(String amazonOrderReferenceId, String orderAmount) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.orderAmount = orderAmount;
    }

    public String getCurrencyCode() {
        return orderCurrencyCode;
    }
    
    public SetOrderReferenceDetailsRequest setCurrencyCode(String currencyCode) {
        this.orderCurrencyCode = currencyCode;
        return this;
    }
    public SetOrderReferenceDetailsRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public String getOrderCurrencyCode() {
        return orderCurrencyCode;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public String getSellerOrderId() {
        return sellerOrderId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getCustomInformation() {
        return customInformation;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    
    
}
