package com.inventory.task.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.inventory.task.dto.ProductInventoryDTO;
import com.inventory.task.dto.ProductInventoryDisplayDTO;
import com.inventory.task.dto.ProductTypeAndPackageDTO;
import com.inventory.task.dto.ReportByProductTypeAndPackageDTO;
import com.inventory.task.dto.ReportByProductTypeDTO;
import com.inventory.task.dto.paginationFilters;
import com.inventory.task.entities.ProductInventory;


@Component
public interface ProductInventoryService {
	/*this interface is designed to specify the services should be implemented to cover ProductInventory logic
	it contains the header of all CRUD operations for ProductInventory class
	  and it's implemented by ProductInventoryServiceImpl class */
	
	
	public boolean addNewProduct(ProductInventoryDTO productDto) throws Exception; //adding new product
	public boolean updateProduct(ProductInventoryDTO productDto) throws Exception; //update existing product
	public boolean deleteProduct(int id) throws Exception;  //delete existing product
	public ProductInventoryDisplayDTO findById(int id)  throws Exception; // find product using product Id
	public List<ProductInventoryDisplayDTO> findAll()  throws Exception;  // get all products 
	public boolean deleteProductList(Set<ProductInventory> products) throws Exception; //delete list of products
	public ProductInventoryDisplayDTO mappingToDto(ProductInventory product) ; //mapping from entity to DTO
	public boolean AddProductsToOrder(Set<Integer> productsID,int orderId) throws Exception; //add products to order
	public ReportByProductTypeDTO getReportForAllProductsByProductType(Integer productTypeId) throws Exception; //get products details by productTypeId
	public ReportByProductTypeAndPackageDTO getReportForAllProductsByProductTypeAndPackageId (ProductTypeAndPackageDTO productTypePackage) throws Exception; //get products details by productTypeId and Package ID
    public List<ProductInventoryDisplayDTO> getAllProductsInInventory(paginationFilters filters) throws Exception; 	//this  service can be called any time to get all products exists in the inventory with their details

}
