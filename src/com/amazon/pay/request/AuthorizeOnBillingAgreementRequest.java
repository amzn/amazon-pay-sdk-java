/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
 * For more information documentation, see
 * https://pay.amazon.com/documentation/apireference/201751630#201751940">AuthorizeOnBillingAgreement API Reference
 */
public class AuthorizeOnBillingAgreementRequest implements Serializable {

    //required parameters
    private final String amazonBillingAgreementId;
    private final String authorizationReferenceId;
    private final String authorizationAmount;
    private CurrencyCode authorizationCurrencyCode;

    //optional parameters
    private String sellerAuthorizationNote;
    private String transactionTimeout;
    private Boolean captureNow;
    private String softDescriptor;
    private String platformId;
    private String sellerNote;
    private Boolean inheritShippingAddress;

    private String sellerOrderId;
    private String storeName;
    private String customInformation;
    private String mwsAuthToken;

    /**
     * Constructs request for AuthorizeOnBillingAgreement operation
     *
     * @param amazonBillingAgreementId
     *                       The billing agreement identifier. This value is
     *                       retrieved from the Amazon Button, AddressBook, or
     *                       Wallet widgets.
     *
     * @param authorizationReferenceId
     *                       The identifier for this authorization transaction that you specify.
     *                       This identifier must be unique for all your authorization transactions.
     * @param authorizationAmount
     *                       Represents the amount to be authorized.
     *
     * @return AuthorizeOnBillingAgreementRequest
     */
    public AuthorizeOnBillingAgreementRequest(final String amazonBillingAgreementId, final String authorizationReferenceId, final String authorizationAmount) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        this.authorizationReferenceId = authorizationReferenceId;
        this.authorizationAmount = authorizationAmount;
    }

    /**
     * Sets the three-digit currency code.
     *
     * @param authorizationCurrencyCode
     */
    public AuthorizeOnBillingAgreementRequest setAuthorizationCurrencyCode(final CurrencyCode authorizationCurrencyCode){
        this.authorizationCurrencyCode = authorizationCurrencyCode;
        return this;

    }

    /**
     * A description for the transaction that is displayed in emails to the buyer.
     *
     * @param sellerAuthorizationNote
     */
    public AuthorizeOnBillingAgreementRequest setSellerAuthorizationNote(final String sellerAuthorizationNote){
        this.sellerAuthorizationNote = sellerAuthorizationNote;
        return this;
    }

    /**
     * The number of minutes after which the authorization will automatically be
     * closed and you will not be able to capture funds against the authorization.
     *
     * @param TransactionTimeout
     */
    public AuthorizeOnBillingAgreementRequest setTransactionTimeout(final String TransactionTimeout) {
        this.transactionTimeout = TransactionTimeout;
        return this;

    }

    /**
     * Indicates whether to directly capture the amount specified by the
     * AuthorizationAmount request parameter against an order reference
     * (without needing to call Capture and without waiting until the order ships).
     *
     * @param CaptureNow
     */
    public AuthorizeOnBillingAgreementRequest setCaptureNow(final boolean CaptureNow) {
        this.captureNow = CaptureNow;
        return this;
    }

    /**
     * The description to be shown on the buyer's payment instrument statement
     * if CaptureNow is set to true.
     *
     * @param softDescriptor
     */
    public AuthorizeOnBillingAgreementRequest setSoftDescriptor(final String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }

    /**
     * Represents a description of the order that is displayed in emails to the buyer.
     *
     * @param sellerNote
     */
    public AuthorizeOnBillingAgreementRequest setSellerNote(final String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }

    /**
     * Represents the SellerId of the Solution Provider that developed the platform.
     * This value should only be provided by Solution Providers. It should
     * not be provided by merchants creating their own custom integration.
     *
     * @param platformId
     */
    public AuthorizeOnBillingAgreementRequest setPlatformId(final String platformId) {
        this.platformId = platformId;
        return this;
    }

    /**
     * The merchant-specified identifier of this order. This is displayed to the
     * buyer in their emails and transaction history on the Amazon Pay website.
     *
     * @param sellerOrderId
     *
     * @return
     *       Returns a reference to this object so that methods can be chained together.
     */
    public AuthorizeOnBillingAgreementRequest setSellerOrderId(final String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }

    /**
     * The identifier of the store from which the order was placed.
     * This overrides the default value in Seller Central under Settings > Account Settings.
     *
     * @param storeName
     */
    public AuthorizeOnBillingAgreementRequest setStoreName(final String storeName) {
        this.storeName = storeName;
        return this;
    }

    /**
     * Sets any additional information that you want to include with this order reference.
     *
     * @param customInformation
     *
     */
    public AuthorizeOnBillingAgreementRequest setCustomInformation(final String customInformation) {
        this.customInformation = customInformation;
        return this;
    }

    /**
     * Sets inheritShippingAddress parameter
     *
     * @param inheritShippingAddress
     */
    public AuthorizeOnBillingAgreementRequest setInheritShippingAddress(final Boolean inheritShippingAddress) {
        this.inheritShippingAddress = inheritShippingAddress;
        return this;
    }

    /**
     * Sets inheritShippingAddress parameter
     * Deprecated since SDK 2.2.1
     *
     * @param inheritShippingAddress
     */
    @Deprecated
    public AuthorizeOnBillingAgreementRequest setInheritShippingAddress(final String inheritShippingAddress) {
        return setInheritShippingAddress(
                Boolean.parseBoolean(inheritShippingAddress));
    }

    /**
     * Sets MWSAuthToken parameter in request. MWSAuthToken is required only
     * for third-party solution providers and marketplaces. Do not specify
     * this parameter for merchants creating their own custom integration.
     *
     * @param mwsAuthToken new value of mwsAuthToken
     */
    public AuthorizeOnBillingAgreementRequest setMWSAuthToken(final String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * The billing agreement identifier. This value is
     *  retrieved from the Amazon Button, AddressBook, or
     *  Wallet widgets.
     *
     * @return amazonBillingAgreementId
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     *The identifier for this authorization transaction that you specify.
     *
     * @return
     *          Returns authorizationReferenceId from request
     */
    public String getAuthorizationReferenceId() {
        return authorizationReferenceId;
    }

    /**
     * Represents the amount to be authorized.
     * @return
     *          Returns authorizationAmount from request
     */
    public String getAuthorizationAmount() {
        return authorizationAmount;
    }

    /**
     * Represents the three-digit currency code.
     *
     * @return Returns authorizationCurrencyCode from request
     */
    public CurrencyCode getAuthorizationCurrencyCode() {
        return authorizationCurrencyCode;
    }

    /**
     *
     * @return Returns sellerAuthorizationNote from request
     */
    public String getSellerAuthorizationNote() {
        return sellerAuthorizationNote;
    }

    /**
     * The number of minutes after which the authorization will automatically be
     * closed and you will not be able to capture funds against the authorization.
     *
     * @return Returns transactionTimeout from request
     */
    public String getTransactionTimeout() {
        return transactionTimeout;
    }

    /**
     * Indicates whether to directly capture the amount specified by the
     * AuthorizationAmount request parameter against an order reference
     * (without needing to call Capture and without waiting until the order ships).
     *
     * @return Returns captureNow status from request
     */
    public Boolean getCaptureNow() {
        return captureNow;
    }

    /**
     * The description to be shown on the buyer's payment instrument statement
     * if CaptureNow is set to true.
     *
     * @return Returns softDescriptor status from request
     */
    public String getSoftDescriptor() {
        return softDescriptor;
    }

    /**
     * Represents the SellerId of the Solution Provider that developed the platform.
     * This value should only be provided by Solution Providers. It should
     * not be provided by merchants creating their own custom integration.
     *
     * @return Returns platformId status from request
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * Represents a description of the order that is displayed in emails to the buyer.
     *
     * @return Returns sellerNote status from request
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * Returns inheritShippingAddress parameter
     *
     * @return Returns inheritShippingAddress status from request
     */
    public Boolean getInheritShippingAddress() {
        return inheritShippingAddress;
    }

    /**
     *
     * @return Returns sellerOrderId status from request
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * The identifier of the store from which the order was placed.
     * This overrides the default value in Seller Central under Settings > Account Settings.
     *
     * @return Returns storeName status from request
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Sets any additional information that you want to include with this order reference.
     *
     * @return Returns customInformation status from request
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     *
     * @return Returns mwsAuthToken status from request
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
        return "AuthorizeOnBillingAgreementRequest{"
                + "amazonBillingAgreementId=" + amazonBillingAgreementId
                + ", authorizationReferenceId=" + authorizationReferenceId
                + ", authorizationAmount=" + authorizationAmount
                + ", authorizationCurrencyCode=" + authorizationCurrencyCode
                + ", sellerAuthorizationNote=" + sellerAuthorizationNote
                + ", transactionTimeout=" + transactionTimeout
                + ", captureNow=" + captureNow
                + ", softDescriptor=" + softDescriptor
                + ", platformId=" + platformId
                + ", sellerNote=" + sellerNote
                + ", inheritShippingAddress=" + inheritShippingAddress
                + ", sellerOrderId=" + sellerOrderId
                + ", storeName=" + storeName
                + ", customInformation=" + customInformation
                + ", mwsAuthToken=" + mwsAuthToken + '}';
    }

}
