package com.ayasaidi.bank_account_management.application.mapper;

import com.ayasaidi.bank_account_management.domain.model.BankAccount;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.BankAccountEntity;

public class BankAccountMapper {
    public static BankAccountEntity toEntity(BankAccount model) {
        BankAccountEntity e = new BankAccountEntity();
        e.setIdCompte(model.getIdCompte());
        e.setNumeroCompte(model.getNumeroCompte());
        e.setSolde(model.getSolde());
        e.setDevise(model.getDevise());
        e.setDateCreation(model.getDateCreation());
        e.setEstActif(model.isEstActif());

        if(model.getUser() != null) {
            e.setUser(UserMapper.toEntity(model.getUser()));
        }

        return e;
    }
    public static BankAccount toModel(BankAccountEntity e) {
        BankAccount model = new BankAccount();
        model.setIdCompte(e.getIdCompte());
        model.setNumeroCompte(e.getNumeroCompte());
        model.setSolde(e.getSolde());
        model.setDevise(e.getDevise());
        model.setDateCreation(e.getDateCreation());
        model.setEstActif(e.isEstActif());

        if(e.getUser() != null) {
            model.setUser(UserMapper.toModel(e.getUser()));
        }

        return model;
    }


}
