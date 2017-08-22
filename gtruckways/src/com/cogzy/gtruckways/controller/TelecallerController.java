package com.cogzy.gtruckways.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.cogzy.gtruckways.serviceImpl.DriverServiceImpl;
import com.cogzy.gtruckways.serviceImpl.GetPriceServiceImpl;
import com.cogzy.gtruckways.serviceImpl.SmsServiceImpl;
import com.cogzy.gtruckways.serviceImpl.TelePostServiceImpl;
import com.cogzy.gtruckways.serviceImpl.TransporterServiceImpl;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.AddtionalPricePojo;
import com.cogzy.gtruckways.valueObjects.DriverFeedbackPojo;
import com.cogzy.gtruckways.valueObjects.TelePostinfo;
import com.cogzy.gtruckways.valueObjects.TransMobileInfo;
import com.cogzy.gtruckways.businessObjects.CustomerPayment;
import com.cogzy.gtruckways.businessObjects.DriverDetailsResponse;
import com.cogzy.gtruckways.businessObjects.DriverTripDetailsResponse;
import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.Invoice;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.LocalTransporter;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.SmsInformation;
import com.cogzy.gtruckways.businessObjects.Telecaller;
import com.cogzy.gtruckways.businessObjects.TripDetails;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.service.EmailSenderService;



@SessionAttributes({"TelecallerInfo","PostDetail","telePostinfo","transinfo","custPaymentinfo","TruckInfo","error","TransList","driverDetail","driverDetails","BookDetails","TripDetails","dailyinfo","bookInfo","PostInfo"})
@Controller
public class TelecallerController {
	
	@Autowired
	GetPriceServiceImpl priceservice;
	
	@Autowired
	TelePostServiceImpl postService;
	
	@Autowired
	TransporterServiceImpl transService;
	
	@Autowired
	DriverServiceImpl driverService;
	
	@Autowired
	SmsServiceImpl smsservice;
	
	
	
	private static Logger log = Logger.getLogger(Log.class.getName());

	public TransporterServiceImpl getTransService() {
		
		return transService;
	}
	public void setTransService(TransporterServiceImpl transService) {
		this.transService = transService;
	}
	
	public TelePostServiceImpl getPostService() {
		return postService;
	}
	public void setPostService(TelePostServiceImpl postService) {
		this.postService = postService;
	}

	
	@RequestMapping(value = "/smsInfo", method = RequestMethod.GET)
	public String OffersPage(Model model) {								// the User object is used as a template to generate the form
	return "sms";
	}
	
	


/*	@RequestMapping(value = "/bookHome", method = RequestMethod.GET)
	public String TelecallerMainPage(Model model) {								// the User object is used as a template to generate the form
	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		model.addAttribute("username",username);
	
		return "PostHome";
	}*/
	
	@RequestMapping("/dmForm")  
    public ModelAndView showEnterpriseform(@ModelAttribute("TelecallerInfo") Telecaller tname){  
        return new ModelAndView("Driver_mgt","command",new DriverTripDetailsResponse());  
    }
	
	@RequestMapping("/liv")  
    public ModelAndView showLiveTracking(@ModelAttribute("TelecallerInfo") Telecaller tname ){  
        return new ModelAndView("Track_Driver","command",new DriverTripDetailsResponse());  
    }
	

	@ModelAttribute
	public void getEnterpriseDetails(Model model){
		
		
		List<EnterpriseCustomer> ec=transService.getEnterpriseDetails();
		
		List<Post> ListPost=postService.getPostDetails();
		List<LocalTransporter> trans=transService.getTransporterDetails();
		List<Post> landPageCustomers=postService.getLandPageCustomers();
		if(!landPageCustomers.isEmpty()){
			log.info("No Land Page Customer are there");
		
			model.addAttribute("landPageInfo",landPageCustomers);
		}
		model.addAttribute("PostDetail",ListPost);
		model.addAttribute("listTrans",trans);
		model.addAttribute("ec", ec);
		
	}
	
	
	
	@ModelAttribute
	public void getAllVehicleType(Model model){
		
		List<TruckInfo> vehi=priceservice.getAllVehicleTypes();
		List<String> materialList=priceservice.getAllMaterials();
		model.addAttribute("VehicleTypeList", vehi);
		model.addAttribute("MaterialList", materialList);
		
	}
	
	
	
	@RequestMapping(value="/teleLogin",method = RequestMethod.GET)
	public ModelAndView submit(@ModelAttribute("teleLogin") Telecaller lc) throws Exception {
		
		log.info("Username-->"+lc.getUserName()+"-->paassword-->"+lc.getPassword());
		
	
		
		String email=lc.getUserName();
		String password=lc.getPassword();
		
		
		if (!email.isEmpty() && !password.isEmpty() && lc.getTelecallerActive()==0 ) {
			
			
		
				Telecaller tname=postService.checkTelecallerExistsorNot(email, password,lc.getUserType());
				
			
				
				if(tname.getStatusCode()!=200){
					
					log.info("Invalid Telecaller");
					
					ModelAndView model=new ModelAndView("TelecallerLogin");
					model.addObject("error", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Mobile and Password Incorrect</span>");
					return model;
					
				}
				
				log.info("valid  Telecaller"+tname);
				
				
				ModelAndView model=new ModelAndView("redirect:/bookHome");
				model.addObject("TelecallerInfo",tname);    
				return model;
			 
			
		} 
		else 
		{
			ModelAndView model=new ModelAndView("TelecallerLogin");
			return model;
		}
	}
	
	
	@RequestMapping("/teleLogout")  
	public ModelAndView TelecallerLogout(){  
	  
		
		Telecaller tele=new Telecaller();
		tele.setTelecallerActive(1);
		ModelAndView model=new ModelAndView("TelecallerLogin");
		model.addObject("TelecallerInfo", tele);
		return model;
	}
	
	@RequestMapping(value="/bookHome",method = RequestMethod.GET)
	public ModelAndView getTelecallerLoginPage(@ModelAttribute("TelecallerInfo") Telecaller tname,HttpServletRequest request ) throws Exception {
	
	
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*60);
		ModelAndView model=new ModelAndView("PostHome");
		return model;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/postID",method=RequestMethod.GET) 
	public ModelAndView getPost(@RequestParam("PostId") String bookingId,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
		
		
		log.info("TelecallerController---->getPostMethod-->BookingId---->"+bookingId);
	    
		
		if(bookingId!=null && tname.getTelecallerActive()==0)
		{
	    	
	    	Post PS=postService.getPostInformation(bookingId.toUpperCase().trim());
		
	    	
	    	
	    	log.info("TelecallerController-->Booking Information");
	    	
			if(PS.getStatusCode()!=404)
			{
				
				List<TruckInfo> trk=postService.getTruckInfoDetails();
				
				if(!PS.getStatus().equals("Canceled"))
				{
										
					List<Vehicle> veh=postService.getListTransporter(PS.getInfoTruck().getTruckId());
					
					log.info("TelecallerController---->getPost---->List<Vehicle>---->");
					
					Vehicle vehicle=postService.getDriverConfirmation(PS.getBookingId());
					
					LocalDriver driver=new LocalDriver();
					
					driver.setDriverId(0);
					PS.setDriver(driver);
					
					if(vehicle.getStatusCode()!=404)
					{
							if(PS.getStatus().equals("vehicle Arranged"))
							{
								
								CustomerPayment CP=postService.getCustomerPaymentInfo(PS.getInvoiceId());
								
								TripDetails trip=postService.getTripDetailsofBooking(PS.getBookingId());
								
								if(CP != null)
								{
										ModelAndView model=new ModelAndView("TelecallerPost");
										model.addObject("telePostinfo",PS);
										model.addObject("transinfo",vehicle);
										model.addObject("custPaymentinfo",CP);
										model.addObject("tripinfo", trip);
										model.addObject("TransList",veh);
										return model;
									
								}
								else
								{
								
										ModelAndView model=new ModelAndView("TelecallerPost");
									    model.addObject("telePostinfo",PS);
									    model.addObject("transinfo",vehicle);
										model.addObject("tripinfo", trip);
										model.addObject("TransList",veh);
									    return model;
								   
								}
							}
							else 
							{														
									
									CustomerPayment CP=postService.getCustomerPaymentInfo(PS.getInvoiceId());
									TripDetails trip=postService.getTripDetailsofBooking(PS.getBookingId());
									
									if(CP != null)
									{
											ModelAndView model=new ModelAndView("TelecallerPost");
											model.addObject("telePostinfo",PS);
											model.addObject("transinfo",vehicle);
											model.addObject("custPaymentinfo",CP);
											model.addObject("tripinfo", trip);
											model.addObject("TransList",veh);
											return model;
										
									}
									else
									{
											ModelAndView model=new ModelAndView("TelecallerPost");
										    model.addObject("telePostinfo",PS);
										    model.addObject("transinfo",vehicle);
										    model.addObject("TruckInfo",trk);
										    model.addObject("TransList",veh);
											model.addObject("tripinfo", trip);
										    return model;
									   
									}
							}
						}
						else
						{
							if(veh!=null)
							{
								ModelAndView model=new ModelAndView("TelecallerPost");
								model.addObject("telePostinfo",PS);
								model.addObject("TransList",veh);
								model.addObject("TruckInfo",trk);
								model.addObject("driverMsg","<span style='color:green;text-align:center;'>Waiting for driver confirmation. Please keep refreshing the page.</span>");
								return model;
							}
							else
							{
								ModelAndView model=new ModelAndView("TelecallerPost");
								model.addObject("telePostinfo",PS);
								model.addObject("TruckInfo",trk);
								model.addObject("driverMsg","<span style='color:green;text-align:center;'>Waiting for driver confirmation. Please keep refreshing the page.</span>");
								return model;
							}
							
							
						}
					
					}
					else
					{
						ModelAndView model = new ModelAndView("TelecallerPost");
						model.addObject("telePostinfo",PS);
						model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Your post is Canceled</span>");
						return model;
					}
					
				}
				else
				{
					ModelAndView model = new ModelAndView("PostHome");
					model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Booking details not found</span>");
					return model;
				}
			}
		    else 
			{
				ModelAndView model=new ModelAndView("PostHome"); 
				return model;
			}
			

	}
	
	@RequestMapping(value="/transMob",method = RequestMethod.POST)
	public ModelAndView gettransMob(@ModelAttribute("transMob") TransMobileInfo TMob) throws Exception {
	
		String transMob=TMob.getTransByMob();
		
		LocalTransporter trans=new LocalTransporter();
		trans=transService.getTransMobDetails(transMob);
		log.info("TelecallerController---->gettransMob---->getTransMobDetails---->"+trans);
		if(trans != null)
		{
			List<Vehicle> veh=transService.getVehicleDetailsByMob(transMob);
	
			if((veh != null) && !veh.isEmpty())
			{
				ModelAndView model=new ModelAndView("transporterDetails"); 
				model.addObject("listTransById",trans);
				model.addObject("listVehicle",veh);
				return model;
			}
			ModelAndView model=new ModelAndView("transporterDetails"); 
			model.addObject("listTransById",trans);
			model.addObject("msg","<span  style='background-color:#d9534f;padding:5px;color:white;'>No trucks are registered yet</span>");
			return model;
		}
		ModelAndView model=new ModelAndView("PostHome"); 
		model.addObject("transMobMsg","<span  style='background-color:#d9534f;padding:5px;color:white;'>No transporter details found</span>");
		return model;
		
	}

	@RequestMapping(value="/transDetails",method = RequestMethod.GET)
	public ModelAndView gettransDetails(@ModelAttribute("transDetails") TransMobileInfo TransId) throws Exception{
	
		int transId=TransId.getTransById();
				
		LocalTransporter trans=new LocalTransporter();
		trans=transService.getTransportDetails(transId);
		
		List<Vehicle> veh=transService.getVehicleDetails(transId);
		System.out.println(veh);
		if((veh != null) && !veh.isEmpty())
		{
			System.out.println("inside if");
			
				ModelAndView model=new ModelAndView("transporterDetails"); 
				model.addObject("listTransById",trans);
				model.addObject("listVehicle",veh);
				return model;
		}
		ModelAndView model=new ModelAndView("transporterDetails"); 
		model.addObject("listTransById",trans);
		model.addObject("msg","<span  style='background-color:#d9534f;padding:5px;color:white;'>No trucks are registered yet</span>");
		return model;
	}
	
@RequestMapping(value="/confirmPost",method=RequestMethod.POST) 
	
	public ModelAndView confirmPost(@ModelAttribute("confirmPost") TelePostinfo TelePos, @ModelAttribute("telePostinfo") Post pos,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
		
		TruckInfo ti=new TruckInfo();
		
		//Uncomment the following code if Name and cOntact field in the telecaller page are made editable
		
		ti.setTruckName(TelePos.getTrucktype());
		//ti.setTruckId(pos.getTruckId().getTruckId());
		pos.setInfoTruck(ti);
		
		//pos.setFromCity(TelePos.getUserFrom());
		//pos.setToCity(TelePos.getUserTo());
		pos.setPickUpArea(TelePos.getUserPickup());
		pos.setDropArea(TelePos.getUserDrop());
		pos.setMaterial(TelePos.getUserMaterial());
		pos.setTravelDate(TelePos.getUserTravelDate());
		pos.setTotalAmount(Float.parseFloat(TelePos.getUserQuotedAmount()));
		pos.setRecepientName(TelePos.getUserRecipientName());
		pos.setRecepientMobile(TelePos.getUserRecipientContact());
		pos.setApproximateWeight(TelePos.getApproximateWeight());
		pos.setValueOfGoods(TelePos.getValueOfGoods());
		pos.setStatus("Customer Confirmed");
		pos.setHelper(TelePos.getUserHelper());
		postService.updatePostDetails(pos);
	
	
		Post PS=postService.getPostInformation(pos.getBookingId());
		List<Vehicle> veh=postService.getListTransporter(pos.getInfoTruck().getTruckId());

		
		//check if account is present for user
		
		int AccId=postService.getAccountsId(pos.getUser().getUserId());
		if(AccId==0)
		{
			//if account not present, create an account
			postService.addToAccounts(pos.getUser().getUserId());
		}
		
		LocalDriver driver=driverService.getDriverForPushNotification(PS);
		PS.setDriver(driver);  
		 
		if(veh!=null)
		  {
		   if(driver.getDriverId()==0)
		   {
		    ModelAndView model=new ModelAndView("TelecallerPost");
		    model.addObject("TransList",veh);
		    model.addObject("driverNotificationMsg","OOPS!! No driver found in your area");
		    model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Booking is confirmed</span>");
		    model.addObject("driverMsg","<span style='color:green;text-align:center;'>No Driver Found</span>");
		    return model;
		   }
		   else
		   {
		    ModelAndView model=new ModelAndView("TelecallerPost");
		    model.addObject("TransList",veh);
		    model.addObject("telePostinfo",PS);
		    model.addObject("driverNotificationMsg","Driver notification sent to");
		    model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Booking is confirmed</span>");
		    model.addObject("driverMsg","<span style='color:green;text-align:center;'>Waiting for driver confirmation. Please refresh here.</span>");
		    return model;
		   }
		   
		  }
		  else
		  {
		   if(driver.getDriverId()==0)
		   {
		    ModelAndView model=new ModelAndView("TelecallerPost");
		    model.addObject("driverNotificationMsg","OOPS!! No driver found in your area");
		    model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Booking is confirmed</span>");
		    model.addObject("driverMsg","<span style='color:green;text-align:center;'>Waiting for driver confirmation. Please refresh here.</span>");
		    return model;
		   }
		   else
		   {
		    ModelAndView model=new ModelAndView("TelecallerPost");
		    model.addObject("telePostinfo",PS);
		    model.addObject("driverNotificationMsg","Driver notification sent to");
		    model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Booking is confirmed</span>");
		    model.addObject("driverMsg","<span style='color:green;text-align:center;'>Waiting for driver confirmation. Please refresh here.</span>");
		    return model;
		    
		   }
		   
		   
		  }
		 }

		 
		 @RequestMapping(value="/resendPost",method=RequestMethod.GET) 
		 
		 public ModelAndView resendPostCntrl(@ModelAttribute("telePostinfo") Post pos,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
		  
		  
			LocalDriver  driver=driverService.getDriverForPushNotification(pos);
			  if(driver.getDriverId()==0)
			  {
			   ModelAndView model=new ModelAndView("TelecallerPost");
			   model.addObject("driverNotificationMsg","OOPS!! No driver found in your area");
			   return model;
			  }
			  else
			  {
				  
			   pos.setDriver(driver); 
			   ModelAndView model=new ModelAndView("TelecallerPost");
			   model.addObject("telePostinfo",pos);
			   model.addObject("driverNotificationMsg","Driver notification sent to");
			   return model;
			   
			  }
		  
		 }
	
	@RequestMapping(value="/cancel",method=RequestMethod.GET) 

	public ModelAndView getCancel(@ModelAttribute("telePostinfo") Post pos,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
		
		pos.setStatus("Canceled");
		postService.updateCancel(pos);
		
		ModelAndView model=new ModelAndView("TelecallerPost");
		model.addObject("message", "<span style='background-color:#d9534f;padding:5px;color:white;'>Your Booking has been canceled</span>");
		return model;
		
	}
	
	
	@RequestMapping(value="/driverCancel",method=RequestMethod.GET) 

	public ModelAndView driverCancel(@RequestParam("group1") int penaltyAmount, @ModelAttribute("telePostinfo") Post pos) throws Exception{
		
		
		
		log.info("Telecaller Controller-->DriverCancel Method-->bookingId-->"+pos.getRefPostId()+"-->driverId-->"+pos.getDriver().getDriverId()+"-->Penalty Amount-->"+penaltyAmount);
		
		
		int success=postService.driverCanceledtheTrip(pos.getRefPostId(), pos.getDriver().getDriverId(), penaltyAmount);
		
		if(success==1){
		
		ModelAndView model=new ModelAndView("TelecallerPost");
		model.addObject("message", "<span style='background-color:#d9534f;padding:5px;color:white;'>Please, Assign The New Driver</span>");
		return model;
		
		}
		
		ModelAndView model=new ModelAndView("TelecallerPost");
		model.addObject("message", "<span style='background-color:#d9534f;padding:5px;color:white;'>No Penalty for Driver</span>");
		return model;
		
	}
	
	
	@RequestMapping(value="/noResponse",method=RequestMethod.GET) 

	public ModelAndView driverNoResponse( @ModelAttribute("telePostinfo") Post pos){
		
		
		int success=postService.NoResponseFromDriver(pos.getRefPostId(), pos.getDriver().getDriverId());

		if(success==1){
			
			ModelAndView model=new ModelAndView("TelecallerPost");
			model.addObject("message", "<span style='background-color:#d9534f;padding:5px;color:white;'>Please, Assign The New Driver</span>");
			return model;
			
			}	
		
		
		ModelAndView model=new ModelAndView("TelecallerPost");
		model.addObject("message", "<span style='background-color:#d9534f;padding:5px;color:white;'> No Driver Found</span>");
		return model;
	}
	
	
	
	
	
	

	@RequestMapping(value="/confirmTrans",method=RequestMethod.POST) 
	public ModelAndView ConfirmTrans(@RequestParam("driverId") int driverId, @ModelAttribute("telePostinfo") Post pos,@ModelAttribute("TransList") Vehicle veh,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
		
		log.info("DriverId-->"+driverId+"-->bookingID-->"+pos.getBookingId());
		if(pos.getStatus().equals("Customer Confirmed") || pos.getStatus().equals("Vehicle Arranged") )
		{
			pos.setStatus("Vehicle Arranged");
			
			LocalDriver driver=new LocalDriver();
			
				
			transService.SaveTransConfirm(driverId,pos);
			
			driver=driverService.getManuallyDriverForPushNotification(pos,driverId);
			pos.setDriver(driver);
	
			
			Vehicle vehicle=postService.getDriverConfirmation(pos.getBookingId());
			pos.setVehi(vehicle);
		
			ModelAndView model=new ModelAndView("TelecallerPost");
			model.addObject("transinfo",vehicle);
			 model.addObject("telePostinfo",pos);
			model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Notification Sent to Driver </span>");
			return model;
		}
		else if(pos.getStatus().equals("Canceled"))
		{
			ModelAndView model=new ModelAndView("TelecallerPost");
			model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Your Booking is Canceled</span>");
			return model;
		}
		else
		{
			ModelAndView model=new ModelAndView("TelecallerPost");
			model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Driver is Already Assigned</span>");
			return model;
		}
	}
	
	
	
	@RequestMapping(value="/custPayment",method=RequestMethod.POST) 
	public ModelAndView CustPayment(@RequestParam("totalAmount1") float totalAmount, @ModelAttribute("telePostinfo") Post pos,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
		
		
		log.info("Telecaller Controller-->Customer Payment-->TotalAmount-->"+totalAmount);
		
		
		
	
		pos.setStatus("Completed");
		
		float finalAmount=postService.updateTotalAmountAfterPayment(pos,totalAmount);
		
		
		smsservice.confirmationSmsAfterFinish(pos.getUser().getMobileNo(),pos.getBookingId(), finalAmount);
		
		ModelAndView model=new ModelAndView("TelecallerPost");
		model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Customer Payment Successful</span>");
		model.addObject("telePostinfo", pos);
		return model;
		
		
	}
	
	
	@RequestMapping(value="/loadUnload",method=RequestMethod.POST) 
	public ModelAndView LoadUnload(@ModelAttribute("loadUnload") TelePostinfo TelePos, @ModelAttribute("telePostinfo") Post pos,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
		
		String status=TelePos.getLoadUnload();
		 
		String statusDate=TelePos.getWebtime();
		
		
		if(status.equals("Source Reached"))
		{
			String schedule=postService.checkStatus(pos.getBookingId());
			
			if(schedule.equals("Vehicle Arranged"))
			{								
				pos.setStatus(status);
				pos.setSrcReachedDateTime(statusDate);
				
				int afterupdate=postService.srcReached(pos);

				if(afterupdate!=0)
				{
					ModelAndView model=new ModelAndView("TelecallerPost");
					model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Status updated</span>");
					return model;
				}
				else{
					ModelAndView model=new ModelAndView("TelecallerPost");
					model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Cannot update status</span>");
					return model;
				}
				
			}
			else{
				ModelAndView model=new ModelAndView("TelecallerPost");
				model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Confirm the transporter before loading</span>");
				return model;
			}
		}
		else if(status.equals("Loading Completed"))
		{
			String schedule=postService.checkStatus(pos.getBookingId());
			if(schedule.equals("Source Reached"))
			{
			
				pos.setStatus(status);
				pos.setLoadingDateTime(statusDate);
				
				int afterupdate=postService.updateLoad(pos);

				if(afterupdate!=0)
				{
					ModelAndView model=new ModelAndView("TelecallerPost");
					model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Status updated</span>");
					return model;
				}
				else{
					ModelAndView model=new ModelAndView("TelecallerPost");
					model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Cannot update status</span>");
					return model;
				}
				
			}
			else{
				ModelAndView model=new ModelAndView("TelecallerPost");
				model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Can not load the truck before it reach souce</span>");
				return model;
			}
		}
		else if(status.equals("Destination Reached"))
		{
			String schedule=postService.checkStatus(pos.getBookingId());
			if(schedule.equals("Loading Completed"))
			{
				pos.setStatus(status);
				pos.setDestReachedDateTime(statusDate);
				
				int afterupdate=postService.destReached(pos);
				
				if(afterupdate!=0)
				{
					ModelAndView model=new ModelAndView("TelecallerPost");
					model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Status updated</span>");
					return model;
				}
				else{
					ModelAndView model=new ModelAndView("TelecallerPost");
					model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Cannot update status</span>");
					return model;
				}
				
			}
			else{
				ModelAndView model=new ModelAndView("TelecallerPost");
				model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Can not update the status before loading completed</span>");
				return model;
			}
		}
		else if(status.equals("Unloading Finished"))
		{
			String Load=postService.checkStatus(pos.getBookingId());
			if(Load.equals("Destination Reached"))
			{
				
					pos.setStatus(status);
					pos.setUnloadingDateTime(statusDate);
					
					postService.updateUnload(pos);
					
					ModelAndView model=new ModelAndView("TelecallerPost");
					model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Status updated</span>");
					return model;
				
			}
			else
			{
				ModelAndView model=new ModelAndView("TelecallerPost");
				model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Can not unload the truck before it reaches destination</span>");
				return model;
			}
		}
		else if(status.equals("null"))
		{
				ModelAndView model=new ModelAndView("TelecallerPost");
				model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Please select the status</span>");
				return model;
			
		}
		ModelAndView model=new ModelAndView("TelecallerPost");
		model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Invalid Choice</span>");
		return model;
	}
	
	
	
	
	@RequestMapping(value="/addPrice",method=RequestMethod.POST) 
	public ModelAndView UpdateAdditionalPrice(@ModelAttribute("additionalPrice") AddtionalPricePojo additionalPrice,@ModelAttribute("telePostinfo") Post pos,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
		
	
		
	
	
		pos=postService.updateAdditionalPrice(additionalPrice,pos);
		
		if(pos.getStatusCode()==200){
		
		
		ModelAndView model=new ModelAndView("TelecallerPost");
		model.addObject("telePostinfo",pos);	
		return model;
		}
		
		
		ModelAndView model=new ModelAndView("TelecallerPost");
		model.addObject("telePostinfo",pos);	
		return model;
		
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/invoice",method=RequestMethod.GET)  
	public ModelAndView invoice(@ModelAttribute("telePostinfo") Post pos,@ModelAttribute("transinfo")Vehicle vehi,@ModelAttribute("TelecallerInfo") Telecaller tname ) throws Exception{
		
		
		pos.setVehi(vehi);
		
		String start_dt =pos.getTravelDate();
		log.info("Before Parsing-->TravelDate-->"+pos.getTravelDate());
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		
		Date date = (Date)formatter.parse(start_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String finalString = newFormat.format(date);
		log.info("After Parsing-->TravelDate-->"+finalString);
		
		
		pos.setAcceptedTime(finalString);
		ApplicationContext context = new ClassPathXmlApplicationContext("com/cogzy/gtruckways/controller/applicationContext.xml");
		
		 EmailSenderService  mailer =  (EmailSenderService) context.getBean("mailMail");
		
		
		
		 mailer.sendConfirmationEmail(pos);
		
		    ModelAndView model=new ModelAndView("invoice"); 
			model.addObject("telePostinfo",pos);
			return model;
		
	}
	
	
	
	
	
	@RequestMapping(value="/cancelInvoice",method=RequestMethod.GET) 
	public ModelAndView getCancelInvoice(@ModelAttribute("telePostinfo") Post pos) throws Exception{
		
		Invoice in=new Invoice();
		
		
		in=postService.getCancelationInvoiceDetails(pos.getRefPostId());
		
		
		if(in.getStatusCode()==404)
		{
			ModelAndView model=new ModelAndView("TelecallerPost");
			model.addObject("message", "<span  style='background-color:#d9534f;padding:3px;color:white;font-size:12px;'>Cancel Invoice is not Applicable for this Booking Id </span>");
			return model;
		}
		else
		{
			ModelAndView model=new ModelAndView("cancel_invoice");
			model.addObject("invoiceDetails",in);
			return model;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/updateFeedback",method=RequestMethod.POST) 

	public ModelAndView updateFeedback(@ModelAttribute("custPayment") DriverFeedbackPojo feedback,@ModelAttribute("telePostinfo") Post pos) throws Exception{
		
		LocalDateTime dateTime=LocalDateTime.now().withNano(0);
		
		System.out.println("inside updateFeedback");
		boolean flag=postService.updateFeedback(feedback.getFeedback(),dateTime,pos);
		if(flag)
		{
			ModelAndView model=new ModelAndView("TelecallerPost");
			model.addObject("feedback", "Set");
			model.addObject("message", "<span style='background-color:#5cb85c;padding:3px;color:white;font-size:12px;'>Feedback recorded</span>");
			return model;
		}
		else
		{
			ModelAndView model=new ModelAndView("TelecallerPost");
			model.addObject("feedback", "NotSet");
			model.addObject("message", "<span  style='background-color:#d9534f;padding:5px;color:white;'>Cannot Update feedback</span>");
			return model;
		}
		
	}
	
	@RequestMapping(value="/refreshTrans",method=RequestMethod.GET) 

	 public ModelAndView refreshTransCntrl(@ModelAttribute("telePostinfo") Post pos) throws Exception{
	  
	  Vehicle vehicle=postService.getDriverConfirmation(pos.getRefPostId());
	  
	  if(vehicle!=null)
	  {
	   ModelAndView model=new ModelAndView("TelecallerPost");
	   model.addObject("transinfo",vehicle);
	   model.addObject("message", "<span style='background-color:#5cb85c;padding:3px;color:white;font-size:12px;'>Driver is confirmed</span>");
	   return model;
	  }
	  else
	  {
	   ModelAndView model=new ModelAndView("TelecallerPost");
	   model.addObject("message", "<span style='background-color:#d9534f;padding:3px;color:white;font-size:12px;'>Waiting for driver confirmation</span>");
	   return model;
	  }
	  
	 }
	
	@RequestMapping(value="/driverDetails",method=RequestMethod.POST) 

	public ModelAndView getDriverDetails(@RequestParam("regNo") String vehicleRegNo) throws Exception{
		
	
		DriverDetailsResponse driverResp=postService.getDriverDetails(vehicleRegNo);
		
		
		if(driverResp.getStatusCode()==401||driverResp.getStatusCode()==500){
			
			ModelAndView model=new ModelAndView("Driver_mgt");
			 model.addObject("msg", "<span style='background-color:#d9534f;padding:3px;color:white;font-size:12px;'>Vehicle is Not Registered With Us</span>");
			 return model;
			
		}
		
		
		
		 ModelAndView model=new ModelAndView("Driver_mgt");
		 model.addObject("driverDetails", driverResp);
		 return model;
	
	}
	
	@RequestMapping(value="/ChangeStatus",method=RequestMethod.GET) 
	
	public ModelAndView changeTheDriverStatus(@RequestParam("status") int driverStatusId,@ModelAttribute("driverDetails")DriverDetailsResponse driverResp ) throws Exception{

		
		
		int success=postService.updateDriverStatus(driverResp.getDriverId(), driverStatusId);
		
		
		if(success==400){
			
			ModelAndView model=new ModelAndView("Driver_mgt");
			model.addObject("message", "<span style='background-color:#5cb85c;padding:3px;color:white;font-size:12px;'>Unable to Update The Status</span>");
			 model.addObject("driverDetails", driverResp);
			 return model;
			
		}
		
		 driverResp=postService.getDriverDetails(driverResp.getVehicleRegNo());
		
		ModelAndView model=new ModelAndView("Driver_mgt");
		model.addObject("message", "<span style='background-color:#5cb85c;padding:3px;color:white;font-size:12px;'>Status Updated Successfully</span>");
		model.addObject("driverDetails", driverResp);
		return model;
	}
	
	@RequestMapping(value="/DrivertripDetails",method=RequestMethod.POST) 
	
	public ModelAndView getBookDetailsofDriver(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,@ModelAttribute("driverDetails")DriverDetailsResponse driverResp ) throws Exception{

		log.info("FromDate-->"+fromDate+"-->ToDate"+toDate);
		
		List<Post> bookresp=new ArrayList<Post>();
		
		bookresp=postService.getTripResponseOfDriver(driverResp.getDriverId(), fromDate, toDate);
		
		
		TripDetails dailytripinfo=postService.getDailyKmAndMinsofVehicleRegNo(fromDate,toDate,driverResp.getVehicleRegNo());
		
		log.info("FromDate-->"+bookresp);
		if(bookresp.isEmpty()){
			
			log.info("FromDate-->"+bookresp);
			ModelAndView model=new ModelAndView("Driver_mgt");
			model.addObject("message", "<span style='background-color:#d9534f;padding:3px;color:white;font-size:12px;'>No Trip Details Found For this Driver</span>");
			model.addObject("driverDetails", driverResp);
			model.addObject("dailyinfo",dailytripinfo);
			return model;
		}
		
		

		ModelAndView model=new ModelAndView("Driver_mgt");
		model.addObject("BookDetails", bookresp);
		model.addObject("driverDetails", driverResp);
		model.addObject("dailyinfo",dailytripinfo);
		return model;
		
		
	}
	
@RequestMapping(value="/trip",method=RequestMethod.GET) 
	
	public ModelAndView getIncentivesAndDeductions(@RequestParam("bookingId") String bookingId ,@ModelAttribute("driverDetails")DriverDetailsResponse driverResp,@ModelAttribute("dailyinfo") TripDetails dailytripinfo) throws Exception{


	
	DriverTripDetailsResponse tripResp=postService.getIncentivesAndDeductions(driverResp.getDriverId(), bookingId);
	log.info("tripDate-->"+tripResp.gettDate());
	
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();
	String todayDate=dateFormat.format(cal.getTime());
	
	
	log.info("tripDate-->"+todayDate);
	tripResp.setTodayDate(todayDate);
	
	LiveTracking lt=postService.getBookWiseTracking(tripResp.getBookingId(),tripResp.getSourceReachedDateTime(),tripResp.getDestReachedDateTime());
	
	log.info("distance"+lt.getDistance()+"-->time-->"+lt.getTimeMins());

	
	if(tripResp.getStatusCode()==404||tripResp.getStatusCode()==500){
		
		ModelAndView model=new ModelAndView("Driver_mgt");
		model.addObject("message", "<span style='background-color:#5cb85c;padding:5px;color:white;'>Invalid BookingId</span>");
		model.addObject("driverDetails", driverResp);
		model.addObject("liveinfo", lt);
		return model;
	}
	
	
	ModelAndView model=new ModelAndView("Driver_mgt");
	model.addObject("driverDetails", driverResp);
	model.addObject("TripDetails", tripResp);
	model.addObject("liveinfo", lt);
	return model;
}
	
@RequestMapping(value="/dedadd",method=RequestMethod.GET) 

public ModelAndView addDeductions(@RequestParam("dedAmt") int dedAmount,@RequestParam("reason") String reason,@ModelAttribute("driverDetails")DriverDetailsResponse driverResp,@ModelAttribute("TripDetails") DriverTripDetailsResponse tripResp ) throws Exception{
	
	
	DriverTripDetailsResponse resp1=new DriverTripDetailsResponse();
	
	resp1=postService.addDeductions(dedAmount, reason, driverResp, tripResp.getBookingId());
	
	if(resp1.getStatusCode()==500){
		
		ModelAndView model=new ModelAndView("Driver_mgt");
		model.addObject("driverDetails", driverResp);
		model.addObject("TripDetails", tripResp);
		model.addObject("message", "<span style='background-color:#5cb85c;padding:3px;color:white;font-size:12px;'>Deductions are not Added Successfully</span>");
		return model;	
		
	}
	
	tripResp.setDeductions(resp1.getDeductions());
	tripResp.setSumDeductions(resp1.getSumDeductions());
	float driverAmount=(tripResp.getTripEarnings()+tripResp.getSumIncentives())-tripResp.getSumDeductions();
	tripResp.setDriverAmount(driverAmount);

	
	
	ModelAndView model=new ModelAndView("Driver_mgt");
	model.addObject("driverDetails", driverResp);
	model.addObject("TripDetails", tripResp);
	model.addObject("message", "<span style='background-color:#5cb85c;padding:3px;color:white;font-size:12px;'>Deductions are added Successfully</span>");
	return model;
	
	
	}
	

@RequestMapping(value="/dailyKms",method=RequestMethod.POST) 

public ModelAndView DailyInformationOfVehicle(@ModelAttribute("dailyinfo") TripDetails dailyInfo) throws Exception{
	


TripDetails dailytripinfo=postService.getDailyKmAndMinsofVehicleRegNo(dailyInfo.getFromDate(),dailyInfo.getToDate(), dailyInfo.getRegNo());
	
	ModelAndView model=new ModelAndView("driver_mgt_det");
	model.addObject("dailyinfo",dailytripinfo);
	return model;
	
		}
	

@RequestMapping(value="/smscust",method=RequestMethod.POST) 

public ModelAndView SmsInformationToCustomer(@ModelAttribute("smscust") SmsInformation smscust) throws Exception{
	
	
	
	smsservice.SendDriverInformationManuallyToCustomer(smscust);
	
	
	
	ModelAndView model=new ModelAndView("sms");
	model.addObject("msg","Message Sent Successfully");
	return model;
	
		}
	

@RequestMapping(value="/smsdriver",method=RequestMethod.POST) 

public ModelAndView SmsInformationToDriver(@ModelAttribute("smsdriver") SmsInformation smscust) throws Exception{
	

	smsservice.sendCustomerInformationToDriver(smscust);
	
	
	ModelAndView model=new ModelAndView("sms");
	model.addObject("msg","Message Sent Successfully");
	return model;
	
		}





// get Customer Information n TelecallerPage



@RequestMapping(value = "/custInfo", method = RequestMethod.GET)
public String getCustomerInformationPage(Model model,@ModelAttribute("TelecallerInfo") Telecaller tname) {								// the User object is used as a template to generate the form
log.info("mobile-->"+tname.getTelecallerEmail());
model.addAttribute("mobile",tname.getTelecallerEmail());
return "customer_information";
}



@RequestMapping(value="/getcustInfo",method=RequestMethod.GET) 

public ModelAndView getCustomerInformation(@RequestParam("infoId") String infoId,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
	

	
	log.info("BookingId or mobileNo or emailId-->"+infoId);
	
	
	Post post=postService.getCustomerInformation(infoId);
	
	
	
	ModelAndView model=new ModelAndView("customer_information");
	model.addObject("msg","Message Sent Successfully");
	model.addObject("bookInfo",post);
	return model;
	
		}



@RequestMapping(value="/tcustadd",method=RequestMethod.POST) 
public ModelAndView ManualSignupByTelecaller(@ModelAttribute("user") User use,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
	

	
		
	
	User user=postService.addCustomersManualy(use);
	
	
	
	
	ModelAndView model=new ModelAndView("redirect:/getcustInfo");
	model.addObject("infoId",user.getMobileNo());
	return model;
	
		}



@RequestMapping(value="/tbooking",method=RequestMethod.POST) 
public ModelAndView ManualBookingProcess(@ModelAttribute("post") Post post,@ModelAttribute("bookInfo") Post post1,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
	

	
		
	
	Post pos=postService.getManualBookingProcess(post);
	
	log.info(post1.getUser().getUserId());
	User use=new User();
	use.setUserId(post1.getUser().getUserId());
	use.setUserName(post1.getUser().getUserName());
	use.setMobileNo(post1.getUser().getMobileNo());
	use.setGstNumber(post1.getUser().getGstNumber());
	pos.setUser(use);
	pos.setStatusCode(201);
	ModelAndView model=new ModelAndView("customer_information");
	model.addObject("PostInfo", pos);
	return model;
	
		}




@RequestMapping(value="/tconfirmBooking",method=RequestMethod.POST) 
public ModelAndView ManualBookingProcessConfirmation(@ModelAttribute("PostInfo") Post post,@ModelAttribute("TelecallerInfo") Telecaller tname) throws Exception{
	

	log.info("UserId-->"+post.getUser().getUserId()+"-->Different Recepient-->"+post.getDifferentRecepient());
	
	Post pos=postService.insertBookingInformation(post);
	
	
	
	ModelAndView model=new ModelAndView("redirect:/getcustInfo");
	model.addObject("PostInfo", post);
	model.addObject("infoId",post.getUser().getMobileNo());	
	return model;
	
		}

@RequestMapping(value="/landConfirm/{mobile}/{custId}",method=RequestMethod.GET) 
public ModelAndView getLandPageConfirmation(@PathVariable("mobile") String mobile,@PathVariable("custId") int custId) throws Exception{

	log.info("Mobile-->"+mobile);
	
	postService.landPageStatus(custId,"Confirmed");
	
	ModelAndView model=new ModelAndView("redirect:/custInfo");
	model.addObject("telecallerEmail",mobile);
	return model;
}
	

@RequestMapping(value="/landCancel/{custId}",method=RequestMethod.GET) 
public ModelAndView getLandPageCancelation(@PathVariable("custId") int custId) throws Exception{

	log.info("Customer Id-->"+custId);
	
	postService.landPageStatus(custId,"Canceled");
	
	ModelAndView model=new ModelAndView("redirect:/bookHome");
	return model;
}
	
	
}	
	
                
