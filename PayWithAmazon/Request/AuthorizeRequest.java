package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Build request for Authorize API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752010
 */
public class AuthorizeRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    private static final String action = "Authorize";
    
    //required parameters
    private String amazonOrderReferenceId = null;
    private String authorizationReferenceId = null;
    private String authorizationAmount = null;
    private String authorizationCurrencyCode = null;
    
    //optonal parameters
    private String sellerAuthorizationNote = null;
    private String transactionTimeout = null;
    private String captureNow;
    private String softDescriptor = null;
    private String mwsAuthToken = null;
    private List<Map<String,String>> providerCreditDetails = new ArrayList<Map<String,String>>();
    
    public AuthorizeRequest setAmazonOrderReferenceId(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        parameters.put(ParamConstants.AMAZON_ORDER_REFERENCE_ID, amazonOrderReferenceId);
        return this;
    }
    

    public AuthorizeRequest setAuthorizationReferenceId(String authorizationReferenceId) {
        this.authorizationReferenceId = authorizationReferenceId;
        parameters.put(ParamConstants.AUTHORIZATION_REFERENCE_ID, authorizationReferenceId);
        return this;
    }

    public AuthorizeRequest setAuthorizationAmount(String authorizationAmount) {
        this.authorizationAmount = authorizationAmount;
        parameters.put(ParamConstants.AUTHORIZATION_AMOUNT, authorizationAmount);
        return this;
    }
    
    public AuthorizeRequest setAuthorizationCurrencyCode(String authorizationCurrencyCode) {
        this.authorizationCurrencyCode = authorizationCurrencyCode;
        parameters.put(ParamConstants.AUTHORIZATION_CURRENCEYCODE, authorizationCurrencyCode);
        return this;
    }

    public AuthorizeRequest setSellerAuthorizationNote(String sellerAuthorizationNote){
        this.sellerAuthorizationNote = sellerAuthorizationNote;
         parameters.put(ParamConstants.SELLER_AUTHORIZATION_NOTE, sellerAuthorizationNote);
        return this;
    }
    

    public AuthorizeRequest setTransactionTimeout(String TransactionTimeout) {
        this.transactionTimeout = TransactionTimeout;
        parameters.put(ParamConstants.TRANSACTION_TIMEOUT, TransactionTimeout);
        return this;
    }
    

    public AuthorizeRequest setCaptureNow(String CaptureNow) {
        this.captureNow = CaptureNow;
        parameters.put(ParamConstants.CAPTURE_NOW, CaptureNow);
        return this;
    }

    public AuthorizeRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        parameters.put(ParamConstants.SOFT_DESCRIPTOR, softDescriptor);
        return this;
    }

    public AuthorizeRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public AuthorizeRequest setProviderCreditDetails(List<Map<String, String>> providerCreditDetails) {
        this.providerCreditDetails = providerCreditDetails;
        int member = 0;
        for (Map<String,String> m : this.providerCreditDetails) {
            parameters.put("ProviderCreditList.member."+member+".ProviderId", m.get("providerId") );
            parameters.put("ProviderCreditList.member."+member+".CreditAmount.Amount", m.get("amount") );
            parameters.put("ProviderCreditList.member."+member+".CreditAmount.CurrencyCode", m.get("currencyCode") );
            member++;
        }
        return this;
    }
    
    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
