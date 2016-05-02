package com.amazonservices.mws.offamazonpayments.unittest.model;


import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.CloseAuthorizationRequest;

import static junit.framework.Assert.assertNotNull;

public class CloseAuthorizationRequestTest extends ModelTest<CloseAuthorizationRequest>{

    @Override
    protected String getXMLTestFile() {
        return "CloseAuthorizationRequest.xml";
    }

    @Override
    protected Class<CloseAuthorizationRequest> getTestClassType() {
        return CloseAuthorizationRequest.class;
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