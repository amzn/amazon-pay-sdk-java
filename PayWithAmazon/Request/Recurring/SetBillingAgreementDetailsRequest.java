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
 */
public class SetBillingAgreementDetailsRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();

    private String amazonBillingAgreementId = null;
    private String mwsAuthToken = null;

    private String platformId = null;
    private String sellerNote = null;
    
    private String sellerBillingAgreementId = null;
    private String storeName = null;
    private String customInformation = null;

    
    public SetBillingAgreementDetailsRequest setAmazonBillingAgreementId(String amazonBillingAgreementId){
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        parameters.put(ParamConstants.AMAZON_BILLING_AGREEMENT_ID, amazonBillingAgreementId);
        return this;
    }
    
    
    public SetBillingAgreementDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }

    public SetBillingAgreementDetailsRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        parameters.put(ParamConstants.BILLING_AGREEMENT_PLATFORM_ID, platformId);
        return this;
    }

        
    public SetBillingAgreementDetailsRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        parameters.put(ParamConstants.BILLING_AGREEMENT_SELLER_NOTE, sellerNote);
        return this;
    }
    
    
    public SetBillingAgreementDetailsRequest setSellerBillingAgreementId(String sellerBillingAgreementId){
        this.sellerBillingAgreementId = sellerBillingAgreementId;
        parameters.put(ParamConstants.BILLING_AGREEMENT_SELLER_BILLING_AGREEMENT_ID, sellerBillingAgreementId);
        return this;
    }
    
    public SetBillingAgreementDetailsRequest setStoreName(String storeName) {
        this.storeName = storeName;
        parameters.put(ParamConstants.BILLING_AGREEMENT_SELLER_STORE_NAME, storeName);    
        return this;
    }
    
    public SetBillingAgreementDetailsRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
        parameters.put(ParamConstants.BILLING_AGREEMENT_SELLER_CUSTOM_INFORMATION, customInformation);  
        return this;
    }
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
