package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.valueObjects.DriverLoginRequestPojo;
import com.cogzy.gtruckways.valueObjects.UserPostInfo;

public interface UserService {

	
	public User getUserDetails(UserPostInfo ui); 
	
	public int updateUserStatus(User u);
	public User storeCustomerInformationofLandingPage(String fromCity, String toCity, String mobile, String truckType);
	public LocalDriver getDriverStatus(DriverLoginRequestPojo driver);
	public User getEmail(String lmobile);
}
