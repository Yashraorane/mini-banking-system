package com.example.bankingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.bankingapp.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
