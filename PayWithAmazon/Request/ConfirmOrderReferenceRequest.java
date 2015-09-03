package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;

/**
 * Build request for ConfirmOrderReference API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751980
 */

public class ConfirmOrderReferenceRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();

    //required parameters
    private String amazonOrderReferenceId = null;
    
    //optional parameters
    private String mwsAuthToken = null;   

    public ConfirmOrderReferenceRequest setAmazonOrderReferenceId(String amazonOrderReferenceId){
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID , amazonOrderReferenceId);
        return this;
    }
    
    public ConfirmOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
