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
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
	<style>
body{
font-family: 'Raleway', sans-serif;
}
@media (max-width: 603px)
{
.logo {
    width: 80%;
    height: 15%;
}
}

	nav
{
background-color:#1253A4;
}
    header, main, footer {
      padding-left: 240px;
    }

    @media only screen and (max-width : 992px) {
      header, main, footer {
        padding-left: 0;
      }
      .btn.booknow{
         width:42%;
      margin-left: 6rem;

      }
      img{
    max-height: 500px;
        width: auto;
      }
    }
          .parallax-container {
    position: relative;
    overflow: hidden;
    height: 600px;
}
.side-nav.fixed {
    left: 0;
    background-color: rgba(0, 0, 0, 0.84);
    /* color: aqua; */
    position: fixed;
}
.side-nav.fixed a {
    display: block;
    padding: 0 15px;
    color: #fff;
}
.side-nav a {
    line-height: 74px;
    height: 64px;
}
.side-nav li{
     float: none; 
    padding: 0; 
    line-height: 0px; 
}
side-nav.fixed a {
    display: block;
    padding: 0 24px;
    color: #fff;
}
.side-nav a:hover{
background-color: rgba(0, 0, 0, 0);
color:#000;
}
.side-nav li.logo a:hover{
background-color: rgba(0, 0, 0, 0.1);
}
.side-nav li.logo a:hover{
background-color: #fff;

}
/*heading margin */
.heading{
margin-top:13rem;
font-weight: 600;	
font-family:Trebuchet MS;
}
.booknow{
background-color: #1253a4;
border:1px solid white;
width:12%;
font-family:Trebuchet MS;
}
.btn:hover{
background-color: white;
color:#1253a4;
border: 2px solid #1253a4;
}
	</style>
</head>
 <body>
 <header>
      
      <div class="">
      <nav class="hide-on-large-only"><a href="#" data-activates="nav-mobile" class="button-collapse top-nav full hide-on-large-only">&nbsp;<i class="fa fa-bars" style="font-size:25px;"></i></a></nav></div>
      <ul id="nav-mobile" class="side-nav fixed" style="transform: translateX(0%);">
        <li class="logo"><a href="homePage"><img src="img/Logonew.png" class="" height="155%" style="" class="logo" alt="truckwayslogo" /></a></li>
           <li><a href="homePage">Home</a></li>    
      <li><a href="aboutus">About Us</a></li>
        <li><a href="contactus">Contact Us</a></li>
        <li><a href="mini-trucks-booking-rates">Pricing</a></li>
     
      </ul>
    </header>
 <main>
 <div class="">
  	<div class="row">
<div class="parallax-container">
<h4 class="center heading">Deliver Your Goods Faster Than Ever</h4><br>
<a class="btn col offset-l5 booknow" href="homePage">Book Now</a>
    <div class="parallax"><img src="img/test5.jpg" width="100%" height="500px;"></div>
  </div>
  <div class="section white">
    <div class="row container">
  <h2 class="header center" style="font-size:2.5rem;font-family:Trebuchet MS; color:#1253a4;">Gtruckways Transport</h2>    </div>  </div>
  
   <c:forEach items="${seoImageInfo}" var="seo">
  <div class="col s12 m12 l12">
  	<div class="col s12 m12 l6">
  		<img src="<%=request.getContextPath()%>/something/getImg${seo.imageId}" class="z-depth-3" width="100%" height="300px"style="max-height:100%;max-width:100%;">
  	</div>
  	<div class="col s12 m12 l6">
  	<h5 style="font-family:Trebuchet MS; color:#1253a4;" >${seo.title}</h5>
		<p style="text-align:justify">${seo.content}</p>  	
  	</div>
  </div>
  </c:forEach>
  
  

</div>      
 </div>

</main>
   
 <!--  <ul class=" hide-on-med-and-dow" >
 
         <li style="border:1px solid white;width:85px;border-radius:4px;padding:2px;"><a href="#" data-activates="slide-out" class="button-collapse" style="font-size:15px;color:white">&nbsp;&nbsp;<i class="fa fa-bars"></i>&nbsp;&nbsp;Menu</a></li>
         
      </ul> -->
  

      
      <script>
      
      $(document).ready(function(){
          $('.parallax').parallax();
        });
            
      // Initialize collapse button
      $(".button-collapse").sideNav();
      // Initialize collapsible (uncomment the line below if you use the dropdown variation)
      //$('.collapsible').collapsible();
            
      
      
      </script>
 
 </body>
