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
 * https://payments.amazon.com/documentation/apireference/201752640#201751710
 */
public class ConfirmBillingAgreementRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();

    private String amazonBillingAgreementId = null;
    private String mwsAuthToken = null;

    /**
     * Set the value of amazonBillingAgreementId
     *
     * @param amazonBillingAgreementId new value of amazonBillingAgreementId
     */
    public ConfirmBillingAgreementRequest setAmazonBillingAgreementId(String amazonBillingAgreementId){
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        parameters.put(ParamConstants.AMAZON_BILLING_AGREEMENT_ID, amazonBillingAgreementId);
        return this;
    }

     /**
     * Set the value of amazonBillingAgreementId
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public ConfirmBillingAgreementRequest setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN , mwsAuthToken);
        return this; 
    }
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
