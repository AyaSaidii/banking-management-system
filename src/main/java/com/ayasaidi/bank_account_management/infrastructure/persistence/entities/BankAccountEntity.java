package com.ayasaidi.bank_account_management.infrastructure.persistence.entities;

import com.ayasaidi.bank_account_management.domain.model.BankAccount;
import com.ayasaidi.bank_account_management.domain.model.Transaction;
import com.ayasaidi.bank_account_management.domain.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;
    private   String numeroCompte;
    private BigDecimal solde;
    private String devise;
    private LocalDateTime dateCreation;
    private boolean estActif;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;
    @OneToMany(mappedBy = "sender")
    private List<TransactionEntity> sentTransactions;
    @OneToMany(mappedBy = "receiver")
    private List<TransactionEntity> receivedTransactions;

    public Long getIdCompte() {
        return id;
    }

    public void setIdCompte(Long idCompte) {
        this.id = idCompte;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
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

    public boolean isEstActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<TransactionEntity> getSentTransactions() {
        return sentTransactions;
    }

    public void setSentTransactions(List<TransactionEntity> sentTransactions) {
        this.sentTransactions = sentTransactions;
    }

    public List<TransactionEntity> getReceivedTransactions() {
        return receivedTransactions;
    }

    public void setReceivedTransactions(List<TransactionEntity> receivedTransactions) {
        this.receivedTransactions = receivedTransactions;
    }
}
