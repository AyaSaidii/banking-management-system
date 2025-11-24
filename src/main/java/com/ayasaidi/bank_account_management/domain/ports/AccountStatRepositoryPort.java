package com.ayasaidi.bank_account_management.domain.ports;

import com.ayasaidi.bank_account_management.domain.model.AccountStatement;

import java.util.List;

public interface AccountStatRepositoryPort {
    AccountStatement save(AccountStatement statement);

    List<AccountStatement> findByUserId(Long userId);
}
