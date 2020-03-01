package com.inventory.task.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inventory.task.dto.OrderDTO;
import com.inventory.task.dto.OrderDisplayDTO;
import com.inventory.task.entities.Ordering;

@Component
public interface OrderService {
	/*this interface is designed to specify the services should be implemented to cover Ordering logic
	it contains the header of all CRUD operations for Ordering class
	  and it's implemented by OrderingServiceImpl class */
	
	
	public boolean addNewOrder(OrderDTO orderDto) throws Exception; //adding new order
	public boolean updateOrder(OrderDTO orderDto) throws Exception; //update existing order
	public boolean deleteOrder(int id) throws Exception; //delete existing order
	public OrderDisplayDTO findById(int id)  throws Exception; // find order using order Id
	public List<OrderDisplayDTO> findAll()  throws Exception;  // get all order 
	public Ordering findByOrderID(int id)  throws Exception;  // find order By id and return it as entity not DTO like others
}
