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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This represents a container for Message nodes parsed from
 * the Amazon Pay GetServiceStatusResponse API response.
 *
 *     &lt;Messages&gt;
 *       &lt;Message&gt;
 *         &lt;Locale&gt;en_UK&lt;/Locale&gt;
 *         &lt;Text&gt;We are experiencing high latency in UK because of heavy traffic.&lt;/Text&gt;
 *       &lt;/Message&gt;
 *       &lt;Message&gt;
 *         &lt;Locale&gt;en_US&lt;/Locale&gt;
 *         &lt;Text&gt;Service is once again operating at normal capacity at 6:53 PST.&lt;/Text&gt;
 *       &lt;/Message&gt;
 *     &lt;/Messages&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "messages"
})
@XmlRootElement(name = "Message")
public class MessageList {

    @XmlElement(name = "Message", required = true)
    protected List<Message> messages;

    /**
     * Default constructor
     *
     */
    public MessageList() {
        super();
    }

    public MessageList(final List<Message> messages) {
        this.messages = messages;
    }

    /**
     * @return parent element of one or more Message elements.
     */
    public List<Message> getMessages() {
        if (messages == null) {
            messages = new ArrayList<Message>();
        }
        return messages;
    }

    /**
     * Returns the string representation of MessageList
     */
    @Override
    public String toString() {
        return "MessageList{" + "messages=" + messages + '}';
    }
}
