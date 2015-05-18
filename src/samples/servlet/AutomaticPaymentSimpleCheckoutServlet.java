package samples.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.BillingAddress;
import com.amazonservices.mws.offamazonpayments.model.BillingAgreementDetails;
import com.amazonservices.mws.offamazonpayments.model.CaptureResponse;
import com.amazonservices.mws.offamazonpayments.model.Destination;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationDetails;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationNotification;

import samples.CaptureSample;
import samples.AutomaticPaymentSimpleCheckoutExample;
import samples.utils.TaxAndShippingRates;
import samples.utils.Utilities;

public class AutomaticPaymentSimpleCheckoutServlet extends IpnExampleServletBase {

    private static final long serialVersionUID = 1L;
    AutomaticPaymentSimpleCheckoutExample example = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        outStream = response.getWriter();
        String amazonBillingAgreementId = request.getParameter("BillingAgreementId");
        example = new AutomaticPaymentSimpleCheckoutExample(amazonBillingAgreementId, config, service, outStream);
        runSample(request);
    }

    /**
     * Method to demonstrate the sample.
     * Invoking this method will walk through all
     * API calls that will be required for automatic payment
     * using billing agreement
     */
    public void runSample(HttpServletRequest request) {
        this.printMessage("<html><head><title>Automatic payment simple checkout result</title></head><body><div><pre>");
        try {
            double paymentTotal = getPaymentTotal(request);
            String amazonBillingAgreementId = request.getParameter("BillingAgreementId");

            example.setBillingAgreementDetails(amazonBillingAgreementId, request.getParameter("CustomNote"),
                    request.getParameter("StoreName"), request.getParameter("SellerNote"));
            this.printMessage("Billing Agreement is set with provided details.");

            this.printMessage("Now confirming this billing agreement...");
            example.confirmBillingAgreement();
            this.printMessage("Billing Agreement is confirmed and " + "moved to 'OPEN' state");

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

            this.printMessage("Now Closing the Billing Agreement...");
            example.closeBillingAgreement();
            this.printMessage("Billing Agreement Moved to CLOSED state.");
            this.printMessage("Automatic Payment Simple Checkout Example is complete.");

        } catch (OffAmazonPaymentsServiceException ex) {
            outStream.println("Caught Exception: " + ex.getMessage());
            outStream.println("Response Status Code: " + ex.getStatusCode());
            outStream.println("Error Code: " + ex.getErrorCode());
            outStream.println("Error Type: " + ex.getErrorType());
            outStream.println("Request ID: " + ex.getRequestId());
            outStream.println("XML: " + ex.getXML());
            outStream.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
            ex.printStackTrace(outStream);
        } finally {
            this.printMessage("</pre></div></body></html>");
        }
    }

    /**
     * Method to get sub total and Shipping type from console.
     * It returns Payment Total calculated with tax and shipping charge
     * provided from console
     * 
     * @throws OffAmazonPaymentsServiceException
     */
    private double getPaymentTotal(HttpServletRequest request) throws OffAmazonPaymentsServiceException {
        BillingAgreementDetails response = example.getBillingAgreementDetails();
        validateResponseNotNull(response, "BillingAgreementDetails");
        double subTotal = Double.parseDouble(request.getParameter("Subtotal"));
        int shippingOption = Integer.parseInt(request.getParameter("ShippingType"));
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
        String amazonAuthId = example.authorizeOnBillingAgreement(paymentAmount, authReferenceId, authWithCaptureNow,
                "", "");
        AuthorizationDetails authDetails = this.waitForAuthorizationNotification(amazonAuthId, authWithCaptureNow);
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

    private AuthorizationDetails waitForAuthorizationNotification(String amazonAuthorizationId,
            boolean authWithCaptureNow) throws OffAmazonPaymentsServiceException {
        outStream.println("Waiting for authorization to complete...");
        AuthorizationNotification response = this.example.servletWaitUntilAuthorizationComplete(amazonAuthorizationId);
        validateResponseNotNull(response, "AuthorizationNotification");
        String authStatus = response.getAuthorizationDetails().getAuthorizationStatus().getState();
        if ((!authStatus.toUpperCase().equals("OPEN"))) {
            if (authWithCaptureNow && authStatus.toUpperCase().equals("CLOSED")) {
                Utilities.printAuthorizationNotification(response, outStream);
                return null;
            } else {
                throw new OffAmazonPaymentsServiceException("Authorization State is " + authStatus
                        + ". Cannot capture this Authorization");
            }
        } else {
            Utilities.printAuthorizationNotification(response, outStream);
            return response.getAuthorizationDetails();
        }
    }

    private void capture(AuthorizationDetails authDetails) throws OffAmazonPaymentsServiceException {
        validateResponseNotNull(authDetails, "AuthorizationDetails");
        CaptureResponse captureResponse = this.example.captureOrderAmount(authDetails.getAuthorizationAmount()
                .getAmount(), authDetails.getAuthorizationAmount().getCurrencyCode(), authDetails
                .getAmazonAuthorizationId(), authDetails.getAuthorizationReferenceId() + "-c01", "", "");
        validateResponseNotNull(captureResponse, "CaptureResponse");
        CaptureSample.printResponse(captureResponse, outStream);

    }

}
