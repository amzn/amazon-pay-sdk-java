package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;

/**
 * Build request forValidateBillingAgreement API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751720
 */
public class ValidateBillingAgreementRequest {
   
    //required parameters
    private String amazonBillingAgreementId = null;
    
    //optional parameters
    private String mwsAuthToken = null;
    
    private Map<String,String> parameters = new HashMap<String,String>();

    public ValidateBillingAgreementRequest setAmazonBillingAgreementId(String amazonBillingAgreementId){
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        parameters.put(ParamConstants.AMAZON_BILLING_AGREEMENT_ID, amazonBillingAgreementId);
        return this;
    }

    public ValidateBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN , mwsAuthToken);
        return this;
    }

    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
