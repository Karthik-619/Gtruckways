package com.cogzy.gtruckways.businessObjects;


import java.util.List;


public class LiveTracking {


	
private String latitude;

private String longitude;

private String currentTime;

private String vehicleRegNo;


private int driverId;

private String currentDate;




private double distance;


private int timeMins;


private List<LiveTracking> livetrack;



public String getCurrentTime() {
	return currentTime;
}


public void setCurrentTime(String currentTime) {
	this.currentTime = currentTime;
}





public double getDistance() {
	return distance;
}


public void setDistance(double distance) {
	this.distance = distance;
}


public int getTimeMins() {
	return timeMins;
}


public void setTimeMins(int timeMins) {
	this.timeMins = timeMins;
}




public String getLatitude() {
	return latitude;
}


public void setLatitude(String latitude) {
	this.latitude = latitude;
}


public String getLongitude() {
	return longitude;
}


public void setLongitude(String longitude) {
	this.longitude = longitude;
}


public String getVehicleRegNo() {
	return vehicleRegNo;
}


public void setVehicleRegNo(String vehicleRegNo) {
	this.vehicleRegNo = vehicleRegNo;
}





public String getCurrentDate() {
	return currentDate;
}


public void setCurrentDate(String currentDate) {
	this.currentDate = currentDate;
}


public int getDriverId() {
	return driverId;
}


public void setDriverId(int driverId) {
	this.driverId = driverId;
}


public double distance(double lat1, double lon1, double lat2, double lon2) {
   
	double theta = lon1 - lon2;
    double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))+ Math.cos(deg2rad(lat1))* Math.cos(deg2rad(lat2))* Math.cos(deg2rad(theta));
    dist = Math.acos(dist);
    dist = rad2deg(dist);
    dist = dist * 60 * 1.1515;
    dist = dist * 1.609344;
    return (dist);
}

private double deg2rad(double deg) {
    return (deg * Math.PI / 180.0);
}

private double rad2deg(double rad) {
    return (rad * 180.0 / Math.PI);
}


public List<LiveTracking> getLivetrack() {
	return livetrack;
}


public void setLivetrack(List<LiveTracking> livetrack) {
	this.livetrack = livetrack;
}








}
