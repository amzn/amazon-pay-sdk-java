/*******************************************************************************
 *  Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * *****************************************************************************
 */
package com.amazonservices.mws.offamazonpaymentsipn.unittest.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.unittest.model.IpnModelTest;
import com.amazonservices.mws.offamazonpaymentsipn.model.RefundNotification;

public class RefundNotificationWithMissingMandatoryFieldsTest extends IpnModelTest<RefundNotification> {

    @Override
    protected String getXMLTestFile(){
        return "RefundNotificationWithMissingMandatoryFields.xml";
    }

    @Override
    protected Class<RefundNotification> getTestClassType() {
        return RefundNotification.class;
    }

    @Test
    public void testObjectToXML() throws Exception {
        String expectedException = "Value for amazonRefundId in com.amazonservices.mws.offamazonpaymentsipn.model.RefundDetails is NULL";
        try {
            testForNull();
            fail();
        } catch (AssertionError e) {
            assertEquals(expectedException, e.getMessage());
        }
    }

    @Test
    public void testXMLToObject() throws Exception {
        testSchema();
    }
}