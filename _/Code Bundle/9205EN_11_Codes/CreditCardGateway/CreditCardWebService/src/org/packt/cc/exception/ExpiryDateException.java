package org.packt.cc.exception;

public class ExpiryDateException extends Exception {
    private String info;
    
    public ExpiryDateException(Throwable throwable) {
        super(throwable);
    }

    public ExpiryDateException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public ExpiryDateException(String string) {
        super(string);
    }

    public ExpiryDateException() {
        super();
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
