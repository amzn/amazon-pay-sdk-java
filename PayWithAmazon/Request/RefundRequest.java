package PayWithAmazon.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://payments.amazon.com/documentation/apireference/201751630#201752010
 * @author nehaa
 */
public class RefundRequest {
    
    private Map<String,String> parameters = new HashMap<String,String>();
    
    //required parameters
    private String amazonCaptureId = null;
    private String refundReferenceId = null;
    private String refundAmount = null;
    
    //optional parameters
    private String sellerRefundNote = null;
    private String softDescriptor = null;
    private String mwsAuthToken = null;   
    private List<Map<String,String>> providerCreditReversalDetails = new ArrayList<Map<String,String>>();

    public RefundRequest setAmazonCaptureId(String captureId) {
        this.amazonCaptureId = captureId;
        parameters.put(ParamConstants.AMAZON_CAPTURE_ID, captureId);
        return this;
    }
    
    public RefundRequest setRefundReferenceId(String refundReferenceId) {
        this.refundReferenceId = refundReferenceId;
        parameters.put(ParamConstants.REFUND_REFERENCE_ID, refundReferenceId);
        return this;
    }

    public RefundRequest setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
        parameters.put(ParamConstants.REFUND_AMOUNT, refundAmount);
        return this;
    }

    public RefundRequest setSellerRefundNote(String sellerRefundNote){
        this.sellerRefundNote = sellerRefundNote;
         parameters.put(ParamConstants.SELLER_REFUND_NOTE, sellerRefundNote);
         return this;
    }

    public RefundRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        parameters.put(ParamConstants.SOFT_DESCRIPTOR, softDescriptor);
        return this;
    }

    public RefundRequest setProviderCreditReversalDetails(List<Map<String, String>> providerCreditReversalDetails) {
        this.providerCreditReversalDetails = providerCreditReversalDetails;
        int member = 0;
        for (Map<String,String> m : this.providerCreditReversalDetails) {
            parameters.put("ProviderCreditReversalList.member."+member+".ProviderId", m.get("providerId") );
            parameters.put("ProviderCreditReversalList.member."+member+".CreditReversalAmount.Amount", m.get("amount") );
            parameters.put("ProviderCreditReversalList.member."+member+".CreditReversalAmount.CurrencyCode", m.get("currencyCode") );
            member++;
        }
        return this;
    }
    
    public RefundRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    public Map<String,String> getParamMap() {
        return parameters;
    }
    
}
