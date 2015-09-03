package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;


/**
 * Build request for GetBillingAgreementDetails API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751690
 */

public class GetBillingAgreementDetailsRequest {
    
    //required parameters
    private String amazonBillingAgreementId = null;
    
    //optional parameters
    private String addressConsentToken = null;
    private String mwsAuthToken = null;
    
    private Map<String,String> parameters = new HashMap<String,String>();

    public GetBillingAgreementDetailsRequest setAmazonBillingAgreementId(String amazonBillingAgreementId){
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        parameters.put(ParamConstants.AMAZON_BILLING_AGREEMENT_ID, amazonBillingAgreementId);
        return this;
    }

    public GetBillingAgreementDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }

        
    public GetBillingAgreementDetailsRequest setAddressConsentToken(String addressConsentToken) {
        this.addressConsentToken = addressConsentToken;
        parameters.put(ParamConstants.ADDRESS_CONSENT_TOKEN , addressConsentToken);
        return this;
    }
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
