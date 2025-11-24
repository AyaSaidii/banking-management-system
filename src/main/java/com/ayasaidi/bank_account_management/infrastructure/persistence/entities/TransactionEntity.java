package com.ayasaidi.bank_account_management.infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "transacti")
public class TransactionEntity {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private BankAccountEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private BankAccountEntity receiver;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BankAccountEntity getSender() {
        return sender;
    }

    public void setSender(BankAccountEntity sender) {
        this.sender = sender;
    }

    public BankAccountEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(BankAccountEntity receiver) {
        this.receiver = receiver;
    }
}
