package com.setu.assignment.model;

import java.util.Date;

public class BillData {
    private String customerName;
    private String dueAmount;
    private Date dueDate;
    private String refID;

    public BillData() {
        super();
    }

    public BillData(String refID) {
        this.refID = refID;
    }

    public BillData(String customerName, String dueAmount, Date dueDate, String refID) {
        super();
        this.customerName = customerName;
        this.dueAmount = dueAmount;
        this.dueDate = dueDate;
        this.refID = refID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(String dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getRefID() {
        return refID;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }
}