package com.ayasaidi.bank_account_management.application.mapper;

import com.ayasaidi.bank_account_management.domain.model.User;
import com.ayasaidi.bank_account_management.domain.model.Role;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.UserEntity;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.RoleEntity;

import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.RoleEntity;
import com.ayasaidi.bank_account_management.domain.model.Role;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setIdUser(user.getIdUser());
        entity.setNom(user.getNom());
        entity.setPrenom(user.getPrenom());
        entity.setEmail(user.getEmail());
        entity.setMotde_P(user.getMotde_P());
        entity.setDateInscrip(user.getDateInscrip());
        entity.setBlocked(user.isBlocked());


        if (user.getRole() != null) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setIdRole(user.getRole().getIdRole());
            roleEntity.setNomRole(user.getRole().getNomRole());

            entity.setRole(roleEntity);
        }

        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        return new User(
                entity.getIdUser(),
                entity.getNom(),
                entity.getPrenom(),
                entity.getEmail(),
                entity.isBlocked(),
                entity.getDateInscrip(),

                RoleMapper.toModel(entity.getRole())


        );
    }

   /*public static UserEntity toEntity(User user) {
       if (user == null) return null;
       UserEntity e = new UserEntity();
       e.setIdUser(user.getIdUser());
       e.setNom(user.getNom());
       e.setPrenom(user.getPrenom());
       e.setEmail(user.getEmail());
       e.setMotde_P(user.getMotde_P());
       e.setDateInscrip(user.getDateInscrip());
       if (user.getRole() != null) {
           RoleEntity r = new RoleEntity();
           r.setIdRole(user.getRole().getIdRole());
           r.setNomRole(user.getRole().getNomRole());
           e.setRole(r);
       }
       return e;
   }*/
   public static Date toDate(LocalDateTime dateTime) {
       if (dateTime == null) return null;
       return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
   }
    public static User toModel(UserEntity e) {
        User model = new User();
        model.setIdUser(e.getIdUser());
        model.setNom(e.getNom());
        model.setPrenom(e.getPrenom());
        model.setEmail(e.getEmail());
        model.setMotde_P(e.getMotde_P());
        model.setDateInscrip(e.getDateInscrip());
        model.setBlocked(e.isBlocked());


        if(e.getRole() != null) {
            model.setRole(RoleMapper.toModel(e.getRole()));
        }

        return model;
    }
}
