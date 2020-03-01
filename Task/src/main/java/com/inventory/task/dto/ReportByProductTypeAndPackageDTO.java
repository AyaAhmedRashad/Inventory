package com.inventory.task.dto;

import java.util.List;

//this DTO designed to be used in displaying report for products(not ordered yet) details and account according to both productType and package
public class ReportByProductTypeAndPackageDTO {
	private List<ProductInventoryDisplayDTO> products;//list of all products according to product type id and package id
	private int packageCount; // the count of products according to product type id and package id
	
	public ReportByProductTypeAndPackageDTO() {}

	public ReportByProductTypeAndPackageDTO(List<ProductInventoryDisplayDTO> products, int packageCount) {
		super();
		this.products = products;
		this.packageCount = packageCount;
	}

	public List<ProductInventoryDisplayDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductInventoryDisplayDTO> products) {
		this.products = products;
	}

	public int getPackageCount() {
		return packageCount;
	}

	public void setPackageCount(int packageCount) {
		this.packageCount = packageCount;
	}
	
	
}
