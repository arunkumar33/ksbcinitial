package com.KSBC.Bean;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class CompositeKeyOfEnrollmentWelfarePayment implements Serializable {
	public String getEnrollmentId() {
		return EnrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		EnrollmentId = enrollmentId;
	}
	public String getReceiptTransactionId() {
		return ReceiptTransactionId;
	}
	public void setReceiptTransactionId(String receiptTransactionId) {
		ReceiptTransactionId = receiptTransactionId;
	}
	public int getWelfareFundInstallmentNo() {
		return WelfareFundInstallmentNo;
	}
	public void setWelfareFundInstallmentNo(int welfareFundInstallmentNo) {
		WelfareFundInstallmentNo = welfareFundInstallmentNo;
	}
	private String EnrollmentId;
	private String ReceiptTransactionId;
	private int WelfareFundInstallmentNo;
}
