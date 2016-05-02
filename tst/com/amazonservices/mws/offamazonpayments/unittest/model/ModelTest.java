package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Assert;
import org.junit.Before;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;


public abstract class ModelTest<T> {

  protected abstract String getXMLTestFile();
  protected abstract Class<T> getTestClassType();
  
  protected final String packagePath = "com.amazonservices.mws.offamazonpayments.model.";
  protected final String xmlFilePath = "tst/com/amazonservices/mws/offamazonpayments/unittest/xml/";
  
  protected JAXBContext jaxbContext = null;
  protected Unmarshaller jaxbUnmarshaller = null;
  protected InputStream is = null;
  protected Object testClassObject = null;
  
  protected final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  protected DocumentBuilder dBuilder = null;
  protected Document doc = null;

  private static final List<String> RESERVED_TOKENS = Arrays.asList("MWS");

  @Before
  /**
   * init method for this test case
   * @throws Exception
   */
  public void setUp() throws Exception {
    //create file input stream
    is = new FileInputStream(xmlFilePath+getXMLTestFile());
    
    //XML and Java binding
    jaxbContext = JAXBContext.newInstance(getTestClassType());
   
    //class responsible for the process of deserializing
    //XML data into Java object
    jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    testClassObject = getTestClassType().cast(jaxbUnmarshaller.unmarshal(is));
    
    dbFactory.setIgnoringElementContentWhitespace(true);
    dBuilder = dbFactory.newDocumentBuilder();
    doc = dBuilder.parse(new File(xmlFilePath+getXMLTestFile()));
    doc.getDocumentElement().normalize();
  }

    protected T getTestClassObject() {
        return (T)this.testClassObject;
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
   * Recursively tests for null values in object class
   * 
   * @param Object  testObject
   * @param Field[] objFieldList
   * @throws Exception
   */
  protected void testNullAtAllLevel (Object testObject, Field[] objFieldList) throws Exception {
  
  Assert.assertNotNull("Test Object is NULL ", testObject);
  
  String testObjectName = testObject.getClass().getName();
    
  for(Field f : objFieldList) {
    
      Assert.assertNotNull("Null field in " + testObjectName , f);
      
      if(!f.getType().getSimpleName().equals("ResponseHeaderMetadata")){
        
        String fieldType = f.getType().getName();
        String fieldTypeSimpleName = f.getType().getSimpleName();
        String fieldName = f.getName().trim();
        Object fieldValue = getFieldValue(testObject, f, fieldName);
          
        Assert.assertNotNull("Type for " + fieldName + " in " + testObjectName + " is NULL", fieldType);
        Assert.assertNotNull("Type Simple Name for " + fieldName + " in " + testObjectName + " is NULL",fieldTypeSimpleName);           
        Assert.assertNotNull("Value for " + fieldName + " in " + testObjectName +  " is NULL", fieldValue); 
        
        if(fieldTypeSimpleName.equals("List")) {
          
          checkListObject(f, fieldValue, fieldName);
          
        } else if(isModelObject(fieldType)){
          
          checkModelObject(f, fieldValue, fieldName);
          
        } else {
          
          Assert.assertNotNull(fieldName + " is NULL", fieldValue);
        }
      }
    }
  }
  
/**
 * Method to get value assigned to a field in an object
 *  
 * @param Object testObject
 * @param Field f
 * @param String fieldName
 * @return Object fieldValue
 * @throws Exception
 */
  protected Object getFieldValue(Object testObject, Field f, String fieldName) throws Exception{
    String methodName = null;
    String typeSimpleName = f.getType().getSimpleName();

    if(typeSimpleName.equalsIgnoreCase("Boolean")) {
      methodName = createMethodName("is", fieldName);
    } else {
      methodName = createMethodName("get", fieldName);
    }

    return testObject.getClass().getDeclaredMethod(methodName).invoke(testObject);
  }


  // Method names need to use camel case except in the case where a reserved
  // word exists
  private String createMethodName(String prefix, String fieldName) {
    StringBuilder builder = new StringBuilder(prefix);

    fieldName = fieldName.replaceFirst(fieldName.substring(0,1), fieldName.substring(0,1).toUpperCase());

    return builder.append(fieldName).toString();
  }
  /**
   * Method to check a List for any Model object, 
   * and run recursive null test on each item in the list
   * 
   * @param Field f
   * @param Object fieldValue
   * @param String fieldName
   * @throws Exception
   */
  protected void checkListObject( Field f, Object fieldValue, String fieldName ) throws Exception{
    if(isModelObject(getListParameterizedType(f))){
      List<?> eachList = (List<?>) fieldValue;
      for (int i=0; i<eachList.size(); i++){  
        testNullAtAllLevel(eachList.get(i),eachList.get(i).getClass().getDeclaredFields());
      }  
    } else {
      Assert.assertNotNull(fieldName + " is NULL", fieldValue);
    }
  }
  
  protected String getListParameterizedType(Field f){
	ParameterizedType listType = (ParameterizedType) f.getGenericType();
    Class<?> listTypeName = (Class<?>) listType.getActualTypeArguments()[0];  
    return listTypeName.getName();
  }
    
  /**
   * Method to check for ENUM class, and
   * and run recursive null test on all non-ENUM object
   * 
   * @param Field f
   * @param Object fieldValue
   * @param String fieldName
   * @throws Exception
   */
  protected void checkModelObject(Field f, Object fieldValue, String fieldName) throws Exception{
    if(fieldValue.getClass().isEnum()) {
        Assert.assertNotNull(fieldName + " is NULL", fieldValue.getClass().getDeclaredMethod("value").invoke(fieldValue));
      } else {
        testNullAtAllLevel(fieldValue,fieldValue.getClass().getDeclaredFields());
      }
  }

  /**
   * Return true if the field type is a model object
   *  
   * @param String fieldTypeName
   * @return
   */
  protected boolean isModelObject(String fieldTypeName) {
    return fieldTypeName.startsWith(packagePath);
  }

  /**
   * Base method to run the recursive schema test
   * @throws Exception
   */
  protected void testSchema() throws Exception{
    Element root = doc.getDocumentElement();
    testSchemaRecursively(root, testClassObject);    
  }
  
  /**
   * Recursive method to check the XML schema
   * 
   * @param node
   * @param testObject
   * @throws Exception
   */
  protected void testSchemaRecursively (Node node, Object testObject) throws Exception{
    
    Assert.assertNotNull("The Node is NULL", node);
    
    NodeList nl = null;
        
    if(node.hasChildNodes()) {
      nl = node.getChildNodes();
      List <String> XMLElementList = new ArrayList <String>();
     
      for (int i=0; i<nl.getLength(); i++){
        Node childNode = nl.item(i);
        String childNodeName = childNode.getNodeName();
       
        if(childNode.getNodeType() == Node.ELEMENT_NODE ){
          XMLElementList.add(childNodeName);
          if(childNode.hasChildNodes()) {
            String fieldName = getFieldName(childNodeName);
            Field field = testObject.getClass().getDeclaredField(fieldName);
            Object fieldValue = getFieldValue(testObject,field,fieldName);
            
            if(field.getType().getSimpleName().equals("List") && isModelObject(getListParameterizedType(field))) {
            	List<?> eachList = (List<?>) fieldValue;
                for (int j=0; j<eachList.size(); j++){  
                	testSchemaRecursively(nl.item(i),eachList.get(j));
                }  
            } else {
            	testSchemaRecursively(nl.item(i),fieldValue);
            }
                            
            
          }
      }
  }
      
      if(!XMLElementList.isEmpty()){

        Field[] objectFieldList = testObject.getClass().getDeclaredFields();
        Assert.assertNotNull("Field Arrya is NULL for Object "+testObject.getClass().getName());
        
        List <String> fieldList = getObjectFieldList(objectFieldList);
        CompareObjectToXML(XMLElementList,fieldList );
      }
        
    }
  }

  private String getFieldName(String nodeName) {

    String result = null;

    int i;
    for (i=0; i < RESERVED_TOKENS.size(); i++) {
      if (nodeName.startsWith(RESERVED_TOKENS.get(i))) {
        result = nodeName;
        break;
      }
    }

    if (i == RESERVED_TOKENS.size()) {
        result = nodeName.replaceFirst(nodeName.substring(0, 1), nodeName.substring(0, 1).toLowerCase());
    }

    return result;
  }
    
  /**
   * Method creates a List of Strings with all field names in the Field Array
   * 
   * @param objectFieldList
   * @return
   */
  protected List<String> getObjectFieldList(Field[] objectFieldList){
    
    List <String> fieldList= new ArrayList<String>();
    
    String fieldName = null;
    
    for (Field f : objectFieldList){
    fieldName = f.getName();
    fieldList.add(fieldName.replaceFirst(fieldName.substring(0,1), fieldName.substring(0,1).toUpperCase()));
    }
    
    return fieldList;    
  }
  
  /**
   * Compared Schema with its object
   * 
   * @param XMLElementList
   * @param fieldList
   */
  protected void CompareObjectToXML(List<String> XMLElementList,List<String> fieldList) {
    for(String element : XMLElementList) {
      Assert.assertNotNull(element + " is NOT available in Object Class",fieldList.contains(element));
    }
  }


}
