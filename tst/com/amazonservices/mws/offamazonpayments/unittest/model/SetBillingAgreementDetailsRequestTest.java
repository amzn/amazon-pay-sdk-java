package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.SetBillingAgreementDetailsRequest;

import static junit.framework.Assert.assertNotNull;

public class SetBillingAgreementDetailsRequestTest extends ModelTest<SetBillingAgreementDetailsRequest>{

    @Override
    protected String getXMLTestFile(){
        return "SetBillingAgreementDetailsRequest.xml";
    }

    @Override
    protected Class<SetBillingAgreementDetailsRequest> getTestClassType() {
        return SetBillingAgreementDetailsRequest.class;
    }

    @Test
    public void testObjectToXML() throws Exception{
        testForNull();
    }

    @Test
    public void testXMLToObject() throws Exception {
        testSchema();
    }

    @Test
    public void toJSONShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String jsonFragment = getTestClassObject().toJSONFragment();

        assertNotNull(jsonFragment);
    }
}