
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
padding:1%;
}
tr,td,th{
border:1px solid black;
}
td.data
{
 border: 1px solid #dddddd;

    padding:1%;
    
}
	</style>

</head>
<body>
 <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      	<img src="img/Logonew.png" height="70%" width="10%"  alt="logo" style="margin-top:15px;" /><span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;">Customer Care</span>
        
   
    </div>
  </nav>
  </div>
<div class="row col l12 s12 m12">
<!--transporter list  -->
<div class="col l4 s12 m12">
	<h5 class="center mtitle" style="color: #0e58e4;" >Transporter Details</h5>
       
    <table class="responsive-table striped">
			<tr>
				<th>Transporter Id</th>
						<td>${listTransById.transporterId}</td>		
			</tr>
			<tr>
				<th>Transporter Name</th>
				  <td>${listTransById.transporterName}</td>
			</tr>
			<tr>
				<th>Mobile No</th>
				<td>${listTransById.mobileNo}</td>
			</tr>
			<tr>
				<th>Email</th>
					<td>${listTransById.email}</td>
			</tr>	
			<tr>
				<th>Address</th>
				
				<td>${listTransById.address}</td>
			</tr>
			
			<tr>
				<th>Pan No</th>
						<td>${listTransById.panNo}</td>
			</tr>
			<tr>
				<th>Account Holder Name</th>
					<td>${listTransById.acctHolderName}</td>
			</tr>
			<tr>
				<th>IFSC code</th>
						<td>${listTransById.IFSCcode}</td>
			</tr>
			<tr>
				<th>Account No</th>
					<td>${listTransById.acctNo}</td>
			</tr>

			<tr>
				<th>Bank Name</th>
				<td>${listTransById.bankName}</td>
			</tr>
			<tr>
				<th>Branch</th>
				<td>${listTransById.branch}</td>
			</tr>
			
			<tr>
				<th>Adhar No</th>
						<td>${listTransById.identificationNo}</td>
			</tr>
			<tr>
				<th>cheque No</th>
						<td>${listTransById.cancelledChequeNo}</td>
			</tr>
						
</table>    
       

</div> 
<!--/Tranport list  -->

<!--Truck list  -->
<div class="col s12 l8 m12">
<h5 class="center mtitle" style="color: #0e58e4;" >Truck List</h5>

<p>${msg}</p>        
 
<table class="responsive-table striped">
	<thead>
              <tr class="row1">
              
		              
		              <th class="head">Vehicle Registration No</th>
		              <th class="head">Vehicle Name</th>
		              <th class="head">Vehicle Insurance No</th>
		              <th class="head">Vehicle Reg Date</th>
		              <th class="head">Brand</th>
		             
					  
              </tr>
       </thead>
<c:forEach var="v" items="${listVehicle}">
         <tbody>
              <tr class="row1">
           
              
              <td class="data"><span><a href="vehRegDetails?vehRegNum=${v.vehicleRegistrationNo}">${v.vehicleRegistrationNo}</a></span></td>
              <td class="data">${v.vehicleName}</td>
              <td class="data">${v.vehicleInsuranceNo}</td>
              <td class="data">${v.registrationDate}</td>
              <td class="data">${v.brand}</td>
          
               
              </tr>
        </tbody>
     </c:forEach>
   </table>

</div>
</div><!--/truck list  -->
</body>