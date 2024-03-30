package com.jp.todo.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class LoginVo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loginId;
	private String userName;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private EmployeeVo employee;
	
	@OneToOne
	private RoleVo role;
	
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeVo getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeVo employee) {
		this.employee = employee;
	}
	public RoleVo getRole() {
		return role;
	}
	public void setRole(RoleVo role) {
		this.role = role;
	}
	

}
