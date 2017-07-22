package com.KSBC.Login;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Session;

import com.KSBC.Bean.Login;
import com.KSBC.Util.HibernateUtil;


public class LoginValidator implements LoginValidatorInterface {

	@Override
	public String LoginAuthenticate(Login Login) {
		// TODO Auto-generated method stub
		try
		{
		String NewEnrollemntURL="";
		String AccountURL="";
		String EnrollementURL="";
		Session Session = HibernateUtil.getSessionFactory().openSession();
		Session.beginTransaction();
		String sql = "select password from Login where USerName=:userName and Department=:Department";
		org.hibernate.SQLQuery query = Session.createSQLQuery(sql);

		System.out.println("here user id");
		String userName = Login.getUSerName();
		String Department = Login.getDepartment();

		query.setParameter("userName", userName);
		query.setParameter("Department", Department);
		@SuppressWarnings("unchecked")
		ArrayList<String>  ArrayListofPassword =  (ArrayList<String>) query.list();
		String Password=ArrayListofPassword.get(0);
		
		if (Password.equals(Login.getPassword()))
		{
			System.out.println(Login.getUSerName() + " is validated " + " Redirecting to " + Login.getDepartment());
			if(Login.getDepartment().equalsIgnoreCase("Enrollment"))
			{
				return EnrollementURL;
			}
			else if(Login.getDepartment().equalsIgnoreCase("New_Enrollment"))
			{
				return NewEnrollemntURL;
			}
			else if(Login.getDepartment().equalsIgnoreCase("Account"))
			{
				return AccountURL;
			}
			 
		}
		else
		{
			return "Authentication Fail";
		}
		}
		catch(Exception e)
		{
			return "Authentication Fail";
		}
		return "Authentication Fail";
	}

}
