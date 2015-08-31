package PayWithAmazon.Request.SolutionProviderAPI;

import PayWithAmazon.Request.ParamConstants;
import java.util.HashMap;
import java.util.Map;

public class GetProviderCreditDetailsRequest {
        
    //required parameters
    private String amazonProviderCreditId = null;
    
    //optional parameters
    private String mwsAuthToken = null;

    private Map<String,String> parameters = new HashMap<String,String>();

    public GetProviderCreditDetailsRequest setAmazonProviderCreditId(String AmazonProviderCreditId) {
        this.amazonProviderCreditId = AmazonProviderCreditId;
        parameters.put(ParamConstants.AMAZON_PROVIDER_CREDIT_ID , this.amazonProviderCreditId);
        return this;
    }

    public GetProviderCreditDetailsRequest setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN , this.mwsAuthToken);
        return this;
    }
            
    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
