package com.amazon.payments.paywithamazon.request;

import com.amazon.payments.paywithamazon.types.CurrencyCode;
import java.util.*;
import com.amazon.payments.paywithamazon.response.model.ProviderCredit;
import java.io.Serializable;

/**
 *  For more information documentation, see
 * https://payments.amazon.com/documentation/
 */

public class CaptureRequest implements Serializable {

    //required parameters
    private String amazonAuthorizationId;
    private String captureReferenceId;
    private String captureAmount;
    private CurrencyCode captureCurrencyCode;

    //optional parameters
    private String sellerCaptureNote;
    private String softDescriptor;
    private String mwsAuthToken;
    private List<ProviderCredit> providerCredit;

    /*
    * @param amazonAuthorizationId
    *               The authorization identifier that was generated by
    *               Amazon in the earlier call to Authorize or AuthorizeOnBillingAgreement.
    * @param captureReferenceId
    *               The identifier for this capture transaction that you specify.
    *               This identifier must be unique for all your capture transactions.
    * @param captureAmount
    *               The amount to capture in this transaction.
    * @return
    *           Container holding Capture operation parameters
    *
    */
    public CaptureRequest(String amazonAuthorizationId, String captureReferenceId, String captureAmount) {
        this.amazonAuthorizationId = amazonAuthorizationId;
        this.captureReferenceId = captureReferenceId;
        this.captureAmount = captureAmount;

    }
    /**
     * @param currencyCode
     *       Three-digit currency code. In ISO 4217 format.
     *
     * @return AuthorizeRequest
     */
    public CaptureRequest setCaptureCurrencyCode(CurrencyCode currencyCode) {
        this.captureCurrencyCode = currencyCode;
        return this;
    }

    /**
     * @param sellerCaptureNote
     *       A description for the capture transaction that is displayed in emails to the buyer.
     *
     */
    public CaptureRequest setSellerCaptureNote(String sellerCaptureNote) {
        this.sellerCaptureNote = sellerCaptureNote;
        return this;
    }

    /**
     * @param softDescriptor The description to be shown on the buyer's payment instrument statement.
     *                       The soft descriptor sent to the payment processor is:
     *                       “AMZ* <soft descriptor specified here>”.
     */
    public CaptureRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        return this;
    }

    /**
     * Applicable for third-party solution providers only.
     *
     * @param mwsAuthToken
     */
    public CaptureRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * Applicable for third-party solution providers only.
     *
     * @param providerCreditList associated with Authorize operation
     *
     */
    public CaptureRequest setProviderCredit(List<ProviderCredit> providerCreditList) {
        this.providerCredit = providerCreditList;
        return this;
    }

    /**
     *  The authorization identifier that was generated by
     *   Amazon in the earlier call to Authorize or AuthorizeOnBillingAgreement.
     * @return Authorization identifier specified in request
     */
    public String getAmazonAuthorizationId() {
        return amazonAuthorizationId;
    }

    /**
     * The identifier for this capture transaction that you specify. 
     *
     * @return Capture Reference Id specified in request
     */
    public String getCaptureReferenceId() {
        return captureReferenceId;
    }

    /**
     *  The amount to capture in this transaction.
     *
     * @return Capture amount specified in request
     */
    public String getCaptureAmount() {
        return captureAmount;
    }

    /**
     * Three-digit currency code. In ISO 4217 format.
     *
     * @return Currency code specified in request
     */
    public CurrencyCode getCaptureCurrencyCode() {
        return captureCurrencyCode;
    }

    /**
     * A description for the capture transaction that is displayed in emails to the buyer.
     *
     * @return SellerCaptureNote specified in request
     */
    public String getSellerCaptureNote() {
        return sellerCaptureNote;
    }

    /**
     * The description to be shown on the buyer's payment instrument statement. 
     *                       The soft descriptor sent to the payment processor is:
     *                       “AMZ* <soft descriptor specified here>”.
     *
     * @return Soft descriptor string for Capture operation
     */
    public String getSoftDescriptor() {
        return softDescriptor;
    }

    /**
     * Applicable for third-party solution providers only
     *
     * @return mwsAuthToken for Capture operation
     */
    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    /**
     * Applicable for third-party solution providers only.
     *
     * @return ProviderCredit associated with Authorize operation
     */
    public List<ProviderCredit> getProviderCredit() {
        return providerCredit;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CaptureRequest{" + "amazonAuthorizationId=" + amazonAuthorizationId + ", captureReferenceId=" + captureReferenceId + ", captureAmount="
                + captureAmount + ", captureCurrencyCode=" + captureCurrencyCode + ", sellerCaptureNote=" + sellerCaptureNote + ", softDescriptor="
                + softDescriptor + ", mwsAuthToken=" + mwsAuthToken + ", providerCredit=" + providerCredit + '}';
    }



}
