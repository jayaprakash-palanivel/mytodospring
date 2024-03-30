package com.jp.todo.utils;

import java.util.ArrayList;
import java.util.List;

import com.jp.todo.bo.EmployeeBo;
import com.jp.todo.bo.PaginationBo;

public class PaginationClass {

	public static PaginationBo paginationLimitedRecords(int page, int maxRecord, long totalEmployeeCount,
			List<?> employeeLists) {
	
		long recordsPerPage = maxRecord;
		long noOfRecords = (long) totalEmployeeCount;
		long pageLinkLimit = 1;
		List<Long> noOfPages = new ArrayList<Long>();

		PaginationBo po = new PaginationBo();
		po.setListSize(totalEmployeeCount);
		po.setCurrentPage(page);
		long tempPages = (long) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		for (long i = (page > 7 ? (page < (tempPages - 8) ? (page - 5)
				: ((page - 9) <= 0 ? 1 : (tempPages - 9))) : 1); i <= tempPages; i++) {
			noOfPages.add(i);
			pageLinkLimit++;
			if (pageLinkLimit > 10) {
				break;
			}
		}
		po.setNoOfPages(noOfPages);
		po.setTotalPages(tempPages);
		po.setLastRecordValue(tempPages);
		List list =  (List<Object>) employeeLists;
		po.setList(list);
		return po;
	}

}
