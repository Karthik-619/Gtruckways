package com.cogzy.gtruckways.businessObjects;

public class Invoice {

	private int invoiceId;
	private FinancialTransaction transaction;
	private Payment payment;
	private Accounts accts;
	private AccountReceivable acctReceivable;
	private Post post;
	private String invoiceDate;
	private int statusCode;
	
	
	
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public FinancialTransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(FinancialTransaction transaction) {
		this.transaction = transaction;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Accounts getAccts() {
		return accts;
	}
	public void setAccts(Accounts accts) {
		this.accts = accts;
	}
	public AccountReceivable getAcctReceivable() {
		return acctReceivable;
	}
	public void setAcctReceivable(AccountReceivable acctReceivable) {
		this.acctReceivable = acctReceivable;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	
}
