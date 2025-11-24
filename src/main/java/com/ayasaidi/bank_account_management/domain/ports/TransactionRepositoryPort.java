package com.ayasaidi.bank_account_management.domain.ports;

import com.ayasaidi.bank_account_management.domain.model.Transaction;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.TransactionDocument;

import java.util.List;

public interface TransactionRepositoryPort {
    Transaction save(Transaction transaction);
    List<Transaction> findAllByUserId(Long userId);

    List<Transaction> findBySenderId(Long senderId);

    List<Transaction> findByReceiverId(Long receiverId);
    TransactionDocument save(TransactionDocument transactionDocument);
}
