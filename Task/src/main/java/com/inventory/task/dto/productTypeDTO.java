package com.inventory.task.dto;

//this DTO deigned to be used in adding and updating of product Type functions
public class productTypeDTO {

	
	private Integer id;
	private String productTypeName;
	private String company;
	
	public productTypeDTO() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public productTypeDTO(Integer id, String productTypeName, String company) {
		super();
		this.id = id;
		this.productTypeName = productTypeName;
		this.company = company;
	}
	
	
	
}
