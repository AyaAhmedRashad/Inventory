package com.inventory.task.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.task.entities.Advice;

@Repository
public interface AdviceRepo extends JpaRepository<Advice, Integer> {

}
