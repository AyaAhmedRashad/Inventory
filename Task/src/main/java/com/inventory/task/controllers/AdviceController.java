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

import com.inventory.task.dto.AdviceDTO;
import com.inventory.task.dto.PackagingDTO;
import com.inventory.task.services.AdviceService;


@RestController
@RequestMapping("Advice")
public class AdviceController {
	//Advice controller contains All the API related to advice Service (CRUD)
	@Autowired
	private AdviceService adviceService;
	
	//This is the end point for adding advice
	@PostMapping("addAdvice")
	public ResponseEntity<?> addPackage(@RequestBody AdviceDTO adviceDto)throws Exception {
		return ResponseEntity.ok(this.adviceService.addNewAdvice(adviceDto));
	}
	
	//This is the end point for finding one  advice by Id
	@GetMapping("findById/{id}")
	public ResponseEntity<?> findById(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.adviceService.findById(id));

	}
	//This is the end point for updating advice
	@PutMapping("updateAdvice")
	public ResponseEntity<?> updateAdvice(@RequestBody AdviceDTO adviceDto)throws Exception {
		return ResponseEntity.ok(this.adviceService.updateAdvice(adviceDto));
	}
	
	//This is the end point for deleting advice using id
	@DeleteMapping("deleteAdvice/{id}")
	public ResponseEntity<?> deleteAdvice(@PathVariable int id)throws Exception {
		return ResponseEntity.ok(this.adviceService.deleteAdvice(id));

	}
	
	//This is the end point for getting all advises
	@GetMapping("findAll")
	public ResponseEntity<?> findAll()throws Exception {
		return ResponseEntity.ok(this.adviceService.findAll());
	}
	
}
