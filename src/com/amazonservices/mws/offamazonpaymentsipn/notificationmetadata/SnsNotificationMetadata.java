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
 * Metadata associated with an sns message
 */
public class SnsNotificationMetadata extends NotificationMetadata {

    /**
     * Timestamp for when this notification was generated
     */
    private Date timestamp;
    
    /**
     * Topic that the notification was generated from
     */
    private String topicArn;
    
    /**
     * Message id for the notification
     */
    private String messageId;
    
    /**
     * Create a new instance of the SnsNotificationMetadata from a 
     * message conforming to the sns message structure
     * @param msg Message conforming to the sns message structure
     * @throws NotificationsException if field does not exist
     */
    public SnsNotificationMetadata(Message msg) throws NotificationsException {
        timestamp = msg.getMandatoryFieldAsDate("Timestamp");
        topicArn = msg.getMandatoryField("TopicArn");
        messageId = msg.getMandatoryField("MessageId");
    }
    
    /**
     * @return the timestamp for the sns notification
     */
    public Date getTimestamp() {
        return timestamp;
    }
    
    /**
     * @return Topic ARN that this sns notification was published to
     */
    public String getTopicArn() {
        return topicArn;
    }
    
    /**
     * @return Message id for the sns message
     */
    public String getMessageId() {
        return messageId;
    }
    
    /**
     * Indicates the type of notification metadata
     * @return sns for the SNSNotificationMetadata
     */
    @Override
    protected NotificationMetadataType getSpecificNotificationMetadataType() {
        return NotificationMetadataType.Sns;
    }

}
