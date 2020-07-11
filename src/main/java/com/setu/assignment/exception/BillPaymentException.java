package com.setu.assignment.exception;

import com.setu.assignment.model.ErrorResponse;
import com.setu.assignment.model.StatusCodes;
import com.setu.assignment.util.Constants;

public class BillPaymentException extends RuntimeException {
    public BillPaymentException(String message) {
        super(message);
    }

    private int code;

    public BillPaymentException(int code) {
        this(code, new ErrorResponse(StatusCodes.ERROR, Constants.UNHANDLED_ERROR).toString(), null);
    }

    public BillPaymentException(int code, String message) {
        this(code, message, null);
    }

    public BillPaymentException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
