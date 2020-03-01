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
import com.inventory.task.dto.OrderDTO;
import com.inventory.task.dto.OrderDisplayDTO;
import com.inventory.task.dto.ProductInventoryDisplayDTO;
import com.inventory.task.entities.Ordering;
import com.inventory.task.entities.ProductInventory;
import com.inventory.task.repos.OrderRepo;
import com.inventory.task.services.OrderService;
import com.inventory.task.services.ProductInventoryService;

@Service
public class OrderServiceImpl implements OrderService {
	 // this class service contain all operations related to Ordering entity class
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private ProductInventoryService productService;
	
	//this service for creating new order with their products ids in database 
	@Transactional(rollbackFor={Exception.class})
	@Override
	public boolean addNewOrder(OrderDTO orderDto) throws Exception {
	if(orderDto.getId()!=null) {
		throw new Exception("id can not be inserted it is automatically generated");
	}if(orderDto.getPoductList()==null||orderDto.getPoductList().size()==0) {
		throw new Exception("order should contain at least one product");
	}
	try {
		Ordering order=new Ordering();
		order.setOrderDate(new Date());
		order=orderRepo.save(order);
		productService.AddProductsToOrder(orderDto.getPoductList(), order.getId());
		return true;
	}
	catch(Exception ex) {
		throw ex;
	}
	
	}
	
	//this service for updating existing Order with their products ids
	@Transactional(rollbackFor={Exception.class})
	@Override
	public boolean updateOrder(OrderDTO orderDto) throws Exception {
		if(orderDto.getId()==null) {
			throw new Exception("id can not be null");
		}if((orderDto.getPoductList()==null||orderDto.getPoductList().size()==0)&&orderDto.getOrderDate()==null) {
			throw new Exception("there is nothing to update");
		}
		try {
			Ordering order=orderRepo.findById(orderDto.getId()).get();
			if(orderDto.getOrderDate()!=null) {
				order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderDto.getOrderDate()));
			}
			order=orderRepo.save(order);
			if(orderDto.getPoductList().size()>0) {
			if(order.getProductsList().size()>0) {
		   order.getProductsList().removeAll(order.getProductsList());
		   order=orderRepo.save(order);
			}
		productService.AddProductsToOrder(orderDto.getPoductList(), order.getId());
	
			}
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}

	//this service for deleting Order with it's products also
	@Transactional(rollbackFor={Exception.class})
	@Override
	public boolean deleteOrder(int id) throws Exception {
		if(!orderRepo.existsById(id)) {
			throw new Exception("this order id is not exist");
		}
		try {
			Ordering order=orderRepo.findById(id).get();
			if(order.getProductsList().size()>0) {
				productService.deleteProductList(order.getProductsList());
				
			}
			orderRepo.deleteById(id);
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	//this service to get one Order from the database with it's products details by order id and mapping it to DTO in return
	@Transactional
	@Override
	public OrderDisplayDTO findById(int id) throws Exception {
		if(!orderRepo.existsById(id)) {
			throw new Exception("this order id is not exits");
		}
		Ordering order=orderRepo.findById(id).get();
		OrderDisplayDTO orderDto=new OrderDisplayDTO();
		orderDto.setId(order.getId());
		orderDto.setOrderDate(order.getOrderDate().toString());
		Set<ProductInventoryDisplayDTO> poductList=new LinkedHashSet<>();
    for(ProductInventory prod:order.getProductsList()) {
    	poductList.add(productService.mappingToDto(prod));
    	
   }
    orderDto.setPoductList(poductList);
		
		return orderDto;
		
	}

	//this service to get All orders in the database with their products details and mapping them to DTO in return
	@Transactional
	@Override
	public List<OrderDisplayDTO> findAll() throws Exception {
		List<OrderDisplayDTO> orderListDto=new ArrayList<>();
		List<Ordering> orderList=orderRepo.findAll();
		for(Ordering order:orderList) {
			OrderDisplayDTO orderDto=new OrderDisplayDTO();
			orderDto.setId(order.getId());
			orderDto.setOrderDate(order.getOrderDate().toString());
		Set<ProductInventoryDisplayDTO> poductList=new LinkedHashSet<>();
    for(ProductInventory prod:order.getProductsList()) {   
    	poductList.add(productService.mappingToDto(prod));
    	
    }
    orderDto.setPoductList(poductList);
    orderListDto.add(orderDto);
    }
		return orderListDto;
	}

	//this service is also to get one order from the database by order id and return it as entity to be used in another services
		//without mapping to DTO
	@Transactional
	@Override
	public Ordering findByOrderID(int id) throws Exception {
		if(!orderRepo.existsById(id)) {
			throw new Exception("order id is not exits");
		}
		try {
		return orderRepo.findById(id).get();
		}
		catch(Exception ex) {
			throw ex;
		}
	}

}
