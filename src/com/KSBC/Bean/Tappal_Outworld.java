package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Tappal_Outworld")
public class Tappal_Outworld {
	public int getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SerialNumber;
private String Name;
private String Address;
private String particular;
private String Remarks;
private String OutworldNumber;
private Long PostalCharge;
private java.sql.Timestamp OutWorldDate;
public String getOutworldNumber() {
	return OutworldNumber;
}
public void setOutworldNumber(String outworldNumber) {
	OutworldNumber = outworldNumber;
}
public Long getPostalCharge() {
	return PostalCharge;
}
public void setPostalCharge(Long postalCharge) {
	PostalCharge = postalCharge;
}
public java.sql.Timestamp getOutWorldDate() {
	return OutWorldDate;
}
public void setOutWorldDate(java.sql.Timestamp outWorldDate) {
	OutWorldDate = outWorldDate;
}
}
