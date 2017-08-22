package com.cogzy.gtruckways.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cogzy.gtruckways.businessObjects.LocalDriver;
import com.cogzy.gtruckways.businessObjects.SignUp;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.daoImpl.CustomerAppDaoImpl;
import com.cogzy.gtruckways.serviceImpl.CustomerServiceImpl;
import com.cogzy.gtruckways.serviceImpl.GetPriceServiceImpl;
import com.cogzy.gtruckways.serviceImpl.SmsServiceImpl;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.GenericResponse;


@RestController
public class CustomerAppRestController {

	@Autowired
	CustomerServiceImpl customerService;

	@Autowired
	SmsServiceImpl smsSerivce;

	@Autowired
	 CustomerAppDaoImpl customerdao;
	
	
	
	@Autowired
	GetPriceServiceImpl priceservice;
	//private static Logger log = Logger.getLogger(Log.class.getName());
	
	/*@RequestMapping(value="/customer/login123",method=RequestMethod.POST)
	public ResponseEntity<CustomerAppResponse> getDriverStatus(@RequestBody CustomerAppRequestPojo cus,BindingResult result){
		
		CustomerAppResponse loginResponse=new CustomerAppResponse();

		
	
		log.info("CustomerAppController:-->mobileNo:-->"+cus.getMobileNo()+"-->password:-->"+cus.getPassword());
		if(result.hasErrors()||cus.getMobileNo().isEmpty()||cus.getPassword().isEmpty())
		{

			loginResponse.setMessage("Incorrect Input");
			return new ResponseEntity<CustomerAppResponse>(loginResponse,HttpStatus.NOT_FOUND);
		} 
		else
		{	
				
			loginResponse= customerService.CustomerLogin(cus.getMobileNo(),cus.getPassword());

			if(loginResponse.equals(null))
			{

				loginResponse.setMessage("Invalid Input");  

				return new ResponseEntity<CustomerAppResponse>(loginResponse,HttpStatus.NOT_FOUND);

			}

			return new ResponseEntity<CustomerAppResponse>(loginResponse,HttpStatus.OK);//You many decide to return HttpStatus.NOT_FOUND


		}
		

	}*/
	
	
	
	@RequestMapping(value="/customer/signup", method=RequestMethod.POST)
	public ResponseEntity<GenericResponse> createUser(@RequestBody SignUp data, BindingResult result )
	{
		GenericResponse response  = new GenericResponse();
		
		//log.info("CustomerAppController:-->mobileNo:-->"+data.getFirstName()+"-->first name:-->" + "");
		/*System.out.println("firtName------>>>"+data.getUserName());
		System.out.println("lastName------>>>"+data.getMobileNo());
		System.out.println("phonNo------>>>"+data.getEmail());*/
	
		
		if(result.hasErrors()||data.getUserName().isEmpty()||data.getMobileNo().isEmpty()|| data.getEmail().isEmpty() || data.getFcmToken().isEmpty())
		{

			response.setStatus_code("404");
			response.setStatus_message("Invalid Response");
			return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		}
		else
		{
			/*response.setStatus_code("200");
			response.setStatus_message("success");*/
			try{
			response = customerService.customerData(data.getUserName(), data.getMobileNo(), data.getEmail(), data.getFcmToken());
			if(response.equals(null))
			{
				response.setStatus_code("404");
				response.setStatus_message("Invalid Response");
				return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
			}
			else
			{
				return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
			}
			
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		response.setStatus_code("500");
		response.setStatus_message("Internal Server Error");
		return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		
		
		
	}
	
	
	@ModelAttribute
	@RequestMapping(value="/customer",method=RequestMethod.GET)
	public ResponseEntity<GenericResponse> getAllVehicleType(Model model){
		
		GenericResponse response  = new GenericResponse();
		Log.info("Customer App is in Active");
		List<TruckInfo> vehi=priceservice.getAllVehicleTypes();
	
		model.addAttribute("VehicleTypeList", vehi);
		
		   
    	response.setList(vehi);   
        response.setStatus_code("200");
        response.setStatus_message("success");
        return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/customer/login",method=RequestMethod.POST)
	public ResponseEntity<GenericResponse> login(@RequestBody SignUp data, BindingResult result )
	{
		GenericResponse response  = new GenericResponse();
		
		//log.info("CustomerAppController:-->mobileNo:-->"+data.getFirstName()+"-->first name:-->" + "");
		System.out.println("firtName------>>>"+data.getMobileNo());
		
		if(result.hasErrors()||data.getMobileNo().isEmpty()|| data.getFcmToken().isEmpty())
		{

			response.setStatus_code("404");
			response.setStatus_message("Invalid Response");
			return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		}
		else
		{
			try
			{
				response = customerService.loginData(data.getMobileNo(), data.getFcmToken(),data.getOtp());
				if(response.equals(null))
				{
					response.setStatus_code("404");
					response.setStatus_message("Invalid Response");
					return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
				}
				else
				{
					if(response.getStatus_code().equals("200"))
					{
						int success = smsSerivce.getCustomerAppOTP(data.getMobileNo(), data.getOtp());
					       if(success==1)
					       {
					        
					    	//response.setList(vehi);   
					        response.setStatus_code("200");
					        response.setStatus_message("success");
					        return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
					       }
					}
					else
					{
						return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
					}
					//return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		response.setStatus_code("500");
		response.setStatus_message("Internal Server Error");
		return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/customer/updateprofile", method=RequestMethod.POST)
	public ResponseEntity<GenericResponse> updateUserProfile(@RequestBody SignUp data, BindingResult result)
	{
		GenericResponse response  = new GenericResponse();
		
		if(result.hasErrors()||data.getUserName().isEmpty()|| data.getMobileNo().isEmpty()||data.getEmail().isEmpty())
		{

			response.setStatus_code("404");
			response.setStatus_message("Invalid Response");
			return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		}
		else
		{
			try{
				response = customerService.upadteUser(data.getUserId(), data.getUserName(), data.getEmail(), data.getMobileNo());
				
				if(response.equals(null))
				{
					response.setStatus_code("404");
					response.setStatus_message("Could't not update, please try after some time");
					return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
				}
				else
				{
					return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		response.setStatus_code("500");
		response.setStatus_message("Internal Server Error");
		return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	
	
	@RequestMapping(value="/customer/sendotp", method=RequestMethod.POST)
	  public ResponseEntity<GenericResponse> snedOtp(@RequestBody SignUp data, BindingResult result)
	  {
	   GenericResponse response  = new GenericResponse();
	   if(result.hasErrors()|| data.getMobileNo().isEmpty())
	   {

	    response.setStatus_code("404");
	    response.setStatus_message("Invalid Response");
	    return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
	   }
	   else
	   {
	    try
	    {
	  
	     SignUp signUp = customerdao.ifDataExist(data.getMobileNo(), data.getEmail());
	     
	     if(signUp==null)
	     {
	       int success = smsSerivce.getCustomerAppOTP(data.getMobileNo(), data.getOtp());
	       if(success==1)
	       {
	        
	        response.setStatus_code("200");
	        response.setStatus_message("success");
	           return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	       }
	     }
	     
	     else
	     {
	      if(signUp.getMobileNo().equals(data.getMobileNo()))
	    {
	     
	       response.setStatus_code("404");
	       response.setStatus_message("Mobile No is already exist");
	       return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	     
	    }   
	    else if(!signUp.getEmail().isEmpty())  
	    {
	       
	     response.setStatus_code("404");
	     response.setStatus_message("Email id is already exist");
	     return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	    }
	     }
	     
	      
	     
	     
	     response.setStatus_code("404");
	     response.setStatus_message("Invalid Response");
	     return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
	     
	    }catch(Exception e)
	    
	    {
	      e.printStackTrace();
	    }
	    
	   }
	   response.setStatus_code("500");
	   response.setStatus_message("Internal Server Error");
	   return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
	   
	  }
	
	
	
	@RequestMapping(value="/customer/driverdetails", method=RequestMethod.POST)
	public ResponseEntity<GenericResponse> getDriverDeatils(@RequestBody LocalDriver data, BindingResult result)
	{
		GenericResponse response  = new GenericResponse();
		if(result.hasErrors())
		{

			response.setStatus_code("404");
			response.setStatus_message("Invalid Response");
			return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		}
		else
		{
		
			try{
				
				response = customerService.driverId(data.getDriverId());
				if(response.equals(null))
				{
					response.setStatus_code("404");
					response.setStatus_message("Please try again");
					return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
				}
				else
				{
					return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		response.setStatus_code("500");
		response.setStatus_message("Internal Server Error");
		return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		
	}

	
	@RequestMapping(value="/customer/getPromoCodes", method=RequestMethod.GET)
	public ResponseEntity<GenericResponse> getPromocodeDetails()
	{
	
		GenericResponse response  = new GenericResponse();
		
		try{
		
		 
		response = customerService.getPromocodes();
		
	
		
		response.setStatus_code(response.getStatus_code());
		response.setStatus_message(response.getStatus_message());
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
		
		
		}catch(Exception e){
			
			response.setStatus_code("500");
			response.setStatus_message("Internal Server Error");
			return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
			
		}
		
	
	}
	
}
