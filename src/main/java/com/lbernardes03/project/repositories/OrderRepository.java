package com.lbernardes03.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbernardes03.project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
