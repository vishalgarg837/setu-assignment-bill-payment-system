package com.setu.assignment.exception;

public class InvalidApiParameters extends BillPaymentException {
    public InvalidApiParameters(int code) {
        super(code);
    }

    public InvalidApiParameters(int code, String message) {
        super(code, message);
    }

    public InvalidApiParameters(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
