/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Request;

import PayWithAmazon.Request.Recurring.CloseBillingAgreementRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * https://payments.amazon.com/documentation/apireference/201751630#201752010
 * @author nehaa
 */
public class AuthorizeRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    //required parameters
    private String amazonOrderReferenceId = null;
    private String authorizationReferenceId = null;
    private String authorizationAmount = null;
    
    //optonal parameters
    private String sellerAuthorizationNote = null;
    private String transactionTimeout = null;
    private String captureNow;
    private String softDescriptor = null;
    private String mwsAuthToken = null;

    /**
     * Set the value of sellerAuthorizationNote
     *
     * @param amazonOrderReferenceId new value of sellerAuthorizationNote
     */
    public AuthorizeRequest setAmazonOrderReferenceId(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID, amazonOrderReferenceId);
        return this;
    }
    
    /**
     * Set the value of sellerAuthorizationNote
     *
     * @param authorizationReferenceId new value of sellerAuthorizationNote
     */
    public AuthorizeRequest setAuthorizationReferenceId(String authorizationReferenceId) {
        this.authorizationReferenceId = authorizationReferenceId;
        parameters.put(ParamConstants.AUTHORIZATION_REFERENCE_ID, authorizationReferenceId);
        return this;
    }

    /**
     * Set the value of authorizationAmount
     *
     * @param authorizationAmount new value of authorizationAmount
     */
    public AuthorizeRequest setAuthorizationAmount(String authorizationAmount) {
        this.authorizationAmount = authorizationAmount;
        parameters.put(ParamConstants.AUTHORIZATION_AMOUNT, authorizationAmount);
        return this;
    }

    /**
     * Set the value of sellerAuthorizationNote
     *
     * @param sellerAuthorizationNote new value of sellerAuthorizationNote
     */
    public AuthorizeRequest setSellerAuthorizationNote(String sellerAuthorizationNote){
        this.sellerAuthorizationNote = sellerAuthorizationNote;
         parameters.put(ParamConstants.SELLER_AUTHORIZATION_NOTE, sellerAuthorizationNote);
        return this;
    }
    
    /**
     * Set the value of transactionTimeout
     *
     * @param TransactionTimeout new value of transactionTimeout
     */
    public AuthorizeRequest setTransactionTimeout(String TransactionTimeout) {
        this.transactionTimeout = TransactionTimeout;
        parameters.put(ParamConstants.TRANSACTION_TIMEOUT, TransactionTimeout);
        return this;
    }
    
    
    /**
     * Set the value of captureNow
     *
     * @param CaptureNow new value of captureNow
     */
    public AuthorizeRequest setCaptureNow(String CaptureNow) {
        this.captureNow = CaptureNow;
        parameters.put(ParamConstants.CAPTURE_NOW, CaptureNow);
        return this;
    }

    /**
     * Set the value of softDescriptor
     *
     * @param softDescriptor new value of softDescriptor
     */
    public AuthorizeRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        parameters.put(ParamConstants.SOFT_DESCRIPTOR, softDescriptor);
        return this;
    }


    /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public AuthorizeRequest setMWSAuthToken(String mwsAuthToken) {
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
