/**
 * Copyright 2016-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.request;

import com.amazon.pay.types.CurrencyCode;
import java.io.Serializable;

/**
 * Container for the parameters to the SetOrderReferenceDetails operation.
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class SetOrderReferenceDetailsRequest extends DelegateRequest<SetOrderReferenceDetailsRequest> implements Serializable {

    @Override
    protected SetOrderReferenceDetailsRequest getThis() {
        return this;
    }

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
    private Boolean requestPaymentAuthorization;

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
     *
     * @return currenyCode
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
     * @param platformId Represents the SellerId of the Solution Provider that developed the platform.
     *                   This value should only be provided by Solution Providers. It should
     *                   not be provided by merchants creating their own custom integration.
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public SetOrderReferenceDetailsRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        return this;
    }

    /**
     * Represents a description of the order that is displayed in emails to the buyer.
     *
     * @param sellerNote Represents a description of the order that is displayed in emails to the buyer.
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public SetOrderReferenceDetailsRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }

    /**
     * The merchant-specified identifier of this order. This is displayed to the
     * buyer in their emails and transaction history on the Amazon Pay website.
     *
     * @param sellerOrderId merchant-specified identifier of the order.
     *
     * @return the Seller Order ID
     */
    public SetOrderReferenceDetailsRequest setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }

    /**
     * The identifier of the store from which the order was placed. This overrides
     * the default value in Seller Central under Settings &gt; Account Settings. It is
     * displayed to the buyer in their emails and transaction history on the
     * Amazon Pay website.
     *
     * @param storeName the identifier of the store from which the order was placed.
     *
     * @return the Store Name
     */
    public SetOrderReferenceDetailsRequest setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    /**
     * Any additional information that you want to include with this order reference.
     *
     * @param customInformation Additional information that merchant wants to pass for the order.
     *
     * @return Custom Information
     */
    public SetOrderReferenceDetailsRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
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
     *Check if payment authorization has been requested or not
     *
     * @return Value of the requestPaymentAuthorization
     */
    public Boolean getRequestPaymentAuthorization() {
        return requestPaymentAuthorization;
    }

    /**
     * Specifies if the merchants want their buyers to go through multi-factor authentication
     *
     * @param requestPaymentAuthorization flag exposed to merchants using which merchants
     *                                    can enforce their buyers to through multi-factor authentication
     *
     * @return Value of the requestPaymentAuthorization
     */
    public SetOrderReferenceDetailsRequest setRequestPaymentAuthorization(Boolean requestPaymentAuthorization) {
        this.requestPaymentAuthorization = requestPaymentAuthorization;
        return this;
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
        return "SetOrderReferenceDetailsRequest{"
                + "amazonOrderReferenceId=" + amazonOrderReferenceId
                + ", orderAmount=" + orderAmount
                + ", orderCurrencyCode=" + orderCurrencyCode
                + ", platformId=" + platformId
                + ", sellerNote=" + sellerNote
                + ", sellerOrderId=" + sellerOrderId
                + ", storeName=" + storeName
                + ", customInformation=" + customInformation
                + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }

}
