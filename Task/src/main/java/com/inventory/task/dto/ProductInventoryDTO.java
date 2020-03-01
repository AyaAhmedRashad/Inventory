package com.inventory.task.dto;

//this DTO deigned to be used in adding and updating of productInventory functions
public class ProductInventoryDTO {
	private Integer id;
	private String itemCode;
	private Integer packageId;
	private Integer productTypeId;
	private Integer adviceId;
	private Integer orderId;
	private Boolean isOrdered;
	
	public ProductInventoryDTO() {}

	public ProductInventoryDTO(Integer id, String itemCode, Integer packageId, Integer productTypeId, Integer adviceId,
			Integer orderId) {
		super();
		this.id = id;
		this.itemCode = itemCode;
		this.packageId = packageId;
		this.productTypeId = productTypeId;
		this.adviceId = adviceId;
		this.orderId = orderId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Integer getAdviceId() {
		return adviceId;
	}

	public void setAdviceId(Integer adviceId) {
		this.adviceId = adviceId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Boolean getIsOrdered() {
		return isOrdered;
	}

	public void setIsOrdered(Boolean isOrdered) {
		this.isOrdered = isOrdered;
	}
	
	
	
	
}
