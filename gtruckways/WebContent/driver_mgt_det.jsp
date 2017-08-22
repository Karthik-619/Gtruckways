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
<script type="text/javascript" src="js/enterprise.js" ></script> 
<script type="text/javascript" src="js/createReqObj.js" ></script>
<style type="text/css">
		nav
{
background-color:#0288d1;
}
.daily{
text-align:center;
}
</style>
</head>
<body>
 <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      	<img src="img/gtlogo.jpg" height="60%" width="10%"  alt="logo" style="margin-top:15px;" /><span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;"><img src="img/customer-service.png" > Customer Care</span>
      
      <ul class="right hide-on-med-and-down ">
 <li><a href="postID">Go Back</a></li>
       
      </ul>
   
    </div>
  </nav>
  </div> <!--./ Local Header -->      

 <form action="dailyKms" method="Post">
  <div class="row">
  <div class="col s12 m12 l2 input-field">
  <input type="text" id="det_from" name="fromDate">
  <label for="det_from">&nbsp;<i class="fa fa-calendar"></i>&nbsp;From Date</label>
  </div>
    <div class="col s12 m12 l2 input-field">
  <input type="text" id="det_to" name="toDate">
  <label for="det_to">&nbsp;<i class="fa fa-calendar"></i>&nbsp;To Date</label>
  </div>
  <div class="col s12 m12 l2 input-field">
  <input type="text" id="" name="regNo">
  <label for="">&nbsp;Vehicle RegNo</label>
  </div>
  <div class="input-field col s12 m12 l1">
  <input type="submit" value="Search" class="btn">
  </div>
  </div>
  </form>
  <br>
  <div class="row">
 <table>
     <tr>
     <th class="daily">Date of travel</th>
      <th class="daily">Vehicle Registration No</th>
     <th class="daily">No of KM</th>
     <th class="daily">No of Minutes</th>
     </tr>
     
     <c:forEach var="daily" items="${dailyinfo}">  
     <tr>
     <td>${daily.tripDate}</td>
     <td>${daily.regNo}</td>
     <td>${daily.totalKm}&nbsp;Km</td>
     <td>${daily.totalMins}&nbsp;mins</td>
     </tr>
     </c:forEach>
     </table>
  </div>
  
  
  <script>
  $(function(){
    $('#det_from').appendDtpicker({
    "autodateOnStart":false,
  "closeOnSelected": true,
  
  "maxDate":new Date,
  "amPmInTimeList":false,
  "closeButton": true,
  "dateOnly":true,
  "dateFormat":"YYYY-MM-DD",
    });
   });
    $(function(){
        $('#det_to').appendDtpicker({
        "autodateOnStart":false,
      "closeOnSelected": true,
      "futureOnly": false,
      "amPmInTimeList":false,
      "closeButton": true,
      "dateOnly":true,
      "dateFormat":"YYYY-MM-DD",
        });
       });   
    </script>
</body>
</html>