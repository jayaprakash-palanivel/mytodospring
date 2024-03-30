package com.jp.todo.dao;

import java.util.List;

import com.jp.todo.bo.EmployeeBo;
import com.jp.todo.vo.EmployeeVo;

public interface EmployeeDao {

	EmployeeVo createEmployee(EmployeeVo employeeVo);

	List<EmployeeVo> retriveEmployeeList();

	EmployeeVo retriveEmployeeBasedOnId(int employeeId);

	void updateEmployee(EmployeeVo employeeVo);

	void deleteEmployee(int employeeId);

	long retriveCount();

	List<EmployeeVo> retriveEmployeeByPagination(EmployeeBo employeeBo);

}
