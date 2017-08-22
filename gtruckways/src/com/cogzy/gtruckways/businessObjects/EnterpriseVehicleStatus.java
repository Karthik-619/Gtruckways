package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class EnterpriseVehicleStatus {

	
	public String vehicelRegNo;
	
	public String vehicleType;
	
	public String enterpriseName;
	
	public int enterpriseCustomerId;
	
	public int noOfDays;
	
	public int noOfKms;
	
	public int travelledKm;

	public int remainingKm;
	
	public int noOfhoursPerDay;
	
	public int getNoOfhoursPerDay() {
		return noOfhoursPerDay;
	}

	public void setNoOfhoursPerDay(int noOfhoursPerDay) {
		this.noOfhoursPerDay = noOfhoursPerDay;
	}

	public double currentLat;
	
	public double currentLong;

	public List<EnterpriseVehicleStatus> vehiclebalStatus;
	
	
	public List<EnterpriseVehicleStatus> locationStatus;
	
	
	
	public double getCurrentLat() {
		return currentLat;
	}

	public void setCurrentLat(double currentLat) {
		this.currentLat = currentLat;
	}

	public double getCurrentLong() {
		return currentLong;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public void setCurrentLong(double currentLong) {
		this.currentLong = currentLong;
	}

	public List<EnterpriseVehicleStatus> getLocationStatus() {
		return locationStatus;
	}

	public void setLocationStatus(List<EnterpriseVehicleStatus> locationStatus) {
		this.locationStatus = locationStatus;
	}

	public List<EnterpriseVehicleStatus> getVehiclebalStatus() {
		return vehiclebalStatus;
	}

	public void setVehiclebalStatus(List<EnterpriseVehicleStatus> vehiclebalStatus) {
		this.vehiclebalStatus = vehiclebalStatus;
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

	
	public int getNoOfKms() {
		return noOfKms;
	}

	public void setNoOfKms(int noOfKms) {
		this.noOfKms = noOfKms;
	}

	public int getTravelledKm() {
		return travelledKm;
	}

	public void setTravelledKm(int travelledKm) {
		this.travelledKm = travelledKm;
	}

	public int getRemainingKm() {
		return remainingKm;
	}

	public void setRemainingKm(int remainingKm) {
		this.remainingKm = remainingKm;
	}
	
	
	
	
	
	
}
