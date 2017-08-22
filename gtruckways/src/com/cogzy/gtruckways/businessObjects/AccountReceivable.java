package com.cogzy.gtruckways.businessObjects;

public class AccountReceivable {

	private int acctReceivableId;
	private String transactionDate;
	private float amount;
	private Accounts accts;
	private FinancialTransaction transaction;
	
	public int getAcctReceivableId() {
		return acctReceivableId;
	}
	public void setAcctReceivableId(int acctReceivableId) {
		this.acctReceivableId = acctReceivableId;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Accounts getAccts() {
		return accts;
	}
	public void setAccts(Accounts accts) {
		this.accts = accts;
	}
	public FinancialTransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(FinancialTransaction transaction) {
		this.transaction = transaction;
	}
	
}
