package com.cogzy.gtruckways.serviceImpl;

import java.security.SecureRandom;
import java.util.List;

import org.apache.log4j.Logger;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.daoImpl.PostDaoImpl;
import com.cogzy.gtruckways.daoImpl.UserDaoImpl;
import com.cogzy.gtruckways.service.LoginService;
import com.cogzy.gtruckways.validator.Log;

public class LoginServiceImpl implements LoginService {

	UserDaoImpl udao;
	PostDaoImpl pdao;
	
	public PostDaoImpl getPdao() {
		return pdao;
	}

	public void setPdao(PostDaoImpl pdao) {
		this.pdao = pdao;
	}

	public UserDaoImpl getUdao() {
		return udao;
	}

	public void setUdao(UserDaoImpl udao) {
		this.udao = udao;
	}
	

	private static Logger log = Logger.getLogger(Log.class.getName());
	
	@Override
	public User getLoginDetails(String mobileNo, String password) {

		//User use =new User();
		
		
		User use=udao.getUserLoginCredentials(mobileNo, password);
		
		
		return use;
		
		
	}	
		
		
		
		
		/*int loginvalue=1;
		int success=udao.updateUserLoginInfo(mobileNo, loginvalue);
		if( success==1)
		{*/
			
		
		/*}else{
		
		use.setLoginStatusCode(0);
		return use;
		}*/
	

	@Override
	public List<Post> getUserPostedDetails(User use) {
		
		List<Post> pos=pdao.getUserPostDetails(use);
		return pos;
	}

	@Override
	public boolean chkLogMob(String Logmobile) {
		boolean status=pdao.chkLogMob(Logmobile);
		return status;
	}

	@Override
	public User logoutUser(String mobileNo) {
		User use =new User();
		int loginvalue=0;
		int success=udao.updateUserLoginInfo(mobileNo, loginvalue);
		if( success==1)
		{
			
		use.setLoginStatusCode(0);
		use.setActive(false);
		return use;
		
		}else{
		
		use.setLoginStatusCode(1);
		use.setActive(true);
		return use;
		}
	}

	@Override
	public boolean checkEmailIdofUser(String email) {
		
		boolean status=pdao.chkEmailId(email);
		
		return status;
	}

	@Override
	public String updateUserforgotpassword(String email) {
		
		String saltString=getSaltString();

		log.info("Salt String-->"+saltString);
		
		int success=udao.updateUserForgotPassword(email, saltString);
		
		log.info("success-->"+success);
		
		if(success==2){
			
			return saltString;
			
		}
		
		
		
		
		return "AAAA";
	}
	
	
	
	
	public String getSaltString() {
        
		String SALTCHARS = "abcdefghijkABCDEFGHIJKhLmnopMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        SecureRandom rnd = new SecureRandom();
        while (salt.length() < 22) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

	@Override
	public int updateUserNewPassword(String saltString, String newPass, String confirmPass) {
try{
		
			
			String email =udao.getEmailFromSaltString(saltString);
			log.info("Email is -->"+email);
			
			if(email.isEmpty()){
				
				 return 404;
				}
				
				if(newPass.equals(confirmPass)){
					
					 int success=udao.updateNewPassword(newPass, email);
					
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

	
	
	
	
	
	
	
	
}
