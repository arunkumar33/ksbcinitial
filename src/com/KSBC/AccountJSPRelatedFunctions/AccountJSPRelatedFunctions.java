package com.KSBC.AccountJSPRelatedFunctions;

import java.sql.Date;
import java.util.ArrayList;

import com.KSBC.Bean.EligibleKARChanges;
import com.KSBC.Bean.EligibleKARChangesConfirm;
import com.KSBC.Bean.FiveHundreadPayedAdvocateBean;
import com.KSBC.Bean.LifeTimeMembership;
import com.KSBC.Bean.PayedRegistrationChallan;
import com.KSBC.Bean.PayedRegistrationOnline;
import com.KSBC.Bean.RegistrationFormBean;
import com.KSBC.Bean.ThousandPayedAdvocateBean;


public interface AccountJSPRelatedFunctions {
public PayedRegistrationChallan GetChallanTransactionReportByRegNumber(String RegNumber);
public ArrayList<RegistrationFormBean> GetAllChallanTransactionReport();
public PayedRegistrationOnline GetOnlineTransactionReportByTransactionID(String TransactionID);
public ArrayList<PayedRegistrationOnline> GetAllOnlineTransactionReport();
public String MoveToVerifiedPayedRegistrationChallan(String RegNumber);
public String MoveToVerifiedPayedRegistrationOnline(String TransactionID);
public String GetURLForPDF (String html);
public String MoveToEligibleKARChangesconfirmBean(EligibleKARChanges EligibleKARChanges);
public String SaveEligibleKARChangesconfirmBean(EligibleKARChanges EligibleKARChanges);
public ArrayList<EligibleKARChangesConfirm> GetAllEligibleKARChangesconfirmBean();
public ArrayList<FiveHundreadPayedAdvocateBean> GetAllFiveHundreadPayedAdvocateFromDates(Date StartDate,Date EndDate);
public ArrayList<LifeTimeMembership> GetAllLifeTimeMembershipFromDates(Date StartDate,Date EndDate);
public ArrayList<ThousandPayedAdvocateBean> GetAllThousandPayedAdvocateFromDates(Date StartDate,Date EndDate);
public ArrayList<EligibleKARChangesConfirm> GetAllNomineeKARChangesConfirmFromDates(Date StartDate,Date EndDate);

public String MoveToFeeStructureForEnrollmentConfirm(String KARNumber);
public String MoveToFeeStructureDoneFromEnrollmentConfirm(String KARNumber);
public String GetBillingDetails(String KARNumber);
public String MoveToKAWFfeeStructureForKAWFConfirm(String KARNumber);
public String MoveToFKAWFfeeStructureDoneFromKAWFfeeStructureConfirm(String KARNumber);
public String GetAllBillingDetailsForWelfare(String KARNumber);

}
