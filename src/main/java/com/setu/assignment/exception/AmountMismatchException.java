package com.setu.assignment.exception;

public class AmountMismatchException extends BillPaymentException {
    public AmountMismatchException(String message) {
        super(message);
    }

    public AmountMismatchException(int code) {
        super(code);
    }

    public AmountMismatchException(int code, String message) {
        super(code, message);
    }

    public AmountMismatchException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
