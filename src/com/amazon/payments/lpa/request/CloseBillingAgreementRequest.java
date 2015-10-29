package com.amazon.payments.lpa.request;



/**
 * Build request for CloseBillingAgreement API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751950
 */

public class CloseBillingAgreementRequest {
    
    //required parameters
    private String amazonBillingAgreementId;
    
    //optional parameters
    private String closureReason;
    private String mwsAuthToken;
    

    public CloseBillingAgreementRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }
    
    public CloseBillingAgreementRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        return this;
    }

    public CloseBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    public String getClosureReason() {
        return closureReason;
    }

    public String getMwsAuthToken() {
        return mwsAuthToken;
    }
    
}
