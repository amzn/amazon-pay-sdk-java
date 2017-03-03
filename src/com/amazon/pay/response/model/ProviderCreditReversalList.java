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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditReversalList", propOrder = {
    "member"
})
public class ProviderCreditReversalList {

    @XmlElement(required = true)
    protected List<ProviderCreditReversal> member;

    public ProviderCreditReversalList() {
        super();
    }

    public List<ProviderCreditReversal> getMember() {
        if (member == null) {
            member = new ArrayList<ProviderCreditReversal>();
        }
        return this.member;
    }

    @Override
    public String toString() {
        return "ProviderCreditReversalList{" + "member=" + member.toString() + '}';
    }


}
