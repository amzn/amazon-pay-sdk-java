/**
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;
import java.net.URLDecoder;

/**
 * Container for the parameters to the GetBillingAgreementDetails operation.
 *
 * For more information documentation, see
 * https://payments.amazon.com/documentation/
 */
public class GetBillingAgreementDetailsRequest implements Serializable{

    //required parameters
    private String amazonBillingAgreementId;

    //optional parameters
    private String addressConsentToken;
    private String mwsAuthToken;

    /**
     *
     * @param amazonBillingAgreementId
     *              The billing agreement identifier. This value is retrieved 
     *              from the Amazon Button, AddressBook, or Wallet widgets.
     */
    public GetBillingAgreementDetailsRequest(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
    }

    /**
     *
     * @param mwsAuthToken
     */
    public GetBillingAgreementDetailsRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     *
     * @param addressConsentToken
     *              The buyer address consent token. You must provide a valid 
     *              AddressConsentToken if you want to get the full shipping address before 
     *              the billing agreement is confirmed. 
     */
    public GetBillingAgreementDetailsRequest setAddressConsentToken(String addressConsentToken) {
        this.addressConsentToken = URLDecoder.decode(addressConsentToken);
        return this;
    }

    /**
     *
     * @return AmazonBillingAgreementId
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     *
     * @return AddressConsentToken
     */
    public String getAddressConsentToken() {
        return addressConsentToken;
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
        return "GetBillingAgreementDetailsRequest{" + "amazonBillingAgreementId=" + amazonBillingAgreementId + ", addressConsentToken="
                + addressConsentToken + ", mwsAuthToken=" + mwsAuthToken + '}';
    }


}
