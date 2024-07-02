package com.sonnguyen.individual.nhs.Service;

import com.sonnguyen.individual.nhs.Constant.LoanStatus;
import com.sonnguyen.individual.nhs.Constant.TransactionType;
import com.sonnguyen.individual.nhs.Model.Account;
import com.sonnguyen.individual.nhs.Model.Loan;
import com.sonnguyen.individual.nhs.Model.Transaction;
import com.sonnguyen.individual.nhs.Model.Transfer;
import com.sonnguyen.individual.nhs.Service.IService.IAccountService;
import com.sonnguyen.individual.nhs.Service.IService.ILoanService;
import com.sonnguyen.individual.nhs.Service.IService.ITransferService;
import com.sonnguyen.individual.nhs.dao.GeneralDAO;
import com.sonnguyen.individual.nhs.dao.Idao.ILoanDAO;
import javassist.NotFoundException;
import org.jboss.logging.Logger;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.Collection;

@Model
public class LoanService implements ILoanService {
    @Inject
    private ILoanDAO loanRepository;
    @Inject
    private ITransferService transferService;
    @Inject
    private IAccountService accountService;
    Logger logger=Logger.getLogger(this.getClass());
    @Override
    public Collection<Loan> findAllByCustomerId(Integer customerId) {
        return loanRepository.findAllByCustomerId(customerId);
    }

    @Override
    public Loan save(Loan loan) {
        loan.setStatus(LoanStatus.PENDING.value);
        return loanRepository.save(loan);
    }

    @Override
    public Collection<Loan> findAllByStatus(LoanStatus loanStatus) {
        return loanRepository.findAllByStatus(loanStatus.value);
    }
    public Collection<Loan> findAll(){
        try {
            return loanRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Loan updateStatusById(Integer id, LoanStatus status) throws SQLException, NotFoundException {
        loanRepository.updateStatusById(id, status.value);
        return loanRepository.findById(id).orElseThrow(()->new NotFoundException("Could not find"));
    }

    @Override
    public Loan approveLoan(Integer id) throws SQLException, NotFoundException {
        Loan loan=loanRepository.findById(id).orElseThrow(()->new NotFoundException("Could not find"));
        Account account=accountService.findAccountByAccountNumber(loan.getDisbursementAccountNumber()).orElseThrow(()->new NotFoundException("Could not find"));
        return GeneralDAO.createTransactional((connection -> {
            Transaction transaction=new Transaction();
            transaction.setAmount(loan.getAmount());
            transaction.setAccountId(1);
            transaction.setDescription("Disburse for loan");
            transaction.setTransactionType(TransactionType.DISBURSEMENT.value);
            Transfer transfer = new Transfer();
            transfer.setMessage("Disburse for loan");
            transfer.setAccountId(account.getId());
            transfer.setTransaction(transaction);
            loanRepository.updateStatusById(connection,id,LoanStatus.APPROVED.value);
            transferService.startTransfer(connection,transfer);
            loan.setStatus(LoanStatus.APPROVED.value);
            return loan;
        }));
    }
}
