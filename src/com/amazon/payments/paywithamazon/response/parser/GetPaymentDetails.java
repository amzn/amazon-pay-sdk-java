package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.AuthorizationDetails;
import com.amazon.payments.paywithamazon.response.model.CaptureDetails;
import com.amazon.payments.paywithamazon.response.model.OrderReferenceDetails;
import com.amazon.payments.paywithamazon.response.model.RefundDetails;


import java.util.Map;
import java.util.HashMap;

public class GetPaymentDetails {

    private OrderReferenceDetails orderReferenceDetails;
    private String id;
    private Map<String, AuthorizationDetails> authorizationDetails = new HashMap<String, AuthorizationDetails>();
    private Map<String, CaptureDetails> captureDetails = new HashMap<String, CaptureDetails>();
    private Map<String, RefundDetails> refundDetails = new HashMap<String, RefundDetails>();


    public void putOrderReferenceDetails(String id, OrderReferenceDetails orderReferenceResponse){
        this.orderReferenceDetails = orderReferenceResponse;
        this.id = id;
    }

    public void putAuthorizationDetails(String id, AuthorizationDetails authorizeResponse){
        authorizationDetails.put(id, authorizeResponse);
    }

    public void putCaptureDetails(String id, CaptureDetails captureResponse){
        captureDetails.put(id, captureResponse);
    }

    public void putRefundDetails(String id, RefundDetails refundResponse){
        refundDetails.put(id, refundResponse);
    }

    public OrderReferenceDetails getOrderReferenceDetails(){
        return orderReferenceDetails;
    }

    public Map<String, AuthorizationDetails> getAuthorizationDetails(){
        return authorizationDetails;
    }

    public Map<String, CaptureDetails> getCaptureDetails(){
        return captureDetails;
    }
    public Map<String, RefundDetails> getRefundDetails(){
        return refundDetails;
    }
}
