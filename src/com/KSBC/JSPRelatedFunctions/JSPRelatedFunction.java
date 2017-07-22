package com.KSBC.JSPRelatedFunctions;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.KSBC.Bean.AbsentBean;
import com.KSBC.Bean.AcceptedCandidate;
import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.EligibleKARChanges;
import com.KSBC.Bean.EnrollmentDetails;
import com.KSBC.Bean.FeeStructureForKAR;
import com.KSBC.Bean.RegistrationFormBean;
import com.KSBC.Bean.ScheduleBean;
import com.KSBC.Bean.ScheduleConfirmationBean;
import com.KSBC.Bean.ScheduleInterviewListBean;
import com.KSBC.Bean.Step1RegistrationForm;
import com.KSBC.Bean.Step2RegistrationForm;
import com.KSBC.Bean.Step3RegistrationForm;
import com.KSBC.Bean.ValidatedFinalBean;
import com.KSBC.Bean.ValidatedPayedRegistrationChallan;

public interface JSPRelatedFunction {

	public RegistrationFormBean GetDetailsForRegNumber (String RegNumber);
	public ArrayList<RegistrationFormBean> GetDetailsForAllRegNumber();
	public ArrayList<ScheduleConfirmationBean> ViewInterviewCandidate();
	public String MoveToAbsentListFromScheduleList(String RegNumber);
	public String MoveToAbsentListFromScheduleListAll();
	public ArrayList<AbsentBean> ViewInterviewAbsentCandidate();
	public String GenerateKARNumber(String RegNumber);
	public ValidatedFinalBean GetKARNumberInfoForCertificate(String KARNumber);
	public ScheduleConfirmationBean GetKARNumberInfoForCertificateConfirmList(String KARNumber);
	public ArrayList<ValidatedFinalBean> ViewFinalKARNumberHolder();
	public String RemoveUserFromRegistration(String RegNumber);
	public String MoveToScheduleInterviewtList(String RegNumber);
	public String MoveTOInterviewListFromAbsentList(String RegNumber);
	public String MoveTOInterviewConfirmationList(String RegNumber);
	public int RandomNumberForRegNumber();
	public String RegNumberGenration(String FirstName);
	public String GetDomainFromUSernameandPassword(String UserName, String Password);
	public String InsertintoLoginDomain(String UserName, String Password,String Domain);
	public String GetPathforCertificate(String RegNumber);
	public String AbsentListForJSP();
	public String ViewInterviewCandidateForJSP();
	public String ConfirmInterviewJSP(); //ScheduleConfirmationBean
	public ArrayList<ScheduleConfirmationBean> ViewScheduleConfirmationBean();
	public ScheduleConfirmationBean GetConfirmBean(String RegNumber);
	public ArrayList<ValidatedPayedRegistrationChallan> ViewPaymentValidatedCandidate();
//	public String MoveToScheduleInterviewListFromConfirmationBeanAll();
	public ValidatedPayedRegistrationChallan GetDetailsForRegNumberFromValidatedPayedRegistrationChallan (String RegNumber);
	public String ScheduleInterviewBydate(String Date, String RegNumber);
	public String MoveToScheduleConfirmationBeanInterviewtList(String RegNumber); 
	public String ViewInterviewConfirmCandidateForJSP();
	public ArrayList<ScheduleInterviewListBean> ViewInterviewconfirmCandidate();
	public String MoveToScheduleInterviewListFromConfirmationBean(String RegNumber);
	public String DeclainTheCandidate(String RegNumber);
	public String ReScheduletheAbsentCandidate(String RegNumber);  
	public String AcceptTheCandidateMoveTOKAR(String RegNumber); 
	public String UpdateAddressOfKARnumber(String KARnumber,String Address); 
	public String UpdateNameOfKARnumber(String KARnumber,String Name); 
	public String UpdateStatusOfKARnumber(String KARnumber,String Status); 
	public String UpdateNomineeOfKARnumber(String KARnumber,String Nominee);
	public String GetTheStatus(String KARnumber);
	public double GetAmountForWelfareSelect(String KARnumber,String PayForWelfareSelect);  
	public ArrayList<EligibleKARChanges> ViewEligibleKARChanges();
	public ArrayList<ValidatedFinalBean> ViewFinalKARNumberForDeathCandidate(String Status,Date StartDate,Date EndDate);
	public String EligibleKARChangesJSP(); 
	public String ViewEligibleKARChangeForJSP(); 
	public String GenerateAdmissionReport(String PlaceOfPractice,Date StartDate,Date EndDate,String CastCategory,String GenderCategory );
	public String GenerateElectionReport(String PlaceOfPractice,String CastCategory,String GenderCategory );
	public ArrayList<ValidatedFinalBean> GenerateReport(String StatusOfTheAdvocate,Date StartDate,Date EndDate,String CastCategory,String GenderCategory );
	public String GenerateREGNumber(String FirstName);
	public Step1RegistrationForm GetStep1RegistrationForm (String REGNumber);
	public Step2RegistrationForm GetStep2RegistrationForm (String REGNumber);
	public Step3RegistrationForm GetStep3RegistrationForm (String REGNumber);
	public String MoveTOReGBean(String REGNumber);
	public String RegistrationLoginFormValidatationForUSernameandPassword(String REGNumber, String Password);
public String GenerateCertificate (String KARNumber,String FatherName,String Name, java.sql.Timestamp EnrollmentDate,String REGNumber ,int EnrollmentID);
public String DuplicateCertificate (String KARNumber,String FatherName,String Name, java.sql.Timestamp EnrollmentDate,String REGNumber ,int EnrollmentID);
public String GenerateChallan ( Integer TotalMoney,LinkedHashMap<String, Integer> PayingForWithValue, String Name,String Date,String Place,String KARNumber,String ReceiptNo,String DDNumber,String Category);
public String GetWelfareFund(String KARNumber);
public String VerifyChallanForEnrollmentOffline();
public String GetWelfareFundLastPay(String KARNumber);
public ArrayList<FeeStructureForKAR> ViewChallanForEnrollmentOffline(); 
public  EnrollmentDetails GetEnrollmentDetails(String KARNumber);
public  EnrollmentDetails GetEnrollmentDetailsForName(String Name,String Place);
public String MoveDataFromValidatedBeantoEnrollment();
public String GetEnrollmentDetailsByName(String Name,String Place);
/*public KARCheck();*/
public ArrayList<AcceptedCandidate> ViewAcceptList();
public ArrayList<AcceptedCandidate> ViewAcceptedCandidate();
public ArrayList<AcceptedCandidate> ViewAcceptedCandidateIndesc();
public String AcceptcandidateJSP();
public String UpdateCaseDetailsInDC (String CaseDetails,String ComplaintNumber);
public String GetDetailsOfDCfromComplaintNumber(String ComplaintNumber);
// Account flow 
public ArrayList<CashSectionMonthlyReportFlow> ToDoListForNewEnrollment();
public String JSPforToDoListOfNewEnrollment();
public String MoveToCashSectionMonthlyReportDone(String ReceiptNumber);

public String JSPForToDoListOfWelfareAccount();
public ArrayList<CashSectionMonthlyReportFlow> ToDoListForWelfare();

public String JSPForToDoListOfDcAccount();
public ArrayList<CashSectionMonthlyReportFlow> ToDoListForDcAccount();

public String JSPForToDoListOfTappal();
public ArrayList<CashSectionMonthlyReportFlow> ToDoListForTappal();

public String JSPForToDoListOfStamp();
public ArrayList<CashSectionMonthlyReportFlow> ToDoListForStamp();

public String GenerateMnthlyReport(java.sql.Date FromDate,java.sql.Date ToDate);
public String GenerateDailyReport(java.sql.Date FromDate);
public String GenerateDailyReportForUser(java.sql.Date FromDate,String Operator);
public String GenerateCOPDailyReportForUser(java.sql.Date FromDate,String Operator);
public String GenerateCOPMnthlyReport(LocalDate Start,LocalDate End);
public String GenerateCOPDailyReport(java.sql.Date FromDate);
public String GetReportPerDateForCOP(LocalDate Start);

public String GetPhotoDetailsForWelfare(int EnrollmentNumber);
public String GetClaimDetailsForWelfare(String KARNumber);
public String GetClaimRemarksForWelfare(String KARNumber);

public String ChangeTheNominee(String KARNumber,String NomineeName,String RelationShip,String EnteredBy);

public String ChangeOfName(String KARNumber,String Name,String Reason);

public String ChangeOfAddress(String KARNumber,String City,String State,String PinCode, String Address, String EnteredBy);

public String InsertintoEnrollmentPayment(String EnrollmentId, int ReceiptTransactionId,
		int WelfareFundInstallmentNo, int FromYear, int ToYear,BigDecimal AmountPaid,Timestamp AmountPaidOn,String ReceiptNo,String ReceiptDate);

//EnrollmentDetails
public String InsertintoEnrollment( EnrollmentDetails EnrollmentDetails);
public String InsertintoSuspended(String EnrollmentID,int ReceiptTransactionId,String SuspendType,Timestamp SuspendedOn,String SuspendedRemarks,String EnteredBy,Timestamp DateChanged);	
public String InsertIntoTransfer(int EnrollmentId,int ReceiptTransactionId,String TransferType,Short TransferredToState,Short ReasonForTransfer,String NOCNo,Timestamp TransferredDate, Timestamp DateChanged);
public String InsertIntoResumption(int EnrollmentId,int ReceiptVoucherId,int ReceiptId,int ReceiptTransactionid,Timestamp ResumptionDate,String Reason,String EnteredBy,Timestamp EnteredOn);

public String updateStatus(String KARNumber,String Status);
public String GetPayBalenceForKARNumber(String KARNumber);
public String GetPayBalenceForKARNumberForDisplay(String KARNumber);
public String GetMonthlyReportForBCI(LocalDate Start, LocalDate End);

public String GetReportPerDateForBCI(LocalDate Start);
public String GetMonthlyReportForKAWFMisc(LocalDate Start, LocalDate End);

public String GetReportPerDateForKAWFMisc(LocalDate Start);

public String GetMonthlyReportForKAWFMemberShipFee(LocalDate Start, LocalDate End);

public String GetReportPerDateForKAWFMemberShipFee(LocalDate Start);

public String GetMonthlyReportForKSBCMiscFee(LocalDate Start, LocalDate End);
public String UpdateEnrollment( EnrollmentDetails EnrollmentDetails);
public String UpdateChangeTheNominee(String KARNumber,String NomineeName,String RelationShip,String EnteredBy);
public String GetReportPerDateForKSBCMiscFee(LocalDate Start);
public String GetReportPerDateForKSBCMiscFeeForBCI(LocalDate Start);
public String GetMonthlyReportForKSBCEnrollFee(LocalDate Start, LocalDate End);

public String GetReportPerDateForKSBCEnrollFee(LocalDate Start);

public String UpdateToLifeTimeMemberShip(String KARNumber);

public String UpdateToWelfareMemberShip(String KARNumber);
//Stamping
public String GetMonthlyReportForIndividualStampingFee(LocalDate Start, LocalDate End);

public String GetReportPerDateForIndividualStampingFee(LocalDate Start);




public String GetMonthlyReportForAssociateStampingFee(LocalDate Start, LocalDate End);
public String UpdateClimReport(LocalDate ClaimDate,String KARNumber,String Name,String Place,String ClaimType,String ClaimAmount,String Remarks,String ResolutionNumber,LocalDate ResolutionDate);
public String GetReportPerDateForAssociateStampingFee(LocalDate Start);
 
public String DeleteRecordFromChallanFlow(int ReceiptNo);
public String ChangeAddressInEnrollment(String KARNumber,String Address,String Remarks,String statusOfTheAdvocate);
public String ChangeNomineeName(String KARNumber,String Naminee,String Remarks);

public String MoveToScheduleInterviewListFromConfirmationBeanAll();

public String ChangeTheEnrollmentName(String KARNumber,String NameChange,String Remarks);
public String UpdateNomineeDetails(String KARNumber,String Remarks,String Nominee,String Relationship);
public String InsertIntoWelfarePayments(String EnrollmentId,int ReceiptTransactionId,int WelfareFundInstallmentNo,int FromYear,int ToYear,java.math.BigDecimal AmountPaid,java.sql.Timestamp AmountPaidOn,int ReceiptNo, java.sql.Timestamp ReceiptDate);


// Tappal
public String GetDetailsForInWorldTappal(String InworldNumber);
public String GetDetailsForOutWorldTappal(String OutworldNumber);
public String GetDetailsForTappalAssert(String UserName);

//Welfare
public String WelfareReprt(String ReportType);

public String GetMonthlyReportForWelfarePortalFee(Date StartDate, Date EndDate, String Particulars);

public String GenerateAllTheCertificateAtonce(String EnrollmentDate);
public String GenerateStampSectionAssosiationMnthlyReport(LocalDate Start,LocalDate End);
public String GenerateStampSectionAssosiationDailyReport(java.sql.Date FromDate);

public String GenerateStampSectionIndividualMnthlyReport(LocalDate Start,LocalDate End);
public String GenerateStampSectionIndividualDailyReport(java.sql.Date FromDate);

public String GetReportPerDateForStampIndividual(LocalDate Start);
public String GetReportPerDateForStampAsc(LocalDate Start);


public String GetMonthlyReportForNewEnrollmentFee(Date StartDate, Date EndDate, String Particulars);

public String GetDetailKARFromEnrollemntID(int EnrollmentID);
public String UpdateWelfareEnrollDate(String EnrollmentID,Date WelfareDate);
/*public String VSPReport*/
public String GetReportPerDateForSeniorAdv(LocalDate Start);
public String GenerateSeniorAdvMnthlyReport(LocalDate Start,LocalDate End);
public String GetDetailEnrollemntIDFromKAR(String EnrollmentID);

public String GetMonthlyReportForResumbption(Date StartDate, Date EndDate, String Particulars);
public String GetMonthlyReportForTransfor(Date StartDate, Date EndDate, String Particulars);
public String GetMonthlyReportForSuspend(Date StartDate, Date EndDate, String Particulars);
public String GenerateCertificateForBond (String KARNumber,String FatherName,String Name, java.sql.Timestamp EnrollmentDate,String REGNumber ,int EnrollmentID);


public int CheckInTransfer(String KARNumber);
public int CheckInSuspend(String KARNumber);
public int CheckInResumption(String KARNumber);


public String GetMonthlyReportForClaim(Date StartDate, Date EndDate, String Particulars);
public String GetMonthlyReportForLifeTime(Date StartDate, Date EndDate, String Particulars);

public String CheckForStatus(String KARNumber);

public String NewEnrollmentPieChart();
public String AccountPieChart();
public String WelfarePieChart();

public String DCPieChart();
public String TappalPieChart();
public String StampSectionPieChart();
public String UpdateRemarks(String KARNumber,String Remarks);

public String GetRemarks(String KARNumber);

public abstract String GetName(String paramString);

public abstract int IsAdditionalInformationFromRegNumber(String paramString);

public abstract String PriousAddtionalInformation(String paramString);

public abstract String GenerateIncomingReport(String paramString1, Date paramDate1, Date paramDate2, String paramString2, String paramString3);

public abstract int GetSLNumberofChairmanSignature(Timestamp paramTimestamp);
public String GetDetailsForInWorldComplaintTappal(String InworldNumber);

public String GetAIBRemarks(String KARNumber);
}

