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
package com.amazon.payments.paywithamazon.response.ipn.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * An IPN notification to indicate a change in status for
 * a solutionProviderMerchant transaction notification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "merchantRegistrationDetails" })
@XmlRootElement(name = "SolutionProviderMerchantNotification")
public class SolutionProviderMerchantNotification  extends Notification {

    @XmlElement(name = "MerchantRegistrationDetails", required = true)
    private MerchantRegistrationDetails merchantRegistrationDetails;

    public SolutionProviderMerchantNotification() {
        super(NotificationType.SolutionProviderMerchantNotification);
    }

    public SolutionProviderMerchantNotification(final MerchantRegistrationDetails details) {
        super(NotificationType.SolutionProviderMerchantNotification);
        merchantRegistrationDetails = details;
    }

    /**
     * Returns the details of merchantRegistrationDetails
     * 
     * @return Returns the details of merchantRegistrationDetails
     */
    public MerchantRegistrationDetails getMerchantRegistrationDetails() {
        return this.merchantRegistrationDetails;
    }

    /**
     * String representation of SolutionProviderMerchantNotification
     * 
     * @return Returns the string representation of SolutionProviderMerchantNotification
     */
    @Override
    public String toString() {
        return "SolutionProviderMerchantNotification{" + "merchantRegistrationDetails=" + merchantRegistrationDetails.toString() + '}';
    }

    
}
