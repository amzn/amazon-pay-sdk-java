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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
* This represents an enum class identifying the environment LIVE or SANDBOX mode.
* Sandbox mode enables you to conduct an end-to-end test of 
* your integration prior to going live.
*/
@XmlType(name = "ReleaseEnvironment")
@XmlEnum
public enum Environment {

    @XmlEnumValue("Live")
    LIVE("LIVE"),
    @XmlEnumValue("Sandbox")
    SANDBOX("SANDBOX");
    private final String value;

    Environment(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value();
    }

    public static Environment fromValue(String v) {
        for (Environment c: Environment.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
