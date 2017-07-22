package com.KSBC.Bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="AssociationStampBean")


	



	

public class AssociationStampBean {


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

	private int Stampfee;
	public int getStampfee() {
		return Stampfee;
	}
	public void setStampfee(int stampfee) {
		Stampfee = stampfee;
	}
	public int getPostalCharges() {
		return PostalCharges;
	}
	public void setPostalCharges(int postalCharges) {
		PostalCharges = postalCharges;
	}
	private int PostalCharges;
	
	private java.sql.Timestamp ChallanCreatedDate;
	public java.sql.Timestamp getChallanCreatedDate() {
		return ChallanCreatedDate;
	}
	public void setChallanCreatedDate(java.sql.Timestamp challanCreatedDate) {
		ChallanCreatedDate = challanCreatedDate;
	}
		
}
