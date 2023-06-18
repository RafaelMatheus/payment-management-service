package com.wallet.paymentmanagementservice.core.domain;

import com.wallet.paymentmanagementservice.core.enumerated.PaymentStatus;

import java.math.BigDecimal;

public class PaymentDomain {
    private String barcode;
    private BigDecimal amount;
    private String taxId;
    private String accountNumber;
    private PaymentStatus status;

    public PaymentDomain(String barcode, BigDecimal amount, String taxId, String accountNumber, PaymentStatus status) {
        this.barcode = barcode;
        this.amount = amount;
        this.taxId = taxId;
        this.accountNumber = accountNumber;
        this.status = status;
    }

    public PaymentDomain() {
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
