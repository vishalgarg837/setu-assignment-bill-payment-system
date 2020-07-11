package com.setu.assignment.model;

import java.util.Date;

public class TransactionData {
    private String refID;
    private String transactionId;
    private String ackId;
    private Date date;

    public TransactionData(String refId, String transactionId, String ackId) {
        this.refID = refId;
        this.transactionId = transactionId;
        this.ackId = ackId;
    }

    public String getRefID() {
        return refID;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAckId() {
        return ackId;
    }

    public void setAckId(String ackId) {
        this.ackId = ackId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
