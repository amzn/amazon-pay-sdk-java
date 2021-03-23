/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
import com.amazon.pay.types.AmazonReferenceIdType;

import java.io.Serializable;

/**
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class CreateOrderReferenceForIdRequest extends DelegateRequest<CreateOrderReferenceForIdRequest> implements Serializable {

    @Override
    protected CreateOrderReferenceForIdRequest getThis() {
        return this;
    }

    //required parameters
    private String id;
    private AmazonReferenceIdType idType;

    //optonal parameters
    private Boolean inheritShippingAddress;
    private Boolean confirmNow;
    private CurrencyCode orderTotalCurrencyCode;
    private String sellerNote;
    private String sellerOrderId;
    private String storeName;
    private String supplementaryData;
    private String customInformation;

    //conditionally required
    private String orderTotalAmount;
    private String platformId;

    /**
     * Constructor for CreateOrderReferenceForId Request.
     * @param id
     *        The identifier of the object to be used to create an order reference.
     *        Currently, the only accepted value is a billing agreement identifier.
     *        This value is retrieved from the Amazon Button widget after the buyer
     *        has successfully authenticated with Amazon.
     * @param idType
     *        The type of the object represented by the Id request parameter.
     *        Currently, idType must be AmazonReferenceIdType.BILLING_AGREEMENT_ID.
     */
    public CreateOrderReferenceForIdRequest (
            final String id, final AmazonReferenceIdType idType) {
        this.id = id;
        this.idType = idType;
    }

    /**
     * Constructor for CreateOrderReferenceForIdRequest.
     * Automatically sets idType to AmazonReferenceIdType.BILLING_AGREEMENT_ID.
     * @param id
     *        The identifier of the object to be used to create an order reference.
     *        Currently, the only accepted value is a billing agreement identifier.
     *        This value is retrieved from the Amazon Button widget after the buyer
     *        has successfully authenticated with Amazon.
     */
    public CreateOrderReferenceForIdRequest (final String id) {
        this.id = id;
        this.idType = AmazonReferenceIdType.BILLING_AGREEMENT_ID;
    }

    /**
     * The identifier of the object to be used to create an order reference.
     *
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * The type of the object represented by the Id request parameter.
     *
     * @return AmazonReferenceIdType enum
     */
    public AmazonReferenceIdType getIdType() {
        return idType;
    }

    /**
     * Specifies whether to inherit the shipping address details from
     * the object represented by the Id request parameter.
     * Default: true
     *
     * @param inheritShippingAddress
     *        indicating status of confirmNow status
     * @return CreateOrderReferenceForIdRequest
     *         Container holding CreateOrderReferenceForId operation parameters
     */
    public CreateOrderReferenceForIdRequest setInheritShippingAddress(
            final Boolean inheritShippingAddress) {
        this.inheritShippingAddress = inheritShippingAddress;
        return this;
    }

    /**
     * Specifies whether to inherit the shipping address details from
     * the object represented by the Id request parameter.
     *
     * @return Boolean
     */
    public Boolean getInheritShippingAddress() {
        return inheritShippingAddress;
    }

    /**
     * Indicates whether to directly confirm the requested order reference.
     * Default: false
     *
     * @param confirmNow
     *        true: The order reference is directly confirmed.
     *        You do not need to call the ConfirmOrderReference operation.
     *        false: You must call the ConfirmOrderReference operation
     *        to confirm the order reference.
     * @return CreateOrderReferenceForIdRequest
     *         Container holding CreateOrderReferenceForId operation parameters
     */
    public CreateOrderReferenceForIdRequest setConfirmNow(
            final Boolean confirmNow) {
        this.confirmNow = confirmNow;
        return this;
    }

    /**
     * Indicates whether to directly confirm the requested order reference.
     *
     * @return Boolean
     */
    public Boolean getConfirmNow() {
        return confirmNow;
    }

    /**
     * The currency type being used for this order reference.
     * @param orderTotalCurrencyCode
     *        CurrencyCode enum representing ISO-4217
     *        three character currency code.
     *
     * @return CreateOrderReferenceForIdRequest
     *           Container holding CreateOrderReferenceForId operation parameters
     */
    public CreateOrderReferenceForIdRequest setOrderTotalCurrencyCode(
            final CurrencyCode orderTotalCurrencyCode) {
        this.orderTotalCurrencyCode = orderTotalCurrencyCode;
        return this;
    }

    /**
     * The currency type being used for this order reference.
     *
     * @return CurrencyCode enum
     */
    public CurrencyCode getOrderTotalCurrencyCode() {
        return orderTotalCurrencyCode;
    }

    /**
     * Specifies the total amount of the order represented by this order reference.
     * @param orderTotalAmount
     *        The total currency amount for this order.
     *
     * @return CreateOrderReferenceForIdRequest
     *           Container holding CreateOrderReferenceForId operation parameters
     */
    public CreateOrderReferenceForIdRequest setOrderTotalAmount(
            final String orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
        return this;
    }

    /**
     * Specifies the total amount of the order represented by this order reference.
     *
     * @return String
     */
    public String getOrderTotalAmount() {
        return orderTotalAmount;
    }

    /**
     * Represents the SellerId of the Solution Provider that developed the eCommerce platform.
     * @param platformId
     *        This value is only used by Solution Providers, for whom it is required.
     *        It should not be provided by merchants creating their own custom integration.
     *        Do not specify the SellerId of the merchant for this request parameter.
     *        If you are a merchant, do not enter a PlatformId.
     *
     * @return CreateOrderReferenceForIdRequest
     *           Container holding CreateOrderReferenceForId operation parameters
     */
    public CreateOrderReferenceForIdRequest setPlatformId(
            final String platformId) {
        this.platformId = platformId;
        return this;
    }

    /**
     * Represents the SellerId of the Solution Provider that developed the eCommerce platform.
     *
     * @return String
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * Represents a description of the order that is displayed in emails to the buyer.
     * @param sellerNote
     *        Maximum: 1024 characters
     *
     * @return CreateOrderReferenceForIdRequest
     *           Container holding CreateOrderReferenceForId operation parameters
     */
    public CreateOrderReferenceForIdRequest setSellerNote(
            final String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }

    /**
     * Represents a description of the order that is displayed in emails to the buyer.
     *
     * @return String
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * The merchant-specified identifier of this order. This is displayed to the buyer
     * in their emails and transaction history on the Amazon Pay website.
     * @param sellerOrderId
     *        Although it is recommended, Amazon does not require this value to be unique.
     *        Amazon recommends that you use only the following characters:
     *        lowercase a-z, uppercase A-Z, numbers 0-9, dash (-), underscore (_)
     *
     * @return CreateOrderReferenceForIdRequest
     *           Container holding CreateOrderReferenceForId operation parameters
     */
    public CreateOrderReferenceForIdRequest setSellerOrderId(
            final String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }

    /**
     * The merchant-specified identifier of this order.
     *
     * @return String
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * The identifier of the store from which the order was placed.
     * This overrides the default value in Seller Central under Settings/Account Settings.
     * @param storeName
     *        Name displayed to the buyer in their emails and transaction
     *        history on the Amazon Pay website.
     *
     * @return CreateOrderReferenceForIdRequest
     *           Container holding CreateOrderReferenceForId operation parameters
     */
    public CreateOrderReferenceForIdRequest setStoreName(
            final String storeName) {
        this.storeName = storeName;
        return this;
    }

    /**
     * The identifier of the store from which the order was placed.
     *
     * @return String
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Set the trusted authorization supplementary data.
     * Use only as directed by Amazon Pay.
     *
     * @param supplementaryData Trusted authorization supplementary data (JSON string)
     *
     * @return Request object
     */
    public CreateOrderReferenceForIdRequest setSupplementaryData(final String supplementaryData) {
        this.supplementaryData = supplementaryData;
        return this;
    }

    /**
     * Returns the trusted authorization supplementary data.
     *
     * @return supplementaryData as a JSON string
     */
    public String getSupplementaryData() {
        return supplementaryData;
    }

    /**
     * Any additional information that you want to include with this order reference.
     * @param customInformation
     *        This string is never displayed in emails or Seller Central.
     *        It is only accessible by the the SDK or API.
     *
     * @return CreateOrderReferenceForIdRequest
     *           Container holding CreateOrderReferenceForId operation parameters
     */
    public CreateOrderReferenceForIdRequest setCustomInformation(
            final String customInformation) {
        this.customInformation = customInformation;
        return this;
    }

    /**
     * Any additional information that you want to include with this order reference.
     *
     * @return String
     */
    public String getCustomInformation() {
        return customInformation;
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
        return "CreateOrderReferenceForId{" +
                "id=" + id +
                ", idType=" + idType.value() +
                ", inheritShippingAddress=" + inheritShippingAddress +
                ", confirmNow=" + confirmNow +
                ", orderTotalCurrencyCode=" + orderTotalCurrencyCode +
                ", orderTotalAmount=" + orderTotalAmount +
                ", platformId=" + platformId +
                ", sellerNote=" + sellerNote +
                ", sellerOrderId=" + sellerOrderId +
                ", storeName=" + storeName +
                ", supplementaryData=" + supplementaryData +
                ", customInformation=" + customInformation + "}";
    }

}
