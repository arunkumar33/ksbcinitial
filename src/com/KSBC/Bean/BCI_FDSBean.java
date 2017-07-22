package com.KSBC.Bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="BCI_FDSBean")
public class BCI_FDSBean {

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

	private int  BCISubscriptionLateFee ;
	private int   FDSDiffAmt;
	private int  BCISubscription ;
	public int getBCISubscriptionLateFee() {
		return BCISubscriptionLateFee;
	}
	public void setBCISubscriptionLateFee(int bCISubscriptionLateFee) {
		BCISubscriptionLateFee = bCISubscriptionLateFee;
	}
	public int getFDSDiffAmt() {
		return FDSDiffAmt;
	}
	public void setFDSDiffAmt(int fDSDiffAmt) {
		FDSDiffAmt = fDSDiffAmt;
	}
	public int getBCISubscription() {
		return BCISubscription;
	}
	public void setBCISubscription(int bCISubscription) {
		BCISubscription = bCISubscription;
	}
	public int getFDS() {
		return FDS;
	}
	public void setFDS(int fDS) {
		FDS = fDS;
	}
	public int getCostReceipt() {
		return CostReceipt;
	}
	public void setCostReceipt(int costReceipt) {
		CostReceipt = costReceipt;
	}
	public int getBCIReimbursmentOfSalaryDeduction() {
		return BCIReimbursmentOfSalaryDeduction;
	}
	public void setBCIReimbursmentOfSalaryDeduction(int bCIReimbursmentOfSalaryDeduction) {
		BCIReimbursmentOfSalaryDeduction = bCIReimbursmentOfSalaryDeduction;
	}
	public int getBCIInterestonFD() {
		return BCIInterestonFD;
	}
	public void setBCIInterestonFD(int bCIInterestonFD) {
		BCIInterestonFD = bCIInterestonFD;
	}
	public int getBCIClosingFD() {
		return BCIClosingFD;
	}
	public void setBCIClosingFD(int bCIClosingFD) {
		BCIClosingFD = bCIClosingFD;
	}
	public int getFDSInterestonFD() {
		return FDSInterestonFD;
	}
	public void setFDSInterestonFD(int fDSInterestonFD) {
		FDSInterestonFD = fDSInterestonFD;
	}
	public int getFDSClosingFD() {
		return FDSClosingFD;
	}
	public void setFDSClosingFD(int fDSClosingFD) {
		FDSClosingFD = fDSClosingFD;
	}
	
	public java.sql.Timestamp getChallanCreatedDate() {
		return ChallanCreatedDate;
	}
	public void setChallanCreatedDate(java.sql.Timestamp challanCreatedDate) {
		ChallanCreatedDate = challanCreatedDate;
	}

	private int  FDS ;
	private int  CostReceipt ;
	private int   BCIReimbursmentOfSalaryDeduction;
	private int   BCIInterestonFD;
	private int BCIClosingFD  ;
	private int  FDSInterestonFD ;
	private int  FDSClosingFD ;
	private java.sql.Timestamp ChallanCreatedDate;
	
}
