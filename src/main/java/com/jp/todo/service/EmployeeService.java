package com.jp.todo.service;

import java.util.List;

import com.jp.todo.bo.EmployeeBo;
import com.jp.todo.vo.EmployeeVo;

public interface EmployeeService {

	int createEmployee(EmployeeBo employeeBo, String profileImageName, String resumeFile);

	List<EmployeeVo> retriveEmployeeList();

	EmployeeVo retriveEmployeeBasedOnId(int employeeId);

	void updateEmployee(EmployeeBo employeeBo);

	void deleteEmployee(int employeeId);

	long retriveCount();

	List<EmployeeBo> retriveEmployeeByPagination(EmployeeBo employeeBo);

}
