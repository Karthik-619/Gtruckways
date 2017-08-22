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
       </div>
       <br>
		<div class="col s12 l6">
			<fieldset>
			<legend><b>Track a Truck</b></legend>
			<div id="map"></div>
			</fieldset>
		 </div>







   <div id="map" class="col s12 l6" style="float:left;width:70%;height:100%;"></div>
     <div id="control_panel" style="float:right;width:30%;text-align:left;padding-top:20px">
            <div id="directions_panel" style="margin:20px;background-color:#FFEE77;"></div>
        </div>

<script>
  function initMap() {
    var service = new google.maps.DirectionsService;
    var map = new google.maps.Map(document.getElementById('map'));

    
    
    
  

    
    
    
    
    
    
    
    
    
    
    
    // list of points
    var stations = [
     /*    {lat: 12.958578, lng: 21.2171920, name: 'Station 1'},
        {lat: 12.95883, lng: 21.2176398, name: 'Station 2'},
        {lat: 12.958656, lng: 21.2209088, name: 'Station 3'},
        {lat: 12.95883, lng: 21.2261563, name: 'Station 4'},
        {lat: 12.95866, lng: 21.2294855, name: 'Station 5'},
        {lat: 12.95883, lng: 21.2295512, name: 'Station 6'},
        {lat: 12.958614, lng: 21.2292352, name: 'Station 7'},
        {lat: 12.95883, lng: 21.2246742, name: 'Station 8'},
        {lat: 12.958659, lng: 21.2234792, name: 'Station 9'},
        {lat: 12.95883, lng: 21.2221262, name: 'Station 10'},
        {lat: 12.958614, lng: 21.2271386, name: 'Station 11'},
        {lat: 12.95883, lng: 21.2359527, name: 'Station 12'},
        {lat: 12.958659, lng: 21.2392890, name: 'Station 13'},
        {lat: 12.95883, lng: 21.2398272, name: 'Station 14'},
        {lat: 12.958659, lng: 21.2418410, name: 'Station 15'},
        {lat: 12.95883, lng: 21.2453901, name: 'Station 16'},
        {lat: 12.958659, lng: 21.2525850, name: 'Station 17'},
        {lat: 12.958667, lng: 21.2508423, name: 'Station 18'},
        {lat: 49.0085000, lng: 21.2508000, name: 'Station 19'},
        {lat: 49.0093000, lng: 21.2528000, name: 'Station 20'},
        {lat: 49.0103000, lng: 21.2560000, name: 'Station 21'},
        {lat: 49.0112000, lng: 21.2590000, name: 'Station 22'},
        {lat: 49.0124000, lng: 21.2620000, name: 'Station 23'},
        {lat: 49.0135000, lng: 21.2650000, name: 'Station 24'},
        {lat: 49.0149000, lng: 21.2680000, name: 'Station 25'},
        {lat: 49.0171000, lng: 21.2710000, name: 'Station 26'},
        {lat: 49.0198000, lng: 21.2740000, name: 'Station 27'},
        {lat: 49.0305000, lng: 21.3000000, name: 'Station 28'}, */
   
        
        // ... as many other stations as you need
        
        
        
    		{lat:12.95883,lng:77.535475},
    		{ lat:12.958578,lng:77.526586},
    	     {lat:12.95883,lng:77.535475},
    	     {lat:12.958656,lng:77.526325},
    	     {lat:12.95883,lng:77.535475},
    	  	{lat:12.95866,lng:77.526338},
    	     {lat:12.95883,lng:77.535475},
    	   {lat:12.958614,lng:77.52643},
    	     {lat:12.95883,lng:77.535475},
    	    {lat:12.958659,lng:77.526464},
    	     {lat:12.95883,lng:77.535475},
    	    {lat:12.958614,lng:77.52643},
    	     {lat:12.95883,lng:77.535475},
    	    {lat:12.958659,lng:77.526467},
    	     {lat:12.95883,lng:77.535475},
    	    {lat:12.958659,lng:77.52647},
    	     {lat:12.95883,lng:77.535475},
    	     {lat:12.958659,lng:77.526471},
    	    {lat:12.95883,lng:77.535475},
    	    {lat:12.958667,lng:77.526458},
    ];

    // Zoom and center map automatically by stations (each station will be in visible map area)
    var lngs = stations.map(function(station) { return station.lng; });
    var lats = stations.map(function(station) { return station.lat; });
    map.fitBounds({
        west: Math.min.apply(null, lngs),
        east: Math.max.apply(null, lngs),
        north: Math.min.apply(null, lats),
        south: Math.max.apply(null, lats),
    });

    // Show stations on the map as markers
    for (var i = 0; i < stations.length; i++) {
        new google.maps.Marker({
            position: stations[i],
            map: map
            //title: stations[i].name
        });
    }

    // Divide route to several parts because max stations limit is 25 (23 waypoints + 1 origin + 1 destination)
    for (var i = 0, parts = [], max = 23 - 1; i < stations.length; i = i + max)
        parts.push(stations.slice(i, i + max + 1));

    // Service callback to process service results
    var service_callback = function(response, status) {
        if (status != 'OK') {
            console.log('Directions request failed due to ' + status);
            return;
        }
        var renderer = new google.maps.DirectionsRenderer;
        renderer.setMap(map);
        renderer.setOptions({ suppressMarkers: true, preserveViewport: true });
        renderer.setDirections(response);
        
      
          
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
                var dist=route.legs[i].distance.text;   
                document.getElementById("dist").innerHTML=dist;
                /*  summaryPanel.innerHTML += route.legs[i].duration.text + "<br /><br />"; */
            }
        
           
        
          
    };

    // Send requests to service to get route (for stations count <= 25 only one request will be sent)
    for (var i = 0; i < parts.length; i++) {
        // Waypoints does not include first station (origin) and last station (destination)
        var waypoints = [];
        for (var j = 1; j < parts[i].length - 1; j++)
            waypoints.push({location: parts[i][j], stopover: false});
        // Service options
        var service_options = {
            origin: parts[i][0],
            destination: parts[i][parts[i].length - 1],
            waypoints: waypoints,
            optimizeWaypoints: false,
            travelMode: 'WALKING'
        };
        // Send request
        service.route(service_options, service_callback);
        
        
        
    }
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
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWK67G2dser4HY7zGwOPHPlvNrORCRSzs&callback=initMap">
    </script>
