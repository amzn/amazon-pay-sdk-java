package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.GetProviderCreditDetailsResponse;
import com.amazon.payments.paywithamazon.response.model.ProviderCreditDetails;
import java.io.Serializable;

/**
 * Response from GetProviderCreditDetails service API, as returned by Amazon Payments
 */
public final class GetProviderCreditDetailsResponseData  extends ResponseData implements Serializable {
    
    private String requestId;
    private ProviderCreditDetails providerCreditDetails;
    
    public GetProviderCreditDetailsResponseData(GetProviderCreditDetailsResponse getProviderCreditDetailsResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(getProviderCreditDetailsResponse != null) {
            if(getProviderCreditDetailsResponse.getGetProviderCreditDetailsResult()!= null) {
                this.providerCreditDetails = getProviderCreditDetailsResponse.getGetProviderCreditDetailsResult().getProviderCreditDetails();
            }
            this.requestId = getProviderCreditDetailsResponse.getResponseMetadata().getRequestId();
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
     * Encapsulates details about providerCreditDetails
     * 
     * @return providerCreditDetails
     */
    public ProviderCreditDetails getDetails() {
        return providerCreditDetails;
    }

    /**
     * Returns the string representation of GetProviderCreditDetailsResponseData
     * @return 
     */
    @Override
    public String toString() {
        return "GetProviderCreditDetailsResponseData{" + "requestId=" + requestId + ", providerCreditDetails=" + providerCreditDetails.toString() + '}';
    }
    
    

}
