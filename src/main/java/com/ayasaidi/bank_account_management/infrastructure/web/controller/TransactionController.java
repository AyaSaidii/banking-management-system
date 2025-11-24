package com.ayasaidi.bank_account_management.infrastructure.web.controller;

import com.ayasaidi.bank_account_management.application.dto.TransferDto;
import com.ayasaidi.bank_account_management.application.usecases.TransactionUseCase;
import com.ayasaidi.bank_account_management.domain.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transac")
public class TransactionController {

    private final TransactionUseCase transactionUseCase;

    public TransactionController(TransactionUseCase transactionUseCase) {
        this.transactionUseCase = transactionUseCase;
    }

    /**
     * Endpoint pour effectuer une transaction
     * @param userId ID de l'utilisateur initiateur
     * @param senderId ID du compte émetteur
     * @param receiverId ID du compte destinataire
     * @param amount Montant à transférer
     * @return La transaction effectuée
     */
    @PostMapping("/transf")
    public ResponseEntity<Transaction> transfer(@RequestParam Long userId,
                                                @RequestParam Long senderId,
                                                @RequestParam Long receiverId,
                                                @RequestParam BigDecimal amount) {
        try {
            Transaction transaction = transactionUseCase.execute(userId, senderId, receiverId, amount);
            return ResponseEntity.ok(transaction);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(@RequestBody TransferDto request) {
        try {
            Transaction transaction = transactionUseCase.execute(
                    request.getUserId(),
                    request.getSenderId(),
                    request.getReceiverId(),
                    request.getAmount()
            );
            return ResponseEntity.ok(transaction);
        } catch (RuntimeException e)
        {
            e.printStackTrace(); // <-- ajoute ça pour voir l'erreur exacte

            return ResponseEntity.badRequest().body(null);
        }
    }




}
