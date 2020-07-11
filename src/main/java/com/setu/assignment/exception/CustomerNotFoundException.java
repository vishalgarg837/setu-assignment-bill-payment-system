package com.setu.assignment.exception;

public class CustomerNotFoundException extends BillPaymentException {
    public CustomerNotFoundException(int code) {
        super(code);
    }

    public CustomerNotFoundException(int code, String message) {
        super(code, message);
    }

    public CustomerNotFoundException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
