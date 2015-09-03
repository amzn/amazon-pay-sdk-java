package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import PayWithAmazon.Request.*;
import java.util.*;


/**
 * Build request for Authorize API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752010
 */

/**
 * 
 * @author nehaa
 * https://payments.amazon.com/documentation/apireference/201752640#201751950
 */
public class CloseBillingAgreementRequest {
    
    //required parameters
    private String amazonBillingAgreementId = null;
    
    //optional parameters
    private String closureReason = null;
    private String mwsAuthToken = null;
    
    private Map<String,String> parameters = new HashMap<String,String>();


    public CloseBillingAgreementRequest setAmazonBillingAgreementId(String amazonBillingAgreementId){
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        parameters.put(ParamConstants.AMAZON_BILLING_AGREEMENT_ID, amazonBillingAgreementId);
        return this;
    }
    
    public CloseBillingAgreementRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        parameters.put(ParamConstants.CLOSURE_REASON , closureReason);
        return this;
    }

    public CloseBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
