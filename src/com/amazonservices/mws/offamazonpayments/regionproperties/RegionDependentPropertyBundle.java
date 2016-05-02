package com.amazonservices.mws.offamazonpayments.regionproperties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;

public class RegionDependentPropertyBundle {
    private static final String PROPERTY_FILE_NAME = "RegionDependent.config.properties";
    private static Properties properties;
    private static final String CLASS_PATH = System.getProperty("java.class.path");
    static {
        properties = new Properties();
        try {
            InputStream in = RegionDependentPropertyBundle.class.getResourceAsStream(PROPERTY_FILE_NAME);
            properties.load(in);
        } catch (FileNotFoundException e) {
            throw new OffAmazonPaymentsServiceException("File not found. Make sure the file: " + PROPERTY_FILE_NAME
                    + " is present in java class path: " + CLASS_PATH, e);
        } catch (IOException e) {
            throw new OffAmazonPaymentsServiceException("IOException in reading file: " + PROPERTY_FILE_NAME
                    + " present in java class path: " + CLASS_PATH, e);
        }
    }

    static Properties getProperties() {
        return properties;
    }
}
