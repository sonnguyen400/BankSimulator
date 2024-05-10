package com.sonnguyen.individual.nhs.Service.IService;

import com.sonnguyen.individual.nhs.Exception.FailureTransaction;
import com.sonnguyen.individual.nhs.Model.Account;
import com.sonnguyen.individual.nhs.Model.Customer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IAccountService{
    List<Account> findSavingsAccountsByCustomerId(Integer customerId);
    Account findPrincipalAccountByCustomerId(Integer customerId);

    Optional<Account> findAccountByAccountNumber(String username);
    BigDecimal updateBalanceByAccountId(Connection connection,Integer accountId, BigDecimal value) throws SQLException;
}
