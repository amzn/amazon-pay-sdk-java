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
