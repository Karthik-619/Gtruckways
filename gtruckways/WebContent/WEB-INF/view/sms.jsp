<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
 <link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/enterprise.css" />	
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
      <script src="http://maps.googleapis.com/maps/api/js"></script>
<script src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery-dtpicker.js"></script>
<script type="text/javascript" src="js/materialize.js" ></script>
<script type="text/javascript" src="js/materialize.min.js" ></script> 
</head>

<body>
<div class="navbar-fixed"><!-- Header -->
<nav>
    <div class="nav-wrapper" >
     <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars"></i></a>
    	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a>
    	<span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;color:#fff">Customer Care</span>
<!--    <span style="margin-left:20%;font-size:15px;"> <a href="maptest.jsp"><i class="fa fa-map-marker"></i><b>Status of truck</b></a></span>
 -->     <ul class="side-nav" id="mobile-demo">
     <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
      </ul>
   
    </div>
  </nav>
  </div> <!--./Header -->
  <span>${msg}</span>
  <div class="row">
  	<div class="col s12 m12 l6">
  	<h5>SMS To Driver</h5>
  	<hr>
  	<h6 class="center">Customer Details</h6>
  <form action="smsdriver" method="Post">
  		<div class="row">
  		  <div class="input-field col s12 m12 l6">
  		 <input type="text" name="sendTo"  required>
  		 <label> &nbsp;<i class="fa fa-phone"></i>&nbsp;Enter Driver Mobile Number</label>
  		</div> 
  		<div class="input-field col s12 m12 l6">
  		 <input type="text" name="customerName"  required>
  		 <label>&nbsp; <i class="fa fa-user"></i> &nbsp;Customer Name</label>
  		</div>
  		
  		
  		</div>
  		<div class="row">
  		<div class="input-field col s12 m12 l6">
  		 <input type="text" name="customerMobileNo"  pattern="^[789]\d{9}$"  class="validate" maxlength="10" required>
  		 <label>&nbsp; <i class="fa fa-phone"></i> &nbsp; Mobile No</label>
  		</div> 
  		<div class="input-field col s12 m12 l6">
  		 <input type="text" name="pickUpTime"   required>
  		 <label>&nbsp;<i class="fa fa-map-marker"></i>&nbsp; Pick Up Time</label>
  		</div>
  		</div>
  		<div class="row">
  		
  		<div class="input-field col s12 m12 l6">
  		 <input type="text" name="pickUpLocation"  required>
  		 <label>&nbsp;<i class="fa fa-map-marker"></i>&nbsp; Pick Up location</label>
  		</div>
  		<div class="input-field col s12 m12 l6">
  		 <input type="text" name="dropLocation"   required>
  		 <label>&nbsp;<i class="fa fa-map-marker"></i>&nbsp; Drop location</label>
  		</div>
  		</div>
  		<div class="input-field col s12 m12 l6">
  		<input type="submit" value="submit" class="btn">
  		</div>
  		
  		</form>
  	</div>
  	
  	
  <div class="col s12 m12 l6">
  <h5>SMS To Customer</h5>
  <hr>
  <h6 class="center">Driver Details</h6>
<form action="smscust" method="Post">
  <div class="row">
   	  <div class="input-field col s12 m12 l6">
  		 <input type="text" name="sendTo"  required>
  		 <label>&nbsp;<i class="fa fa-phone"></i>&nbsp;Enter customer Mobile Number </label>
  		</div>
  		<div class="input-field col s12 m12 l6">
  		 <input type="text" name="bookingId" required>
  		 <label>&nbsp;<i class="fa fa-newspaper-o" aria-hidden="true"></i>&nbsp;Booking ID</label>
  		</div>
  		</div>
  		<div class="row">
  		<div class="input-field col s12 m12 l6">
  		 <input type="text" name="driverName" required>
  		 <label>&nbsp;<i class="fa fa-user"></i>&nbsp;Driver Name</label>
  		</div>
  		<div class="input-field col s12 m12 l6">
  		 <input type="text" name="vehicleRegNo" required>
  		 <label>&nbsp;<i class="fa fa-truck"></i>&nbsp; Vehicle reg No</label>
  		</div>
  		</div>
  		<div class="row">
  		<div class="input-field col s12 m12 l6">
  		 <input type="text" name="driverMobileNo"  pattern="^[789]\d{9}$"  class="validate" maxlength="10" required>
  		 <label>&nbsp;<i class="fa fa-phone"></i>&nbsp; Driver Mobile No</label>
  		</div>
  	<div class="input-field col s12 m12 l6">
  		<input type="submit" value="submit" class="btn">
  		</div>
  		</div>
  		</form>
  </div>
  </div>
  <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=true&libraries=places&key=AIzaSyDmfsnWuRT_lsvnEPJWmoFPPMsIr6N_mus"></script>
<script type="text/javascript">
function initialize() {
	var defaultBounds = new google.maps.LatLngBounds(
			  new google.maps.LatLng(12.9538477,77.3507369),
			  new google.maps.LatLng(12.9538477,77.3507369));
var options = {
	types: ['geocode'], 
	bounds: defaultBounds,
    componentRestrictions: {country: "in"}
  };
  var input = document.getElementById('frmarea');
  var toarea =document.getElementById('tooarea');
  var autocomplete = new google.maps.places.Autocomplete(input, options);

  var autocomplete = new google.maps.places.Autocomplete(toarea, options);
  //autocomplete.bindTo('bounds', map);
 }
google.maps.event.addDomListener(window, 'load', initialize);
</script>
</body>
</html>