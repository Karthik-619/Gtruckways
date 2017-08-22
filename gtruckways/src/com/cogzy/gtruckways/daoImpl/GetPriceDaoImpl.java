package com.cogzy.gtruckways.daoImpl;

import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cogzy.gtruckways.businessObjects.PromoCode;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.dao.GetPriceDao;


//@Component
public class GetPriceDaoImpl implements GetPriceDao {

	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	} 

	
  
	public TruckInfo getTruckInformation(int truckId) {
	   
		String sql = "SELECT * FROM truckways.truckinfo where truckId='"+truckId+"'";;
	    
	    
	    return template.query(sql, new ResultSetExtractor<TruckInfo>() {
	 
	    
	        public TruckInfo extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        	
	        	TruckInfo tr = new TruckInfo();
	        	
	        	if (rs.next()) {
	            	
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
	               
	            	return tr;
	            }
	        	tr.setTruckId(0);
	            return tr;
	        }
	 
	    });
	}
	
	@Override
	 public float ajaxGetPrice(String trkType) {
	   String sql = "SELECT basePrice FROM truckways.truckinfo where truckName='"+trkType+"'";;
	      return template.query(sql, new ResultSetExtractor<Float>() {
	   
	      
	          public Float extractData(ResultSet rs) throws SQLException,
	                  DataAccessException {
	              if (rs.next()) {
	               
	               float amt=rs.getFloat("basePrice");
	               
	                  return amt;
	              }
	   
	              return 0.0f;
	          }
	   
	      });
	 }
	
	@Override
	 public int getTrcukId(String VehicleName) {
	 
		String sql = "select truckId from truckways.truckinfo where truckName='"+VehicleName+"'";
	     
		try {   
	      return template.query(sql, new ResultSetExtractor<Integer>() {
	   
	      public Integer extractData(ResultSet rs) throws SQLException,
	                  DataAccessException {
	      
	    	  if(rs.next()){
	         
	    		  	int truckId=rs.getInt("truckId");
	    		  	return truckId;
	    	  		}
	    	  return 404;
	      		}
	      
	         });
	         } catch (EmptyResultDataAccessException e) {
	          return 404;
	         }
	   }

	@Override
	public List<TruckInfo> getAllVehicleTypes() {
		 String sql = "SELECT * FROM truckways.truckinfo where truckId=1 or truckId=2";
		    return template.query(sql, new ResultSetExtractor<List<TruckInfo>>() {
		 
		    
		        public List<TruckInfo> extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        	List<TruckInfo> vehicle=new ArrayList<TruckInfo>();
		            while (rs.next()) {
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
		               vehicle.add(tr);
		            }
		 
		            return vehicle;
		        }
		 
		    });
	}
	@Override
	public List<String> getAllMaterials() {
		 
		String sql = "SELECT materialName FROM truckways.materialsforlocal";
		    return template.query(sql, new ResultSetExtractor<List<String>>() {
		 
		    
		        public List<String> extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		        	List<String> mat=new ArrayList<String>();
		            while (rs.next()) {
		            	String materialName=rs.getString("materialName");
		       
		               mat.add(materialName);
		            }
		 
		            return mat;
		        }
		 
		    });
	}



	@Override
	public PromoCode CheckPromoCodeExistsOrNot(String promoCode) {
		 String sql = "SELECT * FROM truckways.promocode where promoCode='"+promoCode+"'";
	      return template.query(sql, new ResultSetExtractor<PromoCode>() {
	   
	      
	          public PromoCode extractData(ResultSet rs) throws SQLException,
	                  DataAccessException {
	        	  PromoCode promo=new PromoCode();
	        	  
	        	  if (rs.next()) {
	               
	            	
	            	  promo.setPromoCode(rs.getString("promoCode"));
	            	  promo.setDiscountPercent(rs.getFloat("discountPercent"));
	            	  promo.setFromDate(rs.getString("fromDate"));
	            	  promo.setToDate(rs.getString("toDate"));
	            	  promo.setPromoActive(true);
	            	  
	                  return promo;
	              }
	        	  promo.setPromoActive(false);
	              return promo;
	          }
	   
	      });

	}



   
}
