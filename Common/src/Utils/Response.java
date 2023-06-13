package Utils;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class Response implements Serializable {

    private int responseCode;
    private String message;
    private Object payload;

    public Response (){

    }

    public Response(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
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
