package com.sonnguyen.individual.nhs.Repository;

import com.sonnguyen.individual.nhs.Model.Account;
import com.sonnguyen.individual.nhs.Model.AccountHolder;
import com.sonnguyen.individual.nhs.Model.Customer;
import com.sonnguyen.individual.nhs.Model.Login;
import com.sonnguyen.individual.nhs.Repository.IRepository.*;
import com.sonnguyen.individual.nhs.Utils.AccountType;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class LoginCustomerRepository extends Repository<Customer,Integer> implements ILoginCustomerRepository {
    @Inject
    private ILoginRepository loginRepository;
    @Inject
    private ICustomerRepository customerRepository;
    @Inject
    private IAccountRepository repository;
    @Inject
    private IAccountHolderRepository accountHolderRepository;

    @Override
    public Customer save(Login login, Customer customer, Account account) {
        return  createTransactional((connection -> {
            Integer customerId=customerRepository.executeInsert(connection,customer);
            login.setCustomerId(customerId);
            Integer loginId=loginRepository.executeInsert(connection,login);
            account.setBranchID(1);
            Integer accountId=repository.executeInsert(connection,account);
            customer.setId(customerId);
            login.setId(loginId);
            account.setId(accountId);
            customer.setAccounts(List.of(account));
            customer.setLogin(customer.getLogin());
            AccountHolder accountHolder = new AccountHolder();
            accountHolder.setCustomerID(customerId);
            accountHolder.setAccountID(accountId);
            accountHolder.setAccountType(AccountType.PRINCIPAL.value);
            accountHolderRepository.executeInsert(connection,accountHolder);
            return customer;
        }));
    }
}
