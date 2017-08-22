package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;

public interface OtpService {

	public int checkUserOTP(String otp,Post pos);
	
	public Post storePostDetails(Post pos,Price price);
	
}
