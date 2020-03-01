package com.inventory.task.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.task.entities.Packaging;


@Repository
public interface PackagingRepo extends JpaRepository<Packaging, Integer>{

}
