package com.cogzy.gtruckways.controller;




import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;



import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;

@Controller
public class TestImageUpload {

	
	
	
	 public static void main(String[] args) throws java.text.ParseException {
	       
		
		 
		
		 
		double dist=distance(12.9613648,77.5599137,12.9609632,77.5594231);
		
		 
		System.out.println("Distance is-->"+dist);
		

		 	
/*
		 		String dateStart = "2012-04-20 11:29:58";
		 		String dateStop = "2012-04-20 12:31:48";

		 		//HH converts hour in 24 hours format (0-23), day calculation
		 		//SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		 		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

		 		
		 		Date d1 = null;
		 		Date d2 = null;

		 		try {
		 			d1 = format.parse(dateStart);
		 			d2 = format.parse(dateStop);

		 			//in milliseconds
		 			long diff = d2.getTime() - d1.getTime();

		 			long diffSeconds = diff / 1000 % 60;
		 			long diffMinutes = diff / (60 * 1000) % 60;
		 			long diffHours = diff / (60 * 60 * 1000) % 24;
		 			long diffDays = diff / (24 * 60 * 60 * 1000);

		 		 long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
		 			System.out.print(minutes + " minutes, ");
		 			System.out.print(diffDays + " days, ");
		 			System.out.print(diffHours + " hours, ");
		 			System.out.print(diffMinutes + " minutes, ");
		 			System.out.print(diffSeconds + " seconds.");

		 		} catch (Exception e) {
		 			e.printStackTrace();
		 		}*/

		 	}

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 public static double distance(double lat1, double lon1, double lat2, double lon2) {
		   
			double theta = lon1 - lon2;
		    double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))+ Math.cos(deg2rad(lat1))* Math.cos(deg2rad(lat2))* Math.cos(deg2rad(theta));
		    dist = Math.acos(dist);
		    dist = rad2deg(dist);
		    dist = dist * 60 * 1.1515;
		 
		    return (dist);
		}

		private static double deg2rad(double deg) {
		    return (deg * Math.PI / 180.0);
		}

		private static double rad2deg(double rad) {
		    return (rad * 180.0 / Math.PI);
		}
 
		 
		 
		 
		
		 
	 
		 
		
		
		/* String td="2017-05-10 09:35:42";
		 int helper=3;
		 float amount=560;
		 int helperprice=300;
		
		
		 
		 float famount=getFinalAmount(td,helper,amount,helperprice);
		 
	    System.out.println("finalAmount-->"+famount);*/
	    
	
	
	   
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public static float getFinalAmount(String travelDate,int helper,float amount,int helperPrice){
		 
		 String[] s = travelDate.split("\\s+");
		 
		 System.out.println(s[1]);
		 
		 String[] sp=s[1].split(":");
		 
		 System.out.println(sp[0]);
			
		 int slab=Integer.parseInt(sp[0]);
		    
			if(((slab>=0 && slab<8) || (slab>=20 && slab<=23)) && helper!=0 ){
		 	   	 
				amount=(float) (amount*1.5+helperPrice*helper);
		 		   
		 	   } else if((slab>=0 && slab<8 ||slab>=20 && slab<=23) && helper==0 ){
		 		   
		 		  amount=(float) (amount*1.5);
		 		   
		 	   }
		 	   else if(helper!=0){
		 		   
		 		  amount=amount+helperPrice*helper;
		 	   }

			return amount;
		

	 }
	 
}	 /*
	
	  
	  public long getDateTimeDiffrence(String startDate,String endDate) throws java.text.ParseException {  
	        
	        // Custom date format
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  

	        Date d1 = null;
	        Date d2 = null;
	        try {
	            d1 =  format.parse(startDate);
	            d2 =  format.parse(endDate);
	        
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }    

	        // Get msec from each, and subtract.
	        long diff = d2.getTime() - d1.getTime();

	        
	        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
	        
	        
	       long days = TimeUnit.MILLISECONDS.toDays(diff);
	        long remainingHoursInMillis = diff - TimeUnit.DAYS.toMillis(days);
	        long hours = TimeUnit.MILLISECONDS.toHours(remainingHoursInMillis);
	        long remainingMinutesInMillis = remainingHoursInMillis - TimeUnit.HOURS.toMillis(hours);
	      
	        long diffMinutes = diff / (60 * 1000) % 60; 
	        long remainingSecondsInMillis = remainingMinutesInMillis - TimeUnit.MINUTES.toMillis(minutes);
	        long seconds = TimeUnit.MILLISECONDS.toSeconds(remainingSecondsInMillis);

	        System.out.println("Days: " + days + ", hours: " + hours + ", minutes: " + minutes + ", seconds: " + seconds+"totalMins"+diffMinutes);
	   
	  return minutes;
	  
	  }
	  
	  
	  
	  
	  
	  public static double distance(double lat1, double lon1, double lat2, double lon2) {
		    double theta = lon1 - lon2;
		    double dist = Math.sin(deg2rad(lat1)) 
		                    * Math.sin(deg2rad(lat2))
		                    + Math.cos(deg2rad(lat1))
		                    * Math.cos(deg2rad(lat2))
		                    * Math.cos(deg2rad(theta));
		    dist = Math.acos(dist);
		    dist = rad2deg(dist);
		    dist = dist * 60 * 1.1515;
		    return (dist);
		}

	  
	  private static double deg2rad(double deg) {
		    return (deg * Math.PI / 180.0);
		}

		private static double rad2deg(double rad) {
		    return (rad * 180.0 / Math.PI);
		}

	  
}
	
	
	
	
	
	
	
	
	
	

	 public static boolean convertFormat(String inputImagePath,
	            String outputImagePath, String formatName) throws IOException {
	        FileInputStream inputStream = new FileInputStream(inputImagePath);
	        FileOutputStream outputStream = new FileOutputStream(outputImagePath);
	         
	        // reads input image from file
	        BufferedImage inputImage = ImageIO.read(inputStream);
	         
	        // writes to the output image in specified format
	        boolean result = ImageIO.write(inputImage, formatName, outputStream);
	         
	        // needs to close the streams
	        outputStream.close();
	        inputStream.close();
	         
	        return result;
	    }
	
	 public static boolean containsDigit(String s) {
		    if (s != null && !s.isEmpty()) {
		        for (char c : s.toCharArray()) {
		            if (Character.isDigit(c)) {
		                return true;
		            }
		        }
		    }
		    return false;
		}
		
	 
	 
	 public static void main(String[] args) {
	      
		 
		 
		 boolean str=containsDigit("abc123");
		 
		 System.out.println(str);
		 //String randomstring=getSaltString();
		 //System.out.println("shjfghjsd"+randomstring);
		 
		 String inputImage = "C:/Users/user1/Desktop/file/maptruck.jpg";
	        String oututImage = "C:/Users/user1/Desktop/file/maptruck.png";
	        String formatName = "PNG";
	        try {
	            boolean result = convertFormat(inputImage,
	            		
	            		
	            		
	            		
	            		
	                    oututImage, formatName);
	            if (result) {
	                System.out.println("Image converted successfully.");
	            } else {
	                System.out.println("Could not convert image.");
	            }
	        } catch (IOException ex) {
	            System.out.println("Error during converting image.");
	            ex.printStackTrace();
	        }
	    }
	 
	 
	 
	 public static String getSaltString() {
	        String SALTCHARS = "ABCDEFGHIJKabchLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        SecureRandom rnd = new SecureRandom();
	        while (salt.length() < 15) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        return saltStr;

	    }
	 
	//shjfghjsdA4SK1g3Q3H1R0UY
	 //shjfghjsdUNQC863CDBU4DJ9

*/