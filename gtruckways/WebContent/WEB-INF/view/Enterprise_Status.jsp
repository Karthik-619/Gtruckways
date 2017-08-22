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
</style> 
</head>

<body >
<div class="navbar-fixed"><!-- Header -->
<nav>
    <div class="nav-wrapper" >
     <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars"></i></a>
    	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a>
    	<span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;color:#fff">Account Manager</span>
<!--    <span style="margin-left:20%;font-size:15px;"> <a href="maptest.jsp"><i class="fa fa-map-marker"></i><b>Status of truck</b></a></span>
 -->     <ul class="side-nav" id="mobile-demo">
     <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
      </ul>
   
    </div>
  </nav>
  </div> <!--./Header -->


<div class="top"></div>
	<div class="stepbar">
		<div class="stepbox"><a href="entAcc" id="enterprisecont"><div class="stepS e-cust"><i class="fa fa-user" style="color:white;font-size:20px;"></i></div><b>Enterprise Contract</b></a></div>
		<div class="stepbox"><a href="eschedule" id="dailyscheduling"><div class="stepS e-daily"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Daily Scheduling</b></a></div>
		<div class="stepbox"><a href="espare" id="sparetruck"><div class="stepS e-spare"><i class="fa fa-truck" style="color:white;font-size:20px;"></i></div><b>Spare Truck</b></a></div>
			<div class="stepbox"><a href="estatus" id="status"><div class="stepS e-status" style="background-color:#3F51B5;"><i class="fa fa-map-marker" style="color:white;font-size:20px;"></i></div><b>Status of Truck</b></a></div>
				<div class="stepbox"><a href="eodo" id="enterprisecont"><div class="stepS e-cust"><i class="fa fa-tachometer" style="color:white;font-size:20px;"></i></div><b>Enterprise Odometer</b></a></div>
			
			<div class="stepbox"><a href="epay" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Details</b></a></div>
			<div class="stepbox"><a href="entbill" id="paymentdetails"><div class="stepS e-payment"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Billng Details</b></a></div>
			<div class="stepbox"><a href="epaydash" id="paymentdashbord"><div class="stepS e-paymentdash"><i class="fa fa-rupee" style="color:white;font-size:20px;"></i></div><b>Payment Dashboard</b></a></div>
	</div>
	<div class="row" id="statusoftruck">

<div class="col s12 l6 m12">
 <fieldset>
  <legend><b>Balance KM</b></legend>
  <!-- Show enterprisename&ID -->
   	
   	<c:choose>
   <c:when test="${not empty balanceinfo && balanceinfo.enterpriseCustomerId!=0}">
   	<div class="right">
   	  <span class="name"><b>Enterprise Name</b>:${balanceinfo.enterpriseName}</span><br>
  <span class="id"><b>Enterprise-ID</b>:GTRENT-${balanceinfo.enterpriseCustomerId}</span>
   	</div>
   	</c:when>
   	</c:choose>
   	<!-- ./Show enterprisename&ID -->
   	
   	<form action="entBal" method="Post">
   	
   	 <div class="input-field col s12 m6 l4" > 
   	 
   	 <select class="browser-default" name="enterpriseName" required>
   	   <option value="" disabled selected>Select EnterpriseName</option>
   	  <c:forEach var="item" items="${EnterPriseNameList}">
     <option>${item.enterpriseName}</option>
   	 </c:forEach>
   	 </select> 

			  </div>
			 <div class="input-field col s12 m12 l4">
	<input type="submit" value="search" class="senter btn">
			  </div>
			  
	</form>
		 <br> <br><br>
		 <!--Balance km of enterprise  -->
	<div>
			<table class="striped">
			<tr>
			<th class="daily">Vehicle type</th>
			<th class="daily">Vehicle RegNo</th>
			<th class="daily">No of Days Required</th>
			<th class="daily">No of Days Completed</th>
			<th class="daily">No Of KM/Month</th>
			<th class="daily">Traveled KM/Month</th>
			<th class="daily">Remaining KM/Month</th>
			</tr>
			<c:forEach var="bal" items="${balanceinfo.vehiclebalStatus}">
			<tr>
			<td class="daily">${bal.vehicleType}</td>
			<td class="daily">${bal.vehicelRegNo}</td>
			<td class="daily">${bal.noOfDays}</td>
			<td class="daily">${bal.noOfDays}</td>
			<td class="daily">${bal.noOfKms}</td>
			<td class="daily">${bal.travelledKm}</td>
			<td class="daily">${bal.remainingKm }</td>
			
			</tr>
			</c:forEach>
			</table><!--./balance km enterprise  -->
	</div>
			
    </fieldset>
</div>
<div class="col s12 l6">
<fieldset>
<legend>Status of Truck</legend>
   <div id="map"></div>
 </fieldset>
 </div>
</div>
<!--script for map  -->
 <script>      
      function initMap(){
    	    // Asynchronously Load the map API 
    	    var script = document.createElement('script');
    	    script.src = "//maps.googleapis.com/maps/api/js?key=AIzaSyBFhu4jaAf4efq2YfG20ypzNNdKvOlG-LI&callback=initialize";
    	    document.body.appendChild(script);
    	}
      
      function initialize() {
    	    var map;
    	    var bounds = new google.maps.LatLngBounds();
    	    var mapOptions = {
    	        mapTypeId: 'roadmap'
    	    };
    	                    
    	    // Display a map on the page
    	    map = new google.maps.Map(document.getElementById("map"), mapOptions);
    	    map.setTilt(45);
    	        
    	    // Multiple Markers
    	   
    	    var markerLat,markerLong;
    	    
    	    markerLat = [
    		  
    	    <c:forEach var="s" items="${balanceinfo.locationStatus}">
    	        <c:out value="${s.currentLat}"/>,
    	    </c:forEach>
    	    ];
    	   
    	    markerLong = [
    		   
    	    	<c:forEach var="s" items="${balanceinfo.locationStatus}">
    	        <c:out value="${s.currentLong}"/>,
    	    </c:forEach>
    	    ];
    	   
    	                        
    	    // Info Window Content
    	    var infoWindowContent = [
    	    	 
    	    	<c:forEach var="s" items="${balanceinfo.locationStatus}">
    	    	  '<b>' + '${s.vehicelRegNo}' + '<p>' + '${s.vehicleType}' + '</b></p>',
    	    </c:forEach>
    	   
    	    	
    	    ];
    	        
    	    // Display multiple markers on a map
    	    var infoWindow = new google.maps.InfoWindow(), marker, i;
    	    var marker;
    	    // Loop through our array of markers & place each one on the map  
    	    for( i = 0; i < markerLat.length; i++ ) {
    	        var position = new google.maps.LatLng(markerLat[i], markerLong[i]);
    	        var image='img/maptruck.png';
    	        bounds.extend(position);
    	        marker = new google.maps.Marker({
    	            position: position,
    	            map: map,
    	            icon:image,	            
    	        });
    	        
    	        // Allow each marker to have an info window    
    	        google.maps.event.addListener(marker, 'click', (function(marker, i) {
    	            return function() {
    	                infoWindow.setContent(infoWindowContent[i]);
    	                infoWindow.open(map, marker);
    	            }
    	        })(marker, i));

    	        // Automatically center the map fitting all markers on the screen
    	        map.fitBounds(bounds);
    	    }
    	    
    	 // Override our map zoom level once our fitBounds function runs (Make sure it only runs once)
    	    var boundsListener = google.maps.event.addListener((map), 'bounds_changed', function(event) {
    	        this.setZoom(12);
    	        google.maps.event.removeListener(boundsListener);
    	    });
    	    
    	}

      // Loop through the results array and place a marker for each
      // set of coordinates.
     /*  window.eqfeed_callback = function(results) {
        for (var i = 0; i < results.features.length; i++) {
          var coords = results.features[i].geometry.coordinates;
          var latLng = new google.maps.LatLng(coords[1],coords[0]);
          var marker = new google.maps.Marker({
            position: latLng,
            map: map
          });
        }
      } */
    </script>
     <script>
     $(document).ready(function(){
    	 initMap();
     })
    </script>
</body>
</html>