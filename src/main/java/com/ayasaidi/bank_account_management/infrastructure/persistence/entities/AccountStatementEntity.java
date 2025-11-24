package com.ayasaidi.bank_account_management.infrastructure.persistence.entities;

import com.ayasaidi.bank_account_management.domain.model.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_statements")
public class AccountStatementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_releve;
    private LocalDateTime dategeneration;
    private  LocalDateTime periode_deb;
    private  LocalDateTime periode_fin;
    private  String lien_pdf;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public int getId_releve() {
        return id_releve;
    }

    public void setId_releve(int id_releve) {
        this.id_releve = id_releve;
    }

    public LocalDateTime getDategeneration() {
        return dategeneration;
    }

    public void setDategeneration(LocalDateTime dategeneration) {
        this.dategeneration = dategeneration;
    }

    public LocalDateTime getPeriode_deb() {
        return periode_deb;
    }

    public void setPeriode_deb(LocalDateTime periode_deb) {
        this.periode_deb = periode_deb;
    }

    public LocalDateTime getPeriode_fin() {
        return periode_fin;
    }

    public void setPeriode_fin(LocalDateTime periode_fin) {
        this.periode_fin = periode_fin;
    }

    public String getLien_pdf() {
        return lien_pdf;
    }

    public void setLien_pdf(String lien_pdf) {
        this.lien_pdf = lien_pdf;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
