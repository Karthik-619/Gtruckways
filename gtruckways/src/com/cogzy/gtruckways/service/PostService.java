package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.valueObjects.UserPostInfo;

public interface PostService {

	
	public Post getPostedDetails(UserPostInfo bi,User u,Price price);
	
	
	
}
