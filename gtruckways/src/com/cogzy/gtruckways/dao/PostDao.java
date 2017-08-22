package com.cogzy.gtruckways.dao;

import java.util.List;

import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.User;

public interface PostDao {

	public int getrandompostid();
	
	public int savepostdetails(Post pos);
	
	public Post getPostDetails(String postid);

	public Post getTrackPostDetails(String postid,String mobile);

	public List<Post> getUserPostDetails(User use);

	public int cancelPost(String PostId);

	public boolean chkLogMob(String Logmobile);
	
	
	
}
