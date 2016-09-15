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
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", propOrder = {
    "name",
    "addressLine1",
    "addressLine2",
    "addressLine3",
    "city",
    "county",
    "district",
    "stateOrRegion",
    "postalCode",
    "countryCode",
    "phone"
})
public class Address {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "AddressLine1")
    protected String addressLine1;
    @XmlElement(name = "AddressLine2")
    protected String addressLine2;
    @XmlElement(name = "AddressLine3")
    protected String addressLine3;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "County")
    protected String county;
    @XmlElement(name = "District")
    protected String district;
    @XmlElement(name = "StateOrRegion")
    protected String stateOrRegion;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "Phone")
    protected String phone;
    
    public Address() {
        super();
    }

    /**
     * @return The name or business name. Required.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return The first line of the address.
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * 
     * @return The second line of the address.
     */
    public String getAddressLine2() {
        return addressLine2;
    }
    
    /**
     * 
     * @return The third line of the address.
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * 
     * @return Returns the city. Required.
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @return The county. Optional.
     */
    public String getCounty() {
        return county;
    }

    /**
     * 
     * @return The district. Optional.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 
     * @return The state or region. This element is free text and can be 
     * either a 2-character code, fully spelled out, or abbreviated. Required.
     */
    public String getStateOrRegion() {
        return stateOrRegion;
    }

    /**
     * 
     * @return The postal code. Required.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * @return The country code, in ISO 3166 format. Required.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @return The phone number. Optional.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * String representation of Address object
     */
    @Override
    public String toString() {
        return "Address{" + "name=" + name + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 
                + ", addressLine3=" + addressLine3 + ", city=" + city + ", county=" + county + ", district=" 
                + district + ", stateOrRegion=" + stateOrRegion + ", postalCode=" + postalCode + ", countryCode=" 
                + countryCode + ", phone=" + phone + '}';
    }

    
    
}
