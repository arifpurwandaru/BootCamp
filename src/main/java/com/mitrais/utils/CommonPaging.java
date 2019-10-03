package com.mitrais.utils;

import java.util.List;

import org.springframework.data.domain.Page;

public class CommonPaging <T> {
	List<T> data;
	int page;
	int rowPerPage;
	long totalData;

	public CommonPaging() {
	}

	public CommonPaging(Page<T> paging) {
		this.page = paging.getNumber();
		this.rowPerPage = paging.getSize();
		this.totalData = paging.getTotalElements();
		this.data = paging.getContent();
	}

	public List<T> getData() {
		return this.data;
	}

	public int getPage() {
		return this.page;
	}

	public int getRowPerPage() {
		return this.rowPerPage;
	}

	public int getStartRow() {
		return this.page * this.rowPerPage;
	}

	public long getTotalData() {
		return this.totalData;
	}

	public long getTotalPage() {
		return (this.totalData - 1L) / (long) this.rowPerPage + 1L;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public void setTotalData(int totalData) {
		this.totalData = (long) totalData;
	}

}
