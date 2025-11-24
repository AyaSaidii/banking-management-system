package com.ayasaidi.bank_account_management.infrastructure.persistence.adapters;

import com.ayasaidi.bank_account_management.application.mapper.TransactionMapper;
import com.ayasaidi.bank_account_management.domain.model.Transaction;
import com.ayasaidi.bank_account_management.domain.ports.TransactionRepositoryPort;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.TransactionDocument;
import com.ayasaidi.bank_account_management.infrastructure.persistence.repositories.TransactionMongoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionRepositoryAdapter implements TransactionRepositoryPort {

    private final TransactionMongoRepository mongoRepo;

    public TransactionRepositoryAdapter(TransactionMongoRepository mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public Transaction save(Transaction transaction) {
        // Mapper Transaction -> TransactionDocument (Mongo)
        TransactionDocument doc = TransactionMapper.toDocument(transaction);
        TransactionDocument saved = mongoRepo.save(doc);
        return TransactionMapper.toModel(saved);
    }

    @Override
    public List<Transaction> findAllByUserId(Long userId) {
        // Récupérer toutes les transactions où l'utilisateur est l'émetteur
        return mongoRepo.findByUserId(userId)
                .stream()
                .map(TransactionMapper::toModel)
                .collect(Collectors.toList());
    }


    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        List<TransactionDocument> docs = mongoRepo.findBySenderAccountIdOrReceiverAccountId(accountId, accountId);
        return TransactionMapper.toDomainList(docs);
    }

    @Override
    public List<Transaction> findBySenderId(Long senderId) {
        return null;
    }
    @Override
    public TransactionDocument save(TransactionDocument transactionDocument) {
        return mongoRepo.save(transactionDocument);
    }
    @Override
    public List<Transaction> findByReceiverId(Long receiverId) {
        return null;
    }
}
