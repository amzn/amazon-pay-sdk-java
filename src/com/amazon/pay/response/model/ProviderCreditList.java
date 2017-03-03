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
@XmlType(name = "ProviderCreditList", propOrder = {
    "member"
})
public class ProviderCreditList {

    @XmlElement(required = true)
    protected List<ProviderCredit> member;

    public ProviderCreditList() {
        super();
    }

    public ProviderCreditList(final List<ProviderCredit> member) {
        this.member = member;
    }

    public List<ProviderCredit> getMember() {
        if (member == null) {
            member = new ArrayList<ProviderCredit>();
        }
        return this.member;
    }

    @Override
    public String toString() {
        return "ProviderCreditList{" + "member=" + member + '}';
    }

    
}
