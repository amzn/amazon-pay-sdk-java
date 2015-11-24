package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.GetOrderReferenceDetailsResponse;
import com.amazon.payments.paywithamazon.response.model.OrderReferenceDetails;
import java.io.Serializable;

/**
 * Response from GetOrderReferenceDetails service API, as returned by Amazon Payments
 */
public final class GetOrderReferenceDetailsResponseData  extends ResponseData implements Serializable{
    
    private String requestId;
    private OrderReferenceDetails orderReferenceDetails;
    
    public GetOrderReferenceDetailsResponseData(GetOrderReferenceDetailsResponse response , ResponseData rawResponse) {
        super(rawResponse);
        if(response != null) {
            this.requestId = response.getResponseMetadata().getRequestId();
            if(response.getGetOrderReferenceDetailsResult() != null) { 
               orderReferenceDetails = response.getGetOrderReferenceDetailsResult().getOrderReferenceDetails();
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
     * Encapsulates details about an Order Reference object and its current state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752660
     * @return orderReferenceDetails
     */
    public OrderReferenceDetails getDetails() {
        return orderReferenceDetails;
    }

    /**
     * Returns the string representation of GetOrderReferenceDetailsResponseData
     */
    @Override
    public String toString() {
        return "GetOrderReferenceDetailsResponseData{" + "requestId=" + requestId + ", orderReferenceDetails=" + orderReferenceDetails.toString() + '}';
    }
    
    
    

}
