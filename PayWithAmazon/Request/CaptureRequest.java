package PayWithAmazon.Request;

import PayWithAmazon.Utilities.ParamConstants;
import java.util.*;

/**
 * Build request for Capture API.
 * For documentation, refer - https://payments.amazon.com/documentation/apireference/201751630#201752040
 */

public class CaptureRequest {
    
    //required parameters
    private String amazonAuthorizationId = null;  
    private String captureReferenceId = null;
    private String captureAmount = null;
    private String captureCurrencyCode = null;
    
    //optional parameters
    private String sellerCaptureNote = null;
    private String softDescriptor = null;
    private String mwsAuthToken = null;   

    private Map<String,String> parameters = new HashMap<String,String>();

    public CaptureRequest setAmazonAuthorizationId(String amazonAuthorizationId ){
        this.amazonAuthorizationId  = amazonAuthorizationId ;
        parameters.put(ParamConstants.AMAZON_AUTHORIZATION_ID, amazonAuthorizationId );
        return this;
    }
    
    public CaptureRequest setCaptureReferenceId(String captureReferenceId) {
        this.captureReferenceId = captureReferenceId;
        parameters.put( ParamConstants.CAPTURE_REFERENCE_ID , captureReferenceId );
        return this;
    }

    public CaptureRequest setCaptureAmount(String captureAmount) {
        this.captureAmount = captureAmount;
        parameters.put( ParamConstants.CAPTURE_AMOUNT , captureAmount );
        return this;
    }
    public CaptureRequest setCaptureCurrencyCode(String captureCurrencyCode) {
        this.captureCurrencyCode = captureCurrencyCode;
        parameters.put( ParamConstants.CAPTURE_CURRENCEYCODE , captureCurrencyCode );
        return this;
    }

    public CaptureRequest setSellerCaptureNote(String sellerCaptureNote) {
        this.sellerCaptureNote = sellerCaptureNote;
        parameters.put( ParamConstants.CAPTURE_NOTE , sellerCaptureNote );
        return this;
    }
    
    public CaptureRequest setSoftDescriptor(String softDescriptor) {
        this.softDescriptor = softDescriptor;
        parameters.put( ParamConstants.SOFT_DESCRIPTOR , softDescriptor );
        return this;
    }
    
    public CaptureRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        parameters.put(ParamConstants.MWS_AUTH_TOKEN, mwsAuthToken);
        return this;
    }
    
    public Map<String,String> getParamMap(){
        return parameters;
        
    }
    
}
