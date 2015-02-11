package samples.utils;

import java.io.PrintWriter;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpaymentsipn.model.ProviderCreditReversalSummary;
import com.amazonservices.mws.offamazonpaymentsipn.model.ProviderCreditReversalSummaryList;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationDetails;
import com.amazonservices.mws.offamazonpaymentsipn.model.IdList;
import com.amazonservices.mws.offamazonpaymentsipn.model.OrderItemCategories;
import com.amazonservices.mws.offamazonpaymentsipn.model.Price;
import com.amazonservices.mws.offamazonpaymentsipn.model.RefundDetails;
import com.amazonservices.mws.offamazonpaymentsipn.model.RefundNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.Status;
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationNotification;

public class Utilities {

    private static PrintWriter defaultOutStream = new PrintWriter(System.out);

    /**
     * Helper Method to check for NULL response object
     * 
     * @param response
     * @param responseName
     * @return
     * @throws OffAmazonPaymentsServiceException
     */
    public static boolean validateResponseNotNull(Object response, String responseObjectName)
            throws OffAmazonPaymentsServiceException {
        if (response != null) {
            return true;
        } else {
            throw new OffAmazonPaymentsServiceException(responseObjectName + " object is NULL");
        }
    }

    /**
     * Prints to System.out the key on the first line and the value on the second,
     * preceded by one tab. Both lines are preceded by tabLevel tabs.
     * 
     * @param key
     * @param value
     * @param tabLevel
     */
    public static void printVariable(String key, String value, int tabLevel) {
        printVariable(key, value, tabLevel, defaultOutStream);
    }

    /**
     * Prints to outStream the key on the first line and the value on the second,
     * preceded by one tab. Both lines are preceded by tabLevel tabs.
     * 
     * @param key
     * @param value
     * @param tabLevel
     */
    public static void printVariable(String key, String value, int tabLevel, PrintWriter outStream) {
        if (key != null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < tabLevel; i++) {
                builder.append("\t");
            }
            outStream.println(builder.toString() + key + "\n");
            if (value != null) {
                builder.append("\t");
                outStream.println(builder.toString() + value + "\n");
            }
        }
    }

    /**
     * Method to print Get Authorization Details response to console
     * 
     * @param response
     *            instance of GetAuthorizationDetailsResponse
     */
    public static void printAuthorizationNotification(AuthorizationNotification response, PrintWriter outStream) {

        int tabLevel = 0;
        outStream.println("GetAuthorizationDetails Action Response");
        outStream.println("=============================================================================");
        outStream.println();

        tabLevel++;
        AuthorizationDetails authorizationDetails = response.getAuthorizationDetails();
        printVariable("AuthorizationDetails", null, tabLevel, outStream);
        if (authorizationDetails.isSetAmazonAuthorizationId()) {
            printVariable("AmazonAuthorizationId", authorizationDetails.getAmazonAuthorizationId(), tabLevel, outStream);
        }
        if (authorizationDetails.isSetAuthorizationReferenceId()) {
            printVariable("AuthorizationReferenceId", authorizationDetails.getAuthorizationReferenceId(), tabLevel,
                    outStream);
        }
        tabLevel++;
        if (authorizationDetails.isSetAuthorizationAmount()) {
            printVariable("AuthorizationAmount", null, tabLevel, outStream);
            Price authorizationAmount = authorizationDetails.getAuthorizationAmount();
            if (authorizationAmount.isSetAmount()) {
                printVariable("Amount", authorizationAmount.getAmount(), tabLevel, outStream);
            }
            if (authorizationAmount.isSetCurrencyCode()) {
                printVariable("CurrencyCode", authorizationAmount.getCurrencyCode(), tabLevel, outStream);
            }
        }
        if (authorizationDetails.isSetCapturedAmount()) {
            printVariable("CapturedAmount", null, tabLevel, outStream);
            Price capturedAmount = authorizationDetails.getCapturedAmount();
            if (capturedAmount.isSetAmount()) {
                printVariable("Amount", capturedAmount.getAmount(), tabLevel, outStream);
            }
            if (capturedAmount.isSetCurrencyCode()) {
                printVariable("CurrencyCode", capturedAmount.getCurrencyCode(), tabLevel, outStream);
            }
        }
        if (authorizationDetails.isSetAuthorizationFee()) {
            printVariable("AuthorizationFee", null, tabLevel, outStream);
            Price authorizationFee = authorizationDetails.getAuthorizationFee();
            if (authorizationFee.isSetAmount()) {
                printVariable("Amount", authorizationFee.getAmount(), tabLevel, outStream);
            }
            if (authorizationFee.isSetCurrencyCode()) {
                printVariable("CurrencyCode", authorizationFee.getCurrencyCode(), tabLevel, outStream);
            }
        }
        if (authorizationDetails.isSetIdList()) {
            printVariable("IdList", null, tabLevel, outStream);
            IdList idList = authorizationDetails.getIdList();
            java.util.List<String> memberList = idList.getId();
            for (String member : memberList) {
                printVariable("Id", member, tabLevel, outStream);
            }
        }
        tabLevel--;
        if (authorizationDetails.isSetCreationTimestamp()) {
            printVariable("CreationTimestamp", authorizationDetails.getCreationTimestamp().toString(), tabLevel,
                    outStream);
        }
        if (authorizationDetails.isSetExpirationTimestamp()) {
            printVariable("ExpirationTimestamp", authorizationDetails.getExpirationTimestamp().toString(), tabLevel,
                    outStream);
        }
        if (authorizationDetails.isSetAddressVerificationCode()) {
            printVariable("AddressVerificationCode", authorizationDetails.getAddressVerificationCode(), tabLevel,
                    outStream);
        }
        if (authorizationDetails.isSetAuthorizationStatus()) {
            printVariable("AuthorizationStatus", null, tabLevel, outStream);
            Status authorizationStatus = authorizationDetails.getAuthorizationStatus();
            tabLevel++;
            if (authorizationStatus.isSetState()) {
                printVariable("State", authorizationStatus.getState(), tabLevel, outStream);
            }
            if (authorizationStatus.isSetLastUpdateTimestamp()) {
                printVariable("LastUpdateTimestamp", authorizationStatus.getLastUpdateTimestamp().toString(), tabLevel,
                        outStream);
            }
            if (authorizationStatus.isSetReasonCode()) {
                printVariable("ReasonCode", authorizationStatus.getReasonCode(), tabLevel, outStream);
            }
            if (authorizationStatus.isSetReasonDescription()) {
                printVariable("ReasonDescription", authorizationStatus.getReasonDescription(), tabLevel, outStream);
            }
            tabLevel--;
        }
        if (authorizationDetails.isSetOrderItemCategories()) {
            printVariable("OrderItemCategories", null, tabLevel, outStream);
            OrderItemCategories orderItemCategories = authorizationDetails.getOrderItemCategories();
            java.util.List<String> orderItemCategoryList = orderItemCategories.getOrderItemCategory();
            tabLevel++;
            for (String orderItemCategory : orderItemCategoryList) {
                printVariable("OrderItemCategory", orderItemCategory, tabLevel, outStream);
            }
            tabLevel--;
        }
        if (authorizationDetails.isSetCaptureNow()) {
            printVariable("CaptureNow", authorizationDetails.isCaptureNow() + "", tabLevel, outStream);
        }
        if (authorizationDetails.isSetSoftDescriptor()) {
            printVariable("SoftDescriptor", authorizationDetails.getSoftDescriptor(), tabLevel, outStream);
        }
        outStream.println();

    }

    /**
     * Method to print Get Refund Details response to console
     * 
     * @param response
     *            instance of GetRefundDetailsResponse
     */
    public static void printRefundNotification(RefundNotification response, PrintWriter outStream) {

        int tabLevel = 1;
        outStream.println("GetRefundDetails Action Response");
        outStream.println("=============================================================================");
        outStream.println();

        outStream.println("    GetRefundDetailsResponse");
        outStream.println();
        RefundDetails refundDetails = response.getRefundDetails();
        printVariable("RefundDetails", null, tabLevel, outStream);
        tabLevel++;
        if (refundDetails.isSetAmazonRefundId()) {
            printVariable("AmazonRefundId", refundDetails.getAmazonRefundId(), tabLevel, outStream);
        }
        if (refundDetails.isSetRefundReferenceId()) {
            printVariable("RefundReferenceId", refundDetails.getRefundReferenceId(), tabLevel, outStream);
        }
        if (refundDetails.isSetRefundType()) {
            printVariable("RefundType", refundDetails.getRefundType(), tabLevel, outStream);
        }
        if (refundDetails.isSetRefundAmount()) {
            printVariable("RefundAmount", null, tabLevel, outStream);
            Price refundAmount = refundDetails.getRefundAmount();
            tabLevel++;
            if (refundAmount.isSetAmount()) {
                printVariable("Amount", refundAmount.getAmount(), tabLevel, outStream);
            }
            if (refundAmount.isSetCurrencyCode()) {
                printVariable("CurrencyCode", refundAmount.getCurrencyCode(), tabLevel, outStream);
            }
            tabLevel--;
        }
        if (refundDetails.isSetFeeRefunded()) {
            printVariable("FeeRefunded", null, tabLevel, outStream);
            Price feeRefunded = refundDetails.getFeeRefunded();
            tabLevel++;
            if (feeRefunded.isSetAmount()) {
                printVariable("Amount", feeRefunded.getAmount(), tabLevel, outStream);
            }
            if (feeRefunded.isSetCurrencyCode()) {
                printVariable("CurrencyCode", feeRefunded.getCurrencyCode(), tabLevel, outStream);
            }
            tabLevel--;
        }
        if (refundDetails.isSetCreationTimestamp()) {
            printVariable("CreationTimestamp", refundDetails.getCreationTimestamp().toString(), tabLevel, outStream);
        }
        if (refundDetails.isSetRefundStatus()) {
            printVariable("RefundStatus", null, tabLevel, outStream);
            Status refundStatus = refundDetails.getRefundStatus();
            tabLevel++;
            if (refundStatus.isSetState()) {
                printVariable("State", refundStatus.getState(), tabLevel, outStream);
            }
            if (refundStatus.isSetLastUpdateTimestamp()) {
                printVariable("LastUpdateTimestamp", refundStatus.getLastUpdateTimestamp().toString(), tabLevel,
                        outStream);
            }
            if (refundStatus.isSetReasonCode()) {
                printVariable("ReasonCode", refundStatus.getReasonCode(), tabLevel, outStream);
            }
            if (refundStatus.isSetReasonDescription()) {
                printVariable("ReasonDescription", refundStatus.getReasonDescription(), tabLevel, outStream);
            }
            tabLevel--;
        }
        if (refundDetails.isSetSoftDescriptor()) {
            printVariable("SoftDescriptor", refundDetails.getSoftDescriptor(), tabLevel, outStream);
        }
        if (refundDetails.isSetProviderCreditReversalSummaryList()){
            printVariable("ProviderCreditReversalSummaryList", null, tabLevel, outStream);
            ProviderCreditReversalSummaryList providerCreditReversalSummaryList = refundDetails.getProviderCreditReversalSummaryList();
            java.util.List<ProviderCreditReversalSummary> memberList = providerCreditReversalSummaryList.getProviderCreditReversalSummary();
            tabLevel++;
            for (ProviderCreditReversalSummary member : memberList) {
                Utilities.printVariable("ProviderCreditReversalSummary", null, tabLevel, outStream);
                tabLevel++;
                if (member.isSetProviderSellerId()) {
                    Utilities.printVariable("ProviderSellerId", member.getProviderSellerId(), tabLevel, outStream);
                }
                if (member.isSetProviderCreditReversalId()) {
                    Utilities.printVariable("ProviderCreditReversalId", member.getProviderCreditReversalId(), tabLevel, outStream);                                
                }
                tabLevel--;
            }
            tabLevel--;
        }
        outStream.println();
    }
}
