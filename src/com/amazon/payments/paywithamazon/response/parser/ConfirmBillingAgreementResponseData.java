package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.ConfirmBillingAgreementResponse;
import java.io.Serializable;

/**
 * Response from ConfirmBillingAgreement service API, as returned by Amazon Payments
 */
public final class ConfirmBillingAgreementResponseData extends ResponseData implements Serializable{
    
    private String requestId;
    
    public ConfirmBillingAgreementResponseData(ConfirmBillingAgreementResponse confirmBillingAgreementResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(confirmBillingAgreementResponse != null) {
            if(confirmBillingAgreementResponse.getResponseMetadata() != null) {
                this.requestId = confirmBillingAgreementResponse.getResponseMetadata().getRequestId();
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
    
}
