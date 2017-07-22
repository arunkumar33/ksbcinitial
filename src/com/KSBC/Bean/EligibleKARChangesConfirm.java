package com.KSBC.Bean;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name="EligibleKARChangesConfirm")
public class EligibleKARChangesConfirm {

	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SerialNumber;
	
	private Date RequestCompletedDate;
	@Column(name="KARNumber")
	private String KARNumber;
	
	private String PayingFor;

	public int getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}

	public String getKARNumber() {
		return KARNumber;
	}

	public void setKARNumber(String kARNumber) {
		KARNumber = kARNumber;
	}

	public String getPayingFor() {
		return PayingFor;
	}

	public void setPayingFor(String payingFor) {
		PayingFor = payingFor;
	}
	
	@Column(name="PayedChallan")
    @Lob
	private Blob PayedChallan;

	public Blob getPayedChallan() {
		return PayedChallan;
	}

	public void setPayedChallan(Blob payedChallan) {
		PayedChallan = payedChallan;
	}

	public Date getRequestCompletedDate() {
		return RequestCompletedDate;
	}

	public void setRequestCompletedDate(Date requestCompletedDate) {
		RequestCompletedDate = requestCompletedDate;
	}
	
}
