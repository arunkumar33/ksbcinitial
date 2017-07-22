package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="KAWFfeeStructureConfirm")
public class KAWFfeeStructureDone {

	
	
	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int SerialNumber;
	private String Place;
	private Integer EnrollmentFee;
	private Integer IdentityCard;
	private String Name;
	private String KARNumber;
	private String BankName;
	private String BranchName;
	private Integer Amount;
	private String ChequeNumber;
	private String DDNumber;
	public Integer getEnrollmentFee() {
		return EnrollmentFee;
	}
	public void setEnrollmentFee(Integer enrollmentFee) {
		EnrollmentFee = enrollmentFee;
	}
	public Integer getIdentityCard() {
		return IdentityCard;
	}
	public void setIdentityCard(Integer identityCard) {
		IdentityCard = identityCard;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getKARNumber() {
		return KARNumber;
	}
	public void setKARNumber(String kARNumber) {
		KARNumber = kARNumber;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public Integer getAmount() {
		return Amount;
	}
	public void setAmount(Integer amount) {
		Amount = amount;
	}
	public String getChequeNumber() {
		return ChequeNumber;
	}
	public void setChequeNumber(String chequeNumber) {
		ChequeNumber = chequeNumber;
	}
	public String getDDNumber() {
		return DDNumber;
	}
	public void setDDNumber(String dDNumber) {
		DDNumber = dDNumber;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	
	
	
	
	
	
	
	
	
}
