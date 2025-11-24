package com.ayasaidi.bank_account_management.application.impl;


import com.ayasaidi.bank_account_management.application.usecases.AccountStatementUseCase;
import com.ayasaidi.bank_account_management.domain.model.Transaction;
import com.ayasaidi.bank_account_management.domain.ports.TransactionRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountStatementUseCaseImpl implements AccountStatementUseCase {

    private final TransactionRepositoryPort transactionRepository;

    public AccountStatementUseCaseImpl(TransactionRepositoryPort transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAccountStatement(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}

