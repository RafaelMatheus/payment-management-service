package com.wallet.paymentmanagementservice.adapter.consumer.dto;

import java.math.BigDecimal;

public class PaymentRabbitDtoRequest {
    private String originAccount;
    private BigDecimal amount;
    private String barcode;
    private String taxId;

    public PaymentRabbitDtoRequest(String originAccount, BigDecimal amount, String barcode, String taxId) {
        this.originAccount = originAccount;
        this.amount = amount;
        this.barcode = barcode;
        this.taxId = taxId;
    }

    public PaymentRabbitDtoRequest() {
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
