package com.cogzy.gtruckways.controller;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.validator.Log;

public class SendFCMNotification {

	private static Logger log = Logger.getLogger(Log.class.getName());
	/*public final static String AUTH_KEY_FCM_DRIVER = "AIzaSyAEDFg-zJkA8wQu2b2MMQs5SZYg3fdKOno";*/ //punith
	
	public final static String AUTH_KEY_FCM_DRIVER ="AIzaSyDVdRIJBimgoDOWNBcbzilE5S02QAlwv-c"; //new for driver
	public final static String AUTH_KEY_FCM_CUSTOMER = "AIzaSyDajpWcWt9FKW_gmLU1TBmDrKnhJqlOjcE"; // new key for customer App
	            //  AIzaSyCE8YyZCQWg9X_Q2IPA6PIL9JumMhRYR38 old key ravindra customer App
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
	// userDeviceIdKey is the device id you will query from your database 
	
	public static  int pushFCMNotification(String userDeviceIdKey,Post pos) throws Exception{
		//public static  void pushFCMNotification(String userDeviceIdKey) throws Exception{	
	String authKey = AUTH_KEY_FCM_DRIVER;   // You FCM AUTH key i.e Server Legacy Key
	String FMCurl = API_URL_FCM;     

	try{
	URL url = new URL(FMCurl);
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	conn.setUseCaches(false);
	conn.setDoInput(true);
	conn.setDoOutput(true);

	conn.setRequestMethod("POST");
	conn.setRequestProperty("Authorization","key="+authKey);
	conn.setRequestProperty("Content-Type","application/json");

	/*JSONObject json = new JSONObject();
	JSONObject data = new JSONObject();
	data.put("Source", "karthik");
	data.put("Destination", "Rajajinagar");
	json.put("data", data);
	
	json.put("to",userDeviceIdKey.trim());	*/
	
	log.info("DriverSerivceImpl-->Fcm Notification-->bookingId-->"+pos.getBookingId());
	JSONObject json = new JSONObject();
	json.put("to",userDeviceIdKey.trim());
	JSONObject info = new JSONObject();
	JSONObject body= new JSONObject();
	
	
	body.put("pickup",pos.getFromCity());
	body.put("drop", pos.getToCity());
	body.put("pickupTime",pos.getTravelDate());
	body.put("bookingId", pos.getBookingId());
	body.put("rName",pos.getRecepientName());
	body.put("rMobile", pos.getRecepientMobile());
	body.put("pArea", pos.getPickUpArea());
	body.put("dArea", pos.getDropArea());
	
	info.put("title", "Gtruckways");   // Notification title
	info.put("body","Booking Information");
	info.put("sound", "notify");// Notification body
	info.put("click_action","NOTIFICTION_ACTION");
	//json.put("notification", info);
	json.put("data", body);
	
	
	
	
	

	System.out.println(json.toString());
	
	OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	wr.write(json.toString());
	wr.flush();
	wr.close();
	conn.getInputStream();
	
	return 1;
	}catch(NullPointerException e){
	log.info("No Driver Found");
		
		return 0;
	}
	
	}
	
public static  int pushFCMNotificationForCustomerApp(String userDeviceIdKey,LocalDriver driver,String bookingId) throws Exception{
//public static  int pushFCMNotificationForCustomer(String userDeviceIdKey) throws Exception{	
	
	String authKey = AUTH_KEY_FCM_CUSTOMER;   // You FCM AUTH key
	String FMCurl = API_URL_FCM;     

	try{
	URL url = new URL(FMCurl);
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	conn.setUseCaches(false);
	conn.setDoInput(true);
	conn.setDoOutput(true);

	conn.setRequestMethod("POST");
	conn.setRequestProperty("Authorization","key="+authKey);
	conn.setRequestProperty("Content-Type","application/json");

	
	log.info("DriverSerivceImpl-->Fcm Notification for Customer App-->bookingId-->-->Driver Name");
	JSONObject json = new JSONObject();
	
	json.put("to",userDeviceIdKey.trim());
	JSONObject info = new JSONObject();
	JSONObject body= new JSONObject();
	
	body.put("driverName",driver.getDriverName());
	body.put("driverMobile",driver.getMobile());
	body.put("VehicleRegNo",driver.getDriverRegNo());
	body.put("bookingId",bookingId);
	
	
	// for Testing  Dummy Data
	
	/*body.put("driverName","AJAY");
	body.put("driverMobile","8050654123");
	body.put("VehicleRegNo","KA04MN9482");
	body.put("bookingId","GTR123456");
	*/
	
	info.put("title", "Gtruckways");   // Notification title
	info.put("body","Driver Information");
	info.put("sound", "default");// Notification body
	json.put("notification", info);
	json.put("data", body);
	
	
	
	
	

	System.out.println(json.toString());
	
	OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	wr.write(json.toString());
	wr.flush();
	wr.close();
	conn.getInputStream();
	
	return 1;
	}catch(NullPointerException e){
	log.info("No Driver Found");
		
		return 0;
	}
		

	}
	public static void main(String args[]) throws Exception{
		
		String userDeviceIdKey ="e7vraC752LE:APA91bFBbALE3cgxyghHTFIiDAq9JizGmD9DhhjR6CU95-9-Kmq92h59YnS2JvRo_u0rReO3o41kgowpJVf36cQytn34UQhuP-286nsAVwOi72LQqssYlzLa150L54b86APWbQXQtT3f";
		SendFCMNotification.pushFCMNotification(userDeviceIdKey);
		System.out.println("Done");
		
	}
	
	public static  void pushFCMNotification(String userDeviceIdKey) throws Exception{	
		
		String authKey = AUTH_KEY_FCM_DRIVER;   // You FCM AUTH key i.e Server Legacy Key
		String FMCurl = API_URL_FCM;     

		try{
		URL url = new URL(FMCurl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization","key="+authKey);
		conn.setRequestProperty("Content-Type","application/json");
		JSONObject json = new JSONObject();
		
		json.put("to",userDeviceIdKey.trim());
		JSONObject info = new JSONObject();
		JSONObject body= new JSONObject();
		
		info.put("title", "Gtruckways");   // Notification title
		info.put("body","Driver Information");
		info.put("sound", "default");// Notification body
		json.put("notification", info);
		json.put("data", body);
		
		body.put("pickup","Banashankari");
		body.put("drop", "vijaynagar,bengaluru");
		body.put("pickupTime","2017-05-30 15:30 ");
		body.put("bookingId", "GTR24568");
		body.put("rName","Ajay");
		body.put("rMobile","8050795014");
		body.put("pArea","vija");
		body.put("dArea","abnagsakjashd");
		
		System.out.println(json.toString());
		
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(json.toString());
		wr.flush();
		wr.close();
		conn.getInputStream();
	
		
		}catch(NullPointerException e){
		log.info("No Driver Found");
			
		
		}
	}
}
