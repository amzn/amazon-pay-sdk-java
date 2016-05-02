package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.CloseBillingAgreementRequest;

import static junit.framework.Assert.assertNotNull;

public class CloseBillingAgreementRequestTest extends ModelTest<CloseBillingAgreementRequest>{

    @Override
    protected String getXMLTestFile(){
        return "CloseBillingAgreementRequest.xml";
    }

    @Override
    protected Class<CloseBillingAgreementRequest> getTestClassType() {
        return CloseBillingAgreementRequest.class;
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