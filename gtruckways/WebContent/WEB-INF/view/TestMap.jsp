<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
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
<!-- <script type="text/javascript" src="js/materialize.min.js" ></script>  -->
<!-- <script type="text/javascript" src="js/enterprise.js" ></script>  -->
<!-- <script type="text/javascript" src="js/createReqObj.js" ></script> -->
        <style type="text/css"> 
            html { height: 100% }
            body { height: 100%; margin: 0px; padding: 0px }
        </style>
     
    </head>
    <body onload="initialize()">
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
   
    </div>
  </nav>
  </div> <!--./Header -->
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
  
        <div id="map_canvas" class="col s12 l6" style="float:left;width:70%;height:100%;"></div>
        <div id="control_panel" style="float:right;width:30%;text-align:left;padding-top:20px">
            <div id="directions_panel" style="margin:20px;background-color:#FFEE77;"></div>
        </div>
 
        <script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
        </script> 
        <script type="text/javascript">
        </script> 
        
        
           <script type="text/javascript" src="https://maps.google.com/maps/api/js?key=AIzaSyDWK67G2dser4HY7zGwOPHPlvNrORCRSzs&sensor=false"></script>
        <script type="text/javascript">
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
                 
       
       
	    var mappts=new Array();	
	    	
	    var waypts=new Array();
       
	   

	    
       
       for (var j = 1; j <  markerLat.length-1; j=j+2) {
         
    	  
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
    </body>
</html>



































