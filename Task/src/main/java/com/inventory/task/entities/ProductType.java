package com.inventory.task.entities;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;



@Entity
@Table(name="product_type")
public class ProductType {
	//this entity define the ProductType attributes so that any new ProductType should have this attributes
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "PRODUCT_TYPE_NAME", nullable = false)
	private String productTypeName;
	@Column(name = "COMPANY_NAME")
	private String companyName;

	@OneToMany(mappedBy = "productTypeId", cascade = {CascadeType.ALL})
	private Set<ProductInventory> productsList = new LinkedHashSet<>();  //this is the list of products related to this productType
	
	public ProductType() {}
	public ProductType(int id, String productTypeName) {
		super();
		this.id = id;
		this.productTypeName = productTypeName;
	}
	
	
	public ProductType(String productTypeName, String companyName) {
		super();
		this.productTypeName = productTypeName;
		this.companyName = companyName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Set<ProductInventory> getProductsList() {
		return productsList;
	}
	public void setProductsList(Set<ProductInventory> productsList) {
		this.productsList = productsList;
	}
	public ProductType(int id, String productTypeName, String companyName, Set<ProductInventory> productsList) {
		super();
		this.id = id;
		this.productTypeName = productTypeName;
		this.companyName = companyName;
		this.productsList = productsList;
	}
	
	
	
	

}
