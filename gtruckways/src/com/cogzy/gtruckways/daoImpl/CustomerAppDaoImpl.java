package com.cogzy.gtruckways.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.PromoCode;
import com.cogzy.gtruckways.businessObjects.SignUp;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.dao.CustomerAppDao;
import com.cogzy.gtruckways.valueObjects.ConfirmBookingResponse;
import com.cogzy.gtruckways.valueObjects.GenericResponse;

public class CustomerAppDaoImpl implements CustomerAppDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	
	@Override
	public User getCustomerDetails(String mobile, String password) {
	
		
		String sql="select * from truckways.user where mobileNo='"+mobile+"'and password='"+password+"' ";  
		   
		   return template.query(sql, new ResultSetExtractor<User>() {  
	 

			        @Override
			        public User extractData(ResultSet rs) throws SQLException,
			        DataAccessException {
			        	User use=new User();
			        	if (rs.next()) {
			        		
			            	use.setUserId(rs.getInt("userId"));
			            	use.setUserName(rs.getString("userName"));
			            	use.setEmail(rs.getString("email"));
			            	use.setMobileNo(rs.getString("mobileNo"));
			            	use.setPassword(rs.getString("password"));
			            	use.setActive(true);
			            	return use;
			            } else{
			        	
			            
			            	use.setActive(false);
			            	 System.out.println(use);
			            	return use;
			           
			        }
			        	
			        }	
			        
			    }); 
		
		
		
		
	}



	@Override
	public int getCustomerData(String userName, String email, String phone_no, String fcmToken) {
		
		String query = "insert into truckways.user (userName, mobileNo, email,appUser, fcmToken,password,userStatus,userType) values ('"+userName+"','"+email+"','"+phone_no+"','1', '"+fcmToken+"', '0','0','0')";
		
		return template.update(query);
	}



	@Override
	public SignUp ifDataExist(String phone, String email) {

		String sql="select * from truckways.user where mobileNo='"+phone+"' or email='"+email+"' ";
		
		
		return template.query(sql, new ResultSetExtractor<SignUp>(){

			@Override
			public SignUp extractData(ResultSet args) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				SignUp obj = new SignUp();
				if(args.next())
				{
				    obj.setEmail(args.getString("email"));
					obj.setMobileNo(args.getString("mobileNo"));
					return obj;
				}
				else
				{
					System.out.println("------------->>ifDataExist");
					return null;
				}
				
			}
			
		});
	}



	@Override
	public SignUp getUserData(String phone) {
		String sql="select * from truckways.user where mobileNo='"+phone+"' ";
		
		
		return template.query(sql, new ResultSetExtractor<SignUp>(){

			@Override
			public SignUp extractData(ResultSet args) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				SignUp obj = new SignUp();
				if(args.next())
				{
					obj.setEmail(args.getString("email"));
					obj.setMobileNo(args.getString("mobileNo"));
					obj.setUserName(args.getString("userName"));
					//obj.setLastName(args.getString("last_name"));
					obj.setUserId(args.getInt("userId"));
					return obj;
				}
				else
				{
					System.out.println("------------->>getUserData");
					return null;
				}
				
			}
			
		});
	}



	@Override
	public int getUserProfile(int userId, String user_name, String email, String phone) {
		// TODO Auto-generated method stub
		
		String query = "update truckways.user set userName ='"+user_name+"', "
				+ "email='"+email+"' where userId='"+userId+"' ";
		
		return template.update(query);
	}



	@Override
	public int getConfirmBooking(ConfirmBookingResponse pos) {
		
		
		//int truckId = 1;
		String sql="insert into truckways.postdetail(postId,refPostId,userId,fromCity,toCity,material,postDate,travelDate,"
				+ "truckId,status,approxKm,approxMins,totalAmount,approxAmount,sourceLat,sourceLong,destLat,destLong,bookingStatus,recipientMobile,paymentMode,recipientName,pickUp,dropArea,valueOfGoods,approximateWeight,helper,baseFare,helperAmount,promocode,discountAmount,freeKm,freeMins,slab1Price,slab2Price,gstAmount)"
	+ " values('"+pos.getPostId()+"', '"+pos.getRefPostId()+"', '"+pos.getUserId()+"', '"+pos.getFromCity()+"', '"+pos.getToCity()+"', '"+pos.getMaterial()+"', '"+pos.getPostDate()+"', '"+pos.getTravelDate()+"', '"+pos.getTruckId()+"', '"+pos.getStatus()+"', '"+pos.getKilometers()+"', '"+pos.getMinutes()+"', '"+pos.getTotalAmount()+"', '"+pos.getApproximateAmount()+"', '"+pos.getSourceLat()+"', '"+pos.getSourceLong()+"', '"+pos.getDestLat()+"', '"+pos.getDestLong()+"', '"+pos.getBookingStatus()+"', '"+pos.getRecipientMobile()+"','"+pos.getPaymentMode()+"', '"+pos.getRecipientName()+"', '"+pos.getPickUp()+"', '"+pos.getDropArea()+"', '"+pos.getApproximateCost()+"', '"+pos.getApproximateWeight()+"', '"+pos.getHelper()+"', '"+pos.getBaseFare()+"', '"+pos.getHelperAmount()+"', '"+pos.getPromoCode()+"','"+pos.getDiscountAmount()+"','"+pos.getFreeKm()+"', '"+pos.getFreeMins()+"', '"+pos.getSlab1Price()+"', '"+pos.getSlab2Price()+"', '"+pos.getGstAmount()+"' )";  
		  
	    return template.update(sql);   
	}



	@Override
	public ConfirmBookingResponse getBookingDetails(String booking_id) {
		String sql="select * from truckways.postdetail where refPostId='"+booking_id+"' ";
		
		return template.query(sql, new ResultSetExtractor<ConfirmBookingResponse>(){

			@Override
			public ConfirmBookingResponse extractData(ResultSet args) throws SQLException, DataAccessException {


				ConfirmBookingResponse obj = new ConfirmBookingResponse();
				if(args.next())
				{
					obj.setPostId(args.getInt("postId"));
					obj.setTruckId(args.getInt("truckId"));
					obj.setFromCity(args.getString("fromCity"));
					obj.setToCity(args.getString("toCity"));
					obj.setMaterial(args.getString("material"));
					obj.setStatus(args.getString("status"));
					obj.setUserId(args.getInt("userId"));
					obj.setKilometers(args.getFloat("approxKm"));
					obj.setMinutes(args.getFloat("approxMins"));
					obj.setTotalAmount(args.getFloat("totalAmount"));
					obj.setSourceLat(args.getDouble("sourceLat"));
					obj.setSourceLong(args.getDouble("sourceLong"));
					obj.setDestLat(args.getDouble("destLat"));
					obj.setDestLong(args.getDouble("destLong"));
					return obj;
				}
				else
				{
					System.out.println("------------->>getUserData");
					obj.setStatus("404");
					return obj;
				}
			}
			
		});
	}



	@Override
	public int getBookingId(String booking_id, String reason, String comment) {
		
		String query = "update truckways.postdetail set status ='Canceled', bookingStatus='3', cancelReason='"+reason+"', comment='"+comment+"' where refPostId='"+booking_id+"' ";
		
		return template.update(query);
	}



	@Override
	public List<ConfirmBookingResponse> getOrderList(int user_id) {
		
		String sql="select * from truckways.postdetail where userId='"+user_id+"' ";
		
		return template.query(sql, new ResultSetExtractor<List<ConfirmBookingResponse>>(){

			@Override
			public List<ConfirmBookingResponse> extractData(ResultSet args) throws SQLException, DataAccessException {
				
				
				List<ConfirmBookingResponse> ps = new ArrayList<ConfirmBookingResponse>();
				while(args.next())
				{
					ConfirmBookingResponse response = new ConfirmBookingResponse();
					
					response.setStatus(args.getString("status"));
					response.setBookingStatus(args.getInt("bookingStatus"));
					response.setRefPostId(args.getString("refPostId"));
			        response.setFromCity(args.getString("fromCity"));
			        response.setToCity(args.getString("toCity"));
			        response.setTravelDate(args.getString("travelDate"));
			        response.setPostDate(args.getString("postDate"));
			        response.setMaterial(args.getString("material"));
			       // response.setApproximateAmount(args.getString("approximateAmount"));
			        response.setTruckId(args.getInt("truckId"));
			        response.setTotalAmount(args.getFloat("totalAmount"));
			        response.setDriverId(args.getInt("driverId"));
			        
			        
			        
					ps.add(response);
				}
				
				return ps;
			}});
	}



	@Override
	public int updateFcmToken(String phoneNo, String fcmToken) {
		
		String query = "update truckways.user set fcmToken ='"+fcmToken+"' where mobileNo='"+phoneNo+"' ";
		
		return template.update(query);
	}



	@Override
	public LocalDriver getDriverId(int driverId) {
		
		String sql="select * from truckways.localdriver where localDriverId='"+driverId+"' ";
		return template.query(sql, new ResultSetExtractor<LocalDriver>(){

			@Override
			public LocalDriver extractData(ResultSet args) throws SQLException, DataAccessException {
			
				LocalDriver obj = new LocalDriver();
				
				if(args.next())
				{
					obj.setDriverName(args.getString("driverName"));
					
					return obj;
				}
				else
				{
					System.out.println("------------->>getDriverId");
					return null;
				}
			}
			
		});
	}

 
	
	 public int storeOTP(String mobile,String email,int otp,int userId) {
		  
			LocalDateTime dt=LocalDateTime.now().withNano(0);
		   String sql="select * from truckways.otp where mobileNo='"+mobile+"'and email='"+email+"' and userId='"+otp+"'";  
		     
		     return template.query(sql, new ResultSetExtractor<Integer>() { 
		      public Integer extractData(ResultSet rs) throws SQLException,
		               DataAccessException {
		           if (rs.next()) {
		    
		            String sql="update truckways.otp set otpNumber='"+otp+"',otpSendTime='"+dt+"' where userid='"+userId+"'"; 
		          return template.update(sql); 
		      
		      }
		           else
		           {
		            String sql="insert into truckways.otp(mobileNo,email,otpNumber,otpSendTime,userId) values('"+mobile+"','"+email+"','"+otp+"','"+dt+"','"+userId+"')";  
		          return template.update(sql);  
		           }
		      }   
		      });
		 }



	@Override
	public List<PromoCode> getPromocodes() {
		
		
		String sql="SELECT * FROM truckways.promocode where active='1'";  
		   
		   return template.query(sql, new ResultSetExtractor<List<PromoCode>>() {  
	 

			        @Override
			        public List<PromoCode> extractData(ResultSet rs) throws SQLException,
			        DataAccessException {
			        	
			        	
			        	
			        	List<PromoCode> as=new ArrayList<PromoCode>();
			        	
			        	while (rs.next()) {
			        		
			        		PromoCode promo=new PromoCode();
			        		promo.setPromoCode(rs.getString("promoCode"));
			        		promo.setDiscountAmount(rs.getFloat("discountPercent"));
			        		promo.setDescription(rs.getString("description"));
			            	as.add(promo);
			        		
			            } 
			        	
			          
			            return as;
			           
			       
			        	
			        }	
			        
			    }); 
		
		
		
		
		
	}
	

	
	
	
}
