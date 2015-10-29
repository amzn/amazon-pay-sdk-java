package com.amazon.payments.lpa.request;

/**
 * Build request for SetBillingAgreementDetails API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751700
 */
public class SetBillingAgreementDetailsRequest {
    
    //required parameters
    private String amazonBillingAgreementId;
    
    //optional parameters
    private String platformId;
    private String sellerNote;
    private String sellerBillingAgreementId;
    private String storeName;
    private String customInformation;
    private String mwsAuthToken;
        
    public SetBillingAgreementDetailsRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }
    
    public SetBillingAgreementDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    public SetBillingAgreementDetailsRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        return this;
    }
   
    public SetBillingAgreementDetailsRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }
    
    
    public SetBillingAgreementDetailsRequest setSellerBillingAgreementId(String sellerBillingAgreementId){
        this.sellerBillingAgreementId = sellerBillingAgreementId;
        return this;
    }
    
    public SetBillingAgreementDetailsRequest setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }
    
    public SetBillingAgreementDetailsRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
        return this;
    }

    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public String getSellerBillingAgreementId() {
        return sellerBillingAgreementId;
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
