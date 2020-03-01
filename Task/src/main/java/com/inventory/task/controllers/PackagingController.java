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

import com.inventory.task.dto.PackagingDTO;
import com.inventory.task.dto.productTypeDTO;
import com.inventory.task.servicesImpl.PackageServiceImpl;
import com.inventory.task.servicesImpl.ProductTypeServiceImpl;

@RestController
@RequestMapping("packaging")

public class PackagingController {
	//Packaging controller contains All the API related to Packaging Service (CRUD)
	
	@Autowired
	private PackageServiceImpl packageService;
	
	//This is the end point for adding new package
	@PostMapping("addPackage")
	public ResponseEntity<?> addPackage(@RequestBody PackagingDTO packaging)throws Exception {
		return ResponseEntity.ok(this.packageService.addNewPackage(packaging));
	}
	
	//This is the end point for updating package
	@PutMapping("updatePackage")
	public ResponseEntity<?> updatePackage(@RequestBody PackagingDTO packaging)throws Exception {
		return ResponseEntity.ok(this.packageService.updatePackage(packaging));
	}
	
	//This is the end point for deleting package using id
	@DeleteMapping("deletePackage/{id}")
	public ResponseEntity<?> deletePackage(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.packageService.deletePackage(id));

	}
	
	//This is the end point for finding one package by Id
	@GetMapping("findById/{id}")
	public ResponseEntity<?> findById(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.packageService.findById(id));

	}
	
	//This is the end point for getting all packages
	@GetMapping("findAll")
	public ResponseEntity<?> findAll()throws Exception {
		return ResponseEntity.ok(this.packageService.findAll());

	}

}
