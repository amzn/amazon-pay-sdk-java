package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.GetRefundDetailsResponse;
import com.amazon.payments.paywithamazon.response.model.RefundDetails;
import java.io.Serializable;

public final class GetRefundDetailsResponseData  extends ResponseData implements Serializable{
    
    private String requestId;
    private RefundDetails refundDetails;
    
    public GetRefundDetailsResponseData(GetRefundDetailsResponse getRefundDetailsResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(getRefundDetailsResponse != null) {
            if(getRefundDetailsResponse.getGetRefundDetailsResult() != null) {
                refundDetails = getRefundDetailsResponse.getGetRefundDetailsResult().getRefundDetails();
            }
            this.requestId = getRefundDetailsResponse.getResponseMetadata().getRequestId();
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
     * Encapsulates details about a Refund object and its status.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752740
     * 
     * @return refundDetails
     */
    public RefundDetails getDetails() {
        return refundDetails;
    }

}
