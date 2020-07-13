package com.setu.assignment.model;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillPaymentMapper implements ResultSetMapper<BillData> {
    public BillData map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new BillData(
                resultSet.getString("name"),
                resultSet.getString("due_amount"),
                resultSet.getDate("due_date"),
                resultSet.getString("ref_id"));
    }
}
