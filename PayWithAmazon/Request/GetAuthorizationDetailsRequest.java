/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * https://payments.amazon.com/documentation/apireference/201752640#201752030
 * @author nehaa
 */
public class GetAuthorizationDetailsRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    private String amazonAuthorizationId = null;
    private String mwsAuthToken = null;   
    /**
     * Set the value of amazonAuthorizationId
     *
     * @param amazonAuthorizationId new value of amazonAuthorizationId
     */
    public GetAuthorizationDetailsRequest setAmazonAuthorizationId(String amazonAuthorizationId) {
        this.amazonAuthorizationId = amazonAuthorizationId;
        parameters.put(ParamConstants.AMAZON_AUTHORIZATION_ID, amazonAuthorizationId);
        return this;
    }

    
     /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public GetAuthorizationDetailsRequest setMWSAuthToken(String mwsAuthToken) {
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
