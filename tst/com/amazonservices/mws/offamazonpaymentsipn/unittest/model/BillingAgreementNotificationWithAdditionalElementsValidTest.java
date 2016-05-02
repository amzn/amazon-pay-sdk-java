package com.amazonservices.mws.offamazonpaymentsipn.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.model.BillingAgreementNotification;

public class BillingAgreementNotificationWithAdditionalElementsValidTest extends IpnModelTest<BillingAgreementNotification> {

    @Override
    protected String getXMLTestFile(){
        return "BillingAgreementNotificationWithAdditionalElementsValid.xml";
    }

    @Override
    protected Class<BillingAgreementNotification> getTestClassType() {
        return BillingAgreementNotification.class;
    }

    @Test
    public void testObjectToXML() throws Exception {
        testForNull();
    }

    @Test
    public void testXMLToObject() throws Exception {
        testSchema();
    }
}
