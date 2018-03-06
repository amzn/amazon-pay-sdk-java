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
package com.amazon.pay.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * This represents the GetServiceStatusResult node parsed
 * from the Amazon Pay GetServiceStatusResponse API response.
 *
 *   &lt;GetServiceStatusResult&gt;
 *     &lt;Status&gt;GREEN_I&lt;/Status&gt;
 *     &lt;Timestamp&gt;2010-11-01T21:38:09.676Z&lt;/Timestamp&gt;
 *     &lt;MessageId&gt;173964729I&lt;/MessageId&gt;
 *     &lt;Messages&gt;
 *       &lt;Message&gt;
 *         &lt;Locale&gt;en_US&lt;/Locale&gt;
 *         &lt;Text&gt;Service is once again operating at normal capacity at 6:53 PST.&lt;/Text&gt;
 *       &lt;/Message&gt;
 *     &lt;/Messages&gt;
 *   &lt;/GetServiceStatusResult&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "timestamp",
    "messageId",
    "messages"
})
@XmlRootElement(name = "GetServiceStatusResult")
public class GetServiceStatusResult {

    @XmlElement(name = "Status", required = true)
    protected ServiceStatus status;

    @XmlElement(name = "Timestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;

    @XmlElement(name = "MessageId")
    protected String messageId;

    @XmlElement(name = "Messages")
    protected MessageList messages;

    public GetServiceStatusResult() {
        super();
    }

    /**
     * @return  service status:
     *   GREEN—The service is operating normally.
     *   GREEN_I—The service is operating normally.
     *       Additional information is provided.
     *   YELLOW—The service is experiencing higher than normal error rates or is
     *       operating with degraded performance.
     *       Additional information may be provided.
     *   RED—The service is unavailable or experiencing extremely high error rates.
     *       Additional information may be provided.
     */
    public ServiceStatus getStatus() {
        return status;
    }

    /**
     * @return the time at which the operational status was evaluated.
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * @return Amazon-defined message identifier.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @return parent element of one or more Message elements.
     */
    public MessageList getMessages() {
        return messages;
    }

    /**
     * Returns the string representation of GetServiceStatusResult
     */
    @Override
    public String toString() {
        return "GetServiceStatus{" + "status=" + status +
                ", timestamp=" + timestamp +
                ", messageId=" + messageId +
                ", messages=" + messages + '}';
    }
}
