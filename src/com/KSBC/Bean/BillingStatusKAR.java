package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="BillingStatusKAR")
public class BillingStatusKAR {
	
	@Id
	@Column(name="EnrollmentID",nullable=false,unique=true)
	
	private String EnrollmentID;
	private String ReceiptTransactionID;
	private String WelfareFundInstallmentNo;
	private int FromYear;
	private int ToYear;
	public String getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(String enrollmentID) {
		EnrollmentID = enrollmentID;
	}
	public String getReceiptTransactionID() {
		return ReceiptTransactionID;
	}
	public void setReceiptTransactionID(String receiptTransactionID) {
		ReceiptTransactionID = receiptTransactionID;
	}
	public String getWelfareFundInstallmentNo() {
		return WelfareFundInstallmentNo;
	}
	public void setWelfareFundInstallmentNo(String welfareFundInstallmentNo) {
		WelfareFundInstallmentNo = welfareFundInstallmentNo;
	}
	public int getFromYear() {
		return FromYear;
	}
	public void setFromYear(int fromYear) {
		FromYear = fromYear;
	}
	public int getToYear() {
		return ToYear;
	}
	public void setToYear(int toYear) {
		ToYear = toYear;
	}
	public int getAmountPaidOn() {
		return AmountPaidOn;
	}
	public void setAmountPaidOn(int amountPaidOn) {
		AmountPaidOn = amountPaidOn;
	}
	public String getReceiptNo() {
		return ReceiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		ReceiptNo = receiptNo;
	}
	public String getReceiptDate() {
		return ReceiptDate;
	}
	public void setReceiptDate(String receiptDate) {
		ReceiptDate = receiptDate;
	}
	private int AmountPaidOn;
	private String ReceiptNo;
	private String ReceiptDate;

	
	
}
