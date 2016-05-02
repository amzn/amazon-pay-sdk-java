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

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Interface for metadata relating to a single notification.
 * There can be multiple notification metadata objects for a single message,
 * each relating to a single container for the request object.
 */
@XmlJavaTypeAdapter(NotificationMetadata.Adapter.class)
public interface INotificationMetadata {
    /**
     * @return the type of the implementation notification metadata
     */
    NotificationMetadataType getNotificationMetadataType();

    /**
     * @return A reference to the parent notification metadata type
     * if defined, otherwise null
     */
    INotificationMetadata getParentNotificationMetadata();
}
