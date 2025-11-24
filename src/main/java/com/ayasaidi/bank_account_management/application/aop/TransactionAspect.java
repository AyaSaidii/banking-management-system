package com.ayasaidi.bank_account_management.application.aop;


import com.ayasaidi.bank_account_management.domain.model.Transaction;
import com.ayasaidi.bank_account_management.domain.ports.TransactionRepositoryPort;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    private final TransactionRepositoryPort transactionRepository;

    public TransactionAspect(TransactionRepositoryPort transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @AfterReturning(pointcut = "@annotation(com.ayasaidi.bank_account_management.application.aop.TrackTransaction)",
            returning = "transaction")
    public void captureTransaction(JoinPoint joinPoint, Transaction transaction) {
        if(transaction != null) {
            transactionRepository.save(transaction); // Sauvegarde dans MongoDB
        }
    }
}

