package com.amazon.payments.paywithamazon.response.model;

import com.amazon.payments.paywithamazon.response.model.ResponseMetadata;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "authorizeResult",
    "responseMetadata"
})
@XmlRootElement(name = "AuthorizeResponse")
public class AuthorizeResponse {

    @XmlElement(name = "AuthorizeResult", required = true)
    protected AuthorizeResult authorizeResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;
    

    public AuthorizeResponse() {
        super();
    }
    
    public AuthorizeResult getAuthorizeResult() {
        return authorizeResult;
    }


    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }
    
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "authorizationDetails"
    })
    @XmlRootElement(name = "AuthorizeResult")
    public static class AuthorizeResult {

        @XmlElement(name = "AuthorizationDetails", required = true)
        protected AuthorizationDetails authorizationDetails;

        public AuthorizeResult() {
           super();
        }

        public AuthorizationDetails getAuthorizationDetails() {
           return authorizationDetails;
        }
    }
}
