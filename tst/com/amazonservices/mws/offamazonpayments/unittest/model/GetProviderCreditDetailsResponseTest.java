package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetProviderCreditDetailsResponse;

import static junit.framework.Assert.assertNotNull;

public class GetProviderCreditDetailsResponseTest extends ModelTest<GetProviderCreditDetailsResponse>{

	@Override
	protected String getXMLTestFile() {
		return "GetProviderCreditDetailsResponse.xml";
	}

	@Override
	protected Class<GetProviderCreditDetailsResponse> getTestClassType() {
		return GetProviderCreditDetailsResponse.class;
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
