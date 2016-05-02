package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.ConfirmOrderReferenceRequest;

import static junit.framework.Assert.assertNotNull;

public class ConfirmOrderReferenceRequestTest extends ModelTest<ConfirmOrderReferenceRequest>{

    @Override
    protected String getXMLTestFile(){
        return "ConfirmOrderReferenceRequest.xml";
    }

    @Override
    protected Class<ConfirmOrderReferenceRequest> getTestClassType() {
        return ConfirmOrderReferenceRequest.class;
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