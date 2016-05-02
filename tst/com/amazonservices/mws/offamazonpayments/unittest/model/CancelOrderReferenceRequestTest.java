package com.amazonservices.mws.offamazonpayments.unittest.model;


import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.CancelOrderReferenceRequest;

import static junit.framework.Assert.assertNotNull;

public class CancelOrderReferenceRequestTest extends ModelTest<CancelOrderReferenceRequest>{

    @Override
    protected String getXMLTestFile(){
        return "CancelOrderReferenceRequest.xml";
    }

    @Override
    protected Class<CancelOrderReferenceRequest> getTestClassType() {
        return CancelOrderReferenceRequest.class;
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