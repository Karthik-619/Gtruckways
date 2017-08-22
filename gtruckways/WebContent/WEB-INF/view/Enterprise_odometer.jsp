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
<style>
th.Dtd1{

    text-align: left;
padding:0px;
backgroud-color:#75caeb;
font-size:14px;
}
th.Dtd{

padding:0px;
font-size:14px;	
}

td.Dtd{
padding:0px;
font-size:13px;
}
.gtruck input[type="text"]{
border:none;

} 	
</style> 
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
					<div class="stepbox"><a href="#" id="enterprisecont"><div class="stepS e-cust"style="background-color:#3F51B5;"><i class="fa fa-tachometer" style="color:white;font-size:20px;"></i></div><b>Enterprise Odometer</b></a></div>
								<div class="stepbox"><a href="epay" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
								<div class="stepbox"><a href="entbill" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Billng Details</b></a></div>
								<div class="stepbox"><a href="epaydash" id="paymentdashbord"><div class="stepS e-paymentdash"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Dashboard</b></a></div>
			
	</div>
	<hr>
	<!--SEARCHING DIV  -->
	<div class="row">
		<form action="entodometer" method="post">
		<div class="col s12 m12 l12">
		<div class="input-field col s12 m12 l2">
		<input type="text" name="fromDate" id="odomt_from">
		<label for="odomt_from">&nbsp;<i class="fa fa-calendar"></i>&nbsp;From Date</label>
		</div>
		<div class="input-field col s12 m12 l2">
		<input type="text" name="toDate" id="odomt_To">
		<label for="odomt_from">&nbsp;<i class="fa fa-calendar"></i>&nbsp;To Date</label>
		</div>
		<div class="input-field col s12 m12 l2">
		
		<input type="text" name="vehicleRegNo" >
		<label >&nbsp;&nbsp;Vehicle RegNo</label>
		
		<!-- <select class="browser-default">
		<option vlaue="" selected disabled>Vehicle RegNo</option>
		</select> -->
		</div>
		<div class="input-field col s12 m12 l2">
		<input type="submit" class="btn ent_search" value="search" >
		</div>

		</div>
		</form>
	</div>
	<br>
	
	<div class="row">

	<div class="col s12 m12 l3">
		<fieldset>
	<table>
	<tr>
	<th  class="Dtd1">Enterprise Id</th>
	<td class="Dtd">GTRENT-${odometer.enterpriseId}</td>
	</tr>
	<tr>
	<th  class="Dtd1">Enterprise Name</th>
	<td class="Dtd">${odometer.enterpriseName}</td>
	</tr>
	
	<tr>
	<th  class="Dtd1">Contact Person</th>
	<td class="Dtd">${odometer.contactPerson}</td>
	</tr>
	<tr>
	<th  class="Dtd1">Contact Mobile</th>
	<td class="Dtd">${odometer.contactMobile}</td>
	</tr>
	
	<tr>
	<th  class="Dtd1">Vehicle RegNo#</th>
	<td class="Dtd">${odometer.vehicleRegNo}</td>
	</tr>
	<tr>
	<th class="Dtd1">Vehicle Type</th>
	<td class="Dtd">${odometer.truckName}</td>
	</tr>
	<tr>
	<th class="Dtd1">Driver Name</th>
	<td class="Dtd">${odometer.driverName}</td>
	</tr>
	<tr>
	<th class="Dtd1">Driver Mobile</th>
	<td class="Dtd">${odometer.driverMobileNo}</td>
	</tr>
	</table>
		</fieldset>
	</div>

	<fieldset>
	<legend></legend>
	<table class="responsive-table striped">
	<tr>
	
	<th class="daily" style="padding-right:3rem;">Date Of Travel</th>
	<th class="daily">Start Reading</th>
	<th class="daily">Start Reading Image</th>
	<th class="daily">End Reading</th>
	<th class="daily">End Reading Image</th>
	<!-- <th class="daily">Odometer Details</th> -->
	<th class="daily edit">Edit</th>
	<th class="daily" id="action">Action</th>
	</tr>
	<c:forEach var="odo" items="${odometer.odometerReadings}">
	<form action="updateodo" method="post">
	<tr class="gtruck">
	<td class="daily"><input type="text" name="tripDate" value="${odo.tripDate}" disabled></td>
	<td class="daily"><input type="text" name="startReading" id="sdate_reading" class="validate"  value="${odo.startReading}"  disabled>  <input type="hidden" name="enterpriseCustomerId" value="${odo.enterpriseCustomerId}"/></td>
	<td class="daily" style="text-align:center;"><img src="<c:url value='http://www.gtruckways.com/images/${odo.driverId}/${odo.tripDate}/START.png'/>" width="70%" height="100px" /></td>
	<td class="daily"><input type="text" name="endReading" id="end_reading" class="validate" value="${odo.endReading}" disabled></td>
	 <td class="daily" style="text-align:center;"><img src="<c:url value='http://www.gtruckways.com/images/${odo.driverId}/${odo.tripDate}/END.png'/>" width="70%" height="100px" /></td>
	<!-- <td class="daily"><a href="#odometer" class="modal-trigger">Odometer Details</a></td> -->
		<td class="editbut"><button type="button" class="btn  ent_edit">Edit</button></td>
	<td class="save"><input type="submit" class="btn  ent_save" value="Save" disabled></td> 
	</tr>
	</form>
	</c:forEach>
	</table>
	</fieldset>
	</div>
	 <div id="odometer" class="modal col s12 l12 m5">
  <div class="modal-content ">
    <a href="#" class="fa fa-close modal-action modal-close right"  ></a>
    <br>
    
 <c:forEach var="odo" items="${odometer.odometerReadings}">
    <div class="row">
<div class="col s12 m12 l6">
<fieldset>
<legend>Start odometer Reading</legend>
 <div class="col s12 l12 m12">
   <img src="<c:url value='http://www.gtruckways.com/images/${odo.driverId}/${odo.tripDate}/START.png'/>" width="50%" height="50%" />
    </div>
</fieldset>
</div>
  <div class="col s12 l6 m12">
<fieldset>
<legend>Stop odometer Reading</legend>
 <div class="col s12 l12 m12">
   <img src="<c:url value='http://www.gtruckways.com/images/${odo.driverId}/${odo.tripDate}/END.png'/>" width="100%" height="150" />
    </div>
</fieldset>
</div>


</div>
</c:forEach>

  </div>
  </div>
	    <script> 
	    $('.ent_edit').click(function(){
	   	 $(this).closest('tr').find('input,textarea').removeAttr('disabled');
	   	    $(this).closest('tr').find('textarea,input').removeAttr('readonly');
	       $(this).first().remove();
	       $(this).parent('td.save').last().show();

	       //$('.existing_enter tr:eq(1) td:eq(12)').show();
	       //$(this).parents('td.save').last().show();
	       //$('td:last').show();
	   });
	    
		$(document).ready(function(){
			// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
			$('.modal-trigger').leanModal({
		    dismissible: false,
		});
		});
$(function(){
    $('#odomt_from').appendDtpicker({
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
        $('#odomt_To').appendDtpicker({
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