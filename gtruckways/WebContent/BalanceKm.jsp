<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/local.css" />
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
	 <script type="text/javascript" src="js/createReqObj.js" ></script>
	  <script type="text/javascript" src="js/register.js" ></script>
	  <style>
	
	   .card-content
	  {
	  height:70%;
	  }
	  </style>
</head>
<body>
<div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      
      	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a><span style="font-size:35px;margin-left:32rem;padding-bottom:1rem;color:#fff">Enterprise</span>
      <ul class="right hide-on-med-and-down ">
 
       
      </ul>
   
    </div>
  </nav>
  </div> <!--./ Local Header -->

<div class="row">
<div class="card col s12 m12 l2">

<div class="card-content">

<a href="EnterpriseDashboard.jsp"><img src="img/user.jpg" width="60%"></a>

</div>
<div class="card-content">

<b>GTRENT1001</b>

</div>
<div class="card-content">

<a href="TrackTruck.jsp"><i class="fa fa-truck"></i>&nbsp;&nbsp;Track Truck</a>
</div>
<div class="card-content">

<a href="BalanceKm.jsp"><i class="fa fa-balance-scale"></i>&nbsp;&nbsp;Balance KM</a>
</div>
<div class="card-content">

<a href="#"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Billing Details</a>
</div>

<div class="card-content">

<a href="AccountSettings.jsp"><i class="fa fa-cog"></i>&nbsp;&nbsp;Account Settings</a>
</div>
<div class="card-content">


</div>

</div>
<div class="card col s12 m12 l10">
<div class="card-content ">
              <span class="card-title">Balance Kilometer </span>
              
            </div>
<div class="card-action">

  <div class="row">
  <div class="container center">
     <form action="enterprise" method="post" class="enterprise"  autocomplete="on" style="margin-left:130px">
    <div class="row">
     	 <div class="input-field col s12 m12 l8 ">
           
             <select  name="truckType" class="browser-default"  required="required" onclick="samecity()"style="height:2rem;">
                  <option value="" disabled selected>Vehicle Type</option>
                  <option value="1">TATA ACE</option>
                  <option value="2">TATA 407</option>
                  <option value="6">TATA SUPER ACE</option>
                  <option value="3">CANTER 14FT</option>
                   <option value="4">CANTER 17FT</option>
                   <option value="5">CANTER 19FT</option>
                 
               </select>
  		 </div>
  	</div>
  	<div class="row">
  		 <div class="input-field col s12 m12 l8 ">
           <select  name="truckType" class="browser-default"  required="required" onclick="samecity()"style="height:2rem;">
                  <option value="" disabled selected>Vehicle RegNo</option>
                 
               </select>
  		</div>
  	</div>
  	<div class="row">
  		 <div class="input-field col s12 m12 l8 ">
            <input  id="e_contname" type="text" name="contactPerson" class="validate"    placeholder="Frequency of Vehicle" required>
  		</div>
  	</div>
  	<div class="row">
  		 <div class="input-field col s12 m12 l8 ">
            <input  id="e_contname" type="text" name="contactPerson" class="validate"  placeholder="No of Km/Month" required>
  		</div>
  	</div>
  	<div class="row">
  		 <div class="input-field col s12 m12 l8 ">
            <input  id="e_contname" type="text" name="contactPerson" class="validate"   placeholder="Travalled Km/Month" required>
  		</div>
  	</div>
  	<div class="row">
  		  <div class="input-field col s12 m12 l8 ">
            <input  id="e_contname" type="text" name="contactPerson" class="validate"    placeholder="Remaining Km/month" required>
  		 </div>
  	</div>
  		
  	   </form>
  		</div>
  		
   		
   		
   		
   
  
  
    
 
    </div>
     
      </div>
</div>
</div>


</body>
</html>