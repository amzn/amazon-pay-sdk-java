package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.ValidateBillingAgreementRequest;

import static junit.framework.Assert.assertNotNull;

public class ValidateBillingAgreementRequestTest extends ModelTest<ValidateBillingAgreementRequest>{

    @Override
    protected String getXMLTestFile(){
        return "ValidateBillingAgreementRequest.xml";
    }

    @Override
    protected Class<ValidateBillingAgreementRequest> getTestClassType() {
        return ValidateBillingAgreementRequest.class;
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