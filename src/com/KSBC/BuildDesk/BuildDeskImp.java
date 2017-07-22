package com.KSBC.BuildDesk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class BuildDeskImp implements BuildeskInterface {

	@Override
	public String sendPost(String URL) throws Exception {
		
		String url = "https://pgi.billdesk.com/pgidsk/PGIMerchantPayment";

	HttpClient client = new DefaultHttpClient();
	HttpPost post = new HttpPost(url);

	// add header
	//post.setHeader("User-Agent", USER_AGENT);
/*MerchantID|CustomerID|NA|TxnAmount|NA|NA|NA|CurrencyType|NA|TypeField1|SecurityID|NA|NA|
	TypeField2|Txtadditionalinfo1|Txtadditionalinfo2|Txtadditionalinfo3|Txtadditionalinfo4|Txtadditionalinf
	o5| Txtadditionalinfo6| Txtadditionalinfo7|RU
*/
	//KSBC
	
	/*payment GateWay Info
	MerchantID=KSBC
	SecurityID=ksbc
	PaymentGateWayURL=https://pgi.billdesk.com/pgidsk/PGIMerchantPayment
		CheckSumValue=Dd42CiSE4Qj6*/
	
	
	String msg="KSBC|1223464566645|NA|2|NA|NA|NA|INR|NA|R|ksbc|NA|NA|"
	+"F|REG/1/2002|A Arun|arunkumar@gmail.con|NA|NA| "
	+ "NA| NA|http://139.59.34.42:8080/ksbc2/Response.jsp|Dd42CiSE4Qj6";
	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	urlParameters.add(new BasicNameValuePair("msg", msg));
	
	post.setEntity(new UrlEncodedFormEntity(urlParameters));

	HttpResponse response = client.execute(post);
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post 	 : " + post.getEntity());
	System.out.println("Response Code : " +
                                response.getStatusLine().getStatusCode());

	BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

	StringBuffer result = new StringBuffer();
	result.append("");
	String line = "";
	while ((line = rd.readLine()) != null) {
		result.append(line);
	}

	System.out.println(result.toString());
	
	return result.toString();
}

}
