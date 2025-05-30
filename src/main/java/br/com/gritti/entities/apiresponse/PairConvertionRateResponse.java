package br.com.gritti.entities.apiresponse;

public class PairConvertionRateResponse extends BaseResponse{
  private String base_code;
  private String target_code;
  private double conversion_rate;

  public PairConvertionRateResponse() {
  }

  public PairConvertionRateResponse(String base_code, String target_code, double conversion_rate) {
    this.base_code = base_code;
    this.target_code = target_code;
    this.conversion_rate = conversion_rate;
  }

  public String getBase_code() {
    return base_code;
  }

  public void setBase_code(String base_code) {
    this.base_code = base_code;
  }

  public String getTarget_code() {
    return target_code;
  }

  public void setTarget_code(String target_code) {
    this.target_code = target_code;
  }

  public double getConversion_rate() {
    return conversion_rate;
  }

  public void setConversion_rate(double conversion_rate) {
    this.conversion_rate = conversion_rate;
  }
}
