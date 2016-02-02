package com.amazon.payments.paywithamazon.response.model;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



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

    @Override
    public String toString() {
        return "SolutionProviderOptions{" + "solutionProviderOption=" + solutionProviderOption.toString() + '}';
    }


}
