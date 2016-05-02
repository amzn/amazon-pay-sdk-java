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
package com.amazonservices.mws.offamazonpaymentsipn.parsers;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.BillingAgreementNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.CaptureNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.OrderReferenceNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.ProviderCreditNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.ProviderCreditReversalNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.RefundNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.SolutionProviderMerchantNotification;
import com.amazonservices.mws.offamazonpaymentsipn.notifications.INotification;
import com.amazonservices.mws.offamazonpaymentsipn.notifications.Notification;

/**
 * Wrapper around a decoded IPN notification message to
 * create the notification objects.
 */
public class XmlNotificationParser {

    /**
     * Error message for unknown notification type
     */
    private final static String UNKNOWN_NOTIFICATION_ERR_MSG
            = "Error with ipn notification - unknown notification type: %s";

    /**
     * Error message for invalid xml
     */
    private final static String INVALID_XML_ERR_MSG
            = "Error with ipn message - NotificationData field does not contain valid xml, contents: %s";

    /**
     * Create an instance of the IPN notification that represents
     * the xml contained within the ipn message structure
     * @param ipnMessage IPN message, containing the xml in the NotificationData field
     * @return Instance of INotification
     * @throws NotificationsException if the message is not an ipn message, or if the xml cannot be constructed
     */
    public INotification parseIpnMessage(final Message ipnMessage) throws NotificationsException {
        String notificationData = ipnMessage.getMandatoryField("NotificationData");
        String notificationType = ipnMessage.getMandatoryField("NotificationType");

        Notification notification = null;
        JAXBContext jaxbContext = null;
        try {
            if (notificationType.equals("OrderReferenceNotification")) {
                jaxbContext = JAXBContext.newInstance(OrderReferenceNotification.class);
            } else if (notificationType.equals("PaymentAuthorize")) {
                jaxbContext = JAXBContext.newInstance(AuthorizationNotification.class);
            } else if (notificationType.equals("PaymentCapture")) {
                jaxbContext = JAXBContext.newInstance(CaptureNotification.class);
            } else if (notificationType.equals("PaymentRefund")) {
                jaxbContext = JAXBContext.newInstance(RefundNotification.class);
            } else if (notificationType.equals("BillingAgreementNotification")) {
                jaxbContext = JAXBContext.newInstance(BillingAgreementNotification.class);
            } else if (notificationType.equals("ProviderCredit")) {
                jaxbContext = JAXBContext.newInstance(ProviderCreditNotification.class);
            } else if (notificationType.equals("ProviderCreditReversal")) {
                jaxbContext = JAXBContext.newInstance(ProviderCreditReversalNotification.class);
            } else if (notificationType.equals("SolutionProviderEvent")) {
                jaxbContext = JAXBContext.newInstance(SolutionProviderMerchantNotification.class);
            } else {
                throw new NotificationsException(String.format(UNKNOWN_NOTIFICATION_ERR_MSG, notificationType));
            }
            
            // Modify namespace declaration so it is ignored
            notificationData = notificationData.replace("xmlns=", "ymlns=");

            if (jaxbContext != null) {
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                notification = (Notification) jaxbUnmarshaller.unmarshal(new StringReader(notificationData.trim()));
                notification.setNotificationMetadata(ipnMessage.getMetadata());
            }
        } catch (JAXBException e) {
            throw new NotificationsException(String.format(INVALID_XML_ERR_MSG, notificationData), e);
        }

        return notification;
    }
}
