package com.KSBC.JSPRelatedFunctions;

import java.awt.Image;
import java.awt.List;
import java.beans.Statement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.KSBC.AccountJSPRelatedFunctions.AccountJSPRelatedFunctionsImp;
import com.KSBC.Bean.AIBTable;
import com.KSBC.Bean.AbsentBean;
import com.KSBC.Bean.AcceptedCandidate;
import com.KSBC.Bean.AssociationStampBean;
import com.KSBC.Bean.BCI_FDSBean;
import com.KSBC.Bean.COPTable;
import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.CashSectionMonthlyReportDone;
import com.KSBC.Bean.CashSectionMonthlyReportFlow;
import com.KSBC.Bean.ChairmanSignature;
import com.KSBC.Bean.DC_Committee;
import com.KSBC.Bean.DateScheduleForInterviewBean;
import com.KSBC.Bean.DomainLoginBean;
import com.KSBC.Bean.EligibleKARChanges;
import com.KSBC.Bean.EligibleKARChangesConfirm;
import com.KSBC.Bean.EnrollmentDetails;
import com.KSBC.Bean.EnrollmentNewMemberBean;
import com.KSBC.Bean.Enrollment_WelfareFundPayments;
import com.KSBC.Bean.FeeStructure;
import com.KSBC.Bean.FeeStructureForKAR;
import com.KSBC.Bean.FileUploadBean;
import com.KSBC.Bean.IndividualStampBean;
import com.KSBC.Bean.KAWFLateWelfareFundBean;
import com.KSBC.Bean.KAWFMiscReceiptBean;
import com.KSBC.Bean.KSBCMiscReceiptBean;
import com.KSBC.Bean.REGNumberGenratorSequence;
import com.KSBC.Bean.RegistrationFormBean;
import com.KSBC.Bean.RegistrationLogin;
import com.KSBC.Bean.ScheduleBean;
import com.KSBC.Bean.ScheduleConfirmationBean;
import com.KSBC.Bean.ScheduleInterviewListBean;
import com.KSBC.Bean.SeniorAdvocateTable;
import com.KSBC.Bean.StampSectionAssociationBean;
import com.KSBC.Bean.StampSectionIndividualBean;
import com.KSBC.Bean.Step1RegistrationForm;
import com.KSBC.Bean.Step2RegistrationForm;
import com.KSBC.Bean.Step3RegistrationForm;
import com.KSBC.Bean.TappalAssertTable;
import com.KSBC.Bean.TappalComplaintInword;
import com.KSBC.Bean.Tappal_Inworld;
import com.KSBC.Bean.Tappal_Outworld;
import com.KSBC.Bean.ValidatedFinalBean;
import com.KSBC.Bean.ValidatedPayedRegistrationChallan;
import com.KSBC.Servlet.BCI_FDS;
import com.KSBC.Servlet.OutWorldTappal;
import com.KSBC.Util.HibernateUtil;
import com.KSBC.Util.JDBCUtil;

public class JSPRelatedFunctionsimp implements JSPRelatedFunction {
	static long  Global_BCISubscriptionLateFee = 0 ;
	 static long   Global_FDSDiffAmt = 0 ;
	 static long  Global_BCISubscription  = 0 ;
	 static long Global_total=(int) 0;
	 static long  Global_FDS  = 0 ;
	 static long  Global_Certverificationfee  = 0 ;
	 static long Global_KSBCCOPApplication=0;
	 static	 long Global_KSBCCOPFee=0;
	 static	 long Global_KSBCCOPLateFee=0;
	 static	 long Global_KSBCCOPRescFee=0;
	 static	 long Global_KSBCCOPMiscFee=0;
	 static	 long Global_KSBCCOPSeniorAdvc=0;
	 static  long Global_COPClosingFD=0;
	 static	 long Global_COPInterestONFD=0;
	 static long  Global_CostReceipt  = 0 ;
	 static long   Global_BCIReimbursmentOfSalaryDeduction = 0 ;
	 static long   Global_BCIInterestonFD = 0 ;
	 static long Global_BCIClosingFD   = 0 ;
	 static long  Global_FDSInterestonFD  = 0 ;
	 static long  Global_FDSClosingFD  = 0 ;
	 static long Global_Stampfee=0;
	 static long Global_AssociationStampfee=0;
	 static  long Global_PostalCharges=0;
	 static long Global_KawfSubscription =0;
	 static long Global_SeniorAdvocateContribution =0;
	 static long Global_ChangeofNominee =0;
	 static long Global_DuplicateCertificate =0;
	 static long Global_WelfareFundCostReceipts =0;
	 static long Global_donation =0;
	 static long Global_subscriptionLateFee =0;
	 
	 static long Global_seniorAdvocateLateFee =0;
	 static long Global_WFReimbursmentOfsalaryDeduction =0;
	 static long Global_WelfareFundInterestOnFD =0;
	 static long Global_WelfareFundClosingFD =0;
	 static long Global_SaleofStampAmount =0;
	 static long Global_LifeMembershipFee =0;
	 static long Global_Govtgrant =0;
	 static long Global_Miscellaneous =0;
	 static long Global_KAWFMembershipFee=0;
	  static long Global_WFMembershipLateFee=0;
	  
	  
	 static long Global_CertificateCopyCharges=0;
	 static long Global_PostageReceipts=0;

	 static long Global_DuplicateEnrollemt=0;
	// String KARNumber=0;
	 static long Global_EndomentCertificate=0;
	 static long Global_KSBCInterestONFD=0;
	 static long Global_DOBCertificate=0;
	 static long Global_ContinuityCertificate=0;
	 static long Global_VSP=0;
	 static long Global_ProcessFee=0;
	 static long Global_NOC=0;
	 static long Global_ChangeOfNamePublication=0;
	 static long total=(long) 0;
static long Global_ReimbursementOFSalaryDeduction=0;
static long Global_ClosingFD=0;
static long Global_KSBCCostReceipt=0;

static long Global_Resumption=0;

static long Global_MiscReceipts=0;

static long Global_VoterCD=0;
static long Global_NominationForm=0;
static long Global_ElectionDeposit=0;
static long Global_PDC=0;
 static long Global_GOvtGrant=0;
	 static long Global_ElectionRules=0;
 static long Global_ChangeOfAddress=0;
	 static long Global_ComplaintFee=0;
//	 String NameOftheClient=0;
	 static long Global_IdentityCard=0;
	 static long Global_EnrollmentApplication=0;
	// From KSBC New ENrollment 
	 static long Global_EnrollmentFee=0;
	 static long Global_ksbcIdentityCard=0;
	 static long Global_miscRts=0;
	 static long Global_KsbcTrust = 0;
	 static long Global_KawfMembershipFee=0;
	 static long Global_BciSubscription=0;
	 static long Global_fds=0;
	 
	@Override
	public RegistrationFormBean GetDetailsForRegNumber(String RegNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from RegistrationFormBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<RegistrationFormBean> list = (ArrayList<RegistrationFormBean>)query.list();
		 Session.close();
		return list.get(0);
		}
		catch(Exception e)
		{
		return null;	
		}
	}

	@Override
	public ArrayList<RegistrationFormBean> GetDetailsForAllRegNumber() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from RegistrationFormBean");
		
		 @SuppressWarnings("unchecked")
		ArrayList<RegistrationFormBean> list = (ArrayList<RegistrationFormBean>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public ArrayList<ScheduleConfirmationBean> ViewInterviewCandidate() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleConfirmationBean");
		
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleConfirmationBean> list = (ArrayList<ScheduleConfirmationBean>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public String MoveToAbsentListFromScheduleList(String RegNumber) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleInterviewListBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleInterviewListBean> list = (ArrayList<ScheduleInterviewListBean>)query.list();
		 ScheduleInterviewListBean RegistrationFormBean= list.get(0);
		 
		 AbsentBean ScheduleBean= new AbsentBean();
		// AbsentBean.setRegNumber(ScheduleBean.getRegNumber());
		 
		 ScheduleBean.setRegNumber(RegistrationFormBean.getRegNumber());
		 ScheduleBean.setAddress(RegistrationFormBean.getAddress());
		 ScheduleBean.setAddressFromStep3(RegistrationFormBean.getAddressFromStep3());
		 ScheduleBean.setBirthdate(RegistrationFormBean.getBirthdate());
		 ScheduleBean.setBloodGroup(RegistrationFormBean.getBloodGroup());
		 ScheduleBean.setBusinessDetails(RegistrationFormBean.getBusinessDetails());
		 ScheduleBean.setCitizenOfIndia(RegistrationFormBean.getCitizenOfIndia());
		 ScheduleBean.setCity(RegistrationFormBean.getCity());
		 ScheduleBean.setCollege(RegistrationFormBean.getCollege());
		 ScheduleBean.setConvictedDetails(RegistrationFormBean.getConvictedDetails());
		 ScheduleBean.setDiscontinuanceOfPractice(RegistrationFormBean.getDiscontinuanceOfPractice());
		 ScheduleBean.setEmail(RegistrationFormBean.getEmail());
		 ScheduleBean.setFather_name(RegistrationFormBean.getFather_name());
		 ScheduleBean.setFirst_name(RegistrationFormBean.getFirst_name());
		 ScheduleBean.setFullName(RegistrationFormBean.getFullName());
		 ScheduleBean.setNomineeDetails(RegistrationFormBean.getNomineeDetails());
		 ScheduleBean.setNotAnClitizen(RegistrationFormBean.getNotAnClitizen());
		 ScheduleBean.setNotAnClitizen(RegistrationFormBean.getNotAnClitizen());
		 ScheduleBean.setOtherProfessional(RegistrationFormBean.getOtherProfessional());
		 ScheduleBean.setPendingCriminalCases(RegistrationFormBean.getPendingCriminalCases());
		 ScheduleBean.setPhone(RegistrationFormBean.getPhone());
		 ScheduleBean.setPlaceOfPractice(RegistrationFormBean.getPlaceOfPractice());
		 ScheduleBean.setPlaceOfPracticeFromStep2(RegistrationFormBean.getPlaceOfPracticeFromStep2());
		 ScheduleBean.setPreviousApplicationDetails(RegistrationFormBean.getPreviousApplicationDetails());
		 ScheduleBean.setPreviousEmployment(RegistrationFormBean.getPreviousEmployment());
		 ScheduleBean.setProportionOfShare(RegistrationFormBean.getProportionOfShare());
		 ScheduleBean.setRegNumber(RegistrationFormBean.getRegNumber());
		 ScheduleBean.setState(RegistrationFormBean.getState());
		 ScheduleBean.setTerminatedDetails(RegistrationFormBean.getTerminatedDetails());
		 ScheduleBean.setUniversity_Name(RegistrationFormBean.getUniversity_Name());
		 ScheduleBean.setYear_course(RegistrationFormBean.getYear_course());
		 ScheduleBean.setYear_of_Completion(RegistrationFormBean.getYear_of_Completion());
		 ScheduleBean.setZipCode(RegistrationFormBean.getZipCode());
		 ScheduleBean.setGenderCategory(RegistrationFormBean.getGenderCategory());
		 ScheduleBean.setCastCategory(RegistrationFormBean.getCastCategory());
		 //arun123
		 // Please do For all other paarameters
		 Session.saveOrUpdate(ScheduleBean);
		 Session.delete(RegistrationFormBean);
		 Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	
	}

	@Override
	public ArrayList<AbsentBean> ViewInterviewAbsentCandidate() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from AbsentBean");
		
		 @SuppressWarnings("unchecked")
		ArrayList<AbsentBean> list = (ArrayList<AbsentBean>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public String GenerateKARNumber(String RegNumber) {
		
		return null;
	}
//Changed from ValidatedFinalBean to ScheduleConfirmationBean
	@Override
	public ValidatedFinalBean GetKARNumberInfoForCertificate(String KARNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedFinalBean where KARNumber = :RegNumber ");
		query.setParameter("RegNumber", KARNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
		 Session.close();
		return list.get(0);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
		
	/*	try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleConfirmationBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", KARNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleConfirmationBean> list = (ArrayList<ScheduleConfirmationBean>)query.list();
		 Session.close();
		return list.get(0);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}*/
	}

	@Override
	public ArrayList<ValidatedFinalBean> ViewFinalKARNumberHolder() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedFinalBean");
		
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public String RemoveUserFromRegistration(String RegNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from RegistrationFormBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<RegistrationFormBean> list = (ArrayList<RegistrationFormBean>)query.list();
		 RegistrationFormBean RegistrationFormBean= list.get(0);
		 Session.delete(RegistrationFormBean);
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	}

	@Override
	public String MoveToScheduleInterviewtList(String RegNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from RegistrationFormBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<RegistrationFormBean> list = (ArrayList<RegistrationFormBean>)query.list();
		 RegistrationFormBean RegistrationFormBean= list.get(0);
		 
		 ScheduleBean ScheduleBean= new ScheduleBean();
		 ScheduleBean.setRegNumber(RegistrationFormBean.getRegNumber());
		 ScheduleBean.setAddress(RegistrationFormBean.getAddress());
		 ScheduleBean.setAddressFromStep3(RegistrationFormBean.getAddressFromStep3());
		 ScheduleBean.setBirthdate(RegistrationFormBean.getBirthdate());
		 ScheduleBean.setBloodGroup(RegistrationFormBean.getBloodGroup());
		 ScheduleBean.setBusinessDetails(RegistrationFormBean.getBusinessDetails());
		 ScheduleBean.setCitizenOfIndia(RegistrationFormBean.getCitizenOfIndia());
		 ScheduleBean.setCity(RegistrationFormBean.getCity());
		 ScheduleBean.setCollege(RegistrationFormBean.getCollege());
		 ScheduleBean.setConvictedDetails(RegistrationFormBean.getConvictedDetails());
		 ScheduleBean.setDiscontinuanceOfPractice(RegistrationFormBean.getDiscontinuanceOfPractice());
		 ScheduleBean.setEmail(RegistrationFormBean.getEmail());
		 ScheduleBean.setFather_name(RegistrationFormBean.getFather_name());
		 ScheduleBean.setFirst_name(RegistrationFormBean.getFirst_name());
		 ScheduleBean.setFullName(RegistrationFormBean.getFullName());
		 ScheduleBean.setNomineeDetails(RegistrationFormBean.getNomineeDetails());
		 ScheduleBean.setNotAnClitizen(RegistrationFormBean.getNotAnClitizen());
		 ScheduleBean.setNotAnClitizen(RegistrationFormBean.getNotAnClitizen());
		 ScheduleBean.setOtherProfessional(RegistrationFormBean.getOtherProfessional());
		 ScheduleBean.setPendingCriminalCases(RegistrationFormBean.getPendingCriminalCases());
		 ScheduleBean.setPhone(RegistrationFormBean.getPhone());
		 ScheduleBean.setPlaceOfPractice(RegistrationFormBean.getPlaceOfPractice());
		 ScheduleBean.setPlaceOfPracticeFromStep2(RegistrationFormBean.getPlaceOfPracticeFromStep2());
		 ScheduleBean.setPreviousApplicationDetails(RegistrationFormBean.getPreviousApplicationDetails());
		 ScheduleBean.setPreviousEmployment(RegistrationFormBean.getPreviousEmployment());
		 ScheduleBean.setProportionOfShare(RegistrationFormBean.getProportionOfShare());
		 ScheduleBean.setRegNumber(RegistrationFormBean.getRegNumber());
		 ScheduleBean.setState(RegistrationFormBean.getState());
		 ScheduleBean.setTerminatedDetails(RegistrationFormBean.getTerminatedDetails());
		 ScheduleBean.setUniversity_Name(RegistrationFormBean.getUniversity_Name());
		 ScheduleBean.setYear_course(RegistrationFormBean.getYear_course());
		 ScheduleBean.setYear_of_Completion(RegistrationFormBean.getYear_of_Completion());
		 ScheduleBean.setZipCode(RegistrationFormBean.getZipCode());
		 ScheduleBean.setGenderCategory(RegistrationFormBean.getGenderCategory());
		 ScheduleBean.setCastCategory(RegistrationFormBean.getCastCategory());
		 // Please do For all other paarameters
		 Session.saveOrUpdate(ScheduleBean);
		 Session.delete(RegistrationFormBean);
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	}

	@Override
	public String MoveTOInterviewListFromAbsentList(String RegNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from AbsentBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<AbsentBean> list = (ArrayList<AbsentBean>)query.list();
		 AbsentBean RegistrationFormBean= list.get(0);
		 
		 ScheduleBean ScheduleBean= new ScheduleBean();
		 ScheduleBean.setRegNumber(RegistrationFormBean.getRegNumber());
		 // Please do For all other paarameters
		 
		 ScheduleBean.setRegNumber(RegistrationFormBean.getRegNumber());
		 ScheduleBean.setAddress(RegistrationFormBean.getAddress());
		 ScheduleBean.setAddressFromStep3(RegistrationFormBean.getAddressFromStep3());
		 ScheduleBean.setBirthdate(RegistrationFormBean.getBirthdate());
		 ScheduleBean.setBloodGroup(RegistrationFormBean.getBloodGroup());
		 ScheduleBean.setBusinessDetails(RegistrationFormBean.getBusinessDetails());
		 ScheduleBean.setCitizenOfIndia(RegistrationFormBean.getCitizenOfIndia());
		 ScheduleBean.setCity(RegistrationFormBean.getCity());
		 ScheduleBean.setCollege(RegistrationFormBean.getCollege());
		 ScheduleBean.setConvictedDetails(RegistrationFormBean.getConvictedDetails());
		 ScheduleBean.setDiscontinuanceOfPractice(RegistrationFormBean.getDiscontinuanceOfPractice());
		 ScheduleBean.setEmail(RegistrationFormBean.getEmail());
		 ScheduleBean.setFather_name(RegistrationFormBean.getFather_name());
		 ScheduleBean.setFirst_name(RegistrationFormBean.getFirst_name());
		 ScheduleBean.setFullName(RegistrationFormBean.getFullName());
		 ScheduleBean.setNomineeDetails(RegistrationFormBean.getNomineeDetails());
		 ScheduleBean.setNotAnClitizen(RegistrationFormBean.getNotAnClitizen());
		 ScheduleBean.setNotAnClitizen(RegistrationFormBean.getNotAnClitizen());
		 ScheduleBean.setOtherProfessional(RegistrationFormBean.getOtherProfessional());
		 ScheduleBean.setPendingCriminalCases(RegistrationFormBean.getPendingCriminalCases());
		 ScheduleBean.setPhone(RegistrationFormBean.getPhone());
		 ScheduleBean.setPlaceOfPractice(RegistrationFormBean.getPlaceOfPractice());
		 ScheduleBean.setPlaceOfPracticeFromStep2(RegistrationFormBean.getPlaceOfPracticeFromStep2());
		 ScheduleBean.setPreviousApplicationDetails(RegistrationFormBean.getPreviousApplicationDetails());
		 ScheduleBean.setPreviousEmployment(RegistrationFormBean.getPreviousEmployment());
		 ScheduleBean.setProportionOfShare(RegistrationFormBean.getProportionOfShare());
		 ScheduleBean.setRegNumber(RegistrationFormBean.getRegNumber());
		 ScheduleBean.setState(RegistrationFormBean.getState());
		 ScheduleBean.setTerminatedDetails(RegistrationFormBean.getTerminatedDetails());
		 ScheduleBean.setUniversity_Name(RegistrationFormBean.getUniversity_Name());
		 ScheduleBean.setYear_course(RegistrationFormBean.getYear_course());
		 ScheduleBean.setYear_of_Completion(RegistrationFormBean.getYear_of_Completion());
		 ScheduleBean.setZipCode(RegistrationFormBean.getZipCode());
		 
		 ScheduleBean.setGenderCategory(RegistrationFormBean.getGenderCategory());
		 ScheduleBean.setCastCategory(RegistrationFormBean.getCastCategory());
		 Session.saveOrUpdate(ScheduleBean);
		 Session.delete(RegistrationFormBean);
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	}
//ScheduleConfirmationBean
	@Override
	public String MoveTOInterviewConfirmationList(String RegNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleBean> list = (ArrayList<ScheduleBean>)query.list();
		 ScheduleBean ScheduleBean= list.get(0);
		 
		 ScheduleConfirmationBean ScheduleConfirmationBean= new ScheduleConfirmationBean();
		 ScheduleConfirmationBean.setRegNumber(ScheduleBean.getRegNumber());
		 // Please do For all other paarameters
		 Session.saveOrUpdate(ScheduleConfirmationBean);
		 Session.delete(ScheduleBean);
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	}

	@Override
	public int RandomNumberForRegNumber() {
		
		
		int random = (int )(Math.random() * 10000000 + 100000000);

		    return random;
	}

	@Override
	public String RegNumberGenration(String FirstName) {
		
		String Name=FirstName.substring(0, 2);
		
		return (Name+RandomNumberForRegNumber());
	}

	@Override
	public String GetDomainFromUSernameandPassword(String UserName, String Password) {
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		String Sql = "select * from DomainLoginBean where UserName = :UserName and Password =:Password";
	/*	Query query = Session.createQuery("select D from DomainLoginBean D where (D.UserName:UserName) and (D.Password:Password)");*/
		SQLQuery query = Session.createSQLQuery(Sql);
		query.setParameter("UserName", UserName);
		query.setParameter("Password", Password);
		 query.addEntity(DomainLoginBean.class);
    //     List employees = (List) query.list();
		 @SuppressWarnings("unchecked")
		ArrayList<DomainLoginBean> list = (ArrayList<DomainLoginBean>)query.list();
		 System.out.println(list);
		 Session.close();
		return list.get(0).getDomain();
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String InsertintoLoginDomain(String UserName, String Password, String Domain) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Transaction Tx = Session.beginTransaction();
		DomainLoginBean DomainLoginBean = new DomainLoginBean();
		DomainLoginBean.setDomain(Domain);
		DomainLoginBean.setPassword(Password);
		DomainLoginBean.setUserName(UserName);
		Session.saveOrUpdate(DomainLoginBean);
		Tx.commit();
		Session.close();
		return "Success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String GetPathforCertificate(String RegNumber) {
		String DownlOadDirectiory = "";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        byte[] Bytearray=null;
        String FileName="";
        String FilePath="";
        try {
             
            transaction = session.beginTransaction();
             ArrayList<FileUploadBean> employees = (ArrayList<FileUploadBean>) session.createQuery("from FileUploadBean where RegNumber ='" + RegNumber + "'").list();
           
            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
            	FileUploadBean user = (FileUploadBean) iterator.next();
                Blob blob = user.getChallanScanedCopy();
                 FileName=RegNumber+"ChallanScanedCopy"+".png";
                 FilePath= DownlOadDirectiory+File.separator+FileName;
                FileOutputStream fos = new FileOutputStream(DownlOadDirectiory+File.separator+FileName); 
                Bytearray = blob.getBytes(1, (int)blob.length());
                
                System.out.println(Bytearray);
                fos.write(blob.getBytes(1, (int)blob.length()));
                fos.close();
            }
            transaction.commit();
            return FilePath;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		return FilePath;
    
	}

	@Override
	public String AbsentListForJSP() {
		
		String responseString="Sorry Absent List is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<AbsentBean> absentList=JSPRelatedFunctionsimp.ViewInterviewAbsentCandidate();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			
			/*responseString="	<!DOCTYPE html> "
					+"<html> "
					+"<head> "
					+"<meta charset=\"ISO-8859-1\"> "
					+"<title>Insert title here</title> "
					+"<style type=\"text/css\"> "




					+".a { "
					 +"   width: 1px; "
					  +"  border: 1px white; "
					  +"  padding: 100px; "
					 +"   margin: 0px; "
					 +"} "

					+"body{ "
					 +"  page-break-inside: avoid; "
					 +"} "


					+"h1 { "
					+"page-break-before: always; "
					+"}   "

					+"</style> "

					 
					+"</head> "; // for certificate
*/			   responseString="<table class='table table-bordered'><thead><tr><th>#</th>"
		+ "<th>Reg Number</th><th>Name</th><th>Father Name</th>"
	  +  "<th>DOB</th> <th>ReSchedule</th><th>Reject</th> </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			/*java.sql.Date dat=null;
			java.sql.Timestamp timestamp =null;*/
			   for (AbsentBean RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>1</th>"
						    +  " <td><b> " +RegBean.getRegNumber()+"</b></td>"
						      +  " <td><b> " +RegBean.getFullName()+"</b></td>"
						      +  " <td><b> " +RegBean.getFather_name()+"</b></td>"
						      +  " <td><b> " +RegBean.getBirthdate()+"</b></td>"
						        +"   <td><b> <button class=\"btn btn-info\" name='Decline' onclick=\" CallToServletFromJSP('"+RegBean.getRegNumber()+ "','"+ "ReScheduletheAbsentCandidate" +"');\" >Re Schedule</button></b></td>"
				 
				   +"   <td><b> <button class=\"btn btn-warning\" name='Decline' onclick=\" CallToServletFromJSP('"+RegBean.getRegNumber()+ "','"+ "DeclientheCandidate" +"');\" >Decline</button></b></td>";
				  
				/*   dat = RegBean.getEnrolledDate();
					 timestamp = new java.sql.Timestamp(dat.getTime());
					 responseString+=JSPRelatedFunctionsimp.GenerateCertificate(RegBean.getKARNumber(), RegBean.getFather_name(), RegBean.getFullName(), timestamp,RegBean.getRegNumber(),0);
				*/		
			}
	  
			   responseString += 
	      

	 " </tbody> "+  "</table>";  // table
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public String ViewInterviewCandidateForJSP() {
		
		String responseString="Sorry List is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<ValidatedPayedRegistrationChallan> absentList=JSPRelatedFunctionsimp.ViewPaymentValidatedCandidate();
		
		if (absentList.get(0)==null)
		{
			System.out.println("Coming into if part");
		return responseString;	
		}
		
		else 
		{
			
			System.out.println("Shedule confirm list"
					+ absentList);
			
			System.out.println("Coming into else part");
			   responseString="<table class='table table-bordered'><thead><tr><th>#</th>"
			   		+ "<th>Reg Number</th> <th>Name</th><th>Father Name</th>"
	  +  "<th>DOB</th> "
	  + "<th>Done</th>"
	  + " </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int indexForSchedule=1;
			   
			   for (ValidatedPayedRegistrationChallan RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+indexForSchedule+"</th>"
						    +  " <td><b> " +RegBean.getRegNumber()+"</b></td>"
						      +  " <td><b> " +RegBean.getFullName()+"</b></td>"
						      +  " <td><b> " +RegBean.getFather_name()+"</b></td>"
						      +  " <td><b> " +RegBean.getBirthdate()+"</b></td>"
						     +"   <td><b> <button  class=\"btn btn-info\" name='Decline' onclick=\" CallToServletFromJSP('"+RegBean.getRegNumber()+ "','"+ "DeclientheCandidate" +"');\" >Decline</button></b></td>"
				   +" </tr>";
				   indexForSchedule++;
			}
	  
			   responseString += /* " <td><b> " 
	      
	      
+ "<form id='FormForScheduleInterview'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='ConfirmChallanPay' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='ConfirmChallanPay' value='ConfirmChallanPay'  id='ConfirmChallanPay'  >"
	
+"	</form> "
	


	

 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#ConfirmChallanPay').click(function(event) { "
+ "alert('********** challan ***********');"
+" var RegNumber=$('#RegNumber').val(); "
	+ "var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
+"</b></td>"
	      +  " <td><b> " 
	      

+ "<form id='FormForViewChallan'   target='_blank'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='SeeChallan' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='SeeChallan' value='SeeChallan'  id='SeeChallan'  >"
		
	+"	</form> "
		

	
		
	
 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#SeeChallan').click(function(event) { "
	+ "alert('********** SeeChallan ***********');"
	+" var RegNumber=$('#RegNumber').val(); "

		+ "var WhichFunctionToHandle='SeeChallan';"
		+"alert(WhichFunctionToHandle);"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
	      +"</b></td>"
	              
	    
	   +  " </tr>"*/
	  /* +  " <tr>"
	   +  "   <th scope='row'>2</th>"
	    +  "  <td><b>Jacob</b></td>"
	    +  "  <td><b>Thornton</b></td>"
	    +  "  <td><b>@fat</b></td>"
	   +  " </tr>"
	  +  "  <tr>"
	   +  "   <th scope='row'>3</th>"
	   +  "   <td><b>Larry</b></td>"
	   +  "   <td><b>the Bird</b></td>"
	   +  "   <td><b>@twitter</b></td>"
	  +  "  </tr> "*/
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public String ConfirmInterviewJSP() {
		
		String responseString="Sorry  List is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<ScheduleConfirmationBean> absentList=JSPRelatedFunctionsimp.ViewInterviewCandidate();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			String WhichFunctionToHandle="ConfirmTheScheduledInterview";
			String WhichFunctionToHandle2="ConfirmTheScheduledInterviewAll";
			   responseString="<table class='table table-bordered'><thead><tr>"
			   		+ "<th>#</th><th>Reg Number</th><th>Name</th>"
			   		+ "<th>Father</th>"
	  +  "<th>BirthDate</th>"
	  + " <th>Confirm</th>  <th>Re Schedule</th><th>Edit</th> </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int indexForSchedule=1;
			   
			   for (ScheduleConfirmationBean RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+indexForSchedule+"</th>"
						    +  " <td><b> " +RegBean.getRegNumber()+"</b></td>"
						      +  " <td><b> " +RegBean.getFullName()+"</b></td>"
					 +  " <td><b> " +RegBean.getFather_name()+"</b></td>"
						      +  " <td><b> " +RegBean.getBirthdate()+"</b></td>"
						 
						      
						  +"   <td><b> <button  class=\"btn btn-info\" name='Confirm' onclick=\" CallToServletFromJSP('"+RegBean.getRegNumber()+ "','"+ WhichFunctionToHandle +"');\" >Confirm</button></b></td>"
				     +"   <td><b> <button  class=\"btn btn-warning\" name='Decline' onclick=\" CallToServletFromJSP('"+RegBean.getRegNumber()+ "','"+ "ReScheduletheAbsentCandidate" +"');\" >Re Schedule</button></b></td>"
				     +"   <td><b> <button  class=\"btn btn-primary\" name='Decline' onclick=\" CallToServletFromJSP('"+RegBean.getRegNumber()+ "','"+ "EditConfirmList" +"');\" >Edit</button></b></td>"
						 +"</tr>";
				   indexForSchedule++;
			}
	  
			   responseString += 
					   " </tbody> "+  "</table>"
					 +  "  <b> <button name='Confirm'  class=\"btn btn-info\" onclick=\" CallToServletFromJSP('"+WhichFunctionToHandle2+ "','"+ WhichFunctionToHandle2 +"');\" >Confirm All</button></b>"
					 
	; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public ArrayList<ScheduleConfirmationBean> ViewScheduleConfirmationBean() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleConfirmationBean");
		
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleConfirmationBean> list = (ArrayList<ScheduleConfirmationBean>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public ArrayList<ValidatedPayedRegistrationChallan> ViewPaymentValidatedCandidate() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedPayedRegistrationChallan");
		
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedPayedRegistrationChallan> list = (ArrayList<ValidatedPayedRegistrationChallan>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public ValidatedPayedRegistrationChallan GetDetailsForRegNumberFromValidatedPayedRegistrationChallan(
			String RegNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedPayedRegistrationChallan where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedPayedRegistrationChallan> list = (ArrayList<ValidatedPayedRegistrationChallan>)query.list();
		 Session.close();
		return list.get(0);
		}
		catch(Exception e)
		{
		return null;	
		}
	}

	@Override
	public String ScheduleInterviewBydate(String Date, String RegNumber) {
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		
		 SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		 
		 java.sql.Date sqlDate = null ;
	         java.util.Date parsed = null;
			try {
				parsed =  format.parse(Date);
				sqlDate = new java.sql.Date(parsed.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Errorrrrrrrrrrrrrrr");
				return "";
			}
			DateScheduleForInterviewBean DateScheduleForInterviewBean= new DateScheduleForInterviewBean();
			DateScheduleForInterviewBean.setDateOfSchedule(sqlDate);
			DateScheduleForInterviewBean.setRegNumber(RegNumber);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
			 String result=JSPRelatedFunctionsimp.MoveToScheduleConfirmationBeanInterviewtList(RegNumber);
			 
			 System.out.println(result + " Moving from schdule bean to schedule confirm bean" );
	Session.saveOrUpdate(DateScheduleForInterviewBean);
	Session.beginTransaction().commit();
		 Session.close();
	
		return result;
		}
		catch ( Exception e)
		{
			e.printStackTrace();
			
		return "";	
		}
	}

	@Override
	public String MoveToScheduleConfirmationBeanInterviewtList(String RegNumber) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedPayedRegistrationChallan where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedPayedRegistrationChallan> list = (ArrayList<ValidatedPayedRegistrationChallan>)query.list();
		 ValidatedPayedRegistrationChallan ValidatedPayedRegistrationChallan= list.get(0);
		 
		 ScheduleConfirmationBean ScheduleConfirmationBean= new ScheduleConfirmationBean();
		 ScheduleConfirmationBean.setRegNumber(ValidatedPayedRegistrationChallan.getRegNumber());
		 ScheduleConfirmationBean.setAddress(ValidatedPayedRegistrationChallan.getAddress());
		 ScheduleConfirmationBean.setAddressFromStep3(ValidatedPayedRegistrationChallan.getAddressFromStep3());
		 ScheduleConfirmationBean.setBirthdate(ValidatedPayedRegistrationChallan.getBirthdate());
		 ScheduleConfirmationBean.setBloodGroup(ValidatedPayedRegistrationChallan.getBloodGroup());
		 ScheduleConfirmationBean.setBusinessDetails(ValidatedPayedRegistrationChallan.getBusinessDetails());
		 ScheduleConfirmationBean.setCitizenOfIndia(ValidatedPayedRegistrationChallan.getCitizenOfIndia());
		 ScheduleConfirmationBean.setCity(ValidatedPayedRegistrationChallan.getCity());
		 ScheduleConfirmationBean.setCollege(ValidatedPayedRegistrationChallan.getCollege());
		 ScheduleConfirmationBean.setConvictedDetails(ValidatedPayedRegistrationChallan.getConvictedDetails());
		 ScheduleConfirmationBean.setDiscontinuanceOfPractice(ValidatedPayedRegistrationChallan.getDiscontinuanceOfPractice());
		 ScheduleConfirmationBean.setEmail(ValidatedPayedRegistrationChallan.getEmail());
		 ScheduleConfirmationBean.setFather_name(ValidatedPayedRegistrationChallan.getFather_name());
		 ScheduleConfirmationBean.setFirst_name(ValidatedPayedRegistrationChallan.getFirst_name());
		 ScheduleConfirmationBean.setFullName(ValidatedPayedRegistrationChallan.getFullName());
		 ScheduleConfirmationBean.setNomineeDetails(ValidatedPayedRegistrationChallan.getNomineeDetails());
		 ScheduleConfirmationBean.setNotAnClitizen(ValidatedPayedRegistrationChallan.getNotAnClitizen());
		 ScheduleConfirmationBean.setNotAnClitizen(ValidatedPayedRegistrationChallan.getNotAnClitizen());
		 ScheduleConfirmationBean.setOtherProfessional(ValidatedPayedRegistrationChallan.getOtherProfessional());
		 ScheduleConfirmationBean.setPendingCriminalCases(ValidatedPayedRegistrationChallan.getPendingCriminalCases());
		 ScheduleConfirmationBean.setPhone(ValidatedPayedRegistrationChallan.getPhone());
		 ScheduleConfirmationBean.setPlaceOfPractice(ValidatedPayedRegistrationChallan.getPlaceOfPractice());
		 ScheduleConfirmationBean.setPlaceOfPracticeFromStep2(ValidatedPayedRegistrationChallan.getPlaceOfPracticeFromStep2());
		 ScheduleConfirmationBean.setPreviousApplicationDetails(ValidatedPayedRegistrationChallan.getPreviousApplicationDetails());
		 ScheduleConfirmationBean.setPreviousEmployment(ValidatedPayedRegistrationChallan.getPreviousEmployment());
		 ScheduleConfirmationBean.setProportionOfShare(ValidatedPayedRegistrationChallan.getProportionOfShare());
		 ScheduleConfirmationBean.setRegNumber(ValidatedPayedRegistrationChallan.getRegNumber());
		 ScheduleConfirmationBean.setState(ValidatedPayedRegistrationChallan.getState());
		 ScheduleConfirmationBean.setTerminatedDetails(ValidatedPayedRegistrationChallan.getTerminatedDetails());
		 ScheduleConfirmationBean.setUniversity_Name(ValidatedPayedRegistrationChallan.getUniversity_Name());
		 ScheduleConfirmationBean.setYear_course(ValidatedPayedRegistrationChallan.getYear_course());
		 ScheduleConfirmationBean.setYear_of_Completion(ValidatedPayedRegistrationChallan.getYear_of_Completion());
		 ScheduleConfirmationBean.setZipCode(ValidatedPayedRegistrationChallan.getZipCode());
		 ScheduleConfirmationBean.setGenderCategory(ValidatedPayedRegistrationChallan.getGenderCategory());
		 ScheduleConfirmationBean.setCastCategory(ValidatedPayedRegistrationChallan.getCastCategory());
		 
		 // Please do For all other paarameters
		 Session.saveOrUpdate(ScheduleConfirmationBean);
		 Session.delete(ValidatedPayedRegistrationChallan);
		  Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
			return "";
		}
	
	}

	@Override
	public String ViewInterviewConfirmCandidateForJSP() {
		
		String responseString="Sorry  List is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<ScheduleInterviewListBean> absentList=JSPRelatedFunctionsimp.ViewInterviewconfirmCandidate();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>#</th>"
			   		+ "<th>Reg Number</th><th>Name</th><th>Father</th>"
	  +  "<th>DOB</th><th>Accept</th><th>Absent</th> <th>Decline</th>  </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int indexForSchedule=1;
			   
			   for (ScheduleInterviewListBean RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+indexForSchedule+"</th>"
						    +  " <td><b> " +RegBean.getRegNumber()+"</b></td>"
						      +  " <td><b> " +RegBean.getFullName()+"</b></td>"
						      +  " <td><b> " +RegBean.getFather_name()+"</b></td>"
						      +  " <td><b> " +RegBean.getBirthdate()+"</b></td>"
						   
						      
						      
						       +"   <td><b> <button name='Confirm' class=\"btn btn-info\" onclick=\" CallToServletFromJSP('"+RegBean.getRegNumber()+ "','"+ "AcceptTheCandidateMoveTOKAR" +"');\" >Accept</button></b></td>"
						       +"   <td><b> <button name='Absent'  class=\"btn btn-warning\" onclick=\" CallToServletFromJSP('"+RegBean.getRegNumber()+ "','"+ "AbsentCandidateMoveTOAbsentList" +"');\" >Absent</button></b></td>"
						       +"   <td><b> <button name='Decline'  class=\"btn btn-primary\" onclick=\" CallToServletFromJSP('"+RegBean.getRegNumber()+ "','"+ "DeclientheCandidate" +"');\" >Decline</button></b></td>"
				   +" </tr>";
				   indexForSchedule++;
			}
			   responseString += 
						 " </tbody> "+  "</table>";  
			   responseString+=
					   
					   "   <b> <button class=\"btn btn-info\" name='Decline' onclick=\" CallToServletFromJSP('"+ "AcceptAll" +"','"+ "AcceptAll" +"');\" >Accept All</button></b>"
					  + "<form action=\"GenrateInterViewCandidateReport\"  class=\"btn btn-info\" name='GenrateInterViewCandidateReport'>"
	
	+"<input type=\"button\"  class=\"btn btn-info\" value=\"Generate Enrollment Candidate\"  onclick=\" CallToServletForReport() \"  name=\"GenerateEnrollmentCandidate\"></form>";
			  
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public ArrayList<ScheduleInterviewListBean> ViewInterviewconfirmCandidate() {
		
		// This method to see the ppl who interview is confirmed.
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleInterviewListBean");
		System.out.println("Coming here ViewInterviewconfirmCandidate ");
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleInterviewListBean> list = (ArrayList<ScheduleInterviewListBean>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String MoveToScheduleInterviewListFromConfirmationBean(String RegNumber) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleConfirmationBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleConfirmationBean> list = (ArrayList<ScheduleConfirmationBean>)query.list();
		 ScheduleConfirmationBean ScheduleConfirmationBean= list.get(0);
		 
		 ScheduleInterviewListBean ScheduleInterviewListBean= new ScheduleInterviewListBean();
		 ScheduleInterviewListBean.setRegNumber(ScheduleConfirmationBean.getRegNumber());
		 ScheduleInterviewListBean.setAddress(ScheduleConfirmationBean.getAddress());
		 ScheduleInterviewListBean.setAddressFromStep3(ScheduleConfirmationBean.getAddressFromStep3());
		 ScheduleInterviewListBean.setBirthdate(ScheduleConfirmationBean.getBirthdate());
		 ScheduleInterviewListBean.setBloodGroup(ScheduleConfirmationBean.getBloodGroup());
		 ScheduleInterviewListBean.setBusinessDetails(ScheduleConfirmationBean.getBusinessDetails());
		 ScheduleInterviewListBean.setCitizenOfIndia(ScheduleConfirmationBean.getCitizenOfIndia());
		 ScheduleInterviewListBean.setCity(ScheduleConfirmationBean.getCity());
		 ScheduleInterviewListBean.setCollege(ScheduleConfirmationBean.getCollege());
		 ScheduleInterviewListBean.setConvictedDetails(ScheduleConfirmationBean.getConvictedDetails());
		 ScheduleInterviewListBean.setDiscontinuanceOfPractice(ScheduleConfirmationBean.getDiscontinuanceOfPractice());
		 ScheduleInterviewListBean.setEmail(ScheduleConfirmationBean.getEmail());
		 ScheduleInterviewListBean.setFather_name(ScheduleConfirmationBean.getFather_name());
		 ScheduleInterviewListBean.setFirst_name(ScheduleConfirmationBean.getFirst_name());
		 ScheduleInterviewListBean.setFullName(ScheduleConfirmationBean.getFullName());
		 ScheduleInterviewListBean.setNomineeDetails(ScheduleConfirmationBean.getNomineeDetails());
		 ScheduleInterviewListBean.setNotAnClitizen(ScheduleConfirmationBean.getNotAnClitizen());
		 ScheduleInterviewListBean.setNotAnClitizen(ScheduleConfirmationBean.getNotAnClitizen());
		 ScheduleInterviewListBean.setOtherProfessional(ScheduleConfirmationBean.getOtherProfessional());
		 ScheduleInterviewListBean.setPendingCriminalCases(ScheduleConfirmationBean.getPendingCriminalCases());
		 ScheduleInterviewListBean.setPhone(ScheduleConfirmationBean.getPhone());
		 ScheduleInterviewListBean.setPlaceOfPractice(ScheduleConfirmationBean.getPlaceOfPractice());
		 ScheduleInterviewListBean.setPlaceOfPracticeFromStep2(ScheduleConfirmationBean.getPlaceOfPracticeFromStep2());
		 ScheduleInterviewListBean.setPreviousApplicationDetails(ScheduleConfirmationBean.getPreviousApplicationDetails());
		 ScheduleInterviewListBean.setPreviousEmployment(ScheduleConfirmationBean.getPreviousEmployment());
		 ScheduleInterviewListBean.setProportionOfShare(ScheduleConfirmationBean.getProportionOfShare());
		 ScheduleInterviewListBean.setRegNumber(ScheduleConfirmationBean.getRegNumber());
		 ScheduleInterviewListBean.setState(ScheduleConfirmationBean.getState());
		 ScheduleInterviewListBean.setTerminatedDetails(ScheduleConfirmationBean.getTerminatedDetails());
		 ScheduleInterviewListBean.setUniversity_Name(ScheduleConfirmationBean.getUniversity_Name());
		 ScheduleInterviewListBean.setYear_course(ScheduleConfirmationBean.getYear_course());
		 ScheduleInterviewListBean.setYear_of_Completion(ScheduleConfirmationBean.getYear_of_Completion());
		 ScheduleInterviewListBean.setZipCode(ScheduleConfirmationBean.getZipCode());
		 ScheduleInterviewListBean.setGenderCategory(ScheduleConfirmationBean.getGenderCategory());
		 ScheduleInterviewListBean.setCastCategory(ScheduleConfirmationBean.getCastCategory());
		 
		 // Please do For all other paarameters
		 Session.saveOrUpdate(ScheduleInterviewListBean);
		 Session.delete(ScheduleConfirmationBean);
		  Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	}

	@Override
	public String DeclainTheCandidate(String RegNumber) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleInterviewListBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleInterviewListBean> list = (ArrayList<ScheduleInterviewListBean>)query.list();
		 try
		 {
		 ScheduleInterviewListBean ScheduleInterviewListBean= list.get(0);
		 Session.delete(ScheduleInterviewListBean);
		 
		 }
		 catch (Exception e)
		 {
			 try
			 {
			 Query query1 = Session.createQuery("from AbsentBean where RegNumber = :RegNumber ");
				query1.setParameter("RegNumber", RegNumber);
				 @SuppressWarnings("unchecked")
				ArrayList<AbsentBean> list1 = (ArrayList<AbsentBean>)query1.list();	
				 AbsentBean AbsentBean= list1.get(0);
				 Session.delete(AbsentBean);
				 
			 }
			 
			 catch (Exception ex)
			 {
				 Query query1 = Session.createQuery("from ValidatedPayedRegistrationChallan where RegNumber = :RegNumber ");
					query1.setParameter("RegNumber", RegNumber);
					 @SuppressWarnings("unchecked")
					ArrayList<ValidatedPayedRegistrationChallan> list1 = (ArrayList<ValidatedPayedRegistrationChallan>)query1.list();	
					 ValidatedPayedRegistrationChallan AbsentBean= list1.get(0);
					 Session.delete(AbsentBean);	 
			 }
		 }
		 
			 
			  
		 
		 
		 // Please do For all other paarameters
		
		  Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	}

	@Override
	public String ReScheduletheAbsentCandidate(String RegNumber) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from AbsentBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<AbsentBean> list = (ArrayList<AbsentBean>)query.list();
		 AbsentBean AbsentBean= list.get(0);
		 
		 AcceptedCandidate ScheduleBean= new AcceptedCandidate();
		 ScheduleBean.setRegNumber(AbsentBean.getRegNumber());
		 ScheduleBean.setAddress(AbsentBean.getAddress());
		 ScheduleBean.setAddressFromStep3(AbsentBean.getAddressFromStep3());
		 ScheduleBean.setBirthdate(AbsentBean.getBirthdate());
		 ScheduleBean.setBloodGroup(AbsentBean.getBloodGroup());
		 ScheduleBean.setBusinessDetails(AbsentBean.getBusinessDetails());
		 ScheduleBean.setCitizenOfIndia(AbsentBean.getCitizenOfIndia());
		 ScheduleBean.setCity(AbsentBean.getCity());
		 ScheduleBean.setCollege(AbsentBean.getCollege());
		 ScheduleBean.setConvictedDetails(AbsentBean.getConvictedDetails());
		 ScheduleBean.setDiscontinuanceOfPractice(AbsentBean.getDiscontinuanceOfPractice());
		 ScheduleBean.setEmail(AbsentBean.getEmail());
		 ScheduleBean.setFather_name(AbsentBean.getFather_name());
		 ScheduleBean.setFirst_name(AbsentBean.getFirst_name());
		 ScheduleBean.setFullName(AbsentBean.getFullName());
		 ScheduleBean.setNomineeDetails(AbsentBean.getNomineeDetails());
		 ScheduleBean.setNotAnClitizen(AbsentBean.getNotAnClitizen());
		 ScheduleBean.setNotAnClitizen(AbsentBean.getNotAnClitizen());
		 ScheduleBean.setOtherProfessional(AbsentBean.getOtherProfessional());
		 ScheduleBean.setPendingCriminalCases(AbsentBean.getPendingCriminalCases());
		 ScheduleBean.setPhone(AbsentBean.getPhone());
		 ScheduleBean.setPlaceOfPractice(AbsentBean.getPlaceOfPractice());
		 ScheduleBean.setPlaceOfPracticeFromStep2(AbsentBean.getPlaceOfPracticeFromStep2());
		 ScheduleBean.setPreviousApplicationDetails(AbsentBean.getPreviousApplicationDetails());
		 ScheduleBean.setPreviousEmployment(AbsentBean.getPreviousEmployment());
		 ScheduleBean.setProportionOfShare(AbsentBean.getProportionOfShare());
		 ScheduleBean.setRegNumber(AbsentBean.getRegNumber());
		 ScheduleBean.setState(AbsentBean.getState());
		 ScheduleBean.setTerminatedDetails(AbsentBean.getTerminatedDetails());
		 ScheduleBean.setUniversity_Name(AbsentBean.getUniversity_Name());
		 ScheduleBean.setYear_course(AbsentBean.getYear_course());
		 ScheduleBean.setYear_of_Completion(AbsentBean.getYear_of_Completion());
		 ScheduleBean.setZipCode(AbsentBean.getZipCode());
		 ScheduleBean.setGenderCategory(AbsentBean.getGenderCategory());
		 ScheduleBean.setCastCategory(AbsentBean.getCastCategory());
		 
		 
		 // Please do For all other paarameters
		 Session.saveOrUpdate(ScheduleBean);
		 Session.delete(AbsentBean);
		  Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			try
			{
			Session Session = HibernateUtil.getSessionFactory().openSession();
			Session.beginTransaction();
			Query query = Session.createQuery("from ScheduleConfirmationBean where RegNumber = :RegNumber ");
			query.setParameter("RegNumber", RegNumber);
			 @SuppressWarnings("unchecked")
			ArrayList<ScheduleConfirmationBean> list = (ArrayList<ScheduleConfirmationBean>)query.list();
			 ScheduleConfirmationBean AbsentBean= list.get(0);
			 
			 ValidatedPayedRegistrationChallan ScheduleBean= new ValidatedPayedRegistrationChallan();
			 ScheduleBean.setRegNumber(AbsentBean.getRegNumber());
			 ScheduleBean.setAddress(AbsentBean.getAddress());
			 ScheduleBean.setAddressFromStep3(AbsentBean.getAddressFromStep3());
			 ScheduleBean.setBirthdate(AbsentBean.getBirthdate());
			 ScheduleBean.setBloodGroup(AbsentBean.getBloodGroup());
			 ScheduleBean.setBusinessDetails(AbsentBean.getBusinessDetails());
			 ScheduleBean.setCitizenOfIndia(AbsentBean.getCitizenOfIndia());
			 ScheduleBean.setCity(AbsentBean.getCity());
			 ScheduleBean.setCollege(AbsentBean.getCollege());
			 ScheduleBean.setConvictedDetails(AbsentBean.getConvictedDetails());
			 ScheduleBean.setDiscontinuanceOfPractice(AbsentBean.getDiscontinuanceOfPractice());
			 ScheduleBean.setEmail(AbsentBean.getEmail());
			 ScheduleBean.setFather_name(AbsentBean.getFather_name());
			 ScheduleBean.setFirst_name(AbsentBean.getFirst_name());
			 ScheduleBean.setFullName(AbsentBean.getFullName());
			 ScheduleBean.setNomineeDetails(AbsentBean.getNomineeDetails());
			 ScheduleBean.setNotAnClitizen(AbsentBean.getNotAnClitizen());
			 ScheduleBean.setNotAnClitizen(AbsentBean.getNotAnClitizen());
			 ScheduleBean.setOtherProfessional(AbsentBean.getOtherProfessional());
			 ScheduleBean.setPendingCriminalCases(AbsentBean.getPendingCriminalCases());
			 ScheduleBean.setPhone(AbsentBean.getPhone());
			 ScheduleBean.setPlaceOfPractice(AbsentBean.getPlaceOfPractice());
			 ScheduleBean.setPlaceOfPracticeFromStep2(AbsentBean.getPlaceOfPracticeFromStep2());
			 ScheduleBean.setPreviousApplicationDetails(AbsentBean.getPreviousApplicationDetails());
			 ScheduleBean.setPreviousEmployment(AbsentBean.getPreviousEmployment());
			 ScheduleBean.setProportionOfShare(AbsentBean.getProportionOfShare());
			 ScheduleBean.setRegNumber(AbsentBean.getRegNumber());
			 ScheduleBean.setState(AbsentBean.getState());
			 ScheduleBean.setTerminatedDetails(AbsentBean.getTerminatedDetails());
			 ScheduleBean.setUniversity_Name(AbsentBean.getUniversity_Name());
			 ScheduleBean.setYear_course(AbsentBean.getYear_course());
			 ScheduleBean.setYear_of_Completion(AbsentBean.getYear_of_Completion());
			 ScheduleBean.setZipCode(AbsentBean.getZipCode());
			 ScheduleBean.setGenderCategory(AbsentBean.getGenderCategory());
			 ScheduleBean.setCastCategory(AbsentBean.getCastCategory());
			 
			 
			 // Please do For all other paarameters
			 Session.saveOrUpdate(ScheduleBean);
			 Session.delete(AbsentBean);
			  Session.beginTransaction().commit();
			 Session.close();
			 return "Success";
			}
			catch (Exception ex)
			{
				return "";
			}
		}
	
	}

	@Override
	public String AcceptTheCandidateMoveTOKAR(String RegNumber) {
		
		// changed to accepted..
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleInterviewListBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleInterviewListBean> list = (ArrayList<ScheduleInterviewListBean>)query.list();
		 ScheduleInterviewListBean ScheduleInterviewListBean= list.get(0);
		 
		 AcceptedCandidate ValidatedFinalBean= new AcceptedCandidate();
		 
		 ValidatedFinalBean.setState("Active");
		 ValidatedFinalBean.setRegNumber(ScheduleInterviewListBean.getRegNumber());
		 ValidatedFinalBean.setAddress(ScheduleInterviewListBean.getAddress());
		 ValidatedFinalBean.setAddressFromStep3(ScheduleInterviewListBean.getAddressFromStep3());
		 ValidatedFinalBean.setBirthdate(ScheduleInterviewListBean.getBirthdate());
		 ValidatedFinalBean.setBloodGroup(ScheduleInterviewListBean.getBloodGroup());
		 ValidatedFinalBean.setBusinessDetails(ScheduleInterviewListBean.getBusinessDetails());
		 ValidatedFinalBean.setCitizenOfIndia(ScheduleInterviewListBean.getCitizenOfIndia());
		 ValidatedFinalBean.setCity(ScheduleInterviewListBean.getCity());
		 ValidatedFinalBean.setCollege(ScheduleInterviewListBean.getCollege());
		 ValidatedFinalBean.setConvictedDetails(ScheduleInterviewListBean.getConvictedDetails());
		 ValidatedFinalBean.setDiscontinuanceOfPractice(ScheduleInterviewListBean.getDiscontinuanceOfPractice());
		 ValidatedFinalBean.setEmail(ScheduleInterviewListBean.getEmail());
		 ValidatedFinalBean.setFather_name(ScheduleInterviewListBean.getFather_name());
		 ValidatedFinalBean.setFirst_name(ScheduleInterviewListBean.getFirst_name());
		 ValidatedFinalBean.setFullName(ScheduleInterviewListBean.getFullName());
		 ValidatedFinalBean.setNomineeDetails(ScheduleInterviewListBean.getNomineeDetails());
		 ValidatedFinalBean.setNotAnClitizen(ScheduleInterviewListBean.getNotAnClitizen());
		 ValidatedFinalBean.setNotAnClitizen(ScheduleInterviewListBean.getNotAnClitizen());
		 ValidatedFinalBean.setOtherProfessional(ScheduleInterviewListBean.getOtherProfessional());
		 ValidatedFinalBean.setPendingCriminalCases(ScheduleInterviewListBean.getPendingCriminalCases());
		 ValidatedFinalBean.setPhone(ScheduleInterviewListBean.getPhone());
		 ValidatedFinalBean.setPlaceOfPractice(ScheduleInterviewListBean.getPlaceOfPractice());
		 ValidatedFinalBean.setPlaceOfPracticeFromStep2(ScheduleInterviewListBean.getPlaceOfPracticeFromStep2());
		 ValidatedFinalBean.setPreviousApplicationDetails(ScheduleInterviewListBean.getPreviousApplicationDetails());
		 ValidatedFinalBean.setPreviousEmployment(ScheduleInterviewListBean.getPreviousEmployment());
		 ValidatedFinalBean.setProportionOfShare(ScheduleInterviewListBean.getProportionOfShare());
		 ValidatedFinalBean.setRegNumber(ScheduleInterviewListBean.getRegNumber());
		 ValidatedFinalBean.setState(ScheduleInterviewListBean.getState());
		 ValidatedFinalBean.setTerminatedDetails(ScheduleInterviewListBean.getTerminatedDetails());
		 ValidatedFinalBean.setUniversity_Name(ScheduleInterviewListBean.getUniversity_Name());
		 ValidatedFinalBean.setYear_course(ScheduleInterviewListBean.getYear_course());
		 ValidatedFinalBean.setYear_of_Completion(ScheduleInterviewListBean.getYear_of_Completion());
		 ValidatedFinalBean.setZipCode(ScheduleInterviewListBean.getZipCode());
		 java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		 System.out.println(date);
		 
		 
		 ValidatedFinalBean.setGenderCategory(ScheduleInterviewListBean.getGenderCategory());
		 ValidatedFinalBean.setCastCategory(ScheduleInterviewListBean.getCastCategory());
		 // Please do For all other paarameters
		 Session.saveOrUpdate(ValidatedFinalBean);
		 Session.delete(ScheduleInterviewListBean);
		  Session.beginTransaction().commit();
		 Session.close();
		 return "Moved To accepted ";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	
	}

	@Override
	public String UpdateAddressOfKARnumber(String KARnumber,String Address) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedFinalBean where KARNumber = :KARNumber ");
		query.setParameter("KARNumber", KARnumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
		
			 ValidatedFinalBean ScheduleInterviewListBean= list.get(0);
			 ScheduleInterviewListBean.setAddress(Address);
				 Session.saveOrUpdate(ScheduleInterviewListBean);
		 
		 
			 
			  
		 
		 
		 // Please do For all other paarameters
		
		  Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	}

	@Override
	public String UpdateNameOfKARnumber(String KARnumber,String Name) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedFinalBean where KARNumber = :KARNumber ");
		query.setParameter("KARNumber", KARnumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
		
			 ValidatedFinalBean ScheduleInterviewListBean= list.get(0);
			 ScheduleInterviewListBean.setFullName(Name);
				 Session.saveOrUpdate(ScheduleInterviewListBean);
		 
		 
		 // Please do For all other paarameters
		
		  Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	}

	@Override
	public String UpdateStatusOfKARnumber(String KARnumber, String Status) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedFinalBean where KARNumber = :KARNumber ");
		query.setParameter("KARNumber", KARnumber);
		System.out.println("UpdateStatusOfKARnumber inside");
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
		
			 ValidatedFinalBean ScheduleInterviewListBean= list.get(0);
			 ScheduleInterviewListBean.setKARStatus(Status);
				 Session.saveOrUpdate(ScheduleInterviewListBean);
		 
		 
			 
			  
		 
		 
		 // Please do For all other paarameters
		
		  Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("UpdateStatusOfKARnumber outside");
			return "";
		}
	
	}

	@Override
	public String UpdateNomineeOfKARnumber(String KARnumber, String Nominee) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedFinalBean where KARNumber = :KARNumber ");
		query.setParameter("KARNumber", KARnumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
		
			 ValidatedFinalBean ScheduleInterviewListBean= list.get(0);
			 ScheduleInterviewListBean.setNomineeDetails(Nominee);
				 Session.saveOrUpdate(ScheduleInterviewListBean);
		 
		 
			 
			  
		 
		 
		 // Please do For all other paarameters
		
		  Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	}

	@Override
	public String GetTheStatus(String KARnumber) {
		
		String ResponseString= "";
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ValidatedFinalBean where KARNumber = :KARNumber ");
		query.setParameter("KARNumber", KARnumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
		
			 ValidatedFinalBean ScheduleInterviewListBean= list.get(0);
			 String Status=ScheduleInterviewListBean.getKARStatus();
				
			 ResponseString= "Your Current Status is <b>" + Status+"</b>";
		 
			 
			  
		 
		 
		 // Please do For all other paarameters
		
		  Session.beginTransaction().commit();
		 Session.close();
		 return ResponseString;
		}
		catch (Exception e)
		{
			return ResponseString;
		}
	
	}

	@Override
	public double GetAmountForWelfareSelect(String KARnumber, String PayForWelfareSelect) {
		
		double ReturnValue=0.0;
		String inputValue="";
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		
		Query query = Session.createQuery("from FeeStructure ");
	
		 @SuppressWarnings("unchecked")
		ArrayList<FeeStructure> list = (ArrayList<FeeStructure>)query.list();
		
			System.out.println("HI Coming Here"); 
			//  System.out.println(results.get(0));
		 System.out.println(list.get(0).getAddressChange());
		 
		 // Please do For all other paarameters
		
		 switch(PayForWelfareSelect)
			{
			case "Apply For Change Of Status":ReturnValue=list.get(0).getChangeOfStatus();
			break;
		//	SerialNumber, AddressChange, ChangeOfStatus, NameChange, NomineeChange, PayForduplicateCertificate
			case "Name Change":ReturnValue=list.get(0).getNameChange();
			break;
			case "Nominee Change":ReturnValue=list.get(0).getNomineeChange();
			break;
			
			case "Address Change":ReturnValue=list.get(0).getAddressChange();
			break;
		
			
			case "Pay for duplicate Certificate":ReturnValue=list.get(0).getPayForduplicateCertificate();
			break;
			}
		 Session.close();
		 return ReturnValue;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return ReturnValue;
		}
	
	}

	@Override
	public ArrayList<EligibleKARChanges> ViewEligibleKARChanges() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from EligibleKARChanges");
		
		 @SuppressWarnings("unchecked")
		ArrayList<EligibleKARChanges> list = (ArrayList<EligibleKARChanges>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public String EligibleKARChangesJSP() {
		
		
		System.out.println("This is the one");
		String responseString="Sorry  List is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<EligibleKARChanges> absentList=JSPRelatedFunctionsimp.ViewEligibleKARChanges();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			
			   responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>KAR Number</th><th>For Which Function Paying For</th><th>See Challan</th>"
	  +  "<th>Confirm</th> </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int indexForSchedule=1;
			   
			   for (EligibleKARChanges RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+indexForSchedule+"</th>"
						    +  " <td><b> " +RegBean.getKARNumber()+"</b></td>"
						      +  " <td><b> " +RegBean.getPayingFor()+"</b></td>"
						      +"   <td><b> <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletForKARImage('"+RegBean.getKARNumber()+ "','"+"ChallanScanedCopy" + "','"+ "ChallanScanedCopyLoadForKAR" +"');\" >See Challan</button></b></td>"  
						  +"   <td><b> <button name='Confirm'  class=\"btn btn-warning\" onclick=\" CallToServletFromJSPForKARNumber('"+RegBean.getKARNumber()+ "','"+ "ConfirmChallanForKARPayment"+ "','"+RegBean.getPayingFor() +"');\" >Confirm</button></b></td>"
				   +" </tr>";
				   indexForSchedule++;
			}
	  
			   responseString += 
					   
					/*    "<script>"
					   + "function  ConfirmBean(RegNumber,WhichMethod)"
			   +" {"
			   +" alert(RegNumber); "
			   +"  alert(WhichMethod); "
			   + "alert('********** challan ***********');"
			  +" var RegNumber=RegNumber; "
			   	+ "var WhichFunctionToHandle=WhichMethod;"
			   + "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
			   +" $('#Main_Content1').html(responseText);  "+"}); "
			   +"  }); "
			 +"   return false; "
			 +"  } "
					   
					+ "</script>"*/   
					   /* " <td><b> " 
	      
	      + 
+ "<form id='FormForScheduleInterview'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='ConfirmChallanPay' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='ConfirmChallanPay' value='ConfirmChallanPay'  id='ConfirmChallanPay'  >"
	
+"	</form> "
	


	

 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#ConfirmChallanPay').click(function(event) { "
+ "alert('********** challan ***********');"
+" var RegNumber=$('#RegNumber').val(); "
	+ "var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
+"</b></td>"
	      +  " <td><b> " 
	      

+ "<form id='FormForViewChallan'   target='_blank'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='SeeChallan' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='SeeChallan' value='SeeChallan'  id='SeeChallan'  >"
		
	+"	</form> "
		

	
		
	
 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#SeeChallan').click(function(event) { "
	+ "alert('********** SeeChallan ***********');"
	+" var RegNumber=$('#RegNumber').val(); "

		+ "var WhichFunctionToHandle='SeeChallan';"
		+"alert(WhichFunctionToHandle);"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
	      +"</b></td>"
	              
	    
	   +  " </tr>"*/
	  /* +  " <tr>"
	   +  "   <th scope='row'>2</th>"
	    +  "  <td><b>Jacob</b></td>"
	    +  "  <td><b>Thornton</b></td>"
	    +  "  <td><b>@fat</b></td>"
	   +  " </tr>"
	  +  "  <tr>"
	   +  "   <th scope='row'>3</th>"
	   +  "   <td><b>Larry</b></td>"
	   +  "   <td><b>the Bird</b></td>"
	   +  "   <td><b>@twitter</b></td>"
	  +  "  </tr> "*/
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public String ViewEligibleKARChangeForJSP() {
		
		
		System.out.println("Hi");
		String responseString="Sorry  List is Empty";
		try
		{
			AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		ArrayList<EligibleKARChangesConfirm> absentList=AccountJSPRelatedFunctionsImp.GetAllEligibleKARChangesconfirmBean();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			
			   responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>KAR Number</th><th>For Which Function Paying For</th><th>See Challan</th>"
	  +  "<th>Confirm</th> </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int indexForSchedule=1;
			   
			   for (EligibleKARChangesConfirm RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+indexForSchedule+"</th>"
						    +  " <td><b> " +RegBean.getKARNumber()+"</b></td>"
						      +  " <td><b> " +RegBean.getPayingFor()+"</b></td>"
						      
						  +"   <td><b> <button class=\"btn btn-info\" name='Confirm' onclick=\" CallToServletFromJSPForKARNumber('"+RegBean.getKARNumber()+ "','"+ "WorkIsDoneForKARChanges"+ "','"+RegBean.getPayingFor() +"');\" >Done</button></b></td>"
				   +" </tr>";
				   indexForSchedule++;
			}
	  
			   responseString += 
					   
					
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public ArrayList<ValidatedFinalBean> ViewFinalKARNumberForDeathCandidate(String Status,Date StartDate,Date EndDate) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI");
		Query query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.KARStatus =:Nominee )");
		query.setDate("stDate", StartDate);
		query.setDate("edDate", EndDate); //
		query.setString("Nominee", Status);
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
		 
		 Session.close();
		 
		return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String GenerateAdmissionReport(String PlaceOfPractice, Date StartDate, Date EndDate,
			String CastCategory, String GenderCategory) {
		
		java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
		Connection con = null;
		String responseString = " Error while processing please try again later ";
		
		try 
		{
			System.out.println("********* GenerateAdmissionReport 123 ***************");
			 PreparedStatement PrepareStateMent = null; 
		/*Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		Query query = null;*/
			
			String OutputResult="not working";
			int resultoutput=0;
			Connection conn = null;
			
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*	String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
					
				      String sql;
			
				
			
			
			
			
		if (PlaceOfPractice.equalsIgnoreCase("All"))
		{
			// No need to query on PlaceOFpractice
			if (GenderCategory.equalsIgnoreCase("All"))
			{
			
				// GenderCategory
				
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					// coming
					System.out.println("Coming Here All");
				sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM"
						+ " EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ? ) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;
					
			 PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
				
	
				}
				
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					// coming
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND CategoryId=1 ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;

					/* query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.castCategory =:Nominee )");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate1); 
					query.setString("Nominee", "General");
*/		
					
					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
					/*	PrepareStateMent.setString(3, "General");*/
				
				
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{	
					// coming
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND CategoryId=2 ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;
				
					
					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
						/*PrepareStateMent.setString(3, "SC ST");*/
				}
				
				
			} // GenderCategory all ends
			else if (GenderCategory.equalsIgnoreCase("Male"))
			{
				
// CastCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					// coming
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND Gender='M' ORDER BY  EnrollmentDate  ASC,EnrollmentId";

						
						PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
						/*PrepareStateMent.setString(3, "Male");*/
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M') AND (CategoryId=1)  ORDER BY  EnrollmentDate  ASC,EnrollmentId";

				PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);
				/*PrepareStateMent.setString(3, "Male");
				PrepareStateMent.setString(4, "General");*/
					
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M') AND (CategoryId=2)  ORDER BY  EnrollmentDate  ASC,EnrollmentId";	
				
					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
					/*PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "SC ST");*/
					
					
				}
				
			}  // GenderCategory Male
			else if (GenderCategory.equalsIgnoreCase("Female"))
			{
// GenderCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') ORDER BY  EnrollmentDate  ASC,EnrollmentId";	

				
						PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
						/*PrepareStateMent.setString(3, "Male");*/
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=1) ORDER BY  EnrollmentDate  ASC,EnrollmentId";	
				

				PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);
		/*		PrepareStateMent.setString(3, "Male");
				PrepareStateMent.setString(4, "General");*/
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{	sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) ORDER BY  EnrollmentDate  ASC,EnrollmentId";	

					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
				/*	PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "SC ST");*/
				}
				
				
			}  // GenderCategory Male
			
		}
		else
		{
			//  need to query on PlaceOFpractice
			if (GenderCategory.equalsIgnoreCase("All"))
			{
			
				// GenderCategory
				
				
				if (CastCategory.equalsIgnoreCase("All"))
				{	
					
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
					PrepareStateMent.setString(3, PlaceOfPractice);
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (CategoryId=1) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
					/*	PrepareStateMent.setString(3, "General");*/
						PrepareStateMent.setString(3, PlaceOfPractice);
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{ 
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (CategoryId=2) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
 
					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
						/*PrepareStateMent.setString(3, "SC ST");*/
						PrepareStateMent.setString(3, PlaceOfPractice);
				}
				
				
			} // GenderCategory all ends
			else if (GenderCategory.equalsIgnoreCase("Male"))
			{
				
// CastCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M') AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
					/*	PrepareStateMent.setString(3, "Male");*/
						PrepareStateMent.setString(4, PlaceOfPractice);
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{	sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M')AND (CategoryId=1) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
				 PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
				/*	PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "General");*/
						PrepareStateMent.setString(3, PlaceOfPractice);
					
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{	
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M')AND (CategoryId=2) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
				
					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
				/*	PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "SC ST");*/
						PrepareStateMent.setString(3, PlaceOfPractice);
					
				}
				
			}  // GenderCategory Male
			else if (GenderCategory.equalsIgnoreCase("Female"))
			{
// GenderCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
				
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrolledDate BETWEEN ? AND ?) AND (Gender='F') AND (Place_Of_Practice=?)   "
							+ "ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
					/*PrepareStateMent.setString(3, "FeMale");*/
					PrepareStateMent.setString(4, PlaceOfPractice);
					
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					
					
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=1) AND (Place_Of_Practice=?)   ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
					/*PrepareStateMent.setString(3, "FeMale");
					PrepareStateMent.setString(4, "General");*/
					PrepareStateMent.setString(3, PlaceOfPractice);	
		//SELECT RollNo,Name,Gender,FatherName,DateOfBirth,Permanent_City,WelfareMember
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?)   ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
				/*	PrepareStateMent.setString(3, "FeMale");
					PrepareStateMent.setString(4, "SC ST");*/
					PrepareStateMent.setString(3, PlaceOfPractice);
				}
				
				
			}  // GenderCategory Male
			
		 // else download
		}
		
		ResultSet rs = PrepareStateMent.executeQuery();
		
	
		System.out.println("Not coming");
		int Index=1;
		System.out.println();
		
 //sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
		responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
				+ "<h1><center><b>Enrollment General Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
		
		
	      responseString+="<table class='table table-bordered'><thead><tr><th>#</th>"
	      		+ ""
	      		+ ""
	      		+ "<th>RollNo</th>"
	      		 +  "<th>EnrollmentRegistrationNo</th>"
	      		+ "<th>Name</th>"
	      		+ "<th>DOB</th>"
	      		+ "<th>Enrollment Date</th>"
	      		+ "<th>Father Name</th>"
  			  + ""
  			
  			  + "<th>Communication Address</th>"
  			  + " <th>Remarks</th> </tr>"
  			  +  " </thead>"
  			  +  "<tbody>";
	      String communication1="";
	    	 String communication2="";
	    	 String communication3="";
	    	 String FatherName="";
	      while(rs.next()){

	    /*	 rs.getString("RollNo");
	    	 rs.getString("Name");
	    	 rs.getString("Gender");
	    	 rs.getString("FatherName");*/
//	    	 rs.getString("DateOfBirth");
	    //	 rs.getString("Permanent_City");
	    	// rs.getString("WelfareMember");
	   	
    	 FatherName=rs.getString("FatherName");
    	 communication1=rs.getString("Communication_Address1");
    	 communication2=rs.getString("Communication_Address2");
    	 communication3=rs.getString("Communication_Address3");
    	 try
    	 {
      	  
      	  if(FatherName==null)
  	    	 {
      		FatherName=""; 
  	    	 }
  	    	 }
      	  catch(Exception e)
  	    	 {
  	    		 e.printStackTrace();
  	    		FatherName="";  
  	    	 }
    	 String remarks="";
    	 try
    	 {
    	 if(communication1==null)
    	 {
    		 communication1=""; 
    	 }
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    		 communication1="";  
    	 }
    	 try
    	 {
    	   if(communication2==null)
    	 {
    		 communication2=""; 
    	 }
    	   
      }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    		 communication2="";  
    	 }
    	 try
    	 {
    	   if(communication3==null)
	    	 {
	    		 communication3=""; 
	    	 }
    	 }
    	   catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    		 communication3="";  
	    	 }
	    	 try
	    	 {
    	   remarks = rs.getString("Remarks");
    	  if(remarks==null)
	    	 {
    		  remarks=""; 
	    	 }
	    	 }
    	  catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    		 remarks="";  
	    	 }
	    	 
	   // 	 sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
	    	
	    		 responseString +=  " <tr>"
						    +  "  <th scope='row'>"+Index+"</th>"
						    +  " <td><b> " +rs.getString("RollNo")+"</b></td>"
						     
						
							+  " <td><b> " +rs.getString("EnrollmentRegistrationNo")+"</b></td>"
							+  " <td><b> " +rs.getString("Name")+"</b></td>"
						+  " <td><b> " +rs.getTimestamp("DateOfBirth")+"</b></td>"
						+  " <td><b> " +rs.getTimestamp("EnrollmentDate")+"</b></td>"
						+  " <td><b> " +FatherName+"</b></td>"
						/*	+  " <td><b> " +rs.getString("FatherName")+"</b></td>"*/
							/*	+  " <td><b> " +rs.getString("Gender")+"</b></td>"
								+  " <td><b> " +rs.getString("Place_Of_Practice")+"</b></td>"
							*/	+  " <td><b> " +(communication1+communication2+communication3)+"</b></td>"	
							/*	+  " <td><b> " +rs.getString("Communication_Address2")+"</b></td>"	
								+  " <td><b> " +rs.getString("Communication_Address3")+"</b></td>"	
						*/	/*+  " <td><b> " +rs.getString("Communication_Address1")+"</b></td>"	*/
							+  " <td><b> " +remarks+"</b></td>"	
							/*+  " <td><b> " +rs.getString("DateOfBirth")+"</b></td>"
							+  " <td><b> " +rs.getString("Permanent_City")+"</b></td>"
							+  " <td><b> " +rs.getString("WelfareMember")+"</b></td>"*/
						   
						     
				   +" </tr>"; 
				   Index++;
	      }
				   responseString+=	 " </tbody> "+  "</table><br></br><br></br>";
				   rs.close();
				      PrepareStateMent.close();
				      conn.close();
	
			 
		
			 
			
			}
				} // connection 
			
			catch (SQLException e)
			{
				e.printStackTrace();
				
			}
			
		}finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}}
		return responseString;
		
	
	}

	@Override
	public ArrayList<ValidatedFinalBean> GenerateReport(String StatusOfTheAdvocate, Date StartDate, Date EndDate,
			String CastCategory, String GenderCategory) {
		
		try 
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		Query query = null;
		
		System.out.println("********* GenerateReport ***************");
		if (StatusOfTheAdvocate.equalsIgnoreCase("All"))
		{
			// No need to query on PlaceOFpractice
			if (GenderCategory.equalsIgnoreCase("All"))
			{
			
				// GenderCategory
				
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
				
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrollmentDate BETWEEN :stDate AND :edDate)   ");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate); 
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrollmentDate BETWEEN :stDate AND :edDate)   and ( e.castCategory =:Nominee )");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate); 
					query.setString("Nominee", "General");
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrollmentDate BETWEEN :stDate AND :edDate)   and ( e.castCategory =:Nominee )");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "SC ST");
				}
				
				
			} // GenderCategory all ends
			else if (GenderCategory.equalsIgnoreCase("Male"))
			{
				
// CastCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
				
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrollmentDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee )");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "Male");
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.castCategory =:castCategory)");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "Male");
						query.setString("castCategory", "General");
					
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.castCategory =:castCategory)");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "Male");
						query.setString("castCategory", "SC ST");
					
				}
				
			}  // GenderCategory Male
			else if (GenderCategory.equalsIgnoreCase("Female"))
			{
// GenderCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
				
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee )");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "Male");
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.castCategory =:castCategory)");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate); 
					query.setString("Nominee", "Female");
					query.setString("castCategory", "General");
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.castCategory =:castCategory)");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate); 
					query.setString("Nominee", "Female");
					query.setString("castCategory", "SC ST");
				}
				
				
			}  // GenderCategory Male
			
		}
		else
		{
			//  need to query on PlaceOFpractice
			if (GenderCategory.equalsIgnoreCase("All"))
			{
			
				// GenderCategory
				
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
				
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate) and (e.KARStatus:Place_Of_Practice)  ");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate); 
					query.setString("PlaceOfPractice", StatusOfTheAdvocate);
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.castCategory =:Nominee ) and (e.KARStatus:PlaceOfPractice)");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate); 
					query.setString("Nominee", "General");
					query.setString("PlaceOfPractice", StatusOfTheAdvocate);
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{ 
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.castCategory =:Nominee ) and (e.KARStatus:PlaceOfPractice)");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "SC ST");
						query.setString("PlaceOfPractice", StatusOfTheAdvocate);
				}
				
				
			} // GenderCategory all ends
			else if (GenderCategory.equalsIgnoreCase("Male"))
			{
				
// CastCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
				
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.KARStatus:PlaceOfPractice)");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "Male");
						query.setString("PlaceOfPractice", StatusOfTheAdvocate);
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.castCategory =:castCategory) and (e.KARStatus:PlaceOfPractice)");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "Male");
						query.setString("castCategory", "General");
						query.setString("PlaceOfPractice", StatusOfTheAdvocate);
					
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.castCategory =:castCategory) and (e.KARStatus:PlaceOfPractice)");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "Male");
						query.setString("castCategory", "SC ST");
						query.setString("PlaceOfPractice", StatusOfTheAdvocate);
					
				}
				
			}  // GenderCategory Male
			else if (GenderCategory.equalsIgnoreCase("Female"))
			{
// GenderCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
				
					 query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.KARStatus:PlaceOfPractice)");
						query.setDate("stDate", StartDate);
						query.setDate("edDate", EndDate); 
						query.setString("Nominee", "Male");
						query.setString("PlaceOfPractice", StatusOfTheAdvocate);
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.castCategory =:castCategory) and (e.KARStatus:PlaceOfPractice)");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate); 
					query.setString("Nominee", "Female");
					query.setString("castCategory", "General");
					query.setString("PlaceOfPractice", StatusOfTheAdvocate);
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.GenderCategory =:Nominee ) and (e.castCategory =:castCategory) and (e.KARStatus:PlaceOfPractice)");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate); 
					query.setString("Nominee", "Female");
					query.setString("castCategory", "SC ST");
					query.setString("PlaceOfPractice", StatusOfTheAdvocate);
				}
				
				
			}  // GenderCategory Male
			
		} // else download
		
		
		
		
		 @SuppressWarnings("unchecked")
			ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
			 
			 Session.close();
			 
			return list;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			return null;	
			}
	}

	
	@Override
	public String GenerateREGNumber(String FirstName) {
		
		return null;
	}

	@Override
	public Step1RegistrationForm GetStep1RegistrationForm(String REGNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from Step1RegistrationForm where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", REGNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<Step1RegistrationForm> list = (ArrayList<Step1RegistrationForm>)query.list();
		 Session.close();
		return list.get(0);
		}
		catch(Exception e)
		{
		return null;	
		}
	}

	@Override
	public Step2RegistrationForm GetStep2RegistrationForm(String REGNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from Step2RegistrationForm where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", REGNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<Step2RegistrationForm> list = (ArrayList<Step2RegistrationForm>)query.list();
		 Session.close();
		return list.get(0);
		}
		catch(Exception e)
		{
		return null;	
		}
	}

	@Override
	public Step3RegistrationForm GetStep3RegistrationForm(String REGNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from Step3RegistrationForm where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", REGNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<Step3RegistrationForm> list = (ArrayList<Step3RegistrationForm>)query.list();
		 Session.close();
		return list.get(0);
		}
		catch(Exception e)
		{
		return null;	
		}
	}

	@Override
	public String MoveTOReGBean(String REGNumber) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		
		
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		Step1RegistrationForm Step1RegistrationForm = JSPRelatedFunctionsimp.GetStep1RegistrationForm(REGNumber);
		Step2RegistrationForm Step2RegistrationForm = JSPRelatedFunctionsimp.GetStep2RegistrationForm(REGNumber);
		Step3RegistrationForm Step3RegistrationForm = JSPRelatedFunctionsimp.GetStep3RegistrationForm(REGNumber);
		
		RegistrationFormBean RegistrationFormBean= new RegistrationFormBean();
		RegistrationFormBean.setAddress(Step1RegistrationForm.getAddress());
		RegistrationFormBean.setAddressFromStep3(Step3RegistrationForm.getAddress());
		RegistrationFormBean.setBirthdate(Step1RegistrationForm.getBirthdate());
		RegistrationFormBean.setBloodGroup(Step1RegistrationForm.getBloodGroup());
		RegistrationFormBean.setBusinessDetails(Step2RegistrationForm.getBusinessDetails());
		RegistrationFormBean.setCastCategory(Step1RegistrationForm.getCastCategory());
		RegistrationFormBean.setCitizenOfIndia(Step1RegistrationForm.getCitizenOfIndia());
		RegistrationFormBean.setCity(Step1RegistrationForm.getCity());
		RegistrationFormBean.setCollege(Step2RegistrationForm.getCollege());
		RegistrationFormBean.setConvictedDetails(Step2RegistrationForm.getConvictedDetails());
		RegistrationFormBean.setDiscontinuanceOfPractice(Step3RegistrationForm.getDiscontinuanceOfPractice());

		RegistrationFormBean.setEmail(Step1RegistrationForm.getEmail());
		RegistrationFormBean.setFather_name(Step1RegistrationForm.getFather_name());
		RegistrationFormBean.setFirst_name(Step1RegistrationForm.getFirst_name());
		
		RegistrationFormBean.setFullName(Step3RegistrationForm.getFullName());
		RegistrationFormBean.setGenderCategory(Step1RegistrationForm.getGenderCategory());
		RegistrationFormBean.setNomineeDetails(Step3RegistrationForm.getNomineeDetails());
		RegistrationFormBean.setNotAnClitizen(Step1RegistrationForm.getNotAnClitizen());
		
		RegistrationFormBean.setOtherProfessional(Step2RegistrationForm.getOtherProfessional());
		RegistrationFormBean.setPendingCriminalCases(Step2RegistrationForm.getPendingCriminalCases());
		RegistrationFormBean.setPhone(Step1RegistrationForm.getPhone());
		RegistrationFormBean.setPlaceOfPractice(Step2RegistrationForm.getPlaceOfPractice());
		RegistrationFormBean.setPlaceOfPracticeFromStep2(Step2RegistrationForm.getPlaceOfPractice());
		
		RegistrationFormBean.setPreviousApplicationDetails(Step2RegistrationForm.getPreviousApplicationDetails());
		RegistrationFormBean.setPreviousEmployment(Step3RegistrationForm.getPreviousEmployment());
		RegistrationFormBean.setProportionOfShare(Step3RegistrationForm.getProportionOfShare());
		RegistrationFormBean.setRegNumber(REGNumber);
		RegistrationFormBean.setState(Step1RegistrationForm.getState());
		RegistrationFormBean.setTerminatedDetails(Step2RegistrationForm.getTerminatedDetails());
		RegistrationFormBean.setUniversity_Name(Step2RegistrationForm.getUniversity_Name());
		
		RegistrationFormBean.setYear_course(Step2RegistrationForm.getYear_course());
		RegistrationFormBean.setYear_of_Completion(Step2RegistrationForm.getYear_of_Completion());
		RegistrationFormBean.setZipCode(Step1RegistrationForm.getZipCode());
		
		Session.saveOrUpdate(RegistrationFormBean);
		
		 Session.beginTransaction().commit();
		 Session.close();
		return "Success";
		}
		catch(Exception e)
		{
		return null;	
		}
	}

	@Override
	public String RegistrationLoginFormValidatationForUSernameandPassword(String REGNumber, String Password) {
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		String Sql = "select * from RegistrationLogin where REGNumber = :REGNumber and Password =:Password";
	/*	Query query = Session.createQuery("select D from DomainLoginBean D where (D.UserName:UserName) and (D.Password:Password)");*/
		SQLQuery query = Session.createSQLQuery(Sql);
		query.setParameter("REGNumber", REGNumber);
		query.setParameter("Password", Password);
		 query.addEntity(DomainLoginBean.class);
    //     List employees = (List) query.list();
		 @SuppressWarnings("unchecked")
		ArrayList<RegistrationLogin> list = (ArrayList<RegistrationLogin>)query.list();
		 System.out.println(list);
		 Session.close();
		 if (list==null)
		 {
		return "";	 
		 }
		 else 
		 {
			 return "Success";	  
		 }
		
		
		}
		catch ( Exception e)
		{
			e.printStackTrace();
			return "";	
		}
	}
//Date date = Date.valueOf(EnrollmentDate.toLocalDateTime().toLocalDate());
	@Override
	public String GenerateCertificate(String KARNumber, String FatherName, String Name, java.sql.Timestamp EnrollmentDate,String REGNumber,int EnrollmentID)
	{
        JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
     String NameChairman="";
     System.out.println(EnrollmentDate + "EnrollmentDate");
		int SLNumber = JSPRelatedFunctionsimp.GetSLNumberofChairmanSignature(EnrollmentDate); 
		if(SLNumber>0)
		{
			Session Session = HibernateUtil.getSessionFactory().openSession();
			
			
			ChairmanSignature signatureBean = (ChairmanSignature)Session.get(ChairmanSignature.class, SLNumber);
			NameChairman=	signatureBean.getName();
		}
		
		String Chairmansrc="ChairmanImageServlet?SLNumber="+SLNumber+"";
        String src="";
        String Privioussrc=JSPRelatedFunctionsimp.GetPhotoDetailsForWelfare(EnrollmentID);
        
        System.out.println(Privioussrc + "  Its what coming");
        if(!Privioussrc.contains("Error"))
        {
            src=Privioussrc;    
        }
        else
        {
            src="ImageServlet?RegNumber="+REGNumber+"&WhichPhoto=Photo";
            
            
        }
        /*String date="";*/
        
        Date date1 = Date.valueOf(EnrollmentDate.toLocalDateTime().toLocalDate());  
        String dateString=date1.toString();
        String date="";
 date=convertDateToWords(dateString);
    String    resultString=""
+"<body > "

+"<page> "



+"<h1> "
+"<div class=\"a\"></div> "
+"<div align=\"center\"><font face=\" Arial\" size=\"5.5px\">ENROLMENT CERTIFICATE</font></div></h1> "
+"     <div align=\"center\" > <img src=\""+src+"\" alt=\"photo\"  width=\"120px\" height=\"120px\"/></div><br> "
      
+"  <div align=\"center\"><font face=\" French Script MT\" size=\"6px\"><b> Reg. No. : "+REGNumber+"</b></font></div>"
+"  <div align=\"center\"><font face=\" French Script MT\" size=\"6px\"><b> Roll No. : "+KARNumber+"</b></font></div> "
       
 +"  <p align=\"center\"> <font face=\"French Script MT\" size=\"6px\"><b>This is to certify that</b> </font></p> "
 +"  <p align=\"center\"> <font face=\"French Script MT\" size=\"6px\"><b>Shri/Smt </b>"+"<font face=\" Arial\" size=\"5px\">"+Name+"</font></p> "
 +"  <p align=\"center\"><font face=\"  French Script MT\" size=\"6px\"><b>Son/Daughter of </b></font></p>"
 +"  <p align=\"center\"> <font face=\" Arial\" size=\"5px\"> "+FatherName+"</font></p> "
 +"  <p align=\"center\"><font face=\"  French Script MT\" size=\"6px\"><b>is admitted as an Advocate on the Roll of Karnataka State</b></font></p> "
 +"  <p align=\"center\"><font face=\"  French Script MT\" size=\"6px\"><b>Bar Council and Signed the Roll on</b></font> <font face=\" Arial\" size=\"5px\">"+date+"</font></p> "
 +"  <p align=\"center\"><font face=\"French Script MT\" size=\"6px\"><b>Under Section 17 of the Advocates Act,1961</b></font></p> "
     
   +"    <br></br> "
 

       
 +" <div> "    
  +"<table id=page style=\"margin-left:55%; top:50% \"> " 
  +" <tr><th>&nbsp;&nbsp;&nbsp;&nbsp<img src=\""+Chairmansrc+"\" alt=\"signature\"  width=\"90px\" height=\"90px\"/></th></tr> "
  +" <tr><td><font face=\" Arial\" size=\"2.8px\">("+NameChairman+")</font><div></div></td></tr> "
  +"  <tr><td><font face=\" Arial\"size=\"4px\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHAIRMAN</font></td></tr> "
 +"</table>  "
   +"  </div>   "
      
      
     
            


+"</page> "
+"</body> "
; 
                return resultString;
            }

    private String convertDateToWords(String dateString) {
                String[] parts = dateString.split("-");
                String year = parts[0];
                String month = parts[1]; 
                String day = parts[2];
                System.out.println("year "+year);
                System.out.println("month "+month);
                System.out.println("day "+day);
                
                String formonth="";
                if(month.equals("01")||month.equals("1")){ formonth="January";}
                else if(month.equals("02")||month.equals("2")){formonth="Febraury";}
                else if(month.equals("03")||month.equals("3")){formonth="March";}
                else if(month.equals("04")||month.equals("4")){formonth="April";}
                else if(month.equals("05")||month.equals("5")){formonth="May";}
                else if(month.equals("06")||month.equals("6")){formonth="June";}
                else if(month.equals("07")||month.equals("7")){formonth="July";}
                else if(month.equals("08")||month.equals("8")){formonth="August";}
                else if(month.equals("09")||month.equals("9")){formonth="September";}
                else if(month.equals("10")){formonth="October";}
                else if(month.equals("11")){formonth="November";}
                else if(month.equals("12")){formonth="December";}
                
                String forday="th";
                if(day.equals("01")||day.equals("1")||day.equals("21")||day.equals("31")){
                    forday="st";
                }
                if(day.equals("02")||day.equals("2")||day.equals("22")){
                    forday="nd";
                }
                if(day.equals("03")||day.equals("3")||day.equals("23")){
                    forday="rd";
                }
                System.out.println(forday);
                String dateInWords=(day+forday+" day "+"of "+formonth+" "+year);
                
                return dateInWords;
                
             }

    @Override
    public String GenerateChallan( Integer TotalMoney,LinkedHashMap<String, Integer> PayingForWithValue, String Name, String Date,
            String Place,String KARNumber,String ReceiptNo,String Category,String DDNumber) {
        // TODO Auto-generated method stub
class numberToWords{
           
            public  String wordInt(int n){ 
               
                  numberToWords a = new numberToWords();
               String hd=   a.pw((n/1000000000)," Hundred");
               String cr=     a.pw((n/10000000)%100," crore");
               String lk=    a.pw(((n/100000)%100)," lakh");
               String th=    a.pw(((n/1000)%100)," thousand");
               String h=    a.pw(((n/100)%10)," hundred");
               String nothing=   a.pw((n%100)," ");
                String TotalAmount=(hd+cr+lk+th+h+nothing);
                return TotalAmount;
                }
               
             
              public String pw(int n,String ch)
              {String CH="";String One=""; String tenOne="";
                String  one[]={" ","One",
                   " Two",
                   " Three",
                   " Four",
                   " Five",
                   " Six",
                   " Seven",
                   " Eight",
                   " Nine",
                   " Ten",
                   " Eleven",
                   " Twelve",
                   " Thirteen",
                   " Fourteen",
                   " Fifteen",
                   " Sixteen",
                   " Seventeen",
                   " Eighteen",
                   " Nineteen"
               };
            
                String ten[]={" "," "," Twenty"," Thirty"," Forty"," Fifty"," Sixty","Seventy"," Eighty"," Ninety"};
            
                if(n > 19) {
                    tenOne=ten[n/10]+" "+one[n%10];
                       
                }
                else {
                    One=one[n];
               
                }
                if(n > 0){
                     CH=ch;
                   
                }
                String Total=tenOne+One+CH;
                   
                    return Total;
              }
             
              
        }
       
        String TotalInWords="";
        String word1="";
        String word2="";
        String word3="";
        String word4="";
         numberToWords nw = new numberToWords();
        String words= nw.wordInt(TotalMoney);

       
       
       
       
        TotalInWords=words+" Only";   
   
            if(TotalInWords.length()<39){
                word1=TotalInWords;
            }
            else if((TotalInWords.length()>39 && TotalInWords.length()<70)){
               
                word1=TotalInWords.substring(0, 37);
                word2=TotalInWords.substring(37);
               
            }
            else if((TotalInWords.length()>=70 && TotalInWords.length()<=100)){
                word1=TotalInWords.substring(0, 37);
                word2=TotalInWords.substring(37,70);
                word3=TotalInWords.substring(70,100);
               
            }
            else if(TotalInWords.length()>100){
                word1=TotalInWords.substring(0, 37);
                word2=TotalInWords.substring(37,70);
                word3=TotalInWords.substring(70,100);
                word4=TotalInWords.substring(100);
            }
           
            String firstName="";
            String lastName="";
            if(Name.length()<25){
                firstName=Name;
            }
            else{
                firstName=Name.substring(0,25);
                lastName=Name.substring(25);
            }
       
        int index1=0;
        int index2=0;
        int index3=0;
        System.out.println(PayingForWithValue.size());
          // Get a set of the entries
          Set set = PayingForWithValue.entrySet();
          System.out.println(DDNumber+"Jagga");
         
          System.out.println(Category+"  akshay");
         
          System.out.println(PayingForWithValue.size()  + "paa");
          // Get an iterator
          Iterator i = set.iterator();
          Iterator i1 = set.iterator();
          Iterator i2 = set.iterator();
          Iterator i3 = set.iterator();
          // Display elements
          String Result="";
          while(i.hasNext()) {
             Map.Entry me = (Map.Entry)i.next();
             System.out.print(me.getKey() + ": ");
             System.out.println(me.getValue());
          }
         
          if (("DD").equalsIgnoreCase(Category))
          {String dd1="";
            String dd2="";
            String dd3="";
            if(DDNumber.length() >59){
            dd1=DDNumber.substring(0,30);
             dd2=DDNumber.substring(30,59);
             dd3=DDNumber.substring(59);
            }
            else{
                dd1=DDNumber.substring(0,30);
                 dd2=DDNumber.substring(30);
            }
                  
                 
                   Result="<!DOCTYPE html>"
                          +"<html>"
                          +"<head>"
                          +"<style>"
                          +".floating-box {"
                            +"  float: left;"
                            +"  width: 30%;"
                            +"  height:100%;"
                            +"  margin: 10px;"
                           +"   border: 1px solid white; "
                           +"}"
                           + ".box{"
                           + "float: left;"
                           + "width:30%; "
                           + "}"
                           +".floating{"
                            +"  float: left;"
                            +"  width: 1%;"
                            +"  height:100%;"
                            +"  margin: 10px;"
                           +"   border: 1px solid white; "
                           +"}"
                          
                          +"</style>"
                          + "<script src='http://code.jquery.com/jquery-latest.js'></script>"
                             + "<script>"
                             + "function Print()"
                             + "{"
                             + "window.print();"
                             + "window.location.href = 'http://139.59.34.42:8080/ksbc/AccountPortal.jsp';"
                            /* + "$('#Main_Content2').load('AccountPortal.jsp');"*/
                             + "} "
                             + "</script>"
                         
                          +"</head>"
                          // Date
                          +"<body onload='Print()' id='Main_Content2'>" //ksbc_logo.jpg

                         +"<div class=\"floating\"></div>"
                         
                          +"<div class=\"floating-box\">"
                          +"<br><br><br><br>"
                          + "<p align=\"right\">Date:"+Date+"</p>"
                           +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+KARNumber
                          +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Name:"+firstName+"<br>";
                          if(lastName.length()>0){
                                  Result+= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+lastName;
                          }
                          Result+="</div></font><br/>"
                          +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Place:"+Place+"</div></font><br/>"


                          +"<div style=\"width:100%;height:3%;border:0px solid brown\">"
                        
                          +"<br> <br> </div> <div class='ForWhatPaying'><br>";
                   while(i1.hasNext()) {
                       Map.Entry me = (Map.Entry)i1.next();
                       System.out.print(me.getKey() + ": "  + index1);
                       System.out.println(me.getValue());
                  
                   //  Result+=  "<div class=\"box\" align=\"left\">"+(index1+1)+"</div><div class=\"box\" align=\"left\">"+me.getKey()+"</div><div class=\"box\" align=\"right\">"+me.getValue()+"</div>";
                       Result+=" <div style=\"float:left;width:25%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+(index1+1)+"</div>"
                              +" <div style=\"float:left;width:53%\">"+me.getKey()+"</div>"
                              +"  <div style=\"float:left;width:0%\">"+me.getValue()+"</div><br/>";
                          
                           index1++;
                        }

                          Result+="</div>"
                                   +"<br/>"
                                 
                                  //+"  <div style=\"float:right;\">-------</div><br/>"
                                  +"  <div style=\"float:right;\">&nbsp;&nbsp;"+TotalMoney+"/-</div>"
                                  + "<br/><br/><br/><br/><br/><br/>";
                                ///  +"Rupees:"+TotalMoney+" /-<br>"
                          if(TotalInWords.length()<39){
                              Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1;
                          }
                          else if((TotalInWords.length()>39 && TotalInWords.length()<70)){
                             
                              Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word2;
                             
                             
                          }
                          else if((TotalInWords.length()>=70 && TotalInWords.length()<=100)){
                             
                              Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ word2+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word3;
                             
                          }
                          else if(TotalInWords.length()>100){
                              Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word2+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word3+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word4;
                          }
                                 
                                  Result+= " <br/>"
                  +"<div style=\"width:100%\">"
                  +"   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+dd1+"<br>"
                  +"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  "+dd2+"<br>"
                  +"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  "+dd3
                  +"  <br><br><br><br> <div style=\"float:left\"> "+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ReceiptNo +"</div>"
                 // +"   <div style=\"float:right\"><strong>CASHIER</strong></div>"
                  +"</div>"
                  +"</div>"




       
        
                         
                  +"<div class=\"floating-box\">"
                  +"<br><br><br><br><br>"
                              +"<p align=\"right\">Date:"+Date+"</p>"
                               +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+KARNumber
                               +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Name:"+firstName+"<br>";
                          if(lastName.length()>0){
                                  Result+= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+lastName;
                          }
                          Result+="</div></font><br/>"
                               +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Place:"+Place+"</div></font><br/>"


                              +"<div style=\"width:100%;height:3%;border:0px solid brown\">"
                            
                              +"  <br><br> </div> <div class='ForWhatPaying'><br>";
                                   while(i2.hasNext()) {
                                       Map.Entry me = (Map.Entry)i2.next();
                                       System.out.print(me.getKey() + ": "  + index2);
                                       System.out.println(me.getValue());
                                   Result+=" <div style=\"float:left;width:25%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+(index2+1)+"</div>"
                                          +" <div style=\"float:left;width:53%\">"+me.getKey()+"</div>"
                                          +"  <div style=\"float:left;width:0%\">"+me.getValue()+"</div><br/>";
                                      
                                       index2++;
                                    }

                                      Result+="</div>"
                                               +"<br/>"
                                         
                                              +"  <div style=\"float:right;\">"+TotalMoney+"/-</div>"
                                               + "<br/><br/><br/><br/><br/><br/> "; 
                                      if(TotalInWords.length()<39){
                                          Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1;
                                      }
                                      else if((TotalInWords.length()>39 && TotalInWords.length()<70)){
                                         
                                          Result+= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word2;
                                         
                                         
                                      }
                                      else if((TotalInWords.length()>=70 && TotalInWords.length()<=100)){
                                         
                                          Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ word2+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word3;
                                         
                                      }
                                      else if(TotalInWords.length()>100){
                                          Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ word2+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word3+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word4;
                                      }
                              Result+="<div style=\"width:100%\">"
                             
                                +" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+dd1+"<br>"
                                +"    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+dd2+"<br>"
                                +"    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+dd3+"<br>"

                              +"  <br><br><br><br> <div style=\"float:left\">    &nbsp;&nbsp;&nbsp; "+ReceiptNo +"</div>"
                              +"</div>"
                              +"</div>"









        
       
                              +"<div class=\"floating-box\">"
                              +"<br><br><br><br><br>"
                                      +"<p align=\"right\">Date:"+Date+"</p>"
                                      +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+KARNumber
                                    //  +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;1. Name:"+Name+"</div></font><br/>"
                                     +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Name:"+firstName+"<br>";
                                      if(lastName.length()>0){
                                              Result+= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+lastName;
                                      }
                                      Result+="</div></font><br/>" 
                                    +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Place:"+Place+"</div></font><br/>"



                                     +"<div style=\"width:100%;height:3%;border:0px solid brown\">"
                                   
                                      +"  <br><br></div> <div class='ForWhatPaying'><br>";


                                       while(i3.hasNext()) {
                                           Map.Entry me = (Map.Entry)i3.next();
                                           System.out.print(me.getKey() + ": "  + index3);
                                           System.out.println(me.getValue());
                                           Result+=" <div style=\"float:left;width:25%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+(index3+1)+"</div>"
                                                  +" <div style=\"float:left;width:53%\">"+me.getKey()+"</div>"
                                                  +"  <div style=\"float:left;width:0%\">"+me.getValue()+"</div><br/>";
                                              
                                               index3++;
                                            }

                                              Result+="</div>"
                                                       +"<br/>"
                                                      +"  <div style=\"float:right;\">"+TotalMoney+"/-</div>"
                                                       + "<br/><br/><br/><br/><br/><br/>  "; 

                                              if(TotalInWords.length()<39){
                                                  Result+="&nbsp;&nbsp;"+word1;
                                              }
                                              else if((TotalInWords.length()>39 && TotalInWords.length()<70)){
            
                                                  Result+= "&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;"+word2;
            
            
                                              }
                                              else if((TotalInWords.length()>=70 && TotalInWords.length()<=100)){
            
                                                  Result+="&nbsp;&nbsp;"+word1+"<br>"+ "&nbsp;&nbsp;"+word2+"<br>"+"&nbsp;&nbsp;"+word3;
            
                                              }
                                              else if(TotalInWords.length()>100){
                                                  Result+="&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;"+word2+"<br>"+"&nbsp;&nbsp;"+word3+"<br>"+"&nbsp;&nbsp;"+word4;
                                     }
                                      Result+="<div style=\"width:100%\">"
                                     +"&nbsp;"+dd1+"<br>"
                                        +"   &nbsp;"+dd2+"<br>"
                                        +"    &nbsp;"+dd3+"<br>"


                                      +"  <br><br><br><br><div style=\"float:left\">      &nbsp;"+ReceiptNo +"</div>"
                                      +"</div>"
                                      +"</div>"


                      +"</body>"
                      +"</html>"; 
          }
                     
                     
                     
                     
                                         
                     
                     
                     
       
             
             
             
            
         
          else
          {
                  
                              
                             
                   Result="<!DOCTYPE html>"
                          +"<html>"
                          +"<head>"
                          +"<style>"
                          +".floating-box {"
                            +"  float: left;"
                            +"  width: 30%;"
                            +"  height:100%;"
                            +"  margin: 10px;"
                           +"   border: 1px solid white; "
                           +"}"
                              +".box {"
                                +"  float: left;"
                                +"  width: 30%;"
                                + "}"
                                +".floating{"
                                +"  float: left;"
                                +"  width: 1%;"
                                +"  height:100%;"
                                +"  margin: 10px;"
                               +"   border: 1px solid white; "
                               +"}"
                          +"</style>"
                          + "<script src='http://code.jquery.com/jquery-latest.js'></script>"
                                 + "<script>"
                                 + "function Print()"
                                 + "{"
                                 + "window.print();"
                                 + "window.location.href = 'http://139.59.34.42:8080/ksbc/AccountPortal.jsp';"
                                /* + "$('#Main_Content2').load('AccountPortal.jsp');"*/
                                 + "} "
                                 + "</script>"
                             
                              +"</head>"
                              // Date
                              +"<body onload='Print()' id='Main_Content2'>" //ksbc_logo.jpg


                         +"<div class=\"floating\"></div>"
                        
                           +"<div class=\"floating-box\">"
                              +"<br><br><br><br><br>"
                                      +"<p align=\"right\">Date:"+Date+"</p>"
                                      +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+KARNumber
                                     // +"<font face=\"verdana\" size=\"1.5\"><div>1. Name:"+Name+"</div></font><br/>"
                                     +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Name:"+firstName+"<br>";
                 if(lastName.length()>0){
                         Result+= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+lastName;
                 }
                 Result+="</div></font><br/>"
                                     +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Place:"+Place+"</div></font><br/>"



                                     +"<div style=\"width:100%;height:3%;border:0px solid brown\">"
                                   
                                      +" <br> <br></div> <div class='ForWhatPaying'><br>";


                   while(i1.hasNext()) {
                       Map.Entry me = (Map.Entry)i1.next();
                       System.out.print(me.getKey() + ": "  + index1);
                       System.out.println(me.getValue());
                     Result+=" <div style=\"float:left;width:25%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+(index1+1)+"</div>"
                              +" <div style=\"float:left;width:53%\">"+me.getKey()+"</div>"
                              +"  <div style=\"float:left;width:0%\">"+me.getValue()+"</div><br/>";
                        
                         index1++;
                    }
                 
                                  Result+="</div>"
                          +"<br/>"
                                         

+"  <div style=\"float:right;\">"+TotalMoney+"/-</div>"
                         
                          + "<br/><br/><br/><br/><br/> <br/> "  ;
                                  if(TotalInWords.length()<39){
                                      Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1;
                                  }
                                  else if((TotalInWords.length()>39 && TotalInWords.length()<70)){
                                     
                                      Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word2;
                                     
                                     
                                  }
                                  else if((TotalInWords.length()>=70 && TotalInWords.length()<=100)){
                                     
                                      Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ word2+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word3;
                                     
                                  }
                                  else if(TotalInWords.length()>100){
                                      Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word2+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word3+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word4;
                                  }
                        
                         Result+="<br/><br/><br/>"

                          +"<div style=\"width:100%\">"
                          +"  <br><br><div style=\"float:left\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  "+ReceiptNo +"</div>"
                          +"</div>"
                          +"</div>"




         
          
                         
                          +"<div class=\"floating-box\">"
                         
                          +"<br><br><br><br><br>"
                                  +"<p align=\"right\">Date:"+Date+"</p>"
                                  +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+KARNumber
                                  +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Name:"+firstName+"<br>";
                                     if(lastName.length()>0){
                                             Result+= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+lastName;
                                     }
                                     Result+="</div></font><br/>"
                                  +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Place:"+Place+"</div></font><br/>"



                                 +"<div style=\"width:100%;height:3%;border:0px solid brown\">"
                           
                                  +" <br> <br></div> <div class='ForWhatPaying'><br>";


                                   while(i2.hasNext()) {
                                       Map.Entry me = (Map.Entry)i2.next();
                                       System.out.print(me.getKey() + ": "  + index2);
                                       System.out.println(me.getValue());
                                     Result+=" <div style=\"float:left;width:25%\">"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+(index2+1)+"</div>"
                                              +" <div style=\"float:left;width:53%\">"+me.getKey()+"</div>"
                                              +"  <div style=\"float:left;width:0%\">"+me.getValue()+"</div><br/>";
                                       index2++;
                                    }
                                      Result+="</div>"
                              +"<br/>"
                           
                              +"  <div style=\"float:right;\">"+TotalMoney+"/-</div>"
                             
                              + "<br/><br/><br/><br/><br/><br/>  "  ;
                           
                                      if(TotalInWords.length()<39){
                                          Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1;
                                      }
                                      else if((TotalInWords.length()>39 && TotalInWords.length()<70)){
                                         
                                          Result+= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word2;
                                         
                                         
                                      }
                                      else if((TotalInWords.length()>=70 && TotalInWords.length()<=100)){
                                         
                                          Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ word2+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word3;
                                         
                                      }
                                      else if(TotalInWords.length()>100){
                                          Result+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ word2+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word3+"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+word4;
                                      }
                             Result+="<br/><br/><br/><br/>"

                              + "<div style=\"width:100%\">"
                              +"  <br><br> <div style=\"float:left\">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  "+ReceiptNo +"</div>"
                              +"</div>"
                              +"</div>"








          
         
                               
                              +"<div class=\"floating-box\">"
                              +"<br><br><br><br><br>"
                                      +"<p align=\"right\">Date:"+Date+"</p>"
                                       +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+KARNumber
                                    //  +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;1. Name:"+Name+"</div></font><br/>"
                                    +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Name:"+firstName+"<br>";
                                         if(lastName.length()>0){
                                                 Result+= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+lastName;
                                         }
                                         Result+="</div></font><br/>"
                                    +"<font face=\"verdana\" size=\"1.5\"><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Place:"+Place+"</div></font><br/>"



                                      +"<div style=\"width:100%;height:3%;border:0px solid brown\">"
                                   
                                      +" <br><br> </div> <div class='ForWhatPaying'><br>";


                                       while(i3.hasNext()) {
                                           Map.Entry me = (Map.Entry)i3.next();
                                           System.out.print(me.getKey() + ": "  + index3);
                                           System.out.println(me.getValue());
                                         Result+=" <div style=\"float:left;width:25%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+(index3+1)+"</div>"
                                                  +" <div style=\"float:left;width:53%\">"+me.getKey()+"</div>"
                                                  +"  <div style=\"float:left;width:0%\">"+me.getValue()+"</div><br/>";
                                             index3++;
                                        }
                                      Result+="</div>"
                                      +"<br/>"
                                             

                                    +"  <div style=\"float:right;\">"+TotalMoney+"/-</div>"
                                     
                                      + "<br/><br/><br/><br/><br/> <br/> ";
                               
                                      if(TotalInWords.length()<39){
                                          Result+="&nbsp;&nbsp;"+word1;
                                      }
                                      else if((TotalInWords.length()>39 && TotalInWords.length()<70)){
    
                                          Result+= "&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;"+word2;
    
    
                                      }
                                      else if((TotalInWords.length()>=70 && TotalInWords.length()<=100)){
    
                                          Result+="&nbsp;&nbsp;"+word1+"<br>"+ "&nbsp;&nbsp;"+word2+"<br>"+"&nbsp;&nbsp;"+word3;
    
                                      }
                                      else if(TotalInWords.length()>100){
                                          Result+="&nbsp;&nbsp;"+word1+"<br>"+"&nbsp;&nbsp;"+word2+"<br>"+"&nbsp;&nbsp;"+word3+"<br>"+"&nbsp;&nbsp;"+word4;
                             }
                                     Result+="<br/><br/><br/>"
                                      +"<div style=\"width:100%\">"
                                      +" <br><br><br>  <div style=\"float:left\">&nbsp;&nbsp;&nbsp;"+ReceiptNo +"</div>"
                                      +"</div>"
                                      +"</div>"

                      +"</body>"
                      +"</html>"; 
          }
       
       
        return Result;
        }
    
    @Override
	public String GetWelfareFund(String KARNumber) {
		
		
	
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT [EnrollmentId] "
    +" ,[ReceiptTransactionId] "
    +" ,[WelfareFundInstallmentNo] "
     +" ,[FromYear] "
     +" ,[ToYear] "
    		  +" ,[AmountPaid] "
      +",[AmountPaidOn] "
    		  +",[ReceiptNo] "
     +" ,[ReceiptDate] "
     +" FROM [dbo].[Enrollment_WelfareFundPayments] where EnrollmentId=? ORDER BY ToYear asc";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber.trim());
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			 	      int Index=1;
			      responseString="<table class='table  table-bordered'><thead><tr><th>#</th><th>EnrollmentId</th><th>Paid Year</th>"
		    			  +  "<th>AmountPaid</th><th>AmountPaidOn</th> </tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      while(rs.next()){
			         //Retrieve by column name
			    	 
			    					   
			    					  
			    						   responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +rs.getString("EnrollmentId")+"</b></td>"
			    								     
			    								    
			    								      +  " <td><b> " +rs.getInt("FromYear")+"</b></td>"
			    								    
			    								      +  " <td><b> " +rs.getBigDecimal("AmountPaid")+"</b></td>"
			    								     
			    								      
			    								        +  " <td><b> " +rs.getTimestamp("AmountPaidOn")+"</b></td>"
			    								     
			    						   +" </tr>";
			    						   Index++;
			      }
			    								      
			      responseString+=	 " </tbody> "+  "</table><br></br><br></br>"; 
			      JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			      responseString+=  JSPRelatedFunctionsimp.GetPayBalenceForKARNumber(KARNumber);
			    
			      responseString+=   "<br><br></br><br></br>";
			      responseString+=  JSPRelatedFunctionsimp.GetClaimDetailsForWelfare(KARNumber);
			      
			      responseString+=   "<br><br>";
			     
			      rs.close();
			      PrepareStateMent.close();
			     
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String VerifyChallanForEnrollmentOffline() {
		
		String responseString="Sorry List is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<FeeStructureForKAR> absentList=JSPRelatedFunctionsimp.ViewChallanForEnrollmentOffline();
		
		if (absentList.get(0)==null)
		{
			System.out.println("Coming into if part");
		return responseString;	
		}
		
		else 
		{
			
			System.out.println("Shedule confirm list"
					+ absentList);
			
			System.out.println("Coming into else part");
			   responseString="<table class='table  table-bordered'><thead><tr><th>#</th><th>KAR Number</th> <th>Name</th><th>Certificate Copy Charge</th>"
	  +  "<th>Change Address</th>Change of Name Publication<th>ClosingFD</th><th>Complain Fee</th> "
	  + "<th>Continuity Certificater</th> <th>DOB Certificate</th><th>Duplicate Enrollemt</th>"
	  +  "<th>Election Deposit</th>Election Rules<th>EndomentCertificate</th><th>EnrollmentApplication</th> "
	  + ""
	  + ""
	  + ""
	  + "<th>Enrollment Fee</th> <th>IdentityCard</th><th>KSBC Cost Receipt</th>"
	  +  "<th>KSBCInterestONFD</th><th>MiscReceipts</th><th>NOC</th><th>NominationForm</th><th>PDC</th>"
	  + "<th>PostageReceipts</th><th>ProcessFee</th>"
	  + "<th>ReimbursementOFSalaryDeduction</th><th>VoterCD</th><th>VSP</th></tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int indexForSchedule=1;
			   
			   for (FeeStructureForKAR RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+indexForSchedule+"</th>"
						    +  " <td><b> " +RegBean.getKARNumber()+"</b></td>"
						      +  " <td><b> " +RegBean.getNameOftheClient()+"</b></td>"
						      +  " <td><b> " +RegBean.getCertificateCopyCharges()+"</b></td>"
						      +  " <td><b> " +RegBean.getChangeOfAddress()+"</b></td>"
						      +  " <td><b> " +RegBean.getChangeOfNamePublication()+"</b></td>"
						      +  " <td><b> " +RegBean.getClosingFD()+"</b></td>"
						       +  " <td><b> " +RegBean.getComplaintFee()+"</b></td>"
						        +  " <td><b> " +RegBean.getContinuityCertificate()+"</b></td>"
						         +  " <td><b> " +RegBean.getDOBCertificate()+"</b></td>"
						          +  " <td><b> " +RegBean.getDuplicateEnrollemt()+"</b></td>"
						           +  " <td><b> " +RegBean.getElectionDeposit()+"</b></td>"
						           
						             +  " <td><b> " +RegBean.getElectionRules()+"</b></td>"
						       +  " <td><b> " +RegBean.getEndomentCertificate()+"</b></td>"
						        +  " <td><b> " +RegBean.getEnrollmentApplication()+"</b></td>"
						  //       +  " <td><b> " +RegBean.getEnrollmentFee()+"</b></td>"
						          +  " <td><b> " +RegBean.getIdentityCard()+"</b></td>"
						           +  " <td><b> " +RegBean.getKSBCCostReceipt()+"</b></td>"
	 +  " <td><b> " +RegBean.getKSBCInterestONFD()+"</b></td>"
						       +  " <td><b> " +RegBean.getMiscReceipts()+"</b></td>"
						        +  " <td><b> " +RegBean.getNOC()+"</b></td>"
						         +  " <td><b> " +RegBean.getNominationForm()+"</b></td>"
						          +  " <td><b> " +RegBean.getPDC()+"</b></td>"
						           +  " <td><b> " +RegBean.getPostageReceipts()+"</b></td>"
						           
						           
						           
			+  " <td><b> " +RegBean.getProcessFee()+"</b></td>"
						         +  " <td><b> " +RegBean.getReimbursementOFSalaryDeduction()+"</b></td>"
						          +  " <td><b> " +RegBean.getVoterCD()+"</b></td>"
						           +  " <td><b> " +RegBean.getVSP()+"</b></td>"
				   +" </tr>";
				   indexForSchedule++;
			}
	  
			   responseString += /* " <td><b> " 
	      
	      
+ "<form id='FormForScheduleInterview'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='ConfirmChallanPay' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='ConfirmChallanPay' value='ConfirmChallanPay'  id='ConfirmChallanPay'  >"
	
+"	</form> "
	


	

 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#ConfirmChallanPay').click(function(event) { "
+ "alert('********** challan ***********');"
+" var RegNumber=$('#RegNumber').val(); "
	+ "var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
+"</b></td>"
	      +  " <td><b> " 
	      

+ "<form id='FormForViewChallan'   target='_blank'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='SeeChallan' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='SeeChallan' value='SeeChallan'  id='SeeChallan'  >"
		
	+"	</form> "
		

	
		
	
 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#SeeChallan').click(function(event) { "
	+ "alert('********** SeeChallan ***********');"
	+" var RegNumber=$('#RegNumber').val(); "

		+ "var WhichFunctionToHandle='SeeChallan';"
		+"alert(WhichFunctionToHandle);"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
	      +"</b></td>"
	              
	    
	   +  " </tr>"*/
	  /* +  " <tr>"
	   +  "   <th scope='row'>2</th>"
	    +  "  <td><b>Jacob</b></td>"
	    +  "  <td><b>Thornton</b></td>"
	    +  "  <td><b>@fat</b></td>"
	   +  " </tr>"
	  +  "  <tr>"
	   +  "   <th scope='row'>3</th>"
	   +  "   <td><b>Larry</b></td>"
	   +  "   <td><b>the Bird</b></td>"
	   +  "   <td><b>@twitter</b></td>"
	  +  "  </tr> "*/
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public ArrayList<FeeStructureForKAR> ViewChallanForEnrollmentOffline() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from FeeStructureForKAR");
		
		 @SuppressWarnings("unchecked")
		ArrayList<FeeStructureForKAR> list = (ArrayList<FeeStructureForKAR>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public ArrayList<AcceptedCandidate> ViewAcceptList() {
		
		return null;
	}

	@Override
	public String AcceptcandidateJSP() {
		
		String responseString="Sorry Absent List is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<AcceptedCandidate> absentList=JSPRelatedFunctionsimp.ViewAcceptedCandidate();
	// Arun absentbean	
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>#</th>"
			   		+ "<th>Reg Number</th><th>Name</th><th>Father Name</th>"
	  +  "<th>DOB</th> </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int Index=0;
			   for (AcceptedCandidate RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+Index+"</th>"
						    +  " <td><b> " +RegBean.getRegNumber()+"</b></td>"
						      +  " <td><b> " +RegBean.getFullName()+"</b></td>"
						      +  " <td><b> " +RegBean.getFather_name()+"</b></td>"
						      +  " <td><b> " +RegBean.getBirthdate()+"</b></td>"
						  ;
				   Index++;
				  
			}
			   responseString+="<form action=\"GenerateAllCandidateKAR\" name='GenerateAllCandidateKAR'>"
						
	+"<input type=\"button\"  class=\"btn btn-info\" value=\"GenerateKAR\"  onclick=\" CallToServletForGenerateKAR() \"  name=\"GenerateKAR\"></form>";
			   responseString += /* " <td><b> " 
	      
	      
+ "<form id='FormForScheduleInterview'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='ConfirmChallanPay' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='ConfirmChallanPay' value='ConfirmChallanPay'  id='ConfirmChallanPay'  >"
	
+"	</form> "
	


	

 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#ConfirmChallanPay').click(function(event) { "
+ "alert('********** challan ***********');"
+" var RegNumber=$('#RegNumber').val(); "
	+ "var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
+"</b></td>"
	      +  " <td><b> " 
	      

+ "<form id='FormForViewChallan'   target='_blank'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='SeeChallan' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='SeeChallan' value='SeeChallan'  id='SeeChallan'  >"
		
	+"	</form> "
		

	
		
	
 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#SeeChallan').click(function(event) { "
	+ "alert('********** SeeChallan ***********');"
	+" var RegNumber=$('#RegNumber').val(); "

		+ "var WhichFunctionToHandle='SeeChallan';"
		+"alert(WhichFunctionToHandle);"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
	      +"</b></td>"
	              
	    
	   +  " </tr>"*/
	  /* +  " <tr>"
	   +  "   <th scope='row'>2</th>"
	    +  "  <td><b>Jacob</b></td>"
	    +  "  <td><b>Thornton</b></td>"
	    +  "  <td><b>@fat</b></td>"
	   +  " </tr>"
	  +  "  <tr>"
	   +  "   <th scope='row'>3</th>"
	   +  "   <td><b>Larry</b></td>"
	   +  "   <td><b>the Bird</b></td>"
	   +  "   <td><b>@twitter</b></td>"
	  +  "  </tr> "*/
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public ArrayList<AcceptedCandidate> ViewAcceptedCandidate() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from AcceptedCandidate");
		
		 @SuppressWarnings("unchecked")
		ArrayList<AcceptedCandidate> list = (ArrayList<AcceptedCandidate>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public ArrayList<AcceptedCandidate> ViewAcceptedCandidateIndesc() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from AcceptedCandidate order by birthdate asc");
		
		 @SuppressWarnings("unchecked")
		ArrayList<AcceptedCandidate> list = (ArrayList<AcceptedCandidate>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
			e.printStackTrace();
			
			
		return null;	
		}
	}

	@Override
	public String GetWelfareFundLastPay(String KARNumber) {
		
		
		
		String responseString = " Data not found  ";
		Connection conn=null;
		try
		{
		 conn = JDBCUtil.GetConnection();
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
	
		 responseString = "  its not working ";
		
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT TOP 1 [EnrollmentId] "
    +" ,[ReceiptTransactionId] "
    +" ,[WelfareFundInstallmentNo] "
     +" ,[FromYear] "
     +" ,[ToYear] "
    		  +" ,[AmountPaid] "
      +",[AmountPaidOn] "
    		  +",[ReceiptNo] "
     +" ,[ReceiptDate] "
     +" FROM [dbo].[Enrollment_WelfareFundPayments] where EnrollmentId=? ORDER BY ToYear desc ";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber.trim());
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			    /*  SELECT TOP (1000) [EnrollmentId]
			    	      ,[ReceiptTransactionId]
			    	      ,[WelfareFundInstallmentNo]
			    	      ,[FromYear]
			    	      ,[ToYear]
			    	      ,[AmountPaid]
			    	      ,[AmountPaidOn]
			    	      ,[ReceiptNo]
			    	      ,[ReceiptDate]
			    	  FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments]*/
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;
			      responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>EnrollmentId</th><th>FromYear</th>"
		    			  +  "<th>AmountPaid</th><th>AmountPaidOn</th> </tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      while(rs.next()){
			         //Retrieve by column name
			    	 
			    					   
			    					  if (Index==1)
			    					  {
			    						  responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +rs.getString("EnrollmentId")+"</b></td>"
			    								     
			    								    
			    								      +  " <td><b> " +rs.getInt("FromYear")+"</b></td>"
			    								     +  " <td><b> " +rs.getBigDecimal("AmountPaid")+"</b></td>"
			    								     
			    								      
			    								        +  " <td><b> " +rs.getTimestamp("AmountPaidOn")+"</b></td>"
			    								     
			    						   +" </tr>";	  
			    					  }
			    						   
			    						   Index++;
			    						   
			    						   
			      }
			    								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	/* resultoutput=Count;
			    	 System.out.println(Count);
			       */ /* int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);*/
			      
			      //STEP 6: Clean-up environment
			      
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public EnrollmentDetails GetEnrollmentDetails(String KARNumber) {
		
		
		EnrollmentDetails EnrollmentDetails = new EnrollmentDetails();
		String responseString = " Data not found  ";
		Connection conn=null;
		try
		{
		 conn = JDBCUtil.GetConnection();
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
	
		 responseString = "  its not working ";
		
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
					
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "SELECT  TOP 1"
 +" [EnrollmentId] "
 +"  ,[RollNo]"
     +"  ,[EnrollNo] "
     +"  ,[EnrollmentRegistrationNo]"
     +"  ,[CertificateNo]"
    +"   ,[TitleId]"
    +"   ,[Name]"
    +"   ,[Gender]"
      +" ,[Father_Title]"
    		  +"  ,[FatherName]"
   +"    ,[DateOfBirth]"
    +"   ,[BloodGroup]"
     +"  ,[CategoryId]"
     +"  ,[Communication_Address1]"
     +"  ,[Communication_Address2]"
     +"  ,[Communication_Address3]"
    +"   ,[Communication_City]"
    +"   ,[Communication_State]"
     +"  ,[Communication_PinCode]"
     +"  ,[Permanent_Address1]"
     +"  ,[Permanent_Address2]"
    		  +"  ,[Permanent_Address3]"
     +"  ,[Permanent_PinCode]"
      +" ,[Permanent_City]"
     +"  ,[Permanent_State]"
     +"  ,[Nominee_Title]"
     +"  ,[Nominee_Name]"
     +"  ,[IsMinor]"
    +"   ,[GuardianName]"
     +"  ,[Relationship]"
    +"   ,[Nominee_Address1]"
      +" ,[Nominee_Address2]"
    +"   ,[Nominee_Address3]"
    +"   ,[Nominee_City]"
     +"  ,[Nominee_State]"
    +"   ,[Nominee_PinCode]"
    +"   ,[PracticeCategory]"
     +"  ,[EMail]"
     +"  ,[Phone_Res]"
    +"   ,[Phone_Off]"
     +"  ,[MobileNo]"
    +"   ,[Remarks]"
    +"   ,[EnrollmentStatus]"
    +"   ,[EnrollmentSource]"
   +"    ,[WelfareMember]"
    +"   ,[EnrollmentDate]"
    +"   ,[Place_Of_Practice]"
    +"   ,[WelfareMemberUpdatedDate]"
    +"   ,[SeniorMember]"
    +"   ,[SeniorMemberUpdatedDate]"
    +"   ,[enr_Year]"
     +"  ,[enr_Month]"
    		  +"  ,[enr_Days]"
      +" ,[SeniorAdvocate]"
      +" ,[SeniorAdvocateUpdatedDate]"
    +"   ,[CertificateStatus]"
     +"  ,[CertificateIssued]"
    		  +"  ,[CertificateIssuedOn]"
     +"  ,[ManagerApproved]"
     +"  ,[NomineeVerified]"
     +"  ,[ApplnForm]"
     +"  ,[WelfareLifeTimeMember]"
  +" FROM [dbo].[EnrollmentDetails] where RollNo=?";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber.trim());
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			    /*  SELECT TOP (1000) [EnrollmentId]
			    	      ,[ReceiptTransactionId]
			    	      ,[WelfareFundInstallmentNo]
			    	      ,[FromYear]
			    	      ,[ToYear]
			    	      ,[AmountPaid]
			    	      ,[AmountPaidOn]
			    	      ,[ReceiptNo]
			    	      ,[ReceiptDate]
			    	  FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments]*/
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;System.out.println();
			      responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>EnrollmentId</th><th>FromYear</th>"
		    			  +  "<th>ToYear</th><th>AmountPaid</th><th>AmountPaidOn</th> </tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      int Enrollmentid=0;
			      while(rs.next()){
			         //Retrieve by column name
			    	 System.out.println(rs.getString("Name")   + "  #####################");
			    	 System.out.println(rs.getString("EnrollmentRegistrationNo"));
			    	 System.out.println(rs.getString("CertificateNo"));
			    	 System.out.println(rs.getString("CertificateNo"));
			    	 System.out.println(rs.getString("EnrollmentId") + "  EnrollmentId");
			    	 try
			    	 {
			    		 Enrollmentid= Integer.parseInt(rs.getString("EnrollmentId"));
			    	 }
			    	 catch (Exception e)
			    	 {
			    		e.printStackTrace(); 
			    	 }
			    	 EnrollmentDetails.setEnrollmentId(Enrollmentid);
			    	 EnrollmentDetails.setRollNo(rs.getString("RollNo"));
			    	 EnrollmentDetails.setName(rs.getString("Name") );
			    	 EnrollmentDetails.setEMail(rs.getString("EMail"));
			    	 EnrollmentDetails.setBloodGroup(rs.getString("bloodGroup"));
			    //	 EnrollmentDetails.setApplnForm(rs.getString("ApplnForm").charAt(0));
			    	 EnrollmentDetails.setCategoryId(rs.getShort("CategoryId"));
			    	 EnrollmentDetails.setCategoryId(rs.getShort("CategoryId"));
			    	 EnrollmentDetails.setCertificateIssuedOn(rs.getTimestamp("CertificateIssuedOn"));
			    	 EnrollmentDetails.setCertificateStatus(rs.getString("CertificateStatus"));
			    	 EnrollmentDetails.setCertificateStatus(rs.getString("CertificateStatus"));
			    	 EnrollmentDetails.setCommunication_Address1(rs.getString("Communication_Address1"));
			    	 EnrollmentDetails.setCommunication_Address2(rs.getString("Communication_Address2"));
			    	 EnrollmentDetails.setCommunication_Address3(rs.getString("communication_Address3"));
			    	// EnrollmentDetails.setCommunication_Address3(communication_Address3);
			    	 EnrollmentDetails.setCommunication_City(rs.getString("Communication_City"));
			    	 EnrollmentDetails.setCommunication_PinCode(rs.getString("Communication_PinCode"));		
			    	 EnrollmentDetails.setCommunication_PinCode(rs.getString("Communication_PinCode"));
			    	 EnrollmentDetails.setCommunication_State(rs.getShort("Communication_State"));
			    	 EnrollmentDetails.setDateOfBirth(rs.getTimestamp("DateOfBirth"));
			    	//  EnrollmentDetails.setEMail(eMail);
			    	 EnrollmentDetails.setEnr_Days(rs.getBigDecimal("enr_Days"));
			    	 EnrollmentDetails.setEnr_Month(rs.getBigDecimal("enr_Month"));
			    	// EnrollmentDetails.setEnr_Month(enr_Month);
			    	 EnrollmentDetails.setEnr_Year(rs.getBigDecimal("enr_Year"));
			    	 EnrollmentDetails.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
			    //	 EnrollmentDetails.setEnrollmentDate(enrollmentDate);
			    	 EnrollmentDetails.setEnrollmentRegistrationNo(rs.getString("EnrollmentRegistrationNo"));
			    	// EnrollmentDetails.setEnrollmentSource(rs.getString("EnrollmentSource").charAt(0));
			    	 EnrollmentDetails.setRemarks(rs.getString("Remarks"));
			    	 EnrollmentDetails.setRelationship(rs.getString("Relationship"));
			    	
			    	 
			    	 if ((rs.getString("WelfareMember")==null) || (rs.getString("WelfareMember")==""))
				    	{
			    		 EnrollmentDetails.setWelfareMember('N');
				    	}
				    	else
				    	{
				    		 EnrollmentDetails.setWelfareMember(rs.getString("WelfareMember").charAt(0));
				    	}
			    	 
			    	 
			    	 if ((rs.getString("EnrollmentSource")==null) || (rs.getString("EnrollmentSource")==""))
				    	{
			    		 EnrollmentDetails.setEnrollmentSource('N');
				    	}
				    	else
				    	{
				    		 EnrollmentDetails.setEnrollmentSource(rs.getString("EnrollmentSource").charAt(0));
				    	}
			    	// EnrollmentDetails.setEnrollmentSource(enrollmentSource);
			    //	 EnrollmentDetails.setEnrollmentStatus(rs.getString("EnrollmentStatus").charAt(0));
			    	 
			    	 
			    	 if ((rs.getString("EnrollmentStatus")==null) || (rs.getString("EnrollmentStatus")==""))
				    	{
			    		 EnrollmentDetails.setEnrollmentStatus('N');
				    	}
				    	else
				    	{
				    		 EnrollmentDetails.setEnrollmentStatus(rs.getString("EnrollmentStatus").charAt(0));
				    	}
			    	 
			    	 
			    	 EnrollmentDetails.setEnrollNo(rs.getString("EnrollNo"));
			    	 EnrollmentDetails.setFather_Title(rs.getInt("Father_Title"));
			    	 EnrollmentDetails.setFatherName(rs.getString("FatherName"));
			    //	 EnrollmentDetails.setGender(rs.getString("Gender").charAt(0));
			    	 
			    	 if ((rs.getString("Gender")==null) || (rs.getString("Gender")==""))
				    	{
				    		EnrollmentDetails.setGender('M');
				    	}
				    	else
				    	{
				    		EnrollmentDetails.setGender(rs.getString("Gender").charAt(0));
				    	}
			    	 
			    	 
			    	 
			    	 EnrollmentDetails.setGuardianName(rs.getString("GuardianName"));
			    	 
			    	if ((rs.getString("IsMinor")==null) || (rs.getString("ManagerApproved")==""))
			    	{
			    		EnrollmentDetails.setManagerApproved('N');
			    	}
			    	else
			    	{
			    		EnrollmentDetails.setManagerApproved(rs.getString("IsMinor").charAt(0));
			    	}
			    	//  EnrollmentDetails.setIsMinor(rs.getString("IsMinor").charAt(0));
			    	// EnrollmentDetails.setManagerApproved(rs.getString("ManagerApproved").charAt(0));
			    	 EnrollmentDetails.setMobileNo(rs.getString("MobileNo"));
			    	 EnrollmentDetails.setName(rs.getString("Name"));
			    	 EnrollmentDetails.setNominee_Address1(rs.getString("Nominee_Address1"));
			    	 EnrollmentDetails.setNominee_Address2(rs.getString("Nominee_Address2"));
			    	 EnrollmentDetails.setNominee_Address3(rs.getString("nominee_Address3"));
			    	 EnrollmentDetails.setNominee_City(rs.getString("Nominee_City"));
			    	 EnrollmentDetails.setNominee_Name(rs.getString("Nominee_Name"));
			    	 EnrollmentDetails.setNominee_PinCode(rs.getString("Nominee_PinCode"));
			    	// EnrollmentDetails.setNominee_Name(nominee_Name);
			    	 EnrollmentDetails.setNominee_State(rs.getShort("Nominee_State"));
			    	 EnrollmentDetails.setNominee_Title(rs.getInt("Nominee_Title"));
			   // 	 EnrollmentDetails.setNomineeVerified(rs.getString("NomineeVerified").charAt(0));
			    	 //WelfareMemberUpdatedDate
			    	 EnrollmentDetails.setWelfareMemberUpdatedDate(rs.getTimestamp("WelfareMemberUpdatedDate"));
			    	 EnrollmentDetails.setPlace_Of_Practice(rs.getString("Place_Of_Practice"));
			    	 if ((rs.getString("NomineeVerified")==null) || (rs.getString("NomineeVerified")==""))
				    	{
				    		EnrollmentDetails.setNomineeVerified('N');
				    	}
				    	else
				    	{
				    		EnrollmentDetails.setNomineeVerified(rs.getString("NomineeVerified").charAt(0));
				    	}
			    	 
			    	 
			    //	 EnrollmentDetails.setWelfareLifeTimeMember(welfareLifeTimeMember);
			    	 if ((rs.getString("WelfareLifeTimeMember")==null) || (rs.getString("WelfareLifeTimeMember")=="N"))
				    	{
				    		EnrollmentDetails.setWelfareLifeTimeMember('N');
				    	}
				    	else
				    	{
				    		EnrollmentDetails.setWelfareLifeTimeMember(rs.getString("WelfareLifeTimeMember").charAt(0));
				    	}
			    	 
			    	 
			    	 System.out.println(rs.getString("Communication_Address1"));
			    	 System.out.println(rs.getString("Communication_Address2")); 
			    	 System.out.println(rs.getString("Communication_PinCode"));
			    	 System.out.println(rs.getString("Communication_City"));
			    	 
			    	 System.out.println(rs.getString("Permanent_Address1"));
			    	 System.out.println(rs.getString("Permanent_Address2"));
			    	 System.out.println(rs.getString("Permanent_Address3"));
			    	 System.out.println(rs.getString("Permanent_PinCode"));
			    	 System.out.println(rs.getString("Nominee_Name"));
			    	 System.out.println(rs.getString("GuardianName"));
			    	 System.out.println(rs.getString("Relationship"));
			    	 System.out.println(rs.getString("Nominee_Address1"));
			    	 System.out.println(rs.getString("Nominee_Address2"));   //Nominee_Address3
			    	 if ((rs.getString("Permanent_Address1")==null) || (rs.getString("Permanent_Address1")==""))
				    	{
				    		EnrollmentDetails.setPermanent_Address1("");
				    	}
				    	else
				    	{
				    		EnrollmentDetails.setPermanent_Address1(rs.getString("Permanent_Address1"));
				    	}
			    	 if ((rs.getString("Permanent_Address2")==null) || (rs.getString("Permanent_Address2")==""))
				    	{
				    		EnrollmentDetails.setPermanent_Address2("");
				    	}
				    	else
				    	{
				    		EnrollmentDetails.setPermanent_Address2(rs.getString("Permanent_Address2"));
				    	}
			    	 
			    	 if ((rs.getString("Permanent_Address3")==null) || (rs.getString("Permanent_Address3")==""))
				    	{
				    		EnrollmentDetails.setPermanent_Address3("");
				    	}
				    	else
				    	{
				    		EnrollmentDetails.setPermanent_Address3(rs.getString("Permanent_Address3"));
				    	}
			    	 System.out.println((rs.getString("Gender")));
			    	 System.out.println((rs.getString("IsMinor")));
			    	 System.out.println((rs.getString("EnrollmentStatus")));
			    	 System.out.println((rs.getString("EnrollmentSource")));
			    	 System.out.println((rs.getString("WelfareMember")));
			    	 System.out.println((rs.getString("SeniorMember")));
			    	 
			    	 
			    	 
			    	 System.out.println((rs.getString("ManagerApproved")));
			    	 System.out.println((rs.getString("NomineeVerified")));
			    	 System.out.println((rs.getString("ApplnForm")));
			    	 System.out.println((rs.getString("WelfareLifeTimeMember")));
			    	
			    	 
			    	 // int 
			    	 
			    	 System.out.println(rs.getInt("TitleId"));
			    	 System.out.println(rs.getInt("Father_Title"));
			    	 System.out.println(rs.getInt("Nominee_Title"));
			    	 System.out.println(rs.getShort("PracticeCategory"));
			    	 System.out.println(rs.getShort("Nominee_State"));
			    	 System.out.println(rs.getShort("Permanent_State"));
			    	 System.out.println(rs.getShort("Communication_State"));
			    	 System.out.println(rs.getShort("CategoryId"));
			    	
			    	 //time stamp
			    	 
			    	 System.out.println(rs.getTimestamp("DateOfBirth"));
			    	 System.out.println(rs.getTimestamp("EnrollmentDate"));
			    	 System.out.println(rs.getTimestamp("WelfareMemberUpdatedDate"));
			    	 System.out.println(rs.getTimestamp("SeniorMemberUpdatedDate"));
			    	 System.out.println(rs.getTimestamp("SeniorAdvocateUpdatedDate"));
			    	 
			    	 System.out.println(rs.getTimestamp("CertificateIssuedOn"));
			    	 
			    	 
			    	 
			    	 // BigDecimal
			    	 
			    	 System.out.println(rs.getBigDecimal("enr_Year"));
			    	 System.out.println(rs.getBigDecimal("enr_Month"));
			    	 System.out.println(rs.getBigDecimal("enr_Days"));
			    	
			    	 
			    	 System.out.println(rs.getString("Nominee_City"));
			    	 System.out.println(rs.getString("Nominee_PinCode"));
			   
			    	 System.out.println(rs.getString("Phone_Res"));
			    	 System.out.println(rs.getString("Phone_Off"));
			    	 System.out.println(rs.getString("MobileNo"));
			    	 System.out.println(rs.getString("Place_Of_Practice"));
			    	 System.out.println(rs.getString("CertificateStatus"));
			    	 System.out.println(rs.getString("Nominee_Address2"));
			    	 
			    	 
			    	 responseString+=rs.getString("EnrollNo");
			    	 EnrollmentDetails.setName(rs.getString("Name") );      
			    	 
			    	 EnrollmentDetails.setPermanent_City(rs.getString("Permanent_City"));
			    	 
			    	 
			      }
			   System.out.println("!!!!!!!!!@#$#########################"); 								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    
			      
			} // connection == null

		} catch (SQLException ex) {
			responseString=ex.toString();
			
			System.out.println("Error");
			ex.printStackTrace();
		} finally {
			try {
				
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Error finally ");
				ex.printStackTrace();
			}
		}

		return EnrollmentDetails;
	
	
	
	}

	@Override
	public ArrayList<CashSectionMonthlyReportFlow> ToDoListForNewEnrollment() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from CashSectionMonthlyReportFlow where (EntFee>0) or (IC>0) or (KLA>0) or (Misc>0) ");
		
		 @SuppressWarnings("unchecked")
		ArrayList<CashSectionMonthlyReportFlow> list = (ArrayList<CashSectionMonthlyReportFlow>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public String JSPforToDoListOfNewEnrollment() {
		
		String responseString="Sorry Absent List is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<CashSectionMonthlyReportFlow> absentList=JSPRelatedFunctionsimp.ToDoListForNewEnrollment();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>SL Number</th><th>Receipt Number</th>"
			   		+ "<th>Date</th><th>Particulars</th><th>Enroll Number</th>"
			   		+ "<th>Name</th>"
			   		+ ""
			   		+ "<th>place</th>"
	  +  "<th>Amount</th><th>Enrollment Fee</th><th>KLA</th> <th>Misc</th><th>IC</th> "
	  + " <th>Done</th><th>Delete</th></tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   
			   for (CashSectionMonthlyReportFlow RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>1</th>"
						    +  " <td><b> " +RegBean.getReceiptNo()+"</b></td>"
						    +  " <td><b> " +RegBean.getChallanCreatedDate()+"</b></td>"
						    +  " <td><b> " +RegBean.getParticulars()+"</b></td>"
						    
						      +  " <td><b> " +RegBean.getEnrollNo()+"</b></td>"
						       +  " <td><b> " +RegBean.getName()+"</b></td>"
						      +  " <td><b> " +RegBean.getPlace()+"</b></td>"
						      +  " <td><b> " +RegBean.getAmount()+"</b></td>"
						      +  " <td><b> " +RegBean.getEntFee()+"</b></td>"
						      +  " <td><b> " +RegBean.getKLA()+"</b></td>"
						      +  " <td><b> " +RegBean.getMisc()+"</b></td>"
						      +  " <td><b> " +RegBean.getIC()+"</b></td>"
						      +"   <td><b> <button class=\"btn btn-info\" name='Confirm' onclick=\" CallToServletFromJSPForNewEnrollmentTodoList1('"+RegBean.getReceiptNo() +"','"+RegBean.getParticulars()+"');\" >Done</button></b></td>"
				   +"   <td><b> <button class=\"btn btn-info\" name='Confirm' onclick=\" CallToServletFromJSPForNewEnrollmentTodoList2('"+RegBean.getReceiptNo() +"','"+RegBean.getParticulars()+"');\" >Confirm</button></b></td>";
					
				  
			}
	  
			   responseString += /* " <td><b> " 
	      
	      
+ "<form id='FormForScheduleInterview'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='ConfirmChallanPay' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='ConfirmChallanPay' value='ConfirmChallanPay'  id='ConfirmChallanPay'  >"
	
+"	</form> "
	


	

 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#ConfirmChallanPay').click(function(event) { "
+ "alert('********** challan ***********');"
+" var RegNumber=$('#RegNumber').val(); "
	+ "var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
+"</b></td>"
	      +  " <td><b> " 
	      

+ "<form id='FormForViewChallan'   target='_blank'>"
+ "<input type='hidden' value="+"'"+ RegBean.getRegNumber()+ "'"+"  name='RegNumber' id='RegNumber'>"
+ "<input type='hidden' value='SeeChallan' name='WhichFunctionToHandle' id='WhichFunctionToHandle'>"
+		"<input type='button' class='btn btn-info' name='SeeChallan' value='SeeChallan'  id='SeeChallan'  >"
		
	+"	</form> "
		

	
		
	
 <script src="http://code.jquery.com/jquery-latest.js"></script>
+ "<script>"
+"     $('#SeeChallan').click(function(event) { "
	+ "alert('********** SeeChallan ***********');"
	+" var RegNumber=$('#RegNumber').val(); "

		+ "var WhichFunctionToHandle='SeeChallan';"
		+"alert(WhichFunctionToHandle);"
+ "         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {  "
+" $('#Main_Content1').html(responseText);  "+"}); "
+"  }); "
+"    </script> "
	      
	      +"</b></td>"
	              
	    
	   +  " </tr>"*/
	  /* +  " <tr>"
	   +  "   <th scope='row'>2</th>"
	    +  "  <td><b>Jacob</b></td>"
	    +  "  <td><b>Thornton</b></td>"
	    +  "  <td><b>@fat</b></td>"
	   +  " </tr>"
	  +  "  <tr>"
	   +  "   <th scope='row'>3</th>"
	   +  "   <td><b>Larry</b></td>"
	   +  "   <td><b>the Bird</b></td>"
	   +  "   <td><b>@twitter</b></td>"
	  +  "  </tr> "*/
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public String JSPForToDoListOfWelfareAccount() {
		
		String responseString="Sorry TODO list is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<CashSectionMonthlyReportFlow> absentList=JSPRelatedFunctionsimp.ToDoListForWelfare();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>SL Number</th>"
			   		+ "<th>Receipt Number</th><th>Date</th><th>Particulars</th><th>Enroll Number</th><th>place</th>"
	  +  "<th>Amount</th><th>KAWF</th> <th>Done</th> <th>Delete</th</tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int index=1;
			   for (CashSectionMonthlyReportFlow RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'> " +index+"</th>"
						    +  " <td><b> " +RegBean.getReceiptNo()+"</b></td>"
						     +  " <td><b> " +RegBean.getChallanCreatedDate()+"</b></td>"
						    +  " <td><b> " +RegBean.getParticulars()+"</b></td>"
						      +  " <td><b> " +RegBean.getEnrollNo()+"</b></td>"
						      +  " <td><b> " +RegBean.getPlace()+"</b></td>"
						      +  " <td><b> " +RegBean.getAmount()+"</b></td>"
						    
						      +  " <td><b> " +RegBean.getKAWF()+"</b></td>"
				   +"   <td><b> <button name='Confirm' class=\"btn btn-info\" onclick=\" CallToServletFromJSPForWelfareList1('"+RegBean.getReceiptNo() +"','"+RegBean.getParticulars()+"');\" >Done</button></b></td>"
				   +"   <td><b> <button name='Confirm' class=\"btn btn-info\" onclick=\" CallToServletFromJSPForWelfareList2('"+RegBean.getReceiptNo() +"','"+RegBean.getParticulars()+"');\" >Delete</button></b></td>";
					 
				   index++;
			   }
	  
			   responseString += 
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public ArrayList<CashSectionMonthlyReportFlow> ToDoListForWelfare() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from CashSectionMonthlyReportFlow where KAWF=2050");
		
		 @SuppressWarnings("unchecked")
		ArrayList<CashSectionMonthlyReportFlow> list = (ArrayList<CashSectionMonthlyReportFlow>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public String MoveToCashSectionMonthlyReportDone(String ReceiptNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from CashSectionMonthlyReportFlow where ReceiptNo = :ReceiptNo ");
		query.setParameter("ReceiptNo", ReceiptNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<CashSectionMonthlyReportFlow> list = (ArrayList<CashSectionMonthlyReportFlow>)query.list();
		 CashSectionMonthlyReportFlow RegistrationFormBean= list.get(0);
		 
		 CashSectionMonthlyReportDone ScheduleBean= new CashSectionMonthlyReportDone();
		 ScheduleBean.setAmount(RegistrationFormBean.getAmount());
		 ScheduleBean.setBCIAWF(RegistrationFormBean.getBCIAWF());
		 LocalDate date = LocalDate.now();
		 ScheduleBean.setChallanCreatedDate(Date.valueOf(date));
		 ScheduleBean.setEnrollNo(RegistrationFormBean.getEnrollNo());
		 ScheduleBean.setEntFee(RegistrationFormBean.getEntFee());
		 ScheduleBean.setFDS(RegistrationFormBean.getFDS());
		 ScheduleBean.setIC(RegistrationFormBean.getIC());
		 ScheduleBean.setKAWF(RegistrationFormBean.getKAWF());
		 ScheduleBean.setKLA(RegistrationFormBean.getKLA());
		 ScheduleBean.setMisc(RegistrationFormBean.getMisc());
		 ScheduleBean.setParticulars(RegistrationFormBean.getParticulars());
		 ScheduleBean.setPaymode(RegistrationFormBean.getPaymode());
		
		 ScheduleBean.setPlace(RegistrationFormBean.getPlace());
		 ScheduleBean.setReceiptNo(RegistrationFormBean.getReceiptNo());
		 ScheduleBean.setSTAMP(RegistrationFormBean.getSTAMP());
		 Session.saveOrUpdate(ScheduleBean);
		 Session.delete(RegistrationFormBean);
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	}

	@Override
	public String GenerateMnthlyReport(java.sql.Date FromDate,java.sql.Date ToDate) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI");
		Query query = Session.createQuery("from CashSectionMonthlyReport e  where (e.ChallanCreatedDate BETWEEN :stDate AND :edDate)");
		query.setDate("stDate", FromDate);
		query.setDate("edDate", ToDate);
		 @SuppressWarnings("unchecked")
		ArrayList<CashSectionMonthlyReport> list = (ArrayList<CashSectionMonthlyReport>)query.list();
		
		 
		String responseString="<table class='table table-bordered'><thead><tr><th>SL Number</th><th>Receipt Number</th><th>Enroll Number</th><th>place</th>"
				  +  "<th>Amount</th><th>KAWF</th> <th>D</th></tr>"
				  +  " </thead>"
				  +  "<tbody>";
						   
						   for (CashSectionMonthlyReport RegBean : list) {
							   responseString +=  " <tr>"
									    +  "  <th scope='row'>1</th>"
									    +  " <td><b> " +RegBean.getReceiptNo()+"</b></td>"
									      +  " <td><b> " +RegBean.getEnrollNo()+"</b></td>"
									      +  " <td><b> " +RegBean.getPlace()+"</b></td>"
									      +  " <td><b> " +RegBean.getAmount()+"</b></td>"
									    
									      +  " <td><b> " +RegBean.getKAWF()+"</b></td>"
							   +"   <td><b> <button name='Confirm' onclick=\" CallToServletFromJSPForWelfareTodoList('"+RegBean.getReceiptNo() +"');\" >Done</button></b></td>";
						}
				  
						   responseString += /* " <td><b> " 
				      
				      
				
			  "*/
				 " </tbody> "+  "</table>"; 
		 Session.close();
		 
		return responseString;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String GenerateDailyReport(Date FromDate) {
	    try
	    {
	      Session Session = HibernateUtil.getSessionFactory().openSession();
	      Session.beginTransaction();
	      
	      System.out.println("HI daily report");
	      




	      Query query = Session.createQuery("from CashSectionMonthlyReport  e  where (e.ChallanCreatedDate=:stDate )  ");
	      Timestamp timestamp = new Timestamp(FromDate.getTime());
	      System.out.println(FromDate + "    From Date");
	      System.out.println(timestamp + "   Time for report");
	      query.setDate("stDate", timestamp);
	      String ResponseResult = "";
	      

	      ArrayList<CashSectionMonthlyReport> list = (ArrayList)query.list();
	      System.out.println(list);
	      long KSBC = 0L;
	      long KSBC_DD = 0L;
	      long KSBC_TRUST = 0L;
	      long KSBCWF_FDS = 0L;
	      long KAWF_TC = 0L;
	      long KAWF_DD = 0L;
	      long STAMP = 0L;
	      long STAMP_DD = 0L;
	      long BCI_AWF = 0L;
	      long BCI_AWF_DD = 0L;
	      long FDS_DD = 0L;
	      String KSBC_DD_String = "";
	      String FDS_DD_String = "";
	      String KAWF_TC_String = "";
	      String BCI_AWF_String = "";
	      String STAMP_DD_String = "";
	      
	      long KSBC_total = 0L;
	      long Kawf_total = 0L;
	      long BCI_total = 0L;
	      long FDS_total = 0L;
	      long STAMP_total = 0L;
	      

	      long Global_total = 0L;
	      long Global_EntFee = 0L;
	      long Global_KLA = 0L;
	      long Global_ic = 0L;
	      long Global_misc = 0L;
	      long Global_BCI_AWF = 0L;
	      
	      long Global_Kawf_total = 0L;
	      
	      long Global_FDS_total = 0L;
	      long Global_STAMP_total = 0L;
	      


	      String responseString = "<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1><h1><center><b>Day Report Of the day : " + FromDate + "  </b></center></h1>";
	      

	      responseString = responseString + "<style>table { border-collapse: separate;   empty-cells: hide; }  @media print { table { border-collapse: separate;   empty-cells: hide; }  } </style><table class='table table-bordered'><thead><tr> <th >      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th><th>SL Number</th><th>Receipt Number</th><th>Enroll Number</th><th>Name</th><th>Place</th><th>Particulars</th> <th>Paymode</th><th>Amount</th><th>Ent Fee</th><th>KLA</th><th>I/C</th><th>Misc</th><th>KAWF</th><th>STAMP</th><th>BCI AWF</th><th>FDS</th>"
	/*      		+ "<th>Operator</th>"
	      		+ ""
	      		+ ""*/
	      		+ "</tr> </thead><tbody>";
	      

	      int Index = 1;
	      for (CashSectionMonthlyReport RegBean : list)
	      {
	        if ("Cash".equalsIgnoreCase(RegBean.getPaymode()))
	        {
	          KAWF_TC += RegBean.getKAWF();
	          BCI_AWF += RegBean.getBCIAWF();
	          STAMP += RegBean.getSTAMP();
	          KSBCWF_FDS += RegBean.getFDS();
	          if ((RegBean.getEntFee() > 0) || (RegBean.getKLA() > 0) || (RegBean.getIC() > 0) || (RegBean.getMisc() > 0))
	          {
	            KSBC += RegBean.getEntFee() + RegBean.getKLA() + RegBean.getIC() + RegBean.getMisc();
	          }
	          

	        }
	        else
	        {
	          if ((RegBean.getEntFee() > 0) || (RegBean.getKLA() > 0) || (RegBean.getIC() > 0) || (RegBean.getMisc() > 0))
	          {
	            KSBC_DD += RegBean.getEntFee() + RegBean.getKLA() + RegBean.getIC() + RegBean.getMisc();
	            
	            try
	            {
	              String[] Split1 = RegBean.getPaymode().split("DDNumber:");
	              String[] split2 = Split1[1].split("DD Date");
	              
	              KSBC_DD_String = KSBC_DD_String + split2[0] + ",";
	            }
	            catch (Exception e)
	            {
	              KSBC_DD_String = KSBC_DD_String + RegBean.getPaymode();
	            }
	          }
	          

	          if (RegBean.getKAWF() > 0)
	          {
	            KAWF_DD += RegBean.getKAWF();
	            try
	            {
	              String[] Split1 = RegBean.getPaymode().split("DDNumber:");
	              String[] split2 = Split1[1].split("DD Date");
	              
	              KAWF_TC_String = KAWF_TC_String + split2[0] + ",";
	            }
	            catch (Exception e)
	            {
	              KAWF_TC_String = KAWF_TC_String + RegBean.getPaymode();
	            }
	          }
	          
	          if (RegBean.getFDS() > 0)
	          {
	            FDS_DD += RegBean.getFDS();
	            
	            try
	            {
	              String[] Split1 = RegBean.getPaymode().split("DDNumber:");
	              String[] split2 = Split1[1].split("DD Date");
	              
	              FDS_DD_String = FDS_DD_String + split2[0] + ",";
	            }
	            catch (Exception e)
	            {
	              FDS_DD_String = FDS_DD_String + RegBean.getPaymode();
	            }
	          }
	          
	          if (RegBean.getBCIAWF() > 0)
	          {
	            BCI_AWF_DD += RegBean.getBCIAWF();
	            

	            try
	            {
	              String[] Split1 = RegBean.getPaymode().split("DDNumber:");
	              String[] split2 = Split1[1].split("DD Date");
	              
	              BCI_AWF_String = BCI_AWF_String + split2[0] + ",";
	            }
	            catch (Exception e)
	            {
	              BCI_AWF_String = BCI_AWF_String + RegBean.getPaymode();
	            }
	          }
	          

	          if (RegBean.getSTAMP() > 0)
	          {
	            STAMP_DD += RegBean.getSTAMP();
	            

	            try
	            {
	              String[] Split1 = RegBean.getPaymode().split("DDNumber:");
	              String[] split2 = Split1[1].split("DD Date");
	              
	              STAMP_DD_String = STAMP_DD_String + split2[0] + ",";
	            }
	            catch (Exception e)
	            {
	              STAMP_DD_String = STAMP_DD_String + RegBean.getPaymode();
	            }
	          }
	        }
	 
	        responseString = responseString + " <tr> <td>      </td>  <td>   </td><td>     </td> <td>   </td><td>     </td> <td>      </td>  <td>   </td><td>     </td> <td>   </td><td>     </td>  <th scope='row'>" + Index + "</th> <td><b> " + RegBean.getReceiptNo() + "</b></td> <td><b> " + RegBean.getEnrollNo() + "</b></td> <td><b> " + RegBean.getName() + "</b></td> <td><b> " + RegBean.getPlace() + "</b></td> <td><b> " + RegBean.getParticulars() + "</b></td> <td><b> " + RegBean.getPaymode() + "</b></td> <td><b> " + RegBean.getAmount() + "</b></td> <td><b> " + RegBean.getEntFee() + "</b></td> <td><b> " + RegBean.getKLA() + "</b></td> <td><b> " + RegBean.getIC() + "</b></td> <td><b> " + RegBean.getMisc() + "</b></td> <td><b> " + RegBean.getKAWF() + "</b></td> <td><b> " + RegBean.getSTAMP() + "</b></td> <td><b> " + RegBean.getBCIAWF() + "</b></td> <td><b> " + RegBean.getFDS() + "</b></td> "
	        		+ ""
	        	/*	+ "<td><b> " + RegBean.getOperator() + "</b></td>"
	        				+ ""*/
	        				+ "</tr>";
	        
	        Global_EntFee += RegBean.getEntFee();
	        Global_KLA += RegBean.getKLA();
	        Global_ic += RegBean.getIC();
	        Global_misc += RegBean.getMisc();
	        Global_BCI_AWF += RegBean.getBCIAWF();
	        
	        Global_Kawf_total += RegBean.getKAWF();
	        
	        Global_FDS_total += RegBean.getFDS();
	        Global_STAMP_total += RegBean.getSTAMP();
	        Global_total += RegBean.getAmount();
	        Index++;
	      }
	      responseString = responseString + " <tr> <td>      </td>  <td>   </td><td>     </td> <td>   </td><td>     </td> <td>      </td>  <td>   </td><td>     </td> <td>   </td><td>     </td>  <th scope='row'><b>Total</b></th> <td><b> -</b></td> <td><b> -</b></td> <td><b> -</b></td> <td><b> -</b></td> <td><b> -</b></td> <td><b> -</b></td> <td><b> " + Global_total + "</b></td> <td><b> " + Global_EntFee + "</b></td> <td><b> " + Global_KLA + "</b></td> <td><b> " + Global_ic + "</b></td> <td><b> " + Global_misc + "</b></td> <td><b> " + Global_Kawf_total + "</b></td> <td><b> " + Global_STAMP_total + "</b></td> <td><b> " + Global_BCI_AWF + "</b></td> <td><b> " + Global_FDS_total + "</b></td> <td><b> -</b></td></tr>";
	      
 responseString = responseString + " </tbody> </table>";
	      
      Session.close();
	       KSBC_total = KSBC + KSBC_DD;
	      
	      Kawf_total = KAWF_TC + KAWF_DD;
	      BCI_total = BCI_AWF + BCI_AWF_DD;
	      FDS_total = KSBCWF_FDS + FDS_DD;
	      STAMP_total = STAMP + STAMP_DD;
	      
	      Long TotalAmount_cash = Long.valueOf(KSBC + KAWF_TC + BCI_AWF + KSBCWF_FDS + STAMP);
	      Long TotalAmount_DD = Long.valueOf(KSBC_DD + KAWF_DD + BCI_AWF_DD + FDS_DD + STAMP_DD);
	      Long Total_collection = Long.valueOf(TotalAmount_cash.longValue() + TotalAmount_DD.longValue());
	      responseString = responseString + "<br><br>";
	      responseString = responseString + "<table class='table table-bordered'><thead><tr> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th><th>Particulars</th><th>Total</th><th>Cash</th><th>DD Amount</th><th>Cheque/DD</th></tr> </thead><tbody>";
	      







	      responseString = responseString + "<tr> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th><th>KSBC</th><th>" + KSBC_total + "</th><th>" + KSBC + "</th><th>" + KSBC_DD + "</th><th>" + KSBC_DD_String + "</th></tr>";
	      




	      responseString = responseString + "<tr> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th><th>FDS</th><th>" + FDS_total + "</th><th>" + KSBCWF_FDS + "</th><th>" + FDS_DD + "</th><th>" + FDS_DD_String + "</th></tr>";
	      




	      responseString = responseString + "<tr> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th><th>KAWF</th><th>" + Kawf_total + "</th><th>" + KAWF_TC + "</th><th>" + KAWF_DD + "</th><th>" + KAWF_TC_String + "</th></tr>";
	      




	      responseString = responseString + "<tr> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th><th>STAMP</th><th>" + STAMP_total + "</th><th>" + STAMP + "</th><th>" + STAMP_DD + "</th><th>" + STAMP_DD_String + "</th></tr>";
	      





	      responseString = responseString + "<tr> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th><th>BCI AWF</th><th>" + BCI_total + "</th><th>" + BCI_AWF + "</th><th>" + BCI_AWF_DD + "</th><th>" + BCI_AWF_String + "</th></tr>";
	      





	      responseString = responseString + "<tr> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th> <th>      </th>  <th>   </th><th>     </th> <th>   </th><th>     </th><th><b>Total</b></th><th>" + Total_collection + "</th><th>" + TotalAmount_cash + "</th><th>" + TotalAmount_DD + "</th><th></tr>";
	      





	      responseString = responseString + " </tbody> </table>";
	      
	      System.out.println(responseString);
	      return responseString + "<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";

	    }
	    catch (Exception e)
	    {

	      e.printStackTrace(); }
	    return "";
	    }

	@Override
	public String GetClaimDetailsForWelfare(String KARNumber) {
		
		
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = "  ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
		
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT [EnrollmentId] "
    +" ,[EDate] "
    +" ,[ApplicantName] "
     +" ,[ClaimAmount] "
     +" ,[Description] "
    		  +" ,[OrderNo] "
      +",[OrderDate] "
    		  +",[DeathDate] "
     +" ,[City] "
    
 +" ,[State] "
 +" ,[Pincode] "
  +" ,[RetirmentDate] "
  +" ,[RetiredReason] "
 		  +" ,[status] "
   +",[PaidStatus] "
 		  +",[ApplicationDate] "
  +" ,[BCMResolutionNo] "
  +" ,[BCMResolutionDate] "    
     
     +" FROM [dbo].[Enrollment_WelfareFundClaims] where EnrollmentId=? ";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber.trim());
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;
			     
			      while(rs.next()){
			         //Retrieve by column name
			    	 
			    	  responseString="<table class='table table-bordered'><thead><tr><th>SL No.</th><th>Enrollment Number</th><th>ClaimType</th><th>Resolution Number</th>"
			    			  +  "<th>Resolution Date</th><th>ClaimAmount</th><th>Description</th></tr>"
			    			  +  " </thead>"
			    			  +  "<tbody>";		   
			    					 String Reason= rs.getString("status");
			    					 String Status="";
			    					if("D".equalsIgnoreCase(Reason))
			    					{
			    						Status="Death";
			    						
			    					}
			    					else if("R".equalsIgnoreCase(Reason))
			    					{
			    						Status="Retirement";
			    						
			    					}
			    					else if("M".equalsIgnoreCase(Reason))
			    					{
			    						Status="Medical";
			    						
			    					}
			    					else if("F".equalsIgnoreCase(Reason))
			    					{
			    						Status="Financial Hardship";
			    						
			    					}
			    						   responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +rs.getString("EnrollmentId")+"</b></td>"
			    								     
			    								    
			    								      +  " <td><b> " +Status+"</b></td>"
			    								    
			    								      +  " <td><b> " +rs.getString("BCMResolutionNo")+"</b></td>"
			    								     
			    								       +  " <td><b> " +rs.getTimestamp("BCMResolutionDate")+"</b></td>"
			    								        +  " <td><b> " +rs.getInt("ClaimAmount")+"</b></td>"
			    								     
			    								        
			    								        
			    								        
			    								         +  " <td><b> " +rs.getString("Description")+"</b></td>"
			    								     
			    								    
			    								    
			    								    
			    								     
			    							  +" </tr>";
			    						   Index++;
			    						     responseString+=	 " </tbody> "+  "</table>"; 
			      }
			    								      
			 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	      
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String ChangeTheNominee(String KARNumber, String NomineeName, String RelationShip,String EnteredBy) {
		
		
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
	    System.out.println(ts1 + "Current Time");
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " INSERT INTO [dbo].[Hst_Enrollment_Nominee] "
          +" ([EnrollmentId] "
         +"  ,[ReceiptTransactionId] "
         +"  ,[ReceiptVoucherID] "
         +"  ,[ReceiptId] "
         +"  ,[Nominee_Title] "
        +"   ,[Nominee_Name] "
        +"  ,[IsMinor] "
       +"    ,[GuardianName] "
        +"   ,[Relationship] "
         +"  ,[Nominee_Address1] "
         +"  ,[Nominee_Address2] "
         +"  ,[Nominee_Address3] "
         +"  ,[Nominee_City] "
        +"   ,[Nominee_State] "
        +"   ,[Nominee_PinCode] "
        +"   ,[EnteredBy] "
        +"   ,[EnteredOn]) "
    +" VALUES "
         +"  (?"
         +"  ,?"
         +"  ,? "
         +"  ,? "
         +"  ,? "
         +"  ,? "
         +"  ,? "
         +"  ,? "
    		   +"  ,? "
    		   +"  ,? "
    		   +"  ,? "
    		   +"  ,? "
    		   +"  ,? "
    		   +"  ,? "
    		   +"  ,? "
    		   +"  ,? "
    		   +"  ,? )";
			      
			      
			      
			    /*  
			         (<EnrollmentId, nvarchar(50),>
           ,<ReceiptTransactionId, int,>
           ,<ReceiptVoucherID, int,>
           ,<ReceiptId, int,>
           ,<Nominee_Title, int,>
           ,<Nominee_Name, nvarchar(200),>
           ,<IsMinor, char(1),>
           ,<GuardianName, nvarchar(200),>
           ,<Relationship, nvarchar(200),>
           ,<Nominee_Address1, nvarchar(200),>
           ,<Nominee_Address2, nvarchar(200),>
           ,<Nominee_Address3, nvarchar(200),>
           ,<Nominee_City, nvarchar(100),>
           ,<Nominee_State, tinyint,>
           ,<Nominee_PinCode, varchar(50),>
           ,<EnteredBy, varchar(15),>
           ,<EnteredOn, datetime,>)
		          */
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber.trim());
		PrepareStateMent.setInt(2, 0);   
		PrepareStateMent.setInt(3, 0); 
		PrepareStateMent.setInt(4, 0); //ReceiptId
		PrepareStateMent.setInt(5, 0); //Nominee_Title
		PrepareStateMent.setString(6, NomineeName); 
		PrepareStateMent.setString(7, "N");
		PrepareStateMent.setString(8,""); //GuardianName
		PrepareStateMent.setString(9,RelationShip);//Relationship
		PrepareStateMent.setString(10,"");//Nominee_Address1
		PrepareStateMent.setString(11,"");
		PrepareStateMent.setString(12,"");
		PrepareStateMent.setString(13,""); //Nominee_City
		Short Nominee_State=0;
		PrepareStateMent.setShort(14, Nominee_State);
		PrepareStateMent.setString(15, "");
		PrepareStateMent.setString(16, EnteredBy);
		
		PrepareStateMent.setTimestamp(17, ts1);
		//EnteredBy
		//Nominee_PinCode 
		//Nominee_State
		  int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			   if (rs>0)
				  
			   {
				   PrepareStateMent.close();
				      conn.close();				
				    
				  return "SuccessFully Inserted"; 
			   }
			   
			   else
			   {
				   PrepareStateMent.close();
				      conn.close();				
				    
				   return "False"; 
			   }
			 	/* resultoutput=Count;
			    	 System.out.println(Count);
			       */ /* int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);*/
			      
			      //STEP 6: Clean-up environment
			      
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String ChangeOfName(String KARNumber, String Name, String EnteredBy) {
		
		
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " NSERT INTO [dbo].[Hst_Enrollment_ChangeName]"
         +"  ([EnrollmentId] "
         +"  ,[ReceiptTransactionId] "
           +"  ,[ReceiptVoucherId] "
           +"  ,[TitleId] "
           +"  ,[Name] "
           +"  ,[DateChanged] "
          +"   ,[EnteredBy]) "
      +" VALUES "
          +"   (? "
          +"   ,? " 
          +"   ,? "
          +"   ,? "
          +"   ,? "
           +"  ,?"
          +"   ,?) ";
			      
			      
			      
			    /*  
			      +"   (<EnrollmentId, nvarchar(50),> "
		          +"   ,<ReceiptTransactionId, int,> " 
		          +"   ,<ReceiptVoucherId, int,> "
		          +"   ,<TitleId, int,> "
		          +"   ,<Name, nvarchar(200),> "
		           +"  ,<DateChanged, datetime,> "
		          +"   ,<EnteredBy, varchar(15),>) "
		           
		          */
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber.trim());
		PrepareStateMent.setInt(2, 0);   
		PrepareStateMent.setInt(3, 0); 
		PrepareStateMent.setInt(4, 0); 
		PrepareStateMent.setString(5, Name); 
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
	    System.out.println(ts1 + "Current Time");
		PrepareStateMent.setTimestamp(6, ts1);
		PrepareStateMent.setString(7, EnteredBy); 
			      int rs = PrepareStateMent.executeUpdate(sql);
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	/* resultoutput=Count;
			    	 System.out.println(Count);
			       */ /* int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);*/
			      
			      //STEP 6: Clean-up environment
			      
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String ChangeOfAddress(String KARNumber,String City,String State,String PinCode, String Address, String EnteredBy) {
		
		
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " INSERT INTO [dbo].[Hst_Enrollment_ChangeAddress] "
          +" ([EnrollmentId]"
          +"  ,[ReceiptTransactionId]"
         +"   ,[VoucherID]"
         +"   ,[Communication_Address1]"
          +"  ,[Communication_Address2]"
          +"  ,[Communication_Address3]"
          +"  ,[Communication_City]"
         +"   ,[Communication_State]"
         +"   ,[Communication_PinCode]"
         +"   ,[DateChanged]"
         +"   ,[enteredby])"
   +"   VALUES"
        +"    (?"
        +"    ,?"
        +"    ,?"
         +"   ,?"
         +"   ,?"
         +"   ,?"
         +"   ,?"
         +"   ,?"
         +"   ,?"
         +"   ,?"
        +"    ,?) ";
			      
			      
			      
			    /*  
			        +"    (<EnrollmentId, int,>"
        +"    ,<ReceiptTransactionId, int,>"
        +"    ,<VoucherID, int,>"
         +"   ,<Communication_Address1, nvarchar(200),>"
         +"   ,<Communication_Address2, nvarchar(200),>"
         +"   ,<Communication_Address3, nvarchar(200),>"
         +"   ,<Communication_City, nvarchar(100),>"
         +"   ,<Communication_State, tinyint,>"
         +"   ,<Communication_PinCode, varchar(50),> "
         +"   ,<DateChanged, datetime,>"
        +"    ,<enteredby, nvarchar(15),>) ";
			      
		          */
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber.trim());
		PrepareStateMent.setInt(2, 0);   
		PrepareStateMent.setInt(3, 0); 
		PrepareStateMent.setString(4, Address); 
		PrepareStateMent.setString(5, ""); 
		PrepareStateMent.setString(6, ""); 
		PrepareStateMent.setString(7, ""); 
		PrepareStateMent.setString(8, ""); 
		PrepareStateMent.setString(9, ""); 
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
	    System.out.println(ts1 + "Current Time");
		PrepareStateMent.setTimestamp(10, ts1);
	//	PrepareStateMent.setString(7, EnteredBy); 
			      int rs = PrepareStateMent.executeUpdate(sql);
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String InsertintoEnrollmentPayment(String KARNumber, int ReceiptTransactionId,
			int WelfareFundInstallmentNo, int FromYear, int ToYear,BigDecimal AmountPaid,Timestamp AmountPaidOn,String ReceiptNo,String ReceiptDate) {
		
		
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");*/
			
			/*try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " INSERT INTO [dbo].[Enrollment_WelfareFundPayments]  "
           +"([EnrollmentId]  "
           +" ,[ReceiptTransactionId]  "
           +" ,[WelfareFundInstallmentNo]  "
           +" ,[FromYear]  "
           +" ,[ToYear]  "
            +",[AmountPaid]  "
           +" ,[AmountPaidOn]  "
        		   +" ,[ReceiptNo]  "
           +" ,[ReceiptDate])  "
      +" VALUES  "
           +" (?  "
           +" ,?  "
           +" ,? "
           +" ,?  "
          +"  ,?  "
          +"  ,?"
          +"  ,? "
			      +" ,?  "
           +" ,?) ";
			      
			      
			      
			    /*  
			          +" (<EnrollmentId, nvarchar(50),>  "
           +" ,<ReceiptTransactionId, int,>  "
           +" ,<WelfareFundInstallmentNo, int,>  "
           +" ,<FromYear, int,>  "
          +"  ,<ToYear, int,>  "
          +"  ,<AmountPaid, numeric(16,2),>  "
          +"  ,<AmountPaidOn, datetime,>  "
			      +" ,<ReceiptNo, varchar(50),>  "
           +" ,<ReceiptDate, varchar(50),> ";
			      
			    
			      (String KARNumber, int ReceiptTransactionId,
			int WelfareFundInstallmentNo, int FromYear, int ToYear,BigDecimal AmountPaid,Timestamp AmountPaidOn,String ReceiptNo,String ReceiptDate) {
		
			      
		          */
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber.trim());
		PrepareStateMent.setInt(2, ReceiptTransactionId);   
		PrepareStateMent.setInt(3, WelfareFundInstallmentNo); 
		PrepareStateMent.setInt(4, FromYear); 
		PrepareStateMent.setInt(5, ToYear); 
		PrepareStateMent.setBigDecimal(6, AmountPaid); 
		PrepareStateMent.setTimestamp(7, AmountPaidOn); 
		PrepareStateMent.setString(8, ReceiptNo); 
		PrepareStateMent.setString(9, ReceiptDate); 
		/*java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
	    System.out.println(ts1 + "Current Time");
		PrepareStateMent.setTimestamp(10, ts1);*/
	//	PrepareStateMent.setString(7, EnteredBy); 
			      int rs = PrepareStateMent.executeUpdate(sql);
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String InsertintoEnrollment(EnrollmentDetails EnrollmentDetails) {
		
		
		
		System.out.println(EnrollmentDetails);
		
	//	System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " INSERT INTO [dbo].[EnrollmentDetails] "
			    		
			    		 
			    		  +"([RollNo] "
			    		        +"   ,[EnrollNo] "
			    		        +"   ,[EnrollmentRegistrationNo] "
			    		         +"  ,[CertificateNo] "
			    		         +"  ,[TitleId] "
			    		        +"   ,[Name] "
			    		        +"   ,[Gender] "
			    		        +"   ,[Father_Title] "
			    		        		   +"   ,[FatherName] "
			    		        +"   ,[DateOfBirth] "
			    		       +"    ,[BloodGroup] "
			    		        +"   ,[CategoryId] "
			    		         +"  ,[Communication_Address1] "
			    		        +"  ,[Communication_Address2] "
			    		        +"   ,[Communication_Address3] "
			    		       +"    ,[Communication_City] "
			    		        +"   ,[Communication_State] "
			    		        +"   ,[Communication_PinCode] "
			    		        +"   ,[Permanent_Address1] "
			    		         +"  ,[Permanent_Address2] "
			    		         +"  ,[Permanent_Address3] "
			    		         +"  ,[Permanent_PinCode] "
			    		        +"   ,[Permanent_City] "
			    		         +"  ,[Permanent_State] "
			    		         +"  ,[Nominee_Title] "
			    		        +"   ,[Nominee_Name] "
			    		        +"   ,[IsMinor] "
			    		        +"   ,[GuardianName] "
			    		        +"   ,[Relationship] "
			    		        +"   ,[Nominee_Address1] "
			    		        		   +"   ,[Nominee_Address2] "
			    		        +"   ,[Nominee_Address3] "
			    		        +"   ,[Nominee_City] "
			    		        +"   ,[Nominee_State] "
			    		        +"   ,[Nominee_PinCode] "
			    		        		   +"   ,[PracticeCategory] "
			    		         +"  ,[EMail] "
			    		         +"  ,[Phone_Res] "
			    		        +"   ,[Phone_Off] "
			    		        +"   ,[MobileNo] "
			    		        +"   ,[Remarks] "
			    		        +"   ,[EnrollmentStatus] " 
			    		        +"   ,[EnrollmentSource] "
			    		        		   +"   ,[WelfareMember] "
			    		         +"  ,[EnrollmentDate] "
			    		       +"    ,[Place_Of_Practice] "
			    		        +"   ,[WelfareMemberUpdatedDate] "
			    		        +"   ,[SeniorMember] "
			    		       +"    ,[SeniorMemberUpdatedDate] "
			    		        		   +"    ,[enr_Year] "
			    		       +"    ,[enr_Month] "
			    		       +"    ,[enr_Days] "
			    		        +"   ,[SeniorAdvocate] "
			    		        +"   ,[SeniorAdvocateUpdatedDate] "
			    		        +"   ,[CertificateStatus] " 
			    		        +"   ,[CertificateIssued] "
			    		        +"   ,[CertificateIssuedOn] "
			    		        +"   ,[ManagerApproved] "
			    		       +"    ,[NomineeVerified] "
			    		        +"   ,[ApplnForm] "
			    		        +"   ,[WelfareLifeTimeMember]) "
      +" VALUES "
         +"   (?"
          +"  ,?"
          +"  ,?"
         +"   ,? "
          +"  ,? "
         +"   ,?"
         +"   ,? "
         +"   ,?"
			      +"   ,? "
       +"     ,?"
        +"    ,? "
        +"    ,? "
        +"    ,? "
         +"   ,? "
         +"   ,? "
         +"   ,? "
        +"    ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? " 
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? "
       +"     ,? )";
		 	      
			      
			      
System.out.println(EnrollmentDetails.getRollNo());
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		//	   PrepareStateMent.setInt(1, 1); 
			   
			   
		PrepareStateMent.setString(1, ""); // rollNumber
		PrepareStateMent.setString(2, EnrollmentDetails.getEnrollNo());
		PrepareStateMent.setString(3, EnrollmentDetails.getEnrollmentRegistrationNo());   
		PrepareStateMent.setString(4, EnrollmentDetails.getCertificateNo()); 
		PrepareStateMent.setInt(5, EnrollmentDetails.getTitleId()); 
		PrepareStateMent.setString(6, EnrollmentDetails.getName()); 
		
		PrepareStateMent.setString(7, EnrollmentDetails.getGender()+"");
		PrepareStateMent.setInt(8,EnrollmentDetails.getFather_Title());
		PrepareStateMent.setString(9, EnrollmentDetails.getFatherName());
		
		
		
		PrepareStateMent.setTimestamp(10, EnrollmentDetails.getDateOfBirth());   
		PrepareStateMent.setString(11, EnrollmentDetails.getBloodGroup()); 
		PrepareStateMent.setShort(12, EnrollmentDetails.getCategoryId()); 
		PrepareStateMent.setString(13, EnrollmentDetails.getCommunication_Address1()); 
		PrepareStateMent.setString(14, EnrollmentDetails.getCommunication_Address2());
		PrepareStateMent.setString(15, EnrollmentDetails.getCommunication_Address3());
		
		PrepareStateMent.setString(16, EnrollmentDetails.getCommunication_City()); 
		PrepareStateMent.setShort(17, EnrollmentDetails.getCommunication_State());
		PrepareStateMent.setString(18, EnrollmentDetails.getCommunication_PinCode());
		
		
		PrepareStateMent.setString(19, EnrollmentDetails.getPermanent_Address1()); 
		PrepareStateMent.setString(20, EnrollmentDetails.getPermanent_Address2());
		PrepareStateMent.setString(21, EnrollmentDetails.getPermanent_Address3());
		
		PrepareStateMent.setString(22, EnrollmentDetails.getPermanent_PinCode());
		
		PrepareStateMent.setString(23, EnrollmentDetails.getPermanent_City());
		
		PrepareStateMent.setShort(24, EnrollmentDetails.getPermanent_State());
		PrepareStateMent.setInt(25,EnrollmentDetails.getNominee_Title());
		PrepareStateMent.setString(26, EnrollmentDetails.getNominee_Name());
		PrepareStateMent.setString(27, EnrollmentDetails.getIsMinor()+"");
		
		PrepareStateMent.setString(28, EnrollmentDetails.getGuardianName()); 
		PrepareStateMent.setString(29, EnrollmentDetails.getRelationship());
		PrepareStateMent.setString(30, EnrollmentDetails.getNominee_Address1());
		
		PrepareStateMent.setString(31, EnrollmentDetails.getNominee_Address2());
		
		PrepareStateMent.setString(32, EnrollmentDetails.getNominee_Address3());
		
		PrepareStateMent.setString(33, EnrollmentDetails.getNominee_City());
		
		
		PrepareStateMent.setShort(34, EnrollmentDetails.getNominee_State());
		
		
		PrepareStateMent.setString(35, EnrollmentDetails.getNominee_PinCode());
		
		
		
		
		
		PrepareStateMent.setShort(36, EnrollmentDetails.getPracticeCategory());
		
		PrepareStateMent.setString(37, EnrollmentDetails.getEMail());
		PrepareStateMent.setString(38, EnrollmentDetails.getPhone_Res());
		
		PrepareStateMent.setString(39, EnrollmentDetails.getPhone_Off());
		
		PrepareStateMent.setString(40, EnrollmentDetails.getMobileNo());
		
		PrepareStateMent.setString(41, EnrollmentDetails.getRemarks());
		
		PrepareStateMent.setString(42, EnrollmentDetails.getEnrollmentStatus()+"");
		
		PrepareStateMent.setString(43, EnrollmentDetails.getEnrollmentSource()+"");
		PrepareStateMent.setString(44, EnrollmentDetails.getWelfareMember()+"");
		PrepareStateMent.setTimestamp(45, EnrollmentDetails.getEnrollmentDate());
		
		PrepareStateMent.setString(46, EnrollmentDetails.getPlace_Of_Practice());
		PrepareStateMent.setTimestamp(47, EnrollmentDetails.getWelfareMemberUpdatedDate());
		PrepareStateMent.setString(48, EnrollmentDetails.getSeniorMember()+"");
		PrepareStateMent.setTimestamp(49, EnrollmentDetails.getSeniorMemberUpdatedDate());
		PrepareStateMent.setBigDecimal(50, EnrollmentDetails.getEnr_Year());
		PrepareStateMent.setBigDecimal(51, EnrollmentDetails.getEnr_Month());
		PrepareStateMent.setBigDecimal(52, EnrollmentDetails.getEnr_Days());
		
		PrepareStateMent.setString(53, EnrollmentDetails.getSeniorAdvocate()+"");
		PrepareStateMent.setTimestamp(54, EnrollmentDetails.getSeniorAdvocateUpdatedDate());
		
		PrepareStateMent.setString(55, EnrollmentDetails.getCertificateStatus()+"");
		PrepareStateMent.setString(56, EnrollmentDetails.getCertificateIssued()+"");
		PrepareStateMent.setTimestamp(57, EnrollmentDetails.getCertificateIssuedOn());
		
		PrepareStateMent.setString(58, EnrollmentDetails.getManagerApproved()+"");
		PrepareStateMent.setString(59, EnrollmentDetails.getNomineeVerified()+"");
		PrepareStateMent.setString(60, EnrollmentDetails.getApplnForm()+"");
		PrepareStateMent.setString(61, EnrollmentDetails.getWelfareLifeTimeMember()+"");
	
	//	PrepareStateMent.setString(61, EnrollmentDetails.getWelfareLifeTimeMember()+"");
	/*	PrepareStateMent.setBigDecimal(6, AmountPaid); 
		PrepareStateMent.setTimestamp(7, AmountPaidOn); 
		PrepareStateMent.setString(8, ReceiptNo); 
		PrepareStateMent.setString(9, ReceiptDate); */
		/*java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
	    System.out.println(ts1 + "Current Time");
		PrepareStateMent.setTimestamp(10, ts1);*/
	//	PrepareStateMent.setString(7, EnteredBy); 
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Akshay Inserted");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String InsertintoSuspended(String EnrollmentID, int ReceiptTransactionId, String SuspendType,
			Timestamp SuspendedOn, String SuspendedRemarks, String EnteredBy, Timestamp DateChanged) {
		
		return null;
	}

	@Override
	public String InsertIntoTransfer(int EnrollmentId, int ReceiptTransactionId, String TransferType,
			Short TransferredToState, Short ReasonForTransfer, String NOCNo, Timestamp TransferredDate,
			Timestamp DateChanged) {
		
		return null;
	}

	@Override
	public String InsertIntoResumption(int EnrollmentId, int ReceiptVoucherId, int ReceiptId, int ReceiptTransactionid,
			Timestamp ResumptionDate, String Reason, String EnteredBy, Timestamp EnteredOn) {
		
		return null;
	}

	@Override
	public EnrollmentDetails GetEnrollmentDetailsForName(String Name, String Place) {
		
		
		EnrollmentDetails EnrollmentDetails = new EnrollmentDetails();
		String responseString = " Data not found  ";
		Connection conn=null;
		try
		{
		 conn = JDBCUtil.GetConnection();
		System.out.println(Name +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
	
		 responseString = "  its not working ";
		
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "SELECT  TOP 1"
 +" [EnrollmentId] "
 +"  ,[RollNo]"
     +"  ,[EnrollNo] "
     +"  ,[EnrollmentRegistrationNo]"
     +"  ,[CertificateNo]"
    +"   ,[TitleId]"
    +"   ,[Name]"
    +"   ,[Gender]"
      +" ,[Father_Title]"
    		  +"  ,[FatherName]"
   +"    ,[DateOfBirth]"
    +"   ,[BloodGroup]"
     +"  ,[CategoryId]"
     +"  ,[Communication_Address1]"
     +"  ,[Communication_Address2]"
     +"  ,[Communication_Address3]"
    +"   ,[Communication_City]"
    +"   ,[Communication_State]"
     +"  ,[Communication_PinCode]"
     +"  ,[Permanent_Address1]"
     +"  ,[Permanent_Address2]"
    		  +"  ,[Permanent_Address3]"
     +"  ,[Permanent_PinCode]"
      +" ,[Permanent_City]"
     +"  ,[Permanent_State]"
     +"  ,[Nominee_Title]"
     +"  ,[Nominee_Name]"
     +"  ,[IsMinor]"
    +"   ,[GuardianName]"
     +"  ,[Relationship]"
    +"   ,[Nominee_Address1]"
      +" ,[Nominee_Address2]"
    +"   ,[Nominee_Address3]"
    +"   ,[Nominee_City]"
     +"  ,[Nominee_State]"
    +"   ,[Nominee_PinCode]"
    +"   ,[PracticeCategory]"
     +"  ,[EMail]"
     +"  ,[Phone_Res]"
    +"   ,[Phone_Off]"
     +"  ,[MobileNo]"
    +"   ,[Remarks]"
    +"   ,[EnrollmentStatus]"
    +"   ,[EnrollmentSource]"
   +"    ,[WelfareMember]"
    +"   ,[EnrollmentDate]"
    +"   ,[Place_Of_Practice]"
    +"   ,[WelfareMemberUpdatedDate]"
    +"   ,[SeniorMember]"
    +"   ,[SeniorMemberUpdatedDate]"
    +"   ,[enr_Year]"
     +"  ,[enr_Month]"
    		  +"  ,[enr_Days]"
      +" ,[SeniorAdvocate]"
      +" ,[SeniorAdvocateUpdatedDate]"
    +"   ,[CertificateStatus]"
     +"  ,[CertificateIssued]"
    		  +"  ,[CertificateIssuedOn]"
     +"  ,[ManagerApproved]"
     +"  ,[NomineeVerified]"
     +"  ,[ApplnForm]"
     +"  ,[WelfareLifeTimeMember]"
  +" FROM [dbo].[EnrollmentDetails] where Name=? and Place_Of_Practice=? ";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, Name.trim());
		PrepareStateMent.setString(2, Place.trim());
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			    /*  SELECT TOP (1000) [EnrollmentId]
			    	      ,[ReceiptTransactionId]
			    	      ,[WelfareFundInstallmentNo]
			    	      ,[FromYear]
			    	      ,[ToYear]
			    	      ,[AmountPaid]
			    	      ,[AmountPaidOn]
			    	      ,[ReceiptNo]
			    	      ,[ReceiptDate]
			    	  FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments]*/
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;System.out.println();
			      responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>EnrollmentId</th><th>FromYear</th>"
		    			  +  "<th>ToYear</th><th>AmountPaid</th><th>AmountPaidOn</th> </tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      while(rs.next()){
			         //Retrieve by column name
			    	 System.out.println(rs.getString("Name")   + "  #####################");
			    	 System.out.println(rs.getString("EnrollmentRegistrationNo"));
			    	 System.out.println(rs.getString("CertificateNo"));
			    	 System.out.println(rs.getString("FatherName"));
			    	 EnrollmentDetails.setRollNo(rs.getString("RollNo"));
			    	 EnrollmentDetails.setName(rs.getString("Name") );
			    	 EnrollmentDetails.setEMail(rs.getString("EMail"));
			    	 EnrollmentDetails.setBloodGroup(rs.getString("bloodGroup"));
			    //	 EnrollmentDetails.setApplnForm(rs.getString("ApplnForm").charAt(0));
			    	 EnrollmentDetails.setCategoryId(rs.getShort("CategoryId"));
			    	 EnrollmentDetails.setCategoryId(rs.getShort("CategoryId"));
			    	 EnrollmentDetails.setCertificateIssuedOn(rs.getTimestamp("CertificateIssuedOn"));
			    	 EnrollmentDetails.setCertificateStatus(rs.getString("CertificateStatus"));
			    	 EnrollmentDetails.setCertificateStatus(rs.getString("CertificateStatus"));
			    	 EnrollmentDetails.setCommunication_Address1(rs.getString("Communication_Address1"));
			    	 EnrollmentDetails.setCommunication_Address2(rs.getString("Communication_Address2"));
			    	 EnrollmentDetails.setCommunication_Address3(rs.getString("communication_Address3"));
			    	// EnrollmentDetails.setCommunication_Address3(communication_Address3);
			    	 EnrollmentDetails.setCommunication_City(rs.getString("Communication_City"));
			    	 EnrollmentDetails.setCommunication_PinCode(rs.getString("Communication_PinCode"));		
			    	 EnrollmentDetails.setCommunication_PinCode(rs.getString("Communication_PinCode"));
			    	 EnrollmentDetails.setCommunication_State(rs.getShort("Communication_State"));
			    	 EnrollmentDetails.setDateOfBirth(rs.getTimestamp("DateOfBirth"));
			    	//  EnrollmentDetails.setEMail(eMail);
			    	 EnrollmentDetails.setEnr_Days(rs.getBigDecimal("enr_Days"));
			    	 EnrollmentDetails.setEnr_Month(rs.getBigDecimal("enr_Month"));
			    	// EnrollmentDetails.setEnr_Month(enr_Month);
			    	 EnrollmentDetails.setEnr_Year(rs.getBigDecimal("enr_Year"));
			    	 EnrollmentDetails.setEnrollmentDate(rs.getTimestamp("EnrollmentDate"));
			    //	 EnrollmentDetails.setEnrollmentDate(enrollmentDate);
			    	 EnrollmentDetails.setEnrollmentRegistrationNo(rs.getString("EnrollmentRegistrationNo"));
			    	// EnrollmentDetails.setEnrollmentSource(rs.getString("EnrollmentSource").charAt(0));
			    	 EnrollmentDetails.setRemarks(rs.getString("Remarks"));
			    	 EnrollmentDetails.setRelationship(rs.getString("Relationship"));
			    	
			    	 
			    	 if ((rs.getString("WelfareMember")==null) || (rs.getString("WelfareMember")==""))
				    	{
			    		 EnrollmentDetails.setWelfareMember('N');
				    	}
				    	else
				    	{
				    		 EnrollmentDetails.setWelfareMember(rs.getString("WelfareMember").charAt(0));
				    	}
			    	 
			    	 
			    	 if ((rs.getString("EnrollmentSource")==null) || (rs.getString("EnrollmentSource")==""))
				    	{
			    		 EnrollmentDetails.setEnrollmentSource('N');
				    	}
				    	else
				    	{
				    		 EnrollmentDetails.setEnrollmentSource(rs.getString("EnrollmentSource").charAt(0));
				    	}
			    	// EnrollmentDetails.setEnrollmentSource(enrollmentSource);
			    //	 EnrollmentDetails.setEnrollmentStatus(rs.getString("EnrollmentStatus").charAt(0));
			    	 
			    	 
			    	 if ((rs.getString("EnrollmentStatus")==null) || (rs.getString("EnrollmentStatus")==""))
				    	{
			    		 EnrollmentDetails.setEnrollmentStatus('N');
				    	}
				    	else
				    	{
				    		 EnrollmentDetails.setEnrollmentStatus(rs.getString("EnrollmentStatus").charAt(0));
				    	}
			    	 
			    	 
			    	 EnrollmentDetails.setEnrollNo(rs.getString("EnrollNo"));
			    	 EnrollmentDetails.setFather_Title(rs.getInt("Father_Title"));
			    	 EnrollmentDetails.setFatherName(rs.getString("FatherName"));
			    //	 EnrollmentDetails.setGender(rs.getString("Gender").charAt(0));
			    	 
			    	 if ((rs.getString("Gender")==null) || (rs.getString("Gender")==""))
				    	{
				    		EnrollmentDetails.setGender('M');
				    	}
				    	else
				    	{
				    		EnrollmentDetails.setGender(rs.getString("Gender").charAt(0));
				    	}
			    	 
			    	 
			    	 EnrollmentDetails.setGuardianName(rs.getString("GuardianName"));
			    	 
			    	if ((rs.getString("IsMinor")==null) || (rs.getString("ManagerApproved")==""))
			    	{
			    		EnrollmentDetails.setManagerApproved('N');
			    	}
			    	else
			    	{
			    		EnrollmentDetails.setManagerApproved(rs.getString("IsMinor").charAt(0));
			    	}
			    	//  EnrollmentDetails.setIsMinor(rs.getString("IsMinor").charAt(0));
			    	// EnrollmentDetails.setManagerApproved(rs.getString("ManagerApproved").charAt(0));
			    	 EnrollmentDetails.setMobileNo(rs.getString("MobileNo"));
			    	 EnrollmentDetails.setName(rs.getString("Name"));
			    	 EnrollmentDetails.setNominee_Address1(rs.getString("Nominee_Address1"));
			    	 EnrollmentDetails.setNominee_Address2(rs.getString("Nominee_Address2"));
			    	 EnrollmentDetails.setNominee_Address3(rs.getString("nominee_Address3"));
			    	 EnrollmentDetails.setNominee_City(rs.getString("Nominee_City"));
			    	 EnrollmentDetails.setNominee_Name(rs.getString("Nominee_Name"));
			    	 EnrollmentDetails.setNominee_PinCode(rs.getString("Nominee_PinCode"));
			    	// EnrollmentDetails.setNominee_Name(nominee_Name);
			    	 EnrollmentDetails.setNominee_State(rs.getShort("Nominee_State"));
			    	 EnrollmentDetails.setNominee_Title(rs.getInt("Nominee_Title"));
			   // 	 EnrollmentDetails.setNomineeVerified(rs.getString("NomineeVerified").charAt(0));
			    	 //WelfareMemberUpdatedDate
			    	 EnrollmentDetails.setWelfareMemberUpdatedDate(rs.getTimestamp("WelfareMemberUpdatedDate"));
			    	 EnrollmentDetails.setPlace_Of_Practice(rs.getString("Place_Of_Practice"));
			    	 if ((rs.getString("NomineeVerified")==null) || (rs.getString("NomineeVerified")==""))
				    	{
				    		EnrollmentDetails.setNomineeVerified('N');
				    	}
				    	else
				    	{
				    		EnrollmentDetails.setNomineeVerified(rs.getString("NomineeVerified").charAt(0));
				    	}
			    	 
			    	 
			    //	 EnrollmentDetails.setWelfareLifeTimeMember(welfareLifeTimeMember);
			    	 if ((rs.getString("WelfareLifeTimeMember")==null) || (rs.getString("WelfareLifeTimeMember")=="N"))
				    	{
				    		EnrollmentDetails.setWelfareLifeTimeMember('N');
				    	}
				    	else
				    	{
				    		EnrollmentDetails.setWelfareLifeTimeMember(rs.getString("WelfareLifeTimeMember").charAt(0));
				    	}
			    	 
			    	 
			    	 System.out.println(rs.getString("Communication_Address1"));
			    	 System.out.println(rs.getString("Communication_Address2")); 
			    	 System.out.println(rs.getString("Communication_PinCode"));
			    	 System.out.println(rs.getString("Communication_City"));
			    	 
			    	 System.out.println(rs.getString("Permanent_Address1"));
			    	 System.out.println(rs.getString("Permanent_Address2"));
			    	 System.out.println(rs.getString("Permanent_Address3"));
			    	 System.out.println(rs.getString("Permanent_PinCode"));
			    	 System.out.println(rs.getString("Nominee_Name"));
			    	 System.out.println(rs.getString("GuardianName"));
			    	 System.out.println(rs.getString("Relationship"));
			    	 System.out.println(rs.getString("Nominee_Address1"));
			    	 System.out.println(rs.getString("Nominee_Address2"));   //Nominee_Address3
			    	 
			    	 
			    	 System.out.println((rs.getString("Gender")));
			    	 System.out.println((rs.getString("IsMinor")));
			    	 System.out.println((rs.getString("EnrollmentStatus")));
			    	 System.out.println((rs.getString("EnrollmentSource")));
			    	 System.out.println((rs.getString("WelfareMember")));
			    	 System.out.println((rs.getString("SeniorMember")));
			    	 
			    	 
			    	 
			    	 System.out.println((rs.getString("ManagerApproved")));
			    	 System.out.println((rs.getString("NomineeVerified")));
			    	 System.out.println((rs.getString("ApplnForm")));
			    	 System.out.println((rs.getString("WelfareLifeTimeMember")));
			    	
			    	 
			    	 // int 
			    	 
			    	 System.out.println(rs.getInt("TitleId"));
			    	 System.out.println(rs.getInt("Father_Title"));
			    	 System.out.println(rs.getInt("Nominee_Title"));
			    	 System.out.println(rs.getShort("PracticeCategory"));
			    	 System.out.println(rs.getShort("Nominee_State"));
			    	 System.out.println(rs.getShort("Permanent_State"));
			    	 System.out.println(rs.getShort("Communication_State"));
			    	 System.out.println(rs.getShort("CategoryId"));
			    	
			    	 //time stamp
			    	 
			    	 System.out.println(rs.getTimestamp("DateOfBirth"));
			    	 System.out.println(rs.getTimestamp("EnrollmentDate"));
			    	 System.out.println(rs.getTimestamp("WelfareMemberUpdatedDate"));
			    	 System.out.println(rs.getTimestamp("SeniorMemberUpdatedDate"));
			    	 System.out.println(rs.getTimestamp("SeniorAdvocateUpdatedDate"));
			    	 
			    	 System.out.println(rs.getTimestamp("CertificateIssuedOn"));
			    	 
			    	 
			    	 
			    	 // BigDecimal
			    	 
			    	 System.out.println(rs.getBigDecimal("enr_Year"));
			    	 System.out.println(rs.getBigDecimal("enr_Month"));
			    	 System.out.println(rs.getBigDecimal("enr_Days"));
			    	
			    	 
			    	 System.out.println(rs.getString("Nominee_City"));
			    	 System.out.println(rs.getString("Nominee_PinCode"));
			   
			    	 System.out.println(rs.getString("Phone_Res"));
			    	 System.out.println(rs.getString("Phone_Off"));
			    	 System.out.println(rs.getString("MobileNo"));
			    	 System.out.println(rs.getString("Place_Of_Practice"));
			    	 System.out.println(rs.getString("CertificateStatus"));
			    	 System.out.println(rs.getString("Nominee_Address2"));
			    	 
			    	 
			    	 responseString+=rs.getString("EnrollNo");
			    	 EnrollmentDetails.setName(rs.getString("Name") );      
			    	 
			    	 EnrollmentDetails.setPermanent_City(rs.getString("Permanent_City"));
			    	 
			    	 
			    				/*EnrollmentDetails.setName(rs.getString("EnrollNo"));
			    				EnrollmentDetails.setEnrollNo(rs.getString("Name"));
			    					  if (Index==1)
			    					  {
			    						  responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +rs.getString("EnrollmentId")+"</b></td>"
			    								     
			    								    
			    								      +  " <td><b> " +rs.getInt("FromYear")+"</b></td>"
			    								      +  " <td><b> " +rs.getInt("ToYear")+"</b></td>"
			    								      +  " <td><b> " +rs.getBigDecimal("AmountPaid")+"</b></td>"
			    								     
			    								      
			    								        +  " <td><b> " +rs.getTimestamp("AmountPaidOn")+"</b></td>"
			    								     
			    						   +" </tr>";	  
			    					  }
			    						   
			    						   Index++;
			    					*/	   
			    						   
			      }
			   System.out.println("!!!!!!!!!@#$#########################"); 								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	/* resultoutput=Count;
			    	 System.out.println(Count);
			       */ /* int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);*/
			      
			      //STEP 6: Clean-up environment
			      
			} // connection == null

		} catch (SQLException ex) {
			responseString=ex.toString();
			
			System.out.println("Error");
			ex.printStackTrace();
		} finally {
			try {
				
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Error finally ");
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return EnrollmentDetails;
	
	
	//	return "String ";
	

		
	//	String responseString;
		//return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String GetEnrollmentDetailsByName(String Name,String Place) {
		
		
		
		
		System.out.println(Name +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				String WildCartName=Name+"%";
				
				System.out.println(WildCartName);
				 String sql;
				 PreparedStatement PrepareStateMent = null;
				if(!Place.equalsIgnoreCase("ALL"))
				{
					
					System.out.println("inside All");
					sql = "SELECT  "
				    		  +" [EnrollmentId] "
				    		  +"  ,[RollNo]"
				    		      +"  ,[EnrollNo] "
				    		      +"  ,[EnrollmentRegistrationNo]"
				    		      +"  ,[CertificateNo]"
				    		     +"   ,[TitleId]"
				    		     +"   ,[Name]"
				    		     +"   ,[Gender]"
				    		       +" ,[Father_Title]"
				    		     		  +"  ,[FatherName]"
				    		    +"    ,[DateOfBirth]"
				    		     +"   ,[BloodGroup]"
				    		      +"  ,[CategoryId]"
				    		      +"  ,[Communication_Address1]"
				    		      +"  ,[Communication_Address2]"
				    		      +"  ,[Communication_Address3]"
				    		     +"   ,[Communication_City]"
				    		     +"   ,[Communication_State]"
				    		      +"  ,[Communication_PinCode]"
				    		      +"  ,[Permanent_Address1]"
				    		      +"  ,[Permanent_Address2]"
				    		     		  +"  ,[Permanent_Address3]"
				    		      +"  ,[Permanent_PinCode]"
				    		       +" ,[Permanent_City]"
				    		      +"  ,[Permanent_State]"
				    		      +"  ,[Nominee_Title]"
				    		      +"  ,[Nominee_Name]"
				    		      +"  ,[IsMinor]"
				    		     +"   ,[GuardianName]"
				    		      +"  ,[Relationship]"
				    		     +"   ,[Nominee_Address1]"
				    		       +" ,[Nominee_Address2]"
				    		     +"   ,[Nominee_Address3]"
				    		     +"   ,[Nominee_City]"
				    		      +"  ,[Nominee_State]"
				    		     +"   ,[Nominee_PinCode]"
				    		     +"   ,[PracticeCategory]"
				    		      +"  ,[EMail]"
				    		      +"  ,[Phone_Res]"
				    		     +"   ,[Phone_Off]"
				    		      +"  ,[MobileNo]"
				    		     +"   ,[Remarks]"
				    		     +"   ,[EnrollmentStatus]"
				    		     +"   ,[EnrollmentSource]"
				    		    +"    ,[WelfareMember]"
				    		     +"   ,[EnrollmentDate]"
				    		     +"   ,[Place_Of_Practice]"
				    		     +"   ,[WelfareMemberUpdatedDate]"
				    		     +"   ,[SeniorMember]"
				    		     +"   ,[SeniorMemberUpdatedDate]"
				    		     +"   ,[enr_Year]"
				    		      +"  ,[enr_Month]"
				    		     		  +"  ,[enr_Days]"
				    		       +" ,[SeniorAdvocate]"
				    		       +" ,[SeniorAdvocateUpdatedDate]"
				    		     +"   ,[CertificateStatus]"
				    		      +"  ,[CertificateIssued]"
				    		     		  +"  ,[CertificateIssuedOn]"
				    		      +"  ,[ManagerApproved]" 
				    		      +"  ,[NomineeVerified]"
				    		      +"  ,[ApplnForm]"
				    		      +"  ,[WelfareLifeTimeMember]"
				    		   +" FROM [dbo].[EnrollmentDetails] where (Name like ? ) and (Place_Of_Practice like ?) ORDER BY TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc  ";
					 PrepareStateMent = conn.prepareStatement(sql); //  ORDER BY RollNo
					PrepareStateMent.setString(1, WildCartName.trim());
					PrepareStateMent.setString(2, Place.trim());
				}
				else
				{
					
					System.out.println("inside Else");
					sql = "SELECT  "
				    		  +" [EnrollmentId] "
				    		  +"  ,[RollNo]"
				    		      +"  ,[EnrollNo] "
				    		      +"  ,[EnrollmentRegistrationNo]"
				    		      +"  ,[CertificateNo]"
				    		     +"   ,[TitleId]"
				    		     +"   ,[Name]"
				    		     +"   ,[Gender]"
				    		       +" ,[Father_Title]"
				    		     		  +"  ,[FatherName]"
				    		    +"    ,[DateOfBirth]"
				    		     +"   ,[BloodGroup]"
				    		      +"  ,[CategoryId]"
				    		      +"  ,[Communication_Address1]"
				    		      +"  ,[Communication_Address2]"
				    		      +"  ,[Communication_Address3]"
				    		     +"   ,[Communication_City]"
				    		     +"   ,[Communication_State]"
				    		      +"  ,[Communication_PinCode]"
				    		      +"  ,[Permanent_Address1]"
				    		      +"  ,[Permanent_Address2]"
				    		     		  +"  ,[Permanent_Address3]"
				    		      +"  ,[Permanent_PinCode]"
				    		       +" ,[Permanent_City]"
				    		      +"  ,[Permanent_State]"
				    		      +"  ,[Nominee_Title]"
				    		      +"  ,[Nominee_Name]"
				    		      +"  ,[IsMinor]"
				    		     +"   ,[GuardianName]"
				    		      +"  ,[Relationship]"
				    		     +"   ,[Nominee_Address1]"
				    		       +" ,[Nominee_Address2]"
				    		     +"   ,[Nominee_Address3]"
				    		     +"   ,[Nominee_City]"
				    		      +"  ,[Nominee_State]"
				    		     +"   ,[Nominee_PinCode]"
				    		     +"   ,[PracticeCategory]"
				    		      +"  ,[EMail]"
				    		      +"  ,[Phone_Res]"
				    		     +"   ,[Phone_Off]"
				    		      +"  ,[MobileNo]"
				    		     +"   ,[Remarks]"
				    		     +"   ,[EnrollmentStatus]"
				    		     +"   ,[EnrollmentSource]"
				    		    +"    ,[WelfareMember]"
				    		     +"   ,[EnrollmentDate]"
				    		     +"   ,[Place_Of_Practice]"
				    		     +"   ,[WelfareMemberUpdatedDate]"
				    		     +"   ,[SeniorMember]"
				    		     +"   ,[SeniorMemberUpdatedDate]"
				    		     +"   ,[enr_Year]"
				    		      +"  ,[enr_Month]"
				    		     		  +"  ,[enr_Days]"
				    		       +" ,[SeniorAdvocate]"
				    		       +" ,[SeniorAdvocateUpdatedDate]"
				    		     +"   ,[CertificateStatus]"
				    		      +"  ,[CertificateIssued]"
				    		     		  +"  ,[CertificateIssuedOn]"
				    		      +"  ,[ManagerApproved]" 
				    		      +"  ,[NomineeVerified]"
				    		      +"  ,[ApplnForm]"
				    		      +"  ,[WelfareLifeTimeMember]"
				    		   +" FROM [dbo].[EnrollmentDetails] where (Name like ? )  ORDER BY TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc  ";
					 PrepareStateMent = conn.prepareStatement(sql); //  ORDER BY RollNo
					PrepareStateMent.setString(1, WildCartName.trim());
			
				}
			     
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			       	   
			      ResultSet rs = PrepareStateMent.executeQuery();
			    /*  SELECT TOP (1000) [EnrollmentId]
			    	      ,[ReceiptTransactionId]
			    	      ,[WelfareFundInstallmentNo]
			    	      ,[FromYear]
			    	      ,[ToYear]
			    	      ,[AmountPaid]
			    	      ,[AmountPaidOn]
			    	      ,[ReceiptNo]
			    	      ,[ReceiptDate]
			    	  FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments]*/
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;
			      responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>EnrollmentId</th><th>Name</th>"
		    			  +  "   <th>Place Of Practice</th> </tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      while(rs.next()){
			         //Retrieve by column name
			    	 
			    					   
			    	
			    						   responseString +=  " <tr>"
			    								 
			    								   
			    								   +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +rs.getString("RollNo")+"</b></td>"
			    								     
			    								        +  " <td><b> " +rs.getString("Name")+"</b></td>" 
			    								     
			    								      
			    								        +  " <td><b> " +rs.getString("Place_Of_Practice")+"</b></td>"
			    								     
			    						   +" </tr>";
			    						   Index++;
			      }
			    								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	/* resultoutput=Count;
			    	 System.out.println(Count);
			       */ /* int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);*/
			      
			      //STEP 6: Clean-up environment
			      
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String GetPayBalenceForKARNumber(String KARNumber) {
		
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		 String ResultString="<h1>Due Payments</h1>";
		
		  ResultString+="<table class='table table-bordered'><thead><tr><th>EnrollmentId</th><th>Due Year</th>"
   			  +  "<th>How Much</th></tr>"
   			  +  " </thead>"
   			  +  "<tbody>";
	EnrollmentDetails ed = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
	System.out.println(ed.getWelfareLifeTimeMember());
	System.out.println(ed.getWelfareMember());
	int FromYear = 0;
	Timestamp EnrollmentDate = ed.getEnrollmentDate();
	Timestamp Welfare = ed.getWelfareMemberUpdatedDate();
	java.util.Date date = new java.util.Date();
	Timestamp CurrentTimeStamp = new Timestamp(date.getTime());
	   //System.out.println(diff);
/*//	   LocalDate dt=LocalDate().now();
*/	 System.out.println(LocalDate.now().getYear()  + "  Year");
	System.out.println(CurrentTimeStamp.getYear() + "  CurrentYear");

    System.out.println(EnrollmentDate.getYear() +"   EnrollmentDate");
   LocalDate EnDate = EnrollmentDate.toLocalDateTime().toLocalDate();
   LocalDate WelfareDate= LocalDate.now(); 
   try
   {
	    WelfareDate = Welfare.toLocalDateTime().toLocalDate();
	      
   }
   catch(Exception e)
   {
	   e.printStackTrace();
	    WelfareDate=   LocalDate.now(); 
   }
   System.out.println("Check the below ");
   System.out.println("****************************************");
   // changed 
   System.out.println(EnDate.getYear() +  "  Enrollment Date ");
    int diff2=(int) (LocalDate.now().getYear()-EnDate.getYear() );
    int diff3=(int) (LocalDate.now().getYear()-WelfareDate.getYear() );
    if((diff2>0) &&(diff3>0))
    {
	if (ed.getWelfareMember()=='Y')
	{
		if(ed.getWelfareLifeTimeMember()=='N')
		{
			
		    System.out.println(CurrentTimeStamp.getYear() + " Current date");
		    System.out.println(diff2 + "  Diffenerce");
		   int TotalAmount=0; 
		   int TotalAmount2=0;
		   
		   if (diff2<15)
		   {
			   TotalAmount=500;
		   }
		   else if (diff2==15)
		   {
			   TotalAmount=1000;
			   TotalAmount2=500;
		   }
		   else 
		   {
			   TotalAmount=1000;
		   }
		  /*  switch(diff2)
			   {
			   case 15: TotalAmount=1000;
			   break;
			  default: 
				  TotalAmount=500;
				   break;
			   }*/
			
		    Calendar now = Calendar.getInstance();
		    // 
		    System.out.println("Current Year is : " + now.get(Calendar.YEAR));
		    // month start from 0 to 11
		    System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
		    
		    int Month=(now.get(Calendar.MONTH) + 1);
		    int Fine_amount=0;
		   switch(Month)
		   {
		   case 1: Fine_amount=50;
		   break;
		   case 2: Fine_amount=100;
		   break;
		   case 3: Fine_amount=150;
		   break;
		   case 4: Fine_amount=200;
		   break;
		   case 5: Fine_amount=250;
		   break;
		   case 6: Fine_amount=300;
		   break;
		   
		   }

			
			
			
			String responseString = " Data not found  ";
			Connection conn=null;
			try
			{
			 conn = JDBCUtil.GetConnection();
			System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
			String OutputResult="not working";
			int resultoutput=0;

			 responseString = "  its not working ";
			
				if (conn != null) {
					DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				//	 java.sql.Statement stmt = conn.createStatement();
					
				      String sql;
				      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
				      sql = " SELECT TOP 1 [EnrollmentId] "
		+" ,[ReceiptTransactionId] "
		+" ,[WelfareFundInstallmentNo] "
		+" ,[FromYear] "
		+" ,[ToYear] "
				  +" ,[AmountPaid] "
		 +",[AmountPaidOn] "
				  +",[ReceiptNo] "
		+" ,[ReceiptDate] "
		+" FROM [dbo].[Enrollment_WelfareFundPayments] where EnrollmentId=? ORDER BY ToYear desc ";
				   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
			PrepareStateMent.setString(1, KARNumber.trim());
				   
				      ResultSet rs = PrepareStateMent.executeQuery();
				    /*  SELECT TOP (1000) [EnrollmentId]
				    	      ,[ReceiptTransactionId]
				    	      ,[WelfareFundInstallmentNo]
				    	      ,[FromYear]
				    	      ,[ToYear]
				    	      ,[AmountPaid]
				    	      ,[AmountPaidOn]
				    	      ,[ReceiptNo]
				    	      ,[ReceiptDate]
				    	  FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments]*/
				      //STEP 5: Extract data from result set
				//      String responseString = "Not coming SOrry";
				      int Index=1;
				      responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>EnrollmentId</th><th>FromYear</th>"
			    			  +  "<th>ToYear</th><th>AmountPaid</th><th>AmountPaidOn</th> </tr>"
			    			  +  " </thead>"
			    			  +  "<tbody>";
				      
				      Timestamp AmountPaidOn;
				      
				      while(rs.next()){
				         //Retrieve by column name
				    	 
				    					   
				    					  if (Index==1)
				    					  {
				    						  AmountPaidOn= rs.getTimestamp("AmountPaidOn");
				    						  
				    						  System.out.println(AmountPaidOn + " AmountPaidOn");
				    						  FromYear=  rs.getInt("FromYear");
				    						  
				    						  System.out.println(FromYear + " FromYear");
				    						   
				    					  }
				    						   
				    						   Index++;
				    						   
				    						   
				      }
				    								      
				      responseString+=	 " </tbody> "+  "</table>"; 					  
				      rs.close();
				      PrepareStateMent.close();
				      conn.close();				
				    	/* resultoutput=Count;
				    	 System.out.println(Count);
				       */ /* int id  = rs.getInt("id");
				         int age = rs.getInt("age");
				         String first = rs.getString("first");
				         String last = rs.getString("last");

				         //Display values
				         System.out.print("ID: " + id);
				         System.out.print(", Age: " + age);
				         System.out.print(", First: " + first);
				         System.out.println(", Last: " + last);*/
				      
				      //STEP 6: Clean-up environment
				      
				}

			} catch (SQLException ex) {
				responseString=ex.toString();
				ex.printStackTrace();
			} finally {
				try {
					
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
//			String responseString;
			

			Timestamp LastPaidTimeStamp = new Timestamp(date.getTime());
			 //  Timestamp CurrentTimeStamp2 = new Timestamp(date.getTime());
			   System.out.println(CurrentTimeStamp.getYear() + "CurrentTimeStamp.getYear()");
			   int NumberOfYearNotPayed=(int) (now.get(Calendar.YEAR)-FromYear);
			   System.out.println(NumberOfYearNotPayed +"  NumberOfYearNotPayed");
			  
//			return "String ";
		if (NumberOfYearNotPayed==0)
		{
			System.out.println("You already payed dont need to pay again");
			ResultString=("You already payed dont need to pay again");
		}
		else if (NumberOfYearNotPayed==1)
		{
			System.out.println("Last year you didnt payed Please pay without fine ");
			
			System.out.println("Amount:" +TotalAmount);
//			ResultString=("Last year you didnt payed Please pay without fine ");
			ResultString +=  " <tr>"
					 
					   
					    								   +  "  <th scope='row'>"+KARNumber+"</th>"
					    								    +  " <td><b> " +now.get(Calendar.YEAR)+"</b></td>"
					    								    +  " <td><b><b> " +TotalAmount+"</b></b></td></tr>";

		}
		else if (NumberOfYearNotPayed>=2)
		{
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int PriviousYear=year-1;
			System.out.println("Last year you didnt payed pay with fine");
			int TotalFineAmount=TotalAmount+Fine_amount;
			int TotalFineAmount2=TotalAmount2+Fine_amount;
			System.out.println("Amount:" +TotalFineAmount);
//			ResultString=("Last year you didnt payed pay with fine ");
			//ResultString+=("Amount:" +TotalFineAmount);
			
			if (Month<=6)
			{
				
				if(diff2==15)
				{
					ResultString +=  " <tr>"
							 
							   
					    								   +  " <td><b> "+KARNumber+"</b></td>"
					    								    +  " <td><b> " +now.get(Calendar.YEAR)+"</b></td>"
					    								    +  " <td><b><b> " +TotalAmount+"</b></b></td></tr>";
			
			ResultString +=  " <tr>"
					 
					   
		 +  " <td><b> " +KARNumber+"</b></td>"
					    								    +  " <td><b> " +PriviousYear+"</b></td>"
					    								    +  " <td><b> <b>" +TotalFineAmount2+"</	b></b></td></tr>";
	
				}
				else
				{
					
					if((diff2>1)  && (diff3>1))
					{
					ResultString +=  " <tr>"
							 
							   
					    								   +  " <td><b> "+KARNumber+"</b></td>"
					    								    +  " <td><b> " +now.get(Calendar.YEAR)+"</b></td>"
					    								    +  " <td><b><b> " +TotalAmount+"</b></b></td></tr>";
			
			ResultString +=  " <tr>"
					 
					   
		 +  " <td><b> " +KARNumber+"</b></td>"
					    								    +  " <td><b> " +PriviousYear+"</b></td>"
					    								    +  " <td><b> <b>" +TotalFineAmount+"</	b></b></td></tr>";
					}
					else
					{
						ResultString +=  " <tr>"
								 
								   
					    								   +  " <td><b> "+KARNumber+"</b></td>"
					    								    +  " <td><b> " +now.get(Calendar.YEAR)+"</b></td>"
					    								    +  " <td><b><b> " +TotalAmount+"</b></b></td></tr>";
			
			
					}
				}
				
			}
			else
			{
				ResultString +=  " <tr>"
						 
						   
					    								   +  "  <th scope='row'>"+KARNumber+"</th>"
					    								    +  " <td><b> " +now.get(Calendar.YEAR)+"</b></td>"
					    								    +  " <td><b> " +TotalAmount+"</b></td></tr>";
			

			}
			ResultString+=	 " </tbody> "+  "</table>"; 
		} 
		} // welfare member 
		
		else
		{
			ResultString ="<h1>Your a Life Time Member </h1> ";
		}
		
	}
	else
	{
		ResultString ="<h1>Not a Welfare Member</h1>";
	} // If for the same year
		
	}
	else
	{
		ResultString ="<h1>No Due</h1>";
	}

		return ResultString+"";
	}

	@Override
	public String GetPayBalenceForKARNumberForDisplay(String KARNumber) {
		
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		 String ResultString="<table class='table table-bordered'><thead><tr><th>EnrollmentId</th><th>For The Year</th>"
   			  +  "<th>How Much</th></tr>"
   			  +  " </thead>"
   			  +  "<tbody>";
	EnrollmentDetails ed = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
	if (ed.getWelfareMember()=='Y')
	{
		if(ed.getWelfareLifeTimeMember()=='N')
		{
			System.out.println(ed.getWelfareLifeTimeMember());
			System.out.println(ed.getWelfareMember());
			int FromYear = 0;
			Timestamp EnrollmentDate = ed.getEnrollmentDate();
			java.util.Date date = new java.util.Date();
			Timestamp CurrentTimeStamp = new Timestamp(date.getTime());
			   //System.out.println(diff);
		/*//	   LocalDate dt=LocalDate().now();
		*/	 System.out.println(LocalDate.now().getYear()  + "  Year");
			System.out.println(CurrentTimeStamp.getYear() + "  CurrentYear");

		    System.out.println(EnrollmentDate.getYear() +"   EnrollmentDate");
		   LocalDate EnDate = EnrollmentDate.toLocalDateTime().toLocalDate();
		   System.out.println("Check the below ");
		   System.out.println("****************************************");
		   // changed 
		   System.out.println(EnDate.getYear() +  "  Enrollment Date ");
		    int diff2=(int) (LocalDate.now().getYear()-EnDate.getYear() );
		    System.out.println(CurrentTimeStamp.getYear() + " Current date");
		    System.out.println(diff2 + "  Diffenerce");
		    int TotalAmount=0; 
			   int TotalAmount2=0;
			   
			   if (diff2<15)
			   {
				  // TotalAmount=500; // older values
				   TotalAmount=1000; 
			   }
			   else if (diff2==15)
			   {
				  /* TotalAmount=1000;
				   TotalAmount2=500; older value*/
				   
				   TotalAmount=2000;
				   TotalAmount2=1000;
			   }
			   else
			   {
				   TotalAmount=2000;
			   }
		  /*  switch(diff2)
			   {
			   case 15: // TotalAmount=1000; //older
			    TotalAmount=2000; 
			   break;
			  default: 
				  TotalAmount=1000;
				   break;
			   }*/
			
		    Calendar now = Calendar.getInstance();
		    // 
		    System.out.println("Current Year is : " + now.get(Calendar.YEAR));
		    // month start from 0 to 11
		    System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
		    
		    int Month=(now.get(Calendar.MONTH) + 1);
		    int Fine_amount=0;
		   switch(Month)
		   {
		   case 1: Fine_amount=100;
		   break;
		   case 2: Fine_amount=200; // changed for jan
		   break;
		   case 3: Fine_amount=300; //changed for feb
		   break;
		   case 4: Fine_amount=400;
		   break;
		   case 5: Fine_amount=500;
		   break;
		   case 6: Fine_amount=600;
		   break;
		   
		   }

			
			
			
			String responseString = " Data not found  ";
			Connection conn=null;
			try
			{
			 conn = JDBCUtil.GetConnection();
			System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
			String OutputResult="not working";
			int resultoutput=0;

			 responseString = "  its not working ";
			
				if (conn != null) {
					DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				
				//	 java.sql.Statement stmt = conn.createStatement();
					
				      String sql;
				      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
				      sql = " SELECT TOP 1 [EnrollmentId] "
		+" ,[ReceiptTransactionId] "
		+" ,[WelfareFundInstallmentNo] "
		+" ,[FromYear] "
		+" ,[ToYear] "
				  +" ,[AmountPaid] "
		 +",[AmountPaidOn] "
				  +",[ReceiptNo] "
		+" ,[ReceiptDate] "
		+" FROM [dbo].[Enrollment_WelfareFundPayments] where EnrollmentId=? ORDER BY ToYear desc ";
				   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
			PrepareStateMent.setString(1, KARNumber.trim());
				   
				      ResultSet rs = PrepareStateMent.executeQuery();
				    /*  SELECT TOP (1000) [EnrollmentId]
				    	      ,[ReceiptTransactionId]
				    	      ,[WelfareFundInstallmentNo]
				    	      ,[FromYear]
				    	      ,[ToYear]
				    	      ,[AmountPaid]
				    	      ,[AmountPaidOn]
				    	      ,[ReceiptNo]
				    	      ,[ReceiptDate]
				    	  FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments]*/
				      //STEP 5: Extract data from result set
				//      String responseString = "Not coming SOrry";
				      int Index=1;
				      responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>EnrollmentId</th><th>FromYear</th>"
			    			  +  "<th>ToYear</th><th>AmountPaid</th><th>AmountPaidOn</th> </tr>"
			    			  +  " </thead>"
			    			  +  "<tbody>";
				      
				      Timestamp AmountPaidOn;
				      
				      while(rs.next()){
				         //Retrieve by column name
				    	 
				    					   
				    					  if (Index==1)
				    					  {
				    						  AmountPaidOn= rs.getTimestamp("AmountPaidOn");
				    						  
				    						  System.out.println(AmountPaidOn + " AmountPaidOn");
				    						  FromYear=  rs.getInt("FromYear");
				    						  
				    						  System.out.println(FromYear + " FromYear");
				    						   
				    					  }
				    						   
				    						   Index++;
				    						   
				    						   
				      }
				    								      
				      responseString+=	 " </tbody> "+  "</table>"; 					  
				      rs.close();
				      PrepareStateMent.close();
				      conn.close();				
				    	/* resultoutput=Count;
				    	 System.out.println(Count);
				       */ /* int id  = rs.getInt("id");
				         int age = rs.getInt("age");
				         String first = rs.getString("first");
				         String last = rs.getString("last");

				         //Display values
				         System.out.print("ID: " + id);
				         System.out.print(", Age: " + age);
				         System.out.print(", First: " + first);
				         System.out.println(", Last: " + last);*/
				      
				      //STEP 6: Clean-up environment
				      
				}

			} catch (SQLException ex) {
				responseString=ex.toString();
				ex.printStackTrace();
			} finally {
				try {
					
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
//			String responseString;
			

			Timestamp LastPaidTimeStamp = new Timestamp(date.getTime());
			 //  Timestamp CurrentTimeStamp2 = new Timestamp(date.getTime());
			   System.out.println(CurrentTimeStamp.getYear() + "CurrentTimeStamp.getYear()");
			   int NumberOfYearNotPayed=(int) (now.get(Calendar.YEAR)-FromYear);
			   System.out.println(NumberOfYearNotPayed +"  NumberOfYearNotPayed");
			  
//			return "String ";
			   if (NumberOfYearNotPayed==0)
			   {
			   	System.out.println("You already payed dont need to pay again");
			   	ResultString= " <tr> "
			   			   +" <td><b>Welfare Fund Fee</b></td> "
			   			    
			   			  +" <td><b> "
			   			
			   +"You Already paid "
			   			  +"  </b></td> "
			   			   
			   				+" </tr>";
			   }
			   else if (NumberOfYearNotPayed==1)
			   {
			   	System.out.println("Last year you didnt payed Please pay without fine ");
			   	
			   	System.out.println("Amount:" +TotalAmount);
//			   	ResultString=("Last year you didnt payed Please pay without fine ");
			   	ResultString =  " <tr> "
			   			   +" <td><b>Welfare Fund Fee</b></td> "
			   			    
			   			  +" <td><b> "
			   			  +" <input type=\"checkbox\" id=\"ThisYear\" name=\"ThisYear\" value=\""+TotalAmount+"\" onclick='handleClick(this);'>"+now.get(Calendar.YEAR)+"  "+" ("+TotalAmount+")<br> "
			   			  +"  </b></td> "
			   			   
			   				+" </tr>";


			   }
			   else if (NumberOfYearNotPayed>=2)
			   {
			   	int year = Calendar.getInstance().get(Calendar.YEAR);
			   	int PriviousYear=year-1;
			   	System.out.println("Last year you didnt payed pay with fine");
			   	int TotalFineAmount=TotalAmount+Fine_amount;
			   	int TotalFineAmount2=TotalAmount2+Fine_amount;
			   	System.out.println("Amount:" +TotalFineAmount);
//			   	ResultString=("Last year you didnt payed pay with fine ");
			   	//ResultString+=("Amount:" +TotalFineAmount);
			   	
			   	if (Month<=6)
			   	{
			   		
			   		if (diff2==15)
			   		{
			   			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				   		ResultString =  " <tr> "
				   				   +" <td><b>Welfare Fund Fee</b></td> "
				   				    
				   				  +" <td><b> "
				   				 +" <input type=\"checkbox\"  id=\"PriviousYear\" name=\"PriviousYear\" value=\""+TotalFineAmount2+"\" onclick='handleClick(this);'> "+PriviousYear+" ("+TotalFineAmount2+")<br> "
				   				  
				   				   +" <input type=\"checkbox\"  id=\"ThisYear\" name=\"ThisYear\" value=\""+TotalAmount+"\" onclick='handleClick(this);'>"+now.get(Calendar.YEAR)+"  "+" ( "+TotalAmount+")<br> "
				   				    +"  </b></td> "
				   				   
				   					+" </tr>";	
			   		}
			   		else
			   		{
			   			System.out.println("akshay" + TotalFineAmount);
				   		ResultString =  " <tr> "
				   				   +" <td><b>Welfare Fund Fee</b></td> "
				   				    
				   				  +" <td><b> "
				   				+" <input type=\"checkbox\" id=\"PriviousYear\"  name=\"PriviousYear\" value=\""+TotalFineAmount+"\" onclick='handleClick(this);'> "+PriviousYear+" ("+TotalFineAmount+")<br> "
				   				   +" <input type=\"checkbox\" id=\"ThisYear\" name=\"ThisYear\" value=\""+TotalAmount+"\"  onclick='handleClick(this);'>"+now.get(Calendar.YEAR)+"  "+" ( "+TotalAmount+")<br> "
				   				   
				   				    +"  </b></td> "
				   				   
				   					+" </tr>";	
			   		}
			   		
			   		
			   	}
			   	else
			   	{
			   		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				   	
			   		ResultString =  " <tr> "
			   				   +" <td><b>Welfare Fund Fee</b></td> "
			   				    
			   				  +" <td><b> "
			   				  +" <input type=\"checkbox\" id=\"ThisYear\"  name=\"ThisYear\" value=\""+TotalAmount+"\" onclick='handleClick(this);'>Pay For this year "+TotalAmount+"<br> "
			   				  +"  </b></td> "
			   				   
			   					+" </tr>";
			   	}
			   	ResultString+=	 " </tbody> "+  "</table>"; } 
		} // welfare member 
		
		else
		{
			/*ResultString +="Your a Life Time Member  ";*/
			
			ResultString= " <tr> "
					   +" <td><b>Welfare Fund Fee</b></td> "
					    
					  +" <td><b> "
					
		+"Your a Life Time Member  "
					  +"  </b></td> "
					   
						+" </tr>";
		}
		
	}
	else
	{
		/*ResultString +="Not a Welfare Member ";*/
		ResultString= " <tr> "
				   +" <td><b>Welfare Fund Fee</b></td> "
				    
				  +" <td><b> "
				
	+"Not a Welfare Member "
				  +"  </b></td> "
				   
					+" </tr>";
		
		
	} 

		return ResultString+"";
	}
	
	@Override
	public String GetMonthlyReportForBCI(LocalDate Start, LocalDate End) {
		
	/*	+ "<td><b> "+Start+"</b></td>"
 		+ "<td><b>"+BCISubscription+"</b></td>"
 		+ "<td><b>"+FDS+"</b></td>"
 		+ "<td><b>"+BCISubscriptionLateFee+"</b></td>"
 		+ "<td><b>"+FDSDiffAmt+"</b></td>"
 		
 		
 		+ "<td><b>"+CostReceipt+"</b></td>"
 		+ "<td><b>"+BCIReimbursmentOfSalaryDeduction+"</b></td>"
 		+ "<td><b>"+BCIInterestonFD+"</b></td>"
 		+ "<td><b>"+BCIClosingFD+"</b></td>"
 				+ "<td><b>"+FDSInterestonFD+"</b></td>"
 				+ "<td><b>"+FDSClosingFD+"</b></td>"
 				+"<td><b>"+total+"</b></td>"*/
//		long minutes = ChronoUnit.MINUTES.between(Start, End);
		String result="<h1><center><b>KSBC  Old KGID Building Bangalore</b></center></h1>"
				+ "<h1><center><b>Monthly Report Of BCI - FDS From: "+Start+" To: "+End+" </b></center></h1>";
		 result+= ""
			  		+ "<style>"
			  		+ "table {"
	    
			  	
	+ " border-collapse: separate; "
	+ "  empty-cells: hide; "
			  		
	   + "} "
	+ "</style>"
			  		
			  		+"<table class='table table-bordered'><thead><tr>"
				 + " <th>      </th> "
					+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
	   	+ " <th>      </th> "
	   	+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
		 		+ "<th>Date</th>"
				 +  "<th>BCI Sub.</th>"
				 + "<th>FDS</th>"
		 		+ "<th>BCI Subscription LateFee</th>"
		 		+ "<th>FDS Diff Amt</th>"
   			 
   			 
   			  + "<th>CostReceipt</th>"
   			  + " <th>BCI Reimbursment Of Salary Deduction</th>"
   			  + "<th>BCI Int. on FD</th> "
   			  + "<th>BCI Closing FD</th>"
   			  + "<th>FDS Interest  FD</th>"
   			  + "<th>FDS Closing FD</th>"
   			  + "<th>Total</th>"
   			  + " </tr>"
   			  +  " </thead>"
   			  +  "<tbody>";
		long days=ChronoUnit.DAYS.between(Start, End);
		LocalDate NewDate = null;
		 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		for(int i=0;i<=days;i++)
		{
			 NewDate = Start.plusDays(i);
			
			 result  += JSPRelatedFunctionsimp.GetReportPerDateForBCI(NewDate);
			
			System.out.println(NewDate + "  New Dates");
		}
		
	long	Global_tot= 	(long) Global_BCISubscriptionLateFee+	 Global_FDSDiffAmt+Global_BCISubscription+Global_FDS+Global_CostReceipt+Global_BCIReimbursmentOfSalaryDeduction+
			Global_BCIInterestonFD+Global_BCIClosingFD+Global_FDSInterestonFD+Global_FDSClosingFD;
		
		System.out.println(days + "   Diff btw start and end");
		// add global variable here
		result+="<tr>"

				 
 + " <td>      </td> "
				+ " <td>   </td><td>     </td> <td>   </td><td>     </td>"
   	+ " <td>      </td> "
   	+ " <td>   </td><td>     </td> <td>   </td><td>     </td>"
 
				+ "<td><b> Total</b></td>"
		 		+ "<td><b>"+Global_BCISubscription+"</b></td>"
		 		+ "<td><b>"+Global_FDS+"</b></td>"
		 		+ "<td><b>"+Global_BCISubscriptionLateFee+"</b></td>"
		 		+ "<td><b>"+Global_FDSDiffAmt+"</b></td>"
		 		
		 		
		 		+ "<td><b>"+Global_CostReceipt+"</b></td>"
		 		+ "<td><b>"+Global_BCIReimbursmentOfSalaryDeduction+"</b></td>"
		 		+ "<td><b>"+Global_BCIInterestonFD+"</b></td>"
		 		+ "<td><b>"+Global_BCIClosingFD+"</b></td>"
		 				+ "<td><b>"+Global_FDSInterestonFD+"</b></td>"
		 				+ "<td><b>"+Global_FDSClosingFD+"</b></td>"
		 				+ "<td><b><b>"+Global_tot+"</b></b></td>"
		 							+ "</tr>";
		result+=" </tbody> "+  "</table>";
		result+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
		   Global_BCISubscriptionLateFee = 0 ;
		   Global_FDSDiffAmt = 0 ;
		   Global_BCISubscription  = 0 ;
		 
		  Global_FDS  = 0 ;
		  Global_CostReceipt  = 0 ;
		  Global_BCIReimbursmentOfSalaryDeduction = 0 ;
		  Global_BCIInterestonFD = 0 ;
		  Global_BCIClosingFD   = 0 ;
		  Global_FDSInterestonFD  = 0 ;
		  Global_FDSClosingFD  = 0 ;
		return result;}

	@Override
	public String GetReportPerDateForBCI(LocalDate Start) {
		
		String Response="";
		
		System.out.println("BCI");
		BCI_FDSBean BCI_FDSBean = new BCI_FDSBean();
		 long  BCISubscriptionLateFee = 0 ;
		 long   FDSDiffAmt = 0 ;
		 long  BCISubscription  = 0 ;
		 Long total=(long) 0;
		  long  FDS  = 0 ;
			 long  CostReceipt  = 0 ;
			 long   BCIReimbursmentOfSalaryDeduction = 0 ;
			 long   BCIInterestonFD = 0 ;
			 long BCIClosingFD   = 0 ;
			 long  FDSInterestonFD  = 0 ;
			 long  FDSClosingFD  = 0 ;
			 java.sql.Timestamp ChallanCreatedDate = null ;
			 
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from BCI_FDSBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<BCI_FDSBean> list = (ArrayList<BCI_FDSBean>)query.list();
		System.out.println(list + "   List from BCI_FDSBean");
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp(); 
		 String Response1=JSPRelatedFunctionsimp.GetReportPerDateForKSBCMiscFeeForBCI(Start);
		 System.out.println(Response1+"GetReportPerDateForKSBCMiscFeeForBCI");
		 
		 String[] Splitresult = Response1.split("mor");
		 long BCIFromKSBC = Long.parseLong(Splitresult[0]);
		 System.out.println(BCIFromKSBC+"BCIFromKSBC");
		 
		 long FDSFromKSBC = Long.parseLong(Splitresult[1]);
		 
		 Global_BCISubscription+=BCIFromKSBC;
		 Global_FDS+=FDSFromKSBC;
		 BCISubscription+=BCIFromKSBC;
		 FDS+=FDSFromKSBC;
		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (BCI_FDSBean bci_FDSBean2 : list) {
				 
				 
				
				 
				
				   Global_BCISubscriptionLateFee+= bci_FDSBean2.getBCISubscriptionLateFee();
				    Global_FDSDiffAmt+=bci_FDSBean2.getFDSDiffAmt();
				   Global_BCISubscription +=bci_FDSBean2.getBCISubscription();
			//	  Global_total=(long) 0;
				    Global_FDS +=bci_FDSBean2.getFDS();
				  //  System.out.println(Global_FDS + "akshay  ");
					   Global_CostReceipt +=bci_FDSBean2.getCostReceipt();
					    Global_BCIReimbursmentOfSalaryDeduction +=bci_FDSBean2.getBCIReimbursmentOfSalaryDeduction();;
					    Global_BCIInterestonFD +=bci_FDSBean2.getBCIInterestonFD();
					  Global_BCIClosingFD   +=bci_FDSBean2.getBCIClosingFD();
					   Global_FDSInterestonFD +=bci_FDSBean2.getFDSInterestonFD();
					   System.out.println(Global_FDSInterestonFD + "akshay  ");
					   Global_FDSClosingFD +=bci_FDSBean2.getFDSClosingFD();
				 
				 
				 
				 
				 
				 BCISubscriptionLateFee+= bci_FDSBean2.getBCISubscriptionLateFee();
				 FDSDiffAmt+=bci_FDSBean2.getFDSDiffAmt();
				 BCISubscription+=bci_FDSBean2.getBCISubscription();
				 FDS+=bci_FDSBean2.getFDS();
				 CostReceipt+=bci_FDSBean2.getCostReceipt();
				 BCIReimbursmentOfSalaryDeduction+=bci_FDSBean2.getBCIReimbursmentOfSalaryDeduction();
				 BCIInterestonFD+=bci_FDSBean2.getBCIInterestonFD();
				 BCIClosingFD+=bci_FDSBean2.getBCIClosingFD();
				 FDSInterestonFD+=bci_FDSBean2.getFDSInterestonFD();
				 FDSClosingFD+=bci_FDSBean2.getFDSClosingFD();
				 
				 
				 
			}
			 total=	(long) BCISubscriptionLateFee+	 FDSDiffAmt+BCISubscription+FDS+CostReceipt+BCIReimbursmentOfSalaryDeduction+
					 BCIInterestonFD+BCIClosingFD+FDSInterestonFD+FDSClosingFD;
			/* Response="<tr> "
			 		
			 		+ "<td><b> "+Start+"</b></td>"
			 		+ "<td><b>"+BCISubscriptionLateFee+"</b></td>"
			 		+ "<td><b>"+FDSDiffAmt+"</b></td>"
			 		+ "<td><b>"+BCISubscription+"</b></td>"
			 		+ "<td><b>"+FDS+"</b></td>"
			 		+ "<td><b>"+CostReceipt+"</b></td>"
			 		+ "<td><b>"+BCIReimbursmentOfSalaryDeduction+"</b></td>"
			 		+ "<td><b>"+BCIInterestonFD+"</b></td>"
			 		+ "<td><b>"+BCIClosingFD+"</b></td>"
			 				+ "<td><b>"+FDSInterestonFD+"</b></td>"
			 				+ "<td><b>"+FDSClosingFD+"</b></td>"
			 				+"<td><b>"+total+"</b></td>"
			 				+ "</tr>";*/
			 
			 Response="<tr> "
 		+ "<td></td> <td></td> <td></td><td></td><td></td> <td></td><td></td><td></td><td></td><td></td><td><b> "+Start+"</b></td>"
			 		+ "<td><b>"+BCISubscription+"</b></td>"
			 		+ "<td><b>"+FDS+"</b></td>"
			 		+ "<td><b>"+BCISubscriptionLateFee+"</b></td>"
			 		+ "<td><b>"+FDSDiffAmt+"</b></td>"
			 		
			 		
			 		+ "<td><b>"+CostReceipt+"</b></td>"
			 		+ "<td><b>"+BCIReimbursmentOfSalaryDeduction+"</b></td>"
			 		+ "<td><b>"+BCIInterestonFD+"</b></td>"
			 		+ "<td><b>"+BCIClosingFD+"</b></td>"
			 				+ "<td><b>"+FDSInterestonFD+"</b></td>"
			 				+ "<td><b>"+FDSClosingFD+"</b></td>"
			 				+"<td><b>"+total+"</b></td>"
			 				+ "</tr>";
		 }
		 
			 
		 
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		
		return Response;
	}
	
	@Override
	public String GetMonthlyReportForKAWFMisc(LocalDate Start, LocalDate End) {// TODO Auto-generated method stub
		/*	 int KawfSubscription ;
		 int SeniorAdvocateContribution;
		 int ChangeofNominee;
		 int DuplicateCertificate;
		 int WelfareFundCostReceipts;
		 int donation;
		 int subscriptionLateFee;
		 int seniorAdvocateLateFee;
		 int WFReimbursmentOfsalaryDeduction;
		 int WelfareFundInterestOnFD;
		 int WelfareFundClosingFD;
		 int SaleofStampAmount;
		 int LifeMembershipFee;
		 int Govtgrant;
		 int Miscellaneous;*/
//		long minutes = ChronoUnit.MINUTES.between(Start, End);
		String result="<br></br><br></br><br></br><br></br><h1><center><b>KSBC  Old KGID Building Bangalore</b></center></h1>"
				+ "<h1><center><b>Monthly Report Of KAWF From: "+Start+" To: "+End+" </b></center></h1>";
		 result+=""
				 + "<style>"
			  		+ "table {"
	    
			  	
	+ " border-collapse: separate; "
	+ "  empty-cells: hide; "
			  		
	   + "} "
	+ "</style>"
			  		+ "<table class='table table-bordered'><thead><tr>"
				 + " <th>      </th> "
					+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
	   	+ " <th>      </th> "
	   	+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
		 		+ "<th><b>Date</th></b>"
				  + "<th><b>Memb. Fee</th></b>"
				+ "<th><b>Kawf Sub</th></b>"
				+ "<th><b>Senior Adv. Cont.</th></b>"
  			  +  "<th><b>Change of Nominee</th></b><th><b>Dup FM Cert.</th></b>"
  			  + "<th><b>Cost Recei.</th></b>"
  			  + " <th><b>Donation</th></b>"
  			  + "<th><b>sub. Late Fee</th></b> "
  			  + "<th><b>sen Adv. cont. Late Fee</th></b>"
  			  + "<th><b>Reim. Of sal. Deduction</th></b>"
  			  + "<th><b>Int. On FD</th></b>"
  			  
  			  
  			 + "<th><b>Closing FD</th></b>"
 			  + "<th><b>Sale of Stamp</th></b>"
 			  + "<th><b>LMF</th></b>"
 			  
+ "<th><b>Govt grant</th></b>"
	  + "<th><b>Misc</th></b>"
	
	 /* + "<th>Mem.Late Fee</th>"*/

+ "<th><b>Total</th></b>"
  			  + " </tr>"
  			  +  " </thead>"
  			  +  "<tbody>";
		long days=ChronoUnit.DAYS.between(Start, End);
		LocalDate NewDate = null;
		for(int i=0;i<=days;i++)
		{
			 NewDate = Start.plusDays(i);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			 result  += JSPRelatedFunctionsimp.GetReportPerDateForKAWFMisc(NewDate);
			
			System.out.println(NewDate + "  New Dates");
		}
		System.out.println(days + "   Diff btw start and end");
		long total=(Global_KawfSubscription+
				  Global_SeniorAdvocateContribution+
				  Global_ChangeofNominee+
				  Global_DuplicateCertificate+
				  Global_WelfareFundCostReceipts+
				  Global_donation+
				  Global_subscriptionLateFee+
				 
				  Global_seniorAdvocateLateFee+
				  Global_WFReimbursmentOfsalaryDeduction+
				  Global_WelfareFundInterestOnFD+
				  Global_WelfareFundClosingFD+
				  Global_SaleofStampAmount+
				  Global_LifeMembershipFee+
				  Global_Govtgrant+
				  Global_Miscellaneous+
				  Global_KAWFMembershipFee);
		result+="<tr>"
				 + " <td>      </td> "
					+ " <td>   </td><td>     </td> <td>   </td><td>     </td>"
	   	+ " <td>      </td> "
	   	+ " <td>   </td><td>     </td> <td>   </td><td>     </td>"
				+ "<td><b>Total</b></td>"
				
				+ "<td><b>"+Global_KAWFMembershipFee+"</b></td>"
				+ "<td><b>"+Global_KawfSubscription+"</b></td>"
		 		+ "<td><b>"+Global_SeniorAdvocateContribution+"</b></td>"
		 		
		 		+ "<td><b>"+Global_ChangeofNominee+"</b></td>"
		 		+ "<td><b>"+Global_DuplicateCertificate+"</b></td>"
		 		
		 		+ "<td><b>"+Global_WelfareFundCostReceipts+"</b></td>"
		 		+ "<td><b>"+Global_donation+"</b></td>"
		 		
		 		+ "<td><b>"+Global_subscriptionLateFee+"</b></td>"
		 		+ "<td><b>"+Global_seniorAdvocateLateFee+"</b></td>"
		 		
		 		
		 		+ "<td><b>"+Global_WFReimbursmentOfsalaryDeduction+"</b></td>"
		 		+ "<td><b>"+Global_WelfareFundInterestOnFD+"</b></td>"
		 		
		 		+ "<td><b>"+Global_WelfareFundClosingFD+"</b></td>"
		 		+ "<td><b>"+Global_SaleofStampAmount+"</b></td>"
		 		
		 		+ "<td><b>"+Global_LifeMembershipFee+"</b></td>"
		 		+ "<td><b>"+Global_Govtgrant+"</b></td>"
		 		+ "<td><b>"+Global_Miscellaneous+"</b></td>"
		 		
		 	/*	+ "<td><b>"+Global_WFMembershipLateFee+"</b></td>"*/
		 		
		 				+ "<td><b>" +total+"</b></td>"
				+ "</tr>";
		result+=" </tbody> "+  "</table>";
		result+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
		 
		  Global_KawfSubscription =0;
		  Global_SeniorAdvocateContribution =0;
		  Global_ChangeofNominee =0;
		  Global_DuplicateCertificate =0;
		  Global_WelfareFundCostReceipts =0;
		  Global_donation =0;
		  Global_subscriptionLateFee =0;
		  Global_Stampfee=0;
		  Global_seniorAdvocateLateFee =0;
		  Global_WFReimbursmentOfsalaryDeduction =0;
		  Global_WelfareFundInterestOnFD =0;
		  Global_WelfareFundClosingFD =0;
		  Global_SaleofStampAmount =0;
		  Global_LifeMembershipFee =0;
		  Global_Govtgrant =0;
		  Global_Miscellaneous =0;
		  Global_KAWFMembershipFee=0;
		  Global_WFMembershipLateFee=0;
		  Global_AssociationStampfee=0;
			 Global_PostalCharges=0;
		/*  Global_*/
		return result;}

	@Override
	public String GetReportPerDateForKAWFMisc(LocalDate Start) {
		
		String Response="";
		
		KAWFMiscReceiptBean BCI_FDSBean = new KAWFMiscReceiptBean();
		 long KawfSubscription =0;
		 long SeniorAdvocateContribution =0;
		 long ChangeofNominee =0;
		 long DuplicateCertificate =0;
		 long WelfareFundCostReceipts =0;
		 long donation =0;
		 long subscriptionLateFee =0;
		 
		 long seniorAdvocateLateFee =0;
		 long WFReimbursmentOfsalaryDeduction =0;
		 int WelfareFundInterestOnFD =0;
		 long WelfareFundClosingFD =0;
		 long SaleofStampAmount =0;
		 long LifeMembershipFee =0;
		 long Govtgrant =0;
		 long Miscellaneous =0;
		 
		 
		
	/*	long total=0;*/
		
			 java.sql.Timestamp ChallanCreatedDate = null ;
		
		
		try
		{
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
			String Associate = JSPRelatedFunctionsimp.GetReportPerDateForAssociateStampingFee(Start);
			
			System.out.println(Associate +"Associate");
			String Individual = JSPRelatedFunctionsimp.GetReportPerDateForIndividualStampingFee(Start);
			System.out.println(Individual + "Individual");
			int AssociateTotal = Integer.parseInt(Associate);
			int IndividualTotal = Integer.parseInt(Individual);
			SaleofStampAmount+=AssociateTotal+IndividualTotal;
			Global_SaleofStampAmount+=AssociateTotal+IndividualTotal;
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from KAWFMiscReceiptBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<KAWFMiscReceiptBean> list = (ArrayList<KAWFMiscReceiptBean>)query.list();
		 
		 
		System.out.println(list + "   List from KAWFLateWelfareFundBean");
			 
		

		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (KAWFMiscReceiptBean bci_FDSBean2 : list) {
				 
				 // Global
				 Global_KawfSubscription +=bci_FDSBean2.getKawfSubscription();
				 Global_SeniorAdvocateContribution +=bci_FDSBean2.getSeniorAdvocateContribution();
				 Global_ChangeofNominee +=bci_FDSBean2.getChangeofNominee();
				 Global_DuplicateCertificate +=bci_FDSBean2.getDuplicateCertificate();
				 Global_WelfareFundCostReceipts +=bci_FDSBean2.getWelfareFundCostReceipts();
				 Global_donation +=bci_FDSBean2.getDonation();
				 Global_subscriptionLateFee +=bci_FDSBean2.getSubscriptionLateFee();
				 Global_seniorAdvocateLateFee +=bci_FDSBean2.getSeniorAdvocateLateFee();
				 Global_WFReimbursmentOfsalaryDeduction +=bci_FDSBean2.getWFReimbursmentOfsalaryDeduction();
				 Global_WelfareFundInterestOnFD +=bci_FDSBean2.getWelfareFundInterestOnFD();
				 Global_WelfareFundClosingFD +=bci_FDSBean2.getWelfareFundClosingFD();
				 Global_SaleofStampAmount +=bci_FDSBean2.getSaleofStampAmount();
				 Global_LifeMembershipFee +=bci_FDSBean2.getLifeMembershipFee();
				 Global_Govtgrant +=bci_FDSBean2.getGovtgrant();
				 Global_Miscellaneous +=bci_FDSBean2.getMiscellaneous(); 
				 
				 
				 //Local
				 System.out.println(bci_FDSBean2.getKawfSubscription() + "  kawf sub");
				  KawfSubscription +=bci_FDSBean2.getKawfSubscription();
				  SeniorAdvocateContribution +=bci_FDSBean2.getSeniorAdvocateContribution();
				  ChangeofNominee +=bci_FDSBean2.getChangeofNominee();
				  DuplicateCertificate +=bci_FDSBean2.getDuplicateCertificate();
				  WelfareFundCostReceipts +=bci_FDSBean2.getWelfareFundCostReceipts();
				  donation +=bci_FDSBean2.getDonation();
				  subscriptionLateFee +=bci_FDSBean2.getSubscriptionLateFee();
				  seniorAdvocateLateFee +=bci_FDSBean2.getSeniorAdvocateLateFee();
				  WFReimbursmentOfsalaryDeduction +=bci_FDSBean2.getWFReimbursmentOfsalaryDeduction();
				  WelfareFundInterestOnFD +=bci_FDSBean2.getWelfareFundInterestOnFD();
				  WelfareFundClosingFD +=bci_FDSBean2.getWelfareFundClosingFD();
				  SaleofStampAmount +=bci_FDSBean2.getSaleofStampAmount();
				  LifeMembershipFee +=bci_FDSBean2.getLifeMembershipFee();
				  Govtgrant +=bci_FDSBean2.getGovtgrant();
				  Miscellaneous +=bci_FDSBean2.getMiscellaneous();
				
				 
			}
			 total=	 KawfSubscription+SeniorAdvocateContribution+ChangeofNominee+DuplicateCertificate+WelfareFundCostReceipts+donation+subscriptionLateFee+
			
					 seniorAdvocateLateFee+WFReimbursmentOfsalaryDeduction+WelfareFundInterestOnFD+WelfareFundClosingFD+SaleofStampAmount+LifeMembershipFee+
					
					 Govtgrant+Miscellaneous;
					
		 }
		 
			 
		
		 
		 String Response1=JSPRelatedFunctionsimp.GetReportPerDateForKAWFMemberShipFee(Start);
		 String[] Splitresult = Response1.split("mor");
		 System.out.println(Splitresult.length   + "   Len");
		 Response="<tr> "
				 + "<td></td> <td></td> <td></td><td></td><td></td> <td></td><td></td><td></td><td></td><td></td><td><b> "+Start+"</b></td>"
					;	 Response+= Splitresult[0]; // MemberShipFee
		 Response+=
			 		 "<td><b>"+KawfSubscription+"</b></td>"
			 		+ "<td><b>"+SeniorAdvocateContribution+"</b></td>"
			 		
			 		+ "<td><b>"+ChangeofNominee+"</b></td>"
			 		+ "<td><b>"+DuplicateCertificate+"</b></td>"
			 		
			 		+ "<td><b>"+WelfareFundCostReceipts+"</b></td>"
			 		+ "<td><b>"+donation+"</b></td>"
			 		
			 		+ "<td><b>"+subscriptionLateFee+"</b></td>"
			 		+ "<td><b>"+seniorAdvocateLateFee+"</b></td>"
			 		
			 		
			 		+ "<td><b>"+WFReimbursmentOfsalaryDeduction+"</b></td>"
			 		+ "<td><b>"+WelfareFundInterestOnFD+"</b></td>"
			 		
			 		+ "<td><b>"+WelfareFundClosingFD+"</b></td>"
			 		+ "<td><b>"+SaleofStampAmount+"</b></td>"
			 		
			 		+ "<td><b>"+LifeMembershipFee+"</b></td>"
			 		+ "<td><b>"+Govtgrant+"</b></td>"
			 		+ "<td><b>"+Miscellaneous+"</b></td>"
			 			
			 		/*	+ "<td><b>"+total+"</b></td>"	*/
			 			/*+ "</tr>"*/;
		 long totalfromenr = Long.parseLong(Splitresult[1]);
		 long FinalTotal=(total+totalfromenr);
		 System.out.println(totalfromenr + "   total");
		 Response+= "<td><b>"+(FinalTotal)+"</b></td></tr>";
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		
		return Response;
	}

	@Override
	public String GetMonthlyReportForKAWFMemberShipFee(LocalDate Start, LocalDate End) {
		
		
//		long minutes = ChronoUnit.MINUTES.between(Start, End);
		String result=""
		  		+ "<style>"
		  		+ "table {"
    
   + " empty-cells: hide;"
   + "} "
+ "</style>"
		  		+ "<table class='table table-bordered'><thead><tr><th>Date</th>"
				+ "<th>KAWFMembershipFee</th><th>WFMembershipLateFee</th><th>Total</th>"
   			
   			  + " </tr>"
   			  +  " </thead>"
   			  +  "<tbody>";
		long days=ChronoUnit.DAYS.between(Start, End);
		LocalDate NewDate = null;
		for(int i=0;i<=days;i++)
		{
			 NewDate = Start.plusDays(i);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			 result  += JSPRelatedFunctionsimp.GetReportPerDateForKAWFMemberShipFee(NewDate);
			
			System.out.println(NewDate + "  New Dates");
		}
		System.out.println(days + "   Diff btw start and end");
		result+=" </tbody> "+  "</table>";
		return result;
	}

	@Override
	public String GetReportPerDateForKAWFMemberShipFee(LocalDate Start) {
		
		String Response="";
		
		KAWFLateWelfareFundBean BCI_FDSBean = new KAWFLateWelfareFundBean();
		 int KAWFMembershipFee=0;
		 int WFMembershipLateFee=0;
	long total=0;
			 java.sql.Timestamp ChallanCreatedDate = null ;
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from KAWFLateWelfareFundBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<KAWFLateWelfareFundBean> list = (ArrayList<KAWFLateWelfareFundBean>)query.list();
		System.out.println(list + "   List from KAWFLateWelfareFundBean");
			 
		

		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (KAWFLateWelfareFundBean bci_FDSBean2 : list) {
				 
				 
				 Global_KAWFMembershipFee+= bci_FDSBean2.getKAWFMembershipFee();
				 Global_WFMembershipLateFee+=bci_FDSBean2.getWFMembershipLateFee();
				 KAWFMembershipFee+= bci_FDSBean2.getKAWFMembershipFee();
				 WFMembershipLateFee+=bci_FDSBean2.getWFMembershipLateFee();
				 
				 
			}
			 total= KAWFMembershipFee+WFMembershipLateFee;
			 Response=
			 		
			 	
			 		 "<td><b>"+KAWFMembershipFee+"</b></td>"
			 			/*	+ "<td><b>"+WFMembershipLateFee+"</b></td>"*/
			 				/*+ "<td><b>"+KAWFMembershipFee+WFMembershipLateFee+"</b></td>"*/
			 			;
		 }
		 
			 
		 
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response+"mor"+total);
		
		return Response+"mor"+total;
	}
	
	
	
	
	@Override
	public String GetMonthlyReportForKSBCMiscFee(LocalDate Start, LocalDate End) {// TODO Auto-generated method stub
		/*private int CertificateCopyCharges;
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

	private int ReimbursementOFSalaryDeduction;
	private int ClosingFD;
	private int KSBCCostReceipt;

	private int Resumption;
	
	private int MiscReceipts;

	private int VoterCD;
	private int NominationForm;
	private int ElectionDeposit;
	private int PDC;
	
	*private int ChangeOfAddress;
	private int ComplaintFee;
	private String NameOftheClient;
	private int IdentityCard;
	private int EnrollmentApplication;
	private int GOvtGrant;
	private int ElectionRules;
	*/

 	/*	+ "<td><b> "+Start+"</b></td>"
			 		+ "<td><b>"+CertificateCopyCharges+"</b></td>"
			 		+ "<td><b>"+PostageReceipts+"</b></td>"
			 		+ "<td><b>"+DuplicateEnrollemt+"</b></td>"
			 		+ "<td><b>"+EndomentCertificate+"</b></td>"
			 		+ "<td><b>"+KSBCInterestONFD+"</b></td>"
			 		+ "<td><b>"+DOBCertificate+"</b></td>"
			 		+ "<td><b>"+ContinuityCertificate+"</b></td>"
			 		
			 		
			 		
			 		+ "<td><b> "+VSP+"</b></td>"
			 		+ "<td><b>"+ProcessFee+"</b></td>"
			 		+ "<td><b>"+NOC+"</b></td>"
			 		+ "<td><b>"+ChangeOfNamePublication+"</b></td>"
			 		+ "<td><b>"+ReimbursementOFSalaryDeduction+"</b></td>"
			 		+ "<td><b>"+ClosingFD+"</b></td>"
			 		+ "<td><b>"+KSBCCostReceipt+"</b></td>"
			 		+ "<td><b>"+Resumption+"</b></td>"
			 		
			 		
			 			+ "<td><b> "+MiscReceipts+"</b></td>"
			 		+ "<td><b>"+ProcessFee+"</b></td>"
			 		+ "<td><b>"+NOC+"</b></td>"
			 		+ "<td><b>"+ChangeOfNamePublication+"</b></td>"
			 		+ "<td><b>"+ReimbursementOFSalaryDeduction+"</b></td>"
			 		+ "<td><b>"+ClosingFD+"</b></td>"
			 		+ "<td><b>"+KSBCCostReceipt+"</b></td>"
			 		+ "<td><b>"+Resumption+"</b></td>"
 		*/

		// TODO Auto-generated method stub
		
//		long minutes = ChronoUnit.MINUTES.between(Start, End);
		
		 String result="<br></br><br></br><br></br><br></br><h1><center><b>KSBC  Old KGID Building Bangalore</b></center></h1>"
	                + "<h1><center><b>Monthly Report Of KSBC From: "+Start+" To: "+End+" </b></center></h1>";
	         result+=/*"<table class='table table-bordered'><thead><tr><th>Date</th>"
	                + "<th>CertificateCopyCharges</th>"
	                + "<th>PostageReceipts</th><th>DuplicateEnrollemt</th>"
	                + "<th>EndomentCertificate</th><th>KSBCInterestONFD</th><th>DOBCertificate</th><th>ContinuityCertificate</th>"
	                + "<th>VSP</th><th>ProcessFee</th><th>NOC</th><th>ChangeOfNamePublication</th><th>ReimbursementOFSalaryDeduction</th>"
	                + "<th>ClosingFD</th><th>KSBCCostReceipt</th>"
	                + "<th>Resumption</th><th>MiscReceipts</th><th>VoterCD</th><th>NominationForm</th>"
	                + "<th>ElectionDeposit</th><th>PDC</th>"
	                
	                + "<th>ChangeOfAddress</th>"
	                + "<th>ComplaintFee</th>"
	                
	                + "<th>IdentityCard</th>"
	                + "<th>EnrollmentApplication</th>"
	                
	                + "<th>ElectionRules</th>"
	               +"<th>GOvtGrant</th>"
	               
	               + "<th>EnrollmentFee</th><th>ID</th>"
	                 +  "<th>miscRts</th><th>KsbcTrust</th><th>"
	                 + "KawfMembershipFee</th> <th>BciSubscription</th><th>fds</th>"
	               +"<th>Total</th>"
	                 + " </tr>"
	                 +  " </thead>"
	                 +  "<tbody>"*/
	                /* + "<td><b> "+Start+"</b></td>"
	                 + "<td><b>"+IdentityCard+"</b></td>"
	                 + "<td><b>"+ComplaintFee+"</b></td>"
	                
	                 + "<td><b>"+NOC+"</b></td>"
	                 + "<td><b>"+ProcessFee+"</b></td>"
	                 + "<td><b>"+Resumption+"</b></td>"
	                     + "<td><b> "+VSP+"</b></td>"
	                 + "<td><b>"+ElectionDeposit+"</b></td>"
	                 + "<td><b> "+MiscReceipts+"</b></td>"
	                 + "<td><b>"+KSBCCostReceipt+"</b></td>"
	                 + "<td><b>"+KSBCInterestONFD+"</b></td>"
	                 + "<td><b>"+ClosingFD+"</b></td>"
	                         + "<td><b>"+ReimbursementOFSalaryDeduction+"</b></td>"
	                     +"<td><b>"+GOvtGrant+"</b></td>"
	                     
	                     
	                 
	                     + "<td><b>"+CertificateCopyCharges+"</b></td>"
	                     + "<td><b>"+PostageReceipts+"</b></td>"
	                     + "<td><b>"+DuplicateEnrollemt+"</b></td>"
	                     + "<td><b>"+EndomentCertificate+"</b></td>"
	                     + "<td><b>"+DOBCertificate+"</b></td>"
	                     + "<td><b>"+ContinuityCertificate+"</b></td>"
	                     
	                     + "<td><b>"+ChangeOfNamePublication+"</b></td>"
	                     + "<td><b>"+VoterCD+"</b></td>"
	                     + "<td><b>"+NominationForm+"</b></td>"
	                     + "<td><b>"+PDC+"</b></td>"
	                     + "<td><b>"+ChangeOfAddress+"</b></td>"
	                
	                + "<td><b>"+EnrollmentApplication+"</b></td>"
	                 + "<td><b>"+ElectionRules+"</b></td>"
	           */
	                 
	                
	                 ""
	                 + "<style>"
	                      + "table {"
	        
	                  
	    + " border-collapse: separate; "
	    + "  empty-cells: hide; "
	                      
	       + "} "
	       

	    +".watermark {"
	    +"  position: absolute;"
	    +"  opacity: 0.20;"
	      +"  font-size: 3em;"
	        +"width: 100%;"
	        +"text-align: center;"
	      /*   z-index: 0; */
	        +"transform:rotate(300deg);"
	        +"-webkit-transform:rotate(300deg);"
	      /*  -webkit-transform: rotate(45deg);
	       -moz-transform: rotate(-45deg); */
	       +"font-family:    Arial, Helvetica, sans-serif;"
	         +"           font-size:      40px;"
	                    /* font-weight:    bold; */
	         +"}"

	    + "</style>"
	                      + "<table class='table table-bordered'><thead>"
	                + "<tr>"
	                + " <th>      </th> "
	                + " <th>   </th><th>     </th> <th>   </th><th>     </th>"
	       + " <th>      </th> "
	       + " <th>   </th><th>     </th> <th>   </th><th>     </th>"
	 
	                + "<th>Date</th>"
	                + "<th>Enrol. Fees</th>"
	                + "<th>ID Card</th>"
	                + "<th>Enrl. App</th>"
	                + "<th>Complnt Fee</th>"
	                
	+ "<th>Change Of Add.</th>"
	
	+ "<th>CNP</th>"
	+ "<th>Certi. Veri. Fee </th>"

	                + "<th>NOC</th>"
	                + "<th>Procs Fee</th>"
	                + "<th>Resumption</th>"
	                + "<th>VSP</th>"
	                + "<th>Others</th>"
	                
	                + "<th>Election Depo.</th>"
	                + "<th>misc Rts</th>"
	                + "<th>KSBC Cost</th>"
	                + "<th>Int on FD</th>"
	                + "<th>Clog FD</th>"
	                + "<th>KSBC Reimb. Sal. Ded</th>"
	                +"<th>Govt Grant</th>"
				
				
				
				
				
				


   			
   			
   			/*+ "<th>ID</th>" 
  +  "<th>misc Rts</th>"
  + "<th>Ksbc Trust</th>"
  + "<th>Kawf Membership Fee</th>"
  + " <th>Bci Subscription</th>"
  + "<th>fds</th>"*/
   			+"<th>Total</th>"
   			  + " </tr>"
   			  +  " </thead>"
   			  +  "<tbody>"
   			  
+"<div class=\"watermark\">KSBC"; 
		
		
		
		
		
		long days=ChronoUnit.DAYS.between(Start, End);
		LocalDate NewDate = null;
		for(int i=0;i<=days;i++)
		{
			 NewDate = Start.plusDays(i);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			 result  += JSPRelatedFunctionsimp.GetReportPerDateForKSBCMiscFee(NewDate);
			
			System.out.println(NewDate + "  New Dates");
		}
		System.out.println(days + "   Diff btw start and end");
		long others=Global_ContinuityCertificate+Global_CertificateCopyCharges+Global_DOBCertificate+Global_PostageReceipts+Global_PDC+Global_EndomentCertificate+Global_DuplicateEnrollemt+Global_VoterCD+Global_ElectionRules+Global_NominationForm;
		long totalKSBC=	Global_ChangeOfNamePublication+Global_EnrollmentFee+Global_IdentityCard+Global_EnrollmentApplication+Global_ComplaintFee
				+Global_ChangeOfAddress+Global_NOC+Global_ProcessFee+Global_Resumption+Global_VSP
				+others+Global_ElectionDeposit+Global_MiscReceipts+Global_KSBCCostReceipt+Global_KSBCInterestONFD
				+Global_ClosingFD+Global_ReimbursementOFSalaryDeduction+Global_GOvtGrant+Global_Certverificationfee;
		result+="<tr>"
				+ " <td>      </td> "
				+ " <td>   </td><td>     </td> <td>   </td><td>     </td>"
   	+ " <td>      </td> "
   	+ " <td>   </td><td>     </td> <td>   </td><td>     </td>"
 
				+ "<td><b> Total</b></td>"
				 +"<td><b>"+Global_EnrollmentFee+"</b></td>"
				 + "<td><b>"+Global_IdentityCard+"</b></td>"
				 + "<td><b>"+Global_EnrollmentApplication+"</b></td>"
				 + "<td><b>"+Global_ComplaintFee+"</b></td>"
				+ "<td><b>"+Global_ChangeOfAddress+"</b></td>"
				 + "<td><b>"+Global_ChangeOfNamePublication+"</b></td>"
				  + "<td><b>"+Global_Certverificationfee+"</b></td>"
				 
				 + "<td><b>"+Global_NOC+"</b></td>"
				 + "<td><b>"+Global_ProcessFee+"</b></td>"
				 + "<td><b>"+Global_Resumption+"</b></td>"
				 	+ "<td><b> "+Global_VSP+"</b></td>"
				 		+ "<td><b> "+others+"</b></td>"
				 	
				 + "<td><b>"+Global_ElectionDeposit+"</b></td>"
				 + "<td><b> "+Global_MiscReceipts+"</b></td>"
				 + "<td><b>"+Global_KSBCCostReceipt+"</b></td>"
				 + "<td><b>"+Global_KSBCInterestONFD+"</b></td>"
				 + "<td><b>"+Global_ClosingFD+"</b></td>"
				 		+ "<td><b>"+Global_ReimbursementOFSalaryDeduction+"</b></td>"
				 	+"<td><b>"+Global_GOvtGrant+"</b></td>"
				 	
			 		+ "<td><b>"+totalKSBC+"</b></td>"
				+ "</tr>";
		result+=" </tbody> "+  "</table></div>";
		result+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
		  Global_CertificateCopyCharges=0;
		  Global_PostageReceipts=0;
		  Global_EnrollmentFee=0;
		  Global_DuplicateEnrollemt=0;
		  Global_Certverificationfee=0;
		// String KARNumber=0;
		  Global_EndomentCertificate=0;
		  Global_KSBCInterestONFD=0;
		  Global_DOBCertificate=0;
		  Global_ContinuityCertificate=0;
		  Global_VSP=0;
		  Global_ProcessFee=0;
		  Global_NOC=0;
		  Global_ChangeOfNamePublication=0;
	/*	  total=(long) 0;*/
		  Global_ReimbursementOFSalaryDeduction=0;
		  Global_ClosingFD=0;
		  Global_KSBCCostReceipt=0;

		  Global_Resumption=0;
	
		  Global_MiscReceipts=0;

		  Global_VoterCD=0;
		  Global_NominationForm=0;
		  Global_ElectionDeposit=0;
		  Global_PDC=0;
		  Global_GOvtGrant=0;
		  Global_ElectionRules=0;
		  Global_ChangeOfAddress=0;
		  Global_ComplaintFee=0;
	//	 String NameOftheClient=0;
		  Global_IdentityCard=0;
		  Global_EnrollmentApplication=0;
		  
		  // From Enroll
		  Global_ksbcIdentityCard=0;
			 Global_miscRts=0;
			 Global_KsbcTrust=0;
			 Global_KawfMembershipFee=0;
			 Global_BciSubscription=0;
			 Global_fds=0;
		 
		 
		
		return result;
	
		}

	@Override
	public String GetReportPerDateForKSBCMiscFee(LocalDate Start) {
		
		String Response="";
		KSBCMiscReceiptBean BCI_FDSBean = new KSBCMiscReceiptBean();
		 long CertificateCopyCharges=0;
		 long PostageReceipts=0;

		 long DuplicateEnrollemt=0;
		// String KARNumber=0;
		 long EndomentCertificate=0;
		 long KSBCInterestONFD=0;
		 long DOBCertificate=0;
		 long ContinuityCertificate=0;
		 long VSP=0;
		 long ProcessFee=0;
		 long NOC=0;
		 long ChangeOfNamePublication=0;
		 Long total=(long) 0;
	 long ReimbursementOFSalaryDeduction=0;
	 long ClosingFD=0;
	 long KSBCCostReceipt=0;

	 long Resumption=0;
	
	 long MiscReceipts=0;

	 long VoterCD=0;
	 long NominationForm=0;
	 long ElectionDeposit=0;
	 long PDC=0;
	  long GOvtGrant=0;
		 long ElectionRules=0;
	  long ChangeOfAddress=0;
		 long ComplaintFee=0;
	//	 String NameOftheClient=0;
		 long IdentityCard=0;
		 long EnrollmentApplication=0;
		 Response="<tr> "
				 + "<td></td> <td></td> <td></td><td></td><td></td> <td></td><td></td><td></td><td></td><td></td><td><b> "+Start+"</b></td>"
					;
		 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp(); 
			String	 Response1=JSPRelatedFunctionsimp.GetReportPerDateForKSBCEnrollFee(Start);
				 String[] Splitresult = Response1.split("mor");
				 System.out.println(Splitresult.length   + "   Len");
				 Response+= Splitresult[0];
				 long totalfromenr = Long.parseLong(Splitresult[1]);
				 long MiscvalueFromEnrol = Long.parseLong(Splitresult[2]);
				 long idFromEnroll = Long.parseLong(Splitresult[3]);
				 long Certverificationfee = Long.parseLong(Splitresult[4]);
				 IdentityCard+=idFromEnroll;
				 MiscReceipts+=MiscvalueFromEnrol;
				
				 Global_IdentityCard+=idFromEnroll;
				 Global_MiscReceipts+=MiscvalueFromEnrol;
			 java.sql.Timestamp ChallanCreatedDate = null ;
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from KSBCMiscReceiptBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<KSBCMiscReceiptBean> list = (ArrayList<KSBCMiscReceiptBean>)query.list();
		System.out.println(list + "   List from KSBCMiscReceiptBean");
			 

		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 
			/* int ChangeOfAddress=0;
			 int ComplaintFee=0;
		//	 String NameOftheClient=0;
			 int IdentityCard=0;
			 int EnrollmentApplication=0;*/
			 for (KSBCMiscReceiptBean bci_FDSBean2 : list) {
				 // Global
				 Global_CertificateCopyCharges+=bci_FDSBean2.getCertificateCopyCharges();
				 Global_PostageReceipts+=bci_FDSBean2.getPostageReceipts();

				 Global_DuplicateEnrollemt+=bci_FDSBean2.getDuplicateEnrollemt();
				// String KARNumber=0;
				 Global_EndomentCertificate+=bci_FDSBean2.getEndomentCertificate();
				 Global_KSBCInterestONFD+=bci_FDSBean2.getKSBCInterestONFD();
				 Global_DOBCertificate+=bci_FDSBean2.getDOBCertificate();
				 Global_ContinuityCertificate+=bci_FDSBean2.getContinuityCertificate();
				 Global_VSP+=bci_FDSBean2.getVSP();
				 Global_ProcessFee+=bci_FDSBean2.getProcessFee();
				 Global_NOC+=bci_FDSBean2.getNOC();
				 Global_ChangeOfNamePublication+=bci_FDSBean2.getChangeOfNamePublication();
				 Global_ChangeOfAddress+=bci_FDSBean2.getChangeOfAddress();
				 Global_ComplaintFee+=bci_FDSBean2.getComplaintFee();
				//	 String NameOftheClient=0;
				 Global_IdentityCard+=bci_FDSBean2.getIdentityCard();
				 Global_EnrollmentApplication+=bci_FDSBean2.getEnrollmentApplication();
				 Global_ReimbursementOFSalaryDeduction+=bci_FDSBean2.getReimbursementOFSalaryDeduction();
				 Global_ClosingFD+=bci_FDSBean2.getClosingFD();
				 Global_KSBCCostReceipt+=bci_FDSBean2.getKSBCCostReceipt();

				 Global_Resumption+=bci_FDSBean2.getResumption();
				 Global_ElectionRules+=bci_FDSBean2.getElectionRules();
				 Global_MiscReceipts+=bci_FDSBean2.getMiscReceipts();
				 Global_GOvtGrant+=bci_FDSBean2.getGOvtGrant();
				 Global_VoterCD+=bci_FDSBean2.getVoterCD();
				 Global_NominationForm+=bci_FDSBean2.getNominationForm();
				 Global_ElectionDeposit+=bci_FDSBean2.getElectionDeposit();
				 Global_PDC+=bci_FDSBean2.getPDC();
				 
				 
				 // Local
				  CertificateCopyCharges+=bci_FDSBean2.getCertificateCopyCharges();
				  PostageReceipts+=bci_FDSBean2.getPostageReceipts();

				  DuplicateEnrollemt+=bci_FDSBean2.getDuplicateEnrollemt();
				// String KARNumber=0;
				  EndomentCertificate+=bci_FDSBean2.getEndomentCertificate();
				  KSBCInterestONFD+=bci_FDSBean2.getKSBCInterestONFD();
				  DOBCertificate+=bci_FDSBean2.getDOBCertificate();
				  ContinuityCertificate+=bci_FDSBean2.getContinuityCertificate();
				  VSP+=bci_FDSBean2.getVSP();
				  ProcessFee+=bci_FDSBean2.getProcessFee();
				  NOC+=bci_FDSBean2.getNOC();
				  ChangeOfNamePublication+=bci_FDSBean2.getChangeOfNamePublication();
				   ChangeOfAddress+=bci_FDSBean2.getChangeOfAddress();
					  ComplaintFee+=bci_FDSBean2.getComplaintFee();
				//	 String NameOftheClient=0;
					  IdentityCard+=bci_FDSBean2.getIdentityCard();
					  EnrollmentApplication+=bci_FDSBean2.getEnrollmentApplication();
			  ReimbursementOFSalaryDeduction+=bci_FDSBean2.getReimbursementOFSalaryDeduction();
			  ClosingFD+=bci_FDSBean2.getClosingFD();
			  KSBCCostReceipt+=bci_FDSBean2.getKSBCCostReceipt();

			  Resumption+=bci_FDSBean2.getResumption();
			  ElectionRules+=bci_FDSBean2.getElectionRules();
			  MiscReceipts+=bci_FDSBean2.getMiscReceipts();
			  GOvtGrant+=bci_FDSBean2.getGOvtGrant();
			  VoterCD+=bci_FDSBean2.getVoterCD();
			  NominationForm+=bci_FDSBean2.getNominationForm();
			  ElectionDeposit+=bci_FDSBean2.getElectionDeposit();
			  PDC+=bci_FDSBean2.getPDC();
				 
				 
			}
			/* + "<th>ChangeOfAddress</th>"
				+ "<th>ComplaintFee</th>"
				+ "<th>NameOftheClient</th>"
				+ "<th>IdentityCard</th>"
				+ "<th>EnrollmentApplication</th>"
			*/
			 Session.close();
			// total=(long) (CertificateCopyCharges+PostageReceipts+DuplicateEnrollemt+EndomentCertificate+KSBCInterestONFD+
				/*	 DOBCertificate+ContinuityCertificate+VSP+ProcessFee+NOC+ChangeOfNamePublication+ChangeOfAddress+
					 ComplaintFee+IdentityCard+EnrollmentApplication+ReimbursementOFSalaryDeduction+
					 +ClosingFD+KSBCCostReceipt+Resumption+ElectionRules+MiscReceipts+GOvtGrant+VoterCD+NominationForm+
					 ElectionDeposit+PDC);*/
					 
					 
					
			 
			 long others=ContinuityCertificate+CertificateCopyCharges+DOBCertificate+PostageReceipts+PDC+EndomentCertificate+DuplicateEnrollemt+VoterCD+ElectionRules+NominationForm;
				
			 total=(long) (ChangeOfNamePublication+others+IdentityCard+EnrollmentApplication+ComplaintFee+ChangeOfAddress
					+ NOC+ProcessFee+Resumption+VSP+ElectionDeposit+MiscReceipts+KSBCCostReceipt+KSBCInterestONFD+ClosingFD
					 +ReimbursementOFSalaryDeduction+GOvtGrant+Certverificationfee);
			 Response+=
					  "<td><b>"+IdentityCard+"</b></td>"
							 + "<td><b>"+EnrollmentApplication+"</b></td>"
							 + "<td><b>"+ComplaintFee+"</b></td>"
							 + "<td><b>"+ChangeOfAddress+"</b></td>"
							 + "<td><b>"+ChangeOfNamePublication+"</b></td>"
							  + "<td><b>"+Certverificationfee+"</b></td>"
							
							 + "<td><b>"+NOC+"</b></td>"
							 + "<td><b>"+ProcessFee+"</b></td>"
							 + "<td><b>"+Resumption+"</b></td>"
							 	+ "<td><b> "+VSP+"</b></td>"
							 	+ "<td><b> "+others+"</b></td>"
							 + "<td><b>"+ElectionDeposit+"</b></td>"
							 + "<td><b> "+MiscReceipts+"</b></td>"
							 + "<td><b>"+KSBCCostReceipt+"</b></td>"
							 + "<td><b>"+KSBCInterestONFD+"</b></td>"
							 + "<td><b>"+ClosingFD+"</b></td>"
							 		+ "<td><b>"+ReimbursementOFSalaryDeduction+"</b></td>"
							 	+"<td><b>"+GOvtGrant+"</b></td>"
							 	
					
						 		
						 	/*	+ "<td><b>"+ChangeOfNamePublication+"</b></td>"*/
					
			   		
			 			;
					
					 long FinalTotal=(total+totalfromenr);
					 System.out.println(totalfromenr + "   total");
					 Response+= "<td><b>"+(FinalTotal)+"</b></td></tr>";
		 }
		 
			 
		 
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		/* Session.close();*/
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		
		return Response;
	}

	@Override
	public String GetMonthlyReportForKSBCEnrollFee(LocalDate Start, LocalDate End) {
		
		/* int EnrollmentFee;
		 int IdentityCard;
		 int miscRts;
		 int KsbcTrust;
		 int KawfMembershipFee;
		 int BciSubscription;
		 int fds;*/
		
		
//		long minutes = ChronoUnit.MINUTES.between(Start, End);
		String result="<table class='table table-bordered'><thead><tr><th>Date</th><th>EnrollmentFee</th><th>ID</th>"
   			  +  "<th>miscRts</th><th>KsbcTrust</th><th>"
   			  + "KawfMembershipFee</th> <th>BciSubscription</th><th>fds</th><th></th> "
   			  + " </tr>"
   			  +  " </thead>"
   			  +  "<tbody>";
		long days=ChronoUnit.DAYS.between(Start, End);
		LocalDate NewDate = null;
		for(int i=0;i<=days;i++)
		{
			 NewDate = Start.plusDays(i);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			 result  += JSPRelatedFunctionsimp.GetReportPerDateForKSBCEnrollFee(NewDate);
			
			System.out.println(NewDate + "  New Dates");
		}
		System.out.println(days + "   Diff btw start and end");
		result+=" </tbody> "+  "</table>";
		return result;
	}

	@Override
	public String GetReportPerDateForKSBCEnrollFee(LocalDate Start) {
		
		
		System.out.println("akshay");
		String Response="";
		EnrollmentNewMemberBean BCI_FDSBean = new EnrollmentNewMemberBean();
		int EnrollmentFee=0;
		 int IdentityCard=0;
		 int miscRts=0;
		 int KsbcTrust = 0;
		 int KawfMembershipFee=0;
		 int BciSubscription=0;
		 int Certverificationfee=0;
		 
		 int fds=0;
Long total=(long) 0;
			 java.sql.Timestamp ChallanCreatedDate = null ;
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from EnrollmentNewMemberBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<EnrollmentNewMemberBean> list = (ArrayList<EnrollmentNewMemberBean>)query.list();
		System.out.println(list + "   List from EnrollmentNewMemberBean");
			 

		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (EnrollmentNewMemberBean bci_FDSBean2 : list) {
				/* int Global_EnrollmentFee=0;
				 int Global_ksbcIdentityCard=0;
				 int Global_miscRts=0;
				 int Global_KsbcTrust = 0;
				 int Global_KawfMembershipFee=0;
				 int Global_BciSubscription=0;
				 int Global_fds=0;*/
				 Global_EnrollmentFee+= bci_FDSBean2.getEnrollmentFee();
				/* Global_ksbcIdentityCard+=bci_FDSBean2.getIdentityCard();
				 Global_miscRts+=bci_FDSBean2.getMiscRts();
				 Global_KsbcTrust+=bci_FDSBean2.getKsbcTrust();
				 Global_KawfMembershipFee+=bci_FDSBean2.getKawfMembershipFee();
				 Global_BciSubscription+=bci_FDSBean2.getBciSubscription();
				 Global_fds+=bci_FDSBean2.getFds();*/
				 Global_Certverificationfee+= bci_FDSBean2.getCertificateVerificationFee();
				 //Local
				 Certverificationfee+= bci_FDSBean2.getCertificateVerificationFee();
				 EnrollmentFee+= bci_FDSBean2.getEnrollmentFee();
				 IdentityCard+=bci_FDSBean2.getIdentityCard();
				 miscRts+=bci_FDSBean2.getMiscRts();
				 KsbcTrust+=bci_FDSBean2.getKsbcTrust();
				 KawfMembershipFee+=bci_FDSBean2.getKawfMembershipFee();
				 BciSubscription+=bci_FDSBean2.getBciSubscription();
				 fds+=bci_FDSBean2.getFds();
				
				 
				 
			}
			 total= (long) (EnrollmentFee+IdentityCard+miscRts);
			 Response=/*"<tr> "*/
			 		
			 	/*	"<td><b> "+Start+"</b></td>"*/
			 		 "<td><b>"+EnrollmentFee+"</b></td>"
			 	/*	+ "<td><b>"+IdentityCard+"</b></td>"
			 		+ "<td><b>"+miscRts+"</b></td>"
			 		+ "<td><b>"+KsbcTrust+"</b></td>"
			 		+ "<td><b>"+KawfMembershipFee+"</b></td>"
			 		+ "<td><b>"+BciSubscription+"</b></td>"
			 		+ "<td><b>"+fds+"</b></td>"*/
			 				/*+ "<td><b>"+total+"</b></td>"*/
			 			/*+ "</tr>"*/;
		 }
		 
			System.out.println(Certverificationfee + " Certverificationfee"); 
		 Response+="mor"+EnrollmentFee+"mor"+miscRts+"mor"+IdentityCard+"mor"+Certverificationfee;
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		
		return Response;
	}

	@Override
	public String GetMonthlyReportForIndividualStampingFee(LocalDate Start, LocalDate End) {
		
		/* private int Stampfee;*/
		
		
//		long minutes = ChronoUnit.MINUTES.between(Start, End);
		String result="<table class='table table-bordered'><thead><tr><th>Date</th><th>Stamp fee</th><th>Total</th>"
   			 + " </tr>"
   			  +  " </thead>"
   			  +  "<tbody>";
		long days=ChronoUnit.DAYS.between(Start, End);
		LocalDate NewDate = null;
		for(int i=0;i<=days;i++)
		{
			 NewDate = Start.plusDays(i);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			 result  += JSPRelatedFunctionsimp.GetReportPerDateForIndividualStampingFee(NewDate);
			
			System.out.println(NewDate + "  New Dates");
		}
		System.out.println(days + "   Diff btw start and end");
		result+=" </tbody> "+  "</table>";
		result+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
		return result;
	}

	@Override
	public String GetReportPerDateForIndividualStampingFee(LocalDate Start) {
		
		String Response="";
		
		EnrollmentNewMemberBean BCI_FDSBean = new EnrollmentNewMemberBean();
		int Stampfee=0;
	
Long total=(long) 0;
			 java.sql.Timestamp ChallanCreatedDate = null ;
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from IndividualStampBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<IndividualStampBean> list = (ArrayList<IndividualStampBean>)query.list();
		System.out.println(list + "   List from IndividualStampBean");
			 

		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (IndividualStampBean bci_FDSBean2 : list) {
				
				
				/* Global_Stampfee+= bci_FDSBean2.getStampfee(); */
				 // Local
				 Stampfee+= bci_FDSBean2.getStampfee();
				 
				 
				 
			}
			 total=	 (long) Stampfee;
			 Response="<tr> "
			 		
			 		+ "<td><b> "+Start+"</b></td>"
			 		+ "<td><b>"+Stampfee+"</b></td>"
			 		+ "<td><b>"+Stampfee+"</b></td>"
			 			+ "</tr>";
		 }
		 
			 
		 
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		Response=Stampfee+"";  // changed for welfare account
		return Response;
	}

	@Override
	public String GetMonthlyReportForAssociateStampingFee(LocalDate Start, LocalDate End) {
		
		/* private int Stampfee;
		 * 
		 * 	private int PostalCharges;*/
		
		
//		long minutes = ChronoUnit.MINUTES.between(Start, End);
		String result="<table class='table table-bordered'><thead><tr><th>Date</th><th>Stamp fee</th><th>PostalCharges</th>"
   			 + " </tr>"
   			  +  " </thead>"
   			  +  "<tbody>";
		long days=ChronoUnit.DAYS.between(Start, End);
		LocalDate NewDate = null;
		for(int i=0;i<=days;i++)
		{
			 NewDate = Start.plusDays(i);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			 result  += JSPRelatedFunctionsimp.GetReportPerDateForAssociateStampingFee(NewDate);
			
			System.out.println(NewDate + "  New Dates");
		}
		System.out.println(days + "   Diff btw start and end");
		result+=" </tbody> "+  "</table>";
		result+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
		return result;
	}

	@Override
	public String GetReportPerDateForAssociateStampingFee(LocalDate Start) {
		
		String Response="";
		
		AssociationStampBean BCI_FDSBean = new AssociationStampBean();
		int Stampfee=0;
		int PostalCharges=0;
		long total=0;
			 java.sql.Timestamp ChallanCreatedDate = null ;
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from AssociationStampBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<AssociationStampBean> list = (ArrayList<AssociationStampBean>)query.list();
		System.out.println(list + "   List from IndividualStampBean");
			 

		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (AssociationStampBean bci_FDSBean2 : list) {
				 
				 /*Global_AssociationStampfee+= bci_FDSBean2.getStampfee();
				 Global_PostalCharges+=bci_FDSBean2.getPostalCharges();*/
			//Local	 
				 
				 Stampfee+= bci_FDSBean2.getStampfee();
				 PostalCharges+=bci_FDSBean2.getPostalCharges();
				 
				 
			}
			 total=Stampfee+PostalCharges;
			 Response="<tr> "
			 		
			 		+ "<td><b> "+Start+"</b></td>"
			 		+ "<td><b>"+Stampfee+"</b></td>"
			 				+ "<td><b>"+PostalCharges+"</b></td>"
			 				+ ""
			 			+ "</tr>";
		 }
		 
			 
		 
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		Response=total+"";
		return Response;
	}

	@Override
	public String InsertIntoWelfarePayments(String EnrollmentId, int ReceiptTransactionId,
			int WelfareFundInstallmentNo, int FromYear, int ToYear, BigDecimal AmountPaid, Timestamp AmountPaidOn,
			int ReceiptNo, Timestamp ReceiptDate) {
		
		
		
		
		
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "INSERT INTO [dbo].[Enrollment_WelfareFundPayments] "
         +"  ([EnrollmentId] "
          +"  ,[ReceiptTransactionId] "
          +"  ,[WelfareFundInstallmentNo] "
        		   +"  ,[FromYear] "
          +"  ,[ToYear] "
        		   +"  ,[AmountPaid] "
          +"  ,[AmountPaidOn] "
          +"  ,[ReceiptNo] "
          +"  ,[ReceiptDate]) "
     +" VALUES "
       +"     (?"
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"   ,?) ";
			      
			      
			      
			    /*  
			        +"     +"     (<EnrollmentId, nvarchar(50),>
        +"    ,<ReceiptTransactionId, int,>
        +"    ,<WelfareFundInstallmentNo, int,>
        +"    ,<FromYear, int,>
			      +"    ,<ToYear, int,>
        +"    ,<AmountPaid, numeric(16,2),>
         +"   ,<AmountPaidOn, datetime,>
          +"  ,<ReceiptNo, varchar(50),> "
         +"   ,<ReceiptDate, varchar(50),>)  ";
			      
		          */
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, EnrollmentId);
		PrepareStateMent.setInt(2, ReceiptTransactionId);   
		PrepareStateMent.setInt(3, WelfareFundInstallmentNo); 
		PrepareStateMent.setInt(4, FromYear); 
		PrepareStateMent.setInt(5, ToYear); 
		PrepareStateMent.setBigDecimal(6, AmountPaid); 
		PrepareStateMent.setTimestamp(7, AmountPaidOn); 
		PrepareStateMent.setInt(8, ReceiptNo); 
		PrepareStateMent.setTimestamp(9, ReceiptDate); 
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
	    System.out.println(ts1 + "Current Time");
		// PrepareStateMent.setTimestamp(10, ts1);
	//	PrepareStateMent.setString(7, EnteredBy); 
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming Inserted Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String updateStatus(String KARNumber, String Status) {
		
		return null;
	}

	@Override
	public String UpdateToLifeTimeMemberShip(String KARNumber) {
		 LocalDate today1 = LocalDate.now();
		 java.util.Date date = Date.from(today1.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
		
		
		
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "UPDATE [dbo].[EnrollmentDetails] "
			      		+ "  SET   [WelfareLifeTimeMember] = 'Y'"
			      		+ " ,    [SeniorMemberUpdatedDate] =?"  
			      		
			      		+ "  WHERE RollNo=?";
			      
			      
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
			   PrepareStateMent.setTimestamp(1, timeStamp);
		PrepareStateMent.setString(2, KARNumber);
		
		
	
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming Update Life Time  Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String UpdateToWelfareMemberShip(String KARNumber) {
		
		
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
		
		
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
					      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "UPDATE [dbo].[EnrollmentDetails] "
			      		+ "  SET   [WelfareMember] = 'Y'"
			      		+ ",  [WelfareMemberUpdatedDate] =?"
			      		+ "  WHERE RollNo=?";
			      
			      
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(2, KARNumber);
		PrepareStateMent.setTimestamp(1, ts1);
		
	
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming UpdateWelfare Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String ChangeAddressInEnrollment(String KARNumber, String Address,String Remarks, String statusOfTheAdvocate) {
		
		System.out.println(KARNumber + "KARNumber");
		System.out.println(Address + "Address");
		System.out.println(Remarks + "Remarks");
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
		
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		String Preremarks = JSPRelatedFunctionsimp.GetRemarks(KARNumber);
		
		if (Preremarks==null)
		{
			Preremarks="";
		}
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
		/*	String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "UPDATE [dbo].[EnrollmentDetails] "
				      		+ "SET   [Communication_Address1] = ?"
				      		+ ",   [Communication_Address2] = ?"
				      		+ ",   [Communication_Address3] = ?"
				      		+ ",   [Place_Of_Practice] = ?"
				      		
				      		+ ", [Remarks] = ?"
				      		
				      		+ "  WHERE RollNo=?";
				      
				      
				
				   
				   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
				   PrepareStateMent.setString(1, Address);
				   PrepareStateMent.setString(2, "");
				   PrepareStateMent.setString(3, "");
				   PrepareStateMent.setString(3, "");
			PrepareStateMent.setString(4, statusOfTheAdvocate);
			PrepareStateMent.setString(5, (Preremarks+", "+Remarks));
			PrepareStateMent.setString(6, KARNumber);
			   
			  
		// int rs=1;
	
			      int rs = PrepareStateMent.executeUpdate();
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming Update Life Time  Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		
		System.out.println(responseString);
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String ChangeNomineeName(String KARNumber, String Naminee,String Remarks) {
		
		
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
		
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		String Preremarks = JSPRelatedFunctionsimp.GetRemarks(KARNumber);
		
		if (Preremarks==null)
		{
			Preremarks="";
		}
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "UPDATE [dbo].[EnrollmentDetails] "
				      		+ "SET   [Nominee_Name] = ?"
				      		+ ", [Remarks] = ?"
				      		+ "WHERE RollNo=?";
				      
				   String remarksPrivious = JSPRelatedFunctionsimp.GetRemarks(KARNumber);
				
				   if(remarksPrivious==null)
				   {
					   remarksPrivious="";
				   }
				   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
				   PrepareStateMent.setString(1, Naminee);
			PrepareStateMent.setString(2, (remarksPrivious+", "+Remarks));
			PrepareStateMent.setString(3, KARNumber);
			
	
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming Update Life Time  Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String ChangeTheEnrollmentName(String KARNumber, String NameChange,String Remarks) {
		
		
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
	    JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
	    String remarksPrivious = JSPRelatedFunctionsimp.GetRemarks(KARNumber);
		
		   if(remarksPrivious==null)
		   {
			   remarksPrivious="";
		   }
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "UPDATE [dbo].[EnrollmentDetails] "
			      		+ "SET   [Name] = ?"
			      		+ ", [Remarks] = ?"
			      		+ " WHERE RollNo=?";
			      
			      
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
			   PrepareStateMent.setString(1, NameChange);
				PrepareStateMent.setString(2, (remarksPrivious+", "+Remarks));
		PrepareStateMent.setString(3, KARNumber);
		
		
	
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming Update Life Time  Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String UpdateClimReport(LocalDate ClaimDate, String KARNumber, String Name, String Place, String ClaimType,
			String ClaimAmount, String Remarks, String ResolutionNumber, LocalDate ResolutionDate) {
		
		
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
		
		System.out.println(ClaimType + "claimtype");
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "INSERT INTO [dbo].[Enrollment_WelfareFundClaims] "
          +" ([EnrollmentId] "
          +"  ,[EDate] "
          +"  ,[ApplicantName] " 
          +"  ,[ClaimAmount] "
          +"  ,[Description] "
          +"  ,[OrderNo] "
          +"  ,[OrderDate] "
          +"  ,[DeathDate] "
         +"   ,[City] "
         +"   ,[State] "
         +"   ,[Pincode] "
        +"    ,[RetirmentDate] "
         +"   ,[RetiredReason] "
         +"   ,[status] "
        		   +"   ,[PaidStatus] "
         +"   ,[ApplicationDate] "
        +"    ,[BCMResolutionNo] "
        +"    ,[BCMResolutionDate]) "
  +"    VALUES "
        +"    (? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? "
        +"    ,? )";


			      
			  /*    "    VALUES "
			        +"    (<EnrollmentId, varchar(50),> "
			        +"    ,<EDate, datetime,> "
			        +"    ,<ApplicantName, varchar(200),> "
			         +"   ,<ClaimAmount, numeric(16,2),> " 
			         +"   ,<Description, varchar(500),> "
			        +"    ,<OrderNo, varchar(100),> "
			        +"    ,<OrderDate, datetime,> "
						      +"   ,<DeathDate, datetime,> "
			        +"    ,<City, nvarchar(100),> "
			       +"     ,<State, int,> "
						      +"     ,<Pincode, nvarchar(50),> "
			       +"     ,<RetirmentDate, datetime,> "
			        +"    ,<RetiredReason, tinyint,> "
			        +"    ,<status, char(1),> "
			         +"   ,<PaidStatus, char(1),> "
						      +"   ,<ApplicationDate, datetime,> "
			        +"    ,<BCMResolutionNo, varchar(500),> "
			        +"    ,<BCMResolutionDate, datetime,>)";*/
			      
			      Timestamp ClaimDateTimeStamp = Timestamp.valueOf(ClaimDate.atStartOfDay());   
			      Timestamp ResolutionDateTimeStamp = Timestamp.valueOf(ResolutionDate.atStartOfDay());     
			      
/*ClaimDate
 * 
 * 
 * Timestamp timestamp = Timestamp.valueOf(localDate.atStartOfDay());
 * */     
			BigDecimal Climamt = new  java.math.BigDecimal(ClaimAmount);
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
			  // PrepareStateMent.setString(1, NameChange);
		PrepareStateMent.setString(1, KARNumber);
		
		PrepareStateMent.setString(2, null);
		PrepareStateMent.setString(3, "");
		PrepareStateMent.setBigDecimal(4, Climamt);
		
		PrepareStateMent.setString(5, Remarks);
		PrepareStateMent.setString(6, ResolutionNumber);
		PrepareStateMent.setTimestamp(7, ClaimDateTimeStamp);
		
		PrepareStateMent.setString(8, null);
		PrepareStateMent.setString(9, null);
		PrepareStateMent.setString(10, null);
		PrepareStateMent.setString(11, null);
		PrepareStateMent.setString(12, null);
		PrepareStateMent.setString(13, null);
		PrepareStateMent.setString(14, ClaimType);
		PrepareStateMent.setString(15, null);
		PrepareStateMent.setString(16, null);
		PrepareStateMent.setString(17, ResolutionNumber);
		
		PrepareStateMent.setTimestamp(18, ResolutionDateTimeStamp);
		
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming Update Life Time  Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String UpdateNomineeDetails(String KARNumber, String Remarks, String Nominee, String Relationship) {
		
		
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
		
	    System.out.println(Nominee + " Jagga");
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			System.out.println(Nominee + " Jagga");
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "UPDATE [dbo].[EnrollmentDetails] "
			      		+ "  SET   [Nominee_Name] = ?"
			      		+ ",  [Relationship] =?"   
			      		+ ",  [Remarks] =?" 
			      		+ "  WHERE RollNo=?";
			      
			      
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, Nominee);
		PrepareStateMent.setString(2, Relationship);
		PrepareStateMent.setString(3, Remarks);
		PrepareStateMent.setString(4, KARNumber);
	
	
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming UpdateWelfare Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String UpdateEnrollment(EnrollmentDetails EnrollmentDetails) {
		System.out.println(EnrollmentDetails);
		
		//	System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
			String OutputResult="not working";
			int resultoutput=0;
			Connection conn = null;
			String responseString = " Error while processing please try again later ";
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
					System.out.println("Driver name: " + dm.getDriverName());
					System.out.println("Driver version: " + dm.getDriverVersion());
					System.out.println("Product name: " + dm.getDatabaseProductName());
					System.out.println("Product version: " + dm.getDatabaseProductVersion());
					
					System.out.println("Product version: " + dm.getUserName());	
					
					System.out.println("Product version: " );	
				//	 java.sql.Statement stmt = conn.createStatement();
					
				      String sql;
				      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
				      sql = " UPDATE [dbo].[EnrollmentDetails] SET"
				    		
				    		 
				    		  +" [RollNo]=? "
				    		        +"   ,[EnrollNo]=?"
				    		        +"   ,[EnrollmentRegistrationNo]=?"
				    		         +"  ,[CertificateNo]=?"
				    		         +"  ,[TitleId]=?"
				    		        +"   ,[Name]=?"
				    		        +"   ,[Gender]=?"
				    		        +"   ,[Father_Title]=?"
				    		        		   +"   ,[FatherName]=?"
				    		        +"   ,[DateOfBirth]=?"
				    		       +"    ,[BloodGroup]=?"
				    		        +"   ,[CategoryId]=?"
				    		         +"  ,[Communication_Address1]=?"
				    		        +"  ,[Communication_Address2]=?"
				    		        +"   ,[Communication_Address3]=?"
				    		       +"    ,[Communication_City]=?"
				    		        +"   ,[Communication_State]=?"
				    		        +"   ,[Communication_PinCode]=?"
				    		        +"   ,[Permanent_Address1]=?"
				    		         +"  ,[Permanent_Address2]=?"
				    		         +"  ,[Permanent_Address3]=?"
				    		         +"  ,[Permanent_PinCode]=?"
				    		        +"   ,[Permanent_City]=?"
				    		         +"  ,[Permanent_State]=?"
				    		         +"  ,[Nominee_Title]=?"
				    		        +"   ,[Nominee_Name]=?"
				    		        +"   ,[IsMinor]=?"
				    		        +"   ,[GuardianName]=?"
				    		        +"   ,[Relationship]=?"
				    		        +"   ,[Nominee_Address1]=?"
				    		        		   +"   ,[Nominee_Address2]=?"
				    		        +"   ,[Nominee_Address3]=?"
				    		        +"   ,[Nominee_City]=?"
				    		        +"   ,[Nominee_State]=?"
				    		        +"   ,[Nominee_PinCode]=?"
				    		        		   +"   ,[PracticeCategory]=?"
				    		         +"  ,[EMail]=?"
				    		         +"  ,[Phone_Res]=?"
				    		        +"   ,[Phone_Off]=?"
				    		        +"   ,[MobileNo]=?"
				    		        +"   ,[Remarks]=?"
				    		        +"   ,[EnrollmentStatus]=?" 
				    		        +"   ,[EnrollmentSource]=?"
				    		        		   +"   ,[WelfareMember]=?"
				    		         +"  ,[EnrollmentDate]=?"
				    		       +"    ,[Place_Of_Practice]=?"
				    		        +"   ,[WelfareMemberUpdatedDate]=?"
				    		        +"   ,[SeniorMember]=?"
				    		       +"    ,[SeniorMemberUpdatedDate]=?"
				    		        		   +"    ,[enr_Year]=?"
				    		       +"    ,[enr_Month]=?"
				    		       +"    ,[enr_Days]=?"
				    		        +"   ,[SeniorAdvocate]=?"
				    		        +"   ,[SeniorAdvocateUpdatedDate]=?"
				    		        +"   ,[CertificateStatus]=?" 
				    		        +"   ,[CertificateIssued]=?"
				    		        +"   ,[CertificateIssuedOn]=?"
				    		        +"   ,[ManagerApproved]=?"
				    		       +"    ,[NomineeVerified]=?"
				    		        +"   ,[ApplnForm]=?"
				    		        +"   ,[WelfareLifeTimeMember]=? ";
	   
				      
	System.out.println(EnrollmentDetails.getRollNo());
				   
				   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
			//	   PrepareStateMent.setInt(1, 1); 
				   
				   
			PrepareStateMent.setString(1, ""); // rollNumber
			PrepareStateMent.setString(2, EnrollmentDetails.getEnrollNo());
			PrepareStateMent.setString(3, EnrollmentDetails.getEnrollmentRegistrationNo());   
			PrepareStateMent.setString(4, EnrollmentDetails.getCertificateNo()); 
			PrepareStateMent.setInt(5, EnrollmentDetails.getTitleId()); 
			PrepareStateMent.setString(6, EnrollmentDetails.getName()); 
			
			PrepareStateMent.setString(7, EnrollmentDetails.getGender()+"");
			PrepareStateMent.setInt(8,EnrollmentDetails.getFather_Title());
			PrepareStateMent.setString(9, EnrollmentDetails.getFatherName());
			
			
			
			PrepareStateMent.setTimestamp(10, EnrollmentDetails.getDateOfBirth());   
			PrepareStateMent.setString(11, EnrollmentDetails.getBloodGroup()); 
			PrepareStateMent.setShort(12, EnrollmentDetails.getCategoryId()); 
			PrepareStateMent.setString(13, EnrollmentDetails.getCommunication_Address1()); 
			PrepareStateMent.setString(14, EnrollmentDetails.getCommunication_Address2());
			PrepareStateMent.setString(15, EnrollmentDetails.getCommunication_Address3());
			
			PrepareStateMent.setString(16, EnrollmentDetails.getCommunication_City()); 
			PrepareStateMent.setShort(17, EnrollmentDetails.getCommunication_State());
			PrepareStateMent.setString(18, EnrollmentDetails.getCommunication_PinCode());
			
			
			PrepareStateMent.setString(19, EnrollmentDetails.getPermanent_Address1()); 
			PrepareStateMent.setString(20, EnrollmentDetails.getPermanent_Address2());
			PrepareStateMent.setString(21, EnrollmentDetails.getPermanent_Address3());
			
			PrepareStateMent.setString(22, EnrollmentDetails.getPermanent_PinCode());
			
			PrepareStateMent.setString(23, EnrollmentDetails.getPermanent_City());
			
			PrepareStateMent.setShort(24, EnrollmentDetails.getPermanent_State());
			PrepareStateMent.setInt(25,EnrollmentDetails.getNominee_Title());
			PrepareStateMent.setString(26, EnrollmentDetails.getNominee_Name());
			PrepareStateMent.setString(27, EnrollmentDetails.getIsMinor()+"");
			
			PrepareStateMent.setString(28, EnrollmentDetails.getGuardianName()); 
			PrepareStateMent.setString(29, EnrollmentDetails.getRelationship());
			PrepareStateMent.setString(30, EnrollmentDetails.getNominee_Address1());
			
			PrepareStateMent.setString(31, EnrollmentDetails.getNominee_Address2());
			
			PrepareStateMent.setString(32, EnrollmentDetails.getNominee_Address3());
			
			PrepareStateMent.setString(33, EnrollmentDetails.getNominee_City());
			
			
			PrepareStateMent.setShort(34, EnrollmentDetails.getNominee_State());
			
			
			PrepareStateMent.setString(35, EnrollmentDetails.getNominee_PinCode());
			
			
			
			
			
			PrepareStateMent.setShort(36, EnrollmentDetails.getPracticeCategory());
			
			PrepareStateMent.setString(37, EnrollmentDetails.getEMail());
			PrepareStateMent.setString(38, EnrollmentDetails.getPhone_Res());
			
			PrepareStateMent.setString(39, EnrollmentDetails.getPhone_Off());
			
			PrepareStateMent.setString(40, EnrollmentDetails.getMobileNo());
			
			PrepareStateMent.setString(41, EnrollmentDetails.getRemarks());
			
			PrepareStateMent.setString(42, EnrollmentDetails.getEnrollmentStatus()+"");
			
			PrepareStateMent.setString(43, EnrollmentDetails.getEnrollmentSource()+"");
			PrepareStateMent.setString(44, EnrollmentDetails.getWelfareMember()+"");
			PrepareStateMent.setTimestamp(45, EnrollmentDetails.getEnrollmentDate());
			
			PrepareStateMent.setString(46, EnrollmentDetails.getPlace_Of_Practice());
			PrepareStateMent.setTimestamp(47, EnrollmentDetails.getWelfareMemberUpdatedDate());
			PrepareStateMent.setString(48, EnrollmentDetails.getSeniorMember()+"");
			PrepareStateMent.setTimestamp(49, EnrollmentDetails.getSeniorMemberUpdatedDate());
			PrepareStateMent.setBigDecimal(50, EnrollmentDetails.getEnr_Year());
			PrepareStateMent.setBigDecimal(51, EnrollmentDetails.getEnr_Month());
			PrepareStateMent.setBigDecimal(52, EnrollmentDetails.getEnr_Days());
			
			PrepareStateMent.setString(53, EnrollmentDetails.getSeniorAdvocate()+"");
			PrepareStateMent.setTimestamp(54, EnrollmentDetails.getSeniorAdvocateUpdatedDate());
			
			PrepareStateMent.setString(55, EnrollmentDetails.getCertificateStatus()+"");
			PrepareStateMent.setString(56, EnrollmentDetails.getCertificateIssued()+"");
			PrepareStateMent.setTimestamp(57, EnrollmentDetails.getCertificateIssuedOn());
			
			PrepareStateMent.setString(58, EnrollmentDetails.getManagerApproved()+"");
			PrepareStateMent.setString(59, EnrollmentDetails.getNomineeVerified()+"");
			PrepareStateMent.setString(60, EnrollmentDetails.getApplnForm()+"");
			PrepareStateMent.setString(61, EnrollmentDetails.getWelfareLifeTimeMember()+"");
		
		//	PrepareStateMent.setString(61, EnrollmentDetails.getWelfareLifeTimeMember()+"");
		/*	PrepareStateMent.setBigDecimal(6, AmountPaid); 
			PrepareStateMent.setTimestamp(7, AmountPaidOn); 
			PrepareStateMent.setString(8, ReceiptNo); 
			PrepareStateMent.setString(9, ReceiptDate); */
			/*java.util.Date today = new java.util.Date();
		    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
		    System.out.println(ts1 + "Current Time");
			PrepareStateMent.setTimestamp(10, ts1);*/
		//	PrepareStateMent.setString(7, EnteredBy); 
				      int rs = PrepareStateMent.executeUpdate();
				  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
				      //STEP 5: Extract data from result set
				//      String responseString = "Not coming SOrry";
				    
				      
				      if (rs>0)
				      {
				    	  
				    	  System.out.println("Akshay Inserted");
				    	  responseString="Sucessfully Updated";	  
				      }
				      else
				      {
				    	  responseString="Error occured Please try again later";	
				      }
				     
				      PrepareStateMent.close();
				      conn.close();				
				    	
				}

			} catch (SQLException ex) {
				  responseString="Error occured Please try again later";	
				     ex.printStackTrace();
			} finally {
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		//	String responseString;
			return responseString;
		
		
		//	return "String ";
		}

	@Override
	public String UpdateChangeTheNominee(String KARNumber, String NomineeName, String RelationShip, String EnteredBy) {
		java.util.Date today = new java.util.Date();
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
	    System.out.println(ts1 + "Current Time");
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				System.out.println("Product version: " + dm.getUserName());	
				
				System.out.println("Product version: " );	
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " UPDATE [dbo].[Hst_Enrollment_Nominee] SET "
          +" [EnrollmentId]=? "
         +"  ,[ReceiptTransactionId]=?=? "
         +"  ,[ReceiptVoucherID]=? "
         +"  ,[ReceiptId]=? "
         +"  ,[Nominee_Title]=? "
        +"   ,[Nominee_Name]=? "
        +"  ,[IsMinor]=? "
       +"    ,[GuardianName]=? "
        +"   ,[Relationship]=? "
         +"  ,[Nominee_Address1]=? "
         +"  ,[Nominee_Address2]=? "
         +"  ,[Nominee_Address3]=? "
         +"  ,[Nominee_City]=? "
        +"   ,[Nominee_State]=? "
        +"   ,[Nominee_PinCode]=? "
        +"   ,[EnteredBy]=? "
        +"   ,[EnteredOn]=? ";
   
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber.trim());
		PrepareStateMent.setInt(2, 0);   
		PrepareStateMent.setInt(3, 0); 
		PrepareStateMent.setInt(4, 0); //ReceiptId
		PrepareStateMent.setInt(5, 0); //Nominee_Title
		PrepareStateMent.setString(6, NomineeName); 
		PrepareStateMent.setString(7, "N");
		PrepareStateMent.setString(8,""); //GuardianName
		PrepareStateMent.setString(9,RelationShip);//Relationship
		PrepareStateMent.setString(10,"");//Nominee_Address1
		PrepareStateMent.setString(11,"");
		PrepareStateMent.setString(12,"");
		PrepareStateMent.setString(13,""); //Nominee_City
		Short Nominee_State=0;
		PrepareStateMent.setShort(14, Nominee_State);
		PrepareStateMent.setString(15, "");
		PrepareStateMent.setString(16, EnteredBy);
		
		PrepareStateMent.setTimestamp(17, ts1);
		
		  int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			   if (rs>0)
				  
			   {
				   PrepareStateMent.close();
				      conn.close();				
				    
				  return "SuccessFully Inserted"; 
			   }
			   
			   else
			   {
				   PrepareStateMent.close();
				      conn.close();				
				    
				   return "False"; 
			   }
			 	
			      //STEP 6: Clean-up environment
			      
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return responseString;
	
	
	}

	@Override
	public String GenerateElectionReport(String PlaceOfPractice, String CastCategory,
			String GenderCategory) {
		
	/*	java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
	*/	Connection con = null;
		String responseString = " Error while processing please try again later ";
		
		try 
		{
			System.out.println("********* GenerateAdmissionReport 123 ***************");
			 PreparedStatement PrepareStateMent = null; 
		/*Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		Query query = null;*/
			
			String OutputResult="not working";
			int resultoutput=0;
			Connection conn = null;
			
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				//	 java.sql.Statement stmt = conn.createStatement();
					
				      String sql;
			
				
			
			
			
			
		if (PlaceOfPractice.equalsIgnoreCase("All"))
		{
			// No need to query on PlaceOFpractice
			if (GenderCategory.equalsIgnoreCase("All"))
			{
			
				// GenderCategory
				
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					// coming
					System.out.println("Coming Here All");
				sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;
					
			 PrepareStateMent = conn.prepareStatement(sql);
		/*		PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
				*/
	
				}
				
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					// coming
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails   CategoryId=1 ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;

					/* query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.castCategory =:Nominee )");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate1); 
					query.setString("Nominee", "General");
*/		
					
					 PrepareStateMent = conn.prepareStatement(sql);
					/*	PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);*/
					/*	PrepareStateMent.setString(3, "General");*/
				
				
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{	
					// coming
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails WHERE  CategoryId=2 ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;
				
					
					 PrepareStateMent = conn.prepareStatement(sql);
					/*	PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);*/
						/*PrepareStateMent.setString(3, "SC ST");*/
				}
				
				
			} // GenderCategory all ends
			else if (GenderCategory.equalsIgnoreCase("Male"))
			{
				
// CastCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					// coming
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails WHERE  Gender='M' ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;

						
						PrepareStateMent = conn.prepareStatement(sql);
						/*PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);*/
						/*PrepareStateMent.setString(3, "Male");*/
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails WHERE  (Gender='M') AND (CategoryId=1)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;

				PrepareStateMent = conn.prepareStatement(sql);
				/*PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);*/
				/*PrepareStateMent.setString(3, "Male");
				PrepareStateMent.setString(4, "General");*/
					
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails WHERE  (Gender='M') AND (CategoryId=2)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
				
					PrepareStateMent = conn.prepareStatement(sql);
					/*PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);*/
					/*PrepareStateMent.setString(1, "Male");
					PrepareStateMent.setString(4, "SC ST");*/
					
					
				}
				
			}  // GenderCategory Male
			else if (GenderCategory.equalsIgnoreCase("Female"))
			{
// GenderCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails WHERE  (Gender='F') ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

				
						PrepareStateMent = conn.prepareStatement(sql);
//						PrepareStateMent.setTimestamp(1,StartDate1);
//						PrepareStateMent.setTimestamp(2, EndDate1);
						/*PrepareStateMent.setString(3, "Male");*/
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails WHERE  (Gender='F') AND (CategoryId=1) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
				

				PrepareStateMent = conn.prepareStatement(sql);
//				PrepareStateMent.setTimestamp(1,StartDate1);
//				PrepareStateMent.setTimestamp(2, EndDate1);
		/*		PrepareStateMent.setString(3, "Male");
				PrepareStateMent.setString(4, "General");*/
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{	sql="SELECT EnrollmentDate,DateOfBirth,,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails WHERE  (Gender='F') AND (CategoryId=2) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
					/*PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);*/
				/*	PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "SC ST");*/
				}
				
				
			}  // GenderCategory Male
			
		}
		else
		{
			//  need to query on PlaceOFpractice
			if (GenderCategory.equalsIgnoreCase("All"))
			{
			
				// GenderCategory
				
				
				if (CastCategory.equalsIgnoreCase("All"))
				{	
					
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails WHERE  (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
					 PrepareStateMent = conn.prepareStatement(sql);
					/*	PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);*/
					PrepareStateMent.setString(1, PlaceOfPractice);
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE  (CategoryId=1) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					 PrepareStateMent = conn.prepareStatement(sql);
						/*PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);*/
					/*	PrepareStateMent.setString(3, "General");*/
						PrepareStateMent.setString(1, PlaceOfPractice);
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{ 
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE  (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
 
					 PrepareStateMent = conn.prepareStatement(sql);
						/*PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);*/
						/*PrepareStateMent.setString(3, "SC ST");*/
						PrepareStateMent.setString(1, PlaceOfPractice);
				}
				
				
			} // GenderCategory all ends
			else if (GenderCategory.equalsIgnoreCase("Male"))
			{
				
// CastCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE  (Gender='M') AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					 PrepareStateMent = conn.prepareStatement(sql);
//						PrepareStateMent.setTimestamp(1,StartDate1);
//						PrepareStateMent.setTimestamp(2, EndDate1);
					/*	PrepareStateMent.setString(3, "Male");*/
						PrepareStateMent.setString(3, PlaceOfPractice);
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{	sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE  (Gender='M')AND (CategoryId=1) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
				 PrepareStateMent = conn.prepareStatement(sql);
				/*	PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);*/
				/*	PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "General");*/
						PrepareStateMent.setString(1, PlaceOfPractice);
					
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{	
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE  (Gender='M')AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
				
					PrepareStateMent = conn.prepareStatement(sql);
					/*PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);*/
				/*	PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "SC ST");*/
						PrepareStateMent.setString(1, PlaceOfPractice);
					
				}
				
			}  // GenderCategory Male
			else if (GenderCategory.equalsIgnoreCase("Female"))
			{
// GenderCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
				
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE  (Gender='F') AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
					/*PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);*/
					/*PrepareStateMent.setString(3, "FeMale");*/
					PrepareStateMent.setString(1, PlaceOfPractice);
					
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					
					
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE  (Gender='F') AND (CategoryId=1) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
					/*PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);*/
					/*PrepareStateMent.setString(3, "FeMale");
					PrepareStateMent.setString(4, "General");*/
					PrepareStateMent.setString(1, PlaceOfPractice);	
		//SELECT RollNo,Name,Gender,FatherName,DateOfBirth,Permanent_City,WelfareMember
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					sql="SELECT EnrollmentDate,DateOfBirth,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE  (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
				/*	PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);*/
				/*	PrepareStateMent.setString(3, "FeMale");
					PrepareStateMent.setString(4, "SC ST");*/
					PrepareStateMent.setString(1, PlaceOfPractice);
				}
				
				
			}  // GenderCategory Male
			
		 // else download
		}
		
		ResultSet rs = PrepareStateMent.executeQuery();
		
	
		
		int Index=1;
		System.out.println();
		
 //sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE  (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
		responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
				+ "<h1><center><b>Enrollment Report </b></center></h1>";
		
	      responseString+="<table class='table table-bordered'><thead><tr><th>#</th><th>RollNo</th><th>Name</th>"
  			  +  "<th>EnrollmentRegistrationNo</th><th>Gender</th>"
  			+ "<th>Enrollment Date</th>"
  			  + "<th>DateOfBirth</th>"
  			  + "<th>Place Of Practice</th>"
  			  + "<th>Communication Address</th>"
  			  + " <th>Remarks</th> </tr>"
  			  +  " </thead>"
  			  +  "<tbody>";
	      String Gender="";
	      while(rs.next()){
	   	
	    /*	 rs.getString("RollNo");
	    	 rs.getString("Name");
	    	 rs.getString("Gender");
	    	 rs.getString("FatherName");*/
//	    	 rs.getString("DateOfBirth");
	    //	 rs.getString("Permanent_City");
	    	// rs.getString("WelfareMember");
	    	 String communication1="";
	    	 String communication2="";
	    	 String communication3="";
	    	 communication1=rs.getString("Communication_Address1");
	    	 communication2=rs.getString("Communication_Address2");
	    	 communication3=rs.getString("Communication_Address3");
	    	 String remarks="";
	    	 try
	    	 {
	    	 if(communication1==null)
	    	 {
	    		 communication1=""; 
	    	 }
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    		 communication1="";  
	    	 }
	    	 try
	    	 {
	    	   if(communication2==null)
	    	 {
	    		 communication2=""; 
	    	 }
	    	   
	      }
	    	 catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    		 communication2="";  
	    	 }
	    	 try
	    	 {
	    	   if(communication3==null)
		    	 {
		    		 communication3=""; 
		    	 }
	    	 }
	    	   catch(Exception e)
		    	 {
		    		 e.printStackTrace();
		    		 communication3="";  
		    	 }
		    	 try
		    	 {
	    	   remarks = rs.getString("Remarks");
	    	  if(remarks==null)
		    	 {
	    		  remarks=""; 
		    	 }
		    	 }
	    	  catch(Exception e)
		    	 {
		    		 e.printStackTrace();
		    		 remarks="";  
		    	 }
		    	
	   // 	 sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE  (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
		    	 Gender=rs.getString("Gender");
		    	 
		    	 if(Gender!=null && Gender.equalsIgnoreCase("M"))
		    	 {
		    		 Gender="Male"; 
		    	 }
		    	 if(Gender!=null && Gender.equalsIgnoreCase("F"))
		    	 {
		    		 Gender="Female";
		    	 }
		    	 
	    		 responseString +=  " <tr>"
						    +  "  <th scope='row'>"+Index+"</th>"
						    +  " <td><b> " +rs.getString("RollNo")+"</b></td>"
						     
							+  " <td><b> " +rs.getString("Name")+"</b></td>"
							+  " <td><b> " +rs.getString("EnrollmentRegistrationNo")+"</b></td>"
						
						/*	+  " <td><b> " +rs.getString("FatherName")+"</b></td>"*/
								+  " <td><b> " +Gender+"</b></td>"
								+  " <td><b> " +rs.getTimestamp("EnrollmentDate")+"</b></td>"
								+  " <td><b> " +rs.getTimestamp("DateOfBirth")+"</b></td>"
								+  " <td><b> " +rs.getString("Place_Of_Practice")+"</b></td>"
								+  " <td><b> " +(communication1+communication2+communication3)+"</b></td>"	
							/*	+  " <td><b> " +rs.getString("Communication_Address2")+"</b></td>"	
								+  " <td><b> " +rs.getString("Communication_Address3")+"</b></td>"	
						*/	/*+  " <td><b> " +rs.getString("Communication_Address1")+"</b></td>"	*/
							+  " <td><b> " +remarks+"</b></td>"	
							/*+  " <td><b> " +rs.getString("DateOfBirth")+"</b></td>"
							+  " <td><b> " +rs.getString("Permanent_City")+"</b></td>"
							+  " <td><b> " +rs.getString("WelfareMember")+"</b></td>"*/
						   
						     
				   +" </tr>"; 
				   Index++;
	      }
				   responseString+=	 " </tbody> "+  "</table><br></br><br></br>";
				   rs.close();
				      PrepareStateMent.close();
				      conn.close();
	
			 
		
			 
			
			}
				} // connection 
			
			catch (SQLException e)
			{
				e.printStackTrace();
				
			}
			
		}finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}}
		return responseString;
		
	}

	@Override
	public String DuplicateCertificate(String KARNumber, String FatherName, String Name, Timestamp EnrollmentDate,
			String REGNumber,int EnrollmentID) {
		
		 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		int SLNumber = JSPRelatedFunctionsimp.GetSLNumberofChairmanSignature(EnrollmentDate); 
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calobj = Calendar.getInstance();
           String dateString=(df.format(calobj.getTime()));
         String presentDate="";
          
         presentDate=convertDateToWords(dateString);
          
        String src="";
        String Privioussrc=JSPRelatedFunctionsimp.GetPhotoDetailsForWelfare(EnrollmentID);
      
       if(!Privioussrc.contains("Error"))
        {
            src=Privioussrc;  
        }
        else
        {
        	 src="ImageServlet?RegNumber="+REGNumber+"&WhichPhoto=Photo";
          
          
        }
       
      
        
     Date date1 = Date.valueOf(EnrollmentDate.toLocalDateTime().toLocalDate());  
        String dateString1=date1.toString();
        String date="";
 date=convertDateToWords(dateString1);
        String    resultString=""
                + "<head>"
                + "<style>"
                + ".watermark {"
                + " position: absolute;"
                + " opacity: 0.25;"
        + " font-size: 3em;"
        + " width: 100%;"
        + " text-align: center;"
        + " transform:rotate(300deg);"
       +" -webkit-transform:rotate(300deg);"
       + "font-family: Arial, Helvetica, sans-serif;"
                    +"font-size:40px;"
        + "}"
  
    +"   </style> "


    +"   </head> "
    +"   <body > "

    +"  <page> "
 
+"<h1> "
+"<div class=\"a\"></div> "
+"<div align=\"center\"><font face=\" Arial\" size=\"6px\">ENROLMENT CERTIFICATE</font></div></h1> "
//+"     <div align=\"center\" > <img src=\""+src+"\" alt=\"photo\"  width=\"120px\" height=\"120px\"/></div><br> "
  +"<br><br>"    
+"  <div align=\"center\"><font face=\" French Script MT\" size=\"6px\"> Reg. No. : "+REGNumber+"</font></div>"
+"  <div align=\"center\"><font face=\" French Script MT\" size=\"6px\"> Roll No. : "+KARNumber+"</font></div> "
       
 +"  <p align=\"center\"> <font face=\"French Script MT\" size=\"6px\">This is to certify that </font></p> "
 +"  <p align=\"center\"> <font face=\"French Script MT\" size=\"6px\">Shri/Smt "+"<font face=\" Arial\" size=\"5px\">"+Name+"</font></p> "
 +"    <div class=\"watermark\">DUPLICATE CERTIFICATE</div> "
 +"  <p align=\"center\"><font face=\"  French Script MT\" size=\"6px\">Son/Daughter of </font></p>"
 +"  <p align=\"center\"> <font face=\" Arial\" size=\"5px\"> "+FatherName+"</font></p> "
 +"  <p align=\"center\"><font face=\"  French Script MT\" size=\"6px\">is admitted as an Advocate on the Roll of Karnataka State</font></p> "
 +"  <p align=\"center\"><font face=\"  French Script MT\" size=\"6px\">Bar Council and Signed the Roll on</font> <font face=\" Arial\" size=\"5px\">"+date+"</font></p> "
 +"  <p align=\"center\"><font face=\"French Script MT\" size=\"6px\">Under Section 17 of the Advocates Act,1961</font></p> "
 + "  <p align=\"left\"><font face=\"Arial\" size=\"5px\"> Issue Date: "+presentDate+"</p>"   
   +"    <br></br> "
      
       
   

         
           +"    <div>  "  
      +"          <table id=page style=\"margin-left:55%; top:50% \"> "
    
             +"    <tr><td><font face=\" Arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sd/-</font></td></tr> "
      +"     <tr><td><font face=\" Arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Copy</font></td></tr> "
       +"    <tr><td><font face=\" Arial\">CHAIRMAN</font></td></tr>"
 
    
   
      +"    </table>  "
    +"      </div>   "
        
        
       
              



          +"  </body> "

   +" </html>";
                return resultString;
   }
	@Override
	public String GetReportPerDateForKSBCMiscFeeForBCI(LocalDate Start) {
		
		
		String Response="";
		EnrollmentNewMemberBean BCI_FDSBean = new EnrollmentNewMemberBean();
	/*	int EnrollmentFee=0;
		 int IdentityCard=0;
		 int miscRts=0;
		 int KsbcTrust = 0;
		 int KawfMembershipFee=0;*/
		 int BciSubscription=0;
		 int fds=0;
Long total=(long) 0;
			 java.sql.Timestamp ChallanCreatedDate = null ;
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from EnrollmentNewMemberBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<EnrollmentNewMemberBean> list = (ArrayList<EnrollmentNewMemberBean>)query.list();
			 

		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (EnrollmentNewMemberBean bci_FDSBean2 : list) {
				/* int Global_EnrollmentFee=0;
				 int Global_ksbcIdentityCard=0;
				 int Global_miscRts=0;
				 int Global_KsbcTrust = 0;
				 int Global_KawfMembershipFee=0;
				 int Global_BciSubscription=0;
				 int Global_fds=0;*/
			/*	 Global_EnrollmentFee+= bci_FDSBean2.getEnrollmentFee();
				 Global_ksbcIdentityCard+=bci_FDSBean2.getIdentityCard();
				 Global_miscRts+=bci_FDSBean2.getMiscRts();
				 Global_KsbcTrust+=bci_FDSBean2.getKsbcTrust();
				 Global_KawfMembershipFee+=bci_FDSBean2.getKawfMembershipFee();
				 Global_BciSubscription+=bci_FDSBean2.getBciSubscription();
				 Global_fds+=bci_FDSBean2.getFds();
				 
				 //Local
				 
				 EnrollmentFee+= bci_FDSBean2.getEnrollmentFee();
				 IdentityCard+=bci_FDSBean2.getIdentityCard();
				 miscRts+=bci_FDSBean2.getMiscRts();
				 KsbcTrust+=bci_FDSBean2.getKsbcTrust();
				 KawfMembershipFee+=bci_FDSBean2.getKawfMembershipFee();
				*/ BciSubscription+=bci_FDSBean2.getBciSubscription();
				 fds+=bci_FDSBean2.getFds();
				
				 
				 
			}
			 Response=/*"<tr> "*/
			 		
			 	/*	"<td><b> "+Start+"</b></td>"*/
			 		BciSubscription+"mor"
			 		+fds
			 				/*+ "<td><b>"+total+"</b></td>"*/
			 			/*+ "</tr>"*/;
		 }
		 
			 
		
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
	
		return Response;
	}

	@Override
	public String DeleteRecordFromChallanFlow(int ReceiptNo) {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from CashSectionMonthlyReportFlow where ReceiptNo = :ReceiptNo ");
		query.setParameter("ReceiptNo", ReceiptNo);
		 @SuppressWarnings("unchecked")
		ArrayList<CashSectionMonthlyReportFlow> list = (ArrayList<CashSectionMonthlyReportFlow>)query.list();
		 try
		 {
			 CashSectionMonthlyReportFlow ScheduleInterviewListBean= list.get(0);
		 Session.delete(ScheduleInterviewListBean);
		 
		 }
		 catch (Exception e)
		 {
			e.printStackTrace();
		 
		 }
		 
			 
			  
		 
		 
		 // Please do For all other paarameters
		
		  Session.beginTransaction().commit();
		 Session.close();
		 return "s";
		}
		catch (Exception e)
		{
			return "Failure";
		}
	
	}

	@Override
	public String MoveToScheduleInterviewListFromConfirmationBeanAll() {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleConfirmationBean ");
		
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleConfirmationBean> list = (ArrayList<ScheduleConfirmationBean>)query.list();
		 
		 for (ScheduleConfirmationBean ScheduleConfirmationBean : list) {
			 
			 ScheduleInterviewListBean ScheduleInterviewListBean= new ScheduleInterviewListBean();
			 ScheduleInterviewListBean.setRegNumber(ScheduleConfirmationBean.getRegNumber());
			 ScheduleInterviewListBean.setAddress(ScheduleConfirmationBean.getAddress());
			 ScheduleInterviewListBean.setAddressFromStep3(ScheduleConfirmationBean.getAddressFromStep3());
			 ScheduleInterviewListBean.setBirthdate(ScheduleConfirmationBean.getBirthdate());
			 ScheduleInterviewListBean.setBloodGroup(ScheduleConfirmationBean.getBloodGroup());
			 ScheduleInterviewListBean.setBusinessDetails(ScheduleConfirmationBean.getBusinessDetails());
			 ScheduleInterviewListBean.setCitizenOfIndia(ScheduleConfirmationBean.getCitizenOfIndia());
			 ScheduleInterviewListBean.setCity(ScheduleConfirmationBean.getCity());
			 ScheduleInterviewListBean.setCollege(ScheduleConfirmationBean.getCollege());
			 ScheduleInterviewListBean.setConvictedDetails(ScheduleConfirmationBean.getConvictedDetails());
			 ScheduleInterviewListBean.setDiscontinuanceOfPractice(ScheduleConfirmationBean.getDiscontinuanceOfPractice());
			 ScheduleInterviewListBean.setEmail(ScheduleConfirmationBean.getEmail());
			 ScheduleInterviewListBean.setFather_name(ScheduleConfirmationBean.getFather_name());
			 ScheduleInterviewListBean.setFirst_name(ScheduleConfirmationBean.getFirst_name());
			 ScheduleInterviewListBean.setFullName(ScheduleConfirmationBean.getFullName());
			 ScheduleInterviewListBean.setNomineeDetails(ScheduleConfirmationBean.getNomineeDetails());
			 ScheduleInterviewListBean.setNotAnClitizen(ScheduleConfirmationBean.getNotAnClitizen());
			 ScheduleInterviewListBean.setNotAnClitizen(ScheduleConfirmationBean.getNotAnClitizen());
			 ScheduleInterviewListBean.setOtherProfessional(ScheduleConfirmationBean.getOtherProfessional());
			 ScheduleInterviewListBean.setPendingCriminalCases(ScheduleConfirmationBean.getPendingCriminalCases());
			 ScheduleInterviewListBean.setPhone(ScheduleConfirmationBean.getPhone());
			 ScheduleInterviewListBean.setPlaceOfPractice(ScheduleConfirmationBean.getPlaceOfPractice());
			 ScheduleInterviewListBean.setPlaceOfPracticeFromStep2(ScheduleConfirmationBean.getPlaceOfPracticeFromStep2());
			 ScheduleInterviewListBean.setPreviousApplicationDetails(ScheduleConfirmationBean.getPreviousApplicationDetails());
			 ScheduleInterviewListBean.setPreviousEmployment(ScheduleConfirmationBean.getPreviousEmployment());
			 ScheduleInterviewListBean.setProportionOfShare(ScheduleConfirmationBean.getProportionOfShare());
			 ScheduleInterviewListBean.setRegNumber(ScheduleConfirmationBean.getRegNumber());
			 ScheduleInterviewListBean.setState(ScheduleConfirmationBean.getState());
			 ScheduleInterviewListBean.setTerminatedDetails(ScheduleConfirmationBean.getTerminatedDetails());
			 ScheduleInterviewListBean.setUniversity_Name(ScheduleConfirmationBean.getUniversity_Name());
			 ScheduleInterviewListBean.setYear_course(ScheduleConfirmationBean.getYear_course());
			 ScheduleInterviewListBean.setYear_of_Completion(ScheduleConfirmationBean.getYear_of_Completion());
			 ScheduleInterviewListBean.setZipCode(ScheduleConfirmationBean.getZipCode());
			 ScheduleInterviewListBean.setGenderCategory(ScheduleConfirmationBean.getGenderCategory());
			 ScheduleInterviewListBean.setCastCategory(ScheduleConfirmationBean.getCastCategory());
			 
			 // Please do For all other paarameters
			 Session.saveOrUpdate(ScheduleInterviewListBean);
			 Session.delete(ScheduleConfirmationBean);
			  Session.beginTransaction().commit();
		}
		// ScheduleConfirmationBean ScheduleConfirmationBean= list.get(0);
		
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	}

	@Override
	public String MoveToAbsentListFromScheduleListAll() {
		
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleInterviewListBean  ");
	
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleInterviewListBean> list = (ArrayList<ScheduleInterviewListBean>)query.list();
		 
		 for (ScheduleInterviewListBean RegistrationFormBean : list) {
			 AcceptedCandidate ScheduleBean= new AcceptedCandidate();
				// AbsentBean.setRegNumber(ScheduleBean.getRegNumber());
				 
				 ScheduleBean.setRegNumber(RegistrationFormBean.getRegNumber());
				 ScheduleBean.setAddress(RegistrationFormBean.getAddress());
				 ScheduleBean.setAddressFromStep3(RegistrationFormBean.getAddressFromStep3());
				 ScheduleBean.setBirthdate(RegistrationFormBean.getBirthdate());
				 ScheduleBean.setBloodGroup(RegistrationFormBean.getBloodGroup());
				 ScheduleBean.setBusinessDetails(RegistrationFormBean.getBusinessDetails());
				 ScheduleBean.setCitizenOfIndia(RegistrationFormBean.getCitizenOfIndia());
				 ScheduleBean.setCity(RegistrationFormBean.getCity());
				 ScheduleBean.setCollege(RegistrationFormBean.getCollege());
				 ScheduleBean.setConvictedDetails(RegistrationFormBean.getConvictedDetails());
				 ScheduleBean.setDiscontinuanceOfPractice(RegistrationFormBean.getDiscontinuanceOfPractice());
				 ScheduleBean.setEmail(RegistrationFormBean.getEmail());
				 ScheduleBean.setFather_name(RegistrationFormBean.getFather_name());
				 ScheduleBean.setFirst_name(RegistrationFormBean.getFirst_name());
				 ScheduleBean.setFullName(RegistrationFormBean.getFullName());
				 ScheduleBean.setNomineeDetails(RegistrationFormBean.getNomineeDetails());
				 ScheduleBean.setNotAnClitizen(RegistrationFormBean.getNotAnClitizen());
				 ScheduleBean.setNotAnClitizen(RegistrationFormBean.getNotAnClitizen());
				 ScheduleBean.setOtherProfessional(RegistrationFormBean.getOtherProfessional());
				 ScheduleBean.setPendingCriminalCases(RegistrationFormBean.getPendingCriminalCases());
				 ScheduleBean.setPhone(RegistrationFormBean.getPhone());
				 ScheduleBean.setPlaceOfPractice(RegistrationFormBean.getPlaceOfPractice());
				 ScheduleBean.setPlaceOfPracticeFromStep2(RegistrationFormBean.getPlaceOfPracticeFromStep2());
				 ScheduleBean.setPreviousApplicationDetails(RegistrationFormBean.getPreviousApplicationDetails());
				 ScheduleBean.setPreviousEmployment(RegistrationFormBean.getPreviousEmployment());
				 ScheduleBean.setProportionOfShare(RegistrationFormBean.getProportionOfShare());
				 ScheduleBean.setRegNumber(RegistrationFormBean.getRegNumber());
				 ScheduleBean.setState(RegistrationFormBean.getState());
				 ScheduleBean.setTerminatedDetails(RegistrationFormBean.getTerminatedDetails());
				 ScheduleBean.setUniversity_Name(RegistrationFormBean.getUniversity_Name());
				 ScheduleBean.setYear_course(RegistrationFormBean.getYear_course());
				 ScheduleBean.setYear_of_Completion(RegistrationFormBean.getYear_of_Completion());
				 ScheduleBean.setZipCode(RegistrationFormBean.getZipCode());
				 ScheduleBean.setGenderCategory(RegistrationFormBean.getGenderCategory());
				 ScheduleBean.setCastCategory(RegistrationFormBean.getCastCategory());
				 //arun123
				 // Please do For all other paarameters
				 Session.saveOrUpdate(ScheduleBean);
				 Session.delete(RegistrationFormBean);
				 Session.beginTransaction().commit();
		}
		
		
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	}

	@Override
	public ScheduleConfirmationBean GetKARNumberInfoForCertificateConfirmList(String KARNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleConfirmationBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", KARNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleConfirmationBean> list = (ArrayList<ScheduleConfirmationBean>)query.list();
		 Session.close();
		return list.get(0);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String MoveDataFromValidatedBeantoEnrollment() {
		
		
		Connection conn = null;
		try
		{
			
			
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		
		Query query = Session.createQuery("from ValidatedFinalBean");
	
		 @SuppressWarnings("unchecked")
		ArrayList<ValidatedFinalBean> list = (ArrayList<ValidatedFinalBean>)query.list();
		 
	//	 System.out.println(list.size() + "size of the array");
		 for (ValidatedFinalBean scheduleConfirmationBean : list) 
		 {
				
				 long PhoneNumberLong = scheduleConfirmationBean.getPhone();
				 Short Cast=1;
				 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
					  java.sql.Date datesql = scheduleConfirmationBean.getBirthdate();
				String Address =scheduleConfirmationBean.getAddress();
				
				String BloodGroup = scheduleConfirmationBean.getBloodGroup();
				
				String CastCategory = scheduleConfirmationBean.getCastCategory();
				if (CastCategory.equalsIgnoreCase("General"))
				{
					Cast=1;
				}
				else
				{
					Cast=2;	
				}
				String city = scheduleConfirmationBean.getCity();

				
			//	.setDiscontinuanceOfPractice(request.getParameter(arg0));
			
				String Father_name = scheduleConfirmationBean.getFather_name();
				// .setFullName(request.getParameter(arg0));
				String GenderCategory = scheduleConfirmationBean.getGenderCategory();
			
				// .setNotAnClitizen(request.getParameter(arg0));
				String email=(String) scheduleConfirmationBean.getEmail();
				
				
			//	.setPhone(request.getParameter(arg0));
				String PlaceOfPractice = scheduleConfirmationBean.getPlaceOfPractice();
			
			//	.setRegNumber(request.getParameter(arg0));
				String state = scheduleConfirmationBean.getState();
				String KARNumber =scheduleConfirmationBean.getKARNumber();
				String REG_Number =scheduleConfirmationBean.getRegNumber();
				
				
		int ZipCode = scheduleConfirmationBean.getZipCode();
				
			
		java.sql.Date date = scheduleConfirmationBean.getEnrolledDate();
		




//			System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " INSERT INTO [dbo].[EnrollmentDetails] "
			    		
			    		 
			    		  +"([RollNo] "
			    		        +"   ,[EnrollNo] "
			    		        +"   ,[EnrollmentRegistrationNo] "
			    		         +"  ,[CertificateNo] "
			    		         +"  ,[TitleId] "
			    		        +"   ,[Name] "
			    		        +"   ,[Gender] "
			    		        +"   ,[Father_Title] "
			    		        		   +"   ,[FatherName] "
			    		        +"   ,[DateOfBirth] "
			    		       +"    ,[BloodGroup] "
			    		        +"   ,[CategoryId] "
			    		         +"  ,[Communication_Address1] "
			    		        +"  ,[Communication_Address2] "
			    		        +"   ,[Communication_Address3] "
			    		       +"    ,[Communication_City] "
			    		        +"   ,[Communication_State] "
			    		        +"   ,[Communication_PinCode] "
			    		        +"   ,[Permanent_Address1] "
			    		         +"  ,[Permanent_Address2] "
			    		         +"  ,[Permanent_Address3] "
			    		         +"  ,[Permanent_PinCode] "
			    		        +"   ,[Permanent_City] "
			    		         +"  ,[Permanent_State] "
			    		         +"  ,[Nominee_Title] "
			    		        +"   ,[Nominee_Name] "
			    		        +"   ,[IsMinor] "
			    		        +"   ,[GuardianName] "
			    		        +"   ,[Relationship] "
			    		        +"   ,[Nominee_Address1] "
			    		        		   +"   ,[Nominee_Address2] "
			    		        +"   ,[Nominee_Address3] "
			    		        +"   ,[Nominee_City] "
			    		        +"   ,[Nominee_State] "
			    		        +"   ,[Nominee_PinCode] "
			    		        		   +"   ,[PracticeCategory] "
			    		         +"  ,[EMail] "
			    		         +"  ,[Phone_Res] "
			    		        +"   ,[Phone_Off] "
			    		        +"   ,[MobileNo] "
			    		        +"   ,[Remarks] "
			    		        +"   ,[EnrollmentStatus] " 
			    		        +"   ,[EnrollmentSource] "
			    		        		   +"   ,[WelfareMember] "
			    		         +"  ,[EnrollmentDate] "
			    		       +"    ,[Place_Of_Practice] "
			    		        +"   ,[WelfareMemberUpdatedDate] "
			    		        +"   ,[SeniorMember] "
			    		       +"    ,[SeniorMemberUpdatedDate] "
			    		        		   +"    ,[enr_Year] "
			    		       +"    ,[enr_Month] "
			    		       +"    ,[enr_Days] "
			    		        +"   ,[SeniorAdvocate] "
			    		        +"   ,[SeniorAdvocateUpdatedDate] "
			    		        +"   ,[CertificateStatus] " 
			    		        +"   ,[CertificateIssued] "
			    		        +"   ,[CertificateIssuedOn] "
			    		        +"   ,[ManagerApproved] "
			    		       +"    ,[NomineeVerified] "
			    		        +"   ,[ApplnForm] "
			    		        +"   ,[WelfareLifeTimeMember]) "
		+" VALUES "
		 +"   ('"+KARNumber+"'"
		 + ",'"+KARNumber+"'"   
		 + ",'"+REG_Number+"'"       
		        +"   ,null "
		        +"   ,null "
		        + ",'"+scheduleConfirmationBean.getFullName()+"'" 
		        + ",'"+GenderCategory+"'"   
		       +"    ,null "
		       + ",'"+Father_name+"'" 
		       + ",'"+datesql+"'" 
		       + ",'"+BloodGroup+"'" 
		       + ",'"+Cast+"'" 
		       + ",'"+Address+"'" 
		    +"      ,null "
		     +"     ,null "
		     + ",'"+city+"'" 
		      +"     ,null "
		      + ",'"+ZipCode+"'" 
		    +"      ,null "
		    +"      ,null "
		    +"       ,null "
		     +"     ,null "
		     +"     ,null "
		     +"      ,null "
		    +"       ,null "
		    +"      ,null "
		          +"      ,null "
		    +"        ,null "
		    +"       ,null "
		    +"      ,null "
		    +"      ,null "
		   +"       ,null "
		          +"       ,null "
		   +"       ,null "
		   +"       ,null "
		    +"       ,null "
		    + ",'"+email+"'" 
		    + ",'"+PhoneNumberLong+"'" 
		      +"     ,null "
		      + ",'"+PhoneNumberLong+"'" 
		     +"      ,null "
		      +"     ,null "
		      +"      ,null "
		      +"     ,'Y' "
		      +"     ,'"+date+"'"  
		      + ",'"+PlaceOfPractice+"'" 
		      +"     ,null "
		      +"     ,null "
		     +"      ,null "
		           +"     ,null "
		       +"    ,null "
		       +"    ,null "
		      +"     ,null "
		       +"    ,null "
		       +"     ,null "
		      +"     ,null "
		      +"     ,null "
		      +"     ,null "
		       +"    ,null "
		       +"    ,null "
		       +"  ,'N')";
		 	      
			      
				   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		
		}
		 
		 Session.close();
		 
		 
		return "Success";
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String GenerateCOPMnthlyReport(LocalDate Start, LocalDate End) {
		

		String result="<br><br><br><br><br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
				+ "<h1><center><b>Monthly Report Of KSBC COP From: "+Start+" To: "+End+" </b></center></h1>";
		 result+="<table class='table table-bordered' style=\"margin-left:06%\"><thead><tr>"
					+ "<th><b>Date</th></b>"
				  + "<th><b>KSBC COP Fee</th></b>"
				+ "<th><b>KSBC Appln Fee</th></b>"
				+ "<th><b>KSBC Late Fee</th></b>"
   			  +  "<th><b>KSBC Resc Fee</th></b><th><b>KSBC COP Misc Fee</th></b>"
   			  + "<th><b>KSBC COP Interest on FD</th></b>"
   			  + " <th><b>KSBC COP Closing of FD</th></b>"
   			  + "<th><b>KSBC COP Senior Advc</th></b> "
   			
	
	 /* + "<th>Mem.Late Fee</th>"*/
 
 + "<th><b>Total</th></b>"
   			  + " </tr>"
   			  +  " </thead>"
   			  +  "<tbody>";
		long days=ChronoUnit.DAYS.between(Start, End);
		LocalDate NewDate = null;
		for(int i=0;i<=days;i++)
		{
			 NewDate = Start.plusDays(i);
			 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			 result  += JSPRelatedFunctionsimp.GetReportPerDateForCOP(NewDate);
			
		}
		System.out.println(days + "   Diff btw start and end");
		long total=( Global_KSBCCOPApplication+
		  Global_KSBCCOPFee+
		  Global_KSBCCOPLateFee+
		  Global_KSBCCOPRescFee+
		  Global_KSBCCOPMiscFee+
		  Global_KSBCCOPSeniorAdvc+
		  Global_COPClosingFD+
		  Global_COPInterestONFD);
		result+="<tr>"
			
				+ "<td><b>Total</b></td>"
				+ "<td><b>"+Global_KSBCCOPFee+"</b></td>"
				+ "<td><b>"+Global_KSBCCOPApplication+"</b></td>"
		 		+ "<td><b>"+Global_KSBCCOPLateFee+"</b></td>"
		 		
		 		+ "<td><b>"+Global_KSBCCOPRescFee+"</b></td>"
		 		+ "<td><b>"+Global_KSBCCOPMiscFee+"</b></td>"
		 		
		 	
		 		+ "<td><b>"+Global_COPClosingFD+"</b></td>"
		 		
		 		+ "<td><b>"+Global_COPInterestONFD+"</b></td>"
		 			+ "<td><b>"+Global_KSBCCOPSeniorAdvc+"</b></td>"
		 	
		 	/*	+ "<td><b>"+Global_WFMembershipLateFee+"</b></td>"*/
		 		
		 				+ "<td><b>" +total+"</b></td>"
				+ "</tr>";
		result+=" </tbody> "+  "</table>";
		result+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
		 
		
		
		  Global_KSBCCOPApplication=0;
		  Global_KSBCCOPFee=0;
		  Global_KSBCCOPLateFee=0;
		  Global_KSBCCOPRescFee=0;
		  Global_KSBCCOPMiscFee=0;
		  Global_KSBCCOPSeniorAdvc=0;
		  Global_COPClosingFD=0;
		  Global_COPInterestONFD=0;

			 
			 
		  
		
		/*  Global_*/
		return result;
	}

	@Override
	public String GenerateCOPDailyReport(Date FromDate) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI daily report");
	/*	Query query = Session.createQuery("from CashSectionMonthlyReport e  where (e.ChallanCreatedDate=:stDate )");
		query.setDate("stDate", FromDate);
		*/
		
		
		Query query = Session.createQuery("from COPTable  e  where (e.ChallanCreatedDate=:stDate )  ");
		java.sql.Timestamp timestamp = new java.sql.Timestamp(FromDate.getTime());
		System.out.println(FromDate + "    From Date");
		System.out.println(timestamp + "   Time for report");
		query.setDate("stDate", timestamp);
		String ResponseResult="";
		 @SuppressWarnings("unchecked")
		
		 ArrayList<COPTable> list = (ArrayList<COPTable>)query.list();
		 System.out.println(list);
		 
		  long KSBCCOPApplication=0;
			 long KSBCCOPFee=0;
			 long KSBCCOPLateFee=0;
			 long KSBCCOPRescFee=0;
			 long KSBCCOPMiscFee=0;
			 long KSBCCOPSeniorAdvc=0;
			  long ClosingFD=0;
				 long InterestONFD=0;
				 
				 long KSBCCOPApplication_DD=0;
				 long KSBCCOPFee_DD=0;
				 long KSBCCOPLateFee_DD=0;
				 long KSBCCOPRescFee_DD=0;
				 long KSBCCOPMiscFee_DD=0;
				 long KSBCCOPSeniorAdvc_DD=0;
				  long ClosingFD_DD=0;
					 long InterestONFD_DD=0;
					 
				
				 String KSBCCOPApplication_DD_String="";
				 String KSBCCOPFee_DD_String="";
				 String KSBCCOPLateFee_DD_String="";
				 String KSBCCOPRescFee_DD_String="";
				 String KSBCCOPMiscFee_DD_String="";
				 String KSBCCOPSeniorAdvc_DD_String="";
				 String ClosingFD_DD_String="";
				 String InterestONFD_DD_String="";
					 
				 long KSBCCOPApplication_total=0;
				 long KSBCCOPFee_total=0;
				 long KSBCCOPLateFee_total=0;
				 long KSBCCOPRescFee_total=0;
				 long KSBCCOPMiscFee_total=0;
				 long KSBCCOPSeniorAdvc_total=0;
				  long ClosingFD_total=0;
					 long InterestONFD_total=0;		 
		 
	
					 long Global_KSBCCOPApplication=0;
					 long Global_KSBCCOPFee=0;
					 long Global_KSBCCOPLateFee=0;
					 long Global_KSBCCOPRescFee=0;
					 long Global_KSBCCOPMiscFee=0;
					 long Global_KSBCCOPSeniorAdvc=0;
					  long Global_ClosingFD=0;
						 long Global_InterestONFD=0;		 
			 
		 
		 long Global_total=0;
		
		 
		 
		 
		 String responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
					+ "<h1><center><b>Day Report Of the day : "+FromDate+"  </b></center></h1>";
			
		  responseString+="<table class='table table-bordered' style=\"margin-left:06%\"><thead><tr><th>SL Number</th><th>Receipt Number</th><th>Enroll Number</th><th>Name</th>"
				  +  "<th>Place</th><th>Particulars</th> <th>Paymode</th><th>Amount</th><th>KSBC COP Fee</th><th>KSBC Appln Fee</th><th>Late Fee</th><th>Resc Fee</th><th>Misc Fee</th><th>Interest On FD</th><th>Closing Of FD</th><th>Senior Advc</th>"
				 /* + ""
				  + "<th>Operator</th>"
				  + ""*/
				  + "</tr>"
				  +  " </thead>"
				  +  "<tbody>";
						   int Index=1;
						   for (COPTable RegBean : list) {
							   // caculating total amount
							 if ("Cash".equalsIgnoreCase(RegBean.getPaymode()))
							   {
								  KSBCCOPApplication+=RegBean.getKSBCCOPApplication();
								  KSBCCOPFee+=RegBean.getKSBCCOPFee();
								  KSBCCOPLateFee+=RegBean.getKSBCCOPLateFee();
								  KSBCCOPRescFee+=RegBean.getKSBCCOPRescFee();
								  KSBCCOPMiscFee+=RegBean.getKSBCCOPMiscFee();
								  KSBCCOPSeniorAdvc+=RegBean.getKSBCCOPSeniorAdvc();
								   ClosingFD+=RegBean.getClosingFD();
									  InterestONFD+=RegBean.getInterestONFD(); 
								 
							   }
							   else
							   {
								   
									   
						
									  
								   
								   if (RegBean.getKSBCCOPApplication()>0)
								   {
									   
									   KSBCCOPApplication_DD+=RegBean.getKSBCCOPApplication();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPApplication_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPApplication_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   if (RegBean.getKSBCCOPFee()>0)
								   {
									   
									   KSBCCOPFee_DD+=RegBean.getKSBCCOPFee();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPFee_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPFee_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   
								   if (RegBean.getKSBCCOPLateFee()>0)
								   {
									   
									   KSBCCOPLateFee_DD+=RegBean.getKSBCCOPLateFee();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPLateFee_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPLateFee_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   if (RegBean.getKSBCCOPRescFee()>0)
								   {
									   
									   KSBCCOPRescFee_DD+=RegBean.getKSBCCOPRescFee();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPRescFee_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPRescFee_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   if (RegBean.getKSBCCOPMiscFee()>0)
								   {
									   
									   KSBCCOPMiscFee_DD+=RegBean.getKSBCCOPMiscFee();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPMiscFee_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPMiscFee_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   if (RegBean.getKSBCCOPSeniorAdvc()>0)
								   {
									   
									   KSBCCOPSeniorAdvc_DD+=RegBean.getKSBCCOPSeniorAdvc();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPSeniorAdvc_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPSeniorAdvc_DD_String+=RegBean.getPaymode();   
									   }
								   }
									   
									   if (RegBean.getClosingFD()>0)
									   {
										   
										   ClosingFD_DD+=RegBean.getClosingFD();
										   try
										   {
											   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
											   String[] split2 = Split1[1].split("DD Date");
											   
											   ClosingFD_DD_String+=split2[0]+",";  
										   }
										   catch (Exception e)
										   {
											   ClosingFD_DD_String+=RegBean.getPaymode();   
										   }
									   }
										   if (RegBean.getInterestONFD()>0)
										   {
											   
											   InterestONFD_DD+=RegBean.getInterestONFD();
											   try
											   {
												   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
												   String[] split2 = Split1[1].split("DD Date");
												   
												   InterestONFD_DD_String+=split2[0]+",";  
											   }
											   catch (Exception e)
											   {
												   InterestONFD_DD_String+=RegBean.getPaymode();   
											   }
									   
								   }
								 		   
							   } // DD Part
						//	   KSBC=RegBean.getEntFee()+RegBean.getKLA()+ RegBean.getIC()+RegBean.getMisc();
							   responseString +=  " <tr>"
									    +  "  <th scope='row'>"+Index+"</th>"
									    +  " <td><b> " +RegBean.getSerialNumber()+"</b></td>"
									      +  " <td><b> " +RegBean.getEnrollNo() +"</b></td>"
									      +  " <td><b> " +RegBean.getName() +"</b></td>" // Change this to Name
									      +  " <td><b> " +RegBean.getPlace()+"</b></td>"
									      +  " <td><b> " +RegBean.getParticulars()+"</b></td>"
									     +  " <td><b> " +RegBean.getPaymode()+"</b></td>"
									      +  " <td><b> " +RegBean.getAmount()+"</b></td>"
									      
 										+  " <td><b> " +RegBean.getKSBCCOPFee()+"</b></td>"
 										+  " <td><b> " +RegBean.getKSBCCOPApplication()+"</b></td>"
 										+  " <td><b> " +RegBean.getKSBCCOPLateFee()+"</b></td>"
 										+  " <td><b> " +RegBean.getKSBCCOPRescFee()+"</b></td>"
 										
 										+  " <td><b> " +RegBean.getKSBCCOPMiscFee()+"</b></td>"
 										+  " <td><b> " +RegBean.getInterestONFD()+"</b></td>"
 										+  " <td><b> " +RegBean.getClosingFD()+"</b></td>"
 										+  " <td><b> " +RegBean.getKSBCCOPSeniorAdvc()+"</b></td>"
 										+  " <td><b> " +RegBean.getOperator()+"</b></td></tr>";
 										Global_KSBCCOPApplication+=RegBean.getKSBCCOPApplication();
 										Global_KSBCCOPFee+=RegBean.getKSBCCOPFee();
 										Global_KSBCCOPLateFee+=RegBean.getKSBCCOPLateFee();
 										Global_KSBCCOPRescFee+=RegBean.getKSBCCOPRescFee();
 										Global_KSBCCOPMiscFee+=RegBean.getKSBCCOPMiscFee();
 										Global_KSBCCOPSeniorAdvc+=RegBean.getKSBCCOPSeniorAdvc();
 										Global_ClosingFD+=RegBean.getClosingFD();
 										Global_InterestONFD+=RegBean.getInterestONFD(); 
 										Global_total+=RegBean.getAmount();
 									
							   Index++;
							} // FOr loop
						   responseString += " <tr>"
								    +  "  <th scope='row'><b>"+"Total"+"</b></th>"
								    +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +"-" +"</b></td>"
								      +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +"-"+"</b></td>"
								     +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +Global_total+"</b></td>" 
									+  " <td><b> " +Global_KSBCCOPFee+"</b></td>"
									+  " <td><b> " +Global_KSBCCOPApplication+"</b></td>"
									+  " <td><b> " +Global_KSBCCOPLateFee+"</b></td>"
									+  " <td><b> " +Global_KSBCCOPRescFee+"</b></td>"
									
									+  " <td><b> " +Global_KSBCCOPMiscFee+"</b></td>"
									+  " <td><b> " +Global_InterestONFD+"</b></td>"
									+  " <td><b> " +Global_ClosingFD+"</b></td>"
									+  " <td><b> " +Global_KSBCCOPSeniorAdvc+"</b></td>"
									+  " <td><b> " +"-"+"</b></td>"
											+ "</tr>"
									; 
						   responseString += /* " <td><b> " 
				      
				      
				
			  "*/
				 " </tbody> "+  "</table>"; 
						  
		 Session.close();
		 
		 // adding both DD and cash
		  KSBCCOPApplication_total=KSBCCOPApplication+KSBCCOPApplication_DD;
		
		 KSBCCOPFee_total=KSBCCOPFee+KSBCCOPFee_DD;
		 KSBCCOPLateFee_total=KSBCCOPLateFee+KSBCCOPLateFee_DD;
		 KSBCCOPMiscFee_total=KSBCCOPMiscFee+KSBCCOPMiscFee_DD;
		 
		 KSBCCOPRescFee_total=KSBCCOPRescFee+KSBCCOPRescFee_DD;
		 KSBCCOPSeniorAdvc_total= KSBCCOPSeniorAdvc+ KSBCCOPSeniorAdvc_DD;
		 ClosingFD_total=ClosingFD+ClosingFD_DD;
		 
		 InterestONFD_total=InterestONFD+InterestONFD_DD;
		
		 
		//  String[] KSBC_str_split1 = KSBC_DD_String.split("DDNumber:");
		  Long TotalAmount_cash=(long) (InterestONFD+ClosingFD+KSBCCOPFee+KSBCCOPLateFee+KSBCCOPMiscFee+KSBCCOPRescFee+KSBCCOPSeniorAdvc);
		  Long TotalAmount_DD=(long) (InterestONFD_DD+ClosingFD_DD+KSBCCOPFee_DD+KSBCCOPLateFee_DD+KSBCCOPMiscFee_DD+KSBCCOPRescFee_DD+KSBCCOPSeniorAdvc_DD);
			Long Total_collection=TotalAmount_cash+TotalAmount_DD;
			
			String TotalString=KSBCCOPApplication_DD_String+KSBCCOPFee_DD_String+KSBCCOPLateFee_DD_String+KSBCCOPRescFee_DD_String+KSBCCOPMiscFee_DD_String+InterestONFD_DD_String+ClosingFD_DD_String+KSBCCOPSeniorAdvc_DD_String;
			
		 responseString+="<br><br>";
		 responseString+="<table class='table table-bordered' style=\"margin-left:06%\"><thead><tr><th>Particulars</th><th>Total</th><th>Cash</th>"
				  +  "<th>DD Amount</th><th>Cheque/DD</th></tr>"
				  +  " </thead>"
				  +  "<tbody>";
	/*	 responseString+="<tr><th>KSBC COP Application Fee</th><th>"+KSBCCOPApplication_total+"</th><th>"+KSBCCOPApplication+"</th><th>"+KSBCCOPApplication_DD+"</th><th>"+KSBCCOPApplication_DD_String+"</th></tr>";
		 responseString+="<tr><th>KSBC COP Fee</th><th>"+KSBCCOPFee_total+"</th><th>"+KSBCCOPFee+"</th><th>"+KSBCCOPFee_DD+"</th><th>"+KSBCCOPFee_DD_String+"</th></tr>";
			
		 responseString+="<tr><th>KSBC COP Late Fee</th><th>"+KSBCCOPLateFee_total+"</th><th>"+KSBCCOPLateFee+"</th><th>"+KSBCCOPLateFee_DD+"</th><th>"+KSBCCOPLateFee_DD_String+"</th></tr>";
		 responseString+="<tr><th>KSBC COP Resc Fee</th><th>"+KSBCCOPRescFee_total+"</th><th>"+KSBCCOPRescFee+"</th><th>"+KSBCCOPRescFee_DD+"</th><th>"+KSBCCOPRescFee_DD_String+"</th></tr>";
			
		 responseString+="<tr><th>KSBC COP Misc Fee</th><th>"+KSBCCOPMiscFee_total+"</th><th>"+KSBCCOPMiscFee+"</th><th>"+KSBCCOPMiscFee_DD+"</th><th>"+KSBCCOPMiscFee_DD_String+"</th></tr>";
			
		 
		 responseString+="<tr><th>KSBC COP Interest on FD</th><th>"+InterestONFD_total+"</th><th>"+InterestONFD+"</th><th>"+InterestONFD_DD+"</th><th>"+InterestONFD_DD_String+"</th></tr>";
		 responseString+="<tr><th>KSBC COP Closing FD</th><th>"+ClosingFD_total+"</th><th>"+ClosingFD+"</th><th>"+ClosingFD_DD+"</th><th>"+ClosingFD_DD_String+"</th></tr>";
			
		 responseString+="<tr><th>KSBC COP Senior Adv</th><th>"+KSBCCOPSeniorAdvc_total+"</th><th>"+KSBCCOPSeniorAdvc+"</th><th>"+KSBCCOPSeniorAdvc_DD+"</th><th>"+KSBCCOPSeniorAdvc_DD_String+"</th></tr>";
		
		 */
		 responseString+="<tr><th><b>KSBC COP</b></th><th>"+Total_collection+"</th><th>"+TotalAmount_cash+"</th><th>"+TotalAmount_DD+"</th>><th>"+(TotalString)+"</th></tr>";
			
		 responseString+= " </tbody> "+  "</table>"; 
		 
		 System.out.println(responseString);
		  responseString+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
			
		return responseString; 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String GetReportPerDateForCOP(LocalDate Start) {
		
		String Response="";
		
		System.out.println("BCI");
		BCI_FDSBean BCI_FDSBean = new BCI_FDSBean();
		  long KSBCCOPApplication=0;
			 long KSBCCOPFee=0;
			 long KSBCCOPLateFee=0;
			 long KSBCCOPRescFee=0;
			 long KSBCCOPMiscFee=0;
			 long KSBCCOPSeniorAdvc=0;
			  long ClosingFD=0;
				 long InterestONFD=0;
		 Long total=(long) 0;
		 
			 
			 java.sql.Timestamp ChallanCreatedDate = null ;
			 
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from COPTable where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<COPTable> list = (ArrayList<COPTable>)query.list();
		System.out.println(list + "   List from COPTable");
			 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (COPTable bci_FDSBean2 : list) {
				 
				  Global_KSBCCOPFee+=bci_FDSBean2.getKSBCCOPFee();
				  Global_KSBCCOPLateFee+=bci_FDSBean2.getKSBCCOPLateFee();
				  Global_KSBCCOPRescFee+=bci_FDSBean2.getKSBCCOPRescFee();
				  Global_KSBCCOPMiscFee+=bci_FDSBean2.getKSBCCOPMiscFee();
				  Global_KSBCCOPSeniorAdvc+=bci_FDSBean2.getKSBCCOPSeniorAdvc();
				  Global_COPClosingFD+=bci_FDSBean2.getClosingFD();
				  Global_COPInterestONFD+=bci_FDSBean2.getInterestONFD();
				  
				  Global_KSBCCOPApplication+=bci_FDSBean2.getKSBCCOPApplication();
					 
				  KSBCCOPApplication+=bci_FDSBean2.getKSBCCOPApplication();
				 
				  KSBCCOPFee+=bci_FDSBean2.getKSBCCOPFee();
				  KSBCCOPLateFee+=bci_FDSBean2.getKSBCCOPLateFee();
				  KSBCCOPRescFee+=bci_FDSBean2.getKSBCCOPRescFee();
				  KSBCCOPMiscFee+=bci_FDSBean2.getKSBCCOPMiscFee();
				  KSBCCOPSeniorAdvc+=bci_FDSBean2.getKSBCCOPSeniorAdvc();
				  ClosingFD+=bci_FDSBean2.getClosingFD();
				  InterestONFD+=bci_FDSBean2.getInterestONFD();	 
				 
				 
			}
			 total=	(long)KSBCCOPApplication+ KSBCCOPFee+	 KSBCCOPLateFee+KSBCCOPRescFee+KSBCCOPMiscFee+KSBCCOPSeniorAdvc+ClosingFD+
					 InterestONFD;
		
			 
			 Response="<tr> "
		
				 		
			 		+ "<td><b> "+Start+"</b></td>"
			 		+ "<td><b>"+KSBCCOPFee+"</b></td>"
			 		+ "<td><b>"+KSBCCOPApplication+"</b></td>"
			 		+ "<td><b>"+KSBCCOPLateFee+"</b></td>"
			 		+ "<td><b>"+KSBCCOPRescFee+"</b></td>"
			 		
			 		
			 		+ "<td><b>"+KSBCCOPMiscFee+"</b></td>"
			 			+ "<td><b>"+ClosingFD+"</b></td>"
			 		+ "<td><b>"+InterestONFD+"</b></td>"
			 	
			 		+ "<td><b>"+KSBCCOPSeniorAdvc+"</b></td>"
			 					+"<td><b>"+total+"</b></td>"
			 				+ "</tr>";
		 }
		 
			 
		 
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		
		return Response;
	}



	@Override
	public String GetPhotoDetailsForWelfare(int EnrollmentNumber) {
		
		
		
		
		System.out.println(EnrollmentNumber + " EnrollmentNumber");
		
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "select [photo] from  [dbo].[Enrollment_Photos] "
				      		
					      		+ "WHERE EnrollmentId=?";
					      		   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setInt(1, EnrollmentNumber);
			   
			      ResultSet rs = PrepareStateMent.executeQuery();

			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			  String photo="";
			      int Index=1;
			        while(rs.next()){
			         //Retrieve by column name
			    	 
			    					   
			        	responseString= "data:image/png;base64,"+rs.getString("photo");
			    		System.out.println(responseString);			
			      }
			    								      
			    					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    			      
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String GenerateDailyReportForUser(Date FromDate, String Operator) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI daily report");
	/*	Query query = Session.createQuery("from CashSectionMonthlyReport e  where (e.ChallanCreatedDate=:stDate )");
		query.setDate("stDate", FromDate);
		*/
		
		
		Query query = Session.createQuery("from CashSectionMonthlyReport  e  where (e.ChallanCreatedDate=:stDate ) and (e.operator=:operator) ");
		java.sql.Timestamp timestamp = new java.sql.Timestamp(FromDate.getTime());
		System.out.println(FromDate + "    From Date");
		System.out.println(timestamp + "   Time for report"); 
		query.setDate("stDate", timestamp);
		query.setString("operator", Operator);
		String ResponseResult="";
		 @SuppressWarnings("unchecked")
		
		 ArrayList<CashSectionMonthlyReport> list = (ArrayList<CashSectionMonthlyReport>)query.list();
		 System.out.println(list);
		 long KSBC=0;
		 long KSBC_DD=0;
		 long KSBC_TRUST=0;
		 long KSBCWF_FDS=0;
		 long KAWF_TC=0;
		 long KAWF_DD=0;
		 long STAMP=0;
		 long STAMP_DD=0;
		 long BCI_AWF=0;
		 long BCI_AWF_DD=0;
		 long FDS_DD=0;
		 String KSBC_DD_String="";
		 String FDS_DD_String="";
		 String KAWF_TC_String="";
		 String BCI_AWF_String="";
		 String STAMP_DD_String="";
		 
		 long KSBC_total=0;
		 long Kawf_total=0;
		 long BCI_total=0;
		 long FDS_total=0;
		 long STAMP_total=0;
		 
		 
		 long Global_total=0;
		 long Global_EntFee=0;
		 long Global_KLA=0;
		 long Global_ic=0;
		 long Global_misc=0;
		 long Global_BCI_AWF=0;
		 
		 long Global_Kawf_total=0;
		
		 long Global_FDS_total=0;
		 long Global_STAMP_total=0;
		 
		 
		 
		 String responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
					+ "<h1><center><b>Day Report Of the Day : "+FromDate+"  </b></center></h1>";
			
		  responseString+=
				  ""
			  		+ "<style>"
			  		+ "table {"
	    
			  	
	+ " border-collapse: separate; "
	+ "  empty-cells: hide; "
			  		
	   + "} "
	+ "</style>"
			  		
			  		+ "<table class='table table-bordered' style=\"margin-left:06%\"><thead><tr>"
				 + "<th>SL Number</th><th>Receipt Number</th><th>Enroll Number</th><th>Name</th>"
				  +  "<th>Place</th><th>Particulars</th> <th>Paymode</th><th>Amount</th><th>Ent Fee</th><th>KLA</th><th>I/C</th><th>Misc</th><th>KAWF</th><th>STAMP</th><th>BCI AWF</th><th>FDS</th><th>Operator</th></tr>"
				  +  " </thead>"
				  +  "<tbody>";
						   int Index=1;
						   for (CashSectionMonthlyReport RegBean : list) {
							   // caculating total amount
							 if ("Cash".equalsIgnoreCase(RegBean.getPaymode()))
							   {
								  KAWF_TC+=RegBean.getKAWF();
								   BCI_AWF+=RegBean.getBCIAWF();
								   STAMP+=RegBean.getSTAMP();
								   KSBCWF_FDS+=RegBean.getFDS();
								   if ((RegBean.getEntFee())>0 || (RegBean.getKLA()>0) || (RegBean.getIC()>0) || (RegBean.getMisc()>0))
								   {
									   KSBC+=RegBean.getEntFee()+RegBean.getKLA()+RegBean.getIC()+RegBean.getMisc();
									 
								   }   
							   }
							   else
							   {
								   
								   if ((RegBean.getEntFee())>0 || (RegBean.getKLA()>0) || (RegBean.getIC()>0) || (RegBean.getMisc()>0))
								   {
									   KSBC_DD+=RegBean.getEntFee()+RegBean.getKLA()+RegBean.getIC();
									   
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBC_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBC_DD_String+=RegBean.getPaymode();   
									   }
									   
									  
								   }
								   if (RegBean.getKAWF()>0)
								   {
									   KAWF_DD+=RegBean.getKAWF();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KAWF_TC_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KAWF_TC_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   if (RegBean.getFDS()>0)
								   {
									   FDS_DD+=RegBean.getFDS();
									 
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   FDS_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   FDS_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   if (RegBean.getBCIAWF()>0)
								   {
									   BCI_AWF_DD+=RegBean.getBCIAWF();
									 
									   
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   BCI_AWF_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   BCI_AWF_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   if (RegBean.getSTAMP()>0)
								   {
									   STAMP_DD+=RegBean.getSTAMP();
									   
									   
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   STAMP_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   STAMP_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
							   }
						//	   KSBC=RegBean.getEntFee()+RegBean.getKLA()+ RegBean.getIC()+RegBean.getMisc();
							   responseString +=  " <tr>"
									    +  "  <th scope='row'>"+Index+"</th>"
									    +  " <td><b> " +RegBean.getReceiptNo()+"</b></td>"
									      +  " <td><b> " +RegBean.getEnrollNo() +"</b></td>"
									      +  " <td><b> " +RegBean.getName() +"</b></td>" // Change this to Name
									      +  " <td><b> " +RegBean.getPlace()+"</b></td>"
									      +  " <td><b> " +RegBean.getParticulars()+"</b></td>"
									     +  " <td><b> " +RegBean.getPaymode()+"</b></td>"
									      +  " <td><b> " +RegBean.getAmount()+"</b></td>"
									      
 										+  " <td><b> " +RegBean.getEntFee()+"</b></td>"
 										+  " <td><b> " +RegBean.getKLA()+"</b></td>"
 										+  " <td><b> " +RegBean.getIC()+"</b></td>"
 										+  " <td><b> " +RegBean.getMisc()+"</b></td>"
 										
 										+  " <td><b> " +RegBean.getKAWF()+"</b></td>"
 										+  " <td><b> " +RegBean.getSTAMP()+"</b></td>"
 										+  " <td><b> " +RegBean.getBCIAWF()+"</b></td>"
 										+  " <td><b> " +RegBean.getFDS()+"</b></td>"
 										+  " <td><b> " +RegBean.getOperator()+"</b></td></tr>";
							   
								  Global_EntFee+=RegBean.getEntFee();
								  Global_KLA+=RegBean.getKLA();
								  Global_ic+=RegBean.getIC();
								  Global_misc+=RegBean.getMisc();
								  Global_BCI_AWF+=RegBean.getBCIAWF();
								 
								  Global_Kawf_total+=RegBean.getKAWF();
								
								  Global_FDS_total+=RegBean.getFDS();
								  Global_STAMP_total+=RegBean.getSTAMP();
								  Global_total+=RegBean.getAmount();
							   Index++;
							} // FOr loop
						   responseString += " <tr>"
								   
									   +  "  <th scope='row'><b>"+"Total"+"</b></th>"
								    +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +"-" +"</b></td>"
								      +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +"-"+"</b></td>"
								     +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +Global_total+"</b></td>" 
									+  " <td><b> " +Global_EntFee+"</b></td>"
									+  " <td><b> " +Global_KLA+"</b></td>"
									+  " <td><b> " +Global_ic+"</b></td>"
									+  " <td><b> " +Global_misc+"</b></td>"
									
									+  " <td><b> " +Global_Kawf_total+"</b></td>"
									+  " <td><b> " +Global_STAMP_total+"</b></td>"
									+  " <td><b> " +Global_BCI_AWF+"</b></td>"
									+  " <td><b> " +Global_FDS_total+"</b></td>"
									+  " <td><b> " +"-"+"</b></td>"
											+ "</tr>"
									; 
						   responseString += /* " <td><b> " 
				      
				      
				
			  "*/
				 " </tbody> "+  "</table>"; 
						  
		 Session.close();
		 
		 // adding both DD and cash
		 
		 KSBC_total=KSBC+KSBC_DD;
		
		  Kawf_total=KAWF_TC+KAWF_DD;
		  BCI_total=BCI_AWF+BCI_AWF_DD;
		  FDS_total=KSBCWF_FDS+FDS_DD;
		  STAMP_total=STAMP+STAMP_DD;
		//  String[] KSBC_str_split1 = KSBC_DD_String.split("DDNumber:");
		  Long TotalAmount_cash=(long) (KSBC+KAWF_TC+BCI_AWF+KSBCWF_FDS+STAMP);
		  Long TotalAmount_DD=(long) (KSBC_DD+KAWF_DD+BCI_AWF_DD+FDS_DD+STAMP_DD);
			Long Total_collection=TotalAmount_cash+TotalAmount_DD;
		 responseString+="<br><br>";
		 responseString+="<table class='table table-bordered' style=\"margin-left:06%\"><thead><tr <th>      </th> "
				
				 +"<th>Particulars</th><th>Total</th><th>Cash</th>"
				  +  "<th>DD Amount</th><th>Cheque/DD</th></tr>"
				  +  " </thead>"
				  +  "<tbody>";
		 responseString+="<tr> <th>      </th> "
				+ " <th>KSBC</th><th>"+KSBC_total+"</th><th>"+KSBC+"</th><th>"+KSBC_DD+"</th><th>"+KSBC_DD_String+"</th></tr>";
		 responseString+="<tr><th>      </th> "
				+ " <th>FDS</th><th>"+FDS_total+"</th><th>"+KSBCWF_FDS+"</th><th>"+FDS_DD+"</th><th>"+FDS_DD_String+"</th></tr>";
			
		 responseString+="<tr><th>      </th> "
				+ " <th>KAWF</th><th>"+Kawf_total+"</th><th>"+KAWF_TC+"</th><th>"+KAWF_DD+"</th><th>"+KAWF_TC_String+"</th></tr>";
		 responseString+="<tr><th>      </th> "
				+ " <th>STAMP</th><th>"+STAMP_total+"</th><th>"+STAMP+"</th><th>"+STAMP_DD+"</th><th>"+STAMP_DD_String+"</th></tr>";
			
		 responseString+="<tr><th>      </th> "
				+ " <<th>BCI AWF</th><th>"+BCI_total+"</th><th>"+BCI_AWF+"</th><th>"+BCI_AWF_DD+"</th><th>"+BCI_AWF_String+"</th></tr>";
						
		 responseString+="<tr><th>      </th> "
				+ " < <th><b>Total</b></th><th>"+Total_collection+"</th><th>"+TotalAmount_cash+"</th><th>"+TotalAmount_DD+"</th><th></tr>";
			
		 responseString+= " </tbody> "+  "</table>"; 
		 
		 System.out.println(responseString);
		  responseString+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
			
		return responseString; 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String GenerateCOPDailyReportForUser(Date FromDate, String Operator) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI daily report");
	/*	Query query = Session.createQuery("from CashSectionMonthlyReport e  where (e.ChallanCreatedDate=:stDate )");
		query.setDate("stDate", FromDate);
		*/
		
		
		Query query = Session.createQuery("from COPTable  e  where (e.ChallanCreatedDate=:stDate )  and (e.operator=:operator) ");
		java.sql.Timestamp timestamp = new java.sql.Timestamp(FromDate.getTime());
		System.out.println(FromDate + "    From Date");
		System.out.println(timestamp + "   Time for report");
		query.setDate("stDate", timestamp);
		query.setString("operator", Operator);
		String ResponseResult="";
		 @SuppressWarnings("unchecked")
		
		 ArrayList<COPTable> list = (ArrayList<COPTable>)query.list();
		 System.out.println(list);
		 
		  long KSBCCOPApplication=0;
			 long KSBCCOPFee=0;
			 long KSBCCOPLateFee=0;
			 long KSBCCOPRescFee=0;
			 long KSBCCOPMiscFee=0;
			 long KSBCCOPSeniorAdvc=0;
			  long ClosingFD=0;
				 long InterestONFD=0;
				 
				 long KSBCCOPApplication_DD=0;
				 long KSBCCOPFee_DD=0;
				 long KSBCCOPLateFee_DD=0;
				 long KSBCCOPRescFee_DD=0;
				 long KSBCCOPMiscFee_DD=0;
				 long KSBCCOPSeniorAdvc_DD=0;
				  long ClosingFD_DD=0;
					 long InterestONFD_DD=0;
					 
				
				 String KSBCCOPApplication_DD_String="";
				 String KSBCCOPFee_DD_String="";
				 String KSBCCOPLateFee_DD_String="";
				 String KSBCCOPRescFee_DD_String="";
				 String KSBCCOPMiscFee_DD_String="";
				 String KSBCCOPSeniorAdvc_DD_String="";
				 String ClosingFD_DD_String="";
				 String InterestONFD_DD_String="";
					 
				 long KSBCCOPApplication_total=0;
				 long KSBCCOPFee_total=0;
				 long KSBCCOPLateFee_total=0;
				 long KSBCCOPRescFee_total=0;
				 long KSBCCOPMiscFee_total=0;
				 long KSBCCOPSeniorAdvc_total=0;
				  long ClosingFD_total=0;
					 long InterestONFD_total=0;		 
		 
	
					 long Global_KSBCCOPApplication=0;
					 long Global_KSBCCOPFee=0;
					 long Global_KSBCCOPLateFee=0;
					 long Global_KSBCCOPRescFee=0;
					 long Global_KSBCCOPMiscFee=0;
					 long Global_KSBCCOPSeniorAdvc=0;
					  long Global_ClosingFD=0;
						 long Global_InterestONFD=0;		 
			 
		 
		 long Global_total=0;
		
		 
		 
		 
		 String responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
					+ "<h1><center><b>Day Report Of the Day : "+FromDate+"  </b></center></h1>";
			
		  responseString+=""
				
			  		+ "<style>"
			  		+ "table {"
	    
			  	
	+ " border-collapse: separate; "
	+ "  empty-cells: hide; "
			  		
	   + "} "
	+ "</style>"
			  		
			  		
		  		+ "<table class='table table-bordered' style=\"margin-left:06%\"><thead>"
		  		+ "<tr>"
				 + "<th>SL Number</th><th>Receipt Number</th><th>Enroll Number</th><th>Name</th>"
				  +  "<th>Place</th><th>Particulars</th> <th>Paymode</th><th>Amount</th><th>KSBC COP Fee</th><th>KSBC Appln Fee</th><th>Late Fee</th><th>Resc Fee</th><th>Misc Fee</th><th>Interest On FD</th><th>Closing Of FD</th><th>Senior Advc</th><th>Operator</th></tr>"
				  +  " </thead>"
				  +  "<tbody>";
						   int Index=1;
						   for (COPTable RegBean : list) {
							   // caculating total amount
							 if ("Cash".equalsIgnoreCase(RegBean.getPaymode()))
							   {
								  KSBCCOPApplication+=RegBean.getKSBCCOPApplication();
								  KSBCCOPFee+=RegBean.getKSBCCOPFee();
								  KSBCCOPLateFee+=RegBean.getKSBCCOPLateFee();
								  KSBCCOPRescFee+=RegBean.getKSBCCOPRescFee();
								  KSBCCOPMiscFee+=RegBean.getKSBCCOPMiscFee();
								  KSBCCOPSeniorAdvc+=RegBean.getKSBCCOPSeniorAdvc();
								   ClosingFD+=RegBean.getClosingFD();
									  InterestONFD+=RegBean.getInterestONFD(); 
								 
							   }
							   else
							   {
								   
									   
						
									  
								   
								   if (RegBean.getKSBCCOPApplication()>0)
								   {
									   
									   KSBCCOPApplication_DD+=RegBean.getKSBCCOPApplication();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPApplication_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPApplication_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   if (RegBean.getKSBCCOPFee()>0)
								   {
									   
									   KSBCCOPFee_DD+=RegBean.getKSBCCOPFee();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPFee_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPFee_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   
								   if (RegBean.getKSBCCOPLateFee()>0)
								   {
									   
									   KSBCCOPLateFee_DD+=RegBean.getKSBCCOPLateFee();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPLateFee_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPLateFee_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   if (RegBean.getKSBCCOPRescFee()>0)
								   {
									   
									   KSBCCOPRescFee_DD+=RegBean.getKSBCCOPRescFee();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPRescFee_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPRescFee_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   if (RegBean.getKSBCCOPMiscFee()>0)
								   {
									   
									   KSBCCOPMiscFee_DD+=RegBean.getKSBCCOPMiscFee();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPMiscFee_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPMiscFee_DD_String+=RegBean.getPaymode();   
									   }
									   
								   }
								   
								   if (RegBean.getKSBCCOPSeniorAdvc()>0)
								   {
									   
									   KSBCCOPSeniorAdvc_DD+=RegBean.getKSBCCOPSeniorAdvc();
									   try
									   {
										   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
										   String[] split2 = Split1[1].split("DD Date");
										   
										   KSBCCOPSeniorAdvc_DD_String+=split2[0]+",";  
									   }
									   catch (Exception e)
									   {
										   KSBCCOPSeniorAdvc_DD_String+=RegBean.getPaymode();   
									   }
								   }
									   
									   if (RegBean.getClosingFD()>0)
									   {
										   
										   ClosingFD_DD+=RegBean.getClosingFD();
										   try
										   {
											   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
											   String[] split2 = Split1[1].split("DD Date");
											   
											   ClosingFD_DD_String+=split2[0]+",";  
										   }
										   catch (Exception e)
										   {
											   ClosingFD_DD_String+=RegBean.getPaymode();   
										   }
									   }
										   if (RegBean.getInterestONFD()>0)
										   {
											   
											   InterestONFD_DD+=RegBean.getInterestONFD();
											   try
											   {
												   String[] Split1 = RegBean.getPaymode().split("DDNumber:" );
												   String[] split2 = Split1[1].split("DD Date");
												   
												   InterestONFD_DD_String+=split2[0]+",";  
											   }
											   catch (Exception e)
											   {
												   InterestONFD_DD_String+=RegBean.getPaymode();   
											   }
									   
								   }
								 		   
							   } // DD Part
						//	   KSBC=RegBean.getEntFee()+RegBean.getKLA()+ RegBean.getIC()+RegBean.getMisc();
							   responseString +=  " <tr>"
									   
									   
									   +  "  <th scope='row'>"+Index+"</th>"
									    +  " <td><b> " +RegBean.getSerialNumber()+"</b></td>"
									      +  " <td><b> " +RegBean.getEnrollNo() +"</b></td>"
									      +  " <td><b> " +RegBean.getName() +"</b></td>" // Change this to Name
									      +  " <td><b> " +RegBean.getPlace()+"</b></td>"
									      +  " <td><b> " +RegBean.getParticulars()+"</b></td>"
									     +  " <td><b> " +RegBean.getPaymode()+"</b></td>"
									      +  " <td><b> " +RegBean.getAmount()+"</b></td>"
									      
 										+  " <td><b> " +RegBean.getKSBCCOPFee()+"</b></td>"
 										+  " <td><b> " +RegBean.getKSBCCOPApplication()+"</b></td>"
 										+  " <td><b> " +RegBean.getKSBCCOPLateFee()+"</b></td>"
 										+  " <td><b> " +RegBean.getKSBCCOPRescFee()+"</b></td>"
 										
 										+  " <td><b> " +RegBean.getKSBCCOPMiscFee()+"</b></td>"
 										+  " <td><b> " +RegBean.getInterestONFD()+"</b></td>"
 										+  " <td><b> " +RegBean.getClosingFD()+"</b></td>"
 										+  " <td><b> " +RegBean.getKSBCCOPSeniorAdvc()+"</b></td>"
 										+  " <td><b> " +RegBean.getOperator()+"</b></td></tr>";
 										Global_KSBCCOPApplication+=RegBean.getKSBCCOPApplication();
 										Global_KSBCCOPFee+=RegBean.getKSBCCOPFee();
 										Global_KSBCCOPLateFee+=RegBean.getKSBCCOPLateFee();
 										Global_KSBCCOPRescFee+=RegBean.getKSBCCOPRescFee();
 										Global_KSBCCOPMiscFee+=RegBean.getKSBCCOPMiscFee();
 										Global_KSBCCOPSeniorAdvc+=RegBean.getKSBCCOPSeniorAdvc();
 										Global_ClosingFD+=RegBean.getClosingFD();
 										Global_InterestONFD+=RegBean.getInterestONFD(); 
 										Global_total+=RegBean.getAmount();
 									
							   Index++;
							} // FOr loop
						   responseString += " <tr>"
								   
								 +  "  <th scope='row'><b>"+"Total"+"</b></th>"
								    +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +"-" +"</b></td>"
								      +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +"-"+"</b></td>"
								     +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +"-"+"</b></td>"
								      +  " <td><b> " +Global_total+"</b></td>" 
									+  " <td><b> " +Global_KSBCCOPFee+"</b></td>"
									+  " <td><b> " +Global_KSBCCOPApplication+"</b></td>"
									+  " <td><b> " +Global_KSBCCOPLateFee+"</b></td>"
									+  " <td><b> " +Global_KSBCCOPRescFee+"</b></td>"
									
									+  " <td><b> " +Global_KSBCCOPMiscFee+"</b></td>"
									+  " <td><b> " +Global_InterestONFD+"</b></td>"
									+  " <td><b> " +Global_ClosingFD+"</b></td>"
									+  " <td><b> " +Global_KSBCCOPSeniorAdvc+"</b></td>"
									+  " <td><b> " +"-"+"</b></td>"
											+ "</tr>"
									; 
						   responseString += /* " <td><b> " 
				      
				      
				
			  "*/
				 " </tbody> "+  "</table>"; 
						  
		 Session.close();
		 
		 // adding both DD and cash
		  KSBCCOPApplication_total=KSBCCOPApplication+KSBCCOPApplication_DD;
		
		 KSBCCOPFee_total=KSBCCOPFee+KSBCCOPFee_DD;
		 KSBCCOPLateFee_total=KSBCCOPLateFee+KSBCCOPLateFee_DD;
		 KSBCCOPMiscFee_total=KSBCCOPMiscFee+KSBCCOPMiscFee_DD;
		 
		 KSBCCOPRescFee_total=KSBCCOPRescFee+KSBCCOPRescFee_DD;
		 KSBCCOPSeniorAdvc_total= KSBCCOPSeniorAdvc+ KSBCCOPSeniorAdvc_DD;
		 ClosingFD_total=ClosingFD+ClosingFD_DD;
		 
		 InterestONFD_total=InterestONFD+InterestONFD_DD;
		
		 
		//  String[] KSBC_str_split1 = KSBC_DD_String.split("DDNumber:");
		  Long TotalAmount_cash=(long) (InterestONFD+ClosingFD+KSBCCOPFee+KSBCCOPLateFee+KSBCCOPMiscFee+KSBCCOPRescFee+KSBCCOPSeniorAdvc);
		  Long TotalAmount_DD=(long) (InterestONFD_DD+ClosingFD_DD+KSBCCOPFee_DD+KSBCCOPLateFee_DD+KSBCCOPMiscFee_DD+KSBCCOPRescFee_DD+KSBCCOPSeniorAdvc_DD);
			Long Total_collection=TotalAmount_cash+TotalAmount_DD;
			String TotalString=KSBCCOPApplication_DD_String+KSBCCOPFee_DD_String+KSBCCOPLateFee_DD_String+KSBCCOPRescFee_DD_String+KSBCCOPMiscFee_DD_String+InterestONFD_DD_String+ClosingFD_DD_String+KSBCCOPSeniorAdvc_DD_String;
		 responseString+="<br><br>";
		 responseString+="<table class='table table-bordered' style=\"margin-left:06%\">"
		 		+ "<thead><tr><th>Particulars</th><th>Total</th><th>Cash</th>"
				  +  "<th>DD Amount</th>"
				  + "<th>Cheque/DD</th></tr>"
				  +  " </thead>"
				  +  "<tbody>";
	/*	 responseString+="<tr><th>KSBC COP Application Fee</th><th>"+KSBCCOPApplication_total+"</th><th>"+KSBCCOPApplication+"</th><th>"+KSBCCOPApplication_DD+"</th><th>"+KSBCCOPApplication_DD_String+"</th></tr>";
		 responseString+="<tr><th>KSBC COP Fee</th><th>"+KSBCCOPFee_total+"</th><th>"+KSBCCOPFee+"</th><th>"+KSBCCOPFee_DD+"</th><th>"+KSBCCOPFee_DD_String+"</th></tr>";
			
		 responseString+="<tr><th>KSBC COP Late Fee</th><th>"+KSBCCOPLateFee_total+"</th><th>"+KSBCCOPLateFee+"</th><th>"+KSBCCOPLateFee_DD+"</th><th>"+KSBCCOPLateFee_DD_String+"</th></tr>";
		 responseString+="<tr><th>KSBC COP Resc Fee</th><th>"+KSBCCOPRescFee_total+"</th><th>"+KSBCCOPRescFee+"</th><th>"+KSBCCOPRescFee_DD+"</th><th>"+KSBCCOPRescFee_DD_String+"</th></tr>";
			
		 responseString+="<tr><th>KSBC COP Misc Fee</th><th>"+KSBCCOPMiscFee_total+"</th><th>"+KSBCCOPMiscFee+"</th><th>"+KSBCCOPMiscFee_DD+"</th><th>"+KSBCCOPMiscFee_DD_String+"</th></tr>";
			
		 
		 responseString+="<tr><th>KSBC COP Interest on FD</th><th>"+InterestONFD_total+"</th><th>"+InterestONFD+"</th><th>"+InterestONFD_DD+"</th><th>"+InterestONFD_DD_String+"</th></tr>";
		 responseString+="<tr><th>KSBC COP Closing FD</th><th>"+ClosingFD_total+"</th><th>"+ClosingFD+"</th><th>"+ClosingFD_DD+"</th><th>"+ClosingFD_DD_String+"</th></tr>";
			
		 responseString+="<tr><th>KSBC COP Senior Adv</th><th>"+KSBCCOPSeniorAdvc_total+"</th><th>"+KSBCCOPSeniorAdvc+"</th><th>"+KSBCCOPSeniorAdvc_DD+"</th><th>"+KSBCCOPSeniorAdvc_DD_String+"</th></tr>";
		
		 */
		 responseString+="<tr><th><b>KSBC COP</b></th><th>"+Total_collection+"</th><th>"+TotalAmount_cash+"</th><th>"+TotalAmount_DD+"</th>><th>"+(TotalString)+"</th></tr>";
			
		 responseString+= " </tbody> "+  "</table>"; 
		 
		 System.out.println(responseString);
		  responseString+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
			
		return responseString; 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String UpdateCaseDetailsInDC(String CaseDetails, String ComplaintNumber) {
		
		
		System.out.println(CaseDetails + "Akshay");
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = Session.beginTransaction();
/*		
		DC_Committee dc = (DC_Committee)Session.get(DC_Committee.class, ComplaintNumber);
		dc.setCaseDetails(CaseDetails);*/
		/*DC_Committee DC_Committee = new DC_Committee();
	*/
		Query q = Session.createQuery("update DC_Committee set CaseDetails=:CaseDetails where ComplaintNumber=:ComplaintNumber");
	q.setString("CaseDetails", CaseDetails);
	q.setString("ComplaintNumber", ComplaintNumber);
	q.executeUpdate();
		
	tx.commit();
		/*Session.update(dc);*/
		return "Updated Successfully";
		}
		catch(Exception e)
	
		{
		e.printStackTrace();
		return "Sorry, Its not updated Try Again Later";
		}
	}

	@Override
	public String GetDetailsOfDCfromComplaintNumber(String ComplaintNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from DC_Committee where complaintNumber = :complaintNumber ");
		query.setParameter("complaintNumber", ComplaintNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<DC_Committee> list = (ArrayList<DC_Committee>)query.list();
		DC_Committee DC_Committee= list.get(0);
		String  responseString="<table class='table table-bordered'><thead><tr>"
				+ "<th>complaintNumber</th>"
				+ "<th>Name</th>"
				  +  "<th>Place</th><th>AgainstAdvocate</th>"
				  + " <th>Remarks</th><th>Reason</th><th>CaseDate</th><th>ComplaintPhoneNumber</th>"
				  + "<th>AgainstAdvocatePhoneNumber</th>"
				  + "<th>CaseDetails</th></tr>"
				  +  " </thead>"
				  +  "<tbody>";
		
		responseString+="<tr>"
		/*		  +  "  <th scope='row'>"+1+"</th>"*/
				+ "<td>"+DC_Committee.getComplaintNumber()+"</td>"
				+ "<td>"+DC_Committee.getName()+"</td>"
				+ "<td>"+DC_Committee.getPlace()+"</td>"
				+ "<td>"+DC_Committee.getAgainstAdvocate()+"</td>"
				+ "<td>"+DC_Committee.getRemarks()+"</td>"
				+ "<td>"+DC_Committee.getReason()+"</td>"
				+ "<td>"+DC_Committee.getCaseDate()+"</td>"
				+ "<td>"+DC_Committee.getComplaintPhoneNumber()+"</td>"
				+ "<td>"+DC_Committee.getAgainstAdvocatePhoneNumber()+"</td>"
				+ "<td>"+DC_Committee.getCaseDetails()+"</td>"
				+ "</tr></tbody></table>";
		 String Response="<h2>Dc Committe Report per complaintNumber</h2><br>"
		 		+ "complaintNumber: "+DC_Committee.getComplaintNumber()+""
		 + "Name: "+DC_Committee.getName()+""
		 + "Place: "+DC_Committee.getPlace()+""
		 + "AgainstAdvocate: "+DC_Committee.getAgainstAdvocate()+""
		 + "Remarks: "+DC_Committee.getRemarks()+""
		 + "Reason: "+DC_Committee.getReason()+""
		 
		 + "CaseDate: "+DC_Committee.getCaseDate()+""
		 + "ComplaintPhoneNumber: "+DC_Committee.getComplaintPhoneNumber()+""
		 + "AgainstAdvocatePhoneNumber: "+DC_Committee.getAgainstAdvocatePhoneNumber()+""
		 + "CaseDetails: "+DC_Committee.getCaseDetails()+"";
		 
		 
		return responseString;
		}
		catch(Exception e)
	
		{
		e.printStackTrace();
		return "Sorry, Its not updated Try Again Later";
		}
	}

	@Override
	public String GetDetailsForInWorldTappal(String InworldNumber) {
		
		String responseString="Sorry The In world Number is not correct please try again later.";
		try
		{
			
			System.out.println(InworldNumber + "InworldNumber2");
			Session Session = HibernateUtil.getSessionFactory().openSession();
			Session.beginTransaction();
			Query query = Session.createQuery("from Tappal_Inworld where InworldNumber = :InworldNumber ");
			query.setParameter("InworldNumber", InworldNumber);
			 @SuppressWarnings("unchecked")
			ArrayList<Tappal_Inworld> list = (ArrayList<Tappal_Inworld>)query.list();
			Tappal_Inworld absentList= list.get(0);
			
		if (list.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>Name</th><th>Address</th>"
	  +  "<th>InworldNumber</th><th>Particular</th><th>Remarks</th>  </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+1+"</th>"
						    +  " <td><b> " +absentList.getName()+"</b></td>"
						      +  " <td><b> " +absentList.getAddress()+"</b></td>"
						      +  " <td><b> " +absentList.getInworldNumber()+"</b></td>"
						      +  " <td><b> " +absentList.getParticular()+"</b></td>"
						      +  " <td><b> " +absentList.getRemarks()+"</b></td>"
						      
						     ;
				
				  
			}
			    responseString += 
	 " </tbody> "+  "</table>"; 
			   
			   
		 
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public String GetDetailsForOutWorldTappal(String OutworldNumber) {
		
		String responseString="Sorry The In world Number is not correct please try again later.";
		try
		{
			Session Session = HibernateUtil.getSessionFactory().openSession();
			Session.beginTransaction();
			Query query = Session.createQuery("from Tappal_Outworld where OutworldNumber = :OutworldNumber ");
			query.setParameter("OutworldNumber", OutworldNumber);
			 @SuppressWarnings("unchecked")
			ArrayList<Tappal_Outworld> list = (ArrayList<Tappal_Outworld>)query.list();
			 Tappal_Outworld absentList= list.get(0);
			
		if (list.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>#</th>"
			   		+ "<th>Name</th><th>Address</th>"
	  +  "<th>OutworldNumber</th><th>Particular</th><th>Remarks</th> </th><th>Postal Charge</th>"
	  + " <th>Date</th> </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+1+"</th>"
						    +  " <td><b> " +absentList.getName()+"</b></td>"
						      +  " <td><b> " +absentList.getAddress()+"</b></td>"
						      +  " <td><b> " +absentList.getOutworldNumber()+"</b></td>"
						      +  " <td><b> " +absentList.getParticular()+"</b></td>"
						      +  " <td><b> " +absentList.getRemarks()+"</b></td>"
						        +  " <td><b> " +absentList.getPostalCharge()+"</b></td>"
						      +  " <td><b> " +absentList.getOutWorldDate()+"</b></td>"
						     ;
				
				  
			}
			    responseString += 
	 " </tbody> "+  "</table>"; 
			   
			   
		 
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public String GetDetailsForTappalAssert(String Name) {
		
		String responseString="Sorry The In world Number is not correct please try again later.";
		try
		{
			Session Session = HibernateUtil.getSessionFactory().openSession();
			Session.beginTransaction();
			Query query = Session.createQuery("from TappalAssertTable where User = :User ");
			query.setParameter("User", Name);
			 @SuppressWarnings("unchecked")
			ArrayList<TappalAssertTable> list = (ArrayList<TappalAssertTable>)query.list();
			 TappalAssertTable absentList= list.get(0);
			
		if (list.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>#</th>"
			   		+ "<th>Date</th> <th>Name</th><th>CPUAssertNumbe</th>"
	  +  "<th>CPUMake</th><th>HardwareConfiguration</th><th>IPAddress</th> </th><th>ITAssert</th>"
	  + " <th>MonitorAssertNumber</th>"
	  + " <th>MonitorMake</th>"
	  + " <th>MonitorSLNo</th>"
	  + " <th>PrinterMake</th>"
	  
 + " <th>PrinterModel</th>"
 + " <th>Remarks</th>"
 + " <th>Description</th>"
 
	  + " </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   
			   	   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+1+"</th>"
						     +  " <td><b> " +absentList.getInsertedDate()+"</b></td>"
						    +  " <td><b> " +absentList.getUserName()+"</b></td>"
						      +  " <td><b> " +absentList.getCPUAssertNumber()+"</b></td>"
						      +  " <td><b> " +absentList.getCPUMake()+"</b></td>"
						      +  " <td><b> " +absentList.getHardwareConfiguration()+"</b></td>"
						      +  " <td><b> " +absentList.getIPAddress()+"</b></td>"
						        +  " <td><b> " +absentList.getITAssert()+"</b></td>"
						      +  " <td><b> " +absentList.getMonitorAssertNumber()+"</b></td>"
  +  " <td><b> " +absentList.getMonitorMake()+"</b></td>"
						      +  " <td><b> " +absentList.getMonitorSLNo()+"</b></td>"
						      +  " <td><b> " +absentList.getPrinterMake()+"</b></td>"
						      +  " <td><b> " +absentList.getPrinterModel()+"</b></td>"
						      +  " <td><b> " +absentList.getRemarks()+"</b></td>"
						      +  " <td><b> " +absentList.getDescription()+"</b></td>"   
						     
						     ;
				
				  
			}
			    responseString += 
	 " </tbody> "+  "</table>"; 
			   
			   
		 
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public String WelfareReprt(String ReportType) {
		
		return null;
	}

	@Override
	public String GetMonthlyReportForWelfarePortalFee(Date StartDate, Date EndDate, String Particulars) {
		
		java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
		Connection con = null;
		String responseString = " Error while processing please try again later ";
		try 
		{
			System.out.println("********* GenerateAdmissionReport 123 ***************");
			 PreparedStatement PrepareStateMent = null; 
		/*Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		Query query = null;*/
			
			String OutputResult="not working";
			int resultoutput=0;
			Connection conn = null;
			System.out.println("Status " + Particulars);
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					
				      String sql;
				      Timestamp timestam;
				
				      String resou;
			
			
			
		
					// coming
					System.out.println("Coming Here All");
				      sql = " SELECT [EnrollmentId] "
				    		    +" ,[EDate] "
				    		    +" ,[ApplicantName] "
				    		     +" ,[ClaimAmount] "
				    		     +" ,[Description] "
				    		    		  +" ,[OrderNo] "
				    		      +",[OrderDate] "
				    		    		  +",[DeathDate] "
				    		     +" ,[City] "
				    		    
				    		 +" ,[State] "
				    		 +" ,[Pincode] "
				    		  +" ,[RetirmentDate] "
				    		  +" ,[RetiredReason] "
				    		 		  +" ,[status] "
				    		   +",[PaidStatus] "
				    		 		  +",[ApplicationDate] "
				    		  +" ,[BCMResolutionNo] "
				    		  +" ,[BCMResolutionDate] "    
				    		/*   +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	*/   
				    		     +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) AND status=?";	
			
				  String    sql2 = " SELECT [EnrollmentId] "
				    		    +" ,[EDate] "
				    		    +" ,[ApplicantName] "
				    		     +" ,[ClaimAmount] "
				    		     +" ,[Description] "
				    		    		  +" ,[OrderNo] "
				    		      +",[OrderDate] "
				    		    		  +",[DeathDate] "
				    		     +" ,[City] "
				    		    
				    		 +" ,[State] "
				    		 +" ,[Pincode] "
				    		  +" ,[RetirmentDate] "
				    		  +" ,[RetiredReason] "
				    		 		  +" ,[status] "
				    		   +",[PaidStatus] "
				    		 		  +",[ApplicationDate] "
				    		  +" ,[BCMResolutionNo] "
				    		  +" ,[BCMResolutionDate] "    
				    		/*   +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	*/   
				    		     +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (OrderDate BETWEEN ? AND ?) AND status=?";	
			
				      System.out.println(Particulars + "particualrs");
				      if(Particulars.equalsIgnoreCase("D"))
				      {
				    	  PrepareStateMent = conn.prepareStatement(sql2);  
				      }
				      else
				      {
				    	  PrepareStateMent = conn.prepareStatement(sql);  
				      }
				    
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
			
				PrepareStateMent.setString(3, Particulars.trim());
				
				ResultSet rs = PrepareStateMent.executeQuery();
				
				 
			     
		      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;
			      
			      if(Particulars.equalsIgnoreCase("D"))
			      {
			    	  responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL</b></center></h1>"
								+ "<h1><center><b>Death Advocates Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
					  
			      }
			      if(Particulars.equalsIgnoreCase("M"))
			      {
			    	  responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL</b></center></h1>"
								+ "<h1><center><b>Medical Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
					  
			      }
			      if(Particulars.equalsIgnoreCase("F"))
			      {
			    	  responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL</b></center></h1>"
								+ "<h1><center><b>Financial Hardship Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
					  
			      }
			      if(Particulars.equalsIgnoreCase("R"))
			      {
			    	  responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL</b></center></h1>"
								+ "<h1><center><b>Welfare Retired Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
					  
			      }
			     /* responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL</b></center></h1>"
							+ "<h1><center><b>Welfare Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
				*/	
			      responseString+="<table class='table table-bordered'><thead><tr>"
			      		+ "<th>SL No.</th>"
			      		+ "<th>Enrollment Number</th>"
			      		+ "<th>Name</th>"
			      		+ "<th>ClaimType</th><th>Resolution Number</th>"
		    			  +  "<th>Resolution Date</th><th>ClaimAmount</th><th>Description</th></tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();	
				   String KAR="";
				   String Name="";
			      while(rs.next()){
			         //Retrieve by column name
			    	 
			    		/* System.out.println("Coming Inside");
				    	  String ed=rs.getString("EnrollmentId");
				    	 int Enrollmentid = Integer.parseInt(ed);
				    String KARNumber = JSPRelatedFunctionsimp.GetDetailKARFromEnrollemntID(Enrollmentid);
				    		try
				    		{
				  String[] KarNameArray = KARNumber.split("mor");
				  KAR=KarNameArray[0];
				  Name=KarNameArray[1];
				    		}
				    		catch(Exception e)
				    		{
				    			e.pri
				    			
				    			ntStackTrace();
				    		}	 */  
			    	  
			    					 String Reason= rs.getString("status");
			    					 String Status="";
			    					if("D".equalsIgnoreCase(Reason))
			    					{
			    						Status="Death";
			    						
			    					}
			    					else if("R".equalsIgnoreCase(Reason))
			    					{
			    						Status="Retirement";
			    						
			    					}
			    					else if("M".equalsIgnoreCase(Reason))
			    					{
			    						Status="Medical";
			    						
			    					}
			    					else if("F".equalsIgnoreCase(Reason))
			    					{
			    						Status="Financial Hardship";
			    						
			    					}
			    					
			    					 resou=rs.getString("BCMResolutionNo");
			    					 timestam = rs.getTimestamp("BCMResolutionDate");
			    					if(resou==null)
			    					{
			    						resou=	rs.getString("OrderNo");
			    					}
			    					if(timestam==null)
			    					{
			    						timestam=	rs.getTimestamp("OrderDate");
			    					}
			    						   responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +rs.getString("EnrollmentId")+"</b></td>"
			    								   +  " <td><b> " +JSPRelatedFunctionsimp.GetName(rs.getString("EnrollmentId"))+"</b></td>"
			    								      
			    								    
			    								      +  " <td><b> " +Status+"</b></td>"
			    								    
			    								      +  " <td><b> " +resou+"</b></td>"
			    								     
			    								       +  " <td><b> " +timestam+"</b></td>"
			    								        +  " <td><b> " +rs.getInt("ClaimAmount")+"</b></td>"
			    								     
			    								        
			    								        
			    								        
			    								         +  " <td><b> " +rs.getString("Description")+"</b></td>"
			    								     
			    								    
			    								    
			    								    
			    								     
			    							  +" </tr>";
			    						   Index++;
			      }
			    								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();	
					 
				
		return responseString;
	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("end");
		} //end
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("end");
		return responseString;
	}

	@Override
	public String GenerateAllTheCertificateAtonce(String EnrollmentDate) {
		
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 String StartDate=EnrollmentDate;
	
		 JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp();
			
	
		 java.util.Date parsedStartDate = null;

		 java.sql.Date StartDateSQLdate=null;
	
		 /*java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		 System.out.println(date);*/
			try {
				parsedStartDate =  format.parse(StartDate);
			
				  StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDateSQLdate.getTime());	
			Connection con = null;
			String responseString = " Error while processing please try again later ";
			
			try 
			{
				System.out.println("********* GenerateAdmissionReport 123 ***************");
				 PreparedStatement PrepareStateMent = null; 
			/*Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
			Session.beginTransaction();
			Query query = null;*/
				
				String OutputResult="not working";
				int resultoutput=0;
				Connection conn = null;
				
				try {

					//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
					/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
					String user = "sa";
					String pass = "ksbc@123";
					System.out.println("Hi");
					
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					conn = DriverManager.getConnection(dbURL, user, pass);*/
					try
					{
					 conn = JDBCUtil.GetConnection();
					 
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					if (conn != null) {
						DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
					//	 java.sql.Statement stmt = conn.createStatement();
						
					      String sql;
				
					
				
				
				
				
			
						// coming
						System.out.println("Coming Here All");
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,EnrollmentDate,EnrollmentId FROM EnrollmentDetails where EnrollmentDate=?  ORDER BY   RollNo Asc ";
						System.out.println(StartDate1  + " StartDate1");
				 PrepareStateMent = conn.prepareStatement(sql);
				 PrepareStateMent.setTimestamp(1,StartDate1);
			/*		PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);  
					*/
				 ResultSet rs = PrepareStateMent.executeQuery();
					
					
					System.out.println("Not coming");
					int Index=1;
					System.out.println();
					
			 //sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
						
					responseString="	<!DOCTYPE html> "
							+"<html> "
							+"<head> "
							+"<meta charset=\"ISO-8859-1\"> "
							+"<title>Insert title here</title> "
							+"<style type=\"text/css\"> "




							+".a { "
							 +"   width: 1px; "
							  +"  border: 1px white; "
							  +"  padding: 100px; "
							 +"   margin: 0px; "
							 +"} "

							/*+"body{ "
							 +"  page-break-inside: avoid; "
							 +"} "*/


							+"h1 { "
							+"page-break-before: always; "
							+"}   "
							+"	body{ "
							+"   page-break-inside: avoid;"
							+"	} "
							+"</style> "

							 
							+"</head> ";
				      while(rs.next()){
					   	 	 
						    	 String RollNo=rs.getString("RollNo");
						    	 Timestamp EnrollmentDate2 = rs.getTimestamp("EnrollmentDate");
						    	String name = rs.getString("Name");
						    	String EnrollmentRegistrationNo = rs.getString("EnrollmentRegistrationNo");
						    	int EnrollmentId =rs.getInt("EnrollmentId");
						    	String FatherName = rs.getString("FatherName");
						   // 	 sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
						    	
						    	
				      
						    	 responseString+=JSPRelatedFunctionsimp.GenerateCertificate(RollNo, FatherName, name, EnrollmentDate2,EnrollmentRegistrationNo,EnrollmentId);
									
				      }
		return responseString;
	} // Connection

}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return responseString;
	}

	@Override
	public String GenerateStampSectionAssosiationMnthlyReport(LocalDate Start, LocalDate End) {
		
			String result="<h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
				+ "<h1><center><b>Monthly Report Of Association Report From: "+Start+" To: "+End+" </b></center></h1>";
		 result+= ""
			  		+ "<style>"
			  		+ "table {"
	    
			  	
	+ " border-collapse: separate; "
	+ "  empty-cells: hide; "
			  		
	   + "} "
	+ "</style>"
			  		
			  		+"<table class='table table-bordered'><thead><tr>"
	/*			 + " <th>      </th> "
					+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
	   	+ " <th>      </th> "
	   	+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
	   	
	  */
	  

			 	
			 		
			 
			 		
		 		+ "<th>Date</th>"
		 		+ "<th>netAmount</th>"
		 		  + " <th>grossAmount/th>"
		 		 + "<th>deduction</th>"
				 +  "<th>stampFee</th>"
				 
		 		
		 		+ "<th>totalStamps</th>"
   			 
   		
   			
   			  + "<th>Total</th>"
   			  + " </tr>"
   			  +  " </thead>"
   			  +  "<tbody>";
		long days=ChronoUnit.DAYS.between(Start, End);
		LocalDate NewDate = null;
		 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		for(int i=0;i<=days;i++)
		{
			 NewDate = Start.plusDays(i);
			
			 result  += JSPRelatedFunctionsimp.GetReportPerDateForStampAsc(NewDate);
			
			System.out.println(NewDate + "  New Dates");
		}
		
		System.out.println(days + "   Diff btw start and end");
		// add global variable here
	
		result+=" </tbody> "+  "</table>";
		result+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
		
		return result;
	}

	@Override
	public String GenerateStampSectionAssosiationDailyReport(Date FromDate) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI daily report");
	/*	Query query = Session.createQuery("from CashSectionMonthlyReport e  where (e.ChallanCreatedDate=:stDate )");
		query.setDate("stDate", FromDate);
		*/
		
		
		Query query = Session.createQuery("from StampSectionAssociationBean  e  where (e.ChallanCreatedDate=:stDate )  ");
		java.sql.Timestamp timestamp = new java.sql.Timestamp(FromDate.getTime());
		System.out.println(FromDate + "    From Date");
		System.out.println(timestamp + "   Time for report");
		query.setDate("stDate", timestamp);
		String ResponseResult="";
		 @SuppressWarnings("unchecked")
		
		 ArrayList<StampSectionAssociationBean> list = (ArrayList<StampSectionAssociationBean>)query.list();
		 System.out.println(list);
		
			 long stampFee=0;
			
			 long deduction=0;
			 Date ChallanCreatedDate;
			 long netAmount=0;
			 long totalStamps=0;
			 long postalCharges=0;
			 long grossAmount=0;
			 long totalAmount=0;

		 
		 
		 
		 String responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
					+ "<h1><center><b>Day Report Of the day : "+FromDate+"  </b></center></h1>";
			
		  responseString+=""
		  		+ "<style>"
		  		+ "table {"
    
   + " empty-cells: hide;"
   + "} "
+ "</style>"
		  		+ "<table class='table table-bordered'><thead><tr>"
				  + "<th>SL Number</th>"
				  + "<th>Association Name</th>"
				  + "<th>Receipt Number</th>"
				  + "<th>Mode Of Payment</th>"
				  + "<th>NetAmount</th>"
				  + "<th>GrossAmount</th>"
				  +  "<th>TotalStamps</th><th>Postal Charges</th> "
				  + ""
				  + ""
				  + "<th>Remarks</th></tr>"
				  +  " </thead>"
				  +  "<tbody>";
						   int Index=1;
						   for (StampSectionAssociationBean RegBean : list) {
							   
							   
							 
							
							  deduction+=RegBean.getDeduction();
						
							  netAmount+=RegBean.getNetAmount();
							  totalStamps+=RegBean.getTotalStamps();
							  postalCharges+=RegBean.getPostalCharges();
							  grossAmount+=RegBean.getGrossAmount();
							  totalAmount+=RegBean.getTotalAmount();
							  responseString+="<tr>"
									  
									  
									  + "<td>"+Index+"</td>"
									  + "<td>"+RegBean.getAssociationName()+"</td>"
								/*	  + "<td>"+RegBean.getPaymentMode()+"</td>" */
									
									   + "<td>"+RegBean.getReceiptNumber()+"</td>"
							   + "<td>"+RegBean.getPaymentMode()+"</td>"
							  /*		+ "<td>"+RegBean.getDeduction()+"</td>"*/
							  		+ "<td>"+RegBean.getNetAmount()+"</td>"
							  		+ "<td>"+RegBean.getGrossAmount()+"</td>"
							  		+ "<td>"+RegBean.getTotalStamps()+"</td>"
							  		+ "<td>"+RegBean.getPostalCharges()+"</td>"
							  		  + "<td>"+RegBean.getRemarks()+"</td>" 
							  	/*	+ "<td>"+RegBean.getTotalAmount()+"</td>"*/
							  		+ ""
							  		+ ""
							  		+ "</tr>";  
							  Index++;
							  } // FOr loop
						  
						   responseString += /* " <td><b> " 
				      
				      
				
			  "*/
				 " </tbody> "+  "</table>"; 
						  
		 Session.close();
		 
		 // adding both DD and cash
		 
		
		  responseString+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
			
		return responseString; 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String GenerateStampSectionIndividualMnthlyReport(LocalDate Start, LocalDate End) 
	{
		
		String result="<h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
			+ "<h1><center><b>Monthly Report Of Individual Report From: "+Start+" To: "+End+" </b></center></h1>";
	 result+= ""
		  		+ "<style>"
		  		+ "table {"
    
		  	
+ " border-collapse: separate; "
+ "  empty-cells: hide; "
		  		
   + "} "
+ "</style>"
		  		
		  		+"<table class='table table-bordered'><thead><tr>"
/*			 + " <th>      </th> "
				+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
   	+ " <th>      </th> "
   	+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
   	
  */
		 		
		  		
	 		+ "<th>Date</th>"
	 		 + "<th>Net Amount</th>"
	 		+ " <th>Gross Amount</th>"
	 		+ " <th>Discount Amount</th>"
	 		+ "<th>postalCharges</th>"	
	 	
			 +  "<th>stampFee</th>"
			
	 	
	 		+ "<th>totalStamps</th>"
			 
		
			  
			  + "<th>Total</th>"
			  + " </tr>"
			  +  " </thead>"
			  +  "<tbody>";
	long days=ChronoUnit.DAYS.between(Start, End);
	LocalDate NewDate = null;
	 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
	for(int i=0;i<=days;i++)
	{
		 NewDate = Start.plusDays(i);
		
		 result  += JSPRelatedFunctionsimp.GetReportPerDateForStampIndividual(NewDate);
		
		System.out.println(NewDate + "  New Dates");
	}
	
	System.out.println(days + "   Diff btw start and end");
	// add global variable here

	result+=" </tbody> "+  "</table>";
	result+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
	
	return result;
}

	@Override
	public String GenerateStampSectionIndividualDailyReport(Date FromDate) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI daily report");
	/*	Query query = Session.createQuery("from CashSectionMonthlyReport e  where (e.ChallanCreatedDate=:stDate )");
		query.setDate("stDate", FromDate);
		*/
		
		
		Query query = Session.createQuery("from StampSectionIndividualBean  e  where (e.ChallanCreatedDate=:stDate )  ");
		java.sql.Timestamp timestamp = new java.sql.Timestamp(FromDate.getTime());
		System.out.println(FromDate + "    From Date");
		System.out.println(timestamp + "   Time for report");
		query.setDate("stDate", timestamp);
		String ResponseResult="";
		 @SuppressWarnings("unchecked")
		
		 ArrayList<StampSectionIndividualBean> list = (ArrayList<StampSectionIndividualBean>)query.list();
		 System.out.println(list);
		
			 long stampFee=0;
			
			 long deduction=0;
			 Date ChallanCreatedDate;
			 long netAmount=0;
			 long totalStamps=0;
			 long postalCharges=0;
			 long grossAmount=0;
			 long totalAmount=0;

		 
		 
		 
		 String responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
					+ "<h1><center><b>Day Report Of the day : "+FromDate+"  </b></center></h1>";
			
		  responseString+=""
		  		+ "<style>"
		  		+ "table {"
    
   + " empty-cells: hide;"
   + "} "
+ "</style>"
		  		+ "<table class='table table-bordered'><thead><tr>"
				  + "<th>SL Number</th><th>Name</th>"
				  + "<th>Place</th>"
				  + "<th>Receipt Number</th>"
				  + "<th>Mode Of Payment</th>"
				
				  +  "<th>Net Amount</th>"
				  + "<th>Gross Amount</th>"
				  + "<th>Total Stamp</th> <th>Postal Charge</th>"
				 
				    + "<th>Remarks</th></tr>"
				  +  " </thead>"
				  +  "<tbody>";
						   int Index=1;
						   for (StampSectionIndividualBean RegBean : list) {
							   
							   
							    stampFee+=RegBean.getStampFee();
							
						
						
							  netAmount+=RegBean.getNetAmount();
							  totalStamps+=RegBean.getTotalStamps();
							  postalCharges+=RegBean.getPostalCharges();
							  grossAmount+=RegBean.getGrossAmount();
							  totalAmount+=RegBean.getTotalAmount();
							  responseString+="<tr>"
									  + "<td>"+Index+"</td>" 
									  
									  + "<td>"+RegBean.getName()+"</td>"
									
									
									   
									  
							  	/*	+ "<td>"+RegBean.getStampFee()+"</td>"*/
							  		+ "<td>"+RegBean.getPlace()+"</td>"
							  		+ "<td>"+RegBean.getReceiptNumber()+"</td>"
							  			+ "<td>"+RegBean.getPaymentMode()+"</td>"
							  		+ "<td>"+RegBean.getNetAmount()+"</td>"
							  		+ "<td>"+RegBean.getGrossAmount()+"</td>"
							  		+ "<td>"+RegBean.getTotalStamps()+"</td>"
							  		+ "<td>"+RegBean.getPostalCharges()+"</td>"
							  		  + "<td>"+RegBean.getRemarks()+"</td>" 
						/*	  		+ "<td>"+RegBean.getTotalAmount()+"</td>"*/
							  		+ ""
							  		+ ""
							  		+ "</tr>";  
							  Index++;
							  } // FOr loop
						  
						   responseString += /* " <td><b> " 
				      
				      
				
			  "*/
				 " </tbody> "+  "</table>"; 
						  
		 Session.close();
		 
		 // adding both DD and cash
		 
		
		  responseString+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
			
		return responseString; 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String GetReportPerDateForStampIndividual(LocalDate Start) {
		
		String Response="";
		
		System.out.println("BCI");
		StampSectionAssociationBean StampSectionAssociationBean = new StampSectionAssociationBean();
		 Date ChallanCreatedDate;
		 long stampFee=0;
			
		 long deduction=0;
		
		 long netAmount=0;
		 long totalStamps=0;
		 long postalCharges=0;
		 long grossAmount=0;
		 long totalAmount=0;
		 
		
			 
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from StampSectionIndividualBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<StampSectionIndividualBean> list = (ArrayList<StampSectionIndividualBean>)query.list();
		System.out.println(list + "   List from BCI_FDSBean");
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp(); 
		
		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (StampSectionIndividualBean bci_FDSBean2 : list) {
				 
				 
				
				 
							 
				  stampFee+=bci_FDSBean2.getStampFee();
					
				 
				 postalCharges+= bci_FDSBean2.getPostalCharges();
				
				  netAmount+=bci_FDSBean2.getNetAmount();
				  totalStamps+=bci_FDSBean2.getTotalStamps();
				
				  grossAmount+=bci_FDSBean2.getGrossAmount();
				  totalAmount+=bci_FDSBean2.getTotalAmount();
				 
				 
				
				 
				 
			}
			
			 
			 Response="<tr> "

					 

			 		+ "<td><b> "+Start+"</b></td>"
			 		+ "<td><b>"+netAmount+"</b></td>"
			 		+ "<td><b>"+grossAmount+"</b></td>"
			 			+ "<td><b>"+(grossAmount-netAmount)+"</b></td>"
			 		+ "<td><b>"+postalCharges+"</b></td>"
			 		
			 		+ "<td><b>"+stampFee+"</b></td>"
			 		
			 		+ "<td><b>"+totalStamps+"</b></td>"
			 		
			 		

			 		+ "<td><b>"+grossAmount+"</b></td>"
			 			+ "</tr>";
		 }
		 
			 
		 
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		
		return Response;
	}

	@Override
	public String GetReportPerDateForStampAsc(LocalDate Start) {
		
		String Response="";
		
		System.out.println("BCI");
		StampSectionAssociationBean StampSectionAssociationBean = new StampSectionAssociationBean();
		 Date ChallanCreatedDate;
		 long stampFee=0;
			
		 long deduction=0;
		
		 long netAmount=0;
		 long totalStamps=0;
		 long postalCharges=0;
		 long grossAmount=0;
		 long totalAmount=0;
		 
		
			 
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from StampSectionAssociationBean where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<StampSectionAssociationBean> list = (ArrayList<StampSectionAssociationBean>)query.list();
		System.out.println(list + "   List from BCI_FDSBean");
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp(); 
		
		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 for (StampSectionAssociationBean bci_FDSBean2 : list) {
				 
				 
				
				 
							 
				  stampFee+=bci_FDSBean2.getStampFee();
					
				  deduction+=bci_FDSBean2.getDeduction();
				 postalCharges+= bci_FDSBean2.getPostalCharges();
				
				  netAmount+=bci_FDSBean2.getNetAmount();
				  totalStamps+=bci_FDSBean2.getTotalStamps();
				
				  grossAmount+=bci_FDSBean2.getGrossAmount();
				  totalAmount+=bci_FDSBean2.getTotalAmount();
				 
				 
				
				 
				 
			}
			/*long total1=	(long) deduction+stampFee+	 netAmount+totalStamps+grossAmount;
			*/
			 
			 Response="<tr> "

					 

			 		+ "<td><b> "+Start+"</b></td>"
			 		
			 		
			 		
			 		+ "<td><b>"+netAmount+"</b></td>"
			 		+ "<td><b>"+grossAmount+"</b></td>"
			 		+ "<td><b>"+deduction+"</b></td>"
			 		+ "<td><b>"+stampFee+"</b></td>"
			 		+ "<td><b>"+totalStamps+"</b></td>"
			 	
			 		

			 		+ "<td><b>"+grossAmount+"</b></td>"
			 			+ "</tr>";
		 }
		 
			 
		 
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		
		return Response;
	}

	@Override
	public String JSPForToDoListOfDcAccount() {
		
		String responseString="Sorry TODO list is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<CashSectionMonthlyReportFlow> absentList=JSPRelatedFunctionsimp.ToDoListForDcAccount();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>SL Number</th>"
			   		+ "<th>Receipt Number</th><th>Date</th><th>Particulars</th><th>Enroll Number</th><th>place</th>"
	  +  "<th>Amount</th><th>Done</th></tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int index=1;
			   for (CashSectionMonthlyReportFlow RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'> " +index+"</th>"
						    +  " <td><b> " +RegBean.getReceiptNo()+"</b></td>"
						     +  " <td><b> " +RegBean.getChallanCreatedDate()+"</b></td>"
						    +  " <td><b> " +RegBean.getParticulars()+"</b></td>"
						      +  " <td><b> " +RegBean.getEnrollNo()+"</b></td>"
						      +  " <td><b> " +RegBean.getPlace()+"</b></td>"
						      +  " <td><b> " +RegBean.getAmount()+"</b></td>"
						    
						    
				   +"   <td><b> <button name='Confirm' class=\"btn btn-info\" onclick=\" CallToServletFromJSPForWelfareTodoList('"+RegBean.getReceiptNo() +"');\" >Done</button></b></td>"
				  
				   +"   <td><b> <button name='Confirm' class=\"btn btn-info\" onclick=\" CallToServletFromJSPForWelfareTodoList('"+RegBean.getReceiptNo() +"');\" >Delete</button></b></td>";
					  
				   index++;
			   }
	  
			   responseString += 
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public ArrayList<CashSectionMonthlyReportFlow> ToDoListForDcAccount() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from CashSectionMonthlyReportFlow where Particulars='KSBC ComplaintFee'");
		
		 @SuppressWarnings("unchecked")
		ArrayList<CashSectionMonthlyReportFlow> list = (ArrayList<CashSectionMonthlyReportFlow>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public String JSPForToDoListOfTappal() {
		
		String responseString="Sorry TODO list is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<CashSectionMonthlyReportFlow> absentList=JSPRelatedFunctionsimp.ToDoListForTappal();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>SL Number</th>"
			   		+ "<th>Receipt Number</th><th>Date</th><th>Particulars</th><th>Enroll Number</th><th>place</th>"
	  +  "<th>Amount</th> <th>Done</th></tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int index=1;
			   for (CashSectionMonthlyReportFlow RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'> " +index+"</th>"
						    +  " <td><b> " +RegBean.getReceiptNo()+"</b></td>"
						     +  " <td><b> " +RegBean.getChallanCreatedDate()+"</b></td>"
						    +  " <td><b> " +RegBean.getParticulars()+"</b></td>"
						      +  " <td><b> " +RegBean.getEnrollNo()+"</b></td>"
						      +  " <td><b> " +RegBean.getPlace()+"</b></td>"
						      +  " <td><b> " +RegBean.getAmount()+"</b></td>"
						    
						    
				   +"   <td><b> <button name='Confirm' class=\"btn btn-info\" onclick=\" CallToServletFromJSPForWelfareTodoList('"+RegBean.getReceiptNo() +"');\" >Done</button></b></td>";
				   index++;
			   }
	  
			   responseString += 
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public ArrayList<CashSectionMonthlyReportFlow> ToDoListForTappal() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from CashSectionMonthlyReportFlow  where Particulars='KSBC ComplaintFee'");
		
		 @SuppressWarnings("unchecked")
		ArrayList<CashSectionMonthlyReportFlow> list = (ArrayList<CashSectionMonthlyReportFlow>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public String JSPForToDoListOfStamp() {
		
		String responseString="Sorry TODO list is Empty";
		try
		{
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<CashSectionMonthlyReportFlow> absentList=JSPRelatedFunctionsimp.ToDoListForStamp();
		
		if (absentList.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>SL Number</th>"
			   		+ "<th>Receipt Number</th><th>Date</th><th>Particulars</th><th>Enroll Number</th><th>place</th>"
	  +  "<th>Amount</th><th>STAMP</th> <th>Done</th></tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   int index=1;
			   for (CashSectionMonthlyReportFlow RegBean : absentList) {
				   responseString +=  " <tr>"
						    +  "  <th scope='row'> " +index+"</th>"
						    +  " <td><b> " +RegBean.getReceiptNo()+"</b></td>"
						     +  " <td><b> " +RegBean.getChallanCreatedDate()+"</b></td>"
						    +  " <td><b> " +RegBean.getParticulars()+"</b></td>"
						      +  " <td><b> " +RegBean.getEnrollNo()+"</b></td>"
						      +  " <td><b> " +RegBean.getPlace()+"</b></td>"
						      +  " <td><b> " +RegBean.getAmount()+"</b></td>"
						    
						      +  " <td><b> " +RegBean.getSTAMP()+"</b></td>"
				   +"   <td><b> <button name='Confirm'  class=\"btn btn-info\" onclick=\" CallToServletFromJSPForWelfareTodoList('"+RegBean.getReceiptNo() +"');\" >Done</button></b></td>";
				   index++;
			   }
	  
			   responseString += 
	 " </tbody> "+  "</table>"; 
			   
			   
		 }
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public ArrayList<CashSectionMonthlyReportFlow> ToDoListForStamp() {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from CashSectionMonthlyReportFlow where STAMP>0");
		
		 @SuppressWarnings("unchecked")
		ArrayList<CashSectionMonthlyReportFlow> list = (ArrayList<CashSectionMonthlyReportFlow>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
	}

	@Override
	public String GetMonthlyReportForNewEnrollmentFee(Date StartDate, Date EndDate, String Particulars) {
		
		java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
		Connection con = null;
		String responseString = " Error while processing please try again later ";
		try 
		{
			System.out.println("********* GenerateAdmissionReport 123 ***************");
			 PreparedStatement PrepareStateMent = null; 
		/*Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		Query query = null;*/
			
			String OutputResult="not working";
			int resultoutput=0;
			Connection conn = null;
			System.out.println("Status " + Particulars);
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					
				      String sql;
			
				
			
			
			
			
		
					// coming
					System.out.println("Coming Here All");
				      sql = " SELECT [EnrollmentId] "
				    		    +" ,[EDate] "
				    		    +" ,[ApplicantName] "
				    		     +" ,[ClaimAmount] "
				    		     +" ,[Description] "
				    		    		  +" ,[OrderNo] "
				    		      +",[OrderDate] "
				    		    		  +",[DeathDate] "
				    		     +" ,[City] "
				    		    
				    		 +" ,[State] "
				    		 +" ,[Pincode] "
				    		  +" ,[RetirmentDate] "
				    		  +" ,[RetiredReason] "
				    		 		  +" ,[status] "
				    		   +",[PaidStatus] "
				    		 		  +",[ApplicationDate] "
				    		  +" ,[BCMResolutionNo] "
				    		  +" ,[BCMResolutionDate] "    
				    		/*   +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	*/   
				    		     +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) AND status=?";	
			 PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
			
				PrepareStateMent.setString(3, Particulars.trim());
				
				ResultSet rs = PrepareStateMent.executeQuery();
				
				 
			     
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;
			      responseString="<table class='table table-bordered'><thead><tr><th>SL No.</th><th>Enrollment Number</th><th>ClaimType</th><th>Resolution Number</th>"
		    			  +  "<th>Resolution Date</th><th>ClaimAmount</th><th>Description</th></tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      while(rs.next()){
			         //Retrieve by column name
			    	 
			    					   
			    					 String Reason= rs.getString("status");
			    					 String Status="";
			    					if("D".equalsIgnoreCase(Reason))
			    					{
			    						Status="Death";
			    						
			    					}
			    					else if("R".equalsIgnoreCase(Reason))
			    					{
			    						Status="Retirement";
			    						
			    					}
			    					else if("M".equalsIgnoreCase(Reason))
			    					{
			    						Status="Medical";
			    						
			    					}
			    					else if("F".equalsIgnoreCase(Reason))
			    					{
			    						Status="Financial Hardship";
			    						
			    					}
			    						   responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +rs.getString("EnrollmentId")+"</b></td>"
			    								     
			    								    
			    								      +  " <td><b> " +Status+"</b></td>"
			    								    
			    								      +  " <td><b> " +rs.getString("BCMResolutionNo")+"</b></td>"
			    								     
			    								       +  " <td><b> " +rs.getTimestamp("BCMResolutionDate")+"</b></td>"
			    								        +  " <td><b> " +rs.getInt("ClaimAmount")+"</b></td>"
			    								     
			    								        
			    								        
			    								        
			    								         +  " <td><b> " +rs.getString("Description")+"</b></td>"
			    								     
			    								    
			    								    
			    								    
			    								     
			    							  +" </tr>";
			    						   Index++;
			      }
			    								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();	
					 
				
		return responseString;
	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("end");
		} //end
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("end");
		return responseString;
	}

	@Override
	public String GetMonthlyReportForResumbption(Date StartDate, Date EndDate, String Particulars) {
		
		java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
		Connection con = null;
		String responseString = " Error while processing please try again later ";
		try 
		{
			System.out.println("********* GenerateAdmissionReport 123 ***************");
			 PreparedStatement PrepareStateMent = null; 
		/*Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		Query query = null;*/
			
			String OutputResult="not working";
			int resultoutput=0;
			Connection conn = null;
			System.out.println("Status " + Particulars);
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					
				      String sql;
			
				
			
			
			
			
		
					// coming
					System.out.println("Coming Here All");
				      sql = " SELECT [EnrollmentId] "
				    		    +" ,[ResumptionDate] "
				    		    +" ,[Reason] "
				    		     +" ,[EnteredOn] "
				    		     
				    		/*   +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	*/   
				    		     +" FROM [dbo].[hst_Receipts_Resumption]  WHERE (ResumptionDate BETWEEN ? AND ?) ";	
			 PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
			
				
				ResultSet rs = PrepareStateMent.executeQuery();
				
				 
			     String KAR="";
			     String Name="";
			      int Index=1;
			      
			      responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
							+ "<h1><center><b>Enrollment Election Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
					
			      responseString+="<table class='table table-bordered'><thead><tr><th>SL No.</th>"
			      		+ "<th>Enrollment Number</th>"
			      		+ "<th>Name</th>"
			      		+ ""
			      		+ "<th>Resumption Date</th><th>Reason</th>"
		    			 
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();	
			    	
			      while(rs.next()){
			         //Retrieve by column name
			    	 System.out.println("Coming Inside");
			    	  String ed=rs.getString("EnrollmentId");
			    	 int Enrollmentid = Integer.parseInt(ed);
			    String KARNumber = JSPRelatedFunctionsimp.GetDetailKARFromEnrollemntID(Enrollmentid);
			    		try
			    		{
			  String[] KarNameArray = KARNumber.split("mor");
			  KAR=KarNameArray[0];
			  Name=KarNameArray[1];
			    		}
			    		catch(Exception e)
			    		{
			    			e.printStackTrace();
			    		}
			    String Status="";
			    					
			    						   responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +KAR+"</b></td>"
			    								     +  " <td><b> " +Name+"</b></td>"
			    								         +  " <td><b> " +rs.getTimestamp("ResumptionDate")+"</b></td>"
			    								   
			    								      +  " <td><b> " +rs.getString("Reason")+"</b></td>"
			    								     
			    								     
			    								    
			    								    
			    								     
			    							  +" </tr>";
			    						   Index++;
			      }
			    								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();	
					 
				
		return responseString;
	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("end");
		} //end
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("end");
		return responseString;
	}

	@Override
	public String GetMonthlyReportForTransfor(Date StartDate, Date EndDate, String Particulars) {
		
		java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
		Connection con = null;
		String responseString = " Error while processing please try again later ";
		try 
		{

		      String KAR="";
			     String Name="";
			System.out.println("********* GenerateAdmissionReport 123 ***************");
			 PreparedStatement PrepareStateMent = null; 
		/*Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		Query query = null;*/
			
			String OutputResult="not working";
			int resultoutput=0;
			Connection conn = null;
			System.out.println("Status " + Particulars);
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					
				      String sql;
			
				
			
			
			
		
					// coming
					System.out.println("Coming Here All");
				      sql = " SELECT [EnrollmentId] "
				    		    +" ,[TransferType] "
				    		    +" ,[TransferredDate] "
				    		    + ",[NOCNo]" 
				    		    +" ,[ReasonForTransfer] "
				    		     +" ,[DateChanged] "
				    		     
				    		/*   +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	*/   
				    		     +" FROM [dbo].[Hst_Enrollment_Transfer]  WHERE (TransferredDate BETWEEN ? AND ?) ";	
			 PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
			
				
				ResultSet rs = PrepareStateMent.executeQuery();
				
			
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;
			      
			      responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
							+ "<h1><center><b>Enrollment Transfer Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
					
			      responseString+="<table class='table table-bordered'><thead><tr><th>SL No.</th>"
			      		+ "<th>Enrollment Number</th>"
			      		+ "<th>Name</th>"
			      		+ "<th>Transferred Date</th>"
			       		+ "<th>NOC Number</th>"
			      		+ "<th>Reason</th>"
		    			  +  "<th>Entered On</th><</tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      while(rs.next()){
			         //Retrieve by column name
			    	 
			    		String ed=rs.getString("EnrollmentId");
						int edInt = Integer.parseInt(ed);
						  JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();	
					    	
						
						 String KARNumber = JSPRelatedFunctionsimp.GetDetailKARFromEnrollemntID(edInt);
				    		try
				    		{
				  String[] KarNameArray = KARNumber.split("mor");
				  KAR=KarNameArray[0];
				  Name=KarNameArray[1];
				    		}
				    		catch(Exception e)
				    		{
				    			KAR="";
								  Name="";
				    			e.printStackTrace();
				    		}	   
			    					
				    	
				    		
			    					 String Status=rs.getString("ReasonForTransfer");
			    					 if (Status.equals("1"))
			    					 {
			    						 Status="Family Transferred"; 
			    					 }
			    					 else if (Status.equals("1"))
			    					 {
			    						 Status="Shifting To Native"; 
			    					 }
			    					 else if (Status.equals("1"))
			    					 {
			    						 Status="Better Prospects";
			    					 }
			    					 
			    					
			    						   responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +KAR+"</b></td>"
			    								      +  " <td><b> " +Name+"</b></td>"
			    								     
			    								      +  " <td><b> " +rs.getTimestamp("TransferredDate")+"</b></td>"
			    								       +  " <td><b> " +rs.getString("NOCNo")+"</b></td>"
			    								   
			    								      +  " <td><b> " +Status+"</b></td>"
			    								     
			    								       +  " <td><b> " +rs.getTimestamp("DateChanged")+"</b></td>"
			    								      
			    								    
			    								    
			    								     
			    							  +" </tr>";
			    						   Index++;
			      }
			    								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();	
					 
				
		return responseString;
	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("end");
		} //end
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("end");
		return responseString;
	}

	@Override
	public String GetMonthlyReportForSuspend(Date StartDate, Date EndDate, String Particulars) {
		
		java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
		Connection con = null;
		String responseString = " Error while processing please try again later ";
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		try 
		{
			System.out.println("********* GenerateAdmissionReport 123 ***************");
			 PreparedStatement PrepareStateMent = null; 
		/*Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		Query query = null;*/
			
			String OutputResult="not working";
			int resultoutput=0;
			Connection conn = null;
			System.out.println("Status " + Particulars);
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					
				      String sql;
			
				
			
			
			
			
		
					// coming
					System.out.println("Coming Here All");
				      sql = " SELECT [EnrollmentID] "
				    		    +" ,[SuspendType] "
				    		    +" ,[SuspendedOn] " 
				    		    +" ,[SuspendedRemarks] "
				    		     +" ,[DateChanged] "
				    		     
				    		/*   +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	*/   
				    		     +" FROM [dbo].[Hst_Enrollment_Suspend]  WHERE (DateChanged BETWEEN ? AND ?) ";	
			 PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
			
				
				ResultSet rs = PrepareStateMent.executeQuery();
				
				 
			     
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;
			      
			      responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
							+ "<h1><center><b>Enrollment Suspended Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
					
			      responseString+="<table class='table table-bordered'>"
			      		+ "<thead>"
			      		+ "<tr><th>SL No.</th>"
			      		+ "<th>Enrollment Number</th>"
			      		+ "<th>Name</th>"
			      		+ "<th>SuspendedOn</th>"
			      		+ "<th>Suspended Type</th>"
			      		+ "<th>Reason</th>"
		    			  +  "<th>Entered On</th></tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      String Status="";
			      String KARNumber="";
			      String Name="";
			      
			      EnrollmentDetails ed=null;
			      while(rs.next()){
			         //Retrieve by column name
			    	  KARNumber=rs.getString("EnrollmentId");
			    	  
			    	  ed = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
			    	  String SuspendType = rs.getString("SuspendType");
			    	  if(ed!=null)
			    	  {
			    		 Name= ed.getName();
			    	  }
			    	  if("V".equalsIgnoreCase(SuspendType))
			    	  {
			    		  Status="Voluntary"; 
			    	  }
			    	  else if ("S".equalsIgnoreCase(SuspendType))
			    	  {
			    		  Status="Others";   
			    	  }
			    					
			    				
			    					
			    						   responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +KARNumber+"</b></td>"
			    								      +  " <td><b> " +Name+"</b></td>"
			    								      +  " <td><b> " +rs.getTimestamp("SuspendedOn")+"</b></td>"
			    								    +  " <td><b> " +Status+"</b></td>"
			    								     
			    								      +  " <td><b> " +rs.getString("SuspendedRemarks")+"</b></td>"
			    								     
			    								       +  " <td><b> " +rs.getTimestamp("DateChanged")+"</b></td>"
			    								      
			    								    
			    								    
			    								     
			    							  +" </tr>";
			    						   Index++;
			      }
			    								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();	
					 
				
		return responseString;
	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("end");
		} //end
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("end");
		return responseString;
	}

	@Override
	public String GetDetailKARFromEnrollemntID(int EnrollmentID) {
		
		
	

		
		
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = "";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "select RollNo,Name from [dbo].[EnrollmentDetails] "
			      
			      		+ "  WHERE EnrollmentId=?";
			      
			      
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setInt(1, EnrollmentID);
	
		
	
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      while(rs.next())
			      {
			    	  responseString=  rs.getString("RollNo")+"mor"+rs.getString("Name"); 
			      }
			   
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String UpdateWelfareEnrollDate(String EnrollmentID, Date WelfareDate) {
		
		
	
	    java.sql.Timestamp ts1 = new java.sql.Timestamp(WelfareDate.getTime());
		
		
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "UPDATE [dbo].[EnrollmentDetails] "
			      		+ "  SET   [WelfareMember] = 'Y'"
			      		+ ",  [WelfareMemberUpdatedDate] =?"
			      		+ "  WHERE RollNo=?";
			      
			      
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(2, EnrollmentID);
		PrepareStateMent.setTimestamp(1, ts1);
		
	
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming UpdateWelfare Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String GetReportPerDateForSeniorAdv(LocalDate Start) {
		
		String Response="";
		
		System.out.println("BCI");
		StampSectionAssociationBean StampSectionAssociationBean = new StampSectionAssociationBean();
		
		
			 
		
		
		try
		{
			java.util.Date date = Date.from(Start.atStartOfDay()
			        .atZone(ZoneId.systemDefault()).toInstant());
			    Timestamp timeStamp = new Timestamp(date.getTime());
			   	
			System.out.println(timeStamp + "   Comparing timestamp");
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from SeniorAdvocateTable where ChallanCreatedDate = :ChallanCreatedDate ");
		query.setTimestamp("ChallanCreatedDate", timeStamp);
		 @SuppressWarnings("unchecked")
		ArrayList<SeniorAdvocateTable> list = (ArrayList<SeniorAdvocateTable>)query.list();
		System.out.println(list + "   List from BCI_FDSBean");
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp= new JSPRelatedFunctionsimp(); 
		
		 if (list==null)
		 {
			 Response="Sorry List is empty";	 
		 }
		 else 
		 {
			 int index=1;
			 for (SeniorAdvocateTable bci_FDSBean2 : list) {
				 
				 
				
				 
				 Response+="<tr> "

+ "<td><b> "+index+"</b></td>"

			 		
			 		+ "<td><b>"+bci_FDSBean2.getEnrollNo()+"</b></td>"
			 		
			 	
			 		+ "<td><b>"+bci_FDSBean2.getName()+"</b></td>"
			 		+ "<td><b>"+bci_FDSBean2.getPlace()+"</b></td>"
			 		+ "<td><b>"+bci_FDSBean2.getAmount()+"</b></td>"
			 		+ "<td><b> "+Start+"</b></td>"
+ "<td><b>"+bci_FDSBean2.getYearOfPayed()+"</b></td>"
			 		
			 			+ "</tr>";
				 
				 index++;	
				 
				 
			}
		
			 
			
		 }
		 
			 
		 
		 
		 
		 // Please do For all other paarameters
		
		//  Session.beginTransaction().commit();
		 Session.close();
		// return "Success";
		}
		catch (Exception e)
		{
			return "";
		}
	
	
		
		System.out.println(Response);
		
		return Response;
	}

	@Override
	public String GenerateSeniorAdvMnthlyReport(LocalDate Start, LocalDate End) 
	{
		
		String result="<h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
			+ "<h1><center><b>Monthly Report Of Senior Advocate Report From: "+Start+" To: "+End+" </b></center></h1>";
	 result+= ""
		  		+ "<style>"
		  		+ "table {"
    
		  	
+ " border-collapse: separate; "
+ "  empty-cells: hide; "
		  		
   + "} "
+ "</style>"
		  		
		  		+"<table class='table table-bordered'><thead><tr>"
/*			 + " <th>      </th> "
				+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
   	+ " <th>      </th> "
   	+ " <th>   </th><th>     </th> <th>   </th><th>     </th>"
   	
  */			
	 		
	 		+ "<th>SL Number</th>"	
	 		+ "<th>Enrollment Number</th>"	
	 	
			 +  "<th>Name</th>"
			 + "<th>Place</th>"
	 	
	 		+ "<th>Amount</th>"
			 
+ "<th>Date</th>"
			  + " <th>Year Of Payed</th>"
			 
			  + " </tr>"
			  +  " </thead>"
			  +  "<tbody>";
	long days=ChronoUnit.DAYS.between(Start, End);
	LocalDate NewDate = null;
	 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
	for(int i=0;i<=days;i++)
	{
		 NewDate = Start.plusDays(i);
		
		 result  += JSPRelatedFunctionsimp.GetReportPerDateForSeniorAdv(NewDate);
		
		System.out.println(NewDate + "  New Dates");
	}
	
	System.out.println(days + "   Diff btw start and end");
	// add global variable here

	result+=" </tbody> "+  "</table>";
	result+="<p align=\"right\"> <b>Designed and Developed By SAS Info Solutions</b></p>";
	
	return result;
}

	@Override
	public String GetDetailEnrollemntIDFromKAR(String EnrollmentID) {
		
		
	

		
		
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = "";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "select EnrollmentId  from [dbo].[EnrollmentDetails] "
			      
			      		+ "  WHERE RollNo=?";
			      
			      
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, EnrollmentID);
	
		
	
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      while(rs.next())
			      {
			    	  responseString=  rs.getString("EnrollmentId"); 
			      }
			   
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String GenerateCertificateForBond(String KARNumber, String FatherName, String Name,
			Timestamp EnrollmentDate, String REGNumber, int EnrollmentID) {
   
        /*String date="";*/
        
          
            Date date1 = Date.valueOf(EnrollmentDate.toLocalDateTime().toLocalDate());  
            JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
            
            int SLNumber = JSPRelatedFunctionsimp.GetSLNumberofChairmanSignature(EnrollmentDate); 
    	
            String NameChairman="";
            if(SLNumber>0)
    		{
    			Session Session = HibernateUtil.getSessionFactory().openSession();
    			
    			
    			ChairmanSignature signatureBean = (ChairmanSignature)Session.get(ChairmanSignature.class, SLNumber);
    			 NameChairman = signatureBean.getName();
    		}
    		
            String dateString=date1.toString();
            String date="";
     date=convertDateToWords(dateString);
        String    resultString="<!DOCTYPE html>"
            +"<html>"
    +"<head>"
+"<meta charset=\"ISO-8859-1\">"
+"<title>Bond</title>"
+"</head>"
+"<body>"




+"<br><br><br><br><br><br><br>"

+"<div align=\"center\"><font face=\" Arial\" size=\"5px\">KARNATAKA STATE BAR COUNCIL: BANGALORE 1</font></div>"
+"  <br><br><br><br>"
      +"  <div style=\"margin-left:8%\"><font face=\" Arial\" size=\"4px\"> Reg. No. : "+REGNumber+"</font></div><br>"
       +"     <div style=\"margin-left:8%\"><font face=\" Arial\" size=\"4px\"> Roll No. : "+KARNumber+"</font></div>"
     
            +" <br>"
       
     +"  <p align=\"center\"> <font face=\"Arial\" size=\"4px\">This is to certify that<br> </font></p>"
      +"  <p style=\"margin-left:12%\"> <font face=\"Arial\" size=\"4px\">Shri/Smt <b>"+Name+"</b></font>"
    
     +"   <p style=\"margin-left:12%\"><font face=\"  Arial\" size=\"4px\">Son/Daughter of Shri <b>"+FatherName+"</b></font></p>"
        
        +"  <p style=\"margin-left:12% \"><font face=\"  Arial\" size=\"4px\">was admitted as an Advocate on the Roll of Karnataka State Bar Council </font></p>"
       
        +"  <p style=\" margin-left:12% \"><font face=\"  Arial\" size=\"4px\"> and Signed the Roll on <b>"+date+"</b> Under the provision</font></p>"

+"  <p style=\"margin-left:12% \"><font face=\"  Arial\" size=\"4px\"> of Section 22 of the Advocates Act,1961 </font></p>"
       +" <p align=\"center\"><font face=\"  Arial\" size=\"4px\">(Central Act XXV of 1961)</font></p>"
     
    +"   <br></br>"
 
 

       
       +"<div> "     
  +"    <table style=\"margin-left:72%; top:50% \">"
  //+" <tr><th>&nbsp;&nbsp;&nbsp;&nbsp<img src=\"ChairmanSign.jpg\" alt=\"signature\"  width=\"90px\" height=\"90px\"/></th></tr> "
  +" <tr><td><font face=\" Arial\">("+NameChairman+")</font></td></tr>"
     +"<tr><td><font face=\" Arial\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CHAIRMAN</font></td></tr>"
    +"</table> "
+"  </div>  "
      
      
      +"</body>"
+"</html> "


; 
                return resultString;
            }

	@Override
	public int CheckInTransfer(String KARNumber) {
		
		Connection con = null;
		int Index=0;
		JSPRelatedFunctionsimp  JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		EnrollmentDetails ed = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
		
		try 
		{

		     	 PreparedStatement PrepareStateMent = null; 
		Connection conn = null;
			
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					
				      String sql;
			
				
			
			
			
		
				
				      sql = " SELECT [EnrollmentId] "
				    		 
				    		     
				    		/*   +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	*/   
				    		     +" FROM [dbo].[Hst_Enrollment_Transfer]  WHERE (EnrollmentId = ?) ";	
			 PrepareStateMent = conn.prepareStatement(sql);
				
				PrepareStateMent.setInt(1,ed.getEnrollmentId());
				
				
				ResultSet rs = PrepareStateMent.executeQuery();
				
			
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			  
			         while(rs.next()){
			        	 Index=1;  
			    	  
			      }
			    								      
			    				  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();	
					 
				
		return Index;
	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("end");
		} //end
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("end");
		return Index;
	}

	@Override
	public int CheckInSuspend(String KARNumber) {
		
		
		Connection con = null;
		int Index=0;
		try 
		{

		     	 PreparedStatement PrepareStateMent = null; 
		Connection conn = null;
			
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					
				      String sql;
			
				
			
			
			
		
				
				      sql = " SELECT [EnrollmentID] "
				    		 
				    		     
				    		/*   +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	*/   
				    		     +" FROM [dbo].[Hst_Enrollment_Suspend]  WHERE (EnrollmentID = ?) ";	
			 PrepareStateMent = conn.prepareStatement(sql);
			 PrepareStateMent.setString(1,KARNumber);
				
			
				
				ResultSet rs = PrepareStateMent.executeQuery();
				
			
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			  
			         while(rs.next()){
			        	 Index=1;  
			    	  
			      }
			    								      
			    				  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();	
					 
				
		return Index;
	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("end");
		} //end
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("end");
		return Index;
	}

	@Override
	public int CheckInResumption(String KARNumber) {
		
		Connection con = null;
		int Index=0;
		JSPRelatedFunctionsimp  JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		EnrollmentDetails ed = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
		
		try 
		{

		     	 PreparedStatement PrepareStateMent = null; 
		Connection conn = null;
			
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
				/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					
				      String sql;
			
				
			
			
			
		
				
				      sql = " SELECT [EnrollmentId] "
				    		 
				    		     
				    		/*   +" FROM [dbo].[Enrollment_WelfareFundClaims]  WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	*/   
				    		     +" FROM [dbo].[hst_Receipts_Resumption]  WHERE (EnrollmentId = ?) ";	
			 PrepareStateMent = conn.prepareStatement(sql);
			 PrepareStateMent.setInt(1,ed.getEnrollmentId());
				
			
				
				ResultSet rs = PrepareStateMent.executeQuery();
				
			
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			  
			         while(rs.next()){
			        	 Index=1;  
			    	  
			      }
			    								      
			    				  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();	
					 
				
		return Index;
	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("end");
		} //end
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("end");
		return Index;
	}

	@Override
	public String CheckForStatus(String KARNumber) {
		
		
		JSPRelatedFunctionsimp  JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		int resum = JSPRelatedFunctionsimp.CheckInResumption(KARNumber);
		int Suspend = JSPRelatedFunctionsimp.CheckInSuspend(KARNumber);
		int Transfer = JSPRelatedFunctionsimp.CheckInTransfer(KARNumber);
		
		String Result="<h1>PresentMember</h1>";
		
		if (resum>0)
		{
			Result="<h1>Resumption</h1>";
		}
		else	if (Suspend>0)
		{
			Result="<h1>Suspended</h1>";
		}
		else if (Transfer>0)
		{
			Result="<h1>Transfered</h1>";
		}
		return Result;
	}

	@Override
	public String GetMonthlyReportForClaim(Date StartDate, Date EndDate, String Particulars) {
		
		
		
		java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
	
		
		
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
		
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT [EnrollmentId] "
    +" ,[EDate] "
    +" ,[ApplicantName] "
     +" ,[ClaimAmount] "
     +" ,[Description] "
    		  +" ,[OrderNo] "
      +",[OrderDate] "
    		  +",[DeathDate] "
     +" ,[City] "
    
 +" ,[State] "
 +" ,[Pincode] "
  +" ,[RetirmentDate] "
  +" ,[RetiredReason] "
 		  +" ,[status] "
   +",[PaidStatus] "
 		  +",[ApplicationDate] "
  +" ,[BCMResolutionNo] "
  +" ,[BCMResolutionDate] "    
     
     +" FROM [dbo].[Enrollment_WelfareFundClaims] WHERE (BCMResolutionDate BETWEEN ? AND ?) ";	
			 PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;
			      responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL</b></center></h1>"
							+ "<h1><center><b>Welfare Claim Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
					
			      responseString+="<table class='table table-bordered'><thead><tr><th>SL No.</th><th>Enrollment Number</th>"
			    		  + "<th>Name</th>"
			      		+ "<th>ClaimType</th><th>Resolution Number</th>"
		    			  +  "<th>Resolution Date</th><th>ClaimAmount</th><th>Description</th></tr>"
		    			  +  " </thead>"
		    			  +  "<tbody>";
			      JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new	 JSPRelatedFunctionsimp();
			      Timestamp bmcdate=null;
			      String KARNumber="";
			      String bcmreso="";
			      String Name="";
			      while(rs.next()){
			         //Retrieve by column name
			    	 
			    					   
			    					 String Reason= rs.getString("status");
			    					 String Status="";
			    					if("D".equalsIgnoreCase(Reason))
			    					{
			    						Status="Death";
			    						
			    					}
			    					else if("R".equalsIgnoreCase(Reason))
			    					{
			    						Status="Retirement";
			    						
			    					}
			    					else if("M".equalsIgnoreCase(Reason))
			    					{
			    						Status="Medical";
			    						
			    					}
			    					else if("F".equalsIgnoreCase(Reason))
			    					{
			    						Status="Financial Hardship";
			    						
			    					}
			    					  bcmreso = rs.getString("BCMResolutionNo");
								     
			    					bmcdate = rs.getTimestamp("BCMResolutionDate");
			    					
			    					if(bcmreso==null)
			    					{
			    						  bcmreso = rs.getString("OrderNo");
			    						
			    					}
			    					if(bmcdate==null)
			    					{
			    						bmcdate = rs.getTimestamp("OrderDate");
			    						
			    					}
			    					 KARNumber=rs.getString("EnrollmentId");
			    					EnrollmentDetails ed = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
			    					
			    					try {
			    						Name=ed.getName();
										if(Name==null)
										{
											Name="";
										}
									} catch (Exception e) {
										// TODO: handle exception
										Name="";
									}
			    						   responseString +=  " <tr>"
			    								    +  "  <th scope='row'>"+Index+"</th>"
			    								    +  " <td><b> " +rs.getString("EnrollmentId")+"</b></td>"
			    								     
			    								      +  " <td><b> " +Name+"</b></td>"
			    								      +  " <td><b> " +Status+"</b></td>"
			    								    
			    								      +  " <td><b> " +bcmreso+"</b></td>"
			    								     
			    								       +  " <td><b> " +bmcdate+"</b></td>"
			    								        +  " <td><b> " +rs.getInt("ClaimAmount")+"</b></td>"
			    								     
			    								        
			    								        
			    								        
			    								         +  " <td><b> " +rs.getString("Description")+"</b></td>"
			    								     
			    								    
			    								    
			    								    
			    								     
			    							  +" </tr>";
			    						   Index++;
			      }
			    								      
			      responseString+=	 " </tbody> "+  "</table>"; 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	/* resultoutput=Count;
			    	 System.out.println(Count);
			       */ /* int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);*/
			      
			      //STEP 6: Clean-up environment
			      
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String NewEnrollmentPieChart() {
		
		JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		ArrayList<CashSectionMonthlyReportFlow> ListOfTask = JSPRelatedFunctionsimp.ToDoListForNewEnrollment();
		long EnrollmentFee=0;
		long ChangeOfAddress=0;
		long KSBCChangeOfAddress=0;
		long KSBCVSP=0;
		long KSBCCertificateCopyCharges=0;
		long KSBCContinuityCertificate=0;
		long Resumption=0;
		String Particulars="";
		
		for (CashSectionMonthlyReportFlow cashSectionMonthlyReportFlow : ListOfTask) {
			
			Particulars=cashSectionMonthlyReportFlow.getParticulars();
		
			  if (Particulars=="Enrollment Fee")
			  {
				  EnrollmentFee+=1;
			  }
		  else  if (Particulars=="Change Of Address")
		  {
			  ChangeOfAddress+=1;
		  }
		  else  if (Particulars=="KSBC Change Of Address")
		  {
			  ChangeOfAddress+=1;
			  
		 }
		  
		  else  if (Particulars=="KSBC VSP")
		  {
			  KSBCVSP+=1;
		  }
		  
		  else  if (Particulars=="KSBC Certificate Copy Charges")
		  {
			  KSBCCertificateCopyCharges+=1;
		  }
		  else  if (Particulars=="KSBC Continuity Certificate")
		  {
			  KSBCContinuityCertificate+=1;
		  }
		  else  if (Particulars=="Resumption")
		  {
			  Resumption+=1;
		  }
		 
		}
		
		String result="[ "
					+"{ "
					+"	value:"+ ChangeOfAddress+", "
					+"	color: \"cornflowerblue\", "
					+"	highlight: \"lightskyblue\", "
					+"	label: \"Change Of Address\" "
					+"	}, "
					+"	{ "
					+"	value: "+ KSBCCertificateCopyCharges+", "
					+"	color: \"lightgreen\", "
					+"	highlight: \"yellowgreen\", "
					+"	label: \"KSBC Certificate Copy Charges\" "
					+"	}, "
					+"	{ "
					+"	value: "+ KSBCContinuityCertificate+", "
					+"	color: \"lightgreen\", "
					+"	highlight: \"yellowgreen\", "
					+"	label: \"KSBC Continuity Certificate\" "
					+"	}, "
					
					+"	{ "
					+"	value: "+ KSBCVSP+", "
					+"	color: \"lightgreen\", "
					+"	highlight: \"yellowgreen\", "
					+"	label: \"VSP\" "
					+"	}, "
					
					+"	{ "
					+"	value: "+ Resumption+", "
					+"	color: \"lightgreen\", "
					+"	highlight: \"yellowgreen\", "
					+"	label: \"Resumption\" "
					+"	}, "
					
					
					+"{ "
					+"	value: "+ EnrollmentFee+", "
					+"	color: \"orange\", "
					+"	highlight: \"darkorange\", "
					+"	label: \"EnrollmentFee\" "
					+"	}"
					+"	];";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String AccountPieChart() {
		
		return null;
	}

	@Override
	public String WelfarePieChart() {
		
		return null;
	}

	@Override
	public String DCPieChart() {
		
		return null;
	}

	@Override
	public String TappalPieChart() {
		
		return null;
	}

	@Override
	public String StampSectionPieChart() {
		
		return null;
	}

	@Override
	public String GetMonthlyReportForLifeTime(Date StartDate, Date EndDate, String Particulars)
	{
		
		
		
		java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
	
		
		
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
		
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql="SELECT SeniorMemberUpdatedDate,RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks FROM EnrollmentDetails WHERE ((EnrollmentDate BETWEEN ? AND ?)  AND (WelfareLifeTimeMember='y')) ORDER BY EnrollmentId";

			      
			      PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("Life Time !!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			      int Index=1;
			      responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL</b></center></h1>"
							+ "<h1><center><b>Welfare Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
					
			      responseString+="<table class='table table-bordered'><thead><tr><th>#</th>"
			      		+ "<th>RollNo</th><th>Name</th>"
			  			 
			  			  + "<th>Place Of Practice</th>"
			  			  + "<th>Date</th> </tr>"
			  			  +  " </thead>"
			  			  +  "<tbody>";
				      while(rs.next()){
				    	
			    		 responseString +=  " <tr>"
									    +  "  <th scope='row'>"+Index+"</th>"
									    +  " <td><b> " +rs.getString("RollNo")+"</b></td>"
									     
										+  " <td><b> " +rs.getString("Name")+"</b></td>"
										
									/*	+  " <td><b> " +rs.getString("FatherName")+"</b></td>"*/
											
											+  " <td><b> " +rs.getString("Place_Of_Practice")+"</b></td>"
											+  " <td><b> " +rs.getTimestamp("SeniorMemberUpdatedDate")+"</b></td>"	
									
											/*+  " <td><b> " +rs.getString("Communication_Address1")+"</b></td>"	*/
									
										/*+  " <td><b> " +rs.getString("DateOfBirth")+"</b></td>"
										+  " <td><b> " +rs.getString("Permanent_City")+"</b></td>"
										+  " <td><b> " +rs.getString("WelfareMember")+"</b></td>"*/
									   
									     
							   +" </tr>"; 
							   Index++;
				      }
							   responseString+=	 " </tbody> "+  "</table><br></br><br></br>";
							   rs.close();
							      PrepareStateMent.close();
							      conn.close();
				
						 			
			    	/* resultoutput=Count;
			    	 System.out.println(Count);
			       */ /* int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);*/
			      
			      //STEP 6: Clean-up environment
			      
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String UpdateRemarks(String KARNumber, String Remarks) {
		
		
		
		//System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = " Error while processing please try again later ";
		if (Remarks==null)
		{
			Remarks="";
		}
		
		try {
			JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
			String Preremarks = JSPRelatedFunctionsimp.GetRemarks(KARNumber);
			
			if (Preremarks==null)
			{
				Preremarks="";
			}
			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
					      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = "UPDATE [dbo].[EnrollmentDetails] "
			      	
			      		+ "set  [Remarks] =?"
			      		+ "  WHERE RollNo=?";
			      
			      
			
			   
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(2, KARNumber);
		PrepareStateMent.setString(1, (Preremarks+", "+Remarks));
		
	
			      int rs = PrepareStateMent.executeUpdate();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			    
			      
			      if (rs>0)
			      {
			    	  
			    	  System.out.println("Coming UpdateWelfare Welfare ***********************************");
			    	  responseString="Sucessfully Updated";	  
			      }
			      else
			      {
			    	  responseString="Error occured Please try again later";	
			      }
			     
			      PrepareStateMent.close();
			      conn.close();				
			    	
			}

		} catch (SQLException ex) {
			  responseString="Error occured Please try again later";	
			     ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";	
	}

	@Override
	public String GetRemarks(String KARNumber) {
		
		
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = "  ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
		
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT remarks FROM EnrollmentDetails where RollNo=? ";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber);
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			  
			     
			      while(rs.next()){
			         
			    						   responseString =  rs.getString("remarks");
			    						
			    						  }
			    								      
			 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	      
			}

		} catch (SQLException ex) {
			
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		
		if(responseString==null)
		{
			responseString="";
		}
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public ScheduleConfirmationBean GetConfirmBean(String RegNumber) {
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ScheduleConfirmationBean where REGNumber =:REGNumber");
		query.setString("REGNumber", RegNumber);
		
		 @SuppressWarnings("unchecked")
		ArrayList<ScheduleConfirmationBean> list = (ArrayList<ScheduleConfirmationBean>)query.list();
		 Session.close();
		return list.get(0);
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public String GetClaimRemarksForWelfare(String KARNumber) {
		
		
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = "  ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
		
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT [EnrollmentId] "
    +" ,[EDate] "
    +" ,[ApplicantName] "
     +" ,[ClaimAmount] "
     +" ,[Description] "
    		  +" ,[OrderNo] "
      +",[OrderDate] "
    		  +",[DeathDate] "
     +" ,[City] "
    
 +" ,[State] "
 +" ,[Pincode] "
  +" ,[RetirmentDate] "
  +" ,[RetiredReason] "
 		  +" ,[status] "
   +",[PaidStatus] "
 		  +",[ApplicationDate] "
  +" ,[BCMResolutionNo] "
  +" ,[BCMResolutionDate] "    
     
     +" FROM [dbo].[Enrollment_WelfareFundClaims] where EnrollmentId=? ";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber);
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			  
			     
			      while(rs.next()){
			         
			    						   responseString =  rs.getString("Description");
			    						
			    						  }
			    								      
			 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	      
			}

		} catch (SQLException ex) {
			responseString=ex.toString();
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public String GetName(String KARNumber) {
		
		
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = "  ";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
		
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT Name FROM EnrollmentDetails where RollNo=? ";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber);
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			  
			     
			      while(rs.next()){
			         
			    						   responseString =  rs.getString("Name");
			    						
			    						  }
			    								      
			 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	      
			}

		} catch (SQLException ex) {
			
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return responseString;
	
	
	//	return "String ";
	}

	@Override
	public int IsAdditionalInformationFromRegNumber(String REGnumber) {
		
		
		
		int res=0;
	
		Connection conn = null;
		
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
		/*	String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
		
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT EnrollmentRegistrationNo FROM Addnl_EnrollmentDetails where EnrollmentRegistrationNo=? ";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, REGnumber);
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			      //STEP 5: Extract data from result set
			//      String responseString = "Not coming SOrry";
			  
			     
			      while(rs.next()){
			         
			    						   res=1;			
			    						  }
			    								      
			 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	      
			}

		} catch (SQLException ex) {
			
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return res;
	
	
	//	return "String ";
	}

	@Override
	public String PriousAddtionalInformation(String REGNumber) {
		
		
		System.out.println(REGNumber + "   REGNumber");
		String response="";
		String DOBVerification="";
		String Indian="";
		String NonIndian_Reason="";
		String University="";
		String College="";
		int Year_Completed=0;
		String Course_Years="";
		String Business_Name="";
		String Partnership="";
		String Proprietorship="";
		String Prev_Application_Details="";
		String Prev_Service_Details="";
		String Dismissed_Details="";
		String Convicted_Details="";
		String Criminal_Details="";
		
		int res=0;
	
		Connection conn = null;
		
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
		
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT EnrollmentRegistrationNo"
			      		
+ ",EnrollmentId "
			      		
+ ",Name_In_Certificate "
+ ",DOBVerification "
+ ",Indian "
+ ",NonIndian_Reason "
+ ",University "
+ ",College "
+ ",Year_Completed "
+ ",Course_Years "
+ ",Business_Name "
+ ",Partnership "
+ ",Proprietorship "
+ ",Prev_Application_Details " 
+ ",Prev_Service_Details"
+ ",Dismissed_Details"
+ ",Convicted_Details"
+ ",Criminal_Details "
			      		+ " FROM Addnl_EnrollmentDetails where EnrollmentRegistrationNo=? ";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
			   
			   System.out.println(sql);
		PrepareStateMent.setString(1, REGNumber);
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println("!!!!!!!!!!!!!!@#$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%");
			  
			      while(rs.next()){
			     College=    rs.getString("College");
			     
			     System.out.println(rs.getString("College") + " coll");
			     University=    rs.getString("University");
			     
			     Prev_Application_Details=    rs.getString("Prev_Application_Details");
			     Prev_Service_Details=    rs.getString("Prev_Service_Details");
			   
			     Dismissed_Details=    rs.getString("Dismissed_Details");
			     Convicted_Details=    rs.getString("Convicted_Details");
			     Criminal_Details=    rs.getString("Criminal_Details");
			    
			     
			     
			     
			      DOBVerification= rs.getString("DOBVerification");
					 Indian=rs.getString("Indian");
					 NonIndian_Reason=rs.getString("NonIndian_Reason");
					 University=rs.getString("University");
					 College=rs.getString("College");
					 Year_Completed=rs.getInt("Year_Completed");
					 Course_Years=rs.getString("Course_Years");
					 Business_Name=rs.getString("Business_Name");
					 Partnership=rs.getString("Partnership");
			    						   res=1;			
			    						 }
			    								      
			 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();		
			      if(Business_Name==null)
			      {
			    	  Business_Name="";
			      }
			      if(Partnership==null)
			      {
			    	  Partnership="";
			      }
			      response	 = "div"+/*DOBVerification+"div"+*/
					/* Indian+"div"+*/
					 NonIndian_Reason+"div"+
					 University+"div"+
					 College+"div"+
					 Year_Completed+"div"+
					 Course_Years+"div"+
					 Business_Name+
					 Partnership+"div"+
					 Proprietorship+"div"+
					 Prev_Application_Details+"div"+
					 Prev_Service_Details+"div"+
					 Dismissed_Details+"div"+
					 Convicted_Details+"div"+
					 Criminal_Details+"div"+Indian;   
			      
			      System.out.println(response);
			}

		} catch (SQLException ex) {
			
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		return response;
	
	
	//	return "String ";
	}

	@Override
	public String GenerateIncomingReport(String PlaceOfPractice, Date StartDate, Date EndDate, String CastCategory,
			String GenderCategory) {
		
		java.sql.Timestamp StartDate1 = new java.sql.Timestamp(StartDate.getTime());
		java.sql.Timestamp EndDate1 = new java.sql.Timestamp(EndDate.getTime());
		Connection con = null;
		String responseString = " Error while processing please try again later ";
		
		try 
		{
			System.out.println("********* GenerateAdmissionReport 123 ***************");
			 PreparedStatement PrepareStateMent = null; 
		/*Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		Query query = null;*/
			
			String OutputResult="not working";
			int resultoutput=0;
			Connection conn = null;
			
			try {

				//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*	String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
				String user = "sa";
				String pass = "ksbc@123";
				System.out.println("Hi");
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(dbURL, user, pass);*/
				try
				{
				 conn = JDBCUtil.GetConnection();
				 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if (conn != null) {
					DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
					
				      String sql;
			
				
			
			
			
			
		if (PlaceOfPractice.equalsIgnoreCase("All"))
		{
			// No need to query on PlaceOFpractice
			if (GenderCategory.equalsIgnoreCase("All"))
			{
			
				// GenderCategory
				
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					// coming
					System.out.println("Coming Here All");
				sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM"
						+ " EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ? ) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;
					
			 PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);  
				
	
				}
				
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					// coming
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND CategoryId=1 ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;

					/* query = Session.createQuery("from ValidatedFinalBean e  where (e.EnrolledDate BETWEEN :stDate AND :edDate)   and ( e.castCategory =:Nominee )");
					query.setDate("stDate", StartDate);
					query.setDate("edDate", EndDate1); 
					query.setString("Nominee", "General");
*/		
					
					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
					/*	PrepareStateMent.setString(3, "General");*/
				
				
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{	
					// coming
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND CategoryId=2 ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;
				
					
					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
						/*PrepareStateMent.setString(3, "SC ST");*/
				}
				
				
			} // GenderCategory all ends
			else if (GenderCategory.equalsIgnoreCase("Male"))
			{
				
// CastCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					// coming
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND Gender='M' ORDER BY  EnrollmentDate  ASC,EnrollmentId";

						
						PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
						/*PrepareStateMent.setString(3, "Male");*/
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M') AND (CategoryId=1)  ORDER BY  EnrollmentDate  ASC,EnrollmentId";

				PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);
				/*PrepareStateMent.setString(3, "Male");
				PrepareStateMent.setString(4, "General");*/
					
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M') AND (CategoryId=2)  ORDER BY  EnrollmentDate  ASC,EnrollmentId";	
				
					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
					/*PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "SC ST");*/
					
					
				}
				
			}  // GenderCategory Male
			else if (GenderCategory.equalsIgnoreCase("Female"))
			{
// GenderCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') ORDER BY  EnrollmentDate  ASC,EnrollmentId";	

				
						PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
						/*PrepareStateMent.setString(3, "Male");*/
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=1) ORDER BY  EnrollmentDate  ASC,EnrollmentId";	
				

				PrepareStateMent = conn.prepareStatement(sql);
				PrepareStateMent.setTimestamp(1,StartDate1);
				PrepareStateMent.setTimestamp(2, EndDate1);
		/*		PrepareStateMent.setString(3, "Male");
				PrepareStateMent.setString(4, "General");*/
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{	sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) ORDER BY  EnrollmentDate  ASC,EnrollmentId";	

					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
				/*	PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "SC ST");*/
				}
				
				
			}  // GenderCategory Male
			
		}
		else
		{
			//  need to query on PlaceOFpractice
			if (GenderCategory.equalsIgnoreCase("All"))
			{
			
				// GenderCategory
				
				
				if (CastCategory.equalsIgnoreCase("All"))
				{	
					
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Communication_Address2,Remarks FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
					PrepareStateMent.setString(3, PlaceOfPractice);
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (CategoryId=1) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
					/*	PrepareStateMent.setString(3, "General");*/
						PrepareStateMent.setString(3, PlaceOfPractice);
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{ 
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (CategoryId=2) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
 
					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
						/*PrepareStateMent.setString(3, "SC ST");*/
						PrepareStateMent.setString(3, PlaceOfPractice);
				}
				
				
			} // GenderCategory all ends
			else if (GenderCategory.equalsIgnoreCase("Male"))
			{
				
// CastCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M') AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					 PrepareStateMent = conn.prepareStatement(sql);
						PrepareStateMent.setTimestamp(1,StartDate1);
						PrepareStateMent.setTimestamp(2, EndDate1);
					/*	PrepareStateMent.setString(3, "Male");*/
						PrepareStateMent.setString(4, PlaceOfPractice);
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{	sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M')AND (CategoryId=1) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
				 PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
				/*	PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "General");*/
						PrepareStateMent.setString(3, PlaceOfPractice);
					
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{	
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='M')AND (CategoryId=2) AND (Place_Of_Practice=?)  ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
				
					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
				/*	PrepareStateMent.setString(3, "Male");
					PrepareStateMent.setString(4, "SC ST");*/
						PrepareStateMent.setString(3, PlaceOfPractice);
					
				}
				
			}  // GenderCategory Male
			else if (GenderCategory.equalsIgnoreCase("Female"))
			{
// GenderCategory
				
				if (CastCategory.equalsIgnoreCase("All"))
				{
				
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrolledDate BETWEEN ? AND ?) AND (Gender='F') AND (Place_Of_Practice=?)   "
							+ "ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
					/*PrepareStateMent.setString(3, "FeMale");*/
					PrepareStateMent.setString(4, PlaceOfPractice);
					
					
					
				}
				else if (CastCategory.equalsIgnoreCase("General"))
				{
					
					
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=1) AND (Place_Of_Practice=?)   ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
					/*PrepareStateMent.setString(3, "FeMale");
					PrepareStateMent.setString(4, "General");*/
					PrepareStateMent.setString(3, PlaceOfPractice);	
		//SELECT RollNo,Name,Gender,FatherName,DateOfBirth,Permanent_City,WelfareMember
				}
				else if (CastCategory.equalsIgnoreCase("SC ST"))
				{
					sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?)   ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	

					PrepareStateMent = conn.prepareStatement(sql);
					PrepareStateMent.setTimestamp(1,StartDate1);
					PrepareStateMent.setTimestamp(2, EndDate1);
				/*	PrepareStateMent.setString(3, "FeMale");
					PrepareStateMent.setString(4, "SC ST");*/
					PrepareStateMent.setString(3, PlaceOfPractice);
				}
				
				
			}  // GenderCategory Male
			
		 // else download
		}
		
		ResultSet rs = PrepareStateMent.executeQuery();
		
	
		System.out.println("Not coming");
		int Index=1;
		System.out.println();
		
 //sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
		responseString="<br></br><br></br><br></br><br></br><h1><center><b>KARNATAKA STATE BAR COUNCIL Old KGID Building Bangalore</b></center></h1>"
				+ "<h1><center><b>Enrollment Income Transfer Report From: "+StartDate+" To: "+EndDate+" </b></center></h1>";
		
	      responseString+="<table class='table table-bordered'><thead><tr><th>#</th>"
	      		+ ""
	      		+ ""
	      		+ "<th>RollNo</th>"
	      		 
	      		+ "<th>Name</th>"
	      		+ "<th>DOB</th>"
	      		+ "<th>Enrollment Date</th>"
	      		+ "<th>Father Name</th>"
  			  + ""
  			
  			  + "<th>Communication Address</th>"
  			  + " <th>Remarks</th> </tr>"
  			  +  " </thead>"
  			  +  "<tbody>";
	      String communication1="";
	    	 String communication2="";
	    	 String communication3="";
	    	 String FatherName="";
	      while(rs.next()){

	    /*	 rs.getString("RollNo");
	    	 rs.getString("Name");
	    	 rs.getString("Gender");
	    	 rs.getString("FatherName");*/
//	    	 rs.getString("DateOfBirth");
	    //	 rs.getString("Permanent_City");
	    	// rs.getString("WelfareMember");
	   	
    	 FatherName=rs.getString("FatherName");
    	 communication1=rs.getString("Communication_Address1");
    	 communication2=rs.getString("Communication_Address2");
    	 communication3=rs.getString("Communication_Address3");
    	 try
    	 {
      	  
      	  if(FatherName==null)
  	    	 {
      		FatherName=""; 
  	    	 }
  	    	 }
      	  catch(Exception e)
  	    	 {
  	    		 e.printStackTrace();
  	    		FatherName="";  
  	    	 }
    	 String remarks="";
    	 try
    	 {
    	 if(communication1==null)
    	 {
    		 communication1=""; 
    	 }
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    		 communication1="";  
    	 }
    	 try
    	 {
    	   if(communication2==null)
    	 {
    		 communication2=""; 
    	 }
    	   
      }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    		 communication2="";  
    	 }
    	 try
    	 {
    	   if(communication3==null)
	    	 {
	    		 communication3=""; 
	    	 }
    	 }
    	   catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    		 communication3="";  
	    	 }
	    	 try
	    	 {
    	   remarks = rs.getString("Remarks");
    	  if(remarks==null)
	    	 {
    		  remarks=""; 
	    	 }
	    	 }
    	  catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    		 remarks="";  
	    	 }
	    	 
	   // 	 sql="SELECT RollNo,Name,EnrollmentRegistrationNo,FatherName,Gender,Place_Of_Practice,Communication_Address1,Communication_Address2,Communication_Address3,Remarks,EnrollmentDate,DateOfBirth FROM EnrollmentDetails_Inner_Trasfer WHERE (EnrollmentDate BETWEEN ? AND ?) AND (Gender='F') AND (CategoryId=2) AND (Place_Of_Practice=?) ORDER BY EnrollmentDate Asc, TRY_CAST (SUBSTRING(RollNo,CHARINDEX('/',RollNo)+1, CHARINDEX('/',RollNo,CHARINDEX('/',RollNo)+1) -CHARINDEX('/',RollNo)-1)as int)  Asc" ;	
	    	
	    		 responseString +=  " <tr>"
						    +  "  <th scope='row'>"+Index+"</th>"
						    +  " <td><b> " +rs.getString("RollNo")+"</b></td>"
						     
						
							+  " <td><b> " +rs.getString("Name")+"</b></td>"
						+  " <td><b> " +rs.getTimestamp("DateOfBirth")+"</b></td>"
						+  " <td><b> " +rs.getTimestamp("EnrollmentDate")+"</b></td>"
						+  " <td><b> " +FatherName+"</b></td>"
						/*	+  " <td><b> " +rs.getString("FatherName")+"</b></td>"*/
							/*	+  " <td><b> " +rs.getString("Gender")+"</b></td>"
								+  " <td><b> " +rs.getString("Place_Of_Practice")+"</b></td>"
							*/	+  " <td><b> " +(communication1+communication2+communication3)+"</b></td>"	
							/*	+  " <td><b> " +rs.getString("Communication_Address2")+"</b></td>"	
								+  " <td><b> " +rs.getString("Communication_Address3")+"</b></td>"	
						*/	/*+  " <td><b> " +rs.getString("Communication_Address1")+"</b></td>"	*/
							+  " <td><b> " +remarks+"</b></td>"	
							/*+  " <td><b> " +rs.getString("DateOfBirth")+"</b></td>"
							+  " <td><b> " +rs.getString("Permanent_City")+"</b></td>"
							+  " <td><b> " +rs.getString("WelfareMember")+"</b></td>"*/
						   
						     
				   +" </tr>"; 
				   Index++;
	      }
				   responseString+=	 " </tbody> "+  "</table><br></br><br></br>";
				   rs.close();
				      PrepareStateMent.close();
				      conn.close();
	
			 
		
			 
			
			}
				} // connection 
			
			catch (SQLException e)
			{
				e.printStackTrace();
				
			}
			
		}finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}}
		return responseString;
		
	
	}

	@Override
	public int GetSLNumberofChairmanSignature(java.sql.Timestamp FromAddress) {
		// TODO Auto-generated method stub
		try
		{
			java.sql.Timestamp StartDate1 = FromAddress;
			
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ChairmanSignature  AS c WHERE :Dat between FromDate and ToDate");
		query.setTimestamp("Dat", StartDate1);
		 @SuppressWarnings("unchecked")
		ArrayList<ChairmanSignature> list = (ArrayList<ChairmanSignature>)query.list();
		 Session.close();
		return list.get(0).getSerialNumber();
		}
		catch(Exception e)
		{
		return 0;	
		}
	}

	@Override
	public String GetDetailsForInWorldComplaintTappal(String InworldNumber) {
		
		String responseString="Sorry The In world Number is not correct please try again later.";
		try
		{
			
			System.out.println(InworldNumber + "InworldNumber2");
			Session Session = HibernateUtil.getSessionFactory().openSession();
			Session.beginTransaction();
			Query query = Session.createQuery("from TappalComplaintInword where InworldNumber = :InworldNumber ");
			query.setParameter("InworldNumber", InworldNumber);
			 @SuppressWarnings("unchecked")
			ArrayList<TappalComplaintInword> list = (ArrayList<TappalComplaintInword>)query.list();
			 TappalComplaintInword absentList= list.get(0);
			
		if (list.get(0)==null)
		{
		return responseString;	
		}
		
		else 
		{
			   responseString="<table class='table table-bordered'><thead><tr><th>#</th><th>Name</th><th>Address</th>"
	  +  "<th>Complaint InworldNumber</th><th>Particular</th><th>Remarks</th>  </tr>"
	  +  " </thead>"
	  +  "<tbody>";
			   
				   responseString +=  " <tr>"
						    +  "  <th scope='row'>"+1+"</th>"
						    +  " <td><b> " +absentList.getName()+"</b></td>"
						      +  " <td><b> " +absentList.getAddress()+"</b></td>"
						      +  " <td><b> " +absentList.getInworldNumber()+"</b></td>"
						      +  " <td><b> " +absentList.getParticular()+"</b></td>"
						      +  " <td><b> " +absentList.getRemarks()+"</b></td>"
						      
						     ;
				
				  
			}
			    responseString += 
	 " </tbody> "+  "</table>"; 
			   
			   
		 
		} // Try 
		catch (Exception e)
		{
			e.printStackTrace();
			return responseString;
		}
		return responseString;
	}

	@Override
	public String GetAIBRemarks(String KARNumber) {
		
		
		
		
		
		System.out.println(KARNumber +"  !!!!!!!!!!!!!!!");
		String OutputResult="not working";
		int resultoutput=0;
		Connection conn = null;
		String responseString = "";
		try {

			//String dbURL = "jdbc:sqlserver://107.180.71.40:4\\MSSQLSERVER";
			/*String dbURL="jdbc:sqlserver://107.180.71.40:49170;database=KSBCL;instanceName=MSSQLSERVER;";
			String user = "sa";
			String pass = "ksbc@123";
			System.out.println("Hi");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, user, pass);*/
			try
			{
			 conn = JDBCUtil.GetConnection();
			 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if (conn != null) {
		
			//	 java.sql.Statement stmt = conn.createStatement();
				
			      String sql;
			      //sql = "  select EnrollmentId   FROM [KSBCL].[dbo].[Enrollment_WelfareFundPayments] where EnrollmentId='KAR/1/2002'";
			      sql = " SELECT AIBRemarks,AIBdate FROM AIBTable where KARNumber=? ";
			   PreparedStatement PrepareStateMent = conn.prepareStatement(sql);
		PrepareStateMent.setString(1, KARNumber);
			   
			      ResultSet rs = PrepareStateMent.executeQuery();
			  System.out.println(responseString + " AIBArun" + KARNumber);
			     
			      while(rs.next()){
			         
			    						   responseString =  rs.getString("AIBRemarks")+"Div"+rs.getString("AIBdate");
			    						System.out.println(responseString + " AIBArunInside");
			    						  }
			    								      
			 					  
			      rs.close();
			      PrepareStateMent.close();
			      conn.close();				
			    	      
			}

		} catch (SQLException ex) {
			responseString=""+"Div"+"";
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	//	String responseString;
		
		if(responseString==null)
		{
			responseString=""+"Div"+"";
		}
		return responseString;
	
	
	//	return "String ";
	}

	
}

	

