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
 * Interface for a single parsed notification
 */
public abstract class INotification {
    /**
     * @return Reference to the metadata that 
     * is associated with this notification
     */
    public abstract INotificationMetadata getNotificationMetadata();
    
    /**
     * @return Indicates what type of notification 
     * is implementing this interface
     */
    public abstract NotificationType getNotificationType();
}
