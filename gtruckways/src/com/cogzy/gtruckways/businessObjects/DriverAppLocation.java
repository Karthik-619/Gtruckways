package com.cogzy.gtruckways.businessObjects;

import java.util.List;

public class DriverAppLocation {

	
	private String sourceLat;
	
	private String sourceLong;
	
	private String appTime;
	
	private String driverId;
	
	private String status;
	
	private List<DriverAppLocation> offlineLocations;

	
	
	
	
	
	

	public String getSourceLat() {
		return sourceLat;
	}

	public void setSourceLat(String sourceLat) {
		this.sourceLat = sourceLat;
	}

	public String getSourceLong() {
		return sourceLong;
	}

	public void setSourceLong(String sourceLong) {
		this.sourceLong = sourceLong;
	}

	public String getAppTime() {
		return appTime;
	}

	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<DriverAppLocation> getOfflineLocations() {
		return offlineLocations;
	}

	public void setOfflineLocations(List<DriverAppLocation> offlineLocations) {
		this.offlineLocations = offlineLocations;
	}
	
	
	
	
}
