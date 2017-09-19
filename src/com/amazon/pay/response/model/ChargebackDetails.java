/**
 * Copyright 2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
 * Encapsulates details about a Chargeback object and its status.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargebackDetails", propOrder = {
    "amazonChargebackId",
    "amazonOrderReferenceId",
    "amazonCaptureReferenceId",
    "creationTimestamp",
    "chargebackAmount",
    "chargebackState",
    "chargebackReason"
})
public class ChargebackDetails {

    @XmlElement(name = "AmazonChargebackId", required = true)
    protected String amazonChargebackId;

    @XmlElement(name = "AmazonOrderReferenceId", required = true)
    protected String amazonOrderReferenceId;

    @XmlElement(name = "AmazonCaptureReferenceId", required = true)
    protected String amazonCaptureReferenceId;

    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;

    @XmlElement(name = "ChargebackAmount", required = true)
    protected Price chargebackAmount;

    @XmlElement(name = "ChargebackState", required = true)
    protected String chargebackState;

    @XmlElement(name = "ChargebackReason", required = true)
    protected String chargebackReason;

    /**
     * Default constructor
     *
     */
    public ChargebackDetails() {
        super();
    }

    /**
     * The Amazon-generated identifier for this chargeback transaction.
     *
     * @return amazonChargebackId
     */
    public String getAmazonChargebackId() {
        return amazonChargebackId;
    }

    /**
     * The related Amazon Order Reference identifier for this transaction.
     *
     * @return amazonOrderReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * The related Amazon Capture Reference identifier for this transaction.
     *
     * @return amazonCaptureReferenceId
     */
    public String getAmazonCaptureReferenceId() {
        return amazonCaptureReferenceId;
    }

    /**
     * The time at which the order was created. In ISO 8601 format.
     *
     * @return creationTimestamp
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * The amount requested for the chargeback. Type: Price.
     *
     * @return chargebackAmount
     */
    public Price getChargebackAmount() {
        return chargebackAmount;
    }

    /**
     * Represents the status of the chargeback request.
     *
     * @return chargebackStatus
     */
    public String getChargebackState() {
        return chargebackState;
    }

    /**
     * Represents the chargeback dispute reason code:
     * Unauthorized transaction chargeback is the result of an unauthorized charge
     *     and potentially eligible for the Amazon Pay Purchase Protection Policy,
     *     as described in the Customer Agreement.
     * A service chargeback is filed by a customer, which means that you need to note
     *     the card type and dispute reason code so that you can determine which types
     *     of information to submit if you dispute the claim.
     *
     * @return chargebackReason
     */
    public String getChargebackReason() {
        return chargebackReason;
    }

    /**
     * String representation of chargebackDetails
     */
    @Override
    public String toString() {
        return "ChargebackDetails{"
                + "amazonChargebackId=" + amazonChargebackId
                + ", amazonOrderReferenceId=" + amazonOrderReferenceId
                + ", amazonCaptureReferenceId=" + amazonCaptureReferenceId
                + ", creationTimestamp=" + creationTimestamp
                + ", chargebackAmount=" + chargebackAmount
                + ", chargebackState=" + chargebackState
                + ", chargebackReason=" + chargebackReason
                + '}';
    }

}
