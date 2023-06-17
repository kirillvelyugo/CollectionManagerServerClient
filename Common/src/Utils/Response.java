package Utils;

import java.io.Serializable;

public class Response implements Serializable {

    private ResponseCodes responseCode;
    private String message;
    private Object payload;

    public Response (){

    }

    public Response(ResponseCodes responseCode) {
        this.responseCode = responseCode;
    }

    public ResponseCodes getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCodes responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
