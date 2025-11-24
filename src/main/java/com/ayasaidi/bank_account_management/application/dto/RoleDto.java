package com.ayasaidi.bank_account_management.application.dto;

import com.ayasaidi.bank_account_management.domain.model.User;

import java.util.List;

public class RoleDto {
    private int IdRole;
    private String nomRole;
    private String descripRole;


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


}
