package com.inventory.task.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.task.dto.productTypeDTO;
import com.inventory.task.entities.ProductType;
import com.inventory.task.repos.ProductTypeRepo;
import com.inventory.task.services.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	// this class service contain all operations related to ProductType entity class
	@Autowired
	private ProductTypeRepo productTypeRepo;
	
	//this service for creating new ProductType in database 
	@Transactional
	@Override
	public boolean addProductType(productTypeDTO productDto) throws Exception {
		
		if(productDto.getId()!=null) {
			throw new Exception("can not insert id , it is automatic generated");
		}
		if(productDto.getProductTypeName()==null) {
			throw new Exception("product type name can not be null ");
		}
		else {
		try {
			ProductType productEntity=new ProductType(productDto.getProductTypeName(),productDto.getCompany());
			productTypeRepo.save(productEntity);
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
		}
		
	}
	
	//this service for updating existing ProductType 
	@Transactional
	@Override
	public boolean updateProductType(productTypeDTO productDto) throws Exception {
		if(productDto.getId()==null) {
			throw new Exception("id of product type should be added");
		}
		if(productDto.getProductTypeName()==null&&productDto.getCompany()==null) {
			throw new Exception("Both product type name and company can not be null ");
		}
		if(!productTypeRepo.existsById(productDto.getId())) {
			throw new Exception("this product type id is not exist");
		}
		else {
			
			try {
				ProductType product=productTypeRepo.findById(productDto.getId()).get();
				if(productDto.getProductTypeName()!=null) {
					product.setProductTypeName(productDto.getProductTypeName());
				}
				if(productDto.getCompany()!=null) {
					product.setCompanyName(productDto.getCompany());
				}
				productTypeRepo.save(product);
				return true;
			}
			catch(Exception ex) {
				throw ex;
			}
			}
	
	}
	
	//this service for deleting specific ProductType from the database
	@Override
	@Transactional
	public boolean deleteProductType(int id) throws Exception {
	     if(!productTypeRepo.existsById(id)) {
	    	 throw new Exception("this product type id is not exist");
	     }
	     else {
	    	 try {
	    		 productTypeRepo.deleteById(id);
	    		 return true;
	    	 }
	    	 catch(Exception ex) {
	    		 throw ex;
	    	 }
	    
	     }
		
	}
	
	//this service to get one ProductType details from the database by ProductType id and mapping it to DTO in return
	@Override
	@Transactional
	public productTypeDTO findById(int id) throws Exception {
		 if(!productTypeRepo.existsById(id)) {
	    	 throw new Exception("this product type id is not exist");
	     }
	     else {
	    	 try {
	    		ProductType product= productTypeRepo.findById(id).get();
	    		productTypeDTO dto=new productTypeDTO (product.getId(),product.getProductTypeName(),product.getCompanyName());
	    		 return dto;
	    	 }
	    	 catch(Exception ex) {
	    		 throw ex;
	    	 }
	    
	     }
	}
	
	//this service to get All ProductTypes from the database and mapping them to DTO in return
	@Override
	@Transactional
	public List<productTypeDTO> findAll() throws Exception {
		try {
		List<ProductType>productList=productTypeRepo.findAll();
		List<productTypeDTO> productListDTO=new ArrayList<productTypeDTO>();
		for(ProductType productEntity:productList) {
			productTypeDTO productDTO=new productTypeDTO(productEntity.getId(),productEntity.getProductTypeName(),productEntity.getCompanyName());
			productListDTO.add(productDTO);
		}
		return productListDTO;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	//this service is also to get one ProductType from the database by ProductType id and return it as entity to be used in another services
	//without mapping to DTO
	@Transactional
	@Override
	public ProductType findByProductTypeID(int id) throws Exception {
		 if(!productTypeRepo.existsById(id)) {
	    	 throw new Exception("this product type id is not exist");
	     }
	     else {
	    	 try {
	    		return productTypeRepo.findById(id).get();
	    	 }
	    	 catch(Exception ex) {
	    		 throw ex;
	    	 }
	    
	     }
	}
	
    
	
}
