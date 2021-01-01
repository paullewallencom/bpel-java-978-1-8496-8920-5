package org.packt.java.ws.exception;

public class BookAlreadyBorrowed extends Exception {
    public BookAlreadyBorrowed(Throwable throwable) {
        super(throwable);
    }

    public BookAlreadyBorrowed(String string, Throwable throwable) {
        super(string, throwable);
    }

    public BookAlreadyBorrowed(String string) {
        super(string);
    }

    public BookAlreadyBorrowed() {
        super();
    }
}
