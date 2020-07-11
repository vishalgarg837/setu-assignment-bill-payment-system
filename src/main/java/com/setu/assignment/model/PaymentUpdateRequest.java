package com.setu.assignment.model;

import java.util.Date;

public class PaymentUpdateRequest {
    private String refID;
    private Transaction transaction;

    public String getRefID() {
        return refID;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public static class Transaction {
        private Integer amountPaid;
        private Date date;
        private String id;

        public Integer getAmountPaid() {
            return amountPaid;
        }

        public void setAmountPaid(Integer amountPaid) {
            this.amountPaid = amountPaid;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
