package com.ayasaidi.bank_account_management.application.impl;

import com.ayasaidi.bank_account_management.application.dto.RoleDto;
import com.ayasaidi.bank_account_management.application.dto.UserDto;
import com.ayasaidi.bank_account_management.application.mapper.UserMapper;
import com.ayasaidi.bank_account_management.application.usecases.CreateUserUseCase;
import com.ayasaidi.bank_account_management.domain.model.BankAccount;
import com.ayasaidi.bank_account_management.domain.model.User;
import com.ayasaidi.bank_account_management.domain.ports.BankAccountRepositoryPort;
import com.ayasaidi.bank_account_management.domain.ports.UserRepositoryPort;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.UserEntity;
import com.ayasaidi.bank_account_management.infrastructure.persistence.repositories.UserJpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final BankAccountRepositoryPort bankAccountRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort,
                                 BankAccountRepositoryPort bankAccountRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.bankAccountRepositoryPort = bankAccountRepositoryPort;
    }

  /*  @Override
    public User create(User user) {
        return userRepositoryPort.save(user);
    }*/
 /* public User create(User user) {
      // 1. Sauvegarder l'utilisateur
      User savedUser = userRepositoryPort.save(user);

      // 2. Créer un compte bancaire par défaut pour cet utilisateur
      BankAccount account = new BankAccount();
      account.setUser(savedUser);
      account.setSolde(BigDecimal.ZERO); // solde initial
      account.setDevise("MAD"); // ou autre devise par défaut
      account.setEstActif(true);
      account.setDateCreation(LocalDateTime.now());
      account.setNumeroCompte(generateAccountNumber());

      // 3. Sauvegarder le compte bancaire
      bankAccountRepositoryPort.save(account);

      // 4️⃣ Associer le compte à l'utilisateur pour la réponse
      savedUser.setBankAccounts(List.of(account));


      return savedUser;
  }*/
    private String generateAccountNumber() {
        // Exemple simple : "AC" + timestamp + 4 chiffres aléatoires
        int random = (int) (Math.random() * 9000) + 1000;
        return "AC" + System.currentTimeMillis() + random;
    }
    @Override
    public UserDto create(User user, String devise) {
        User savedUser = userRepositoryPort.save(user);
        BankAccount account = new BankAccount();
        account.setUser(savedUser);
        account.setSolde(BigDecimal.ZERO);
        account.setDevise(devise);
        account.setEstActif(true);
        account.setDateCreation(LocalDateTime.now());
        account.setNumeroCompte(generateAccountNumber());
        bankAccountRepositoryPort.save(account);

        UserDto dto = new UserDto();
        dto.setIdUser(savedUser.getIdUser());
        dto.setNom(savedUser.getNom());
        dto.setPrenom(savedUser.getPrenom());
        dto.setEmail(savedUser.getEmail());
        dto.setDateInscrip(toLocalDateTime(savedUser.getDateInscrip()));
        dto.setRoleNom(savedUser.getRole().getNomRole());
        dto.setCompteNumero(account.getNumeroCompte());


        dto.setDevise(devise);
        if (savedUser.getRole() != null) {
            RoleDto roleDto = new RoleDto();
            roleDto.setIdRole(savedUser.getRole().getIdRole());
            roleDto.setNomRole(savedUser.getRole().getNomRole());
            roleDto.setDescripRole(savedUser.getRole().getDescripRole());
            dto.setRole(roleDto);
        }



        return dto;
    }



    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) return null;
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

}
