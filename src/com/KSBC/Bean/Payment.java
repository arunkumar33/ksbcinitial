package com.KSBC.Bean;



public class Payment {

	/** The id. */
	private String id;

	/** The transaction id. */
	
	private String transactionId;

	/** The status. */
	private String status;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWebhookUrl() {
		return webhookUrl;
	}
	public void setWebhookUrl(String webhookUrl) {
		this.webhookUrl = webhookUrl;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getResourceUri() {
		return resourceUri;
	}
	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}
	public Object getPayments() {
		return payments;
	}
	public void setPayments(Object payments) {
		this.payments = payments;
	}

	/** The currency. */
	private String currency;

	/** The amount. */
	private Double amount;

	/** The name. */
	private String name;

	/** The email. */
	private String email;

	/** The phone. */
	private String phone;

	/** The description. */
	private String description;

	/** Webhook URL */

	private String webhookUrl;

	/** The redirect url. */
	
	private String redirectUrl;

	/** The created at. */
	
	private String createdAt;

	/** The resource uri. */
	
	private String resourceUri;

	/** The payments. */
	private Object payments;

 ;

}
