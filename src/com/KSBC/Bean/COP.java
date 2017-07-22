package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class COP {
	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long SerialNumber;

	public long getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}

	private long COPApplication;
	
	private String EnrollNo;
	private String place;
	private String Name;
	
	private String Paymode;
	
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getInterestONFD() {
		return InterestONFD;
	}
	public void setInterestONFD(long interestONFD) {
		InterestONFD = interestONFD;
	}
	public long getCOPApplication() {
		return COPApplication;
	}
	public void setCOPApplication(long cOPApplication) {
		COPApplication = cOPApplication;
	}
	public void setSerialNumber(long serialNumber) {
		SerialNumber = serialNumber;
	}
	private long ClosingFD;
	private long InterestONFD;
	private long COPApplicationFine;
	
	private java.sql.Timestamp ChallanCreatedDate;
	public java.sql.Timestamp getChallanCreatedDate() {
		return ChallanCreatedDate;
	}
	public void setChallanCreatedDate(java.sql.Timestamp challanCreatedDate) {
		ChallanCreatedDate = challanCreatedDate;
	}
	public long getCOPApplicationFine() {
		return COPApplicationFine;
	}
	public void setCOPApplicationFine(long cOPApplicationFine) {
		COPApplicationFine = cOPApplicationFine;
	}
	public long getClosingFD() {
		return ClosingFD;
	}
	public void setClosingFD(long closingFD) {
		ClosingFD = closingFD;
	}
	public String getEnrollNo() {
		return EnrollNo;
	}
	public void setEnrollNo(String enrollNo) {
		EnrollNo = enrollNo;
	}
	
}
