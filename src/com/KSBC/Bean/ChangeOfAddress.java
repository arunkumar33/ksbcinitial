package com.KSBC.Bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ChangeOfAddress")
public class ChangeOfAddress {


	@Id
	@Column(name="SLnumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SLnumber;
	
	private String KARNumber;
	private String Address;
	private String Name;
	private String PriviousName;
	private String PriviousAddress;
	private String operator;
	private String Type;
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	private Timestamp ChangedOn;
	private String Remarks;
	public int getSLnumber() {
		return SLnumber;
	}
	public void setSLnumber(int sLnumber) {
		SLnumber = sLnumber;
	}
	public String getKARNumber() {
		return KARNumber;
	}
	public void setKARNumber(String kARNumber) {
		KARNumber = kARNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPriviousName() {
		return PriviousName;
	}
	public void setPriviousName(String priviousName) {
		PriviousName = priviousName;
	}
	public String getPriviousAddress() {
		return PriviousAddress;
	}
	public void setPriviousAddress(String priviousAddress) {
		PriviousAddress = priviousAddress;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Timestamp getChangedOn() {
		return ChangedOn;
	}
	public void setChangedOn(Timestamp changedOn) {
		ChangedOn = changedOn;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	
	
}
