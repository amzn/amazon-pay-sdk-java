package PayWithAmazon.IPN;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map; 

/**
 * Helper class to parse the Instant Payment Notifications.
 */
public class IPNMessage {
    

    String type, messageId, topicArn, message, timestamp, signature, signatureVersion, signingCertURL, 
           unsubscribeURL, notificationType, sellerId, environment, version, notificationData, messageTimeStamp;
    
    String ipnDataJson;
    Map<String,String> ipnDataMap;
    
    public boolean isNotificationValid;

    public IPNMessage( String ipnPostPayload ) {
        this.ipnDataJson = ipnPostPayload;
        parse(this.ipnDataJson);      
    }
    
    public Map<String,String> getIpnMessageAsMap() {
        return ipnDataMap;
    }
    
    public String getIpnMessageAsJSON() {
        return ipnDataJson;
    }

    public String getType() {
        return type;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getTopicArn() {
        return topicArn;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSignatureVersion() {
        return signatureVersion;
    }

    public String getSigningCertURL() {
        return signingCertURL;
    }

    public String getUnsubscribeURL() {
        return unsubscribeURL;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getVersion() {
        return version;
    }

    public String getNotificationData() {
        return notificationData;
    }

    public String getMessageTimeStamp() {
        return messageTimeStamp;
    }
    
    public String getSignature() {
        return signature;
    }
    
    private void parse ( String jsonNotificationData ) {
         Map<String,String> notificationDataMap = IPNUtility.convertJsonToMap(jsonNotificationData);   
         type = notificationDataMap.get("Type");
         messageId = notificationDataMap.get("MessageId");
         topicArn = notificationDataMap.get("TopicArn");
         message = notificationDataMap.get("Message");
         timestamp = notificationDataMap.get("Timestamp"); 
         signature = notificationDataMap.get("Signature"); 
         signatureVersion = notificationDataMap.get("SignatureVersion"); 
         signingCertURL = notificationDataMap.get("SigningCertURL"); 
         unsubscribeURL = notificationDataMap.get("UnsubscribeURL"); 
         version = notificationDataMap.get("Version");
         ipnDataMap = new HashMap<String,String>();
         ipnDataMap.putAll(notificationDataMap);
        
         Map<String,String> messageDataMap = null;
         if (message != null) { 
            messageDataMap = IPNUtility.convertJsonToMap(message);
            if (messageDataMap != null) { 
                notificationType = messageDataMap.get("NotificationType");
                sellerId = messageDataMap.get("SellerId");
                notificationData = messageDataMap.get("NotificationData");
                environment = messageDataMap.get("ReleaseEnvironment");
                messageTimeStamp = messageDataMap.get("Timestamp");
            }
         }
         ipnDataMap.putAll(messageDataMap);
    }
    
    public boolean isNotificationValid() {
        return IPNUtility.isMessageSignatureValid(this);
    }
    
    public void writeNotificationsToFile(String filePath) {
        try {
    		//true = append file
    		FileWriter fileWritter = new FileWriter(filePath , true);
                fileWritter.write( ipnDataJson + "\n" );
                fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
}
