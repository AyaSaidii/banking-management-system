package com.ayasaidi.bank_account_management.application.impl;

import com.ayasaidi.bank_account_management.application.mapper.TransactionMapper;
import com.ayasaidi.bank_account_management.application.usecases.TransactionUseCase;
import com.ayasaidi.bank_account_management.domain.model.BankAccount;
import com.ayasaidi.bank_account_management.domain.model.Transaction;
import com.ayasaidi.bank_account_management.domain.model.User;
import com.ayasaidi.bank_account_management.domain.ports.BankAccountRepositoryPort;
import com.ayasaidi.bank_account_management.domain.ports.TransactionRepositoryPort;
import com.ayasaidi.bank_account_management.domain.ports.UserRepositoryPort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TransactionUseCaseImpl implements TransactionUseCase {

    private final UserRepositoryPort userRepository;
    private final BankAccountRepositoryPort accountRepository;
    private final TransactionRepositoryPort transactionRepository;

    public TransactionUseCaseImpl(UserRepositoryPort userRepository,
                                  BankAccountRepositoryPort accountRepository,
                                  TransactionRepositoryPort transactionRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction effectuerTransaction(Long userId, Long senderId, Long receiverId, BigDecimal montant) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        if (user.isBlocked()) {
            throw new RuntimeException("Utilisateur bloqué : impossible d'effectuer une transaction");
        }

        BankAccount sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Compte émetteur non trouvé"));
        BankAccount receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Compte destinataire non trouvé"));

        // Transaction locale ou Forex
        boolean forex = !sender.getDevise().equals(receiver.getDevise());

        // Vérifier solde suffisant
        if (sender.getSolde().compareTo(montant) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        // Déduire du compte émetteur
        sender.setSolde(sender.getSolde().subtract(montant));
        accountRepository.save(sender);

        // Ajouter au compte destinataire
        BigDecimal montantRecu = forex ? convertirDevise(sender.getDevise(), receiver.getDevise(), montant) : montant;
        receiver.setSolde(receiver.getSolde().add(montantRecu));
        accountRepository.save(receiver);

        // Créer transaction et enregistrer dans MongoDB
        Transaction transaction = new Transaction();
        transaction.setFromCurrency(sender.getDevise());
        transaction.setToCurrency(receiver.getDevise());
        transaction.setAmount(montantRecu);
        transactionRepository.save(transaction);

        return transaction;
    }
    @Override
    public Transaction execute(Long userId, Long senderAccountId, Long receiverAccountId, BigDecimal amount) {

        // 1️⃣ Vérifier utilisateur
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        if (user.isBlocked()) {
            throw new RuntimeException("Utilisateur bloqué : transaction impossible");
        }

        // 2️⃣ Vérifier comptes
        BankAccount sender = accountRepository.findById(senderAccountId)
                .orElseThrow(() -> new RuntimeException("Compte émetteur non trouvé"));
        BankAccount receiver = accountRepository.findById(receiverAccountId)
                .orElseThrow(() -> new RuntimeException("Compte destinataire non trouvé"));

        if (!sender.isEstActif() || !receiver.isEstActif()) {
            throw new RuntimeException("Compte inactif");
        }

        // 3️⃣ Vérifier solde
        if (sender.getSolde().compareTo(amount) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        // 4️⃣ Calcul du montant à créditer sur le compte destinataire
        BigDecimal montantFinal = amount;
        if (!sender.getDevise().equals(receiver.getDevise())) {
            // Convertir selon la devise du destinataire
            montantFinal = convertirDevise(sender.getDevise(), receiver.getDevise(), amount);
        }

        // 5️⃣ Débiter le compte émetteur (dans sa devise)
        sender.setSolde(sender.getSolde().subtract(amount));
        accountRepository.save(sender);

        // 6️⃣ Créditer le compte destinataire (dans sa devise)
        receiver.setSolde(receiver.getSolde().add(montantFinal));
        accountRepository.save(receiver);

        // 7️⃣ Créer la transaction
        Transaction transaction = new Transaction();
        transaction.setUserId(user.getIdUser());
        transaction.setSenderAccountId(sender.getIdCompte());
        transaction.setReceiverAccountId(receiver.getIdCompte());
        transaction.setFromCurrency(sender.getDevise());
        transaction.setToCurrency(receiver.getDevise());
        transaction.setAmount(montantFinal); // montant reçu par le destinataire
        transaction.setDate(LocalDateTime.now());

        // 8️⃣ Enregistrer la transaction dans MongoDB
        transactionRepository.save(TransactionMapper.toDocument(transaction));

        return transaction;
    }


    // Méthode de conversion Forex
    private BigDecimal convertirDevise(String from, String to, BigDecimal montant) {
        if(from.equals(to)) {
            return montant; // même devise, pas de conversion
        }

        // Taux fixes par rapport au MAD
        Map<String, BigDecimal> tauxParMAD = new HashMap<>();
        tauxParMAD.put("MAD", BigDecimal.ONE);      // référence
        tauxParMAD.put("EUR", BigDecimal.valueOf(10)); // 1 EUR = 10 MAD
        tauxParMAD.put("USD", BigDecimal.valueOf(11)); // 1 USD = 11 MAD
        tauxParMAD.put("GBP", BigDecimal.valueOf(12)); // 1 GBP = 12 MAD
        tauxParMAD.put("JPY", BigDecimal.valueOf(0.075)); // 1 JPY = 0.075 MAD

        // Conversion via MAD comme devise pivot
        BigDecimal montantEnMAD;
        if(from.equals("MAD")) {
            montantEnMAD = montant;
        } else {
            // from → MAD
            montantEnMAD = montant.multiply(tauxParMAD.get(from));
        }

        if(to.equals("MAD")) {
            return montantEnMAD.setScale(2, RoundingMode.HALF_UP);
        } else {
            // MAD → to
            return montantEnMAD.divide(tauxParMAD.get(to), 2, RoundingMode.HALF_UP);
        }
    }

    // Exemple de taux fixe pour test
    private BigDecimal getExchangeRate(String from, String to) {
        return BigDecimal.valueOf(10); // 1 EUR = 10 MAD (exemple)
    }




}

