package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.ConfirmBillingAgreementRequest;

import static junit.framework.Assert.assertNotNull;

public class ConfirmBillingAgreementRequestTest extends ModelTest<ConfirmBillingAgreementRequest>{

    @Override
    protected String getXMLTestFile(){
        return "ConfirmBillingAgreementRequest.xml";
    }

    @Override
    protected Class<ConfirmBillingAgreementRequest> getTestClassType() {
        return ConfirmBillingAgreementRequest.class;
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