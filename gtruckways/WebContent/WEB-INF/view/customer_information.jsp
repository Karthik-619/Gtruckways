<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
 


	
	<style>
			nav
{
background-color:#0288d1;
}
	input[type=text], input[type=password], input[type=email], input[type=url], input[type=time], input[type=date], input[type=datetime-local], input[type=tel], input[type=number], input[type=search], textarea.materialize-textarea {
    background-color: transparent;
    border-bottom: 1px solid #9e9e9e;
    color: black;
    outline: none;
    height: 2rem;
    width: 100%;
    font-size: 1rem;
    margin: 0 0 15px 0;
    padding: 0;
    box-shadow: none;
    box-sizing: content-box;
    transition: all .3s;
}
fieldset.field {
    border: 1px solid #c0c0c0;
    margin: 0 25px;
    padding: 0.35em 4em 0.75em 1rem;
}
td, th {
    padding: 3px 5px;
    display: table-cell;
    text-align: left;
    vertical-align: middle;
    border-radius: 2px;
}
.btn.search{
height:30px;
background-color:#0288d1;

color:white;
font-size:13px;

line-height:20px
}
::-webkit-input-placeholder { color:gray; }
.row input[type="text"]::-moz-placeholder { color:#7e7e7e; }
.row input[type="text"]:-moz-placeholder { color:#7e7e7e; }
.row textarea[name="pickupArea"]:-moz-placeholder { color:#7e7e7e; }

.row {
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 0px;
}

 .tab{
border:1px solid black;
} 
 .tabs{

background-color:rgba(128, 128, 128, 0.36);
}
.tabs .indicator {
    position: absolute;
    bottom: 0;
    height: 2px;
    background-color: black;
    will-change: left, right;
}
.tabs .tab a {
    color: black;
    display: block;
    width: 100%;
    height: 100%;
    text-overflow: ellipsis;
    overflow: hidden;
    transition: color .28s ease;
}
.tab a.active {
    background-color:rgb(117, 202, 235);
border:2px solid black;
color:black; 
  
}
.tabs .tab a:hover, .tabs .tab a.active {

    color: white;
    font-weight:900;
} 
	</style>
	
</head>
<body onload="initialize()">
 <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      	<img src="img/Logonew.png" height="70%" width="10%"  alt="logo" style="margin-top:15px;" /><span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;"><img src="img/customer-service.png" > Customer Care</span>
      
     <ul id="" class="right logged-in" >
			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;${TelecallerInfo.telecallerName}</a></li>
			
			  <ul id="dropdown_local" class="dropdown-content" >
			

			 <li><a href="" onclick="" id="signout" >Sign out</a></li> 
			  </ul>
		</ul>
   
    </div>
  </nav>
  </div> <!--./ Local Header -->
  
    <div class="col s12 l12 m12">
      <ul class="tabs" >
        <li class="tab col s3" style="width:220px;"><a target="_blank" href="bookHome">Bookings</a></li>
        <li class="tab col s3 " style="width:220px;"><a href="custInfo" class="active" target="_blank">Customer Details</a></li>
        <li class="tab col s3" style="width:220px;"><a  target="_blank" href="dmForm">Driver Management</a></li>     
       
   
      </ul>
    </div>
    
 <br>
  <div class="row">
  
  <!-- Customer Search -->
  	<div class="col s12 m12 l8">
  	<fieldset  class="field">
  <legend><b><span style="color:#1253A4"><i class="fa fa-search"></i>&nbsp;Customer Search</span></b></legend>
  <form action="getcustInfo" method="Get">
  	<div class="input-field col s12 m12 l5">
  	<input type="text" name="infoId" placeholder="Booking Id/Mobile No/Email-ID" value="" style="color:black" id=""  required>
  	
  	</div>

     <div class="input-field col s12 m12 l1">
  	  	<input type="submit" value="search" class="btn search">	
  	</div>
  	</form>
  	   </fieldset>
  	</div>
  <!-- /Customer Search -->
  

  </div>
  <br>
  <br>
  <div class="row">
  	<!--Customer Information  -->
  	<div class="col s12 m12 l6">
  	<span>${bookInfo.statusMessage}</span>
  	
  	 <c:choose>	
  <c:when test="${bookInfo.statusCode!=401}">
  
  	<fieldset class="">
  		<legend><span style="color:#1253A4"><i class="fa fa-user">&nbsp;</i><b>Customer Information</b></span></legend>
  		<table class="striped responsive-table">
  			<tr>
  			<th>Name</th>
  			<td>${bookInfo.user.userName}</td>
  			<th>Mobile No</th>
  			<td>${bookInfo.user.mobileNo}</td>
  			</tr>
  			<tr>
  			<th>Email-Id</th>
  			<td>${bookInfo.user.email}</td>
  			<th>Registered Date</th>
  			<td>${bookInfo.user.registerDate}</td>
  			</tr>
  		<!-- 	<tr>
  			<th>Total Bookings</th>
  			<td>20</td>
  			<th>Bookings completed</th>
  			<td>10</td>
  			</tr> -->	
  			<tr>
  			<th> Customer Type</th>
  			<td>${bookInfo.user.userType}</td>
  			
  			</tr>
  		</table>
  	</fieldset>
  	
</c:when>	
  <c:when test="${bookInfo.statusCode==401}">
  	<fieldset>
  		<legend><span style="color:#1253A4"><i class="fa fa-user">&nbsp;</i><b>Customer Sign Up</b></span></legend>
  		<form action="tcustadd" method="Post">
  		<div class="row">
  			<div class="input-field col s12 m12 l4">
  				<input type="text" name="userName" placeholder="Name">
  			</div>
  			<div class="input-field col s12 m12 l4">
  				<input type="text" name="mobileNo" placeholder="Mobile No" pattern="^[789]\d{9}$"  maxlength="10" class="validate">
  			</div>
  			<div class="input-field col s12 m12 l4">
  				<input type="text" name="email" class="validate" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})"  placeholder="Email-ID">
  			</div>
  		</div>
  		<div class="row">
 
  			<div class="input-field col s12 m12 l4">
  				<input type="text" name="gstNumber" placeholder="GST No">
  			</div>
  			<div class="input-field col s12 m12 l4">
  				<select class="browser-default" name="userType" style="height:20px;">
  				<option value="">Customer Type</option>
  					<option value="On Demand">On Demand</option>
  					<option value="Enterprise">Enterprise</option>
  				</select>
  			</div>
  			<input type="submit" class="btn col offset-l5" value="Sign Up">
  		</div>
  		</form>
  	</fieldset>
  	</c:when>	
</c:choose>
  	<br>
  	<c:choose>	
  	<c:when test="${bookInfo.statusCode!=401}">
  		<fieldset>
  			<legend><span style="color:#1253A4"><i class="fa fa-truck">&nbsp;</i><b>Order Details</b></span></legend>
  			<a href="#" class="btn change  right" id="createnewbooking">Create New Booking</a><br>
  			
  				 <table class="respoinsive-table striped">
  				 	<tr>
  				 		<th>Booking-ID</th>
  				 		<th>Date</th>
  				 		<th>Status</th>
  				 		<th>Booked Through</th>
  				 	</tr>
  				 	<c:forEach var="pos" items="${bookInfo.post}">
  				 	<tr>
  				 	<td><a href="postID?PostId=${pos.bookingId}" target="_blank">${pos.bookingId}</a></td>
  				 	<td>${pos.travelDate}</td>
  				 	<td>${pos.status}</td>
  				 	<td>${pos.bookedThrough}</td>
  				 
  				 	</tr>
  				 		</c:forEach>
  				 </table>
  
  		</fieldset>
  		</c:when>
  		</c:choose>
  	</div>
  	<!-- ./Customer Information -->
  	
  	<div class="col s12 m12 l6">
 
  		<fieldset style="display:none;" id="newbooking">
  			<legend><span style="color:#1253A4"><i class="fa fa-truck">&nbsp;</i><b>New booking</b></span></legend>
  			
  	<form action="tbooking" method="Post">
  			<div class="row">
  			
  			<div class="input-field col s12 m12 l12">
   <input list="from1"  name="fromCity" id="frmarea" placeholder="From" type="text" onfocusout="myFunction()"class="validate" required>
  <label for="frmarea" data-error="" ></label><span id="h_frm" style="color:red;font-size:13px;"></span>
					 	<datalist id="from1">
				 		</datalist>
  </div>
  
   <div class="input-field col s12 m12 l12">
<input list="to1"  name="toCity" id="tooarea"placeholder="To" type="text" class="validate"  onfocusout="myFunction1()" required />
				    <label for="tooarea" data-error="" ></label><span id="h1_frm" style="color:red;font-size:13px;"></span>
				 	<datalist id="to1">
			 		</datalist>
  </div>
  	<div class="input-fiels col s12 l6">
		
		 <textarea  name="pickUpArea" class="text_content" style="height:50px;font-family: Roboto, sans-serif;" maxlength="150" placeholder="Pickup point" required></textarea>
		</div>
		
		<div class="input-fiels col s12 l6">
		
		 <textarea cols="12" rows="12" name="dropArea" style="height:50px;font-family: Roboto, sans-serif;" maxlength="150" class="text_content" placeholder="Drop point" required></textarea>
		</div>	
		
		
   
  			
  			</div>
  		<div class="row">
  		
	 <div class="input-field col s12 m12 l6">
  <select class="browser-default" name="truckId" style="height:1.5rem;">
  	 <option value="" disabled selected  >Select Vehicle Type</option> 
   	  <c:forEach var="item" items="${VehicleTypeList}">
     <option value="${item.truckId}" >${item.truckName}</option>
   	 </c:forEach>
  </select>
  </div>	
		<div class="input-field col s12 m12 l6">
    <select class="browser-default" name="material" style="height:1.5rem;">
  	 <option selected disabled value="" >Select Material</option>
								   <c:forEach var="item" items="${MaterialList}">
    						 		<option>${item}</option>
   									</c:forEach>
  </select>
  </div>	
  		</div>
  		<div class="row">
  			<div class="input-field col s12 m12 l4">
			<input type="text"  name="travelDate" placeholder="Date" id="date_picker1">
			</div>
  		 	<div class="input-field app inr col s12 m12 l4 ">
		<input type="number" name="valueOfGoods" min="0"  placeholder="Value Of Goods"  class="validate" required>
		<label for=""></label>
		</div>
		<div class="input-field col s12 m12 l4">
			<input type="number" name="approximateWeight" min="0" class="validate" placeholder="  Apprx Weight" required>
			<label for="" data-error=""></label>
			</div>
		
    </div>
    <div class="row">
     <div class="input-field col s12 l4 ">
    <input type="number" name="helper" placeholder="Helper" max="4" min="0">
     
   
    </div>
      <div class="input-field col s12 l4 ">
     <span>  <input type="checkbox" name="differentRecepient" class="filled-in" id="diff_recipent"  value="1"  />
      <label for="diff_recipent" class="diff left" > <b>Different Recipient</b></label>
    </span>
    </div>
    <div class="input-field col s12 m12 l4">
			<input type="text" name="promocode"  class="validate" placeholder="Promocode" >
			<label for="" data-error=""></label>
			</div>
    </div>
       <div class="row "  id="recipent_details" style="display:none">
         <div class="input-field col s12 l6">
		   <input  id="rlname" type="text" name="recepientName" class="validate z-depth-3" pattern="^[a-zA-Z-_\s'.]{1,}$" maxlength="45" placeholder="Name" >
			<label for="rlname" data-error=""></label>
		 </div>
		<div class="input-field col s12 l6">
	
		 <input  id="rlmobile" type="text" name="recepientMobile" pattern="^[789]\d{9}$" maxlength="10" class="validate" placeholder="Mobile No" >
		 <label for="rlmobile" data-error=""> </label>
		</div>
		</div><br>
		<div class="row">
		<input type="submit" value="Proceed" class="btn col offset-l5">
		</div>
		</form>
		</fieldset>
		
		
		
		 <c:choose>	
  		<c:when test="${PostInfo.statusCode==201}">
		<fieldset>
		  			<legend><span style="color:#1253A4"><i class="fa fa-truck">&nbsp;</i><b>Booking Details</b></span></legend>
		
		<form action="tconfirmBooking" method="Post">
		<div class="row">
			<table>
				<tr>
					<td>Name</td>
					<td>${bookInfo.user.userName}</td>
					<td>Mobile No</td>
					<td>${bookInfo.user.mobileNo}</td>
				</tr>
				<tr>
					
				</tr>
				<tr>
					<td>From</td>
					<td><textarea>${PostInfo.fromCity}</textarea></td>
					<td>To</td>
					<td><textarea>${PostInfo.toCity}</textarea></td>
				</tr>
					<tr>
					<td>Pickup</td>
					<td><textarea>${PostInfo.pickUpArea}</textarea></td>
					<td>Drop</td>
					<td><textarea>${PostInfo.dropArea}</textarea></td>
				</tr>
					<tr>
					<td>Approximate KM</td>
					<td>${PostInfo.price.route.distance}</td>
					<td>Approximate Min</td>
					<td>${PostInfo.price.route.time}</td>
				</tr>
					<tr>
					<td>Value of goods</td>
					<td>${PostInfo.valueOfGoods}</td>
					<td>Approximate weight</td>
					<td>${PostInfo.approximateWeight}</td>
				</tr>
					<tr>
					<td>Vehicle Type</td>
					<td>${PostInfo.price.info.truckName}</td>
					<td>Material</td>
					<td>${PostInfo.material}</td>
				</tr>
					<tr>
					<td>Date of travel</td>
					<td>${PostInfo.travelDate}</td>
					<td>Approximate Amount</td>
					<td>
					<%--  <input type="hidden" value="${telePostinfo.approximateAmount}" id="amountid">
                     <input type="hidden" value="${telePostinfo.infoTruck.labourPrice}" id="labourid"> <!--price calculation --> --%>
  			      <input type="text"  width="20%;" name="totalAmount" value="${PostInfo.totalAmount}"  id="amount" />
  
					</td>
				</tr>
					<tr>
					<td>Helper</td>
					<td>${PostInfo.helper}</td>
					<td>Promocode</td>
					<td>${PostInfo.statusMessage}</td>
				</tr>
		
			</table>
				<input type="submit" value="Confirm" class="btn col offset-l5">
		</div>
		</form>
		</fieldset>
		
		</c:when>
		<c:when test="${PostInfo.statusCode==200}">
		
		<fieldset>
		  			<legend><span style="color:#1253A4"><i class="fa fa-truck">&nbsp;</i><b>Booking Details</b></span></legend>
		
		<h5 style="color: #01579b !important;text-align:center"><i class="fa fa-check-circle" ></i>&nbsp;Booking has been Created</h5>
		<p style="text-align:center">Booking Id: <b> ${PostInfo.bookingId}</b></p>
		</fieldset>
		</c:when>
		</c:choose>
		
  		</div>
  		
  	</div>

  </div>
  

  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-dtpicker.js"></script>   
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=true&libraries=places&key=AIzaSyDWK67G2dser4HY7zGwOPHPlvNrORCRSzs"></script>

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
  var input = document.getElementById('frmarea');
  var toarea =document.getElementById('tooarea');
  var autocomplete = new google.maps.places.Autocomplete(input, options);

  var autocomplete = new google.maps.places.Autocomplete(toarea, options);
  //autocomplete.bindTo('bounds', map);
 }
google.maps.event.addDomListener(window, 'load', initialize);
</script>
<script>
$(document).ready(function(){
	  // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
	  $('.modal-trigger').leanModal({
	        dismissible: false
	    });
	  });
	  
$('#diff_recipent').change(function() {
    if(!$(this).is(':checked'))
    	
     $("#rlname").val("");
   
 $("#rlmobile").val("");

 
});

$('ul.tabs a').on('click', function(e){

	  if($(this).attr("target") ) {
	    window.location = $(this).attr("href");
	  }
	}); 
	
/* to hide and show newbooking */
$("#createnewbooking").click(function(){
	$("#newbooking").toggle();
});

$('#bid').keyup(function(){
    $(this).val($(this).val().toUpperCase());
}); 

$(function(){
 $('#date_picker,#date_picker1,#date_picker2').appendDtpicker({
  "autodateOnStart": false,
   "closeOnSelected": true,
   "futureOnly": true,
   "closeButton": true,
 });
});
</script> 
<script>
document.getElementById('diff_recipent').onchange = function() {
    document.getElementById('recipent_details').style.display = this.checked ? 'block' : 'none';
};


function samecity(){
	   var frmarea=document.getElementById("frmarea");
	   var tooarea=document.getElementById("tooarea");
	   if(frmarea.value==tooarea.value){
	    
	    tooarea.value="";
	    tooarea.focus();
	    document.getElementById("h_frm").innerHTML="From and To Area can not be same";
	    document.getElementById("tooarea").style="border:3px solid red";
	    document.getElementById("tooarea").style="border-bottom:none";
	    return false;
	   }else{
	  
	    document.getElementById("h_frm").innerHTML="";
	    return true;
	   }
	  }


function myFunction() {
    var str = document.getElementById("frmarea").value;
    var str1 = document.getElementById("tooarea").value;
    var n = str.endsWith("Bengaluru, Karnataka, India");
   // var n1 = str1.endsWith("Bengaluru, Karnataka, India");
    
    if(n==0 ){
  /*  document.getElementById("h_frm").innerHTML="From and To City can not be same";

   document.getElementById("city").value="";
 document.getElementById("city").focus(); */
 frmarea.value="";
/*  frmarea.focus(); */

 document.getElementById("h_frm").innerHTML="Enter areas with in Bengaluru";
 
 
    return false;
    }
    else{
    	document.getElementById("h_frm").innerHTML=" ";
    }
}

function myFunction1() {
  
    var str1 = document.getElementById("tooarea").value;
   var n1 = str1.endsWith("Bengaluru, Karnataka, India");
    
    if(n1==0 ){
  /*  document.getElementById("h_frm").innerHTML="From and To City can not be same";

   document.getElementById("city").value="";
 document.getElementById("city").focus(); */
 tooarea.value="";
/*  frmarea.focus(); */

 document.getElementById("h1_frm").innerHTML="Enter areas with in Bengaluru";
 
 
    return false;
    }
    else{
    	document.getElementById("h1_frm").innerHTML=" ";
    }
}
</script>
</body>
</html>