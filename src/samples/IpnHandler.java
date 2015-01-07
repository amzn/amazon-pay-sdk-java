/******************************************************************************
 *  Copyright 2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
 * ****************************************************************************
 */

package samples;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationParser;
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
import com.amazonservices.mws.offamazonpaymentsipn.notifications.NotificationType;

/**
 * Receives and stores incoming IPN's
 */
public class IpnHandler extends HttpServlet {
    private static Log LOG = LogFactory.getLog(IpnHandler.class);

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("IPN received");
        
        NotificationParser parser = new NotificationParser();
        INotification notification = null;
        try {
            notification = parser.parseRawMessage(request);
            String id = null;
            String key = null;

            if (notification.getNotificationType() == NotificationType.AuthorizationNotification) {
                id = ((AuthorizationNotification) notification).getAuthorizationDetails().getAmazonAuthorizationId();
                key = id + "_Authorize";
            } else if (notification.getNotificationType() == NotificationType.CaptureNotification) {
                id = ((CaptureNotification) notification).getCaptureDetails().getAmazonCaptureId();
                key = id + "_Capture";
            } else if (notification.getNotificationType() == NotificationType.OrderReferenceNotification) {
                id = ((OrderReferenceNotification) notification).getOrderReference().getAmazonOrderReferenceId();
                key = id + "_OrderReference";
            } else if (notification.getNotificationType() == NotificationType.RefundNotification) {
                id = ((RefundNotification) notification).getRefundDetails().getAmazonRefundId();
                key = id + "_Refund";
            } else if (notification.getNotificationType() == NotificationType.BillingAgreementNotification) {
                id = ((BillingAgreementNotification) notification).getBillingAgreement().getAmazonBillingAgreementId();
                key = id + "_BillingAgreement";
            } else if (notification.getNotificationType() == NotificationType.ProviderCreditNotification) {
                id = ((ProviderCreditNotification) notification).getProviderCreditDetails().getAmazonProviderCreditId();
                key = id + "_ProviderCredit";
            } else if (notification.getNotificationType() == NotificationType.ProviderCreditReversalNotification) {
                id = ((ProviderCreditReversalNotification) notification).getProviderCreditReversalDetails()
                        .getAmazonProviderCreditReversalId();
                key = id + "_ProviderCreditReversal";
            }  else if (notification.getNotificationType() == NotificationType.SolutionProviderMerchantNotification) {
                id = ((SolutionProviderMerchantNotification) notification).getMerchantRegistrationDetails().getSellerId();
                key = id + "_SolutionProviderMerchant";
            } else {
                String msg = "Unknown IPN Type: " + notification.getNotificationType();
                LOG.error(msg);
                throw new NotificationsException(msg);
            }

            LOG.info("IPN received of type " + key);
            response.getOutputStream().println("IPN received: " + key);
            Calendar timeout = Calendar.getInstance();
            timeout.add(Calendar.DATE, 1);
            IpnCache.getInstance().put(key, notification, timeout);
            
        } catch (NotificationsException e) {
            LOG.fatal("Unable to handle request in IPNHandler", e);
        }
    }
}
