package com.cogzy.gtruckways.businessObjects;

public class PromoCode {

	private String promoCode;
	
	private float discountPercent;
	
	private float discountAmount;
	
	private float totalAmount;

	private float basePrice;
	
	private String description;
	
	
	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	private String statusMessage;
	
	private int statusCode;
	
	private String fromDate;
	
	private String toDate;
	
	
	
	
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	private boolean promoActive;
	
	public String getPromoCode() {
		return promoCode;
	}

	public boolean isPromoActive() {
		return promoActive;
	}

	public void setPromoActive(boolean promoActive) {
		this.promoActive = promoActive;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
}
