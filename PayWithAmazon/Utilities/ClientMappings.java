package PayWithAmazon.Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class ClientMappings {
        
    public static final Map<String, String> regionMappings;
    public static final Map<String, String> regionEndpointMappings;
    public static final Map<String, String> regionProfileEndpointMappings;
    public static final Map<String, String> regionProfileEndpointSandboxMappings;

    static {
        Map<String, String> regionMappingsMap = new HashMap<String,String>();
        regionMappingsMap.put("uk" , "eu");
        regionMappingsMap.put("us" , "na");
        regionMappingsMap.put("de" , "eu");
        regionMappingsMap.put("jp" , "jp");
        regionMappings = Collections.unmodifiableMap(regionMappingsMap);
        
        Map<String, String> regionEndpointMappingsMap = new HashMap<String,String>();
        regionEndpointMappingsMap.put("eu" , "https://mws-eu.amazonservices.com");
        regionEndpointMappingsMap.put("na" , "https://mws.amazonservices.com");
        regionEndpointMappingsMap.put("jp" , "https://mws.amazonservices.jp");
        regionEndpointMappings = Collections.unmodifiableMap(regionEndpointMappingsMap);

        Map<String, String>  regionProfileEndpointMappingsMap = new HashMap<String,String>();
        regionProfileEndpointMappingsMap.put("uk" , "https://api.amazon.co.uk");
        regionProfileEndpointMappingsMap.put("us" , "https://api.amazon.com");
        regionProfileEndpointMappingsMap.put("de" , "https://api.amazon.de");
        regionProfileEndpointMappingsMap.put("jp" , "https://api.amazon.co.jp");
        regionProfileEndpointMappings = Collections.unmodifiableMap(regionProfileEndpointMappingsMap);

        Map<String, String>  regionProfileEndpointSandboxMappingsMap = new HashMap<String,String>();
        regionProfileEndpointSandboxMappingsMap.put("uk" , "https://api.sandbox.amazon.co.uk");
        regionProfileEndpointSandboxMappingsMap.put("us" , "https://api.sandbox.amazon.com");
        regionProfileEndpointSandboxMappingsMap.put("de" , "https://api.sandbox.amazon.de");
        regionProfileEndpointSandboxMappingsMap.put("jp" , "https://api.sandbox.amazon.co.jp");
        regionProfileEndpointSandboxMappings = Collections.unmodifiableMap(regionProfileEndpointSandboxMappingsMap);

    }

}
