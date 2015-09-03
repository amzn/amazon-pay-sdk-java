package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;

/**
 * Build request for CloseAuthorization API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752070
 */

public class CloseAuthorizationRequest {
        
    //required parameters
    private String amazonAuthorizationId = null;
    
    //optional parameters
    private String closureReason = null;
    private String mwsAuthToken = null; 
    
    private Map<String,String> parameters = new HashMap<String,String>();

    public CloseAuthorizationRequest setAmazonAuthorizationId(String amazonAuthorizationId) {
        this.amazonAuthorizationId = amazonAuthorizationId;
        parameters.put(ParamConstants.AMAZON_AUTHORIZATION_ID, amazonAuthorizationId);
        return this;
    }
    
    public CloseAuthorizationRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        parameters.put(ParamConstants.CLOSURE_REASON, closureReason);
        return this;
    }

    public CloseAuthorizationRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }

    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
