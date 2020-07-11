package com.setu.assignment.service;

import com.setu.assignment.dao.BillPaymentDao;
import com.setu.assignment.model.BillData;
import com.setu.assignment.model.PaymentUpdateRequest;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

public abstract class BillPaymentService {
    @CreateSqlObject
    abstract BillPaymentDao billPaymentDao();

    public BillData fetchBill(String mobileNumber) {
        return billPaymentDao().fetchBill(mobileNumber);
    }

    public String updatePayment(PaymentUpdateRequest request) {
        return billPaymentDao().updatePayment(
                request.getRefID(),
                request.getTransaction().getId(),
                request.getTransaction().getAmountPaid(),
                request.getTransaction().getDate()
        );
    }
}
