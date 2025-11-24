package com.ayasaidi.bank_account_management.infrastructure.persistence.repositories;

import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.AccountStatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatRepository extends JpaRepository<AccountStatementEntity,Integer> {
}
