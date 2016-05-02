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

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Parent class for common functionality across all notification metadata
 * implementations.
 */
public abstract class NotificationMetadata implements INotificationMetadata {
    /**
     * Parent notification metadata if applicable, otherwise null.
     */
    private INotificationMetadata parentNotificationMetadata = null;
    
    /**
     * Initializes the common fields of the parent class.
     * Overloaded constructs should call this.
     */
    public NotificationMetadata() {
    }
    
    /**
     * Extend the base constructor and initialize the parent 
     * notification metadata parameter.
     * @param parentNotificationMetadata parent message information, null if not applicable
     */
    public NotificationMetadata(final INotificationMetadata parentNotificationMetadata) {
        this.parentNotificationMetadata = parentNotificationMetadata;
    }

    /**
     * @return a reference to the parent notification metadata type if defined,
     * otherwise null
     */
    public INotificationMetadata getParentNotificationMetadata() {
        return parentNotificationMetadata;
    }

    /**
     * @return the type of the implementation notification metadata
     */
    public NotificationMetadataType getNotificationMetadataType() {
        return getSpecificNotificationMetadataType();
    }

    /**
     * @return the type of the implementation notification metadata
     */
    protected abstract NotificationMetadataType getSpecificNotificationMetadataType();
    
    /**
     * The adapter class allows JAXB to marshal/unmarshal an instance of INotificationMetadata interface,
     * since the JAXB itself is unable to handle polymorphic types.
     */
    static class Adapter extends XmlAdapter<NotificationMetadata, INotificationMetadata> {
	
		@Override
		public NotificationMetadata marshal(INotificationMetadata v) {
			return (NotificationMetadata)v;
		}
		
		@Override
		public INotificationMetadata unmarshal(NotificationMetadata v) {
			return v;
		}

    }
}
