package com.ayasaidi.bank_account_management.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class BankAccount {
    private   Long idCompte;
    private   String numeroCompte;
    private BigDecimal solde;
    private String devise;
    private LocalDateTime dateCreation;
    private boolean estActif;
    private  User user;
    private List<Transaction> sentTransactions;
    private BankAccount sender;
    private BankAccount receiver;
    private List<Transaction> receivedTransactions;
    public BankAccount(Long idCompte, String numeroCompte, BigDecimal solde, String devise,
                       LocalDateTime dateCreation, boolean estActif, User user) {
        this.idCompte = idCompte;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.devise = devise;
        this.dateCreation = dateCreation;
        this.estActif = estActif;
        this.user = user;
    }

    public BankAccount() {}
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public boolean isEstActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return estActif == that.estActif && Objects.equals(idCompte, that.idCompte) && Objects.equals(numeroCompte, that.numeroCompte) && Objects.equals(solde, that.solde) && Objects.equals(devise, that.devise) && Objects.equals(dateCreation, that.dateCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompte, numeroCompte, solde, devise, dateCreation, estActif);
    }
}

