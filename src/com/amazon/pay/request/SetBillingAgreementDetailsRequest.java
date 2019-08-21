/**
 * Copyright 2016-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

import com.amazon.pay.response.model.Price;
import com.amazon.pay.types.BillingAgreementType;
import java.io.Serializable;

/**
 * Container for the parameters to the SetBillingAgreementDetails operation.
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class SetBillingAgreementDetailsRequest extends DelegateRequest<SetBillingAgreementDetailsRequest> implements Serializable {

    @Override
    protected SetBillingAgreementDetailsRequest getThis() {
        return this;
    }

    //required parameters
    private String amazonBillingAgreementId;

    //optional parameters
    private String platformId;
    private String sellerNote;
    private String sellerBillingAgreementId;
    private String storeName;
    private String customInformation;
    private BillingAgreementType billingAgreementType;
    private Price subscriptionAmount;

    /**
     *
     * @param amazonBillingAgreementId The billing agreement identifier.
     * This value is retrieved from the Amazon Button, AddressBook, or Wallet widgets.
     */
    public SetBillingAgreementDetailsRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    /**
     * Sets the SellerId of the Solution Provider that developed the platform.
     * This value should only be provided by Solution Providers. It should not be
     * provided by merchants creating their own custom integration. Do not specify
     * the SellerId of the merchant for this request parameter.
     * @param platformId Represents the SellerId of the Solution Provider that developed the platform.
     *                   This value should only be provided by Solution Providers. It should
     *                   not be provided by merchants creating their own custom integration.
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public SetBillingAgreementDetailsRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        return this;
    }

    /**
     * Sets description of the billing agreement that is displayed in emails to the buyer.
     * @param sellerNote Represents a description of the order that is displayed in emails to the buyer.
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public SetBillingAgreementDetailsRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        return this;
    }

    /**
     * Sets the merchant-specified identifier of this billing agreement.
     * @param sellerBillingAgreementId the merchant-specified identifier of this billing agreement.
     *
     * @return Seller Billing Agreement ID
     */
    public SetBillingAgreementDetailsRequest setSellerBillingAgreementId(String sellerBillingAgreementId){
        this.sellerBillingAgreementId = sellerBillingAgreementId;
        return this;
    }

    /**
     * Sets identifier of the store from which the order was placed.
     * This overrides the default value in Seller Central under Settings &gt; Account Settings.
     * @param storeName the identifier of the store from which the order was placed.
     *
     * @return the Store Name
     */
    public SetBillingAgreementDetailsRequest setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    /**
     * Sets any additional information that you wish to include with this billing agreement.
     * @param customInformation Additional information that merchant wants to pass for the order.
     *
     * @return Custom Information
     */
    public SetBillingAgreementDetailsRequest setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
        return this;
    }

    /**
     * Sets attribute to determine whether the BillingAgreement is merchant initiated or customer initiated.
     * @param billingAgreementType can be either "CustomerInitiatedTransaction” or “MerchantInitiatedTransaction"
     *
     * @return BillingAgreementType
     */
    public SetBillingAgreementDetailsRequest setBillingAgreementType(BillingAgreementType billingAgreementType) {
        this.billingAgreementType = billingAgreementType;
        return this;
    }

    /**
     * Sets the subscription amount for every charge till the subscription period
     * @param subscriptionAmount The subscription amount for every charge till the subscription period.
     *
     * @return Subscription Amount
     */
    public SetBillingAgreementDetailsRequest setSubscriptionAmount(Price subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
        return this;
    }

    /**
     *
     * @return amazonBillingAgreementId
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     *
     * @return platformId
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     *
     * @return sellerNote
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     *
     * @return sellerBillingAgreementId
     */
    public String getSellerBillingAgreementId() {
        return sellerBillingAgreementId;
    }

    /**
     *
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     *
     * @return customInformation
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     *
     * @return billingAgreementType
     */
    public BillingAgreementType getBillingAgreementType() {
        return billingAgreementType;
    }

    /**
     *
     * @return subscriptionAmount
     */
    public Price getSubscriptionAmount() {
        return subscriptionAmount;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SetBillingAgreementDetailsRequest{"
                + "amazonBillingAgreementId=" + amazonBillingAgreementId
                + ", platformId=" + platformId
                + ", sellerNote=" + sellerNote
                + ", sellerBillingAgreementId=" + sellerBillingAgreementId
                + ", storeName=" + storeName
                + ", customInformation=" + customInformation
                + ", billingAgreementType=" + billingAgreementType
                + ", subscriptionAmount=" + subscriptionAmount
                + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }

}
