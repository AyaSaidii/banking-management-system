package com.ayasaidi.bank_account_management.application.usecases;

import com.ayasaidi.bank_account_management.domain.model.Transaction;

import java.math.BigDecimal;

public interface TransactionUseCase {
    Transaction effectuerTransaction(Long userId, Long senderAccountId, Long receiverAccountId,
                                     BigDecimal montant);

    Transaction execute(Long userId, Long senderAccountId, Long receiverAccountId, BigDecimal amount);

}
