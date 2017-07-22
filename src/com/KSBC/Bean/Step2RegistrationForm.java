package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Step2RegistrationForm")
public class Step2RegistrationForm {
	@Id
	@Column(name="RegNumber",nullable=false,unique=true)
	private String RegNumber;
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
	private String PlaceOfPractice;
	

	public String getUniversity_Name() {
		return University_Name;
	}

	public void setUniversity_Name(String university_Name) {
		University_Name = university_Name;
	}

	public String getPlaceOfPractice() {
		return PlaceOfPractice;
	}

	public void setPlaceOfPractice(String placeOfPractice) {
		PlaceOfPractice = placeOfPractice;
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

	public String getRegNumber() {
		return RegNumber;
	}

	public void setRegNumber(String regNumber) {
		RegNumber = regNumber;
	}
}
