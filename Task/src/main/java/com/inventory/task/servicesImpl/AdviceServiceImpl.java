package com.inventory.task.servicesImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.task.dto.AdviceDTO;
import com.inventory.task.dto.AdviceDisplayDTO;
import com.inventory.task.dto.ProductInventoryDTO;
import com.inventory.task.dto.ProductInventoryDisplayDTO;
import com.inventory.task.entities.Advice;
import com.inventory.task.entities.ProductInventory;
import com.inventory.task.repos.AdviceRepo;
import com.inventory.task.services.AdviceService;
import com.inventory.task.services.ProductInventoryService;
@Service
public class AdviceServiceImpl implements AdviceService { 
	 // this class service contain all operations related to Advise entity class
	@Autowired
	private AdviceRepo adviceRepo;  
	@Autowired
    private  ProductInventoryService productInventoryService;  

	//this service for creating new Advice with their products in database 
	@Transactional(rollbackFor={Exception.class})
	@Override
	public boolean addNewAdvice(AdviceDTO adviceDto) throws Exception {
		if(adviceDto.getId()!=null) {
			throw new Exception("id of advice can not be inserted");
		}
		if(adviceDto.getPoductList().size()==0) {
			throw new Exception("Advice should contain atleast one product");
		}
		
		try {
			
			Advice advice=new Advice();
			advice.setAdviceDate(new Date());
			advice=adviceRepo.save(advice);
			for(ProductInventoryDTO prod:adviceDto.getPoductList()) {
				prod.setAdviceId(advice.getId());
				prod.setIsOrdered(false);
				productInventoryService.addNewProduct(prod);
			}
			
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	//this service for updating existing advice with their products
	@Transactional(rollbackFor={Exception.class})
	@Override
	public boolean updateAdvice(AdviceDTO adviceDto) throws Exception {
		if(adviceDto.getId()==null) {
			throw new Exception("id of advice can not be null");
		}
		if(adviceDto.getPoductList().size()==0&&adviceDto.getAdviceDate()==null) {
			throw new Exception("there is nothing to update");
		}
		if(!adviceRepo.existsById(adviceDto.getId())) {
			throw new Exception("advice id is not exist");	
		}
		try {
			Advice advice=adviceRepo.findById(adviceDto.getId()).get();
			if(adviceDto.getAdviceDate()!=null) {
				advice.setAdviceDate(new SimpleDateFormat("yyyy-MM-dd").parse(adviceDto.getAdviceDate()));
			}
			
			advice=adviceRepo.save(advice);
			for(ProductInventoryDTO prod:adviceDto.getPoductList()) {
				if(prod.getId()==null) {
					prod.setAdviceId(advice.getId());
					prod.setIsOrdered(false);
					productInventoryService.addNewProduct(prod);
				}
				else {
				   List<Integer> productsId=new ArrayList<Integer>();
				   for(ProductInventory product:advice.getProductsList()) {
					   productsId.add(product.getId());
				   }
					if(productsId.contains(prod.getId())) {
						productInventoryService.updateProduct(prod);	
					}
					else {
						throw new Exception("can not update product not belong to this advice");
					}
					
				}
				
			}
			
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	//this service for deleting advice with it's products also
	@Transactional(rollbackFor={Exception.class})
	@Override
	public boolean deleteAdvice(int id) throws Exception {
		if(!adviceRepo.existsById(id)) {
			throw new Exception("this advice id is not exist");
		}
		try {
			Advice advice=adviceRepo.findById(id).get();
			if(advice.getProductsList().size()>0) {
				productInventoryService.deleteProductList(advice.getProductsList());
			}
			adviceRepo.deleteById(id);
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}

	//this service to get one advice from the database with it's products details by advise id and mapping it to DTO in return
	@Transactional
	@Override
	public AdviceDisplayDTO findById(int id) throws Exception {
		if(!adviceRepo.existsById(id)) {
			throw new Exception("this advice id is not exits");
		}
		Advice advice=adviceRepo.findById(id).get();
		AdviceDisplayDTO adviceDto=new AdviceDisplayDTO();
		adviceDto.setId(advice.getId());
		adviceDto.setAdviceDate(advice.getAdviceDate().toString());
		Set<ProductInventoryDisplayDTO> poductList=new LinkedHashSet<>();
    for(ProductInventory prod:advice.getProductsList()) {
    	poductList.add(productInventoryService.mappingToDto(prod));
    	
   }
    adviceDto.setPoductList(poductList);
		
		return adviceDto;
	}

	//this service to get All advises in the database with their products details and mapping them to DTO in return
	@Transactional
	@Override
	public List<AdviceDisplayDTO> findAll() throws Exception {
		List<AdviceDisplayDTO> adviceListDto=new ArrayList<>();
		List<Advice> adviceList=adviceRepo.findAll();
		for(Advice advice:adviceList) {
		AdviceDisplayDTO adviceDto=new AdviceDisplayDTO();
		adviceDto.setId(advice.getId());
		adviceDto.setAdviceDate(advice.getAdviceDate().toString());
		Set<ProductInventoryDisplayDTO> poductList=new LinkedHashSet<>();
    for(ProductInventory prod:advice.getProductsList()) {
    	poductList.add(productInventoryService.mappingToDto(prod));
    }
    adviceDto.setPoductList(poductList);
    adviceListDto.add(adviceDto);
    }
		return adviceListDto;
	}

	//this service is also to get one advice from the database by advise id and return it as entity to be used in another services
	//without mapping to DTO
	@Transactional
	@Override
	public Advice findByAdviceID(int id) throws Exception {
		if(!adviceRepo.existsById(id)) {
			throw new Exception("this Advice id is not exist");
		}
		return adviceRepo.findById(id).get();
	}

}
