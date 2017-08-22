<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>gTruckWays</title>
 <meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/local.css" />
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	 <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>          
	 <script type="text/javascript" src="js/createReqObj.js" ></script>
	  <script type="text/javascript" src="js/register.js" ></script>
	  <style>
	  h4{
	      margin: 40px 0 0;
    text-transform: uppercase;
    font-weight: 600;
    color: #a63926;
    font-size: 18px;
	  }
	  body{
	  background-color:#f5f5f5;
	      font-family: proxima-nova;
	      font-size:16px;
	  }
	  p{
	  text-align:justify;
	  }
	  .card-panel {
    transition: box-shadow .25s;
    padding: 20px;
    margin: 0.5rem 0 1rem 0;
    border-radius: 15px;
    background-color: #fff;
}
ul li.term {
    list-style-type: disc;
}
.btn, .btn-large {
    text-decoration: none;
    color: #fff;
    background-color: #1253a4;
    text-align: center;
    letter-spacing: .5px;
    transition: .2s ease-out;
    cursor: pointer;
}

.btn, .btn-large, .btn-flat {
    border: none;
    border-radius: 2px;
    display: inline-block;
    height: 30px;
    line-height: 30px;
    outline: 0;
    padding: 0 0.5rem;
    text-transform: uppercase;
    vertical-align: middle;
    -webkit-tap-highlight-color: transparent;
}
	  </style>
</head>

<body>


          <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      <a href="#" data-activates="mobile-demo" class="button-collapse"><<i class="fa fa-bars" aria-hidden="true"></i></a>
      	<a href="homePage"><img src="img/Logonew.png" class="hide-on-small-only" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
     
	<!-- Before Login -->
 
     
      <ul class="right hide-on-med-and-down ">
        <li><a href="land">HOME</a></li>
      
      </ul>
     
          <ul class="side-nav" id="mobile-demo">
       <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
        <!--  <li><a href="home.jsp">HOME</a></li> -->
           <li><a href="land">HOME</a></li> 
      </ul>
     
          <ul class="side-nav" id="mobile-demo">
       <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
         <li><a href="land"><i class="fa fa-home"></i>Home</a></li>
         
        <li><a href="#modal3" class="modal-trigger"><i class="fa fa-map-marker"></i>Track Order</a></li>
        
         <li><a href="#modal4" class="modal-trigger"><i class="fa fa-sign-in"></i>Login</a></li>
           <li><a href="enterpriseAppForm"><i class="fa fa-building-o" style="font-size:20px;" aria-hidden="true"></i>Enterprise</a></li>
        <!-- <li><a href="http://blog.gtruckways.com"><i class="fa fa-rss" style="font-size:20px;"></i>Blog</a></li>  -->
      <li style="padding-right:20px;"><a href="tel:919590603333"><span><i class="fa fa-phone" style="font-size:20px;"></i>&nbsp;<b>+919590603333</b></span></a></li>
                
      </ul>
    </div>
  </nav>
  </div> <!--./ Local Header -->

<div class="row container">
        <div class="col s12 m6 l11">
          <div class="card z-depth-5">
            <div class="card-action">
              <h4  class="center">Book a Vehicle From 08:00 am to 12:00 pm @ Just Rs 199</h4>
                        <h6 style="font-size:17px;" class="center">For any queries contact &nbsp;<i class="fa fa-phone" style="font-size:20px;color:#1253a4;"><b>+91 9590603333</b></i></h6>
          <!--   <h4>Hire a Vehicle @ Rs 149</h4> -->
               <h3 style="color: #1253A4;font-size:1.2rem;"><b>Terms and conditions</b></h3>
             <hr>
           		 <ol>
           		<li>This offer is applicable if the total Km is more than 15 Km in a trip.</li>
           		<li>One Customer can use this code for 1 time</li>
           		<li>Flat Rs 50 Off on base fare.</li>
           		<li>This Offer is Applicable only on <b>TATA ACE</b></li>
           		<li>This Offer is Applicable from Monday to Friday </li>
           		<li>Use The Promocode <b>HAPPYHOURS</b></li>
           		<li>The Price Excludes <b>GST</b></li>
           		<li class="center" style="list-style-type:none;"><a href="land" class="btn">Book Now&nbsp;&nbsp;<i class="fa fa-chevron-circle-right" aria-hidden="true" style="font-size:16px;"></i></a></li>
           		</ol> 	
            </div>
          </div>
        </div>
      </div>
</body>
 <jsp:include page="footer.jsp"/>
</html>