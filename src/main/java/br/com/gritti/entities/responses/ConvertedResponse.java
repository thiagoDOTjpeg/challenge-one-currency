package br.com.gritti.entities.responses;

public class ConvertedResponse {
  private double amount;
  private String base_currency;
  private String target_currency;
  private double conversion_rate;
  private double converted_amount;

  public ConvertedResponse() {
  }

  public ConvertedResponse(double amount, String base_currency, String target_currency, double conversion_rate, double converted_amount) {
    this.amount = amount;
    this.base_currency = base_currency;
    this.target_currency = target_currency;
    this.conversion_rate = conversion_rate;
    this.converted_amount = converted_amount;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getBase_currency() {
    return base_currency;
  }

  public void setBase_currency(String base_currency) {
    this.base_currency = base_currency;
  }

  public String getTarget_currency() {
    return target_currency;
  }

  public void setTarget_currency(String target_currency) {
    this.target_currency = target_currency;
  }

  public double getConversion_rate() {
    return conversion_rate;
  }

  public void setConversion_rate(double conversion_rate) {
    this.conversion_rate = conversion_rate;
  }

  public double getConverted_amount() {
    return converted_amount;
  }

  public void setConverted_amount(double converted_amount) {
    this.converted_amount = converted_amount;
  }
}
