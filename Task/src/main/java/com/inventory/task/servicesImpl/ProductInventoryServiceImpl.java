package com.inventory.task.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.task.dto.AdviceDTO;
import com.inventory.task.dto.OrderDTO;
import com.inventory.task.dto.PackagingDTO;
import com.inventory.task.dto.ProductInventoryDTO;
import com.inventory.task.dto.ProductInventoryDisplayDTO;
import com.inventory.task.dto.ProductTypeAndPackageDTO;
import com.inventory.task.dto.ReportByProductTypeAndPackageDTO;
import com.inventory.task.dto.ReportByProductTypeDTO;
import com.inventory.task.dto.paginationFilters;
import com.inventory.task.dto.productTypeDTO;
import com.inventory.task.entities.ProductInventory;
import com.inventory.task.enums.PackageType;
import com.inventory.task.repos.ProductInventoryRepo;
import com.inventory.task.services.AdviceService;
import com.inventory.task.services.OrderService;
import com.inventory.task.services.PackageService;
import com.inventory.task.services.ProductInventoryService;
import com.inventory.task.services.ProductTypeService;

@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {
	// this class service contain all operations related to ProductInventory entity class

	@Autowired
	private ProductInventoryRepo productRepo;
	
	@Autowired
	private PackageService packageService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@Autowired
	private AdviceService adviceService;
	
	@Autowired
	private OrderService orderService;
	
	//this service for creating new product in inventory database and logically not be used except in making or updating advice
	@Transactional
	@Override
	public boolean addNewProduct(ProductInventoryDTO productDto) throws Exception {
		if(productDto.getId()!=null) {
			throw new Exception("product id can not be inserted");
		}
		if(productDto.getItemCode()==null) {
			throw new Exception("Item code should be exist");
		}
		if(productDto.getPackageId()==null) {
			throw new Exception("product should has package ID");
		}
		if(productDto.getProductTypeId()==null) {
			throw new Exception("product should has product type");
		}
		if(productDto.getOrderId()!=null) {
			throw new Exception("adding advice can not contain order Id");
		}
		try {
			ProductInventory product=new ProductInventory();
			product.setItemCode(productDto.getItemCode());
			product.setPackageId(packageService.findByPackageID(productDto.getPackageId()));
			product.setProductTypeId(productTypeService.findByProductTypeID(productDto.getProductTypeId()));
			if(productDto.getAdviceId()!=null) {
				product.setAdviceId(adviceService.findByAdviceID(productDto.getAdviceId()));
				product.setOrdered(false);
			}
			
			productRepo.save(product);
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
		
		
	}
	
	//this service for updating existing product 
	@Transactional
	@Override
	public boolean updateProduct(ProductInventoryDTO productDto) throws Exception {
		if(productDto.getId()==null) {
			throw new Exception("product id can not be null");
		}
		if(productDto.getItemCode()==null&&productDto.getPackageId()==null&&productDto.getProductTypeId()==null) {
			throw new Exception("product has no thing to update");
		}
		if(!productRepo.existsById(productDto.getId())) {
			throw new Exception("product id not exist");
		}
		
		try {
			ProductInventory product=productRepo.findById(productDto.getId()).get();
			if(productDto.getItemCode()!=null) {
				product.setItemCode(productDto.getItemCode());
			}
			if(productDto.getPackageId()!=null) {
				product.setPackageId(packageService.findByPackageID(productDto.getPackageId()));
			}
			if(productDto.getProductTypeId()!=null) {
				product.setProductTypeId(productTypeService.findByProductTypeID(productDto.getProductTypeId()));
			}
			productRepo.save(product);
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	//this service for deleting specific product from the database
	@Transactional
	@Override
	public boolean deleteProduct(int id) throws Exception {
		if(!productRepo.existsById(id)) {
			throw new Exception("product id not exist");
		}
		try {
			productRepo.deleteById(id);
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	//this service to get one product details from the database by product id and mapping it to DTO in return
	@Transactional
	@Override
	public ProductInventoryDisplayDTO findById(int id) throws Exception {
		if(!productRepo.existsById(id)) {
			throw new Exception("product id not exist");
		}
		try {
			
			return mappingToDto(productRepo.findById(id).get());
		}
		catch(Exception ex) {
			throw ex;
		}
	}

//	//this service to get All products from the database and mapping them to DTO in return
	@Transactional
	@Override
	public List<ProductInventoryDisplayDTO> findAll() throws Exception {
		List<ProductInventory> products=productRepo.findAll();
		List<ProductInventoryDisplayDTO> productsDto=new ArrayList<>();
		for(ProductInventory product:products) {
			productsDto.add(mappingToDto(product));
		}
		return productsDto;
	}

	//this service for deleting a list of product in one service
	@Transactional(rollbackFor={Exception.class})
	@Override
	public boolean deleteProductList(Set<ProductInventory> products) throws Exception {

		try {
			//productRepo.deleteInBatch(products);
			for(ProductInventory prod:products) {
				productRepo.delete(prod);
			}
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	//this service only used for mapping ProductInventory entity to it's DTO and used by another multiple service
	@Transactional
	@Override
	public ProductInventoryDisplayDTO mappingToDto(ProductInventory prod) {
		ProductInventoryDisplayDTO prodDto=new ProductInventoryDisplayDTO();
    	prodDto.setId(prod.getId());
    	prodDto.setItemCode(prod.getItemCode());
    	//mapping package to package DTO
    	PackagingDTO packageDto=new PackagingDTO();
    	packageDto.setId(prod.getPackageId().getId());
    	packageDto.setPackageName(prod.getPackageId().getPackageName());
    	packageDto.setPackageQuantity(prod.getPackageId().getPackageQuantity());
    	packageDto.setPackageType(prod.getPackageId().getPackageType());
    	prodDto.setPackaging(packageDto);
    	//mapping productType to package productTypeDTO
    	productTypeDTO productTypeDto=new productTypeDTO();
    	productTypeDto.setId(prod.getProductTypeId().getId());
    	productTypeDto.setProductTypeName(prod.getProductTypeId().getProductTypeName());
    	productTypeDto.setCompany(prod.getProductTypeId().getCompanyName());
    	prodDto.setProductType(productTypeDto);
    	
    	//mapping Order toOrderDTO
    	if(prod.getOrderId()!=null) {
    		OrderDTO orderDto=new OrderDTO();
        	orderDto.setId(prod.getOrderId().getId());
        	orderDto.setOrderDate(prod.getOrderId().getOrderDate().toString());
        	prodDto.setOrder(orderDto);
    	}
    	//mapping Advice to AdviceDTO //added only for test and better to be deleted
    	if(prod.getAdviceId()!=null) {
    	AdviceDTO adviseProductDto=new AdviceDTO();
    	adviseProductDto.setId(prod.getAdviceId().getId());
    	adviseProductDto.setAdviceDate(prod.getAdviceId().getAdviceDate().toString());
    	prodDto.setAdvice(adviseProductDto);
	  }
    	prodDto.setIsOrdered(prod.isOrdered());
    	return prodDto;
	}
	
	//this service used to update product record to link it to specific order(used in making orders)
	@Transactional
	@Override
   public boolean AddProductsToOrder(Set<Integer> productsID, int orderId) throws Exception {
		try {
		for(Integer productId:productsID) {
			if(!productRepo.existsById(productId)) {
				throw new Exception("product id is not exits");
			}
			ProductInventory product=productRepo.findById(productId).get();
			if(product.isOrdered()==true&&product.getOrderId().getId()!=orderId) {
				throw new Exception("this product is already ordered");
			}
			product.setOrdered(true);
			product.setOrderId(orderService.findByOrderID(orderId));
			productRepo.save(product);
		}
		return true;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	
	}

	/*this service used like report for details of products 
	 it takes productType Id and get all products with that productTypeID from inventory that are not ordered yet
	 get products details , their packaging details and also their advise details
	used to know the count of this type of product of all packages with their all details*/
	@Transactional
	@Override
	public ReportByProductTypeDTO getReportForAllProductsByProductType(Integer productTypeId) throws Exception {
		if(productTypeId==null) {
		throw new Exception("product type Id should be exists")	;
		}
		if(productTypeService.findByProductTypeID(productTypeId)==null) {
			throw new Exception("product type Id not exists")	;
		}
	
		try {
			ReportByProductTypeDTO reportDto=new ReportByProductTypeDTO();
			List<ProductInventoryDisplayDTO> productsList=new ArrayList<>();
			List<ProductInventory>productsOfProductTypeId=productRepo.findByProductTypeIdAndIsOrdered(productTypeService.findByProductTypeID(productTypeId),false);
			int singlePackageCount=0;
			int simplePackageCount=0;
			int largePackageCount=0;
			if(productsOfProductTypeId.size()>0) {
				for(ProductInventory product :productsOfProductTypeId) {
					productsList.add(mappingToDto(product));
					if(product.getPackageId().getPackageType()==PackageType.single.getNumVal()) {
						singlePackageCount=singlePackageCount+1;
					}
					if(product.getPackageId().getPackageType()==PackageType.simplePackage.getNumVal()) {
						simplePackageCount=simplePackageCount+1;
					}
					if(product.getPackageId().getPackageType()==PackageType.largePackage.getNumVal()) {
						largePackageCount=largePackageCount+1;
					}
				}
				reportDto.setSingleCount(singlePackageCount);
				reportDto.setSimplePackageCount(simplePackageCount);
				reportDto.setLargePackageCount(largePackageCount);
				reportDto.setProducts(productsList);
			}
			return reportDto;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

	/* this service also like report as the previous service get products not ordered yet also
	but this service get the products according to ProductTypeId and Package Id
	it filters the data according to this 2 parameters not only productTypeID
	so it get the count of the  package Id only not all Packages*/
	@Transactional
	@Override
	public ReportByProductTypeAndPackageDTO getReportForAllProductsByProductTypeAndPackageId(ProductTypeAndPackageDTO productTypePackage) throws Exception {
		if(productTypePackage.getProductTypeId()==null||productTypePackage.getPackageId()==null) {
			throw new Exception("product type Id and package id can not be null")	;
			}
		if(productTypeService.findByProductTypeID(productTypePackage.getProductTypeId())==null) {
			throw new Exception("product type Id not exists")	;
		}
		if(packageService.findByPackageID(productTypePackage.getPackageId())==null) {
			throw new Exception("package Id not exists")	;
		}
			try {
				ReportByProductTypeAndPackageDTO reportDto=new ReportByProductTypeAndPackageDTO();
				List<ProductInventoryDisplayDTO> productsList=new ArrayList<>();
				List<ProductInventory> products=productRepo.findByProductTypeIdAndPackageIdAndIsOrdered(productTypeService.findByProductTypeID(productTypePackage.getProductTypeId()), packageService.findByPackageID(productTypePackage.getPackageId()),false);
				int productCount=0;
				if(products.size()>0) {
					for(ProductInventory product :products) {
						productsList.add(mappingToDto(product));
						productCount=productCount+1;
					}
					reportDto.setPackageCount(productCount);
					reportDto.setProducts(productsList);
				}
				return reportDto;
			}
			catch(Exception ex) {
				throw ex;
			}
	}

	//this  service can be called any time to get all products exists in the inventory with their details
	//the data get paginated according to page number and page size
	@Transactional
	@Override
	public List<ProductInventoryDisplayDTO> getAllProductsInInventory(paginationFilters filters) throws Exception{
		if(filters.getPageNumber()==null||filters.getPageSize()==null) {
			throw new Exception("page number and page size should be identified");
		}
		List<ProductInventoryDisplayDTO> productsList=new ArrayList<>();
		  Pageable Paging = PageRequest.of(filters.getPageNumber(), filters.getPageSize());

	        Page<ProductInventory> pageOfProducts = productRepo.findAll(new Specification<ProductInventory>() {
	            private static final long serialVersionUID = 1L;

	            @Override
	            public Predicate toPredicate(Root<ProductInventory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
	                List<Predicate> predicates = new ArrayList<>();
  
	              
	                //condition to get only Unordered products
	                predicates.add(criteriaBuilder.equal(root.get("isOrdered"), false));


	                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	            }
	        }, Paging);
	        if (pageOfProducts != null && !pageOfProducts.isEmpty()) {
	        	 for(ProductInventory product:pageOfProducts) {
	        		 productsList.add(mappingToDto(product));
	 			}
	        }
	       
           return productsList;
	}
	
}
