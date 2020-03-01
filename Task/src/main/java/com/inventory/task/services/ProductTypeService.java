package com.inventory.task.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.inventory.task.dto.productTypeDTO;
import com.inventory.task.entities.ProductType;

@Component
public interface ProductTypeService {
	/*this interface is designed to specify the services should be implemented to cover ProductType logic
	it contains the header of all CRUD operations for ProductType class
	  and it's implemented by ProductTypeServiceImpl class */
	
	
	public boolean addProductType(productTypeDTO product) throws Exception; //adding new ProductType
	public boolean updateProductType(productTypeDTO product) throws Exception;  //update existing ProductType
	public boolean deleteProductType(int id) throws Exception; //delete existing ProductType
	public productTypeDTO findById(int id)  throws Exception;  // find ProductType using ProductType Id
	public List<productTypeDTO> findAll()  throws Exception;  // get all ProductType 
	public ProductType findByProductTypeID(int id) throws Exception; // find ProductType By id and return it as entity not DTO like others


}
