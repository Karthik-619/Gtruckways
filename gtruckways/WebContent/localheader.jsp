<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Title tag -->
	<title>gTruckWays-Mini Truck for rent in Bangalore</title>   
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
	
	<link rel="icon" href="img/logo.png" type="image/gif" rel="shortcut icon" sizes="16x16">	
	<link rel="stylesheet" type="text/css" href="css/materialize.min.css" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
	<link rel="stylesheet"  type="text/css" href="css/local.css" />
	
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>          
	<script type="text/javascript" src="js/createReqObj.js" ></script>
	<script type="text/javascript" src="js/register.js" ></script>
	
	<style>
		nav
		{
		background-color:#1253A4;
		}
	</style>
</head>
<body>

       <div class="navbar-fixed">
   <nav>
    <div class="nav-wrapper" >
    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars" aria-hidden="true"></i></a>

       
         	
      	<c:choose>
<c:when test="${userinfo.isActive()}"> 
  <a href="homePage"><img src="img/Logonew.png" class="hide-on-small-only" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
     <!--  <ul class="right hide-on-med-and-down ">
        <li><a href="home" class="tooltipped" data-position="bottom" data-delay="25" data-tooltip="Home" ><i class="material-icons" ">home</i></a></li>
      </ul> -->
       <ul id="" class="right logged-in">
			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;${userinfo.userName} </a></li>
			
			  <ul id="dropdown_local" class="dropdown-content">
			  <li><a href="homePage">Book New</a></li>
	            <li><a href="login?mobileNo=${userinfo.mobileNo}&password=${userinfo.password}" onclick="" id="" >My Bookings</a></li>
			    <li><a href="logout?mobile=${userinfo.mobileNo}" onclick="" id="signout" >Sign out</a></li>
			    
			  </ul>
		</ul>
		
		<!--Mobile demo  -->
      <ul class="side-nav" id="mobile-demo">
         <li><a href="homePage">Home</a></li>
      </ul>
      
	</c:when>
	<c:when test="${not empty enterpriseInfo}">
	  <a href="homePage"><img src="img/Logonew.png" class="hide-on-small-only" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
	    <ul id="" class="right logged-in">
			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;${enterpriseInfo.enterpriseName}  </a></li>	
			  <ul id="dropdown_local" class="dropdown-content">
			 <li><a href="enterpriselogout" onclick="" id="signout" >Sign out</a></li> 
			  </ul>
		</ul>
	</c:when>
	<c:otherwise>

 
       <a href="homePage"><img src="img/Logonew.png" class="hide-on-small-only" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
   
   		
   		 
  
   		 
     
     <ul class="right hide-on-med-and-down ">
        <li><a href="homePage"  >Home</a></li>
         <li><a href="#"  >About Us</a></li>
        
   		 <li><a href="#modal3" class=" modal-trigger" >Track Order</a></li>
   		 <li><a href="#modal4" class="modal-trigger" id="llogin">Sign In </a></li>
   		 <li><a href="#">Contact Us</a>
   		 <li><a href="enterpriseAppForm">Enterprise</a>
   		 <li><a href="#"><span><i class="fa fa-phone" style="font-size:20px;"></i>&nbsp;+919590603333</span></a></li>
   		 
     </ul>
 
      <ul class="side-nav" id="mobile-demo">
       <li> <img src="img/Logonew.png" width="50%" class="logo1"  alt="" /></li>
         <li><a href="homePage"><i class="fa fa-home"></i>Home</a></li>     
      </ul>		
   </c:otherwise>
</c:choose>	
   
      
      
      <!--mobile demo  -->
         <ul class="side-nav" id="mobile-demo">
  <!--    <li> <img src="img/gtlogo1.jpg" class="logo" alt="" /></li> -->
         <li><a href="homePage"><i class="fa fa-home"></i>Home</a></li>
         
        <li><a href="#modal3" class="modal-trigger"><i class="fa fa-map-marker"></i>Track Order</a></li>
        
         <li><a href="#modal4" class="modal-trigger"><i class="fa fa-sign-in"></i>Login</a></li>
      </ul>
    </div>
  </nav>
  </div>
  
        
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
         
        </div>
      
   
	
		</div>
		</div>	
		
		
  <script>
  $(document).ready(function(){
		// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
		$('.modal-trigger').leanModal({
      dismissible: false
  });
});
  
  $(document).ready(function(){
	    $('.button-collapse').sideNav();
	    });
  $('.dropdown-button').dropdown({
      inDuration: 300,
      outDuration: 225,
      constrain_width: false, // Does not change width of dropdown to that of the activator
      hover: true, // Activate on hover
      gutter: 0, // Spacing from edge
      belowOrigin: false, // Displays dropdown below the button
      alignment: 'left' // Displays dropdown with edge aligned to the left of button
    }
  );
  </script>
</body>
</html>