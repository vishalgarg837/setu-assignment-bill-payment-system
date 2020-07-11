package com.setu.assignment.model;

public class ErrorResponse {
    private StatusCodes status;
    private String errorCode;

    public ErrorResponse(StatusCodes status, String errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "{\n\t"
                + doubleQuote("status")
                + ":"
                + doubleQuote(status.name())
                + ",\n\t"
                + doubleQuote("errorCode")
                + ":" + doubleQuote(errorCode)
                + '}';
    }

    private static String doubleQuote(String message) {
        return "\"" + message + "\"";
    }
}
