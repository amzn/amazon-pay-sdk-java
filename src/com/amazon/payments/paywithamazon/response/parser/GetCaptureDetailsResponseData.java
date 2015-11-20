package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.CaptureDetails;
import com.amazon.payments.paywithamazon.response.model.GetCaptureDetailsResponse;
import java.io.Serializable;

public final class GetCaptureDetailsResponseData  extends ResponseData implements Serializable{
    
    private String requestId;
    private CaptureDetails captureDetails;
    
    public GetCaptureDetailsResponseData(GetCaptureDetailsResponse getCaptureDetailsResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(getCaptureDetailsResponse != null) {
            if(getCaptureDetailsResponse.getGetCaptureDetailsResult() != null) {
                captureDetails = getCaptureDetailsResponse.getGetCaptureDetailsResult().getCaptureDetails();
            }
            this.requestId = getCaptureDetailsResponse.getResponseMetadata().getRequestId();
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
     * Encapsulates details about a Capture object and its status.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752580
     * 
     * @return captureDetails
     */
    public CaptureDetails getDetails() {
        return captureDetails;
    }

}
