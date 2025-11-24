package com.ayasaidi.bank_account_management.infrastructure.persistence.repositories;

import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity,Long> {

}
