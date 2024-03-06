package com.waynesouza.transactionprocessor.domain;

import com.waynesouza.transactionprocessor.enumeration.TypeAccountEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table
public class User {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    @Enumerated(STRING)
    @Column(nullable = false, length = 16)
    private TypeAccountEnum typeAccount;

    @Column(nullable = false, unique = true, length = 14)
    private String documentNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User() { }

    public User(String fullName, TypeAccountEnum typeAccount, String documentNumber, String email, String password) {
        this.fullName = fullName;
        this.typeAccount = typeAccount;
        this.documentNumber = documentNumber;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public TypeAccountEnum getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccountEnum typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
