package com.ayasaidi.bank_account_management.application.usecases;

import com.ayasaidi.bank_account_management.domain.model.BankAccount;

public interface CreateBankAccountUseCase {
    BankAccount create(BankAccount bankAccount);
}
