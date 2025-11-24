package com.ayasaidi.bank_account_management.config;

import com.ayasaidi.bank_account_management.application.impl.BlockUserUseCaseImpl;
import com.ayasaidi.bank_account_management.application.impl.CreateBankAccountUseCaseImpl;
import com.ayasaidi.bank_account_management.application.impl.CreateUserUseCaseImpl;
import com.ayasaidi.bank_account_management.application.impl.TransactionUseCaseImpl;
import com.ayasaidi.bank_account_management.application.usecases.BlockUserUseCase;
import com.ayasaidi.bank_account_management.application.usecases.CreateBankAccountUseCase;
import com.ayasaidi.bank_account_management.application.usecases.CreateUserUseCase;
import com.ayasaidi.bank_account_management.application.usecases.TransactionUseCase;
import com.ayasaidi.bank_account_management.domain.ports.BankAccountRepositoryPort;
import com.ayasaidi.bank_account_management.domain.ports.TransactionRepositoryPort;
import com.ayasaidi.bank_account_management.domain.ports.UserRepositoryPort;
import com.ayasaidi.bank_account_management.infrastructure.persistence.adapters.BankAccountRepositoryAdapter;
import com.ayasaidi.bank_account_management.infrastructure.persistence.adapters.TransactionRepositoryAdapter;
import com.ayasaidi.bank_account_management.infrastructure.persistence.adapters.UserRepositoryAdapter;
import com.ayasaidi.bank_account_management.infrastructure.persistence.repositories.BankAccountRepository;
import com.ayasaidi.bank_account_management.infrastructure.persistence.repositories.TransactionMongoRepository;
import com.ayasaidi.bank_account_management.infrastructure.persistence.repositories.UserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserRepositoryPort userRepositoryPort(UserJpaRepository repo) {
        return new UserRepositoryAdapter(repo);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepositoryPort port,BankAccountRepositoryPort bankAccountRepositoryPort) {
        return new CreateUserUseCaseImpl(port,bankAccountRepositoryPort);
    }
    @Bean
    public BankAccountRepositoryPort bankAccountRepositoryPort(BankAccountRepository repo){
        return new BankAccountRepositoryAdapter(repo);
    }

    @Bean
    public CreateBankAccountUseCase createBankAccountUseCase(BankAccountRepositoryPort port) {
        return new CreateBankAccountUseCaseImpl(port);
    }



    @Bean
    public BlockUserUseCase blockUserUseCase(UserRepositoryPort userRepositoryPort) {
        return new BlockUserUseCaseImpl(userRepositoryPort);
    }

    // Adapter pour MongoDB
    @Bean
    public TransactionRepositoryPort transactionRepositoryPort(TransactionMongoRepository repo) {
        return new TransactionRepositoryAdapter(repo);
    }

    // Use case pour les transactions
    @Bean
    public TransactionUseCase transactionUseCase(UserRepositoryPort userRepositoryPort,
                                                 BankAccountRepositoryPort bankAccountRepositoryPort,
                                                 TransactionRepositoryPort transactionRepositoryPort) {
        return new TransactionUseCaseImpl(userRepositoryPort, bankAccountRepositoryPort, transactionRepositoryPort);
    }

}

