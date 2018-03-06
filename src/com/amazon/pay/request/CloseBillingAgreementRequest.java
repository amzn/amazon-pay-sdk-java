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

import java.io.Serializable;

/**
 * Container for the parameters to the CloseBillingAgreement operation.
 *
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class CloseBillingAgreementRequest implements Serializable{

    //required parameters
    private String amazonBillingAgreementId;

    //optional parameters
    private String closureReason;
    private String mwsAuthToken;

    /**
     *
     * @param amazonBillingAgreementId
     *              The billing agreement identifier. This value is retrieved 
     *              from the Amazon Button, AddressBook, or Wallet widgets.
     */
    public CloseBillingAgreementRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    /**
     * @param closureReason
     *              Describes the reason for closing the billing agreement.
     *
     * @return The ClosureReason
     */
    public CloseBillingAgreementRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        return this;
    }

    /**
     * Applicable for third-party solution providers only. 
     * @param mwsAuthToken Sets MWSAuthToken parameter in request. MWSAuthToken is required
     *                     only for third-party solution providers and marketplaces. Do not
     *                     specify this parameter for merchants creating their own custom integration.
     *
     * @return The MWSAuthToken
     */
    public CloseBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * The billing agreement identifier. This value is retrieved 
     *              from the Amazon Button, AddressBook, or Wallet widgets.
     * @return AmazonBillingAgreementId specified in request 
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     *
     * @return ClosureResason specified in request
     */
    public String getClosureReason() {
        return closureReason;
    }

    /**
     *
     * @return MWSAuthToken specified in request
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
        return "CloseBillingAgreementRequest{" + "amazonBillingAgreementId=" + amazonBillingAgreementId + ", closureReason="
                + closureReason + ", mwsAuthToken=" + mwsAuthToken + '}';
    }


}
