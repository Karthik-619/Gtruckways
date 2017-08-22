package com.cogzy.gtruckways.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.cogzy.gtruckways.businessObjects.DistancePojo;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.PromoCode;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.dao.UserDao;
import com.cogzy.gtruckways.daoImpl.GetPriceDaoImpl;
import com.cogzy.gtruckways.daoImpl.UserDaoImpl;
import com.cogzy.gtruckways.service.GetPriceService;
import com.cogzy.gtruckways.validator.Log;
import com.google.gson.Gson;

//@Service

@Configuration
@PropertySource(value="/price.properties",ignoreResourceNotFound=true)
public class GetPriceServiceImpl implements GetPriceService {

// @Autowired
 GetPriceDaoImpl dao;

 
 @Autowired
 private Environment env;

	public GetPriceDaoImpl getDao() {
	return dao;
}

private static Logger log = Logger.getLogger(Log.class.getName());

public void setDao(GetPriceDaoImpl dao) {
	this.dao = dao;
}


	public Route getGoogleDistanceAndTime(String fromCity, String toCity){
		
		String distance="";
		String time="";
		
		Route rt=new Route();
	try{	
	        	
        	 URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins='"+URLEncoder.encode(fromCity, "UTF-8")+"'&destinations='"+URLEncoder.encode(toCity, "UTF-8")+"'&mode=driving&language=English&key=AIzaSyCmJHLcZ_RKWYEGf1qHSOqMrtlrcXXyJn8");
             
    
             
        	 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setRequestMethod("GET");
             String line, outputString = "";
             BufferedReader reader = new BufferedReader(
             new InputStreamReader(conn.getInputStream()));
             while ((line = reader.readLine()) != null) 
             {
                 outputString += line;
             }
            
             Gson ob=new Gson();
             DistancePojo capRes = ob.fromJson(outputString, DistancePojo.class);
             
             JSONObject json = new JSONObject(outputString);
             json.get("rows");
             
             json.get("destination_addresses");
             String origin=json.get("origin_addresses").toString();
             JSONArray arr=null;
            
             arr = json.getJSONArray("rows");
            
             
             
             distance =(String)arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getString("text");
          
             time=(String)arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text");
       
             
      
             
             String sourceLatLongs[] = getLatLongPositions(fromCity);
             String destLatLongs[]=getLatLongPositions(toCity);
             
             double sLat=Double.parseDouble(sourceLatLongs[0]);
             double sLong=Double.parseDouble(sourceLatLongs[1]);
             double dLat=Double.parseDouble(destLatLongs[0]);
             double dLong=Double.parseDouble(destLatLongs[1]);
			
             
             
             
			 String[] part = distance.split(" ");
			  float dist=Float.parseFloat(part[0]);	 
			 
			  float googleDistance=0;
				 
			  if(distance.contains("k")){
	        	  
				  googleDistance=dist;
	          } else{
	        	  
	        	  googleDistance=(float) (dist* 0.001);
	        	  
	          }
			  
			  
		   
			 
		
		 rt.setFromCity(fromCity);
		 rt.setToCity(toCity);
		 rt.setDistance(googleDistance);
		 int time_in_mins=rt.getMinutes(time);
		 rt.setsLat(sLat);
		 rt.setsLong(sLong);
		 rt.setdLat(dLat);
		 rt.setdLong(dLong);
		 rt.setTime(time_in_mins);
		 Log.info("GetPriceServiceImpl-->From Google API-->ApproximateDistance-->"+googleDistance+"-->Approximate Km-->"+time_in_mins);     
		return rt;
		
		
	}catch(Exception e){
		
		 rt.setDistance(0);
		 rt.setFromCity("");
		 rt.setToCity("");
		 return rt;
	} 
	
	}


	public TruckInfo getTruckInformationDetails(String truckId) {
		
		TruckInfo info=new TruckInfo();
		try{
		
		int td=Integer.parseInt(truckId);	
		info=dao.getTruckInformation(td);
		
		return info;
		
		
		} catch(Exception e ){
			
			return info;
		}
	}


	public Price getTotalAmount(Route route, TruckInfo info) {
		  
		  int time_in_mins=0;
		  float distance=route.getDistance();
		  float totalDistance=route.getDistance();
			
		  time_in_mins=route.getTime();
		  Price pir=new Price(); 
		    
		float extraKm=0;
		 float extraDistance=0;
		 float totalAmount=0;  
		    
		 float extraTimeAmount=0;
		 float extraKmAmount=0;
		 
		
		 float basePrice=info.getBasePrice();
		 
		 
		  try{
			  
			  if(info.getTruckId()==1||info.getTruckId()==6){
				  
				
				  Log.info("GetPriceServiceImpl-->Tata Ace  Vehicle-->"+route.getTime());
				
				  time_in_mins=route.getTime();
				 
				  Log.info("GetPriceServiceImpl-->Tata Ace Vehicle-->"+time_in_mins+"Tata Ace Free Mins-->"+info.getFreeMins());	
				  
				  if(distance>info.getFreeKm() && time_in_mins>info.getFreeMins()){
					  
				   time_in_mins=time_in_mins-info.getFreeMins();
				   extraTimeAmount=time_in_mins*info.getAdditionalmins();
				   extraKm=distance-info.getFreeKm();
				  
				   Log.info("GetPriceServiceImpl-->TAta Ace Vehicle--> Both distance and mins greater");	  
				   
				  /* if(extraKm>info.getSlab2Km()){
					
					   Log.info("GetPriceServiceImpl-->TAta Ace Vehicle-->Distance greater than "+info.getSlab2Km()+" Km");	  
					   extraDistance=extraKm-info.getSlab2Km();
					   extraKmAmount=info.getSlab2Km()*info.getAdditionalPrice()+extraDistance*info.getSecondPrice();
					   info.setSlab1Km(info.getSlab2Km());  
						  
					  } else{*/
						  
						  Log.info("GetPriceServiceImpl-->Tata Ace  Vehicle-->Distance less than  Km");	  
						  extraKmAmount=extraKm*info.getAdditionalPrice();
						  info.setSlab1Km(extraKm);
					  
					  
					  totalAmount=basePrice+extraKmAmount+extraTimeAmount;
				   
				   
					  Log.info("GetPriceServiceImpl-->Tata Ace  Vehicle-->Amount111-->"+totalAmount);	
				   
				  	} else if(distance>info.getFreeKm()){
				  		
				  		time_in_mins=0;  
				  		extraTimeAmount=0;
				  		extraKm=distance-info.getFreeKm();
				  
				   	/*	if(extraKm>info.getSlab2Km()){
					
						  extraDistance=extraKm-info.getSlab2Km();
						  Log.info("GetPriceServiceImpl-->Tata Ace  Vehicle-->extradistance-->"+extraDistance);
						  extraKmAmount=info.getSlab2Km()*info.getAdditionalPrice()+extraDistance*info.getSecondPrice();
						  info.setSlab1Km(info.getSlab2Km());
						
					  } else{
						  */
						  extraKmAmount=extraKm*info.getAdditionalPrice();
						  info.setSlab1Km(extraKm);
						  
					  
					  totalAmount=basePrice+extraKmAmount+extraTimeAmount;
					 
				  	} else if(distance<=info.getFreeKm() && time_in_mins>info.getFreeMins()){
					  
				  		
				  	   time_in_mins=time_in_mins-info.getFreeMins();
					   extraTimeAmount=time_in_mins*info.getAdditionalmins();
					   extraKmAmount=0;
					   totalAmount=basePrice+extraKmAmount+extraTimeAmount;
					   info.setSlab1Km(0);
					  
					  
				  	} else {
				  	
				  	time_in_mins=0;
				  	extraTimeAmount=0;
				  	extraKmAmount=0;
				  	totalAmount=basePrice+extraKmAmount+extraTimeAmount;
				    info.setSlab1Km(0);
				  
				  	}
				  
				  	
			  
			  } else{
				  
				  Log.info("TAta 407  Vehicle");	
					  time_in_mins=route.getTime();
					 
				  if(distance>info.getFreeKm() && time_in_mins>info.getFreeMins()){
					  
					   time_in_mins=time_in_mins-info.getFreeMins();
					   extraTimeAmount=time_in_mins*info.getAdditionalmins();
					   extraKm=distance-info.getFreeKm();
						  
					   if(extraKm>info.getSlab2Km()){
						
							  extraDistance=extraKm-info.getSlab2Km();
							  extraKmAmount=info.getSlab2Km()*info.getAdditionalPrice()+extraDistance*info.getSecondPrice();
							  info.setSlab1Km(info.getSlab2Km());
							  
						  } else{
							  
							  extraKmAmount=extraKm*info.getAdditionalPrice();
							  info.setSlab1Km(extraKm);
						  }
						  
						  totalAmount=basePrice+extraKmAmount+extraTimeAmount;
						
					   
					   
					   
					  	} else if(distance>info.getFreeKm()){
					  		
					  		time_in_mins=0;  
					  		extraTimeAmount=0;
					  		extraKm=distance-info.getFreeKm();
					  
					   		if(extraKm>info.getSlab2Km()){
						
							  extraDistance=extraKm-info.getSlab2Km();
							  extraKmAmount=info.getSlab2Km()*info.getAdditionalPrice()+extraDistance*info.getSecondPrice();
							  info.setSlab1Km(info.getSlab2Km());
							  
						  } else{
							  
							  extraKmAmount=extraKm*info.getAdditionalPrice();
							  info.setSlab1Km(extraKm);
						  }
						  
						  totalAmount=basePrice+extraKmAmount+extraTimeAmount;
					  		
					
					  	} 
					  	
					 else if(distance<info.getFreeKm() && time_in_mins>info.getFreeMins()){
					  
			  		
						 time_in_mins=time_in_mins-info.getFreeMins();
						 extraTimeAmount=time_in_mins*info.getAdditionalmins();
						 extraKmAmount=0;
						 totalAmount=basePrice+extraKmAmount+extraTimeAmount;
						 info.setSlab1Km(0);
				  
					 }
					  	else{
					  	
					  	time_in_mins=0;  
					  	extraTimeAmount=0;
					  	extraKmAmount=0;
					  	totalAmount=basePrice+extraKmAmount+extraTimeAmount;
					  	info.setSlab1Km(0);
					  
					  	}
				  
				  
				  
				 
				  
				  
				  
			  }
			  
			  
			  
			   float totalMins=route.getTime();
			  
			   Log.info("ExtraKm-->"+extraKm);
			   LocalDate date=LocalDate.now();
			   LocalTime time=LocalTime.now().withNano(0);
			   String nextDay=date.plusDays(1).toString();
			   String serverDateTime=date.toString();
			   String serverTime=time.toString();
			   pir.setNextDate(nextDay);
			   pir.setServerTime(serverTime);
			   pir.setServerDate(serverDateTime);
			   pir.setExtraDistance(extraDistance);
			   pir.setExtraKm(extraKm);
			   pir.setExtraMins(time_in_mins);
			   pir.setExtraKmAmount(extraKmAmount);
			   pir.setExtraMinsAmount(extraTimeAmount);
			   pir.setApproximateAmount(totalAmount);
			   pir.setTotalAmount(totalAmount);
			   pir.setTotalDistanceKm(totalDistance);
			   pir.setTotalMins(totalMins);
			   pir.setRoute(route);
			   info.setBasePrice(basePrice);
			   pir.setInfo(info);
			   return pir;  
			  
			  
			  
			  
		  }  catch(Exception e){
			  
			  pir.setTotalAmount(0);
			  return pir;  
			  
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		/*  
		  try{

		   if(distance>2.0 && time_in_mins>60){
		    
			 if(truckId==1 || truckId==6 ||truckId==2)
		    {
		     time_in_mins=time_in_mins-60;
		    }
		    else if(time_in_mins>120){
		     time_in_mins=time_in_mins-120;
		    } else{
		    	time_in_mins=0;
		    }
		    
			 System.out.println("env valus--->"+env.getRequiredProperty("TataAce.FreeKm")+"-->407-->"+env.getRequiredProperty("Tata407.Slab2"));
			 
		    extraMins=(time_in_mins*100)/100;
		    
		    distance=distance-2.0f;
		    extraDistance=(distance*100)/100;
		    System.out.println("distance"+extraDistance);
		   totalAmount=Math.round((info.getBasePrice()+(extraDistance)*info.getAdditionalPrice()+(extraMins)*info.getAdditionalmins()));
		   
		   }
		   else if(distance>2){
			
			distance=distance-2.0f;
		    extraDistance=(distance*100)/100;
		    totalAmount=Math.round((info.getBasePrice()+(extraDistance)*info.getAdditionalPrice()));
		    System.out.println("distance"+extraDistance+"dist"+distance);
		   } else
		   
		   {
		    extraMins=0;
		    extraDistance=0;
		    totalAmount=Math.round((info.getBasePrice()));
		      }
		   
		   System.out.println("distance"+extraMins+"time"+extraDistance);
		   System.out.println("distance"+totalAmount+"time"+info.getBasePrice());
		     float totalMins=route.getTime();
		   
		  
		   pir.setExtraDistance(extraDistance);
		   pir.setExtraMins(extraMins);
		   pir.setTotalAmount(totalAmount);
		   pir.setTotalDistanceKm(totalDistance);
		   pir.setTotalMins(totalMins);
		   pir.setRoute(route);
		   pir.setInfo(info);
		   return pir;

		  } catch(Exception e){
			  
			  pir.setTotalAmount(0);
			  return pir;

		  }*/
		   
		 }

	
	public  String[] getLatLongPositions(String address) throws Exception
	  {
	    int responseCode = 0;
	    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true"; //&key=AIzaSyCmJHLcZ_RKWYEGf1qHSOqMrtlrcXXyJn8
	    System.out.println("URL : "+api);
	    URL url = new URL(api);
	    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
	    httpConnection.connect();
	    responseCode = httpConnection.getResponseCode();
	    if(responseCode == 200)
	    {
	    	
	      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	      Document document = builder.parse(httpConnection.getInputStream());
	      XPathFactory xPathfactory = XPathFactory.newInstance();
	      XPath xpath = xPathfactory.newXPath();
	      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
	      String status = (String)expr.evaluate(document, XPathConstants.STRING);
	      if(status.equals("OK"))
	      {
	         expr = xpath.compile("//geometry/location/lat");
	         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         expr = xpath.compile("//geometry/location/lng");
	         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         return new String[] {latitude, longitude};
	      }
	      else
	      {
	         throw new Exception("Error from the API - response status: "+status);
	      }
	    }
	    return null;
	  }	
	
	
	@Override
	 public float ajaxGetPrice(String trkType) {
	  float amt=dao.ajaxGetPrice(trkType);
	  return amt;
	 }
	
	@Override
	 public int getTrcukId(String trkType) {
	  int truckId=dao.getTrcukId(trkType);
	  return truckId;
	 }
	
	@Override
	public List<TruckInfo> getAllVehicleTypes() {
		
		List<TruckInfo> vehicleType=dao.getAllVehicleTypes();
		return vehicleType;
	}
	
	@Override
	public List<String> getAllMaterials() {
		
		List<String> materialName=dao.getAllMaterials();
		return materialName;
		
	}


	@Override
	public PromoCode CheckPromoCodeExistsOrNot(String promoCode,float totalAmount, Price price,String travelDate) {
		
		
		
		PromoCode promo=dao.CheckPromoCodeExistsOrNot(promoCode);
		int PromoCodeDistance=Integer.parseInt(env.getRequiredProperty("PromoCode.Distance"));
		Log.info("Promodistance-->"+PromoCodeDistance);
		if(promo.isPromoActive()){
			
		
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(travelDate, formatter);
			
			Log.info("TravelDate-->"+dateTime);
			
			DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
			int dayvalue=dayOfWeek.getValue();
			 int leanHour= dateTime.getHour();
			/*DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
			   int leanHour= LocalDateTime.now().getHour();
			  
			  String dayname=dayOfWeek.toString();
			  */
			Log.info("Day Name is-->"+dayvalue+"hour-->"+leanHour);
			
		boolean percent=containsDigit(promoCode);
	
		if(percent==true){
			
			Log.info("Promocode is Discount Percent");
			
			
			if(price.getTotalDistanceKm()>=PromoCodeDistance && dayvalue>=1 && dayvalue<=4){
			
						float discountAmount=(price.getInfo().getBasePrice()*promo.getDiscountPercent())/100;
						float amount=totalAmount-discountAmount;
						promo.setDiscountAmount(discountAmount);
						promo.setTotalAmount(amount);
						promo.setStatusCode(200);
						promo.setStatusMessage("<span style='color:green'>PromoCode Appplied Successfully</span>");
						return promo;
				}
		
			
					promo.setTotalAmount(totalAmount);
					promo.setStatusCode(404);
					promo.setDiscountAmount(0);
					promo.setPromoCode("Not Applied");
					promo.setStatusMessage("<span style='color:red'>This PromoCode is not Applicable For You</span>");
					return promo;
		
		
		}  else {
		
			if(price.getInfo().getTruckId()==1){
					
			  int leanDay=Integer.parseInt(env.getRequiredProperty("TataAce.LeanDay").trim());
			  int leanDayBasePrice=Integer.parseInt(env.getRequiredProperty("TataAce.LeanDay.BasePrice").trim());
			  int leanDayBaseHourPrice=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHour.BasePrice").trim());
			  Log.info("Promocode is Lean Day and Lean Hour1");	
			  int leanDayHourDay1=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHour.Day1").trim());
			  Log.info("Promocode is Lean Day and Lean Hour111");
			  int leanDayHourDay2=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHour.Day2").trim());
			 
			  Log.info("Promocode is Lean Day and Lean Hour2");
			  int leanDayHourFrom1=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHours.f1").trim());
			  int leanDayHourTo1=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHours.t1").trim());
			 
			  int leanDayHourFrom2=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHours.f2").trim());
			  int leanDayHourTo2=Integer.parseInt(env.getRequiredProperty("TataAce.LeanHours.t2").trim());	
			  float discountAmount=0;
			
			  Log.info("Promocode is Lean Day and Lean Hour3");	
			// Lean Day Promocode Functionality
			
			if(promoCode.equalsIgnoreCase(env.getRequiredProperty("Lean.Day.PromoCode").trim())){
						
				Log.info("Promocode is Lean Day");	 
						   
						 if(leanDay==dayvalue && leanDay!=0 ){
							  
							discountAmount=promo.getDiscountPercent();
						 
							float amount=totalAmount-discountAmount;
							promo.setDiscountAmount(discountAmount);
							promo.setTotalAmount(amount);
							promo.setStatusCode(200);
							promo.setStatusMessage("<span style='color:green'>The Discount of Rs "+discountAmount+" Appplied Successfully</span>");
							return promo;
						 
						 
						 }
						
					
					
						 	promo.setTotalAmount(totalAmount);
							promo.setStatusCode(404);
							promo.setDiscountAmount(0);
							promo.setPromoCode("Not Applied");
							promo.setStatusMessage("<span style='color:red'>This Promocode is not valid today </span>");
							return promo;
				// Lean Hours Promocode Functionality
			}else if(promoCode.equalsIgnoreCase(env.getRequiredProperty("Lean.Hours.PromoCode").trim())){	
			
				Log.info("Promocode is Lean hour");
				 if(dayvalue>=leanDayHourDay1 && dayvalue<=leanDayHourDay2){
					 
				  if(((leanHour>=leanDayHourFrom1 && leanHour<leanDayHourTo1) || (leanHour>=leanDayHourFrom2 && leanHour<leanDayHourTo2)) && (leanDayHourFrom1!=0 || leanDayHourTo1!=0) && (leanDayHourFrom2!=0 || leanDayHourTo2!=0)  ){
					Log.info("promocode lean hour-->"+leanHour+"dsfdj-->"+leanDayHourTo2);  
					discountAmount=promo.getDiscountPercent();
				  	
				 
			
				  float amount=totalAmount-discountAmount;
					promo.setDiscountAmount(discountAmount);
					promo.setTotalAmount(amount);
					promo.setStatusCode(200);
					promo.setStatusMessage("<span style='color:green'>The Discount of Rs "+discountAmount+" Appplied Successfully</span>");
					return promo;
				  
				  	}
				 }
			
			

				 	promo.setTotalAmount(totalAmount);
					promo.setStatusCode(404);
					promo.setDiscountAmount(0);
					promo.setPromoCode("Not Applied");
					promo.setStatusMessage("<span style='color:red'>This Promocode is not valid in this Hours </span>");
					return promo;
				 
				 
			
			
			} else  {
					
				Log.info("Other Promocode");
				float amount=totalAmount-promo.getDiscountPercent();
				promo.setDiscountAmount(promo.getDiscountPercent());
				promo.setTotalAmount(amount);
				promo.setStatusCode(200);
				promo.setStatusMessage("<span style='color:red'>Promocode Applied Successfully</span>");
				return promo;
		
				}	
			
		}else{
			
			promo.setTotalAmount(totalAmount);
			promo.setStatusCode(404);
			promo.setDiscountAmount(0);
			promo.setPromoCode("Not Applied");
			promo.setStatusMessage("<span style='color:red'>This PromoCode is not Applicable for You</span>");
			return promo;
			
		}
			
		}
		
			
			
			
		
		}	else{
			
			promo.setTotalAmount(totalAmount);
			promo.setStatusCode(404);
			promo.setDiscountAmount(0);
			promo.setPromoCode("Not Applied");
			promo.setStatusMessage("<span style='color:red'>PromoCode is Invalid</span>");
			return promo;
		}
		
		
	}
		
	
	
	
	
	
	public  boolean containsDigit(String s) {
	    if (s != null && !s.isEmpty()) {
	        for (char c : s.toCharArray()) {
	            if (Character.isDigit(c)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	
public Route getGoogleDistanceAndTimeUsingLatAndLong(double sLat,double sLong,double dLat, double dLong){
		
		String distance="";
		String time="";
		String s="";
		 
		log.info("DriverServiceImpl-->getGoogleDistanceAndTimeUsingLatAndLong-->Source Lat"+sLat+"-->Source Long-->"+sLong+"-->Destination Lat-->"+dLat+"-->Destination Long-->"+dLong);
		
	try{	
	        	
        	 URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+sLat+","+sLong+"&destinations="+dLat+","+dLong+"&mode=driving&language=English&key=AIzaSyCmJHLcZ_RKWYEGf1qHSOqMrtlrcXXyJn8");
             
        	// URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins='"+fromCity+"'&destinations='"+toCity+"'&mode=driving&language=English&key=AIzaSyCmJHLcZ_RKWYEGf1qHSOqMrtlrcXXyJn8");
             System.out.println(url);
        	 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setRequestMethod("GET");
             String line, outputString = "";
             BufferedReader reader = new BufferedReader(
             new InputStreamReader(conn.getInputStream()));
             while ((line = reader.readLine()) != null) 
             {
                 outputString += line;
             }
            log.info("DriverServiceImpl-->GoogleDistanceUsingLatandLong-->Json outPut String-->"+outputString);
             
       
             Gson ob=new Gson();
             DistancePojo capRes = ob.fromJson(outputString, DistancePojo.class);
             System.out.println(capRes);
             
             JSONObject json = new JSONObject(outputString);
             json.get("rows");
             
             json.get("destination_addresses");
             String origin=json.get("origin_addresses").toString();
             JSONArray arr=null;
             JSONArray arr1=null;
             arr = json.getJSONArray("rows");
             arr1=json.getJSONArray("origin_addresses");
             
             
             distance =(String)arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getString("text").toString();
          
             time=(String)arr.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text").toString();
       
             
            /* String originaddress="";
             StringBuilder stringBuilderDestinationAddr = new StringBuilder();

             for (int i = 0; i < origin.length(); i++)
                 if (origin.charAt(i) != '[' && origin.charAt(i) != ']' && origin.charAt(i) != '"')
                      stringBuilderDestinationAddr.append(originaddress.origin(i));

             String strCleanDestination = stringBuilderDestinationAddr.toString();*/
             
             
             
             log.info("GoogleApIMethod-->googleDistanceInKm-->"+distance+"googleTimeInHoursAndMinutes"+time);
        
          
             
             
             
		 String[] part = distance.split(" ");
		  float dist=Float.parseFloat(part[0]);
		  float googleDistance=0;
		 
		  if(distance.contains("k")){
        	  
			  googleDistance=dist;
          } else{
        	  
        	  googleDistance=(float) (dist* 0.001);
        	  
          }
		  
		  
		  Route rt=new Route();
		  int time_in_mins=rt.getMinutes(time);
		  log.info("GoogleApIMethod-->googleDistance-->"+dist+"googleTimeInMinutes"+time_in_mins);
		  rt.setDistance(googleDistance);
		  rt.setTime(time_in_mins);
		  rt.setsLat(sLat);
		  rt.setsLong(sLong);
		  rt.setdLat(dLat);
		  rt.setdLong(dLong);
		  
		  return rt;
		
		
	}catch(Exception e){
		
		e.printStackTrace();

	} 
	return null;
	}


	
	
}
