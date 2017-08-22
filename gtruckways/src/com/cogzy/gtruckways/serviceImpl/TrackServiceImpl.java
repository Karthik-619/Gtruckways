package com.cogzy.gtruckways.serviceImpl;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.daoImpl.PostDaoImpl;
import com.cogzy.gtruckways.daoImpl.UserDaoImpl;
import com.cogzy.gtruckways.service.TrackService;

public class TrackServiceImpl implements TrackService {

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
	
	@Override
	public Post getTrackPostDetails(String postId, String mobileNo) {
		
		Post pos=pdao.getTrackPostDetails(postId, mobileNo);
		
		return pos;
	}

	@Override
	public User getUserInformation(String mobileNo) {
		
		User use=udao.fetchUserDetails(mobileNo);
		return use;
	}

	
	
}
