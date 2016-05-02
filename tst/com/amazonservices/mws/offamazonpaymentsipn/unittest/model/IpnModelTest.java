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

import com.amazonservices.mws.offamazonpayments.model.AuthorizeOnBillingAgreementResponse;
import org.junit.Assert;
import org.junit.Before;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import com.amazonservices.mws.offamazonpaymentsipn.unittest.NamespaceRemovingInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;


public abstract class IpnModelTest<T> {

    protected abstract String getXMLTestFile();
    protected abstract Class<T> getTestClassType();

    private final String packagePath = "com.amazonservices.mws.offamazonpaymentsipn.model.";
    private final String xmlFilePath = "tst/com/amazonservices/mws/offamazonpaymentsipn/unittest/xml/";

    protected JAXBContext jaxbContext = null;
    protected Unmarshaller jaxbUnmarshaller = null;
    protected InputStream is = null;
    protected Object testClassObject = null;

    protected final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    protected DocumentBuilder dBuilder = null;
    protected Document doc = null;


    @Before
    /**
     * init method for this test case
     * @throws Exception
     */
    public void setUp() throws Exception {
        //create file input stream
        is = new FileInputStream(xmlFilePath + getXMLTestFile());

        //This stream will remove all specified xml namespaces from the xml
        is = new NamespaceRemovingInputStream(is);

        //XML and Java binding
        jaxbContext = JAXBContext.newInstance(getTestClassType());

        //class responsible for the process of deserializing
        //XML data into Java object

        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        testClassObject = getTestClassType().cast(jaxbUnmarshaller.unmarshal(is));

        dbFactory.setIgnoringElementContentWhitespace(true);

        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(new File(xmlFilePath + getXMLTestFile()));
        doc.getDocumentElement().normalize();
    }

    protected T getTestClassObject() {
        return (T)testClassObject;
    }

    /**
     * Base method to run the recursive testing for NULL value.
     *
     * @throws Exception
     */
    protected void testForNull() throws Exception {
        Field[] objectField = testClassObject.getClass().getDeclaredFields();
        testNullAtAllLevel(testClassObject,objectField);
    }

    /**
     * Recursively tests for null values in object class.
     *
     * @param Object  testObject
     * @param Field[] objFieldList
     * @throws Exception
     */
    protected void testNullAtAllLevel(final Object testObject, final Field[] objFieldList) throws Exception {

        Assert.assertNotNull("Test Object is NULL ", testObject);

        String testObjectName = testObject.getClass().getName();

        for (Field f : objFieldList) {

            Assert.assertNotNull("Null field in " + testObjectName , f);

            if (!f.getType().getSimpleName().equals("ResponseHeaderMetadata")) {

                String fieldType = f.getType().getName();
                String fieldTypeSimpleName = f.getType().getSimpleName();
                String fieldName = f.getName().trim();
                Object fieldValue = getFieldValue(testObject, f, fieldName);

                Assert.assertNotNull("Type for " + fieldName + " in " + testObjectName + " is NULL", fieldType);
                Assert.assertNotNull("Type Simple Name for " + fieldName + " in " + testObjectName + " is NULL",fieldTypeSimpleName);
                Assert.assertNotNull("Value for " + fieldName + " in " + testObjectName +  " is NULL", fieldValue);

                if (fieldTypeSimpleName.equals("List")) {
                    checkListObject(f, fieldValue, fieldName);
                } else if (isModelObject(fieldType)) {
                    checkModelObject(f, fieldValue, fieldName);
                } else {
                    Assert.assertNotNull(fieldName + " is NULL", fieldValue);
                }
            }
        }
    }

    /**
     * Method to get value assigned to a field in an object.
     *
     * @param Object testObject
     * @param Field f
     * @param String fieldName
     * @return Object fieldValue
     * @throws Exception
     */
    protected Object getFieldValue(final Object testObject, final Field f, final String fieldName) throws Exception {
        String methodName = null;
        String typeSimpleName = f.getType().getSimpleName();
        if (typeSimpleName.equalsIgnoreCase("Boolean")) {
            methodName = "is" + fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
        } else {
            methodName = "get" + fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
        }
        return testObject.getClass().getDeclaredMethod(methodName).invoke(testObject);
    }

    /**
     * Method to check a List for any Model object,
     * and run recursive null test on each item in the list.
     *
     * @param Field f
     * @param Object fieldValue
     * @param String fieldName
     * @throws Exception
     */
    protected void checkListObject(final Field f, final Object fieldValue, final String fieldName) throws Exception {
        if (isModelObject(getListParameterizedType(f))) {
            List<?> eachList = (List<?>) fieldValue;
            for (int i = 0; i < eachList.size(); i++) {
                testNullAtAllLevel(eachList.get(i), eachList.get(i).getClass().getDeclaredFields());
            }
        } else {
            Assert.assertNotNull(fieldName + " is NULL", fieldValue);
        }
    }

    protected String getListParameterizedType(final Field f) {
        ParameterizedType listType = (ParameterizedType) f.getGenericType();
        Class<?> listTypeName = (Class<?>) listType.getActualTypeArguments()[0];
        return listTypeName.getName();
    }

    /**
     * Method to check for ENUM class, and
     * and run recursive null test on all non-ENUM object.
     *
     * @param Field f
     * @param Object fieldValue
     * @param String fieldName
     * @throws Exception
     */
    protected void checkModelObject(final Field f, final Object fieldValue, final String fieldName) throws Exception {
        if (fieldValue.getClass().isEnum()) {
            Assert.assertNotNull(fieldName + " is NULL", fieldValue.getClass().getDeclaredMethod("value").invoke(fieldValue));
        } else {
            testNullAtAllLevel(fieldValue, fieldValue.getClass().getDeclaredFields());
        }
    }

    /**
     * Return true if the field type is a model object.
     *
     * @param String fieldTypeName
     * @return
     */
    protected boolean isModelObject(final String fieldTypeName) {
        return fieldTypeName.startsWith(packagePath);
    }

    /**
     * Base method to run the recursive schema test.
     * @throws Exception
     */
    protected void testSchema() throws Exception {
        Element root = doc.getDocumentElement();
        testSchemaRecursively(root, testClassObject);
    }

    /**
     * Recursive method to check the XML schema.
     *
     * @param node
     * @param testObject
     * @throws Exception
     */
    protected void testSchemaRecursively(final Node node, final Object testObject) throws Exception {

        Assert.assertNotNull("The Node is NULL", node);

        NodeList nl = null;

        if (node.hasChildNodes()) {
            nl = node.getChildNodes();
            List <String> XMLElementList = new ArrayList <String>();

            for (int i = 0; i < nl.getLength(); i++) {
                Node childNode = nl.item(i);
                String childNodeName = childNode.getNodeName();

                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    XMLElementList.add(childNodeName);
                    if (childNode.hasChildNodes()) {
                        String fieldName = childNodeName.replaceFirst(childNodeName.substring(0, 1), childNodeName.substring(0, 1).toLowerCase());
                        try {
                            Field field = testObject.getClass().getDeclaredField(fieldName);
                            Object fieldValue = getFieldValue(testObject, field, fieldName);

                            if (field.getType().getSimpleName().equals("List") && isModelObject(getListParameterizedType(field))) {
                                List<?> eachList = (List<?>) fieldValue;
                                for (int j = 0; j < eachList.size(); j++) {
                                    testSchemaRecursively(nl.item(i), eachList.get(j));
                                }
                            } else {
                                testSchemaRecursively(nl.item(i), fieldValue);
                            }
                        } catch (NoSuchFieldException e) {
                            // Extra element in schema, ignore this
                        }

                    }
                }
            }

            if (!XMLElementList.isEmpty()) {

                Field[] objectFieldList = testObject.getClass().getDeclaredFields();
                Assert.assertNotNull("Field Arrya is NULL for Object " + testObject.getClass().getName());

                List <String> fieldList = getObjectFieldList(objectFieldList);
                CompareObjectToXML(XMLElementList, fieldList);
            }

        }
    }

    /**
     * Method creates a List of Strings with all field names in the Field Array.
     *
     * @param objectFieldList
     * @return
     */
    protected List<String> getObjectFieldList(final Field[] objectFieldList) {

        List <String> fieldList = new ArrayList<String>();

        String fieldName = null;

        for (Field f : objectFieldList) {
            fieldName = f.getName();
            fieldList.add(fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase()));
        }

        return fieldList;
    }

    /**
     * Compared Schema with its object.
     *
     * @param XMLElementList
     * @param fieldList
     */
    protected void CompareObjectToXML(final List<String> XMLElementList, final List<String> fieldList) {
        for (String element : XMLElementList) {
            Assert.assertNotNull(element + " is NOT available in Object Class",fieldList.contains(element));
        }
    }
}
