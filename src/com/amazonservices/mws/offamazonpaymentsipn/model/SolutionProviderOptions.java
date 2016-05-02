/*******************************************************************************
 *  Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * *****************************************************************************
 */
package com.amazonservices.mws.offamazonpaymentsipn.model;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.common.JSONFragmentBuilder;
import com.amazonservices.mws.offamazonpayments.common.ReflectionFragmentBuilder;
import com.amazonservices.mws.offamazonpayments.common.XmlFragmentBuilder;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SolutionProviderOptions complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SolutionProviderOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}SolutionProviderOptions">
 *       &lt;sequence>
 *         &lt;element name="solutionProviderOption" type="{http://www.w3.org/2001/XMLSchema}SolutionProviderOption" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SolutionProviderOptions", propOrder = {
        "solutionProviderOption"
})
public class SolutionProviderOptions {

    @XmlElement(name = "SolutionProviderOption", required = true)
    protected List<SolutionProviderOption> solutionProviderOption;

    public SolutionProviderOptions() {
        super();
    }

    public SolutionProviderOptions(final List<SolutionProviderOption> solutionProviderOption) {
        this.solutionProviderOption = solutionProviderOption;
    }

    public List<SolutionProviderOption> getSolutionProviderOption() {
        if (solutionProviderOption == null) {
            solutionProviderOption = new ArrayList<SolutionProviderOption>();
        }
        return this.solutionProviderOption;
    }

    public boolean isSetSolutionProviderOption() {
        return ((this.solutionProviderOption != null)&&(!this.solutionProviderOption.isEmpty()));
    }

    public void unsetSolutionProviderOption() {
        this.solutionProviderOption = null;
    }

    public SolutionProviderOptions withSolutionProviderOption(final SolutionProviderOption... values) {
        for (SolutionProviderOption value: values) {
            getSolutionProviderOption().add(value);
        }
        return this;
    }

    public void setSolutionProviderOption(final List<SolutionProviderOption> solutionProviderOption) {
        this.solutionProviderOption = solutionProviderOption;
    }

    /**
     *
     * XML fragment representation of this object
     *
     * @return XML fragment for this object. Name for outer
     * tag expected to be set by calling method. This fragment
     * returns inner properties representation only
     */
    @Deprecated
    public String toXMLFragment() throws OffAmazonPaymentsServiceException {
        return new ReflectionFragmentBuilder(this, new XmlFragmentBuilder()).build();
    }

    /**
     *
     * JSON fragment representation of this object
     *
     * @return JSON fragment for this object. Name for outer
     * object expected to be set by calling method. This fragment
     * returns inner properties representation only
     *
     */
    @Deprecated
    public String toJSONFragment() throws OffAmazonPaymentsServiceException {
        return new ReflectionFragmentBuilder(this, new JSONFragmentBuilder()).build();
    }
}
