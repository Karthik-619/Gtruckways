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
/*Date picker close btn  */
.datepicker > .datepicker_header > .icon-close {
    position: absolute;
    display: block;
    width: 16px;
    height: 16px;
    vertical-align: middle;
    padding: 1px;
    top: 0;
    right: 0;
}
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
		<div class="stepbox"><a href="eschedule" id="dailyscheduling"><div class="stepS e-daily"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Daily Scheduling</b></a></div>
		<div class="stepbox"><a href="espare" id="sparetruck"><div class="stepS e-spare"><i class="fa fa-truck" style="color:white;font-size:20px;"></i></div><b>Spare Truck</b></a></div>
			<div class="stepbox"><a href="estatus" id="status"><div class="stepS e-status"><i class="fa fa-map-marker" style="color:white;font-size:20px;"></i></div><b>Status of Truck</b></a></div>
				<div class="stepbox"><a href="eodo" id="enterprisecont"><div class="stepS e-cust"><i class="fa fa-tachometer" style="color:white;font-size:20px;"></i></div><b>Enterprise Odometer</b></a></div>
			<div class="stepbox"><a href="epay" id="paymentdetails"><div class="stepS e-payment" style="background-color:#3F51B5;"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
						<div class="stepbox"><a href="entbill" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Billng Details</b></a></div>
			<div class="stepbox"><a href="epaydash" id="paymentdashbord"><div class="stepS e-paymentdash"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Dashboard</b></a></div>


	</div>
	
	  <div class="row" id="enterprisepayment" >
    	<fieldset>
    	<c:choose>
    	<c:when test="${not empty epayinfo}">
    	<br>
    	<div class="right">
   	  <span class="name"><b>Enterprise Name</b>:${epayinfo.enterpriseName}</span><br>
  <span class="id"><b>Enterprise-ID</b>:GTRENT-${epayinfo.enterpriseCustomerId}</span>
   	</div>
   	</c:when>
   	</c:choose>
<div class="col s12 m12 l6">
<div class="row">
<form action="enttripDetails" method="Post">
<div class="input-field col s12 m12 l3">
<input type="text" id="from_pay" name="startDate" required>
<label>&nbsp;<i class="fa fa-calendar"></i>&nbsp;From Date</label>
</div>
<div class="input-field col s12 m12 l3" required>
<input type="text" id="to_pay" name="endDate">
<label>&nbsp;<i class="fa fa-calendar"></i>&nbsp;To Date</label>
</div>
<div class="input-field col s12 m12 l3">
<select class="browser-default" name="enterpriseName" required>
 <option value="" disabled selected>Select EnterpriseName</option>
   	  <c:forEach var="item" items="${EnterPriseNameList}">
     <option>${item.enterpriseName}</option>
   	 </c:forEach>
</select>
</div>
<div class="input-field col s12 m12 l3">
<input type="submit" value="search" class="btn ent_search">
</div>
</form>
</div>
</div>
<div class="input-field col s12 m12 l12">
<table class="striped">
<tr>
<th class="daily">Sl.NO</th>
<th class="daily">Vehicle RegNo#</th>
<th class="daily">Vehicle Type</th>
<th class="daily">Fixed Distance</th>
<th class="daily">Traveled Distance</th>
<th class="daily">Fixed Days</th>
<th class="daily">Actual Working Days</th>
<th class="daily">Start Date</th>
<th class="daily">End Date</th>
<th class="daily">Total Amount</th>
</tr>

<c:set var="count" value="0" scope="page" />
<c:forEach var="vehiinfo" items="${epayinfo.invoiceInfo}">
<tr>
<c:set var="count" value="${count + 1}" scope="page"/>
<td class="daily" style="text-align:center;">${count}</td>
<td class="daily" style="text-align:center;">${vehiinfo.vehicleRegNo}</td>
<td class="daily" style="text-align:center;">${vehiinfo.vehicleType}</td>
<td class="daily" style="text-align:center;">${vehiinfo.fixedKm}&nbsp;Km</td>
<td class="daily" style="text-align:center;">${vehiinfo.totalKm}&nbsp;Km</td>
<td class="daily" style="text-align:center;">${vehiinfo.fixedDays}</td>
<td class="daily" style="text-align:center;">${vehiinfo.actualWorkingDays}</td>
<td class="daily" style="text-align:center;">${vehiinfo.startDate}</td>
<td class="daily" style="text-align:center;">${vehiinfo.endDate}</td>
<td class="daily" style="text-align:center;">${vehiinfo.actualAmount}&nbsp;Rs</td>
</tr>
</c:forEach>
</table>
      </div>
      </fieldset>
      </div>
      <br>
<a href="Enterprise_Invoice.jsp" class="btn show_invoice">Show Invoice</a>
<br>
      <div class="row">
      <fieldset>
      <legend>Trip Details</legend>
   
      <table class="responsive-table striped">
    
      <tr>
      <th class="daily">Sl.NO</th>
      <th class="daily">Vehicle RegNo#</th>
      <th class="daily">Vehicle Type</th>
      <th class="daily">Date of travel</th>
      <th class="daily">Opening Km</th>
      <th class="daily">Closing Km</th>
      <th class="daily">No of KM/Day</th>
      <th class="daily">Start Time</th>
      <th class="daily">End Time</th>
      <th class="daily">No of Hr/Day</th>
      <th class="daily">Additional Min/Day</th>
      <th class="daily">Additional Amount</th>
      
      
      </tr>
      <c:set var="count" value="0" scope="page" />
     <c:forEach var="tripinfo" items="${epayinfo.eTripdetails}">
      <tr>
      <c:set var="count" value="${count + 1}" scope="page"/>
      <td class="daily">${count}</td>
      <td class="daily">${tripinfo.vehicelRegNo}</td>
       <td class="daily">${tripinfo.vehicleType}</td>
      <td class="daily">${tripinfo.tripDate}</td>
       <td class="daily">${tripinfo.startReading}</td>
       <td class="daily">${tripinfo.endReading}</td> 
       <td class="daily">${tripinfo.distance}</td>
       <td class="daily">${tripinfo.startReadingTime}</td>
       <td class="daily">${tripinfo.endReadingTime}</td>
      <td class="daily">${tripinfo.todayMins}</td>
      <td class="daily">${tripinfo.additionalTime}</td>
      <td class="daily">${tripinfo.additionalAmount}</td>
      </tr>
      </c:forEach>
      </table>
      </fieldset>
      </div>
    <script> 
$(function(){
    $('#from_pay').appendDtpicker({
    "autodateOnStart":false,
  "closeOnSelected": true,
  
  "maxDate":new Date,
  "amPmInTimeList":false,
  "closeButton": true,
  "dateOnly":true,
  "dateFormat":"YYYY-MM-DD",
    });
   });
    $(function(){
        $('#to_pay').appendDtpicker({
        "autodateOnStart":false,
      "closeOnSelected": true,
      "futureOnly": false,
      "amPmInTimeList":false,
      "closeButton": true,
      "dateOnly":true,
      "dateFormat":"YYYY-MM-DD",
        });
       });
   </script>
</body>
</html>