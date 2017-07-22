package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DC_Committee")
public class DC_Committee {
	@Id
	
private String complaintNumber;
	private String Name;
	private String AgainstAdvocate;
	private String Place;
	private String Remarks;
	private String Reason;
	private java.sql.Timestamp CaseDate;
	private Long ComplaintPhoneNumber;
	private Long AgainstAdvocatePhoneNumber;
	private String CaseDetails;


	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAgainstAdvocate() {
		return AgainstAdvocate;
	}
	public void setAgainstAdvocate(String againstAdvocate) {
		AgainstAdvocate = againstAdvocate;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public java.sql.Timestamp getCaseDate() {
		return CaseDate;
	}
	public void setCaseDate(java.sql.Timestamp caseDate) {
		CaseDate = caseDate;
	}
	public Long getComplaintPhoneNumber() {
		return ComplaintPhoneNumber;
	}
	public void setComplaintPhoneNumber(Long complaintPhoneNumber) {
		ComplaintPhoneNumber = complaintPhoneNumber;
	}
	public Long getAgainstAdvocatePhoneNumber() {
		return AgainstAdvocatePhoneNumber;
	}
	public void setAgainstAdvocatePhoneNumber(Long againstAdvocatePhoneNumber) {
		AgainstAdvocatePhoneNumber = againstAdvocatePhoneNumber;
	}
	public String getCaseDetails() {
		return CaseDetails;
	}
	public void setCaseDetails(String caseDetails) {
		CaseDetails = caseDetails;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getComplaintNumber() {
		return complaintNumber;
	}
	public void setComplaintNumber(String complaintNumber) {
		this.complaintNumber = complaintNumber;
	}
	
	
}
