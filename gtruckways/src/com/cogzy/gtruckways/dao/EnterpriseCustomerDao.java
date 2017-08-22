package com.cogzy.gtruckways.dao;

import java.util.List;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;


public interface EnterpriseCustomerDao {

	public int saveEnterpriseCustomerDetails(EnterpriseCustomer ec);

	public List<EnterpriseCustomer>  getEnterpriseDetails();
	public int checkDuplicateEnterprise(String mobile, String email,String enterpriseName);
	
	public boolean checkMobile(String mobileNo);
	public boolean checkEmail(String Eemail);
	
	public EnterpriseCustomer getEnterpriseLoginInfo(String email,String password);
	
	public EnterpriseCustomer getEnterPriseDetails(int enterpriseId);
	
	public int updateEnterPrisePassword(int enterpriseId,String password);
	
	public List<EnterpriseVehicleStatus> getvehicleStatus(int entCustomerId);
	
	//Enterprise forgot password email sender      
	public int updateEnterPriseforgotPassword(String EnterpriseEmail, String password);

	public EnterpriseCustomer getEnterPriseDetails(String email);
	
	public int updateEnterprsieResetPasswordSaltString(String email,String saltString);
}
