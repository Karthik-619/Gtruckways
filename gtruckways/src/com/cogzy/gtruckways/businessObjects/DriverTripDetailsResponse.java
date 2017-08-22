package com.cogzy.gtruckways.businessObjects;


import java.util.List;

public class DriverTripDetailsResponse {

	
	
	private int statusCode;
	
	
	private String statusMessage;
	
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	private String bookingId;
	
	private String bookingDate;
	
	private String todayDate;
	
	private String tDate;
	
	private int driverId;
	
	private String fromCity;
	
	private String toCity;
	
	private String material;
	
	private float totalDistance;
	
	private int totalMins;
	
	private float totalAmount;
	
	private int dryRunKm;
	
	private int startDelayMins;
	
	private float tripEarnings;
	
	private float driverAmount;
	
	private String sourceReachedDateTime;
	
	private String destReachedDateTime;
	
	
	
	

	public String getSourceReachedDateTime() {
		return sourceReachedDateTime;
	}

	public void setSourceReachedDateTime(String sourceReachedDateTime) {
		this.sourceReachedDateTime = sourceReachedDateTime;
	}

	public String getDestReachedDateTime() {
		return destReachedDateTime;
	}

	public void setDestReachedDateTime(String destReachedDateTime) {
		this.destReachedDateTime = destReachedDateTime;
	}

	private List<Incentives> incentives;
	
	private List<Deductions> deductions;
	
	
	private float sumIncentives;
	
	private float sumDeductions;
	
	
	
	
	public float getSumIncentives() {
		return sumIncentives;
	}

	public void setSumIncentives(float sumIncentives) {
		this.sumIncentives = sumIncentives;
	}

	public float getSumDeductions() {
		return sumDeductions;
	}

	public void setSumDeductions(float sumDeductions) {
		this.sumDeductions = sumDeductions;
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

	public float getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(float totalDistance) {
		this.totalDistance = totalDistance;
	}

	public int getTotalMins() {
		return totalMins;
	}

	public void setTotalMins(int totalMins) {
		this.totalMins = totalMins;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getDryRunKm() {
		return dryRunKm;
	}

	public void setDryRunKm(int dryRunKm) {
		this.dryRunKm = dryRunKm;
	}

	public int getStartDelayMins() {
		return startDelayMins;
	}

	public void setStartDelayMins(int startDelayMins) {
		this.startDelayMins = startDelayMins;
	}

	public float getTripEarnings() {
		return tripEarnings;
	}

	public void setTripEarnings(float tripEarnings) {
		this.tripEarnings = tripEarnings;
	}

	public float getDriverAmount() {
		return driverAmount;
	}

	public void setDriverAmount(float driverAmount) {
		this.driverAmount = driverAmount;
	}


	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public List<Incentives> getIncentives() {
		return incentives;
	}

	public void setIncentives(List<Incentives> incentives) {
		this.incentives = incentives;
	}

	public List<Deductions> getDeductions() {
		return deductions;
	}

	public void setDeductions(List<Deductions> deductions) {
		this.deductions = deductions;
	}

	public String getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}

	public String gettDate() {
		return tDate;
	}

	public void settDate(String tDate) {
		this.tDate = tDate;
	}

	
	
	
	
}
