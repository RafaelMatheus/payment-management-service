package com.wallet.paymentmanagementservice.adapter.entity;

import com.wallet.paymentmanagementservice.core.enumerated.PaymentStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document("payment")
public class PaymentEntity {
    @Id
    private String id;
    private String barcode;
    private BigDecimal amount;
    private String taxId;
    private String accountNumber;
    private PaymentStatus status;
    private LocalDateTime creationDate;

    public PaymentEntity(String id, String barcode, BigDecimal amount, String taxId, String accountNumber, PaymentStatus status, LocalDateTime creationDate) {
        this.id = id;
        this.barcode = barcode;
        this.amount = amount;
        this.taxId = taxId;
        this.accountNumber = accountNumber;
        this.status = status;
        this.creationDate = creationDate;
    }

    public PaymentEntity() {
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
