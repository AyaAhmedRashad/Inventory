package com.inventory.task.dto;

import java.util.LinkedHashSet;
import java.util.Set;

//this DTO designed to be used in get order function as it casted to the required attributes need to be displayed
public class OrderDisplayDTO {
	private Integer id;
	private String orderDate;
	private Set<ProductInventoryDisplayDTO> poductList=new LinkedHashSet<>();
	
	public OrderDisplayDTO() {}
	public OrderDisplayDTO(Integer id, String orderDate, Set<ProductInventoryDisplayDTO> poductList) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.poductList = poductList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Set<ProductInventoryDisplayDTO> getPoductList() {
		return poductList;
	}
	public void setPoductList(Set<ProductInventoryDisplayDTO> poductList) {
		this.poductList = poductList;
	}
	
}
