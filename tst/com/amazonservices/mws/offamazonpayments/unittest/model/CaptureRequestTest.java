package com.amazonservices.mws.offamazonpayments.unittest.model;


import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.CaptureRequest;

import static junit.framework.Assert.assertNotNull;

public class CaptureRequestTest extends ModelTest<CaptureRequest>{

    @Override
    protected String getXMLTestFile(){
        return "CaptureRequest.xml";
    }

    @Override
    protected Class<CaptureRequest> getTestClassType() {
        return CaptureRequest.class;
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