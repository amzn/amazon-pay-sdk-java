/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.impl.ipn;

import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.impl.PayLogUtil;
import com.amazon.pay.response.ipn.model.AuthorizationNotification;
import com.amazon.pay.response.ipn.model.BillingAgreementNotification;
import com.amazon.pay.response.ipn.model.CaptureNotification;
import com.amazon.pay.response.ipn.model.ChargebackNotification;
import com.amazon.pay.response.ipn.model.IPNMessageMetaData;
import com.amazon.pay.response.ipn.model.Notification;
import com.amazon.pay.response.ipn.model.NotificationMetaData;
import com.amazon.pay.response.ipn.model.OrderReferenceNotification;
import com.amazon.pay.response.ipn.model.ProviderCreditNotification;
import com.amazon.pay.response.ipn.model.ProviderCreditReversalNotification;
import com.amazon.pay.response.ipn.model.RefundNotification;
import com.amazon.pay.response.ipn.model.SolutionProviderMerchantNotification;
import com.amazon.pay.response.parser.AmazonValidationEventHandler;

import com.google.gson.Gson;

import java.io.StringReader;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class NotificationFactory {

    public static PayLogUtil payUtil = new PayLogUtil();

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
     * @throws AmazonClientException  AmazonClientException represents any internal errors that are encountered inside the client while
     *   attempting to make the request or handle the response.  For example
     *   if a network connection is not available. Or if for some reason even if SDK is unable
     *   to parse the response, using this exception you can still retrieve the raw API response.
     *
     */
    public static Notification parseNotification(Map<String,String> headers, final String body) throws AmazonClientException {

        final NotificationVerification verifier = new NotificationVerification();

        //verify notification header values
        verifier.verifyHeaders(headers);

        //log headers to the console.
        try {
            payUtil.logMessage("\n\nNotification Header:\n" + headers.toString());
        } catch (Exception e) {
            throw new AmazonClientException("Encountered an Exception: ", e);
        }

        //parse notification
        final Notification notification = NotificationFactory.getNotification(body);

        //log notification body contents to the console.
        try {
            if (body != null) {
                // To aid troubleshooting, logged response will get formatted so that
                // it appears very close to the input of Seller Central's IPN Test Tool
                payUtil.logMessage("\n\nNotification Body:\n" +
                        body.replace("\\\\n", "\n")                   // change \\n into a newline
                                .replace("\\\\/", "/")                // change \\/ into /
                                .replace("\\\\\\\"", "\"")            // change \\\" into "
                                .replace(",\\\"", ",\n    \"")        // change ,\" into ,newline+spacex4+"
                                .replace("\"{\\\"", "\n  {\n    \"")  // change "{\" into "newline+spacex2{newline+spacex4+"
                                .replace("\\\"}\"", "\n  }")          // change \"}" into "newline+spacex2}"
                                .replace("\\\"", "\"")                // change \" into " (needs to come last in sequence)
                                );
            }
        } catch (Exception e) {
            throw new AmazonClientException("Encountered an Exception: ", e);
        }

        //verify validity of notification using signature, type and signingCertURL fields.
        verifier.verifyMessage(notification);

        //If all verification succeeds, notification container object is returned.
        return notification;
    }


    private static Notification getNotification(String payLoad)  {
        Notification notifData = null;
        if (payLoad == null || payLoad.isEmpty()) {
            throw new AmazonClientException("Aborting, empty payload");
        }
        final String notificationDataAsJSON = payLoad;
        final Map<String,String> notificationDataAsMap = new Gson().fromJson(payLoad, Map.class);

        final String message = notificationDataAsMap.get("Message");
        Map<String,String> messageDataMap = null;
        if (message != null) {
            messageDataMap = new Gson().fromJson(message, Map.class);
            if (messageDataMap != null) {
                final String notificationTypeWithSpaces = messageDataMap.get("NotificationType");
                if (notificationTypeWithSpaces != null) {
                    final String notificationType = notificationTypeWithSpaces.replaceAll(" ", "");
                    JAXBContext jaxbContext = null;
                    try {
                        if ("OrderReferenceNotification".equalsIgnoreCase(notificationType)) {
                            jaxbContext = JAXBContext.newInstance(OrderReferenceNotification.class);
                        } else if ("PaymentAuthorize".equalsIgnoreCase(notificationType)) {
                            jaxbContext = JAXBContext.newInstance(AuthorizationNotification.class);
                        } else if ("PaymentCapture".equalsIgnoreCase(notificationType)) {
                            jaxbContext = JAXBContext.newInstance(CaptureNotification.class);
                        } else if ("PaymentRefund".equalsIgnoreCase(notificationType)) {
                            jaxbContext = JAXBContext.newInstance(RefundNotification.class);
                        } else if ("BillingAgreementNotification".equalsIgnoreCase(notificationType)) {
                            jaxbContext = JAXBContext.newInstance(BillingAgreementNotification.class);
                        } else if ("ProviderCredit".equalsIgnoreCase(notificationType)) {
                            jaxbContext = JAXBContext.newInstance(ProviderCreditNotification.class);
                        }  else if ("ProviderCreditReversal".equalsIgnoreCase(notificationType)) {
                            jaxbContext = JAXBContext.newInstance(ProviderCreditReversalNotification.class);
                        }  else if ("SolutionProviderEvent".equalsIgnoreCase(notificationType)) {
                            jaxbContext = JAXBContext.newInstance(SolutionProviderMerchantNotification.class);
                        }  else if ("ChargebackDetailedNotification".equalsIgnoreCase(notificationType)) {
                            jaxbContext = JAXBContext.newInstance(ChargebackNotification.class);
                        }  else {
                            throw new AmazonClientException("Unknown notification type: "+ notificationType);
                        }

                        // Modify namespace declaration so it is ignored
                        if (jaxbContext != null) {
                            final String notificationData = messageDataMap.get("NotificationData").replaceAll(
                                    "xmlns(?:.*?)?=\"https://mws.amazonservices.com/ipn/OffAmazonPayments/2013-01-01\"", "");
                            final StringReader reader = new StringReader(notificationData.trim());
                            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                            unmarshaller.setEventHandler(new AmazonValidationEventHandler());

                            final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
                            xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
                            xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
                            final XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
                            notifData = (Notification) unmarshaller.unmarshal(xmlStreamReader);
                            notifData.setNotificationMetadata(new NotificationMetaData(notificationDataAsMap));
                            notifData.setMessageMetaData(new IPNMessageMetaData(messageDataMap));
                            notifData.setJSON(notificationDataAsJSON);
                            notifData.setMap(notificationDataAsMap);
                        }

                    } catch (JAXBException e) {
                        throw new AmazonClientException("Failed marshalling notification: " + notificationDataAsJSON, e);
                    } catch (XMLStreamException e) {
                        throw new AmazonClientException("Failed marshalling notification: " + notificationDataAsJSON, e);
                    }
                }
            }
        }
        return notifData;
    }

}
