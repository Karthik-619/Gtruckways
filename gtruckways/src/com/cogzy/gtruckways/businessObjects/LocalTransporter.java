package com.cogzy.gtruckways.businessObjects;

import java.sql.Blob;

public class LocalTransporter {

	
	private int transporterId;
	
	private String transporterName;
	
	private String contactPersonName;
	
	private String mobileNo;
	
	private String email;
	
	private String address;
	
	private Blob photo;
		
	private String panNo;
	
	private String acctHolderName;
	
	private String IFSCcode;
	
	private String acctNo;
	
	private String bankName;
	
	private String branch;
	
	private String identificationNo;
	
	private int cancelledChequeNo;
	
	private String chqReceivedDate;
	
	private String bankCode;

	public int getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(int transporterId) {
		this.transporterId = transporterId;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAcctHolderName() {
		return acctHolderName;
	}

	public void setAcctHolderName(String acctHolderName) {
		this.acctHolderName = acctHolderName;
	}

	public String getIFSCcode() {
		return IFSCcode;
	}

	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

		public int getCancelledChequeNo() {
		return cancelledChequeNo;
	}

	public void setCancelledChequeNo(int cancelledChequeNo) {
		this.cancelledChequeNo = cancelledChequeNo;
	}

	public String getChqReceivedDate() {
		return chqReceivedDate;
	}

	public void setChqReceivedDate(String chqReceivedDate) {
		this.chqReceivedDate = chqReceivedDate;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	

}
