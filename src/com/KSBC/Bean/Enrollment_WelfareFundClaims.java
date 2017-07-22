package com.KSBC.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Enrollment_WelfareFundClaims")
public class Enrollment_WelfareFundClaims {

	@Id
	private String EnrollmentId;
	private java.sql.Timestamp EDate;
	private String ApplicantName;
	private java.math.BigDecimal ClaimAmount;
	private String Description;
	private String OrderNo;
	private java.sql.Timestamp OrderDate;
	private  java.sql.Timestamp DeathDate;
	private String City;
	private int State;
	private String Pincode;
	private java.sql.Timestamp RetirmentDate;
	private Short RetiredReason;
	private String status;
	private String PaidStatus;
	private java.sql.Timestamp  ApplicationDate;
	private String BCMResolutionNo;
	public String getEnrollmentId() {
		return EnrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		EnrollmentId = enrollmentId;
	}
	public java.sql.Timestamp getEDate() {
		return EDate;
	}
	public void setEDate(java.sql.Timestamp eDate) {
		EDate = eDate;
	}
	public String getApplicantName() {
		return ApplicantName;
	}
	public void setApplicantName(String applicantName) {
		ApplicantName = applicantName;
	}
	public java.math.BigDecimal getClaimAmount() {
		return ClaimAmount;
	}
	public void setClaimAmount(java.math.BigDecimal claimAmount) {
		ClaimAmount = claimAmount;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public java.sql.Timestamp getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(java.sql.Timestamp orderDate) {
		OrderDate = orderDate;
	}
	public java.sql.Timestamp getDeathDate() {
		return DeathDate;
	}
	public void setDeathDate(java.sql.Timestamp deathDate) {
		DeathDate = deathDate;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public int getState() {
		return State;
	}
	public void setState(int state) {
		State = state;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public java.sql.Timestamp getRetirmentDate() {
		return RetirmentDate;
	}
	public void setRetirmentDate(java.sql.Timestamp retirmentDate) {
		RetirmentDate = retirmentDate;
	}
	public Short getRetiredReason() {
		return RetiredReason;
	}
	public void setRetiredReason(Short retiredReason) {
		RetiredReason = retiredReason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaidStatus() {
		return PaidStatus;
	}
	public void setPaidStatus(String paidStatus) {
		PaidStatus = paidStatus;
	}
	public java.sql.Timestamp getApplicationDate() {
		return ApplicationDate;
	}
	public void setApplicationDate(java.sql.Timestamp applicationDate) {
		ApplicationDate = applicationDate;
	}
	public String getBCMResolutionNo() {
		return BCMResolutionNo;
	}
	public void setBCMResolutionNo(String bCMResolutionNo) {
		BCMResolutionNo = bCMResolutionNo;
	}
	public java.sql.Timestamp getBCMResolutionDate() {
		return BCMResolutionDate;
	}
	public void setBCMResolutionDate(java.sql.Timestamp bCMResolutionDate) {
		BCMResolutionDate = bCMResolutionDate;
	}
	private java.sql.Timestamp BCMResolutionDate;
}
