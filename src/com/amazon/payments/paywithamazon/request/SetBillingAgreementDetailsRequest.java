package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the {@link com.amazon.payments.lpa.Client#setBillingAgreementDetails(SetBillingAgreementDetailsRequest) SetBillingAgreementDetails operation}.
 * For more information documentation, see  
 * <a href="https://payments.amazon.com/documentation/"> API Reference</a>
 */
public class SetBillingAgreementDetailsRequest implements Serializable{
    
    //required parameters
    private String amazonBillingAgreementId;
    
    //optional parameters
    private String platformId;
    private String sellerNote;
    private String sellerBillingAgreementId;
    private String storeName;
    private String customInformation;
    private String mwsAuthToken;
        
    /**
     * 
     * @param amazonBillingAgreementId The billing agreement identifier. 
     * This value is retrieved from the Amazon Button, AddressBook, or Wallet widgets.
     */
    public SetBillingAgreementDetailsRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }
    
    /**
     * Sets MWSAuthToken. This is applicable for third-party solution providers only
     * @param mwsAuthToken
     */
    public SetBillingAgreementDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * Sets the SellerId of the Solution Provider that developed the platform. 
     * This value should only be provided by Solution Providers. It should not be 
     * provided by merchants creating their own custom integration. Do not specify 
     * the SellerId of the merchant for this request parameter.
     * @param platformId
     */
    public SetBillingAgreementDetailsRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        return this;
    }
   
    /**
     * Sets description of the billing agreement that is displayed in emails to the buyer.
     * @param sellerNote
     */
    public SetBillingAgreementDetailsRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }
    
    /**
     * Sets the merchant-specified identifier of this billing agreement.
     * @param sellerBillingAgreementId
     */
    public SetBillingAgreementDetailsRequest setSellerBillingAgreementId(String sellerBillingAgreementId){
        this.sellerBillingAgreementId = sellerBillingAgreementId;
        return this;
    }
    
    /**
     * Sets identifier of the store from which the order was placed. 
     * This overrides the default value in Seller Central under Settings > Account Settings.
     * @param storeName
     */
    public SetBillingAgreementDetailsRequest setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }
    
    /**
     * Sets any additional information that you wish to include with this billing agreement.
     * @param customInformation
     */
    public SetBillingAgreementDetailsRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
        return this;
    }

    /**
     * 
     * @return amazonBillingAgreementId
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     * 
     * @return platformId
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * 
     * @return sellerNote
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * 
     * @return sellerBillingAgreementId
     */
    public String getSellerBillingAgreementId() {
        return sellerBillingAgreementId;
    }

    /**
     * 
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 
     * @return customInformation
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     * 
     * @return mwsAuthToken
     */
    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SetBillingAgreementDetailsRequest{" + "amazonBillingAgreementId=" + amazonBillingAgreementId + ", platformId=" 
                + platformId + ", sellerNote=" + sellerNote + ", sellerBillingAgreementId=" + sellerBillingAgreementId + ", storeName=" 
                + storeName + ", customInformation=" + customInformation + ", mwsAuthToken=" + mwsAuthToken + '}';
    }
    
    
}
