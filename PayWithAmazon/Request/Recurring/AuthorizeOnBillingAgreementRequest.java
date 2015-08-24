/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Request.Recurring;

import PayWithAmazon.Request.*;
import java.util.HashMap;
import java.util.Map;

/**
 * https://payments.amazon.com/documentation/apireference/201752640#201751940
 * @author nehaa
 */
public class AuthorizeOnBillingAgreementRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    private String amazonBillingAgreementId = null;
    private String authorizationReferenceId = null;
    private String authorizationAmount = null;
    private String sellerAuthorizationNote = null;
    private String transactionTimeout = null;
    private String captureNow;
    private String softDescriptor = null;
    private String platformId = null;
    private String sellerNote = null;
    private String InheritShippingAddress = null;
    private String mwsAuthToken = null;


    /**
     * Set the value of amazonBillingAgreementId
     *
     * @param amazonBillingAgreementId new value of amazonBillingAgreementId
     */
    public AuthorizeOnBillingAgreementRequest setAmazonBillingAgreementId(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        parameters.put(ParamConstants.AMAZON_BILLING_AGREEMENT_ID, amazonBillingAgreementId);
        return this;
    }
    
    /**
     * Set the value of sellerAuthorizationNote
     *
     * @param authorizationReferenceId new value of sellerAuthorizationNote
     */
    public AuthorizeOnBillingAgreementRequest setAuthorizationReferenceId(String authorizationReferenceId) {
        this.authorizationReferenceId = authorizationReferenceId;
        parameters.put(ParamConstants.AUTHORIZATION_REFERENCE_ID, authorizationReferenceId);
        return this;
    }

    /**
     * Set the value of authorizationAmount
     *
     * @param authorizationAmount new value of authorizationAmount
     */
    public AuthorizeOnBillingAgreementRequest setAuthorizationAmount(String authorizationAmount) {
        this.authorizationAmount = authorizationAmount;
        parameters.put(ParamConstants.AUTHORIZATION_AMOUNT, authorizationAmount);
        return this;
    }

    /**
     * Set the value of sellerAuthorizationNote
     *
     * @param sellerAuthorizationNote new value of sellerAuthorizationNote
     */
    public AuthorizeOnBillingAgreementRequest setSellerAuthorizationNote(String sellerAuthorizationNote){
        this.sellerAuthorizationNote = sellerAuthorizationNote;
         parameters.put(ParamConstants.SELLER_AUTHORIZATION_NOTE, sellerAuthorizationNote);
        return this;

    }
    
    /**
     * Set the value of transactionTimeout
     *
     * @param TransactionTimeout new value of transactionTimeout
     */
    public AuthorizeOnBillingAgreementRequest setTransactionTimeout(String TransactionTimeout) {
        this.transactionTimeout = TransactionTimeout;
        parameters.put(ParamConstants.TRANSACTION_TIMEOUT, TransactionTimeout);
        return this;

    }
    
    
    /**
     * Set the value of captureNow
     *
     * @param CaptureNow new value of captureNow
     */
    public AuthorizeOnBillingAgreementRequest setCaptureNow(String CaptureNow) {
        this.captureNow = CaptureNow;
        parameters.put(ParamConstants.CAPTURE_NOW, CaptureNow);
        return this;
    }

    /**
     * Set the value of softDescriptor
     *
     * @param softDescriptor new value of softDescriptor
     */
    public AuthorizeOnBillingAgreementRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        parameters.put(ParamConstants.SOFT_DESCRIPTOR, softDescriptor);
        return this;
    }

    /**
     * Set the value of platformId
     *
     * @param platformId new value of platformId
     */
    public AuthorizeOnBillingAgreementRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        parameters.put(ParamConstants.PLATFORM_ID, platformId);
        return this;
    }

    
    /**
     * Set the value of sellerNote
     *
     * @param sellerNote new value of sellerNote
     */
    public AuthorizeOnBillingAgreementRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        parameters.put(ParamConstants.SELLER_NOTE, sellerNote);
        return this;
    }

    /**
     * Set the value of InheritShippingAddress
     *
     * @param InheritShippingAddress new value of InheritShippingAddress
     */
    public AuthorizeOnBillingAgreementRequest setInheritShippingAddress(String InheritShippingAddress) {
        this.InheritShippingAddress = InheritShippingAddress;
        parameters.put(ParamConstants.INHERIT_SHIPPING_ADDRESS, InheritShippingAddress);
        return this;
    }

    /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public AuthorizeOnBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    /**
     * Get the value of request parameters
     *
     * @return parameters map of all request parameters
     */
    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
