<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script src="js/jquery.js"></script>	
<script type="text/javascript" src="js/materialize.js" ></script>
<script type="text/javascript" src="js/materialize.min.js" ></script> 
<script type="text/javascript" src="js/enterprise.js" ></script> 
<script type="text/javascript" src="js/createReqObj.js" ></script>


</head>
<body>
<div class="navbar-fixed"><!-- Header -->
<nav>
    <div class="nav-wrapper" >
     <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars"></i></a>
    	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a>
    	<span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;color:#fff">Account Manager</span>
<!--    <span style="margin-left:20%;font-size:15px;"> <a href="maptest.jsp"><i class="fa fa-map-marker"></i><b>Status of truck</b></a></span>
 -->     <ul class="side-nav" id="mobile-demo">
     <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
      </ul>
   
    </div>
  </nav>
  </div> <!--./Header -->

<div class="top"></div>
<div class="stepbar">
		<div class="stepbox"><a href="entAcc" id="enterprisecont"><div class="stepS e-cust"style="background-color:#3F51B5;"><i class="fa fa-user" style="color:white;font-size:20px;"></i></div><b>Enterprise Contract</b></a></div>
		<div class="stepbox"><a href="eschedule" id="dailyscheduling"><div class="stepS e-daily"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Daily Scheduling</b></a></div>
		<div class="stepbox"><a href="espare" id="sparetruck"><div class="stepS e-spare"><i class="fa fa-truck" style="color:white;font-size:20px;"></i></div><b>Spare Truck</b></a></div>
			<div class="stepbox"><a href="estatus" id="status"><div class="stepS e-status"><i class="fa fa-map-marker" style="color:white;font-size:20px;"></i></div><b>Status of Truck</b></a></div>
	<div class="stepbox"><a href="Enterprise_odometer.jsp" id="enterprisecont"><div class="stepS e-cust"><i class="fa fa-tachometer" style="color:white;font-size:20px;"></i></div><b>Enterprise Odometer</b></a></div>
			<div class="stepbox"><a href="epay" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
			<div class="stepbox"><a href="entbill" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Billng Details</b></a></div>
				<div class="stepbox"><a href="epaydash" id="paymentdashbord"><div class="stepS e-paymentdash" style="background-color:#3F51B5;"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Dashboard</b></a></div>
	</div>


<fieldset>
		<legend></legend>
		<div class="row">
		   	<form action="" method="Post">
   	 <div class="input-field col s12 m6 l2" > 
   	 <select class="browser-default" name="" required>
   	   <option value="" disabled selected>Select EnterpriseName</option>
  
     <option></option>

  
   	 </select> 

			  </div>
			  <div class="input-field col s12 m12 l6">
			  			  <input type="submit" value="search" class="senter btn">
			  </div>
		</form>
		</div>
		<table>
		  <tr>
  <th class="daily">Enterprise Name</th>
  <th class="daily">Invoice ID</th>
  <th class="daily">Invoice Date</th>
  <th class="daily">Total Amount</th>
  <th class="daily">Payment Status</th>
  </tr>
  <tr>
  <td class="daily">KA1234</td>
   <td class="daily">tata ace</td>
 <td class="daily">12</td>
  <td class="daily">20-10-2013</td>
    <td class="daily">21-10-2013</td>

  </tr>
   <tr>
  <td class="daily">KA1234</td>
   <td class="daily">tata ace</td>
 <td class="daily">12</td>
  <td class="daily">20-10-2013</td>
    <td class="daily">21-10-2013</td>
   
  </tr>
   <tr>
  <td class="daily">KA1234</td>
   <td class="daily">tata ace</td>
 <td class="daily">12</td>
  <td class="daily">20-10-2013</td>
    <td class="daily">21-10-2013</td>
  
  </tr>

		</table>
		</fieldset>
</body>
</html>