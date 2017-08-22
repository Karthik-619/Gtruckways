package com.cogzy.gtruckways.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cogzy.gtruckways.businessObjects.Post;
import com.cogzy.gtruckways.businessObjects.Price;
import com.cogzy.gtruckways.businessObjects.Route;
import com.cogzy.gtruckways.businessObjects.TruckInfo;
import com.cogzy.gtruckways.service.EmailSenderService;
import com.cogzy.gtruckways.serviceImpl.CustomerServiceImpl;
import com.cogzy.gtruckways.serviceImpl.GetPriceServiceImpl;
import com.cogzy.gtruckways.valueObjects.ConfirmBookingResponse;
import com.cogzy.gtruckways.valueObjects.GenericResponse;
import com.cogzy.gtruckways.valueObjects.GetPriceRequestPojo;

@RestController
public class GetPriceControllerApp {
	
	@Autowired
	GetPriceServiceImpl priceservice;
	
	
	@Autowired
	CustomerServiceImpl customerService;
	
	
	@RequestMapping(value="/customer/price", method=RequestMethod.POST)
	public ResponseEntity<GenericResponse> getApproximatePrice(@RequestBody GetPriceRequestPojo gp, BindingResult result )
	{
		GenericResponse response  = new GenericResponse();
		
		
		
		 Route route=new Route();
		 TruckInfo info= new TruckInfo(); 
		 Price price=new Price();
		 if(gp.getSourceLat()==0 ||gp.getSourceLong()==0||gp.getDestLat()==0||gp.getDestLong()==0 )
		 {
			 response.setStatus_code("404");
			 response.setStatus_message("Invalid Response");
			 return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		 }
		 else
		 {
			try{
				
				
				  route=priceservice.getGoogleDistanceAndTimeUsingLatAndLong(gp.getSourceLat(),gp.getSourceLong(),gp.getDestLat(), gp.getDestLong());
				  
				  info=priceservice.getTruckInformationDetails(gp.getTruckType());
				 
				  
					if(info.getTruckId()==1 || info.getTruckId()==6){
						
						 route.setTime(route.getTime()+30);
						
					}else{
						
						 route.setTime(route.getTime()+60);
					}
				  
				  
				  
				  price=priceservice.getTotalAmount(route, info);
				 
				  LocalDateTime dt=LocalDateTime.now().withSecond(0).withNano(0);
				  String date=dt.toString();
				  price.setCurrentDate(date);
				  
				  float gst=(float) (price.getTotalAmount()*0.05);
				  float totalAmount=price.getTotalAmount()+gst;
				  price.setTotalAmount(totalAmount);
				  price.setGstAmount(gst);
				  response.setResponse(price);
				  
				  if(response.equals(null))
					{
						response.setStatus_code("404");
						response.setStatus_message("Can't Get Price, Try after spme time");
						return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
					}
					else
					{
						response.setStatus_code("200");
						response.setStatus_message("success");
						
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
	
	
	
	@RequestMapping(value="/customer/confirm", method=RequestMethod.POST)
	public ResponseEntity<GenericResponse> confirmBooking(@RequestBody ConfirmBookingResponse data, BindingResult result )
	{
		GenericResponse response  = new GenericResponse();
		if(result.hasErrors()||data.getFromCity().isEmpty()||data.getToCity().isEmpty())
		{

			response.setStatus_code("404");
			response.setStatus_message("Invalid Response");
			return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		}
		else
		{
			
			Date now = new Date();
            String getServerTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(now);
            if(checkLocalTime(data.getPostDate(), getServerTime))
            {
            	   
			try{
				
				response = customerService.confirmBookingData(data);
				 if(response.equals(404))
					{
						response.setStatus_code("404");
						response.setStatus_message("Booking failed");
						return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
					}
					else
					{
						
						/*ApplicationContext context = new ClassPathXmlApplicationContext("com/cogzy/gtruckways/controller/applicationContext.xml");
						
						 EmailSenderService  mailer =  (EmailSenderService) context.getBean("mailMail");
						       
						
						 Class<? extends Object> getDetails=response.getResponse().getClass();
						*/
						
					
						response.setStatus_code("200");
						response.setStatus_message("success");
						
						return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
					}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
            else
            {
            	response.setStatus_code("404");
				response.setStatus_message("Invalid Date & Time");
				return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
            }
		}
		
		response.setStatus_code("500");
		response.setStatus_message("Internal Server Error");
		return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
	}
	

	@RequestMapping(value="/customer/cancel", method=RequestMethod.POST)
	public ResponseEntity<GenericResponse> cancelBooking(@RequestBody ConfirmBookingResponse data, BindingResult result )
	{
		GenericResponse response  = new GenericResponse();
		if(result.hasErrors() || data.getRefPostId().isEmpty() || data.getCancelReason().isEmpty())
		{

			response.setStatus_code("404");
			
			
			response.setStatus_message("Invalid Response");
			return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		}
		else
		{
			try{
				
				response = customerService.cancelBookingData(data.getRefPostId(), data.getCancelReason(), data.getComment());
				if(response.equals(null))
				{
					response.setStatus_code("404");
					response.setStatus_message("Booking Cancelation failed");
					return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
				}
				else
				{
					response.setStatus_code("200");
					response.setStatus_message("success");
					
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
	
	
	
	@RequestMapping(value="/customer/orderlist", method=RequestMethod.POST)
	public ResponseEntity<GenericResponse> getOrderList(@RequestBody ConfirmBookingResponse data, BindingResult result )
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
				response = customerService.getOrderList(data.getUserId());
				if(response.equals(null))
				{
					response.setStatus_code("404");
					response.setStatus_message("Could't fetch the order details");
					return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
				}
				else
				{
					response.setStatus_code("200");
					response.setStatus_message("success");
					
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
	
	
	@RequestMapping(value="/customer/applyCoupon", method=RequestMethod.POST)
	public ResponseEntity<GenericResponse> applyCoupon(@RequestBody ConfirmBookingResponse data, BindingResult result )
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
				
				response = customerService.CheckPromoCodeExistsOrNot(data.getPromoCode().toUpperCase(), data.getKilometers(), data.getTotalAmount(),data.getTravelDate(),data.getBasePrice(),data.getTruckId(),data.getStatus());
				if(response.equals(null))
				{
					response.setStatus_code("404");
					response.setStatus_message("Could't fetch the order details");
					return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
				}
				else
				{
					//response.setStatus_code("200");
					//response.setStatus_message("success");
					
					return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
				}
			}catch(Exception e )
			{
				e.printStackTrace();
			}
		}
		
		
		response.setStatus_code("500");
		response.setStatus_message("Internal Server Error");
		return new ResponseEntity<GenericResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	
	public boolean checkLocalTime(String localTime, String serverTime)
    {

        String[] splitLocalTime = localTime.split( "\\s+" );
        String localDate = splitLocalTime[0];
        String localTime1 = splitLocalTime[1];

        String[] splitServerTime = serverTime.split( "\\s+" );
        String serverDate = splitServerTime[0];
        String serverTime1 = splitServerTime[1];

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");

        try {

            if (sdf.parse(localDate).compareTo(sdf.parse(serverDate)) > 0) {
                System.out.println("Date1 is after Date2");
                return false;
            } else if (sdf.parse(localDate).compareTo(sdf.parse(serverDate)) < 0) {
                System.out.println("Date1 is before Date2");
                return false;
            } else if (sdf.parse(localDate).compareTo(sdf.parse(serverDate)) == 0) {
                System.out.println("Date1 is equal to Date2");

                Date d1 = sdf1.parse(localTime1);
                Date d2 = sdf1.parse(serverTime1);
                long elapsed = d2.getTime() - d1.getTime();
                System.out.println("TimeDiff"+elapsed);

                if (elapsed >0)
                {
                    return elapsed <= 300000;
                }
                else if(elapsed <0)
                {
                    return elapsed >= -300000;
                }
                else if(elapsed==0)
                {
                    return true;
                }
                else
                {
                    System.out.println("How to get here 2 ?");
                    return false;
                }

            } else {
                System.out.println("How to get here?");
                return false;
            }
        } catch (ParseException pe)
        {
            pe.printStackTrace();
        }



        return false;
    }

	
}
