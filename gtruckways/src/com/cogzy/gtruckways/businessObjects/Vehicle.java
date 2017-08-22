package com.cogzy.gtruckways.businessObjects;

public class Vehicle {

	
	private int vehicleId;
	private String vehicleName;
	private String actType;
	private String vehicleRegistrationNo;
	private String vehicleChasisNo;
	private String vehicleInsuranceNo;
	private String insuranceOwner;
	private String registrationDate;
	private String regValidity;
	private String engineNo;
	private String fcNo;
	private String fcValidity;
	private String brand;
	private int cubicCapacity;
	private float bhp;
	private float payLoadCapacity;
	private String vehicleType;
	private String dimension;
	private String pollutionCertNo;
	private String pollutionCertValidity;
	private String permitType;
	private String permitStates;
	private String permitValidity;
	private String vehicleInsuranceExpiryDate;
	private int vehicleLocationId;
	private int deviceId;
	
	private LocalTransporter transporter;
	private LocalDriver driverId;
	
	private int statusCode;
	
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}
	public int getVehicleLocationId() {
		return vehicleLocationId;
	}
	public void setVehicleLocationId(int vehicleLocationId) {
		this.vehicleLocationId = vehicleLocationId;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public LocalTransporter getTransporter() {
		return transporter;
	}
	public void setTransporter(LocalTransporter transporter) {
		this.transporter = transporter;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}
	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}
	public String getVehicleChasisNo() {
		return vehicleChasisNo;
	}
	public void setVehicleChasisNo(String vehicleChasisNo) {
		this.vehicleChasisNo = vehicleChasisNo;
	}
	public String getVehicleInsuranceNo() {
		return vehicleInsuranceNo;
	}
	public void setVehicleInsuranceNo(String vehicleInsuranceNo) {
		this.vehicleInsuranceNo = vehicleInsuranceNo;
	}
	public String getVehicleInsuranceExpiryDate() {
		return vehicleInsuranceExpiryDate;
	}
	public void setVehicleInsuranceExpiryDate(String vehicleInsuranceExpiryDate) {
		this.vehicleInsuranceExpiryDate = vehicleInsuranceExpiryDate;
	}
	public String getInsuranceOwner() {
		return insuranceOwner;
	}
	public void setInsuranceOwner(String insuranceOwner) {
		this.insuranceOwner = insuranceOwner;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getRegValidity() {
		return regValidity;
	}
	public void setRegValidity(String regValidity) {
		this.regValidity = regValidity;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getFcNo() {
		return fcNo;
	}
	public void setFcNo(String fcNo) {
		this.fcNo = fcNo;
	}
	public String getFcValidity() {
		return fcValidity;
	}
	public void setFcValidity(String fcValidity) {
		this.fcValidity = fcValidity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getCubicCapacity() {
		return cubicCapacity;
	}
	public void setCubicCapacity(int cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}
	public float getBhp() {
		return bhp;
	}
	public void setBhp(float bhp) {
		this.bhp = bhp;
	}
	public float getPayLoadCapacity() {
		return payLoadCapacity;
	}
	public void setPayLoadCapacity(float payLoadCapacity) {
		this.payLoadCapacity = payLoadCapacity;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getPollutionCertNo() {
		return pollutionCertNo;
	}
	public void setPollutionCertNo(String pollutionCertNo) {
		this.pollutionCertNo = pollutionCertNo;
	}
	public String getPollutionCertValidity() {
		return pollutionCertValidity;
	}
	public void setPollutionCertValidity(String pollutionCertValidity) {
		this.pollutionCertValidity = pollutionCertValidity;
	}
	public String getPermitType() {
		return permitType;
	}
	public void setPermitType(String permitType) {
		this.permitType = permitType;
	}
	public String getPermitStates() {
		return permitStates;
	}
	public void setPermitStates(String permitStates) {
		this.permitStates = permitStates;
	}
	public String getPermitValidity() {
		return permitValidity;
	}
	public void setPermitValidity(String permitValidity) {
		this.permitValidity = permitValidity;
	}
	public LocalDriver getDriverId() {
		return driverId;
	}
	public void setDriverId(LocalDriver driverId) {
		this.driverId = driverId;
	}
	
	
	
}
