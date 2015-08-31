package PayWithAmazon.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Build request for CloseOrderReference API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201752640#201752030
 */

public class GetAuthorizationDetailsRequest {
    
    //required parameters
    private String amazonAuthorizationId = null;
    
    //optional parameters
    private String mwsAuthToken = null; 
    
    private Map<String,String> parameters = new HashMap<String,String>();
  
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
