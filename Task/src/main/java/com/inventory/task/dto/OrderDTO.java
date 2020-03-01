package com.inventory.task.dto;

import java.util.LinkedHashSet;
import java.util.Set;

//this DTO deigned to be used in adding and updating of order functions
public class OrderDTO {
	private Integer id;
	private String orderDate;
	private Set<Integer> poductList=new LinkedHashSet<>();
   
	public OrderDTO() {}

	public OrderDTO(Integer id, String orderDate) {
		super();
		this.id = id;
		this.orderDate = orderDate;
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

	public Set<Integer> getPoductList() {
		return poductList;
	}

	public void setPoductList(Set<Integer> poductList) {
		this.poductList = poductList;
	}

	public OrderDTO(Integer id, String orderDate, Set<Integer> poductList) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.poductList = poductList;
	}
	
	
}

