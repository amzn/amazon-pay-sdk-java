package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.ValidateBillingAgreementResponse;

import static junit.framework.Assert.assertNotNull;

public class ValidateBillingAgreementResponseTest extends ModelTest<ValidateBillingAgreementResponse>{

    @Override
    protected String getXMLTestFile(){
        return "ValidateBillingAgreementResponse.xml";
    }

    @Override
    protected Class<ValidateBillingAgreementResponse> getTestClassType() {
        return ValidateBillingAgreementResponse.class;
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
    public void toXMLShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String xmlFragment = getTestClassObject().toXML();

        assertNotNull(xmlFragment);
    }

    @Test
    public void toJSONShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String jsonFragment = getTestClassObject().toJSON();

        assertNotNull(jsonFragment);
    }
}