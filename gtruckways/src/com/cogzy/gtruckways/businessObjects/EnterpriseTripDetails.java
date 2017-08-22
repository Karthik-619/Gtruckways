package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class EnterpriseTripDetails {

	
	public String vehicelRegNo;
	
	public String vehicleType;
	
	public String enterpriseName;
	
	public int enterpriseCustomerId;
	
	private int driverId;
	
	
	public String distance;
	
	public String startDate;
	 
	public String endDate;
	
	public float todayKm;
	
	public int todayMins;
	
	public float totalAmount;
	
	public String tripDate;
	
	public int additionalKm;
	
	public int additionalTime;
	
	public float additionalAmount;

	public float startReading;
	
	public float endReading;
	
	public String startReadingTime;
	
	public String endReadingTime;
	
	
	public float balanceKm;
	
	public float distanceTravelled;
	
	public List <EnterpriseTripDetails> eTripdetails; 
	
	public List <EnterpriseTripDetails>  eVehicleInfo;
	
	public List<EnterpriseInvoice> invoiceInfo;
	
	
	public List<EnterpriseInvoice> getInvoiceInfo() {
		return invoiceInfo;
	}

	public void setInvoiceInfo(List<EnterpriseInvoice> invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}

	public float getTodayKm() {
		return todayKm;
	}

	public void setTodayKm(float todayKm) {
		this.todayKm = todayKm;
	}

	
	public float getBalanceKm() {
		return balanceKm;
	}

	public void setBalanceKm(float balanceKm) {
		this.balanceKm = balanceKm;
	}

	public float getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(float distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	

	public float getStartReading() {
		return startReading;
	}

	public void setStartReading(float startReading) {
		this.startReading = startReading;
	}

	public float getEndReading() {
		return endReading;
	}

	public void setEndReading(float endReading) {
		this.endReading = endReading;
	}

	public String getStartReadingTime() {
		return startReadingTime;
	}

	public void setStartReadingTime(String startReadingTime) {
		this.startReadingTime = startReadingTime;
	}

	public String getEndReadingTime() {
		return endReadingTime;
	}

	public void setEndReadingTime(String endReadingTime) {
		this.endReadingTime = endReadingTime;
	}

	
	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public int getEnterpriseCustomerId() {
		return enterpriseCustomerId;
	}

	public void setEnterpriseCustomerId(int enterpriseCustomerId) {
		this.enterpriseCustomerId = enterpriseCustomerId;
	}

	
	public int getTodayMins() {
		return todayMins;
	}

	public void setTodayMins(int todayMins) {
		this.todayMins = todayMins;
	}
	
	
	public String getVehicelRegNo() {
		return vehicelRegNo;
	}

	public void setVehicelRegNo(String vehicelRegNo) {
		this.vehicelRegNo = vehicelRegNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public int getAdditionalKm() {
		return additionalKm;
	}

	public void setAdditionalKm(int additionalKm) {
		this.additionalKm = additionalKm;
	}

	public int getAdditionalTime() {
		return additionalTime;
	}

	public void setAdditionalTime(int additionalTime) {
		this.additionalTime = additionalTime;
	}

	public float getAdditionalAmount() {
		return additionalAmount;
	}

	public void setAdditionalAmount(float additionalAmount) {
		this.additionalAmount = additionalAmount;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	
	public List<EnterpriseTripDetails> geteTripdetails() {
		return eTripdetails;
	}

	public void seteTripdetails(List<EnterpriseTripDetails> eTripdetails) {
		this.eTripdetails = eTripdetails;
	}

	public List<EnterpriseTripDetails> geteVehicleInfo() {
		return eVehicleInfo;
	}

	public void seteVehicleInfo(List<EnterpriseTripDetails> eVehicleInfo) {
		this.eVehicleInfo = eVehicleInfo;
	}

	
}
