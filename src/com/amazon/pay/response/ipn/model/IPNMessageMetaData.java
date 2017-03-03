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

import java.util.Map;

public final class IPNMessageMetaData {

    private final String releaseEnvironment;
    private final String timeStamp;
    private final String notificationReferenceId;
    private final String sellerId;
    private final String version;

    public IPNMessageMetaData(Map<String,String> messageMetaDataMap) {
        releaseEnvironment = messageMetaDataMap.get("ReleaseEnvironment");
        timeStamp = messageMetaDataMap.get("Timestamp");
        notificationReferenceId = messageMetaDataMap.get("NotificationReferenceId");
        sellerId = messageMetaDataMap.get("SellerId");
        version = messageMetaDataMap.get("Version");
    }

    /**
     * Returns the environment LIVE or SANDBOX
     *
     * @return Returns the environment LIVE or SANDBOX
     */
    public String getReleaseEnvironment() {
        return releaseEnvironment;
    }

    /**
     * Returns the timeStamp of IPN Message
     *
     * @return Returns the timeStamp of IPN Message
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Returns the notification referenceId specified in IPN message
     *
     * @return Returns the notification referenceId specified in IPN message
     */
    public String getNotificationReferenceId() {
        return notificationReferenceId;
    }

    /**
     * Returns the sellerId specified in IPN Message
     *
     * @return Returns the sellerId specified in IPN Message
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Returns the version specified in IPN message
     *
     * @return Returns the version specified in IPN message
     */
    public String getVersion() {
        return version;
    }

    /**
     * String representation of IPN Message Metadata
     *
     */
    @Override
    public String toString() {
        return "IPNMessageMetaData{"
                + "releaseEnvironment=" + releaseEnvironment
                + ", timeStamp=" + timeStamp
                + ", notificationReferenceId=" + notificationReferenceId
                + ", sellerId=" + sellerId
                + ", version=" + version + '}';
    }

}
