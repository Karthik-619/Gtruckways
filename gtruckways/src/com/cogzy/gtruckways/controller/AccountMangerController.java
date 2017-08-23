package com.cogzy.gtruckways.controller;

import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cogzy.gtruckways.businessObjects.DriverAppResponse;
import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseTripDetails;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;
import com.cogzy.gtruckways.businessObjects.LiveTracking;
import com.cogzy.gtruckways.businessObjects.SchedulingVehicle;
import com.cogzy.gtruckways.businessObjects.SeoFile;
import com.cogzy.gtruckways.businessObjects.SpareTruckInfo;
import com.cogzy.gtruckways.businessObjects.Telecaller;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.businessObjects.EnterpriseOdometer;
import com.cogzy.gtruckways.serviceImpl.AccountManagerServiceImpl;
import com.cogzy.gtruckways.serviceImpl.TelePostServiceImpl;
import com.cogzy.gtruckways.validator.Log;


@Controller
@SessionAttributes({"enterpriseInfo","scheduleInfo","odometer","seoInfo"})
public class AccountMangerController extends HttpServlet {

	
	// account manager Controller
	
	@Autowired 
	AccountManagerServiceImpl accountservice;
	@Autowired
	TelePostServiceImpl postService;
	
	
	public TelePostServiceImpl getPostService() {
		return postService;
	}

	public void setPostService(TelePostServiceImpl postService) {
		this.postService = postService;
	}

	public AccountManagerServiceImpl getAccountservice() {
		return accountservice;
	}

	public void setAccountservice(AccountManagerServiceImpl accountservice) {
		this.accountservice = accountservice;
	}


	private static Logger log = Logger.getLogger(Log.class.getName());

	
	@ModelAttribute
	public void getAllEnterpriseNames(Model model){
		
	List <EnterpriseCustomer> entcust=accountservice.getAllEnterpriseNames();
	
	model.addAttribute("EnterPriseNameList", entcust);
	
	}
	// EnterpriseAccount manager page
	
	 @RequestMapping("/entAcc")  
	    public ModelAndView showEntAccountManagerPage(){  
	        return new ModelAndView("Enterprise_Contract");  
	    }

	 
	 @RequestMapping("/admin")  
	    public ModelAndView ShowSEOAdminPage(){  
	        
		   return new ModelAndView("Admin");  
	    }

	 
	 @RequestMapping("/blog")  
	 
	    public ModelAndView ShowBlogPage(){  
	       
		List<SeoFile> seo=accountservice.getAllSeoImagesAndData();
		 
		ModelAndView model=new ModelAndView("blog");
		model.addObject("seoImageInfo", seo);
		return model;
	  
	 }

	 
	 
	 
	 
	 @RequestMapping("/eschedule")  
	    public ModelAndView showEntDailyScheduling(){  
	        return new ModelAndView("Enterprise_Daily_scheduling");  
	    }
	
	 @RequestMapping("/espare")  
	    public ModelAndView showEntSpare(){  
	        return new ModelAndView("Enterprise_Spare");  
	    }
	
	 @RequestMapping("/estatus")  
	    public ModelAndView showEntStatus(){  
	        return new ModelAndView("Enterprise_Status");  
	    }
	
	 @RequestMapping("/epay")  
	    public ModelAndView showEntPAyment(){  
	        return new ModelAndView("Enterprise_payment");  
	    }
	 @RequestMapping("/eodo")  
	    public ModelAndView showEntOdometer(){  
	        return new ModelAndView("Enterprise_odometer");  
	    }
	 @RequestMapping("/entbill")  
	    public ModelAndView showEntBillingPage(){  
	        return new ModelAndView("Enterprise_Billing_details");  
	    }
	 @RequestMapping("/epaydash")  
	    public ModelAndView showEntpaydashBoard(){  
	        return new ModelAndView("Enterprise_paymentdashboard");  
	    }
	
	 
	 @RequestMapping("/map1")  
	    public ModelAndView showMap(){  
	        return new ModelAndView("maptest");  
	    }
	 
	 
	@RequestMapping(value="/enterpriseSearch",method=RequestMethod.POST) 
	public void EnterPriseSearch(@RequestParam("enterpriseName") String enterpriseName ,SessionStatus status,HttpServletResponse response ) throws Exception{
		
		/*AccountManagerServiceImpl cah = (AccountManagerServiceImpl)getServletContext().getAttribute("EnterpriseName");		
		Collection<EnterpriseCustomer> col = cah.prefixSearch(enterpriseName);
		Iterator<EnterpriseCustomer> itr = col.iterator();
		
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObj = null;
		int i=0;
		EnterpriseCustomer ent = null;
		
		while (itr.hasNext()) {
			ent = itr.next();
			jsonObj = new JSONObject();
			
			try{
				jsonObj.put("enterpriseName",ent.getEnterpriseName());
				jsonObj.put("enterpriseId",ent.getEnterpriseCustomerId());
				
				jsonArr.put(i++, jsonObj);
			}catch(JSONException e){
				e.printStackTrace();
			}
		}		
		
		response.getWriter().write(jsonArr.toString());
*/	
	}	
	

	@RequestMapping(value="/entsrch",method=RequestMethod.POST) 
	public ModelAndView enterpriseSearch(@RequestParam("enterpriseName") String enterpriseName,SessionStatus status,HttpServletResponse response ) throws Exception{
	
	
		
		EnterpriseCustomer ecust=accountservice.getEnterpriseDetails(enterpriseName);
		
		if (ecust.getStatusCode()==204){
			
			ModelAndView model=new ModelAndView("Enterprise_Contract");
			Log.info("AccountManagerController-->"+ecust.getStatus());
			ecust.setStatus(1);
			model.addObject("enterpriseInfo",ecust);
			return model;
			
		} else if(ecust.getStatusCode()==404||ecust.getStatusCode()==500){
			
			ModelAndView model=new ModelAndView("Enterprise_Contract");
			model.addObject("enterpriseInfo",ecust);
			return model;
			
		} else
		
		Log.info("AccountManagerController-->"+ecust.getContactPerson());
		
		ModelAndView model=new ModelAndView("Enterprise_Contract");
		model.addObject("enterpriseInfo",ecust);
		return model;
	
	
	
	}
	
	@RequestMapping(value="/asgTruck",method=RequestMethod.POST) 
	public ModelAndView assignTruck(@ModelAttribute("assignTruck") EnterpriseTruckAssign assign,@ModelAttribute("enterpriseInfo") EnterpriseCustomer ecust ,SessionStatus status,HttpServletResponse response ) throws Exception{
	
	
		
		Log.info("Account Manager Controller-->Assign Truck Service-->EnterPrise Status-->"+ecust.getStatus());
		
		if(ecust.getStatus()==1)
		{		
		
			int success= accountservice.assignVehicleToEnterprise(assign,ecust);
			ecust=accountservice.getEnterpriseDetails(ecust.getEnterpriseName());
			if(success==0){
			
			ModelAndView model=new ModelAndView("Enterprise_Contract");
			 model.addObject("entrMsg", "<span style='background-color:#d9534f;padding:5px;color:white;'>Unable to assign the Vehicle</span>");
			return model;
			}

		
			ModelAndView model=new ModelAndView("Enterprise_Contract");
			model.addObject("entrMsg", "<span style='background-color:#5cb85c;padding:3px;color:white;font-size;10px;'>Vehicle is assigned Successfully</span>");	
			model.addObject("enterpriseInfo",ecust);
			return model;
		
		
		
	} else{
		
		ModelAndView model=new ModelAndView("Enterprise_Contract");
		 model.addObject("entrMsg", "<span style='background-color:#d9534f;padding:3px;color:white;font-size:10px;'>Enterprise is Not Registered With Us</span>");
		return model;
	}
		
	}

	
	
	
	
	
	@ModelAttribute
	public void getDailyScheduling(Model model){
		
		List<SchedulingVehicle> schedule=accountservice.getDailySchedulingInformation();
		
		
		for(SchedulingVehicle sc :schedule){
			
			log.info("enterpriseId"+sc.getEnterpriseId());
		}
		
		
		 model.addAttribute("scheduleInfo",schedule);
		
	}
	
	
	@RequestMapping(value="/rgNo",method=RequestMethod.GET)
	public void getTruckRegNoFromAjax(@RequestParam("vehicleType") String vehicleType,HttpServletResponse response) throws IOException
	{
		
		int  vehicleTypeId=Integer.parseInt(vehicleType);
		log.info("Account Manager Controller-->AjaxRequest for Vehicle RegNo-->TruckType"+vehicleTypeId);
		
		List<Vehicle> vehi=accountservice.getTruckRegNo(vehicleTypeId);
		
		JSONArray arr = new JSONArray();
		
		
		int i=0;
		for(Vehicle a : vehi){
			
			JSONObject obj = new JSONObject();
			try{
				obj.put("regisNo",a.getVehicleRegistrationNo());
				
				
				arr.put(i++,obj);
			}catch(JSONException e){
				e.printStackTrace();
			}
		}
		
		response.getWriter().write(arr.toString());
	}
	
	@RequestMapping(value="chngEntDet",method=RequestMethod.POST)
	public ModelAndView changeEnterpriseDetails(@ModelAttribute("assign") EnterpriseTruckAssign assign,@ModelAttribute("enterpriseInfo") EnterpriseCustomer ecust){
		
		
		
		
		log.info(ecust.getEnterpriseCustomerId());
		log.info(assign.getVehicleRegNo());
		log.info(assign.getDestination());
		assign.setEnterpriseId(ecust.getEnterpriseCustomerId());
		int success=accountservice.updateEnterpriseVehicleDetails(assign);
		ecust=accountservice.getEnterpriseDetails(ecust.getEnterpriseName());
		
		log.info(success);
		if(success==404||success==500){
		
			ModelAndView model=new ModelAndView("Enterprise_Contract");
			 model.addObject("entrMsg", "<span style='background-color:#d9534f;padding:5px;color:white;'>Enterprise Details are Not Changed</span>");
			return model;
			
		}
		
		
		ModelAndView model=new ModelAndView("Enterprise_Contract");
		model.addObject("enterpriseInfo",ecust);
		 model.addObject("entrMsg", "<span style='background-color:#d9534f;padding:5px;color:white;'>Enterprise Details are Changed Successfully</span>");
		return model;
	}
	
	
	@RequestMapping(value="rmVehi",method=RequestMethod.POST)
	public ModelAndView EnterpriseVehicleContractCancel(@RequestParam("vehicleRegNo") String vehicleRegNo,@ModelAttribute("enterpriseInfo") EnterpriseCustomer ecust){
	
		log.info(vehicleRegNo);
		int success=accountservice.EnterpriseVehicleContractCancel(vehicleRegNo);
		
		log.info(success);
		if(success==404||success==500){
			
			ModelAndView model=new ModelAndView("Enterprise_Contract");
			return model;
			
		}
		
		
		ModelAndView model=new ModelAndView("Enterprise_Contract");
		return model;
	}
	
	
	
	@RequestMapping(value="/entsparesrch",method=RequestMethod.POST) 
	public ModelAndView enterpriseSpareSearch(@RequestParam("enterpriseName") String enterpriseName,SessionStatus status,HttpServletResponse response ) throws Exception{
	
	
		
		EnterpriseCustomer ecust=accountservice.getEnterpriseDetails(enterpriseName);
		
		if (ecust.getStatusCode()==204){
			
			ModelAndView model=new ModelAndView("Enterprise_Spare");
			Log.info("AccountManagerController-->"+ecust.getStatus());
			ecust.setStatus(1);
			model.addObject("enterpriseInfo",ecust);
			return model;
			
		} else if(ecust.getStatusCode()==404||ecust.getStatusCode()==500){
			
			ModelAndView model=new ModelAndView("Enterprise_Spare");
			model.addObject("enterpriseInfo",ecust);
			return model;
			
		} else
		
		Log.info("AccountManagerController-->"+ecust.getContactPerson());
		
		ModelAndView model=new ModelAndView("Enterprise_Spare");
		model.addObject("enterpriseInfo",ecust);
		return model;
	
	
	
	}
	
	
	
	
	
	@RequestMapping(value="/sparesrch",method=RequestMethod.POST) 
	public ModelAndView spareEnterpriseVehicle(@RequestParam("regNo") String vehicleRegNo,@RequestParam("vehicleType") String vehicleType,@ModelAttribute("enterpriseInfo") EnterpriseCustomer ecust  , SessionStatus status,HttpServletResponse response ) throws Exception{
	
	
		
		log.info("Sparetruck regNo-->"+vehicleRegNo+"-->VehicleType-->"+vehicleType);
		
		SpareTruckInfo spare=accountservice.getSpareVehicles(vehicleType, vehicleRegNo);
		
		if(spare.getStatusCode()==404||spare.getStatusCode()==500){
			
			ModelAndView model=new ModelAndView("Enterprise_Spare");
			model.addObject("enterpriseInfo",ecust);
			return model;
			
		 } 
		
		
		
		ModelAndView model=new ModelAndView("Enterprise_Spare");
		model.addObject("enterpriseInfo",ecust);
		model.addObject("spareinfo",spare);
		return model;
	
	
	
	}
	
	
	@RequestMapping(value="/addspare",method=RequestMethod.POST) 
	public ModelAndView addSpareVehicles(@ModelAttribute("sinfo") SpareTruckInfo spare1, @ModelAttribute("enterpriseInfo") EnterpriseCustomer ecust,SessionStatus status,HttpServletResponse response ) throws Exception{
	
		
		log.info("Assign vehicle"+spare1.getAssignVehicleRegNo());
		
		int success=accountservice.insertSpareTruckDetails(spare1,ecust.getEnterpriseCustomerId());
	
		if(success==0){
	
			ModelAndView model=new ModelAndView("Enterprise_Spare");
			 model.addObject("entrMsg", "<span style='background-color:#d9534f;padding:5px;color:white;'>Spare Truck is Not Assigned </span>");
			return model;
		
			
		}
		
		ModelAndView model=new ModelAndView("Enterprise_Spare");
		 model.addObject("entrMsg", "<span style='background-color:#5cb85c;padding:3px;color:white;font-size:12px;'>Spare Truck is Assigned Successfully</span>");
		return model;
		}
	
	
	
	@RequestMapping(value="/reassign",method=RequestMethod.POST) 
	public ModelAndView reassignSpare(@ModelAttribute("sinfo") SpareTruckInfo spare2, @ModelAttribute("enterpriseInfo") EnterpriseCustomer ecust,SessionStatus status,HttpServletResponse response ) throws Exception{
	
	
	
	
		ModelAndView model=new ModelAndView("Enterprise_Spare");
		model.addObject("assignSpareInfo", spare2);
	
		return model;
		}
	
	
	@RequestMapping(value="/reassignSpare",method=RequestMethod.POST) 
	public ModelAndView reAssignSpareVehicles(@ModelAttribute("sinfo") SpareTruckInfo spare1 , @ModelAttribute("enterpriseInfo") EnterpriseCustomer ecust,SessionStatus status,HttpServletResponse response ) throws Exception{
	
		
		log.info("Reassign-->Spare-->"+spare1.getSpareVehicleRegNo()+"Regular-->"+spare1.getAssignVehicleRegNo());
		
		int success=accountservice.reassignOfVehicle(spare1.getAssignVehicleRegNo(), spare1.getSpareVehicleRegNo());
	
		log.info("Reassign-->Spare-->"+success);
		
		if(success==0){
	
			ModelAndView model=new ModelAndView("Enterprise_Spare");
			model.addObject("entrMsg", "<span style='background-color:#d9534f;padding:3px;color:white;font-size:12px;'>Truck is Not Re-Assigned</span>");
			return model;
		
			
		}
		
		ModelAndView model=new ModelAndView("Enterprise_Spare");
		 model.addObject("entrMsg", "<span style='background-color:#5cb85c;padding:3px;color:white;font-size:12px;'>Truck is Re-Assigned</span>");
		return model;
		}
	
	
	@RequestMapping(value="/enttripDetails",method=RequestMethod.POST) 
	public ModelAndView enterPriseTripDeatils(@ModelAttribute("enttrip") EnterpriseTripDetails eTrip ,SessionStatus status,HttpServletResponse response ) throws Exception{
	
	
		
		EnterpriseTripDetails eTrip1=accountservice.getEnterprsiePaymentDetails(eTrip.getStartDate(), eTrip.getEndDate(), eTrip.getEnterpriseName());
		
		
		ModelAndView model=new ModelAndView("Enterprise_payment");
		model.addObject("epayinfo", eTrip1);
		return model;
	
	}
	
	
	@RequestMapping(value="/entBal",method=RequestMethod.POST) 
	public ModelAndView enterBalanceInfoDeatils(@RequestParam("enterpriseName") String enterpriseName ,SessionStatus status,HttpServletResponse response ) throws Exception{
	
	
		
		EnterpriseVehicleStatus bal=accountservice.getvehicleStatus(enterpriseName);
		
		
		ModelAndView model=new ModelAndView("Enterprise_Status");
		model.addObject("balanceinfo", bal);
		return model;
	
	}
	
	@RequestMapping(value="/entodometer",method={ RequestMethod.POST, RequestMethod.GET }) 
	public ModelAndView enterpriseOdometerReading(@ModelAttribute("odometer2") EnterpriseOdometer odometer ,SessionStatus status,HttpServletResponse response,HttpSession session ) throws Exception{
	
	log.info("Redirection  odometer Readings-->"+odometer.getFromDate()+"-->To Date"+odometer.getToDate()+"-->regNo-->"+odometer.getVehicleRegNo());
		
		EnterpriseOdometer odometerReading=accountservice.getEnterpriseOdometerInformation(odometer.getFromDate(), odometer.getToDate(),odometer.getVehicleRegNo());
		
		
		ModelAndView model=new ModelAndView("Enterprise_odometer");
		model.addObject("odometer", odometerReading);
		return model;
	
	}
	
	
	@RequestMapping(value="/updateodo",method=RequestMethod.POST) 
	public ModelAndView updateEnterpriseOdometerReading(@ModelAttribute("odochanges") EnterpriseTripDetails odometer,@ModelAttribute("odometer") EnterpriseOdometer odometer1,SessionStatus status,HttpServletResponse response ) throws Exception{
	
	
	log.info("Update Enterprise odometer readings-->tripDate-->"+odometer.getTripDate()+"-->startReading-->"+odometer.getStartReading()+"-->End Reading-->"+odometer.getEndReading()+"-->entvehicleId-->"+odometer.getEnterpriseCustomerId());
	                
	int success=accountservice.updateEnterpriseOdometer(odometer);
	
	EnterpriseOdometer odometerReading=accountservice.getEnterpriseOdometerInformation(odometer1.getFromDate(), odometer1.getToDate(),odometer1.getVehicleRegNo());
	
	if(success==200){
	
		 
		
		
		ModelAndView model=new ModelAndView("Enterprise_odometer");
		model.addObject("odometer", odometerReading);
		return model;
		
	}
	
	log.info(odometer1.getFromDate());
	
		ModelAndView model=new ModelAndView("Enterprise_odometer");
		model.addObject("odometer", odometerReading);
		return model;
	
	}
	
	
	
	@RequestMapping(value="/liveTrack",method=RequestMethod.GET) 
	public ModelAndView getVehicleTrackingInformation(@RequestParam("regNo") String vehicleRegNo,@RequestParam("date") String trackDate, SessionStatus status,HttpServletResponse response ) throws Exception{
	
	
		
		log.info("AccountManagerController-->Live Tracking Method-->VehilceRegNo"+vehicleRegNo+"-->Date-->"+trackDate);
		
		
		
		LiveTracking lt=accountservice.getVehicleTracking(vehicleRegNo, trackDate);
	
		log.info("Distance-->"+lt.getDistance());
		
		if(lt.getDistance()==0){
			
			

			ModelAndView model=new ModelAndView("Track_Driver");
			model.addObject("liveinfo", lt);
			return model;
			
			
		}
		
		
		ModelAndView model=new ModelAndView("Track_Driver");
		model.addObject("liveinfo", lt);
		return model;
		

	
	}
	
	
	@RequestMapping(value="/alogin",method = RequestMethod.GET)
	public ModelAndView submit(@ModelAttribute("teleLogin") Telecaller lc) throws Exception {
		
		log.info("Username-->"+lc.getUserName()+"-->paassword-->"+lc.getPassword());
		
	
		
		String email=lc.getUserName();
		String password=lc.getPassword();
		
		
		if (!email.isEmpty() && !password.isEmpty() && lc.getTelecallerActive()==0 ) {
			
			
		
				Telecaller tname=postService.checkTelecallerExistsorNot(email, password,lc.getUserType());
				
			
				
				if(tname.getStatusCode()!=200){
					
					log.info("Invalid Telecaller");
					
					ModelAndView model=new ModelAndView("Admin");
					model.addObject("error", "<span  style='background-color:#d9534f;padding:4px;color:white;'>Email-Id and Password Incorrect</span>");
					return model;
					
				}
				
				log.info("valid  Telecaller"+tname);
				
				
				ModelAndView model=new ModelAndView("redirect:/adminlogin");
				model.addObject("seoInfo",tname);    
				return model;
			 
			
		} 
		else 
		{
			ModelAndView model=new ModelAndView("Admin");
			return model;
		}
	}
	
	
	@RequestMapping(value="/adminlogin",method = RequestMethod.GET)
	public ModelAndView SeoSubmit(@ModelAttribute("seoInfo") Telecaller lc) throws Exception {
		
		
		List<SeoFile> seo=accountservice.getAllSeoImagesAndData();
		
		
		ModelAndView model=new ModelAndView("adminaccess");
		model.addObject("seoImageInfo", seo);
		return model;
	}


	
	
	@RequestMapping(value = "/seoUploadFile", method = RequestMethod.POST)
	public ModelAndView getDriverImage(@RequestParam("file") CommonsMultipartFile fileUpload, @ModelAttribute("seoFile") SeoFile seo ,HttpServletRequest request,HttpServletRequest response,HttpSession session) throws Exception {
        
						fileUpload.getOriginalFilename();
		 byte[] bytes = fileUpload.getBytes();
		
		 ServletContext context = session.getServletContext();
		 
		
		 log.info("Image bytes-->"+bytes+"-->title-->"+seo.getTitle()+"content-->"+seo.getContent()+"fileupload-->"+fileUpload);
		 
		 InputStream fis=fileUpload.getInputStream();
		 
		 log.info("Inputstream-->"+fis);
		 seo.setData(bytes);
	
		 byte[] b=accountservice.saveSeoImageInformation(seo, fis);
		
		
		 
		 ModelAndView model=new ModelAndView("redirect:/adminlogin");
		 return model;
      }
	
	

	@ModelAttribute
	@RequestMapping(value = "/something/getImg{imageId}", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> ListImage(@PathVariable int imageId) throws IOException{
	   
		
		byte[] image=accountservice.getImage(imageId);
	    
		final HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.IMAGE_JPEG);
	    
		return new ResponseEntity<byte[]>(image, headers, HttpStatus.CREATED);
	}


	
	
	@RequestMapping(value="/seoUpdate",method = RequestMethod.GET)
	public ModelAndView UpdateSeoContent(@ModelAttribute("seoUpdateInfo") SeoFile lc) throws Exception {
		
		log.info("ImageId-->"+lc.getImageId());
		
		int seo=accountservice.updateSeoInformation(lc);
		
		
		ModelAndView model=new ModelAndView("redirect:/adminlogin");
		
		return model;
	}
	
	
	@RequestMapping(value="/seoDelete",method = RequestMethod.GET)
	public ModelAndView DeleteSeoImageAndContent(@RequestParam("id") int imageId) throws Exception {
		
		log.info("ImageId-->"+imageId);
		
		int success=accountservice.deleteImages(imageId);
		
		
		ModelAndView model=new ModelAndView("redirect:/adminlogin");
		return model;
	}
	
	

}