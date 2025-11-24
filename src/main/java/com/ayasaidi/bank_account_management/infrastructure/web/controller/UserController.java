package com.ayasaidi.bank_account_management.infrastructure.web.controller;

import com.ayasaidi.bank_account_management.application.dto.UserDto;
import com.ayasaidi.bank_account_management.application.usecases.BlockUserUseCase;
import com.ayasaidi.bank_account_management.application.usecases.CreateUserUseCase;
import com.ayasaidi.bank_account_management.domain.model.Role;
import com.ayasaidi.bank_account_management.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final BlockUserUseCase blockUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase,
                          BlockUserUseCase blockUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.blockUserUseCase = blockUserUseCase; // ➕ AJOUT
    }
    /*@PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        UserDto createdUser = createUserUseCase.create(user);
        return ResponseEntity.ok(createdUser);
   } */
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        // Convertir le DTO en User
        User user = new User();
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        user.setMotde_P(userDto.getMotde_P()); // Correction ici, assure-toi que getMotde_P() existe
        user.setDateInscrip(new Date());


        // Convertir le RoleDto en Role
        if (userDto.getRole() != null) {
            Role role = new Role(
                    userDto.getRole().getIdRole(),
                    userDto.getRole().getNomRole(),
                    userDto.getRole().getDescripRole(),
                    null // Liste d'utilisateurs à null
            );
            user.setRole(role);
        }

        // Récupérer la devise depuis le DTO
        String devise = userDto.getDevise();

        // Appel du use case
        UserDto createdUser = createUserUseCase.create(user, devise);

        return ResponseEntity.ok(createdUser);
    }
    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) return null;
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    @PutMapping("/{id}/block")
    public ResponseEntity<String> blockUser(@PathVariable Long id) {
        blockUserUseCase.blockUser(id);
        return ResponseEntity.ok("Utilisateur bloqué avec succès");
    }

}
