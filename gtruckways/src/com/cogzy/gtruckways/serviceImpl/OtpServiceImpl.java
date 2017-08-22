package com.cogzy.gtruckways.serviceImpl;

import com.cogzy.gtruckways.businessObjects.Otp;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.daoImpl.PostDaoImpl;
import com.cogzy.gtruckways.daoImpl.UserDaoImpl;
import com.cogzy.gtruckways.service.OtpService;
import com.cogzy.gtruckways.validator.Log;

public class OtpServiceImpl implements OtpService {

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
	public int checkUserOTP(String otp,Post pos) {
	
		
		Otp ot= new Otp();
		
		ot=udao.getUserOTP(pos.getUser());
	
		Log.info("OtpServiceImpl-->OtpNumber-->"+ot.getOtpNumber());
		
		if(Integer.parseInt(otp)==ot.getOtpNumber()){
			
			Log.info("OtpServiceImpl-->Genuine User-->");
			
			return 1;
		} else
		{
			return 0;
		}
		
		
	}
		
		

	@Override
	public Post storePostDetails(Post pos,Price price) {
		// TODO Auto-generated method stub

		
		int invoiceId=pdao.getrandompostid();
		Log.info("OtpServiceImpl-->StorePostDetails-->Invoice-->"+invoiceId);
	
		
		String bookingId="GTR"+invoiceId;
		pos.setInvoiceId(invoiceId);
		pos.setBookingId(bookingId);
		pos.setPrice(price);
		pos.setBookedThrough("Web");
		
		Log.info("OtpServiceImpl-->StorePostDetaisls-->CustomerBookingId-->"+bookingId);
		pdao.savepostdetails(pos);
		
		pos=pdao.getPostDetails(pos.getBookingId());
		
		if(price.getLandPageStatus()==200){
			
			udao.deletePotentialUser(pos.getUser().getMobileNo());
			
		}
		
		
		return pos;
	}

}
