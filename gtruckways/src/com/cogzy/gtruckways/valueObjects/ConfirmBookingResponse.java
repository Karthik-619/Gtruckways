package com.cogzy.gtruckways.valueObjects;

public class ConfirmBookingResponse {

	private String refPostId,fromCity,toCity,material,postDate,travelDate,status,
	approximateAmount, cancelReason,comment,recipientMobile,recipientName,paymentMode,pickUp,dropArea,promoCode;
	
	private float kilometers,minutes,totalAmount,discountPercent,basePrice, discountAmount, freeKm,gstAmount,baseFare,slab1Price, slab2Price ;
	
	private double sourceLat,sourceLong,destLat,destLong ;
	
	private int postId,userId,truckId, bookingStatus,driverId,approximateCost,approximateWeight, helper,helperAmount, freeMins;
	
	public float getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(float baseFare) {
		this.baseFare = baseFare;
	}

	public float getSlab1Price() {
		return slab1Price;
	}

	public void setSlab1Price(float slab1Price) {
		this.slab1Price = slab1Price;
	}

	public float getSlab2Price() {
		return slab2Price;
	}

	public void setSlab2Price(float slab2Price) {
		this.slab2Price = slab2Price;
	}

	
	
	
	
	
	
	
	
	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public float getFreeKm() {
		return freeKm;
	}

	public void setFreeKm(float freeKm) {
		this.freeKm = freeKm;
	}

	public float getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(float gstAmount) {
		this.gstAmount = gstAmount;
	}

	public int getHelper() {
		return helper;
	}

	public void setHelper(int helper) {
		this.helper = helper;
	}

	

	public int getHelperAmount() {
		return helperAmount;
	}

	public void setHelperAmount(int helperAmount) {
		this.helperAmount = helperAmount;
	}

	public int getFreeMins() {
		return freeMins;
	}

	public void setFreeMins(int freeMins) {
		this.freeMins = freeMins;
	}

	

	public String getPromoCode() {
		return promoCode;
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

	public int getApproximateCost() {
		return approximateCost;
	}

	public void setApproximateCost(int approximateCost) {
		this.approximateCost = approximateCost;
	}

	public int getApproximateWeight() {
		return approximateWeight;
	}

	public void setApproximateWeight(int approximateWeight) {
		this.approximateWeight = approximateWeight;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	
	
	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getDropArea() {
		return dropArea;
	}

	public void setDropArea(String dropArea) {
		this.dropArea = dropArea;
	}

	public String getRecipientMobile() {
		return recipientMobile;
	}

	public void setRecipientMobile(String recipientMobile) {
		this.recipientMobile = recipientMobile;
	}

	
	
	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}



	public int getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	

	public String getRefPostId() {
		return refPostId;
	}

	public void setRefPostId(String refPostId) {
		this.refPostId = refPostId;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApproximateAmount() {
		return approximateAmount;
	}

	public void setApproximateAmount(String approximateAmount) {
		this.approximateAmount = approximateAmount;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public float getKilometers() {
		return kilometers;
	}

	public void setKilometers(float kilometers) {
		this.kilometers = kilometers;
	}

	public float getMinutes() {
		return minutes;
	}

	public void setMinutes(float minutes) {
		this.minutes = minutes;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getSourceLat() {
		return sourceLat;
	}

	public void setSourceLat(double sourceLat) {
		this.sourceLat = sourceLat;
	}

	public double getSourceLong() {
		return sourceLong;
	}

	public void setSourceLong(double sourceLong) {
		this.sourceLong = sourceLong;
	}

	public double getDestLat() {
		return destLat;
	}

	public void setDestLat(double destLat) {
		this.destLat = destLat;
	}

	public double getDestLong() {
		return destLong;
	}

	public void setDestLong(double destLong) {
		this.destLong = destLong;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	
	
	
	
}
