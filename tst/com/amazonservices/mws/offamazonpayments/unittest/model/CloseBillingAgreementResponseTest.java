package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.CloseBillingAgreementResponse;

import static junit.framework.Assert.assertNotNull;

public class CloseBillingAgreementResponseTest extends ModelTest<CloseBillingAgreementResponse>{

    @Override
    protected String getXMLTestFile(){
        return "CloseBillingAgreementResponse.xml";
    }

    @Override
    protected Class<CloseBillingAgreementResponse> getTestClassType() {

        return CloseBillingAgreementResponse.class;
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