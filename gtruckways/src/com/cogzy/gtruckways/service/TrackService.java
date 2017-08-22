package com.cogzy.gtruckways.service;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.User;

public interface TrackService {

	
public Post	getTrackPostDetails(String postId,String mobileNo);
public User getUserInformation(String mobileNo); 
}
