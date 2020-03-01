package com.inventory.task.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_inventory")
public class ProductInventory {
	//this entity represents the products in the repository (advice+order) products 
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "ITEM_CODE", nullable = false)
	private String itemCode;
	@ManyToOne
	@JoinColumn(name = "PACKAGE_ID", nullable = false)
	private Packaging packageId; 
	@ManyToOne
	@JoinColumn(name = "PRODUCT_TYPE_ID", nullable = false)
	private ProductType productTypeId; 
	@ManyToOne
	@JoinColumn(name = "ADVICE_ID")
	private Advice adviceId; 
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Ordering orderId; 
	@Column(name="IS_ORDERED",columnDefinition = "boolean default false", nullable = false)
	private boolean isOrdered;
	
	public ProductInventory() {}

	public ProductInventory(int id, String itemCode, Packaging packageId, ProductType productTypeId, Advice adviceId,
			Ordering orderId) {
		super();
		this.id = id;
		this.itemCode = itemCode;
		this.packageId = packageId;
		this.productTypeId = productTypeId;
		this.adviceId = adviceId;
		this.orderId = orderId;
	}
	

	public ProductInventory(int id, String itemCode, Packaging packageId, ProductType productTypeId, Advice adviceId,
			boolean isOrdered) {
		super();
		this.id = id;
		this.itemCode = itemCode;
		this.packageId = packageId;
		this.productTypeId = productTypeId;
		this.adviceId = adviceId;
		this.isOrdered = isOrdered;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Packaging getPackageId() {
		return packageId;
	}

	public void setPackageId(Packaging packageId) {
		this.packageId = packageId;
	}

	public ProductType getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(ProductType productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Advice getAdviceId() {
		return adviceId;
	}

	public void setAdviceId(Advice adviceId) {
		this.adviceId = adviceId;
	}

	public Ordering getOrderId() {
		return orderId;
	}

	public void setOrderId(Ordering orderId) {
		this.orderId = orderId;
	}

	public boolean isOrdered() {
		return isOrdered;
	}

	public void setOrdered(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}
	
	
}
