package com.sonnguyen.individual.nhs.service.iservice;

import com.sonnguyen.individual.nhs.constant.AccountStatus;
import com.sonnguyen.individual.nhs.constant.AccountType;
import com.sonnguyen.individual.nhs.model.Account;
import com.sonnguyen.individual.nhs.model.AccountHolder;
import com.sonnguyen.individual.nhs.model.SavingsInfo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IAccountService{
    Optional<Account> findBranchPrincipalAccount(int branchId);

    Optional<Account> findById(int id);
    Optional<Account> findByAccountNumber(String accountNumber);
    Collection<Account> findAllByCustomerId(Integer customerId);
    void createSavingsAccount(Integer customerId, SavingsInfo savingsInfor);
    List<Account> findByStatusAndTypeAndCustomerId(AccountStatus status,AccountType accountType, Integer customerId);
    Account findDefaultAccountByCustomerId(Integer customerId);
    List<Account> findByCustomerIdAndType(AccountType accountType,Integer customerId);
    Account createNewAccount(Account account, List<AccountHolder> accountHolder);
    void inactiveAccount(Integer accountId);
    void freezeAccount(Integer accountId);

    void openAccount(Integer accountId);
}
