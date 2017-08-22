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
<script type="text/javascript" src="js/enterprise.js" ></script> 
<script type="text/javascript" src="js/createReqObj.js" ></script>
<style>
.data
{
border:none;
}
.row
{
border:none;
}

.gtruck input[type="text"]{
border:none;
border-bottom:1px solid black;
}
input:contains(“info”) { background-color:red;}
</style> 
</head>

<body >
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
		<div class="stepbox"><a href="eschedule" id="dailyscheduling"><div class="stepS e-daily" style="background-color:#3F51B5;"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Daily Scheduling</b></a></div>
		<div class="stepbox"><a href="espare" id="sparetruck"><div class="stepS e-spare"><i class="fa fa-truck" style="color:white;font-size:20px;"></i></div><b>Spare Truck</b></a></div>
			<div class="stepbox"><a href="estatus" id="status"><div class="stepS e-status"><i class="fa fa-map-marker" style="color:white;font-size:20px;"></i></div><b>Status of Truck</b></a></div>
				<div class="stepbox"><a href="eodo" id="enterprisecont"><div class="stepS e-cust"><i class="fa fa-tachometer" style="color:white;font-size:20px;"></i></div><b>Enterprise Odometer</b></a></div>
			<div class="stepbox"><a href="epay" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
			<div class="stepbox"><a href="entbill" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Billng Details</b></a></div>
			<div class="stepbox"><a href="#" id="paymentdashbord"><div class="stepS e-paymentdash"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Dashboard</b></a></div>
	</div>
		<div class="row daily_sche">
	<div class="col s12 l12 m12">
	<fieldset>
  <legend>

  </legend>
  <form>
  <br>
     
 
  <table class="responsive-table striped">

  <tr>
  
  <th class="daily">Enterprise Id</th>
  <th class="daily">Enterprise Name</th>
  <th class="daily">Truck Type</th>
  <th class="daily">Truck Reg No</th>
  <th class="daily">Driver Name</th>
  <th class="daily">Driver MobileNo</th>
  <th class="daily">Source</th>
  <th class="daily">Destination</th>
  <th class="daily">Start Date</th>
  <th class="daily">End Date</th>
  <th class="daily">Scheduled Time</th>
  

  </tr>
  
  


   <c:forEach var="sc" items="${scheduleInfo}"> 
  <tr>
   <td class="daily">GTRENT-${sc.enterpriseId}</td>
   <td class="daily">${sc.enterpriseName }</td>
  
  <td class="daily">${sc.vehicleName}</td>
   <td class="daily">${sc.vehicleRegNo }</td>
   <td class="daily">${sc.driverName }</td>
   <td class="daily">${sc.driverMobile }</td>
   <td class="daily"><textarea style="border:none;">${sc.source}</textarea></td>
   <td class="daily"><textarea style="border:none;">${sc.destination}</textarea></td>
    <td class="daily">${sc.startDate}</td>
   <td class="daily">${sc.endDate}</td>
   <td class="daily">${sc.scheduleTime}</td>
     
  </tr>
  </c:forEach>

  </table>


 
  </form>
  </fieldset>
	</div>
	</div>
	
	 
	
	<script type="text/javascript">
	$(document).ready(function(){
		// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
		$('.modal-trigger').leanModal({
	    dismissible: false,
	});
	});
	</script>
</body>
</html>