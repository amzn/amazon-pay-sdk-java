package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Indicates mandatory information that is missing or incorrect in a Billing Agreement object or an Order Reference object.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Constraint", propOrder = {
    "constraintID",
    "description"
})
public class Constraint {

    @XmlElement(name = "ConstraintID")
    protected String constraintID;
    @XmlElement(name = "Description")
    protected String description;

    public Constraint() {
        super();
    }

    /**
     * The identifier of the constraint. For more information, see Billing Agreement Constraints or Order Reference Constraints.
     * 
     * @return constraintID
     */
    public String getConstraintID() {
        return constraintID;
    }

    /**
     * The description of the constraint. For more information, see Billing Agreement Constraints or Order Reference Constraints.
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }


}
