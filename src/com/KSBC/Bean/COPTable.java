package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="COPTable")
public class COPTable {
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
	private String operator;
	private long KSBCCOPApplication;
	private long KSBCCOPFee;
	private long KSBCCOPLateFee;
	private long KSBCCOPRescFee;
	private long KSBCCOPMiscFee;
	private long KSBCCOPSeniorAdvc;
	private long ClosingFD;
	private long InterestONFD;
	private long Amount;
	public long getAmount() {
		return Amount;
	}
	public void setAmount(long amount) {
		Amount = amount;
	}
	public String getParticulars() {
		return Particulars;
	}
	public void setParticulars(String particulars) {
		Particulars = particulars;
	}
	private String Particulars;
	public long getKSBCCOPApplication() {
		return KSBCCOPApplication;
	}
	public void setKSBCCOPApplication(long kSBCCOPApplication) {
		KSBCCOPApplication = kSBCCOPApplication;
	}
	public long getKSBCCOPFee() {
		return KSBCCOPFee;
	}
	public void setKSBCCOPFee(long kSBCCOPFee) {
		KSBCCOPFee = kSBCCOPFee;
	}
	public long getKSBCCOPLateFee() {
		return KSBCCOPLateFee;
	}
	public void setKSBCCOPLateFee(long kSBCCOPLateFee) {
		KSBCCOPLateFee = kSBCCOPLateFee;
	}
	public long getKSBCCOPRescFee() {
		return KSBCCOPRescFee;
	}
	public void setKSBCCOPRescFee(long kSBCCOPRescFee) {
		KSBCCOPRescFee = kSBCCOPRescFee;
	}
	public long getKSBCCOPMiscFee() {
		return KSBCCOPMiscFee;
	}
	public void setKSBCCOPMiscFee(long kSBCCOPMiscFee) {
		KSBCCOPMiscFee = kSBCCOPMiscFee;
	}
	public long getKSBCCOPSeniorAdvc() {
		return KSBCCOPSeniorAdvc;
	}
	public void setKSBCCOPSeniorAdvc(long kSBCCOPSeniorAdvc) {
		KSBCCOPSeniorAdvc = kSBCCOPSeniorAdvc;
	}
	public String getPaymode() {
		return Paymode;
	}
	public void setPaymode(String paymode) {
		Paymode = paymode;
	}

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

	
	
	
	
	private java.sql.Timestamp ChallanCreatedDate;
	public java.sql.Timestamp getChallanCreatedDate() {
		return ChallanCreatedDate;
	}
	public void setChallanCreatedDate(java.sql.Timestamp challanCreatedDate) {
		ChallanCreatedDate = challanCreatedDate;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
