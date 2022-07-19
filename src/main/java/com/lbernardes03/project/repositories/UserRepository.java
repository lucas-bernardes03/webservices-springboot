package com.lbernardes03.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbernardes03.project.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
