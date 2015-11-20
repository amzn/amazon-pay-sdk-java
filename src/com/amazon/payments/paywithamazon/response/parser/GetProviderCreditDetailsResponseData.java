package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.GetProviderCreditDetailsResponse;
import com.amazon.payments.paywithamazon.response.model.ProviderCreditDetails;
import java.io.Serializable;

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
     * @return  The requestID that uniquely identifies the service request
     * the caller made.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 
     * @return providerCreditDetails
     */
    public ProviderCreditDetails getDetails() {
        return providerCreditDetails;
    }

}
