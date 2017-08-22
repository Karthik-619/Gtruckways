package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.Post;

public interface CancelService {

	public int cancelPost(String postId);
	
	public Post getPostDetails(String postId,String mobileNo);
}
