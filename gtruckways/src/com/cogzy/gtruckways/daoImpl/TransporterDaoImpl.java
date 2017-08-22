package com.cogzy.gtruckways.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.LocalTransporter;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.TransConfirm;
import com.cogzy.gtruckways.businessObjects.Transporter;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.dao.TransporterDao;

public class TransporterDaoImpl implements TransporterDao {

	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	} 
	
	//method to fetch all the available transporter from localtransporter table
	@Override
	public List<LocalTransporter> getTransporterDetails() {
		
		    String sql = "SELECT localtransporter.* FROM truckways.localtransporter order by  transporterId desc;";
		    try {
		    	return template.query(sql, new ResultSetExtractor<List<LocalTransporter>>() {
		 
		        
		        public List<LocalTransporter> extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        				
				            	ArrayList<LocalTransporter> trans = new ArrayList<LocalTransporter>();
								while (rs.next()){
				    	   
									LocalTransporter tr = new LocalTransporter();
									
								
									
									tr.setTransporterName(rs.getString("transporterName"));
									tr.setMobileNo(rs.getString("mobileNo"));
					            	tr.setAddress(rs.getString("address"));	
									tr.setContactPersonName(rs.getString("contactPersonName"));
									tr.setTransporterId(rs.getInt("transporterId"));
									
									
									trans.add(tr);
								}
								return trans;
				            	
		        		}
		 
		    });
		} catch (EmptyResultDataAccessException e) {
		    	return null;
		}
	}
	
	@Override
	public LocalTransporter getTransMobDetails(String TransMob) {
	    String sql = "SELECT localtransporter.* FROM truckways.localtransporter where mobileNo='"+TransMob+"'";
	    try {
	    	return template.query(sql, new ResultSetExtractor<LocalTransporter>() {
	 
	       
	        public LocalTransporter extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        				
			            	while (rs.next()){
			    	   
			            		LocalTransporter lt = new LocalTransporter();
								
								
								
								lt.setTransporterName(rs.getString("transporterName"));
								lt.setMobileNo(rs.getString("mobileNo"));
				            	
								lt.setEmail(rs.getString("email"));
								
				            	lt.setPanNo(rs.getString("panNo"));
				            	lt.setAcctHolderName(rs.getString("acctHolderName"));
				            	lt.setTransporterId(rs.getInt("transporterId"));
				            	lt.setIFSCcode(rs.getString("IFSCcode"));
				            	lt.setAcctNo(rs.getString("acctNo"));
				            	lt.setBankName(rs.getString("bankName"));
				            	lt.setBranch(rs.getString("branch"));
				            	lt.setIdentificationNo(rs.getString("identificationNo"));
				            	lt.setCancelledChequeNo(rs.getInt("cancelledChequeNo"));
				            	lt.setChqReceivedDate(rs.getString("chqReceivedDate"));
				            	
				            	
								return lt;
								
							}
							return null;
			            	
	        		}
	 
	    });
	    } catch (EmptyResultDataAccessException e) {
	    	return null;
	    }
	}
	
	@Override
	public List<Vehicle> getVehicleDetailsByMob(String transMob) {
		String sql = "select vehicle.* from vehicle inner join localtransporter on vehicle.transporterId = localtransporter.transporterId where mobileNo = '"+transMob+"'";
		try {
			return template.query(sql, new ResultSetExtractor<List<Vehicle>>() {



		    public List<Vehicle> extractData(ResultSet rs) throws SQLException,
		            DataAccessException {
		    				
			            	ArrayList<Vehicle> veh = new ArrayList<Vehicle>();
							while (rs.next()){
			    	   
									Vehicle v = new Vehicle();
									v.setVehicleName(rs.getString("vehicleName"));
									v.setVehicleRegistrationNo(rs.getString("vehicleRegistrationNo"));
									v.setVehicleChasisNo(rs.getString("vehicleChasisNo"));
									v.setVehicleInsuranceNo(rs.getString("vehicleInsuranceNo"));
									v.setInsuranceOwner(rs.getString("insuranceOwner"));
									v.setVehicleInsuranceExpiryDate(rs.getString("vehicleInsuranceExpiryDate"));
									v.setRegistrationDate(rs.getString("registrationDate"));
									v.setRegValidity(rs.getString("regValidity"));
									v.setEngineNo(rs.getString("engineNo"));
									v.setFcNo(rs.getString("fcNo"));
									v.setFcValidity(rs.getString("fcValidity"));
									v.setBrand(rs.getString("brand"));
									v.setCubicCapacity(rs.getInt("cubicCapacity"));
									v.setBhp(rs.getInt("bhp"));
									v.setPayLoadCapacity(rs.getInt("payLoadCapacity"));
									v.setVehicleType(rs.getString("vehicleType"));
									v.setDimension(rs.getString("dimension"));
									v.setPollutionCertNo(rs.getString("pollutionCertNo"));
									v.setPollutionCertValidity(rs.getString("pollutionCertValidity"));
									v.setPermitType(rs.getString("permitType"));
									v.setPermitStates(rs.getString("permitStates"));
									v.setVehicleId(rs.getInt("vehicleId"));
									v.setPermitValidity(rs.getString("permitValidity"));
					            	veh.add(v);
			    		   
							}
							return veh;
			            	
		    		}

			});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public LocalTransporter getTransportDetails(int TransId) {
	    String sql = "SELECT localtransporter.* FROM truckways.localtransporter where localtransporter.transporterId='"+TransId+"'";
	    try {
	    	return template.query(sql, new ResultSetExtractor<LocalTransporter>() {
	 
	       
	        public LocalTransporter extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        				
			            	while (rs.next()){
			    	   
			            		LocalTransporter lt = new LocalTransporter();
								
								
								
								lt.setTransporterName(rs.getString("transporterName"));
								lt.setMobileNo(rs.getString("mobileNo"));
				            	lt.setAddress(rs.getString("address"));
								lt.setEmail(rs.getString("email"));
								
				            	
				            	lt.setPanNo(rs.getString("panNo"));
				            	
				            	lt.setAcctHolderName(rs.getString("acctHolderName"));
				            	lt.setTransporterId(rs.getInt("transporterId"));
				            	lt.setIFSCcode(rs.getString("IFSCcode"));
				            	lt.setAcctNo(rs.getString("acctNo"));
				            	lt.setBankName(rs.getString("bankName"));
				            	lt.setBranch(rs.getString("branch"));
				            	lt.setIdentificationNo(rs.getString("identificationNo"));
				            	lt.setCancelledChequeNo(rs.getInt("cancelledChequeNo"));
				            	lt.setChqReceivedDate(rs.getString("chqReceivedDate"));
				            	
				            	
				            	
								return lt;
								
							}
							return null;
			            	
	        		}
	 
	    	});
	    } catch (EmptyResultDataAccessException e) {
	    	return null;
	    }
	}
	
	@Override
	public List<Vehicle> getVehicleDetails(int transId) {
	    String sql = "select vehicle.*,truckName from truckways.vehicle inner join localtransporter on localtransporter.transporterId = vehicle.transporterId inner join   truckways.truckinfo on  truckinfo.truckId=vehicle.vehicleName  where vehicle.transporterId ='"+transId+"'";
	    try {
	    	return template.query(sql, new ResultSetExtractor<List<Vehicle>>() {
	 
	       
	        public List<Vehicle> extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        				
			            	ArrayList<Vehicle> veh = new ArrayList<Vehicle>();
							while (rs.next()){
			    	   
								Vehicle v = new Vehicle();
								v.setVehicleName(rs.getString("truckName"));
								v.setVehicleRegistrationNo(rs.getString("vehicleRegistrationNo"));
								v.setVehicleChasisNo(rs.getString("vehicleChasisNo"));
								v.setVehicleInsuranceNo(rs.getString("vehicleInsuranceNo"));
								v.setInsuranceOwner(rs.getString("insuranceOwner"));
								v.setVehicleInsuranceExpiryDate(rs.getString("vehicleInsuranceExpiryDate"));
								v.setRegistrationDate(rs.getString("registrationDate"));
								v.setRegValidity(rs.getString("regValidity"));
								v.setEngineNo(rs.getString("engineNo"));
								v.setFcNo(rs.getString("fcNo"));
								v.setFcValidity(rs.getString("fcValidity"));
								v.setBrand(rs.getString("brand"));
								v.setCubicCapacity(rs.getInt("cubicCapacity"));
								v.setBhp(rs.getInt("bhp"));
								v.setPayLoadCapacity(rs.getInt("payLoadCapacity"));
								v.setVehicleType(rs.getString("vehicleType"));
								v.setDimension(rs.getString("dimension"));
								v.setPollutionCertNo(rs.getString("pollutionCertNo"));
								v.setPollutionCertValidity(rs.getString("pollutionCertValidity"));
								v.setPermitType(rs.getString("permitType"));
								v.setPermitStates(rs.getString("permitStates"));
								v.setVehicleId(rs.getInt("vehicleId"));
								v.setPermitValidity(rs.getString("permitValidity"));	
					            veh.add(v);
			    		   
							}
							return veh;
			            	
	        		}
	 
	    });
	    } catch (EmptyResultDataAccessException e) {
	    	return null;
	    }
	}
	
	//method to confirm the transporter
	@Override
	public int SaveTransConfirm(int driverId, Post pos){  
		
		 try {
			 	String sql="update truckways.postdetail set driverId='"+driverId+"',status='"+pos.getStatus()+"' where refPostId='"+pos.getBookingId()+"'";  
		        int status=template.update(sql);
		       	return status;
			 
		 } catch (EmptyResultDataAccessException e) {
		    	return 0;
		 }
	}
	
	
	
	@Override
	public boolean checkDuplicateVehicle(Vehicle veh) {
		String sql = " SELECT * FROM truckways.vehicle where vehicleRegistrationNo='"+veh.getVehicleRegistrationNo()+"'";
	    try {
	    	return template.query(sql, new ResultSetExtractor<Boolean>() {
	 
	        
	        public Boolean extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        				
			            	while (rs.next()){
			    	   
								return true;
								
							}
							return false;
			        }
	 
	    	});
	    } catch (EmptyResultDataAccessException e) {
	    	return false;
	    }
		
	}
	
	@Override
	public boolean checkDuplicateDriver(LocalDriver locDriver) {
		String sql = "SELECT * FROM truckways.localdriver WHERE mobile='"+locDriver.getMobile()+"' and dlNo='"+locDriver.getDlNo()+"'";
	    try {
	    	return template.query(sql, new ResultSetExtractor<Boolean>() {
	 
	        
	        public Boolean extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        				
			            	while (rs.next()){
			    	   
								return true;
								
							}
							return false;
			        }
	 
	    	});
	    } catch (EmptyResultDataAccessException e) {
	    	return false;
	    }
		
	}

	
	
	public int AddToDriverVehicle(LocalDriver locDriver,final Vehicle veh,final int TransporterId,final int truckId,LocalDateTime datetime) {
		  try{
		   
		   String sql="insert into truckways.localdriver(driverName,address,mobile,emailId,dlNo,dlIssueDate,dlValidity,driverPassword,driverStatusId,joinedDate) values ('"+locDriver.getDriverName()+"','"+locDriver.getAddress()+"','"+locDriver.getMobile()+"','"+locDriver.getEmailId()+"','"+locDriver.getDlNo()+"','"+locDriver.getDlIssueDate()+"','"+locDriver.getDlValidity()+"','"+locDriver.getPassword()+"','"+locDriver.getDriverStatus()+"','"+datetime+"')"; 
		   template.update(sql);
		   String sel="select localDriverId from truckways.localdriver where dlNo='"+locDriver.getDlNo()+"' and mobile='"+locDriver.getMobile()+"'";
		   return template.query(sel, new ResultSetExtractor<Integer>() {
		    
		    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
		     if (rs.next()) {
		      int DriverId=rs.getInt("localDriverId");
		      String sql1="insert into truckways.vehicle(vehicleName,vehicleRegistrationNo,vehicleChasisNo,vehicleInsuranceNo,insuranceOwner,vehicleInsuranceExpiryDate,registrationDate,regValidity,engineNo,fcNo,fcValidity,brand,cubicCapacity,bhp,payLoadCapacity,vehicleType,dimension,pollutionCertNo,pollutionCertValidity,permitType,permitStates,permitValidity,transporterId,driverId,actType,attachDate) values ('"+veh.getVehicleName()+"','"+veh.getVehicleRegistrationNo()+"','"+veh.getVehicleChasisNo()+"','"+veh.getVehicleInsuranceNo()+"','"+veh.getInsuranceOwner()+"','"+veh.getVehicleInsuranceExpiryDate()+"','"+veh.getRegistrationDate()+"','"+veh.getRegValidity()+"','"+veh.getEngineNo()+"','"+veh.getFcNo()+"','"+veh.getFcValidity()+"','"+veh.getBrand()+"','"+veh.getCubicCapacity()+"','"+veh.getBhp()+"','"+veh.getPayLoadCapacity()+"','"+veh.getVehicleType()+"','"+veh.getDimension()+"','"+veh.getPollutionCertNo()+"','"+veh.getPollutionCertValidity()+"','"+veh.getPermitType()+"','"+veh.getPermitStates()+"','"+veh.getPermitValidity()+"','"+TransporterId+"','"+DriverId+"','"+veh.getActType()+"','"+datetime+"')"; 
		      int status=template.update(sql1);
		      
		      String sql2="insert into truckways.vehiclelocation(driverId,truckTypeId) values ('"+DriverId+"','"+truckId+"')"; 
		      int stats=template.update(sql2);
		      
		      return status;
		     }
		     else
		     {
		      return 0;
		     }
		    }
		   });
		   
		  } catch (EmptyResultDataAccessException e) {
		   return 0;
		  }
		 }

	
	
	public int saveTransporter(Transporter trans,LocalDateTime dt, int active){  
		
		
	    String sql="insert into truckways.localtransporter(transporterName,contactPersonName,mobileNo,email,address,panNo,idProof,identificationNo,acctHolderName,acctNo,bankName,branch,IFSCcode,cancelledChequeNo,registerDate,transporterActive) values('"+trans.getTransportName()+"','"+trans.getContactName()+"','"+trans.getTransportMobileNo()+"','"+trans.getTransportEmail()+"','"+trans.getTransportAddress()+"','"+trans.getTransportPan()+"','"+trans.getTransportIdProof()+"','"+trans.getIdProofNumber()+"','"+trans.getAccHolderName()+"','"+trans.getAccNumber()+"','"+trans.getBankName()+"','"+trans.getBankBranch()+"','"+trans.getIfscCode()+"','"+trans.getTransportCheque()+"','"+dt+"','"+active+"')";  
	  
	    return template.update(sql);   
	}

	
	public boolean checkDuplicateTransporter(Transporter trans) {
		String sql = "SELECT * FROM truckways.localtransporter WHERE mobileNo='"+trans.getTransportMobileNo()+"' and panNo='"+trans.getTransportPan()+"'";
	    try {
	    	return template.query(sql, new ResultSetExtractor<Boolean>() {
	 
	        
	        public Boolean extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        				
			            	while (rs.next()){
			    	   
								return true;
								
							}
							return false;
			        }
	 
	    	});
	    } catch (EmptyResultDataAccessException e) {
	    	return false;
	    }
		
	}

	@Override
	public List<Post> getTransporterPaymentInformation(String fromDate,String toDate,String transporterId) {

		 String sql = "select localtransporter.*, vehicle.*, postdetail.*, localdriver.* from postdetail inner join localtransporter on postdetail.transporterId = localtransporter.transporterId inner join vehicle on localtransporter.transporterId = vehicle.transporterId inner join localdriver on vehicle.driverId = localdriver.localDriverId where postdetail.postId in (select postId from postdetail where transporterId='"+transporterId+"' and status='Completed' and destReachedDateTime between '"+fromDate+"' and '"+toDate+"') and vehicle.driverId = postdetail.driverId";
		 		try {  	
		 			return template.query(sql, new ResultSetExtractor<List<Post>>() {
		 
		       
					 public List<Post> extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        				
				            	ArrayList<Post> pos = new ArrayList<Post>();
								while (rs.next()){
				    	   
									Post post=new Post();
									
									Transporter trans=new Transporter();
									
									trans.setTransporterId(rs.getInt("transporterId"));
									trans.setTransportName(rs.getString("transporterName"));
									Vehicle vehi=new Vehicle();
									
									vehi.setVehicleName(rs.getString("vehicleName"));
									vehi.setVehicleRegistrationNo(rs.getString("vehicleRegistrationNo"));
							
									LocalDriver drive=new LocalDriver();
									
									drive.setDriverName(rs.getString("driverName"));
									post.setTravelDate(rs.getString("travelDate"));
									post.setPostDate(rs.getString("postDate"));
									post.setFromCity(rs.getString("fromCity"));
									post.setToCity(rs.getString("toCity"));
									post.setMaterial(rs.getString("material"));
									
									post.setRefPostId(rs.getString("refPostId"));
									
									post.setPostId(rs.getInt("postId"));
									post.setTotalAmount(rs.getFloat("totalAmount"));
									post.setGtruckwaysAmount(rs.getFloat("gtruckwaysAmount"));
									post.setTransporterAmount(rs.getFloat("transporterAmount"));
									
									vehi.setDriverId(drive);
									
									post.setTransporter(trans);
									post.setVehi(vehi);
									pos.add(post);
								}
								return pos;
				            	
		        		}
		 
		    });
		    } catch (EmptyResultDataAccessException e) {
		    	return null;
		    }
	
	}

	@Override
	public AmountDetails getAllTotalAmount(String fromDate, String toDate, int transporterId) {
		 String sql ="Select SUM(postdetail.totalAmount) as Total_Amount, sum(gtruckwaysAmount) as Total_gTruck_Amount, sum(postdetail.transporterAmount) as Total_Transporter_Amount  from postdetail inner join localtransporter on postdetail.transporterId = localtransporter.transporterId inner join vehicle on localtransporter.transporterId = vehicle.transporterId inner join localdriver on vehicle.driverId = localdriver.localDriverId where postdetail.postId in (select postId from postdetail where postdetail.transporterId='"+transporterId+"' and status='Completed' and destReachedDateTime between '"+fromDate+"' and '"+toDate+"') and vehicle.driverId = postdetail.driverId"; 
		    try {
		    	return template.query(sql, new ResultSetExtractor<AmountDetails>() {
		 
		       
		        public AmountDetails extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        				
				            	while (rs.next()){
				    	   
				            		AmountDetails amt= new AmountDetails();
									amt.setCustomerAmount(Math.round(rs.getFloat("Total_Amount")));
									amt.setGtruckwaysAmount(Math.round(rs.getFloat("Total_gTruck_Amount")));
									amt.setTransporterAmount(Math.round(rs.getFloat("Total_Transporter_Amount")));
									
									
									
					            	
					            	
									return amt;
									
								}
								return null;
				            	
		        		}
		 
		    });
		    } catch (EmptyResultDataAccessException e) {
		    	return null;
		    }
	
	}
	
	public Vehicle getVehicleInformation(String vehRegNum)
	{
		String sql="SELECT * FROM truckways.vehicle where vehicleRegistrationNo='"+vehRegNum+"'";
		return template.query(sql, new ResultSetExtractor<Vehicle>() {
			
			public Vehicle extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Vehicle v = new Vehicle();
					LocalTransporter lt = new LocalTransporter();
					LocalDriver ld=new LocalDriver();
					
					lt.setTransporterId(rs.getInt("transporterId"));
					
					ld.setDriverId(rs.getInt("driverId"));
					
					v.setVehicleName(rs.getString("vehicleName"));
					v.setVehicleRegistrationNo(rs.getString("vehicleRegistrationNo"));
					v.setActType(rs.getString("actType"));
					v.setVehicleChasisNo(rs.getString("vehicleChasisNo"));
					v.setVehicleInsuranceNo(rs.getString("vehicleInsuranceNo"));
					v.setInsuranceOwner(rs.getString("insuranceOwner"));
					v.setVehicleInsuranceExpiryDate(rs.getString("vehicleInsuranceExpiryDate"));
					v.setRegistrationDate(rs.getString("registrationDate"));
					v.setRegValidity(rs.getString("regValidity"));
					v.setEngineNo(rs.getString("engineNo"));
					v.setFcNo(rs.getString("fcNo"));
					v.setFcValidity(rs.getString("fcValidity"));
					v.setBrand(rs.getString("brand"));
					v.setCubicCapacity(rs.getInt("cubicCapacity"));
					v.setBhp(rs.getInt("bhp"));
					v.setPayLoadCapacity(rs.getInt("payLoadCapacity"));
					v.setVehicleType(rs.getString("vehicleType"));
					v.setDimension(rs.getString("dimension"));
					v.setPollutionCertNo(rs.getString("pollutionCertNo"));
					v.setPollutionCertValidity(rs.getString("pollutionCertValidity"));
					v.setPermitType(rs.getString("permitType"));
					v.setPermitStates(rs.getString("permitStates"));
					v.setVehicleId(rs.getInt("vehicleId"));
					v.setPermitValidity(rs.getString("permitValidity"));	
					v.setTransporter(lt);
					v.setDriverId(ld);
					return v;
				}
				else
				{
					return null;
				}
			}
		});
		
	}

	public boolean checkValidTransId(int transId) {
		String sql = "SELECT transporterId FROM truckways.localtransporter WHERE localtransporter.transporterId='"+transId+"'";
	    try {
	    	return template.query(sql, new ResultSetExtractor<Boolean>() {
	 
	        
	        public Boolean extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        				
			            	while (rs.next()){
			    	   
								return true;
								
							}
							return false;
			        }
	 
	    	});
	    } catch (EmptyResultDataAccessException e) {
	    	return false;
	    }
	}
	
	@Override
	public List<Post> getAllTransporterPaymentInformation(String fromDate, String toDate) {
		String sql = "select localtransporter.*, vehicle.*, postdetail.*, localdriver.*from postdetail inner join localtransporter on postdetail.transporterId = localtransporter.transporterId inner join vehicle on localtransporter.transporterId = vehicle.transporterId inner join localdriver on vehicle.driverId = localdriver.localDriverId where postdetail.postId in (select postId from postdetail where status='Completed' and destReachedDateTime between '"+fromDate+"' and '"+toDate+"')";
 		try {  	
 			return template.query(sql, new ResultSetExtractor<List<Post>>() {
 
       
			 public List<Post> extractData(ResultSet rs) throws SQLException,
                DataAccessException {
        				
		            	ArrayList<Post> pos = new ArrayList<Post>();
						while (rs.next()){
		    	   
							Post post=new Post();
							
							Transporter trans=new Transporter();
							
							trans.setTransporterId(rs.getInt("transporterId"));
							trans.setTransportName(rs.getString("transporterName"));
							Vehicle vehi=new Vehicle();
							
							vehi.setVehicleName(rs.getString("vehicleName"));
							vehi.setVehicleRegistrationNo(rs.getString("vehicleRegistrationNo"));
					
							LocalDriver drive=new LocalDriver();
							
							drive.setDriverName(rs.getString("driverName"));
							post.setTravelDate(rs.getString("travelDate"));
							post.setPostDate(rs.getString("postDate"));
							post.setFromCity(rs.getString("fromCity"));
							post.setToCity(rs.getString("toCity"));
							post.setMaterial(rs.getString("material"));
							
							
							post.setRefPostId(rs.getString("refPostId"));
							
							post.setPostId(rs.getInt("postId"));
							post.setTotalAmount(rs.getFloat("totalAmount"));
							post.setGtruckwaysAmount(rs.getFloat("gtruckwaysAmount"));
							post.setTransporterAmount(rs.getFloat("transporterAmount"));
							
							vehi.setDriverId(drive);
							
							post.setTransporter(trans);
							post.setVehi(vehi);
							pos.add(post);
						}
						return pos;
		            	
        		}
 
    });
    } catch (EmptyResultDataAccessException e) {
    	return null;
    }
	}

	@Override
	public Deductions getTransporterDeduction(final Post p) {
		String sql = "select sum(deductions.amount) as Deduction_Amt,bookId from deductions inner join localdriver on deductions.driverId = localdriver.localDriverId where bookId='"+p.getPostId()+"'";
 		try {  	
 			return template.query(sql, new ResultSetExtractor<Deductions>() {
 
       
			 public Deductions extractData(ResultSet rs) throws SQLException,
                DataAccessException {
				
						if(rs.next()){
							
							Deductions ded=new Deductions();
							ded.setAmount(rs.getFloat("Deduction_Amt"));
							ded.setBookId(p.getRefPostId());
							return ded;
						}
						return null;
			 }
			 
 		    });
 		    } catch (EmptyResultDataAccessException e) {
 		    	return null;
 		    }
	}

	@Override
	public Incentives getTransporterIncentive(final Post p) {
		String sql = "select sum(incentives.incAmount) as Incentive_Amt,bookId from incentives inner join localdriver on incentives.driverId = localdriver.localDriverId where bookId='"+p.getPostId()+"'";
 		try {  	
 			return template.query(sql, new ResultSetExtractor<Incentives>() {
 
       
			 public Incentives extractData(ResultSet rs) throws SQLException,
                DataAccessException {
				
						if(rs.next()){
							Incentives in=new Incentives();
							in.setIncAmount(rs.getFloat("Incentive_Amt"));
							in.setBookId(p.getRefPostId());
							return in;
						}
						return null;
			 }
			 
 		    });
 		    } catch (EmptyResultDataAccessException e) {
 		    	return null;
 		    }
	}
	
	@Override
	 public int getTrcukId(String VehicleName) {
	  String sql = "select truckId from truckways.truckinfo where truckId='"+VehicleName+"'";
	   try {   
	    return template.query(sql, new ResultSetExtractor<Integer>() {
	 
	    public Integer extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	    
	      if(rs.next()){
	       
	       int truckId=rs.getInt("truckId");
	       return truckId;
	      }
	      return 0;
	    }
	    
	       });
	       } catch (EmptyResultDataAccessException e) {
	        return 0;
	       }
	 }
}
