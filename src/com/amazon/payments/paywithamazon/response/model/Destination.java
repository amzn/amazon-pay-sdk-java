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

/**
 * Represents the address selected by the buyer through the AddressBook widget.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Destination", propOrder = {
    "destinationType",
    "physicalDestination"
})
public class Destination {

    @XmlElement(name = "DestinationType")
    protected String destinationType;
    @XmlElement(name = "PhysicalDestination")
    protected Address physicalDestination;

    public Destination() {
        super();
    }

    /**
     * Returns destination type. Allowed value: Physical
     * 
     * @return destinationType
     */
    public String getDestinationType() {
        return destinationType;
    }

    /**
     * The address of the destination. Type: Address
     * 
     * @return physicalDestination
     */
    public Address getPhysicalDestination() {
        return physicalDestination;
    }

    @Override
    public String toString() {
        return "Destination{" + "destinationType=" + destinationType + ", physicalDestination=" + physicalDestination.toString() + '}';
    }

    
}
