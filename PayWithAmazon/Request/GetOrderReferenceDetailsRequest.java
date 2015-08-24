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
 */
public class GetOrderReferenceDetailsRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    private String amazonOrderReferenceId = null;
    private String addressConsentToken = null;
    private String mwsAuthToken = null;   
    
    public GetOrderReferenceDetailsRequest setAmazonOrderReferenceId( String amazonOrderReferenceId ){
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID , amazonOrderReferenceId);
        return this;
    }
    
    public GetOrderReferenceDetailsRequest setAddressConsentToken( String addressConsentToken ) {
        this.addressConsentToken = addressConsentToken;
        parameters.put(ParamConstants.ADDRESS_CONSENT_TOKEN , addressConsentToken);
        return this;
    }
    
    /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public GetOrderReferenceDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }

   
    public Map<String,String> getParamMap(){
        return parameters;
    }
    
}
