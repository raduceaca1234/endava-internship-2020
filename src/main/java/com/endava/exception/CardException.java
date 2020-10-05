package com.endava.exception;

public class CardException extends Exception {
    public CardException(String message) {
        super(message);
    }

    public CardException(String message, Throwable cause) {
        super(message, cause);
    }
}
