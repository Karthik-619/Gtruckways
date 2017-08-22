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
<style>
.data
{
border:none;
}
.row
{
border:none;
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
		<div class="stepbox"><a href="#" id="enterprisecont"><div class="stepS e-cust"style="background-color:#3F51B5;"><i class="fa fa-user" style="color:white;font-size:20px;"></i></div><b>Enterprise Contract</b></a></div>
		<div class="stepbox"><a href="#" id="dailyscheduling"><div class="stepS e-daily"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Daily Scheduling</b></a></div>
		<div class="stepbox"><a href="#" id="sparetruck"><div class="stepS e-spare"><i class="fa fa-truck" style="color:white;font-size:20px;"></i></div><b>Spare Truck</b></a></div>
			<div class="stepbox"><a href="#" id="status"><div class="stepS e-status"><i class="fa fa-map-marker" style="color:white;font-size:20px;"></i></div><b>Status of Truck</b></a></div>
			<div class="stepbox"><a href="#" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
	</div>
	<div id="enteerprisecontract" class="row col s12 l12 m12"  >
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
		
			<div class=" input-field col s12 m12 l2">
			
					<button type="button" class="add btn"  id="addbtn"><i class="fa fa-plus">Add</i></button>
	 </div>	
		
	</div>
	<br>
	

	<hr>
	
<c:choose>
<c:when test="${enterpriseInfo.status==0}">	
<form action="enterprise" method="post">
<div class="row">

<div class="input-field col s12 m6 l5">
<input type="text" id="enter_name" name="enterprise_Name" value="${enterpriseInfo.enterpriseName}"  class="validate"  required/>
		<label for="enter_name">&nbsp;&nbsp;<i class="fa fa-user"></i>&nbsp;&nbsp;Name</label>
</div>
<div class="input-field col s12 m6 l5">
<input type="text" id="cont_per" name="contact_Person" class="validate" pattern="^[a-zA-Z-\s'.]{1,}$" value="${enterpriseInfo.contactPerson }"  required/>
		<label for="cont_per" data-error="Invalid Name">&nbsp;&nbsp;<i class="fa fa-user"></i>&nbsp;&nbsp;Contact Person</label>
</div>
</div>
<div class="row">
<div class="input-field col s12 m6 l5">
<input type="text" id="E_mobil" name="enterprise_no" class="validate" pattern="^[789]\d{9}$" maxlength="10" value="${enterpriseInfo.contactNumber}"  required/>
		<label for="E_mobil" data-error="invalid no">&nbsp;&nbsp;<i class="fa fa-phone"></i>&nbsp;&nbsp;MobileNo</label>
</div>
<div class="input-field col s12 m6 l5">
<input type="text" id="E_email" name="enterprise_mail" class="validate" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})" value="${enterpriseInfo.email}"  required/>
		<label for="E_email" data-error="invalid email-id">&nbsp;&nbsp;<i class="fa fa-envelope"></i>&nbsp;&nbsp;Email-ID</label>
</div>
</div>
<div class="row">
<div class="input-field col s12 m6 l10">
<textarea type="text" id="E_addr" name="enterprise_addr" class="materialize-textarea validate" value="${enterpriseInfo.address}"   required/></textarea>
		<label for="E_addr" data-error="invalid name">&nbsp;&nbsp;<i class="fa fa-map-marker"></i>&nbsp;&nbsp;Address</label>
</div>

</div>

<div class="row">
<div class="input-field col s12 m6 l4">
<button type="button" class="btn edit right" id="editbtn"><i class="fa fa-pencil"></i>&nbsp;&nbsp;Edit</button>
</div>
<div class="input-field col s12 m6 l2">

<button type="submit" class="senter btn" ><i class="fa fa-sign-in">&nbsp;Submit</i></button>
</div>
</div>
</form>

</c:when>
<c:otherwise>

<form>
<table class="responsive-table">
<tr class="row">
<td class="data">
Enterprise Id
</td>
<td class="data">
5000
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
	<div class="col s12 l6 m12">
	<fieldset>
<legend>Assign Trucks</legend>
<form action="" method="post">
<button type="button" class="btn addtruck" id="add_truck" ><i class="fa fa-plus"></i>Assign trucks</button>
<div class="row">

<!--Vehicle type  -->
  <div class="input-field col s12 l6" >
    <select id="vehicleTypeId" name="truckType" class="browser-default">
      <option value="" disabled selected>Vehicle Type</option>
      <option value="2">Tata ace</option>
      <option value="2">Tata super ace</option>
      <option value="2">Tata 407 </option>
    </select>
  </div>
    <!--Vehicle Reg no-->
    <div class="input-field col s12 l6" >
    <select id="vehicle" name="truckRegNo" class="browser-default">
      <option value="" disabled selected>Truck Reg no</option>
    <!--   <option value="">ka2133</option>
      <option value="">ka6788</option>
      <option value="">ka2332 </option> -->
    </select>
  </div>
  </div>
 

  <div class="row">
    <!-- Source loc -->
	<div class="input-field col s12 l6">
		 <input list="src"  name="sourceLoc" id="srcLoc"  type="text" class="validate" required>
         <label for="srcLoc" data-error="" ><i class="fa fa-road"></i>&nbsp;&nbsp;Source</label><p id="src_frm" style="color:red;font-size:13px;"></p>
			<datalist id="src">
		   </datalist>
	</div>
	<!--Destination loc  -->	
		<div class="input-field col s12 l6">
		<input list="dest"  name="destLoc" id="destLocation" type="text" class="validate" required />
		<label for="destLocation" data-error="" ><i class="fa fa-road"></i>&nbsp;&nbsp;Destination</label><p id="dest_frm" style="color:red;font-size:13px;"></p>
		<datalist id="dest">
		</datalist>
	</div>
	</div>

	<div class="row">
	<!--No of Km/month  -->
	<div class="input-field col s12 l6">
		<input type="text" id="noOfKm" name="noOfKm-month" pattern="^[0-9]{1,}" class="validate" />
		<label for="noOfKm" data-erroe="invalid input"><i class="fa fa-road"></i>&nbsp;&nbsp;No of KM/Month</label>
	</div>
	<!--No of hours/Day  -->
	<div class="input-field col s12 l6">
		<input type="text" id="noOfHr" name="noHours"pattern="^[0-9]{1,}$" class="validate"/>
		<label for="noOfHr" data-error="invalid input"><i class="fa fa-clock-o"></i>&nbsp;&nbsp;No of Hours/Day</label>
	</div>
</div>
<div class="row">
<!--Praise per/km  -->
	<div class="input-field col s12 l6">
		<input type="text" id="pricePerKm" name="pricePer-Km" pattern="^[0-9]{1,}$" class="validate"/>
		<label for="pricePerKm" data-error="invalid input"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per/Km</label>
	</div>
	
	<!--Praise per additional km  -->
	<div class="input-field col s12 l6">
		<input type="text" id="priceperadd" name="PriceperAdd-km" pattern="^[0-9]{1,}$" class="validate" />
		<label for="priceperadd" data-error="invalid input"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per Additional Km</label>
	</div>
</div>
<div class="row">
	<!-- Praise Per Additional Min/hr -->
	<div class="input-field col s12 l6">
		<input type="text" id="priceperaddmin" name="pricePerAddMin" pattern="^[0-9]{1,}$" class="validate"/>
		<label for="priceperaddmin" data-error="invalid input"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per Additional Min/hr</label>
	</div>
	<!--Scheduled Time  -->	
	<div class="input-field col s12 m12 l6">
		<input type="text" name="startDate"  id="schedule_time"  class="datepicker validate" pattern="\d{2}:\d{2}"required>
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
				<select id="freqVehicle" class="browser-default">
				<option value="" disable selected>Frequency of Vehicle</option>
				<option>Daily</option>
					<option>Monthly</option>
					<option>Weekly</option>
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
	
	</div>
	<div class="row daily_sche" style="display:none;">
	<div class="col s12 l12 m12">
	<fieldset>
  <legend class="input-field"><input type="text" >
  <label><b>Enterprise Name</b></label>
  </legend>
  <form>
  <br>
  <table class="responsive-table">
  <tr>
  <th>Truck Type</th>
  <th>Truck Reg No</th>
  <th>Driver Name</th>
  <th>Driver MobileNo</th>
  <th>Source</th>
  <th>Destination</th>
  <th>Scheduled Time</th>
  <th>Trip start</th>
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
  </table>
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
	<select class="browser-default" name="trucktype" id="enterprisetrucktype" required="required" >
         								<option value="" disabled>select one</option>
         							</select>
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
     
 

</body>
<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript">
</script><!-- <script type="text/javascript">// <![CDATA[
     var src=12.9706095;
     var dest=77.5152328;
     var src1=12.9613591;
     var dest1=77.5329978;
     var src2=12.9779977;
     var dest2=77.5701634;
    
     
var markers = [{"lat":src,"lng":dest,"icon":" goldStar",},
               {"lat":src1,"lng":dest1},
               {"lat":src2,"lng":dest2}];
window.onload = function () {
var mapOptions = {
center: new google.maps.LatLng(markers[0].lat, markers[0].lng),

zoom: 10,
mapTypeId: google.maps.MapTypeId.ROADMAP
};
var map = new google.maps.Map(document.getElementById("dvMap"), mapOptions);
var infoWindow = new google.maps.InfoWindow();
var lat_lng = new Array();
var latlngbounds = new google.maps.LatLngBounds();
for (i = 0; i < markers.length; i++) {
var data = markers[i]
var myLatlng = new google.maps.LatLng(data.lat, data.lng);
lat_lng.push(myLatlng);
var marker = new google.maps.Marker({
position: myLatlng,
map: map,
type:'info',
title: data.title
});
latlngbounds.extend(marker.position);
/* (function (marker, data) {
google.maps.event.addListener(marker, "click", function (e) {
infoWindow.setContent(data.description);
infoWindow.open(map, marker);
});
})(marker, data); */
}
map.setCenter(latlngbounds.getCenter());
map.fitBounds(latlngbounds);

}</script> -->
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
   
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDr96kKx9kn-kt3urNoG43U6u4GViFQXhU&callback=myMap"></script>

</html>