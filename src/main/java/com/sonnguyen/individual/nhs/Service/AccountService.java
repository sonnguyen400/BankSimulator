package com.sonnguyen.individual.nhs.Service;

import com.sonnguyen.individual.nhs.Model.Account;
import com.sonnguyen.individual.nhs.dao.Idao.IAccountDAO;
import com.sonnguyen.individual.nhs.Service.IService.IAccountService;
import com.sonnguyen.individual.nhs.Constant.AccountType;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Model
public class AccountService implements IAccountService {
    @Inject
    private IAccountDAO accountRepository;
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }


    @Override
    public Account findPrincipalAccountByCustomerId(Integer customerId) {
        return accountRepository.findByCustomerIdAndType(customerId, AccountType.PRINCIPAL).get(0);
    }
    @Override
    public List<Account> findSavingsAccountsByCustomerId(Integer customerId) {
        return accountRepository.findByCustomerIdAndType(customerId, AccountType.SAVINGS);
    }

    @Override
    public Optional<Account> findAccountByAccountNumber(String username) {
        return accountRepository.findAccountByAccountNumber(username);
    }

    @Override
    public BigDecimal updateBalanceByAccountId(Connection connection,Integer accountId, BigDecimal value) throws SQLException {
        return accountRepository.updateBalanceByAccountId(connection,accountId, value);
    }

    @Override
    public Collection<Account> findAllByCustomerId(Integer customerId) {
        return accountRepository.findAllByCustomerId(customerId);
    }

}
