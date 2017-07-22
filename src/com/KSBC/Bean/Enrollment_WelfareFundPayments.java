package com.KSBC.Bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Enrollment_WelfareFundPayments")
public class Enrollment_WelfareFundPayments {	
	 @EmbeddedId
	
	private CompositeKeyOfEnrollmentWelfarePayment id;
	private int FromYear;
	private int ToYear;
	private BigDecimal AmountPaid;
	
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
	public java.sql.Timestamp getAmountPaidOn() {
		return AmountPaidOn;
	}
	public void setAmountPaidOn(java.sql.Timestamp amountPaidOn) {
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
	public BigDecimal getAmountPaid() {
		return AmountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
		AmountPaid = amountPaid;
	}
	private java.sql.Timestamp AmountPaidOn;
	private String ReceiptNo;
	private String ReceiptDate;

	
}
