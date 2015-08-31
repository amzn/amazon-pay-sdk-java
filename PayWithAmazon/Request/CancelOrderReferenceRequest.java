package PayWithAmazon.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Build request for CancelOrderReference API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751990
 */
public class CancelOrderReferenceRequest {
        
    //required parameters
    private String amazonOrderReferenceId = null;
    
    //optional parameters
    private String cancelationReason = null;
    private String mwsAuthToken = null;
    
    private Map<String,String> parameters = new HashMap<String,String>();


    public CancelOrderReferenceRequest setAmazonOrderReferenceId(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID, amazonOrderReferenceId);
        return this;
    }
    
    public CancelOrderReferenceRequest setCancelReason(String cancelationReason) {
        this.cancelationReason = cancelationReason;
        parameters.put(ParamConstants.CANCELATION_REASON, cancelationReason);
        return this;
    }
 
    public CancelOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
