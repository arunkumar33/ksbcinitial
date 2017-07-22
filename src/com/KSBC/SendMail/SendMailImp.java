package com.KSBC.SendMail;

import java.util.Properties;



import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailImp implements SendMail {

	@Override
	public String SendMail(String senderEmail, String password, String profileName, String recipientEmail,
			String subject, String message) {
		  // SSL // I USED THIS METHOD            
	     try{   Properties propsSSL = new Properties();

	        // EVEN IF YOU SKIP THESE TWO PROP IT WOULD WORK
	        propsSSL.put("mail.transport.protocol", "smtps");
	        propsSSL.put("mail.smtps.host", "smtp.gmail.com");

	        // THIS IS THE MOST IMPORTANT PROP --> "mail.smtps.auth"
	        propsSSL.put("mail.smtps.auth", "true");

	        Session sessionSSL = Session.getInstance(propsSSL);
	        sessionSSL.setDebug(true);

	        Message messageSSL = new MimeMessage(sessionSSL);
	        messageSSL.setFrom(new InternetAddress(senderEmail, profileName));
	        messageSSL.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // real recipient
	        messageSSL.setSubject(subject);
	        messageSSL.setText(message);

	        Transport transportSSL = sessionSSL.getTransport();
	        // EVEN IF YOU SKIP PORT NUMBER , IT WOULD WORK
	        transportSSL.connect("smtp.gmail.com", 465, senderEmail, password); // account used.
	        transportSSL.sendMessage(messageSSL, messageSSL.getAllRecipients());
	        transportSSL.close();System.out.println("SSL done.");
	     }
	     catch(Exception e){System.out.println(e);}
	        
			return "Failure";
		}

}
