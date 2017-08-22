package com.cogzy.gtruckways.valueObjects;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class GetPriceRequestPojo {

	@NotEmpty (message="Enter the Area inside Bangalore")
	private String fromCity;
	
	@NotEmpty (message="Enter the Area inside Bangalore")
	private String toCity;
	
	@NotEmpty (message="Select the Vehicle Type")
	@Pattern(regexp = "^[1,2,6]{1,1}$")
	private String truckType;
	

	private double sourceLat;
	
	private double sourceLong;
	
	private double destLat;
	
	private double destLong;
	
	
	
	
	private String mobileNo;
	
	
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
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
	
	
	
}
