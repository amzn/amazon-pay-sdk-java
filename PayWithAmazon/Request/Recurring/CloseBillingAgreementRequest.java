/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Request.Recurring;

import PayWithAmazon.Request.*;
import java.util.*;

/**
 * 
 * @author nehaa
 * https://payments.amazon.com/documentation/apireference/201752640#201751950
 */
public class CloseBillingAgreementRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();

    private String amazonBillingAgreementId = null;
    private String closureReason = null;
    private String mwsAuthToken = null;
    

    /**
     * Set the value of amazonBillingAgreementId
     *
     * @param amazonBillingAgreementId new value of amazonBillingAgreementId
     */
    public CloseBillingAgreementRequest setAmazonBillingAgreementId(String amazonBillingAgreementId){
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        parameters.put(ParamConstants.AMAZON_BILLING_AGREEMENT_ID, amazonBillingAgreementId);
        return this;
    }
    
    /**
     * Set the value of closureReason
     *
     * @param closureReason new value of closureReason
     */
    public CloseBillingAgreementRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        parameters.put(ParamConstants.CLOSURE_REASON , closureReason);
        return this;
    }
    
    /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public CloseBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
