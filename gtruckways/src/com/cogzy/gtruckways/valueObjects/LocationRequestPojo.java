package com.cogzy.gtruckways.valueObjects;

public class LocationRequestPojo {

	
	private float sLat;
	
	private float sLong;
	
	
	private float dLat;
	
	private float dLong;
	
	private String time;
	
	private String regNo;
	
	private String destination;

	


	public float getsLat() {
		return sLat;
	}

	public void setsLat(float sLat) {
		this.sLat = sLat;
	}

	public float getsLong() {
		return sLong;
	}

	public void setsLong(float sLong) {
		this.sLong = sLong;
	}

	public float getdLat() {
		return dLat;
	}

	public void setdLat(float dLat) {
		this.dLat = dLat;
	}

	public float getdLong() {
		return dLong;
	}

	public void setdLong(float dLong) {
		this.dLong = dLong;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
