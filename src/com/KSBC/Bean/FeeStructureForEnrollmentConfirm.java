package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FeeStructureForEnrollmentConfirm")
public class FeeStructureForEnrollmentConfirm {
	/*EnrollmentFee:EnrollmentFee,ReimbursementOFSalaryDeduction:ReimbursementOFSalaryDeduction,
	ClosingFD:ClosingFD,KSBCCostReceipt:KSBCCostReceipt,
	ElectionRules:ElectionRules,MiscReceipts:MiscReceipts,
	ElectionRules:ElectionRules,NominationForm:NominationForm,
	VoterCD:VoterCD,ElectionDeposit:ElectionDeposit,PDC:PDC,
	DOBCertificate:DOBCertificate,CertificateCopyCharges:CertificateCopyCharges,
	PostageReceipts:PostageReceipts,EnrollmentFee:EnrollmentFee,KARNumber:KARNumber,
	DuplicateEnrollemt:DuplicateEnrollemt,EndomentCertificate:EndomentCertificate,
	KSBCInterestONFD:KSBCInterestONFD,WhichFunctionToHandle:WhichFunctionToHandle,PlaceOftheClient:PlaceOftheClient,
	EnrollmentApplication:EnrollmentApplication,IdentityCard:IdentityCard,NameOftheClient:NameOftheClient,
	ComplaintFee:ComplaintFee,ChangeOfAddress:ChangeOfAddress,KARNumber:KARNumber,*/
	
	
	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int SerialNumber;
	
	
	private Integer ChangeOfAddress;
	private Integer ComplaintFee;
	private String NameOftheClient;
	private Integer IdentityCard;
	private Integer EnrollmentApplication;
	
	private String PlaceOftheClient;
	private Integer CertificateCopyCharges;
	private Integer PostageReceipts;
	private Integer EnrollmentFee;
	private Integer DuplicateEnrollemt;
	private String KARNumber;
	private Integer EndomentCertificate;
	private Integer KSBCInterestONFD;
	private Integer DOBCertificate;
	private Integer ContinuityCertificate;
	private Integer VSP;
	private Integer ProcessFee;
	private Integer NOC;
	private Integer ChangeOfNamePublication;

private Integer ReimbursementOFSalaryDeduction;
private Integer ClosingFD;
private Integer KSBCCostReceipt;
public Integer getChangeOfAddress() {
	return ChangeOfAddress;
}
public void setChangeOfAddress(Integer changeOfAddress) {
	ChangeOfAddress = changeOfAddress;
}
public Integer getComplaintFee() {
	return ComplaintFee;
}
public void setComplaintFee(Integer complaintFee) {
	ComplaintFee = complaintFee;
}
public String getNameOftheClient() {
	return NameOftheClient;
}
public void setNameOftheClient(String nameOftheClient) {
	NameOftheClient = nameOftheClient;
}
public Integer getIdentityCard() {
	return IdentityCard;
}
public void setIdentityCard(Integer identityCard) {
	IdentityCard = identityCard;
}
public Integer getEnrollmentApplication() {
	return EnrollmentApplication;
}
public void setEnrollmentApplication(Integer enrollmentApplication) {
	EnrollmentApplication = enrollmentApplication;
}
public String getPlaceOftheClient() {
	return PlaceOftheClient;
}
public void setPlaceOftheClient(String placeOftheClient) {
	PlaceOftheClient = placeOftheClient;
}
public Integer getCertificateCopyCharges() {
	return CertificateCopyCharges;
}
public void setCertificateCopyCharges(Integer certificateCopyCharges) {
	CertificateCopyCharges = certificateCopyCharges;
}
public Integer getPostageReceipts() {
	return PostageReceipts;
}
public void setPostageReceipts(Integer postageReceipts) {
	PostageReceipts = postageReceipts;
}
public Integer getEnrollmentFee() {
	return EnrollmentFee;
}
public void setEnrollmentFee(Integer enrollmentFee) {
	EnrollmentFee = enrollmentFee;
}
public Integer getDuplicateEnrollemt() {
	return DuplicateEnrollemt;
}
public void setDuplicateEnrollemt(Integer duplicateEnrollemt) {
	DuplicateEnrollemt = duplicateEnrollemt;
}
public String getKARNumber() {
	return KARNumber;
}
public void setKARNumber(String kARNumber) {
	KARNumber = kARNumber;
}
public Integer getEndomentCertificate() {
	return EndomentCertificate;
}
public void setEndomentCertificate(Integer endomentCertificate) {
	EndomentCertificate = endomentCertificate;
}
public Integer getKSBCInterestONFD() {
	return KSBCInterestONFD;
}
public void setKSBCInterestONFD(Integer kSBCInterestONFD) {
	KSBCInterestONFD = kSBCInterestONFD;
}
public Integer getDOBCertificate() {
	return DOBCertificate;
}
public void setDOBCertificate(Integer dOBCertificate) {
	DOBCertificate = dOBCertificate;
}
public Integer getContinuityCertificate() {
	return ContinuityCertificate;
}
public void setContinuityCertificate(Integer continuityCertificate) {
	ContinuityCertificate = continuityCertificate;
}
public Integer getVSP() {
	return VSP;
}
public void setVSP(Integer vSP) {
	VSP = vSP;
}
public Integer getProcessFee() {
	return ProcessFee;
}
public void setProcessFee(Integer processFee) {
	ProcessFee = processFee;
}
public Integer getNOC() {
	return NOC;
}
public void setNOC(Integer nOC) {
	NOC = nOC;
}
public Integer getChangeOfNamePublication() {
	return ChangeOfNamePublication;
}
public void setChangeOfNamePublication(Integer changeOfNamePublication) {
	ChangeOfNamePublication = changeOfNamePublication;
}
public Integer getReimbursementOFSalaryDeduction() {
	return ReimbursementOFSalaryDeduction;
}
public void setReimbursementOFSalaryDeduction(Integer reimbursementOFSalaryDeduction) {
	ReimbursementOFSalaryDeduction = reimbursementOFSalaryDeduction;
}
public Integer getClosingFD() {
	return ClosingFD;
}
public void setClosingFD(Integer closingFD) {
	ClosingFD = closingFD;
}
public Integer getKSBCCostReceipt() {
	return KSBCCostReceipt;
}
public void setKSBCCostReceipt(Integer kSBCCostReceipt) {
	KSBCCostReceipt = kSBCCostReceipt;
}
public Integer getElectionRules() {
	return ElectionRules;
}
public void setElectionRules(Integer electionRules) {
	ElectionRules = electionRules;
}
public Integer getMiscReceipts() {
	return MiscReceipts;
}
public void setMiscReceipts(Integer miscReceipts) {
	MiscReceipts = miscReceipts;
}
public Integer getVoterCD() {
	return VoterCD;
}
public void setVoterCD(Integer voterCD) {
	VoterCD = voterCD;
}
public Integer getNominationForm() {
	return NominationForm;
}
public void setNominationForm(Integer nominationForm) {
	NominationForm = nominationForm;
}
public Integer getElectionDeposit() {
	return ElectionDeposit;
}
public void setElectionDeposit(Integer electionDeposit) {
	ElectionDeposit = electionDeposit;
}
public Integer getPDC() {
	return PDC;
}
public void setPDC(Integer pDC) {
	PDC = pDC;
}
private Integer ElectionRules;
private Integer MiscReceipts;

private Integer VoterCD;
private Integer NominationForm;
private Integer ElectionDeposit;
private Integer PDC;


}
