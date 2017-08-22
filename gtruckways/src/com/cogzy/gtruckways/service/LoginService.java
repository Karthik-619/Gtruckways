package com.cogzy.gtruckways.service;

import java.util.List;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.User;

public interface LoginService {

	public User getLoginDetails(String mobileNo,String password);
	
	public List<Post> getUserPostedDetails(User use);
	public boolean chkLogMob(String Logmobile);
	public boolean checkEmailIdofUser(String email);
	public User logoutUser(String mobileNo);
	public String updateUserforgotpassword(String email);
	public int updateUserNewPassword(String saltString,String newPass,String confirmPass);
}
