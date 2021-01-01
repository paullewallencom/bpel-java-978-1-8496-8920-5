package org.packt.cc;

import java.util.UUID;

public class TransactionResponse {
    private String responseText;
    private int    responseStatus;
    private UUID   token;

    public TransactionResponse() {     
    }

    public TransactionResponse(String responseText, int responseStatus,
                               String token) {
        this.responseText = responseText;
        this.responseStatus = responseStatus;
        if (token != null)
            this.token = UUID.fromString(token);
        else
            this.token = null;
    }


    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setToken(String token) {
        this.token = UUID.fromString(token);
    }

    public String getToken() {
        if (token != null)
            return token.toString();
        else
            return null;
    }
}
