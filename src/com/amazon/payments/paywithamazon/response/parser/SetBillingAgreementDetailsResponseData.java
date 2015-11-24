package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.BillingAgreementDetails;
import com.amazon.payments.paywithamazon.response.model.SetBillingAgreementDetailsResponse;
import java.io.Serializable;

/**
 * Response from SetBillingAgreementDetails service API, as returned by Amazon Payments
 */
public final class SetBillingAgreementDetailsResponseData extends ResponseData implements Serializable{
    
    private String requestId;
    private BillingAgreementDetails billingAgreementDetails;
    
    public SetBillingAgreementDetailsResponseData(SetBillingAgreementDetailsResponse response , ResponseData rawResponse) {
        super(rawResponse);
        if(response != null) {
            this.requestId = response.getResponseMetadata().getRequestId();
            if(response.getSetBillingAgreementDetailsResult() != null) { 
               billingAgreementDetails = response.getSetBillingAgreementDetailsResult().getBillingAgreementDetails();
            }
        }
    }

    
    /**
     * @return  The requestID that uniquely identifies the service request
     * the caller made.
     */
    public String getRequestId() {
        return requestId;
    }
    
    /**
     * Encapsulates details about a Billing Agreement object and its current state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752500
     * 
     * @return billingAgreementDetails
     */
    public BillingAgreementDetails getDetails() {
        return billingAgreementDetails;
    }

    @Override
    public String toString() {
        return "SetBillingAgreementDetailsResponseData{" + "requestId=" + requestId + ", billingAgreementDetails=" + billingAgreementDetails.toString() + '}';
    }
    
    
    

}
