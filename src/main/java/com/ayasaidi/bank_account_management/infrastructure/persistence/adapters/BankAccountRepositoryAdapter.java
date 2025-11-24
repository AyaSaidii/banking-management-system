package com.ayasaidi.bank_account_management.infrastructure.persistence.adapters;

import com.ayasaidi.bank_account_management.application.mapper.BankAccountMapper;
import com.ayasaidi.bank_account_management.domain.model.BankAccount;
import com.ayasaidi.bank_account_management.domain.ports.BankAccountRepositoryPort;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.BankAccountEntity;
import com.ayasaidi.bank_account_management.infrastructure.persistence.repositories.BankAccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BankAccountRepositoryAdapter implements BankAccountRepositoryPort {
    private final BankAccountRepository jpa;

    public BankAccountRepositoryAdapter(BankAccountRepository jpa) {
        this.jpa = jpa;
    }
    @Override
    public BankAccount save(BankAccount bankAccount) {
        BankAccountEntity e = BankAccountMapper.toEntity(bankAccount);
        BankAccountEntity saved = jpa.save(e);
        return BankAccountMapper.toModel(saved);
    }



    @Override
    public Optional<BankAccount> findById(Long id) {
        return jpa.findById(id)
                .map(BankAccountMapper::toModel);  // map vers le modèle domaine
    }

    @Override
    public List<BankAccount> findAllByUserId(Long userId) {
        return null;
    }

  /*   @Override
   public List<BankAccount> findAllByUserId(Long userId) {
        return jpa.findByUser_Id(userId)   // méthode JPA pour récupérer tous les comptes d’un user
                .stream()
                .map(BankAccountMapper::toModel)
                .collect(Collectors.toList());
    }



/*
    @Override
    public Optional<BankAccount> findById(Long id) {
        return jpa.findById(id).map(BankAccountMapper::toModel);
    }

    @Override
    public Optional<BankAccount> findByNumeroCompte(String numero) {
        return jpa.findByNumeroCompte(numero).map(BankAccountMapper::toModel);
    }

    @Override
    public List<BankAccount> findByUserId(Long userId) {
        return jpa.findByUser_Id(userId).stream().map(BankAccountMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<BankAccount> findAll() {
        return null;
    }*/
}
