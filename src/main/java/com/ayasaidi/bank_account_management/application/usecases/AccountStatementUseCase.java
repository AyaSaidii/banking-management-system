package com.ayasaidi.bank_account_management.application.usecases;


import com.ayasaidi.bank_account_management.domain.model.Transaction;

import java.util.List;

public interface AccountStatementUseCase {
    List<Transaction> getAccountStatement(Long accountId);
}
