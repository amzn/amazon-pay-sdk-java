package com.amazon.payments.lpa.request;


/**
 * Build request for ConfirmBillingAgreement API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751710
 */

public class ConfirmBillingAgreementRequest {

    //required parameters
    private String amazonBillingAgreementId;
    
    //optional parameters
    private String mwsAuthToken;
    
    public ConfirmBillingAgreementRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    public ConfirmBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this; 
    }

    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
    
    
}
