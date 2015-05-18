/*******************************************************************************
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
 * *****************************************************************************
 */

package samples;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;
import com.amazonservices.mws.offamazonpaymentsipn.model.RefundNotification;

import samples.utils.Utilities;

/**
 * .
 * Refund Example
 * 
 * This sample demonstrated a merchant use case for
 * a partial/full refund on previously captured amount
 * 
 * This example will show the following service calls:
 * - GetOrderReferenceDetails
 * - GetCaptureDetails
 * - Refund
 * - GetRefundDetails
 */

public class RefundExample extends CheckoutExampleBase {

    private String amazonOrderReferenceId = null;
    private String amazonCaptureId = null;
    private String refundId = null;

    public RefundExample(String amazonOrderReferenceId, String amazonCaptureId, OffAmazonPaymentsServiceConfig config,
            OffAmazonPaymentsServiceClient service, PrintWriter outStream) {
        super(config, service, outStream);
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.amazonCaptureId = amazonCaptureId;
        this.refundId = this.amazonCaptureId + "r0";
    }

    /**
     * Method to print the order reference details, Use this method to
     * display buyer's shipping address detail
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void printOrderDetails() throws OffAmazonPaymentsServiceException {
        this.printOrderDetails(this.amazonOrderReferenceId);
    }

    /**
     * .
     * Method to get the capture details, Give details about
     * the capture using Amazon Capture ID
     * 
     * @return GetCaptureDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     */
    private GetCaptureDetailsResponse getCaptureDetailsForRefund() throws OffAmazonPaymentsServiceException {
        GetCaptureDetailsRequest request = new GetCaptureDetailsRequest();
        request.setAmazonCaptureId(this.amazonCaptureId);
        request.setSellerId(this.sellerId);

        GetCaptureDetailsResponse response = this.service.getCaptureDetails(request);
        return response;
    }

    /**
     * .
     * Method to get the capture details and print them out
     * Give details about the capture using Amazon Capture
     * ID, and it's current state
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    public void printCaptureDetailsForRefund() throws OffAmazonPaymentsServiceException {
        GetCaptureDetailsResponse response = getCaptureDetailsForRefund();
        Utilities.validateResponseNotNull(response, "GetCaptureDetailsResponse");
        GetCaptureDetailsSample.printResponse(response, outStream);
    }

    /**
     * Method to refund partial/complete amount on a captured amount.
     * 
     * @param refundAmount
     * @param optionalSellerRefundNote
     * @param optionalSoftDescriptor
     * @return RefundResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public RefundResponse refund(double refundAmount, String optionalSellerRefundNote, String optionalSoftDescriptor)
            throws OffAmazonPaymentsServiceException {
        return refund(refundAmount, optionalSellerRefundNote, optionalSoftDescriptor, null, null);
    }

    /**
     * Method to refund partial/complete amount on a captured amount.
     * 
     * @param refundAmount
     * @param optionalSellerRefundNote
     * @param optionalSoftDescriptor
     * @return RefundResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public RefundResponse refund(double refundAmount, String optionalSellerRefundNote, String optionalSoftDescriptor,
            String providerId, String creditReversalAmount) throws OffAmazonPaymentsServiceException {

        GetCaptureDetailsResponse getCaptureDetails = this.getCaptureDetailsForRefund();

        if (getCaptureDetails == null) {
            throw new OffAmazonPaymentsServiceException("GetCaptureDetailsResponse is NULL");
        }
        if (refundAmount < 0.00) {
            throw new OffAmazonPaymentsServiceException("refundAmount is not a valid amount");
        }
        /*
         * Below code is used to generate unique Seller Refund ID for
         * each refund on this capture ID. It uses IdList to check if
         * there was any previous refund to this capture:
         * If Yes, it appends the IdList count of refundId.
         * If the ID list is empty, it start with count 1
         * In this way the Ids are incremental like
         * <AmazonCaptureID>r01, <AmazonCaptureID>r02,<AmazonCaptureID>r03,...
         */
        IdList refundIdList = getCaptureDetails.getGetCaptureDetailsResult().getCaptureDetails().getIdList();
        if (refundIdList.isSetMember()) {
            int refundCount = refundIdList.getMember().size() + 1;
            this.refundId = this.refundId + new Integer(refundCount).toString();
        } else {
            this.refundId = this.refundId + "1";
        }

        RefundRequest request = new RefundRequest();

        Price refundValue = new Price();
        refundValue.setAmount(Double.toString(refundAmount));
        refundValue.setCurrencyCode(config.getCurrencyCode());

        request.setRefundAmount(refundValue);
        request.setAmazonCaptureId(this.amazonCaptureId);
        request.setRefundReferenceId(this.refundId);
        request.setSellerId(this.sellerId);

        /*
         * Optional Parameters
         */
        if (optionalSellerRefundNote != null) {
            request.setSellerRefundNote(optionalSellerRefundNote);
        }
        if (optionalSoftDescriptor != null) {
            request.setSoftDescriptor(optionalSoftDescriptor);
        }
        if (providerId != null && creditReversalAmount != null) {
            request.setProviderCreditReversalList(constructProviderCreditReversalListObject(providerId,
                    creditReversalAmount));
        }

        RefundResponse response = this.service.refund(request);

        return response;
    }

    /**
     * Method is used to check the status for an Refund request
     * Poll the API for the status of the Refund Request, and continue
     * once the status has been updated from PENDING to other state
     * 
     * WARNING!!: This is not the way to integrate for production systems,
     * instead merchants should use IPN to receive a callback once the
     * processing has been completed.
     * Note that Amazon reserves the right to throttle requests that
     * ignore this advice and poll for a response
     * 
     * 
     * @param amazonRefundId
     * @return GetAuthorizationDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public GetRefundDetailsResponse cliWaitUntilRefundComplete(String amazonRefundId)
            throws OffAmazonPaymentsServiceException {

        if (amazonRefundId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Refund ID is NULL");
        } else {
            GetRefundDetailsRequest request = new GetRefundDetailsRequest();
            request.setSellerId(this.sellerId);
            request.setAmazonRefundId(amazonRefundId);

            GetRefundDetailsResponse result = null;
            String pendingState = "PENDING";
            boolean isPending;
            int retryCounter = 0; // This counter is used as timeout for this loop
            int maxWait = 20;
            try {
                outStream.print("Attempting to perform refund...");
                do {
                    outStream.print(retryCounter + "...");
                    Thread.sleep(5000);
                    retryCounter++;
                    result = this.service.getRefundDetails(request);
                    if (result == null) {
                        throw new OffAmazonPaymentsServiceException("No valid response from GetRefundDetails request");
                    }
                    isPending = result.getGetRefundDetailsResult().getRefundDetails().getRefundStatus().getState()
                            .toUpperCase().equals(pendingState);
                } while (isPending && retryCounter < maxWait);
                if (isPending) {
                    outStream.println("Timed out");
                } else {
                    outStream.println("Success!");
                }
            } catch (InterruptedException ie) {
                throw new OffAmazonPaymentsServiceException("Internal Error", ie);
            }
            return result;
        }
    }

    /**
     * Method is used to check the status for an Refund request
     * Poll the API for the status of the Refund Request, and continue
     * once the status has been updated from PENDING to other state
     * 
     * @param amazonRefundId
     * @return GetAuthorizationDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public RefundNotification servletWaitUntilRefundComplete(String amazonRefundId)
            throws OffAmazonPaymentsServiceException {

        if (amazonRefundId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Refund ID is NULL");
        } else {
            GetRefundDetailsRequest request = new GetRefundDetailsRequest();
            request.setSellerId(this.sellerId);
            request.setAmazonRefundId(amazonRefundId);

            RefundNotification result = null;
            String pendingState = "PENDING";
            boolean isPending = true;
            int retryCounter = 0; // This counter is used as timeout for this loop
            int maxWait = 20;
            try {
                outStream.print("Attempting to perform refund...");
                do {
                    outStream.print(retryCounter + "...");
                    Thread.sleep(5000);
                    retryCounter++;
                    result = ((RefundNotification) IpnCache.getInstance().get(amazonRefundId + "_Refund"));
                    if (result != null) {
                        isPending = result.getRefundDetails().getRefundStatus().getState().toUpperCase()
                                .equals(pendingState);
                    }
                } while (isPending && retryCounter < maxWait);
                if (isPending) {
                    outStream.println("Timed out");
                } else {
                    outStream.println("Success!");
                }
            } catch (InterruptedException ie) {
                throw new OffAmazonPaymentsServiceException("Internal Error", ie);
            }
            return result;
        }
    }

    /**
     * Method is used to construct the ProviderCreditReversalList Object for
     * the Refund request if required.
     * 
     * @return ProviderCreditReversalList
     */
    public ProviderCreditReversalList constructProviderCreditReversalListObject(String providerId,
            String creditReversalAmountString) {
        ProviderCreditReversal providerCreditReversal = new ProviderCreditReversal();
        providerCreditReversal.setProviderId(providerId);
        Price creditReversalAmount = new Price();
        creditReversalAmount.setAmount(creditReversalAmountString);
        creditReversalAmount.setCurrencyCode(this.config.getCurrencyCode());
        providerCreditReversal.setCreditReversalAmount(creditReversalAmount);
        List<ProviderCreditReversal> providerCreditReversalListMember = new ArrayList<ProviderCreditReversal>();
        providerCreditReversalListMember.add(providerCreditReversal);
        ProviderCreditReversalList providerCreditReversalList = new ProviderCreditReversalList();
        providerCreditReversalList.setMember(providerCreditReversalListMember);
        return providerCreditReversalList;
    }

    /**
     * Method is used to check for the Provider Credit Reversal List
     * in the Refund Details
     * 
     * @return GetRefundDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     * @throws InterruptedException
     */
    public RefundDetails waitForRefundDetailsWithProviderCreditReversalSummaryList(String amazonRefundId)
            throws OffAmazonPaymentsServiceException {

        if (amazonRefundId == null) {
            throw new OffAmazonPaymentsServiceException("Amazon Refund Id is NULL");
        } else {
            GetRefundDetailsRequest request = new GetRefundDetailsRequest();
            request.setSellerId(this.sellerId);
            request.setAmazonRefundId(amazonRefundId);

            GetRefundDetailsResponse result = null;
            boolean isProviderCreditReversalSummaryListPresent = false;
            int retryCounter = 0; // This counter is used as timeout for this loop
            try {
                do {
                    Thread.sleep(10000);
                    retryCounter++;
                    result = this.service.getRefundDetails(request);
                    if (result == null) {
                        throw new OffAmazonPaymentsServiceException("No valid response from "
                                + "GetRefundDetails request");
                    }
                    isProviderCreditReversalSummaryListPresent = result.getGetRefundDetailsResult().getRefundDetails()
                            .isSetProviderCreditReversalSummaryList();
                } while (!isProviderCreditReversalSummaryListPresent && retryCounter < 20);
            } catch (InterruptedException ie) {
                throw new OffAmazonPaymentsServiceException("Internal Error", ie);
            }
            return result.getGetRefundDetailsResult().getRefundDetails();
        }

    }

}
