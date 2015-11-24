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
