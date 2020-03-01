package com.inventory.task.entities;

import java.util.Date;
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
@Table(name="advice")
public class Advice {
	//this entity define the device attributes so that any new device should have this attributes
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "ADVICE_DATE")
	private Date adviceDate;
	
	@OneToMany(mappedBy = "adviceId", cascade = {CascadeType.ALL})
	private Set<ProductInventory> productsList = new LinkedHashSet<>(); //this is the list of products related to this device
	
	
	public Advice() {}


	public Advice(int id, Date adviceDate, Set<ProductInventory> productsList) {
		super();
		this.id = id;
		this.adviceDate = adviceDate;
		this.productsList = productsList;
	}

	public Advice(int id, Date adviceDate) {
		super();
		this.id = id;
		this.adviceDate = adviceDate;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getAdviceDate() {
		return adviceDate;
	}


	public void setAdviceDate(Date adviceDate) {
		this.adviceDate = adviceDate;
	}


	public Set<ProductInventory> getProductsList() {
		return productsList;
	}


	public void setProductsList(Set<ProductInventory> productsList) {
		this.productsList = productsList;
	}
	
	
	
}
