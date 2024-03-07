package com.waynesouza.transactionprocessor.listener;

import com.waynesouza.transactionprocessor.dto.error.ErrorDTO;
import com.waynesouza.transactionprocessor.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionListener {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException e) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGenericException(Exception e) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    private ResponseEntity<ErrorDTO> buildErrorResponse(HttpStatus status, String message) {
        return new ResponseEntity<>(new ErrorDTO(message, status.toString()), status);
    }

}
