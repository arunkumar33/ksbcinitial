package com.KSBC.SendSMS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendSms {

	
	public String SMS(String UserName,String Hash,String Message,String Sender, String Number)
	{
		

		// TODO Auto-generated method stub
		
		 
		
				try {
					// Construct data
					/*String user = "username=" + "arunkumar.1rn12ec400@gmail.com";
					String hash = "&hash=" + "5e4a89d20bed9906f5b57201a3f4fb119eb0f386";
					String message = "&message=" + "SMS From TestLocal SMS Gateway";
					String sender = "&sender=" + "TXTLCL";
					String numbers = "&numbers=" + "918147894950";*/
					
					String user = "username=" + UserName;
					String hash = "&hash=" + Hash;
					String message = "&message=" + Message;
					String sender = "&sender=" + Sender;
					String numbers = "&numbers=" + Number;
					
					// Send data
					HttpURLConnection conn = (HttpURLConnection) new URL("http://api.textlocal.in/send/?").openConnection();
					String data = user + hash + numbers + message + sender;
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
					conn.getOutputStream().write(data.getBytes("UTF-8"));
					final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					final StringBuffer stringBuffer = new StringBuffer();
					String line;
					while ((line = rd.readLine()) != null) {
						stringBuffer.append(line);
					}
					rd.close();
					
					System.out.println(stringBuffer.toString());
					return "Success";
				} catch (Exception e) {
					System.out.println("Error SMS "+e);
					System.out.println("Error "+e);
					return "Failure";
				}
			
		
	}
}
