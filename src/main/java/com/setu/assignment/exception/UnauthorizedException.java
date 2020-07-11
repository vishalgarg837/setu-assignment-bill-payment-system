package com.setu.assignment.exception;

public class UnauthorizedException extends BillPaymentException {
    public UnauthorizedException(int code) {
        super(code);
    }

    public UnauthorizedException(int code, String message) {
        super(code, message);
    }

    public UnauthorizedException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
