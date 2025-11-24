package com.ayasaidi.bank_account_management.application.impl;

import com.ayasaidi.bank_account_management.application.usecases.CreateBankAccountUseCase;
import com.ayasaidi.bank_account_management.domain.model.BankAccount;
import com.ayasaidi.bank_account_management.domain.ports.BankAccountRepositoryPort;
import jakarta.transaction.Transactional;

public class CreateBankAccountUseCaseImpl implements CreateBankAccountUseCase {
    private final BankAccountRepositoryPort port;

    public CreateBankAccountUseCaseImpl(BankAccountRepositoryPort port) {
        this.port = port;
    }

    @Override
    @Transactional
    public BankAccount create(BankAccount bankAccount) {
        // validations: numéro unique, user exists, initial balance >= 0, etc.
        return port.save(bankAccount);
    }

}
