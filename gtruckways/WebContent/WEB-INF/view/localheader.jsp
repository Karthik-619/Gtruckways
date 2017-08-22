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
	

	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/local.css" />
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
 	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>	
	<script type="text/javascript" src="js/local_pricing.js"></script>
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
      <%-- <!-- <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a> -->
      	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%" class="logo" alt="" /></a>
     
      <!-- Mobile Demo -->
      <ul class="side-nav" id="mobile-demo">
         <li><a href="home.jsp"><i class="fa fa-home"></i>Home</a></li>
      </ul>
      
      
     
       <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">Menu</i></a>   --%>
       
         	
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
   <li><a href="homePage">Home</a></li>
   <!--   <ul class="left" style="margin-left:-32rem">
       <li><a href="homePage">Home</a></li>
         <li><a href="aboutus">About Us</a></li>  
         </ul>    -->  
          <!-- <li><a href="contactus">Contact Us</a>
          <li><a href="mini-trucks-booking-rates">Pricing</a></li>  
   		 <li><a href="#modal3" class=" modal-trigger" >Track Order</a></li>
   		 <li><a href="#modal4" class="modal-trigger" id="llogin">Sign In </a></li>
   		 <li><a href="enterpriseAppForm">Enterprise</a>
   		 <li><a href="#"><span><i class="fa fa-phone" style="font-size:20px;"></i>&nbsp;+919590603333</span></a></li> -->
      </ul>
 
      <ul class="side-nav" id="mobile-demo">
       <li> <img src="img/Logonew.png" width="50%" class="logo1"  alt="" /></li>
         <li><a href="homePage"><i class="fa fa-home"></i>Home</a></li> 
        <!--   <li><a href="aboutus">About Us</a></li>       
   		 <li><a href="#modal3" class=" modal-trigger" >Track Order</a></li>
   		 <li><a href="#modal4" class="modal-trigger" id="llogin">Sign In </a></li>
   		 <li><a href="contactus">Contact Us</a>
   		 <li><a href="enterpriseAppForm">Enterprise</a> -->
   		 <li><a href="#"><span><i class="fa fa-phone" style="font-size:20px;"></i>&nbsp;+919590603333</span></a></li>
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



 
 
	
		

</body>
</html>