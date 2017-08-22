package com.cogzy.gtruckways.businessObjects;


public class TransConfirm {
	
	private int transConfirmId;
	
	private String truckRegNum;
	
	private String vehcileName;
	
	private String transporterContactPerson;
	
	private String transporterName;
	
	private String transporterContact;
	
	private String driverName;
	
	private String driverContact;
	
	private float totalAmount;
	
	private float amountPaid;
	
	private String paidDate;
	
	private int lrNumber;
	
	private int refInvoiceNumber;
	
	private Post postId;
	
	public int getLrNumber() {
		return lrNumber;
	}

	public void setLrNumber(int lrNumber) {
		this.lrNumber = lrNumber;
	}

	public int getRefInvoiceNumber() {
		return refInvoiceNumber;
	}

	public void setRefInvoiceNumber(int refInvoiceNumber) {
		this.refInvoiceNumber = refInvoiceNumber;
	}

	public int getTransConfirmId() {
		return transConfirmId;
	}

	public void setTransConfirmId(int transConfirm_Id) {
		this.transConfirmId = transConfirm_Id;
	}

	public String getTruckRegNum() {
		return truckRegNum;
	}

	public void setTruckRegNum(String truckRegNum) {
		this.truckRegNum = truckRegNum;
	}

	public String getTransporterName() {
		return transporterName;
	}

	
	
	public String getVehcileName() {
		return vehcileName;
	}

	public void setVehcileName(String vehcileName) {
		this.vehcileName = vehcileName;
	}

	public String getTransporterContactPerson() {
		return transporterContactPerson;
	}

	public void setTransporterContactPerson(String transporterContactPerson) {
		this.transporterContactPerson = transporterContactPerson;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTransporterContact() {
		return transporterContact;
	}

	public void setTransporterContact(String transporterContact) {
		this.transporterContact = transporterContact;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverContact() {
		return driverContact;
	}

	public void setDriverContact(String driverContact) {
		this.driverContact = driverContact;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public float getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

	public Post getPostId() {
		return postId;
	}

	public void setPostId(Post postId) {
		this.postId = postId;
	}

	
}
