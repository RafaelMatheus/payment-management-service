package com.wallet.paymentmanagementservice.core.dto;

import com.wallet.paymentmanagementservice.core.enumerated.TransactionType;

import java.math.BigDecimal;

public class TransactionRabbitMqDomain {
    private TransactionType transactionType;
    private String originAccount;
    private BigDecimal value;
    private String barcode;
    private String taxId;

    public TransactionRabbitMqDomain() {
    }

    public TransactionRabbitMqDomain(TransactionType transactionType, String originAccount, BigDecimal value, String barcode, String taxId) {
        this.transactionType = transactionType;
        this.originAccount = originAccount;
        this.value = value;
        this.barcode = barcode;
        this.taxId = taxId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
}
