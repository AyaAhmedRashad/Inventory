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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="packaging")
public class Packaging {
	//this entity define the packaging attributes so that any new package should have this attributes
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "PACKAGE_NAME", nullable = false)
	private String packageName;
	@Column(name = "PACKAGE_QUANTITY", nullable = false)
	private int packageQuantity;
	@Column(name = "PACKAGE_TYPE", nullable = false)
	private int packageType;
	@OneToMany(mappedBy = "packageId", cascade = {CascadeType.ALL})
	private Set<ProductInventory> productsList = new LinkedHashSet<>(); //this is the list of products related to this package
	
	public Packaging() {}
	
	public Packaging(int id, String packageName, int packageQuantity, int packageType) {
		super();
		this.id = id;
		this.packageName = packageName;
		this.packageQuantity = packageQuantity;
		this.packageType = packageType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public int getPackageQuantity() {
		return packageQuantity;
	}
	public void setPackageQuantity(int packageQuantity) {
		this.packageQuantity = packageQuantity;
	}
	public int getPackageType() {
		return packageType;
	}
	public void setPackageType(int packageType) {
		this.packageType = packageType;
	}

	public Packaging(String packageName, int packageQuantity, int packageType) {
		super();
		this.packageName = packageName;
		this.packageQuantity = packageQuantity;
		this.packageType = packageType;
	}

	public Set<ProductInventory> getProductsList() {
		return productsList;
	}

	public void setProductsList(Set<ProductInventory> productsList) {
		this.productsList = productsList;
	}

	public Packaging(int id, String packageName, int packageQuantity, int packageType,
			Set<ProductInventory> productsList) {
		super();
		this.id = id;
		this.packageName = packageName;
		this.packageQuantity = packageQuantity;
		this.packageType = packageType;
		this.productsList = productsList;
	}
	
	
	
}
