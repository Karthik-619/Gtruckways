<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	</style>
	
</head>
<body onload="initialize()">
 <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      	<img src="img/Logonew.png" height="70%" width="10%"  alt="logo" style="margin-top:15px;" /><span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;"><img src="img/customer-service.png" > Customer Care</span>
      
     <ul id="" class="right logged-in" >
			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;Name  </a></li>
			
			  <ul id="dropdown_local" class="dropdown-content" >
			

			 <li><a href="" onclick="" id="signout" >Sign out</a></li> 
			  </ul>
		</ul>
   
    </div>
  </nav>
  </div> <!--./ Local Header -->
  
 
  <div class="row">
  
  <!-- Customer Search -->
  	<div class="col s12 m12 l8">
  	<fieldset  class="field">
  <legend><b><span style="color:#1253A4"><i class="fa fa-search"></i>&nbsp;Customer Search</span></b></legend>
  <form action="" method="post">
  	<div class="input-field col s12 m12 l5">
  	<input type="text" name="" placeholder="Booking Id/Mobile No/Email-ID/Name"  style="color:black" id=""  required>
  	
  	</div>

     <div class="input-field col s12 m12 l1">
  	  	<input type="submit" value="search" class="btn search">	
  	</div>
  	</form>
  	   </fieldset>
  	</div>
  <!-- /Customer Search -->
  

  </div>
  <div class="row">
  	<!--Customer Information  -->
  	<div class="col s12 m12 l6">
  	<fieldset class="">
  		<legend><span style="color:#1253A4"><i class="fa fa-user">&nbsp;</i><b>Customer Information</b></span></legend>
  		<table class="striped responsive-table">
  			<tr>
  			<th>Name</th>
  			<td>Sowmya</td>
  			<th>Mobile No</th>
  			<td>8495887398</td>
  			</tr>
  			<tr>
  			<th>Email-Id</th>
  			<td>sowmya@gmail.com</td>
  			<th>Registered Date</th>
  			<td>12-05-2017</td>
  			</tr>
  			<tr>
  			<th>Total Bookings</th>
  			<td>20</td>
  			<th>Bookings completed</th>
  			<td>10</td>
  			</tr>
  			<tr>
  			<th> Customer Type</th>
  			<td>Enterprise</td>
  			
  			</tr>
  		</table>
  	</fieldset>
  	<br>
  		<fieldset>
  			<legend><span style="color:#1253A4"><i class="fa fa-truck">&nbsp;</i><b>Order Details</b></span></legend>
  			<a href="#" class="btn change  right" >Create New Booking</a><br>
  			
  				 <table class="respoinsive-table striped">
  				 	<tr>
  				 		<th>Booking-ID</th>
  				 		<th>Date</th>
  				 		<th>Status</th>
  				 		<th>Booked Through</th>
  				 	</tr>
  				 	<tr>
  				 	<td><a href="bookHome" target="_blank"> GTR-1234</a></td>
  				 	<td>12-02-2017</td>
  				 	<td>completed</td>
  				 	<td>Web</td>
  				 	</tr>
  				 </table>
  
  		</fieldset>
  	</div>
  	<!-- ./Customer Information -->
  	
  	<div class="col s12 m12 l6">
  	<form>
  		<fieldset>
  			<legend><span style="color:#1253A4"><i class="fa fa-truck">&nbsp;</i><b>New booking</b></span></legend>
  			<div class="row">
  			
  			<div class="input-field col s12 m12 l4">
   <input list="from1"  name="fromCity" id="frmarea" placeholder="From" type="text" onfocusout="myFunction()"class="validate" required>
  <label for="frmarea" data-error="" ></label><span id="h_frm" style="color:red;font-size:13px;"></span>
					 	<datalist id="from1">
				 		</datalist>
  </div>
  
   <div class="input-field col s12 m12 l4">
<input list="to1"  name="toCity" id="tooarea"placeholder="To" type="text" class="validate"  onfocusout="myFunction1()" required />
				    <label for="tooarea" data-error="" ></label><span id="h1_frm" style="color:red;font-size:13px;"></span>
				 	<datalist id="to1">
			 		</datalist>
  </div>
  
    <div class="input-field col s12 m12 l4">
  <select class="browser-default" style="height:1.5rem;">
  	<option value="">vehicle type</option>
  	<option value="">Tata Ace</option>
  	<option value="">Tata 407</option>
  </select>
  </div>
  			
  			</div>
  		<div class="row">
  		<div class="input-fiels col s12 l4">
		
		 <textarea  name="pickupArea" class="text_content" style="height:50px;font-family: Roboto, sans-serif;" maxlength="150" placeholder="Pickup point" required></textarea>
		</div>
		<div class="input-fiels col s12 l4">
		
		 <textarea cols="12" rows="12" name="dropArea" style="height:50px;font-family: Roboto, sans-serif;" maxlength="150" class="text_content" placeholder="Drop point" required></textarea>
		</div>	
		<div class="input-field col s12 m12 l4">
    <select class="browser-default" style="height:1.5rem;">
  	<option value="">Select Material</option>
  	  
    <option value="Building Materials">Building Materials</option>
	<option value="House Hold Materials">House Hold Materials</option>
    <option value="Liquid / Oil">Liquid / Oil</option>
	<option value="Food Grains">Food Grains</option>
	<option value="Industrial Equipments">Industrial Equipments</option>
	<option value="Fruits and Vegetables">Fruits and Vegetables</option>
	<option value="Beverages">Beverages</option>
	<option value="CPG">consumer packaged goods (CPG)</option>
	<option value="General Goods ">General Goods</option>
	<option value="Bardana Jute/Plastic">Bardana Jute/Plastic</option>
	<option value="Chemicals">Chemicals</option>
	<option value="Container">Container</option>
	<option value="Eelectronics / Consumer Durables ">Electronics / Consumer Durables</option>
	<option value="Fertilizers ">Fertilizers</option>
	<option value="Furniture and Wood Products ">Furniture and Wood Products</option>
	<option value="Liquids in Drums ">Liquids in Drums</option>
  </select>
  </div>	
  		</div>
  		<div class="row">
  			<div class="input-field col s12 m12 l4">
			<input type="text"  name="traveldate" placeholder="Date">
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
     <span>  <input type="checkbox" name="helper" class="filled-in" id="driverasHelper" value="1" onchange="totalprice()"/>
      <label for="driverasHelper"  style="font-size:14px;" class="diff left"> <b>Driver As Helper</b></label>
     
    </span>
    </div>
      <div class="input-field col s12 l4 ">
     <span>  <input type="checkbox" name="diffRecepient" class="filled-in" id="diff_recipent"  value="1"  />
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
	
		 <input  id="rlmobile" type="text" name="recepientMobileNo" pattern="^[789]\d{9}$" maxlength="10" class="validate" placeholder="Mobile No" >
		 <label for="rlmobile" data-error=""> </label>
		</div>
		</div><br>
		<div class="row">
		<input type="submit" value="Procced" class="btn col offset-l5">
		</div>
		
		</fieldset>
		</form>
		<fieldset>
		  			<legend><span style="color:#1253A4"><i class="fa fa-truck">&nbsp;</i><b>Booking Details</b></span></legend>
		
		<form>
		<div class="row">
			<table>
				<tr>
					<td>Name</td>
					<td>sowmya</td>
					<td>Mobile No</td>
					<td>9449434970</td>
				</tr>
				<tr>
					
				</tr>
				<tr>
					<td>From</td>
					<td><textarea></textarea></td>
					<td>To</td>
					<td><textarea></textarea></td>
				</tr>
					<tr>
					<td>Pickup</td>
					<td><textarea></textarea></td>
					<td>Drop</td>
					<td><textarea></textarea></td>
				</tr>
					<tr>
					<td>Approximate KM</td>
					<td>11</td>
					<td>Approximate Min</td>
					<td>20</td>
				</tr>
					<tr>
					<td>Value of goods</td>
					<td>11</td>
					<td>Approximate weight</td>
					<td>20</td>
				</tr>
					<tr>
					<td>Vehicle Type</td>
					<td>tata ace</td>
					<td>Material</td>
					<td>house hold</td>
				</tr>
					<tr>
					<td>Date of travel</td>
					<td><input type="text" name="traveldate" value="${telePostinfo.travelDate}" onchange="totalprice()" placeholder="Date"></td>
					<td>Approximate Amount</td>
					<td>
					 <input type="hidden" value="${telePostinfo.approximateAmount}" id="amountid">
                     <input type="hidden" value="${telePostinfo.infoTruck.labourPrice}" id="labourid"> <!--price calculation -->
  			      <input type="text"  width="20%;" name="userQuotedAmount" value="${telePostinfo.totalAmount}"  id="amount" readonly/>
  
					</td>
				</tr>
					<tr>
					<td>Helper</td>
					<td><input type="number" min="0"max="4"></td>
					<td>Promocode</td>
					<td>applied</td>
				</tr>
		
			</table>
				<input type="submit" value="Confirm" class="btn col offset-l5">
		</div>
		</form>
		</fieldset>
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


$('#bid').keyup(function(){
    $(this).val($(this).val().toUpperCase());
}); 

$(function(){
 $('*[name=traveldate]').appendDtpicker({
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