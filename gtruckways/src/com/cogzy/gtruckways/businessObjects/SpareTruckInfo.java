package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class SpareTruckInfo {

	
	
	private int statusCode;
	
	private String statusMessage;
	
	private String spareVehicleRegNo;
	
	private String spareVehicleType;
	
	private int noOfDays;
	
	private String startDate;

	private String endDate;
	
	private String assignVehicleRegNo;

	private List<String> vehicleRegNo;
	
	public String getSpareVehicleRegNo() {
		return spareVehicleRegNo;
	}

	public void setSpareVehicleRegNo(String spareVehicleRegNo) {
		this.spareVehicleRegNo = spareVehicleRegNo;
	}

	public String getSpareVehicleType() {
		return spareVehicleType;
	}

	public void setSpareVehicleType(String spareVehicleType) {
		this.spareVehicleType = spareVehicleType;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
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

	public String getAssignVehicleRegNo() {
		return assignVehicleRegNo;
	}

	public void setAssignVehicleRegNo(String assignVehicleRegNo) {
		this.assignVehicleRegNo = assignVehicleRegNo;
	}

	public List<String> getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(List<String> vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}
	
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
	
	
	
}
