package com.cogzy.gtruckways.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;





import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.PromoCode;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.service.EmailSenderService;


import com.cogzy.gtruckways.serviceImpl.GetPriceServiceImpl;
import com.cogzy.gtruckways.serviceImpl.OtpServiceImpl;
import com.cogzy.gtruckways.serviceImpl.PostServiceImpl;
import com.cogzy.gtruckways.serviceImpl.SmsServiceImpl;
import com.cogzy.gtruckways.serviceImpl.UserServiceImpl;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.GetPriceRequestPojo;
import com.cogzy.gtruckways.valueObjects.TelecallerLoginInfo;
import com.cogzy.gtruckways.valueObjects.UserPostInfo;


@Controller
@SessionAttributes({"priceinfo","postinfo","userinfo"})
public class GetPriceController {
	
	
@Autowired
GetPriceServiceImpl priceservice;

@Autowired
PostServiceImpl postservice;
 
@Autowired
UserServiceImpl userservice;
 
@Autowired
OtpServiceImpl otpservice;

@Autowired
SmsServiceImpl smsservice;

private static Logger log = Logger.getLogger(Log.class.getName());


public GetPriceServiceImpl getPriceservice() {
	return priceservice;
}

public void setPriceservice(GetPriceServiceImpl priceservice) {
	this.priceservice = priceservice;
}



@RequestMapping(value = "/", method = RequestMethod.GET)
public String welcomePage(Model model) {								// the User object is used as a template to generate the form
model.addAttribute("price", new GetPriceRequestPojo());
return "home";
}

@RequestMapping(value = "/homePage", method = RequestMethod.GET)
public String HomePage(Model model) {								// the User object is used as a template to generate the form
model.addAttribute("price", new GetPriceRequestPojo());
return "home";
}

@RequestMapping(value = "/TelecallerLogin", method = RequestMethod.GET)
public String TelecallerLoginPage(Model model) {								// the User object is used as a template to generate the form
return "TelecallerLogin";
}

@RequestMapping(value = "/faq", method = RequestMethod.GET)
public String Faq(Model model) {								// the User object is used as a template to generate the form
return "faq";
}



@RequestMapping(value = "/offers", method = RequestMethod.GET)
public String OffersPage(Model model) {								// the User object is used as a template to generate the form
return "TermsConditions";
}

@RequestMapping(value = "/land", method = RequestMethod.GET)
public String landPage(Model model) {								// the User object is used as a template to generate the form
return "landingpage";
}



@ModelAttribute
public void getAllVehicleType(Model model){
	
	List<TruckInfo> vehi=priceservice.getAllVehicleTypes();
	List<String> materialList=priceservice.getAllMaterials();
	model.addAttribute("VehicleTypeList", vehi);
	model.addAttribute("MaterialList", materialList);
	
}
   

@RequestMapping("/privacy")  
public ModelAndView showPrivacyPage(){  
    return new ModelAndView("Privacy_policy");  
}



@RequestMapping("/aboutus")  
public ModelAndView showAboutUsPage(){  
    return new ModelAndView("aboutus");  
}


@RequestMapping("/contactus")  
public ModelAndView showContactUsPage(){  
    return new ModelAndView("contactus");  
}

@RequestMapping("/mini-trucks-booking-rates")  
public ModelAndView showPricingPage(){  
    return new ModelAndView("mini-trucks-booking-rates");  
}

@RequestMapping("/terms")  
public ModelAndView showTermsAndConditionPage(){  
    return new ModelAndView("Termsofuse");  
}


	@RequestMapping(value = "/price", method = RequestMethod.POST)
	public ModelAndView getprice(@Valid @ModelAttribute("price") GetPriceRequestPojo gp, BindingResult result,
			SessionStatus status) throws Exception {

		if (result.hasErrors()) {

			log.info("GetPrice Controller-->GetPriceMethod--> Error in the Input's i.e FromCity or Tocity or TruckType");
			ModelAndView model = new ModelAndView("home");
			return model;
		}

		
		log.info("GetPriceController-->Get Price Method-->From City-->" + gp.getFromCity() + "-->To City-->"
				+ gp.getToCity() + "-->Truck Type-->" + gp.getTruckType());
		
		if(!gp.getFromCity().contains("Bangalore")){
			
			log.info("Bangalore");
		}
		
		
		if (!gp.getFromCity().endsWith("Bengaluru, Karnataka, India")
				|| !gp.getToCity().endsWith("Bengaluru, Karnataka, India") || gp.getFromCity().equals(gp.getToCity())) {

			
			
			ModelAndView model = new ModelAndView("home");
			return model;
		}

		

		try {

		Route	route = priceservice.getGoogleDistanceAndTime(gp.getFromCity(), gp.getToCity());

			if (route.getFromCity().isEmpty() || route.getToCity().isEmpty() || route.getDistance() == 0) {

				ModelAndView model = new ModelAndView("home");
				return model;

			}

			TruckInfo	info = priceservice.getTruckInformationDetails(gp.getTruckType());
			
			if(info.getTruckId()==1 || info.getTruckId()==6){
				
				 route.setTime(route.getTime()+30);
				
			}else{
				
				 route.setTime(route.getTime()+60);
			}
			
			Price	price = priceservice.getTotalAmount(route, info);

			float gst=0;
			float totalAmount=0;
			if(price.getTotalAmount()>=1500){
				
			    gst=(float) (price.getTotalAmount()*0.05);
			    totalAmount=price.getTotalAmount()+gst;
			
			} else{
				
				gst=0;
				totalAmount=price.getTotalAmount();
			}
			
			
			
			price.setTotalAmount(totalAmount);
			
			ModelAndView model = new ModelAndView("local_post");
			model.addObject("mobileNo",gp.getMobileNo());
			model.addObject("priceinfo", price);
			model.addObject("userpostinfo", new UserPostInfo());
			return model;
		
		} catch (Exception e) {

			ModelAndView model = new ModelAndView("home");
			return model;
		}

	}

	@RequestMapping(value="/getprice",method=RequestMethod.POST)
	public ModelAndView getquoteprice(@Valid @ModelAttribute("userpostinfo") UserPostInfo upi,@ModelAttribute("priceinfo") Price price, BindingResult result) throws Exception{


		try{	
	
	log.info("GetPrice Controller-->Approximate Amount-->"+upi.getApproxAmount()+"-->"+price.getTotalAmount()+"-->DriverAsHelper-->"+upi.getHelper()+"DiscountAmount-->"+upi.getDiscountAmount()+"-->promocode-->"+upi.getPromocode());
	
	if (result.hasErrors()) {

		log.info("GetPrice Controller-->GetQuotePrice--> ");
		ModelAndView model = new ModelAndView("local_post");
		model.addObject("priceinfo", price);
		return model;
	}

	
	
	
	
		User user=userservice.getUserDetails(upi);
		
		Post pos=postservice.getPostedDetails(upi,user,price);
	
		ApplicationContext context = new ClassPathXmlApplicationContext("com/cogzy/gtruckways/controller/applicationContext.xml"); 

		EmailSenderService  mailer =  (EmailSenderService) context.getBean("mailMail");
	        //Send a composed mail
	 			
			log.info("GetPriceController-->UserStatus-->"+pos.getUser().getUserStatus()+"-->otpEmail-->"+pos.getUser().getEmail()+"-->otp-->"+pos.getUser().getOtp().getOtpNumber());
	 
			
	 			mailer.otpEmail(user);
	 			
	 			
	 			smsservice.getOtpSms(user);
	
	
				ModelAndView model =new ModelAndView("local_post");
				String msg="<span style='color:green;font-size:14px;'>Enter OTP that has sent to your MobileNo/Mail-ID</span>";
				model.addObject("errormsg",msg);
				model.addObject("postinfo",pos);
				return model;
	
	} catch(Exception e){
		
		 ModelAndView model=new ModelAndView("homePage");	 
		 return model;
	}


}




	@RequestMapping(value="/confirm",method=RequestMethod.POST)
	public ModelAndView confirmcustomer(@RequestParam("otp") String otp,@ModelAttribute("priceinfo") Price price,@ModelAttribute("postinfo") Post pos){ 


		
	try{	
		
		
		int success=otpservice.checkUserOTP(otp,pos);
		
		if(success==1){
			
			
		
			pos=otpservice.storePostDetails(pos,price);
		
			ApplicationContext context = new ClassPathXmlApplicationContext("com/cogzy/gtruckways/controller/applicationContext.xml");
			
			 EmailSenderService  mailer =  (EmailSenderService) context.getBean("mailMail");
			       
			log.info("GetpriceController-->UserStatus--->"+pos.getUser().getUserStatus());
			 
			 mailer.postDetailsMail(pos.getUser().getEmail(),pos.getUser().getMobileNo(),pos.getPostDate(),pos.getBookingId(),pos.getUser().getPassword(),pos.getUser().getUserName(),pos.getUser().getUserStatus());
			 mailer.mailToTelecaller(pos);
			
			 if(pos.getUser().getUserStatus()==1){
				 
			 log.info("GetPriceController-->New User");
			 
			 userservice.updateUserStatus(pos.getUser());
			
			 }
			 
			ModelAndView model =new ModelAndView("postconfirmjsp");
			model.addObject("postinfo",pos);
			return model;
			
			
			
		
		} else{
			
			ModelAndView model =new ModelAndView("local_post");
			model.addObject("postinfo",pos);
			String msg="<span style='color:red;font-size:14px;'>OTP entered is incorrect</span>";
			model.addObject("errormsg",msg);
			 return model;
			
		}
	
	
	} catch(Exception e)
	
	{
		
		ModelAndView model =new ModelAndView("homePage");
		String msg="<span style='color:red;font-size:14px;'>OTP entered is incorrect</span>";
		model.addObject("errormsg",msg);
		 return model;
		
	}

}
	
	@RequestMapping(value="/getEmail",method=RequestMethod.GET) 
	 public void getEmailCntrl(@RequestParam("Gmobile") String Gmobile, HttpServletResponse response ) throws Exception
	 {
	  
	  String msg="";
	  String gst="";  
	  
	  User use=userservice.getEmail(Gmobile);
	 
	    if(use.getStatusCode()==200){
	     msg=use.getEmail();
	     gst=use.getGstNumber();
	    
	    }else if(use.getStatusCode()==204){
	     msg=use.getEmail();
	     gst="";
	    
	    }else{
	    	msg="";
	    	gst="";
	    	
	    }
	  
	  
	     JSONObject obj = new JSONObject();
	     try{
	      obj.put("msg",msg);  
	      obj.put("gst", gst);
	     }catch(JSONException e){
	      e.printStackTrace();
	     }
	    response.getWriter().write(obj.toString());
	 }
	
	
	
	@RequestMapping(value="/ajaxGetPrice",method=RequestMethod.GET) 
	public void ajaxGetPriceCntrl(@RequestParam("truckType") String trkType, @RequestParam("fromCity") String frmCity,@RequestParam("toCity") String toCity,HttpServletResponse response ) throws Exception
	{
	  
	    log.info("GetPriceController--> ajaxGetPrice controller-->TruckType-->"+trkType+"-->FromCity-->"+frmCity+"-->ToCity-->"+toCity);
	    Route route=new Route();
	    TruckInfo info= new TruckInfo(); 
	    Price price=new Price();
	    String msg="";
	    float tId;      
	     try{
	     
	    	 
	    route=priceservice.getGoogleDistanceAndTime(frmCity, toCity);
	    
	  
	     
	     int truckId=priceservice.getTrcukId(trkType);
	     
	     String td=String.valueOf(truckId);
	     
	     info=priceservice.getTruckInformationDetails(td);
	    
	     price=priceservice.getTotalAmount(route, info);
	     
	     if(price.getTotalAmount()!=0.0f){
	     
	    log.info("GetPriceController-->AjaxPrice-->PriceChanged to-->"+price.getTotalAmount()+"LabourPrice-->"+price.getInfo().getLabourPrice());
	    	 
	    	msg=Float.toString(price.getTotalAmount());
	    	  tId=price.getInfo().getLabourPrice();
	     }
	     	else 
	    	  {
	    		  msg="";
	    		  tId=price.getInfo().getLabourPrice(); 
	    	  }
	    
	     
	     JSONObject obj = new JSONObject();
	 
	 try{
	   obj.put("msg",msg); 
	   obj.put("labourprice", tId);
	 
	 }catch(JSONException e){
	   e.printStackTrace();
	  }
	  response.getWriter().write(obj.toString());
	     
	    }
	    catch(Exception e ){
	     
	    }
	    
	   
	   }
	
	
	// ajax code for Apply coupon
	
	@RequestMapping(value="/ajaxCoupon",method=RequestMethod.GET) 
	public void ApplyCouponCode(@RequestParam("promoCode") String PromoCode,@RequestParam("totalAmount") float amount,@RequestParam("status") int statusCode,@RequestParam("travelDate") String travelDate,@ModelAttribute("priceinfo") Price price ,HttpServletResponse response ) throws Exception
	{
	
	log.info("GetPriceController-->ApplyCouponCodeMethod-->PromoCode"+PromoCode+"-->totalAmount-->"+amount+"--statusCode-->"+statusCode);
	log.info("GetPriceController-->ApplyCouponCodeMethod-->BaseFare"+price.getInfo().getBasePrice());
	JSONObject obj = new JSONObject();
	try{
		
		if(statusCode==200){
			
			  obj.put("amount",amount);
			  obj.put("msg", "<span style='color:red;'>Promocode is Already Used</span>");
			  obj.put("status","200");
			  obj.put("discount",0);
			  obj.put("promocode","Not Applied");
			  response.getWriter().write(obj.toString());
			
		} else{
		
		  PromoCode promo=priceservice.CheckPromoCodeExistsOrNot(PromoCode,amount,price,travelDate);
		
		
		
		  log.info("TotalAmount"+promo.getTotalAmount()+"-->Discount-->"+ promo.getDiscountAmount());
		  obj.put("amount",promo.getTotalAmount());
		  obj.put("msg",promo.getStatusMessage());
		  obj.put("status",promo.getStatusCode());
		  obj.put("promocode",promo.getPromoCode());
		  obj.put("discount", promo.getDiscountAmount());
		  response.getWriter().write(obj.toString());
		  
		
		} 
		  
	}catch(Exception e){
		
		  obj.put("amount",amount);
		  obj.put("msg", "<span style='color:red;'>This PromoCode is not Applicable for You</span>");
		  obj.put("status","500");
		  obj.put("promocode","Not Applied");
		  obj.put("discount",0);
		  response.getWriter().write(obj.toString());
	}
	
	}
	
	
	@RequestMapping(value = "/getQuote", method = RequestMethod.POST)
	public ModelAndView getQuotePriceFromLandingPage(@Valid @ModelAttribute("price") GetPriceRequestPojo gp, BindingResult result,
			SessionStatus status) throws Exception {

		if (result.hasErrors()) {

			log.info("GetPrice Controller-->GetPriceMethod--> Error in the Input's i.e FromCity or Tocity or TruckType");
			ModelAndView model = new ModelAndView("home");
			return model;
		}

		
		log.info("GetPriceController-->Get Price Method-->From City-->" + gp.getFromCity() + "-->To City-->"
				+ gp.getToCity() + "-->Truck Type-->" + gp.getTruckType());
		
		if(!gp.getFromCity().contains("Bangalore")){
			
			log.info("Bangalore");
		}
		
		
		if (!gp.getFromCity().endsWith("Bengaluru, Karnataka, India")
				|| !gp.getToCity().endsWith("Bengaluru, Karnataka, India") || gp.getFromCity().equals(gp.getToCity())) {

			
			
			ModelAndView model = new ModelAndView("home");
			return model;
		}

		

		try {

		Route	route = priceservice.getGoogleDistanceAndTime(gp.getFromCity(), gp.getToCity());

			if (route.getFromCity().isEmpty() || route.getToCity().isEmpty() || route.getDistance() == 0) {

				ModelAndView model = new ModelAndView("home");
				return model;

			}

			TruckInfo	info = priceservice.getTruckInformationDetails(gp.getTruckType());
			
			if(info.getTruckId()==1 || info.getTruckId()==6){
				
				 route.setTime(route.getTime()+30);
				
			}else{
				
				 route.setTime(route.getTime()+60);
			}
			
			Price	price = priceservice.getTotalAmount(route, info);

			float gst=0;
			float totalAmount=0;
			if(price.getTotalAmount()>=1500){
				
			    gst=(float) (price.getTotalAmount()*0.05);
			    totalAmount=price.getTotalAmount()+gst;
			
			} else{
				
				gst=0;
				totalAmount=price.getTotalAmount();
			}
			
			
			User use=userservice.storeCustomerInformationofLandingPage(gp.getFromCity(), gp.getToCity(), gp.getMobileNo(), gp.getTruckType());
			
			price.setTotalAmount(totalAmount);
			price.setLandPageStatus(200);
			ModelAndView model = new ModelAndView("local_post");
			model.addObject("priceinfo", price);
			model.addObject("usercustinfo", use);
			return model;
		
		} catch (Exception e) {

			ModelAndView model = new ModelAndView("home");
			return model;
		}

	}
	
	
	
}
