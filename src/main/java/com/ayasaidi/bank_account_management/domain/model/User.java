package com.ayasaidi.bank_account_management.domain.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class User {
    private Long IdUser;
    private String nom;
    private  String prenom;
    private String email;
    private  String motde_P;
    private boolean isBlocked;

    private Date dateInscrip;
    private Role role;
    private List<AccountStatement> accountStatements;
    private List<BankAccount>bankAccounts;

    public User() {
    }

    public User(Long idUser, String nom, String prenom, String email, String motde_P,
                Date dateInscrip, Role role, List<AccountStatement> accountStatementList,
                List<BankAccount> bankAccounts) {
        IdUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motde_P = motde_P;
        this.dateInscrip = dateInscrip;
        this.role = role;
        this.accountStatements = accountStatementList;
        this.bankAccounts = bankAccounts;
    }

    public User(Long idUser, String nom, String prenom, String email, String motde_P, Date dateInscrip,
                Role role) {
        IdUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motde_P = motde_P;
        this.dateInscrip = dateInscrip;
        this.role = role;
    }

    public User(Long idUser, String nom, String prenom, String email,
                boolean isBlocked, Date dateInscrip, Role role) {
        IdUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;

        this.isBlocked = isBlocked;
        this.dateInscrip = dateInscrip;
        this.role = role;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<AccountStatement> getAccountStatements() {
        return accountStatements;
    }

    public void setAccountStatements(List<AccountStatement> accountStatements) {
        this.accountStatements = accountStatements;
    }

    public Long getIdUser() {
        return IdUser;
    }

    public void setIdUser(Long idUser) {
        IdUser = idUser;
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

    public String getMotde_P() {
        return motde_P;
    }

    public void setMotde_P(String motde_P) {
        this.motde_P = motde_P;
    }

    public Date getDateInscrip() {
        return dateInscrip;
    }

    public void setDateInscrip(Date dateInscrip) {
        this.dateInscrip = dateInscrip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(IdUser, user.IdUser) && Objects.equals(nom, user.nom) && Objects.equals(prenom, user.prenom) && Objects.equals(email, user.email) && Objects.equals(motde_P, user.motde_P) && Objects.equals(dateInscrip, user.dateInscrip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdUser, nom, prenom, email, motde_P, dateInscrip);
    }

    @Override
    public String toString() {
        return "User{" +
                "IdUser=" + IdUser +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", motde_P='" + motde_P + '\'' +
                ", dateInscrip=" + dateInscrip +
                ", role=" + role +
                ", accountStatementList=" + accountStatements +
                '}';
    }
}
