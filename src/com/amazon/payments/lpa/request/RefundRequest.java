package com.amazon.payments.lpa.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://payments.amazon.com/documentation/apireference/201751630#201752010
 * 
 */
public class RefundRequest {
        
    //required parameters
    private String amazonCaptureId;
    private String refundReferenceId;
    private String refundAmount;
    private String refundCurrencyCode;    
    
    //optional parameters
    private String sellerRefundNote;
    private String softDescriptor;
    private String mwsAuthToken;   
    private List<Map<String,String>> providerCreditReversalDetails = new ArrayList<Map<String,String>>();

    public RefundRequest(String captureId, String refundReferenceId, String refundAmount ) {
        this.amazonCaptureId = captureId;
        this.refundReferenceId = refundReferenceId;
        this.refundAmount = refundAmount;
    }
    
    public RefundRequest setCurrencyCode(String currencyCode) {
        this.refundCurrencyCode = currencyCode;
        return this;
    }

    public String getCurrencyCode() {
        return refundCurrencyCode;
    }
    
    public RefundRequest setSellerRefundNote(String sellerRefundNote){
        this.sellerRefundNote = sellerRefundNote;
         return this;
    }

    public RefundRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }

    public RefundRequest setProviderCreditReversalDetails(List<Map<String, String>> providerCreditReversalDetails) {
        this.providerCreditReversalDetails = providerCreditReversalDetails;
        return this;
    }
    
    public RefundRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonCaptureId() {
        return amazonCaptureId;
    }

    public String getRefundReferenceId() {
        return refundReferenceId;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public String getRefundCurrencyCode() {
        return refundCurrencyCode;
    }

    public String getSellerRefundNote() {
        return sellerRefundNote;
    }

    public String getSoftDescriptor() {
        return softDescriptor;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    public List<Map<String, String>> getProviderCreditReversalDetails() {
        return providerCreditReversalDetails;
    }

    
}
