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
    	<a href="homePage"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a>
    	<span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;color:#fff">Account Manager</span>
   <span style="margin-left:20%;font-size:15px;"> <a href="maptest.jsp"><i class="fa fa-map-marker"></i><b>Status of truck</b></a></span>
     <ul class="side-nav" id="mobile-demo">
     <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
      </ul>
   
    </div>
  </nav>
  </div> <!--./Header -->


<div class="top"></div>
	<div class="stepbar">
		<div class="stepbox"><a href="#" id="enterprisecont"><div class="stepS e-cust"style="background-color:#3F51B5;"><i class="fa fa-user" style="color:white;font-size:20px;"></i></div><b>Enterprise Contract</b></a></div>
		<div class="stepbox"><a href="#" id="dailyscheduling"><div class="stepS e-daily"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Daily Scheduling</b></a></div>
		<div class="stepbox"><a href="#" id="sparetruck"><div class="stepS e-spare"><i class="fa fa-truck" style="color:white;font-size:20px;"></i></div><b>Spare Truck</b></a></div>
			<div class="stepbox"><a href="#" id="status"><div class="stepS e-status"><i class="fa fa-map-marker" style="color:white;font-size:20px;"></i></div><b>Status of Truck</b></a></div>
			<div class="stepbox"><a href="#" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
	</div>
	
	
	<div id="enteerprisecontract" class="row"  >
	<div class="col s12 l6 m12">
	<fieldset>
<legend><b>Enterprise Details</b></legend>
	<div class="row">
	
	
	<form action="entsrch" method="Post">
  	<div class="input-field col s12 m6 l5" >
		  
  	<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
			  <label for="Enterprisesrchname" style="font-size:14px;" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-user"></i>&nbsp;&nbsp;Enterprise Name</label>
			  <span id="ent-name"></span>
	
	<datalist id="e_name_srch">
				 		</datalist>
			  </div>
			<div class=" input-field col s12 m12 l2">
					<input type="submit" class="srch btn" value="search" id="srchbtn"/><!-- <i class="fa fa-search">search</i></button> -->
	 			</div>
		 </form>
		<!-- 
			<div class=" input-field col s12 m12 l2">
			
					<button type="button" class="add btn"  id="addbtn"><i class="fa fa-plus">Add</i></button>
	 </div>	 -->
		
	</div>
	<br>
	
	<hr>
<br>
 <span >${Msg}</span>
<br>
<c:choose>
   
<c:when test="${enterpriseInfo.status==0}">
               	
<form action="enterprise" method="post">
<div class="row">

<div class="input-field col s12 m6 l5">
<input type="text" id="enter_name" name="enterpriseName" value="${enterpriseInfo.enterpriseName}"  class="validate"  required/>
		<label for="enter_name">&nbsp;&nbsp;<i class="fa fa-user"></i>&nbsp;&nbsp;Enterprise Name</label>
</div>
<div class="input-field col s12 m6 l5">
<input type="text" id="cont_per" name="contactPerson" class="validate" pattern="^[a-zA-Z-\s'.]{1,}$" value="${enterpriseInfo.contactPerson }"  required/>
		<label for="cont_per" data-error="Invalid Name">&nbsp;&nbsp;<i class="fa fa-user"></i>&nbsp;&nbsp;Contact Person</label>
</div>
</div>
<div class="row">
<div class="input-field col s12 m6 l5">
<input type="text" id="E_mobil" name="enterpriseMobile" class="validate" pattern="^[789]\d{9}$" maxlength="10" value="${enterpriseInfo.contactNumber}"  required/>
		<label for="E_mobil" data-error="invalid no">&nbsp;&nbsp;<i class="fa fa-phone"></i>&nbsp;&nbsp;MobileNo</label>
</div>
<div class="input-field col s12 m6 l5">
<input type="text" id="E_email" name="enterpriseEmail" class="validate" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})" value="${enterpriseInfo.email}"  required/>
		<label for="E_email" data-error="invalid email-id">&nbsp;&nbsp;<i class="fa fa-envelope"></i>&nbsp;&nbsp;Email-ID</label>
</div>
</div>
<div class="row">
<div class="input-field col s12 m6 l10">
<textarea type="text" id="E_addr" name="enterpriseAddress" class="materialize-textarea validate" required/>${enterpriseInfo.address} </textarea>
		<label for="E_addr" data-error="invalid name">&nbsp;&nbsp;<i class="fa fa-map-marker"></i>&nbsp;&nbsp;Address</label>
</div>

</div>
<input type="hidden" name="status" value="1"/>
<div class="row">
<div class="input-field col s12 m6 l2 push-l2">
<input type="submit" class="senter btn" value="Submit" ><!-- <i class="fa fa-sign-in">&nbsp;Submit</i></button> -->
</div>
</form>
<div class="input-field col s12 m6 l4 push-l1">
<button type="button" class="btn edit right" id="editbtn"><i class="fa fa-pencil"></i>&nbsp;&nbsp;Edit</button>
</div>



</c:when>
<c:when test="${enterpriseInfo.statusCode==204}">

NO Enterprise Found



</c:when>

<c:otherwise>
<form>
<table class="responsive-table">
<tr class="row">
<td class="data">
Enterprise Id
</td>
<td class="data">
GTRENT-${enterpriseInfo.enterpriseCustomerId}
</td>

<td class="data">
Enterprise Name
</td>
<td class="data">
${enterpriseInfo.enterpriseName}
</td>

</tr>
<tr class="row">
<td class="data">
Contact Person
</td>
<td class="data">
${enterpriseInfo.contactPerson}
</td>
<td class="data">
Mobile Number
</td>
<td class="data">
${enterpriseInfo.contactNumber}
</td>
</tr>

<tr class="row">
<td class="data">
Email id
</td>
<td class="data">
${enterpriseInfo.email}
</td>

<td class="data">
Address
</td>
<td class="data">
${enterpriseInfo.address}
</td>
</tr>

</table>
</form>
</c:otherwise>
</c:choose>
</fieldset>
</div>

<%-- 	<div class="col s12 l6 m12">
	
	 <ul class="collapsible" data-collapsible="accordion">
    <li>
      <div class="collapsible-header">Assign Spare Truck</div>
      <div class="collapsible-body">
      <fieldset>
<legend>Assign Trucks</legend>

<button type="button" class="btn addtruck" id="add_truck" ><i class="fa fa-plus"></i>Assign trucks</button>

<br>
 <span >${entrMsg}</span>
 <br>
<form action="asgTruck" method="post">
<div class="row">

<!--Vehicle type  -->
  <div class="input-field col s12 l6" >
    <select id="vehicleTypeId" name="vehicleType" class="browser-default">
      <option value="0" disabled selected>Vehicle Type</option>
      <option value="1">TATA ACE</option>
      <option value="6">TATA SUPER ACE</option>
      <option value="2">TATA 407</option>
    </select>
  </div>
    <!--Vehicle Reg no-->
    <div class="input-field col s12 l6" >
   <!--  <input type="text" name="vehicleRegNo" class="browser-default" placeholder="Vehicle Reg No"/> -->
   <select id="vehicle" name="vehicleRegNo" class="browser-default">
      <option value="" disabled selected>Truck Reg no</option>
     
    </select>
  </div>
  </div>
 

  <div class="row">
    <!-- Source loc -->
	<div class="input-field col s12 l6">
		 <input list="src"  name="source" id="srcLoc"  type="text" class="validate" required>
         <label for="srcLoc" data-error="" ><i class="fa fa-road"></i>&nbsp;&nbsp;Source</label><span id="src_frm" style="color:red;font-size:13px;"></span>
			<datalist id="src">
		   </datalist>
	</div>
	<!--Destination loc  -->	
		<div class="input-field col s12 l6">
		<input list="dest"  name="destination" id="destLocation" type="text" class="validate" required />
		<label for="destLocation" data-error="" ><i class="fa fa-road"></i>&nbsp;&nbsp;Destination</label><span id="dest_frm" style="color:red;font-size:13px;"></span>
		<datalist id="dest">
		</datalist>
	</div>
	</div>

	<div class="row">
	<!--No of Km/month  -->
	<div class="input-field col s12 l6">
		<input type="text" id="noOfKm" name="noOfKms" pattern="^[0-9]{1,}" class="validate" />
		<label for="noOfKm" data-erroe="invalid input"><i class="fa fa-road"></i>&nbsp;&nbsp;No of KM/Month</label>
	</div>
	<!--No of hours/Day  -->
	<div class="input-field col s12 l6">
		<input type="text" id="noOfHr" name="noOfhours"pattern="^[0-9]{1,}$" class="validate"/>
		<label for="noOfHr" data-error="invalid input"><i class="fa fa-clock-o"></i>&nbsp;&nbsp;No of Hours/Day</label>
	</div>
</div>
<div class="row">
<!--Praise per/km  -->
	<div class="input-field col s12 l6">
		<input type="text" id="pricePerKm" name="pricePerKm" pattern="^[0-9]{1,}$" class="validate"/>
		<label for="pricePerKm" data-error="invalid input"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per/Km</label>
	</div>
	
	<!--Praise per additional km  -->
	<div class="input-field col s12 l6">
		<input type="text" id="priceperadd" name="pricePerAdditionalKm" pattern="^[0-9]{1,}$" class="validate" />
		<label for="priceperadd" data-error="invalid input"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per Additional Km</label>
	</div>
</div>
<div class="row">
	<!-- Praise Per Additional Min/hr -->
	<div class="input-field col s12 l6">
		<input type="text" id="priceperaddmin" name="pricePerAdditionalMin" pattern="^[0-9]{1,}$" class="validate"/>
		<label for="priceperaddmin" data-error="invalid input"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per Additional Min/hr</label>
	</div>
	<!--Scheduled Time  -->	
	<div class="input-field col s12 m12 l6">
		<input type="text" name="scheduleTime"  id="scheduleTime"  class="datepicker validate" pattern="\d{2}:\d{2}"required>
			<label for="schedule_time" data-error="Invalid Date"><i class="fa fa-calendar"></i>&nbsp;&nbsp;Scheduled Time</label>
			
		</div>
</div>

<div class="row">
<!--Start date  -->
	<div class="input-field col s12 m12 l6">
			<input type="text" name="startDate"  id="sdate_only"  class="validate" pattern="(\d{4}-\d{2}-\d{2})" required>
			<label for="sdate_only" data-error="Invalid Date"><i class="fa fa-calendar"></i>&nbsp;&nbsp;Start Date</label>
	</div>
		
	<!--End date  -->
		<div class="input-field col s12 m12 l6 "> 
			<input type="text" name="endDate"  id="edate_only1"  class="validate" pattern="(\d{4}-\d{2}-\d{2})" required>
			<label for="edate_only1" data-error="Invalid Date"><i class="fa fa-calendar"></i>&nbsp;&nbsp;End Date</label>
		</div>
</div>
<div class="row">
<!-- Frequency of vehicle(Daily) -->
				<div class="input-field col s12 l6">
				<select id="freqVehicle" name="frequencyOfVehicle" class="browser-default">
				<option value="" disable selected>Frequency of Vehicle</option>
				<option value="Daily">Daily</option>
					<option value="Monthly">Monthly</option>
					<option value="Weekly">Weekly</option>
				</select>
	
   </div>
 <!--Submit form  -->
    <div class="input-field col s12 l2">
   <input type="submit" value="Submit" id="submit_addtruck" class="btn addtruck">
   </div>
</div>
</form>
		</fieldset>
      
      </div>
    </li>
 
   
  </ul>
        


	</div> --%>
	<div class="row">
	<div class="col s12 m12 l12">
	<fieldset>
	<legend>Existing Enterprise Details</legend>
	<a class="btn addtruck modal-trigger" href="#assigntrucks" id="add_truck"><i class="fa fa-plus"></i>Assign trucks</a>
	<br>
<!-- 	<button type="button" class="btn addtruck modal-trigger"  ><i class="fa fa-plus"></i>Assign trucks</button>
 -->	<br>
	<table  class="existing_enter">
	<tr>
	<th>Vehicle RegNo#</th>
	<th>Vehicle Type</th>
	<th>Source</th>
	<th>Destination</th>
	<th>Start Date</th>
	<th>End Date</th>
	<th>No Km/Month</th>
	<th>No Hours/Day</th>
	<th>Price Per Km</th>
	<th>Price Per Additional km</th>
	<th>Price Per Additional Min</th>
	<th class="edit">Edit</th>
	<th>Action</th>
	<th class="delete">Delete</th>
	
	</tr>
	<tr class="gtruck">
	<td>${enterpriseInfo.entDetails.vehicleRegNo}</td>
	<td>${enterpriseInfo.entDetails.vehicleName}</td>
	<td><textarea style="border:none;border-bottom:1px solid gray;">${enterpriseInfo.entDetails.source}</textarea></td>
	<td><textarea style="border:none;border-bottom:1px solid gray;">${enterpriseInfo.entDetails.destination}</textarea></td>
	<td><input type="text" value="${enterpriseInfo.entDetails.startDate}" readonly></td>
	<td><input type="text" value="${enterpriseInfo.entDetails.endDate}" readonly></td>
	<td><input type="text" value="${enterpriseInfo.entDetails.noOfKms}" readonly></td>
	<td><input type="text" value="${enterpriseInfo.entDetails.noOfhours}" readonly></td>
	<td><input type="text" value="${enterpriseInfo.entDetails.pricePerKm}" readonly></td>
	<td><input type="text" value="${enterpriseInfo.entDetails.pricePerAdditionalKm}" readonly></td>
	<td><input type="text" value="${enterpriseInfo.entDetails.pricePerAdditionalMin}" readonly></td>
	<td><button type="submit" class="btn  ent_save">Save</button></td>
		<td class="editbut"><button type="button" class="btn  ent_edit">Edit</button></td>
	<td class="deletebut"><button type="button" class="btn  ent_delete">Delete</button></td>
	</tr>
	</table>
	</fieldset>
	</div>
	
	</div>
	</div>
	



<div class="row daily_sche" style="display:none;">
	<div class="col s12 l12 m12">
	<fieldset>
  <legend class="input-field">
  </legend>
  <form>
  <br>
   
 
  <table class="responsive-table">

  <tr>
  
  <th>Enterprise Id</th>
  <th>Enterprise Name</th>
  <th>Truck Type</th>
  <th>Truck Reg No</th>
  <th>Driver Name</th>
  <th>Driver MobileNo</th>
  <th>Source</th>
  <th>Destination</th>
  <th>Start Date</th>
  <th>End Date</th>
  <th>Scheduled Time</th>
  <th>odometer</th>

  </tr>
  
  


   <c:forEach var="sc" items="${scheduleInfo}"> 
  <tr>
   <td>GTRENT-${sc.enterpriseId}</td>
   <td>${sc.enterpriseName }</td>
  
  <td>${sc.vehicleName}</td>
   <td>${sc.vehicleRegNo }</td>
   <td>${sc.driverName }</td>
   <td>${sc.driverMobile }</td>
   <td>${sc.source}</td>
   <td>${sc.destination}</td>
   <td>${sc.startDate}</td>
   <td>${sc.endDate}</td>
   <td>${sc.scheduleTime}</td>
      <td><a href="#odometer" class="modal-trigger">Odometer Details</a></td>
  </tr>
  </c:forEach>

  </table>


  <!--   <tr>
  <td>TATA ACE</td>
   <td>KA12343</td>
   <td>ajay</td>
   <td>8455444444</td>
   <td>BTM</td>
   <td>HAL</td>
   <td>9AM-9PM</td>
   <td><button type="submit" class="btn start"><i class="fa fa-truck">Start Trip</i></button></td>
  </tr>
    <tr>
  <td>TATA ACE</td>
   <td>KA12343</td>
   <td>ajay</td>
   <td>8455444444</td>
   <td>BTM</td>
   <td>HAL</td>
   <td>9AM-9PM</td>
   <td><button type="submit" class="btn start"><i class="fa fa-truck">Start Trip</i></button></td>
  </tr>
    <tr>
  <td>TATA ACE</td>
   <td>KA12343</td>
   <td>ajay</td>
   <td>8455444444</td>
   <td>BTM</td>
   <td>HAL</td>
   <td>9AM-9PM</td>
   <td><button type="submit" class="btn start"><i class="fa fa-truck">Start Trip</i></button></td>
  </tr> 
  </table>-->
  </form>
  </fieldset>
	</div>
	</div>
 
<div class="row" id="spare_truck" style="display:none;">
<div class="col s12 l4 m12">
<fieldset>
   	<legend><b>Spare Truck</b></legend>
   	 <div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="spare_enterprise_name" name="spareEnterpriseName"   required>
			  <label for="spare_enterprise_name"  >&nbsp;<i class="fa fa-user"></i>&nbsp;Enterprise Name</label>
			  </div>
   	<div class="input-field col s12 m6 l12" >  
   	<select name="" class="browser-default">
   		<option disabled selected>Truck Type</option>
   		<option value="">Truck Reg No</option>
   		<option value="">Tata Ace</option>
   		<option value="">Tata Super Ace</option>
   	</select>
	 </div>

	  	<div class="input-field col s12 m6 l12" >  
  <select name="" class="browser-default">
  <option selected disabled>Truck Reg No</option>
  <option value="">123555</option>
  <option value="">455545</option>
  </select>
		  </div>
	 	<div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="spare_noofkm" name="spareNoofKm" pattern="^[0-9]{1,}$"   required>
	  <label for="spare_noofkm"  >&nbsp;<i class="fa fa-road"></i>&nbsp;No of KM/Day</label>
		  </div>
		    	<div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="spare_noofhr" name="spareNoogHr" pattern="^[0-9]{1,}$" required>
	  <label for="spare_noofhr" >&nbsp;<i class="fa fa-road"></i>&nbsp;No of Hours/Day</label>
		  </div>
<div class="row">
	 	<div class="input-field col s12 m6 l6" >  
  	<input type="text" class="validate" id="sparetimestart" name="PostId"  pattern="\d{2}:\d{2}"  required>
	  <label for="sparetime" >&nbsp;<i class="fa fa-calender"></i>&nbsp;Time schedule(start)/vehicle</label>
		  </div>
		  <div class="input-field col s12 m6 l6" >  
  	<input type="text" class="validate" id="sparetimeend" name="PostId" pattern="\d{2}:\d{2}"  required>
	  <label for="sparetime" >&nbsp;<i class="fa fa-calender"></i>&nbsp;Time schedule(End)/vehicle</label>
		  </div>
</div>
	<br>
	<br><br>
	  </fieldset>
</div>

<div class="col s12 l4 m12">
   <fieldset>
   <legend><b>Assign Spare Truck</b></legend>
   <form action="confirm" method="post">

  <div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="assignTruckreg" name="assignTruckregno"   required>
	  <label for="assignTruckreg" >&nbsp;<i class="fa fa-truck"></i>&nbsp;Truck Reg No</label>
		  </div>
		    	<div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="assignToTruckreg" name="assigntotruckreg"   required>
	  <label for="assignToTruckreg">&nbsp;<i class="fa fa-truck"></i>&nbsp;Assign To Vehicle</label>
		  </div>
	<div class="input-field col s12 m6 l12" >  
  	<select name="" class="browser-default">
  	<option value="" disabled selected>Vehicle type</option>
  	<option value="">TATA ACE</option>
  	<option value="">Tata Super ace</option>
  	<option>Tata 407</option>
  	</select>
		  </div>
  
  	<div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="assignNoofdays" name="assignNoOfDays" pattern="^[0-9]{1,}"  required>
	  <label for="assignNoofdays" data-error="invalid input">&nbsp;<i class="fa fa-calendar"></i>&nbsp;No of days</label>
		  </div>
		    	<div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="assign_start_date" name="assignStartDate" pattern="(\d{4}-\d{2}-\d{2})"  required>
	  <label for="assign_start_date" data-error="invalid input">&nbsp;<i class="fa fa-calendar"></i>&nbsp;Start Date</label>
		  </div>
 
  
   <div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="assignEnddate" name="assignEndDate" pattern="(\d{4}-\d{2}-\d{2})"  required>
	  <label for="assignEnddate" >&nbsp;<i class="fa fa-calendar"></i>&nbsp;End Date</label>
		  </div>
		   <div class="input-field col s12 m6 l12" >  
					<button type="submit" class="add btn right"  id="addbtn"><i class="fa fa-truck">&nbsp;Assign Truck</i></button>
		  </div>
 </form>
  </fieldset>
</div>
<div class="col s12 l4 m12">
<fieldset>
   <legend><b>Reassign Spare truck</b></legend>
 <form action="" method="post">
   <div class="input-field col s12 m6 l12" >  
     	<input type="text" class="validate" id="reassigntruckreg"  name="reassignTruckReg"  required>
	  <label for="reassigntruckreg">&nbsp;<i class="fa fa-truck"></i>&nbsp;Vehicle Reg No</label>
	  </div>
	    <div class="input-field col s12 m6 l12" >  
     	<input type="text" class="validate" id="reassigntruckregTo"    required>
	  <label for="reassigntruckregTo">&nbsp;<i class="fa fa-truck"></i>&nbsp;Assign Vehicle Reg No</label>
	  </div>
	   <div class="input-field col s12 m6 l12" >  
<button type="submit" class="add btn right"  id="addbtn"><i class="fa fa-truck">&nbsp;ReAssign</i></button>
	  </div>
   </form>
   </fieldset>
</div>
</div>
<div class="row" id="statusoftruck" style="display:none;">
<div class="col s12 l6">
<div id="map" style="width:100%;height:500px;overflow:none;"></div>
</div>
<div class="col s12 l6 m12">
 <fieldset>
  <legend><b>Balance KM</b></legend>

  	<!--  -->

   	<div class="input-field col s12 m6 l12" >  
  	<input type="text" class="validate" id="mobno" name="PostId"   required>
			  <label for="mobno" >&nbsp;<i class="fa fa-road"></i>&nbsp;Enterprise Name</label>
			  </div>
			
			
			   <div class="input-field col s12 m6 l12">
			  <select name="bal_Enterprise_vehtype" class="browser-default">
			  <option value="" disabled selected>Vehicle type</option>
			  <option value="">Tata Ace</option>
			  <option value="">Tata Sperace</option>
			  <option value="">Tata 407</option>
			  </select>
			  </div>
			  
			<div class="input-field col s12 m6 l12" >  
  	        <select name="bal_Enterprise_vehreg" class="browser-default">
  	        <option value="" selected disabled>Vehicle RegNo</option>
  	        <option value="">KA1234</option>
  	        <option value="">KA1212</option>
  	        <option value="">KA8777</option>
  	        </select>
			  </div>
			  
			 
			  <div class="input-field col s12 m6 l12">
			  <select name="Enterprise_freq" class="browser-default">
			  <option value="" disabled selected>Frequency of vehicle</option>
			  <option value="">Daily</option>
			  <option value="">Monthly</option>
			  <option value="">Weekly</option>
			  
			  </select>
			  </div>
			
			 <div class="input-field col s12 m6 l12">
			 <input type="text" name="Balance_no_of_km" id="bal_no_of_KM">
			 <label for="bal_no_of_KM"><i class="fa fa-road">&nbsp;</i>No Of KM/Month</label>
			 </div>
			 
			 
			 <div class="input-field col s12 m6 l12">
			 <input type="text" name="Balance_travelled_km" id="bal_travelled_KM">
			 <label for="bal_travelled_KM"><i class="fa fa-road">&nbsp;</i>Travelled KM/Month</label>
			 </div>
			

			  <div class="input-field col s12 m6 l12">
			 <input type="text" name="Remaining_no_of_km" id="remaining_no_of_KM">
			 <label for="remaining_no_of_KM"><i class="fa fa-road">&nbsp;</i>Remaining KM/Month</label>
			 </div>
			
    </fieldset>
</div>
</div>

  <div class="row" id="enterprisepayment" style="display:none;">
  <div class="col s12 l6 m12">
  <fieldset>
  <legend>Payment Details</legend>
    <div class="input-field col s12 m6 l12" >  
     	<input type="text" class="validate" id="totalamount"  name="ent_totalamount"  required>
	  <label for="totalamount">&nbsp;<i class="fa fa-ruppe"></i>&nbsp;Total Amount</label>
	  </div>
	   <div class="input-field col s12 m6 l12" >  
     	<input type="text" class="validate" id="entamtrecived"  name="ent_amt_received"  required>
	  <label for="entamtrecived">&nbsp;<i class="fa fa-ruppe"></i>&nbsp;Amount received</label>
	  </div>
	   <div class="input-field col s12 m6 l12" >  
     	<input type="text" class="validate" id="entamtrecived"  name="ent_amt_received"  required>
	  <label for="entamtrecived">&nbsp;<i class="fa fa-ruppe"></i>&nbsp;Balance Amount</label>
	  </div>
	  <div class="input-field col s12 m6 l12" >  
     	<input type="text" class="validate" id="entpaymentdate"  name="ent_payment_date"  required>
	  <label for="entpaymentdate">&nbsp;<i class="fa fa-ruppe"></i>&nbsp;Payment Date</label>
	  </div>
  </fieldset>
  </div>    
      </div>
      <!-- Modal For assign trucks -->
      <div id="assigntrucks" class="modal col s12 l12 m5">
  <div class="modal-content ">
    <a href="#" class="fa fa-close modal-action modal-close right"  ></a>

<h5 class="center" style="color:#1253A4">Assign Trucks</h5>

 <span >${entrMsg}</span>

<form action="asgTruck" method="post">
<div class="row">

<!--Vehicle type  -->
  <div class="input-field col s12 l6" >
    <select id="vehicleTypeId" name="vehicleType" class="browser-default">
      <option value="0" disabled selected>Vehicle Type</option>
      <option value="1">TATA ACE</option>
      <option value="6">TATA SUPER ACE</option>
      <option value="2">TATA 407</option>
    </select>
  </div>
    <!--Vehicle Reg no-->
    <div class="input-field col s12 l6" >
   <!--  <input type="text" name="vehicleRegNo" class="browser-default" placeholder="Vehicle Reg No"/> -->
   <select id="vehicle" name="vehicleRegNo" class="browser-default">
      <option value="" disabled selected>Truck Reg no</option>
     
    </select>
  </div>
  </div>
 

  <div class="row">
    <!-- Source loc -->
	<div class="input-field col s12 l6">
		 <input list="src"  name="source" id="srcLoc"  type="text" class="validate" required>
         <label for="srcLoc" data-error="" ><i class="fa fa-road"></i>&nbsp;&nbsp;Source</label><span id="src_frm" style="color:red;font-size:13px;"></span>
			<datalist id="src">
		   </datalist>
	</div>
	<!--Destination loc  -->	
		<div class="input-field col s12 l6">
		<input list="dest"  name="destination" id="destLocation" type="text" class="validate" required />
		<label for="destLocation" data-error="" ><i class="fa fa-road"></i>&nbsp;&nbsp;Destination</label><span id="dest_frm" style="color:red;font-size:13px;"></span>
		<datalist id="dest">
		</datalist>
	</div>
	</div>

	<div class="row">
	<!--No of Km/month  -->
	<div class="input-field col s12 l6">
		<input type="text" id="noOfKm" name="noOfKms" pattern="^[0-9]{1,}" class="validate" />
		<label for="noOfKm" data-erroe="invalid input"><i class="fa fa-road"></i>&nbsp;&nbsp;No of KM/Month</label>
	</div>
	<!--No of hours/Day  -->
	<div class="input-field col s12 l6">
		<input type="text" id="noOfHr" name="noOfhours"pattern="^[0-9]{1,}$" class="validate"/>
		<label for="noOfHr" data-error="invalid input"><i class="fa fa-clock-o"></i>&nbsp;&nbsp;No of Hours/Day</label>
	</div>
</div>
<div class="row">
<!--Praise per/km  -->
	<div class="input-field col s12 l6">
		<input type="text" id="pricePerKm" name="pricePerKm" pattern="^[0-9]{1,}$" class="validate"/>
		<label for="pricePerKm" data-error="invalid input"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per/Km</label>
	</div>
	
	<!--Praise per additional km  -->
	<div class="input-field col s12 l6">
		<input type="text" id="priceperadd" name="pricePerAdditionalKm" pattern="^[0-9]{1,}$" class="validate" />
		<label for="priceperadd" data-error="invalid input"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per Additional Km</label>
	</div>
</div>
<div class="row">
	<!-- Praise Per Additional Min/hr -->
	<div class="input-field col s12 l6">
		<input type="text" id="priceperaddmin" name="pricePerAdditionalMin" pattern="^[0-9]{1,}$" class="validate"/>
		<label for="priceperaddmin" data-error="invalid input"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per Additional Min/hr</label>
	</div>
	<!--Scheduled Time  -->	
	<div class="input-field col s12 m12 l6">
		<input type="text" name="scheduleTime"  id="scheduleTime"  class="datepicker validate" pattern="\d{2}:\d{2}"required>
			<label for="schedule_time" data-error="Invalid Date"><i class="fa fa-calendar"></i>&nbsp;&nbsp;Scheduled Time</label>
			
		</div>
</div>

<div class="row">
<!--Start date  -->
	<div class="input-field col s12 m12 l6">
			<input type="text" name="startDate"  id="sdate_only"  class="validate" pattern="(\d{4}-\d{2}-\d{2})" required>
			<label for="sdate_only" data-error="Invalid Date"><i class="fa fa-calendar"></i>&nbsp;&nbsp;Start Date</label>
	</div>
		
	<!--End date  -->
		<div class="input-field col s12 m12 l6 "> 
			<input type="text" name="endDate"  id="edate_only1"  class="validate" pattern="(\d{4}-\d{2}-\d{2})" required>
			<label for="edate_only1" data-error="Invalid Date"><i class="fa fa-calendar"></i>&nbsp;&nbsp;End Date</label>
		</div>
</div>
<div class="row">
<!-- Frequency of vehicle(Daily) -->
				<div class="input-field col s12 l6">
				<select id="freqVehicle" name="frequencyOfVehicle" class="browser-default">
				<option value="" disable selected>Frequency of Vehicle</option>
				<option value="Daily">Daily</option>
					<option value="Monthly">Monthly</option>
					<option value="Weekly">Weekly</option>
				</select>
	
   </div>
 <!--Submit form  -->
    <div class="input-field col s12 l2">
   <input type="submit" value="Submit" id="submit_addtruck" class="btn addtruck">
   </div>
</div>
</form>
	
      

  </div>
</div>

     
 <div id="odometer" class="modal col s12 l12 m5">
  <div class="modal-content ">
    <a href="#" class="fa fa-close modal-action modal-close right"  ></a>
    <br>
    <div class="row">
<div class="col s12 m12 l6">
<fieldset>
<legend>Start odometer Reading</legend>
<a href="#image" class="modal-trigger">View Image</a>
<div class="input-field">
<input type="text" name="">
<label>Start Trip Reading</label>
</div>
<br>
<input type="submit" class="btn right" value="Submit">
</fieldset>
</div>

    <div class="col s12 l6 m12">
    <img src="img/speedo.jpg" width="100%" height="150">
    </div>
    </div>
    <hr>
    <div class="row">
  <div class="col s12 l6 m12">
<fieldset>
<legend>Stop odometer Reading</legend>
<a href="#image" class="modal-trigger">View Image</a>
<div class="input-field">
<input type="text" name="">
<label>Stop Trip Reading</label>
</div>
<br>
<input type="submit" class="btn right" value="Submit">
</fieldset>
</div>
 <div class="col s12 l6 m12">
    <img src="img/speedo.jpg" width="100%" height="150">
    </div>
  </div>
</div>
  </div>

</body>
<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript">
</script>
<script>
function myMap() {
  var myCenter = new google.maps.LatLng(51.508742,-0.120850);
  var mapCanvas = document.getElementById("map");
  var mapOptions = {center: myCenter, zoom: 5};
  var map = new google.maps.Map(mapCanvas, mapOptions);
  var marker = new google.maps.Marker({position:myCenter});
  marker.setMap(map);

  // Zoom to 9 when clicking on marker
  google.maps.event.addListener(marker,'click',function() {
    map.setZoom(9);
    map.setCenter(marker.getPosition());
  });
}
</script>
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
  var input = document.getElementById('srcLoc');
  var toarea =document.getElementById('destLocation');
  var autocomplete = new google.maps.places.Autocomplete(input, options);

  var autocomplete = new google.maps.places.Autocomplete(toarea, options);
  autocomplete.bindTo('bounds', map);
 }
google.maps.event.addDomListener(window, 'load', initialize);
</script>
<script>
$('.ent_edit').click(function(){
     $(this).closest('tr').find('input').removeAttr('readonly');
 });
 $('.ent_edit').click(function(){
	/*  $(".editbut,.deletebut,.edit,.delete").hide(); */
	 $(this).parents('td.editbut').first().remove(); 
	
 })
</script>
<script>/* To show tabs of enterprise */
$("document").ready(function(){
	$("#enterprisecont").click(function(){
		$("#statusoftruck,#spare_truck,#enterprisepayment,.daily_sche").hide();
		$("#enteerprisecontract").show();
		$(".e-daily,.e-spare,.e-status,.e-payment").css('background-color','#25A0B8');
		$(".e-cust").css('background-color','#3F51B5');
	});
	$("#dailyscheduling").click(function(){

		$("#enteerprisecontract,#statusoftruck,#spare_truck,#enterprisepayment").hide();
		$(".daily_sche").show();
		$(".e-daily").css('background-color','#3F51B5');
		$(".e-cust,.e-spare,.e-status,.e-payment").css('background-color','#25A0B8');
	});
	$("#sparetruck").click(function(){

		$("#enteerprisecontract,.daily_sche,#statusoftruck,#enterprisepayment").hide();
		$("#spare_truck").show();
		$(".e-spare").css('background-color','#3F51B5');
		$(".e-daily,.e-cust,.e-status,.e-payment").css('background-color','#25A0B8');
	});
	$("#status").click(function(){

		$("#enteerprisecontract,.daily_sche,#spare_truck,#enterprisepayment").hide();
		$("#statusoftruck").show();
	 $(".e-status").css('background-color','#3F51B5'); 
		$(".e-daily,.e-cust,.e-spare,.e-payment").css('background-color','#25A0B8');
	});
	
	$("#paymentdetails").click(function(){
		$("#enterprisepayment").show();
		$("#enteerprisecontract,.daily_sche,#spare_truck,#statusoftruck").hide();
			});
	/* To clear the value of fields */
	$("#add_truck").click(function(){
			$("#srcLoc,#destLocation,#noOfKm,#noOfHr,#pricePerKm,#priceperadd,#priceperaddmin,#schedule_time,#sdate_only,#edate_only1").val("");	
	});
	$("#editbtn").click(function(){
		$("#cont_per,#E_mobil,#E_addr,#E_email,#num_vehicle").removeAttr("readonly");
	});
	/* $("#add_truck").attr("disabled","disabled");
	if(src.length>0){
		alert("sdsdsd");
		$("#add_truck").removeAttr("disabled");
	} */
	
	
})
/* 	$("#submit_addtruck").click(function(){
		
		if(src.length>0){
			alert("sdsdsd");
			$("#add_truck").removeAttr("disabled");
		}
		
		
	}) */

	 $(document).ready(function(){
		    $('.collapsible').collapsible();
		  });
		        
$(document).ready(function(){
	// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
	$('.modal-trigger').leanModal({
    dismissible: false
});
});

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
$(function(){
    $('#schedule_time,#sparetimestart,#sparetimeend').appendDtpicker({
    "autodateOnStart":false,
  "closeOnSelected": true,
  
  "amPmInTimeList":false,
  "closeButton": true,
  "timeOnly":true,
 
    });
   });
initall();
if (typeof initalls == 'function') { 
	initalls(); 
	}


</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDr96kKx9kn-kt3urNoG43U6u4GViFQXhU&callback"></script>

</html>