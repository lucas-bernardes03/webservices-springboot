package com.lbernardes03.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbernardes03.project.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{
    
}
