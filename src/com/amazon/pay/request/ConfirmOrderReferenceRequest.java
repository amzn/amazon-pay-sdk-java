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

import com.amazon.pay.types.CurrencyCode;
import java.io.Serializable;

/**
 * Container for the parameters to the ConfirmOrderReference operation.
 *
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class ConfirmOrderReferenceRequest extends DelegateRequest<ConfirmOrderReferenceRequest> implements Serializable {

    @Override
    protected ConfirmOrderReferenceRequest getThis() {
        return this;
    }

    //required parameters
    private String amazonOrderReferenceId;

    //optional parameters
    private String successUrl;
    private String failureUrl;
    private String authorizationAmount;
    private CurrencyCode authorizationCurrencyCode;

    /**
     * Constructor requires an order reference identifier.
     * @param amazonOrderReferenceId The order reference identifier.
     */
    public ConfirmOrderReferenceRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }

    /**
     * The order reference identifier.
     *
     * @return AmazonOrderReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * @param currencyCode
     *       Three-digit currency code. In ISO 4217 format.
     *
     * @return ConfirmOrderReferenceRequest
     *       Container holding Confirm Order Reference operation parameters
     */
    public ConfirmOrderReferenceRequest setAuthorizationCurrencyCode(final CurrencyCode currencyCode) {
        this.authorizationCurrencyCode = currencyCode;
        return this;
    }

    /**
     * Represents currency code for Confirm Order Reference request
     *
     * @return CurrencyCode
     *       Enum representing three-character currency code (ISO 4217)
     */
    public CurrencyCode getAuthorizationCurrencyCode() {
        return authorizationCurrencyCode;
    }

    /**
     * @param authorizationAmount
     *       The amount to authorize during MFA completion.
     *       Use this parameter if you want to set a payment
     *       amount that is different than the OrderTotal
     *       provided in the SetOrderReferenceDetails
     *       operation call.
     *
     *       If this parameter is not set, the amount authorized
     *       during MFA will be equal to the OrderTotal.
     *
     * @return ConfirmOrderReferenceRequest
     *       Container holding Confirm Order Reference operation parameters
     */
    public ConfirmOrderReferenceRequest setAuthorizationAmount(final String authorizationAmount) {
        this.authorizationAmount = authorizationAmount;
        return this;
    }

    /**
     * Represents the amount to be authorized during MFA completion.
     *
     * @return String
     */
    public String getAuthorizationAmount() {
        return authorizationAmount;
    }

    /**
     * @param successUrl
     *       The buyer is redirected to this URL if the MFA is successful.
     *
     * @return ConfirmOrderReferenceRequest
     *       Container holding Confirm Order Reference operation parameters
     */
    public ConfirmOrderReferenceRequest setSuccessUrl(final String successUrl) {
        this.successUrl = successUrl;
        return this;
    }

    /**
     * Represents the URL buyer is redirected to when MFA is successful.
     *
     * @return String
     */
    public String getSuccessUrl() {
        return successUrl;
    }

    /**
     * @param failureUrl
     *       The buyer is redirected to this URL if the MFA is not successful.
     *
     * @return ConfirmOrderReferenceRequest
     *       Container holding Confirm Order Reference operation parameters
     */
    public ConfirmOrderReferenceRequest setFailureUrl(final String failureUrl) {
        this.failureUrl = failureUrl;
        return this;
    }

    /**
     * Represents the URL buyer is redirected to when MFA is not successful.
     *
     * @return String
     */
    public String getFailureUrl() {
        return failureUrl;
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
        return "ConfirmOrderReferenceRequest{"
                + "amazonOrderReferenceId=" + amazonOrderReferenceId
                + ", authorizationAmount=" + authorizationAmount
                + ", authorizationCurrencyCode=" + authorizationCurrencyCode
                + ", successUrl=" + successUrl
                + ", failureUrl=" + failureUrl
                + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }

}
