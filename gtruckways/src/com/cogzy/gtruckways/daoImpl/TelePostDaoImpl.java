package com.cogzy.gtruckways.daoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cogzy.gtruckways.businessObjects.Accounts;
import com.cogzy.gtruckways.businessObjects.CustomerPayment;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.DriverDetailsResponse;
import com.cogzy.gtruckways.businessObjects.DriverTripDetailsResponse;
import com.cogzy.gtruckways.businessObjects.FinancialTransaction;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.Invoice;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.LocalTransporter;
import com.cogzy.gtruckways.businessObjects.Payment;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.Telecaller;
import com.cogzy.gtruckways.businessObjects.TripDetails;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.dao.TelePostDao;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.DriverAppRequestPojo;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class TelePostDaoImpl implements TelePostDao{

	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	} 
	
	private static Logger log = Logger.getLogger(Log.class.getName());
	//method to fetch all the bookings from postdetail table
	public List<Post> getPostDetails() {
		
	    String sql = "SELECT postdetail.postId,postdetail.refPostId,postdetail.fromCity,postdetail.toCity,postdetail.material,postdetail.postDate,postdetail.travelDate,postdetail.status,truckinfo.truckName,user.userName  FROM truckways.postdetail inner join truckways.truckinfo on postdetail.truckId=truckinfo.truckId inner join user on user.userId=postdetail.userId order by date(travelDate) desc";
	    try {
	    	return template.query(sql, new ResultSetExtractor<List<Post>>() {
	 
	        @Override
	        public List<Post> extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        				
			            	ArrayList<Post> ps = new ArrayList<Post>();
							while (rs.next()){
									TruckInfo tr=new TruckInfo();
								
									Post p = new Post();
									p.setInvoiceId(rs.getInt("postId"));
					            	p.setBookingId(rs.getString("refPostId"));
					            	p.setFromCity(rs.getString("fromCity"));
					            	p.setToCity(rs.getString("toCity"));
					            	p.setMaterial(rs.getString("material"));
					            	p.setPostDate(rs.getString("postDate"));
					            	p.setTravelDate(rs.getString("travelDate"));
					            	p.setStatus(rs.getString("status"));
									User user=new User();
									user.setUserName(rs.getString("userName"));
					            	p.setUser(user);
					            	tr.setTruckName(rs.getString("truckName"));
									
									p.setInfoTruck(tr);
					            	ps.add(p);
			    		   
							}
							return ps;
			            	
	        		}
	 
	    });
	    } catch (EmptyResultDataAccessException e) {
	    	return null;
	    }
	}
	
	
	
	//method to fetch the details of particular Bookid from postdetail table
		public Post getPostInformation(String PostId) {
		    String sql = "select postdetail.*, user.userName, user.mobileNo, user.email, truckinfo.*,TIME_FORMAT(srcReachedDateTime,'%H:%i') as srcTime,TIME_FORMAT(unloadingDateTime,'%H:%i') as unloadTime from postdetail inner join user on postdetail.userId = user.userId inner join truckinfo on postdetail.truckId = truckinfo.truckId where refPostId='"+PostId+"'";
			Post ps = new Post(); 
		    try {
		    	return template.query(sql, new ResultSetExtractor<Post>() {
		 
		        @Override
		        public Post extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        				if (rs.next()) {
				            
				            	User us=new User();
				            	TruckInfo ti=new TruckInfo();
				            	LocalDriver ld=new LocalDriver();
				            	
				            	
				            	ps.setInvoiceId(rs.getInt("postId"));
				            	ps.setBookingId(rs.getString("refPostId"));
				            	ps.setFromCity(rs.getString("fromCity"));
				            	ps.setToCity(rs.getString("toCity"));
				            	ps.setPickUpArea(rs.getString("pickUp"));
				            	ps.setDropArea(rs.getString("dropArea"));	            	
				            	ps.setMaterial(rs.getString("material"));
				            	ps.setPostDate(rs.getString("postDate"));
				            	ps.setTravelDate(rs.getString("travelDate"));
				            	
				            	ps.setHelper(rs.getInt("helper"));
				            	ps.setStatus(rs.getString("status"));
				            	ps.setRecepientMobile(rs.getString("recipientMobile"));
								ps.setRecepientName(rs.getString("recipientName"));
								ps.setGtruckwaysAmount(rs.getFloat("gtruckwaysAmount"));
								ps.setDriverAmount(rs.getFloat("driverAmount"));
								ps.setsLat(rs.getDouble("sourceLat"));
								ps.setsLong(rs.getDouble("sourceLong"));
								ps.setdLat(rs.getDouble("destLat"));
								ps.setdLong(rs.getDouble("destLong"));
								ps.setSrcReachedDateTime(rs.getString("srcTime"));
								ps.setLoadingDateTime(rs.getString("loadingDateTime"));
								ps.setDestReachedDateTime(rs.getString("destReachedDateTime"));
								ps.setUnloadingDateTime(rs.getString("unloadTime"));
								ps.setApproximateKm(rs.getFloat("approxKm"));
								ps.setApproximateMins(rs.getInt("approxMins"));
								ps.setApproximateAmount(rs.getFloat("approxAmount"));
								ps.setApproximateWeight(rs.getInt("approximateWeight"));
								ps.setDiscountAmount(rs.getFloat("discountAmount"));
								ps.setPromocode(rs.getString("promocode"));
								ps.setValueOfGoods(rs.getInt("valueOfGoods"));
								ps.setBasePrice(rs.getFloat("baseFare"));
								ps.setTotalKm(rs.getFloat("totalKm"));
								ps.setExtraKm(rs.getFloat("extraKm"));
								ps.setExtraMins(rs.getFloat("extraMins"));
								ps.setExtraKmAmount(rs.getFloat("extraKmAmount"));
								ps.setExtraMinsAmount(rs.getFloat("extraMinsAmount"));
								ps.setHelperAmount(rs.getFloat("helperAmount"));
								ps.setTotalAmount(rs.getFloat("totalAmount"));
								ps.setOtherAmount(rs.getFloat("otherAmount"));
								ps.setGstAmount(rs.getFloat("gstAmount"));
								ps.setTotalMins(rs.getFloat("totalMins"));
								ps.setFreeKm(rs.getFloat("freeKm"));
								ps.setFreeMins(rs.getFloat("freeMins"));
								ps.setNightCharges(rs.getFloat("nightCharges"));
								ps.setGstNumber(rs.getString("gstNumber"));
								
								LocalDriver driver =new LocalDriver();
								driver.setDriverId(rs.getInt("driverId"));
								ps.setDriver(driver);
								
								
				            	us.setUserName(rs.getString("userName"));
				            	us.setMobileNo(rs.getString("mobileNo"));
				            	us.setUserId(rs.getInt("userId"));
				            	us.setEmail(rs.getString("email"));
				            	
				            	
				            	ti.setTruckId(rs.getInt("truckId"));
				            	ti.setTruckName(rs.getString("truckName"));
				            	ti.setLabourPrice(rs.getFloat("labourPrice"));
				            	ti.setAdditionalmins(rs.getFloat("additionalmins"));
				            	ti.setAdditionalPrice(rs.getFloat("slab1Price"));
				            	ti.setBasePrice(rs.getFloat("basePrice"));
				            	ti.setFreeKm(rs.getInt("freeKm"));
				            	ti.setFreeMins(rs.getInt("freeMins"));
				            	ti.setSlab2Km(rs.getInt("slab1Km"));
				            	ti.setSecondPrice(rs.getFloat("slab2Price"));
				            	ps.setUser(us);
				            	ps.setInfoTruck(ti);
				            	ps.setStatusCode(200);
				            	return ps;
		        				}
		        				
		        				ps.setStatusCode(404);
				            	return ps;
		        			
		        			
		        				
		        		}
		 
		    		});
		    	} catch (EmptyResultDataAccessException e) {
		    	ps.setStatusCode(404);
            	return ps;
			
		    }
		}
		
		//method will fetch list of available trucks and their price details from truckinfo table
		public List<TruckInfo> getTruckInfoDetails() {
		   
			String sql = "SELECT * FROM truckways.truckinfo where truckId=1 or truckId=2";
		    
			try {
		    	return template.query(sql, new ResultSetExtractor<List<TruckInfo>>() {
		 
		        @Override
		        public List<TruckInfo> extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        				
				            	ArrayList<TruckInfo> t = new ArrayList<TruckInfo>();
								while (rs.next()){
				    	   
									TruckInfo tr = new TruckInfo();
					            	
									tr.setTruckId(rs.getInt("truckId"));
					            	tr.setTruckName(rs.getString("truckName"));
					            	tr.setBasePrice(rs.getFloat("basePrice"));
					            	tr.setAdditionalPrice(rs.getFloat("additionalPrice"));	            	
					            	tr.setAdditionalmins(rs.getFloat("additionalmins"));
					            	tr.setLabourPrice(rs.getFloat("labourPrice"));
					            	tr.setHaltingPrice(rs.getFloat("haltingPrice"));
					            	tr.setNightPrice(rs.getFloat("nightPrice"));
					            	tr.setCapacity(rs.getString("capacity"));
					            	tr.setDimension(rs.getString("dimension"));
					            	tr.setSecondPrice(rs.getFloat("secondPrice"));
					            	tr.setFreeKm(rs.getInt("freeKm"));
					            	tr.setFreeMins(rs.getInt("freeMins"));
					            	tr.setSlab2Km(rs.getInt("slab1Km"));
										
										t.add(tr);
				    		   
								}
								return t;
				            	
		        		}
		 
		    		});
		    	} catch (EmptyResultDataAccessException e) {
		    	return null;
		    }
		}
		
		
		
		//method to check whether customer payment is done or not for particular BookId, If payment done, fetch the details	
				public CustomerPayment getCustomerPaymentInfo(int PostId) {
					
					String sql = "select * from truckways.customerpayment where postId='"+PostId+"'";
						    
					try {
						    return template.query(sql, new ResultSetExtractor<CustomerPayment>() {
						 
						    @Override
						    public CustomerPayment extractData(ResultSet rs) throws SQLException,
						    DataAccessException {
						        if (rs.next()) {
								            	
						        	CustomerPayment cp=new CustomerPayment();
								            	
						        	cp.setAmtPaid(rs.getFloat("amtPaid"));	
						        	cp.setCustomerPaymentId(rs.getInt("customerPaymentId"));
						        	cp.setPaymentDate(rs.getString("paymentDate"));
						        	cp.setTotAmount(rs.getFloat("totAmount"));
								            	
								    return cp;
						        }
						        else
						        {
						        	return null;
						        }
						        				
						    }
						 
					});
			} catch (EmptyResultDataAccessException e) {
					return null;
			}
		}
				
		@Override
		public int updatePostDetails(final Post ps){  
				      
				   try {
				     
				     String sel="select truckId from truckinfo where truckName='"+ps.getInfoTruck().getTruckName()+"'";
				     
				     return template.query(sel, new ResultSetExtractor<Integer>(){
				     
				     public Integer extractData(ResultSet rs) throws SQLException,
				                   DataAccessException {
				              if (rs.next()) {
				               
				                  int truckId=rs.getInt("truckId");
				                  System.out.println(truckId);
				                  String sql="update postdetail inner join user on postdetail.userId = user.userId inner join truckinfo on postdetail.truckId = truckinfo.truckId set postdetail.material = '"+ps.getMaterial()+"', postdetail.travelDate = '"+ps.getTravelDate()+"', postdetail.pickUp = '"+ps.getPickUpArea()+"', postdetail.dropArea = '"+ps.getDropArea()+"', postdetail.helper ='"+ps.getHelper()+"' ,postdetail.approxAmount='"+ps.getTotalAmount()+"', postdetail.totalAmount = '"+ps.getTotalAmount()+"', postdetail.truckId = '"+truckId+"',status='"+ps.getStatus()+"', recipientName='"+ps.getRecepientName()+"', recipientMobile='"+ps.getRecepientMobile()+"',valueOfGoods='"+ps.getValueOfGoods()+"',approximateWeight='"+ps.getApproximateWeight()+"' where refPostId = '"+ps.getBookingId()+"'";  
				         int status=template.update(sql);
				         System.out.println(status);
				             
				         return status; 
				                 
				              }
				              else{
				               return 0;
				              }
				       }
				     });
				      
				    } catch (EmptyResultDataAccessException e) {
				           return 0;
				    }
		}
		//method to check if there is already an account for user
		public int getAccountsId(int UserId){
	
			try {
					String sel="select accountsId from truckways.accounts where userId='"+UserId+"'";
					return template.query(sel, new ResultSetExtractor<Integer>() {
					@Override
					public Integer extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        			if (rs.next()) {
			        				
						            int AccId=rs.getInt("accountsId");
						            return AccId;
			        			}
			        			else{
			        				return 0;
			        			}
					 }
				
					});
			} catch (EmptyResultDataAccessException e) {
		    	return 0;
			}
		}
		
		// method to create an account for new user
		public int addToAccounts(int UserId){  
			
			try {
					String sql="insert into truckways.accounts(acctType,userType,userId) values ('Individual', 'Customer','"+UserId+"')"; 
			        template.update(sql);

			        return 1;
			        	  						 
			 } catch (EmptyResultDataAccessException e) {
			    	return 0;
			 }
		}
		
		
		public int updateCancel(Post ps){  
			
			 try {
				 	String sql="update postdetail set status='"+ps.getStatus()+"' where refPostId = '"+ps.getBookingId()+"'";  
				 	int status=template.update(sql);
				 	return status;  
			 } catch (EmptyResultDataAccessException e) {
			    	return 0;
			 }
		}
		
		//method to update customer payment details
		public int updateCustomerPayment(Post pos){  
		
			 try {
				
					String sql="update truckways.postdetail set status='Completed',totalAmount='"+pos.getTotalAmount()+"',otherAmount='"+pos.getOtherAmount()+"',discountAmount='"+pos.getDiscountAmount()+"',gstAmount='"+pos.getGstAmount()+"',gtruckwaysAmount='"+pos.getGtruckwaysAmount()+"',driverAmount='"+pos.getDriverAmount()+"',bookingStatus='4' where refPostId='"+pos.getBookingId()+"'";
				 	return template.update(sql);
				
			 	} catch (EmptyResultDataAccessException e) {
			    	return 0;
			 }
		}
		
		//method to insert to FinancialTransaction which is required in generation of invoice
		public int addFinancialTransaction(CustomerPayment cp, int AccId){  

			try {
					
				  	String sql="insert into truckways.financialtransaction(transactionType,transactionDate,accountId) values ('Received', '"+cp.getPaymentDate()+"','"+AccId+"')"; 
				  	template.update(sql);
			        String sel="select transactionId from truckways.financialtransaction where accountId='"+AccId+"' and transactionDate=(select max(transactionDate) from truckways.financialtransaction)";
			        return template.query(sel, new ResultSetExtractor<Integer>() {
			        @Override
			        public Integer extractData(ResultSet rs) throws SQLException,
			        DataAccessException {
			        	  if (rs.next()) {
			        		  	int tranId=rs.getInt("transactionId");
					            return tranId;
			        	   }
			        	  else{
			        		  return 0;
			        	  }
			        }
				
				});
						 
			 } catch (EmptyResultDataAccessException e) {
			    	return 0;
			 }
		}
		
		public int addAccountReceivable(CustomerPayment cp, int AccId,int transactionId){  

			try {
					String sql="insert into truckways.accountreceivable(transactionDate,amount,accountId,transactionId) values ('"+cp.getPaymentDate()+"','"+cp.getAmtPaid()+"','"+AccId+"','"+transactionId+"')"; 
					template.update(sql);
					String sel="select acctReceivableId from truckways.accountreceivable where transactionId='"+transactionId+"'";
					return template.query(sel, new ResultSetExtractor<Integer>() {
						@Override
						public Integer extractData(ResultSet rs) throws SQLException,
						DataAccessException {
							if (rs.next()) {
								int accReceivableId=rs.getInt("acctReceivableId");
								return accReceivableId;
							}
							else{
								return 0;
							}
						}
						
					});
						 
			} catch (EmptyResultDataAccessException e) {
				return 0;
			}
		}
		
		
		public int addPayment(final CustomerPayment cp, final int transactionId,final int AccId,final int accReceivableId){

			try {
					 
				  	String sql="insert into truckways.payment(paymentType,amtDue,amtReceived,balance,transactionId,accReceivableId) values ('Full', '"+cp.getTotAmount()+"','"+cp.getAmtPaid()+"','0.0','"+transactionId+"','"+accReceivableId+"')"; 
				  	template.update(sql);
				  	 String sel="select paymentId from truckways.payment where transactionId='"+transactionId+"' and accReceivableId='"+accReceivableId+"'";
				        return template.query(sel, new ResultSetExtractor<Integer>() {
				        @Override
				        public Integer extractData(ResultSet rs) throws SQLException,
				        DataAccessException {
				        	  if (rs.next()) {
				        		  	int paymentId=rs.getInt("paymentId");
				        		  	String invoice="insert into truckways.invoice(transactionId,paymentId,accountId,acctReceivableId,postId) values ('"+transactionId+"','"+paymentId+"','"+AccId+"','"+accReceivableId+"','"+cp.getPostId().getPostId()+"')"; 
								  	template.update(invoice);
						            return 1;
				        	   }
				        	  return 0;
				  	
				        }
						
						});
				  	
						 
			 } catch (EmptyResultDataAccessException e) {
			    	return 0;
			 }
		}
		
		//method to check whether status is scheduled before loading
		public String checkStatus(String Postid){  

			try {
				  	String sql="select status from truckways.postdetail where refPostId = '"+Postid+"'"; 
				 	return template.query(sql, new ResultSetExtractor<String>() {
				 		 
				        @Override
				        public String extractData(ResultSet rs) throws SQLException,
				                DataAccessException {
				        			if (rs.next()) {
							            	
				        				String getstatus=rs.getString("status");
							            return getstatus;
							        }
						        return null;
				        }
				 	
				 });		 
			 } catch (EmptyResultDataAccessException e) {
			    	return null;
			 }
		}
		
		public int srcReached(Post ps){  
	
			 try {
				 
				  	String sql="update truckways.postdetail set status='"+ps.getStatus()+"',srcReachedDateTime='"+ps.getSrcReachedDateTime()+"',bookingStatus='22' where refPostId = '"+ps.getBookingId()+"'"; 
				 	int status=template.update(sql);
		 	
				 	return status;  
							 
			 } catch (EmptyResultDataAccessException e) {
			    	return 0;
			 }
		}
		
		//method to update load and unload status
		public int updateLoad(final Post ps){  
			
			try {
			 	String sql="select driverid from truckways.postdetail where refPostId = '"+ps.getBookingId()+"'"; 
			 	return template.query(sql, new ResultSetExtractor<Integer>() {
			 		 
			        @Override
			        public Integer extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        			if (rs.next()) {
						            	
			        				String driverId=rs.getString("driverid");
						           
						            String update="insert into truckways.tripdetails(bookingId,driverId) values ('"+ps.getBookingId()+"','"+driverId+"')";
								 	template.update(update);
								 	String sql="update truckways.postdetail set status='"+ps.getStatus()+"', loadingDateTime='"+ps.getLoadingDateTime()+"'where refPostId = '"+ps.getBookingId()+"'"; 
								 	int status=template.update(sql);
								 	
								 	return status; 
						            
						        }
					        return null;
			        }
			 	
			 });	
			
			 	 
						 
		 } catch (EmptyResultDataAccessException e) {
		    	return 0;
		 }
	}
		
		public int destReached(Post ps){  
		
			 try {
				 
				  	String sql="update truckways.postdetail set status='"+ps.getStatus()+"',destReachedDateTime='"+ps.getDestReachedDateTime()+"' where refPostId = '"+ps.getBookingId()+"'"; 
				 	int status=template.update(sql);
				 	return status;  
							 
			 } catch (EmptyResultDataAccessException e) {
			    	return 0;
			 }
		}
		
		//method to check whether Payment is done before unloading
		public int checkPayment(int postId){  
			try {
				
				  	String sql="select * from truckways.customerpayment where postId = '"+postId+"'"; 
				 	return template.query(sql, new ResultSetExtractor<Integer>() {
				 		 
				        @Override
				        public Integer extractData(ResultSet rs) throws SQLException,
				                DataAccessException {
				        			if (rs.next()) {
							            
				        				return 1;
				        			}
						            	
						        return 0;
				        }
				 	
				 });		 
			 } catch (EmptyResultDataAccessException e) {
			    	return 0;
			 }
		}
		
		public int updateUnload(Post ps){  
			
			 try {
				
				  	String sql="update truckways.postdetail set status='"+ps.getStatus()+"',unloadingDateTime='"+ps.getUnloadingDateTime()+"' where refPostId = '"+ps.getBookingId()+"'"; 
				 	int status=template.update(sql);
				 	return status;  
							 
			 } catch (EmptyResultDataAccessException e) {
			    	return 0;
			 }
		}
		
		//method to fetch the details of transporter confirmation	
		public Invoice getInvoiceDetails(int PostId){
					 try {
						 String sql = "select postdetail.*, financialtransaction.transactionType , financialtransaction.transactionDate , payment.paymentType, payment.amtDue, payment.amtReceived, payment.balance, accounts.userType , user.userName, user.mobileNo,user.email, invoice.invoiceId,truckinfo.truckName from invoice inner join accounts on accounts.accountsId = invoice.accountId inner join user on user.userId = accounts.userId inner join financialtransaction on invoice.transactionId = financialtransaction.transactionId inner join accountreceivable on invoice.acctReceivableId = accountreceivable.acctReceivableId inner join payment on invoice.paymentId = payment.paymentId inner join postdetail on invoice.postId = postdetail.postId inner join truckinfo on postdetail.truckId = truckinfo.truckId where invoice.postId='"+PostId+"'";
						 return template.query(sql, new ResultSetExtractor<Invoice>() {
						        @Override
						        public Invoice extractData(ResultSet rs) throws SQLException,
						        DataAccessException {
					        				if (rs.next()) {
					        					Post ps=new Post();
					        					Invoice in=new Invoice();
					        					FinancialTransaction ft=new FinancialTransaction();
					        					Payment pm=new Payment();
					        					Accounts ac=new Accounts();
					        					User us=new User();
					        					TruckInfo ti=new TruckInfo();
					        					
					        					us.setUserName(rs.getString("userName"));
					        					us.setEmail(rs.getString("email"));
					        					us.setMobileNo(rs.getString("mobileNo"));
					        					
					        					ps.setFromCity(rs.getString("fromCity"));
					        					ps.setToCity(rs.getString("toCity"));
					        					ps.setMaterial(rs.getString("material"));
					        					ps.setTravelDate(rs.getString("travelDate"));
					        					ps.setPickUpArea(rs.getString("pickUp"));
					        					ps.setDropArea(rs.getString("dropArea"));
					        					ps.setRecepientName(rs.getString("recipientName"));
					        					ps.setUser(us);
					        					ps.setInfoTruck(ti);
					        					ps.setRecepientMobile(rs.getString("recipientMobile"));
					        					ps.setPostId(rs.getInt("postId"));
					        					ps.setRefPostId(rs.getString("refPostId"));
					        					ps.setTotalAmount(rs.getFloat("totalAmount"));
					        					ps.setApproximateAmount(rs.getFloat("approximateAmount"));
					        					ps.setAdditionalAmount(rs.getFloat("additionalAmount"));
					        					ft.setTransactionType(rs.getString("transactionType"));
					        					ft.setTransactionDate(rs.getString("transactionDate"));
					        					
					        					pm.setPaymentType(rs.getString("paymentType"));
					        					pm.setAmtDue(rs.getFloat("amtDue"));
					        					pm.setAmtReceived(rs.getFloat("amtReceived"));
					        					pm.setBalance(rs.getFloat("balance"));
					        					
					        								        					
					        					ac.setUserType(rs.getString("userType"));
					        					ac.setUser(us);
					        					
					        					ti.setTruckName(rs.getString("truckName"));
					        					
					        					in.setPayment(pm);
					        					in.setPost(ps);
					        					in.setTransaction(ft);
					        					in.setAccts(ac);
					        					in.setInvoiceId(rs.getInt("invoiceId"));
					        					return in;
					        				}
					        				else
					        				{
					        					return null;
					        				}
					        				
					        		}
					 
					    });
					 } catch (EmptyResultDataAccessException e) {
					    	return null;
					}
		}
		
		
		public Invoice getCancelationInvoiceDetails(String postId){
			Invoice in=new Invoice();
			try {
				 String sql ="SELECT * FROM truckways.postdetail inner join user on user.userId=postdetail.userId inner join truckinfo on truckinfo.truckId=postdetail.truckId  where refPostId='"+postId+"'";
				
				 return template.query(sql, new ResultSetExtractor<Invoice>() {
				        @Override
				        public Invoice extractData(ResultSet rs) throws SQLException,
				        DataAccessException {
				        	
			        				if (rs.next()) {
			        					
			        				
			        				
			        					Post ps=new Post();
			        					User us=new User();
			        					TruckInfo ti=new TruckInfo();
			        					
			        					us.setUserName(rs.getString("userName"));
			        					us.setEmail(rs.getString("email"));
			        					us.setMobileNo(rs.getString("mobileNo"));
			        					
			        					ps.setFromCity(rs.getString("fromCity"));
			        					ps.setToCity(rs.getString("toCity"));
			        					ps.setMaterial(rs.getString("material"));
			        					ps.setTravelDate(rs.getString("travelDate"));
			        					ps.setPickUpArea(rs.getString("pickUp"));
			        					ps.setDropArea(rs.getString("dropArea"));
			        					ps.setRecepientName(rs.getString("recipientName"));
			        					ps.setSrcReachedDateTime(rs.getString("srcReachedDateTime"));
			        					ps.setAcceptedTime(rs.getString("acceptedDateTime"));
			        					ps.setRecepientMobile(rs.getString("recipientMobile"));
			        					ps.setPostId(rs.getInt("postId"));
			        					ps.setRefPostId(rs.getString("refPostId"));
			        					ps.setTotalAmount(rs.getFloat("totalAmount"));
			        					ps.setApproximateAmount(rs.getFloat("approximateAmount"));
			        					ps.setAdditionalAmount(rs.getFloat("additionalAmount"));
			        					
			        					ti.setTruckName(rs.getString("truckName"));
			        					ti.setBasePrice(rs.getFloat("basePrice"));
			        					ps.setInfoTruck(ti);
			        					ps.setUser(us);
			        					in.setPost(ps);
			        					in.setStatusCode(200);
			        					return in;
			        				}
			        				else
			        				{
			        					in.setStatusCode(404);
			        					return in;
			        				}
			        				
			        		}
			 
			    });
			 } catch (EmptyResultDataAccessException e) {
				 in.setStatusCode(404);
					return in;
			}
}
		
		
		public int updatePostInformationAfterTripComplete(Post pos,Price price){
			
			try {
				
				log.info("TelePostserviceImpl-->updateAdditionalPriceMethod-->totalAmount-->"+pos.getTotalAmount()+"-->NightCharges-->"+pos.getNightCharges()+"totalKm-->"+price.getTotalDistanceKm()+"-->"+price.getTotalMins()+"-->"+price.getExtraKmAmount()+"-->"+price.getExtraMinsAmount()+"-->"+price.getExtraKm()+""+price.getOtherAmount());
				
				String sql="update truckways.postdetail  set totalKm= '"+price.getTotalDistanceKm()+"',totalMins='"+price.getTotalMins()+"',extraKm='"+price.getExtraKm()+"',extraMins='"+price.getExtraMins()+"',extraKmAmount='"+price.getExtraKmAmount()+"',extraMinsAmount='"+price.getExtraMinsAmount()+"',otherAmount='"+price.getOtherAmount()+"',totalAmount='"+price.getTotalAmount()+"',status='Trip Finished',bookingStatus='4',helperAmount='"+pos.getHelperAmount()+"',gstAmount='"+pos.getGstAmount()+"',nightCharges='"+pos.getNightCharges()+"' where refPostId= '"+pos.getBookingId()+"'";  
				
				return template.update(sql);
							 	
						
						
				} catch (EmptyResultDataAccessException e) {
						    	
					return 0;
				}
		}
		
		@Override
		public List<Vehicle> getListTransporter(int truckId) {
			try {
				
			
			  	String sql="SELECT localDriverId,truckName,vehicleRegistrationNo,driverName,mobile FROM truckways.localdriver inner join truckways.vehicle on vehicle.driverId=localdriver.localDriverId inner join truckways.truckinfo on truckinfo.truckId=vehicle.vehicleName where localdriver.driverStatusId='11' and truckinfo.truckId='"+truckId+"' and vehicle.actType='Individual';";
			 	return template.query(sql, new ResultSetExtractor<List<Vehicle>>() {
			 		 
			        @Override
			        public List<Vehicle> extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        			ArrayList<Vehicle> v = new ArrayList<Vehicle>();
			        			while (rs.next()) {
			        				
			        			
			        				Vehicle veh=new Vehicle();
			        				LocalDriver ld=new LocalDriver();
			        			
			        				
			        				ld.setDriverName(rs.getString("driverName"));
			        				ld.setMobile(rs.getString("mobile"));
			        				ld.setDriverId(rs.getInt("localDriverId"));
			        				
			        				veh.setVehicleName(rs.getString("truckName"));
			        				veh.setVehicleRegistrationNo(rs.getString("vehicleRegistrationNo"));
			        				
			        				veh.setDriverId(ld);
			        				
			        				v.add(veh);
			        				
			        				
			        			}
			        		
			        			return v;
			        }
			 	
			 });		 
		 } catch (EmptyResultDataAccessException e) {
		    	return null;
		 }
			
	}
	
		
		@Override
		public Vehicle getDriverConfirmation(String PostId) {
			
			Vehicle veh=new Vehicle();
			try {
				
			
			  	String sql="select driverName,postdetail.driverId as driverId1, mobile, vehicle.vehicleRegistrationNo, vehicle.vehicleName, driverAmount from localdriver inner join vehicle on localdriver.localDriverId = vehicle.driverId inner join postdetail on postdetail.driverId = localdriver.localDriverId where refPostId = '"+PostId+"'";			  		
			  	return template.query(sql, new ResultSetExtractor<Vehicle>() {
			 		 
			        @Override
			        public Vehicle extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        			if (rs.next()) {
			        				System.out.println("inside rs.next() getDriverConfirmation");
			        				
			        				
			        				LocalDriver ld=new LocalDriver();
			        							        				        				
			        				ld.setDriverName(rs.getString("driverName"));
			        				ld.setMobile(rs.getString("mobile"));
			        				ld.setDriverId(rs.getInt("driverId1"));
			        				veh.setVehicleName(rs.getString("vehicleName"));
			        				veh.setVehicleRegistrationNo(rs.getString("vehicleRegistrationNo"));
			        				
			        				veh.setDriverId(ld);
			        				veh.setStatusCode(200);
			        				return veh;
			        			}
			        			
			        			veh.setStatusCode(404);
			        		return veh;	
			        }
			 	
			 });		 
		 } catch (EmptyResultDataAccessException e) {
			veh.setStatusCode(404);	
			 return veh;	
		 }
		}

		@Override
		public int updateFeedback(final String feedback,final LocalDateTime feedbackDate, final Post pos) {
			try {
					final String code="DED_MISBEHAVED";
					final float amount=300.0f;
					String sel="select postdetail.driverId from postdetail where postId = '"+pos.getPostId()+"'";			  		
				  	return template.query(sel, new ResultSetExtractor<Integer>() {
				 		 
				        @Override
				        public Integer extractData(ResultSet rs) throws SQLException,
				        DataAccessException {
				        	
				        	if (rs.next()) {
				        			int driverId=rs.getInt("driverId");
				        			String sql="insert into truckways.deductions(driverId,code,reason,amount,dateTime,bookId) values ('"+driverId+"','"+code+"','"+feedback+"','"+amount+"','"+feedbackDate+"','"+pos.getRefPostId()+"')";  
									int status=template.update(sql);
										
									System.out.println("status"+status);
									return status;  
				        	}
		        			else
		        			{	
		        				System.out.println("!rs.next()");
		        				return 0;
		        			}
				        
				        }
		 	
				  	});		 
		 		 
			} catch (EmptyResultDataAccessException e) {
				    	return 0;
			}
		}

		@Override
		public TripDetails getTripDetailsofBook(String bookingId) {
			String sql="select tripdetails.* from tripdetails where tripdetails.bookingId ='"+bookingId+"'"; 
		 	return template.query(sql, new ResultSetExtractor<TripDetails>() {
		 		 
		        @Override
		        public TripDetails extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        			
		        	TripDetails trip=new TripDetails();
		        	if (rs.next()) {
					      
		        		
		        		trip.setTotalKm(rs.getFloat("totalKm"));
		        		trip.setTotalMins(rs.getInt("totalMins"));
		        		trip.setDryRunKm(rs.getInt("dry_run_km"));
		        		trip.setStartDelay(rs.getInt("startDelay"));
		        		
		        		return trip;
		        		
					        }
		        	
		        	trip.setTotalKm(0);
				        return trip;
		        }
		 	
		 });		 

		}

		@Override
		public DriverDetailsResponse getDriverDetails(String vehicleRegNo) {
			
			String sql="SELECT vehicle.driverId,actType,vehicleRegistrationNo,driverName,mobile,driverStatus,statusChangeTime,truckName,currentLat,currentLong,lastUpdateLocationTime FROM truckways.vehicle inner join truckways.localdriver on vehicle.driverId=localdriver.localDriverId inner join truckways.driverstatus on driverstatus.driverStatusId=localdriver.driverStatusId inner join truckways.truckinfo on truckinfo.truckId=vehicle.vehicleName inner join truckways.vehiclelocation on vehiclelocation.driverId=vehicle.driverId where vehicleRegistrationNo='"+vehicleRegNo+"'"; 
		 	return template.query(sql, new ResultSetExtractor<DriverDetailsResponse>() {
		 		 
		        @Override
		        public DriverDetailsResponse extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        			
		        	DriverDetailsResponse resp=new DriverDetailsResponse();
		        	if (rs.next()) {
					      
		        		resp.setDriverId(rs.getInt("driverId"));
		        		resp.setDriverName(rs.getString("driverName"));
		        		resp.setMobileNo(rs.getString("mobile"));
		        		resp.setCurrentLat(rs.getDouble("currentLat"));
		        		resp.setCuurentLong(rs.getDouble("currentLong"));
		        		resp.setDriverStatus(rs.getString("driverStatus"));
		        		resp.setDriverStatusChangeTime(rs.getString("statusChangeTime"));
		        		resp.setDriverType(rs.getString("actType"));
		        		resp.setLocationTime(rs.getString("lastUpdateLocationTime"));
		        		resp.setVehicleRegNo(rs.getString("vehicleRegistrationNo"));
		        		resp.setVehicleType(rs.getString("truckName"));
		        		
		        		resp.setStatusCode(200);
			        	resp.setStatusMessage("success");
		        		
		        		return resp;
		        		
					        }
		        	
		        	resp.setStatusCode(401);
		        	resp.setStatusMessage("Not Found");
				        return resp;
		        }
		 	
		 });		 

		}

		@Override
		public List<Post> getBookingsOfDriver(int driverId, String fromDate, String toDate) {
			
			try {
				
			
			  	String sql="SELECT * FROM truckways.postdetail where date(travelDate) between '"+fromDate+"' and '"+toDate+"' and driverId="+driverId+" and status='Completed' order by travelDate desc ";
			 	return template.query(sql, new ResultSetExtractor<List<Post>>() {
			 		 
			        @Override
			        public List<Post> extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        			List<Post> resp = new ArrayList<Post>();
			        			while (rs.next()) {
			        				
			        				Post pos=new Post();
			        				
			        				pos.setRefPostId(rs.getString("refPostId"));
			        				pos.setTravelDate(rs.getString("travelDate"));
			        				pos.setFromCity(rs.getString("fromCity"));
			        				pos.setToCity(rs.getString("toCity"));
			        				pos.setMaterial(rs.getString("material"));
			        				resp.add(pos);
			        				
			        				
			        				
			        				
			        			}
			        			
			        			return resp;
			        }
			 	
			 });		 
		 } catch (EmptyResultDataAccessException e) {
		    	return null;
		 }
			
	}

		@Override
		public List<Incentives> getDriverIncentives(int driverId, String bookId) {
			
			try {
					
			  	String sql="SELECT * FROM truckways.incentives where bookId='"+bookId+"' and driverId='"+driverId+"'";
			 	
			  	return template.query(sql, new ResultSetExtractor<List<Incentives>>() {
			 		 
			        @Override
			        public List<Incentives> extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        			List<Incentives> resp = new ArrayList<Incentives>();
			        			while (rs.next()) {
			        				
			        				Incentives inc=new Incentives();
			        				
			        				inc.setCode(rs.getString("code"));
			        				inc.setIncAmount(rs.getFloat("incAmount"));
			        				inc.setDateTime(rs.getString("dateTime"));
			        				resp.add(inc);
			        				
			        			}
			        			
			        			return resp;
			        }
			 	
			 });		 
		 } catch (EmptyResultDataAccessException e) {
		    	return null;
		 }
			
		}

		@Override
		public List<Deductions> getDriverDeductions(int driverId, String bookId) {
				
			try {
				
			  	String sql="SELECT * FROM truckways.deductions where bookId='"+bookId+"' and driverId='"+driverId+"'";
			 	
			  	return template.query(sql, new ResultSetExtractor<List<Deductions>>() {
			 		 
			        @Override
			        public List<Deductions> extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        			List<Deductions> resp = new ArrayList<Deductions>();
			        			while (rs.next()) {
			        				
			        				Deductions ded=new Deductions();
			        				
			        				ded.setCode(rs.getString("code"));
			        				ded.setReason(rs.getString("reason"));
			        				ded.setAmount(rs.getFloat("amount"));
			        				resp.add(ded);
			        				
			        			}
			        			
			        			return resp;
			        }
			 	
			 });		 
		 } catch (EmptyResultDataAccessException e) {
		    	return null;
		 }
				}

		@Override
		public DriverTripDetailsResponse getParticularBookingDetails(int driverId, String bookingId) {
			try {
				
				
			  	//String sql="SELECT postdetail.*,tripdetails.totalKm,tripdetails.totalMins,dry_run_km,startDelay,totalAmount,transporterAmount,travelDate,date(travelDate) as tdate FROM truckways.postdetail inner join truckways.tripdetails on tripdetails.bookingId=postdetail.refPostId where postdetail.driverId='"+driverId+"' and postdetail.refPostId='"+bookingId+"'";
			 	
			  	String sql="SELECT postdetail.* from truckways.postdetail  where postdetail.driverId='"+driverId+"' and postdetail.refPostId='"+bookingId+"' ";
				
			  	return template.query(sql, new ResultSetExtractor<DriverTripDetailsResponse>() {
			 		 
			        @Override
			        public DriverTripDetailsResponse extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        	DriverTripDetailsResponse tripResp=new DriverTripDetailsResponse();
			        	if (rs.next()) {
			        				
			        				
			        				
			        				tripResp.setBookingId(rs.getString("refPostId"));
			        				tripResp.setBookingDate(rs.getString("travelDate"));
			        				tripResp.setSourceReachedDateTime(rs.getString("srcReachedDateTime"));
			        				tripResp.setDestReachedDateTime(rs.getString("unloadingDateTime"));
			        				tripResp.setFromCity(rs.getString("fromCity"));
			        				tripResp.setToCity(rs.getString("toCity"));
			        				tripResp.setMaterial(rs.getString("material"));
			        				//tripResp.setDryRunKm(rs.getInt("dry_run_km"));
			        				tripResp.setTotalAmount(rs.getFloat("totalAmount"));
			        				//tripResp.setTripEarnings(rs.getFloat("transporterAmount"));
			        				//tripResp.setStartDelayMins(rs.getInt("startDelay"));
			        				tripResp.setTotalDistance(rs.getFloat("totalKm"));
			        				tripResp.setTotalMins(rs.getInt("totalMins"));
			        				//tripResp.settDate(rs.getString("tdate"));
			        				tripResp.setStatusCode(200);
						        	tripResp.setStatusMessage("Data Found");
			        				
			        				return tripResp;
			        				
			        				
			        				
			        			}
			        		
			        	tripResp.setStatusCode(404);
			        	tripResp.setStatusMessage("No Data Found");
			        	return tripResp;
			        }
			 	
			 });		 
		 } catch (EmptyResultDataAccessException e) {
		    	return null;
		 }
			
	}

		@Override
		public int sumofIncetivesofBookId(int driverId, String bookingId) {
			try {
				String sel="SELECT sum(incAmount) as sumIncentives FROM truckways.incentives where incentives.driverId='"+driverId+"' and incentives.bookId='"+bookingId+"'";

				return template.query(sel, new ResultSetExtractor<Integer>() {
				@Override
				public Integer extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        			if (rs.next()) {
		        				
					            int sumIncentives=rs.getInt("sumIncentives");
					            return sumIncentives;
		        			}
		        			else{
		        				return 0;
		        			}
				 }
			
				});
		} catch (EmptyResultDataAccessException e) {
	    	return 0;
		}
	}

		@Override
		public int sumofDeductionsofBookId(int driverId, String bookingId) {
			try {
				String sel="SELECT sum(amount) as sumDeductions FROM truckways.deductions where deductions.driverId='"+driverId+"' and deductions.bookId='"+bookingId+"'";
				return template.query(sel, new ResultSetExtractor<Integer>() {
				@Override
				public Integer extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        			if (rs.next()) {
		        				
					            int sumDeductions=rs.getInt("sumDeductions");
					            return sumDeductions;
		        			}
		        			else{
		        				return 0;
		        			}
				 }
			
				});
		} catch (EmptyResultDataAccessException e) {
	    	return 0;
		}
	}
		
		
		
public DriverDetailsResponse getCityWhenDriverEnagage(int driverId) {
			
			String sql="select fromCity,toCity from postdetail where driverId='"+driverId+"' and bookingStatus='22' order by travelDate desc limit 1);";
		 	return template.query(sql, new ResultSetExtractor<DriverDetailsResponse>() {
		 		 
		        @Override
		        public DriverDetailsResponse extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        			
		        	DriverDetailsResponse resp=new DriverDetailsResponse();
		        	if (rs.next()) {
					      
		        		resp.setFromCity(rs.getString("fromCity"));
		        		resp.setToCity(rs.getString("toCity"));
		        		
		        		resp.setStatusCode(200);
			        	resp.setStatusMessage("success");
		        		return resp;
		        		
					        }
		        	
		        	resp.setStatusCode(401);
		        	resp.setStatusMessage("Not Found");
				    return resp;
		        }
		 	
		 });		 

		}

@Override
public List<TripDetails> getDailyKmAndMinsofVehicleRegNo(String fromDate, String toDate, String vehicleRegNo) {
	try {
		
	  	String sql="SELECT date(tripDateTime) as tripDate,sum(km_to_source+totalKm) as totalKmPerDay,sum(mins_to_source+totalMins) as totalMinsPerDay FROM truckways.tripdetails inner join truckways.vehicle on vehicle.driverId=tripdetails.driverId where date(tripDateTime) between'"+fromDate+"' and '"+toDate+"' and vehicleRegistrationNo='"+vehicleRegNo+"' group by tripDateTime;";
	 	
	  	return template.query(sql, new ResultSetExtractor<List<TripDetails>>() {
	 		 
	        @Override
	        public List<TripDetails> extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        	
	        			List<TripDetails> resp = new ArrayList<TripDetails>();
	        			while (rs.next()) {
	        				
	        				TripDetails ded=new TripDetails();
	        				ded.setTotalKm(rs.getFloat("totalKmPerDay"));
	        				ded.setTotalMins(rs.getInt("totalMinsPerDay"));
	        				ded.setTripDate(rs.getString("tripDate"));
	        		
	        				
	        				resp.add(ded);
	        				
	        			}
	        			
	        			return resp;
	        }
	 	
	 });		 
 } catch (EmptyResultDataAccessException e) {
    	return null;
 }
}

public int checkvehicleRegNo(String vehicleRegNo){  
	try {
		
		  	String sql="SELECT * FROM truckways.vehicle where vehicleRegistrationNo='"+vehicleRegNo+"'"; 
		 	return template.query(sql, new ResultSetExtractor<Integer>() {
		 		 
		        @Override
		        public Integer extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        			if (rs.next()) {
					            
		        				return 1;
		        			}
				            	
				        return 0;
		        }
		 	
		 });		 
	 } catch (EmptyResultDataAccessException e) {
	    	return 0;
	 }
}


public int updateTripDetailsAfterTripCompleteManualy(float totalKm,int totalTime,LocalDateTime datetime,String bookingId) {
	// TODO Auto-generated method stub

	String sql = "update truckways.tripdetails set tripDateTime='"+datetime+"',totalKm='" + totalKm + "',totalMins='" + totalTime+ "' where tripdetails.bookingId='" + bookingId + "'";
	return template.update(sql);
}

@Override
public List<LiveTracking> getVehicleTracking(String bookingId, String srcReachedTime, String destReachedTime) {


		
		String sql="SELECT *,latitude as lat,longitude as lng,Time(currentDate) as currentTime FROM truckways.locationvehicle where currentDate between '"+srcReachedTime+"' and '"+destReachedTime+"' and driverId=(select driverId from postdetail where refPostId='"+bookingId+"') order by currentDate asc";
		
		return template.query(sql, new ResultSetExtractor<List<LiveTracking>>() {

			public List<LiveTracking> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<LiveTracking> ps = new ArrayList<LiveTracking>();
				
				while(rs.next()) {
					LiveTracking lt=new LiveTracking();
					
					lt.setLatitude(rs.getString("lat"));
					lt.setLongitude(rs.getString("lng"));
					lt.setCurrentDate(rs.getString("currentDate"));
					lt.setCurrentTime(rs.getString("currentTime"));
					ps.add(lt);
				} 

				
				
				return ps;
			}
		});

	
	}

@Override
public Telecaller checkTelecallerExistsorNot(String email, String password,String userType) {
	
	Telecaller tele=new Telecaller();
	try {
		String sel="SELECT * FROM truckways.telecaller where username='"+email+"' and password='"+password+"' and role='"+userType+"' ";
		
		return template.query(sel, new ResultSetExtractor<Telecaller>() {
		@Override
		public Telecaller extractData(ResultSet rs) throws SQLException,
                DataAccessException {
        			if (rs.next()) {
        				
        				tele.setTelecallerName(rs.getString("TelecallerName"));
			            tele.setTelecallerEmail(rs.getString("username"));
        				tele.setTelecallerId(rs.getInt("telecallerId"));
        				tele.setStatusCode(200);
        				return tele;
        			}
        		
        			tele.setStatusCode(401);
        			return tele;
		 }
	
		});
} catch (EmptyResultDataAccessException e) {
	
	tele.setStatusCode(500);
	return tele;
}
}

@Override
public Post getCustomerInformation(String infoId) {
	// TODO Auto-generated method stub
	Post po=new Post();
	User user=new User();
	try{
	
				
	String sql="SELECT * FROM truckways.user left join truckways.postdetail on user.userId=postdetail.userId where mobileNo='"+infoId+"' or email='"+infoId+"' ";
	
	return template.query(sql, new ResultSetExtractor<Post>() {
		@Override
		public Post extractData(ResultSet rs) throws SQLException,
                DataAccessException {
        			
			
			
			if (rs.first()) {
        				
        			
        			Log.info("Getting User Information");
        			user.setUserName(rs.getString("userName"));
        			user.setMobileNo(rs.getString("mobileNo"));
        			user.setUserId(rs.getInt("userId"));
        			user.setEmail(rs.getString("email"));
        			user.setRegisterDate(rs.getString("userRegDate"));
        			user.setUserType(rs.getString("userType"));
        			user.setGstNumber(rs.getString("gstNumber"));
  
        			List<Post> pos=new ArrayList<Post>();
        				
        				rs.beforeFirst();
        				
        				while(rs.next()){
        					
        					Log.info("Getting Booking Information");
        					Post post=new Post();
        					post.setBookingId(rs.getString("refPostId"));
        					post.setTravelDate(rs.getString("travelDate"));
        					post.setTotalAmount(rs.getFloat("totalAmount"));
        					post.setStatus(rs.getString("status"));
        					post.setBookedThrough(rs.getString("bookedThrough"));
        					pos.add(post);
        				
        					}
        				
        				
        				po.setPost(pos);
        				po.setUser(user);
        				po.setStatusCode(200);
        				return po;
        			} 
        				
        			
        			
        	Log.info("User Not Found");
        	po.setStatusMessage("User Not Found, Please Register");
			po.setStatusCode(401);	
			return po;			
        			
        		
        		
        		
		 }
		
		});
	
	} catch(Exception e ){
		
		Log.info("Catch Block");
		po.setUser(user);
		po.setStatusCode(204);	
		return po;			
    			
	}
}

@Override
public User getCustomersInformationManualy(User user) {
	User use=new User();
	try{
		
		
	    String sql="select * from truckways.user where mobileNo='"+user.getMobileNo()+"' ";  
	   
	    return template.query(sql, new ResultSetExtractor<User>() {  

		        public User extractData(ResultSet rs) throws SQLException,
		        DataAccessException {
		        	
		        	if (rs.next()) {
		            	
		        		
		            	use.setUserId(rs.getInt("userId"));
		            	use.setUserName(rs.getString("userName"));
		            	use.setEmail(rs.getString("email"));
		            	use.setMobileNo(rs.getString("mobileNo"));
		                use.setUserType(rs.getString("userType"));
		                use.setGstNumber(rs.getString("gstNumber"));
		                use.setActive(true);
		               use.setStatusCode(200);
		                return use;
		            }
		        	
		        		
		        		use.setActive(false);
			            use.setStatusCode(401);
			            return use;
		        		
		        	
		              
		        }
		 
		    });
		
		}
		catch(Exception e)
		{
			 use.setStatusCode(500);
	         return use;
		}
}

@Override
public int insertCustomerManualy(User u) {
	 
	LocalDateTime dt=LocalDateTime.now().withNano(0);
	
	 try {
		
		
		String sql="insert into truckways.user(userName,mobileNo,email,password,userStatus,userType,loginStatus,userRegDate,gstNumber) values('"+u.getUserName()+"','"+u.getMobileNo()+"','"+ u.getEmail()+"','123456','2','"+u.getUserType()+"','0','"+dt+"','"+u.getGstNumber()+"')";  
		
		return template.update(sql);
					 	
				
				
		} catch (EmptyResultDataAccessException e) {
				    	
			return 0;
		}
}


public int savepostdetails(Post pos) {
	
	
	Log.info("StoringPostdetails-->UserId-->"+ pos.getUser().getUserId()+"FromCity-->"+pos.getPrice().getRoute().getFromCity());
	
	String sql="insert into truckways.postdetail(postId,refPostId,userId,fromCity,toCity,material,postDate,travelDate,pickUp,dropArea,helper,truckId,status,recipientName,recipientMobile, approxKm,approxMins,approxAmount,totalAmount,sourceLat,sourceLong,destLat,destLong,valueOfGoods,approximateWeight,promocode,discountAmount,baseFare,freeKm,freeMins,slab1Price,slab2Price,gstAmount,bookedThrough,gstNumber) values('"+pos.getInvoiceId()+"','"+pos.getBookingId()+"','"+pos.getUser().getUserId()+"','"+pos.getPrice().getRoute().getFromCity()+"','"+pos.getPrice().getRoute().getToCity()+"','"+pos.getMaterial()+"','"+pos.getPostDate()+"','"+pos.getTravelDate()+"','"+pos.getPickUpArea()+"','"+pos.getDropArea()+"','"+pos.getHelper()+"','"+pos.getPrice().getInfo().getTruckId()+"','"+pos.getStatus()+"','"+pos.getRecepientName()+"','"+pos.getRecepientMobile()+"','"+pos.getPrice().getTotalDistanceKm()+"' ,'"+pos.getPrice().getTotalMins()+"','"+pos.getApproximateAmount()+"','"+pos.getTotalAmount()+"','"+pos.getPrice().getRoute().getsLat()+"','"+pos.getPrice().getRoute().getsLong()+"','"+pos.getPrice().getRoute().getdLat()+"','"+pos.getPrice().getRoute().getdLong()+"','"+pos.getValueOfGoods()+"','"+pos.getApproximateWeight()+"','"+pos.getPromocode()+"','"+pos.getDiscountAmount()+"','"+pos.getPrice().getInfo().getBasePrice()+"','"+pos.getPrice().getInfo().getFreeKm()+"','"+pos.getPrice().getInfo().getFreeMins()+"','"+pos.getPrice().getInfo().getAdditionalPrice()+"','"+pos.getPrice().getInfo().getSecondPrice()+"','"+pos.getGstAmount()+"','"+pos.getBookedThrough()+"','"+pos.getUser().getGstNumber()+"')";  
	  
    return template.update(sql);   
}


public int getrandompostid() {
	// TODO Auto-generated method stub
	String sql="SELECT FLOOR(RAND() * 999999) AS postId FROM truckways.postdetail WHERE 'postId' NOT IN (SELECT postId FROM truckways.postdetail ) LIMIT 1";
    
    
	   return template.query(sql, new ResultSetExtractor<Integer>() {  


	       
	       public Integer extractData(ResultSet rs) throws SQLException,DataAccessException {
	    	   int pid=0;
	    	   if (rs.next()) {
	        	  pid=rs.getInt("postId");
	          
	    	   } else
	           {
	        	   pid=rs.getInt("postId")+9;
	           }
	    	   
	    	  
	    	return pid;
	    	 
	       }

	   });
}



@Override
public List<Post> getLandPageCustomers() {
	 String sql = "SELECT customer.*,truckName FROM truckways.customer inner join truckways.truckinfo on truckinfo.truckId=customer.vehicleType where status='Visited' and time<CURRENT_TIMESTAMP()";
	    try {
	    	return template.query(sql, new ResultSetExtractor<List<Post>>() {
	 
	        @Override
	        public List<Post> extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        				
			            	ArrayList<Post> ps = new ArrayList<Post>();
							
			            	
			            	while (rs.next()){
								
								
									Post p = new Post();
					            	p.setInvoiceId(rs.getInt("CustomerId"));
									p.setFromCity(rs.getString("fromCity"));
					            	p.setToCity(rs.getString("toCity"));
									p.setMobileNo(rs.getString("mobileNo"));
					            	p.setTruckType(rs.getString("truckName"));
					            	p.setPostDate(rs.getString("time"));
					            	ps.add(p);
			    		   
							}
							return ps;
			            	
	        		}
	 
	    });
	    } catch (EmptyResultDataAccessException e) {
	    	return null;
	    }

	}



@Override
public int updateLandPageStatus(int customerId,String status) {
	
	
	String sql="update truckways.customer set status='"+status+"' where customerId='"+customerId+"'";
	return template.update(sql);
}
}

