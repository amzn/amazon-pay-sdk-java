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

import com.amazon.pay.response.model.CaptureDetails;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An IPN notification to indicate a change in status for 
 * a capture transaction notification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "captureDetails"
})
@XmlRootElement(name="CaptureNotification")
public class CaptureNotification extends Notification   {

    /**
     * Capture details.
     */
    @XmlElement(name="CaptureDetails", required = true)
    private CaptureDetails captureDetails;

    /**
     * Creates a new instance of the capture notification.
     */
    public CaptureNotification() {
        super(NotificationType.CaptureNotification);
    }

    public CaptureNotification(final CaptureDetails details) {
        super(NotificationType.CaptureNotification);
        captureDetails = details;
    }

    /**
     * @return the details for this capture notification
     */
    public CaptureDetails getCaptureDetails() {
        return this.captureDetails;
    }

    /**
     * String representation of Capture Notification
     */
    @Override
    public String toString() {
        return "CaptureNotification{" + "captureDetails=" + captureDetails.toString() + '}';
    }
    
    
}
