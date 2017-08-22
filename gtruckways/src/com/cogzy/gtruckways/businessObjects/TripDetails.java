package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class TripDetails {

	
	private double sLat;
	
	private double sLong;
	
	private double dLat;
	
	private double dLong;

	private int tripId;
	
	private int driverId;
	
	private String bookingId;
	
	private int km_to_source;
	
	private int mins_to_source;
	
	private int dryRunKm;
	
	private float totalKm;
	
	private int totalMins;
	
	private float deductionAmount;
	
	private float incentiveAmount;
	
	private int startDelay;
	
	private String tripDate;
	
	private String regNo;
	
	private String fromDate;
	
	private String toDate;
	
	private List<TripDetails> dailytripinfo;
	
	
	
	public List<TripDetails> getDailytripinfo() {
		return dailytripinfo;
	}

	public void setDailytripinfo(List<TripDetails> dailytripinfo) {
		this.dailytripinfo = dailytripinfo;
	}

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

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	
	public float getTotalKm() {
		return totalKm;
	}

	public void setTotalKm(float totalKm) {
		this.totalKm = totalKm;
	}

	public int getTotalMins() {
		return totalMins;
	}

	public void setTotalMins(int totalMins) {
		this.totalMins = totalMins;
	}

	public float getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(float deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public float getIncentiveAmount() {
		return incentiveAmount;
	}

	public void setIncentiveAmount(float incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}

	public int getStartDelay() {
		return startDelay;
	}

	public void setStartDelay(int startDelay) {
		this.startDelay = startDelay;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public int getKm_to_source() {
		return km_to_source;
	}

	public void setKm_to_source(int km_to_source) {
		this.km_to_source = km_to_source;
	}

	public int getMins_to_source() {
		return mins_to_source;
	}

	public void setMins_to_source(int mins_to_source) {
		this.mins_to_source = mins_to_source;
	}

	public int getDryRunKm() {
		return dryRunKm;
	}

	public void setDryRunKm(int dryRunKm) {
		this.dryRunKm = dryRunKm;
	}

	public double getsLat() {
		return sLat;
	}

	public void setsLat(double sLat) {
		this.sLat = sLat;
	}

	public double getsLong() {
		return sLong;
	}

	public void setsLong(double sLong) {
		this.sLong = sLong;
	}

	public double getdLat() {
		return dLat;
	}

	public void setdLat(double dLat) {
		this.dLat = dLat;
	}

	public double getdLong() {
		return dLong;
	}

	public void setdLong(double dLong) {
		this.dLong = dLong;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}

	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	
	
}
