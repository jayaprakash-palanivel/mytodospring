package com.jp.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.todo.bo.EmployeeBo;
import com.jp.todo.dao.EmployeeDao;
import com.jp.todo.model.EmailModel;
import com.jp.todo.utils.SendEmailService;
import com.jp.todo.vo.EmployeeVo;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	SendEmailService sendEmailService;

	EmailModel model = new EmailModel();

	@Override
	public int createEmployee(EmployeeBo employeeBo, String profileImageName, String resumeFile) {
		EmployeeVo employeeVo = new EmployeeVo();
		employeeVo.setFirstName(employeeBo.getFirstName());
		employeeVo.setLastName(employeeBo.getLastName());
		employeeVo.setEmailId(employeeBo.getEmailId());
		employeeVo.setPassword(employeeBo.getPassword());
		employeeVo.setMobileNumber(employeeBo.getMobileNumber());
		employeeVo.setAddress(employeeBo.getAddress());
		employeeVo.setCity(employeeBo.getCity());
		employeeVo.setCountry(employeeBo.getCountry());
		employeeVo.setState(employeeBo.getState());
		employeeVo.setIsDelete(false);

		// file and image
		employeeVo.setProfileImage(profileImageName);
		employeeVo.setResume(resumeFile);

		EmployeeVo employee = employeeDao.createEmployee(employeeVo);
		// email code

		/*
		 * if (null != employee && 0 < employee.getEmployeeId()) { String
		 * toaddress=employee.getEmailId(); String bodyContent="Employee Registration";
		 * String subject = "Employee Registration Details!";
		 * model.setEmailId(employee.getEmailId());
		 * model.setPhoneNumber(employee.getMobileNumber());
		 * model.setUserName(employee.getFirstName());
		 * model.setPassword(employee.getPassword());
		 * 
		 * String success =
		 * sendEmailService.sendEmployeeRegisterEmail(toaddress,bodyContent,subject,
		 * model); System.out.println(success); }
		 */
		return employee.getEmployeeId();
	}

	@Override
	public List<EmployeeVo> retriveEmployeeList() {

		return employeeDao.retriveEmployeeList();
	}

	@Override
	public EmployeeVo retriveEmployeeBasedOnId(int employeeId) {
		return employeeDao.retriveEmployeeBasedOnId(employeeId);
	}

	@Override
	public void updateEmployee(EmployeeBo employeeBo) {
		EmployeeVo employeeVo = new EmployeeVo();
		employeeVo.setEmployeeId(employeeBo.getEmployeeId());
		employeeVo.setFirstName(employeeBo.getFirstName());
		employeeVo.setLastName(employeeBo.getLastName());
		employeeVo.setEmailId(employeeBo.getEmailId());
		employeeVo.setPassword(employeeBo.getPassword());
		employeeVo.setMobileNumber(employeeBo.getMobileNumber());
		employeeVo.setAddress(employeeBo.getAddress());
		employeeVo.setCity(employeeBo.getCity());
		employeeVo.setCountry(employeeBo.getCountry());
		employeeVo.setState(employeeBo.getState());

		employeeDao.updateEmployee(employeeVo);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);

	}

	@Override
	public long retriveCount() {
		// TODO Auto-generated method stub
		return employeeDao.retriveCount();
	}

	@Override
	public List<EmployeeBo> retriveEmployeeByPagination(EmployeeBo employeeBo) {
		List<EmployeeBo> employeeList = new ArrayList<EmployeeBo>();
		List<EmployeeVo> employeeVo = employeeDao.retriveEmployeeByPagination(employeeBo);
		for (EmployeeVo e : employeeVo) {
			EmployeeBo employee = new EmployeeBo();
			employee.setEmployeeId(e.getEmployeeId());
			employee.setFirstName(e.getFirstName());
			employee.setLastName(e.getLastName());
			employee.setEmailId(e.getEmailId());
			employee.setPassword(e.getPassword());
			employee.setMobileNumber(e.getMobileNumber());
			employee.setAddress(e.getAddress());
			employee.setCity(e.getCity());
			employee.setCountry(e.getCountry());
			employee.setState(e.getState());

			employeeList.add(employee);
		}
		return employeeList;
	}

}
