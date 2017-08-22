package com.cogzy.gtruckways.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cogzy.gtruckways.businessObjects.EnterpriseCustomer;
import com.cogzy.gtruckways.businessObjects.EnterpriseTruckAssign;
import com.cogzy.gtruckways.businessObjects.EnterpriseVehicleStatus;
import com.cogzy.gtruckways.service.EmailSenderService;
import com.cogzy.gtruckways.serviceImpl.AccountManagerServiceImpl;
import com.cogzy.gtruckways.serviceImpl.EnterpriseServiceImpl;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.EnterpriseRequestPojo;
import com.cogzy.gtruckways.valueObjects.LoginRequestPojo;

@Controller
@SessionAttributes({"enterpriseInfo","balanceInfo"})
public class EnterpriseController {

	@Autowired
	EnterpriseServiceImpl enterpriseservice;
	
	@Autowired 
	AccountManagerServiceImpl accountservice;
	

	public AccountManagerServiceImpl getAccountservice() {
		return accountservice;
	}

	public void setAccountservice(AccountManagerServiceImpl accountservice) {
		this.accountservice = accountservice;
	}
	
	
	
	private static Logger log = Logger.getLogger(Log.class.getName());
	public EnterpriseServiceImpl getEnterpriseservice() {
		return enterpriseservice;
	}
	
	public void setEnterpriseservice(EnterpriseServiceImpl enterpriseservice) {
		this.enterpriseservice = enterpriseservice;
	}

	
	@ModelAttribute
	public void getAllEnterpriseNames(Model model){
		
	List <EnterpriseCustomer> entcust=accountservice.getAllEnterpriseNames();
	
	model.addAttribute("EnterPriseNameList", entcust);
	
	}
	
	 @RequestMapping("/enterpriseAppForm")  
	    public ModelAndView showEnterpriseform(){  
	        return new ModelAndView("Enterprise","command",new EnterpriseRequestPojo());  
	    }
	
	
	   @RequestMapping("/accountForm")  
	    public ModelAndView showAccountform(){  
	       
		
		   return new ModelAndView("AccountSettings","command",new EnterpriseRequestPojo());  
	    }
	
	
	   @RequestMapping("/trackform")  
	    public ModelAndView showTrackTruckform(){  
	        return new ModelAndView("TrackTruck","command",new EnterpriseRequestPojo());  
	    }
	
	   @RequestMapping("/balance")  
	    public ModelAndView showBalanceform(@ModelAttribute("enterpriseInfo")EnterpriseCustomer ecust ){  
	       
		   List<EnterpriseVehicleStatus> balance=enterpriseservice.getEnterPriseVehicleInformation(ecust.getEnterpriseCustomerId());
			
					for(EnterpriseVehicleStatus as:balance){
						Log.info("Enterprise Login Controller--> frequency of vehicle-->");
					}
				   
		   
		   ModelAndView model=new ModelAndView("BalanceKm");
		   model.addObject("balanceInfo", balance);
		   return model;
	    }
	
	
	   @RequestMapping("/entDashBoard")  
	    public ModelAndView showEnterpriseDashboardform(){  
	        return new ModelAndView("EnterpriseDashboard","command",new EnterpriseRequestPojo());  
	    }
	

	@RequestMapping(value="/enterprise",method=RequestMethod.POST) 
	public ModelAndView enterpriseSignup(@ModelAttribute("enterprise") EnterpriseRequestPojo ec  ,SessionStatus status,BindingResult result) throws Exception{
	
		int success=0;
		
		log.info("EnterpriseController"+ec.getStatus());
		
		int check=enterpriseservice.checkDuplicateEnterprise(ec);
		
		log.info("EnterpriseController-->Duplicate Entry-->"+check+"Status-->"+ec.getStatus()+"-->Mobile-->"+ec.getEnterpriseMobile()+"-->Email-->"+ec.getEnterpriseEmail());
			
		if(check!=1 && ec.getStatus()==0)		
			{
		
				// first Time enterprise From Main application
			success=enterpriseservice.saveEnterpriseInformation(ec);
			
				
				
				 ModelAndView model=new ModelAndView("Enterprise");
				 model.addObject("entrMsg", "<span style='background-color:#5cb85c;padding:5px;color:white;'><i>Thank you, Our representative will contact you at the earliest.</i></span>");
				return model;
			}
			else if(check!=1 && ec.getStatus()==1)
			{ 
				// from Account manager application
				log.info("Enterprise Collabration");
				String password =accountservice.updateEnterpriseDetails(ec);
				if(!password.isEmpty()){
					
				EnterpriseCustomer ecust=accountservice.getEnterpriseDetails(ec.getEnterpriseName());
				
				
				ApplicationContext context = new ClassPathXmlApplicationContext("com/cogzy/gtruckways/controller/applicationContext.xml");
				EmailSenderService mailer = (EmailSenderService) context.getBean("mailMail");
				log.info("Sending password to email");
				mailer.passSendEmail(ecust,password);
				log.info("password sent successfully ");
				
				ModelAndView model=new ModelAndView("Enterprise_Contract");
				model.addObject("enterpriseInfo",ecust);
				 model.addObject("Msg", "<span style='background-color:#5cb85c;padding:3px;color:white;'>Enterprise Details are Added Successfully</span>");
				return model;
				/*// from Account manager application
				int success1=accountservice.updateEnterpriseDetails(ec);
				if(success1==1){
					
				EnterpriseCustomer ecust=accountservice.getEnterpriseDetails(ec.getEnterpriseName());
				
				ModelAndView model=new ModelAndView("Enterprise_Contract");
				model.addObject("enterpriseInfo",ecust);
				 model.addObject("Msg", "<span style='background-color:#d9534f;padding:5px;color:white;'>Enterprise Details are Added Successfully</span>");
				return model;*/
				
				}
			} else if(check==1 && ec.getStatus()==0){
		
			
			 ModelAndView model=new ModelAndView("Enterprise");
			 model.addObject("entrMsg", "<span style='background-color:#d9534f;padding:5px;color:white;'>Enterprise Details already exists</span>");
			return model;
			}
		
			 ModelAndView model=new ModelAndView("Enterprise_Contract");
			 model.addObject("Msg", "<span style='background-color:#d9534f;padding:3px;color:white;'>This EnterPrise is Already Exists</span>");
			return model;
		}
	
	
	
	
	@RequestMapping(value="/chkMob",method=RequestMethod.GET) 
	public void chkMobCntrl(@RequestParam("mobile") String mobileNo, HttpServletResponse response ) throws Exception
	{
		System.out.println("inside chkMobCntrl"+mobileNo);
		String msg="";
				
		
		boolean flag=enterpriseservice.checkMobile(mobileNo);
				if(flag){
					msg="Mobile already Registered!";
				}else{
					msg="";
				}
		
		
					JSONObject obj = new JSONObject();
					try{
						obj.put("msg",msg);				
					}catch(JSONException e){
						e.printStackTrace();
					}
				response.getWriter().write(obj.toString());
	}
	
	@RequestMapping(value="/checkEmail",method=RequestMethod.GET) 
	public void chkEmailCntrl(@RequestParam("email") String Eemail, HttpServletResponse response ) throws Exception
	{
		System.out.println("inside chkEmailCntrl jjjjjj"+Eemail);
		String msg="";
				
		
		boolean flag=enterpriseservice.checkEmail(Eemail);
				if(flag){
					msg="Email already Registered!";
				}else{
					msg="";
				}
		
		
					JSONObject obj = new JSONObject();
					try{
						obj.put("msg",msg);				
					}catch(JSONException e){
						e.printStackTrace();
					}
				response.getWriter().write(obj.toString());
	}
	
	
	@RequestMapping(value="/enterpriseLogin",method=RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("login") LoginRequestPojo login ){
		
		
		Log.info("EnterpriseController-->EnterPrriseLogin Method--->mobileNo-->"+login.getEmailId()+"-->Password-->"+login.getPassword());
		//User use=loginservice.getLoginDetails(login.getMobileNo(),login.getPassword());
		
		EnterpriseCustomer ecust=enterpriseservice.enterpriseLoginInfo(login.getEmailId(),login.getPassword());
		
	
		if(ecust.getEnterpriseCustomerId()!=999 && !ecust.equals(null))
		{
			if(ecust.getEmail().equals(login.getEmailId())&&ecust.getPassword().equals(login.getPassword()))
			{
			   
				
				
				ModelAndView model=new ModelAndView("EnterpriseDashboard");
				
				model.addObject("enterpriseInfo",ecust);
			
				return model;
			
			}
			
			
				ModelAndView model=new ModelAndView("Enterprise");
				System.out.println("login failed");
				model.addObject("entrMsg","<span style='background-color:#d9534f;padding:3px;color:white;'>Email Id is Incorrect</span>");
				return model;
			}
		
		else
		{
			ModelAndView model=new ModelAndView("Enterprise");
			System.out.println("login failed");
			model.addObject("entrMsg","<span style='background-color:#d9534f;padding:2px;color:white;font-size:14px;'>Email Id and password mistmatch</span>");
			return model;
		}
	
	}
	
	
	

	@RequestMapping(value="/changepwd",method=RequestMethod.POST) 
	public ModelAndView changePassword(@ModelAttribute("chgpwd") EnterpriseRequestPojo ent,@ModelAttribute("enterpriseInfo") EnterpriseCustomer ec,SessionStatus status,HttpServletResponse response ) throws Exception{
	
		
		log.info("EnterPriseController-->ChangePasswordMethod-->EnterpriseId-->"+ec.getEnterpriseCustomerId()+"-->oldPwd-->"+ent.getOldEnterPrisePassword()+"-->newpwd-->"+ent.getEnterPrisePassword()+"-->confirmPwd-->"+ent.getConfirmPassword());
		
		int statuscode=enterpriseservice.ChangeEnterprisePassword(ent,ec.getEnterpriseCustomerId());
		
		if(statuscode==405){
			
			ModelAndView model=new ModelAndView("AccountSettings");
			model.addObject("msg","<span style='color:red;font-size:14px;'>Old Password is Incorrect</span>");
			return model;
			
		} else if(statuscode==404){
			ModelAndView model=new ModelAndView("AccountSettings");
			model.addObject("msg","<span style='color:red;font-size:14px;'>New Password and Confirm Password doesn't Match</span>");
			return model;
			
		} else if(statuscode==500){
			
			
			ModelAndView model=new ModelAndView("AccountSettings");
			model.addObject("msg","<span style='color:red;font-size:14px;'>Incorrect Password</span>");
			return model;
		}
		
		
		ModelAndView model=new ModelAndView("AccountSettings");
		model.addObject("msg","<span style='color:green;font-size:14px;'>Password Changed Successfully</span>");
		return model;
	
}
	
	
	
	/*@ModelAttribute
	public void getEnterpriseVehicleDetails(Model model){
		
		
		//List<EnterpriseTruckAssign> assign=
		
		
	}
	*/
	

	   @RequestMapping("/chngemail/{email}")  
	    public ModelAndView showchangePassword(@PathVariable("email") String email){  
	       
		  log.info("saltcode--->"+email);
		  
		  ModelAndView model=new ModelAndView("changepswd");
		  model.addObject("saltcode", email);
		  return model;
		  
	    }
	
	//checking the email id is already present or not
	@RequestMapping(value="/forgot",method=RequestMethod.POST) 
	public ModelAndView chkentEmailCntrl(@RequestParam("email") String Email, HttpServletResponse response ) throws Exception
	{
			Log.info("EnterpriseController-->Enterprise forgot password Method--->Email-->"+Email);
				
			String msg="";
						
		try {
			boolean flag = enterpriseservice.checkEmail(Email);

			if (flag) {
				msg = "";
				
				String saltString=enterpriseservice.updateEnterprsieResetPasswordSaltString(Email);
				
				if(saltString.equals("AAAA")){
					
					ModelAndView model = new ModelAndView("Enterprise");
					model.addObject("enterpriseInfo");
					model.addObject("errmsg", "<span style='color:red;font-size:14px;'>Unable to Send a Mail, Please Try Again Later</span>");
					return model;
					
				}
				ApplicationContext context = new ClassPathXmlApplicationContext(
						"com/cogzy/gtruckways/controller/applicationContext.xml");
				EmailSenderService mailer = (EmailSenderService) context.getBean("mailMail");
			
				mailer.forgotpassEmail(Email,saltString);
				
				/* ModelAndView model=new ModelAndView("Enterprise"); */
				ModelAndView model = new ModelAndView("Enterprise");
				model.addObject("enterpriseInfo");
				model.addObject("msg",
						"<span style='background-color:#5cb85c;padding:3px;color:white;'>Forgot password link sent to your mail</span>");
				return model;

			} else {
				msg = "Email not Registered!";
				log.info("Email not Registered!");
				ModelAndView model = new ModelAndView("Enterprise");
				model.addObject("enterpriseInfo");
				model.addObject("errmsg", "<span style='background-color:#d9534f;padding:3px;color:white;'>Sorry,Email-Id not registered</span>");
				return model;
			}

		} catch (Exception e) {
			ModelAndView model = new ModelAndView("Enterprise");
			model.addObject("enterpriseInfo");
			String msg1 = "<span style='background-color:#d9534f;padding:3px;color:white;'>Sorry,Email not registered</span>";
			model.addObject("errmsg", msg1);
			return model;
		}

	}
		
	@RequestMapping(value = "/chngemail/resetpass", method = RequestMethod.POST)
	public ModelAndView resetpassCntrl(@ModelAttribute("fpass") EnterpriseRequestPojo ent,SessionStatus status,HttpServletResponse response ) throws Exception
	{
		log.info("EnterPriseController-->Reset Password Method-->EnterpriseEmail-->"+ent.getEnterpriseEmail()+"-->newpwd-->"+ent.getNewpass()+"-->confirmnewpwd-->"+ent.getConfirmnewpass());
		log.info(ent.getEnterpriseEmail());
		
		if(ent.getEnterpriseEmail().length()!=20){
		
			ModelAndView model=new ModelAndView("changepswd");
			
			
			
			
			model.addObject("msg","<span style='background-color:#d9534f;padding:3px;color:white;'>Please, Use the Recent Link Sent to Your Mail Id</span>");
			return model;

		}
		
		
		
		int statuscode=enterpriseservice.ChangeEnterpriseforgotPassword(ent);
		
		
		if(statuscode==404||statuscode==500){
			
			ModelAndView model=new ModelAndView("changepswd");
			model.addObject("msg","<span style='color:red;font-size:14px;'>Link is already Used</span>");
			return model;
		}
		else if(statuscode==204)
		{
			
		
			ModelAndView model=new ModelAndView("changepswd");
			model.addObject("msg","<span style='color:red;font-size:14px;'>New Password and Confirm Password Doesn't Match</span>");
			model.addObject("saltcode",ent.getEnterpriseEmail());
			return model;
		}
		else 
		{
			
		ModelAndView model=new ModelAndView("changepswd");
		model.addObject("msg","<span style='color:green;font-size:14px;'>Password Changed Successfully</span>");
		return model;
		
		}
	}
	
	
	@RequestMapping(value="/enterpriselogout",method=RequestMethod.GET)
	public ModelAndView enterpriseLogout(HttpServletRequest request,HttpServletResponse response ){
	
		
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/enterpriseAppForm";*/
		
		
		
		HttpSession session = request.getSession();
	    if(session != null) {
	        session.removeAttribute("enterpriseInfo");
	    }
	    session.invalidate();
	    
	    return new ModelAndView("forward:/enterpriseAppForm");
			
			
		}
	
	
	
	
	
	
}
