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
		<div class="stepbox"><a href="entAcc" id="enterprisecont"><div class="stepS e-cust"><i class="fa fa-user" style="color:white;font-size:20px;"></i></div><b>Enterprise Contract</b></a></div>
		<div class="stepbox"><a href="eschedule" id="dailyscheduling"><div class="stepS e-daily"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Daily Scheduling</b></a></div>
		<div class="stepbox"><a href="espare" id="sparetruck"><div class="stepS e-spare"><i class="fa fa-truck" style="color:white;font-size:20px;"></i></div><b>Spare Truck</b></a></div>
		<div class="stepbox"><a href="estatus" id="status"><div class="stepS e-status"><i class="fa fa-map-marker" style="color:white;font-size:20px;"></i></div><b>Status of Truck</b></a></div>
	    <div class="stepbox"><a href="Enterprise_odometer.jsp" id="enterprisecont"><div class="stepS e-cust"><i class="fa fa-tachometer" style="color:white;font-size:20px;"></i></div><b>Enterprise Odometer</b></a></div>
	    <div class="stepbox"><a href="epay" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
	    <div class="stepbox"><a href="entbill" id="paymentdetails"><div class="stepS e-payment" style="background-color:#3F51B5;"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Billng Details</b></a></div>
	    <div class="stepbox"><a href="epaydash" id="paymentdashbord"><div class="stepS e-paymentdash"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Dashboard</b></a></div>
	</div>
			<div class="row">
	
	<form action="entsrch" method="Post">
  	<div class="input-field col s12 m6 l2" >
		  
  	<select class="browser-default" name="enterpriseName" required>
   	    <option value="" disabled selected>Select EnterpriseName</option>
   	  
		 </select> 	   
			  <span id="ent-name"></span>
	<datalist id="e_name_srch"></datalist>
			  </div>
			<div class=" input-field col s12 m12 l2">
					<input type="submit" class="srch btn" value="search" id="srchbtn"/><!-- <i class="fa fa-search">search</i></button> -->
	 			</div>
		 </form>
		
	<!-- 		<div class=" input-field col s12 m12 l2">
			
					<button type="button" class="add btn"  id="addbtn"><i class="fa fa-plus">Add</i></button>
	 </div>	 -->
		
	</div>
		<fieldset>
		<legend></legend>
		<div class="right">
		<span style="font-size:12px;"><b>Enterprise Name:</b></span><br/>
		<span style="font-size:12px;"><b>Enterprise ID:</b></span><br/>
		</div>
		<table>
		  <tr>
  
  <th class="daily">Vehicle RegNo</th>
  <th class="daily">Vehicle Type</th>
  <th class="daily">Distance</th>
  <th class="daily">Start Date</th>
  <th class="daily">End Date</th>
  <th class="daily">Amount</th>
  </tr>
  <tr>
  <td class="daily">KA1234</td>
   <td class="daily">tata ace</td>
 <td class="daily">12</td>
  <td class="daily">20-10-2013</td>
    <td class="daily">21-10-2013</td>
      <td class="daily">2000</td>
  </tr>
   <tr>
  <td class="daily">KA1234</td>
   <td class="daily">tata ace</td>
 <td class="daily">12</td>
  <td class="daily">20-10-2013</td>
    <td class="daily">21-10-2013</td>
      <td class="daily">2000</td>
  </tr>
   <tr>
  <td class="daily">KA1234</td>
   <td class="daily">tata ace</td>
 <td class="daily">12</td>
  <td class="daily">20-10-2013</td>
    <td class="daily">21-10-2013</td>
      <td class="daily">2000</td>
  </tr>
   <tr>
  <td class="daily"></td>
   <td class="daily"></td>
 <td class="daily"></td>
  <td class="daily"></td>
    <td class="daily"><b>Total Amount</b></td>
      <td class="daily"><b>2000</b></td>
  </tr>
		</table>
		</fieldset>
		<fieldset>
		<legend>Payment Mode</legend>
		<div class="right">
		<span style="font-size:12px;"><b>Payment Date:</b></span><br/>
		<span style="font-size:12px;"><b>Due Date:</b></span>
		</div>
		<br>
		<div class="col s12 m12 l12">
		<div class="">
		<input class="with-gap" type="radio" name="payment" value="rtgs" id="rtgs">
		<label for="rtgs">RTGS/NEFT</label>
		<input class="with-gap" type="radio" name="payment" id="cash">
		<label for="cash">Cash</label>
		<input class="with-gap" type="radio" name="payment" id="Check">
		<label for="Check">Check</label>
		</div>
		
		<!--Rtgs payment  -->
		<div class="row" id="rtgstrans" style="display:none;">
		<div class="input-field col s12 m12 l2">
		<input type="text" name="">
		<label>Transaction No</label>
		</div>
		<div class="input-field col s12 m12 l2">
		<input type="submit" class="btn" value="Pay">
		</div>
		</div>
		
		<!--Cash payment -->
		<div class="row" id="cashpay" style="display:none;">

		<div class="input-field col s12 m12 l2" >
		<input type="submit" class="btn" value="Pay">  
		</div> 
		</div>
		
		<!--Check payment  -->
		<div class="row" id="checkno" style="display:none;">
		<div class="input-field col s12 m12 l2">
		<input type="text" name="">
		<label for="">Check No</label>
		</div>
		<div class="input-field col s12 m12 l2">
		<input type="submit" class="btn" value="Pay">
		</div>
	</div>
	
		</div>
		</fieldset>
		
		<script>
		$("#rtgs,#cash,#Check").click(function(){
			$("#rtgstrans").show();
			$("#cashpay,#checkno").hide();
		})
			$("#cash").click(function(){
			$("#cashpay").show();
			$("#rtgstrans,#checkno").hide();
		})
			$("#Check").click(function(){
			$("#checkno").show();
			$("#rtgstrans,#cashpay").hide();
		})
		</script>
</body>
</html>