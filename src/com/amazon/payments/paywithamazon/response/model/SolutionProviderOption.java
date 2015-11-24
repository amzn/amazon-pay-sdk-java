package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SolutionProviderOption", propOrder = { "name", "value" })
public class SolutionProviderOption {

    @XmlElement(name = "name")
    protected String name;
    @XmlElement(name = "value")
    protected String value;

    public SolutionProviderOption() {
        super();
    }

    public SolutionProviderOption(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SolutionProviderOption{" + "name=" + name + ", value=" + value + '}';
    }




}
