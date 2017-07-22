	package com.KSBC.Servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.KSBC.Util.HibernateUtil;







public class mainChecking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session Session = HibernateUtil.getSessionFactory().openSession();
	    Session Transactionsession = null;
	    Transaction TransactionDBtransaction = null;
	   
	
	    // Transaction Session
	    
	    com.KSBC.Bean.AbsentBean RegistrationForm = new com.KSBC.Bean.AbsentBean();
		RegistrationForm.setAddress("7/a, 1st main road, Krishnanandha nagar");
		RegistrationForm.setRegNumber("sowmya12");
		RegistrationForm.setCity("Bangaore");
		RegistrationForm.setCollege("RNSIT coll");
		RegistrationForm.setEmail("arun@thoughtknock.com");
		RegistrationForm.setFullName("A Arun Kumar");
	    TransactionDBtransaction = Session.beginTransaction(); // Transaction for Transaction DB
	   System.out.println("HI");
	   Session.saveOrUpdate(RegistrationForm);
	   TransactionDBtransaction.commit();
	}

}
