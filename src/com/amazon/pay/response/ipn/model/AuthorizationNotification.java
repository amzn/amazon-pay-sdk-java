/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.response.ipn.model;

import com.amazon.pay.response.model.AuthorizationDetails;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ipn", propOrder = {
        "authorizationDetails"
})
@XmlRootElement(name = "AuthorizationNotification")

public class AuthorizationNotification extends Notification {

    /**
     * Authorization details field.
     */
    @XmlElement(name = "AuthorizationDetails", required = true)
    protected AuthorizationDetails authorizationDetails;

    /**
     * Creates a new instance of the authorization notification.
     */
    public AuthorizationNotification() {
       super(NotificationType.AuthorizationNotification);
    }

    /**
     * Value constructor
     *
     */
    public AuthorizationNotification(final AuthorizationDetails authorizationDetails) {
        super(NotificationType.AuthorizationNotification);
        this.authorizationDetails = authorizationDetails;
    }

    /**
     * Gets the value of the authorizationDetails property.
     *
     * @return authorizationDetails
     *
     */
    public AuthorizationDetails getAuthorizationDetails() {
        return this.authorizationDetails;
    }

    /**
     * String representation of authorization notification
     */
    @Override
    public String toString() {
        return "AuthorizationNotification{"
                + "authorizationDetails=" + authorizationDetails.toString() + '}';
    }

}
