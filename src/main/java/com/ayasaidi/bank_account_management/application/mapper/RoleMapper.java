package com.ayasaidi.bank_account_management.application.mapper;

import com.ayasaidi.bank_account_management.domain.model.Role;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.RoleEntity;

public class RoleMapper {

    public static RoleEntity toEntity(Role model) {
        RoleEntity e = new RoleEntity();
        e.setIdRole(model.getIdRole());
        e.setNomRole(model.getNomRole());
        return e;
    }


    public static Role toModel(RoleEntity e) {
        if(e == null) return null;
        return new Role(
                e.getIdRole(),
                e.getNomRole(),
                e.getDescripRole()

                // si tu as d'autres champs
        );
    }

}

