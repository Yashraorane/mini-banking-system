package com.example.bankingapp.config;

import com.example.bankingapp.model.User;
import com.example.bankingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User sampleUser = new User();
            sampleUser.setUsername("sample_user");
            sampleUser.setEmail("sample_user@example.com");
            userRepository.save(sampleUser);
            System.out.println("Sample user created in the database.");
        } else {
            System.out.println("Users collection already contains data.");
        }
    }
}
