package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;

/**
 * Build request for CloseOrderReference API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752000
 */

public class CloseOrderReferenceRequest {
    
    //required parameters
    private String amazonOrderReferenceId = null;
    
    //optional parameters
    private String closureReason = null;
    private String mwsAuthToken = null; 
    
    private Map<String,String> parameters = new HashMap<String,String>();

    public CloseOrderReferenceRequest setAmazonOrderReferenceId(String amazonOrderReferenceId){
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID , amazonOrderReferenceId);
        return this;
    }
    
    public CloseOrderReferenceRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        parameters.put(ParamConstants.CLOSURE_REASON , closureReason);
        return this;
    }
    
    public CloseOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public Map<String,String> getParamMap(){
        return parameters; 
    }
    
}
