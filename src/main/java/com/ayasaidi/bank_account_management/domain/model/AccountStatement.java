package com.ayasaidi.bank_account_management.domain.model;

import java.time.LocalDateTime;

public class AccountStatement {
    private int id_releve;
    private LocalDateTime dategeneration;
    private  LocalDateTime periode_deb;
    private  LocalDateTime periode_fin;
    private  String lien_pdf;
    private  User user;

    public AccountStatement() {}

    public AccountStatement(int id_releve, LocalDateTime dategeneration, LocalDateTime periode_deb,
                            LocalDateTime periode_fin, String lien_pdf, User user) {
        this.id_releve = id_releve;
        this.dategeneration = dategeneration;
        this.periode_deb = periode_deb;
        this.periode_fin = periode_fin;
        this.lien_pdf = lien_pdf;
        this.user = user;
    }


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
}
