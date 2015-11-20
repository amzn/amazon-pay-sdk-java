package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.CaptureDetails;
import com.amazon.payments.paywithamazon.response.model.CaptureResponse;
import java.io.Serializable;

/**
 * Response from Capture service API, as returned by Amazon Payments
 */
public final class CaptureResponseData extends ResponseData implements Serializable{
    
    private String requestId;
    private CaptureDetails captureDetails;
    
    public CaptureResponseData(CaptureResponse captureResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(captureResponse != null) {
            if(captureResponse.getCaptureResult() != null) {
                captureDetails = captureResponse.getCaptureResult().getCaptureDetails();
            }
            this.requestId = captureResponse.getResponseMetadata().getRequestId();
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
