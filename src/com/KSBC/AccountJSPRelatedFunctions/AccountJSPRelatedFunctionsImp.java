package com.KSBC.AccountJSPRelatedFunctions;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.KSBC.Bean.AbsentBean;
import com.KSBC.Bean.BillingStatusKAR;
import com.KSBC.Bean.EligibleKARChanges;
import com.KSBC.Bean.EligibleKARChangesConfirm;
import com.KSBC.Bean.EligibleKARChangescompleted;
import com.KSBC.Bean.Enrollment_WelfareFundPayments;
import com.KSBC.Bean.FeeStructureForEnrollmentConfirm;
import com.KSBC.Bean.FeeStructureForKAR;
import com.KSBC.Bean.FiveHundreadPayedAdvocateBean;
import com.KSBC.Bean.KAWFfeeStructure;
import com.KSBC.Bean.KAWFfeeStructureConfirm;
import com.KSBC.Bean.KAWFfeeStructureDone;
import com.KSBC.Bean.LifeTimeMembership;
import com.KSBC.Bean.PayedRegistrationChallan;
import com.KSBC.Bean.PayedRegistrationOnline;
import com.KSBC.Bean.RegistrationFormBean;
import com.KSBC.Bean.ThousandPayedAdvocateBean;
import com.KSBC.Bean.ValidatedPayedRegistrationChallan;
import com.KSBC.Bean.ValidatedPayedRegistrationOnline;
import com.KSBC.Util.HibernateUtil;

public class AccountJSPRelatedFunctionsImp implements AccountJSPRelatedFunctions {

	@Override
	public PayedRegistrationChallan GetChallanTransactionReportByRegNumber(String RegNumber) {
		// TODO Auto-generated method stub
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from PayedRegistrationChallan where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<PayedRegistrationChallan> list = (ArrayList<PayedRegistrationChallan>)query.list();
		 Session.close();
		return list.get(0);
	}

	@Override
	public ArrayList<RegistrationFormBean> GetAllChallanTransactionReport() {
		// TODO Auto-generated method stub
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
	public PayedRegistrationOnline GetOnlineTransactionReportByTransactionID(String TransactionID) {
		// TODO Auto-generated method stub
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from PayedRegistrationOnline where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", TransactionID);
		 @SuppressWarnings("unchecked")
		ArrayList<PayedRegistrationOnline> list = (ArrayList<PayedRegistrationOnline>)query.list();
		 Session.close();
		return list.get(0);
	}

	@Override
	public ArrayList<PayedRegistrationOnline> GetAllOnlineTransactionReport() {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from PayedRegistrationOnline");
		
		 @SuppressWarnings("unchecked")
		ArrayList<PayedRegistrationOnline> list = (ArrayList<PayedRegistrationOnline>)query.list();
		 Session.close();
		return list;
		}
		catch ( Exception e)
		{
		return null;	
		}
		
	}

	@Override
	public String MoveToVerifiedPayedRegistrationChallan(String RegNumber) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from RegistrationFormBean where RegNumber = :RegNumber ");
		query.setParameter("RegNumber", RegNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<RegistrationFormBean> list = (ArrayList<RegistrationFormBean>)query.list();
		 RegistrationFormBean PayedRegistrationChallan= list.get(0);
		 
		 ValidatedPayedRegistrationChallan ValidatedPayedRegistrationChallan= new ValidatedPayedRegistrationChallan();
		 ValidatedPayedRegistrationChallan.setRegNumber(PayedRegistrationChallan.getRegNumber());
		 ValidatedPayedRegistrationChallan.setAddress(PayedRegistrationChallan.getAddress());
		 ValidatedPayedRegistrationChallan.setAddressFromStep3(PayedRegistrationChallan.getAddressFromStep3());
		 ValidatedPayedRegistrationChallan.setBirthdate(PayedRegistrationChallan.getBirthdate());
		 ValidatedPayedRegistrationChallan.setBloodGroup(PayedRegistrationChallan.getBloodGroup());
		 ValidatedPayedRegistrationChallan.setBusinessDetails(PayedRegistrationChallan.getBusinessDetails());
		 ValidatedPayedRegistrationChallan.setCitizenOfIndia(PayedRegistrationChallan.getCitizenOfIndia());
		 ValidatedPayedRegistrationChallan.setCity(PayedRegistrationChallan.getCity());
		 ValidatedPayedRegistrationChallan.setCollege(PayedRegistrationChallan.getCollege());
		 ValidatedPayedRegistrationChallan.setConvictedDetails(PayedRegistrationChallan.getConvictedDetails());
		 ValidatedPayedRegistrationChallan.setDiscontinuanceOfPractice(PayedRegistrationChallan.getDiscontinuanceOfPractice());
		 ValidatedPayedRegistrationChallan.setEmail(PayedRegistrationChallan.getEmail());
		 ValidatedPayedRegistrationChallan.setFather_name(PayedRegistrationChallan.getFather_name());
		 ValidatedPayedRegistrationChallan.setFirst_name(PayedRegistrationChallan.getFirst_name());
		 ValidatedPayedRegistrationChallan.setFullName(PayedRegistrationChallan.getFullName());
		 ValidatedPayedRegistrationChallan.setNomineeDetails(PayedRegistrationChallan.getNomineeDetails());
		 ValidatedPayedRegistrationChallan.setNotAnClitizen(PayedRegistrationChallan.getNotAnClitizen());
		 ValidatedPayedRegistrationChallan.setNotAnClitizen(PayedRegistrationChallan.getNotAnClitizen());
		 ValidatedPayedRegistrationChallan.setOtherProfessional(PayedRegistrationChallan.getOtherProfessional());
		 ValidatedPayedRegistrationChallan.setPendingCriminalCases(PayedRegistrationChallan.getPendingCriminalCases());
		 ValidatedPayedRegistrationChallan.setPhone(PayedRegistrationChallan.getPhone());
		 ValidatedPayedRegistrationChallan.setPlaceOfPractice(PayedRegistrationChallan.getPlaceOfPractice());
		 ValidatedPayedRegistrationChallan.setPlaceOfPracticeFromStep2(PayedRegistrationChallan.getPlaceOfPracticeFromStep2());
		 ValidatedPayedRegistrationChallan.setPreviousApplicationDetails(PayedRegistrationChallan.getPreviousApplicationDetails());
		 ValidatedPayedRegistrationChallan.setPreviousEmployment(PayedRegistrationChallan.getPreviousEmployment());
		 ValidatedPayedRegistrationChallan.setProportionOfShare(PayedRegistrationChallan.getProportionOfShare());
		 ValidatedPayedRegistrationChallan.setRegNumber(PayedRegistrationChallan.getRegNumber());
		 ValidatedPayedRegistrationChallan.setState(PayedRegistrationChallan.getState());
		 ValidatedPayedRegistrationChallan.setTerminatedDetails(PayedRegistrationChallan.getTerminatedDetails());
		 ValidatedPayedRegistrationChallan.setUniversity_Name(PayedRegistrationChallan.getUniversity_Name());
		 ValidatedPayedRegistrationChallan.setYear_course(PayedRegistrationChallan.getYear_course());
		 ValidatedPayedRegistrationChallan.setYear_of_Completion(PayedRegistrationChallan.getYear_of_Completion());
		 ValidatedPayedRegistrationChallan.setZipCode(PayedRegistrationChallan.getZipCode());
		 
		 ValidatedPayedRegistrationChallan.setGenderCategory(PayedRegistrationChallan.getGenderCategory());
		 ValidatedPayedRegistrationChallan.setCastCategory(PayedRegistrationChallan.getCastCategory());
		 
		 // Please do For all other paarameters
		 Session.saveOrUpdate(ValidatedPayedRegistrationChallan);
		 Session.delete(PayedRegistrationChallan);
		 Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Failure";
		}
	}

	@Override
	public String MoveToVerifiedPayedRegistrationOnline(String TransactionID) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from PayedRegistrationOnline where TransactionID = :TransactionID ");
		query.setParameter("TransactionID", TransactionID);
		 @SuppressWarnings("unchecked")
		ArrayList<PayedRegistrationOnline> list = (ArrayList<PayedRegistrationOnline>)query.list();
		 PayedRegistrationOnline PayedRegistrationOnline= list.get(0);
		 
		 ValidatedPayedRegistrationOnline ValidatedPayedRegistrationOnline= new ValidatedPayedRegistrationOnline();
		 ValidatedPayedRegistrationOnline.setTransactionID(PayedRegistrationOnline.getTransactionID());
		 // Please do For all other paarameters
		 Session.saveOrUpdate(ValidatedPayedRegistrationOnline);
		 Session.delete(PayedRegistrationOnline);
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			return "Failure";
		}
	}

	@Override
	public String GetURLForPDF(String html) {
		// TODO Auto-generated method stub
		
		// HTML to PDF returning LInk
		return null;
	}

	@Override
	public String MoveToEligibleKARChangesconfirmBean(EligibleKARChanges EligibleKARChanges) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println(EligibleKARChanges.getKARNumber() + "  **********8 KAR Number ***********");
		System.out.println(EligibleKARChanges.getPayingFor()+ "  **********8 paying for Upldate***********");
		Session.beginTransaction();
		Query query = Session.createQuery("from EligibleKARChanges where KARNumber = :KARNumber and  PayingFor = :PayingFor ");
		query.setParameter("KARNumber", EligibleKARChanges.getKARNumber());
		query.setParameter("PayingFor", EligibleKARChanges.getPayingFor());
		 @SuppressWarnings("unchecked")
		ArrayList<EligibleKARChanges> list = (ArrayList<EligibleKARChanges>)query.list();
		 EligibleKARChanges PayedRegistrationChallan= list.get(0);
		 
		 EligibleKARChangesConfirm EligibleKARChangesConfirm= new EligibleKARChangesConfirm();
		 
		 EligibleKARChangesConfirm.setKARNumber(PayedRegistrationChallan.getKARNumber());
		 EligibleKARChangesConfirm.setPayedChallan(PayedRegistrationChallan.getPayedChallan());
		 EligibleKARChangesConfirm.setPayingFor(PayedRegistrationChallan.getPayingFor());
		 // Please do For all other paarameters
		 java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		 System.out.println(date);
		 EligibleKARChangesConfirm.setRequestCompletedDate(date);
		 Session.saveOrUpdate(EligibleKARChangesConfirm);
		 Session.delete(PayedRegistrationChallan);
		 Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
			return "Sorry Something Went Wrong";
		}
	}

	@Override
	public String SaveEligibleKARChangesconfirmBean(EligibleKARChanges EligibleKARChanges) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println(EligibleKARChanges.getKARNumber() + "  **********8 KAR Number ***********");
		System.out.println(EligibleKARChanges.getPayingFor()+ "  **********8 paying for ***********");
		Session.beginTransaction();
		Query query = Session.createQuery("from EligibleKARChangesConfirm where KARNumber = :KARNumber and  PayingFor = :PayingFor ");
		query.setParameter("KARNumber", EligibleKARChanges.getKARNumber());
		query.setParameter("PayingFor", EligibleKARChanges.getPayingFor());
		 @SuppressWarnings("unchecked")
		ArrayList<EligibleKARChangesConfirm> list = (ArrayList<EligibleKARChangesConfirm>)query.list();
		 EligibleKARChangesConfirm PayedRegistrationChallan= list.get(0);
		 
		 EligibleKARChangescompleted EligibleKARChangesConfirm= new EligibleKARChangescompleted();
		 
		 EligibleKARChangesConfirm.setKARNumber(PayedRegistrationChallan.getKARNumber());
		 EligibleKARChangesConfirm.setPayedChallan(PayedRegistrationChallan.getPayedChallan());
		 EligibleKARChangesConfirm.setPayingFor(PayedRegistrationChallan.getPayingFor());
		 // Please do For all other paarameters
		 java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		 System.out.println(date);
		 
		 Session.saveOrUpdate(EligibleKARChangesConfirm);
		 Session.delete(PayedRegistrationChallan);
		 Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
			return "Sorry Something Went Wrong";
		}
	}

	@Override
	public ArrayList<EligibleKARChangesConfirm> GetAllEligibleKARChangesconfirmBean() {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from EligibleKARChangesConfirm  ");
		
		 @SuppressWarnings("unchecked")
		ArrayList<EligibleKARChangesConfirm> list = (ArrayList<EligibleKARChangesConfirm>)query.list();
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
	public ArrayList<FiveHundreadPayedAdvocateBean> GetAllFiveHundreadPayedAdvocateFromDates(Date StartDate,
			Date EndDate) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from FiveHundreadPayedAdvocateBean  l where l.PayedDate BETWEEN :stDate AND :edDate ");
		query.setDate("stDate", StartDate);
		query.setDate("edDate", EndDate);
		 @SuppressWarnings("unchecked")
		ArrayList<FiveHundreadPayedAdvocateBean> list = (ArrayList<FiveHundreadPayedAdvocateBean>)query.list();
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
	public ArrayList<LifeTimeMembership> GetAllLifeTimeMembershipFromDates(Date StartDate, Date EndDate) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from LifeTimeMembership  l where l.PayedDate BETWEEN :stDate AND :edDate ");
		query.setDate("stDate", StartDate);
		query.setDate("edDate", EndDate);
		 @SuppressWarnings("unchecked")
		ArrayList<LifeTimeMembership> list = (ArrayList<LifeTimeMembership>)query.list();
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
	public ArrayList<ThousandPayedAdvocateBean> GetAllThousandPayedAdvocateFromDates(Date StartDate, Date EndDate) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from ThousandPayedAdvocateBean l where l.PayedDate BETWEEN :stDate AND :edDate");
		query.setDate("stDate", StartDate);
		query.setDate("edDate", EndDate);
		 @SuppressWarnings("unchecked")
		ArrayList<ThousandPayedAdvocateBean> list = (ArrayList<ThousandPayedAdvocateBean>)query.list();
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
	public ArrayList<EligibleKARChangesConfirm> GetAllNomineeKARChangesConfirmFromDates(Date StartDate, Date EndDate) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI");
		Query query = Session.createQuery("from EligibleKARChangesConfirm e  where (e.RequestCompletedDate BETWEEN :stDate AND :edDate)   and ( e.PayingFor =:Nominee )");
		query.setDate("stDate", StartDate);
		query.setDate("edDate", EndDate); //
		query.setString("Nominee", "Nominee Change");
		 @SuppressWarnings("unchecked")
		ArrayList<EligibleKARChangesConfirm> list = (ArrayList<EligibleKARChangesConfirm>)query.list();
		 
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
	public String GetBillingDetails(String KARNumber) {
		// TODO Auto-generated method stub
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI");
		Query query = Session.createQuery("from Enrollment_WelfareFundPayments where EnrollmentID = :EnrollmentID ORDER BY (ToYear) ");
		query.setParameter("EnrollmentID", KARNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<Enrollment_WelfareFundPayments> list = (ArrayList<Enrollment_WelfareFundPayments>)query.list();
		Enrollment_WelfareFundPayments BillingStatusKAR= list.get(0);
		 
		 String resultString="<table class=\"table\">"
  +"<thead>"
   +" <tr>"
    +"  <th>#</th>"
     +" <th>Enrollment ID</th>"
    +"  <th>From Year</th>"
    +"  <th>To Year</th>"
    +"<th>Amount Paid</th>"
    +"<th>Amount Paid on</th>"
    +"</tr>"
 +" </thead>"
 +" <tbody>"
  +"  <tr>"
   +"   <th scope=\"row\">1</th>"
  // +"  <td>"+BillingStatusKAR.getEnrollmentID()+"</td>"
   +"     <td>"+BillingStatusKAR.getFromYear()+"</td>"
   +"     <td>"+BillingStatusKAR.getToYear()+"</td>"
    +"     <td>"+BillingStatusKAR.getAmountPaid()+"</td>"
     +"     <td>"+BillingStatusKAR.getAmountPaidOn()+"</td>"
  +"  </tr>"
  +"  <tr>"
     
  +"</tbody>"
  +"</table>";
		 Session.close();
		 
		return resultString;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		return "NotFound";	
		}
	}

	@Override
	public String MoveToFeeStructureForEnrollmentConfirm(String KARNumber) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from FeeStructureForKAR where KARNumber = :KARNumber ");
		query.setParameter("KARNumber", KARNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<FeeStructureForKAR> list = (ArrayList<FeeStructureForKAR>)query.list();
		 FeeStructureForKAR FeeStructureForKAR= list.get(0);
		 
		 FeeStructureForEnrollmentConfirm FeeStructureForEnrollmentConfirm= new FeeStructureForEnrollmentConfirm();
		 FeeStructureForEnrollmentConfirm.setCertificateCopyCharges(FeeStructureForKAR.getCertificateCopyCharges());
		 FeeStructureForEnrollmentConfirm.setChangeOfAddress(FeeStructureForKAR.getChangeOfAddress());
		 FeeStructureForEnrollmentConfirm.setChangeOfNamePublication(FeeStructureForKAR.getChangeOfNamePublication());
		 FeeStructureForEnrollmentConfirm.setClosingFD(FeeStructureForKAR.getClosingFD());
		 FeeStructureForEnrollmentConfirm.setComplaintFee(FeeStructureForKAR.getComplaintFee());
		 FeeStructureForEnrollmentConfirm.setContinuityCertificate(FeeStructureForKAR.getContinuityCertificate());
		 FeeStructureForEnrollmentConfirm.setDOBCertificate(FeeStructureForKAR.getDOBCertificate());
		 FeeStructureForEnrollmentConfirm.setDuplicateEnrollemt(FeeStructureForKAR.getDuplicateEnrollemt());
		 FeeStructureForEnrollmentConfirm.setElectionDeposit(FeeStructureForKAR.getElectionDeposit());
		 FeeStructureForEnrollmentConfirm.setElectionRules(FeeStructureForKAR.getElectionRules());
		 FeeStructureForEnrollmentConfirm.setEndomentCertificate(FeeStructureForKAR.getEndomentCertificate());
		 FeeStructureForEnrollmentConfirm.setEnrollmentApplication(FeeStructureForKAR.getEnrollmentApplication());
	//	 FeeStructureForEnrollmentConfirm.setEnrollmentFee(FeeStructureForKAR.getEnrollmentFee());
		 FeeStructureForEnrollmentConfirm.setIdentityCard(FeeStructureForKAR.getIdentityCard());
		 FeeStructureForEnrollmentConfirm.setKARNumber(FeeStructureForKAR.getKARNumber());
		 FeeStructureForEnrollmentConfirm.setKSBCCostReceipt(FeeStructureForKAR.getKSBCInterestONFD());
		 FeeStructureForEnrollmentConfirm.setKSBCInterestONFD(FeeStructureForKAR.getKSBCInterestONFD());
		 FeeStructureForEnrollmentConfirm.setMiscReceipts(FeeStructureForKAR.getMiscReceipts());
		 FeeStructureForEnrollmentConfirm.setNameOftheClient(FeeStructureForKAR.getNameOftheClient());
		 FeeStructureForEnrollmentConfirm.setNameOftheClient(FeeStructureForKAR.getNameOftheClient());
		 FeeStructureForEnrollmentConfirm.setNOC(FeeStructureForKAR.getNOC());
		 FeeStructureForEnrollmentConfirm.setNominationForm(FeeStructureForKAR.getNominationForm());
		 FeeStructureForEnrollmentConfirm.setPDC(FeeStructureForKAR.getPDC());
	
		 FeeStructureForEnrollmentConfirm.setPlaceOftheClient(FeeStructureForKAR.getPlaceOftheClient());
		 FeeStructureForEnrollmentConfirm.setPlaceOftheClient(FeeStructureForKAR.getPlaceOftheClient());
		 FeeStructureForEnrollmentConfirm.setPostageReceipts(FeeStructureForKAR.getPostageReceipts());
		 FeeStructureForEnrollmentConfirm.setReimbursementOFSalaryDeduction(FeeStructureForKAR.getReimbursementOFSalaryDeduction());
		 FeeStructureForEnrollmentConfirm.setProcessFee(FeeStructureForKAR.getProcessFee());
		 FeeStructureForEnrollmentConfirm.setVoterCD(FeeStructureForKAR.getVoterCD());
		 FeeStructureForEnrollmentConfirm.setVSP(FeeStructureForKAR.getVSP());
		 // Please do For all other paarameters
		 Session.saveOrUpdate(FeeStructureForEnrollmentConfirm);
		 Session.delete(FeeStructureForKAR);
		 Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Failure";
		}
	}

	@Override
	public String MoveToFeeStructureDoneFromEnrollmentConfirm(String KARNumber) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from FeeStructureForKAR where KARNumber = :KARNumber ");
		query.setParameter("KARNumber", KARNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<FeeStructureForKAR> list = (ArrayList<FeeStructureForKAR>)query.list();
		 FeeStructureForKAR FeeStructureForKAR= list.get(0);
		 
		 FeeStructureForEnrollmentConfirm FeeStructureForEnrollmentConfirm= new FeeStructureForEnrollmentConfirm();
		 FeeStructureForEnrollmentConfirm.setCertificateCopyCharges(FeeStructureForKAR.getCertificateCopyCharges());
		 FeeStructureForEnrollmentConfirm.setChangeOfAddress(FeeStructureForKAR.getChangeOfAddress());
		 FeeStructureForEnrollmentConfirm.setChangeOfNamePublication(FeeStructureForKAR.getChangeOfNamePublication());
		 FeeStructureForEnrollmentConfirm.setClosingFD(FeeStructureForKAR.getClosingFD());
		 FeeStructureForEnrollmentConfirm.setComplaintFee(FeeStructureForKAR.getComplaintFee());
		 FeeStructureForEnrollmentConfirm.setContinuityCertificate(FeeStructureForKAR.getContinuityCertificate());
		 FeeStructureForEnrollmentConfirm.setDOBCertificate(FeeStructureForKAR.getDOBCertificate());
		 FeeStructureForEnrollmentConfirm.setDuplicateEnrollemt(FeeStructureForKAR.getDuplicateEnrollemt());
		 FeeStructureForEnrollmentConfirm.setElectionDeposit(FeeStructureForKAR.getElectionDeposit());
		 FeeStructureForEnrollmentConfirm.setElectionRules(FeeStructureForKAR.getElectionRules());
		 FeeStructureForEnrollmentConfirm.setEndomentCertificate(FeeStructureForKAR.getEndomentCertificate());
		 FeeStructureForEnrollmentConfirm.setEnrollmentApplication(FeeStructureForKAR.getEnrollmentApplication());
		// FeeStructureForEnrollmentConfirm.setEnrollmentFee(FeeStructureForKAR.getEnrollmentFee());
		 FeeStructureForEnrollmentConfirm.setIdentityCard(FeeStructureForKAR.getIdentityCard());
		 FeeStructureForEnrollmentConfirm.setKARNumber(FeeStructureForKAR.getKARNumber());
		 FeeStructureForEnrollmentConfirm.setKSBCCostReceipt(FeeStructureForKAR.getKSBCInterestONFD());
		 FeeStructureForEnrollmentConfirm.setKSBCInterestONFD(FeeStructureForKAR.getKSBCInterestONFD());
		 FeeStructureForEnrollmentConfirm.setMiscReceipts(FeeStructureForKAR.getMiscReceipts());
		 FeeStructureForEnrollmentConfirm.setNameOftheClient(FeeStructureForKAR.getNameOftheClient());
		 FeeStructureForEnrollmentConfirm.setNameOftheClient(FeeStructureForKAR.getNameOftheClient());
		 FeeStructureForEnrollmentConfirm.setNOC(FeeStructureForKAR.getNOC());
		 FeeStructureForEnrollmentConfirm.setNominationForm(FeeStructureForKAR.getNominationForm());
		 FeeStructureForEnrollmentConfirm.setPDC(FeeStructureForKAR.getPDC());
	
		 FeeStructureForEnrollmentConfirm.setPlaceOftheClient(FeeStructureForKAR.getPlaceOftheClient());
		 FeeStructureForEnrollmentConfirm.setPlaceOftheClient(FeeStructureForKAR.getPlaceOftheClient());
		 FeeStructureForEnrollmentConfirm.setPostageReceipts(FeeStructureForKAR.getPostageReceipts());
		 FeeStructureForEnrollmentConfirm.setReimbursementOFSalaryDeduction(FeeStructureForKAR.getReimbursementOFSalaryDeduction());
		 FeeStructureForEnrollmentConfirm.setProcessFee(FeeStructureForKAR.getProcessFee());
		 FeeStructureForEnrollmentConfirm.setVoterCD(FeeStructureForKAR.getVoterCD());
		 FeeStructureForEnrollmentConfirm.setVSP(FeeStructureForKAR.getVSP());
		 // Please do For all other paarameters
		 Session.saveOrUpdate(FeeStructureForEnrollmentConfirm);
		 Session.delete(FeeStructureForKAR);
		 Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Failure";
		}
	}

	@Override
	public String MoveToKAWFfeeStructureForKAWFConfirm(String KARNumber) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from KAWFfeeStructure where KARNumber = :KARNumber ");
		query.setParameter("KARNumber", KARNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<KAWFfeeStructure> list = (ArrayList<KAWFfeeStructure>)query.list();
		 KAWFfeeStructure FeeStructureForKAR= list.get(0);
		 
		 KAWFfeeStructureConfirm KAWFfeeStructureConfirm = new KAWFfeeStructureConfirm();
		 KAWFfeeStructureConfirm.setAmount(FeeStructureForKAR.getAmount());
		 KAWFfeeStructureConfirm.setBankName(FeeStructureForKAR.getBankName());
		 KAWFfeeStructureConfirm.setBranchName(FeeStructureForKAR.getBranchName());
		 KAWFfeeStructureConfirm.setChequeNumber(FeeStructureForKAR.getChequeNumber());
		 KAWFfeeStructureConfirm.setDDNumber(FeeStructureForKAR.getDDNumber());
		 KAWFfeeStructureConfirm.setEnrollmentFee(FeeStructureForKAR.getEnrollmentFee());
		 KAWFfeeStructureConfirm.setIdentityCard(FeeStructureForKAR.getIdentityCard());
		 KAWFfeeStructureConfirm.setKARNumber(FeeStructureForKAR.getKARNumber());
		 KAWFfeeStructureConfirm.setName(FeeStructureForKAR.getName());
		 KAWFfeeStructureConfirm.setPlace(FeeStructureForKAR.getPlace());
		 // Please do For all other paarameters
		 Session.saveOrUpdate(KAWFfeeStructureConfirm);
		 Session.delete(FeeStructureForKAR);
		 Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Failure";
		}
	}

	@Override
	public String MoveToFKAWFfeeStructureDoneFromKAWFfeeStructureConfirm(String KARNumber) {
		// TODO Auto-generated method stub
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		Query query = Session.createQuery("from KAWFfeeStructureConfirm where KARNumber = :KARNumber ");
		query.setParameter("KARNumber", KARNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<KAWFfeeStructureConfirm> list = (ArrayList<KAWFfeeStructureConfirm>)query.list();
		 KAWFfeeStructureConfirm FeeStructureForKAR= list.get(0);
		 
		 KAWFfeeStructureDone KAWFfeeStructureConfirm = new KAWFfeeStructureDone();
		 KAWFfeeStructureConfirm.setAmount(FeeStructureForKAR.getAmount());
		 KAWFfeeStructureConfirm.setBankName(FeeStructureForKAR.getBankName());
		 KAWFfeeStructureConfirm.setBranchName(FeeStructureForKAR.getBranchName());
		 KAWFfeeStructureConfirm.setChequeNumber(FeeStructureForKAR.getChequeNumber());
		 KAWFfeeStructureConfirm.setDDNumber(FeeStructureForKAR.getDDNumber());
		 KAWFfeeStructureConfirm.setEnrollmentFee(FeeStructureForKAR.getEnrollmentFee());
		 KAWFfeeStructureConfirm.setIdentityCard(FeeStructureForKAR.getIdentityCard());
		 KAWFfeeStructureConfirm.setKARNumber(FeeStructureForKAR.getKARNumber());
		 KAWFfeeStructureConfirm.setName(FeeStructureForKAR.getName());
		 KAWFfeeStructureConfirm.setPlace(FeeStructureForKAR.getPlace());
		 // Please do For all other paarameters
		 Session.saveOrUpdate(KAWFfeeStructureConfirm);
		 Session.delete(FeeStructureForKAR);
		 Session.beginTransaction().commit();
		 Session.close();
		 return "Success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Failure";
		}
	}
	 
	@Override
	public String GetAllBillingDetailsForWelfare(String KARNumber) {
		// TODO Auto-generated method stub
		
		try
		{
		Session Session = HibernateUtil.getSessionFactory().openSession(); // where (e.RequestCompletedDate BETWEEN :stDate AND :edDate) and ( e.PayingFor :Nominee )
		Session.beginTransaction();
		
		System.out.println("HI");
		Query query = Session.createQuery("from Enrollment_WelfareFundPayments where EnrollmentID = :EnrollmentID ORDER BY (ToYear); ");
		query.setParameter("EnrollmentID", KARNumber);
		 @SuppressWarnings("unchecked")
		ArrayList<Enrollment_WelfareFundPayments> list = (ArrayList<Enrollment_WelfareFundPayments>)query.list();
	
		 
		String responseString="<table class='table table-striped'><thead><tr>"+"<thead>"
   +" <tr>"
    +"  <th>#</th>"
     +" <th>Enrollment ID</th>"
    +"  <th>From Year</th>"
    +"  <th>To Year</th>"
    +"<th>Amount Paid</th>"
    +"<th>Amount Paid on</th>"
    +"</tr>"
				  +  " </thead>"
				  +  "<tbody>";
						   
						   for (Enrollment_WelfareFundPayments BillingStatusKAR : list) {
							   responseString +=  " <tr>"
									    +  "  <th scope='row'>1</th>"
								//	    +"  <td>"+BillingStatusKAR.getEnrollmentID()+"</td>"
									    +"     <td>"+BillingStatusKAR.getFromYear()+"</td>"
									    +"     <td>"+BillingStatusKAR.getToYear()+"</td>"
									     +"     <td>"+BillingStatusKAR.getAmountPaid()+"</td>"
									      +"     <td>"+BillingStatusKAR.getAmountPaidOn()+"</td>";
						   }
		 Session.close();
		 
		return responseString;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		return "NotFound";	
		}
	}

}
