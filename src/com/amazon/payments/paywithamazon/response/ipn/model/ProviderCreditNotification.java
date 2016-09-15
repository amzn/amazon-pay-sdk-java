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
 * a providerCredit transaction notification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "providerCreditDetails"
})
@XmlRootElement(name="ProviderCreditNotification")
public class ProviderCreditNotification  extends Notification {

    /**
     * ProviderCredit details.
     */
    @XmlElement(name="ProviderCreditDetails", required = true)
    private ProviderCreditDetails providerCreditDetails;

    /**
     * Creates a new instance of the providerCredit notification.
     */
    public ProviderCreditNotification() {
        super(NotificationType.ProviderCreditNotification);
    }

    public ProviderCreditNotification(final ProviderCreditDetails details) {
        super(NotificationType.ProviderCreditNotification);
        providerCreditDetails = details;
    }

    /**
     * @return the details for this providerCredit notification
     */
    public ProviderCreditDetails getProviderCreditDetails() {
        return this.providerCreditDetails;
    }

    /**
     * String representation of providerCreditNotificaiton 
     */
    @Override
    public String toString() {
        return "ProviderCreditNotification{" + "providerCreditDetails=" + providerCreditDetails.toString() + '}';
        
    }



}
