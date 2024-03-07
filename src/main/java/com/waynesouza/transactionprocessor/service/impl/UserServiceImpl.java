package com.waynesouza.transactionprocessor.service.impl;

import com.waynesouza.transactionprocessor.domain.User;
import com.waynesouza.transactionprocessor.dto.request.UserRequestDTO;
import com.waynesouza.transactionprocessor.dto.response.UserResponseDTO;
import com.waynesouza.transactionprocessor.exception.NotFoundException;
import com.waynesouza.transactionprocessor.repository.UserRepository;
import com.waynesouza.transactionprocessor.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public UserResponseDTO create(UserRequestDTO userRequestDto) {
        logger.info("Creating user");
        // TODO create password encoder
        User user = userRepository.save(modelMapper.map(userRequestDto, User.class));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO findById(UUID id) {
        logger.info("Finding user by id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        logger.info("Finding user by id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        logger.info("Deleting user");
        userRepository.delete(user);
    }

}
