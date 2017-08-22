 <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />

	<link rel="stylesheet" href="css/tele.css" />
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<style>
	input:not([type]), input[type=text], input[type=password], input[type=email], input[type=url], input[type=time], input[type=date], input[type=datetime-local], input[type=tel], input[type=number], input[type=search], textarea.materialize-textarea {
    background-color: #eee;
    border: 1px solid black;
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
input[name="P_DateTime"],input[name="P_Source" ],input[name="P_Destination"],input[name="P_TravelDate"],input[name="P_MaterialNAme"],input[name="P_MaterialNAme"],input[name="P_Status"],input[name="PostId"],input[name="transByMob"]
{
  background-color:transparent;
   border: 1px solid transparent;
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
input[name="PostId"],input[name="transByMob"]
{
 
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
nav
{
background-color:#0288d1;
}
fieldset
{
background-color: rgba(0, 137, 236, 0.2);
height:auto;
}
th.head {
    border: 1px solid rgba(0, 137, 236, 0.2);
    text-align:left;
    padding: 5px;
    background:#75caeb;
     
    color:white;
}
td.data{
    border: 1px solid rgba(0, 137, 236, 0.2);
    text-align:left;
    padding: 5px;
 
     
    color:black;
}
#my_id {
    display: none;
}

td {
    padding: 10px 10px;
    padding-top: 1%x;
    padding-right: 0px;
    padding-bottom: 0px;
    padding-left: 0px;
    display: table-cell;
    text-align: left;
    vertical-align: middle;
    border-radius: 2px;
}

	
	</style>
</head>
<body>
<div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
     <a href="#"><img src="img/gtlogo.jpg"  height="60%" width="10%" style="margin-top:15px;"  class="logo" alt="" /></a> 	
      
      <ul class="right hide-on-med-and-down ">
 
       
      </ul>
   
    </div>
  </nav>
  </div>
<div class=" row">
<span class="col offset-l5" style="color: #0e58e4;"><b>Transporter Payment</b></span><br>
<div class="col ss12 l4 push-l4">

<fieldset>
<legend></legend>
<form action="trackpayment" method="POST">
<table class="responsive-table">
<tr>
<td>
FromDate
</td>
<td>
<input  id="fromDate" type="text" name="fromDate" class="validate z-depth-3" placeholder=" Enter From Date"  pattern="(\d{4}-\d{2}-\d{2})" minlength="3" required>
</td>
</tr>
<tr>
<td>
ToDate
</td>
<td>
<input  id="toDate" type="text" name="toDate" class="validate z-depth-3" placeholder="Enter To Date"  pattern="(\d{4}-\d{2}-\d{2})" minlength="3" required>
</td>
</tr>
<tr>
<td>
Transporter Id
</td>
<td>
<input  id="transporterId" type="text" name="transporterId" class="validate z-depth-3" placeholder="Enter Transpoter Id"  pattern="^[0-9]{2,}$" minlength="4" required>
</td>
</tr>
<tr>
<td>
   <input type="submit" value="Submit" class="btn col push-l12" >
</td>
</tr>
</table>
</form>
</fieldset>
</div>
</div>

<div class=" row">
<c:choose>
<c:when test="${not empty postinfo}">


<div class="col s7 l12 m12">
<span class="center col offset-l5" style="color: #0e58e4;"><b>Payment Details</b></span>

<br>
<span class="center col push-s2"><b>From-Date:&nbsp;</b>&nbsp;${trackpayment.fromDate}</span><span class="center col push-s7"><b>To-Date:&nbsp;</b>&nbsp;${trackpayment.toDate}</span>
<div>
<table>
<tr class="row">
<th class="head">Transporter Id</th>
<th class="head">Transporter Name</th>
<th class="head">PostId</th>
<th class="head">Booking&nbsp;Date</th>
<th class="head">Incentive</th>
<th class="head">Deduction</th>
<th class="head">Vehicle Reg No</th>
<th class="head">Vehicle Name</th>
<th class="head">Driver Name</th>
<th class="head">Travel&nbsp;Date</th>
<th class="head">Customer Amount</th>
<th class="head">Transporter Amount</th>
<th class="head">Gtruckways Amount</th>
</tr>
<c:forEach var="post" items="${postinfo}"> 

<tr>
<td class="data">${post.transporter.transporterId}</td>
<td class="data">${post.transporter.transportName}</td>
<td class="data">${post.refPostId}</td>
<td class="data">${post.postDate}</td>

<c:forEach var="i" items="${Incentive}">
 
 <c:choose>
<c:when test="${i.bookId.equals(post.postId)}"> <!-- if postid=inc.postid -->

<td class="data">${i.incAmount}</td>

</c:when>
</c:choose>  

</c:forEach> 

<c:forEach var="d" items="${Deduction}"> 

<c:choose>
<c:when test="${d.bookId.equals(post.postId)}"><!-- if postid=ded.postid -->

<td class="data">${d.amount}</td>

 </c:when>
 </c:choose> 
 
</c:forEach>
<td class="data">${post.vehi.vehicleRegistrationNo}</td>
<td class="data">${post.vehi.vehicleName}</td>
<td class="data">${post.vehi.driverId.driverName}</td>
<td class="data">${post.travelDate}</td>
<td class="data">${post.totalAmount}</td>
<td class="data">${post.transporterAmount}</td>
<td class="data">${post.gtruckwaysAmount}</td>

</tr>

</c:forEach> 
</table>
<div class="row" style="float:right">
<%-- <table class="col l3 s12" style="float:right">
<tr class="row">
<td class="data"></td>
<td class="data"><span>${amt.customerAmount}/-</span></td>
<td class="data"><span>${amt.transporterAmount}/-</span></td>
<td class="data"><span>${amt.gtruckwaysAmount}/-</span></td>
</tr>

</table> --%>

 <p><span class="col pull-s1" ><b>Total</b></span></p>
<p><span class="col pull-s1">Customer Amount:<b>${amt.customerAmount}/-</b></span></p>
<p><span class="col pull-s1">Transporter Amount:<b>${amt.transporterAmount}/-</b></span></p>
<p><span class="col pull-s1">Gtruckways Amount:<b>${amt.gtruckwaysAmount}/-</b></span></p>
</div>  



</div>
</div>
</c:when>
<c:otherwise>
<span>${transPayMsg}</span>

</c:otherwise>
</c:choose>

</div>

</body>
<script>
$("#button1").click(function() 
		{ 
	$("#form1").show(); 
	});

</script>
<script>
	 $(function(){
     $('#fromDate,#toDate').appendDtpicker({
    	 "autodateOnStart": false,
		 "closeOnSelected": true,
		 /* "futureOnly": true, */
			/* "amPmInTimeList": true, */
			"closeButton": true,
			"dateOnly":true
     });
    });
	 
	 </script>
	 <script type="text/javascript" src="js/jquery-dtpicker.js"></script>
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
</html>