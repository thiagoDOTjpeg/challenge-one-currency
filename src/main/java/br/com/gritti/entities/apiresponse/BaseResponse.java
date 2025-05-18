package br.com.gritti.entities.apiresponse;

public class BaseResponse {
  private String documentation;
  private String result;
  private String terms_of_use;
  private int time_last_update_unix;
  private String time_last_update_utc;
  private int time_next_update_unix;
  private String time_next_update_utc;

  public BaseResponse() {
  }

  public BaseResponse(String documentation, String result, String terms_of_use, int time_last_update_unix, String time_last_update_utc, int time_next_update_unix, String time_next_update_utc) {
    this.documentation = documentation;
    this.result = result;
    this.terms_of_use = terms_of_use;
    this.time_last_update_unix = time_last_update_unix;
    this.time_last_update_utc = time_last_update_utc;
    this.time_next_update_unix = time_next_update_unix;
    this.time_next_update_utc = time_next_update_utc;
  }

  public String getDocumentation() {
    return documentation;
  }

  public void setDocumentation(String documentation) {
    this.documentation = documentation;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getTerms_of_use() {
    return terms_of_use;
  }

  public void setTerms_of_use(String terms_of_use) {
    this.terms_of_use = terms_of_use;
  }

  public int getTime_last_update_unix() {
    return time_last_update_unix;
  }

  public void setTime_last_update_unix(int time_last_update_unix) {
    this.time_last_update_unix = time_last_update_unix;
  }

  public String getTime_last_update_utc() {
    return time_last_update_utc;
  }

  public void setTime_last_update_utc(String time_last_update_utc) {
    this.time_last_update_utc = time_last_update_utc;
  }

  public int getTime_next_update_unix() {
    return time_next_update_unix;
  }

  public void setTime_next_update_unix(int time_next_update_unix) {
    this.time_next_update_unix = time_next_update_unix;
  }

  public String getTime_next_update_utc() {
    return time_next_update_utc;
  }

  public void setTime_next_update_utc(String time_next_update_utc) {
    this.time_next_update_utc = time_next_update_utc;
  }
}
