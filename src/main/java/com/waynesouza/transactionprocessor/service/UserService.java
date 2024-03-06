package com.waynesouza.transactionprocessor.service;

import com.waynesouza.transactionprocessor.dto.request.UserRequestDTO;
import com.waynesouza.transactionprocessor.dto.response.UserResponseDTO;

import java.util.UUID;

public interface UserService {

    UserResponseDTO create(UserRequestDTO userRequestDto);

    UserResponseDTO findById(UUID id);

    void deleteById(UUID id);

}
