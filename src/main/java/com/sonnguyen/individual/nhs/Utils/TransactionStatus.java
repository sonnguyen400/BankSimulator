package com.sonnguyen.individual.nhs.Utils;

public enum TransactionStatus {
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE"),
    PENDING("PENDING");
    private String value;
    TransactionStatus(String value) {
        this.value = value;
    }
}
