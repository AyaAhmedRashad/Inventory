package com.inventory.task.dto;

//this DTO designed to be used in get productInventory function as it casted to the required attributes need to be displayed
public class ProductInventoryDisplayDTO {
	private Integer id;
	private String itemCode;
	private PackagingDTO packaging;
	private productTypeDTO productType;
	private AdviceDTO advice;
	private OrderDTO order;
	private Boolean isOrdered;
	
	public ProductInventoryDisplayDTO() {}

	
	
	
	public ProductInventoryDisplayDTO(Integer id, String itemCode, PackagingDTO packaging, productTypeDTO productType,
			AdviceDTO advice, OrderDTO order, Boolean isOrdered) {
		super();
		this.id = id;
		this.itemCode = itemCode;
		this.packaging = packaging;
		this.productType = productType;
		this.advice = advice;
		this.order = order;
		this.isOrdered = isOrdered;
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

	public PackagingDTO getPackaging() {
		return packaging;
	}

	public void setPackaging(PackagingDTO packaging) {
		this.packaging = packaging;
	}

	public productTypeDTO getProductType() {
		return productType;
	}

	public void setProductType(productTypeDTO productType) {
		this.productType = productType;
	}

	public AdviceDTO getAdvice() {
		return advice;
	}

	public void setAdvice(AdviceDTO advice) {
		this.advice = advice;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public Boolean getIsOrdered() {
		return isOrdered;
	}

	public void setIsOrdered(Boolean isOrdered) {
		this.isOrdered = isOrdered;
	}
	
	
}
