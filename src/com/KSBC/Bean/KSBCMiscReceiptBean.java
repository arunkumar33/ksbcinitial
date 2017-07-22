package com.KSBC.Bean;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="KSBCMiscReceiptBean")
public class KSBCMiscReceiptBean {
	
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

	
	private int ChangeOfAddress;
	private int ComplaintFee;
	private String NameOftheClient;
	private int IdentityCard;
	private int EnrollmentApplication;
	
	
	private int ElectionRules;
	public int getElectionRules() {
		return ElectionRules;
	}
	public void setElectionRules(int electionRules) {
		ElectionRules = electionRules;
	}
	public int getMiscReceipts() {
		return MiscReceipts;
	}
	public void setMiscReceipts(int miscReceipts) {
		MiscReceipts = miscReceipts;
	}
	public int getVoterCD() {
		return VoterCD;
	}
	public void setVoterCD(int voterCD) {
		VoterCD = voterCD;
	}
	public int getNominationForm() {
		return NominationForm;
	}
	public void setNominationForm(int nominationForm) {
		NominationForm = nominationForm;
	}
	public int getElectionDeposit() {
		return ElectionDeposit;
	}
	public void setElectionDeposit(int electionDeposit) {
		ElectionDeposit = electionDeposit;
	}
	public int getPDC() {
		return PDC;
	}
	public void setPDC(int pDC) {
		PDC = pDC;
	}
	private int MiscReceipts;

	private int VoterCD;
	private int NominationForm;
	private int ElectionDeposit;
	private int PDC;
	
	private String PlaceOftheClient;
	public int getChangeOfAddress() {
		return ChangeOfAddress;
	}
	public void setChangeOfAddress(int changeOfAddress) {
		ChangeOfAddress = changeOfAddress;
	}
	public int getComplaintFee() {
		return ComplaintFee;
	}
	public void setComplaintFee(int complaintFee) {
		ComplaintFee = complaintFee;
	}
	public String getNameOftheClient() {
		return NameOftheClient;
	}
	public void setNameOftheClient(String nameOftheClient) {
		NameOftheClient = nameOftheClient;
	}
	public int getIdentityCard() {
		return IdentityCard;
	}
	public void setIdentityCard(int identityCard) {
		IdentityCard = identityCard;
	}
	public int getEnrollmentApplication() {
		return EnrollmentApplication;
	}
	public void setEnrollmentApplication(int enrollmentApplication) {
		EnrollmentApplication = enrollmentApplication;
	}
	public String getPlaceOftheClient() {
		return PlaceOftheClient;
	}
	public void setPlaceOftheClient(String placeOftheClient) {
		PlaceOftheClient = placeOftheClient;
	}
	public int getCertificateCopyCharges() {
		return CertificateCopyCharges;
	}
	public void setCertificateCopyCharges(int certificateCopyCharges) {
		CertificateCopyCharges = certificateCopyCharges;
	}
	public int getPostageReceipts() {
		return PostageReceipts;
	}
	public void setPostageReceipts(int postageReceipts) {
		PostageReceipts = postageReceipts;
	}
	public int getDuplicateEnrollemt() {
		return DuplicateEnrollemt;
	}
	public void setDuplicateEnrollemt(int duplicateEnrollemt) {
		DuplicateEnrollemt = duplicateEnrollemt;
	}
	public String getKARNumber() {
		return KARNumber;
	}
	public void setKARNumber(String kARNumber) {
		KARNumber = kARNumber;
	}
	public int getEndomentCertificate() {
		return EndomentCertificate;
	}
	public void setEndomentCertificate(int endomentCertificate) {
		EndomentCertificate = endomentCertificate;
	}
	public int getKSBCInterestONFD() {
		return KSBCInterestONFD;
	}
	public void setKSBCInterestONFD(int kSBCInterestONFD) {
		KSBCInterestONFD = kSBCInterestONFD;
	}
	public int getDOBCertificate() {
		return DOBCertificate;
	}
	public void setDOBCertificate(int dOBCertificate) {
		DOBCertificate = dOBCertificate;
	}
	public int getContinuityCertificate() {
		return ContinuityCertificate;
	}
	public void setContinuityCertificate(int continuityCertificate) {
		ContinuityCertificate = continuityCertificate;
	}
	public int getVSP() {
		return VSP;
	}
	public void setVSP(int vSP) {
		VSP = vSP;
	}
	public int getProcessFee() {
		return ProcessFee;
	}
	public void setProcessFee(int processFee) {
		ProcessFee = processFee;
	}
	public int getNOC() {
		return NOC;
	}
	public void setNOC(int nOC) {
		NOC = nOC;
	}
	public int getChangeOfNamePublication() {
		return ChangeOfNamePublication;
	}
	public void setChangeOfNamePublication(int changeOfNamePublication) {
		ChangeOfNamePublication = changeOfNamePublication;
	}
	public int getReimbursementOFSalaryDeduction() {
		return ReimbursementOFSalaryDeduction;
	}
	public void setReimbursementOFSalaryDeduction(int reimbursementOFSalaryDeduction) {
		ReimbursementOFSalaryDeduction = reimbursementOFSalaryDeduction;
	}
	public int getClosingFD() {
		return ClosingFD;
	}
	public void setClosingFD(int closingFD) {
		ClosingFD = closingFD;
	}
	public int getKSBCCostReceipt() {
		return KSBCCostReceipt;
	}
	public void setKSBCCostReceipt(int kSBCCostReceipt) {
		KSBCCostReceipt = kSBCCostReceipt;
	}
	private int CertificateCopyCharges;
	private int PostageReceipts;

	private int DuplicateEnrollemt;
	private String KARNumber;
	private int EndomentCertificate;
	private int KSBCInterestONFD;
	private int DOBCertificate;
	private int ContinuityCertificate;
	private int VSP;
	private int ProcessFee;
	private int NOC;
	private int ChangeOfNamePublication;

	
/*	+ "<th>CertificateCopyCharges</th>"
	+ "<th>PostageReceipts</th><th>DuplicateEnrollemt</th>"
	+ "<th>EndomentCertificate</th><th>KSBCInterestONFD</th><th>DOBCertificate</th><th>ContinuityCertificate</th>"
	+ "<th>VSP</th><th>ProcessFee</th><th>NOC</th><th>ChangeOfNamePublication</th><th>ReimbursementOFSalaryDeduction</th>"
	+ "<th>ClosingFD</th><th>KSBCCostReceipt</th>"
	+ "<th>Resumption</th><th>MiscReceipts</th><th>VoterCD</th><th>NominationForm</th>"
	+ "<th>ElectionDeposit</th><th>PDC</th>"
	
	+ "<th>ChangeOfAddress</th>"
	+ "<th>ComplaintFee</th>"
	
	+ "<th>IdentityCard</th>"
	+ "<th>EnrollmentApplication</th>"*/
private int ReimbursementOFSalaryDeduction;
private int ClosingFD;
private int KSBCCostReceipt;

private int Resumption;

public int getResumption() {
	return Resumption;
}
public void setResumption(int resumption) {
	Resumption = resumption;
}


private int GOvtGrant;
public int getGOvtGrant() {
	return GOvtGrant;
}
public void setGOvtGrant(int gOvtGrant) {
	GOvtGrant = gOvtGrant;
}


private java.sql.Timestamp ChallanCreatedDate;
public java.sql.Timestamp getChallanCreatedDate() {
	return ChallanCreatedDate;
}
public void setChallanCreatedDate(java.sql.Timestamp challanCreatedDate) {
	ChallanCreatedDate = challanCreatedDate;
}
	

}
