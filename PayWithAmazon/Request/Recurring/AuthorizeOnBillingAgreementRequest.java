package PayWithAmazon.Request.Recurring;

import PayWithAmazon.Request.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Build request for Authorize API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752010
 */

/**
 * https://payments.amazon.com/documentation/apireference/201752640#201751940
 * @author nehaa
 */
public class AuthorizeOnBillingAgreementRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    //required parameters
    private String amazonBillingAgreementId = null;
    private String authorizationReferenceId = null;
    private String authorizationAmount = null;
    
    //optional parameters
    private String sellerAuthorizationNote = null;
    private String transactionTimeout = null;
    private String captureNow;
    private String softDescriptor = null;
    private String platformId = null;
    private String sellerNote = null;
    private String InheritShippingAddress = null;
    private String mwsAuthToken = null;


    public AuthorizeOnBillingAgreementRequest setAmazonBillingAgreementId(String amazonBillingAgreementId) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        parameters.put(ParamConstants.AMAZON_BILLING_AGREEMENT_ID, amazonBillingAgreementId);
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setAuthorizationReferenceId(String authorizationReferenceId) {
        this.authorizationReferenceId = authorizationReferenceId;
        parameters.put(ParamConstants.AUTHORIZATION_REFERENCE_ID, authorizationReferenceId);
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setAuthorizationAmount(String authorizationAmount) {
        this.authorizationAmount = authorizationAmount;
        parameters.put(ParamConstants.AUTHORIZATION_AMOUNT, authorizationAmount);
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setSellerAuthorizationNote(String sellerAuthorizationNote){
        this.sellerAuthorizationNote = sellerAuthorizationNote;
         parameters.put(ParamConstants.SELLER_AUTHORIZATION_NOTE, sellerAuthorizationNote);
        return this;

    }
    
    public AuthorizeOnBillingAgreementRequest setTransactionTimeout(String TransactionTimeout) {
        this.transactionTimeout = TransactionTimeout;
        parameters.put(ParamConstants.TRANSACTION_TIMEOUT, TransactionTimeout);
        return this;

    }
    
    
    public AuthorizeOnBillingAgreementRequest setCaptureNow(String CaptureNow) {
        this.captureNow = CaptureNow;
        parameters.put(ParamConstants.CAPTURE_NOW, CaptureNow);
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        parameters.put(ParamConstants.SOFT_DESCRIPTOR, softDescriptor);
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setPlatformId(String platformId) {
        this.platformId = platformId;
        parameters.put(ParamConstants.PLATFORM_ID, platformId);
        return this;
    }

    
    public AuthorizeOnBillingAgreementRequest setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
        parameters.put(ParamConstants.SELLER_NOTE, sellerNote);
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setInheritShippingAddress(String InheritShippingAddress) {
        this.InheritShippingAddress = InheritShippingAddress;
        parameters.put(ParamConstants.INHERIT_SHIPPING_ADDRESS, InheritShippingAddress);
        return this;
    }

    public AuthorizeOnBillingAgreementRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
