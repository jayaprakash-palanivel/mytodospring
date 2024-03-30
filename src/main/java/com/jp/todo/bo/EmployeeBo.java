package com.jp.todo.bo;

public class EmployeeBo {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private Long mobileNumber;
	private String address;
	private String city;
	private String state;
	private String country;
	private boolean isDelete;
	private int startingRecordIndex ;
	private int maxRecord ;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public int getStartingRecordIndex() {
		return startingRecordIndex;
	}
	public void setStartingRecordIndex(int startingRecordIndex) {
		this.startingRecordIndex = startingRecordIndex;
	}
	public int getMaxRecord() {
		return maxRecord;
	}
	public void setMaxRecord(int maxRecord) {
		this.maxRecord = maxRecord;
	}
	
}
