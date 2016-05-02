package com.amazonservices.mws.offamazonpayments.regionproperties;

import org.apache.commons.lang.StringUtils;
import com.amazonservices.mws.offamazonpayments.Environment;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.Region;
import com.amazonservices.mws.offamazonpayments.common.ModelConstants;

public class RegionDependentSettings {

    private String region;

    public RegionDependentSettings(Region region) {
        this.region = region.getValue().toUpperCase();
    }

    public String getMwsUrlForEnvironment(Environment environment) {
        return UrlBuilder.buildMwsUrlWithBaseForEnvironment(getValueForKey(ModelConstants.MWS_URL_KEY),
                environment);
    }

    public String getWidgetUrlForEnvironment(Environment environment) {
        return UrlBuilder.buildWidgetUrlWithBaseAndLocaleForEnvironment(
                getValueForKey(ModelConstants.WIDGET_URL_KEY),
                getLocale(), environment);
    }

    public String getCurrencyCode() {
        return getValueForKey(ModelConstants.CURRENCY_CODE_KEY);
    }

    public String getLocale() {
        return getValueForKey(ModelConstants.LOCALE_KEY);
    }

    private String getValueForKey(String key) {
        String searchKey = region + "." + key;
        String value = RegionDependentPropertyBundle.getProperties().getProperty(searchKey);
        if (StringUtils.isEmpty(value)) {
            throw new OffAmazonPaymentsServiceException("No value found for key: " + searchKey
                    + " in Region dependent properties.");
        }
        return value;
    }
}
