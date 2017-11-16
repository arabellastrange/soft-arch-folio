package model.web;

public class NoSuchTickerException extends Exception {
    public NoSuchTickerException() {
    }

    NoSuchTickerException(String s) {
        super(s);
    }
}
