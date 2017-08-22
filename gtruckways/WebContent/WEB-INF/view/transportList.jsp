
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
 <meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-dtpicker.js"></script>
	<link rel="stylesheet" href="css/tele.css" />
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<style>
		.card .card-action a:not(.btn):not(.btn-large):not(.btn-floating) {
    color: #0089ec;
    margin-right: 20px;
    transition: color .3s ease;
    text-transform: uppercase;
}
	.logo{
	margin-top:1rem ;
}
		nav
{
background-color:#0288d1;
}
#dropdown1{
margin-top:36px;
color:black;
}
table{
border-collapse:collapse;
}
th,td{
padding:1.5%;
}
tr,td,th{
border:1px solid black;
}
	</style>

</head>
<body>
 <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
     	<img src="img/Logonew.png" height="70%" width="10%"  alt="logo" style="margin-top:15px;" /><span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;">Customer Care</span>
      <ul class="right hide-on-med-and-down ">
 <a href="transDetails?transById=${vehDetails.transporter.transporterId}">Go Back</a>
       
      </ul>
   
    </div>
  </nav>
  </div>
  <div class="row">
  <br>
  <fieldset>
<legend></legend>

<h5 class="center mtitle" style="color: #0e58e4;" >Transporter List</h5>
  <div class="col l6 s12 m12">
	
           
    <table class="responsive-table striped">
     		<tr class="row1">
              
              <th >Transporter ID</th>
                <td >${vehDetails.transporter.transporterId}</td>
              </tr>
    
			 <tr class="row1">
              
              <th >Vehicle Name</th>
                <td >${vehDetails.vehicleName}</td>
              </tr>
              <tr>
              <th>Vehicle Registration No</th>
               <td >${vehDetails.vehicleRegistrationNo}</td>
              </tr>
              <tr>
              <th>User Type</th>
               <td >${vehDetails.actType}</td>
              </tr>
              <tr>
              <th>Vehicle Chasis No</th>
               <td>${vehDetails.vehicleChasisNo}</td>
              </tr>
              <tr>
              <th>Vehicle Insurance No</th>
              <td>${vehDetails.vehicleInsuranceNo}</td>
              </tr>
              <tr>
              <th>Insurance Owner</th>
              <td>${vehDetails.insuranceOwner}</td>
              </tr>
              <tr>
              <th>Insurance Expiry Date</th>
               <td>${vehDetails.vehicleInsuranceExpiryDate}</td>
              </tr>
              <tr>
              <th>Vehicle Reg Date</th>
               <td>${vehDetails.registrationDate}</td>
              </tr>
              <tr>
              <th>Vehicle Reg Validity</th>
              <td>${vehDetails.regValidity}</td>
              </tr>
              <tr>
              <th>Engine No</th>
               <td>${vehDetails.engineNo}</td>
              </tr>
              <tr>
              <th>FC No</th>
              <td>${vehDetails.fcNo}</td>
              </tr>
              
             
			
</table>

</div> 
<div class="col l6 s12 m12">
    <table class="responsive-table striped">
 			<tr>
              <th>FC Validity</th>
              <td>${vehDetails.fcValidity}</td>
              </tr>
 			
 			<tr>
              <th>Brand</th>
               <td>${vehDetails.brand}</td>
              </tr>
              <tr>
              <th>Cubic Capacity</th>
              <td>${vehDetails.cubicCapacity}</td>
              </tr>
              <tr>
              <th>BHP</th>
              <td>${vehDetails.bhp}</td>
              </tr>
              <tr>
              <th>Pay Load Capacity</th>
              <td>${vehDetails.payLoadCapacity}</td>
              </tr>
              <tr>
              <th>Vehicle Type</th>
              <td>${vehDetails.vehicleType}</td>
              </tr>
              <tr>
              <th>Dimension</th>
               <td>${vehDetails.dimension}</td>
              </tr>
              <tr>
              <th>Pollution Cert. No</th>
              <td>${vehDetails.pollutionCertNo}</td>
              </tr>
              <tr>
              <th>Pollution Cert. Validity</th>
               <td>${vehDetails.pollutionCertValidity}</td>
              </tr>
              <tr>
              <th>Permit Type</th>
               <td>${vehDetails.permitType}</td>
              </tr>
              <tr>
              <th>Permit States</th>
               <td>${vehDetails.permitStates}</td>
              </tr>
              <tr>
              <th>Permit Validity</th>
                  
              <td>${vehDetails.permitValidity}</td>
              </tr>
			
</table>

</div> 
</fieldset>
</div>
</body>
</html>