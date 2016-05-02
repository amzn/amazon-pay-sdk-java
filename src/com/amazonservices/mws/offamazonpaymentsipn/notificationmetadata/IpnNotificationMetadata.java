/*******************************************************************************
 *  Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * *****************************************************************************
 */
package com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata;

import java.util.Date;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;

/**
 * Notification metadata for the ipn message.
 */
public class IpnNotificationMetadata extends NotificationMetadata {

    /**
     * Timestamp for when the notification was generated.
     */
    private Date timestamp;

    /**
     * Environment in which the notification was generated.
     */
    private String releaseEnvironment;

    /**
     * Identification for the reference id.
     */
    private String notificationReferenceId;

    /**
     * Creates a new ipn notification metadata object from an ipn message.
     * @param ipnMessage message conforming to ipn structure
     * @param parentNotificationMetadata parent notification metadata
     * @throws NotificationsException
     */
    public IpnNotificationMetadata( Message ipnMessage, INotificationMetadata parentNotificationMetadata) throws NotificationsException {
        super(parentNotificationMetadata);
        timestamp = ipnMessage.getMandatoryFieldAsDate("Timestamp");
        releaseEnvironment = ipnMessage.getMandatoryField("ReleaseEnvironment");
        notificationReferenceId = ipnMessage.getMandatoryField("NotificationReferenceId");
    }

    /**
     * @return timestamp for the ipn request
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @return Notification reference id for the ipn request
     */
    public String getNotificationReferenceId() {
        return notificationReferenceId;
    }

    /**
     * Release environment for the ipn request.
     * @return release environment
     */
    public String getReleaseEnvironment() {
        return releaseEnvironment;
    }

    /**
     * Indicated the type of notification metadata.
     * @return IPN for IPN notification metadata
     */
    @Override
    protected NotificationMetadataType getSpecificNotificationMetadataType() {
        return NotificationMetadataType.Ipn;
    }

}
