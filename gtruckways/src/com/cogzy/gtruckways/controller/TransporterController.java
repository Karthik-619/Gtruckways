package com.cogzy.gtruckways.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cogzy.gtruckways.businessObjects.AmountDetails;
import com.cogzy.gtruckways.businessObjects.Deductions;
import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.Incentives;
import com.cogzy.gtruckways.businessObjects.LocalTransporter;
import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Vehicle;
import com.cogzy.gtruckways.service.EmailSenderService;
import com.cogzy.gtruckways.serviceImpl.SmsServiceImpl;
import com.cogzy.gtruckways.serviceImpl.TelePostServiceImpl;
import com.cogzy.gtruckways.serviceImpl.TransporterServiceImpl;
import com.cogzy.gtruckways.valueObjects.TeleAddTrucksInfo;
import com.cogzy.gtruckways.valueObjects.TrackTransporterRequestPojo;
import com.cogzy.gtruckways.valueObjects.TransporterRequestPojo;
import com.cogzy.gtruckways.valueObjects.VehicleInfoPojo;



@Controller
public class TransporterController {

	@Autowired
	TransporterServiceImpl transService;

	@Autowired
	TelePostServiceImpl postService;
	
	@Autowired
	SmsServiceImpl smsservice;
	
	public TelePostServiceImpl getPostService() {
		return postService;
	}
	public void setPostService(TelePostServiceImpl postService) {
		this.postService = postService;
	}
	
	public TransporterServiceImpl getTransService() {
		return transService;
	}
	public void setTransService(TransporterServiceImpl transService) {
		this.transService = transService;
	}
	
	@ModelAttribute
	public void getBookingDetails(Model model){
		List<EnterpriseCustomer> ec=transService.getEnterpriseDetails();
	
		List<Post> ListPost=postService.getPostDetails();
		List<LocalTransporter> trans=transService.getTransporterDetails();
	
		model.addAttribute("PostDetail",ListPost);
		model.addAttribute("listTrans",trans);
		model.addAttribute("ec", ec);
		
	}
	

	@RequestMapping(value="/vehicleReg",method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("teleAddTrucks") TeleAddTrucksInfo addTruck) throws Exception {
		
		if(transService.checkValidTransId(addTruck.getTransportID()))
		{
			if(!transService.checkDuplicateVehicle(addTruck))
			{
				if(!transService.checkDuplicateDriver(addTruck))
				{
					String password =transService.AddNewTrucks(addTruck);
					
					if(!password.equals("ABB")){
						
					
						smsservice.sendSmsToDriverPasswordAndUserNameAfterRegistration(addTruck.getDriverMobile(),password,addTruck.getDriverName());
					}	
					ModelAndView model=new ModelAndView("PostHome");
					model.addObject("truckMsg","<span style='color:green;font-size:14px;'>Vehicle Details are added Successfully </span>");
					return model;
					
				}
				else
				{
					// driver details exists
					//exit
					ModelAndView model=new ModelAndView("PostHome");
					model.addObject("truckMsg","<span style='color:green;font-size:14px;'>OOPS!! Driver Details already exists</span>");
					return model;
					
				}
				
			}
			else
			{
				//vehicle already exists
				//exit
				ModelAndView model=new ModelAndView("PostHome");
				model.addObject("truckMsg","<span style='color:green;font-size:14px;'>OOPS!! Vehicle is already registered</span>");
				return model;
			}
		}
		else
		{
			ModelAndView model=new ModelAndView("PostHome");
			model.addObject("truckMsg","<span style='color:green;font-size:14px;'>OOPS!! Transporter is not registered</span>");
			return model;
		}
	
	}
	
	@RequestMapping(value="/vehRegDetails",method = RequestMethod.GET)
	public ModelAndView submit(@ModelAttribute("vehRegDetails") VehicleInfoPojo vehInfo) throws Exception {
		String vehRegNum=vehInfo.getVehRegNum();
		 if(vehRegNum!=null)
			{
		    	Vehicle vehRegDetails=transService.getVehicleInformation(vehRegNum);
		    	ModelAndView model=new ModelAndView("transportList");
		    	model.addObject("vehDetails",vehRegDetails);
				return model;
			}
		 else
		 {
			 	ModelAndView model=new ModelAndView("transportList"); 
				
				return model;
		 }
	}
	
	@RequestMapping(value="/transReg",method = RequestMethod.POST)
	public ModelAndView addTransporter(@ModelAttribute("teleAddTransporter") TransporterRequestPojo transporterInfo) throws Exception {
	
		if(!transService.checkDuplicateTransporter(transporterInfo)){
		
		transService.saveTransporter(transporterInfo);
		List<LocalTransporter> trans=transService.getTransporterDetails();
		  
		  
		  
		  		ModelAndView model=new ModelAndView("PostHome");
		  		model.addObject("listTrans",trans);
				model.addObject("truckMsg","<span style='color:green;font-size:14px;'>Transporter Details are added</span>");
				return model;
		}
		else{
			
			ModelAndView model=new ModelAndView("PostHome");
			model.addObject("truckMsg","<span style='color:green;font-size:14px;'>OOPS!! Transporter Details already exists</span>");
			return model;
		}
	}	
	
	@RequestMapping(value="/trackpayment",method = RequestMethod.POST)
	public ModelAndView trackTransporterPayment(@ModelAttribute("trackTransportPay") TrackTransporterRequestPojo tracktrans ) throws Exception {
	
		//System.out.println("SDFJHGKJSDFHLIKSD"+tracktrans.getTransporterId());
		Incentives inc=new Incentives();
		Deductions ded=new Deductions();
		List<Deductions> d=new ArrayList<Deductions>();
		List<Incentives> i=new ArrayList<Incentives>();
		
		List<Post> pos=transService.getTransporterPayemntInformation(tracktrans.getFromDate(), tracktrans.getToDate(), tracktrans.getTransporterId());
		
		System.out.println("List<Post> pos"+pos);
		if(!pos.isEmpty())
		{
		
			for (Post p: pos) {
				
			    System.out.println("postID"+p.getPostId());
			    ded=transService.getTransporterDeduction(p);
			    inc=transService.getTransporterIncentive(p);
			    System.out.println("Deductions "+p.getPostId()+"="+ded);
			    System.out.println("Incentives "+p.getPostId()+"="+inc);
			    
			    i.add(inc);
			    d.add(ded);
			   /* System.out.println("Incetive List SIZEEE"+i.size());
			    System.out.println("Deduction List SIZEEE"+d.size());*/
			}
			
			System.out.println("Incetive List SIZEEE"+i.size());
			System.out.println("Deduction List SIZEEE"+d.size());
			AmountDetails  amt=transService.getTotalAmount(tracktrans.getFromDate(), tracktrans.getToDate(), tracktrans.getTransporterId());
			System.out.println("SDFJHGKJSDFHLIKSD"+pos.size());
			
			ModelAndView model=new ModelAndView("forward:/TransporterpaymentDetails.jsp");
			model.addObject("postinfo", pos);
			model.addObject("Deduction", d);
			model.addObject("Incentive", i);
			model.addObject("trackpayment", tracktrans);
			model.addObject("amt",amt);
			return model;
		
		}
		else
		{
			ModelAndView model=new ModelAndView("forward:/TransporterpaymentDetails.jsp");
			model.addObject("transPayMsg","<span style='color:green;font-size:14px;'>Transporter details not found</span>");
			return model;
		}
	}
}

