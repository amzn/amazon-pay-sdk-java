package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.CloseBillingAgreementResponse;
import java.io.Serializable;

/**
 * Response from CloseBillingAgreement service API, as returned by Amazon Payments
 */
public final class CloseBillingAgreementResponseData  extends ResponseData implements Serializable{
    
    private String requestId;
    
    public CloseBillingAgreementResponseData(CloseBillingAgreementResponse closeBillingAgreementResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(closeBillingAgreementResponse != null) {
            if(closeBillingAgreementResponse.getResponseMetadata() != null) {
                this.requestId = closeBillingAgreementResponse.getResponseMetadata().getRequestId();
            }
        }
    }


    /**
     * The requestID that uniquely identifies the service request
     * the caller made.
     * 
     * @return  The requestID that uniquely identifies the service request
     * the caller made.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Returns the string representation of CloseBillingAgreementResponseData
     */
    @Override
    public String toString() {
        return "CloseBillingAgreementResponseData{" + "requestId=" + requestId + '}';
    }
    
    
}
