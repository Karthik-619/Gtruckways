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
.data
{
border:none;
}
.row
{
border:none;
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
		<div class="stepbox"><a href="entAcc" id="enterprisecont"><div class="stepS e-cust"style="background-color:#3F51B5;"><i class="fa fa-user" style="color:white;font-size:20px;"></i></div><b>Enterprise Contract</b></a></div>
		<div class="stepbox"><a href="eschedule" id="dailyscheduling"><div class="stepS e-daily"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Daily Scheduling</b></a></div>
		<div class="stepbox"><a href="espare" id="sparetruck"><div class="stepS e-spare"><i class="fa fa-truck" style="color:white;font-size:20px;"></i></div><b>Spare Truck</b></a></div>
			<div class="stepbox"><a href="estatus" id="status"><div class="stepS e-status"><i class="fa fa-map-marker" style="color:white;font-size:20px;"></i></div><b>Status of Truck</b></a></div>
	<div class="stepbox"><a href="eodo" id="enterprisecont"><div class="stepS e-cust"><i class="fa fa-tachometer" style="color:white;font-size:20px;"></i></div><b>Enterprise Odometer</b></a></div>
			<div class="stepbox"><a href="epay" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
			<div class="stepbox"><a href="entbill" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Billng Details</b></a></div>
			<div class="stepbox"><a href="epaydash" id="paymentdashbord"><div class="stepS e-paymentdash"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Dashboard</b></a></div>
	</div>
	 <span >${Msg}</span>
		<div id="enteerprisecontract" class="row"  >
	<div class="col s12 l6 m12 ">
	<fieldset>
<legend><b>Enterprise Details</b></legend>
	<div class="row">
	
	<form action="entsrch" method="Post">
  	<div class="input-field col s12 m6 l5" >
		  
  	<select class="browser-default" name="enterpriseName" required>
   	    <option value="" disabled selected>Select EnterpriseName</option>
   	  <c:forEach var="item" items="${EnterPriseNameList}">
     <option>${item.enterpriseName}</option>
   	 </c:forEach>
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
</fieldset>
 <fieldset>

<c:choose>
<c:when test="${enterpriseInfo.status==0}">
             	
<form action="enterprise" method="post">
<div class="row">

<div class="input-field col s12 m6 l5">
<input type="text" id="enter_name" name="enterpriseName" value="${enterpriseInfo.enterpriseName}"  style=""class="validate"  required readonly/>
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
<textarea type="text" id="E_addr" name="enterpriseAddress" class="materialize-textarea validate" required>${enterpriseInfo.address} </textarea>
		<label for="E_addr" data-error="invalid name">&nbsp;&nbsp;<i class="fa fa-map-marker"></i>&nbsp;&nbsp;Address</label>
</div>

</div>
<input type="hidden" name="status" value="1"/>
<div class="row">
<div class="input-field col s12 m6 l2 push-l2">
<input type="submit" class="senter btn" value="Submit" ><!-- <i class="fa fa-sign-in">&nbsp;Submit</i></button> -->
</div>
</div>
</form>
<!-- <div class="input-field col s12 m6 l4 push-l1">
<button type="button" class="btn edit right" id="editbtn"><i class="fa fa-pencil"></i>&nbsp;&nbsp;Edit</button>
</div> -->



</c:when>
<c:when test="${ not empty enterpriseInfo && enterpriseInfo.enterpriseCustomerId!=0}">
<form>
<table class="responsive-table">
<tr >
<th class="daily1">
Enterprise Id
</th>
<td class="daily">
GTRENT-${enterpriseInfo.enterpriseCustomerId}
</td>

<th class="daily1">
Enterprise Name
</th>
<td class="daily">
${enterpriseInfo.enterpriseName}
</td>

</tr>
<tr>
<th class="daily1">
Contact Person
</th>
<td class="daily">
${enterpriseInfo.contactPerson}
</td>
<th class="daily1">
Mobile Number
</th>
<td class="daily">
${enterpriseInfo.contactNumber}
</td>
</tr>

<tr>
<th class="daily1">
Email id
</th>
<td class="daily">
${enterpriseInfo.email}
</td>

<th class="daily1">
Address
</th>
<td class="daily">
<textarea style="border:none;" readonly>${enterpriseInfo.address}</textarea>
</td>
</tr>

</table>
</form>
</c:when>

<c:otherwise>

Select Enterprise

</c:otherwise>

</c:choose>

</fieldset>

</div>
<c:choose>
<c:when test="${not empty enterpriseInfo && enterpriseInfo.enterpriseCustomerId!=0}">
	<div class="col s12 l6 m12">
	 <span style="margin-left:3rem;">${entrMsg}</span>
	 <ul class="collapsible" data-collapsible="accordion">
    <li>
      <div class="collapsible-header"><span style="font-size:17px;"><b>Assign Truck</b></span><i class="fa fa-caret-down right"></i></div>
      <div class="collapsible-body">



<!-- <button type="button" class="btn addtruck" id="add_truck" ><i class="fa fa-plus"></i>Assign trucks</button>
 -->



<form action="asgTruck" method="post">
<div class="row">

<!--Vehicle type  -->
  <div class="input-field col s12 l6" >
    <select id="vehicleTypeId" name="vehicleType" class="browser-default" required>
      <option value="" disabled selected>Vehicle Type</option>
      <option value="1">TATA ACE</option>
      <option value="6">TATA SUPER ACE</option>
      <option value="2">TATA 407</option>
    </select>
  </div>
    <!--Vehicle Reg no  through ajax call-->
    <div class="input-field col s12 l6" >
   <select id="vehicle" name="vehicleRegNo" class="browser-default" required>
      <option value="" disabled selected>Truck Reg no</option>
     
    </select>
  </div>
  </div>
 

  <div class="row">
    <!-- Source loc -->
	<div class="input-field col s12 l6">
		 <input list="src"  name="source" id="srcLoc" placeholder=" " type="text" class="validate" required>
         <label for="srcLoc" data-error="" >&nbsp;&nbsp;<i class="fa fa-road"></i>&nbsp;&nbsp;Source</label><span id="src_frm" style="color:red;font-size:13px;"></span>
			<datalist id="src">
		   </datalist>
	</div>
	<!--Destination loc  -->	
		<div class="input-field col s12 l6">
		<input list="dest"  name="destination" id="destLocation" placeholder=" "  type="text" class="validate" required />
		<label for="destLocation" data-error="" >&nbsp;&nbsp;<i class="fa fa-road"></i>&nbsp;&nbsp;Destination</label><span id="dest_frm" style="color:red;font-size:13px;"></span>
		<datalist id="dest">
		</datalist>
	</div>
	</div>

	<div class="row">
	<!--No of Km/month  -->
	<div class="input-field col s12 l6">
		<input type="text" id="noOfKm" name="noOfKms" pattern="^[0-9]{1,4}" class="validate" required/>
		<label for="noOfKm" data-erroe="invalid input">&nbsp;&nbsp;<i class="fa fa-road"></i>&nbsp;&nbsp;No of KM/Month</label>
	</div>
	<!--No of hours/Day  -->
	
	<div class="input-field col s12 l6">
		<input type="text" id="noOfDays" name="noOfDays"pattern="^[0-9]{1,3}$" class="validate" required/>
		<label for="noOfDays" data-error="invalid input">&nbsp;&nbsp;<i class="fa fa-clock-o"></i>&nbsp;&nbsp;No of Days Required</label>
	</div>
	
	
	
</div>
<div class="row">
<!--Praise per/km  -->
	<div class="input-field col s12 l6">
		<input type="text" id="pricePerKm" name="quoteAmount" pattern="^[0-9]{1,8}$" class="validate" required/>
		<label for="quoteAmount" data-error="invalid input">&nbsp;&nbsp;<i class="fa fa-rupee"></i>&nbsp;&nbsp;Quote Amount</label>
	</div>
	
	
	<div class="input-field col s12 l6">
		<input type="text" id="noOfHr" name="noOfhours"pattern="^[0-9]{1,2}$" class="validate" required/>
		<label for="noOfHr" data-error="invalid input">&nbsp;&nbsp;<i class="fa fa-clock-o"></i>&nbsp;&nbsp;No of Hours/Day</label>
	</div>
	
	

</div>
<div class="row">

	<!--Praise per additional km  -->
	<div class="input-field col s12 l6">
		<input type="text" id="priceperadd" name="pricePerAdditionalKm" pattern="^[0-9]{1,3}$" class="validate" required/>
		<label for="priceperadd" data-error="invalid input">&nbsp;&nbsp;<i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per Additional Km</label>
	</div>


	<!-- Praise Per Additional Min/hr -->
	<div class="input-field col s12 l6">
		<input type="text" id="priceperaddmin" name="pricePerAdditionalMin" pattern="^[0-9]{1,2}$" class="validate" required/>
		<label for="priceperaddmin" data-error="invalid input">&nbsp;&nbsp;<i class="fa fa-rupee"></i>&nbsp;&nbsp;Price Per Additional Min</label>
	</div>
	
</div>

<div class="row">
<!--Start date  -->
	<div class="input-field col s12 m12 l6">
			<input type="text" name="startDate"  id="sdate_only"  class="validate" pattern="(\d{4}-\d{2}-\d{2})" required>
			<label for="sdate_only" data-error="Invalid Date">&nbsp;&nbsp;<i class="fa fa-calendar"></i>&nbsp;&nbsp;Start Date</label>
	</div>
		
	<!--End date  -->
		<div class="input-field col s12 m12 l6 "> 
			<input type="text" name="endDate"  id="edate_only1"  class="validate" pattern="(\d{4}-\d{2}-\d{2})" required>
			<label for="edate_only1" data-error="Invalid Date">&nbsp;&nbsp;<i class="fa fa-calendar"></i>&nbsp;&nbsp;End Date</label>
		</div>
</div>
<div class="row">

<!--Scheduled Time  -->	
	<div class="input-field col s12 m12 l6">
		<input type="text" name="scheduleTime"  id=""  class="datepicker validate" pattern="^(?:([01]?\d|2[0-3]):([0-5]?\d))$" required>
			<label for="schedule_time" data-error="ex:hh:mm">&nbsp;&nbsp;<i class="fa fa-calendar"></i>&nbsp;&nbsp;Scheduled Time</label>
			
		</div>
 
 <!--Submit form  -->
    <div class="input-field col s12 l2">
   <input type="submit" value="Submit" id="submit_addtruck" class="btn addtruck">
   </div>
</div>
</form>

      
      </div>
    </li>
 
   
  </ul>
        


	</div>

	<div class="row">
	<div class="col s12 m12 l12">
	<fieldset>
	<legend>Existing Enterprise Details</legend>
<!-- 	<a href="#assigntruck" class="btn addtruck modal-trigger"><i class="fa fa-plus"></i>Assign trucks</a>
 -->	
	
	<table class="existing_enter">
	<tr>
	<th>Vehicle RegNo#</th>
	<th>Vehicle Type</th>
	<th>Source</th>
	<th>Destination</th>
	<th>No Km/Month</th>
	<th>No of Days Required</th>
	<th>Quote Amount</th>
	<th>No Hours/Day</th>	
	<th>Price Per Additional km</th>
	<th>Price Per Additional Min</th>
	<th class="edit">Edit</th>
	<th  id="action">Action</th>
<!-- 	<th class="delete">Delete</th>
 -->	
	</tr>
	<c:forEach var="vehi" items="${enterpriseInfo.entVehicleDetails}">  
	<form action="chngEntDet" method="post">
	<tr class="gtruck">
	<td>${vehi.vehicleRegNo} <input type="hidden" value="${vehi.vehicleRegNo}" name="vehicleRegNo"></td>
	<td>${vehi.vehicleName}</td>
	<td><textarea name="source"  id="srcLoc1" style="border:none;border-bottom:1px solid gray;margin-bottom:15px;"  disabled>${vehi.source}</textarea></td>
	<td><textarea name="destination" id="destLocation1" style="border:none;border-bottom:1px solid gray;margin-bottom:15px;"  disabled>${vehi.destination}</textarea></td>
	<td><input type="text" name="noOfKms"   pattern="^[0-9]{1,4}" class="validate" value="${vehi.noOfKms}" disabled></td>
	<td><input type="text" name="noOfDays"    pattern="^[0-9]{1,3}" class="validate" value="${vehi.noOfDays}" disabled></td>
	<td><input type="text" name="quoteAmount"  pattern="^[0-9]{1,8}" class="validate" value="${vehi.quoteAmount}" readonly></td>
	<td><input type="text" name="noOfhours" class="validate" pattern="^[0-9]{1,2}$" value="${vehi.noOfhours}" readonly></td>
	<td><input type="text" name="pricePerAdditionalKm" class="validate" pattern="^[0-9]{1,3}$"  value="${vehi.pricePerAdditionalKm}" readonly></td>
	<td><input type="text" name="pricePerAdditionalMin" class="validate" pattern="^[0-9]{1,2}$" value="${vehi.pricePerAdditionalMin}" readonly></td>
	
	<td class="editbut"><button type="button" class="btn  ent_edit">Edit</button></td>
	<td class="save"><input type="submit" class="btn  ent_save" value="Save" disabled></td> 
	
	</tr>
	</form>
	<%--  <td class="deletebut">
	<a href="#conf_delet" class="btn  ent_delete modal-trigger">Delete</a>
	</td>
	
	
	
	   	 <div id="conf_delet" class="modal" style="width:30%;">
						  <div class="modal-content">
						 <a href="#" class="fa fa-close modal-action modal-close right"  id="closebtn"></a>
	<form action="rmVehi" method="POST">        
        <div class="showyesno">
        <h6 class="center">Are you sure, you want to Delete</h6>
        <br>
    	<input type="hidden" value="${vehi.vehicleRegNo}" name="vehicleRegNo">
       <input type="submit" id="yes" class=" fa fa-check btn" value="Yes" style="margin-left:20%;background-color: #4caf50;height:25px;">
        <button type="button" id="no" style="margin-left:10%;height:25px;background-color: rgba(244, 67, 54, 0.65);" class="btn fa fa-close modal-action modal-close" >&nbsp;No</button>
   
                
        </div> 
        </div>
     </div>    
            
  </form>  --%>
 
	
	</c:forEach>
	</table>
		
	</fieldset>
	</div>
	
	</div>

</c:when>

</c:choose>


	</div>
	
 
	<script type="text/javascript" src="js/enterprise.js" ></script> 
<script type="text/javascript" src="js/createReqObj.js" ></script>
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
  //autocomplete.bindTo('bounds', map);
 }
google.maps.event.addDomListener(window, 'load', initialize);
</script>

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=true&libraries=places&key=AIzaSyDr96kKx9kn-kt3urNoG43U6u4GViFQXhU"></script>
<script type="text/javascript">
$('.ent_edit').click(function(){
	 $(this).closest('tr').find('input,textarea').removeAttr('disabled');
	    $(this).closest('tr').find('textarea,input').removeAttr('readonly');
    $(this).first().remove();
    $(this).parent('td.save').last().show();

    //$('.existing_enter tr:eq(1) td:eq(12)').show();
    //$(this).parents('td.save').last().show();
    //$('td:last').show();
});

/* $('.ent_edit').click(function(){
	$("#action,#save").show();
	$(".edit,.editbut").hide();
	 $(this).parents('td.editbut').first().remove();
		
}); */

$(document).ready(function(){
	// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
	$('.modal-trigger').leanModal({
    dismissible: false,
});
});

initall();
if (typeof initalls == 'function') { 
	initalls(); 
	}

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
    $('#scheduleTime').appendDtpicker({
    "autodateOnStart":false,
  "closeOnSelected": true,
  "futureOnly": true,
  "amPmInTimeList":false,
  "closeButton": true,
  "timeOnly":true,

    });
   });

</script>


</body>
</html>