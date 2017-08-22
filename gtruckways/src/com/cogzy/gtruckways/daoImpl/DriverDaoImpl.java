
package com.cogzy.gtruckways.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.BookingResponse;
import com.cogzy.gtruckways.businessObjects.DayWiseResponse;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.DriverAppLocation;
import com.cogzy.gtruckways.businessObjects.DriverAppResponse;
import com.cogzy.gtruckways.businessObjects.EnterpriseTripDetails;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.MonthlyWiseResponse;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.TripDetails;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.businessObjects.VehicleLocationInfo;
import com.cogzy.gtruckways.businessObjects.WeeklyResponse;
import com.cogzy.gtruckways.businessObjects.WeeklyWiseResponse;
import com.cogzy.gtruckways.dao.DriverDao;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.DriverAppRequestPojo;
import java.sql.PreparedStatement;

public class DriverDaoImpl implements DriverDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	private static Logger log = Logger.getLogger(Log.class.getName());

	
	@Override
	public int insertDeviceInformation(DriverAppRequestPojo alr) {

		String sql = "insert into truckways.device (deviceImeiNo,FCMregisterId) values('" + alr.getImeiNo() + "','"
				+ alr.getFcmToken() + "')";

		return template.update(sql);
	}

	@Override
	public Vehicle getDriverStatus(String mobileNo, String password) {
		// TODO Auto-generated method stub

		String sql = "select localdriver.mobile,localdriver.driverPassword,localdriver.driverName,localdriver.driverStatusId, localdriver.localDriverId,localdriver.fcmToken,localdriver.ImeiNo,driverstatus.driverStatus, vehicle.vehicleName, vehicle.vehicleRegistrationNo from localdriver inner join driverstatus on localdriver.driverStatusId = driverstatus.driverStatusId inner join vehicle on vehicle.driverId = localdriver.localDriverId  where localdriver.mobile= '"
				+ mobileNo + "' and localdriver.driverPassword= '" + password + "' and vehicle.actType='Individual'";
		return template.query(sql, new ResultSetExtractor<Vehicle>() {

			public Vehicle extractData(ResultSet rs) throws SQLException, DataAccessException {
				LocalDriver driver = new LocalDriver();
				Vehicle vehi = new Vehicle();
				// LocalTransporter trans=new LocalTransporter();
				if (rs.next()) {
					log.info("Driver Status is -->"+rs.getString("driverStatus"));
					driver.setDriverId(rs.getInt("localDriverId"));
					driver.setDriverStatus(rs.getString("driverStatus"));
					driver.setDriverName(rs.getString("driverName"));
					driver.setMobile(rs.getString("mobile"));
					driver.setPassword(rs.getString("driverPassword"));
					driver.setFcmToken(rs.getString("fcmToken"));
					driver.setImeiNo(rs.getString("ImeiNo"));
					// trans.setTransporterId(rs.getInt("transporterId"));

					vehi.setVehicleName(rs.getString("vehicleName"));
					vehi.setVehicleRegistrationNo(rs.getString("vehicleRegistrationNo"));
					vehi.setDriverId(driver);
					// vehi.setTransporter(trans);
					return vehi;

				}

				driver.setPassword("00000");
				vehi.setDriverId(driver);
				System.out.println("bye");
				return vehi;
			}

		});

	}

	@Override
	public int updateDriverStatus(String mobileNo, String password, String imeiNo, String fcmToken) {

		String sql = "update localdriver set localdriver.ImeiNo='" + imeiNo
				+ "',localdriver.fcmToken='" + fcmToken + "' where mobile='" + mobileNo + "' and driverPassword='"
				+ password + "'";

		return template.update(sql);

	}

	@Override
	public int assignDriverForBooking(String bookingId, int driverId, String acceptDateAndTime){
		try{
		String sql = "update truckways.postdetail set postdetail.driverId='" + driverId
				+ "',postdetail.acceptedDateTime='" + acceptDateAndTime
				+ "',postdetail.status='Vehicle Arranged',bookingStatus='22' where postdetail.refPostId='" + bookingId + "'";

		template.update(sql);
		return 1;
		}
		catch(Exception e){
			return 0;
		}
	}

	@Override
	public Post getBookingDetails(String bookingId, int driverId) {
		// TODO Auto-generated method stub
		String sql = "SELECT postdetail.*,userName,mobileNo,email,truckinfo.* FROM truckways.postdetail inner join truckways.user on user.userId=postdetail.userId inner join truckways.truckinfo on truckinfo.truckId=postdetail.truckId   where refPostId='"
				+ bookingId + "' and driverId='" + driverId + "'";
		return template.query(sql, new ResultSetExtractor<Post>() {

			public Post extractData(ResultSet rs) throws SQLException, DataAccessException {
				Post ps = new Post();
				User us = new User();
				TruckInfo ti = new TruckInfo();
				if (rs.next()) {

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
					ps.setSrcReachedDateTime(rs.getString("srcReachedDateTime"));
					ps.setLoadingDateTime(rs.getString("loadingDateTime"));
					ps.setDestReachedDateTime(rs.getString("destReachedDateTime"));
					ps.setUnloadingDateTime(rs.getString("unloadingDateTime"));
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
				
				log.info("DriverDaoImpl-->getBookingDetails-->BookingDetails is not fetched");
				ps.setTotalAmount(0);
				return ps;

			}

		});

	}

	@Override
	public int cancelBooking(String bookingId, int driverId) {
		// TODO Auto-generated method stub

		String sql = "update truckways.postdetail set postdetail.status='Canceled' where postdetail.refPostId='"
				+ bookingId + "'and postdetail.driverId='" + driverId + "'";

		return template.update(sql);
	}

	// At location update tripdetails and booking status
	@Override
	public int updateTripDetailsAtPickupLocation(final DriverAppRequestPojo alr,LocalDateTime dateTime, final float dryRunKm,final int startDelayTime) {

	     try {
	     
	    	 log.info("atPickupLocation-->sourceLat-->"+alr.getSourceLat()+"-->sourceLong-->"+alr.getSourceLong()+"-->bookingId"+alr.getBookingId()+"-->driverId-->"+alr.getDriverId()); 
	    	 
	        String sel="select * from truckways.tripdetails where bookingId ='"+alr.getBookingId()+"' and driverId='"+alr.getDriverId()+"' ";
	        return template.query(sel, new ResultSetExtractor<Integer>(){
	        
	        public Integer extractData(ResultSet rs) throws SQLException,
	                      DataAccessException {
	                 if (rs.next()) {
	                  
	                    
	            String sql="update truckways.tripdetails set bookingId='"+alr.getBookingId()+"',driverId='"+alr.getDriverId()+"',tripDateTime='"+dateTime+"',startLattitude='"+alr.getSourceLat()+"',startLongitude='"+alr.getSourceLong()+"',dry_run_km='"+dryRunKm+"',startDelay='"+startDelayTime+"' where bookingId='"+alr.getBookingId()+"' and driverId='"+alr.getDriverId()+"' ";
	            int status=template.update(sql);
	            System.out.println(status);
	                
	            return status; 
	                    
	                 } else{
	  
	  
	  
	                  String sql = "insert into truckways.tripdetails (bookingId,driverId,tripDateTime,startLattitude,startLongitude,endLattitude,endLongitude,totalKm,totalMins,dry_run_km,startDelay) values('"
	    + alr.getBookingId() + "','" + alr.getDriverId() + "','" + alr.getAppTime() + "','" + alr.getSourceLat()
	    + "','" + alr.getSourceLong() + "','0','0','0','0','"+dryRunKm+"','"+startDelayTime+"')";

	  return template.update(sql);
	  
	                 }
	                 
	        }
	      
	       });
	        
	      } catch (EmptyResultDataAccessException e) {
	             return 0;
	      }
	  
	 }

	@Override
	public int updateBookingStatusAtLocation(DriverAppRequestPojo alr) {
		// TODO Auto-generated method stub
		String sql = "update truckways.postdetail set postdetail.status='Source Reached',postdetail.srcReachedDateTime='"
				+ alr.getAppTime() + "' where postdetail.refPostId='" + alr.getBookingId()
				+ "'and postdetail.driverId='" + alr.getDriverId() + "'";

		return template.update(sql);
	}

	// start the trip and update the booking status and time
	@Override
	public int updateBookingStatusAtStart(DriverAppRequestPojo start) {
		// TODO Auto-generated method stub
		String sql = "update truckways.postdetail set postdetail.loadingDateTime='" + start.getAppTime()
				+ "',postdetail.status='Loading Completed' where postdetail.refPostId='" + start.getBookingId()
				+ "'and postdetail.driverId='" + start.getDriverId() + "' ";
		return template.update(sql);
	}

	// drop location
	@Override
	public int updateBookingStatusAtDropLocation(DriverAppRequestPojo stop) {
		String sql = "update truckways.postdetail set postdetail.destReachedDateTime='" + stop.getAppTime()
				+ "',postdetail.status='Destination Reached' where postdetail.refPostId='" + stop.getBookingId()
				+ "'and postdetail.driverId='" + stop.getDriverId() + "' ";
		return template.update(sql);
	}

	// trip complete
	@Override
	public int updateTripDetailsAfterTripComplete(DriverAppRequestPojo end, float totalKm, int totalTime) {
		// TODO Auto-generated method stub

		String sql = "update truckways.tripdetails set endLattitude='" + end.getDestLat() + "',endLongitude='"
				+ end.getDestLong() + "',totalKm='" + totalKm + "',totalMins='" + totalTime
				+ "' where tripdetails.bookingId='" + end.getBookingId() + "'and tripdetails.driverId='"
				+ end.getDriverId() + "' ";
		return template.update(sql);
	}

	@Override
	public int updateBookingStatusAfterTripComplete(DriverAppRequestPojo end) {

		String sql = "update truckways.postdetail set postdetail.unloadingDateTime='" + end.getAppTime()
				+ "',postdetail.status='Unloading Finished',bookingStatus='4'  where postdetail.refPostId='" + end.getBookingId()
				+ "'and postdetail.driverId='" + end.getDriverId() + "' ";
		return template.update(sql);

	}

	@Override
	public int updateDriverStatustoSleepOrActive(int driverId, String status,LocalDateTime time) {

		String sql = "update localdriver set localdriver.driverStatusId ='" + status + "',localdriver.statusChangeTime='"+time+"' where localDriverId='"
				+ driverId + "'";

		return template.update(sql);
	}

	@Override
	public int updateBookingStatusTripComplete(AmountDetails amt, DriverAppRequestPojo end) {
		// TODO Auto-generated method stub

		String sql="";/*"update postdetail  set totalKm= '"+price.getTotalDistanceKm()+"',totalMins='"+price.getTotalMins()+"',extraKm='"+price.getExtraKm()+"',extraMins='"+price.getExtraMins()+"',extraKmAmount='"+price.getExtraKmAmount()+"',extraMinsAmount='"+price.getExtraMinsAmount()+"',otherAmount='"+price.getOtherAmount()+"',totalAmount='"+price.getTotalAmount()+"',status='Trip Finished',bookingStatus='4',gtruckwaysAmount='"+pos.getGtruckwaysAmount()+"',driverAmount='"+pos.getDriverAmount()+"',helperAmount='"+pos.getHelperAmount()+"' where postdetail.refPostId= '"+pos.getBookingId()+"'";*/  
		return template.update(sql);

	}

	@Override
	public LocalDriver getDriverForPushNotifications(Post pos) {
		
		int radius = 10; // in Kilometers
		LocalDateTime time1 = LocalDateTime.now().withNano(0);
		LocalDriver driver = getDriverForPushNotifications(pos, radius,time1);
		if (driver.getDriverId() == 0) {
			//Increase the radius by another 20 Kms and try again
			driver = getDriverForPushNotifications(pos, radius + 20,time1);
		}
		return driver;
	}
	
	/* Convenience method to get driver details */
	private LocalDriver getDriverForPushNotifications(Post pos, int radius,LocalDateTime time1 ) {
		
		String sql = "SELECT loc.driverId, ( 6371 * acos( cos( radians('" + pos.getsLat()
		+ "') ) * cos( radians( loc.currentLat ) ) * cos( radians( loc.currentLong ) - radians('"
		+ pos.getsLong() + "') ) + sin( radians('" + pos.getsLat()
		+ "') ) * sin( radians( loc.currentLat ) ) ) ) AS distance  FROM vehiclelocation loc inner join localdriver driver on loc.driverId = driver.localDriverId  inner join vehicle vehi on vehi.driverId=driver.localDriverId  where loc.trucktypeid = '"
		+ pos.getInfoTruck().getTruckId() + "' and  TIMESTAMPDIFF(MINUTE, loc.lastUpdateLocationTime, '"+time1+"') < 500 and  vehi.actType='Individual' and driver.driverStatusId = 11 having distance < " + radius
		+ " ORDER BY distance LIMIT 100";

		return template.query(sql, new ResultSetExtractor<LocalDriver>() {

			public LocalDriver extractData(ResultSet rs) throws SQLException, DataAccessException {
				LocalDriver driver = new LocalDriver();

				if (rs.next()) {

					driver.setDriverId(rs.getInt("driverId"));
					driver.setDistanceFromSource(rs.getString("distance"));
					return driver;
				} 

				driver.setDriverId(0);

				return driver;
			}
		});
	}
	
	
/*public LocalDriver getManuallyDriverForPushNotifications(Post pos) {
		
		int radius = 10; // in Kilometers
		LocalDateTime time1 = LocalDateTime.now().withNano(0);
		LocalDriver driver = getDriverForPushNotifications(pos, radius,time1);
		if (driver.getDriverId() == 0) {
			//Increase the radius by another 20 Kms and try again
			driver = getManualDriverForPushNotifications(pos, radius + 20,time1);
		}
		return driver;
	}
	
	
	
	private LocalDriver getManualDriverForPushNotifications(Post pos, int radius,LocalDateTime time1 ) {
		
		String sql = "SELECT loc.driverId, ( 6371 * acos( cos( radians('" + pos.getsLat()
		+ "') ) * cos( radians( loc.currentLat ) ) * cos( radians( loc.currentLong ) - radians('"
		+ pos.getsLong() + "') ) + sin( radians('" + pos.getsLat()
		+ "') ) * sin( radians( loc.currentLat ) ) ) ) AS distance  FROM vehiclelocation loc inner join localdriver driver on loc.driverId = driver.localDriverId  inner join vehicle vehi on vehi.driverId=driver.localDriverId  where loc.trucktypeid = '"
		+ pos.getTruckId().getTruckId() + "' and  vehi.actType='Individual' and driver.driverStatusId = 11 having distance < " + radius
		+ " ORDER BY distance LIMIT 100";

		return template.query(sql, new ResultSetExtractor<LocalDriver>() {

			public LocalDriver extractData(ResultSet rs) throws SQLException, DataAccessException {
				LocalDriver driver = new LocalDriver();

				if (rs.next()) {

					driver.setDriverId(rs.getInt("driverId"));
					driver.setDistanceFromSource(rs.getString("distance"));
					return driver;
				} 

				driver.setDriverId(0);

				return driver;
			}
		});
	}
	*/
	

	@Override
	 public LocalDriver getFcmRegistrationToken(int driverId) {

	  String sql = "SELECT * FROM truckways.localdriver where localDriverId='" + driverId + "' ";
	  return template.query(sql, new ResultSetExtractor<LocalDriver>() {

	   public LocalDriver extractData(ResultSet rs) throws SQLException, DataAccessException {

	    LocalDriver driver =new LocalDriver();
	    
	   
	    if (rs.next()) {

	     driver.setFcmToken(rs.getString("fcmToken"));
	     driver.setDriverId(rs.getInt("localDriverId"));
	     driver.setDriverName(rs.getString("driverName"));
	     driver.setMobile(rs.getString("mobile"));

	     return driver;
	    }

	    return driver;
	   }
	  });
	 }

	@Override
	public int getDeviceId(DriverAppRequestPojo alr) {

		String sql = "SELECT deviceId FROM truckways.device where deviceImeiNo='" + alr.getImeiNo()
				+ "' and FCMregisterId='" + alr.getFcmToken() + "'";
		return template.query(sql, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

				int deviceId = 0;
				if (rs.next()) {

					deviceId = rs.getInt("deviceId");

					return deviceId;
				}

				return deviceId = 0;
			}
		});
	}

	@Override
	public int updateDeviceIdtoDriver(String mobileNo, int deviceId) {

		String sql = "update truckways.localdriver set deviceId='" + deviceId + "' where mobile='" + mobileNo + "'";
		return template.update(sql);
	}

	@Override
	public TripDetails getTripDetails(DriverAppRequestPojo tripComplete) {

		String sql = "select * from tripdetails where bookingId='" + tripComplete.getBookingId() + "' and driverId='"
				+ tripComplete.getDriverId() + "'";
		return template.query(sql, new ResultSetExtractor<TripDetails>() {

			public TripDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
				TripDetails td = new TripDetails();

				if (rs.next()) {

					td.setTripId(rs.getInt("tripDetailsId"));
					td.setsLat(rs.getDouble("startLattitude"));
					td.setsLong(rs.getDouble("startLongitude"));
					return td;
				}

				return td;
			}
		});
	}

	@Override
	public int updateVehicleLocation(double latitude, double Longitude, int driverId,String lastUpdatedTime,int status) {
		String sql = "update truckways.vehiclelocation set currentLat='" + latitude + "',currentLong='" + Longitude
				+ "',lastUpdateLocationTime='"+lastUpdatedTime+"' where driverId='" + driverId + "'";
		
		template.update(sql);
		
		String sql1="insert into locationvehicle(driverId,latitude,longitude,currentDate,status) values('"+driverId+"','"+latitude+"','"+Longitude+"','"+lastUpdatedTime+"','"+status+"')";

		return template.update(sql1);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public VehicleLocationInfo getVehicleLocation(int driverId) {
		// TODO Auto-generated method stub
		
String sql="SELECT * FROM truckways.vehiclelocation where driverId='"+driverId+"'";
		return template.query(sql, new ResultSetExtractor<VehicleLocationInfo>() {

			public VehicleLocationInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				VehicleLocationInfo locInfo = new VehicleLocationInfo();
				if (rs.next()) {
					
					locInfo.setCurLat(rs.getDouble("currentLat"));
					locInfo.setCurLong(rs.getDouble("currentLong"));
					
		
					return locInfo;
				}
				log.info("DriverDaoImpl-->getVehicleLocation---> Vehicle location is not fetched");
				return locInfo;
			}
		});
	}

	
	@Override
	public int insertTripdetailsInAcceptOrder(final int driverId, final String bookingId,final Route route) {
		
		try {
		     
		     String sel="select * from truckways.tripdetails where bookingId ='"+bookingId+"' and driverId='"+driverId+"' ";
		     //final int exactMins=route.getTime()+15;
		     
		     
		     return template.query(sel, new ResultSetExtractor<Integer>(){
		     
		     public Integer extractData(ResultSet rs) throws SQLException,
		                   DataAccessException {
		              if (rs.next()) {
		                 
		         String sql="update truckways.tripdetails set bookingId='"+bookingId+"',driverId='"+driverId+"',km_to_source='"+route.getDistance()+"',mins_to_source='"+route.getTime()+"' where bookingId='"+bookingId+"' and driverId='"+driverId+"' ";
		         int status=template.update(sql);
		         System.out.println(status);
		             
		         return status; 
		                 
		              } else{
	
	
		            	  String sql = "insert into truckways.tripdetails (bookingId,driverId,km_to_source,mins_to_source,tripDateTime,startLattitude,startLongitude,endLattitude,endLongitude,totalKm,totalMins) values('"
			+ bookingId + "','" +driverId+ "','"+route.getDistance()+"','"+route.getTime()+"','0','0','0','0','0','0','0')";

	return template.update(sql);
	
		              }
		              
		     }
		   
	     });
	      
	    } catch (EmptyResultDataAccessException e) {
	           return 0;
	    }
	}	
		@Override
	public TripDetails getTripDetailsInPickupLocation(String bookingId, int driverId) {
			String sql = "select * from tripdetails where bookingId='" + bookingId + "' and driverId='"
					+driverId + "'";
			return template.query(sql, new ResultSetExtractor<TripDetails>() {

				public TripDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
					TripDetails td = new TripDetails();

					if (rs.next()) {

						td.setKm_to_source(rs.getInt("km_to_source"));
						td.setMins_to_source(rs.getInt("mins_to_source"));
						
						return td;
					}

					return td;
				}
			});
		}

		
		 @Override
		  public int addIncentives(Incentives incent,LocalDateTime incentiveDate) {
		   
			  String sql = "insert into truckways.incentives(driverId,code,incAmount,dateTime,bookId) values('"+incent.getDriverId()+"','"+incent.getCode()+"','"+incent.getIncAmount()+"','"+incentiveDate+"','"+incent.getBookId()+"')";
	             

			     return template.update(sql);
			     
			                    }
		 
		 @Override
		  public int addDeductions(Deductions ded,LocalDateTime deductionDate) {
			  
			  String sql = "insert into truckways.deductions (driverId,code,reason,amount,dateTime,bookId) values('"+ded.getDriverId()+"','"+ded.getCode()+"','"+ded.getReason()+"','"+ded.getAmount()+"','"+deductionDate+"','"+ded.getBookId()+"')";
	             

			     return template.update(sql);
			     
			  }
		
		
		
		


		@Override
		public int updateBookingStatus(Post pos, int driverId) {

			
			String sql="update truckways.postdetail set status='Completed',totalAmount='"+pos.getTotalAmount()+"',otherAmount='"+pos.getOtherAmount()+"',discountAmount='"+pos.getDiscountAmount()+"',gstAmount='"+pos.getGstAmount()+"',gtruckwaysAmount='"+pos.getGtruckwaysAmount()+"',driverAmount='"+pos.getDriverAmount()+"',postdetail.bookingStatus='4' where refPostId='"+pos.getBookingId()+"'";
		
		
			return template.update(sql);
			
			
		}

		

		@Override
		public LocalDriver getDriverDetails(int driverId) {
			String sql = "SELECT localdriver.*,vehicleRegistrationNo FROM truckways.localdriver inner join truckways.vehicle on vehicle.driverId=localdriver.localDriverId where localDriverId='"+driverId+"'";
			return template.query(sql, new ResultSetExtractor<LocalDriver>() {

				public LocalDriver extractData(ResultSet rs) throws SQLException, DataAccessException {
					LocalDriver driver = new LocalDriver();
				
					// LocalTransporter trans=new LocalTransporter();
					if (rs.next()) {
						
						driver.setDriverId(rs.getInt("localDriverId"));
						driver.setDriverName(rs.getString("driverName"));
						driver.setMobile(rs.getString("mobile"));
						driver.setDriverRegNo(rs.getString("vehicleRegistrationNo"));
						return driver;

					} else{
						
						
						driver.setDriverId(0);
						
						return driver;
					}
			
			
				}
			});

	
		
		}

		@Override
		public Post getPostDetails(String bookingId) {
			String sql = "SELECT postdetail.*,mobileNo,email FROM truckways.postdetail inner join truckways.user on user.userId=postdetail.userId where refPostId='"+ bookingId + "'";
			return template.query(sql, new ResultSetExtractor<Post>() {

				public Post extractData(ResultSet rs) throws SQLException, DataAccessException {
					Post post = new Post();
				
					if (rs.next()) {
					
						post.setBookingId(rs.getString("refPostId"));
						post.setTotalAmount(rs.getFloat("totalAmount"));
						post.setApproximateAmount(rs.getFloat("approxAmount"));
						post.setFromCity(rs.getString("fromCity"));
						post.setToCity(rs.getString("toCity"));
						post.setsLat(rs.getDouble("sourceLat"));
						post.setsLong(rs.getDouble("sourceLong"));
						post.setdLat(rs.getDouble("destLat"));
						post.setdLong(rs.getDouble("destLong"));
						post.setMaterial(rs.getString("material"));
						post.setTravelDate(rs.getString("travelDate"));
						post.setHelper(rs.getInt("helper"));
						post.setSrcReachedDateTime(rs.getString("srcReachedDateTime"));
						post.setAcceptedTime(rs.getString("acceptedDateTime"));
						post.setUnloadingDateTime(rs.getString("unloadingDateTime"));
						post.setApproximateKm(rs.getFloat("approxKm"));
						post.setStatus(rs.getString("status"));
						post.setApproximateMins(rs.getInt("approxMins"));
						User user=new User();
						user.setMobileNo(rs.getString("mobileNo"));
						user.setEmail(rs.getString("email"));
						post.setUser(user);
						return post;

					}
					log.info("DriverDaoImpl-->getBookingDetails-->BookingDetails is not fetched");
					post.setTotalAmount(0);
					return post;

				}

			});

		}
		

		
		@Override
		public DayWiseResponse getSumOfDailyTripFares(int driverId,LocalDate dateTime) {
			String sql = "SELECT sum(totalAmount) as tripFare,sum(transporterAmount) as tripEarnings FROM truckways.postdetail  where date(postdetail.travelDate) ='"+dateTime+"' and driverId='"+driverId+"' and postdetail.status='Completed'";
			return template.query(sql, new ResultSetExtractor<DayWiseResponse>() {

				public DayWiseResponse extractData(ResultSet rs) throws SQLException, DataAccessException {
					DayWiseResponse resp = new DayWiseResponse();
				
					if (rs.next()) {
						
						resp.setTotalCashCollect(rs.getFloat("tripFare"));
						resp.setTotalTripEarinings(rs.getFloat("tripEarnings"));
					
						
					
						return resp;

					} 
					resp.setStatusCode(404);
					resp.setStatusMessage("No Connectivity to Database");
					return resp;
			
				}
			});

	
		}

		@Override
		public int getSumOfDailyIncentives(int driverId,LocalDate dateTime) {
			
			
			String sql = "select sum(incentives.incAmount) as Total_Incs from incentives where date(dateTime) ='"+dateTime+"' and driverId='"+driverId+"'";
			
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					int sumIncentivesOfDay=0;
					
					if (rs.next()) {
						
						sumIncentivesOfDay=rs.getInt("Total_Incs");
					
						return sumIncentivesOfDay;

					} 
					
					
					return sumIncentivesOfDay;
			
				}
			});

	
		}

		@Override
		public int getSumOfDailyDeductions(int driverId,LocalDate dateTime) {
			
			String sql = "select sum(deductions.amount) as Total_Deds from deductions where date(dateTime) ='"+dateTime+"' and driverId='"+driverId+"'";
			
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					int sumDeductionsOfDay=0;
					
					if (rs.next()) {
						
						sumDeductionsOfDay=rs.getInt("Total_Deds");
					
						return sumDeductionsOfDay;

					} 
					
					
					return sumDeductionsOfDay;
			
				}
			});

		}

		@Override
		public List<BookingResponse> getAllBookingsOfTheDay(int driverId, LocalDate dateTime) {
		
			
			String sql = "select postdetail.totalAmount as cashCollect, postdetail.transporterAmount as driverAmount,refPostId,postdetail.travelDate from  postdetail where date(postdetail.travelDate) ='"+dateTime+"' and postdetail.driverId='"+driverId+"' and  postdetail.status='Completed'  group by refPostId";
			
			return template.query(sql, new ResultSetExtractor<List<BookingResponse>>() {

				public List<BookingResponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					List<BookingResponse> ps = new ArrayList<BookingResponse>();
					
					while(rs.next()) {
						BookingResponse resp = new BookingResponse();
						
						resp.setBookingId(rs.getString("refPostId"));
						resp.setCashCollected(rs.getFloat("cashCollect"));
						resp.setDateAndTime(rs.getString("travelDate"));
						resp.setTripEarnings(rs.getFloat("driverAmount"));
						resp.setTripFare(rs.getFloat("cashCollect"));
						ps.add(resp);
						
					}
					
					
					
					return ps;
				}
			});
			
			
			
		}

		@Override
public int getAllIncentivesOfBooking(int driverId, LocalDate dateTime, String bookId) {
String sql = "SELECT sum(incAmount) FROM truckways.incentives  where incentives.driverId='"+driverId+"' and incentives.bookId='"+bookId+"'";
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					int sumIncentives=0;
					if (rs.next()) {
						
						
						sumIncentives=rs.getInt("sum(incAmount)");
						return sumIncentives;
					}
					
					
					
					return sumIncentives;
				}
			});
			
		}

		@Override
		public int getAllDeductionsOfBooking(int driverId, LocalDate dateTime, String bookId) {
			String sql = "SELECT sum(amount) FROM truckways.deductions  where deductions.driverId='"+driverId+"' and deductions.bookId='"+bookId+"'";
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					int sumDeductions=0;
					if (rs.next()) {
						
						
						sumDeductions=rs.getInt("sum(amount)");
						return sumDeductions;
					}
					
					
					
					return sumDeductions;
				}
			});
			
		}

		@Override
		public WeeklyWiseResponse getSumOfWeeklyTripFares(LocalDate startDate, LocalDate endDate, int driverId) {
			
			String sql = "SELECT sum(totalAmount) as tripFare,sum(transporterAmount) as tripEarnings FROM truckways.postdetail  where date(postdetail.travelDate) between '"+startDate+"' and '"+endDate+"' and driverId='"+driverId+"' and postdetail.status='Completed'";
			return template.query(sql, new ResultSetExtractor<WeeklyWiseResponse>() {

				public WeeklyWiseResponse extractData(ResultSet rs) throws SQLException, DataAccessException {
					WeeklyWiseResponse resp = new WeeklyWiseResponse();
				
					if (rs.next()) {
						
						resp.setTotalCashCollect(rs.getFloat("tripFare"));
						resp.setTotalTripEarinings(rs.getFloat("tripEarnings"));
					
						
					
						return resp;

					} 
					resp.setTotalCashCollect(0);
					resp.setTotalDeductions(0);
					resp.setStatusCode(404);
					resp.setStatusMessage("No Connectivity to Database");
					return resp;
			
				}
			});

	
		}

		@Override
		public int getSumOfWeeklyIncentives(LocalDate startDate, LocalDate endDate, int driverId) {
			String sql = "select sum(incentives.incAmount) as Total_Incs from incentives where date(dateTime) between '"+startDate+"' and '"+endDate+"' and driverId='"+driverId+"'";
			
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					int sumIncentivesOfDay=0;
					
					if (rs.next()) {
						
						sumIncentivesOfDay=rs.getInt("Total_Incs");
					
						return sumIncentivesOfDay;

					} 
					
					
					return sumIncentivesOfDay;
			
				}
			});

		}

		@Override
		public int getSumOfWeeklyDeductions(LocalDate startDate, LocalDate endDate, int driverId) {
			
			String sql = "select sum(deductions.amount) as Total_Deds from deductions where date(dateTime) between '"+startDate+"' and '"+endDate+"' and driverId='"+driverId+"'";
			
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					int sumDeductionsOfDay=0;
					
					if (rs.next()) {
						
						sumDeductionsOfDay=rs.getInt("Total_Deds");
					
						return sumDeductionsOfDay;

					} 
					
					
					return sumDeductionsOfDay;
			
				}
			});

			
		}

		@Override
		public List<BookingResponse> getAllBookingsOfTheWeekly(LocalDate startDate, LocalDate endDate, int driverId) {
			
			String sql = "select sum(postdetail.totalAmount) as cashCollect, sum(postdetail.transporterAmount) as driverAmount,date(postdetail.travelDate) as travelDate from  postdetail where date(postdetail.travelDate) between '"+startDate+"' and '"+endDate+"'  and postdetail.driverId='"+driverId+"' and  postdetail.status='Completed'  group by date(travelDate)";
			
			return template.query(sql, new ResultSetExtractor<List<BookingResponse>>() {

				public List<BookingResponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					List<BookingResponse> ps = new ArrayList<BookingResponse>();
					
					while(rs.next()) {
						BookingResponse resp = new BookingResponse();
						
						resp.setCashCollected(rs.getFloat("cashCollect"));
						resp.setDateAndTime(rs.getString("travelDate"));
						resp.setTripEarnings(rs.getFloat("driverAmount"));
						resp.setTripFare(rs.getFloat("cashCollect"));
						log.info(rs.getFloat("cashCollect"));
						ps.add(resp);
						
					}
					
					
					
					return ps;
				}
			});
		}

		@Override
		public int getAllIncentivesOfDaily(String date,int driverId) {
			
			String sql = "SELECT sum(incAmount) FROM truckways.incentives  where incentives.driverId='"+driverId+"' and date(dateTime)='"+date+"'";
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					int sumIncentives=0;
					if (rs.next()) {
						
						
						sumIncentives=rs.getInt("sum(incAmount)");
						return sumIncentives;
					}
					
					
					
					return sumIncentives;
				}
			});
		}

		@Override
		public int getAllDeductionsOfDaily(String date,int driverId) {
			String sql = "SELECT sum(amount) FROM truckways.deductions  where deductions.driverId='"+driverId+"' and  date(dateTime)='"+date+"'";
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					int sumDeductions=0;
					if (rs.next()) {
						
						
						sumDeductions=rs.getInt("sum(amount)");
						return sumDeductions;
					}
					
					
					
					return sumDeductions;
				}
			});
			
		}

		@Override
		public MonthlyWiseResponse getSumOfMonthlyTripFares(String month, int year, int driverId) {
			String sql = "SELECT sum(totalAmount) as tripFare,sum(transporterAmount) as tripEarnings FROM truckways.postdetail  where monthname(postdetail.travelDate) = '"+month+"' and year(postdetail.travelDate)='"+year+"'  and driverId='"+driverId+"'and postdetail.status='Completed'";
			return template.query(sql, new ResultSetExtractor<MonthlyWiseResponse>() {

				public MonthlyWiseResponse extractData(ResultSet rs) throws SQLException, DataAccessException {
					MonthlyWiseResponse resp = new MonthlyWiseResponse();
				
					if (rs.next()) {
						
						resp.setTotalCashCollect(rs.getFloat("tripFare"));
						resp.setTotalTripEarinings(rs.getFloat("tripEarnings"));
					
						
					
						return resp;

					} 
					resp.setTotalCashCollect(0);
					resp.setTotalDeductions(0);
					resp.setStatusCode(404);
					resp.setStatusMessage("No Connectivity to Database");
					return resp;
			
				}
			});

		}

		@Override
		public int getSumOfMonthlyIncentives(String month, int year, int driverId) {
			
			String sql = "select sum(incentives.incAmount) as Total_Incs from incentives where monthname(dateTime) = '"+month+"' and year(dateTime)='"+year+"'  and driverId='"+driverId+"'";
			
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					int sumIncentivesOfDay=0;
					
					if (rs.next()) {
						
						sumIncentivesOfDay=rs.getInt("Total_Incs");
					
						return sumIncentivesOfDay;

					} 
					
					
					return sumIncentivesOfDay;
			
				}
			});
		}

		@Override
		public int getSumOfMonthlyDeductions(String month, int year, int driverId) {
			
			String sql = "select sum(deductions.amount) as Total_Deds from deductions where monthname(dateTime) = '"+month+"' and year(dateTime)='"+year+"'  and driverId='"+driverId+"'";
			
			return template.query(sql, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					int sumDeductionsOfDay=0;
					
					if (rs.next()) {
						
						sumDeductionsOfDay=rs.getInt("Total_Deds");
					
						return sumDeductionsOfDay;

					} 
					
					
					return sumDeductionsOfDay;
			
				}
			});

		}

		@Override
		public WeeklyResponse getAllWeekWiseBookingsOfTheMonthly(LocalDate startDate, LocalDate endDate, int driverId) {
			
			String sql = "SELECT sum(totalAmount) as tripFare,sum(transporterAmount) as tripEarnings FROM truckways.postdetail  where date(postdetail.travelDate) between '"+startDate+"' and '"+endDate+"' and driverId='"+driverId+"'and postdetail.status='Completed' ";
			return template.query(sql, new ResultSetExtractor<WeeklyResponse>() {

				public WeeklyResponse extractData(ResultSet rs) throws SQLException, DataAccessException {
					WeeklyResponse resp = new WeeklyResponse();
				
					if (rs.next()) {
						
						resp.setCashCollect(rs.getFloat("tripFare"));
						resp.setTripEarinings(rs.getFloat("tripEarnings"));
						String sDate=startDate.toString();
					    String eDate=endDate.toString();
						resp.setFromDate(sDate);
						resp.setToDate(eDate);
						
						
					
						return resp;

					} 
					
					return resp;
			
				}
			});

		
		}	

		
		@Override
		public int UpdateBookingStatusFromCustomerApp(String status, String bookingId) {
			
			try{
			String sql = "update truckways.postdetail set postdetail.status='Customer Confirmed' where refPostId='"+bookingId+"'";
			
			return template.update(sql);
			} catch(Exception e){
				
				return 500;
			}
		}

		@Override
		public User getFcmTokenofTheUser(String bookingId) {
			try{ 
			
				String sql="SELECT user.* FROM truckways.user inner join truckways.postdetail on user.userId=postdetail.userId where postdetail.refPostId='"+bookingId+"'";  
				return template.query(sql, new ResultSetExtractor<User>() {  

				        public User extractData(ResultSet rs) throws SQLException,
				        DataAccessException {
				        	User use=new User();
				        	if (rs.next()) {
				            	
				        		System.out.println("rs.next()"+use);
				            	use.setUserId(rs.getInt("userId"));
				            	use.setUserName(rs.getString("userName"));
				            	use.setEmail(rs.getString("email"));
				            	use.setMobileNo(rs.getString("mobileNo"));
				            	use.setUserStatus(rs.getInt("userStatus"));
				            	use.setUserType(rs.getString("userType"));
				            	use.setFcmToken(rs.getString("fcmToken"));
				            	use.setAppUser(rs.getInt("appUser"));
				            	use.setActive(true);
				            	
				               return use;
				            }
				        	else
				        	{
				        		
				        		use.setActive(false);
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
		/*public int driverimageupload(String path, String time, int driverId,String status,int odometer) {
			//String sql="insert into truckways.driverimage(driverId,path,time,status,odometer) values('"+driverId+"','"+path+"','"+time+"',,'"+status+"','"+odometer+"')";
			String sql="update truckways.driverimage set driverimage.path='"+path+"',time='"+time+"',status='"+status+"',odometer='"+odometer+"' where driverimage.driverId='"+driverId+"'";
			return template.update(sql);
		}			
	*/
		//to get entVehDetailsId for a given driverId
		@Override
				public EnterpriseTruckAssign getEnterpriseInformation(int driverId){
			EnterpriseTruckAssign id=new EnterpriseTruckAssign();	
			
			try{ 
					String sql="SELECT entVehDetailsId,vehicleRegistrationNo,fixedKm,additionalKmPr,additionalHrPr,traveledKm,workingDays FROM truckways.vehicle inner join  truckways.entvehicledetails on entvehicledetails.entvehRegNo=vehicle.vehicleRegistrationNo where driverId='"+driverId+"' ";
						return template.query(sql, new ResultSetExtractor<EnterpriseTruckAssign>() {  

						        public EnterpriseTruckAssign extractData(ResultSet rs) throws SQLException,
						        DataAccessException {
						        	
						        	if (rs.next()) {
						        		id.setEnterpriseId(rs.getInt("entVehDetailsId"));
						        		id.setNoOfKms(rs.getLong("fixedKm"));
						        		id.setVehicleRegNo(rs.getString("vehicleRegistrationNo"));
						        		id.setPricePerAdditionalKm(rs.getInt("additionalKmPr"));
						        		id.setPricePerAdditionalMin(rs.getInt("additionalHrPr"));
						        		id.setDistanceTravelled(rs.getFloat("traveledKm"));
						        		id.setWorkingDays(rs.getInt("workingDays"));
						        		id.setStatusCode(200);
						               return id;
						            }
						        	
						        	id.setStatusCode(404);   
						        	 return id;
						        }
						 
						    });
						
						}
					
						catch(Exception e)
						{
							id.setStatusCode(500);
							return id;
						}
					
						
				}
				//inserting enterprise driver odometer start reading reading with date
			@Override
				public int driverimageinsert(String date,int entVehDetailsId, int odometer,LocalTime time){
				
				
				String sql="SELECT * FROM truckways.entrtripdetails where entVehDetailsId='"+entVehDetailsId+"' and date(entrtripdate)='"+date+"' ";
				
				return template.query(sql, new ResultSetExtractor<Integer>() {

					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
						int sumDeductionsOfDay=0;
						
						if (rs.next()) {
				
							String sql="update truckways.entrtripdetails set startReading='"+odometer+"',startReadingTime='"+time+"' where entVehDetailsId='"+entVehDetailsId+"' and date(entrtripdate)='"+date+"'";
				
							return template.update(sql);
							
						} else{
							
				
				
							String sql="INSERT INTO truckways.entrtripdetails (entVehDetailsId,entrtripdate,startReading,startReadingTime) VALUES ('"+entVehDetailsId+"', '"+date+"', '"+odometer+"','"+time+"');";
					
							return template.update(sql);
						}
				
					}
				
				});
}		
						
						
						//updateing enterprise driver end reading for a given driverId 
			@Override
				public int driverimageupload(String date, EnterpriseTruckAssign assign,int odometer,LocalTime time) {
					
				
				String sql="update truckways.entrtripdetails set endReading='"+odometer+"',endReadingTime='"+time+"', balanceKms='"+assign.getNoOfKms()+"' where entVehDetailsId='"+assign.getEnterpriseId()+"' and date(entrtripdate)='"+date+"'";
					return template.update(sql);
				}

			
			
			
			
			
			
			@Override
			public int getBalanceKmofEnterprise(int enterpriseVehicleId, float noOfKms) {
				
				String sql="Select min(balanceKms)as balanceKM from truckways.entrtripdetails where entVehDetailsId='"+enterpriseVehicleId+"'";
				
				return template.query(sql, new ResultSetExtractor<Integer>() {

					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
						int sumDeductionsOfDay=(int) noOfKms;
						
						if (rs.next()) {
							
							sumDeductionsOfDay=rs.getInt("balanceKM");
						
							return sumDeductionsOfDay;

						} 
						
						log.info("First Trip");
						return sumDeductionsOfDay;
				
					}
				});
			}

			@Override
			public EnterpriseTripDetails getTripDetails(int enterpriseVehicleId, String date) {
				
				String sql="SELECT * FROM truckways.entrtripdetails where entVehDetailsId='"+enterpriseVehicleId+"' and date(entrtripdate)='"+date+"' ";
				return template.query(sql, new ResultSetExtractor<EnterpriseTripDetails>() {  

				        public EnterpriseTripDetails extractData(ResultSet rs) throws SQLException,
				        DataAccessException {
				        	EnterpriseTripDetails id =new EnterpriseTripDetails();
				        	if (rs.next()) {
				        		
				        		id.setStartReading(rs.getFloat("startReading"));
				        		id.setStartReadingTime(rs.getString("startReadingTime"));
				        		id.setEndReading(rs.getFloat("endReading"));
				        		id.setEndReadingTime(rs.getString("endReadingTime"));
				               return id;
				            }
				        	
				        	
				        	 return id;
				        }
				 
				    });
				
				}

			@Override
			public int updateTripDetails(EnterpriseTripDetails tripinfo, int entVehDetailsId,String date1) {
			
				
				String sql="update truckways.entrtripdetails set todayKms='"+tripinfo.getTodayKm()+"',todayHours='"+tripinfo.getTodayMins()+"',additionalHrs='"+tripinfo.getAdditionalTime()+"',distanceTravelled='"+tripinfo.getDistanceTravelled()+"',balanceKms='"+tripinfo.getBalanceKm()+"',additionalAmount='"+tripinfo.getAdditionalAmount()+"' where entVehDetailsId='"+entVehDetailsId+"' and date(entrtripdate)='"+date1+"'";
				return template.update(sql);
				
			}

public void updateMultiplelocationDetails(List<DriverAppLocation> offlineLocations) {
				
				
				
				
				 String sql = "INSERT INTO truckways.locationvehicle " +
							"(driverId,latitude,longitude,currentDate,status) VALUES (?, ?, ?, ?, ?)";

				 template.batchUpdate(sql, new BatchPreparedStatementSetter() {

					
							public void setValues(PreparedStatement ps, int i) throws SQLException {
								DriverAppLocation loc = offlineLocations.get(i);
								ps.setString(1, loc.getDriverId());
								ps.setString(2,loc.getSourceLat());
								ps.setString(3,loc.getSourceLong());
								ps.setString(4,loc.getAppTime());
								ps.setString(5,loc.getStatus());
							}

							@Override
							public int getBatchSize() {
								return offlineLocations.size();
							}

						
						  });
				
			}
				

public List<LiveTracking> getVehicleTracking(int driverId, String srcTime,String destTime) {

	
	String sql="SELECT *,latitude as lat,longitude as lng,Time(currentDate) as currentTime FROM truckways.locationvehicle where driverId='"+driverId+"' and currentDate between '"+srcTime+"' and '"+destTime+"' order by currentDate asc";
	
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


		
				
					
	
	
	
	
}
