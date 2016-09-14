package com.amazon.payments.paywithamazon.impl;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PaymentsConfigLoaderFactory {

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
    public static PaymentsConfig loadConfigFromJSON(String fileLocation) throws IllegalArgumentException, FileNotFoundException, IOException{
        BufferedReader br = null;
        Properties prop = null;
        try {
            br = new BufferedReader(new FileReader(fileLocation));
            prop = new Gson().fromJson(br, Properties.class);
        } finally {
            if(br != null)
                br.close();
        }
        return new PaymentsConfig(prop);
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
     * @return PaymentsConfig
     */
    public static PaymentsConfig loadConfigFromPropertiesFile(String fileLocation) throws IllegalArgumentException, FileNotFoundException, IOException {
        InputStream input = null;
        Properties prop = new Properties();
        try {
            input = new FileInputStream(fileLocation);
            prop.load(input);
        } finally {
            if(input != null)
                input.close();
        }
        return new PaymentsConfig(prop);
    }


}