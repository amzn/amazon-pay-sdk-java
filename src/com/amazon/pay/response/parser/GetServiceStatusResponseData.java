/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.response.parser;

import com.amazon.pay.response.model.GetServiceStatusResponse;
import com.amazon.pay.response.model.ServiceStatus;
import com.amazon.pay.response.model.MessageList;

import java.io.Serializable;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Response from GetServiceStatus service API, as returned by Amazon Pay
 */
public final class GetServiceStatusResponseData extends ResponseData implements Serializable {

    private String requestId;
    private ServiceStatus status;
    private XMLGregorianCalendar timestamp;
    private String messageId;
    private MessageList messages;

    public GetServiceStatusResponseData(GetServiceStatusResponse response, ResponseData rawResponse) {
        super(rawResponse);
        if (response != null) {
            this.requestId = response.getResponseMetadata().getRequestId();
            if (response.getServiceStatusResult() != null) {
                status = response.getServiceStatusResult().getStatus();
                timestamp = response.getServiceStatusResult().getTimestamp();
                messageId = response.getServiceStatusResult().getMessageId();
                messages = response.getServiceStatusResult().getMessages();
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

    public ServiceStatus getStatus() {
        return status;
    }

    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public MessageList getMessages() {
        return messages;
    }


    /**
     * Returns the string representation of GetOrderReferenceDetailsResponseData
     */
    @Override
    public String toString() {
        return "GetServiceStatusResponseData{" + "requestId=" + requestId +
                ", status=" + status +
                ", timestamp=" + timestamp +
                ", messageId=" + messageId +
                ", messages=" + messages + "}";
    }

}
