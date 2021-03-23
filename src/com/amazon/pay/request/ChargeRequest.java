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

import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.response.model.ProviderCredit;
import com.amazon.pay.types.AmazonReferenceIdType;
import com.amazon.pay.types.CurrencyCode;
import java.io.Serializable;
import java.util.List;

/**
 * Container for the parameters to the Capture operation.
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */

public class ChargeRequest extends DelegateRequest<ChargeRequest> implements Serializable {

    @Override
    protected ChargeRequest getThis() {
        return this;
    }

    //required parameters
    private String amazonReferenceId;
    private AmazonReferenceIdType type;
    private String chargeReferenceId;
    private String amount;
    private CurrencyCode currencyCode;
    private String transactionTimeout;
    private Boolean captureNow;
    private String chargeOrderId;
    private String storeName;
    private String customInformation;
    private String platformId;

    //optional parameters
    private String sellerNote;
    private String softDescriptor;

    private Boolean inheritShippingAddress;

    private List<ProviderCredit> providerCredit;

    public Boolean getInheritShippingAddress() {
        return inheritShippingAddress;
    }

    /**
     * Sets the InheritShippingAddress in ChargeRequest
     *
     * @param  inheritShippingAddress Sets the value of inheritShippingAddress
     */
    public void setInheritShippingAddress(final Boolean inheritShippingAddress) {
        this.inheritShippingAddress = inheritShippingAddress;
    }


    /**
     * Sets the InheritShippingAddress in ChargeRequest
     * Deprecated since SDK 2.2.1
     *
     * @param  inheritShippingAddress Sets the value of inheritShippingAddress
     */
    @Deprecated
    public void setInheritShippingAddress(final String inheritShippingAddress) {
        setInheritShippingAddress(Boolean.parseBoolean(inheritShippingAddress));
    }


    /*
    * @param amazonAuthorizationId
    *               The authorization identifier that was generated by
    *               Amazon in the earlier call to Authorize or AuthorizeOnBillingAgreement.
    * @param captureReferenceId
    *               The identifier for this capture transaction that you specify.
    *               This identifier must be unique for all your capture transactions.
    * @param captureAmount
    *               The amount to capture in this transaction.
    * @return
    *           Container holding Capture operation parameters
    *
    */
    public ChargeRequest() {
    }


    /**
     * Sets the Amazon Order Reference ID / Amazon Billing Agreement ID
     *
     * @param amazonReferenceId The Amazon Order Reference ID / Amazon Billing Agreement ID
     *
     * @return Returns a reference to this object so that methods can be chained together.
     **/
    public ChargeRequest withAmazonReferenceId(final String amazonReferenceId) {
        if ((amazonReferenceId != null) && (amazonReferenceId.length() > 0)) {
            final String switchChar = amazonReferenceId;
            switch (switchChar.charAt(0)) {
                case 'P':
                case 'S':
                    type = AmazonReferenceIdType.ORDER_REFERENCE_ID;
                    this.amazonReferenceId = amazonReferenceId;
                    break;
                case 'B':
                case 'C':
                    type = AmazonReferenceIdType.BILLING_AGREEMENT_ID;
                    this.amazonReferenceId = amazonReferenceId;
                    break;
                default:
                    throw new AmazonClientException("Invalid Amazon Reference ID");
            }
        } else {
            throw new AmazonClientException(
                    "Amazon Reference ID is a required field and should be a Order Reference ID / Billing Agreement ID");
        }

        return this;
    }


    /**
     * Sets the amount in ChargeRequest
     *
     * @param amount
     *       Specified amount for charge request
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withAmount(final String amount){
        this.amount = amount;
        return this;
    }


    /**
     * Sets the currency code in ChargeRequest
     *
     * @param currencyCode
     *       Three-digit currency code. In ISO 4217 format.
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withCurrencyCode(final CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }


    /**
     * Sets the authorization reference Id. This needs to be unique Id across all authorization requests
     *
     * @param  chargeReferenceId
     *       Unique referenceId
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withChargeReferenceId(final String chargeReferenceId) {
        this.chargeReferenceId = chargeReferenceId;
        return this;
    }


    /**
     * Sets the Seller Note, Seller Authorization Note for Amazon Order Reference ID / Amazon Billing Agreement ID
     *
     * @param  chargeNote Charge Note
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withChargeNote(final String chargeNote) {
        this.sellerNote = chargeNote;
        return this;
    }


    /**
     * Sets the transaction timeout to ChargeRequest
     *
     * @param  transactionTimeout Sets the transaction timeout to ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withTransactionTimeout(final String transactionTimeout) {
        this.transactionTimeout = transactionTimeout;
        return this;
    }


    /**
     * Sets the captureNow in ChargeRequest
     *
     * @param  captureNow Sets the captureNow in ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withCaptureNow(final Boolean captureNow) {
        this.captureNow = captureNow;
        return this;
    }


    /**
     * Sets the InheritShippingAddress in ChargeRequest
     *
     * @param  inheritShippingAddress Sets the InheritShippingAddress in ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withInheritShippingAddress(final Boolean inheritShippingAddress) {
        this.inheritShippingAddress = inheritShippingAddress;
        return this;
    }


    /**
     * Sets the InheritShippingAddress in ChargeRequest
     * Deprecated since SDK 2.2.1
     *
     * @param  inheritShippingAddress Sets the InheritShippingAddress in ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    @Deprecated
    public ChargeRequest withInheritShippingAddress(final String inheritShippingAddress) {
        return withInheritShippingAddress(Boolean.parseBoolean(inheritShippingAddress));
    }


    /**
     * Sets the chargeOrderId in ChargeRequest
     *
     * @param  chargeOrderId Sets the chargeOrderId in ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withChargeOrderId(final String chargeOrderId) {
        this.chargeOrderId = chargeOrderId;
        return this;
    }


    /**
     * Sets the storeName in ChargeRequest
     *
     * @param  storeName Sets the storeName in ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withStoreName(final String storeName) {
        this.storeName = storeName;
        return this;
    }


    /**
     * Sets the customInformation in ChargeRequest
     *
     * @param  customInformation Sets the customInformation in ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withCustomInformation(final String customInformation) {
        this.customInformation = customInformation;
        return this;
    }


    /**
     * Sets the platformId in ChargeRequest
     *
     * @param  platformId Sets the platformId in ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withPlatformId(final String platformId) {
        this.platformId = platformId;
        return this;
    }


    /**
     * Sets the softDescriptor in ChargeRequest
     *
     * @param  softDescriptor Sets the softDescriptor in ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withSoftDescriptor(final String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }


    /**
     * Sets the providerCredit in ChargeRequest
     *
     * @param providerCredit Sets the providerCredit in ChargeRequest
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public ChargeRequest withProviderCreditDetails(final List<ProviderCredit> providerCredit) {
        this.providerCredit = providerCredit;
        return this;
    }


    /**
     * The identifier for this Amazon Pay transaction that you specify.
     *
     * @return Amazon Reference Id specified in request
     */
    public String getAmazonReferenceId() {
        return amazonReferenceId;
    }

    /**
     * The type of Amazon Pay transaction that you specify.
     *
     * @return Amazon Reference Id Type specified in request
     */
    public AmazonReferenceIdType getType() {
        return type;
    }

    /**
     * The identifier for this Charge Reference ID
     *
     * @return Charge Reference Id specified in request
     */
    public String getChargeReferenceId() {
        return chargeReferenceId;
    }

    /**
     * The amount for the transaction
     *
     * @return Amount specified in request
     */
    public String getAmount() {
        return amount;
    }

    /**
     * The currencyCode set in the request
     *
     * @return currencyCode specified in request
     */
    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    /**
     * The TransactionTimeOut set in the request
     *
     * @return TransactionTimeOut specified in request
     */
    public String getTransactionTimeout() {
        return transactionTimeout;
    }

    /**
     * The captureNow set in the request
     *
     * @return captureNow specified in request
     */
    public Boolean getCaptureNow() {
        return captureNow;
    }

    /**
     * The chargeOrderId set in the request
     *
     * @return chargeOrderId specified in request
     */
    public String getChargeOrderId() {
        return chargeOrderId;
    }

    /**
     * The storeName set in the request
     *
     * @return storeName specified in request
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * The customInformation set in the request
     *
     * @return customInformation specified in request
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     * The platformId set in the request
     *
     * @return platformId specified in request
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * The sellerNote set in the request
     *
     * @return sellerNote specified in request
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * The SoftDescriptor set in the request
     *
     * @return SoftDescriptor specified in request
     */
    public String getSoftDescriptor() {
        return softDescriptor;
    }

    /**
     * The ProviderCredit set in the request
     *
     * @return ProviderCredit specified in request
     */
    public List<ProviderCredit> getProviderCredit() {
        return providerCredit;
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
        return "ChargeRequest{"
                + "amazonReferenceId=" + amazonReferenceId
                + ", type=" + type
                + ", chargeReferenceId=" + chargeReferenceId
                + ", amount=" + amount
                + ", currencyCode=" + currencyCode
                + ", transactionTimeout=" + transactionTimeout
                + ", captureNow=" + captureNow
                + ", chargeOrderId=" + chargeOrderId
                + ", storeName=" + storeName
                + ", customInformation=" + customInformation
                + ", platformId=" + platformId
                + ", sellerNote=" + sellerNote
                + ", softDescriptor=" + softDescriptor
                + ", mwsAuthToken=" + getMwsAuthToken()
                + ", inheritShippingAddress=" + inheritShippingAddress
                + ", providerCredit=" + providerCredit + '}';
    }


}
