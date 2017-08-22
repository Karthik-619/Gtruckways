package com.cogzy.gtruckways.daoImpl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseInvoice;
import com.cogzy.gtruckways.businessObjects.EnterpriseOdometer;
import com.cogzy.gtruckways.businessObjects.EnterpriseTripDetails;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.SchedulingVehicle;
import com.cogzy.gtruckways.businessObjects.SeoFile;
import com.cogzy.gtruckways.businessObjects.SpareTruckInfo;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.dao.AccountManagerDao;
import com.cogzy.gtruckways.validator.Log;
import com.mysql.jdbc.Blob;

@Repository
public class AccountManagerDaoImpl implements AccountManagerDao {

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	
	
	@Override
	public TreeMap<String,EnterpriseCustomer> getEnterPriseName() {
		
		
		String sql="SELECT enterpriseName,EnterpriseId FROM truckways.enterprisecustomer";
		
		return template.query(sql, new ResultSetExtractor<TreeMap<String,EnterpriseCustomer>>() {

			public TreeMap<String,EnterpriseCustomer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				TreeMap<String,EnterpriseCustomer> ps = new TreeMap<String,EnterpriseCustomer>();
				
				 
				while(rs.next()) {
					
					EnterpriseCustomer ent=new EnterpriseCustomer();
					ent.setEnterpriseName(rs.getString("enterpriseName"));
					ent.setEnterpriseCustomerId(rs.getInt("EnterpriseId"));
				System.out.println("enterpriseName"+rs.getString("enterpriseName"));
					
					ps.put(ent.getEnterpriseName(), ent);
				
				}
				
				
				
				return ps;
			}
		});

	}




	@Override
	public EnterpriseCustomer getEnterpriseInformation(String enterpriseName) {
		
		EnterpriseCustomer ent = new EnterpriseCustomer();
		try{
		String sql="SELECT * FROM truckways.enterprisecustomer where enterpriseName='"+enterpriseName+"'";
		
		return template.query(sql, new ResultSetExtractor<EnterpriseCustomer>() {

			public EnterpriseCustomer extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if (rs.next()) {

					ent.setEnterpriseCustomerId(rs.getInt("EnterpriseId"));
					ent.setEnterpriseName(rs.getString("enterpriseName"));
					ent.setContactNumber(rs.getString("contactNumber"));
					ent.setContactPerson(rs.getString("contactPerson"));
					ent.setAddress(rs.getString("address"));
					ent.setEmail(rs.getString("email"));
					ent.setStatus(rs.getInt("status"));	
					ent.setStatusCode(200);
					ent.setStatusMessage("EnterPrise Found");
					Log.info("Enterprise Found");
					return ent;
					} 

					
					ent.setStatusCode(404);
					Log.info("NO Enterprise Found");
					ent.setStatusMessage("No EnterPrise Found");
					return ent;
			}
		});
	
		} catch(Exception e){
			
			ent.setStatusCode(500);
			ent.setStatusMessage("Server Error");
			return ent;
		}
	
	}

	@Override
	public int updateEnterpriseDetails(EnterpriseCustomer ec) {
		
		String sql="update truckways.enterprisecustomer set contactPerson='"+ec.getContactPerson()+"',address='"+ec.getAddress()+"',status='"+ec.getStatus()+"',password='"+ec.getPassword()+"' , contactNumber='"+ec.getContactNumber()+"',email='"+ec.getEmail()+"',registeredDate='"+ec.getRegDate()+"' where enterpriseName='"+ec.getEnterpriseName()+"'";
		
		return template.update(sql);
	}


	/*@Override
	public int updateEnterpriseDetails(EnterpriseCustomer ec) {
		
		String sql="update truckways.enterprisecustomer set contactPerson='"+ec.getContactPerson()+"',address='"+ec.getAddress()+"',contactNumber='"+ec.getContactNumber()+"',status='"+ec.getStatus()+"' where enterpriseName='"+ec.getEnterpriseName()+"' and email='"+ec.getEmail()+"'";
		
		return template.update(sql);
	}*/




	@Override
	public int assignTruckToEnterprise(EnterpriseTruckAssign assign) {
		
		
		String sql="insert into truckways.entvehicledetails (enterpriseCustomerId,vehicleType,entvehRegNo,startPoint,endPoint,fixedKm,fixedDays,noHrs,additionalKmPr,additionalHrPr,timeSlot,startDate,endDate,quoteAmount,totalAmount,workingDays) values('"+assign.getEnterpriseId()+"','"+assign.getVehicleType()+"','"+assign.getVehicleRegNo()+"','"+assign.getSource()+"','"+assign.getDestination()+"','"+assign.getNoOfKms()+"','"+assign.getNoOfDays()+"','"+assign.getNoOfhours()+"','"+assign.getPricePerAdditionalKm()+"','"+assign.getPricePerAdditionalMin()+"','"+assign.getScheduleTime()+"','"+assign.getStartDate()+"','"+assign.getEndDate()+"','"+assign.getQuoteAmount()+"','"+assign.getQuoteAmount()+"','0')";
		
		
		return template.update(sql);
	}




	@Override
	public List<SchedulingVehicle> getDailySchedulingDetails() {

		String sql="select entvehicledetails.*, truckinfo.truckName, enterprisecustomer.enterpriseId, enterprisecustomer.enterpriseName, vehicle.driverId, localdriver.driverName , localdriver.mobile from entvehicledetails inner join truckinfo on entvehicledetails.vehicleType = truckinfo.truckId inner join enterprisecustomer on enterprisecustomer.enterpriseId = entvehicledetails.enterpriseCustomerId inner join vehicle on entvehicledetails.entvehRegNo = vehicle.vehicleRegistrationNo inner join localdriver on vehicle.driverId = localdriver.localDriverId where date(now()) between startDate and endDate";
		
		return template.query(sql, new ResultSetExtractor<List<SchedulingVehicle>>() {

			public List<SchedulingVehicle> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<SchedulingVehicle> ps = new ArrayList<SchedulingVehicle>();
				
				while(rs.next()) {
					SchedulingVehicle assign=new SchedulingVehicle();
					
					assign.setEnterpriseName(rs.getString("enterpriseName"));
					assign.setEnterpriseId(rs.getInt("enterpriseCustomerId"));
					assign.setVehicleRegNo(rs.getString("entvehRegNo"));
					assign.setVehicleName(rs.getString("truckName"));
					assign.setDriverName(rs.getString("driverName"));
					assign.setDriverMobile(rs.getString("mobile"));
					assign.setSource(rs.getString("startPoint"));
					assign.setDestination(rs.getString("endPoint"));
					assign.setScheduleTime(rs.getString("timeSlot"));
					assign.setStartDate(rs.getString("startDate"));
					assign.setEndDate(rs.getString("endDate"));
					ps.add(assign);
				} 

				
				
				return ps;
			}
		});
	}
	
	
	@Override
	public List<Vehicle> getTruckRegNo(int vehicleTypeId) {
String sql="SELECT vehicleRegistrationNo FROM truckways.vehicle where actType='Enterprise' and vehicleName='"+vehicleTypeId+"' and assignStatus='0'";
		
		return template.query(sql, new ResultSetExtractor<List<Vehicle>>() {

			public List<Vehicle> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<Vehicle> ps = new ArrayList<Vehicle>();
				
				while(rs.next()) {
					Vehicle vehi=new Vehicle();
					vehi.setVehicleRegistrationNo(rs.getString("vehicleRegistrationNo"));
					
					
					ps.add(vehi);
				} 

				
				
				return ps;
			}
		});
	}
	
	@Override
	public List<EnterpriseTruckAssign> getParticularEnterpriseVehicleDetails(int enterpriseId) {
		
	
			
		String sql="SELECT entvehicledetails.*,truckName FROM truckways.entvehicledetails inner join truckways.truckinfo on truckinfo.truckId=entvehicledetails.vehicleType where enterpriseCustomerId='"+enterpriseId+"' and (entVehicleActive='555' or entVehicleActive='777')"; 
		   
		   return template.query(sql, new ResultSetExtractor<List<EnterpriseTruckAssign>>() {  


			        @Override
			        public List<EnterpriseTruckAssign> extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        	List<EnterpriseTruckAssign> ent= new ArrayList<EnterpriseTruckAssign>();
			        	
			        	while (rs.next()) {
			        		EnterpriseTruckAssign ec= new EnterpriseTruckAssign();
			            	ec.setVehicleName(rs.getString("truckName"));
			            	ec.setVehicleRegNo(rs.getString("entvehRegNo"));
			            	ec.setSource(rs.getString("startPoint"));
			            	ec.setDestination(rs.getString("endPoint"));
			            	ec.setNoOfDays(rs.getInt("fixedDays"));
			            	ec.setPricePerAdditionalKm(rs.getInt("additionalKmPr"));
			            	ec.setPricePerAdditionalMin(rs.getInt("additionalHrPr"));
			            	ec.setQuoteAmount(rs.getFloat("quoteAmount"));
			            	ec.setNoOfKms(rs.getInt("fixedKm"));
			            	ec.setNoOfhours(rs.getInt("noHrs"));
			            	ec.setStartDate(rs.getString("startDate"));
			            	ec.setEndDate(rs.getString("endDate"));
			        		ec.setStatusCode(200);
			        		ec.setStatusMessage("Data Found");
			            	
			            	ent.add(ec);
			            }
			        	
			        	return ent;
			            
			        }
			 
			    });

	
		
		   
		   
		   
	}



	
	public List<EnterpriseTruckAssign> getParticularEnterpriseVehicleDetailsInSpare(int enterpriseId) {
		
		
		
		String sql="SELECT entvehicledetails.*,truckName,max(distanceTravelled) as distanceTravelled  FROM truckways.entvehicledetails inner join truckways.truckinfo on truckinfo.truckId=entvehicledetails.vehicleType inner join truckways.entrtripdetails on entrtripdetails.entVehDetailsId=entvehicledetails.entVehDetailsId where enterpriseCustomerId='"+enterpriseId+"' and entVehicleActive='555' group by entvehRegNo"; 
		   
		   return template.query(sql, new ResultSetExtractor<List<EnterpriseTruckAssign>>() {  


			        @Override
			        public List<EnterpriseTruckAssign> extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        	List<EnterpriseTruckAssign> ent= new ArrayList<EnterpriseTruckAssign>();
			        	
			        	while (rs.next()) {
			        		EnterpriseTruckAssign ec= new EnterpriseTruckAssign();
			            	ec.setVehicleName(rs.getString("truckName"));
			            	ec.setVehicleRegNo(rs.getString("entvehRegNo"));
			            	ec.setSource(rs.getString("startPoint"));
			            	ec.setDestination(rs.getString("endPoint"));
			            	ec.setNoOfDays(rs.getInt("daysRequired"));
			            	ec.setPricePerAdditionalKm(rs.getInt("additionalKmPr"));
			            	ec.setPricePerAdditionalMin(rs.getInt("additionalHrPr"));
			            	ec.setQuoteAmount(rs.getFloat("quoteAmount"));
			            	ec.setNoOfKms(rs.getInt("noKms"));
			            	ec.setNoOfhours(rs.getInt("noHrs"));
			            	ec.setStartDate(rs.getString("startDate"));
			            	ec.setEndDate(rs.getString("endDate"));
			            	ec.setDistanceTravelled(rs.getFloat("distanceTravelled"));
			            	ec.setStatusCode(200);
			        		ec.setStatusMessage("Data Found");
			            	
			            	ent.add(ec);
			            }
			        	
			        	return ent;
			            
			        }
			 
			    });

	
		
		   
		   
		   
	}
	
	
	
	
	
	
	
	

	@Override
	public List<EnterpriseCustomer> getAllEnterpriseNames() {
			
		String sql="SELECT * FROM truckways.enterprisecustomer";
		
		return template.query(sql, new ResultSetExtractor<List<EnterpriseCustomer>>() {

			public List<EnterpriseCustomer> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<EnterpriseCustomer> ps = new ArrayList<EnterpriseCustomer>();
				
				while(rs.next()) {
					EnterpriseCustomer ent=new EnterpriseCustomer ();
					
					ent.setEnterpriseName(rs.getString("enterpriseName"));
					
					ps.add(ent);
				} 

				
				
				return ps;
			}
		});
	
	}




	@Override
	public int updateEnterpriseVehicleDetails(EnterpriseTruckAssign eta) {
	
		String sql="update truckways.entvehicledetails set startPoint='"+eta.getSource()+"',endPoint='"+eta.getDestination()+"',noKms='"+eta.getNoOfKms()+"',noHrs='"+eta.getNoOfhours()+"',quoteAmount='"+eta.getQuoteAmount()+"',additionalKmPr='"+eta.getPricePerAdditionalKm()+"',additionalHrPr='"+eta.getPricePerAdditionalMin()+"',startDate='"+eta.getStartDate()+"',endDate='"+eta.getEndDate()+"' where entvehRegNo='"+eta.getVehicleRegNo()+"' and enterpriseCustomerId='"+eta.getEnterpriseId()+"'";
		
		return template.update(sql);
		
	}
	
	
	@Override
	public int EnterpriseVehicleContractCancel(String RegNo) {

	
		String sql="update truckways.vehicle,truckways.entvehicledetails set assignStatus='0',entVehicleActive='999' where vehicleRegistrationNo='"+RegNo+"' and entvehRegNo='"+RegNo+"'";
		
		
		return template.update(sql);
	}




	@Override
	public List<String> getSpareVehicles(String vehicleType) {
		
	
		
		String sql="SELECT * FROM truckways.vehicle where vehicleName=(select truckId from truckways.truckinfo where truckName='"+vehicleType+"') and actType='Spare' and assignStatus=0";
		
		return template.query(sql, new ResultSetExtractor<List<String>>() {

			public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<String> ps = new ArrayList<String>();
				
				while(rs.next()) {
					
					String VehicleRegNo=rs.getString("vehicleRegistrationNo");
					
					ps.add(VehicleRegNo);
				} 

				
				
				return ps;
			}
		});
	
	}




	@Override
	public int updateVehicleStatus(String regNo) {
	
		String sql="update truckways.vehicle set assignStatus='1' where vehicleRegistrationNo='"+regNo+"'";
		
		return template.update(sql);
	}


	
	
	public int updateSpareVehicleStatus(String regNo,String spareRegNo) {
		
		String sql="update truckways.entvehicledetails,truckways.vehicle set entVehicleActive='777',assignStatus='1' where entvehRegNo='"+regNo+"' and vehicleRegistrationNo='"+spareRegNo+"'";
		
		return template.update(sql);
	}



	@Override
	public int insertSpareTruckDetails(SpareTruckInfo spare,int entCustomerId) {
		
		String sql=" insert into truckways.entsparevehicles(entCustomerId,entVehicelRegNo,SpareVehicleRegNo,noOfDays,StartDate,endDate,vehicleType) values('"+entCustomerId+"','"+spare.getAssignVehicleRegNo()+"','"+spare.getSpareVehicleRegNo()+"','"+spare.getNoOfDays()+"','"+spare.getStartDate()+"','"+spare.getEndDate()+"','"+spare.getSpareVehicleType()+"')";

		return template.update(sql);
	}




	@Override
	public List<SpareTruckInfo> getSpareTruckofEnterprise(int entCustomerId) {
		
		String sql=" SELECT * FROM truckways.entsparevehicles where entCustomerId='"+entCustomerId+"' and spareActive='55'";
		
		return template.query(sql, new ResultSetExtractor<List<SpareTruckInfo>>() {

			public List<SpareTruckInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<SpareTruckInfo> ps = new ArrayList<SpareTruckInfo>();
				
				while(rs.next()) {
					SpareTruckInfo spare=new SpareTruckInfo();
					
					spare.setAssignVehicleRegNo(rs.getString("entVehicelRegNo"));
					spare.setSpareVehicleRegNo(rs.getString("SpareVehicleRegNo"));
					spare.setNoOfDays(rs.getInt("noOfDays"));
					spare.setStartDate(rs.getString("StartDate"));
					spare.setEndDate(rs.getString("endDate"));
					spare.setSpareVehicleType(rs.getString("vehicleType"));
					
					ps.add(spare);
				} 

				
				
				return ps;
			}
		});
		
	}




	@Override
	public int reassignOfVehicle(String assignVehicle, String spareVehicle) {
		// TODO Auto-generated method stub
		
		String sql="update truckways.entvehicledetails,truckways.entsparevehicles,truckways.vehicle set entVehicleActive='555',spareActive='77',assignStatus='0' where entvehRegNo='"+assignVehicle+"' and entVehicelRegNo='"+assignVehicle+"'  and SpareVehicleRegNo='"+spareVehicle+"' and vehicleRegistrationNo='"+spareVehicle+"'";
		
		return template.update(sql);
	}
	
	
	@Override
	public List<EnterpriseTripDetails> getEnterpriseTripDetails(String startDate, String endDate, int entCustomerId) {
	
		
		String sql="SELECT entvehicledetails.*,truckName,entrtripdetails.* FROM truckways.entrtripdetails inner join truckways.entvehicledetails on entrtripdetails.entVehDetailsId=entvehicledetails.entVehDetailsId inner join truckways.truckinfo on entvehicledetails.vehicleType=truckinfo.truckId  where enterpriseCustomerId='"+entCustomerId+"' and date(entrtripdate) between '"+startDate+"' and '"+endDate+"'";
		
		return template.query(sql, new ResultSetExtractor<List<EnterpriseTripDetails>>() {

			public List<EnterpriseTripDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<EnterpriseTripDetails> ps = new ArrayList<EnterpriseTripDetails>();
				
				while(rs.next()) {
					EnterpriseTripDetails ent=new EnterpriseTripDetails();
					
					ent.setVehicelRegNo(rs.getString("entvehRegNo"));
					ent.setVehicleType(rs.getString("truckName"));
					ent.setTripDate(rs.getString("entrtripdate"));
					ent.setDistance(rs.getString("todayKms"));
					ent.setTodayMins(rs.getInt("todayHours"));
					ent.setAdditionalTime(rs.getInt("additionalHrs"));
					ent.setAdditionalAmount(rs.getFloat("additionalAmount"));
					ent.setTotalAmount(rs.getFloat("totalAmount"));
					ent.setStartReading(rs.getFloat("startReading"));
					ent.setEndReading(rs.getFloat("endReading"));
					ent.setStartReadingTime(rs.getString("startReadingTime"));
					ent.setEndReadingTime(rs.getString("endReadingTime"));
					ps.add(ent);
				} 

				
				
				return ps;
			}
		});
	
	
	
	}




	@Override
	public List<EnterpriseInvoice> getEnterpriseVehicleDetails(String startDate, String endDate,
			int entCustomerId) {
		String sql="SELECT entvehicledetails.*,truckName FROM truckways.entrtripdetails inner join truckways.entvehicledetails on entrtripdetails.entVehDetailsId=entvehicledetails.entVehDetailsId inner join truckways.truckinfo on entvehicledetails.vehicleType=truckinfo.truckId  where enterpriseCustomerId='"+entCustomerId+"' and date(entrtripdate) between '"+startDate+"' and '"+endDate+"' group by entvehRegNo";
		
		return template.query(sql, new ResultSetExtractor<List<EnterpriseInvoice>>() {

			public List<EnterpriseInvoice> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<EnterpriseInvoice> ps = new ArrayList<EnterpriseInvoice>();
				
				while(rs.next()) {
					EnterpriseInvoice ent=new EnterpriseInvoice();
					
					ent.setVehicleRegNo(rs.getString("entvehRegNo"));
					ent.setVehicleType(rs.getString("truckName"));
					ent.setFixedKm(rs.getFloat("fixedKm"));
					ent.setFixedDays(rs.getInt("fixedDays"));
					ent.setFixedRate(rs.getFloat("quoteAmount"));
					ent.setTotalKm(rs.getFloat("traveledKm"));
					ent.setActualWorkingDays(rs.getInt("workingDays"));
					ent.setStartDate(rs.getString("startDate"));
					ent.setEndDate(rs.getString("endDate"));
					ent.setActualAmount(rs.getFloat("totalAmount"));
					
					
					
					ps.add(ent);
				} 

				
				
				return ps;
			}
		});
	
	}




	@Override
	public List<EnterpriseVehicleStatus> getvehicleStatus(int entCustomerId) {
		
		String sql="SELECT max(distanceTravelled) as distanceTraveled,min(balanceKms) as balanceKm,entvehRegNo,noKms,daysRequired,vehicleType,noHrs,truckName FROM truckways.entrtripdetails inner join truckways.entvehicledetails on entrtripdetails.entVehDetailsId=entvehicledetails.entVehDetailsId inner join truckways.truckinfo on truckinfo.truckId=entvehicledetails.vehicleType where enterpriseCustomerId='"+entCustomerId+"' group by entvehRegNo";
		
		return template.query(sql, new ResultSetExtractor<List<EnterpriseVehicleStatus>>() {

			public List<EnterpriseVehicleStatus> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<EnterpriseVehicleStatus> ps = new ArrayList<EnterpriseVehicleStatus>();
				
				while(rs.next()) {
					EnterpriseVehicleStatus ent=new EnterpriseVehicleStatus();
					
					ent.setVehicelRegNo(rs.getString("entvehRegNo"));
					ent.setVehicleType(rs.getString("truckName"));
					ent.setNoOfKms(rs.getInt("fixedKm"));
					ent.setNoOfhoursPerDay(rs.getInt("noHrs"));
					ent.setNoOfDays(rs.getInt("fixedDays"));
					ent.setTravelledKm(rs.getInt("distanceTraveled"));
					ent.setRemainingKm(rs.getInt("balanceKm"));
					ps.add(ent);
				} 

				
				
				return ps;
			}
		});
	
		
		
	}




	@Override
	public List<EnterpriseVehicleStatus> getVehicleLocation(int entCustomerId) {
		
		String sql="SELECT currentLat,currentLong,vehiclelocation.driverId, vehicleRegistrationNo,truckName FROM truckways.vehiclelocation inner join truckways.vehicle on vehicle.driverId=vehiclelocation.driverId inner join truckways.entvehicledetails on entvehicledetails.entvehRegNo=vehicle.vehicleRegistrationNo inner join truckways.truckinfo on truckinfo.truckId=vehicle.vehicleName where actType='Enterprise' and enterpriseCustomerId='"+entCustomerId+"'";
		
		return template.query(sql, new ResultSetExtractor<List<EnterpriseVehicleStatus>>() {

			public List<EnterpriseVehicleStatus> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<EnterpriseVehicleStatus> ps = new ArrayList<EnterpriseVehicleStatus>();
				
				while(rs.next()) {
					EnterpriseVehicleStatus ent=new EnterpriseVehicleStatus();
					
					ent.setVehicelRegNo(rs.getString("vehicleRegistrationNo"));
					ent.setVehicleType(rs.getString("truckName"));
					ent.setCurrentLat(rs.getDouble("currentLat"));
					ent.setCurrentLong(rs.getDouble("currentLong"));
					
					ps.add(ent);
				} 

				
				
				return ps;
			}
		});
	}
	
	@Override
	public List<EnterpriseTripDetails> getOdometerReadings(String fromDate, String toDate, String vehicleRegNo) {

		
		String sql="select entvehicledetails.entVehDetailsId,entrtripdate,startReading,startReadingTime,endReading,endReadingTime,driverId from truckways.entrtripdetails inner join truckways.entvehicledetails on entrtripdetails.entVehDetailsId=entvehicledetails.entVehDetailsId inner join truckways.vehicle on vehicle.vehicleRegistrationNo=entvehicledetails.entvehRegNo  where date(entrtripdate) between '"+fromDate+"' and '"+toDate+"' and entvehRegNo='"+vehicleRegNo+"'";
		
		return template.query(sql, new ResultSetExtractor<List<EnterpriseTripDetails>>() {

			public List<EnterpriseTripDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<EnterpriseTripDetails> ps = new ArrayList<EnterpriseTripDetails>();
				
				while(rs.next()) {
					EnterpriseTripDetails ent=new EnterpriseTripDetails();
					
					ent.setStartReading(rs.getFloat("startReading"));
					ent.setStartReadingTime(rs.getString("startReadingTime"));
					ent.setEndReading(rs.getFloat("endReading"));
					ent.setEndReadingTime(rs.getString("endReadingTime"));
					ent.setTripDate(rs.getString("entrtripdate"));
					ent.setDriverId(rs.getInt("driverId"));
					ent.setEnterpriseCustomerId(rs.getInt("entVehDetailsId"));
					ps.add(ent);
				} 

				
				
				return ps;
			}
		});

	
	
	}




	@Override
	public EnterpriseOdometer getEnterpriseOdomterinformation(String vehicleRegNo) {
		EnterpriseOdometer ent = new EnterpriseOdometer();
		try{
		String sql="select EnterpriseId,enterpriseName,contactPerson,contactNumber,entvehRegNo,truckName,driverName,mobile from truckways.enterprisecustomer inner join truckways.entvehicledetails  on enterprisecustomer.EnterpriseId=entvehicledetails.enterpriseCustomerId inner join truckways.truckinfo on truckinfo.truckId=entvehicledetails.vehicleType inner join truckways.vehicle on vehicle.vehicleRegistrationNo=entvehicledetails.entvehRegNo inner join truckways.localdriver on localdriver.localDriverId=vehicle.driverId where entvehRegNo='"+vehicleRegNo+"'";
		
		return template.query(sql, new ResultSetExtractor<EnterpriseOdometer>() {

			public EnterpriseOdometer extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if (rs.next()) {

					ent.setEnterpriseId(rs.getInt("EnterpriseId"));
					ent.setEnterpriseName(rs.getString("enterpriseName"));
					ent.setContactPerson(rs.getString("contactPerson"));
					ent.setContactMobile(rs.getString("contactNumber"));
					ent.setDriverName(rs.getString("driverName"));
					ent.setDriverMobileNo(rs.getString("mobile"));
					ent.setTruckName(rs.getString("truckName"));
					ent.setVehicleRegNo(rs.getString("entvehRegNo"));
				
					Log.info("Enterprise Found");
					return ent;
					} 

					
					
					return ent;
			}
		});
	
		} catch(Exception e){
		
			return ent;
		}
	}




	@Override
	public EnterpriseTripDetails getEnterpriseOdometerReadings(String tripdate, int entvehicleId) {
		
		EnterpriseTripDetails ent=new EnterpriseTripDetails();
		try{
			String sql="select startReading,endReading,todayKms,distanceTravelled,balanceKms,entrtripdate from truckways.entrtripdetails where date(entrtripdate)='"+tripdate+"' and entVehDetailsId='"+entvehicleId+"'";
			
			return template.query(sql, new ResultSetExtractor<EnterpriseTripDetails>() {

				public EnterpriseTripDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					if (rs.next()) {

						ent.setStartReading(rs.getFloat("startReading"));
						ent.setEndReading(rs.getFloat("endReading"));
						ent.setTodayKm(rs.getInt("todayKms"));
						ent.setDistanceTravelled(rs.getInt("distanceTravelled"));
						ent.setBalanceKm(rs.getInt("balanceKms"));
						ent.setTripDate(rs.getString("entrtripdate"));
						
						
						
						Log.info("Enterprise Found");
						return ent;
						} 

						
						
						return ent;
				}
			});
		
			} catch(Exception e){
			
				return ent;
			}
		}




	@Override
	public int updateEnterprisedetails(float start, float end, float distance, float balance, float todayKm,
			String tripDate, int entvehicleId) {


		String sql="update truckways.entrtripdetails set startReading='"+start+"',endReading='"+end+"',todayKms='"+todayKm+"',distanceTravelled='"+distance+"',balanceKms='"+balance+"' where date(entrtripdate)='"+tripDate+"' and entVehDetailsId='"+entvehicleId+"'";
		
		return template.update(sql);
	}




	@Override
	public int getminimumBalanceKm(int entvehicleId) {
	
		String sql ="Select min(balanceKms)as balanceKM from truckways.entrtripdetails where entVehDetailsId='"+entvehicleId+"'";
		
		return template.query(sql, new ResultSetExtractor<Integer>() {

	public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

		int balanceKm = 0;
		if (rs.next()) {

			balanceKm = rs.getInt("balanceKM");

			return balanceKm;
		}

		return balanceKm = 0;
	}
});
	}




	@Override
	public int getMaxDistanceTravelled(int entvehicleId) {
		
		String sql ="Select max(distanceTravelled)as distance from truckways.entrtripdetails where entVehDetailsId='"+entvehicleId+"'";
		
		return template.query(sql, new ResultSetExtractor<Integer>() {

	public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

		int distance = 0;
		if (rs.next()) {

			distance = rs.getInt("distance");

			return distance;
		}

		return distance = 0;
		}
		});
}




	@Override
	public List<LiveTracking> getVehicleTracking(String vehicleRegNo, String date) {

		
		String sql="SELECT *,latitude as lat,longitude as lng,Time(currentDate) as currentTime FROM truckways.locationvehicle where driverId=(select driverId from truckways.vehicle where vehicleRegistrationNo='"+vehicleRegNo+"') and date(currentDate) ='"+date+"' order by currentDate asc";
		
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
	public int saveSeoImageInformation(SeoFile seo,InputStream str) {
		
		LocalDateTime dt=LocalDateTime.now().withNano(0);
		seo.setUploadDate(dt.toString());
		
		String sql="insert into truckways.seo(title,content,image,uploadDate) values(?,?,?,?)";
		
		return template.execute(sql,new PreparedStatementCallback<Integer>(){  
		    
			@Override  
		    public Integer doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		              
		        ps.setString(1,seo.getTitle());
		        ps.setString(2, seo.getContent());
		        ps.setBytes(3,seo.getData());  
		        ps.setString(4,seo.getUploadDate());
		        ps.execute();      
		        return  1;
		              
		    }  
		    });  
	}




	@Override
	public  byte[]  getImageFromDatabase(int imageId) {
		
		byte b[]=new byte[5];
		String sql="SELECT * FROM truckways.seo where seoImageId='"+imageId+"'";
		
		return template.query(sql, new ResultSetExtractor<byte[]>() {

			public byte[] extractData(ResultSet rs) throws SQLException, DataAccessException {
			
				if(rs.next()) {
					
					Blob blob=(Blob) rs.getBlob("image");
					
					return	blob.getBytes(1,(int) blob.length());
					
				} 

				return b;
				
			
			}
		});

	}




	@Override
	public List<SeoFile> getAllSeoImagesAndData() {

		
		String sql="SELECT * FROM truckways.seo";
		
		return template.query(sql, new ResultSetExtractor<List<SeoFile>>() {

			public List<SeoFile> extractData(ResultSet rs) throws SQLException, DataAccessException {
			

				List<SeoFile> ps = new ArrayList<SeoFile>();
				
				while(rs.next()) {
					SeoFile sf=new SeoFile();
					
					sf.setImageId(rs.getInt("seoImageId"));
					sf.setContent(rs.getString("content"));
					sf.setTitle(rs.getString("title"));
					sf.setUploadDate(rs.getString("uploadDate"));
					ps.add(sf);
					
				} 

				
				
				return ps;
			}
		});

	
	}




	@Override
	public int updateSeoInformation(SeoFile seo) {
	

		LocalDateTime dt=LocalDateTime.now().withNano(0);
		seo.setUploadDate(dt.toString());
		
		String sql="update truckways.seo  set title='"+seo.getTitle()+"',content='"+seo.getContent()+"',uploadDate='"+seo.getUploadDate()+"' where seoImageId='"+seo.getImageId()+"'";
		
		return template.update(sql);
		
	}




	@Override
	public int deleteImages(int imageId) {
		
		String sql="delete From truckways.seo where seoImageId='"+imageId+"'";
		
		return template.update(sql);
	}


	
	
	
	


}
