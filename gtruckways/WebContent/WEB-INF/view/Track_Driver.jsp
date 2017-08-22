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
      <!-- <script src="http://maps.googleapis.com/maps/api/js"></script> -->
<script src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery-dtpicker.js"></script>
<script type="text/javascript" src="js/materialize.js" ></script>
<script type="text/javascript" src="js/materialize.min.js" ></script> 
<!-- <script type="text/javascript" src="js/enterprise.js" ></script>  -->
<!-- <script type="text/javascript" src="js/createReqObj.js" ></script> -->
<style>
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
.data
{
border:none;
}
.row
{
border:none;
}

.gtruck input[type="text"]{
border:none;
border-bottom:1px solid black;
}
 #map {
        height: 400px;
        width: 100%;
       }
       .stepbox{
	-webkit-flex: 1;
    flex: 1;
	display: -webkit-flex;
	display: 		 flex;
	-webkit-align-items: center;
			align-items: center;
	-webkit-justify-content: center;
			justify-content: center;
/*	width: 33.3%;
	display: inline-block;*/
}

.stepsU{
	background-color: #B9DDE5;
}
.top {
    background-color: #fff;
    height: 38px;
}
.stepS {
    display: inline-block;
    width: 70px;
    height: 64px;
    background-color: gray;
    border: #5FC0D3 4px solid;
    border-radius: 100%;
    text-align: center;
    line-height: 54px;
    display: -webkit-flex;
    display: flex;
    -webkit-align-items: center;
    align-items: center;
    -webkit-justify-content: center;
    justify-content: center;
}
.stepbar {
    display: -webkit-flex;
    display: flex;
    margin: 0 auto;
    margin-top: -36px;
}

</style> 
</head>

<body >
<div class="navbar-fixed"><!-- Header -->
<nav>
    <div class="nav-wrapper" >
     <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars"></i></a>
    	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a>
    	<span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;color:#fff">Driver Management</span>
<!--    <span style="margin-left:20%;font-size:15px;"> <a href="maptest.jsp"><i class="fa fa-map-marker"></i><b>Status of truck</b></a></span>
 -->     <ul class="side-nav" id="mobile-demo">
     <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
      </ul>
             <!--logout  -->
    <ul id="" class="right logged-in">
    <li><a href="bookHome"><i class="fa fa-arrow-left"></i>&nbsp;Go Back</a></li>
			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;${TelecallerInfo.telecallerName}</a></li>
			
			  <ul id="dropdown_local" class="dropdown-content">
			 
			    <li><a href="teleLogout" onclick="" id="signout" >Sign out</a></li>
			    
			  </ul>
		</ul>
	  <!--/logout  -->
    </div>
  </nav>
  </div> <!--./Header -->
  
    <!--tabs  -->
      <div class="col s12 l12 m12">
      <ul class="tabs" >
        <li class="tab col s3" style="width:180px;"><a target="_blank" href="bookHome">Bookings</a></li>
        <li class="tab col s3 " style="width:190px;"><a target="_blank" href="custInfo"  target="_blank">Customer Details</a></li>
        <li class="tab col s3" style="width:190px;"><a href="dmForm" class="active">Driver Management</a></li>       
      </ul>
    </div>
    <!-- /tabs -->
    <br>
      <div class="top"></div>
  <div class="stepbar">
		<div class="stepbox"><a href="dmForm" id="driverdet"><div class="stepS e-cust"><i class="fa fa-user" style="color:white;font-size:20px;"></i></div><b>Driver Details</b></a></div>
		<div class="stepbox"><a href="#" id="livetracking"><div class="stepS e-daily" style="background-color:#3F51B5;"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Live Tracking</b></a></div>
		
	</div>
        
    
  	<div class="row" >
        <div class="col s12 l3 m12">
           <fieldset>
             <legend><b>Vehicle Tracking</b></legend>	
            	<form action="liveTrack" method="GET"> 
            	<div class="row col s12 m12 l12">
            	 <div class="input-field" >  	 
   	                    <input type="text" name="regNo" required>
   	                     <label>Vehicle No</label>
	                 </div>
            		 <div class="input-field">
                         <input type="text" id="vehicle_date" name="date" required>
                          <label>&nbsp;<i class="fa fa-calendar"></i>&nbsp; Date</label>
                        </div>
   	                    <div class="input-field ">
	                      <input type="submit" value="search" class="senter btn" style="width:100%;">
			            </div>	<br>
			            <div class="row">
			            	 <span><i class="fa fa-truck">&nbsp;</i><b>Vehicle RegNo</b>:${liveinfo.vehicleRegNo}</span> <br>
			<span><i class="fa fa-road"></i>&nbsp;<b>Total Distance in KM:</b> ${liveinfo.distance}&nbsp;Km</span><br>
			<span><i class="fa fa-clock-o"></i>&nbsp;<b>Total Time</b>:${liveinfo.timeMins}&nbsp;mins</span>  
			</div>
            	</div>	
                	
	 	             
			           		  
	               </form>
                </fieldset>
          </div>
          
          <div class="col s12 l9">
		
			
			<fieldset>
			<legend><b>Track a Truck</b></legend>
			<div id="map"></div>
			</fieldset>
		 </div>
       </div>
       <br>
		






<!-- 
   <div id="map" class="col s12 l6" style="float:left;width:70%;height:100%;"></div>
     <div id="control_panel" style="float:right;width:30%;text-align:left;padding-top:20px">
            <div id="directions_panel" style="margin:20px;background-color:#FFEE77;"></div> -->
        </div>

 <script>
      function initMap() {
    	
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 12,
          center: {lat: 12.9716, lng:77.5946},
          mapTypeId: 'terrain'
        });

        var markerLat,markerLong,currentTime;    
        
        markerLat = [
			<c:forEach var="s" items="${liveinfo.livetrack}">
    			<c:out value="${s.latitude}"/>,</c:forEach> 
				 ];

	markerLong = [
   
		<c:forEach var="s" items="${liveinfo.livetrack}">
    		<c:out value="${s.longitude}"/>, </c:forEach>
 			];
      
	currentTime = [
		   
		<c:forEach var="s" items="${liveinfo.livetrack}">
    		
			'${s.currentTime}',
			 
    		</c:forEach>

 			];
	
	
	
	var flightPlanCoordinates=new Array();
    for (var j = 0; j <  markerLat.length; j++) {
      
 	  
    	flightPlanCoordinates.push({
          lat: markerLat[j],
          lng: markerLong[j]
        });
      
    }
 
        
        
/*        var flightPlanCoordinates = [
          {lat: 12.9588208, lng: 77.5262473},
          {lat: 12.9740315, lng: 77.5440983},
          {lat: 12.9618493, lng: 77.5336254},
          {lat: 12.9570034, lng: 77.5285223}
        ]; */
        var flightPath = new google.maps.Polyline({
          path: flightPlanCoordinates,
          geodesic: true,
          strokeColor: 'red',
          strokeOpacity: 1.0,
          strokeWeight: 5
        });

        
        var marker, i;
        for (i = 0; i <markerLat.length-1; i=i+5) {  
            
        	marker = new google.maps.Marker({
          
       		icon: {
        		       
        		        url: "img/Logomakr_2KZJvA.png",
        		        size: new google.maps.Size(7, 7),
        		        anchor: new google.maps.Point(4, 4)
        		      },
        		
        	position:new google.maps.LatLng(markerLat[i], markerLong[i]) ,
        	title:currentTime[i],
        	map: map
          });
          
        	 var marker1=new google.maps.Marker({
        		 

				 icon: {
					 url: "http://maps.google.com/mapfiles/ms/icons/green-dot.png",
        		       
        		    },
        		 position:new google.maps.LatLng(markerLat[0], markerLong[0]) ,
        		 title:currentTime[0],
        		 map: map
        		 
        	 });
        	
        	 
			var marker2=new google.maps.Marker({
        		 

				 icon: {
       			 	url: "http://maps.google.com/mapfiles/ms/icons/red-dot.png",
       		       
       		    },
        		 position:new google.maps.LatLng(markerLat[markerLat.length-1], markerLong[markerLat.length-1]) ,
        		 title:currentTime[markerLat.length-1],
        		 map: map
        		 
        	 });
        	
       }
        
        
        
        
        
        
        flightPath.setMap(map);
      }
    </script>
  
   <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWK67G2dser4HY7zGwOPHPlvNrORCRSzs&callback=initMap">
    </script>
    <script>
    $(function(){
        $('#vehicle_date').appendDtpicker({
        "autodateOnStart":false,
      "closeOnSelected": true,      
      /* "maxDate":new Date, */
      "amPmInTimeList":false,
      "closeButton": true,
      "dateOnly":true,
      "dateFormat":"YYYY-MM-DD",
        });
       });
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWK67G2dser4HY7zGwOPHPlvNrORCRSzs&callback=initMap">
    </script>
  <script type="text/javascript">
  $('ul.tabs a').on('click', function(e){

	  if($(this).attr("target") ) {
	    window.location = $(this).attr("href");
	  }
	}); 
	
  
  </script>