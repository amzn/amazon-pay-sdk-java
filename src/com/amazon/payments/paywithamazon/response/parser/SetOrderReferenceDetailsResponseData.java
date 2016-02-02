package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.SetOrderReferenceDetailsResponse;
import com.amazon.payments.paywithamazon.response.model.OrderReferenceDetails;
import java.io.Serializable;

/**
 * Response from SetOrderReferenceDetails service API, as returned by Amazon Payments
 */
public final class SetOrderReferenceDetailsResponseData extends ResponseData implements Serializable{
    
    private String requestId;
    private OrderReferenceDetails orderDetails;
    
    public SetOrderReferenceDetailsResponseData(SetOrderReferenceDetailsResponse response , ResponseData rawResponse) {
        super(rawResponse);
        if(response != null) {
            this.requestId = response.getResponseMetadata().getRequestId();
            if(response.getSetOrderReferenceDetailsResult() != null) { 
               orderDetails = response.getSetOrderReferenceDetailsResult().getOrderReferenceDetails();
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
     * Encapsulates details about an Order Reference object and its current state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752660
     * 
     * @return authorizationDetails
     *
     */
    public OrderReferenceDetails getDetails() {
        return orderDetails;
    }

    /**
     * Returns the string representation of SetOrderReferenceDetailsResponseData
     */
    @Override
    public String toString() {
        return "SetOrderReferenceDetailsResponseData{" + "requestId=" + requestId + ", orderDetails=" + orderDetails.toString() + '}';
    }
    
    
    

}
