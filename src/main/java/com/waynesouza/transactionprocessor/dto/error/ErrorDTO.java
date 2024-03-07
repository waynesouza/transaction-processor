package com.waynesouza.transactionprocessor.dto.error;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

    private String message;
    private String code;

    public ErrorDTO() { }

    public ErrorDTO(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
