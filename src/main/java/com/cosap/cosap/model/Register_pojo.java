package com.cosap.cosap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Register_pojo {

	@Id
	private String inumber;
	@Column
	private String agegrp;
	//A for less than 18 , B for 18-45 ,C for 45+
	@Column
	private String date;
	
	@Column
	private String status;
	
	public Register_pojo() {
	}
	
	public Register_pojo(String inumber, String agegrp, String date, String status) {
		this.inumber = inumber;
		this.agegrp = agegrp;
		this.date = date;
		this.status = status;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInumber() {
		return inumber;
	}
	public void setInumber(String inumber) {
		this.inumber = inumber;
	}
	public String getAgegrp() {
		return agegrp;
	}
	public void setAgegrp(String agegrp) {
		this.agegrp = agegrp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
