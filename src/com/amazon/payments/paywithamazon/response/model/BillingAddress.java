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

    public String getAddressType() {
        return addressType;
    }

    public Address getPhysicalAddress() {
        return physicalAddress;
    }


}