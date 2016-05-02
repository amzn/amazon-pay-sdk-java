/*******************************************************************************
 *  Copyright 2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonservices.mws.offamazonpayments.common;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.*;
import com.amazonservices.mws.offamazonpayments.model.Error;

import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {

    private static final String ERR_METHOD_CANT_BE_INVOKED = "Unable to call method %s, cannot parse object";
    private static final String ERR_METHOD_NOT_FOUND = "Unable to find %s on object %s";

    public static Object invokeMethodOn(Object target, String methodName) throws OffAmazonPaymentsServiceException {
        Method method = getMethodOn(target.getClass(), methodName);
        return invokeMethodOn(target, method);
    }

    private static Method getMethodOn(Class<?> objectClass, String methodName) throws OffAmazonPaymentsServiceException {
        try {
            return objectClass.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            String errMsg = String.format(ERR_METHOD_NOT_FOUND, methodName, objectClass.getName());
            throw new OffAmazonPaymentsServiceException(errMsg, e);
        }
    }

    private static Object invokeMethodOn(Object target, Method method) throws OffAmazonPaymentsServiceException {
        try {
            return method.invoke(target);

            // Need to support java 6 so can't use | operator
            // in exception handler
        } catch (IllegalAccessException e) {
            String errMsg = String.format(ERR_METHOD_CANT_BE_INVOKED, method.getName());
            throw new OffAmazonPaymentsServiceException(errMsg, e);
        } catch (InvocationTargetException e) {
            String errMsg = String.format(ERR_METHOD_CANT_BE_INVOKED, method.getName());
            throw new OffAmazonPaymentsServiceException(errMsg, e);
        }
    }

    public static boolean shouldPrintValueOfType(Object fieldValue) {
        return  fieldValue instanceof String ||
                fieldValue instanceof Boolean ||
                fieldValue instanceof Integer ||
                fieldValue instanceof XMLGregorianCalendar ||
                fieldValue instanceof Enum ||
                fieldValue instanceof Error.Detail;
    }

}
