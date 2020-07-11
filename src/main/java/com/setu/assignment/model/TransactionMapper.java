package com.setu.assignment.model;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapper implements ResultSetMapper<TransactionData> {
    @Override
    public TransactionData map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new TransactionData(
                resultSet.getString("ref_id"),
                resultSet.getString("transaction_id"),
                resultSet.getString("ack_id"));
    }
}
