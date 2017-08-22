package com.cogzy.gtruckways.serviceImpl;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.service.EmailSenderService;
import com.cogzy.gtruckways.validator.Log;

public class EmailSenderServiceImpl implements EmailSenderService {

	
	@Autowired
    private static JavaMailSender  mailSender;
	    
	@Autowired
	    private SimpleMailMessage templateMessage;

	@Autowired
	private VelocityEngine velocityEngine;


	    public static JavaMailSender getMailSender() {
			return mailSender;
		}



		public static void setMailSender(JavaMailSender mailSender) {
			EmailSenderServiceImpl.mailSender = mailSender;
		}



		public void setTemplateMessage(SimpleMailMessage templateMessage) {
	        this.templateMessage = templateMessage;
	    }
	
	
	
	public VelocityEngine getVelocityEngine() {
			return velocityEngine;
		}



		public void setVelocityEngine(VelocityEngine velocityEngine) {
			this.velocityEngine = velocityEngine;
		}



	@Override
	public String otpEmail(User use) {
		// TODO Auto-generated method stub
		
		String success="Yes";
    	String recipientAddress = use.getEmail();
    	String subject = "Otp number to Verify Customer";
        String msg ="<img src='http://www.gtruckways.com/img/Logonew.png' width='120px' height='50px'><br><br><span><strong>Dear Customer</strong>,</span>\n\n"
    	
        +"<br>Please Enter the "+use.getOtp().getOtpNumber()+" Digit Otp Number to Confirm Your Booking";
    
      
        
        try{
        	  
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            

            
		         helper.setFrom("cogzytruckways@gmail.com");  
		         helper.setTo(recipientAddress);
		         helper.setSubject(subject);
		         helper.setText(msg,true);

         

		         mailSender.send(message);
            
         return success;
            
            } catch(Exception e){
            	
            }
        	return "ok";
        }
        
        // forwards to the view named "Result"
       
	

	@Override
	public String postDetailsMail(String email1,String mobileNo,String postDate,String bookingId, String password,String username,int UserStatus) {
		String success="Yes";
   	 
 	
 	   
 	   String recipientAddress = email1;
 	  
 	   String subject="Booking Information";
 	   
 	   String message="";
 	 
if(UserStatus==1){
  		  
  	   
 	   
 	  message="Dear <span>"+username+",\n\n"
 			  
    +"Thank you for using gTruckways, Your PassWord:"+password+",for Login id:"+mobileNo
  
    + " Your Booking Id is:"+bookingId+"," + " Booking Date and Time :" + postDate
    + " We will Contact you soon"+"\n\n"
    
    
    
    +"© 2016 Copyright gTruckways";
 	  
 	   } else{
 		
 		   message="Dear "+username+",\n\n"
 				  +"Thank you for using gTruckways "
 				  
 				    + " Your Booking Id is :"+bookingId+"," + " Booking Date and Time:" + postDate +"\n\n"
 				    + " We will Contact you soon"+"\n\n"
 			       
 			       
 			       +"© 2016 Copyright gTruckways";
 		   
 		   
 		   
 	   }
 	 
 	  
 	  	SimpleMailMessage email = new SimpleMailMessage();
        
 	  	email.setFrom("cogzytruckways@gmail.com");
         email.setTo(recipientAddress);
         email.setSubject(subject);
         email.setText(message);
  
         
         
        System.out.println("hello"+email);
         
         // sends the e-mail
         
         mailSender.send(email); 
 	   
 	   
 	   
 	 return success;
  }

	
	@Override
	public String sendTransConfirmMail(Post pos, String RegNum, String DvrName, String DvrContact ){
	    
		  String success="Yes";
	    	 
	    	   System.out.println( pos.getUser().getEmail());
	    	   
	    	   String recipientAddress = pos.getUser().getEmail();
	    	  
	    	   String subject="Freight Details";
	    	   
	    	  String message="Dear "+pos.getUser().getUserName()+",\n\n"
	       +"Following are the details of your freight for Booking Id:"+pos.getPostId()+"\n\n"
	     
	       + "Vehicle Registration Number :"+RegNum+"  \n"
	       + "Driver Name:"+DvrName+"  \n" 
	       + "Driver Contact :"+DvrContact+"  \n\n" 
	       
	       
	       +"© 2016 Copyright gTruckways";
	    	   
	    	 
	    	  
	    	  SimpleMailMessage email = new SimpleMailMessage();
	           
	    	  	email.setFrom("cogzytruckways@gmail.com");
	            email.setTo(recipientAddress);
	            email.setSubject(subject);
	            email.setText(message);
	                  
	            
	           System.out.println("hello"+email);
	            
	            // sends the e-mail
	            
	            mailSender.send(email); 
	    	   
	    	 return success;
	     }

	@Override
	public int SendDriverInfoToCustomer(String bookingId,String driverName, String mobileNo, String emailId,String regNo) {
		Post pos=new Post();
		
		String recipientAddress = emailId;
    	String subject = "Vehicle and Driver Information";
        String message ="Dear Customer\n\n"
    	
        +"Your booking Id="+bookingId+" has been confirmed,Driver Name ="+driverName+",Mobile No="+mobileNo+",Vehicle number ="+regNo+", will pick up your goods soon. Track your order at 'www.gtruckways.com'";
    
        /*Dear Customer, Your booking id 'XXX' has been confirmed, 
         * Driver : Driver name(mobile number), Vehicle number will pick up your goods soon.
         * Track your order at "mention the link".
         */
        
        System.out.println("To: " +mailSender);
        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
         
        
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("cogzytruckways@gmail.com");
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
     
       System.out.println("hello"+email);
        
        // sends the e-mail
        
        mailSender.send(email);
        
        // forwards to the view named "Result"
        return 1;
	
	}

	@Override
	public int TripcompletionMail(String emailId, String bookingId, float totalAmount) {
		String recipientAddress = emailId;
    	String subject = "Booking is Completed";
        String message ="Dear Customer\n\n"
    	
        
          +"Your booking id "+bookingId+" has been delivered.The total amount to be paid  is Rs "+totalAmount+". ";
    
        System.out.println("To: " +mailSender);
        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
         
        
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("cogzytruckways@gmail.com");
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
     
       System.out.println("hello"+email);
        
        // sends the e-mail
        
        mailSender.send(email);
        
        // forwards to the view named "Result"
        return 1;
	}

	@Override
	public int mailToTelecaller(Post pos) {
		
		String recipientAddress ="gtr.cse@gmail.com";
    	String subject = "Booking is Completed";
		String message="Dear Telecaller, New Booking Request has been Received,Please Go Ahead\n\n"
			     
			       + "Booking Id is :"+pos.getBookingId()+"  " + "Booking Date and Time:" + pos.getPostDate() +"\n\n"
			       + "Source:"+pos.getPrice().getRoute().getFromCity()+"  "+"Destination:" + pos.getPrice().getRoute().getToCity() +"\n\n" 
			       + "Material Name :"+ pos.getMaterial() +"  " + "Travel Date and Time:" +pos.getTravelDate()+"\n\n" 
			       + "Approximate Amount:" + pos.getTotalAmount()+"\n\n"
			       
			       
			       +"© 2016 Copyright gTruckways";
		   
		   
		   
	 
	 
	  
	  	SimpleMailMessage email = new SimpleMailMessage();
     
	  email.setFrom("cogzytruckways@gmail.com");
      email.setTo(recipientAddress);
      email.setSubject(subject);
      email.setText(message);

      
     System.out.println("hello"+email);
      
      // sends the e-mail
      
      mailSender.send(email); 
	   
	   
	   
	 return 1;
}


	//Enterprise Customer forgot password
		@Override
		public String forgotpassEmail(String Eemail,String SecureString) {
			// TODO Auto-generated method stub
			String success="Yes";
	    	String recipientAddress = Eemail;
	    	String subject = "Enterprise Customer Forgot password";
	    	
	    	
	    	String message =" 'http://www.gtruckways.com/chngemail/"+SecureString+"  use this link to reset password";
	    
	    	Log.info("To: " +mailSender);
	        // prints debug info
	       Log.info("To: " + recipientAddress);
	       Log.info("Subject: " + subject);
	       Log.info("Message: " + message);
	         
	        
	        // creates a simple e-mail object
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setFrom("cogzytruckways@gmail.com");
	        email.setTo(recipientAddress);
	        email.setSubject(subject);
	        email.setText(message);
	     
	       System.out.println("hello"+email);
	        
	        // sends the e-mail
	        
	        mailSender.send(email);
	        
	        // forwards to the view named "Result"
	        return success;
		}
	
		//Enterprise Customer forgot password
		@Override
		public String passSendEmail(EnterpriseCustomer ecust,String password) {
			// TODO Auto-generated method stub
			String success="Yes";
	    	String recipientAddress = ecust.getEmail();
	    	String subject = "Enterprise Customer Password";
	       String message ="Dear Customer,\n\n"
	    	
	        +" Please Use this Password: "+password+" To Login to your Account ";
	    	/*String message ="<a href='http://www.gtruckways.com/changepwd1.jsp "+Eemail+"'>use this link to reset password</a>";*/
	    	//String message =" http://localhost:8080/gtruckways/chngemail    "+Eemail+" use this link to reset password";
	        System.out.println("To: " +mailSender);
	        // prints debug info
	        System.out.println("To: " + recipientAddress);
	        System.out.println("Subject: " + subject);
	        System.out.println("Message: " + message);
	         
	        
	        // creates a simple e-mail object
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setFrom("cogzytruckways@gmail.com");
	        email.setTo(recipientAddress);
	        email.setSubject(subject);
	        email.setText(message);
	     
	       System.out.println("hello"+email);
	        
	        // sends the e-mail
	        
	        mailSender.send(email);
	        
	        // forwards to the view named "Result"
	        return success;
		}

		@Override
		public String forgotpassEmailRetailUser(String Eemail, String secureSaltString) {
			
			String success="Yes";
	    	String recipientAddress = Eemail;
	    	String subject = "Customer Forgot password Link";
	    	
	    	
	    	//String message =" 'http://localhost:8080/gtruckways/changemail/"+secureSaltString+"  use this link to reset password";
	    	
	    	String message =" 'http://www.gtruckways.com/changemail/"+secureSaltString+"  use this link to reset password";
	    
	    	Log.info("To: " +mailSender);
	        // prints debug info
	       Log.info("To: " + recipientAddress);
	       Log.info("Subject: " + subject);
	       Log.info("Message: " + message);
	         
	        
	        // creates a simple e-mail object
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setFrom("cogzytruckways@gmail.com");
	        email.setTo(recipientAddress);
	        email.setSubject(subject);
	        email.setText(message);
	     
	       System.out.println("hello"+email);
	        
	        // sends the e-mail
	        
	        mailSender.send(email);
	        
	        // forwards to the view named "Result"
	        return success;
		}
	
	
	
	
		@Override
		 public void sendConfirmationEmail(Post pos) {
		        
			 MimeMessagePreparator preparator = new MimeMessagePreparator() {
		            public void prepare(MimeMessage mimeMessage) throws Exception {
		                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
		                message.setTo(pos.getUser().getEmail());
		                message.setFrom("cogzytruckways@gmail.com"); // could be parameterized...
		               message.setSubject("Invoice");
		                Map model = new HashMap();
		                model.put("telePostinfo", pos);
		                
		                String text = VelocityEngineUtils.mergeTemplateIntoString(
		                        velocityEngine, "com/cogzy/gtruckways/resources/invoiceTemplate.vm",model);
		                message.setText(text, true);
		            }
		        };
		       
		        this.mailSender.send(preparator);
		    }
	
		
		 
	
	
	
	
	
}
