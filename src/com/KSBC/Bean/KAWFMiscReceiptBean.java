package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="KAWFMiscReceiptBean")

public class KAWFMiscReceiptBean {
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

private int KawfSubscription ;
private int SeniorAdvocateContribution;
private int ChangeofNominee;
private int DuplicateCertificate;
private int WelfareFundCostReceipts;
private int donation;
private int subscriptionLateFee;
private int seniorAdvocateLateFee;
private int WFReimbursmentOfsalaryDeduction;
private int WelfareFundInterestOnFD;
private int WelfareFundClosingFD;
private int SaleofStampAmount;
private int LifeMembershipFee;
private int Govtgrant;
private int Miscellaneous;



private java.sql.Timestamp ChallanCreatedDate;
public java.sql.Timestamp getChallanCreatedDate() {
	return ChallanCreatedDate;
}
public void setChallanCreatedDate(java.sql.Timestamp challanCreatedDate) {
	ChallanCreatedDate = challanCreatedDate;
}


public int getKawfSubscription() {
	return KawfSubscription;
}
public void setKawfSubscription(int kawfSubscription) {
	KawfSubscription = kawfSubscription;
}
public int getSeniorAdvocateContribution() {
	return SeniorAdvocateContribution;
}
public void setSeniorAdvocateContribution(int seniorAdvocateContribution) {
	SeniorAdvocateContribution = seniorAdvocateContribution;
}
public int getChangeofNominee() {
	return ChangeofNominee;
}
public void setChangeofNominee(int changeofNominee) {
	ChangeofNominee = changeofNominee;
}
public int getDuplicateCertificate() {
	return DuplicateCertificate;
}
public void setDuplicateCertificate(int duplicateCertificate) {
	DuplicateCertificate = duplicateCertificate;
}
public int getWelfareFundCostReceipts() {
	return WelfareFundCostReceipts;
}
public void setWelfareFundCostReceipts(int welfareFundCostReceipts) {
	WelfareFundCostReceipts = welfareFundCostReceipts;
}
public int getDonation() {
	return donation;
}
public void setDonation(int donation) {
	this.donation = donation;
}
public int getSubscriptionLateFee() {
	return subscriptionLateFee;
}
public void setSubscriptionLateFee(int subscriptionLateFee) {
	this.subscriptionLateFee = subscriptionLateFee;
}
public int getSeniorAdvocateLateFee() {
	return seniorAdvocateLateFee;
}
public void setSeniorAdvocateLateFee(int seniorAdvocateLateFee) {
	this.seniorAdvocateLateFee = seniorAdvocateLateFee;
}
public int getWFReimbursmentOfsalaryDeduction() {
	return WFReimbursmentOfsalaryDeduction;
}
public void setWFReimbursmentOfsalaryDeduction(int wFReimbursmentOfsalaryDeduction) {
	WFReimbursmentOfsalaryDeduction = wFReimbursmentOfsalaryDeduction;
}
public int getWelfareFundInterestOnFD() {
	return WelfareFundInterestOnFD;
}
public void setWelfareFundInterestOnFD(int welfareFundInterestOnFD) {
	WelfareFundInterestOnFD = welfareFundInterestOnFD;
}
public int getWelfareFundClosingFD() {
	return WelfareFundClosingFD;
}
public void setWelfareFundClosingFD(int welfareFundClosingFD) {
	WelfareFundClosingFD = welfareFundClosingFD;
}
public int getSaleofStampAmount() {
	return SaleofStampAmount;
}
public void setSaleofStampAmount(int saleofStampAmount) {
	SaleofStampAmount = saleofStampAmount;
}
public int getLifeMembershipFee() {
	return LifeMembershipFee;
}
public void setLifeMembershipFee(int lifeMembershipFee) {
	LifeMembershipFee = lifeMembershipFee;
}
public int getGovtgrant() {
	return Govtgrant;
}
public void setGovtgrant(int govtgrant) {
	Govtgrant = govtgrant;
}
public int getMiscellaneous() {
	return Miscellaneous;
}
public void setMiscellaneous(int miscellaneous) {
	Miscellaneous = miscellaneous;
}






}
