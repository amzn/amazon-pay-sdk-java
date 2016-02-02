package com.amazon.payments.paywithamazon.request;

import com.amazon.payments.paywithamazon.types.CurrencyCode;
import java.io.Serializable;

/**
 * Container for the parameters to the 
 * {@link com.amazon.payments.lpa.Client#reverseProviderCredit(ReverseProviderCreditRequest) ReverseProviderCredit operation}.
 *
 */
public class ReverseProviderCreditRequest implements Serializable{
        
    //required parameters
    private String amazonProviderCreditId;
    private String creditReversalReferenceId;
    private String creditReversalAmount;
    private CurrencyCode creditReversalAmountCurrencyCode;
    private String sellerId;
    
    //optional parameters
    private String creditReversalNote ;
    private String mwsAuthToken;
  
    /**
     * 
     * @param amazonProviderCreditId
     * @param creditReversalReferenceId
     * @param sellerId
     * @param creditReversalAmount 
     */
    public ReverseProviderCreditRequest(String amazonProviderCreditId, String creditReversalReferenceId, String sellerId, String creditReversalAmount){
        this.amazonProviderCreditId = amazonProviderCreditId;
        this.creditReversalReferenceId = creditReversalReferenceId;
        this.creditReversalAmount = creditReversalAmount;
        this.sellerId = sellerId;
    }
    
    /**
     * 
     * @param currencyCode
     */
    public ReverseProviderCreditRequest setCreditReversalCurrencyCode(CurrencyCode currencyCode) {
        this.creditReversalAmountCurrencyCode = currencyCode;
        return this;
    }

    
    /**
     * 
     * @param creditReversalNote
     */
    public ReverseProviderCreditRequest setCreditReversalNote(String creditReversalNote) {
        this.creditReversalNote = creditReversalNote;
        return this;
    }
    
    /**
     * 
     * @param mwsAuthToken
     */
    public ReverseProviderCreditRequest setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * 
     * @return amazonProviderCreditId
     */
    public String getAmazonProviderCreditId() {
        return amazonProviderCreditId;
    }

    /**
     * 
     * @return creditReversalReferenceId
     */
    public String getCreditReversalReferenceId() {
        return creditReversalReferenceId;
    }

    /**
     * 
     * @return creditReversalAmount
     */
    public String getCreditReversalAmount() {
        return creditReversalAmount;
    }

    /**
     * 
     * @return creditReversalAmountCurrencyCode
     */
    public CurrencyCode getCreditReversalAmountCurrencyCode() {
        return creditReversalAmountCurrencyCode;
    }

    /**
     * 
     * @return sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 
     * @return creditReversalNote
     */
    public String getCreditReversalNote() {
        return creditReversalNote;
    }

    /**
     * 
     * @return mwsAuthToken
     */
    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ReverseProviderCreditRequest{" + "amazonProviderCreditId=" + amazonProviderCreditId + ", creditReversalReferenceId=" 
                + creditReversalReferenceId + ", creditReversalAmount=" + creditReversalAmount + ", creditReversalAmountCurrencyCode=" 
                + creditReversalAmountCurrencyCode + ", sellerId=" + sellerId + ", creditReversalNote=" + creditReversalNote + ", mwsAuthToken=" 
                + mwsAuthToken + '}';
    }

    
}
