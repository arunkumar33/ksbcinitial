package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="KARNumberCreation1")
public class KARNumberCreation {

	
	@Id
	@Column(name="SerialNumber")

	@GeneratedValue(strategy=GenerationType.AUTO )
	
	private int id;
	
	
	private String RegNumber;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRegNumber() {
		return RegNumber;
	}


	public void setRegNumber(String regNumber) {
		RegNumber = regNumber;
	}
}
