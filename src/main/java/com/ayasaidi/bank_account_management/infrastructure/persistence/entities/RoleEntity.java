package com.ayasaidi.bank_account_management.infrastructure.persistence.entities;

import com.ayasaidi.bank_account_management.domain.model.User;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRole;
    private String nomRole;
    private String descripRole;
    @OneToMany(mappedBy = "role")
    private List<UserEntity> users;

    public int getIdRole() {
        return IdRole;
    }

    public void setIdRole(int idRole) {
        IdRole = idRole;
    }

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    public String getDescripRole() {
        return descripRole;
    }

    public void setDescripRole(String descripRole) {
        this.descripRole = descripRole;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
