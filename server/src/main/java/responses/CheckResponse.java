package responses;

public class CheckResponse {
  private int code;
  private String result;

  public CheckResponse(int code, String result) {
    setCode(code);
    setResult(result);
  }

  public void setCode(int code) {
    this.code = code;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public int getCode() {
    return code;
  }

  public String getResult() {
    return result;
  }
}
