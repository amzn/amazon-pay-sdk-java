/**
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.payments.paywithamazon.response.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This can parse two different variations of <IdList> nodes.
 * In most cases, the individual members are instead <member>..</member> tags,
 * but some IPN messages put them inside <Id>..</Id> tags.
 * The class was modified to handle both cases and let the
 * SDK client retrieve either case by a single getMember() call.
 *
 * Valid example 1:
 *   <IdList>
 *     <member>S01-9228170-9681927-C035172</member>
 *     <member>S01-9228170-9681927-C039558</member>
 *  </IdList>
 *
 * Valid example 2:
 *   <IdList>
 *     <Id>S01-9228170-9681927-C035172</Id>
 *     <Id>S01-9228170-9681927-C039558</Id>
 *  </IdList>
 *
 * Invalid example (cannot mix Id and member tags in same group):
 *   <IdList>
 *     <member>S01-9228170-9681927-C035172</member>
 *     <Id>S01-9228170-9681927-C039558</Id>
 *  </IdList>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdList", propOrder = {
    "member",
    "id"
})
public class IdList {

    @XmlElement(name = "member")
    protected List<String> member;
    @XmlElement(name = "Id")
    protected List<String> id;

    /**
     * Default constructor
     *
     */
    public IdList() {
        super();
    }

    public IdList(final List<String> member) {
        this.member = member;
    }

    public List<String> getMember() {
        if ((member == null) && (id == null)) {
            return new ArrayList<String>();
        }
        return (member != null) ? member : id;
    }

    public List<String> getId() {
        return getMember();
    }

    @Override
    public String toString() {
        return "IdList{" + "member=" + getMember() + '}';
    }

}
