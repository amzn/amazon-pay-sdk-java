package PayWithAmazon;

import java.util.HashMap;

public class ClientMappings {
        
    private HashMap<String,String> regionMappings = new HashMap<String,String>();
    private HashMap<String,String> regionEndpointMappings = new HashMap<String,String>();
    private HashMap<String,String> regionProfileEndpointMappings = new HashMap<String,String>();
    private HashMap<String,String> regionProfileEndpointSandboxMappings = new HashMap<String,String>();
    
    public HashMap<String, String> getRegionMappings() {
        return regionMappings;
    }

    public HashMap<String, String> getRegionEndpointMappings() {
        return regionEndpointMappings;
    }

    public HashMap<String, String> getRegionProfileEndpointMappings() {
        return regionProfileEndpointMappings;
    }

    public HashMap<String, String> getRegionProfileEndpointSandboxMappings() {
        return regionProfileEndpointSandboxMappings;
    }
    
    public ClientMappings() {
       regionEndpointMappings.put("eu" , "https://mws-eu.amazonservices.com");
       regionEndpointMappings.put("na" , "https://mws.amazonservices.com");
       regionEndpointMappings.put("jp" , "https://mws.amazonservices.jp");
       
       regionProfileEndpointMappings.put("uk" , "https://api.amazon.co.uk");
       regionProfileEndpointMappings.put("us" , "https://api.amazon.com");
       regionProfileEndpointMappings.put("de" , "https://api.amazon.de");
       regionProfileEndpointMappings.put("jp" , "https://api.amazon.co.jp");
       
       regionProfileEndpointMappings.put("uk" , "https://api.sandbox.amazon.co.uk");
       regionProfileEndpointMappings.put("us" , "https://api.sandbox.amazon.com");
       regionProfileEndpointMappings.put("de" , "https://api.sandbox.amazon.de");
       regionProfileEndpointMappings.put("jp" , "https://api.sandbox.amazon.co.jp");
       
       regionMappings.put("uk" , "eu");
       regionMappings.put("us" , "na");
       regionMappings.put("de" , "eu");
       regionMappings.put("jp" , "jp");
    }
        
}
