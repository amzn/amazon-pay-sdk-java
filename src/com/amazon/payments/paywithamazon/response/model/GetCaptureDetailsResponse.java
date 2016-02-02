package com.amazon.payments.paywithamazon.response.model;

import com.amazon.payments.paywithamazon.response.model.ResponseMetadata;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCaptureDetailsResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetCaptureDetailsResponse")
public class GetCaptureDetailsResponse {

    @XmlElement(name = "GetCaptureDetailsResult", required = true)
    protected GetCaptureDetailsResult getCaptureDetailsResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    
    public GetCaptureDetailsResponse() {
        super();
    }
    
    public GetCaptureDetailsResult getGetCaptureDetailsResult() {
        return getCaptureDetailsResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "captureDetails"
    })
    @XmlRootElement(name = "GetCaptureDetailsResult")
    public static class GetCaptureDetailsResult {

        @XmlElement(name = "CaptureDetails", required = true)
        protected CaptureDetails captureDetails;

        public GetCaptureDetailsResult() {
            super();
        }
        
        public CaptureDetails getCaptureDetails() {
            return captureDetails;
        }

    }

}
