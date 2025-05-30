package br.com.gritti.entities.apiresponse;

import java.util.Map;

public class AllConvertionRateResponse extends BaseResponse{

  private String base_code;
  private Map<String, Double> conversion_rates;

  public AllConvertionRateResponse() {
  }

  public AllConvertionRateResponse(String base_code, Map<String, Double> conversion_rates) {
    this.base_code = base_code;
    this.conversion_rates = conversion_rates;
  }

  public String getBase_code() {
    return base_code;
  }

  public void setBase_code(String base_code) {
    this.base_code = base_code;
  }

  public Map<String, Double> getConversion_rates() {
    return conversion_rates;
  }

  public void setConversion_rates(Map<String, Double> conversion_rates) {
    this.conversion_rates = conversion_rates;
  }
}
