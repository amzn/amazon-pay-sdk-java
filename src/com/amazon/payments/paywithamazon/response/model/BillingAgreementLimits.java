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
package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Represents the total amount that you can charge a buyer in a given time period.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingAgreementLimits", propOrder = {
    "amountLimitPerTimePeriod",
    "timePeriodStartDate",
    "timePeriodEndDate",
    "currentRemainingBalance"
})
public class BillingAgreementLimits {

    @XmlElement(name = "AmountLimitPerTimePeriod")
    protected Price amountLimitPerTimePeriod;
    @XmlElement(name = "TimePeriodStartDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timePeriodStartDate;
    @XmlElement(name = "TimePeriodEndDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timePeriodEndDate;
    @XmlElement(name = "CurrentRemainingBalance")
    protected Price currentRemainingBalance;


    public BillingAgreementLimits() {
        super();
    }


    /**
     * The maximum amount that can be charged on a billing agreement in the 
     * time period defined by TimePeriodStartDate and TimePeriodEndDate.
     * Type: Price
     * 
     * @return amountLimitPerTimePeriod
     */
    public Price getAmountLimitPerTimePeriod() {
        return amountLimitPerTimePeriod;
    }


    /**
     * The start date of the period during which the AmountLimitPerTimePeriod applies.
     * 
     * @return timePeriodStartDate
     */
    public XMLGregorianCalendar getTimePeriodStartDate() {
        return timePeriodStartDate;
    }

    /**
     * The end date of the period during which the AmountLimitPerTimePeriod applies.
     * 
     * @return timePeriodEndDate
     */
    public XMLGregorianCalendar getTimePeriodEndDate() {
        return timePeriodEndDate;
    }

    /**
     * The remaining balance that can be charged in the current time period. Type: Price
     * 
     * @return currentRemainingBalance
     */
    public Price getCurrentRemainingBalance() {
        return currentRemainingBalance;
    }

    /**
     * Returns the string representation of BillingAgreementLimits
     */
    @Override
    public String toString() {
        return "BillingAgreementLimits{" + "amountLimitPerTimePeriod=" + amountLimitPerTimePeriod 
                + ", timePeriodStartDate=" + timePeriodStartDate + ", timePeriodEndDate=" + timePeriodEndDate 
                + ", currentRemainingBalance=" + currentRemainingBalance + '}';
    }


}
