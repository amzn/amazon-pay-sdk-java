package com.amazon.payments.paywithamazon.response.model;

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
    "lastUpdatedTimestamp",
    "reasonCode",
    "reasonDescription"
})
public class BillingAgreementStatus {

    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "LastUpdatedTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdatedTimestamp;
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

}
