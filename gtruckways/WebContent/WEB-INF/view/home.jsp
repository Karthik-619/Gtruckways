<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Title tag -->
	<title>Online Mini Truck Booking in Bangalore | Tata Ace & Tata 407 </title>   
 <meta charset="UTF-8">
	
 <!-- SEO -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- meta tag keywords -->
	<meta name="keywords" content="Mini Truck for rent in Bangalore, 407 rentals in Bangalore, House shifting in Bangalore,Tata ace rentals Bangalore, mini trucks in Bangalore, mini truck for hire in bangalore, Truck Service in Bangalore, gTruck Transport, truck rentals in Bangalore, Truck Service in Bangalore, Mini Trucks for shifting in Bangalore" /> 	
    <meta name="description" content="" >
    
 <!-- Open Graph Tags -->
	<meta property="og:title" content="gTruckways"/>
	<meta property="og:type" content="website"/>
	<meta property="og:url" content="https://www.gtruckways.com"/>
	<meta property="og:image" content=""/>
	<meta property="fb:admins" content="365844223786038"/>
	 
<!-- Twitter Card -->
	<meta name="twitter:card" content="summary">
	<meta name="twitter:url" content="https://gtruckways.com">
	<meta name="twitter:title" content="gtruckways - Deliver Your Goods Faster Than Ever">
	<meta name="twitter:image" content="">
		 	

	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/local.css" />
	
	<script type="text/javascript" src="js/local_pricing.js"></script>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!--     <script type="text/javascript" src="js/createReqObj.js" ></script>
    <script type="text/javascript" src="js/register.js" ></script> -->
	<style>
body{
font-family: 'Raleway', sans-serif;
}
.backgroundimage 
{ 
position: relative; 
top: 0; 
left: 0;
} 
.overlaytruck
{
width:auto; 
position:absolute; 
bottom:1px;
-webkit-animation: mymove 11s infinite;/*  / Safari 4.0 - 8.0 / */
 animation: mymove 11s infinite;
} 
/*  Safari 4.0 - 8.0  */
-webkit-keyframes mymove {
    from {right: -12px;}
    to {right:100%;}
}

@keyframes mymove {
    from {right: 12px;}
    to {right:100%;}
}

.btn {
    height: 35px; 
}
.modal .modal-content {
    padding: 10px;
   
}

.modal .modal-close {
    cursor: pointer;
    font-size: large;
    color: black;
}

 #deletesuccess{
 padding:10px;
 background-color:gray;
 color:white;
 width:40%;
 margin:5px;
 }
 
 
.modal{
   display: none;
    position: fixed;
    left: 0;
    right: 0;
    background-color: #fafafa;
    padding: 0;
    max-height: 90%;
    width: 30%;
    margin: auto;
    overflow-y: auto;
    border-radius: 2px;
    will-change: top, opacity;
}


/*App Details Row */
.appstore
{
	background-color:#01579b;
	color:#ffffff"
}
/*App Details Row */
.inputfield
{
	background-color:#01579b;
	color:#ffffff";
	height:1%;
}
.input-field label {
    color: #9e9e9e;
    position: absolute;
    top: 0.45rem;
    left: 0.75rem;
    font-size: 1rem;
    cursor: text;
    transition: .2s ease-out;
}
.btn.apk{
height:30px;
line-height:10px;

}
 	@media ( max-width:603px ){
 #getapp{
width:70%;

 }
 #mobileno{
 width:55%;
 margin-left:9rem;
 }
 #apkbtn{
 width:30%;
 margin-left:8rem;
 }
/*  .modal-content.getapp{
 background: url("WebContent/img/mobile_device.png")  no-repeat scroll top left;;
    background-color: #cccccc;
    background-repeat:no-repeat;
background-size:100% 200px;
 } */
/*   .modal-content.getapp{
 background: url("WebContent/img/mobile_device.png")  no-repeat scroll top left;;
    background-color: #cccccc;
    background-repeat:no-repeat;
background-size:100% 200px;
 } */
/*  @media ( max-width:1024px){

  .modal-content.getapp{
 background: url("img/mobile_device1.png")  no-repeat scroll top left;;
    background-color: #cccccc;
    background-repeat:no-repeat;
background-size:50%;
 }
 } */

 }
 .card .card-content {
    padding: 9px;
    border-radius: 0 0 2px 2px;
}
@media(max-width:603px){
#modal4,#modal5,#modal3{
width:100%;
max-width:100%;
}
}
#modal4,#modal3{
width:24%;
}
.content{
font-size:13px;
text-align:justify;
line-height:24px;   
 font-weight: 400;
}
.whychoos{
padding:2rem;
}
	</style> 
</head>
<!--body  -->
<body onload="initialize()">
<% if(session.getAttribute("postinfo")!= null)
{
session.removeAttribute("postinfo"); 
}
%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
 <div class="row">
    <c:choose> 
 <c:when test="${(userinfo.loginStatusCode==200 ||userinfo.loginStatusCode==204) && userinfo.isActive()}">      
       <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
<a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars" aria-hidden="true"></i></a>
      	<a href="homePage"><img src="img/Logonew.png" alt="logo" class="hide-on-small-only" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
     <ul id="" class="right logged-in">
   <!--      <li><a href="#modal3" data-position="bottom" data-delay="25" class=" modal-trigger tooltipped"  data-tooltip="Track Order"><i class="material-icons">room</i></a></li> -->
 			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;${userinfo.userName} </a></li>
		
 
			
	
				   <ul id='dropdown_local' class='dropdown-content'>
	            <li><a href="login?mobileNo=${userinfo.mobileNo}&password=${userinfo.password}" onclick="" id="" >My Bookings</a></li>
			    <li><a href="logout?mobile=${userinfo.mobileNo}" onclick="" id="signout" >Sign out</a></li>
			    
			  </ul> 
		</ul>
		
		 
	</div>
  </nav>
  </div>	
  
     <!--After Login  -->
 </c:when> 
<c:otherwise> 
  
 
  
          <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars" aria-hidden="true"></i></a>
      	<a href="homePage"><img src="img/Logonew.png" alt="logo" class="hide-on-small-only" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
     
	<!-- Before Login -->
 
     <!-- navigation for home page -->
      <ul class="right hide-on-med-and-down ">
        <ul class="left" style="margin-left:-30rem">  
        <li><a href="homePage">Home</a></li>
       <li><a href="aboutus">About Us</a></li>       
         </ul> 
      
       <li><a href="contactus">Contact Us</a></li>  
      <li><a href="mini-trucks-booking-rates">Pricing</a></li>
      <li><a href="#modal3" class=" modal-trigger" >Track Order</a></li>
       <li><a href="#modal4" class="modal-trigger" id="llogin">Sign In </a></li>
       <li><a href="enterpriseAppForm">Enterprise</a>
       <!--  <li><a href="http://blog.gtruckways.com">BLOG</a></li> -->
         <li><a href="#" style="font-size:20px;"><span><i class="fa fa-phone" style="font-size:24px;"></i>&nbsp;<b>+919590603333</b></span></a></li>
         <li></li>
      </ul>
      
     <!--Mobile Device Demo  -->
        <ul class="side-nav" id="mobile-demo">
        <li> <img src="img/Logonew.png" alt="logo" class="logo1" width="50%" alt="" /></li>
          <li><a href="homePage">Home</a></li>
       <!--   <li><a href="aboutus">About Us</a></li>   -->
        <li><a href="mini-trucks-booking-rates">Pricing</a></li>
      <li><a href="#modal3" class=" modal-trigger" >Track Order</a></li>
       <li><a href="#modal4" class="modal-trigger" id="llogin">Sign In </a></li>
       <li><a href="contactus">Contact Us</a></li>
      <li><a href="enterpriseAppForm">Enterprise</a>  
       <!--  <li><a href="http://blog.gtruckways.com">BLOG</a></li> -->
         <li><a href="#"><span><i class="fa fa-phone" style="font-size:20px;"></i>&nbsp;<b>+919590603333</b></span></a></li>
      </ul>
     
         
    </div>
  </nav>
  </div> <!--./ Local Header -->
   </c:otherwise>
</c:choose>	
  </div>
  
 

     <div class="row" style="position: relative; left: 0; top: 0;">
         <img src="img/new_web_background.png" alt="backgroundimage" class="backgroundimage" width="100%"height="350">  
        <img src="img/newtruckImage.png" alt="truckMoving" class="overlaytruck">
     </div>
 
      <!--input field row  -->   
        
     <div class="row inputfield" style="background-color:#01579b"> 
    
  <div>
  
 <div class="row col s12 l12 m12 srch"  id="page-wrap">

   <fieldset style="border:1px solid #F0FFFF;margin-top:12px;"> 
   <legend></legend>
   <form:form action="price" method="Post" commandName="price" id="myform" style="margin-top:9px;">
     <div class="col s12 m12 l3 input-field map-marker home">
 <span class="fa fa-map-marker"></span>
 
  <form:input list="from1" path="fromCity" id="frmarea" placeholder="From" type="text" onfocusout="myFunction()" class="validate" required="required"/>
  <label for="frmarea" data-error="" ></label><p id="h_frm" style="color:red;font-size:13px;"></p>
					 	<datalist id="from1">
				 		</datalist>
 </div>
     
    <div class="col s12 m12 l3 input-field map-marker home">
 <span class="fa fa-map-marker"></span>
<form:input list="to1"  path="toCity" id="tooarea" placeholder="To" type="text" class="validate"  onfocusout="myFunction1()" required="required" />
				    <label for="tooarea" data-error="" ></label><p id="h1_frm" style="color:red;font-size:13px;"></p>
				 	<datalist id="to1">
			 		</datalist>
 </div>
     
   <div class="col s12 l3 m12 input-field truck" >
	<span class="fa fa-truck"></span>
   <form:select  path="truckType" class="browser-default"  required="required"  style="height:2rem;">
        <option value="" disabled selected  >Select Vehicle Type</option> 
   	  <c:forEach var="item" items="${VehicleTypeList}">
     <option value="${item.truckId}" >${item.truckName}</option>
   	 </c:forEach>
                 
               </form:select>
 </div>
 
 <div class="col s12 l3 m12">
 <input type="submit"  class="btn" id ="getquote" value="Get Quote" onclick="samecity()">
 </div>
  </form:form>
   </fieldset>
   <br>
 </div> 	

  </div>
 
 </div>
  <!--./input field row  -->   
    
    
      <br>
    
    <!--gtruckways text  -->
  <div class="row">
  <p class="center" style="font-size:15px;color:grey"><b>gTruckways  transport is the system of online mini truck booking in Bangalore.</b></p>
  <p  class ="container center"style="font-size:15px;color:grey"><b>To facilitate demand and  supply in the segment  of  goods transportation  in Bangalore city meet.</b></p>
 </div>
   <!--./ gtruckways text -->
   
  
  <!-- Line Bar -->
   <br>
 <div class="center">
 <img src="img/Line.PNG" class="center">
 </div>

 <!--./Line Bar -->
 
  <div class="row whychoos">
						 
			<h4 style="font-weight:600" class="center black-text"> WHY CHOOSE GTRUCKWAYS </h4>
			   <div class="row center">			
				<div class="row ">				
					<div class="col s12 l6 m6">						
						<h5 style="font-family:Trebuchet MS; color:#1253a4;">Mini truck booking in Bangalore on Finger tips</h5>
          <p style="" class="content">Find it difficult to move your goods in Bangalore? The only thing you need to do is to place an order using your mobile or web and find at the door steps the mini truck to move your goods. Yes, transportation of goods in Bangalore is as simple as that. Count on us to hire mini trucks in Bangalore. We offer the fastest and safest goods transportation in deploying Tata Ace and 407 vehicles.  gTruck transport service makes you feel   hassle free and comfortable.</p>
					</div>				
					<div class="col s12 l6 m6 center">					
						<img src="img/minitruck.png" alt="onlinebooking" width="30%">					
					</div>			
				</div>												
				<div class="row ">				
					<div class="col s12 l6 m6 center">					
							<img src="img/hand-gesture%20(2).png" alt="bookfrommobile" width="20%">					
					</div>					
					<div class="col s12 l6 m6">						
					<!-- 	<h5 style="font-family:Trebuchet MS; color:#023761;">Book from Mobile or Web</h5>
						<p style="font-size:17px;">Just place your order and we will provide you on <br> demand mini trucks to move your goods.</p>						 -->
						<h5 style="font-family:Trebuchet MS; color:#1253a4;">Latest technology to serve you better</h5>
          <p  class="content">We offer quick and safe transport service based on the latest technology to book mini trucks in Bangalore. Our online truck booking technology is client friendly and minimizes response lag. We waste no time to respond as your time is precious and your needs are important. Prompt and ready- to -serve attitude enhances the quality of gTruck&#145;s service. Utilise it and feel the difference.</p>
					</div>							 
				</div>			 						 
			 <div class="row ">				
					<div class="col s12 l6 m6 ">						
						<h5 style="font-family:Trebuchet MS; color:#1253a4;">Best Vehicles & Expert Drivers</h5>
         <p  class="content">Keen on the quality of service gTruck deploys only vehicles with good running condition. The large array of vehicles consisting of Tata Ace and 407mini trucks undergo frequent mechanical checks. We take all hurdles in the goods transportation in Bangalore into consideration to ensure smooth flow of service.  The drivers of the vehicles are recruited only after verifying their expertise and care they take while driving.</p>
					</div>				
					<div class="col s12 l6 m6 center">					
						<img src="img/tracking%20(1).png" alt="track" width="20%">					
					</div>			 
				</div>			 						 
			 <div class="row ">				
				<div class="col s12 l6 m6 center bounceIn">					
					<img src="img\truckss.png"  width="25%">					
					</div>
					<div class="col s12 l6 m6">
						
						<h5 style="font-family:Trebuchet MS; color:#1253a4;"> Real Time Tracking & Alerts</h5>
             <p  class="content">Ensuring safety is always the prime concern in transportation business. Coupled with it comes promptness.  So we gTruck way transport introduced the system of vehicle tracking info via SMS and e- mail alerts. The client is empowered to check the trip status and rest peacefully awaiting the arrival of the consignment. </p>
					</div>		 
				</div>
			</div> 			 
			 </div>
 
 
   
  
 
      
   
  <br>
 <!--App Details Row -->
     <div class="appstore">
     <div class="container">
     <div class="row " >
     <div class="col s12 l6 m12">
      <img src="img/mobile_app.png" style="width:50%;height:auto;margin-top:30px;">
     </div>
      <div class="col s12 l6 m12" style="color:#ffffff;margin-top:30px;">
      <h1 style="color:#ffffff;font-size:2rem;">Download gTruckways App</h1>
      <p>Book Your Truck & </p>
      <p>Get Connected to drivers instantly.</p>
       <a href="https://play.google.com/store/apps/details?id=com.cogzytech.truckways" target="_blank"><img src="img/play_store_with_border.png" style="width:30%;height:auto;"></a>
     </div> 
     </div>
     </div> 
     </div>
     <!--./App Details Row -->
     
     
       <!-- Contact Number Row -->
    <br>
     <div class="row">
     <h4 class="contact center" style="font-family:LucidaSansTypewriter">Give us a try,we're sure you will love us.Call:+91 9590603333</h4>
     </div>
     
     <!-- ./Contact Number Row -->
     
    
      
 <div id="modal3" class="modal col s12 l12 m6">
   
  <div class="modal-content ">
    <a href="#" class="fa fa-close modal-action modal-close right"  ></a>
   <h4 class="center mtitle" style="font-size:20px;">Track Order</h4>
       <div class="row" >
             <form action="track" method="Get">
              <div class="input-field col s12 m6 l10 push-l1 ">

				       <input  id="book_id"  type="text" name="postid" class="validate"  required/>
				       <label data-error="" style="color:#0288d1">&nbsp;<i class="fa fa-newspaper-o" aria-hidden="true"></i>&nbsp;Booking Id</label>
					  
					</div>
					
					<div class="row  ">
					 <div class="input-field col s12 m6 l10 push-l1 ">
			
					    <input  name="mobile" type="text" class="validate"   id="t_mobile" pattern="^[789]\d{9}$" maxlength="10" required/>
					    <label style="color:#0288d1">&nbsp;<i class="fa fa-phone"></i>&nbsp;Mobile No</label>
					</div>
					<div class="input-field col s12 m6 l10 offset-l1 " >
			<input type="submit" value="Track"  class="btn" style="width:100%; height:35px;font-size:15px;background-color:#3366CC;" id="submit"  >
			</div>
		
					</div>
					<br>
				</form>
         
        </div>
   
  
   

  </div>
  </div>
 

				
				
    <div id="modal4" class="modal">
		<div class="modal-content">

         <a href="#" class="fa fa-close modal-action modal-close right" id="signupclose" ></a>
 
        <div class="row " >
             <form action="login" method="Get" id="lform" >
                <h4 class="center mtitle" style="font-size:20px;">Sign In</h4>
              <div class="input-field col s12 m6 l10 offset-l1 ">
				       <input id="l_mobile"  type="text" name="mobileNo" class="validate"  pattern="^[789]\d{9}$" maxlength="10" required/>
				       <label for="l_mobile" style="color:#0288d1">&nbsp;<i class="fa fa-phone"></i>&nbsp;MobileNo</label>
					   <span id="lmbl" style="color:red;"></span>
					</div>
					
					<div class="row  ">
					 <div class="input-field col s12 m6 l10 offset-l1 ">
				       <input  name="password" id="pwd" type="password" class="validate" required/>
				         <label for="pwd" style="color:#0288d1">&nbsp;<i class="fa fa-lock"></i>&nbsp;Password</label>
					    <span id="forget"><a href="#"  style="color:rgba(255, 0, 0, 0.87)"><u>Forgot password?</u></a></span>
					</div>
					<div class="input-field col s12 m6 l10 center " >
			<input type="submit" value="Sign In" class="btn" style="width:100%;height:35px; font-size:20px;background-color:#3366CC;margin-left:1.8rem;" id="submit"  >

			</div>
			
		
					</div>
				
				</form>
			 <form action="retforgot" method="post" id="fform" class="row" style="display:none" >
                <h5 class="center">  <span> <i class="fa fa-arrow-left" style="font-size:20px;cursor:pointer;" id="llink"></i></span>&nbsp;&nbsp;Forget Password</h5>
			     <div class="input-field col s12 l10 offset-l1">
				  <input id="email_id"  name="email" type="text" class="validate" required /><span id="sp" style="color:#00BFFF"></span> 
				  <label for="email_id" style="top:0.60rem;color:#0288d1;">&nbsp;<i class="fa fa-user" ></i> &nbsp; Enter Your Email</label>
				</div> 
				
				
				<div class="input-field col s12 l10"  >
                  
                    <button id="last_name" type="submit" class="btn get validate" style="margin-left:1.8rem;width:100%;height:35px; font-size:20px;background-color:#3366CC;">Get Link</button>
				
				</div>    	
										
			</form>
         <br>
        </div>
      
   
	
		</div>
		</div>	
 	
 	 <div id="getapp" class="modal">
		<div class="modal-content" >
 
  <a href="#" class="fa fa-close modal-action modal-close right" id="closeBtn" ></a>
  <br>
	<div class="row">
	
				<h4 class="center"><b>Get a Vehicle</b></h4>
				<span class="center col s12 m12 l10 offset-l1">@ Just Rs <b>199</b></span>
		
				<div class="input-field col s12 m12 l10 offset-l1">
						<a href="offers"  class="btn" style="background:rgb(18, 83, 164)">Click Here For More Details</a>
						<p class="center modal-action modal-close" id="closeBtn"><u style="font-size:12px;">NO THANKS</u></p>
				</div>
	</div>
		
		

			
 
   </div>

   
	
		</div> 
	
		
 <jsp:include page="footer.jsp"/>		
	

  
 
<script type="text/javascript">
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/591ec1b88028bb7327046b15/default';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script>
     <script>
/*    $('#getapp').openModal();  */
    
    $(document).ready(function(){
	   var shown= localStorage.getItem('isshow');
	    if(shown !="t"){
	    	 $('#getapp').openModal();
	        localStorage.setItem('isshow', "t");
	    }
	});
	
     $("#forget").click(function(){
    		$("#fform").show();
    		$("#lform").hide();
    	})
    	$("#llink").click(function(){
    		$("#lform").show();
    		$("#fform").hide();
    	})
    	$("#signupclose").click(function(){
    		  $("#fform").hide();
    	      $("#lform").show();
    		})
   
    //jquery
     //document.getElementById("enterprice_form").reset();
  
     
	    $(document).ready(function(){
	        $('.slider').slider({full_width: true});
	      });
	    
	    function samecity(){
	    	   var frmarea=document.getElementById("frmarea");
	    	   var tooarea=document.getElementById("tooarea");
	    	   if((frmarea.value && tooarea.value)){
	    	   if(frmarea.value==tooarea.value){
	    	    
	    	    tooarea.value="";
	    	    tooarea.focus();
	    	    document.getElementById("h_frm").innerHTML="From and To Area can not be same";
	    	    document.getElementById("tooarea").style="border:3px solid red";
	    	    document.getElementById("tooarea").style="border-bottom:none";
	    	    return false;
	    	   }else{
	    	  
	    	    document.getElementById("h_frm").innerHTML="";
	    	    return true;
	    	   }
	    	  }
	    }

	    function myFunction() {
	        var str = document.getElementById("frmarea").value;
	        var str1 = document.getElementById("tooarea").value;
	        var n = str.endsWith("Bengaluru, Karnataka, India");
	       // var n1 = str1.endsWith("Bengaluru, Karnataka, India");
	        
	        if(n==0 ){
	      /*  document.getElementById("h_frm").innerHTML="From and To City can not be same";
  
	       document.getElementById("city").value="";
	     document.getElementById("city").focus(); */
	     frmarea.value="";
	    /*  frmarea.focus(); */
	   
	     document.getElementById("h_frm").innerHTML="Enter areas with in Bengaluru";
	     
	     
	        return false;
	        }
	        else{
	        	document.getElementById("h_frm").innerHTML=" ";
	        }
	    }
	   
	    function myFunction1() {
	      
	        var str1 = document.getElementById("tooarea").value;
	       var n1 = str1.endsWith("Bengaluru, Karnataka, India");
	        
	        if(n1==0 ){
	      /*  document.getElementById("h_frm").innerHTML="From and To City can not be same";

	       document.getElementById("city").value="";
	     document.getElementById("city").focus(); */
	     tooarea.value="";
	    /*  frmarea.focus(); */
	   
	     document.getElementById("h1_frm").innerHTML="Enter areas with in Bengaluru";
	     
	     
	        return false;
	        }
	        else{
	        	document.getElementById("h1_frm").innerHTML=" ";
	        }
	    }
	  </script>
    <script>
    $(document).ready(function(){
    $('.button-collapse').sideNav();
    });
    $(document).ready(function(){
        $('.parallax').parallax();
      });
 
    $('a[href*="#"]:not([href="#"])').click(function() {
    	  if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
    	    var target = $(this.hash);
    	    target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
    	    if (target.length) {
    	      $('html, body').animate({
    	        scrollTop: target.offset().top
    	      }, 1000);
    	      return false;
    	    }
    	  }
    	});
   
    </script>

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=true&libraries=places&key=AIzaSyDWK67G2dser4HY7zGwOPHPlvNrORCRSzs"></script>


<script type="text/javascript">

</script>
<!-- <script type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
	setTimeout("noBack()", -1);
</script> -->
<script type="text/javascript">
	
document.getElementById("myform").reset();
	
	$(".modal-close").click(function(){
		   $("#t_mobile,#book_id,#l_mobile,#pwd,#ename,#emobile,#e_email,#address,#e_contname").val("");
		 
		 
		  });
	  $(document).keyup(function(e) {
          if (e.keyCode == 27) { // escape key maps to keycode `27`
             $('#modal3').closeModal();
             $('#modal4').closeModal();
         }
     });
	  
	  $(document).ready(function(){
			// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
			$('.modal-trigger').leanModal({
            dismissible: false
        });
	  });
	  
	/*   $(document).ready(function(){
		  initall();
			if (typeof initalls == 'function') { 
				initalls(); 
				}
			
		  }); */
	 

	 $('.dropdown-button').dropdown({
	      inDuration: 300,
	      outDuration: 225,
	      constrain_width: false, // Does not change width of dropdown to that of the activator
	      hover: false, // Activate on hover
	      gutter: 0, // Spacing from edge
	      belowOrigin: false, // Displays dropdown below the button
	      alignment: 'left' // Displays dropdown with edge aligned to the left of button
	    }
	  ); 
</script>



<script>
/* var div = document.createElement("div");
div.innerHTML = "<!--[if lt IE 9]><i></i><![endif]-->";
var isIeLessThan9 = (div.getElementsByTagName("i").length == 1);
if (isIeLessThan9) {
    alert("WE DON'T LIKE YOUR BROWSER");
} */
if (document.all && !document.addEventListener) {
    alert('To open www.gtruckways.com, upgrade your browser to IE 11');
}
</script>

</body>
    </html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          