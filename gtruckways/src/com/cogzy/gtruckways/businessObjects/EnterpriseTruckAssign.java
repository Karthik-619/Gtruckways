package com.cogzy.gtruckways.businessObjects;

public class EnterpriseTruckAssign {

	
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

	private int enterpriseId;
	
	private int vehicleType;
	
	private  String  vehicleName;
	
	private String vehicleRegNo;
	
	private String source;
	
	private String destination;
	
	private long noOfKms;
	
	private int noOfDays;
	
	private int noOfhours;
	
	
	
	
	private int pricePerAdditionalKm;
	
	private int pricePerAdditionalMin;
	
	private String scheduleTime;
	
	private String startDate;
	
	private String endDate;
	
	

	
	private float quoteAmount;
	
	private float totalAmount;
	
	private float distanceTravelled;
	
	
	private int workingDays;
	
	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public int getVehicleType() {
		return vehicleType;
	}

	public int getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public long getNoOfKms() {
		return noOfKms;
	}

	public void setNoOfKms(long noOfKms) {
		this.noOfKms = noOfKms;
	}

	public int getNoOfhours() {
		return noOfhours;
	}

	public void setNoOfhours(int noOfhours) {
		this.noOfhours = noOfhours;
	}

	

	public int getPricePerAdditionalKm() {
		return pricePerAdditionalKm;
	}

	public void setPricePerAdditionalKm(int pricePerAdditionalKm) {
		this.pricePerAdditionalKm = pricePerAdditionalKm;
	}

	public int getPricePerAdditionalMin() {
		return pricePerAdditionalMin;
	}

	public void setPricePerAdditionalMin(int pricePerAdditionalMin) {
		this.pricePerAdditionalMin = pricePerAdditionalMin;
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

	
	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	/**
	 * @return the totalAmount
	 */
	public float getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the quoteAmount
	 */
	public float getQuoteAmount() {
		return quoteAmount;
	}

	/**
	 * @param quoteAmount the quoteAmount to set
	 */
	public void setQuoteAmount(float quoteAmount) {
		this.quoteAmount = quoteAmount;
	}

	/**
	 * @return the distanceTravelled
	 */
	public float getDistanceTravelled() {
		return distanceTravelled;
	}

	/**
	 * @param distanceTravelled the distanceTravelled to set
	 */
	public void setDistanceTravelled(float distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}
	
	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	
	
	
	
}
