package com.sonnguyen.individual.nhs.dao.Idao;

import com.sonnguyen.individual.nhs.Model.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ITransactionDAO extends AbstractDAO<Transaction,Integer> {
     Integer createTransaction(Connection connection,Transaction transaction)  throws SQLException;
     List<Transaction> findAllByAccountId(Integer accountId);
     List<Transaction> findAllByRefNumber(String refNumber);
     int updateStatus(Connection connection,Integer transactionId, int status) throws SQLException;
}
