<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!-- <!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Simple Polylines</title>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>

      // This example creates a 2-pixel-wide red polyline showing the path of William
      // Kingsford Smith's first trans-Pacific flight between Oakland, CA, and
      // Brisbane, Australia.

      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 13,
          center: {lat: 12.9716, lng:77.5946},
          mapTypeId: 'terrain'
        });

        var flightPlanCoordinates = [
            {lat: 12.9588208, lng: 77.5262473},
            {lat: 12.9740315, lng: 77.5440983},
            {lat: 12.9618493, lng: 77.5336254},
            {lat: 12.9570034, lng: 77.5285223}
          ];
        
        var flightPath = new google.maps.Polyline({
          path: flightPlanCoordinates,
          geodesic: true,
          strokeColor: '#FF0000',
          strokeOpacity: 1.0,
          strokeWeight: 2
        });

        flightPath.setMap(map);
      }
      
      
    </script>
 
 
  <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWK67G2dser4HY7zGwOPHPlvNrORCRSzs&callback=initMap">
    </script>
      
  </body>
</html> -->
 --%>
















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
   
<script src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery-dtpicker.js"></script>
<script type="text/javascript" src="js/materialize.js" ></script>
<!-- <script type="text/javascript" src="js/materialize.min.js" ></script> 
 --><script type="text/javascript" src="js/enterprise.js" ></script> 
<script type="text/javascript" src="js/createReqObj.js" ></script>
<style>
    /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 70%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
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
.top {
    background-color: #5FC0D3;
    height: 38px;
}
.stepbar {
    display: -webkit-flex;
    display: flex;
    margin: 0 auto;
    margin-top: -36px;
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
</style> 
</head>

<body>

<div class="navbar-fixed"><!-- Header -->
<nav>
    <div class="nav-wrapper" >
     <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars"></i></a>
    	<a href="homePage"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a>
    	<span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;color:#fff">Driver Managment</span>
   
     <ul class="side-nav" id="mobile-demo">
     <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
      </ul>
   
    </div>
  </nav>
  </div> <!--./Header -->
<div class="top"></div>
	<div class="stepbar">
			<div class="stepbox"><a href="Driver_mgt.jsp" id="driverdet"><div class="stepS e-cust"><i class="fa fa-user" style="color:white;font-size:20px;"></i></div><b>Driver Details</b></a></div>
		<div class="stepbox"><a href="#" id="livetracking"><div class="stepS e-daily" style="background-color:#3F51B5;"><i class="fa fa-calendar" style="color:white;font-size:20px;"></i></div><b>Live Tracking</b></a></div>
	</div>
	
<div class="row" >
  	                         
        <div class="col s12 l6 m12">
 
           <fieldset>
             <legend><b>Vehicle Tracking</b></legend>	
            	<form action="liveTrack" method="GET"> 	
                	 <div class="input-field col s12 m6 l4" >  	 
   	                    <input type="text" name="regNo" required>
   	                     <label>Vehicle No</label>
	                 </div>
	 	              <div class="input-field col s12 m12 l4">
                         <input type="text" id="vehicle_date" name="date" required>
                          <label>&nbsp;<i class="fa fa-calendar"></i>&nbsp; Date</label>
                        </div>
			            <div class="input-field col s12 m12 l4">
	                      <input type="submit" value="search" class="senter btn">
			            </div>	
			            		  
	               </form>
                </fieldset>
   
          </div>
          <br>
          <div class="row col s12 m12 l6 ">
       <div class="right">
        <span><b>Vehicle RegNo</b>:${liveinfo.vehicleRegNo}</span><br>
       <span><b>Total Distance</b>:${liveinfo.distance}&nbsp;km</span><br>
       <span><b>Total Time</b>:${liveinfo.timeMins}&nbsp;mins</span>
       </div>
  </div>
       </div> 
<!-- <div id="map"></div> -->
      <div id="map_canvas" class="col s12 l6" style="float:left;width:100%;height:100%;"></div>
        <div id="control_panel" style="float:right;width:30%;text-align:left;padding-top:20px">
            <div id="directions_panel" style="margin:20px;background-color:#FFEE77;"></div>
        </div> 
 
  
        
     
        
        
         
      
      
       <script>

      // This example creates a 2-pixel-wide red polyline showing the path of William
   

 function initMap() {
    	
        var map = new google.maps.Map(document.getElementById('map_canvas'), {
          zoom: 13,
          center: {lat: 12.9716, lng:77.5946},
          mapTypeId: 'terrain'
        });

      var markerLat,markerLong;    
        
        markerLat = [
	    	
  		  
			<c:forEach var="s" items="${liveinfo.livetrack}">
    			<c:out value="${s.latitude}"/>,
		 		</c:forEach> 
				 ];

	markerLong = [
   
		<c:forEach var="s" items="${liveinfo.livetrack}">
    		<c:out value="${s.longitude}"/>,
			 </c:forEach>

 			];
      
	
	var flightPlanCoordinates=new Array();
    for (var j = 1; j <  markerLat.length-1; j++) {
      
 	  
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

        var marker, i;
        for (i = 0; i <markerLat.length-1; i++) {  
            
        	marker = new google.maps.Marker({
            position: {lat:12.9205554,lng:77.6205833),
            map: map
          });
          
       }
        
        
        
        var flightPath = new google.maps.Polyline({
          path: flightPlanCoordinates,
          geodesic: true,
          strokeColor: '#FFF000',
          strokeOpacity: 2.0,
          strokeWeight: 2
        });

       
        
        

    

  
        
        flightPath.setMap(map);
      }
      
      
    </script>
  <!--   <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap">
    </script> -->
      
      
      
      <!--   <script type="text/javascript">
            var directionDisplay;
            var directionsService = new google.maps.DirectionsService();
            var map;

            function initialize() {
            	
                directionsDisplay = new google.maps.DirectionsRenderer();
             
                var myOptions = {
                		 zoom: 12,
                         center: {lat: 12.9716, lng:77.5946},
                         mapTypeId: 'terrain'
                };
                
            
                
                map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
                directionsDisplay.setMap(map);
                calcRoute();
            }

         function calcRoute() {
             
         var markerLat,markerLong;
	 	 markerLat = [
	    	
		  
	    			<c:forEach var="s" items="${liveinfo.livetrack}">
	        			<c:out value="${s.latitude}"/>,
	   		 		</c:forEach> 
	   				 ];
	   
	    	markerLong = [
		   
	    		<c:forEach var="s" items="${liveinfo.livetrack}">
	        		<c:out value="${s.longitude}"/>,
	   			 </c:forEach>
	    
	     			];
                 
       
       var waypts=new Array();
       for (var j = 1; j <  markerLat.length-1; j++) {
         
    	  
           waypts.push({
             location: new google.maps.LatLng(markerLat[j], markerLong[j]),
             stopover: false
           });
         
       }

    

                
               
                
                var start1=new google.maps.LatLng(markerLat[0], markerLong[0]);
                var dest=new google.maps.LatLng(markerLat[markerLat.length-1],markerLong[markerLat.length-1]); 
                var request = {
                    origin: start1, 
                    destination:dest,
                   waypoints:waypts,
                    optimizeWaypoints: false,
                    travelMode: google.maps.DirectionsTravelMode.WALKING
                };
                directionsService.route(request, function (response, status) {
                
                    if (status == google.maps.DirectionsStatus.OK) {
                        directionsDisplay.setDirections(response);
                        var route = response.routes[0];
                        var summaryPanel = document.getElementById("directions_panel");
                        summaryPanel.innerHTML = "";
                        // For each route, display summary information.
                        for (var i = 0; i < route.legs.length; i++) {
                            var routeSegment = i + 1;
                            summaryPanel.innerHTML += "<b>Route Segment: " + routeSegment + "</b><br />";
                            summaryPanel.innerHTML += route.legs[i].start_address + " to ";
                            summaryPanel.innerHTML += route.legs[i].end_address + "<br />";
                            summaryPanel.innerHTML += route.legs[i].distance.text + "<br /><br />";
                           /*  summaryPanel.innerHTML += route.legs[i].duration.text + "<br /><br />"; */
                        }
                    } else {
                        alert("directions response " + status);
                    }
                });
            }
        </script> -->
        
        
  <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWK67G2dser4HY7zGwOPHPlvNrORCRSzs&callback=initMap">
    </script>   <!--  <script>
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
    </script> -->
</body>
</html> 