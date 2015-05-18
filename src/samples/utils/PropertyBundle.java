/******************************************************************************
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
 * ****************************************************************************
 */


package samples.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyBundle {
	private static final String PROPERTY_FILE_NAME = "OffAmazonPaymentsService.config.properties";
	private static Properties properties;
	static {
		properties = new Properties();
		try{
			InputStream in = PropertyBundle.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
			properties.load(in);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + PROPERTY_FILE_NAME+ " not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException : Can't read " + PROPERTY_FILE_NAME);
			e.printStackTrace();
		}
	}

	public static Properties getProperties() {
		return properties;
	}
}
