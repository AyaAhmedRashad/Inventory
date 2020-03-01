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
import com.inventory.task.dto.ProductInventoryDTO;
import com.inventory.task.dto.ProductTypeAndPackageDTO;
import com.inventory.task.dto.paginationFilters;
import com.inventory.task.services.ProductInventoryService;

@RestController
@RequestMapping("ProductInventory")
public class ProductInventoryController {
	//ProductInventory controller contains All the API related to productInventory Service (CRUD)
	
	@Autowired
	private ProductInventoryService productService;
	
	//This is the end point for adding new product in inventory
	@PostMapping("addNewProduct")
	public ResponseEntity<?> addPackage(@RequestBody ProductInventoryDTO productDto)throws Exception {
		return ResponseEntity.ok(this.productService.addNewProduct(productDto));
	}
	
	//This is the end point for finding one product by Id
	@GetMapping("findById/{id}")
	public ResponseEntity<?> findById(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.productService.findById(id));

	}
	
	//This is the end point for updating product
	@PutMapping("updateProduct")
	public ResponseEntity<?> updateAdvice(@RequestBody ProductInventoryDTO productDto)throws Exception {
		return ResponseEntity.ok(this.productService.updateProduct(productDto));
	}
	
	//This is the end point for deleting product using id
	@DeleteMapping("deleteProduct/{id}")
	public ResponseEntity<?> deleteAdvice(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.productService.deleteProduct(id));

	}
	//This is the end point for getting all products(not ordered yet) details and count according to productType 
	@GetMapping("findByProductType/{productTypeId}")
	public ResponseEntity<?> getReportForAllProductsByProductType(@PathVariable int productTypeId)throws Exception {
		return ResponseEntity.ok(this.productService.getReportForAllProductsByProductType(productTypeId));

	}
	//This is the end point for getting all products (not ordered yet) details and count according to productType and package
	@GetMapping("findByProductTypeAndPackage")
	public ResponseEntity<?> getReportForAllProductsByProductTypeAndPackageId(@RequestBody ProductTypeAndPackageDTO productTypePackage)throws Exception {
		return ResponseEntity.ok(this.productService.getReportForAllProductsByProductTypeAndPackageId(productTypePackage));

	}
	//This is the end point for getting all products
	@GetMapping("findAll")
	public ResponseEntity<?> findAll()throws Exception {
		return ResponseEntity.ok(this.productService.findAll());
	}
	
	//This is the end point to get all products exists in inventory at any time
	@GetMapping("getAllProductsInInventory")
	public ResponseEntity<?> getAllProductsInInventory(paginationFilters filters)throws Exception {
		return ResponseEntity.ok(this.productService.getAllProductsInInventory(filters));

	}
	
}
