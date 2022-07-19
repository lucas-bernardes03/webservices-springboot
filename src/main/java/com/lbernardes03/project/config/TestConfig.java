package com.lbernardes03.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lbernardes03.project.entities.User;
import com.lbernardes03.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas", "lucas@gmail.com", "123456789", "12345");
        User u2 = new User(null, "Bob", "bob@gmail.com", "987654321", "54321");
        userRepository.saveAll(Arrays.asList(u1,u2));

    }


}
