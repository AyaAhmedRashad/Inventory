package com.inventory.task.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inventory.task.dto.PackagingDTO;
import com.inventory.task.entities.Packaging;

@Component
public interface PackageService {
	/*this interface is designed to specify the services should be implemented to cover Packaging logic
	it contains the header of all CRUD operations for Packaging class
	  and it's implemented by PackagingServiceImpl class */
	
	
	public boolean addNewPackage(PackagingDTO packageDto) throws Exception; //adding new package
	public boolean updatePackage(PackagingDTO packageDto) throws Exception; //update existing package
	public boolean deletePackage(int id) throws Exception; //delete existing package
	public PackagingDTO findById(int id)  throws Exception; // find package using package Id
	public List<PackagingDTO> findAll()  throws Exception;  // get all packages 
	public Packaging findByPackageID(int id) throws Exception; // find package By id and return it as entity not DTO like others
}