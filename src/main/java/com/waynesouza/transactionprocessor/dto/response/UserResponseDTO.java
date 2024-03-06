package com.waynesouza.transactionprocessor.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.UUID;

public class UserResponseDTO implements Serializable {

    @NotNull
    private UUID id;

    @NotNull
    private String fullName;

    @NotNull
    private String typeAccount;

    @NotNull
    private String documentNumber;

    @NotNull
    @Email
    private String email;

    public UserResponseDTO() { }

    public UserResponseDTO(UUID id, String fullName, String typeAccount, String documentNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.typeAccount = typeAccount;
        this.documentNumber = documentNumber;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
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

}
