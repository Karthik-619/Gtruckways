<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>gTruckWays</title>
 <meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/tele.css" />

	<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />	
	  <script type="text/javascript" src="js/materialize.min.js"></script>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script type="text/javascript" src="js/jquery-dtpicker.js"></script>   
	<script type="text/javascript" src="js/createReqObj.js" ></script>
<script type="text/javascript" src="js/register.js" ></script>
		<style>
	.logo{
	margin-top:1rem ;
}
		nav
{
background-color:#0288d1;
}
th.head {
  
    text-align:left;
    padding: 0px;
    background:#75caeb;
     
    color:white;
}
td.data
{
 border: none; 
    text-align:center;
    padding:0px;
    padding-top: 1%x;
    padding-right: 0px;
    padding-bottom: 0px;
    padding-left: 0px;
    display: table-cell;
    text-align: left;
    vertical-align: middle;
   
}	
th.daily{
	padding:0px;
	background-color:rgb(117, 202, 235);
	text-align:center;
	font-size:12px;
  padding-right: 1em;
      border: 1px solid #FFF;
}
td.daily{
	padding:3px;
	font-size:12px;
}
/* tr.row1:nth-child(odd) {
    background-color: #dddddd;
      text-align:center;
}
tr.row1:nth-child(even) {
    background-color: white;
      text-align:center;
} */
.modal {
    display: none;
    position: fixed;
    left: 0;
    right: 0;
    background-color: #fafafa;
    padding: 0;
    max-height: 70%;
    width: 45%;
    margin: auto;
    overflow-y: auto;
    border-radius: 2px;
    will-change: top, opacity;
}



td {
  
    padding-top: 1%x;
    padding-right: 0px;
    padding-bottom: 0px;
  
    display: table-cell;
    text-align: left;
    vertical-align: middle;
    border-radius: 2px;
}
input:not([type]), input[type=text], input[type=password], input[type=email], input[type=url], input[type=time], input[type=date], input[type=datetime-local], input[type=tel], input[type=number], input[type=search], textarea.materialize-textarea {
    background-color: white;
    border-bottom: 1px solid black;
    border-radius: 0;
    outline: none;
    height: 2rem;
    width: 100%;
    font-size: 1rem;
    margin: 0 0 0px 0;
    padding: 0;
    box-shadow: none;
    box-sizing: content-box;
    transition: all .3s;
}
th.Dtd{
padding:5px;
font-size:14px;	
}
td.Dtd{
padding:5px;
font-size:13px;
}
button.btn.srch,.btn.frmdate {
	background-color:#0288d1;
    margin-top: 11px;
color:white;
font-size:1px;
height:20px;
line-height:20px;			
}

th.Dtd1{
padding:0px;
backgroud-color:#75caeb;
font-size:14px;
}
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
<body>
<div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      	<img src="img/gtlogo.jpg" height="60%" width="10%"  alt="logo" style="margin-top:15px;" /><span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;"><img src="img/customer-service.png" > Customer Care</span>
      
      <ul class="right hide-on-med-and-down ">
 <li><a href="bookHome">Go Back</a></li>
       
      </ul>
   
    </div>
  </nav>
  </div> <!--./ Local Header -->
<div class="row" id="driverdetails">

    <div class="row">
    <div class="col s12 m12 l4">
       	
       	 <form action="driverDetails" method="Post">
       	<div class="input-field col s12 m6 l5" >
		  
  	<input type="text" class="validate space" id="" name="regNo"   required>
			  <label for="" style="font-size:13px;" >&nbsp;<i class="fa fa-truck"></i>&nbsp;&nbsp;Vehicle RegNo</label>
			  </div>
			  
			 
			<div class=" input-field col s12 m12 l2">
					<button type="submit" class="srch btn frmdate"  id=""><i class="fa fa-search" style="font-size:13px;">search</i></button>
	 </div>
	 
	
	 </form>
	 <br> <br> 
	 
	  <p>${msg}</p>
	 <br>
  
   <c:choose>
<c:when test="${not empty driverDetails}">
    <fieldset>
    <legend style="color:#1253A4;"><b>Driver Details</b></legend>
<table class="bordered">

<tr>
<th class="Dtd1">Driver Id</th>
<td class="Dtd"><i class="fa fa-credit-card" ></i>&nbsp;GTRDR-${driverDetails.driverId }</td>
</tr>
<tr>
<th class="Dtd1">Driver Name</th>
<td class="Dtd"><i class="fa fa-user"></i>&nbsp;${driverDetails.driverName }</td>
</tr>
<tr>
<th class="Dtd1">Driver Mobile No</th>
<td class="Dtd"><i class="fa fa-phone"></i>&nbsp;${driverDetails.mobileNo}</td>
</tr>
<tr>
<th class="Dtd1">Vehicle RegNo#</th>
<td class="Dtd"><i class="fa fa-truck"></i>&nbsp;${driverDetails.vehicleRegNo }</td>
</tr>
<tr>
<th class="Dtd1">Vehicle Type</th>
<td class="Dtd"><i class="fa fa-truck"></i>&nbsp;${driverDetails.vehicleType }</td>
</tr>
<tr>
<th class="Dtd1">Current Location</th>
<td class="Dtd"><textarea readonly>${driverDetails.currentLocationName}</textarea></td>
</tr>
<tr>
<th class="Dtd1">Last Updated Location Time</th>
<td class="Dtd">${driverDetails.locationTime}</td>
</tr>
<tr>
<th class="Dtd1">Assigned To</th>
<td class="Dtd"><i class="fa fa-user"></i>&nbsp;${driverDetails.driverType}</td>
</tr>

</table>

    </fieldset>
    
  <div class="row">
<fieldset>
<legend style="color:#1253A4;"><b>Status Update</b></legend>
<div class="" >
<c:choose>
<c:when test="${driverDetails.driverStatus.equals('ENGAGE')}">
<table class="bordered">
<tr>
<th class="Dtd1"><b>Current Status</b></th>
<td class="Dtd" style="color:green"><b>${driverDetails.driverStatus}</b></td>

</tr>
<tr>
<th class="Dtd1"><b >Engage Time</b></th>
<td class="Dtd">${driverDetails.driverStatusChangeTime}</td>

</tr>
</table>

<table>
<tr>
<th>Pickup Location</th>
<td>${driverDetails.fromCity}</td>
<th>Drop Location</th>
<td>${driverDetails.toCity}</td>
</tr>
</table>
</c:when>
<c:otherwise>
<table>
<tr>
<td class="Dtd"><b>Current Status</b></td>
<td class="Dtd"><b>Status change time</b></td>
<td class="Dtd"><b>Change Status</b></td>
</tr>
<tr>
<td class="Dtd">${driverDetails.driverStatus}</td>
<td class="Dtd">${driverDetails.driverStatusChangeTime}</td>
<td class="Dtd"><a href="#changestatus" class="btn change modal-trigger">Change</a></td>
</tr>
</table>
</c:otherwise>
</c:choose>
</div>
</fieldset>
</div>
    </div>


   <div class="col s12 m12 l8">
    <table height="45"></table>
      <span style="margin-left:20%;">${message}</span>
    <fieldset>
    <legend style="color:#1253A4;"><b>Past Trip Details</b></legend>
  <form action="DrivertripDetails" method="Post">
    <div class="row">
   <div class="input-field col s12 l2 m12">
    <input type="text" name="fromDate" id="dr_frmdate" required>
    <label>From Date</label>
    </div>
     <div class="input-field col s12 l2 m12"required>
    <input type="text" name="toDate"  id="dr_todate" ><span id="dr_toerr" style="color:red;font-size:13px;"></span>
    <label>To Date</label> 
    </div>
    <div class="input-field col s12 l3 m12 ">
    <input type="submit"  value="Search" style="font-size:13px;"class="btn frmdate">
</div>
</div>
</form>
<table>
<tr>
<th class="daily">Booking ID</th>
<th class="daily">Date & Time</th>
<th class="daily">From</th>
<th class="daily">To</th>
<th class="daily">Material Type</th>
</tr>
<c:forEach var="book" items="${BookDetails}">
<tr>
<td class="Dtd"><a href="trip?bookingId=${book.refPostId}"><u>${book.refPostId}</u></a></td>
<td class="Dtd">${book.travelDate}&nbsp;</td>
<td class="Dtd"><textarea>${book.fromCity}</textarea></td>
<td class="Dtd"><textarea>${book.toCity}</textarea></td>
<td class="Dtd">${book.material}</td>
</tr>
</c:forEach>
</table>

        </fieldset>
    </div>
   
 </c:when>
 </c:choose> 
     </div>

 <c:choose>
<c:when test="${not empty TripDetails.bookingId}">
     <hr>
<div class="row">
    <div class="row col s12 m12 l4">
    <fieldset>
    <legend style="color:#1253A4;"><b>Trip Details</b></legend>
    <table>
    <tr>
    <th class="Dtd">Booking ID</th>
    <td class="Dtd"><i class="fa fa-credit-card" ></i>&nbsp;${TripDetails.bookingId}</td>
    </tr>
    <tr>
    <th class="Dtd">Date&Time</th>
    <td class="Dtd"><i class="fa fa-calendar-o" ></i>&nbsp;${TripDetails.bookingDate}&nbsp;</td>
    </tr>
    <tr>
    <th class="Dtd">From</th>
     <td class="Dtd"><textarea readonly>${TripDetails.fromCity}</textarea></td>
    </tr>
    <tr>
    <th class="Dtd">To</th>
    <td class="Dtd"><textarea readonly>${TripDetails.toCity}</textarea></td>
    </tr>
    <tr>
    <th class="Dtd">Material Type</th>
        <td class="Dtd"><i class="fa fa-truck" ></i>&nbsp;${TripDetails.material}</td>
    </tr>
      <tr>
    <th class="Dtd">Total Distance</th>
        <td class="Dtd"><i class="fa fa-road" ></i>&nbsp;${TripDetails.totalDistance}</td>
    </tr>
    <tr>
     <th class="Dtd">Total Mins</th>
        <td class="Dtd"><i class="fa fa-clock-o"></i>&nbsp;${TripDetails.totalMins }</td>
    </tr>
       <tr>
     <th class="Dtd">Total Amt Received</th>
        <td class="Dtd"><i class="fa fa-rupee"></i>&nbsp;${TripDetails.totalAmount }</td>
    </tr>
    
    </table>
    </fieldset>

  
    </div>
  <div class="row col s12 l4 m12">
  <fieldset>
  <legend style="color:#1253A4;"><b>Incentives Details</b></legend>
   <!--  <a href="#changestatus" class="btn change right">ADD</a> -->
  <table class="bordered">
 
  <tr>
  <th class="daily">Reason</th>
  <th class="daily">DryRun</th>
    <th class="daily">Incentives Amt</th>
 
  </tr>

<c:forEach var="incent" items="${TripDetails.incentives}">
  <tr>
  <td class="Dtd">${incent.code}</td>
  <td class="Dtd">${TripDetails.dryRunKm}KM</td>
<td class="Dtd"><i class="fa fa-rupee"></i>&nbsp;${incent.incAmount}</td>
  </tr>
  </c:forEach>
   <tr>
     <td class="Dtd"></td>
    <th class="Dtd right">SUM:</th>
    <td class="Dtd"><i class="fa fa-rupee"></i>&nbsp;${TripDetails.sumIncentives}</td>
    </tr>
  </table>
  </fieldset>
   
        <fieldset>
  <legend style="color:#1253A4;"><b>Trip Earnings</b></legend>
  <table class="bordered">
  <tr>
  <th class="daily">Trip Fare</th>
  <th class="daily">Trip Earnings</th>
 <th class="daily">Driver Amount</th>
  </tr>
  <tr>
  <td class="Dtd"><i class="fa fa-rupee"></i>&nbsp;${TripDetails.totalAmount}</td>
  <td class="Dtd"><i class="fa fa-rupee"></i>&nbsp;${TripDetails.tripEarnings}</td>
<td class="Dtd"><i class="fa fa-rupee"></i>&nbsp;${TripDetails.driverAmount}</td>
  </tr>
  </table>
  
  
  </fieldset>
 
  </div>
  <div class="row col s12 l4 m12">
  <fieldset>
  <legend style="color:#1253A4;"><b>Deduction Details</b></legend>
 <%-- <c:when test="${TripDetails.tDate eq TripDetails.todayDate}"> --%>
  <a href="#deduction_det" class="btn change right modal-trigger">ADD</a>
  <%--  </c:when> - --%>
  <table class="bordered"> 
 
  <tr>
   <th class="daily">Deduction Reason</th>
  <th class="daily">Deduction Amt</th>
  
  </tr>
   
  <c:forEach var="ded" items="${TripDetails.deductions}">
  <tr>
  <td class="Dtd">${ded.reason}</td>
  <td class="Dtd"><i class="fa fa-rupee"></i>&nbsp;${ded.amount}</td>
 
  </tr>

</c:forEach>
   <tr>
    <th class="Dtd right">SUM:</th>
    <td class="Dtd"><i class="fa fa-rupee"></i>&nbsp;${TripDetails.sumDeductions}</td>
    </tr>
  </table>
  
  </fieldset>
  </div>
  </div>

   </c:when>
  </c:choose>
    </div>


<c:choose>
<c:when test="${not empty BookDetails}">
<hr>
<div class="row">
   <fieldset class="col s12 m12 l5">
  
 
  <legend style="color:#1253A4;"><b>Daywise Driver Details</b></legend>
   <c:choose>
  
   <c:when test="${dailyinfo.toDate eq '999'}">
   
    <span style="color:red;margin-left:10px;">Entered vehicle RegNo '&nbsp;${dailyinfo.regNo}&nbsp;' doesn't Exists With Us </span>
   </c:when>
  <c:when test="${not empty dailyinfo.dailytripinfo}">

	 <div class="row" style="margin-left:10px;">
    <span class="name"><b>From Date:</b>&nbsp;&nbsp;${dailyinfo.fromDate}</span>&nbsp;&nbsp;&nbsp;
  <span class="id"><b>To Date:</b>&nbsp;&nbsp;${dailyinfo.toDate}</span><br>
  </div>
	

 <table class="responsive-table striped">
     <tr>
      <th class="daily">SL No</th>
     <th class="daily">Date of travel</th>
     <th class="daily">No of KM</th>
     <th class="daily">No of Minutes</th>
     </tr>
     <c:set var="count" value="0" scope="page" />
    <c:forEach var="daily" items="${dailyinfo.dailytripinfo}">  
     <tr>
     <c:set var="count" value="${count + 1}" scope="page"/>
     <td class="daily">${count}</td>
     <td class="daily">${daily.tripDate}</td>
     <td class="daily">${daily.totalKm}&nbsp;Km</td>
     <td class="daily">${daily.totalMins}&nbsp;mins</td>
     </tr>
     </c:forEach>
     </table>
  </c:when>
  <c:otherwise>
  
 <span style="color:red;margin-left:10px;"> No Trip is found for the Vehicle '&nbsp;${dailyinfo.regNo}&nbsp;' between the Date '&nbsp;${dailyinfo.fromDate}&nbsp;' and '&nbsp;${dailyinfo.toDate}&nbsp;'  </span>
  </c:otherwise>
  
  </c:choose>
 
  </fieldset>
 
 
 
  </div>
  </c:when>
  </c:choose>
  
   <!-- Modal for changestatus -->
    	 <div id="changestatus" class="modal" style="width:30%;">
						  <div class="modal-content">
						 <a href="#" class="fa fa-close modal-action modal-close right"  id="closebtn"></a>
	<form action="ChangeStatus" method="GET">        
        <div class="showyesno" style="display:none;">
        <h6>Are you sure, you want to change the status</h6>
        <br>
       
       <button type="submit" id="yes" class=" fa fa-check btn" style="margin-left:20%;background-color: #4caf50;height:30px;">&nbsp;Yes</button>
        <button type="button" id="no" style="margin-left:10%;height:30px;background-color: rgba(244, 67, 54, 0.65);" class="btn fa fa-close modal-action modal-close" >&nbsp;No</button>
   
                
        </div>
          
                
        <div class="row" id="enterstatus" >  
           <h6 class="center">Status Change</h6>
      <div class="input-field col s12 l12 m12">
                <select class="browser-default" name="status">
                <option value="11">Active</option>
                <option value="33">Sleep</option>
                <option value="44">Sleep for 30min</option>
                <option value="55">Logout</option>
                </select>
        </div><br>
          
           <div class="input-field col s12 l12 m12">
          
        <input type="button" class="btn cnagesub" value="Submit"style="width:100%;"><br>
						</div>
						<!--./modal for change status  -->
</div>
  </form> 
</div>
     </div>  
 <div id="deduction_det" class="modal" style="width:30%;">
						  <div class="modal-content">
						 <a href="#" class="fa fa-close modal-action modal-close right"  id="closebtn"></a>
	<form action="dedadd" method="GET">        
      
                
        <div class="row"  id="enterstatus" >  
           <h6 class="center">Add Deduction</h6>
     <table class="striped">
     <tr>
     <th class="Dtd">Deduction Amt</th>
     <th class="Dtd">Deduction Reason</th>
     <th class="Dtd">Action</th>
    
     </tr>
     <tr>
     <td class="Dtd"><input type="number" name="dedAmt" class="validate" id="ded_amt" required>
     <label for="ded_amt" ></label>
     </td>
     <td class="Dtd"><input type="text" name="reason" id="ded_reason" required></td>
     <td class="Dtd"><input type="submit" class="btn cnagesub" id="input" value="Save" >
  </td>
     </tr>
     </table><br>
<span style="color:red;">Note:</span><span style="color:#1253A4;font-size:13px;"><i>Enter -ve values to remove deduction</i> </span>
						<!--./modal for change status  -->
</div>
  </form> 
</div>
     </div>  

   
 <!-- Transporter/Vehicle Register -->
    <script>

    $(function() {
        var txt = $(".space");
        var func = function() {
            txt.val(txt.val().replace(/\s/g, ''));
        }
        txt.keyup(func).blur(func);
    });
    $(document).ready(function(){
    	  // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    	  $('.modal-trigger').leanModal({
    	        dismissible: false
    	    });
    	  });
$(document).ready(function() {
  $('select').material_select();
}); 
$(".cnagesub").click(function(){

	$("#enterstatus").hide();
	$(".showyesno").show();
});

$('#closebtn,#no').click(function(){

	$("#enterstatus").show();
	$(".showyesno").hide();
})
 $(document).keyup(function(e) {
               if (e.keyCode == 27) { // escape key maps to keycode `27`
                  $('#changestatus').closeModal();
                  
              }
          });

</script>
 <script type="text/javascript">
			         $(function(){
			          $('*[name=fromDate],[name=toDate]').appendDtpicker({
			           "autodateOnStart": false,
			            "closeOnSelected": true,
			         
			            "closeButton": true,
			            "dateOnly":true,
			          });
			         });
  </script> 
</body>
</html>