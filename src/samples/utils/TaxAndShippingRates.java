package samples.utils;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.Address;
import com.amazonservices.mws.offamazonpayments.model.BillingAddress;
import com.amazonservices.mws.offamazonpayments.model.Destination;

/***************************************************************************
 * Helper class for setting state specific tax rates
 * and type of shipping and its rate
 ***************************************************************************/
public class TaxAndShippingRates {
  private String stateCode;
  private String countryCode;
  private double taxRate;
  private double standardShipping;
  private double twoDayShipping;
  private double nextDayShipping;

  public void setRates(String countryCode,
      String stateCode, double taxRate, double standardShipping,
      double twoDayShipping, double nextDayShipping) {
    this.countryCode = countryCode;
    this.stateCode = stateCode;
    this.taxRate = taxRate;
    this.standardShipping = standardShipping;
    this.twoDayShipping = twoDayShipping;
    this.nextDayShipping = nextDayShipping;
  }

  public void setRatesForCountryAndState(String countryCode, String stateCode) {
    if (countryCode.equals("US")) {
      if (stateCode.equals("WA"))
        this.setRates(countryCode,"WA",8.6,10.00,25.00,50.00);
      else if (stateCode.equals("NY"))
        this.setRates(countryCode, "NY",7.3,15.00,25.00,75.00);
      else if (stateCode.equals("CT"))
        this.setRates(countryCode, "CT",4.3,5.00,15.00,55.00);
      else
        this.setRates(countryCode, "UNKNOWN",0.0,5.00,10.00,20.00);
    }
    else if (countryCode.equals("CA")) {
      if (stateCode.equals("BC"))
        this.setRates(countryCode, "BC",7.6,11.00,35.00,55.00);
      else if (stateCode.equals("QC"))
        this.setRates(countryCode, "QC",8.3,10.00,20.00,70.00);
      else if (stateCode.equals("ON"))
        this.setRates(countryCode, "ON",5.3,15.00,25.00,75.00);
      else
        this.setRates(countryCode, "UNKNOWN",0.0,5.00,10.00,20.00);
    }
    else
      this.setRates(countryCode, "UNKNOWN",0.0,5.00,10.00,20.00);
  }
  
  public TaxAndShippingRates(Destination destination)
      throws OffAmazonPaymentsServiceException {
	  
    if (destination != null) {
      Address address = destination.getPhysicalDestination();
      if (address != null) {
          setRatesForCountryAndState(
              address.getCountryCode(), address.getStateOrRegion());
        } else {
          throw new OffAmazonPaymentsServiceException(
              "No Physical Address is set");
        }
    } else {
      throw new OffAmazonPaymentsServiceException(
          "No Destination is set");
    }
  }
  
  public String getCountryCode() {
    return this.countryCode;
  }

  public String getStateCode() {
    return this.stateCode;
  }

  public double getTaxRate() {
    return this.taxRate;
  }

  public double getShippingRate(String shippingType) {
    if (shippingType.equals("standardShipping")) {
      return this.standardShipping;
    } else if (shippingType.equals("twoDayShipping")) {
      return this.twoDayShipping;
    } else if (shippingType.equals("nextDayShipping")) {
      return this.nextDayShipping;
    } else {
      return -1.00;
    }
  }

  /**
   * calculates tax
   *
   * @param subTotal
   * @return orderTotalWithTax
   * @throws OffAmazonPaymentsServiceException
   */
  public double calculateTax(double subTotal)
      throws OffAmazonPaymentsServiceException {
    double taxRate = getTaxRate();
    double orderTotalWithTax = subTotal * (1 + (taxRate / 100));
    orderTotalWithTax = Double.valueOf(new java.text.
        DecimalFormat("#.##").format(orderTotalWithTax));
    return orderTotalWithTax;
  }

  /**
   * calculates shipping charge
   *
   * @param subTotal
   * @param shippingType
   * @return orderTotalWithShipping
   * @throws OffAmazonPaymentsServiceException
   */
  public double calculateShipping(double subTotal, String shippingType)
      throws OffAmazonPaymentsServiceException {
    double shippingRate = getShippingRate(shippingType);
    if (shippingRate < 0) {
      throw new OffAmazonPaymentsServiceException(shippingType+
          ": Is unknown Shipping Type. " +
          "Only Following types are allowed:" +
          "\n1.standardShipping\n2.twoDayShipping" +
          "\n3.nextDayShipping\n");
    } else {
      double orderTotalWithShipping = subTotal + shippingRate;
      orderTotalWithShipping = Double.valueOf(new java.text.
          DecimalFormat("#.##").format(orderTotalWithShipping));
      return orderTotalWithShipping;
    }
  }

  /**
   * calculates tax and adds Shipping charge based on type of shipping
   *
   * @param subTotal
   * @param shippingOption
   * @return Order Total with Tax and Shipping Charge
   * @throws OffAmazonPaymentsServiceException
   */
  public double getTotalAmountWithTaxAndShipping(
      double subTotal, int shippingOption)
          throws OffAmazonPaymentsServiceException{
    double withTax = calculateTax(subTotal);
    /*
     * This sample uses 3 options for shipping type:
     * 1. Standard Shipping
     * 2. Two Day Shipping
     * 3. Next Day Shipping
     */
    String shippingType = null;
    switch (shippingOption) {
    case 1:
      shippingType = "standardShipping";
      break;
    case 2:
      shippingType = "twoDayShipping";
      break;
    case 3:
      shippingType = "nextDayShipping";
      break;
    }
    double orderTotal = calculateShipping(withTax, shippingType);
    return orderTotal;
  }

}
