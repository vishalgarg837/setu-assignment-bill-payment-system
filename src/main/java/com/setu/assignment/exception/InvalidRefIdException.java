package com.setu.assignment.exception;

public class InvalidRefIdException extends BillPaymentException {
    public InvalidRefIdException(String message) {
        super(message);
    }

    public InvalidRefIdException(int code) {
        super(code);
    }

    public InvalidRefIdException(int code, String message) {
        super(code, message);
    }

    public InvalidRefIdException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
