package com.ayasaidi.bank_account_management.application.dto;

import java.time.LocalDateTime;

public class UserDto {
    private Long idUser;
    private String nom;
    private String prenom;
    private String email;
    private LocalDateTime dateInscrip;
    private String roleNom;
    private String compteNumero;
    private String devise;
    private  String motde_P;
    private RoleDto role;
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public String getMotde_P() {
        return motde_P;
    }

    public void setMotde_P(String motde_P) {
        this.motde_P = motde_P;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateInscrip() {
        return dateInscrip;
    }

    public void setDateInscrip(LocalDateTime dateInscrip) {
        this.dateInscrip = dateInscrip;
    }

    public String getRoleNom() {
        return roleNom;
    }

    public void setRoleNom(String roleNom) {
        this.roleNom = roleNom;
    }

    public String getCompteNumero() {
        return compteNumero;
    }

    public void setCompteNumero(String compteNumero) {
        this.compteNumero = compteNumero;
    }
}
