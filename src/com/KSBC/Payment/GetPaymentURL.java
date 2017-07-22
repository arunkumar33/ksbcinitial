package com.KSBC.Payment;

import com.KSBC.Bean.Payment;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.InvalidPaymentOrderException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;

public class GetPaymentURL {

	
	
	public String GetPaymentURLForPayment(Payment Payment)
	{

		// TODO Auto-generated method stub
		
	/*	Client ID: gGoy3eGZOtN2GNzG4yH4gUrR2E6xMVqFblOz0ZKG

Test URLs

auth_endpoint : https://test.instamojo.com/oauth2/token/

endpoint: https://test.instamojo.com/v2/

Production URLs

auth endpoint : https://www.instamojo.com/oauth2/token/

endpoint: https://api.instamojo.com/v2/



		Client Secret:9247ue3nxkUca6AiDIsQWtmPhZiPKufIMx5XwYPQovLp4UOkX4rx6tBso5iTcpXn1dWxbmFXPFrbBqFxcYZT75fZGkyNKBPoiqbXfBWgHSvusenfmVj1FB0zD3FQVsSA*/
		
		PaymentOrder order = new PaymentOrder();
		order.setName(Payment.getName());
		order.setEmail(Payment.getEmail());
		order.setPhone(Payment.getPhone());
		order.setCurrency(Payment.getCurrency());
		order.setAmount(Payment.getAmount());
		order.setDescription(Payment.getDescription());
		order.setRedirectUrl(Payment.getRedirectUrl());
		/*order.setWebhookUrl("http://www.someurl.com/");*/
		order.setTransactionId(Payment.getTransactionId());
		String ClientID="CrqmayBF7A934b50tMyoyyzbYLr41jCHBBEJCvwv";
String ClientSecreate="wZwkManMnde1wI5E9frxCb4OHRPzVM6urrBVx36ArZY4HONJZtJEhX8NX3hU8xMsERdNUr500JQ7xkwzjg7cIoLbY7voZCLWlgWSf3gwn809m4pwJu4Gjjpo8ZzBubFC";
		Instamojo api = null;

		try {
		    // gets the reference to the instamojo api
			System.out.println("Inside");
		    api = InstamojoImpl.getApi(ClientID,ClientSecreate);
		    System.out.println("Inside2");
		} catch (ConnectionException e) {
		    System.out.println(e.getStackTrace());
		}

		boolean isOrderValid = order.validate();
System.out.println(isOrderValid + "order validation");
System.out.println(order.isTransactionIdInvalid() + "Transaction ID validation");
		if (isOrderValid) {
		    try {
		        CreatePaymentOrderResponse createPaymentOrderResponse = api.createNewPaymentOrder(order);
		        // print the status of the payment order.
		        System.out.println(createPaymentOrderResponse.getPaymentOrder().getStatus());
		        System.out.println(createPaymentOrderResponse.getPaymentOptions().getPaymentUrl() + "This is the url");
		    } catch (InvalidPaymentOrderException e) {
		    	System.out.println(e.getStackTrace());

		        if (order.isTransactionIdInvalid()) {
		            System.out.println("Transaction id is invalid. This is mostly due to duplicate  transaction id.");
		        }
		        if (order.isCurrencyInvalid()) {
		            System.out.println("Currency is invalid.");
		        }
		    } catch (ConnectionException e) {
		    	System.out.println(e.getStackTrace());
		    }
		} else {
		    // inform validation errors to the user.
		    if (order.isTransactionIdInvalid()) {
		        System.out.println("Transaction id is invalid.");
		    }
		    if (order.isAmountInvalid()) {
		      System.out.println("Amount can not be less than 9.00.");
		    }
		    if (order.isCurrencyInvalid()) {
		      System.out.println("Please provide the currency.");
		    }
		    if (order.isDescriptionInvalid()) {
		      System.out.println("Description can not be greater than 255 characters.");
		        }
		    if (order.isEmailInvalid()) {
		      System.out.println("Please provide valid Email Address.");
		    }
		    if (order.isNameInvalid()) {
		      System.out.println("Name can not be greater than 100 characters.");
		    }
		    if (order.isPhoneInvalid()) {
		      System.out.println("Phone is invalid.");
		    }
		    if (order.isRedirectUrlInvalid()) {
		      System.out.println("Please provide valid Redirect url.");
		    }

		    if (order.isWebhookInvalid()) {
		      System.out.println("Provide a valid webhook url");
		    }
		}
	
		return null;
		
	}
}
