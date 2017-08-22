package com.cogzy.gtruckways.businessObjects;

public class AmountDetails {

	private float customerAmount;
	
	private float transporterAmount;
	
	private float gtruckwaysAmount;

	private float additionalAmount;
	
	private int extraMins;
	
	private float extraKm;
	
	private float totalAmount;
	
	private float nightCharges;
	
	
	
	
	
	public float getAdditionalAmount() {
		return additionalAmount;
	}

	public void setAdditionalAmount(float additionalAmount) {
		this.additionalAmount = additionalAmount;
	}

	
	public int getExtraMins() {
		return extraMins;
	}

	public void setExtraMins(int extraMins) {
		this.extraMins = extraMins;
	}

	public float getExtraKm() {
		return extraKm;
	}

	public void setExtraKm(float extraKm) {
		this.extraKm = extraKm;
	}

	public float getCustomerAmount() {
		return customerAmount;
	}

	public void setCustomerAmount(float customerAmount) {
		this.customerAmount = customerAmount;
	}

	public float getTransporterAmount() {
		return transporterAmount;
	}

	public void setTransporterAmount(float transporterAmount) {
		this.transporterAmount = transporterAmount;
	}

	public float getGtruckwaysAmount() {
		return gtruckwaysAmount;
	}

	public void setGtruckwaysAmount(float gtruckwaysAmount) {
		this.gtruckwaysAmount = gtruckwaysAmount;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public float getNightCharges() {
		return nightCharges;
	}

	public void setNightCharges(float nightCharges) {
		this.nightCharges = nightCharges;
	}
	
	
	
}
