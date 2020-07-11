package com.setu.assignment.model;

public class PaymentAck {
    private String ackID;

    public PaymentAck(String ackId) {
        this.ackID = ackId;
    }

    public String getAckID() {
        return ackID;
    }
}
