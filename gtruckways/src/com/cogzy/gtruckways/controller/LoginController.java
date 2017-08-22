package com.cogzy.gtruckways.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.User;
import com.cogzy.gtruckways.service.EmailSenderService;
import com.cogzy.gtruckways.serviceImpl.CancelServiceImpl;
import com.cogzy.gtruckways.serviceImpl.LoginServiceImpl;
import com.cogzy.gtruckways.serviceImpl.TrackServiceImpl;
import com.cogzy.gtruckways.validator.Log;
import com.cogzy.gtruckways.valueObjects.EnterpriseRequestPojo;
import com.cogzy.gtruckways.valueObjects.LoginRequestPojo;

@SessionAttributes({"listPostinfo","userinfo","postinfo"})
@Controller
public class LoginController {

	@Autowired
	LoginServiceImpl loginservice;

	@Autowired
	TrackServiceImpl trackservice;

	@Autowired
	CancelServiceImpl cancelservice;

	private static Logger log = Logger.getLogger(Log.class.getName());
	
	public LoginServiceImpl getLoginservice() {
		return loginservice;
	}


	public void setLoginservice(LoginServiceImpl loginservice) {
		this.loginservice = loginservice;
	}


	public TrackServiceImpl getTrackservice() {
		return trackservice;
	}


	public void setTrackservice(TrackServiceImpl trackservice) {
		this.trackservice = trackservice;
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView userLogin(@ModelAttribute("login") LoginRequestPojo login ){
		
		
		
		User use=loginservice.getLoginDetails(login.getMobileNo(),login.getPassword());
	
		List<Post> pos=new ArrayList<Post>();
		
		if( use.isActive() && use.getMobileNo().equals(login.getMobileNo())&&use.getPassword().equals(login.getPassword()))
		{
			
			 // get the Booking Details Information  
			 pos=loginservice.getUserPostedDetails(use);
				
		
			
			if(pos.isEmpty()){
			
				log.info("BookingInformation is Empty-->"+pos.isEmpty());
				use.setLoginStatusCode(204);
				
			}else{
				
				log.info("BookingInformation is Empty-->"+pos.isEmpty());
				use.setLoginStatusCode(200);
				
			}
				
				
			log.info("login Success");
				
			ModelAndView model=new ModelAndView("redirect:/CustomerLogin");
			model.addObject("listPostinfo", pos);
			model.addObject("userinfo", use);
			return model;
		}
			
		
		else
		{
			
			 log.info("login UnSuccessfull");
			use.setLoginStatusCode(401);	
			ModelAndView model=new ModelAndView("redirect:/CustomerLogin");
			model.addObject("listPostinfo", pos);
			model.addObject("userinfo", use);
			return model;
		}
	}
	

	
	@RequestMapping(value="/CustomerLogin",method=RequestMethod.GET)
	public ModelAndView loginPage(@ModelAttribute("listPostinfo") List<Post> pos,@ModelAttribute("userinfo") User use) throws Exception{
	
	try{
		
		if(pos.isEmpty() && use.getLoginStatusCode()==204){
			
			log.info("Login Success but no Bookings"+use.getUserName());
			ModelAndView model=new ModelAndView("PostedDetails");
			
			return model;
			
			
		} else if(use.getLoginStatusCode()==200){
			
			log.info("Login Success Bookings Found"+use.getUserName());
			ModelAndView model=new ModelAndView("PostedDetails");
			return model;
			
		}
		
		use.setLoginStatusCode(401);
		ModelAndView model=new ModelAndView("PostedDetails");
		model.addObject("loginerr","<span style='color:red;font-size:14px;'>Mobile and password mistmatch</span>");
		return model;
	
	
		} catch(Exception e){
		
		use.setLoginStatusCode(401);
		ModelAndView model=new ModelAndView("PostedDetails");
		model.addObject("loginerr","<span style='color:red;font-size:14px;'>Mobile and password mistmatch</span>");
		model.addObject("userInfo",use);
		return model;
		
	}
}	
		
	@RequestMapping(value="/track",method=RequestMethod.GET)
	public ModelAndView trackorder(@RequestParam("mobile") String mobileNo,@RequestParam("postid") String postId) throws Exception{

		System.out.println("inside trackorder"+postId+"mobileNo"+mobileNo);
		
		
		Post pos=trackservice.getTrackPostDetails(postId, mobileNo);
		
		if(pos!=null )
		{
			User user=trackservice.getUserInformation(mobileNo);
			System.out.println("after getUserInformation"+user.isActive());
			if(user.getLoginStatusCode()==1 && user.isActive())
			{
				System.out.println("after userinfo"+user+"LS"+user.getLoginStatusCode()+"mob"+user.getMobileNo()+"userID"+user.getUserId());
				if(user.getMobileNo()!=null && user.getUserId()==(pos.getUser().getUserId()))
				{
			
				
				/*pos=trackservice.getTrackPostDetails(postId, mobileNo);*/
				
					System.out.println("if getLoginStatusCode"+user.getLoginStatusCode());	
						ModelAndView model=new ModelAndView("track");
						model.addObject("postinfo",pos);
						model.addObject("userinfo",user);
						return model;
				}
				else
				{
					
					System.out.println("else getMobileNo");	
					//redirect:/home.jsp
					ModelAndView model=new ModelAndView("track");
					model.addObject("error","<span style='background-color:#d9534f;padding:5px;color:white;'>Incorrect Booking Id</span>");
					
					return model;
		
				}
			}
			else
			{
					System.out.println("else getLoginStatusCode"+user.getLoginStatusCode());	
					ModelAndView model=new ModelAndView("track");
					model.addObject("postinfo",pos);
					/*model.addObject("userinfo",user);*/
					return model;
			}
			 
			
		
		}else{

			System.out.println("else getRefPostId");	
			ModelAndView model=new ModelAndView("track");
			model.addObject("error","<span style='background-color:#d9534f;padding:5px;color:white;'>Mobile number and Booking Id mismatch</span>");
			
			return model;

		}
		
	}
	
	@RequestMapping(value="/cancelbooking",method=RequestMethod.GET)
	public ModelAndView cancelOrder(@RequestParam("mobile") String mobile,@RequestParam("postid") String postId) throws Exception{

		int status=cancelservice.cancelPost(postId);
		
		Post pos=cancelservice.getPostDetails(postId, mobile);
		if(status!=0 && pos.getRefPostId()!=null){
			
			pos=cancelservice.getPostDetails(postId, mobile);	
		
		
		System.out.println("he hiwwkk"+postId);
		
		ModelAndView model=new ModelAndView("track");
		model.addObject("postinfo", pos);
		String message="<span style='background-color:#5cb85c;padding:5px;color:white;'>Your Booking is Canceled</span>";
		model.addObject("error",message);
		
		return model;
		}
		
		ModelAndView model=new ModelAndView("track");
		
		String message="<span style='background-color:#d9534f;padding:5px;color:white;'>Unable to Cancel Your Booking</span>";
		model.addObject("error",message);
		model.addObject("postinfo", pos);
		return model;
		
		
		}

	@RequestMapping(value="/chkLogMob",method=RequestMethod.GET) 
	public void chkLogMobCntrl(@RequestParam("lmobile") String Logmobile, HttpServletResponse response ) throws Exception
	{
		System.out.println("inside chkLmobCntrl"+Logmobile);
		String msg="";
				
		
		boolean flag=loginservice.chkLogMob(Logmobile);
		System.out.println("after chkLogMob"+flag);
				if(flag){
					msg="";
				}else{
					msg="Mobile number not Registered!";
				}
		
		
					JSONObject obj = new JSONObject();
					try{
						obj.put("msg",msg);				
					}catch(JSONException e){
						e.printStackTrace();
					}
				response.getWriter().write(obj.toString());
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView userLogout(@RequestParam("mobile") String mobileNo,HttpServletRequest request){
		
		User use=loginservice.logoutUser(mobileNo);
		HttpSession session = request.getSession();
		
		if(use.getLoginStatusCode()==0 && !use.isActive()){
			
			System.out.println("loginservice.logoutUser"+use.getLoginStatusCode());
			ModelAndView model=new ModelAndView("forward:/homePage");
			model.addObject("userinfo",use);
			session.invalidate();
			return model;
		} 
		else{
			System.out.println("else .logoutUser"+use.getLoginStatusCode());
			session.invalidate();
			return new ModelAndView("forward:/homePage");
			
			
			
		}
	
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute("userinfo") User use){
		
		System.out.println("inside homePage");
		ModelAndView model=new ModelAndView("forward:/home.jsp");
		model.addObject("userinfo",use);
		return model;
		
		
	}
	
	
	@RequestMapping(value="/retforgot",method=RequestMethod.POST) 
	public ModelAndView forgotPasswordRetail(@RequestParam("email") String email, HttpServletResponse response ) throws Exception
	{
			Log.info("LoginController-->Retail forgot password Method--->Email-->"+email);
				
			String msg="";
						
		try {
			boolean flag = loginservice.checkEmailIdofUser(email);
			
			if (flag) {
				msg = "";
				
			
				String saltString=loginservice.updateUserforgotpassword(email);
				
				if(saltString.equals("AAAA")){
					
					ModelAndView model = new ModelAndView("PostedDetails");
					model.addObject("saltString",saltString);
					model.addObject("loginerror", "<span style='color:red;font-size:14px;'>Unable to Send a Mail, Please Try Again Later</span>");
					return model;
					
				}
				
				ApplicationContext context = new ClassPathXmlApplicationContext(
						"com/cogzy/gtruckways/controller/applicationContext.xml");
				EmailSenderService mailer = (EmailSenderService) context.getBean("mailMail");
			
				mailer.forgotpassEmailRetailUser(email,saltString);
				
				ModelAndView model = new ModelAndView("PostedDetails");
				model.addObject("saltString",saltString);
				model.addObject("loginerror",
						"<span style='background-color:#5cb85c;padding:5px;color:white;'>Forgot password link sent to your mail Id</span>");
				return model;

			} else {
				msg = "Email not Registered!";
				log.info("Email not Registered!");
				ModelAndView model = new ModelAndView("PostedDetails");
				model.addObject("saltString","AAAA");
				model.addObject("loginerror", "<span style='background-color:#d9534f;padding:5px;color:white;'>Sorry,Email-Id not registered</span>");
				return model;
			}

		} catch (Exception e) {
			ModelAndView model = new ModelAndView("PostedDetails");
			model.addObject("saltString","AAAA");
			String msg1 = "<span style='color:background-color:#d9534f;padding:5px;color:white;'>Sorry,Email-Id not registered</span>";
			model.addObject("loginerror", msg1);
			return model;
		}

	}
	
	
	
	 @RequestMapping("/changemail/{email}")  
	    public ModelAndView showchangePassword(@PathVariable("email") String email){  
	       
		  log.info("saltcode--->"+email);
		  
		  ModelAndView model=new ModelAndView("changepwd1");
		  model.addObject("saltcode", email);
		  return model;
		  
	    }
	
	
	
	@RequestMapping(value = "/changemail/respass", method = RequestMethod.POST)
	public ModelAndView resetpassCntrl(@ModelAttribute("fpass") EnterpriseRequestPojo ent,SessionStatus status,HttpServletResponse response ) throws Exception
	{
		log.info("LoginController-->Reset Password Method-->UserEmail-->"+ent.getEnterpriseEmail()+"-->newpwd-->"+ent.getNewpass()+"-->confirmnewpwd-->"+ent.getConfirmnewpass());
		log.info(ent.getEnterpriseEmail());
		
		if(ent.getEnterpriseEmail().length()!=22){
		
			ModelAndView model=new ModelAndView("changepwd1");
			
			
			
			
			model.addObject("msg","<span style='color:red;font-size:14px;'>Please, Use the Recent Link Sent to Your Mail Id</span>");
			return model;

		}
	
		int statuscode=loginservice.updateUserNewPassword(ent.getEnterpriseEmail(),ent.getNewpass(),ent.getConfirmnewpass());
		
		
		if(statuscode==404||statuscode==500){
			
			ModelAndView model=new ModelAndView("changepwd1");
			model.addObject("msg","<span style='color:red;font-size:14px;'>Link is already Used</span>");
			return model;
		}
		else if(statuscode==204)
		{
			
		
			ModelAndView model=new ModelAndView("changepwd1");
			model.addObject("msg","<span style='color:red;font-size:14px;'>New Password and Confirm Password Doesn't Match</span>");
			model.addObject("saltcode",ent.getEnterpriseEmail());
			return model;
		}
		else 
		{
			
		ModelAndView model=new ModelAndView("changepwd1");
		model.addObject("msg","<span style='color:green;font-size:14px;'>Password Changed Successfully</span>");
		return model;
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
