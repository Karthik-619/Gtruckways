package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class EnterpriseOdometer {

	private String enterpriseName;
	
	private int enterpriseId;
	
	private String contactPerson;
	
	private String contactMobile;
	
	private String vehicleRegNo;
	
	
	private String truckName;
	
	private String driverName;
	
	private String driverMobileNo;
	
	
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

	private List<EnterpriseTripDetails> odometerReadings;

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverMobileNo() {
		return driverMobileNo;
	}

	public void setDriverMobileNo(String driverMobileNo) {
		this.driverMobileNo = driverMobileNo;
	}

	public List<EnterpriseTripDetails> getOdometerReadings() {
		return odometerReadings;
	}

	public void setOdometerReadings(List<EnterpriseTripDetails> odometerReadings) {
		this.odometerReadings = odometerReadings;
	}
	
	
	
	
	
	
	
}
