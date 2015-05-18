/*******************************************************************************
 *  Copyright 2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * *****************************************************************************
 */

package samples;

import java.io.PrintWriter;

import samples.utils.Utilities;

import com.amazonservices.mws.offamazonpayments.*;
import com.amazonservices.mws.offamazonpayments.model.*;

/**
 * .
 * Reverse Provider Credit Example
 * 
 * This example will show the following service calls:
 * - ReverseProviderCredit
 * - GetProviderCreditReversalDetails
 */

public class ReverseProviderCreditExample extends CheckoutExampleBase {

    private String amazonProviderCreditId = null;
    private String reverseProviderCreditReferenceId = null;

    public ReverseProviderCreditExample(String amazonProviderCreditId, OffAmazonPaymentsServiceConfig config,
            OffAmazonPaymentsServiceClient service, PrintWriter outStream) {
        super(config, service, outStream);
        this.amazonProviderCreditId = amazonProviderCreditId;
        this.reverseProviderCreditReferenceId = this.amazonProviderCreditId + "q0";
    }

    /**
     * Method to reverse provider credit partial/complete amount on a provider credit amount.
     * 
     * @param creditReversalAmount
     * @param optionalCreditReversalNote
     * @return ReverseProviderCreditResponse
     * @throws OffAmazonPaymentsServiceException
     */
    public ReverseProviderCreditResponse reverseProviderCredit(double creditReversalAmount,
            String optionalCreditReversalNote) throws OffAmazonPaymentsServiceException {

        GetProviderCreditDetailsResponse getProviderCreditDetailsResponse = this.getProviderCreditDetailsResponse();
        Utilities.validateResponseNotNull(getProviderCreditDetailsResponse, "GetProviderCreditDetailsResponse");

        if (creditReversalAmount < 0.00) {
            throw new OffAmazonPaymentsServiceException("creditReversalAmount is not a valid amount");
        }
        /*
         * Below code is used to generate unique Credit Reversal Reference Id for
         * each credkt reversal on this provider credit id. It uses CreditReversalIdList to check if
         * there was any previous credit reversal to this provider credit:
         * If Yes, it appends the IdList count of refundId.
         * If the ID list is empty, it start with count 1
         * In this way the Ids are incremental like
         * <ProviderCreditId>q01, <ProviderCreditId>q02,<ProviderCreditId>q03,...
         */
        IdList creditReversalIdList = getProviderCreditDetailsResponse.getGetProviderCreditDetailsResult()
                .getProviderCreditDetails().getCreditReversalIdList();
        if (creditReversalIdList.isSetMember()) {
            int creditReversalCount = creditReversalIdList.getMember().size() + 1;
            this.reverseProviderCreditReferenceId = this.reverseProviderCreditReferenceId
                    + new Integer(creditReversalCount).toString();
        } else {
            this.reverseProviderCreditReferenceId = this.reverseProviderCreditReferenceId + "1";
        }

        ReverseProviderCreditRequest request = new ReverseProviderCreditRequest();

        Price creditReversalAmountPrice = new Price();
        creditReversalAmountPrice.setAmount(Double.toString(creditReversalAmount));
        creditReversalAmountPrice.setCurrencyCode(config.getCurrencyCode());

        request.setCreditReversalAmount(creditReversalAmountPrice);
        request.setAmazonProviderCreditId(this.amazonProviderCreditId);
        request.setCreditReversalReferenceId(this.reverseProviderCreditReferenceId);
        request.setSellerId(this.sellerId);

        /*
         * Optional Parameters
         */
        if (optionalCreditReversalNote != null) {
            request.setCreditReversalNote(optionalCreditReversalNote);
        }

        ReverseProviderCreditResponse response = this.service.reverseProviderCredit(request);

        return response;
    }

    /**
     * .
     * Method to get the provider credit details, Give details about
     * the provider credit id.
     * 
     * @return GetPrvoviderCreditDetailsResponse
     * @throws OffAmazonPaymentsServiceException
     */
    private GetProviderCreditDetailsResponse getProviderCreditDetailsResponse()
            throws OffAmazonPaymentsServiceException {
        GetProviderCreditDetailsRequest request = new GetProviderCreditDetailsRequest();
        request.setAmazonProviderCreditId(this.amazonProviderCreditId);
        request.setSellerId(this.sellerId);

        GetProviderCreditDetailsResponse response = this.service.getProviderCreditDetails(request);
        return response;
    }

}
