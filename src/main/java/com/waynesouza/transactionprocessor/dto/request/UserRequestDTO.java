package com.waynesouza.transactionprocessor.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class UserRequestDTO implements Serializable {

    @NotNull
    private String fullName;

    @NotNull
    private String typeAccount;

    @NotNull
    private String documentNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    public UserRequestDTO() { }

    public UserRequestDTO(String fullName, String typeAccount, String documentNumber, String email, String password) {
        this.fullName = fullName;
        this.typeAccount = typeAccount;
        this.documentNumber = documentNumber;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
