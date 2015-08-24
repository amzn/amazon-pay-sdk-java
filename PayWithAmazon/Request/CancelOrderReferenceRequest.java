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
 * https://payments.amazon.com/documentation/apireference/201751630#201751990
 * @author nehaa
 */
public class CancelOrderReferenceRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    private String amazonOrderReferenceId = null;
    private String cancelationReason = null;
    private String mwsAuthToken = null;

    /**
     * Set the value of sellerAuthorizationNote
     *
     * @param amazonOrderReferenceId new value of sellerAuthorizationNote
     */
    public CancelOrderReferenceRequest setAmazonOrderReferenceId(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID, amazonOrderReferenceId);
        return this;
    }
    
    /**
     * Set the value of cancelReason
     *
     * @param cancelReason new value of cancelReason
     */
    public CancelOrderReferenceRequest setCancelReason(String cancelationReason) {
        this.cancelationReason = cancelationReason;
        parameters.put(ParamConstants.CANCELATION_REASON, cancelationReason);
        return this;
    }
    /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public CancelOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
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
