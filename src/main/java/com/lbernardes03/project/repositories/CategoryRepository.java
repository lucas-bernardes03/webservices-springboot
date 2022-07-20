package com.lbernardes03.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbernardes03.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
