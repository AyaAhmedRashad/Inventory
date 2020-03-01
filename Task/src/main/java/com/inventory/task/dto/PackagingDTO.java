package com.inventory.task.dto;

// this DTO designed to be used in most of packaging service
public class PackagingDTO {

	private Integer id;
	private String packageName;
	private Integer packageQuantity;
	private Integer packageType;
	public PackagingDTO() {}
	public PackagingDTO(Integer id, String packageName, Integer packageQuantity, Integer packageType) {
		super();
		this.id = id;
		this.packageName = packageName;
		this.packageQuantity = packageQuantity;
		this.packageType = packageType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public Integer getPackageQuantity() {
		return packageQuantity;
	}
	public void setPackageQuantity(Integer packageQuantity) {
		this.packageQuantity = packageQuantity;
	}
	public Integer getPackageType() {
		return packageType;
	}
	public void setPackageType(Integer packageType) {
		this.packageType = packageType;
	}
	
	
}
