package com.setu.assignment.dao;

import com.setu.assignment.exception.AmountMismatchException;
import com.setu.assignment.exception.InvalidRefIdException;
import com.setu.assignment.model.*;
import com.setu.assignment.util.Constants;
import org.apache.commons.lang3.RandomStringUtils;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;

@RegisterMapper({BillPaymentMapper.class, TransactionMapper.class})
public interface BillPaymentDao {
    @SqlQuery("select ref_id, name, due_amount, due_date from bill where mobile_number = :mobileNumber")
    BillData fetchBill(@Bind("mobileNumber") String mobileNumber);

    @SqlQuery("select b.ref_id, t.transaction_id, t.ack_id from bill b inner join transactions t on b.ref_id = t.ref_id and b.ref_id = :refId")
    TransactionData checkIfTransactionIsDuplicate(@Bind("refId") String refId);

    @SqlQuery("select * from bill where ref_id = :refId")
    BillData checkIfBillIsValid(@Bind("refId") String refId);

    @SqlUpdate("update bill set due_amount = 0 where ref_id = :refId and due_amount = :amount")
    void updateBill(@Bind("refId") String refId, @Bind("amount") String amount);

    @SqlUpdate("insert into transactions(ref_id, transaction_id, ack_id, transaction_date) values (:refId, :id, :ackId, :date)")
    void updateTransaction(@Bind("refId") String refId, @Bind("id") String id, @Bind("ackId") String ackId, @Bind("date") Date date);

    @Transaction
    default String updatePayment(String refId, String id, String amountToBePaid, Date date) {
        TransactionData transaction = checkIfTransactionIsDuplicate(refId);

        if (transaction != null) {
            if (transaction.getTransactionId().equalsIgnoreCase(id)) {
                return transaction.getAckId();
            } else {
                throw new InvalidRefIdException(Constants.INVALID_REF_ID);
            }
        }

        BillData billData = checkIfBillIsValid(refId);
        if (billData == null) {
            throw new InvalidRefIdException(Constants.INVALID_REF_ID);
        } else if (billData.getDueAmount().compareTo(amountToBePaid) != 0) {
            throw new AmountMismatchException(Constants.AMOUNT_MISMATCH);
        }

        updateBill(refId, amountToBePaid);

        String ackId = RandomStringUtils.randomAlphanumeric(8);
        updateTransaction(refId, id, ackId, date);

        return ackId;
    }
}
