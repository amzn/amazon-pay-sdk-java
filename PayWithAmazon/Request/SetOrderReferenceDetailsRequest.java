/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Request;

import java.util.*;

/**
 *    // params.put("AmazonOrderReferenceId","S01-4182319-6876838");
      // params.put("OrderReferenceAttributes.OrderTotal.Amount","30");
      // params.put("OrderReferenceAttributes.OrderTotal.CurrencyCode","USD");
      // params.put("OrderReferenceAttributes.PlatformId","");
      // params.put("OrderReferenceAttributes.SellerNote","Lorem%20ipsum");
      // params.put("OrderReferenceAttributes.SellerOrderAttributes.SellerOrderId","5678-23");
      // params.put("OrderReferenceAttributes.SellerOrderAttributes.StoreName","YOUR_STORE_NAME");  
 * @author nehaa
 */
public class SetOrderReferenceDetailsRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();

    private String amazonOrderReferenceId = null;
    private String addressConsentToken = null;
    private String mwsAuthToken = null;
    private String currencyCode = null;
    private String orderTotal = null;
    private String platformId = null;
    private String sellerNote = null;
    private String sellerOrderId = null;
    private String storeName = null;
    
    public SetOrderReferenceDetailsRequest setAmazonOrderReferenceId(String amazonOrderReferenceId){
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID, amazonOrderReferenceId);
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setAddressConsentToken(String addressConsentToken) {
        this.addressConsentToken = addressConsentToken;
        parameters.put(ParamConstants.ADDRESS_CONSENT_TOKEN, addressConsentToken);
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public SetOrderReferenceDetailsRequest setCurrencyCode(String currencyCode){
        this.currencyCode = currencyCode;
        parameters.put(ParamConstants.CURRENCY_CODE, currencyCode);
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
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
