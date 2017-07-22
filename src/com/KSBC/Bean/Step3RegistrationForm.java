package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Step3RegistrationForm")
public class Step3RegistrationForm {
	@Id
	@Column(name="RegNumber",nullable=false,unique=true)
	private String RegNumber;
private String FullName;
private String PlaceOfPractice;
private String Address;
private String discontinuanceOfPractice;
private String PreviousEmployment;
private String nomineeDetails;
private String ProportionOfShare;
	public String getFullName() {
	return FullName;
}

public void setFullName(String fullName) {
	FullName = fullName;
}

public String getPlaceOfPractice() {
	return PlaceOfPractice;
}

public void setPlaceOfPractice(String placeOfPractice) {
	PlaceOfPractice = placeOfPractice;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public String getDiscontinuanceOfPractice() {
	return discontinuanceOfPractice;
}

public void setDiscontinuanceOfPractice(String discontinuanceOfPractice) {
	this.discontinuanceOfPractice = discontinuanceOfPractice;
}

public String getPreviousEmployment() {
	return PreviousEmployment;
}

public void setPreviousEmployment(String previousEmployment) {
	PreviousEmployment = previousEmployment;
}

public String getNomineeDetails() {
	return nomineeDetails;
}

public void setNomineeDetails(String nomineeDetails) {
	this.nomineeDetails = nomineeDetails;
}

public String getProportionOfShare() {
	return ProportionOfShare;
}

public void setProportionOfShare(String proportionOfShare) {
	ProportionOfShare = proportionOfShare;
}

	public String getRegNumber() {
		return RegNumber;
	}

	public void setRegNumber(String regNumber) {
		RegNumber = regNumber;
	}
}
