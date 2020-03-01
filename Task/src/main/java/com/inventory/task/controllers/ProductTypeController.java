package com.inventory.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.task.dto.productTypeDTO;
import com.inventory.task.entities.ProductType;
import com.inventory.task.servicesImpl.ProductTypeServiceImpl;

@RestController
@RequestMapping("productType")
public class ProductTypeController {
	
	//product Type controller contains All the API related to product Type Service (CRUD)
	@Autowired
	private ProductTypeServiceImpl productTypeService;
	
	//This is the end point for adding new product Type
	@PostMapping("addProductType")
	public ResponseEntity<?> addProductType(@RequestBody productTypeDTO product)throws Exception {
		return ResponseEntity.ok(this.productTypeService.addProductType(product));
	}
	
	//This is the end point for updating product Type
	@PutMapping("updateProductType")
	public ResponseEntity<?> updateProductType(@RequestBody productTypeDTO product)throws Exception {
		return ResponseEntity.ok(this.productTypeService.updateProductType(product));
	}
	
	//This is the end point for deleting product Type using id
	@DeleteMapping("deleteProductType/{id}")
	public ResponseEntity<?> deleteProductType(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.productTypeService.deleteProductType(id));

	}
	
	//This is the end point for finding one product Type by Id
	@GetMapping("findById/{id}")
	public ResponseEntity<?> findById(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.productTypeService.findById(id));

	}
	
	//This is the end point for getting all product Types
	@GetMapping("findAll")
	public ResponseEntity<?> findAll()throws Exception {
		return ResponseEntity.ok(this.productTypeService.findAll());

	}
}
