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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "type",
    "code",
    "message",
    "detail"
})
@XmlRootElement(name = "Error")
public class Error {

    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlElement(name = "Detail", required = true)
    protected Error.Detail detail;

    /**
     * Default constructor
     * 
     */
    public Error() {
        super();
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Error.Detail getDetail() {
        return detail;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Detail {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        public Detail() {
            super();
        }
        
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }
    }

    /**
     * String representation of BillingAgreement Notification
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Error{" + "type=" + type + ", code=" + code + ", message=" + message + ", detail=" + detail + '}';
    }
}
