package com.cogzy.gtruckways.businessObjects;

public class Payment {

	private int paymentId;
	private String paymentType;
	private float amtDue;
	private float amtReceived;
	private float balance;
	private FinancialTransaction transaction;
	private AccountReceivable accReceivable;
	
	public FinancialTransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(FinancialTransaction transaction) {
		this.transaction = transaction;
	}
	public AccountReceivable getAccReceivable() {
		return accReceivable;
	}
	public void setAccReceivable(AccountReceivable accReceivable) {
		this.accReceivable = accReceivable;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public float getAmtDue() {
		return amtDue;
	}
	public void setAmtDue(float amtDue) {
		this.amtDue = amtDue;
	}
	public float getAmtReceived() {
		return amtReceived;
	}
	public void setAmtReceived(float amtReceived) {
		this.amtReceived = amtReceived;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
}
