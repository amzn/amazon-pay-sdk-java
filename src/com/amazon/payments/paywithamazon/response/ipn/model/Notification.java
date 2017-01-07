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
package com.amazon.payments.paywithamazon.response.ipn.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)
/**
 * Abstract implementation of the notification interface encapsulates
 * the common properties of all notifications
 */
public abstract class Notification {

    /**
     * Metadata associated with this notification
     */
    private NotificationMetaData notificationMetadata;
    private IPNMessageMetaData messageMetadata;

    /**
     * Notification in JSON representation
     */
    private String notificationAsJSON;

    /**
     * Notification values stored in Map
     */
    private Map<String,String> notificationAsMap;

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
        this.notificationType = type;
    }

    /*
     * Indicates what type of notification is implementing this interface
    */
    public NotificationType getNotificationType() {
        return notificationType;
    }

    /**
     * Returns the metadata associated with the notification
     *
     * @return notificationMetadata
     */
    public NotificationMetaData getNotificationMetadata() {
        return notificationMetadata;
    }

    /**
     * Setter method for notificationMetaData
     * @param metadata
     */
    public void setNotificationMetadata(NotificationMetaData metadata) {
        notificationMetadata = metadata;
    }

    /**
     * Setter method for notification JSON
     * @param json
     */
    public void setJSON(String json) {
        notificationAsJSON = json;
    }

    /**
     * Returns the notification in JSON format
     *
     * @return notificationAsJSON
     */
    public String toJSON() {
        return notificationAsJSON;
    }

    /**
     * Setter for notificationMap
     *
     * @param map
     */
    public void setMap(Map<String,String> map) {
        notificationAsMap = map;
    }

    /**
     * Returns the notification values as a Map datastructure
     *
     * @return notificationAsMap
     */
    public Map<String,String> toMap() {
        return notificationAsMap;
    }

    /**
     * Setter for IPN MessageMetadata
     *
     * @param ipnMessageMetaData
     */
    public void setMessageMetaData(IPNMessageMetaData ipnMessageMetaData) {
        messageMetadata = ipnMessageMetaData;
    }

    /**
     * Returns the notification message metadata
     *
     * @return messageMetadata
     */
    public IPNMessageMetaData getMessageMetadata() {
        return messageMetadata;
    }

    /**
     * Returns the string representation of Notification
     * @return
     */
    @Override
    public String toString() {
        return "Notification{"
                + "notificationMetadata=" + notificationMetadata
                + ", messageMetadata=" + messageMetadata
                + ", notificationAsJSON=" + notificationAsJSON
                + ", notificationAsMap=" + notificationAsMap
                + ", notificationType=" + notificationType + '}';
    }

}
