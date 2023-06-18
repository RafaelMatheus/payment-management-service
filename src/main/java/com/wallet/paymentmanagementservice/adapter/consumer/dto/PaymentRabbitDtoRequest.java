package com.wallet.paymentmanagementservice.adapter.consumer.dto;

import java.math.BigDecimal;

public class PaymentRabbitDtoRequest {
    private String barcode;
    private String accountNumber;
    private String taxId;
    private BigDecimal amount;

    public PaymentRabbitDtoRequest(String barcode, String accountNumber, String taxId, BigDecimal amount) {
        this.barcode = barcode;
        this.accountNumber = accountNumber;
        this.taxId = taxId;
        this.amount = amount;
    }

    public PaymentRabbitDtoRequest() {
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
