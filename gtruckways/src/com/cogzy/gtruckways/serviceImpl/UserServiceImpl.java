package com.cogzy.gtruckways.serviceImpl;

import java.time.LocalDateTime;

import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.Otp;

import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.daoImpl.UserDaoImpl;
import com.cogzy.gtruckways.service.UserService;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.DriverLoginRequestPojo;
import com.cogzy.gtruckways.valueObjects.UserPostInfo;

public class UserServiceImpl implements UserService {

	UserDaoImpl udao;

	public UserDaoImpl getUdao() {
		return udao;
	}

	public void setUdao(UserDaoImpl udao) {
		this.udao = udao;
	}

	@Override
	public User getUserDetails(UserPostInfo ui) {
		// TODO Auto-generated method stub

		User use = new User();
		Otp ot = new Otp();

	try{
		
		use = udao.fetchUserDetails(ui.getMobileNo());
		
		Log.info("User Exists-->"+use.isActive());
		
		
		if (use.isActive() && use.getUserStatus()==2) {

			// update otp number in otp table 
			// Existing User
			
			Log.info("User Service Impl-->Existing User is Booking");
			udao.updateOTP(use);

			ot = udao.getUserOTP(use);

			if(ui.getGstNumber()!=null && ui.getGstNumber().matches("[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{2}")){
				
				use.setGstNumber(ui.getGstNumber());
		
			}else{
				
				use.setGstNumber("GGGG");
				
			}
			
			
			use.setOtp(ot);
			use.setUserName(ui.getUserName());
			use.setEmail(ui.getEmail());
			
			udao.updateUserName(use);
			
			
			return use;
		
		} else {

			Log.info("User Service Impl-->New User is Booking");
			use.setUserName(ui.getUserName());
			use.setEmail(ui.getEmail());
			use.setMobileNo(ui.getMobileNo());
			use.setUserType("Customer");
			
			
			if (ui.getAutoRegister()==1) {

				Log.info("User Service Impl-->Signup User");

				use.setPassword(use.getUserpassword());
				use.setUserStatus(1);
				
			} else {

				Log.info("User Service Impl-->Guest User");
				use.setUserStatus(0);
				use.setPassword("");
			}

			if(ui.getGstNumber()!=null && ui.getGstNumber().matches("[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{2}")){
				
				use.setGstNumber(ui.getGstNumber());
		
			}else{
				
				use.setGstNumber("GGGG");
				
			}
			
			
			udao.saveUser(use);

			use = udao.fetchUserStatusDetails(use.getMobileNo(),use.getUserStatus());
			use.setUserName(ui.getUserName());
			use.setEmail(ui.getEmail());
			
			
			
			udao.storeOTP(use);

			ot = udao.getUserOTP(use);

			use.setOtp(ot);

			return use;
		}

	} catch (Exception e){
		return use;
	}
		
	}

	@Override
	public int updateUserStatus(User u) {
	
	LocalDateTime dt=LocalDateTime.now().withNano(0);
	
	int success=udao.updateUserStatus(u.getMobileNo(),dt);
		
	return success;
	}

	@Override
	public LocalDriver getDriverStatus(DriverLoginRequestPojo driver) {
	
		LocalDriver drive=new LocalDriver();
		drive.setDriverRegNo(driver.getRegNo()); 
		drive.setPassword(driver.getPassword());
		drive=udao.getDriverStatus(drive);
		
		return drive;
	}
	
	@Override
	public User getEmail(String lmobile) {
		
		
		User user=udao.getEmail(lmobile);
		
		return user;
	}

	

@Override
public User storeCustomerInformationofLandingPage(String fromCity, String toCity, String mobile, String truckType) {
	
	
	int success= udao.storeCustomerInformation(fromCity, toCity, truckType, mobile);
	
	User user=udao.fetchUserDetails(mobile);
	
	if(user.isActive()){
		
		user.setStatusCode(200);
		return  user;
		
	}
	
	user.setStatusCode(401);
	user.setMobileNo(mobile);
	return  user;
}
	
	
}
