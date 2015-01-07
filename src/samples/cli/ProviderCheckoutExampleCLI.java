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
 * *****************************************************************************
 *
 */

package samples.cli;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

import samples.CaptureSample;
import samples.GetAuthorizationDetailsSample;
import samples.GetProviderCreditDetailsSample;
import samples.SimpleCheckoutExample;
import samples.utils.PropertyBundle;

/******************************************************************************
 * Straight provider checkout example command line
 * This sample drives SimpleCheckoutExample by
 * getting required inputs via command line
 ******************************************************************************/

public class ProviderCheckoutExampleCLI extends CLIHelperClass {

    private SimpleCheckoutExample example = null;

    public ProviderCheckoutExampleCLI() {
        super();
        this.example = new SimpleCheckoutExample(amazonOrderReferenceId, config, service, outStream);
        System.out.println(PropertyBundle.getProperties().get("serviceURL"));
    }

    public static void main(String[] args) {
        ProviderCheckoutExampleCLI providerCheckoutExampleCLI = new ProviderCheckoutExampleCLI();
        providerCheckoutExampleCLI.runSample();
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all
     * API calls that will be required for simple
     * cart checkout followed with immediate authorization
     * and capture of entire order amount
     */
    public void runSample() {
        try {
            this.addOrderReferenceDetails();
            this.printMessage("Order Reference is set with provided details.");
            this.printMessage("Now confirming this order reference...");

            example.confirmOrderReference();
            this.printMessage("Order Reference is confirmed and " + "moved to 'OPEN' state");
            this.printMessage("Now getting details for Authorization...");

            int authOption = getAuthorizationOption();
            boolean captureNow = isDirectCapture();
            String providerId = this.getUserStringFromConsole("Provider Id :");
            String creditAmount = this.getUserStringFromConsole("Credit Amount :");

            AuthorizationDetails authDetails = authorize(captureNow, authOption, providerId, creditAmount);
            if (captureNow) {
                this.printMessage("Authorization with Capture is complete");
                this.printMessage("Now Closing the Order Reference...");
            } else {
                this.printMessage("Authorization for this Order Reference " + "is complete and moved to 'OPEN' state");
                this.printMessage("Now getting details for Capture...");

                CaptureResponse captureResponse = this.capture(authDetails, providerId, creditAmount);
                this.printMessage("Capture for this Order Reference is complete");
                ProviderCreditSummaryList providerCreditSummaryList = null;
                if (providerId != null && creditAmount != null) {
                    providerCreditSummaryList = this.waitForCaptureDetailsWithProviderCreditSummaryList(captureResponse
                            .getCaptureResult().getCaptureDetails().getAmazonCaptureId());
                    getProviderCreditDetails(providerCreditSummaryList);
                }
                this.printMessage("Now Closing the Order Reference...");
            }
            example.closeOrder();
            this.printMessage("Order Refernce Moved to CLOSED state.");
            this.printMessage("Provider Checkout Example is complete.");

        } catch (OffAmazonPaymentsServiceException ex) {
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.println("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
            ex.printStackTrace();
        }

    }

    /**
     * Method to get sub total, Shipping type and other optional parameters.
     * It sets Order Reference object with Order Total calculated with
     * tax, and Shipping charge and other optional parameters
     * provided from console
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void addOrderReferenceDetails() throws OffAmazonPaymentsServiceException {

        OrderReferenceDetails response = this.example.getOrderDetails();
        validateResponseNotNull(response, "OrderReferenceDetails");

        System.out.println("Please Enter Order Sub Total for this Sample: ");
        double subTotal = Double.valueOf(in.next().trim());
        /*
         * This sample uses 3 options for shipping type:
         * 1. Standard Shipping
         * 2. Two Day Shipping
         * 3. Next Day Shipping
         */
        int shippingOption;
        do {
            System.out.println("Shipping Type:");
            System.out.println("1. Standard Shipping");
            System.out.println("2. Two Day Shipping");
            System.out.println("3. Next Day Shipping");
            System.out.println("Your Option?");
            shippingOption = Integer.valueOf(in.next().trim());
        } while (shippingOption < 1 || shippingOption > 3);

        /*
         * Following inputs are for setting order detail.
         * These are OPTIONAL, you can skip by pressing enter:
         * Use SellerOrderAttribute to set sellerOrderId, storeName,
         * orderItemCategories, customInformation.
         */
        String optionalSellerNote = getUserStringFromConsole("Seller Note");
        SellerOrderAttributes optionalSellerOrderAttributes = getSellerOrderAttributes();

        example.addOrderReferenceDetails(optionalSellerNote, response.getAmazonOrderReferenceId(),
                optionalSellerOrderAttributes.getCustomInformation(), optionalSellerOrderAttributes.getStoreName(),
                String.valueOf(subTotal), String.valueOf(shippingOption));

    }

    /**
     * Method to get required and optional parameters
     * for authorization, then calls method to call
     * Authorize based on the type of Authorization.
     * 
     * @param captureNow
     * @param authOption
     * @throws OffAmazonPaymentsServiceException
     */
    private AuthorizationDetails authorize(boolean captureNow, int authOption, String providerId, String creditAmount)
            throws OffAmazonPaymentsServiceException {
        String optionalSoftDescriptor = null;
        if (captureNow) {
            optionalSoftDescriptor = getUserStringFromConsole("Soft Descriptor");
        }
        String optionalSellerAuthNote = getUserStringFromConsole("Seller Authorization Note");

        return authorizeBasedOnType(captureNow, authOption, optionalSoftDescriptor, optionalSellerAuthNote, providerId,
                creditAmount);
    }

    /**
     * Method to call Authorize based on the type
     * of Authorization selected
     * 
     * @param captureNow
     * @param authOption
     * @param optionalSoftDescriptor
     * @param optionalSellerAuthNote
     * @throws OffAmazonPaymentsServiceException
     */
    private AuthorizationDetails authorizeBasedOnType(boolean captureNow, int authOption,
            String optionalSoftDescriptor, String optionalSellerAuthNote, String providerId, String creditAmount)
            throws OffAmazonPaymentsServiceException {
        example.authorize(captureNow, authOption, optionalSoftDescriptor, optionalSellerAuthNote, providerId,
                creditAmount);
        if (authOption == 1) {
            this.waitForAuthorization();
        }
        return getAuthorizationDetailsIfOpenState(example.getAuthorizationDetails(), captureNow);
    }

    /**
     * Method to wait for Authorization to change from Pending state
     * and then check if it's final state
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void waitForAuthorization() throws OffAmazonPaymentsServiceException {
        System.out.println("Waiting for authorization to complete...");
        this.example.cliWaitUntilAuthorizationComplete();

    }

    /**
     * Method to check Authorization state
     * If the final state is OPEN, it returns Authorization Details
     * If State is CLOSED and If Capture Now is set to true, it return NULL
     * else throws exception
     * 
     * @param GetAuthorizationDetailsResponse
     * @param captureNow
     * @return AuthorizationDetails
     * @throws OffAmazonPaymentsServiceException
     */
    private AuthorizationDetails getAuthorizationDetailsIfOpenState(GetAuthorizationDetailsResponse response,
            boolean captureNow) throws OffAmazonPaymentsServiceException {
        validateResponseNotNull(response, "GetAuthorizationDetailsResponse");
        String authStatus = response.getGetAuthorizationDetailsResult().getAuthorizationDetails()
                .getAuthorizationStatus().getState();
        if ((!authStatus.toUpperCase().equals("OPEN"))) {
            if (captureNow && authStatus.toUpperCase().equals("CLOSED")) {
                GetAuthorizationDetailsSample.printResponse(response, outStream);
                return null;
            } else {
                throw new OffAmazonPaymentsServiceException("Authorization State is " + authStatus
                        + ". Cannot capture this Authorization");
            }
        } else {
            GetAuthorizationDetailsSample.printResponse(response, outStream);
            return response.getGetAuthorizationDetailsResult().getAuthorizationDetails();
        }
    }

    /**
     * Method to get capture details and
     * make capture request with provided info from console
     * 
     * @param authDetails
     * @param providerId
     * @param creditAmount
     * @throws OffAmazonPaymentsServiceException
     * @return CaptureResponse
     */
    private CaptureResponse capture(AuthorizationDetails authDetails, String providerId, String creditAmount)
            throws OffAmazonPaymentsServiceException {
        validateResponseNotNull(authDetails, "AuthorizationDetails");
        String optionalSoftDescriptor = getUserStringFromConsole("Soft Descriptor");
        String optionalSellerCaptureNote = getUserStringFromConsole("Seller Capture Note");
        CaptureResponse captureResponse = this.example.captureOrderAmount(authDetails.getAuthorizationAmount()
                .getAmount(), authDetails.getAuthorizationAmount().getCurrencyCode(), authDetails
                .getAmazonAuthorizationId(), optionalSoftDescriptor, optionalSellerCaptureNote, providerId,
                creditAmount);
        validateResponseNotNull(captureResponse, "CaptureResponse");
        CaptureSample.printResponse(captureResponse, outStream);
        return captureResponse;
    }

    /**
     * Method to wait for Capture Details to have
     * Provider Credit Summary List
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private ProviderCreditSummaryList waitForCaptureDetailsWithProviderCreditSummaryList(String amazonCaptureId)
            throws OffAmazonPaymentsServiceException {
        System.out.println("Waiting for capture details to have Provider Credit Summary List...");
        return this.example.waitForCaptureDetailsWithProviderCreditSummaryList(amazonCaptureId)
                .getProviderCreditSummaryList();
    }

    /**
     * Method to Get Provider Credit Details from
     * Provider Credit Summary List
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void getProviderCreditDetails(ProviderCreditSummaryList providerCreditSummaryList)
            throws OffAmazonPaymentsServiceException {
        if (providerCreditSummaryList == null || !providerCreditSummaryList.isSetMember()) {
            throw new OffAmazonPaymentsServiceException("Null Provider Credit Summary List from Capture Details.");
        }
        for (ProviderCreditSummary providerCreditSummary : providerCreditSummaryList.getMember()) {
            GetProviderCreditDetailsResponse getProviderCreditDetailsResponse = this.example
                    .getProviderCreditDetails(providerCreditSummary.getProviderCreditId());
            validateResponseNotNull(getProviderCreditDetailsResponse, "GetProviderCreditDetailsResponse");
            GetProviderCreditDetailsSample.printResponse(getProviderCreditDetailsResponse, outStream);
        }
    }

    /**
     * Method to read Optional Seller Attributes for this Order
     * Gets following detail:
     * -sellerOrderId
     * -sellerCustomNotes
     * -storeName
     * -orderItemCategories
     * 
     * @return
     */
    private SellerOrderAttributes getSellerOrderAttributes() {
        SellerOrderAttributes optionalSellerOrderAttributes = new SellerOrderAttributes();

        String sellerOrderId = this.getUserStringFromConsole("seller order id for this order: ");
        if (sellerOrderId != null && !sellerOrderId.equals("")) {
            optionalSellerOrderAttributes.setSellerOrderId(sellerOrderId);
        }

        String sellerCustomNotes = this.getUserStringFromConsole("your custom notes for this order: ");
        if (sellerCustomNotes != null && !sellerCustomNotes.equals("")) {
            optionalSellerOrderAttributes.setCustomInformation(sellerCustomNotes);
        }

        String storeName = this.getUserStringFromConsole("your store name: ");
        if (storeName != null && !storeName.equals("")) {
            optionalSellerOrderAttributes.setStoreName(storeName);
        }

        return optionalSellerOrderAttributes;
    }



}
