package com.cogzy.gtruckways.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;
import com.cogzy.gtruckways.dao.EnterpriseCustomerDao;

public class EnterpriseCustomerDaoImpl implements EnterpriseCustomerDao {

	JdbcTemplate template;  
	 
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	
	@Override
	public int saveEnterpriseCustomerDetails(EnterpriseCustomer ec) {
		
		String sql="insert into truckways.enterprisecustomer(enterpriseName,contactPerson,contactNumber,email,address,registeredDate,status) values('"+ec.getEnterpriseName()+"','"+ec.getContactPerson()+"','"+ec.getContactNumber()+"','"+ec.getEmail()+"','"+ec.getAddress()+"','"+ec.getRegDate()+"','"+ec.getStatus()+"')";  
		  
	    return template.update(sql); 
	}

	@Override
	public List<EnterpriseCustomer> getEnterpriseDetails() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM truckways.enterprisecustomer"; 
		   
		   return template.query(sql, new ResultSetExtractor<List<EnterpriseCustomer>>() {  


			        @Override
			        public List<EnterpriseCustomer> extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	ArrayList<EnterpriseCustomer> ps = new ArrayList<EnterpriseCustomer>();
			        	while (rs.next()) {
			        		EnterpriseCustomer ec= new EnterpriseCustomer();
			            	ec.setEnterpriseCustomerId(rs.getInt("EnterpriseId"));
			            	ec.setEnterpriseName(rs.getString("enterpriseName"));
			            	ec.setContactPerson(rs.getString("contactPerson"));
			            	ec.setContactNumber(rs.getString("contactNumber"));
			            	ec.setEmail(rs.getString("email"));
			            	ec.setAddress(rs.getString("address"));
			            	ps.add(ec);
			            }
			 
			            return ps;
			        }
			 
			    });
			}

	@Override
	public int checkDuplicateEnterprise(String mobile, String email,String enterpriseName) {
		String sql="SELECT * FROM truckways.enterprisecustomer where (contactNumber='"+mobile+"' or email='"+email+"' or enterpriseName='"+enterpriseName+"') and status='1'"; 
		   
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
	}
	
	@Override
	public boolean checkMobile(String mobileNo) {
		String sql="SELECT * FROM truckways.enterprisecustomer where contactNumber='"+mobileNo+"' "; 
		   
		   return template.query(sql, new ResultSetExtractor<Boolean>() {  


			        @Override
			        public Boolean extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	ArrayList<EnterpriseCustomer> ps = new ArrayList<EnterpriseCustomer>();
			        	while (rs.next()) {
			        		return true;
			            }
			 
			            return false;
			        }
			 
			    });
	}

	@Override
	public boolean checkEmail(String Eemail) {
		String sql="SELECT * FROM truckways.enterprisecustomer where email='"+Eemail+"' "; 
		   
		   return template.query(sql, new ResultSetExtractor<Boolean>() {  


			        @Override
			        public Boolean extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        	while (rs.next()) {
			        		return true;
			            }
			 
			            return false;
			        }
			 
			    });
	}
	
	
	
	
	public String checkEmailLink(String saltString) {
		String sql="SELECT * FROM truckways.enterprisecustomer where forgotpasscode='"+saltString+"' "; 
		   
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
	public EnterpriseCustomer getEnterpriseLoginInfo(String email, String password) {

		EnterpriseCustomer ec= new EnterpriseCustomer();
	try{
		
		String sql="SELECT * FROM truckways.enterprisecustomer where email='"+email+"' and password='"+password+"'"; 
		   
		   return template.query(sql, new ResultSetExtractor<EnterpriseCustomer>() {  


			        @Override
			        public EnterpriseCustomer extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        
			        	if (rs.next()) {
			        	
			            	ec.setEnterpriseCustomerId(rs.getInt("EnterpriseId"));
			            	ec.setEnterpriseName(rs.getString("enterpriseName"));
			            	ec.setContactPerson(rs.getString("contactPerson"));
			            	ec.setContactNumber(rs.getString("contactNumber"));
			            	ec.setEmail(rs.getString("email"));
			            	ec.setAddress(rs.getString("address"));
			            	ec.setPassword(rs.getString("password"));
			            	return ec;
			            } else{
			            		ec.setEnterpriseCustomerId(rs.getInt(999));
			            return ec;
			            }
			         }
			 
			    });
			}

	 catch(Exception e){
		 
		 ec.setEnterpriseCustomerId(999);
         return ec;
			
		}
	}

	@Override
	public EnterpriseCustomer getEnterPriseDetails(int enterpriseId) {
		// TODO Auto-generated method stub
		
		EnterpriseCustomer ec=new EnterpriseCustomer();
		try{
			
			String sql="SELECT * FROM truckways.enterprisecustomer where EnterpriseId='"+enterpriseId+"'"; 
			   
			   return template.query(sql, new ResultSetExtractor<EnterpriseCustomer>() {  


				        @Override
				        public EnterpriseCustomer extractData(ResultSet rs) throws SQLException,
				                DataAccessException {
				        
				        	if (rs.next()) {
				        	
				            	ec.setEnterpriseCustomerId(rs.getInt("EnterpriseId"));
				            	ec.setEnterpriseName(rs.getString("enterpriseName"));
				            	ec.setContactPerson(rs.getString("contactPerson"));
				            	ec.setContactNumber(rs.getString("contactNumber"));
				            	ec.setEmail(rs.getString("email"));
				            	ec.setAddress(rs.getString("address"));
				            	ec.setPassword(rs.getString("password"));
				            	return ec;
				            } else{
				            		ec.setEnterpriseCustomerId(rs.getInt(999));
				            return ec;
				            }
				         }
				 
				    });
				}

		 catch(Exception e){
			 
			 ec.setEnterpriseCustomerId(999);
	         return ec;
				
			}
		}

	@Override
	public int updateEnterPrisePassword(int enterpriseId, String password) {
		String sql="update truckways.enterprisecustomer set password='"+password+"' where EnterpriseId='"+enterpriseId+"'"; 
		   
		   return template.update(sql);
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
					ent.setNoOfKms(rs.getInt("noKms"));
					ent.setNoOfhoursPerDay(rs.getInt("noHrs"));
					ent.setNoOfDays(rs.getInt("daysRequired"));
					ent.setTravelledKm(rs.getInt("distanceTraveled"));
					ent.setRemainingKm(rs.getInt("balanceKm"));
					ps.add(ent);
				} 

				
				
				return ps;
			}
		});
	}

@Override
public EnterpriseCustomer getEnterPriseDetails(String email) {
	// TODO Auto-generated method stub
	
	EnterpriseCustomer ec=new EnterpriseCustomer();
	try{
		
		String sql="SELECT * FROM truckways.enterprisecustomer where email='"+email+"'"; 
		   
		   return template.query(sql, new ResultSetExtractor<EnterpriseCustomer>() {  


			        @Override
			        public EnterpriseCustomer extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        
			        	if (rs.next()) {
			        	
			            	ec.setEnterpriseCustomerId(rs.getInt("EnterpriseId"));
			            	ec.setEnterpriseName(rs.getString("enterpriseName"));
			            	ec.setContactPerson(rs.getString("contactPerson"));
			            	ec.setContactNumber(rs.getString("contactNumber"));
			            	ec.setEmail(rs.getString("email"));
			            	ec.setAddress(rs.getString("address"));
			            	return ec;
			            } else{
			            		ec.setEnterpriseCustomerId(rs.getInt(999));
			            return ec;
			            }
			         }
			 
			    });
			}

	 catch(Exception e){
		 
		 ec.setEnterpriseCustomerId(999);
         return ec;
			
		}
	}
@Override
public int updateEnterPriseforgotPassword(String enterpriseEmail, String password) {
	
	String sql="update truckways.enterprisecustomer set password='"+password+"',forgotpasscode='AAAA' where email='"+enterpriseEmail+"'"; 
   
	return template.update(sql);
}

@Override
public int updateEnterprsieResetPasswordSaltString(String email,String saltString) {
	

	String sql="update truckways.enterprisecustomer set forgotpasscode='"+saltString+"' where email='"+email+"'"; 
   
	return template.update(sql);
	
	
}
	
	


}


