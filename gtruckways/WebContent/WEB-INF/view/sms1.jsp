<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div style="">
<span>${msg}</span>
<h3>SMS To Driver</h3>
<div >
<form action="smsdriver" method="Post">
<label>To</label>
<input type="text" name="sendTo" placeholder="Enter Driver Mobile Number" required><br/>
<h6>Customer Details</h6>
<label> Customer Name</label>
<input type="text" name="customerName" required><br/><br/>
<label>Mobile No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<input type="text" name="customerMobileNo" required><br/><br/>
<label>PickUp Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<input type="text" name="pickUpTime" required><br/><br/>
<label>Pick Up location</label>
<input type="text" name="pickUpLocation" required><br/><br/>
<label>Drop location</label>
<input type="text" name="dropLocation" required><br/><br/>
<input type="submit" value="submit">
</form>
</div>
<hr>


<h3>SMS To Customer</h3>
<div>
<form action="smscust" method="Post">
<label>To</label>
<input type="text" name="sendTo" placeholder="Enter Customer Mobile Number" required><br/>
<h5>Driver Details</h5>
<label>Booking ID</label>
<input type="text" name="bookingId" required><br/><br/>
<label>Driver Name</label>
<input type="text" name="driverName" required><br/><br/>
<label>Vehicle reg No</label>
<input type="text" name="vehicleRegNo"  required><br/><br/>
<label>Driver Mobile No</label>
<input type="text" name="driverMobileNo" required><br/><br/>
<input type="submit" value="submit"> 
</form>
</div>
</div>
</body>
</html>