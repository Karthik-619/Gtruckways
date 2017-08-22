package com.cogzy.gtruckways.valueObjects;

public class TransMobileInfo {

	private String transByMob;
	
	private int transById;
	
	private String vehRegNo;
	
	private String vehName;
	
	private String tranName;
	
	private String transMobile;
	
	private String driver;
	
	private String driverMobile;
	
	private int vehDriverId;
	
	public int getVehDriverId() {
		return vehDriverId;
	}

	public void setVehDriverId(int vehDriverId) {
		this.vehDriverId = vehDriverId;
	}

	public String getVehRegNo() {
		return vehRegNo;
	}

	public void setVehRegNo(String vehRegNo) {
		this.vehRegNo = vehRegNo;
	}

	public String getVehName() {
		return vehName;
	}

	public void setVehName(String vehName) {
		this.vehName = vehName;
	}

	public String getTranName() {
		return tranName;
	}

	public void setTranName(String tranName) {
		this.tranName = tranName;
	}

	
	public String getTransMobile() {
		return transMobile;
	}

	public void setTransMobile(String transMobile) {
		this.transMobile = transMobile;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDriverMobile() {
		return driverMobile;
	}

	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}

	public int getTransById() {
		return transById;
	}

	public void setTransById(int transById) {
		this.transById = transById;
	}

	public String getTransByMob() {
		return transByMob;
	}

	public void setTransByMob(String transByMob) {
		this.transByMob = transByMob;
	}
}
