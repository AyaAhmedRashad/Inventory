package com.inventory.task.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inventory.task.dto.AdviceDTO;
import com.inventory.task.dto.AdviceDisplayDTO;
import com.inventory.task.entities.Advice;


@Component
public interface AdviceService {
	/*this interface is designed to specify the services should be implemented to cover Advice logic
	it contains the header of all CRUD operations for Advise class
	  and it's implemented by AdviceServiceImpl class */
	
	
	public boolean addNewAdvice(AdviceDTO adviceDto) throws Exception; //adding new advice
	public boolean updateAdvice(AdviceDTO adviceDto) throws Exception; //update existing advice 
	public boolean deleteAdvice(int id) throws Exception; //delete existing advice
	public AdviceDisplayDTO findById(int id)  throws Exception; // find advice using advice Id
	public List<AdviceDisplayDTO> findAll()  throws Exception; // get all Advises 
	public Advice findByAdviceID(int id)  throws Exception; // find advice By id and return it as entity not DTO like others
}
