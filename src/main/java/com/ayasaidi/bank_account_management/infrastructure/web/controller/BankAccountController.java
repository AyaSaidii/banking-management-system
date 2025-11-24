package com.ayasaidi.bank_account_management.infrastructure.web.controller;

import com.ayasaidi.bank_account_management.application.usecases.CreateBankAccountUseCase;
import com.ayasaidi.bank_account_management.domain.model.BankAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {

    private final CreateBankAccountUseCase createUseCase;

    public BankAccountController(CreateBankAccountUseCase createUseCase) {
        this.createUseCase = createUseCase;
    }

    @PostMapping
    public ResponseEntity<BankAccount> create(@RequestBody BankAccount bankAccount) {
        BankAccount created = createUseCase.create(bankAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}

