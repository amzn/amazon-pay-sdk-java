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
package com.amazonservices.mws.offamazonpaymentsipn.notifications;

import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.INotificationMetadata;

/**
 * Abstract implementation of the notification interface encapsulates 
 * the common properties of all notifications
 */
public abstract class Notification extends INotification {

    /**
     * Metadata associated with this notification
     */
    private INotificationMetadata notificationMetadata;
    
    /**
     * The type of notification
     */
    private NotificationType notificationType;
    
    /** To make JaxB happy
     *  Should not be use anywhere else
     */
    public Notification() {
    }
    
    /**
     * Create a new typed notification instance
     * @param type Notification type
     */
    protected Notification(NotificationType type) {
        notificationMetadata = null;
        notificationType = type;
    }
    
    /**
     * Indicates what type of notification is implementing this interface
     */
    public NotificationType getNotificationType() {
        return notificationType;
    }
    
    public INotificationMetadata getNotificationMetadata() {
        return notificationMetadata;
    }
    
    public void setNotificationMetadata(INotificationMetadata metadata) {
        notificationMetadata = metadata;
    }
}
