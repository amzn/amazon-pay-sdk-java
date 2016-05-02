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
package com.amazonservices.mws.offamazonpaymentsipn.parsers;

import java.util.Map;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.SnsNotificationMetadata;

/**
 * Class to convert a json string into a message.
 * that corresponds to an sns notification
 */
public class SnsNotificationParser {
    /**
     * Error string for unknown notification type.
     */
    private static final String UNEXPECTED_MESSAGE_ERR_STR
            = "Error with sns notification - unexpected message with Type of %s";

    /**
     * Error string for missing sns header.
     */
    private static final String MISSING_SNS_HEADER_ERR_STR
            = "Error with message - header does not contain x-amz-sns-message-type";

    /**
     * Error string for invalid sns header.
     */
    private static final String INVALID_SNS_HEADER_ERR_STR
            = "Error with sns message - header x-amz-sns-message-type has value %s, expected Notification";

    /** 
     * Error string for null header object.
     */
    private static final String MISSING_HEADERS_ERR_STR = "Expected headers to be passed, null value received";
    
    private static final String SNS_HEADER = "x-amz-sns-message-type";
    
    private static final String SNS_HEADER_TYPE_NAME = "Type";
    
    private static final String SNS_HEADER_TYPE_NOTIFICATION = "Notification";
    
    /**
     * Parse a json string in an sns format and convert it into a message.
     * object that stores key/value pairs
     * @param headers Sns headers
     * @param snsJson Sns json string
     * @return A Message object containing the message
     * @throws NotificationsException
     */
    public Message parseNotification(final Map<String, String> headers, final String snsJson) throws NotificationsException {
        validateHeaders(headers);
        Message msg = new Message(snsJson);
        validateMessageType(msg);
        addSnsNotificationMetadataToMessage(msg);
        return msg;
    }

    /**
     * Check the sns headers to ensure that the notification is valid.
     * @param headers Sns header
     * @throws NotificationsException exception if header does not exists, value is null, or value is not 'Notification"
     */
    private void validateHeaders(final Map<String, String> headers) throws NotificationsException {
        if (headers == null) {
            throw new NotificationsException(MISSING_HEADERS_ERR_STR);
        }

        if (!headers.containsKey(SNS_HEADER)) {
            throw new NotificationsException(MISSING_SNS_HEADER_ERR_STR);
        }

        String messageType = null;
        messageType = headers.get(SNS_HEADER);

        if (messageType == null) {
            throw new NotificationsException(MISSING_SNS_HEADER_ERR_STR);
        }

        if (!messageType.equalsIgnoreCase(SNS_HEADER_TYPE_NOTIFICATION)) {
            throw new NotificationsException(String.format(INVALID_SNS_HEADER_ERR_STR, messageType));
        }
    }

    /**
     * Ensure that the sns message is the valid notification type.
     * @param msg Sns message
     * @throws NotificationsException exception if Type field is not 'Notification'
     */
    private void validateMessageType(final Message msg) throws NotificationsException {
        String notificationType = msg.getMandatoryField(SNS_HEADER_TYPE_NAME);

        if (!notificationType.equalsIgnoreCase(SNS_HEADER_TYPE_NOTIFICATION)) {
            throw new NotificationsException(String.format(UNEXPECTED_MESSAGE_ERR_STR, notificationType));
        }
    }

    /**
     * Add the notification metadata to the message.
     * @param msg Message to add notification metadata to
     * @throws NotificationsException
     */
    private void addSnsNotificationMetadataToMessage(final Message msg) throws NotificationsException {
        msg.setMetadata(new SnsNotificationMetadata(msg));
    }
}
