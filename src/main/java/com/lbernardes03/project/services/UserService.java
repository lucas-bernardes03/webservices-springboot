package com.lbernardes03.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbernardes03.project.entities.User;
import com.lbernardes03.project.repositories.UserRepository;

@Service
public class UserService{
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.get();
    }
}