package com.cogzy.gtruckways.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.Otp;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.dao.UserDao;
import com.cogzy.gtruckways.validator.Log;

public class UserDaoImpl implements UserDao {

	JdbcTemplate template;  
	 
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	public int saveUser(final User u){  
		  try{
		   
	
			  LocalDateTime dt=LocalDateTime.now().withNano(0);
		      String sql="select * from truckways.user where mobileNo='"+u.getMobileNo()+"' and email='"+ u.getEmail()+"'";  
		     
		     return template.query(sql, new ResultSetExtractor<Integer>() {  

		           public Integer extractData(ResultSet rs) throws SQLException,
		           DataAccessException {
		            
		            if (rs.next()) {
		             String sql="update truckways.user set userName='"+u.getUserName()+"',mobileNo='"+u.getMobileNo()+"',email='"+ u.getEmail()+"',password='"+u.getPassword()+"',userStatus='"+u.getUserStatus()+"',userType='"+u.getUserType()+"',loginStatus='0',gstNumber='"+u.getGstNumber()+"' where mobileNo='"+u.getMobileNo()+"' and email='"+ u.getEmail()+"'"; 
		             
		                return template.update(sql); 
		             
		               }
		            else
		            {
		             String sql="insert into truckways.user(userName,mobileNo,email,password,userStatus,userType,loginStatus,userRegDate,gstNumber) values('"+u.getUserName()+"','"+u.getMobileNo()+"','"+ u.getEmail()+"','"+u.getPassword()+"','"+u.getUserStatus()+"','"+u.getUserType()+"','0','"+dt+"','"+u.getGstNumber()+"')";  
		               
		                return template.update(sql); 
		             
		            }
		                 
		           }
		    
		       });
		   
		   }
		   catch(Exception e)
		   {
		    return 0;
		   }
		  
		       
		 }

	

	public int updateUserName(final User u){  
	
		
		 String sql="update truckways.user set userName='"+u.getUserName()+"' where mobileNo='"+u.getMobileNo()+"' and email='"+ u.getEmail()+"'";
		
		 template.update(sql); 
		
		return 1;
	}
	
	
	public User fetchUserDetails(String mobile){  
		try{
		
	
	    String sql="select * from truckways.user where mobileNo='"+mobile+"' ";  
	   
	    return template.query(sql, new ResultSetExtractor<User>() {  

		        public User extractData(ResultSet rs) throws SQLException,
		        DataAccessException {
		        	User use=new User();
		        	
		        	if (rs.next()) {
		            	
		        		
		            	use.setUserId(rs.getInt("userId"));
		            	use.setUserName(rs.getString("userName"));
		            	use.setEmail(rs.getString("email"));
		            	use.setMobileNo(rs.getString("mobileNo"));
		            	use.setUserStatus(rs.getInt("userStatus"));
		            	use.setPassword(rs.getString("password"));
		               
		               use.setUserType(rs.getString("userType"));
		               use.setLoginStatusCode(rs.getInt("loginStatus"));
		               use.setGstNumber(rs.getString("gstNumber"));
		               use.setActive(true);
		               return use;
		            }
		        	else
		        	{
		        		
		        			use.setActive(false);
			              use.setLoginStatusCode(0);
			            return use;
		        		
		        	}
		              
		        }
		 
		    });
		
		}
		catch(Exception e)
		{
			return null;
		}
		}

	
	public User fetchUserStatusDetails(String mobile, int status){  
		  try{
		  
		     String sql="select * from truckways.user where mobileNo='"+mobile+"' and userStatus='"+status+"'";  
		    
		    return template.query(sql, new ResultSetExtractor<User>() {  

		          public User extractData(ResultSet rs) throws SQLException,
		          DataAccessException {
		           User use=new User();
		           if (rs.next()) {
		               
		           
		               use.setUserId(rs.getInt("userId"));
		               use.setUserName(rs.getString("userName"));
		               use.setEmail(rs.getString("email"));
		               use.setMobileNo(rs.getString("mobileNo"));
		               use.setUserStatus(rs.getInt("userStatus"));
		               use.setPassword(rs.getString("password"));
		                 use.setUserType(rs.getString("userType"));
		                 use.setLoginStatusCode(rs.getInt("loginStatus"));
		                 use.setGstNumber(rs.getString("gstNumber"));
		                 use.setActive(true);
		                 return use;
		              }
		           else
		           {
		    
		             use.setActive(false);
		               use.setLoginStatusCode(0);
		               return use;
		            
		           }
		                
		          }
		   
		      });
		  
		  }
		  catch(Exception e)
		  {
		   return null;
		  }
		  }
	
	
	@Override
	 public int storeOTP(final User u) {
	  
		LocalDateTime dt=LocalDateTime.now().withNano(0);
	   String sql="select * from truckways.otp where mobileNo='"+u.getMobileNo()+"'and email='"+u.getEmail()+"' and userId='"+u.getUserId()+"'";  
	     
	     return template.query(sql, new ResultSetExtractor<Integer>() { 
	      public Integer extractData(ResultSet rs) throws SQLException,
	               DataAccessException {
	           if (rs.next()) {
	    
	            String sql="update truckways.otp set otpNumber='"+u.getUserOtp()+"',otpSendTime='"+dt+"' where userid='"+u.getUserId()+"'"; 
	          return template.update(sql); 
	      
	      }
	           else
	           {
	            String sql="insert into truckways.otp(mobileNo,email,otpNumber,otpSendTime,userId) values('"+u.getMobileNo()+"','"+u.getEmail()+"','"+u.getUserOtp()+"','"+dt+"','"+u.getUserId()+"')";  
	          return template.update(sql);  
	           }
	      }   
	      });
	 }

	@Override
	public int updateOTP(User u) {
		
		String sql="update truckways.otp set otpNumber='"+u.getUserOtp()+"' where userid='"+u.getUserId()+"'"; 
		  
	    return template.update(sql); 
	}

	@Override
	 public Otp getUserOTP(User u) {
	   String sql="select * from truckways.otp where mobileNo='"+u.getMobileNo()+"'and email='"+u.getEmail()+"' and userId='"+u.getUserId()+"'";  
	     
	     return template.query(sql, new ResultSetExtractor<Otp>() {  

	           public Otp extractData(ResultSet rs) throws SQLException,
	                   DataAccessException {
	               if (rs.next()) {
	                Otp ot = new Otp();
	                ot.setOtpNumber(rs.getInt("otpNumber"));
	                  /* ot.setOtpResponseTime("otpResponseTime");
	                   ot.setOtpSendTime("otpSendTime");*/
	                return ot;
	               }
	    
	               return null;
	           }
	    
	       });
	   }

	@Override
	public int updateUserStatus(String mobileNo,LocalDateTime dt) {
		
		  String sql="update truckways.user set userStatus='2',userRegDate='"+dt+"' where mobileNo='"+mobileNo+"'"; 
		  
		    return template.update(sql);   
	}

	@Override
	public User getUserLoginCredentials(String mobileNo, String password) {
		
		String sql="select * from truckways.user where mobileNo='"+mobileNo+"'and password='"+password+"' ";  
		   
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
			            	use.setGstNumber(rs.getString("gstNumber"));
			            	use.setActive(true);
			            	return use;
			            } else{
			        	
			   
			            	use.setActive(false);
			            	
			            	return use;
			           
			        }
			        	
			        }	
			        
			    }); 
		} 
	
	public LocalDriver getDriverStatus(LocalDriver driver){  
	    String sql="SELECT * FROM truckways.localdriver where driverRegNo='"+driver.getDriverRegNo()+"' and driverPassword='"+driver.getPassword()+"'";  
	   
	   return template.query(sql, new ResultSetExtractor<LocalDriver>() {  

		        public LocalDriver extractData(ResultSet rs) throws SQLException,
		        DataAccessException {
		        	LocalDriver driver=new LocalDriver();
		        	if (rs.next()) {
		            	
		        		driver.setDriverStatus(rs.getString("driverStatus"));
		        		
		               return driver;
		            }
		        
		        	
		            return driver;
		        }
		 
		    });
		}
	
	@Override
	public User getEmail(String lmobile) {
		
		User user=new User();
		
		String sql="SELECT email,gstNumber FROM truckways.user where mobileNo='"+lmobile+"' and (userStatus='1' or userStatus='2') ";  
		   
		   return template.query(sql, new ResultSetExtractor<User>() {  

			        public User extractData(ResultSet rs) throws SQLException,
			        DataAccessException {
			        	
			        	if (rs.next()) {
			            	
			        		user.setEmail(rs.getString("email"));
			        		
			        		if(!rs.getString("gstNumber").equals("GGGG")){
			        			Log.info("Gst exists for this Customer");
			        			user.setGstNumber(rs.getString("gstNumber"));
			        			user.setStatusCode(200);
				        		return user;
			        		}
			        		
			        		user.setStatusCode(204);
			        		return user;
			            }
			        
			        	
			        	user.setStatusCode(401);
		        		return user;

			        }
			 
			    });
		
	}

	@Override
	public int updateUserLoginInfo(String mobileNo, int loginvalue) {
		
		 String sql="update truckways.user set loginStatus='"+loginvalue+"' where mobileNo='"+mobileNo+"'"; 
		  
		    return template.update(sql);   
		
	}

	@Override
	public int updateUserForgotPassword(String email, String saltString) {
		
		 String sql="update truckways.user set forgotpass='"+saltString+"' where email='"+email+"'"; 
		  
		    template.update(sql);   
	
		    return 2;
	}

	@Override
	public String getEmailFromSaltString(String saltString) {
		
		String sql="SELECT * FROM truckways.user where forgotpass='"+saltString+"' "; 
		   
		   return template.query(sql, new ResultSetExtractor<String>() {  


			        @Override
			        public String extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	String email="";
			        	if (rs.next()) {
			        		
			        		email=rs.getString("email");
			        		return email;
			            }
			 
			            return email;
			        }
			 
			    });
	}

	@Override
	public int updateNewPassword(String password,String email) {
		
		String sql="update truckways.user set password='"+password+"',forgotpass='AAAA' where email='"+email+"'"; 
		   
		return template.update(sql);
	}
	
	
	
	@Override
	public int storeCustomerInformation(String formCity, String toCity, String vehicleType, String mobileNo) {

		LocalDateTime dt=LocalDateTime.now().plusMinutes(5).withNano(0);
		
		String sql="Insert into truckways.customer(fromCity,toCity,vehicleType,mobileNo,time) value('"+formCity+"','"+toCity+"','"+vehicleType+"','"+mobileNo+"','"+dt+"')";
		
		return template.update(sql);
		
		
	}

	@Override
	public int deletePotentialUser(String mobile) {
		
		LocalDate dt=LocalDate.now();
		
		String sql="delete from truckways.customer where mobileNo='"+mobile+"' and date(time)='"+dt+"'";
		
		return template.update(sql);
	}  
	   
}
