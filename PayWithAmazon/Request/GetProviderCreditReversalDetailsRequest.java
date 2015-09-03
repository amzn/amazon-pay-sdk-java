package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;

public class GetProviderCreditReversalDetailsRequest {
    
    //required parameters
    private String amazonProviderCreditReversalId = null;

    //optional parameters
    private String mwsAuthToken = null;

    private Map<String,String> parameters = new HashMap<String,String>();

    public GetProviderCreditReversalDetailsRequest setAmazonProviderCreditId(String amazonProviderCreditReversalId) {
        this.amazonProviderCreditReversalId = amazonProviderCreditReversalId;
        parameters.put(ParamConstants.AMAZON_PROVIDER_CREDIT_REVERSAL_ID , this.amazonProviderCreditReversalId);
        return this;
    }

    public void setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
    }
            
    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
