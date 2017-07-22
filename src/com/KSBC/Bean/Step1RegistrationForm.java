package com.KSBC.Bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Step1RegistrationForm")
public class Step1RegistrationForm {
	@Id
	@Column(name="RegNumber",nullable=false,unique=true)
	private String RegNumber;
private String first_name;
private String Father_name;
private String email;
private long phone;
private String address;
private String state;
private int ZipCode;
private String CastCategory;
private String BloodGroup;
private String GenderCategory;
public String getCastCategory() {
	return CastCategory;
}

public void setCastCategory(String castCategory) {
	CastCategory = castCategory;
}

public String getGenderCategory() {
	return GenderCategory;
}

public void setGenderCategory(String genderCategory) {
	GenderCategory = genderCategory;
}

private Date birthdate;
private String city;
private String CitizenOfIndia;
private String NotAnClitizen;

	public String getNotAnClitizen() {
	return NotAnClitizen;
}

public void setNotAnClitizen(String notAnClitizen) {
	NotAnClitizen = notAnClitizen;
}

	public String getCitizenOfIndia() {
	return CitizenOfIndia;
}

public void setCitizenOfIndia(String citizenOfIndia) {
	CitizenOfIndia = citizenOfIndia;
}

	public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

	public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getFather_name() {
	return Father_name;
}

public void setFather_name(String father_name) {
	Father_name = father_name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public long getPhone() {
	return phone;
}

public void setPhone(long phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public int getZipCode() {
	return ZipCode;
}

public void setZipCode(int zipCode) {
	ZipCode = zipCode;
}

public String getBloodGroup() {
	return BloodGroup;
}

public void setBloodGroup(String bloodGroup) {
	BloodGroup = bloodGroup;
}

public Date getBirthdate() {
	return birthdate;
}

public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}

	public String getRegNumber() {
		return RegNumber;
	}

	public void setRegNumber(String regNumber) {
		RegNumber = regNumber;
	}
}
