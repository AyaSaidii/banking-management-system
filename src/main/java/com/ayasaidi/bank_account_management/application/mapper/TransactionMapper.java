package com.ayasaidi.bank_account_management.application.mapper;

import com.ayasaidi.bank_account_management.domain.model.Transaction;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.TransactionDocument;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {

    public static TransactionDocument toDocument(Transaction transaction) {
        TransactionDocument doc = new TransactionDocument();
        doc.setUserId(transaction.getUserId());
        doc.setSenderAccountId(transaction.getSenderAccountId());
        doc.setReceiverAccountId(transaction.getReceiverAccountId());
        doc.setAmount(transaction.getAmount());
        doc.setFromCurrency(transaction.getFromCurrency());
        doc.setToCurrency(transaction.getToCurrency());
        doc.setDate(transaction.getDate());
        return doc;
    }
    public static Transaction toDomain(TransactionDocument doc) {
        Transaction transaction = new Transaction();
        //transaction.setId(doc.getId());
        transaction.setUserId(doc.getUserId());
        transaction.setSenderAccountId(doc.getSenderAccountId());
        transaction.setReceiverAccountId(doc.getReceiverAccountId());
        transaction.setFromCurrency(doc.getFromCurrency());
        transaction.setToCurrency(doc.getToCurrency());
        transaction.setAmount(doc.getAmount());
        transaction.setDate(doc.getDate());
        return transaction;
    }
    public static List<Transaction> toDomainList(List<TransactionDocument> docs) {
        return docs.stream().map(TransactionMapper::toDomain).collect(Collectors.toList());
    }

    public static Transaction toModel(TransactionDocument doc) {
        Transaction transaction = new Transaction();
        transaction.setId(doc.getId() != null ? Long.parseLong(doc.getId()) : null);
        transaction.setFromCurrency(doc.getFromCurrency());
        transaction.setToCurrency(doc.getToCurrency());
        transaction.setAmount(doc.getAmount());
        transaction.setUserId(doc.getUserId());
       transaction.setSenderAccountId(doc.getSenderAccountId());
        transaction.setReceiverAccountId(doc.getReceiverAccountId());
        transaction.setDate(doc.getDate());
        return transaction;
    }
}
