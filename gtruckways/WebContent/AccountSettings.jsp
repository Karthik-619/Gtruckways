<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/local.css" />
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
	 <script type="text/javascript" src="js/createReqObj.js" ></script>
	  <script type="text/javascript" src="js/register.js" ></script>
	  <style>
	
	   .card-content
	  {
	  height:70%;
	  }
	  </style>
</head>
<body>
<div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      
      	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a><span style="font-size:35px;margin-left:32rem;padding-bottom:1rem;color:#fff">Enterprise</span>
      <ul class="right hide-on-med-and-down ">
 
       
      </ul>
   
    </div>
  </nav>
  </div> <!--./ Local Header -->

<div class="row">
<div class="card col s12 m12 l2">

<div class="card-content">

<a href="EnterpriseDashboard.jsp"><img src="img/user.jpg" width="60%"></a>

</div>
<div class="card-content">

<b>GTRENT1001</b>

</div>
<div class="card-content">

<a href="TrackTruck.jsp"><i class="fa fa-truck"></i>&nbsp;&nbsp;Track Truck</a>
</div>
<div class="card-content">

<a href="BalanceKm.jsp"><i class="fa fa-balance-scale"></i>&nbsp;&nbsp;Balance KM</a>
</div>
<div class="card-content">

<a href="#"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Billing Details</a>
</div>

<div class="card-content">

<a href="AccountSettings.jsp"><i class="fa fa-cog"></i>&nbsp;&nbsp;Account Settings</a>
</div>
<div class="card-content">


</div>



</div>
<div class="card col s12 m12 l10">
<div class="card-content ">
              <span class="card-title">Change Password</span>
              
            </div>
<div class="card-action center">

  <div class="row">
     <form action="enterprise" method="post" class="enterprise"  autocomplete="on">
    <div class="row">
     <div class="input-field col s12 m12 l3 ">
            <input   type="text"  class="validate"   placeholder="Current Password" required>
  		</div>
  		 <div class="input-field col s12 m12 l3 ">
            <input   type="text"  class="validate"  placeholder="New Password" required>
  		</div>
  		 <div class="input-field col s12 m12 l3 ">
            <input   type="text"  class="validate"  placeholder="Confirm Password" required>
  		</div>
  		<div class="input-field col s12 l3 m12">
    			<input type="submit" value="Submit" class="btn" style="width:100%;height:40px; font-size:20px;background-color:#3366CC;" id="submit"  >
  
    </div>
  		</div>
  		
          </form>
   		</div>
   	
   		
   		
   		
   
  
  
    

     
      </div>
</div>
</div>
</div>

</body>
</html>