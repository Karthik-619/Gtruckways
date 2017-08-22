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
		<div class="stepbox"><a href="espare" id="sparetruck"><div class="stepS e-spare" style="background-color:#3F51B5;"><i class="fa fa-truck" style="color:white;font-size:20px;"></i></div><b>Spare Truck</b></a></div>
			<div class="stepbox"><a href="estatus" id="status"><div class="stepS e-status"><i class="fa fa-map-marker" style="color:white;font-size:20px;"></i></div><b>Status of Truck</b></a></div>
				<div class="stepbox"><a href="eodo" id="enterprisecont"><div class="stepS e-cust"><i class="fa fa-tachometer" style="color:white;font-size:20px;"></i></div><b>Enterprise Odometer</b></a></div>
			<div class="stepbox"><a href="epay" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
			<div class="stepbox"><a href="entbill" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Billng Details</b></a></div>
			<div class="stepbox"><a href="epaydash" id="paymentdashbord"><div class="stepS e-paymentdash"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Dashboard</b></a></div>
	</div>
	
	<div class="row">
		<span style="margin-left:2rem;">${entrMsg}</span>
	<div class="col s12 m12 l8">
	<fieldset>
   	<legend><b>Search Spare Truck</b></legend>
   
   	<div class="row">
   
   <c:choose>
   <c:when test="${not empty enterpriseInfo && enterpriseInfo.enterpriseCustomerId!=0}">
   	<div class="right">
   	  <span class="name"><b>Enterprise Name</b>:${enterpriseInfo.enterpriseName}</span><br>
  <span class="id"><b>Enterprise-ID</b>:GTRENT-${enterpriseInfo.enterpriseCustomerId}</span>
   	</div>
   	</c:when>
   	</c:choose>
   	
   	<form action="entsparesrch" method="Post">
   	 <div class="input-field col s12 m6 l3" > 
   	 <select class="browser-default" name="enterpriseName" required>
   	   <option value="" disabled selected>Select EnterpriseName</option>
   	  <c:forEach var="item" items="${EnterPriseNameList}">
     <option>${item.enterpriseName}</option>
   	 </c:forEach>
  
   	 </select> 

			  </div>
			  <div class="input-field col s12 m12 l6">
			  			  <input type="submit" value="search" class="senter btn">
			  </div>
		</form>
		</div>
		
		<br>
		<!-- serch spare truck -->	  
<div class="row">
<table class="responsive-table striped">
<tr>
<th class="daily">Vehicle Type</th>
<th class="daily">Vehicle RegNo#</th>
<th class="daily">No of KM Completed</th>
<th class="daily">Start Time</th>
<th class="daily">End Time</th>
<th class="daily">Action</th>

</tr>

<c:forEach var="vehi" items="${enterpriseInfo.entVehicleDetails}">
<form action="sparesrch" method="Post">
<tr>
<td class="daily">${vehi.vehicleName}<input type="hidden" name="vehicleType" value="${vehi.vehicleName}"></td>
<td class="daily">${vehi.vehicleRegNo}<input type="hidden" name="regNo" value="${vehi.vehicleRegNo}"> </td>
<td class="daily">${vehi.distanceTravelled}</td>
<td class="daily">${vehi.startDate}</td>
<td class="daily">${vehi.endDate}</td>
<td class="daily"><input type="submit" class="ent_edit btn "  value="Search Spare"></td>
</tr>
</form>
</c:forEach>


</table>
</div>


	  </fieldset>
	</div>
<c:choose>	
	<c:when test="${not empty spareinfo}">

	<div class="col s12 m12 l4">
	
	<fieldset>
   <legend><b>Assign Spare Truck</b></legend>
   <form action="addspare" method="post">
	<div class="input-field col s12 m6 l12" >  
  <input type="text" name="spareVehicleType" value="${spareinfo.spareVehicleType}" readonly>
   <input type="hidden" name="assignVehicleRegNo" value="${spareinfo.assignVehicleRegNo}" readonly>
  <label for="">&nbsp;Vehicle Type</label>
		  </div>
  
  <div class="input-field col s12 m6 l12" >  
   	   	 
   	   	 <select class="browser-default" name="spareVehicleRegNo" required>
   	   	 <option value="" disabled selected>Vehicle RegNo</option>
   	   	    	  <c:forEach var="item" items="${spareinfo.vehicleRegNo}">
     <option>${item}</option>
   	 </c:forEach>
   	   	 </select>                                                                                                     
		  </div>
	

		    	<div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="assign_start_date" name="startDate" pattern="(\d{4}-\d{2}-\d{2})"  required>
	  <label for="assign_start_date" data-error="invalid input">&nbsp;<i class="fa fa-calendar"></i>&nbsp;Start Date</label>
		  </div>
 
  
   <div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="assignEnddate" name="endDate" pattern="(\d{4}-\d{2}-\d{2})"  required>
	  <label for="assignEnddate" >&nbsp;<i class="fa fa-calendar"></i>&nbsp;End Date</label>
		  </div>
		  
  	<div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" placeholder=" " id="assignNoofdays" name="noOfDays" pattern="^[0-9]{1,2}"  required>
	  <label for="assignNoofdays"   data-error="invalid input">&nbsp;<i class="fa fa-calendar"></i>&nbsp;No of days</label>
		  </div>
		   <div class="input-field col s12 m6 l12" >  
					<button type="submit" class="add btn right"  id="addbtn"><i class="fa fa-truck">&nbsp;Assign Spare</i></button>
		  </div>
 </form>
  </fieldset>
	</div>
	</c:when>
	</c:choose>
	
	</div>
 <div class="row">
 <div class="col s12 m12 l8">
 <fieldset>
<legend>Assigned Spare Truck details</legend>

<c:choose>
<c:when test="${not empty enterpriseInfo.spareDetails}">

<table class="responsive-table stripped">
<tr>
<th class="daily">Vehicle Type</th>
<th class="daily">Spare Vehicle</th>
<th class="daily">Regular Vehicle</th>
<th class="daily">No Of Days</th>
<th class="daily">Start Date</th>
<th class="daily">End Date</th>
<th class="daily">Action</th>
</tr>

<c:forEach var="spare" items="${enterpriseInfo.spareDetails}">
<form action="reassign" method="Post">
<tr>
<td class="daily">${spare.spareVehicleType} </td>
<td class="daily">${spare.spareVehicleRegNo}<input type="hidden" name="spareVehicleRegNo" value="${spare.spareVehicleRegNo}"></td>
<td class="daily">${spare.assignVehicleRegNo}<input type="hidden" name="assignVehicleRegNo" value="${spare.assignVehicleRegNo}"></td>
<td class="daily">${spare.noOfDays}</td>
<td class="daily">${spare.startDate}</td>
<td class="daily">${spare.endDate}</td>
<td class="daily"><input type="submit" class="ent_edit btn"  value="Reassign Truck"></td>
</tr>
</form>
</c:forEach>



</table>
</c:when>

<c:otherwise>

<span style="color:white;background-color:rgba(255, 0, 0, 0.67);font-size:12px;padding:3px;margin-left:25rem;">No spare Truck Found</span>


</c:otherwise>

</c:choose>


</fieldset>
 
 </div>
 <c:choose>
 <c:when test="${not empty assignSpareInfo}">
  <div class="col s12 m12 l4">
 <fieldset>
   <legend><b>Reassign Regular Truck</b></legend>
 <form action="reassignSpare" method="post">
   <div class="input-field col s12 m6 l12" >  
     	<input type="text"  id="reassigntruckreg"  name="spareVehicleRegNo"  value="${assignSpareInfo.spareVehicleRegNo}" readonly>
	  <label for="reassigntruckreg">&nbsp;<i class="fa fa-truck"></i>&nbsp;Spare Vehicle</label>
	  </div>
	    <div class="input-field col s12 m6 l12" >  
     	<input type="text"  id="reassigntruckregTo" name="assignVehicleRegNo" value="${assignSpareInfo.assignVehicleRegNo}"   readonly>
	  <label for="reassigntruckregTo">&nbsp;<i class="fa fa-truck"></i>&nbsp;Regular Vehicle</label>
	  </div>
	   <div class="input-field col s12 m6 l12" >  
<input type="submit" class="add btn right"  id="addbtn" value="ReAssign Truck">
	  </div>
   </form>
   </fieldset>
 
 </div>
 </c:when>
 
 </c:choose>
 
 </div>



<script>
$(function(){
    $('#sdate_only,#edate_only1,#assign_start_date,#assignEnddate,#entpaymentdate').appendDtpicker({
    "autodateOnStart":false,
  "closeOnSelected": true,
  "futureOnly": true,
  "amPmInTimeList":false,
  "closeButton": true,
  "dateOnly":true,
  "dateFormat":"YYYY-MM-DD",
    });
   });
   
$("#assignEnddate,#assign_start_date").change(function(){
	   var start=new Date($('#assign_start_date').handleDtpicker('getDate'));

 	var end= new Date($('#assignEnddate').handleDtpicker('getDate'));
		days = (end- start) / (1000 * 60 * 60 * 24);
		$("#assignNoofdays").val(Math.round(days));
});
	
</script>
</body>
</html>