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
import java.util.List;
import com.amazon.pay.response.model.ProviderCredit;
import java.io.Serializable;


/**
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class AuthorizeRequest implements Serializable {

    //required parameters
    private String amazonOrderReferenceId;
    private String authorizationReferenceId;
    private String authorizationAmount;

    //optonal parameters
    private CurrencyCode authorizationCurrencyCode;
    private String sellerAuthorizationNote;
    private String transactionTimeout;
    private Boolean captureNow;
    private String softDescriptor;
    private String mwsAuthToken;
    private List<ProviderCredit> providerCredit;

    /*
    * @param amazonOrderReferenceId
    *      The order reference identifier. This value is retrieved
    *      from the Amazon Button widget after the buyer has successfully
    *      authenticated with Amazon.
    * @param authorizationReferenceId
    *      The identifier for this authorization transaction that you specify.
    *      This identifier must be unique for all your authorization transactions.
    * @param authorizationAmount
    *      Represents the amount to be authorized.
    *
    * @return AuthorizeRequest
    *           Container holding authorize operation parameters
    */
    public AuthorizeRequest(String amazonOrderReferenceId, String authorizationReferenceId, String authorizationAmount) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.authorizationReferenceId = authorizationReferenceId;
        this.authorizationAmount = authorizationAmount;
    }

    /**
     * @param currencyCode
     *       Three-digit currency code. In ISO 4217 format.
     *
     * @return AuthorizeRequest
     */
    public AuthorizeRequest setAuthorizationCurrencyCode(CurrencyCode currencyCode) {
        this.authorizationCurrencyCode = currencyCode;
        return this;
    }

    /**
     * Represents currency code for Authorize request
     *
     * @return AuthorizeRequest
     */
    public CurrencyCode getAuthorizationCurrencyCode() {
        return authorizationCurrencyCode;
    }

    /**
     * Indicates whether to directly capture a specified amount against an order reference
     * (without needing to call Capture and without waiting until the order ships).
     * The captured amount is disbursed to your account in the next disbursement cycle.
     * Default: false
     *
     * @param CaptureNow boolean indicating status of captureNow status
     */
    public AuthorizeRequest setCaptureNow(boolean CaptureNow) {
        this.captureNow = CaptureNow;
        return this;
    }

    /**
     * The description to be shown on the buyer's payment instrument statement
     * if CaptureNow is set to true. The soft descriptor sent to the payment
     * processor is: “AMZ* <soft descriptor specified here>”.
     * Default: “AMZ*<SELLER_NAME> amzn.com/pmts WA”
     * Maximum: 16 characters
     *
     * @param softDescriptor string for Authorize operation
     */
    public AuthorizeRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }

    /**
     * Represents the order reference identifier.
     *
     * @return Amazon Order ReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * The identifier for this authorization transaction that you specify.
     *
     * @return Amazon Authorization ReferenceId
     */
    public String getAuthorizationReferenceId() {
        return authorizationReferenceId;
    }

    /**
     * Represents the amount to be authorized.
     *
     * @return Amazon Authorization amount
     */
    public String getAuthorizationAmount() {
        return authorizationAmount;
    }

    /*
    * A description for the transaction that is displayed in emails
    * to the buyer. Appears only when CaptureNow is set to true.
    *
    * @return A description for the transaction
    */
    public String getSellerAuthorizationNote() {
        return sellerAuthorizationNote;
    }

    /*
    * A description for the transaction that is displayed in emails to the buyer.
    * Appears only when CaptureNow is set to true.
    *
    * @return A description for the transaction
    */
    public AuthorizeRequest setSellerAuthorizationNote(String sellerAuthorizationNote){
        this.sellerAuthorizationNote = sellerAuthorizationNote;
        return this;
    }

    /**
     * The maximum number of minutes allocated for the Authorize operation
     * call to be processed, after which the authorization will automatically
     * be declined. Note: Set this value to zero for synchronous mode.
     *
     * @return Maximum number of minutes allocated for the Authorize operation
     */
    public String getTransactionTimeout() {
        return transactionTimeout;
    }

    /**
     * The maximum number of minutes allocated for the Authorize operation
     * call to be processed, after which the authorization will automatically
     * be declined. Note: Set this value to zero for synchronous mode.
     *
     * @param TransactionTimeout maximum number of minutes allocated for the Authorize operation
     */
    public AuthorizeRequest setTransactionTimeout(String TransactionTimeout) {
        this.transactionTimeout = TransactionTimeout;
        return this;
    }

    /**
     * Indicates whether to directly capture a specified amount against an order reference
     * (without needing to call Capture and without waiting until the order ships).
     * The captured amount is disbursed to your account in the next disbursement cycle.
     * Default: false
     *
     * @return A boolean indicating status of captureNow status
     */
    public Boolean getCaptureNow() {
        return captureNow;
    }

    /**
     * The description to be shown on the buyer's payment instrument statement
     * if CaptureNow is set to true. The soft descriptor sent to the payment
     * processor is: “AMZ* <soft descriptor specified here>”.
     * Default: “AMZ*<SELLER_NAME> amzn.com/pmts WA”
     * Maximum: 16 characters
     *
     * @return Soft descriptor string for Authorize operation
     */
    public String getSoftDescriptor() {
        return softDescriptor;
    }

    /**
     * @return mwsAuthToken
     */
    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    /**
     * Applicable for third-party solution providers only.
     *
     * @param mwsAuthToken
     */
    public AuthorizeRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * Applicable for third-party solution providers only.
     *
     * @return ProviderCredit associated with Authorize operation
     */
    public List<ProviderCredit> getProviderCredit() {
        return providerCredit;
    }

    /**
     * Applicable for third-party solution providers only.
     *
     * @param providerCreditList associated with Authorize operation
     *
     */
    public AuthorizeRequest setProviderCredit(List<ProviderCredit> providerCreditList) {
        this.providerCredit = providerCreditList;
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
        return "AuthorizeRequest{" + "amazonOrderReferenceId=" + amazonOrderReferenceId + ", authorizationReferenceId="
                + authorizationReferenceId + ", authorizationAmount=" + authorizationAmount + ", authorizationCurrencyCode="
                + authorizationCurrencyCode + ", sellerAuthorizationNote=" + sellerAuthorizationNote + ", transactionTimeout="
                + transactionTimeout + ", captureNow=" + captureNow + ", softDescriptor=" + softDescriptor + ", mwsAuthToken="
                + mwsAuthToken + ", providerCredit=" + providerCredit + '}';
    }



}
