package com.cosap.cosap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee_pojo {
	
	
	@Id
	private String iNumber;

	@Column
	private String EmpName;

	@Column
	private String EmpMail;

	@Column
	private String EmpContact;
	
	@Column
	private String password;
	
	public Employee_pojo() {
	}

	public Employee_pojo(String iNumber, String empName, String empMail, String empContact,String password) {
		this.iNumber = iNumber;
		this.EmpName = empName;
		this.EmpMail = empMail;
		this.EmpContact = empContact;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getiNumber() {
		return iNumber;
	}

	public void setiNumber(String iNumber) {
		this.iNumber = iNumber;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		this.EmpName = empName;
	}

	public String getEmpMail() {
		return EmpMail;
	}

	public void setEmpMail(String empMail) {
		this.EmpMail = empMail;
	}

	public String getEmpContact() {
		return EmpContact;
	}

	public void setEmpContact(String empContact) {
		this.EmpContact = empContact;
	}
	


}
