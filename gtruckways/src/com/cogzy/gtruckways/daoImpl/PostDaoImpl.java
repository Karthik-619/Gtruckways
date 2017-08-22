package com.cogzy.gtruckways.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.dao.PostDao;
import com.cogzy.gtruckways.validator.Log;

public class PostDaoImpl implements PostDao {
	

	JdbcTemplate template;  
	 
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}

	
	@Override
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
	
	
	
public int savepostdetails(Post pos) {
		
		
		Log.info("StoringPostdetails-->UserId-->"+ pos.getUser().getUserId()+"FromCity-->"+pos.getPrice().getRoute().getFromCity());
		
		String sql="insert into truckways.postdetail(postId,refPostId,userId,fromCity,toCity,material,postDate,travelDate,pickUp,dropArea,helper,truckId,status,recipientName,recipientMobile, approxKm,approxMins,approxAmount,totalAmount,sourceLat,sourceLong,destLat,destLong,valueOfGoods,approximateWeight,promocode,discountAmount,baseFare,freeKm,freeMins,slab1Price,slab2Price,gstAmount,bookedThrough,gstNumber) values('"+pos.getInvoiceId()+"','"+pos.getBookingId()+"','"+pos.getUser().getUserId()+"','"+pos.getPrice().getRoute().getFromCity()+"','"+pos.getPrice().getRoute().getToCity()+"','"+pos.getMaterial()+"','"+pos.getPostDate()+"','"+pos.getTravelDate()+"','"+pos.getPickUpArea()+"','"+pos.getDropArea()+"','"+pos.getHelper()+"','"+pos.getPrice().getInfo().getTruckId()+"','"+pos.getStatus()+"','"+pos.getRecepientName()+"','"+pos.getRecepientMobile()+"','"+pos.getPrice().getTotalDistanceKm()+"' ,'"+pos.getPrice().getTotalMins()+"','"+pos.getApproximateAmount()+"','"+pos.getTotalAmount()+"','"+pos.getPrice().getRoute().getsLat()+"','"+pos.getPrice().getRoute().getsLong()+"','"+pos.getPrice().getRoute().getdLat()+"','"+pos.getPrice().getRoute().getdLong()+"','"+pos.getValueOfGoods()+"','"+pos.getApproximateWeight()+"','"+pos.getPromocode()+"','"+pos.getDiscountAmount()+"','"+pos.getPrice().getInfo().getBasePrice()+"','"+pos.getPrice().getInfo().getFreeKm()+"','"+pos.getPrice().getInfo().getFreeMins()+"','"+pos.getPrice().getInfo().getAdditionalPrice()+"','"+pos.getPrice().getInfo().getSecondPrice()+"','"+pos.getGstAmount()+"','"+pos.getBookedThrough()+"','"+pos.getUser().getGstNumber()+"')";  
		  
	    return template.update(sql);   
	}

	
	public Post getPostDetails(String postid) {
		
		
		String sql="SELECT * from truckways.user inner join truckways.postdetail on postdetail.userId=user.userId where refPostId='"+postid+"' ";  
		   
		   return template.query(sql, new ResultSetExtractor<Post>() {  


			    
			        public Post extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			            if (rs.next()) {
			            	Post pos=new Post();
			            	pos.setBookingId(rs.getString("refPostId"));
			            	pos.setInvoiceId(rs.getInt("postId"));
			            	pos.setPostDate(rs.getString("postDate"));
			            	pos.setTravelDate(rs.getString("travelDate"));
			            	pos.setTotalAmount(rs.getFloat("totalAmount"));
			            	pos.setMaterial(rs.getString("material"));
			            	String fromCity=rs.getString("fromCity");
			            	String toCity=rs.getString("toCity");
			            	String username=rs.getString("userName");
			            	String email=rs.getString("email");
			            	int userId=rs.getInt("userId");
			            	int userStatus=rs.getInt("userStatus");
			            	String password=rs.getString("password");
			            	Route route=new Route();
			            	route.setFromCity(fromCity);
			            	route.setToCity(toCity);
			            	Price price=new Price();
			            	price.setRoute(route);
			            	User use =new User();
			            	use.setMobileNo(rs.getString("mobileNo"));
			            	use.setUserName(username);
			            	use.setEmail(email);
			            	use.setUserId(userId);
			            	use.setUserStatus(userStatus);
			            	use.setPassword(password);
			            	use.setUserType("Customer");
			            	pos.setPrice(price);
			            	pos.setUser(use);
			            	return pos;
			            }
			 
			            return null;
			        }
			 
			    });
			}
		 
		
	
	@Override
	public Post getTrackPostDetails(String postid, String mobile) {
		
		String sql="SELECT * from truckways.user inner join truckways.postdetail on postdetail.userId=user.userId inner join truckways.truckinfo  on postdetail.truckId=truckinfo.truckId where refPostId='"+postid+"' and mobileNo='"+mobile+"' ";  
		   
		   return template.query(sql, new ResultSetExtractor<Post>() {  


			        @Override
			        public Post extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			            if (rs.next()) {
			            	Post pos=new Post();
			            	pos.setRefPostId(rs.getString("refPostId"));
			            	pos.setPostId(rs.getInt("postId"));
			            	pos.setStatus(rs.getString("status"));
			            	pos.setPostDate(rs.getString("postDate"));
			            	pos.setTravelDate(rs.getString("travelDate"));
			            	pos.setTotalAmount(rs.getFloat("totalAmount"));
			            	pos.setHelper(rs.getInt("helper"));
			            	pos.setMaterial(rs.getString("material"));
			            	pos.setPickUpArea(rs.getString("pickUp"));
			            	pos.setDropArea(rs.getString("dropArea"));
			            	String fromCity=rs.getString("fromCity");
			            	String toCity=rs.getString("toCity");
			            	String username=rs.getString("userName");
			            	String email=rs.getString("email");
			            	String mobile=rs.getString("mobileNo");
			            	String truckName=rs.getString("truckName");
			            	int userId=rs.getInt("userId");
			            	TruckInfo info=new TruckInfo();
			            	info.setTruckName(truckName);
			            	Route route=new Route();
			            	route.setFromCity(fromCity);
			            	route.setToCity(toCity);
			            	Price price=new Price();
			            	price.setRoute(route);
			            	price.setInfo(info);
			            	User use =new User();
			            	use.setUserName(username);
			            	use.setMobileNo(mobile);
			            	use.setEmail(email);
			            	use.setUserId(userId);
			            	
			            	
			            	pos.setPrice(price);
			            	pos.setUser(use);
			            	return pos;
			            }
			            else{
			            	System.out.println("outside rs.next()");
			            	 return null;
			            }
			        }
			 
			    });
			}
	

	@Override
	public List<Post> getUserPostDetails(User use) {
		
		
		String sql="SELECT * FROM truckways.postdetail inner join truckways.truckinfo  on postdetail.truckId=truckinfo.truckId inner join truckways.user on postdetail.userId=user.userId where postdetail.userId='"+use.getUserId()+"'"; 
		   
		   return template.query(sql, new ResultSetExtractor<List<Post>>() {  


			        @Override
			        public List<Post> extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	ArrayList<Post> ps = new ArrayList<Post>();
			        	while (rs.next()) {
			            	Post pos=new Post();
			            	
			            	pos.setInvoiceId(rs.getInt("postId"));
			            	pos.setBookingId(rs.getString("refPostId"));
			            	pos.setPostDate(rs.getString("postDate"));
			            	pos.setTravelDate(rs.getString("travelDate"));
			            	pos.setTotalAmount(rs.getFloat("totalAmount"));
			            	pos.setMaterial(rs.getString("material"));
			 
			            	pos.setHelper(rs.getInt("helper"));
			            	pos.setStatus(rs.getString("status"));
			            	String truckName=rs.getString("truckName");
			            	String fromCity=rs.getString("fromCity");
			            	String toCity=rs.getString("toCity");
			            	String username=rs.getString("userName");
			            	String email=rs.getString("email");
			            	String mobile=rs.getString("mobileNo");
			            	TruckInfo info=new TruckInfo();
			            	info.setTruckName(truckName);
			            	Route route=new Route();
			            	Price price=new Price();
			            	route.setFromCity(fromCity);
			            	route.setToCity(toCity);
			            	price.setInfo(info);
			            	price.setRoute(route);
			            	
			            	pos.setPrice(price);
			            	User use =new User();
			            	use.setUserName(username);
			            	use.setEmail(email);
			            	use.setMobileNo(mobile);
			            	pos.setUser(use);
			            
			            	ps.add(pos);
			            }
			 
			            return ps;
			       }
			 
			});
	}
		
	
	@Override
	public int cancelPost(String PostId) {
		
		 String sql="update truckways.postdetail set status='Canceled' where refPostId='"+PostId+"'"; 
		  
		    return template.update(sql);  
	}


	@Override
	public boolean chkLogMob(String Logmobile) {
		String sql="SELECT * FROM truckways.user where mobileNo='"+Logmobile+"' "; 
		   
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
	
	
	
	

	public boolean chkEmailId(String email) {
		
		String sql="SELECT * FROM truckways.user where email='"+email+"' "; 
		   
		   return template.query(sql, new ResultSetExtractor<Boolean>() {  


			        @Override
			        public Boolean extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			        	
			        	if (rs.next()) {
			        		
			        		return true;
			            }
			 
			            return false;
			        }
			 
			    });
		}
	
	
	
	
	
	
}
