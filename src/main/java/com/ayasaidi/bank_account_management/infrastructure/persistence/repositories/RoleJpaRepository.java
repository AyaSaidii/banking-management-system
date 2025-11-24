package com.ayasaidi.bank_account_management.infrastructure.persistence.repositories;

import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<RoleEntity,Integer> {
}
