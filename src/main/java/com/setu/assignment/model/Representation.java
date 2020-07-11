package com.setu.assignment.model;

public class Representation<T> {
    private StatusCodes status;
    private T data;

    public StatusCodes getStatus() {
        return status;
    }

    public Representation() {
        // Jackson deserialization
    }

    public Representation(StatusCodes status, T data) {
        this.status = status;
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
