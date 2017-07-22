package com.KSBC.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class HibernateUtil {
/*	public static final org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(HibernateUtil.class);*/
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			//For XML mapping
			//return new Configuration().configure().buildSessionFactory();
			/*log.info("I am in SessionFactory Function");*/
			//For Annotation
		/*	log.info("SessionFactory is crated..");*/
			System.out.println("TRy Block");
			return new Configuration().configure().buildSessionFactory();
			
		} catch (Throwable ex) {
			/*log.info("SessionFactory is not crated..");*/
			System.out.println("catch  Block");
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		/*log.info("SessionFactory is closed ..");*/
		getSessionFactory().close();
	}

}