package com.setu.assignment.exception;

public class NotFoundException extends BillPaymentException {
    public NotFoundException(int code) {
        super(code);
    }

    public NotFoundException(int code, String message) {
        super(code, message);
    }

    public NotFoundException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
