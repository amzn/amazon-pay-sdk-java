package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;

/**
 * https://payments.amazon.com/documentation/apireference/201752640#201752060
 * @author nehaa
 */
public class GetCaptureDetailsRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    private String amazonCaptureId = null;
    private String mwsAuthToken = null;   
    /**
     * Set the value of amazonCaptureId
     *
     * @param amazonCaptureId new value of amazonCaptureId
     */
    public GetCaptureDetailsRequest setAmazonCaptureId(String amazonCaptureId) {
        this.amazonCaptureId = amazonCaptureId;
        parameters.put(ParamConstants.AMAZON_CAPTURE_ID, amazonCaptureId);
        return this;
    }
  
     /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public GetCaptureDetailsRequest setMWSAuthToken(String mwsAuthToken) {
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
