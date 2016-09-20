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
 * The name, email address, and phone number of the buyer.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Buyer", propOrder = {
    "name",
    "email",
    "phone"
})
public class Buyer {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Phone")
    protected String phone;

    public Buyer() {
        super();
    }

    /**
     * The name of the buyer. Required.
     * 
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * The email address of the buyer. Required.
     * 
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * The phone number of the buyer. Optional.
     * 
     * @return Phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the string representation of Buyer
     */
    @Override
    public String toString() {
        return "Buyer{" + "name=" + name + ", email=" + email + ", phone=" + phone + '}';
    }


}
