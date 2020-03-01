package com.inventory.task.dto;

import java.util.LinkedHashSet;
import java.util.Set;

//this DTO designed to be used in get advice function as it casted to the required attributes need to be displayed
public class AdviceDisplayDTO {
	private Integer id;
	private String adviceDate;
	private Set<ProductInventoryDisplayDTO> poductList=new LinkedHashSet<>();
	
	public AdviceDisplayDTO() {}

	public AdviceDisplayDTO(Integer id, String adviceDate, Set<ProductInventoryDisplayDTO> poductList) {
		super();
		this.id = id;
		this.adviceDate = adviceDate;
		this.poductList = poductList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdviceDate() {
		return adviceDate;
	}

	public void setAdviceDate(String adviceDate) {
		this.adviceDate = adviceDate;
	}

	public Set<ProductInventoryDisplayDTO> getPoductList() {
		return poductList;
	}

	public void setPoductList(Set<ProductInventoryDisplayDTO> poductList) {
		this.poductList = poductList;
	}
	
	
}
