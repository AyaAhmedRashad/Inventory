package com.inventory.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventory.task.dto.OrderDTO;
import com.inventory.task.services.OrderService;

@RestController
@RequestMapping("Ordering")
public class OrderingController {
	//Ordering controller contains All the API related to ordering Service (CRUD)
	@Autowired
	private OrderService orderService;
	
	//This is the end point for adding new order
	@PostMapping("addNewOrder")
	public ResponseEntity<?> addPackage(@RequestBody OrderDTO orderDto)throws Exception {
		return ResponseEntity.ok(this.orderService.addNewOrder(orderDto));
	}
	
	//This is the end point for finding one order by Id
	@GetMapping("findById/{id}")
	public ResponseEntity<?> findById(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.orderService.findById(id));

	}
	//This is the end point for updating order
	@PutMapping("updateOrder")
	public ResponseEntity<?> updateAdvice(@RequestBody OrderDTO orderDto)throws Exception {
		return ResponseEntity.ok(this.orderService.updateOrder(orderDto));
	}
	
	//This is the end point for deleting order using id
	@DeleteMapping("deleteOrder/{id}")
	public ResponseEntity<?> deleteAdvice(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.orderService.deleteOrder(id));

	}
	
	//This is the end point for getting all orders
	@GetMapping("findAll")
	public ResponseEntity<?> findAll()throws Exception {
		return ResponseEntity.ok(this.orderService.findAll());
	}
	
}
