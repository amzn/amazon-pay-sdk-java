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
package com.amazon.pay.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Indicates the current status of a Billing Agreement object.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingAgreementStatus", propOrder = {
    "state",
    "lastUpdatedTimestamp", // used in real-time responses
    "lastUpdateTimestamp",  // used in IPN responses, probably due to an error in IPN code
    "reasonCode",
    "reasonDescription"
})
public class BillingAgreementStatus {

    @XmlElement(name = "State")
    protected String state;

    @XmlElement(name = "LastUpdatedTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdatedTimestamp;

    @XmlElement(name = "LastUpdateTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateTimestamp;

    @XmlElement(name = "ReasonCode")
    protected String reasonCode;

    @XmlElement(name = "ReasonDescription")
    protected String reasonDescription;

    public BillingAgreementStatus() {
        super();
    }

    /**
     * Indicates the state that the Billing Agreement object is in.
     * For more information, see Billing Agreement States and Reason Codes.
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * A timestamp that indicates the time when the billing agreement state was
     * last updated. In ISO 8601 format. Optional if the order reference is in
     * the Draft state.
     *
     * @return lastUpdatedTimestamp
     */
    public XMLGregorianCalendar getLastUpdatedTimestamp() {
        if (lastUpdateTimestamp != null)
            return lastUpdateTimestamp;
        else
            return lastUpdatedTimestamp;
    }

    /**
     * Optional if the billing agreement is in the Draft state.
     * For more information, see Billing Agreement States and Reason Codes.
     *
     * @return reasonCode
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * An optional description of the billing agreement status.
     *
     * @return reasonDescription
     */
    public String getReasonDescription() {
        return reasonDescription;
    }

    /**
     * Returns the string representation of BillingAgreementStatus
     */
    @Override
    public String toString() {
        return "BillingAgreementStatus{"
                + "state=" + state
                + ", lastUpdatedTimestamp=" + getLastUpdatedTimestamp()
                + ", reasonCode=" + reasonCode
                + ", reasonDescription=" + reasonDescription
                + '}';
    }

}
