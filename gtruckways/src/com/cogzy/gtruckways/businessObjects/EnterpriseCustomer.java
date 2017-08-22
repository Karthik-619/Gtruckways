package com.cogzy.gtruckways.businessObjects;

import java.time.LocalDate;




import java.util.List;

public class EnterpriseCustomer {

	
	
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

	private int enterpriseCustomerId;
	private String enterpriseName;
	private String contactPerson;
	private String contactNumber;
	private String email;
	private String address;
	private String password;
	private int status;
	private LocalDate regDate;
	
	private List<EnterpriseTruckAssign> entVehicleDetails;
	
	private List<EnterpriseVehicleStatus>  locationStatus;
	
	private List<SpareTruckInfo> spareDetails;
	
	private Object entDetails;
	
	
	
	
	public int getEnterpriseCustomerId() {
		return enterpriseCustomerId;
	}

	public void setEnterpriseCustomerId(int enterpriseCustomerId) {
		this.enterpriseCustomerId = enterpriseCustomerId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the entDetails
	 */
	public Object getEntDetails() {
		return entDetails;
	}

	/**
	 * @param entDetails the entDetails to set
	 */
	public void setEntDetails(Object entDetails) {
		this.entDetails = entDetails;
	}

	/**
	 * @return the entVehicleDetails
	 */
	public List<EnterpriseTruckAssign> getEntVehicleDetails() {
		return entVehicleDetails;
	}

	/**
	 * @param entVehicleDetails the entVehicleDetails to set
	 */
	public void setEntVehicleDetails(List<EnterpriseTruckAssign> entVehicleDetails) {
		this.entVehicleDetails = entVehicleDetails;
	}

	public List<SpareTruckInfo> getSpareDetails() {
		return spareDetails;
	}

	public void setSpareDetails(List<SpareTruckInfo> spareDetails) {
		this.spareDetails = spareDetails;
	}

	public List<EnterpriseVehicleStatus> getLocationStatus() {
		return locationStatus;
	}

	public void setLocationStatus(List<EnterpriseVehicleStatus> locationStatus) {
		this.locationStatus = locationStatus;
	}

	
	
}
