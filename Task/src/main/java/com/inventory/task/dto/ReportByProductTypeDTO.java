package com.inventory.task.dto;

import java.util.List;

//this DTO designed to be used in displaying report for products(not ordered yet) details and account according to  productType 
public class ReportByProductTypeDTO {

	private List<ProductInventoryDisplayDTO> products; //list of all products according to product type id
	private int singleCount; //number of product that has package type single
	private int simplePackageCount;  //number of product that has package type simplepackage
	private int largePackageCount; //number of product that has package type largePackage
	
	public ReportByProductTypeDTO() {}

	public ReportByProductTypeDTO(List<ProductInventoryDisplayDTO> products, int singleCount, int simplePackageCount,
			int largePackageCount) {
		super();
		this.products = products;
		this.singleCount = singleCount;
		this.simplePackageCount = simplePackageCount;
		this.largePackageCount = largePackageCount;
	}

	public List<ProductInventoryDisplayDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductInventoryDisplayDTO> products) {
		this.products = products;
	}

	public int getSingleCount() {
		return singleCount;
	}

	public void setSingleCount(int singleCount) {
		this.singleCount = singleCount;
	}

	public int getSimplePackageCount() {
		return simplePackageCount;
	}

	public void setSimplePackageCount(int simplePackageCount) {
		this.simplePackageCount = simplePackageCount;
	}

	public int getLargePackageCount() {
		return largePackageCount;
	}

	public void setLargePackageCount(int largePackageCount) {
		this.largePackageCount = largePackageCount;
	}
	
	
	
}
