/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.impl;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PayConfigLoaderFactory {

    /**
     * Loads configuration from specified JSON file
     *
     * @param fileLocation
     *             The file location from which to load the client configuration
     *
     * @throws IllegalArgumentException
     *             If required properties are missing. Or if an invalid property key or value is encountered.
     *
     * @throws FileNotFoundException
     *             If specified file isn't found
     *
     * @throws IOException
     *             If any problems are encountered while reading from file
     *
     * @return PaymentConfig
     */
    public static PayConfig loadConfigFromJSON(String fileLocation) throws IllegalArgumentException, FileNotFoundException, IOException{
        BufferedReader br = null;
        Properties prop = null;
        try {
            br = new BufferedReader(new FileReader(fileLocation));
            prop = new Gson().fromJson(br, Properties.class);
        } finally {
            if(br != null)
                br.close();
        }
        return new PayConfig(prop);
    }


    /**
     * Loads configuration from specified Java properties file
     *
     * @param fileLocation
     *             The file location from which to load the client configuration
     *
     * @throws IllegalArgumentException
     *             If required properties are missing. Or if an invalid property key or value is encountered.
     *
     * @throws FileNotFoundException
     *             If specified file isn't found
     *
     * @throws IOException
     *             If any problems are encountered while reading from file
     *
     * @return PayConfig
     */
    public static PayConfig loadConfigFromPropertiesFile(String fileLocation) throws IllegalArgumentException, FileNotFoundException, IOException {
        InputStream input = null;
        Properties prop = new Properties();
        try {
            input = new FileInputStream(fileLocation);
            prop.load(input);
        } finally {
            if(input != null)
                input.close();
        }
        return new PayConfig(prop);
    }


}