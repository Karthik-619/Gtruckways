package com.cogzy.gtruckways.serviceImpl;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.daoImpl.PostDaoImpl;
import com.cogzy.gtruckways.daoImpl.UserDaoImpl;
import com.cogzy.gtruckways.service.CancelService;

public class CancelServiceImpl implements CancelService {

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
	public int cancelPost(String postId) {
		int a=1;
		a=pdao.cancelPost(postId);
		return 1;
	}

	@Override
	public Post getPostDetails(String postId, String mobileNo) {
		
	Post pos=pdao.getTrackPostDetails(postId, mobileNo);
		
		return pos;
	}

	
}
