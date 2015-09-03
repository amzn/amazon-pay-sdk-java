package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import PayWithAmazon.Request.*;
import java.util.*;

/**
 * 
 * @author nehaa
 * https://payments.amazon.com/documentation/apireference/201752640#201751710
 */

/**
 * Build request for Authorize API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752010
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
