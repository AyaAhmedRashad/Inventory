package com.inventory.task.dto;

import java.util.LinkedHashSet;
import java.util.Set;
//this DTO deigned to be used in adding and updating of advice functions
public class AdviceDTO {
private Integer id;
private String adviceDate;
private Set<ProductInventoryDTO> poductList=new LinkedHashSet<>();

public AdviceDTO() {
	
}

public AdviceDTO(Integer id, String adviceDate) {
	super();
	this.id = id;
	this.adviceDate = adviceDate;
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

public Set<ProductInventoryDTO> getPoductList() {
	return poductList;
}

public void setPoductList(Set<ProductInventoryDTO> poductList) {
	this.poductList = poductList;
}

public AdviceDTO(Integer id, String adviceDate, Set<ProductInventoryDTO> poductList) {
	super();
	this.id = id;
	this.adviceDate = adviceDate;
	this.poductList = poductList;
}


}
