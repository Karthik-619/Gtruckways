package com.cogzy.gtruckways.valueObjects;





import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserPostInfo {

	
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String mobileNo;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String travelDate;
	
	
	@NotEmpty
	private String material;

	private String pickupArea;

	private String dropArea;
	
	
	
	private String floor;
	

	private int helper;
	
	private String gstNumber;

	private int autoRegister;
	

	private int diffRecepient;
	
	private String recepientName;
	
	private String recepientMobileNo;
	
	private float totalAmount;

public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

private float approxAmount;
	
	private int valueOfGoods;
	
	private int approximateWeight;
	
	
	private String promocode;
	
	private float discountAmount;
	
	
	
	public String getPromocode() {
		return promocode;
	}

	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
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

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPickupArea() {
		return pickupArea;
	}

	public void setPickupArea(String pickupArea) {
		this.pickupArea = pickupArea;
	}

	public String getDropArea() {
		return dropArea;
	}

	public void setDropArea(String dropArea) {
		this.dropArea = dropArea;
	}

	

	public int getHelper() {
		return helper;
	}

	public void setHelper(int helper) {
		this.helper = helper;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	
	public int getAutoRegister() {
		return autoRegister;
	}

	public void setAutoRegister(int autoRegister) {
		this.autoRegister = autoRegister;
	}

	public int getDiffRecepient() {
		return diffRecepient;
	}

	public void setDiffRecepient(int diffRecepient) {
		this.diffRecepient = diffRecepient;
	}

	public String getRecepientName() {
		return recepientName;
	}

	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}

	public String getRecepientMobileNo() {
		return recepientMobileNo;
	}

	public void setRecepientMobileNo(String recepientMobileNo) {
		this.recepientMobileNo = recepientMobileNo;
	}


	
	public int getApproximateWeight() {
		return approximateWeight;
	}

	public void setApproximateWeight(int approximateWeight) {
		this.approximateWeight = approximateWeight;
	}

	public int getValueOfGoods() {
		return valueOfGoods;
	}

	public void setValueOfGoods(int valueOfGoods) {
		this.valueOfGoods = valueOfGoods;
	}

	public float getApproxAmount() {
		return approxAmount;
	}

	public void setApproxAmount(float approxAmount) {
		this.approxAmount = approxAmount;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	
	
}
