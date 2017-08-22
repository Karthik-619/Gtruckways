package com.cogzy.gtruckways.businessObjects;

public class CustomerPayment {
	
	private int customerPaymentId;
	
	private float totAmount;
	
	private float amtPaid;
	
	private String paymentDate;
	
	private Post postId;
	
	public int getCustomerPaymentId() {
		return customerPaymentId;
	}

	public void setCustomerPaymentId(int customerPaymentId) {
		this.customerPaymentId = customerPaymentId;
	}

	public float getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(float totAmount) {
		this.totAmount = totAmount;
	}

	public float getAmtPaid() {
		return amtPaid;
	}

	public void setAmtPaid(float amtPaid) {
		this.amtPaid = amtPaid;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Post getPostId() {
		return postId;
	}

	public void setPostId(Post postId) {
		this.postId = postId;
	}
}
