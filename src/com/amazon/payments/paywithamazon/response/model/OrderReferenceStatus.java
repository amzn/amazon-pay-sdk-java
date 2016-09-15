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
 * Indicates the current status of an Order Reference object.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderReferenceStatus", propOrder = {
    "state",
    "lastUpdateTimestamp",
    "reasonCode",
    "reasonDescription"
})
public class OrderReferenceStatus {

    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "LastUpdateTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateTimestamp;
    @XmlElement(name = "ReasonCode")
    protected String reasonCode;
    @XmlElement(name = "ReasonDescription")
    protected String reasonDescription;

    public OrderReferenceStatus() {
        super();
    }

    /**
     * Indicates the state that the Order Reference object is in. For more 
     * information, see Order Reference States and Reason Codes.
     * 
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * A timestamp that indicates the time when the order reference state 
     * was last updated. Optional if the order reference 
     * is in the Draft state.
     * 
     * @return lastUpdateTimestamp
     */
    public XMLGregorianCalendar getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    /**
     * Optional if the order reference is in the Draft state. For more information, 
     * see Order Reference States and Reason Codes.
     * 
     * @return reasonCode
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * An optional description of the order reference status.
     * @return reasonDescription
     */
    public String getReasonDescription() {
        return reasonDescription;
    }

    @Override
    public String toString() {
        return "OrderReferenceStatus{" + "state=" + state + ", lastUpdateTimestamp=" + lastUpdateTimestamp 
                + ", reasonCode=" + reasonCode + ", reasonDescription=" + reasonDescription + '}';
    }


}
