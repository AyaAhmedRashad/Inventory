package com.inventory.task.dto;

public class paginationFilters {

	//this DTO designed to get parameters for pagination in criteria builder
	private Integer pageSize;
	private Integer pageNumber;
	
	public paginationFilters() {
		
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public paginationFilters(Integer pageSize, Integer pageNumber) {
		super();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}
	
	
	
}
