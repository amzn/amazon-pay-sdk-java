/**
 * Copyright 2017-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
import java.util.Set;

/**
 * Container for the parameters to the SetOrderAttributes operation.
 *
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class SetOrderAttributesRequest extends DelegateRequest<SetOrderAttributesRequest> implements Serializable {

    @Override
    protected SetOrderAttributesRequest getThis() {
        return this;
    }

    //required parameters
    private String amazonOrderReferenceId;

    // conditionally required when the request has not been confirmed
    private String amount;
    private CurrencyCode currencyCode;

    //optional parameters
    private String sellerNote;
    private String platformId;
    private Boolean requestPaymentAuthorization;
    private String sellerOrderId;
    private String storeName;
    private String customInformation;
    private String paymentServiceProviderId;
    private String paymentServiceProviderOrderId;
    private Set<String> orderItemCategories;

    /**
     *
     * @param amazonOrderReferenceId The order reference identifier.
     *                               This value is retrieved from the Amazon Button widget
     *                               after the buyer has successfully authenticated with Amazon.
     */
    public SetOrderAttributesRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }



    /**
     *
     * @param amazonOrderReferenceId The order reference identifier.
     *                               This value is retrieved from the Amazon Button widget
     *                               after the buyer has successfully authenticated with Amazon.
     * @param amount                 Specifies the total amount of the order represented by this order reference.
     * @param currencyCode           Specifies the currency code for amount of the order represented by this order reference.
     */
    public SetOrderAttributesRequest(String amazonOrderReferenceId, String amount, CurrencyCode currencyCode) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    /**
     * Returns the amazon reference ID
     *
     * @return amazonReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * Returns the total order amount
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Specifies the total amount of the order
     *
     * @param amount Order amount total.
     *
     * @return the order amount
     */
    public SetOrderAttributesRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Returns the currency code
     *
     * @return currencyCode
     */
    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Overrides the Client's currency code with specified currency code in SetOrderAttributesRequest
     *
     * @param currencyCode
     *              A three-digit currency code, formatted based on the ISO 4217 standard.
     *
     * @return Curreny Code
     */
    public SetOrderAttributesRequest setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    /**
     * Returns the seller note
     *
     * @return sellerNote
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * Represents a description of the order that is displayed in emails to the buyer.
     *
     * @param sellerNote Represents a description of the order that is displayed in emails to the buyer.
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public SetOrderAttributesRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }

    /**
     * Returns the platform id
     *
     * @return platformId
     */
    public String getPlatformId() {
        return platformId;
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
    public SetOrderAttributesRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        return this;
    }

    /**
     *Check if payment authorization has been requested or not
     *
     * @return requestPaymentAuthorization
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
    public SetOrderAttributesRequest setRequestPaymentAuthorization(Boolean requestPaymentAuthorization) {
        this.requestPaymentAuthorization = requestPaymentAuthorization;
        return this;
    }

    /**
     * Returns the seller order id
     *
     * @return sellerOrderId
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * The merchant-specified identifier of this order. This is displayed to the
     * buyer in their emails and transaction history on the Amazon Pay website.
     *
     * @param sellerOrderId merchant-specified identifier of the order.
     *
     * @return the Seller Order ID
     */
    public SetOrderAttributesRequest setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }

    /**
     * Returns the store name
     *
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
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
    public SetOrderAttributesRequest setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    /**
     * Returns the custom information
     *
     * @return customInformation
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     * Any additional information that you want to include with this order reference.
     *
     * @param customInformation Additional information that merchant wants to pass for the order.
     *
     * @return Custom Information
     */
    public SetOrderAttributesRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
        return this;
    }

    /**
     * Return the payment service provider id
     *
     * @return paymentServiceProviderId
     */
    public String getPaymentServiceProviderId() {
        return paymentServiceProviderId;
    }

    /**
     * Specifies the payment service provider id
     *
     * @param paymentServiceProviderId  A Payment Service Provider (PSP) allows a
     *                                  merchant to connect to multiple payment
     *                                  methods using a single payment gateway.
     *
     * @return the paymentServiceProviderId
     */
    public SetOrderAttributesRequest setPaymentServiceProviderId(String paymentServiceProviderId) {
        this.paymentServiceProviderId = paymentServiceProviderId;
        return this;
    }

    /**
     * Returns the payment service provider order id
     *
     * @return paymentServiceProviderOrderId
     */
    public String getPaymentServiceProviderOrderId() {
        return paymentServiceProviderOrderId;
    }

    /**
     * Specifies the payment service provider order id
     *
     * @param paymentServiceProviderOrderId the PSP Order ID
     *
     * @return  paymentServiceProviderOrderId
     */
    public SetOrderAttributesRequest setPaymentServiceProviderOrderId(String paymentServiceProviderOrderId) {
        this.paymentServiceProviderOrderId = paymentServiceProviderOrderId;
        return this;
    }

    /**
     * Returns the order item categories
     *
     * @return orderItemCategories
     */
    public Set<String> getOrderItemCategories() {
        return orderItemCategories;
    }

    /**
     * Specifies the order item categories
     *
     * @param orderItemCategories A list representing the types of goods and
     *                            services the merchant offers for sale.
     *                            Not typically used.  Only specific strings
     *                            are allowed in the list.
     * @return the orderItemCategories
     */
    public SetOrderAttributesRequest setOrderItemCategories(Set<String> orderItemCategories) {
        this.orderItemCategories = orderItemCategories;
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
        return "SetOrderAttributesRequest{" + "amazonOrderReferenceId=" + amazonOrderReferenceId
                + ", orderAmount=" + amount
                + ", orderCurrencyCode=" + currencyCode.toString()
                + ", platformId=" + platformId
                + ", sellerNote=" + sellerNote
                + ", sellerOrderId=" + sellerOrderId
                + ", storeName=" + storeName
                + ", customInformation=" + customInformation
                + ", requesPaymentAuthorization=" + requestPaymentAuthorization.toString()
                + ", paymentServiceProviderId=" + paymentServiceProviderId
                + ", paymentServiceProviderOrderId" + paymentServiceProviderOrderId
                + ", orderItemcategories" + orderItemCategories.toString() + '}';
    }
}
