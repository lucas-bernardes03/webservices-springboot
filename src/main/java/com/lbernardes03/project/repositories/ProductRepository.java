package com.lbernardes03.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbernardes03.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
