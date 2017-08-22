package com.cogzy.gtruckways.serviceImpl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.daoImpl.PostDaoImpl;
import com.cogzy.gtruckways.service.PostService;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.UserPostInfo;

public class PostServiceImpl implements PostService {

	PostDaoImpl pdao;
	
	@Autowired
	TelePostServiceImpl telepostservice; 
	
	public PostDaoImpl getPdao() {
		return pdao;
	}

	public void setPdao(PostDaoImpl pdao) {
		this.pdao = pdao;
	}

	private static Logger log = Logger.getLogger(Log.class.getName());
	
	@Override
	public Post getPostedDetails(UserPostInfo bi, User user,Price price) {
		
		
		// TODO Auto-generated method stub
		
		
		Post pos=new Post();
	
		
		if(bi.getDiffRecepient()==1){
			
			pos.setRecepientName(bi.getRecepientName());
			pos.setRecepientMobile(bi.getRecepientMobileNo());
		
		} else
		{
			pos.setRecepientMobile(bi.getMobileNo());
			pos.setRecepientName(bi.getUserName());
			
		}
		
		try{	
		
		
			LocalDateTime date=LocalDateTime.now().withNano(0);
			String dt=date.toString();
			
			pos.setPostDate(dt);
			/*String td=bi.getTravelDate().toString();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(td, formatter);*/
			
			
			float totalAmount;
			
			AmountDetails amt=telepostservice.getFinalAmount(bi.getTravelDate(), bi.getHelper(),price.getApproximateAmount(), price.getInfo().getLabourPrice(),bi.getDiscountAmount(),0);
			
			float gst=0;
			
			if(!user.getGstNumber().equals("GGGG")){
				
				gst =0;
				
				totalAmount=amt.getTotalAmount()+gst;
				pos.setGstAmount(gst);
				
			} else{
			
			if(amt.getTotalAmount()>=1500){
			
				gst=(float) (amt.getTotalAmount()*0.05);
			
			totalAmount=amt.getTotalAmount()+gst;
			
			} else{
				
				gst=0;
				
				totalAmount=amt.getTotalAmount()+gst;
				
				
			}
			
			}
			pos.setGstAmount(gst);
			pos.setTravelDate(bi.getTravelDate());
			pos.setValueOfGoods(bi.getValueOfGoods());
			pos.setApproximateWeight(bi.getApproximateWeight());
			pos.setMaterial(bi.getMaterial());
			pos.setHelper(bi.getHelper());
			
			if(bi.getPickupArea().isEmpty() || bi.getDropArea().isEmpty()){
				
				pos.setPickUpArea(price.getRoute().getFromCity());
				pos.setDropArea(price.getRoute().getToCity());
				
			} else{
			
			pos.setPickUpArea(bi.getPickupArea());
			pos.setDropArea(bi.getDropArea());
			}
			pos.setApproximateAmount(price.getApproximateAmount());
			pos.setTotalAmount(totalAmount);
			pos.setStatus("Booking Accepted");
			pos.setPromocode(bi.getPromocode());
			pos.setDiscountAmount(bi.getDiscountAmount());
			pos.setUser(user);
		
		    log.info("Existing userId-->"+user.getUserId());
			
		    return pos;
			 
		} catch (Exception e){ 
		
			   log.info("Existing userId Exception-->"+user.getUserId());
			return pos;
		}
		
	}

	

}
