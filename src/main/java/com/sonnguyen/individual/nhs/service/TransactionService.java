package com.sonnguyen.individual.nhs.service;

import com.sonnguyen.individual.nhs.dao.impl.TransactionDAOImpl;
import com.sonnguyen.individual.nhs.model.Transaction;
import com.sonnguyen.individual.nhs.service.iservice.ITransactionService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Model
public class TransactionService implements ITransactionService {
    @Inject
    private TransactionDAOImpl transactionDAO;
    public Transaction createTransaction(Connection connection,Transaction transaction) throws SQLException {
        Integer id=transactionDAO.executeInsert(connection,transaction);
        transaction.setId(id);
        return transaction;
    }
    @Override
    public List<Transaction> findHistoryByAccountId(Integer accountId){
        return transactionDAO.findAllByAccountId(accountId);
    }
}
