package com.inventory.task.dto;

//this DTO designed to be used as parameter to the controller and service for product type and package
public class ProductTypeAndPackageDTO {

	private Integer productTypeId;
	private Integer packageId;
	public ProductTypeAndPackageDTO() {}
	public ProductTypeAndPackageDTO(Integer productTypeId, Integer packageId) {
		super();
		this.productTypeId = productTypeId;
		this.packageId = packageId;
	}
	public Integer getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	
}
