package com.inventory.task.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.task.entities.Ordering;


@Repository
public interface OrderRepo extends JpaRepository<Ordering, Integer> {

}
