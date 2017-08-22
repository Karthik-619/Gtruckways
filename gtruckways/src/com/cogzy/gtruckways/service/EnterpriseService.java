package com.cogzy.gtruckways.service;

import java.util.List;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;
import com.cogzy.gtruckways.valueObjects.EnterpriseRequestPojo;

public interface EnterpriseService {

	public int saveEnterpriseInformation(EnterpriseRequestPojo ec);
	public int checkDuplicateEnterprise(EnterpriseRequestPojo ec);
	
	public boolean checkMobile(String mobileNo);
	public boolean checkEmail(String Eemail);
	
	public EnterpriseCustomer enterpriseLoginInfo(String mobile, String password);
	
	public int ChangeEnterprisePassword(EnterpriseRequestPojo ec,int enterpriseId); 
	
	public List<EnterpriseVehicleStatus> getEnterPriseVehicleInformation(int enterpriseCustomerId);
	public int ChangeEnterpriseforgotPassword(EnterpriseRequestPojo ec);
	public String updateEnterprsieResetPasswordSaltString(String email);
	
	
}
