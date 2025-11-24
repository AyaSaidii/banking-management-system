package com.ayasaidi.bank_account_management.infrastructure.persistence.repositories;

import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.TransactionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionMongoRepository extends MongoRepository<TransactionDocument, String> {
    List<TransactionDocument> findByUserId(Long userId);
}