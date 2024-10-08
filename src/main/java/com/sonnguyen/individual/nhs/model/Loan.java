package com.sonnguyen.individual.nhs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;

@Entity
@Table(name = "loan")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "customer_id")
    private int customerId;

    @Size(max = 20)
    @Column(name = "type", length = 20)
    private Integer type;

    @Column(name = "amount", precision = 2)
    private BigDecimal amount;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "term")
    private Integer term;

    @Column(name = "approval_date")
    private Date approvalDate;
    @Column(name = "create_at",insertable = false)
    private Date createAt;

    @Size(max = 20)
    @Column(name = "status", length = 20)
    private Integer status;

    @Size(max = 45)
    @Column(name = "repayment", length = 45)
    private String repayment;
    @Column(name = "branch_id")
    private int branchId;
    @Transient
    private Integer term_id;
    @Column(name = "disbursement_account_number")
    private String disbursementAccountNumber;
    @Transient
    private Customer customer;

    public Integer getTerm_id() {
        return term_id;
    }

    public void setTerm_id(Integer term_id) {
        this.term_id = term_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDisbursementAccountNumber() {
        return disbursementAccountNumber;
    }

    public void setDisbursementAccountNumber(String disbursementAccountNumber) {
        this.disbursementAccountNumber = disbursementAccountNumber;
    }

    public void setStatus(@Size(max = 20) Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public @Size(max = 20) Integer getType() {
        return type;
    }

    public void setType(@Size(max = 20) Integer type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public @Size(max = 20) Integer getStatus() {
        return status;
    }

    public String getRepayment() {
        return repayment;
    }

    public void setRepayment(String repayment) {
        this.repayment = repayment;
    }



    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", term=" + term +
                ", approvalDate=" + approvalDate +
                ", status='" + status + '\'' +
                ", repayment='" + repayment + '\'' +
                ", branchId=" + branchId +
                ", disbursementAccountNumber='" + disbursementAccountNumber + '\'' +
                '}';
    }
    public BigDecimal paymentInterest(){
        return amount.multiply(interestRate).divide(BigDecimal.valueOf(100),4, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(term),4, RoundingMode.HALF_UP);
    }
    public BigDecimal paymentPrincipal(){
        return amount.divide(BigDecimal.valueOf(term),4, RoundingMode.HALF_UP);
    }
    public BigDecimal monthlyPayment(){
        final BigDecimal principal=paymentPrincipal();
        final BigDecimal interest=paymentInterest();
        return principal.add(interest);
    }

}