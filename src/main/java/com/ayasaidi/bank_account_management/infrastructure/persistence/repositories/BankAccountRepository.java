package com.ayasaidi.bank_account_management.infrastructure.persistence.repositories;

import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository  extends JpaRepository<BankAccountEntity,Long> {
    Optional<BankAccountEntity> findByNumeroCompte(String numeroCompte);
  /*  List<BankAccountEntity> findByUser_Id(Long userId);*/
 // List<BankAccountEntity> findByUser_Id(Long userId);

}
