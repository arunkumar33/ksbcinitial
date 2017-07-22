package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FeeStructure")
public class FeeStructure {

	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int SerialNumber;
	
	private double ChangeOfStatus;
	private double NameChange;
	public double getChangeOfStatus() {
		return ChangeOfStatus;
	}
	public double getNameChange() {
		return NameChange;
	}
	public double getNomineeChange() {
		return NomineeChange;
	}
	public double getAddressChange() {
		return AddressChange;
	}
	public double getPayForduplicateCertificate() {
		return PayForduplicateCertificate;
	}
	private double NomineeChange;
	private double AddressChange;
	private double PayForduplicateCertificate;
	public int getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}
}
