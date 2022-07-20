package com.lbernardes03.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbernardes03.project.entities.Order;
import com.lbernardes03.project.repositories.OrderRepository;

@Service
public class OrderService{
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> order = repository.findById(id);
        return order.get();
    }
}
