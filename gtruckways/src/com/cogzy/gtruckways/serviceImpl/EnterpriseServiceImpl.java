package com.cogzy.gtruckways.serviceImpl;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.dao.EnterpriseCustomerDao;
import com.cogzy.gtruckways.daoImpl.AccountManagerDaoImpl;
import com.cogzy.gtruckways.daoImpl.EnterpriseCustomerDaoImpl;
import com.cogzy.gtruckways.service.EnterpriseService;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.EnterpriseRequestPojo;


@Service
public class EnterpriseServiceImpl implements EnterpriseService{

	
	EnterpriseCustomerDaoImpl ecdao;
	
	AccountManagerDaoImpl accountdao;
	
	
	
	
	public AccountManagerDaoImpl getAccountdao() {
		return accountdao;
	}


	public void setAccountdao(AccountManagerDaoImpl accountdao) {
		this.accountdao = accountdao;
	}


	

	public EnterpriseCustomerDaoImpl getEcdao() {
		return ecdao;
	}


	public void setEcdao(EnterpriseCustomerDaoImpl ecdao) {
		this.ecdao = ecdao;
	}




	private static Logger log = Logger.getLogger(Log.class.getName());
	
	@Override
	public int saveEnterpriseInformation(EnterpriseRequestPojo er) {
		
		
		
		EnterpriseCustomer ec=new EnterpriseCustomer();
		
		/*User user=new User();
		ec.setPassword(user.getUserpassword());*/
		 LocalDate today = LocalDate.now();
		 
		ec.setRegDate(today); 
		ec.setEnterpriseName(er.getEnterpriseName());
		ec.setContactPerson(er.getContactPerson());
		ec.setContactNumber(er.getEnterpriseMobile());
		ec.setEmail(er.getEnterpriseEmail());
		ec.setAddress(er.getEnterpriseAddress());
		ec.setStatus(er.getStatus());
		ecdao.saveEnterpriseCustomerDetails(ec);
		return 1;
	}


	@Override
	public int checkDuplicateEnterprise(EnterpriseRequestPojo er) {
		
		int status=ecdao.checkDuplicateEnterprise(er.getEnterpriseMobile(),er.getEnterpriseEmail(),er.getEnterpriseName());
		
		if(status==0){
			
			log.info("EnterpriseServiceImpl-->No Duplicate Found");
			return status;
		}
		
		log.info("EnterpriseServiceImpl-->Duplicate Found");
		return status;
	}
	
	@Override
	public boolean checkMobile(String mobileNo) {
		boolean status=ecdao.checkMobile(mobileNo);
		return status;
	}


	@Override
	public boolean checkEmail(String Eemail) {
		boolean status=ecdao.checkEmail(Eemail);
		return status;
	}


	@Override
	public EnterpriseCustomer enterpriseLoginInfo(String mobile, String password) {
		// TODO Auto-generated method stub
	
		EnterpriseCustomer ecust=ecdao.getEnterpriseLoginInfo(mobile, password);
		
		List<EnterpriseVehicleStatus>  locationList=accountdao.getVehicleLocation(ecust.getEnterpriseCustomerId());
		
		for(EnterpriseVehicleStatus loc :locationList){
			
		System.out.println(loc.getCurrentLat());
		System.out.println(loc.getVehicleType());	
		}
		
		if(ecust.getEnterpriseCustomerId()==999){
			
			ecust.setLocationStatus(locationList);
			return ecust;
		}
		
		ecust.setLocationStatus(locationList);
		return ecust;
	}


	@Override
	public int ChangeEnterprisePassword(EnterpriseRequestPojo ec,int enterpriseId) {


		try{
		
			EnterpriseCustomer ecust=ecdao.getEnterPriseDetails(enterpriseId);
		
		
		if(ecust.getPassword().equals(ec.getOldEnterPrisePassword())){
			
			 if(ec.getEnterPrisePassword().equals(ec.getConfirmPassword())){
				 
				 
				 int success=ecdao.updateEnterPrisePassword(enterpriseId, ec.getEnterPrisePassword());
				 
				 return 200; // success
				 
			 } else{
				 
				 return 404;
			 }
			 
			 
			}	else {
				 
				 
				 return 405;// password and confirm password mismatch

			 }	 
				 
				 
				 
		} catch (Exception e){	 
		
			return 500;
		}
		
			
	}


	@Override
	public List<EnterpriseVehicleStatus> getEnterPriseVehicleInformation(int enterpriseCustomerId) {
		// TODO Auto-generated method stub
		
		List<EnterpriseVehicleStatus> assign=ecdao.getvehicleStatus(enterpriseCustomerId);
		
		return assign;
	}

	@Override
	public int ChangeEnterpriseforgotPassword(EnterpriseRequestPojo ec) {
		log.info("inside forgot pass service1"+ec.getNewpass()+"dfh"+ec.getConfirmnewpass());

		try{
		
			
			String email =ecdao.checkEmailLink(ec.getEnterpriseEmail());
			log.info("Email is -->"+email);
			
			if(email.isEmpty()){
				
				 return 404;
				}
				
				if(ec.getNewpass().equals(ec.getConfirmnewpass())){
					
					 int success=ecdao.updateEnterPriseforgotPassword(email, ec.getNewpass());
					
					 if(success!=1){
						 
						 return 404;
						 
					 }
					 
					 return 200;
				} else{
					
					
					 return 204;
					
				}
				
		
				
			
			
			
			 
				 
		} catch (Exception e){	 
		
			return 500;
		}
		
			
	}


	@Override
	public String updateEnterprsieResetPasswordSaltString(String email) {
	
		
		String saltString=getSaltString();
		
		int success=ecdao.updateEnterprsieResetPasswordSaltString(email, saltString);
		
		if(success==1){
			
			
			return saltString;
		}
		
		
		
		
		return "AAAA";
	}
	
	
	
	 public String getSaltString() {
	        String SALTCHARS = "abcdABCDEFGHIJKhLmnopMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        SecureRandom rnd = new SecureRandom();
	        while (salt.length() < 20) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        return saltStr;

	    }
	
	
	
	
	
	
}
