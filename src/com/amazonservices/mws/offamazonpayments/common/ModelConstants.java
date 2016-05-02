package com.amazonservices.mws.offamazonpayments.common;

public final class ModelConstants {

    /**
     * Empty value for the MWS Auth token field, required
     * for merchants with delegated access to transact on
     * another merchants behalf.
     * 
     */
    public static final String EMPTY_MWS_AUTH_TOKEN = null;

    /**
     * The following constants are the keys associated to the
     * configurations for each region/country in the
     * RegionDependent.config.properties file
     */
    public static final String MWS_URL_KEY = "MWS_URL";
    public static final String WIDGET_URL_KEY = "WIDGET_URL";
    public static final String CURRENCY_CODE_KEY = "CURRENCY_CODE";
    public static final String LOCALE_KEY = "LOCALE";
}
