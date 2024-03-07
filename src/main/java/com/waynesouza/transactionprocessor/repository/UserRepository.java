package com.waynesouza.transactionprocessor.repository;

import com.waynesouza.transactionprocessor.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> { }
