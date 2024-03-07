package com.waynesouza.transactionprocessor.controller;

import com.waynesouza.transactionprocessor.dto.request.UserRequestDTO;
import com.waynesouza.transactionprocessor.dto.response.UserResponseDTO;
import com.waynesouza.transactionprocessor.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO userRequestDto) {
        try {
            return new ResponseEntity<>(userService.create(userRequestDto), CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
