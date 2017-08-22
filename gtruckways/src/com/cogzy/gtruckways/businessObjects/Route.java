package com.cogzy.gtruckways.businessObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Route {

	private String fromCity;
	private String toCity;
	private float distance;
	private int time;
	private double sLat;
	private double sLong;
	
	private double dLat;
	private double dLong;
	
	
	
	
	public double getsLat() {
		return sLat;
	}
	public void setsLat(double sLat) {
		this.sLat = sLat;
	}
	public double getsLong() {
		return sLong;
	}
	public void setsLong(double sLong) {
		this.sLong = sLong;
	}
	public double getdLat() {
		return dLat;
	}
	public void setdLat(double dLat) {
		this.dLat = dLat;
	}
	public double getdLong() {
		return dLong;
	}
	public void setdLong(double dLong) {
		this.dLong = dLong;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
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
	



	private static final String regexp = "([0-9]*)(\\D*)([0-9]*)(.*)";
	private static final Pattern pattern = Pattern.compile(regexp);
	
	public int getMinutes(String timeString){
		
		int mins = 0;
		Matcher matcher = pattern.matcher(timeString);
		if (matcher.find()) {
		if (matcher.group(3).equals("")) {
		mins = Integer.parseInt(matcher.group(1));
		 
		} else {
		mins = 60 * Integer.parseInt(matcher.group(1));
		mins += Integer.parseInt(matcher.group(3));
		}
		} else {
		System.out.println("NO MATCH");
		// Do exception handling here; throw exception
		}
		return mins;
		}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
}
