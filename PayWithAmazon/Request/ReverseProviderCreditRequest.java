package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.HashMap;
import java.util.Map;

public class ReverseProviderCreditRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    //required parameters
    private String amazonProviderCreditId = null;
    private String creditReversalReferenceId = null;
    private String creditReversalAmount = null;
    private String creditReversalAmountCurrencyCode = null;
    
    //optional parameters
    private String creditReversalNote  = null;
    private String mwsAuthToken = null;

    public  ReverseProviderCreditRequest setAmazonProviderCreditId(String amazonProviderCreditId) {
        this.amazonProviderCreditId = amazonProviderCreditId;
        parameters.put(ParamConstants.AMAZON_PROVIDER_CREDIT_ID , this.amazonProviderCreditId);
        return this;
    }

    public  ReverseProviderCreditRequest setCreditReversalReferenceId(String creditReversalReferenceId) {
        this.creditReversalReferenceId = creditReversalReferenceId;
        parameters.put(ParamConstants.CREDIT_REVERSAL_REFERENCE_ID , this.creditReversalReferenceId);
        return this;
    }

    public ReverseProviderCreditRequest setCreditReversalAmount(String creditReversalAmount) {
        this.creditReversalAmount = creditReversalAmount;
        parameters.put(ParamConstants.CREDIT_REVERSAL_AMOUNT , this.creditReversalAmount);
        return this;
    }

    public ReverseProviderCreditRequest setCreditReversalAmountCurrencyCode(String creditReversalAmountCurrencyCode) {
        this.creditReversalAmountCurrencyCode = creditReversalAmountCurrencyCode;
        parameters.put(ParamConstants.CREDIT_REVERSAL_AMOUNT_CURRENCY_CODE , this.creditReversalAmountCurrencyCode);
        return this;
    }

    public ReverseProviderCreditRequest setCreditReversalNote(String creditReversalNote) {
        this.creditReversalNote = creditReversalNote;
        parameters.put(ParamConstants.CREDIT_REVERSAL_NOTE , this.creditReversalNote);
        return this;
    }
    
    public ReverseProviderCreditRequest setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN , this.mwsAuthToken);
        return this;
    }
            
    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
