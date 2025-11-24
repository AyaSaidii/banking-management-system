package com.ayasaidi.bank_account_management.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private  String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "motde_P")
    private  String motde_P;
    @Column(name = "dateInscrip")
    private Date dateInscrip;

    @Column(name = "is_blocked", nullable = false)
    private boolean isBlocked = false;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AccountStatementEntity> accountStatements;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<BankAccountEntity> bankAccounts;

    public UserEntity(){

    }

    public UserEntity(Long id, String nom, String prenom, String email, String motde_P, Date dateInscrip, RoleEntity role) {
        id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motde_P = motde_P;
        this.dateInscrip = dateInscrip;
        this.role = role;
    }

    public UserEntity(Long Id, String nom, String prenom, String email, String motde_P,
                      Date dateInscrip, RoleEntity role, List<AccountStatementEntity> accountStatements, List<BankAccountEntity> bankAccounts) {
        id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motde_P = motde_P;
        this.dateInscrip = dateInscrip;
        this.role = role;
        this.accountStatements = accountStatements;
        this.bankAccounts = bankAccounts;
    }

    public UserEntity(Long id, String nom, String prenom, String email, String motde_P,
                      Date dateInscrip, boolean isBlocked, RoleEntity role, List<AccountStatementEntity> accountStatements, List<BankAccountEntity> bankAccounts) {
        id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motde_P = motde_P;
        this.dateInscrip = dateInscrip;
        this.isBlocked = isBlocked;
        this.role = role;
        this.accountStatements = accountStatements;
        this.bankAccounts = bankAccounts;
    }

    public UserEntity(Long Id, String nom, String prenom, String email, String motde_P, Date dateInscrip, boolean isBlocked, RoleEntity role) {
        id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motde_P = motde_P;
        this.dateInscrip = dateInscrip;
        this.isBlocked = isBlocked;
        this.role = role;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Long getIdUser() {
        return id;
    }

    public void setIdUser(Long idUser) {
        id = idUser;
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

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public List<AccountStatementEntity> getAccountStatements() {
        return accountStatements;
    }

    public void setAccountStatements(List<AccountStatementEntity> accountStatements) {
        this.accountStatements = accountStatements;
    }

    public List<BankAccountEntity> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccountEntity> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
