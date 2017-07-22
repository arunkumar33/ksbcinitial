package com.KSBC.Bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="EnrollmentNewMemberBean")



	

public class EnrollmentNewMemberBean {
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

	private int EnrollmentFee;
	private int IdentityCard;
	private int miscRts;
	private int KsbcTrust;
	private int KawfMembershipFee;
	private int BciSubscription;
	private int fds;
	
	private int CertificateVerificationFee;


	
	public int getEnrollmentFee() {
		return EnrollmentFee;
	}
	public void setEnrollmentFee(int enrollmentFee) {
		EnrollmentFee = enrollmentFee;
	}
	public int getIdentityCard() {
		return IdentityCard;
	}
	public void setIdentityCard(int identityCard) {
		IdentityCard = identityCard;
	}
	public int getMiscRts() {
		return miscRts;
	}
	public void setMiscRts(int miscRts) {
		this.miscRts = miscRts;
	}
	public int getKsbcTrust() {
		return KsbcTrust;
	}
	public void setKsbcTrust(int ksbcTrust) {
		KsbcTrust = ksbcTrust;
	}
	public int getKawfMembershipFee() {
		return KawfMembershipFee;
	}
	public void setKawfMembershipFee(int kawfMembershipFee) {
		KawfMembershipFee = kawfMembershipFee;
	}
	public int getBciSubscription() {
		return BciSubscription;
	}
	public void setBciSubscription(int bciSubscription) {
		BciSubscription = bciSubscription;
	}
	public int getFds() {
		return fds;
	}
	public void setFds(int fds) {
		this.fds = fds;
	}
	
	private java.sql.Timestamp ChallanCreatedDate;
	public java.sql.Timestamp getChallanCreatedDate() {
		return ChallanCreatedDate;
	}
	public void setChallanCreatedDate(java.sql.Timestamp challanCreatedDate) {
		ChallanCreatedDate = challanCreatedDate;
	}
	public int getCertificateVerificationFee() {
		return CertificateVerificationFee;
	}
	public void setCertificateVerificationFee(int certificateVerificationFee) {
		CertificateVerificationFee = certificateVerificationFee;
	}
		
	
}
