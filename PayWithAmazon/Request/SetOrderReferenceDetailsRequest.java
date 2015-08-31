package PayWithAmazon.Request;

import java.util.*;

/**
 * Build request for SetOrderReferenceDetails API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201752640#201751960
 */

public class SetOrderReferenceDetailsRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();

    //required parameters
    private String amazonOrderReferenceId = null;
    private String orderTotal = null;
    
    //optional parameters
    private String platformId = null;
    private String sellerNote = null;
    private String sellerOrderId = null;
    private String storeName = null;
    private String customInformation = null;
    private String mwsAuthToken = null;

    public SetOrderReferenceDetailsRequest setAmazonOrderReferenceId(String amazonOrderReferenceId){
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID, amazonOrderReferenceId);
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
        parameters.put(ParamConstants.ORDER_TOTAL, orderTotal);
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        parameters.put(ParamConstants.PLATFORM_ID, platformId);
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        parameters.put(ParamConstants.SELLER_NOTE, sellerNote);
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        parameters.put(ParamConstants.SELLER_ORDER_ID, sellerOrderId);
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setStoreName(String storeName) {
        this.storeName = storeName;
        parameters.put(ParamConstants.STORE_NAME, storeName); 
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
        parameters.put(ParamConstants.CUSTOM_INFORMATION, customInformation);
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
