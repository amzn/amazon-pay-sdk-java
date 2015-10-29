package com.amazon.payments.lpa.request;

import java.util.*;

/**
 * Build request for Capture API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752040
 */

public class CaptureRequest {
    
    //required parameters
    private String amazonAuthorizationId;  
    private String captureReferenceId;
    private String captureAmount;
    private String captureCurrencyCode;
    
    //optional parameters
    private String sellerCaptureNote;
    private String softDescriptor;
    private String mwsAuthToken;  
    private List<ProviderCredit> providerCredit;

    public CaptureRequest(String amazonAuthorizationId, String captureReferenceId, String captureAmount) {
        this.amazonAuthorizationId = amazonAuthorizationId;
        this.captureReferenceId = captureReferenceId;
        this.captureAmount = captureAmount;

    }

    public String getCurrencyCode() {
        return this.captureCurrencyCode;
    }

    public CaptureRequest setCurrencyCode(String currencyCode) {
        this.captureCurrencyCode = currencyCode;
        return this;
    }

    public CaptureRequest setSellerCaptureNote(String sellerCaptureNote) {
        this.sellerCaptureNote = sellerCaptureNote;
        return this;
    }
    
    public CaptureRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }
    
    public CaptureRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }
    
    public CaptureRequest setProviderCredit(List<ProviderCredit> providerCreditList) {
        this.providerCredit = providerCreditList;
        return this;
    }

    public String getAmazonAuthorizationId() {
        return amazonAuthorizationId;
    }

    public String getCaptureReferenceId() {
        return captureReferenceId;
    }

    public String getCaptureAmount() {
        return captureAmount;
    }

    public String getCaptureCurrencyCode() {
        return captureCurrencyCode;
    }

    public String getSellerCaptureNote() {
        return sellerCaptureNote;
    }

    public String getSoftDescriptor() {
        return softDescriptor;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    public List<ProviderCredit> getProviderCredit() {
        return providerCredit;
    }
    
    
    
}
