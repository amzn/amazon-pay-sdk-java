/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Request;

import java.util.*;

/**
 * 
 * @author nehaa
 * https://payments.amazon.com/documentation/apireference/201751630#201751670  
 */
public class CreateForOrderReferenceIdRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();

    private String Id = null;
    private String IdType = null;
    private String InheritShippingAddress = null;

    private String confirmNow = null;
    private String mwsAuthToken = null;   


    /**
     * Set the value of Id
     *
     * @param amazonOrderReferenceId new value of Id
     */
    public CreateForOrderReferenceIdRequest setAmazonOrderReferenceId(String amazonOrderReferenceId){
        this.Id = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID , amazonOrderReferenceId);
        return this;
    }
    
    
    /**
     * Set the value of IdType
     *
     * @param IdType new value of IdType
     */
    public CreateForOrderReferenceIdRequest setIdType(String IdType) {
        this.IdType = IdType;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID , IdType);
        return this;
    }
    
    
    /**
     * Set the value of InheritShippingAddress
     *
     * @param InheritShippingAddress new value of InheritShippingAddress
     */
    public CreateForOrderReferenceIdRequest setInheritShippingAddress(String inheritShippingAddress) {
        this.InheritShippingAddress = InheritShippingAddress;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID , inheritShippingAddress);
        return this;
    }

    /**
     * Set the value of confirmNow
     *
     * @param confirmNow new value of confirmNow
     */
    public CreateForOrderReferenceIdRequest setConfirmNow(String confirmNow) {
        this.confirmNow = confirmNow;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID , confirmNow);
        return this;
    }

     /**
     * Set the value of mwsAuthToken
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public CreateForOrderReferenceIdRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
