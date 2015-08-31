package PayWithAmazon.IPN;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
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
    
    public static void main (String args[]) {
        IPNMessage ipn = new IPNMessage(
 "{  \"Type\" : \"Notification\",  \"MessageId\" : \"33bd40e3-6a9a-58cf-b6be-0eb9ca6bc4e9\",  \"TopicArn\" : \"arn:aws:sns:us-east-1:291180941288:A3BXB0YN3XH17HA2K7NDRCTOTPW9\",  \"Message\" : \"{\\\"MarketplaceID\\\":\\\"A3BXB0YN3XH17H\\\",\\\"ReleaseEnvironment\\\":\\\"Sandbox\\\",\\\"Version\\\":\\\"2013-01-01\\\",\\\"NotificationType\\\":\\\"PaymentCapture\\\",\\\"SellerId\\\":\\\"A2K7NDRCTOTPW9\\\",\\\"NotificationReferenceId\\\":\\\"1111111-1111-11111-1111-11111EXAMPLE\\\",\\\"IsSample\\\":true,\\\"Timestamp\\\":\\\"2015-08-28T17:47:29.215Z\\\",\\\"NotificationData\\\":\\\"<?xml version=\\\\\\\"1.0\\\\\\\" encoding=\\\\\\\"UTF-8\\\\\\\"?>\\\\n        <CaptureNotification xmlns=\\\\\\\"https://mws.amazonservices.com/ipn/OffAmazonPayments/2013-01-01\\\\\\\">\\\\n            <CaptureDetails>\\\\n                <AmazonCaptureId>P01-0000000-0000000-000000<\\\\/AmazonCaptureId>\\\\n                <CaptureReferenceId>P01-0000000-0000000-000000<\\\\/CaptureReferenceId>\\\\n                <CaptureAmount>\\\\n                    <Amount>0.0<\\\\/Amount>\\\\n                    <CurrencyCode>USD<\\\\/CurrencyCode>\\\\n                <\\\\/CaptureAmount>\\\\n                <RefundedAmount>\\\\n                    <Amount>0.0<\\\\/Amount>\\\\n                    <CurrencyCode>USD<\\\\/CurrencyCode>\\\\n                <\\\\/RefundedAmount>\\\\n                <CaptureFee>\\\\n                    <Amount>0.0<\\\\/Amount>\\\\n                    <CurrencyCode>USD<\\\\/CurrencyCode>\\\\n                <\\\\/CaptureFee>\\\\n                <IdList />\\\\n                <CreationTimestamp>2013-01-01T01:01:01.001Z<\\\\/CreationTimestamp>\\\\n                <CaptureStatus>\\\\n                    <State>Completed<\\\\/State>    \\\\n                    <LastUpdateTimestamp>2013-01-01T01:01:01.001Z<\\\\/LastUpdateTimestamp>\\\\n                    <ReasonCode>None<\\\\/ReasonCode>\\\\n                <\\\\/CaptureStatus>\\\\n                <SoftDescriptor>AMZ*softDescriptor<\\\\/SoftDescriptor>\\\\n                <\\\\/CaptureDetails>\\\\n        <\\\\/CaptureNotification>\\\"}\",  \"Timestamp\" : \"2015-08-28T17:47:29.280Z\",  \"SignatureVersion\" : \"1\",  \"Signature\" : \"eUInUlaydzV4eoOcSKHSyNqt9yFAa1r0kFQz2PxXlNV4Ik04pYRyZlgbXy5NdhzdRzGKwIlPG8QcL2HlNe7nFkKecQapQZYmI7cWpvEslO/xrJgP6jTH5j18Xkk7/lmhV79wgwIWjT7LtbMrc3jC7QNDqwiNcRT694WKpFx1+PFa4BdUd0cUCyPLQrWFcNpS0z8fcaERqO98BUZkkPVfwWA7bQhIwQnxJNVzL9dFxWAhs98W7N89/8yEEg7nz/OK0hr9vfaT0P7ZGCYNsrDlwooGbhtJlhj2aLjfFwR91P7h5cK20nx3eBgN3Nen6BXU1jqnz7plA3QVuygzRIUJmA==\",  \"SigningCertURL\" : \"https://sns.us-east-1.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem\",  \"UnsubscribeURL\" : \"https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:us-east-1:291180941288:A3BXB0YN3XH17HA2K7NDRCTOTPW9:05542723-375e-4609-98f1-8abcf427d95f\"}");
        try {
            System.out.println(IPNUtility.isMessageSignatureValid(ipn));
            System.out.println();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public IPNMessage( String ipnPostPayload ) {
        this.ipnDataJson = ipnPostPayload;
        parse(this.ipnDataJson);
        System.out.println(this.ipnDataMap);
      
    }
    
    public Map<String,String> getIpnDataAsMap() {
        return ipnDataMap;
    }
    
    public String getIpnDataAsJSON() {
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
         Map<String,String> notificationDataMap = convertJsonToMap(jsonNotificationData);   
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
            messageDataMap = convertJsonToMap(message);
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
        
    private Map<String,String> convertJsonToMap(String notificationDataJson) {
       Map<String,String> notificationDataMap = new HashMap<String,String>();
       Gson gson = new Gson();
       notificationDataMap = (Map<String,String>) gson.fromJson( notificationDataJson , notificationDataMap.getClass());
       return notificationDataMap;
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
