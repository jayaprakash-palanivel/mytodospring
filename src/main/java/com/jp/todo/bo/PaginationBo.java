package com.jp.todo.bo;

import java.util.List;

public class PaginationBo<T> {
	private long totalPages;
	private long currentPage;
	private int recordsPerPage;
	private long totalRecords;
	private long records;
	private long start;
	private long page;
	private long listSize;
	private List<Long> noOfPages;
	private long lastRecordValue;
	private List<T> list;

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getListSize() {
		return listSize;
	}

	public void setListSize(long listSize) {
		this.listSize = listSize;
	}

	public List<Long> getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(List<Long> noOfPages) {
		this.noOfPages = noOfPages;
	}

	public long getLastRecordValue() {
		return lastRecordValue;
	}

	public void setLastRecordValue(long lastRecordValue) {
		this.lastRecordValue = lastRecordValue;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}
