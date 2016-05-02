package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetAuthorizationDetailsRequest;

import static junit.framework.Assert.assertNotNull;

public class GetAuthorizationDetailsRequestTest extends ModelTest<GetAuthorizationDetailsRequest>{

    @Override
    protected String getXMLTestFile(){
        return "GetAuthorizationDetailsRequest.xml";
    }

    @Override
    protected Class<GetAuthorizationDetailsRequest> getTestClassType() {
        return GetAuthorizationDetailsRequest.class;
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
