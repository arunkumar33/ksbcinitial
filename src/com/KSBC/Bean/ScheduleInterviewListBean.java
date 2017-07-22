package com.KSBC.Bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ScheduleInterviewListBean")
public class ScheduleInterviewListBean {
	public String getRegNumber() {
		return RegNumber;
	}
	public void setRegNumber(String regNumber) {
		RegNumber = regNumber;
	}
	public String getFirst_name() {
		return first_name;
	}
	
private String CastCategory;
	
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

	private String GenderCategory;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCitizenOfIndia() {
		return CitizenOfIndia;
	}
	public void setCitizenOfIndia(String citizenOfIndia) {
		CitizenOfIndia = citizenOfIndia;
	}
	public String getNotAnClitizen() {
		return NotAnClitizen;
	}
	public void setNotAnClitizen(String notAnClitizen) {
		NotAnClitizen = notAnClitizen;
	}
	public String getUniversity_Name() {
		return University_Name;
	}
	public void setUniversity_Name(String university_Name) {
		University_Name = university_Name;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public int getYear_of_Completion() {
		return year_of_Completion;
	}
	public void setYear_of_Completion(int year_of_Completion) {
		this.year_of_Completion = year_of_Completion;
	}
	public String getYear_course() {
		return Year_course;
	}
	public void setYear_course(String year_course) {
		Year_course = year_course;
	}
	public String getOtherProfessional() {
		return OtherProfessional;
	}
	public void setOtherProfessional(String otherProfessional) {
		OtherProfessional = otherProfessional;
	}
	public String getPreviousApplicationDetails() {
		return PreviousApplicationDetails;
	}
	public void setPreviousApplicationDetails(String previousApplicationDetails) {
		PreviousApplicationDetails = previousApplicationDetails;
	}
	public String getBusinessDetails() {
		return BusinessDetails;
	}
	public void setBusinessDetails(String businessDetails) {
		BusinessDetails = businessDetails;
	}
	public String getTerminatedDetails() {
		return terminatedDetails;
	}
	public void setTerminatedDetails(String terminatedDetails) {
		this.terminatedDetails = terminatedDetails;
	}
	public String getConvictedDetails() {
		return convictedDetails;
	}
	public void setConvictedDetails(String convictedDetails) {
		this.convictedDetails = convictedDetails;
	}
	public String getPendingCriminalCases() {
		return PendingCriminalCases;
	}
	public void setPendingCriminalCases(String pendingCriminalCases) {
		PendingCriminalCases = pendingCriminalCases;
	}
	public String getPlaceOfPracticeFromStep2() {
		return PlaceOfPracticeFromStep2;
	}
	public void setPlaceOfPracticeFromStep2(String placeOfPracticeFromStep2) {
		PlaceOfPracticeFromStep2 = placeOfPracticeFromStep2;
	}
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
	public String getAddressFromStep3() {
		return AddressFromStep3;
	}
	public void setAddressFromStep3(String addressFromStep3) {
		AddressFromStep3 = addressFromStep3;
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
	private String BloodGroup;
	private Date birthdate;
	private String city;
	private String CitizenOfIndia;
	private String NotAnClitizen;
	/*From Form2*/
	private String University_Name;
	private String College;
	private int year_of_Completion;
	private String Year_course;
	private String OtherProfessional;
	private String PreviousApplicationDetails;
	private String BusinessDetails;
	private String terminatedDetails;
	private String convictedDetails;
	private String PendingCriminalCases;
	private String PlaceOfPracticeFromStep2;

	/*Form3*/

	private String FullName;
	private String PlaceOfPractice;
	private String AddressFromStep3;
	
	private String discontinuanceOfPractice;
	private String PreviousEmployment;
	private String nomineeDetails;
	private String ProportionOfShare;
	
}
