package com.KSBC.Bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="KAWFLateWelfareFundBeanTable")


public class KAWFLateWelfareFundBean {
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
	
private int KAWFMembershipFee;
private int WFMembershipLateFee;



private java.sql.Timestamp ChallanCreatedDate;
public java.sql.Timestamp getChallanCreatedDate() {
	return ChallanCreatedDate;
}
public void setChallanCreatedDate(java.sql.Timestamp challanCreatedDate) {
	ChallanCreatedDate = challanCreatedDate;
}
	



public int getKAWFMembershipFee() {
	return KAWFMembershipFee;
}
public void setKAWFMembershipFee(int kAWFMembershipFee) {
	KAWFMembershipFee = kAWFMembershipFee;
}
public int getWFMembershipLateFee() {
	return WFMembershipLateFee;
}
public void setWFMembershipLateFee(int wFMembershipLateFee) {
	WFMembershipLateFee = wFMembershipLateFee;
}
}
