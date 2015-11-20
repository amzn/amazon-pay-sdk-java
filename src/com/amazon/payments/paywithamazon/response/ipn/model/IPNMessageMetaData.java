package com.amazon.payments.paywithamazon.response.ipn.model;

import java.util.Map;

public final class IPNMessageMetaData {

    private String releaseEnvironment;
    private String timeStamp;
    private String notificationReferenceId;
    private String sellerId;
    private String version;
    
    public IPNMessageMetaData(Map<String,String> messageMetaDataMap) {
        releaseEnvironment = messageMetaDataMap.get("ReleaseEnvironment");
        timeStamp = messageMetaDataMap.get("Timestamp");
        notificationReferenceId = messageMetaDataMap.get("NotificationReferenceId");
        sellerId = messageMetaDataMap.get("SellerId");
        version = messageMetaDataMap.get("Version");

    }

    public String getReleaseEnvironment() {
        return releaseEnvironment;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getNotificationReferenceId() {
        return notificationReferenceId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "IPNMessageMetaData{" + "releaseEnvironment=" + releaseEnvironment + ", timeStamp=" + timeStamp + ", notificationReferenceId=" + notificationReferenceId + ", sellerId=" + sellerId + ", version=" + version + '}';
    }



}
