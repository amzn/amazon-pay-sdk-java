package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingAddress", propOrder = {
    "addressType",
    "physicalAddress"
})
public class BillingAddress {

    @XmlElement(name = "AddressType")
    protected String addressType;
    @XmlElement(name = "PhysicalAddress")
    protected Address physicalAddress;

    public BillingAddress() {
        super();
    }

    /**
     * 
     * @return Returns the address type
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * 
     * @return Returns the physical address
     */
    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    /**
     * Returns the string representation of BillingAddress
     */
    @Override
    public String toString() {
        return "BillingAddress{" + "addressType=" + addressType + ", physicalAddress=" + physicalAddress.toString() + '}';
    }


}