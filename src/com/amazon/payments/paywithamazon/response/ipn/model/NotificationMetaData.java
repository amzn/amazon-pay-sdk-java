package com.amazon.payments.paywithamazon.response.ipn.model;

import java.util.Map;

public final class NotificationMetaData {

    private final String type;
    private final String messageId;
    private final String topicArn;
    private final String timeStamp;
    private final String signatureVersion;
    private final String signature;
    private final String signingCertUrl;
    private final String unsubscribeUrl;
    
    public NotificationMetaData(Map<String,String> notificationMap) {
        type = notificationMap.get("Type");
        messageId = notificationMap.get("MessageId");
        topicArn = notificationMap.get("TopicArn");
        timeStamp = notificationMap.get("Timestamp");
        signatureVersion = notificationMap.get("SignatureVersion");
        signature = notificationMap.get("Signature");
        signingCertUrl = notificationMap.get("SigningCertURL");
        unsubscribeUrl = notificationMap.get("UnsubscribeURL");
    }

    /**
     * The type of message. For a notification, the type is Notification.
     * 
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * A Universally Unique Identifier, unique for each message published. 
     * For a message that Amazon SNS resends during a retry, the 
     * message ID of the original message is used.
     * 
     * @return messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * The Amazon Resource Name (ARN) for the topic that this message was published to.
     * 
     * @return topicArn
     */
    public String getTopicArn() {
        return topicArn;
    }

    /**
     * The time (GMT) when the notification was published.
     * 
     * @return timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Version of the Amazon SNS signature used.
     * 
     * @return signatureVersion
     */
    public String getSignatureVersion() {
        return signatureVersion;
    }

    /**
     * Base64-encoded "SHA1withRSA" signature of the Message, MessageId, Type, 
     * Timestamp, and TopicArn values. 
     * 
     * @return signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * The URL to the certificate that was used to sign the message. 
     * 
     * @return signingCertUrl
     */
    public String getSigningCertUrl() {
        return signingCertUrl;
    }

    /**
     * A URL that you can use to unsubscribe the endpoint from this topic. 
     * If you visit this URL, Amazon SNS unsubscribes the endpoint and stops 
     * sending notifications to this endpoint.
     * 
     * @return unsubscribeUrl
     */
    public String getUnsubscribeUrl() {
        return unsubscribeUrl;
    }

    @Override
    public String toString() {
        return "NotificationMetaData{" + "type=" + type + ", messageId=" + messageId 
                + ", topicArn=" + topicArn + ", timeStamp=" + timeStamp + ", signatureVersion=" 
                + signatureVersion + ", signature=" + signature + ", signingCertUrl=" 
                + signingCertUrl + ", unsubscribeUrl=" + unsubscribeUrl + '}';
    }


}
