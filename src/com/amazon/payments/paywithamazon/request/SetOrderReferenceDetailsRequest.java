package com.amazon.payments.paywithamazon.request;

import com.amazon.payments.paywithamazon.types.CurrencyCode;
import java.io.Serializable;

/**
 * Container for the parameters to the {@link com.amazon.payments.lpa.Client#setOrderReferenceDetails(SetOrderReferenceDetailsRequest) SetOrderReferenceDetails operation}.
 * For more information documentation, see  
 * <a href="https://payments.amazon.com/documentation/"> API Reference</a>
 */
public class SetOrderReferenceDetailsRequest implements Serializable{
    
    //required parameters
    private String amazonOrderReferenceId;
    private String orderAmount;
    private CurrencyCode orderCurrencyCode;
    
    //optional parameters
    private String platformId;
    private String sellerNote;
    private String sellerOrderId;
    private String storeName;
    private String customInformation;
    private String mwsAuthToken;

    /**
     * 
     * @param amazonOrderReferenceId 
     *              This value is retrieved from the Amazon Button widget 
     *              after the buyer has successfully authenticated with Amazon.
     * 
     * @param orderAmount 
     *              Specifies the total amount of the order represented by this order reference.
     */
    public SetOrderReferenceDetailsRequest(String amazonOrderReferenceId, String orderAmount) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.orderAmount = orderAmount;
    }

    /**
     * Overrides the Client's currency code with specified currency code in SetOrderReferenceDetailsRequest
     * 
     * @param currencyCode 
     *              A three-digit currency code, formatted based on the ISO 4217 standard. 
     */
    public SetOrderReferenceDetailsRequest setOrderCurrencyCode(CurrencyCode currencyCode) {
        this.orderCurrencyCode = currencyCode;
        return this;
    }
    
    /**
     * Represents the SellerId of the Solution Provider that developed the platform. 
     * This value should only be provided by Solution Providers. It should not be 
     * provided by merchants creating their own custom integration. 
     * 
     * @param platformId
     */
    public SetOrderReferenceDetailsRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        return this;
    }
    
    /**
     * Represents a description of the order that is displayed in emails to the buyer.
     * 
     * @param sellerNote
     */
    public SetOrderReferenceDetailsRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }
    
    /**
     * The merchant-specified identifier of this order. This is displayed to the 
     * buyer in their emails and transaction history on the Amazon Payments website.
     * 
     * @param sellerOrderId
     */
    public SetOrderReferenceDetailsRequest setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }
    
    /**
     * The identifier of the store from which the order was placed. This overrides 
     * the default value in Seller Central under Settings > Account Settings. It is
     * displayed to the buyer in their emails and transaction history on the 
     * Amazon Payments website.
     * 
     * @param storeName
     */
    public SetOrderReferenceDetailsRequest setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }
    
    /**
     * Any additional information that you want to include with this order reference.
     * 
     * @param customInformation
     */
    public SetOrderReferenceDetailsRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
        return this;
    }
    
    /**
     * Applicable only for third-party solution providers or marketplaces. It should not be 
     * provided by merchants creating their own custom integration. 
     * 
     * @param mwsAuthToken
     */
    public SetOrderReferenceDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * 
     * @return AmazonOrderReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * 
     * @return OrderAmount
     */
    public String getOrderAmount() {
        return orderAmount;
    }

    /**
     * 
     * @return OrderCurrencyCode
     */
    public CurrencyCode getOrderCurrencyCode() {
        return orderCurrencyCode;
    }

    /**
     * 
     * @return PlatformId
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * 
     * @return SellerNote
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * 
     * @return SellerOrderId
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * 
     * @return StoreName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 
     * @return CustomInformation
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     * 
     * @return MWSAuthToken
     */
    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SetOrderReferenceDetailsRequest{" + "amazonOrderReferenceId=" + amazonOrderReferenceId + ", orderAmount=" + orderAmount 
                + ", orderCurrencyCode=" + orderCurrencyCode + ", platformId=" + platformId + ", sellerNote=" + sellerNote + ", sellerOrderId=" 
                + sellerOrderId + ", storeName=" + storeName + ", customInformation=" + customInformation + ", mwsAuthToken=" + mwsAuthToken + '}';
    }

    
    
}
