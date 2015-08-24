/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Request;

import java.util.*;

/**
 * 
 * @author nehaa
 * https://payments.amazon.com/documentation/apireference/201751630#201752000 
 */
public class CloseOrderReferenceRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();

    private String amazonOrderReferenceId = null;
    private String closureReason = null;
    private String mwsAuthToken = null;   
    /**
     * Set the value of amazonOrderReferenceId
     *
     * @param amazonOrderReferenceId new value of amazonOrderReferenceId
     */
    public CloseOrderReferenceRequest setAmazonOrderReferenceId(String amazonOrderReferenceId){
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID , amazonOrderReferenceId);
        return this;
    }
    
    /**
     * Set the value of closureReason
     *
     * @param closureReason new value of closureReason
     */
    public CloseOrderReferenceRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        parameters.put(ParamConstants.CLOSURE_REASON , closureReason);
        return this;
    }
    
       /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public CloseOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
