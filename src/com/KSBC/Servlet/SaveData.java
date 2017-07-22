package com.KSBC.Servlet;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.KSBC.Bean.DomainLoginBean;
import com.KSBC.Bean.RegistrationFormBean;
import com.KSBC.Util.HibernateUtil;

public class SaveData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			
			
			 SessionFactory TransactionsessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			   Session Transactionsession = null;
			    Transaction TransactionDBtransaction = null;
			  
			   
			 
			    Transactionsession=  TransactionsessionFactory.openSession(); // Transaction Session
			    RegistrationFormBean RegistrationForm = new RegistrationFormBean();
				RegistrationForm.setAddress("7/a, 1st main road, Krishnanandha nagar");
				RegistrationForm.setRegNumber("arun1234");
				RegistrationForm.setCity("Bangaore");
				RegistrationForm.setCollege("RNSIT");
				RegistrationForm.setEmail("arun@thoughtknock.com");
				RegistrationForm.setFullName("A Arun Kumar");
			    
			    TransactionDBtransaction = Transactionsession.beginTransaction(); // Transaction for Transaction DB
			    TransactionDBtransaction.begin();
			    Transactionsession.saveOrUpdate(RegistrationForm);
			    
			    
			    TransactionDBtransaction.commit();
	

	}

}
