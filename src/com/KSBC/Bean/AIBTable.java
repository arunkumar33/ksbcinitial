package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="AIBTable")
public class AIBTable {
	

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
	public String getAIBRemarks() {
		return AIBRemarks;
	}
	public void setAIBRemarks(String aIBRemarks) {
		AIBRemarks = aIBRemarks;
	}
	public String getAIBdate() {
		return AIBdate;
	}
	public void setAIBdate(String aIBdate) {
		AIBdate = aIBdate;
	}
	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SerialNumber;
public String KARNumber;
public String AIBRemarks;
public String AIBdate;
}
