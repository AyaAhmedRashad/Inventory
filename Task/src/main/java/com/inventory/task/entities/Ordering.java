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
@Table(name="ordering")
public class Ordering {
	//this entity define the Ordering attributes so that any new order should have this attributes

	
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	@OneToMany(mappedBy = "orderId", cascade = {CascadeType.ALL})
	private Set<ProductInventory> productsList = new LinkedHashSet<>(); //this is the list of products related to this order
	
	
	public Ordering() {}


	public Ordering(int id, Date orderDate, Set<ProductInventory> productsList) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.productsList = productsList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Set<ProductInventory> getProductsList() {
		return productsList;
	}


	public void setProductsList(Set<ProductInventory> productsList) {
		this.productsList = productsList;
	}
	

}
