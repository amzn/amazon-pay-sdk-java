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

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsService;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

public class ReflectionFragmentBuilder {

    private static final String ERR_ANNOTATION_NOT_FOUND = "Unable to print object values due to missing type " +
            "information, XmlType class not found";
    private static final String ERR_PROPERTY_NOT_FOUND = "Unable to find property %s in class %s";

    private final Object object;
    private final Class<?> objectClass;
    private final FragmentBuilder fragmentBuilder;

    public ReflectionFragmentBuilder(Object obj, FragmentBuilder fragmentBuilder) {
        this.object = obj;
        this.objectClass = obj.getClass();
        this.fragmentBuilder = fragmentBuilder;
    }

    public String build() throws OffAmazonPaymentsServiceException{
        String[] properties = getPropertiesForPrinting();
        return printPropertiesOfObject(properties);
    }

    private String printPropertiesOfObject(String[] properties) throws OffAmazonPaymentsServiceException {
        for (String property : properties) {
            if (StringUtils.isNotBlank(property)) {
                addPropertyToFragment(property);
            }
        }

        return this.fragmentBuilder.build();
    }

    public ReflectionFragmentBuilder withHeaders() {
        this.fragmentBuilder.addHeaderFieldWith(this.objectClass.getSimpleName());
        return this;
    }

    private void addPropertyToFragment(String property) throws OffAmazonPaymentsServiceException {
        String capitalizedPropertyName = StringUtils.capitalize(property);
        String getterPropertyName = getPropertyNamePrefix(property) + capitalizedPropertyName;
        Object result = ReflectionUtils.invokeMethodOn(this.object, getterPropertyName);

        if (result instanceof Collection) {
            addFieldsFromCollection(capitalizedPropertyName, (Collection<?>)result);
        } else {
            this.fragmentBuilder.addFieldToFragmentIfSet(capitalizedPropertyName, result);
        }
    }

    private void addFieldsFromCollection(String capitalizedPropertyName, Collection<?> result) throws OffAmazonPaymentsServiceException {
        this.fragmentBuilder.addCollectionHeader(capitalizedPropertyName);
        for (Object obj : result) {
            this.fragmentBuilder.addCollectionValue(capitalizedPropertyName, obj);
        }
        this.fragmentBuilder.closeCollectionHeader(capitalizedPropertyName);
    }

    private String[] getPropertiesForPrinting() throws OffAmazonPaymentsServiceException{
        try {
            return this.objectClass.getAnnotation(XmlType.class).propOrder();
        } catch (NullPointerException npe) {
            String errMsg = String.format(ERR_ANNOTATION_NOT_FOUND, this.objectClass.getName());
            throw new OffAmazonPaymentsServiceException(errMsg, npe);
        }
    }

    private String getPropertyNamePrefix(String property) throws OffAmazonPaymentsServiceException {
        Field field = getPropertyFromClass(property);

        if (Boolean.class.equals(field.getType()) || boolean.class.equals(field.getType())) {
            return "is";
        }

        return "get";
    }

    private Field getPropertyFromClass(String property) throws OffAmazonPaymentsServiceException {
        Field field;
        try {
            field = this.objectClass.getDeclaredField(property);
        } catch (NoSuchFieldException e) {
            String errMsg = String.format(ERR_PROPERTY_NOT_FOUND,  property, this.objectClass.getName());
            throw new OffAmazonPaymentsServiceException(errMsg, e);
        }
        return field;
    }
}
