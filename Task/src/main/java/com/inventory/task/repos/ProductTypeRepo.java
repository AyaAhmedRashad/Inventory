package com.inventory.task.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.task.entities.ProductType;
@Repository
public interface ProductTypeRepo extends JpaRepository<ProductType, Integer>{

}
