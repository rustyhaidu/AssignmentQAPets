package tests.APITests.models;

public class ApiResponse {

    private int respondeCode;
    private String jsonFormatContent;

    public int getRespondeCode() {
        return respondeCode;
    }

    public ApiResponse(int respondeCode, String jsonFormatContent) {
        this.respondeCode = respondeCode;
        this.jsonFormatContent = jsonFormatContent;
    }

    public void setRespondeCode(int respondeCode) {
        this.respondeCode = respondeCode;
    }

    public String getJsonContent() {
        return jsonFormatContent;
    }

    public void setJsonFormatContent(String jsonFormatContent) {
        this.jsonFormatContent = jsonFormatContent;
    }
}
