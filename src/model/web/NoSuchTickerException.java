package model.web;

public class NoSuchTickerException extends Exception {
    NoSuchTickerException() {
    }

    NoSuchTickerException(String s) {
        super(s);
    }
}
