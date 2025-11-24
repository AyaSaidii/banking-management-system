package com.ayasaidi.bank_account_management.domain.ports;

import com.ayasaidi.bank_account_management.domain.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepositoryPort {

    Role save(Role role);

    Optional<Role> findById(Long id);

    List<Role> findAll();

}
