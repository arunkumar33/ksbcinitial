package com.KSBC.Bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SeniorAdvocateTable")



public class SeniorAdvocateTable {
	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SerialNumber;

	public int getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}
	private String EnrollNo;
	private String place;
	private Date ChallanCreatedDate;
	private String Name;
	
	private String operator;
	private long amount;
	private long YearOfPayed;

	public String getEnrollNo() {
		return EnrollNo;
	}
	public void setEnrollNo(String enrollNo) {
		EnrollNo = enrollNo;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getChallanCreatedDate() {
		return ChallanCreatedDate;
	}
	public void setChallanCreatedDate(Date challanCreatedDate) {
		ChallanCreatedDate = challanCreatedDate;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getYearOfPayed() {
		return YearOfPayed;
	}
	public void setYearOfPayed(long yearOfPayed) {
		YearOfPayed = yearOfPayed;
	}
}
