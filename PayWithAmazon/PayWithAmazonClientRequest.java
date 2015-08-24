package PayWithAmazon;

import java.util.HashMap;
import java.util.Map;

public class PayWithAmazonClientRequest {

    public ClientMappings c = new ClientMappings();
    
    public String merchant_id, access_key, secret_key, client_id, sandbox;
    private String currency_code, region, platform_id, throttle, application_name, application_version;
    private String proxy_addr, proxy_user, proxy_pass, proxy_port;
    public static final String AMAZON_PAYMENTS_API_VERSION = "2013-01-01";

    private Map<String, String> params = new HashMap<String, String>();
    
    public String amazon_payments_service_url;    
    public String amazon_payments_service_mode;
    public String amazon_payments_service_and_api_version;
    public String amazon_payments_endpoint;
    

    public PayWithAmazonClientRequest(String merchant_id, String access_key, String secret_key, String region, String sandbox) {
        this.merchant_id = merchant_id;
        this.access_key = access_key;
        this.secret_key = secret_key;
        this.region = region;
        this.sandbox = sandbox;
        initializeAmazonPaymentEndpoints(this.sandbox, this.region);
    }
    

    /**
     * Set the value of currency_code
     *
     * @param currency_code new value of currency_code
     */
    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
        this.params.put("currency_code", currency_code);
    }

    /**
     * Set the value of region
     *
     * @param region new value of region
     */
    public void setRegion(String region) {
        this.region = region;
        this.params.put("region", region);
        initializeAmazonPaymentEndpoints(this.sandbox, this.region);
    }


    /**
     * Set the value of platform_id
     *
     * @param platform_id new value of platform_id
     */
    public void setPlatform_id(String platform_id) {
        this.platform_id = platform_id;
        this.params.put("platform_id", platform_id);

    }


    /**
     * Set the value of throttle
     *
     * @param throttle new value of throttle
     */
    public void setThrottle(String throttle) {
        this.throttle = throttle;
        this.params.put("throttle", throttle);

    }


    /**
     * Set the value of application_name
     *
     * @param application_name new value of application_name
     */
    public void setApplication_name(String application_name) {
        this.application_name = application_name;
        this.params.put("application_name", application_name);
        initializeAmazonPaymentEndpoints(this.sandbox, this.region);
    }


    /**
     * Set the value of application_version
     *
     * @param application_version new value of application_version
     */
    public void setApplication_version(String application_version) {
        this.application_version = application_version;
        this.params.put("application_version", application_version);

    }


    /**
     * Set the value of proxy_addr
     *
     * @param proxy_addr new value of proxy_addr
     */
    public void setProxy_addr(String proxy_addr) {
        this.proxy_addr = proxy_addr;
        this.params.put("proxy_addr", proxy_addr);
    }


    /**
     * Set the value of proxy_port
     *
     * @param proxy_port new value of proxy_port
     */
    public void setProxy_port(String proxy_port) {
        this.proxy_port = proxy_port;
        this.params.put("proxy_port", proxy_port);
    }


    /**
     * Set the value of proxy_user
     *
     * @param proxy_user new value of proxy_user
     */
    public void setProxy_user(String proxy_user) {
        this.proxy_user = proxy_user;
        this.params.put("proxy_user", proxy_user);
    }


    /**
     * Set the value of proxy_pass
     *
     * @param proxy_pass new value of proxy_pass
     */
    public void setProxy_pass(String proxy_pass) {
        this.proxy_pass = proxy_pass;
        this.params.put("proxy_pass", proxy_pass);
    }

    /**
     * Set the value of sandbox
     *
     * @param sandbox new value of sandbox
     */
    public void setSandbox(String sandbox) {
        this.sandbox = sandbox;
        this.params.put("sandbox", sandbox);

    }
    
    
    public String getAmazonPaymentsEndpoint() {
        return amazon_payments_endpoint;
    }

    public String getAmazonPaymentsServiceAPIVersion() {
        return amazon_payments_service_and_api_version;
    }

    public String getAmazonPaymentsServiceURL() {
        return amazon_payments_service_url;
    }

        public void initializeAmazonPaymentEndpoints(String sandbox, String region){
           ClientMappings c = new ClientMappings();
           c.initialize();
           amazon_payments_service_url = c.amazonPaymentsServiceURLs.get(c.regionMappings.get(region));
           
            String sandbox_str;
            if(sandbox.equals("true")) {
                sandbox_str = "OffAmazonPayments_Sandbox";
            }
           else { 
                sandbox_str ="OffAmazonPayments";
            }
            amazon_payments_service_mode = sandbox_str;
            amazon_payments_service_and_api_version = "/" + amazon_payments_service_mode + "/" + AMAZON_PAYMENTS_API_VERSION;
            amazon_payments_endpoint = amazon_payments_service_url + "/" + amazon_payments_service_and_api_version;
    }



}
