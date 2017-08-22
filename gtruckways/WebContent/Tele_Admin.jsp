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

<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery-dtpicker.js"></script>
<script type="text/javascript" src="js/materialize.js" ></script>
<script type="text/javascript" src="js/materialize.min.js" ></script> 


<style>
	.logo{
	margin-top:1rem ;
}
		nav
{
background-color:#0288d1;
}
.input-field label {
    color: #0288d1;
    position: absolute;
    top: 0.8rem;
    left: 0.75rem;
    font-size: 1rem;
    cursor: text;
    transition: .2s ease-out;
}
select {
    background-color: rgba(255,255,255,0.9);
    width: 100%;
    padding: 5px;
    border-bottom: 1px solid #9e9e9e;
    border-radius: 2px;
    height: 3rem;
    color:#0288d4;
}
.btn, .btn-large {
    text-decoration: none;
    color: #fff;
    background-color: #0288d1;
    text-align: center;
    letter-spacing: .5px;
    transition: .2s ease-out;
    cursor: pointer;
}
</style>
</head>
<body>

 <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      	<img src="img/Logonew.png"  height="70%" width="10%"  class="logo" alt="" /><span style="font-size:35px;margin-left:33rem;margin-top:5rem;">Admin</span>
      <ul class="right hide-on-med-and-down ">
 <!-- <li> --><!-- </li> -->
       
      </ul>
   
    </div>
  </nav>
  </div> 
  
  <div class="row">
  <div class="col s12 m12 l6">
  <br>
  <fieldset>
  <legend><b style="color:#1253A4;"><i class="fa fa-tags" aria-hidden="true" style="font-size:15px;"></i>&nbsp;Add Promocode</b></legend>
  <div class="row center">
	<div class="input-field col s12 m12 l6">
		<input type="text">
		<label for="">Enter Promocode</label>
	</div>
	<div class="input-field col s12 m12 l6">
	<input type="number" min="0">
	<label for="">Amount</label>
	</div>
</div>
<div class="row">
	
</div>
<div class="row">
	<div class="input-field col s12 m12 l6">
		<input type="text" id="fromDate">
		<label for="">From Date</label>
		</div>
			<div class="input-field col s12 m12 l6">
		<input type="text"id="toDate">
		<label for="">To Date</label>
		</div>
</div>

<div class="row">
	<div class="input-field col s12 m12 l12">
	<select class="browser-default">
	<option value="">Vehicle Type</option>
	<option value="">TATA ACE/MAXIMO</option>
	<option value="">TATA 407</option>
	<option value="">ALL</option>
	</select>
		</div>
		</div>
		<div class="row">
		<div class="input-field col s12 m12 l12">
		<input type="submit" value="Submit" class="btn col offset-l3" style="width:50%;">
		</div>
		</div>
  </fieldset>
  
  
  </div>
  
  <div class="col s12 m12 l6">
    <br>
  <fieldset>

  	<legend><b style="color:#1253A4;">&nbsp;<i class="fa fa-rupee" aria-hidden="true" style="font-size:15px;"></i>&nbsp;Price Change</b></legend>
  	<form>
  	<div class="row">
  		<div class="input-field col s12 m12 l6">
  		<select class="browser-default validate" required=required>
  		<option selected>Vehicle Type</option>
  		<option value="">TATA ACE/MAXIMO</option>
  		<option value="">TATA 407</option>
  	
  		</select>
  		
  		</div>
  		
  	<div class="input-field col s12 m12 l6">
  	<input type="text" required>
  	<label for="">Base Fare</label>
  	</div>

  	</div>
  	<div class="row">
  	<div class="input-field col s12 m12 l6">
  	<input type="number" min="0" class="validate" required>
  	<label for="">Additional Km</label>
  	</div>
  	<div class="input-field col s12 m12 l6">
  	<input type="number" min="0" class="validate" required>
  	<label for="">Additional Min</label>
  	</div>
  	</div>
  	  	<div class="row">
  	<div class="input-field col s12 m12 l6">
  	<input type="text" required>
  	<label for="">Travel Time</label>
  	</div>
  	<div class="input-field col s12 m12 l6">
  	<input type="text" required>
  	<label for="">Night Charge</label>
  	</div>
  	</div>
  		  	<div class="row">
  	<div class="input-field col s12 m12 l6">
  	<input type="text" required>
  	<label for="">Driver As Helper</label>
  	</div>
  	<div class="input-field col s12 m12 l6">
  	<input type="text" required>
  	<label for="">Free Km</label>
  	</div>
  	</div>
  	<div class="row">
  	<div class="input-field col s12 m12 l12">
  	<input type="submit" value="Submit" class="btn col offset-l3" style="width:50%;" >
  	</div>
  	</div>
  	</form>
  </fieldset>
  
  </div>
  </div>



 <script type="text/javascript">
			 $('#fromDate,#toDate').appendDtpicker({
					"autodateOnStart": false,
					 "closeOnSelected": true,
					 "futureOnly": true,
						/* "amPmInTimeList": true, */
						"closeButton": true,
					"dateOnly":true,
				});
			 </script>
</body>
</html>