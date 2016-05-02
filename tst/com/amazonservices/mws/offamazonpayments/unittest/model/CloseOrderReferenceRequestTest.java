package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.CloseOrderReferenceRequest;

import static junit.framework.Assert.assertNotNull;

public class CloseOrderReferenceRequestTest extends ModelTest<CloseOrderReferenceRequest>{

    @Override
    protected String getXMLTestFile(){
        return "CloseOrderReferenceRequest.xml";
    }

    @Override
    protected Class<CloseOrderReferenceRequest> getTestClassType() {
        return CloseOrderReferenceRequest.class;
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