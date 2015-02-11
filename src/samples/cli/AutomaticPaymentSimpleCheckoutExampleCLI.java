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
 * *****************************************************************************
 *
 */

package samples.cli;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.AuthorizationDetails;
import com.amazonservices.mws.offamazonpayments.model.BillingAddress;
import com.amazonservices.mws.offamazonpayments.model.BillingAgreementDetails;
import com.amazonservices.mws.offamazonpayments.model.CaptureResponse;
import com.amazonservices.mws.offamazonpayments.model.Destination;
import com.amazonservices.mws.offamazonpayments.model.GetAuthorizationDetailsResponse;
import com.amazonservices.mws.offamazonpayments.model.SellerBillingAgreementAttributes;

import samples.CaptureSample;
import samples.GetAuthorizationDetailsSample;
import samples.AutomaticPaymentSimpleCheckoutExample;
import samples.utils.TaxAndShippingRates;

/**
 * Automatic payment simple checkout example command line example
 * 
 * This class drives the automatic payment simple checkout example by
 * getting required inputs via command line
 */
public class AutomaticPaymentSimpleCheckoutExampleCLI extends CLIHelperClass {

    private String amazonBillingAgreementId;
    private AutomaticPaymentSimpleCheckoutExample example;

    public AutomaticPaymentSimpleCheckoutExampleCLI() {
        super(false);
        this.amazonBillingAgreementId = getBillingAgreementId();
        this.example = new AutomaticPaymentSimpleCheckoutExample(amazonBillingAgreementId, config, service, outStream);
    }

    public static void main(String[] args) {
        AutomaticPaymentSimpleCheckoutExampleCLI AutomaticPaymentSample = new AutomaticPaymentSimpleCheckoutExampleCLI();
        AutomaticPaymentSample.runSample();
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all API calls
     * that will be required for a simple automatic payment example
     */
    public void runSample() {
        try {
            double paymentTotal = this.getPaymentTotal();

            this.setBillingAgreementDetails();
            this.printMessage("Billing Agreement is set with provided details.");

            this.printMessage("Now confirming this billing agreement...");
            example.confirmBillingAgreement();
            this.printMessage("Billing Agreement is confirmed and " + "moved to 'OPEN' state.");

            this.printMessage("Now validating this billing agreement... " + "(optional)");
            example.validateBillingAgreement();
            this.printMessage("Billing Agreement is validated");

            this.printMessage("Making first payment...");
            boolean authWithCaptureNow = false;
            this.makePayment(paymentTotal, amazonBillingAgreementId + "-a01", authWithCaptureNow);
            this.printMessage("First payment is complete.");

            this.printMessage("Making second payment...");
            this.makePayment(paymentTotal, amazonBillingAgreementId + "-a02", authWithCaptureNow);
            this.printMessage("Second payment is complete.");

            this.printMessage("Making third payment with capture now ...");
            authWithCaptureNow = true;
            this.makePayment(paymentTotal, amazonBillingAgreementId + "-a03", authWithCaptureNow);
            this.printMessage("Third payment is complete.");

            /*
             * Add more payments here ...
             */

            this.printMessage("Now Closing the Billing Agreement...");
            example.closeBillingAgreement();
            this.printMessage("Billing Agreement Moved to CLOSED state.");
            this.printMessage("Automatic Payment Simple Checkout Example is complete.");

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
     * Method to get Amazon Billing Agreement Id through console
     */
    private String getBillingAgreementId() {
        outStream.println("Enter a valid Amazon Billing Agreement Id " + "to run this sample "
                + "(NOTE: ID should be in DRAFT state to execute this sample): ");
        String amazonBillingAgreementId = in.nextLine().trim();
        if (amazonBillingAgreementId.equals("")) {
            outStream.println("Missing Amazon Billing Agreement Id or invalid entry"
                    + "...Amazon Billing Agreement ID is required to run this sample");
            System.exit(0);
        }
        return amazonBillingAgreementId.trim();
    }

    /**
     * Method to set optional parameters such as sellerBillingAgreementId,
     * PlatformId, SellerNote, CustomInformation, and StoreName
     * provided from console
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private void setBillingAgreementDetails() throws OffAmazonPaymentsServiceException {
        /*
         * Following inputs are for setting billing agreement detail.
         * These are OPTIONAL, you can skip by pressing enter:
         * Use SellerBillingAgreementAttributes to set sellerBillingAgreementId,
         * storeName, customInformation.
         */
        String optionalSellerNote = getUserStringFromConsole("Seller Note");
        SellerBillingAgreementAttributes optionalSellerBAAttributes = getSellerBillingAgreementAttributes();

        example.setBillingAgreementDetails(optionalSellerBAAttributes.getSellerBillingAgreementId(),
                optionalSellerBAAttributes.getCustomInformation(), optionalSellerBAAttributes.getStoreName(),
                optionalSellerNote);
    }

    /**
     * Method to read Optional Seller Attributes for this Order
     * Gets following detail:
     * -sellerBillingAgreementId
     * -sellerCustomNotes
     * -storeName
     * 
     * @return SellerBillingAgreementAttributes
     */
    private SellerBillingAgreementAttributes getSellerBillingAgreementAttributes() {
        SellerBillingAgreementAttributes optionalSellerBAAttributes = new SellerBillingAgreementAttributes();

        String sellerBillingAgreementId = this.getUserStringFromConsole("seller billing agreement id");
        if (sellerBillingAgreementId != null && !sellerBillingAgreementId.equals("")) {
            optionalSellerBAAttributes.setSellerBillingAgreementId(sellerBillingAgreementId);
        }

        String sellerCustomNotes = this.getUserStringFromConsole("your custom notes");
        if (sellerCustomNotes != null && !sellerCustomNotes.equals("")) {
            optionalSellerBAAttributes.setCustomInformation(sellerCustomNotes);
        }

        String storeName = this.getUserStringFromConsole("your store name");
        if (storeName != null && !storeName.equals("")) {
            optionalSellerBAAttributes.setStoreName(storeName);
        }

        return optionalSellerBAAttributes;
    }

    /**
     * Method to get sub total and Shipping type from console.
     * It returns Payment Total calculated with tax and shipping charge
     * provided from console
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private double getPaymentTotal() throws OffAmazonPaymentsServiceException {
        BillingAgreementDetails response = example.getBillingAgreementDetails();
        validateResponseNotNull(response, "BillingAgreementDetails");
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
        Destination destination = response.getDestination();
        TaxAndShippingRates buyerRates = new TaxAndShippingRates(destination);
        return buyerRates.getTotalAmountWithTaxAndShipping(subTotal, shippingOption);
    }

    /**
     * Method to make a payment by calling authorizeOnBillingAgreement with
     * captureNow option or calling capture call next.
     * 
     * @param paymentAmount
     * @param authReferenceId
     * @param authWithCaptureNow
     * @throws OffAmazonPaymentsServiceException
     */
    private void makePayment(double paymentAmount, String authReferenceId, boolean authWithCaptureNow)
            throws OffAmazonPaymentsServiceException {
        this.printMessage("Now getting details for AuthorizeOnBillingAgreement...");
        String amazonAuthId = this.authorizeOnBillingAgreement(paymentAmount, authReferenceId, authWithCaptureNow);
        AuthorizationDetails authDetails = this.waitForAuthorization(amazonAuthId, authWithCaptureNow);
        if (authWithCaptureNow) {
            this.printMessage("AuthorizationOnBillingAgreement with Capture is complete");
        } else {
            this.printMessage("AuthorizationOnBillingAgreement for this payment "
                    + "is complete and moved to 'OPEN' state");
            this.printMessage("Now getting details for Capture...");
            this.capture(authDetails);
            this.printMessage("Capture for this payment is complete");
        }
    }

    /**
     * Method to get required and optional parameters
     * for authorization and makes request call
     * 
     * @param captureNow
     * @throws OffAmazonPaymentsServiceException
     */
    private String authorizeOnBillingAgreement(double authAmount, String authReferenceId, boolean captureNow)
            throws OffAmazonPaymentsServiceException {
        String optionalSoftDescriptor = null;
        if (captureNow) {
            optionalSoftDescriptor = getUserStringFromConsole("Soft Descriptor");
        }
        String optionalSellerAuthNote = getUserStringFromConsole("Seller Authorization Note");

        return example.authorizeOnBillingAgreement(authAmount, authReferenceId, captureNow, optionalSoftDescriptor,
                optionalSellerAuthNote);
    }

    /**
     * Method to check Authorization state
     * If the final state is OPEN, it returns Authorization Details
     * If State is CLOSED and If Capture Now is set to true, it return NULL
     * else throws exception
     * 
     * @return
     * @throws OffAmazonPaymentsServiceException
     */
    private AuthorizationDetails waitForAuthorization(String amazonAuthorizationId, boolean captureNow)
            throws OffAmazonPaymentsServiceException {
        System.out.println("Waiting for authorization to complete...");
        GetAuthorizationDetailsResponse response = this.example
                .cliWaitUntilAuthorizationComplete(amazonAuthorizationId);
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
     * @throws OffAmazonPaymentsServiceException
     */
    private void capture(AuthorizationDetails authDetails) throws OffAmazonPaymentsServiceException {
        validateResponseNotNull(authDetails, "AuthorizationDetails");
        String optionalSoftDescriptor = getUserStringFromConsole("Soft Descriptor");
        String optionalSellerCaptureNote = getUserStringFromConsole("Seller Capture Note");
        CaptureResponse captureResponse = this.example.captureOrderAmount(authDetails.getAuthorizationAmount()
                .getAmount(), authDetails.getAuthorizationAmount().getCurrencyCode(), authDetails
                .getAmazonAuthorizationId(), authDetails.getAuthorizationReferenceId() + "-c01",
                optionalSoftDescriptor, optionalSellerCaptureNote);
        validateResponseNotNull(captureResponse, "CaptureResponse");
        CaptureSample.printResponse(captureResponse, outStream);

    }

}
