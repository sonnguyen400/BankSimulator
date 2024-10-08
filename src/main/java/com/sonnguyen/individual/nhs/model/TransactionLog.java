package com.sonnguyen.individual.nhs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "transaction_log")
public class TransactionLog {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "transaction_id")
    private int transactionId;

    @Size(max = 255)
    @Column(name = "detail")
    private String detail;

    @Column(name = "log_date")
    private Date logDate;



}