package com.amazonservices.mws.offamazonpayments.regionproperties;

import com.amazonservices.mws.offamazonpayments.Environment;

import static com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConstants.CLIENT_VERSION;

public final class UrlBuilder {

	private UrlBuilder() {
		
	}
	
	public static String buildMwsUrlWithBaseForEnvironment(String urlBase, Environment environment)
    {
        StringBuilder builder = createStringBuilderWithUrlBase(urlBase);

        builder.append("OffAmazonPayments");
        if (isSandbox(environment))
        {
            builder.append("_Sandbox");
        }

        builder.append("/");
        builder.append(CLIENT_VERSION);
        return builder.toString();
    }

    public static String buildWidgetUrlWithBaseAndLocaleForEnvironment(String urlBase, String locale, Environment environment)
    {
        StringBuilder builder = createStringBuilderWithUrlBase(urlBase);
        builder.append("OffAmazonPayments/");
        builder.append(locale);
        if (isSandbox(environment))
        {
            builder.append("/sandbox");
        }
        if(!locale.equals("us")) {
        	builder.append("/lpa");
        }
        builder.append("/js/Widgets.js");
        return builder.toString();
    }

    private static StringBuilder createStringBuilderWithUrlBase(String urlBase)
    {
        StringBuilder builder = new StringBuilder(urlBase);
        if (!urlBase.endsWith("/"))
        {
            builder.append("/");
        }
        return builder;
    }
    
    private static boolean isSandbox(Environment environment)
    {
        return Environment.SANDBOX.equals(environment);
    }
}
