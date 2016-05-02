package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;
import com.amazonservices.mws.offamazonpayments.model.AuthorizeRequest;

import static junit.framework.Assert.assertNotNull;

public class AuthorizeRequestTest extends ModelTest<AuthorizeRequest>{

    @Override
    protected String getXMLTestFile(){
        return "AuthorizeRequest.xml";
    }


    @Override
    protected Class<AuthorizeRequest> getTestClassType() {
        return AuthorizeRequest.class;
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
