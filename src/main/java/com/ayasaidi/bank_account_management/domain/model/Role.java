package com.ayasaidi.bank_account_management.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Role {
    private int IdRole;
    private String nomRole;
    private String descripRole;
    private List<User> users;
    public Role() {}
    public Role(int idRole, String nomRole) {
        this.IdRole = idRole;
        this.nomRole = nomRole;


    }

    public Role(int idRole, String nomRole, String descripRole) {
        IdRole = idRole;
        this.nomRole = nomRole;
        this.descripRole = descripRole;
    }

    public Role(int idRole, String nomRole, String descripRole, List<User> users) {
        IdRole = idRole;
        this.nomRole = nomRole;
        this.descripRole = descripRole;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return IdRole == role.IdRole && Objects.equals(nomRole, role.nomRole) && Objects.equals(descripRole, role.descripRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdRole, nomRole, descripRole);
    }
}
