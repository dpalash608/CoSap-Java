package com.cosap.cosap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vaccine_pojo {
	
	
	@Id
	private String Date;
	@Column
	private String AgeGrp;
	//A for less than 18 , B for 18-45 ,C for 45+
	@Column
	private String Stock;
	

	public Vaccine_pojo() {
	}

	public Vaccine_pojo(String date, String ageGrp, String stock) {
		this.Date = date;
		this.AgeGrp = ageGrp;
		this.Stock = stock;
	}
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	public String getAgeGrp() {
		return AgeGrp;
	}
	public void setAgeGrp(String ageGrp) {
		this.AgeGrp = ageGrp;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		this.Stock = stock;
	}
}
