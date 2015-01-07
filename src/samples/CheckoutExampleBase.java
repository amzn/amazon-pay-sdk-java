/******************************************************************************
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
 * ****************************************************************************
 */

package samples;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import samples.utils.Utilities;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceClient;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.CaptureDetails;
import com.amazonservices.mws.offamazonpayments.model.CaptureRequest;
import com.amazonservices.mws.offamazonpayments.model.CaptureResponse;
import com.amazonservices.mws.offamazonpayments.model.GetAuthorizationDetailsRequest;
import com.amazonservices.mws.offamazonpayments.model.GetAuthorizationDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.GetCaptureDetailsRequest;
import com.amazonservices.mws.offamazonpayments.model.GetCaptureDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.GetOrderReferenceDetailsRequest;
import com.amazonservices.mws.offamazonpayments.model.GetOrderReferenceDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.GetProviderCreditDetailsRequest;
import com.amazonservices.mws.offamazonpayments.model.GetProviderCreditDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.GetProviderCreditReversalDetailsRequest;
import com.amazonservices.mws.offamazonpayments.model.GetProviderCreditReversalDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.Price;
import com.amazonservices.mws.offamazonpayments.model.ProviderCredit;
import com.amazonservices.mws.offamazonpayments.model.ProviderCreditList;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.CaptureNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.ProviderCreditNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.ProviderCreditReversalNotification;

/**
 * Base class that has member variables and functions
 * used across most examples
 * 
 */
public class CheckoutExampleBase {

    protected String sellerId = null;
    protected PrintWriter outStream = null;
    protected OffAmazonPaymentsServiceConfig config = null;
    protected OffAmazonPaymentsServiceClient service = null;

    public CheckoutExampleBase(OffAmazonPaymentsServiceConfig config, OffAmazonPaymentsServiceClient service,
            PrintWriter outStream) {
        this.config = config;
        this.service = service;
        this.sellerId = this.config.getSellerId();
        this.outStream = outStream;
    }

    /**
     * Method to print the order reference details, Use this method to
     * display buyer's shipping address detail
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void printOrderDetails(String amazonOrderReferenceId) throws OffAmazonPaymentsServiceException {
        GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest();
        request.setAmazonOrderReferenceId(amazonOrderReferenceId);
        request.setSellerId(this.sellerId);

        GetOrderReferenceDetailsResponse response = this.service.getOrderReferenceDetails(request);
        Utilities.validateResponseNotNull(response, "GetOrderReferenceDetailsResponse");
        GetOrderReferenceDetailsSample.printResponse(response, outStream);

    }

    /**
     * Method to get the Authorization details
     * 
     * @return GetAuthorizationDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public GetAuthorizationDetailsResponse getAuthorizationDetails(String amazonAuthorizationId)
            throws OffAmazonPaymentsServiceException {

        if (amazonAuthorizationId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Authorization ID is NULL");
        }

        GetAuthorizationDetailsRequest request = new GetAuthorizationDetailsRequest();
        request.setAmazonAuthorizationId(amazonAuthorizationId);
        request.setSellerId(this.sellerId);

        GetAuthorizationDetailsResponse response = this.service.getAuthorizationDetails(request);
        return response;
    }

    /**
     * Method to capture order total
     * 
     * @param amount
     * @param currencyCode
     * @param amazonAuthorizationId
     * @param captureReferenceId
     * @param softDescriptor
     * @param sellerCaptureNote
     * @return CaptureResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public CaptureResponse captureOrderAmount(String amount, String currencyCode, String amazonAuthorizationId,
            String captureReferenceId, String softDescriptor, String sellerCaptureNote)
            throws OffAmazonPaymentsServiceException {
        return captureOrderAmount(amount, currencyCode, amazonAuthorizationId, captureReferenceId, softDescriptor,
                sellerCaptureNote, null, null);
    }

    /**
     * Method to capture order total
     * 
     * @param amount
     * @param currencyCode
     * @param amazonAuthorizationId
     * @param captureReferenceId
     * @param softDescriptor
     * @param sellerCaptureNote
     * @return CaptureResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public CaptureResponse captureOrderAmount(String amount, String currencyCode, String amazonAuthorizationId,
            String captureReferenceId, String softDescriptor, String sellerCaptureNote, String providerId,
            String creditAmount) throws OffAmazonPaymentsServiceException {
        if (amount == null) {
            throw new OffAmazonPaymentsServiceException("Capture Amount is NULL");
        } else if (currencyCode == null) {
            throw new OffAmazonPaymentsServiceException("Currency Code is NULL");
        } else if (amazonAuthorizationId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Authorization ID is NULL");
        } else {
            CaptureRequest request = new CaptureRequest();

            Price captureTotal = new Price(amount, currencyCode);
            request.setCaptureAmount(captureTotal);

            request.setAmazonAuthorizationId(amazonAuthorizationId);

            request.setSellerId(this.sellerId);
            request.setCaptureReferenceId(captureReferenceId);
            /*
             * Optional Parameters
             */
            if (softDescriptor != null) {
                request.setSoftDescriptor(softDescriptor);
            }
            if (sellerCaptureNote != null) {
                request.setSellerCaptureNote(sellerCaptureNote);
            }
            if (providerId != null && creditAmount != null) {
                request.setProviderCreditList(constructProviderCreditListObject(providerId, creditAmount));
            }

            CaptureResponse result = this.service.capture(request);
            return result;
        }
    }

    /**
     * Method is used to check the status for an Authorization request
     * Poll the API for the status of the Authorization Request, and continue
     * once the status has been updated from PENDING to other state
     * 
     * @param amazonAuthorizationId
     * @return AuthorizationNotification
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public AuthorizationNotification servletWaitUntilAuthorizationComplete(String amazonAuthorizationId)
            throws OffAmazonPaymentsServiceException {

        if (amazonAuthorizationId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Authorization ID is NULL");
        } else {
            AuthorizationNotification result = null;
            String pendingState = "PENDING";
            boolean isPending = true;
            int retryCounter = 0; // This counter is used as timeout for this loop
            try {
                do {
                    Thread.sleep(10000);
                    retryCounter++;
                    result = (AuthorizationNotification) IpnCache.getInstance().get(
                            amazonAuthorizationId + "_Authorize");
                    if (result != null) {
                        isPending = result.getAuthorizationDetails().getAuthorizationStatus().getState().toUpperCase()
                                .equals(pendingState);
                    }
                } while (isPending && retryCounter < 20);
            } catch (InterruptedException ie) {
                throw new OffAmazonPaymentsServiceException("Internal Error", ie);
            }
            return result;
        }
    }

    /**
     * Wait for Capture Notification
     * 
     * @param amazonCaptureId
     * @return CaptureNotification
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public CaptureNotification servletWaitForCaptureNotification(String amazonCaptureId)
            throws OffAmazonPaymentsServiceException {
        if (amazonCaptureId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Capture Id is NULL");
        }
        CaptureNotification result = null;
        int retryCounter = 0; // This counter is used as timeout for this loop
        try {
            do {
                Thread.sleep(10000);
                retryCounter++;
                result = (CaptureNotification) IpnCache.getInstance().get(amazonCaptureId + "_Capture");
            } while (retryCounter < 20);
        } catch (InterruptedException ie) {
            throw new OffAmazonPaymentsServiceException("Internal Error", ie);
        }
        return result;
    }

    /**
     * Wait for Provider Credit Notification
     * 
     * @param amazonProviderCreditId
     * @return ProviderCreditNotification
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public ProviderCreditNotification servletWaitForProviderCreditNotification(String amazonProviderCreditId)
            throws OffAmazonPaymentsServiceException {
        if (amazonProviderCreditId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Provider Credit Id is NULL");
        }
        int retryCounter = 0; // This counter is used as timeout for this loop
        ProviderCreditNotification result = null;
        try {
            do {
                Thread.sleep(10000);
                retryCounter++;
                result = (ProviderCreditNotification) IpnCache.getInstance().get(
                        amazonProviderCreditId + "_ProviderCredit");
            } while (retryCounter < 20);
        } catch (InterruptedException ie) {
            throw new OffAmazonPaymentsServiceException("Internal Error", ie);
        }
        return result;
    }

    /**
     * Wait for Provider Credit Reversal Notification
     * 
     * @param amazonProviderReversalCreditId
     * @return ProviderCreditReversalNotification
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public ProviderCreditReversalNotification servletWaitForProviderCreditReversalNotification(
            String amazonProviderCreditReversalId) throws OffAmazonPaymentsServiceException {
        if (amazonProviderCreditReversalId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Provider Credit Reversal Id is NULL");
        }
        int retryCounter = 0; // This counter is used as timeout for this loop
        ProviderCreditReversalNotification result = null;
        try {
            do {
                Thread.sleep(10000);
                retryCounter++;
                result = (ProviderCreditReversalNotification) IpnCache.getInstance().get(
                        amazonProviderCreditReversalId + "_ProviderCreditReversal");
            } while (retryCounter < 20);
        } catch (InterruptedException ie) {
            throw new OffAmazonPaymentsServiceException("Internal Error", ie);
        }
        return result;
    }

    /**
     * Method is used to check the status for an Authorization request
     * Poll the API for the status of the Authorization Request, and continue
     * once the status has been updated from PENDING to other state
     * 
     * WARNING!!: This is not the way to integrate for production systems,
     * instead merchants should use IPNs to receive a callback once the
     * processing has been completed.
     * Note that Amazon reserves the right to throttle requests that
     * ignore this advice and poll for a response
     * 
     * @param amazonAuthorizationId
     * @return GetAuthorizationDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public GetAuthorizationDetailsResponse cliWaitUntilAuthorizationComplete(String amazonAuthorizationId)
            throws OffAmazonPaymentsServiceException {

        if (amazonAuthorizationId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Authorization ID is NULL");
        } else {
            GetAuthorizationDetailsRequest request = new GetAuthorizationDetailsRequest();
            request.setSellerId(this.sellerId);
            request.setAmazonAuthorizationId(amazonAuthorizationId);

            GetAuthorizationDetailsResponse result = null;
            String pendingState = "PENDING";
            boolean isPending;
            int retryCounter = 0; // This counter is used as timeout for this loop
            try {
                do {
                    Thread.sleep(10000);
                    retryCounter++;
                    result = this.service.getAuthorizationDetails(request);
                    if (result == null) {
                        throw new OffAmazonPaymentsServiceException("No valid response from "
                                + "GetAuthorizationDetails request");
                    }
                    isPending = result.getGetAuthorizationDetailsResult().getAuthorizationDetails()
                            .getAuthorizationStatus().getState().toUpperCase().equals(pendingState);
                } while (isPending && retryCounter < 20);
            } catch (InterruptedException ie) {
                throw new OffAmazonPaymentsServiceException("Internal Error", ie);
            }
            return result;
        }
    }

    /**
     * Method is used to construct the ProviderCreditList Object for
     * the Authorization/Capture request if required.
     * 
     * @return ProviderCreditList
     */
    public ProviderCreditList constructProviderCreditListObject(String providerId, String creditAmountString) {
        ProviderCredit providerCredit = new ProviderCredit();
        providerCredit.setProviderId(providerId);
        Price creditAmount = new Price();
        creditAmount.setAmount(creditAmountString);
        creditAmount.setCurrencyCode(this.config.getCurrencyCode());
        providerCredit.setCreditAmount(creditAmount);
        List<ProviderCredit> providerCreditListMember = new ArrayList<ProviderCredit>();
        providerCreditListMember.add(providerCredit);
        ProviderCreditList providerCreditList = new ProviderCreditList();
        providerCreditList.setMember(providerCreditListMember);
        return providerCreditList;
    }

    /**
     * Method is used to check for the Provider Credit Summary List
     * Poll the GetCaptureDetails API and continue once the
     * Provider Credit Summary List is found.
     * 
     * WARNING!!: This is not the way to integrate for production systems,
     * instead merchants should use IPNs to receive a callback once the
     * processing has been completed.
     * Note that Amazon reserves the right to throttle requests that
     * ignore this advice and poll for a response
     * 
     * @param amazonCaptureId
     * @return GetCaptureDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public CaptureDetails waitForCaptureDetailsWithProviderCreditSummaryList(String amazonCaptureId)
            throws OffAmazonPaymentsServiceException {

        if (amazonCaptureId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Capture ID is NULL");
        } else {
            GetCaptureDetailsRequest request = new GetCaptureDetailsRequest();
            request.setSellerId(this.sellerId);
            request.setAmazonCaptureId(amazonCaptureId);

            GetCaptureDetailsResponse result = null;
            boolean isProviderCreditListPresent = false;
            int retryCounter = 0; // This counter is used as timeout for this loop
            try {
                do {
                    Thread.sleep(10000);
                    retryCounter++;
                    result = this.service.getCaptureDetails(request);
                    if (result == null) {
                        throw new OffAmazonPaymentsServiceException("No valid response from "
                                + "GetCaptureDetails request");
                    }
                    isProviderCreditListPresent = result.getGetCaptureDetailsResult().getCaptureDetails()
                            .isSetProviderCreditSummaryList();
                } while (!isProviderCreditListPresent && retryCounter < 20);
            } catch (InterruptedException ie) {
                throw new OffAmazonPaymentsServiceException("Internal Error", ie);
            }
           
            return result.getGetCaptureDetailsResult().getCaptureDetails();
        }
    }

    /**
     * Method to get the Provider Credit details
     * 
     * @return GetProviderCreditDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public GetProviderCreditDetailsResponse getProviderCreditDetails(String amazonProviderCreditId)
            throws OffAmazonPaymentsServiceException {

        if (amazonProviderCreditId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Provider Credit Id is NULL");
        }
        System.out.println("Getting Provider Credit Id:" + amazonProviderCreditId);
        GetProviderCreditDetailsRequest request = new GetProviderCreditDetailsRequest();
        request.setAmazonProviderCreditId(amazonProviderCreditId);
        request.setSellerId(this.sellerId);

        GetProviderCreditDetailsResponse response = this.service.getProviderCreditDetails(request);
        return response;
    }

    /**
     * Method to get the Provider Credit Reversal details
     * 
     * @return GetProviderCreditReversalDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public GetProviderCreditReversalDetailsResponse getProviderCreditReversalDetails(
            String amazonProviderCreditReversalId) throws OffAmazonPaymentsServiceException {

        if (amazonProviderCreditReversalId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Provider Credit Id is NULL");
        }
        System.out.println("Getting Provider Credit Id:" + amazonProviderCreditReversalId);
        GetProviderCreditReversalDetailsRequest request = new GetProviderCreditReversalDetailsRequest();
        request.setAmazonProviderCreditReversalId(amazonProviderCreditReversalId);
        request.setSellerId(this.sellerId);

        GetProviderCreditReversalDetailsResponse response = this.service.getProviderCreditReversalDetails(request);
        return response;
    }

}
