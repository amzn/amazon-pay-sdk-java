/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon;

import java.util.HashMap;
/**
 *
 * @author nehaa
 */
public class ClientMappings {
    
    
    public enum URL {
        
        MWS_EU("https://mws-eu.amazonservices.com","eu"),
        MWS_NA("https://mws.amazonservices.com" ,"na"),
        MWS_JP("https://mws.amazonservices.jp", "jp"),
 
        
        API_ENDPOINT_UK("https://api.amazon.co.uk", "uk"),
        API_ENDPOINT_US("https://api.amazon.com" ,"us"),
        API_ENDPOINT_DE("https://api.amazon.de", "de"),
        API_ENDPOINT_JP("https://api.amazon.co.jp", "jp"),
        
        API_ENDPOINT_UK_SANDBOX("https://api.sandbox.amazon.co.uk" , "uk"),
        API_ENDPOINT_US_SANDBOX("https://api.sandbox.amazon.com" , "us"),
        API_ENDPOINT_DE_SANDBOX("https://api.sandbox.amazon.de" , "de"),
        API_ENDPOINT_JP_SANDBOX("https://api.sandbox.amazon.co.jp" , "jp");

        String url;
        String region;
        
        URL(String url, String region) {
           this.url = url;
           this.region = region;
       }
       
       private String getURL() {
           return url;
       }
       
       private String getRegion() {
           return region;
       }
       
    }
    public static final int MAX_ERROR_RETRY = 3;
    
    public HashMap<String,String> regionMappings = new HashMap<String,String>();
    public HashMap<String,String> amazonPaymentsServiceURLs = new HashMap<String,String>();
    public HashMap<String,String> amazonPaymentsProfileEndpointURLs = new HashMap<String,String>();
    public HashMap<String,String> amazonPaymentsSandboxProfileEndpointURLs = new HashMap<String,String>();
    
    //public static final String MWS_CLIENT_VERSION = "1.0.0";
    
    public void initialize(){
       amazonPaymentsServiceURLs.put("eu",URL.MWS_EU.getURL());
       amazonPaymentsServiceURLs.put("na",URL.MWS_NA.getURL());
       amazonPaymentsServiceURLs.put("jp",URL.MWS_JP.getURL());
       
       amazonPaymentsProfileEndpointURLs.put("uk" , URL.API_ENDPOINT_UK.getURL());
       amazonPaymentsProfileEndpointURLs.put("us" , URL.API_ENDPOINT_US.getURL());
       amazonPaymentsProfileEndpointURLs.put("de" , URL.API_ENDPOINT_DE.getURL());
       amazonPaymentsProfileEndpointURLs.put("jp",URL.API_ENDPOINT_JP.getURL());
       
       amazonPaymentsProfileEndpointURLs.put("uk",URL.API_ENDPOINT_UK_SANDBOX.getURL());
       amazonPaymentsProfileEndpointURLs.put("us",URL.API_ENDPOINT_US_SANDBOX.getURL());
       amazonPaymentsProfileEndpointURLs.put("de",URL.API_ENDPOINT_DE_SANDBOX.getURL());
       amazonPaymentsProfileEndpointURLs.put("jp",URL.API_ENDPOINT_JP_SANDBOX.getURL());
       
       regionMappings.put("uk","eu");
       regionMappings.put("us","na");
       regionMappings.put("de","eu");
       regionMappings.put("jp","jp");
    }
}
