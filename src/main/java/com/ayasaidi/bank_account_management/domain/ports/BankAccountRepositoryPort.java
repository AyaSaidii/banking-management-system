package com.ayasaidi.bank_account_management.domain.ports;

import com.ayasaidi.bank_account_management.domain.model.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepositoryPort {
    BankAccount save(BankAccount account);
    Optional<BankAccount> findById(Long id);  // ✅ méthode manquante
    List<BankAccount> findAllByUserId(Long userId);
}
