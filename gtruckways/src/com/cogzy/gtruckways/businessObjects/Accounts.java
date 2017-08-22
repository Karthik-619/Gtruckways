package com.cogzy.gtruckways.businessObjects;

public class Accounts {

	private int accountsId;
	private String acctType;
	private String userType;
	private int addressId;
	private int billcycleId;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAccountsId() {
		return accountsId;
	}
	public void setAccountsId(int accountsId) {
		this.accountsId = accountsId;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getBillcycleId() {
		return billcycleId;
	}
	public void setBillcycleId(int billcycleId) {
		this.billcycleId = billcycleId;
	}
	
	
}
