package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;

/**
 * Build request for SetBillingAgreementDetails API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201751700
 */
public class SetBillingAgreementDetailsRequest {
    
    //required parameters
    private String amazonBillingAgreementId = null;
    
    //optional parameters
    private String platformId = null;
    private String sellerNote = null;
    private String sellerBillingAgreementId = null;
    private String storeName = null;
    private String customInformation = null;
    private String mwsAuthToken = null;
    
    private Map<String,String> parameters = new HashMap<String,String>();
    

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
