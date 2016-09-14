package com.amazon.payments.paywithamazon.impl.ipn;

import com.amazon.payments.paywithamazon.exceptions.AmazonClientException;
import com.amazon.payments.paywithamazon.impl.PaymentsLogUtil;
import com.amazon.payments.paywithamazon.response.ipn.model.AuthorizationNotification;
import com.amazon.payments.paywithamazon.response.ipn.model.BillingAgreementNotification;
import com.amazon.payments.paywithamazon.response.ipn.model.CaptureNotification;
import com.amazon.payments.paywithamazon.response.ipn.model.IPNMessageMetaData;
import com.amazon.payments.paywithamazon.response.ipn.model.Notification;
import com.amazon.payments.paywithamazon.response.ipn.model.NotificationMetaData;
import com.amazon.payments.paywithamazon.response.ipn.model.OrderReferenceNotification;
import com.amazon.payments.paywithamazon.response.ipn.model.ProviderCreditNotification;
import com.amazon.payments.paywithamazon.response.ipn.model.ProviderCreditReversalNotification;
import com.amazon.payments.paywithamazon.response.ipn.model.RefundNotification;
import com.amazon.payments.paywithamazon.response.ipn.model.SolutionProviderMerchantNotification;
import com.google.gson.Gson;

import java.io.StringReader;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.helpers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class NotificationFactory {

    public static PaymentsLogUtil payUtil = new PaymentsLogUtil();

    /**
     * Convert a raw HTTP POST request that contains an IPN to convert
     * to an Notification object.  With each notification you receive, you
     * should configure your endpoint to send Amazon a "200 OK" response.
     *
     * If an exception is thrown by this method, it is desirable to
     * return a 503 HTTP code. This way Amazon SNS will perform retry notification
     * every hour for 14 days".
     *
     * @param headers HTTP POST request headers
     * @param body HTTP POST body content
     * @return Instance of an Notification that matches the notification type
     *
     * @throws AmazonClientException
     *
     */
    public static Notification parseNotification(Map<String,String> headers , final String body ) throws AmazonClientException{

        NotificationVerification verifier = new NotificationVerification();

        //verify notification header values
        verifier.verifyHeaders( headers );

        //log headers to the console.
        try {
            payUtil.logMessage("Notification Header: " + headers.toString());
        } catch(Exception e){
            throw new AmazonClientException("Encountered an Exception: " ,e);
        }

        //parse notification
        Notification notification = NotificationFactory.getNotification(body);

        //log notification body contents to the console.
        try {
            payUtil.logMessage("Notification Body: " + body);
        } catch(Exception e){
            throw new AmazonClientException("Encountered an Exception: " ,e);
        }

        //verify validity of notification using signature, type and signingCertURL fields.
        verifier.verifyMessage(notification);

        //If all verification succeeds, notification container object is returned.
        return notification;
    }


    private static Notification getNotification(String payLoad)  {
        com.amazon.payments.paywithamazon.response.ipn.model.Notification notifData = null;
        if(payLoad == null || payLoad.isEmpty()) {
            throw new AmazonClientException("Aborting, empty payload");
        }
        String notificationDataAsJSON = payLoad;
        Map<String,String> notificationDataAsMap = new Gson().fromJson(payLoad , Map.class);

        String message = notificationDataAsMap.get("Message");
        Map<String,String> messageDataMap = null;
        if (message != null) {
            messageDataMap = new Gson().fromJson(message , Map.class);
            if (messageDataMap != null) {
                String notificationType = messageDataMap.get("NotificationType");
                JAXBContext jaxbContext = null;
                try {
                    if("OrderReferenceNotification".equalsIgnoreCase(notificationType)) {
                        jaxbContext = JAXBContext.newInstance(OrderReferenceNotification.class);
                    } else if("PaymentAuthorize".equalsIgnoreCase(notificationType)) {
                        jaxbContext = JAXBContext.newInstance(AuthorizationNotification.class);
                    } else if("PaymentCapture".equalsIgnoreCase(notificationType)) {
                        jaxbContext = JAXBContext.newInstance(CaptureNotification.class);
                    } else if("PaymentRefund".equalsIgnoreCase(notificationType)) {
                        jaxbContext = JAXBContext.newInstance(RefundNotification.class);
                    } else if("BillingAgreementNotification".equalsIgnoreCase(notificationType)) {
                        jaxbContext = JAXBContext.newInstance(BillingAgreementNotification.class);
                    } else if("ProviderCredit".equalsIgnoreCase(notificationType)) {
                        jaxbContext = JAXBContext.newInstance(ProviderCreditNotification.class);
                    }  else if("ProviderCreditReversal".equalsIgnoreCase(notificationType)) {
                        jaxbContext = JAXBContext.newInstance(ProviderCreditReversalNotification.class);
                    }  else if("SolutionProviderEvent".equalsIgnoreCase(notificationType)) {
                        jaxbContext = JAXBContext.newInstance(SolutionProviderMerchantNotification.class);
                    }  else {
                        throw new AmazonClientException("Unknown notification type: "+ notificationType);
                    }

                    // Modify namespace declaration so it is ignored
                    if (jaxbContext != null) {
                        String notificationData = messageDataMap.get("NotificationData");
                        //ignore the namespace only for marshalling purpose
                        notificationData = notificationData.replaceAll("xmlns(?:.*?)?=\"https://mws.amazonservices.com/ipn/OffAmazonPayments/2013-01-01\"", "");
                        StringReader reader = new StringReader(notificationData.trim());
                        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                        unmarshaller.setEventHandler(new DefaultValidationEventHandler());
                        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
                        xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
                        xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
                        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
                        notifData = (Notification) unmarshaller.unmarshal(xmlStreamReader);
                        notifData.setNotificationMetadata(new NotificationMetaData(notificationDataAsMap));
                        notifData.setMessageMetaData(new IPNMessageMetaData(messageDataMap));
                        notifData.setJSON(notificationDataAsJSON);
                        notifData.setMap(notificationDataAsMap);                    }

                } catch(JAXBException e) {
                    throw new AmazonClientException("Failed marshalling notification: " + notificationDataAsJSON , e);
                } catch(XMLStreamException e){
                    throw new AmazonClientException("Failed marshalling notification: " + notificationDataAsJSON , e);
                }
            }
        }
        return notifData;
    }



}
