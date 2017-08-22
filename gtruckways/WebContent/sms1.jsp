<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<html>
    <head>
        <style>
        
   html,
body
{
  height: 100%;
  width: 100%;
}
 #map_canvas, #map_canvas1{
 width:50%;
 height:400px;
 top:50px;
 }

        </style>
        
    </head>
    <body onload="initialize()">
    <div id="map_canvas2" class="col s12 l6" style="float:left;width:70%;height:100%;"></div>
       <a href="map1.html" target="_blank">map</a>
       <div id="map_canvas" ></div>
       <input type="hidden" value="vijayanagar,bangaluru" id="location"><br>
       <div id="map_canvas1" ></div>
       <input type="hidden" value="chandralayout,bangaluru" id="location1">
        <script>
var geocoder;
var map,map1;
var address = document.getElementById("location").value;
var address1 = document.getElementById("location1").value;
function initialize1() {
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(12.9716, 77.5946);
  var myOptions = {
    zoom: 8,
    center: latlng,
    mapTypeControl: true,
    mapTypeControlOptions: {
      style: google.maps.MapTypeControlStyle.DROPDOWN_MENU
    },
    navigationControl: true,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  var myOptions1 = {
		    zoom: 8,
		    center: latlng,
		    mapTypeControl: true,
		    mapTypeControlOptions: {
		      style: google.maps.MapTypeControlStyle.DROPDOWN_MENU
		    },
		    navigationControl: true,
		    mapTypeId: google.maps.MapTypeId.ROADMAP
		  };
  map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
  map1 = new google.maps.Map(document.getElementById("map_canvas1"), myOptions1);
  if (geocoder) {
    geocoder.geocode({
      'address': address
    }, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        if (status != google.maps.GeocoderStatus.ZERO_RESULTS) {
          map.setCenter(results[0].geometry.location);

          var infowindow = new google.maps.InfoWindow({
            content: '<b>' + address + '</b>',
            size: new google.maps.Size(150, 50)
          });

          var marker = new google.maps.Marker({
            position: results[0].geometry.location,
            map: map,
            title: address
          });
          google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(map, marker);
          });

        } else {
          alert("No results found");
        }
      } else {
        alert("Geocode was not successful for the following reason: " + status);
      }
    });
  }
  
   if (geocoder) {
	    geocoder.geocode({
	      'address': address1
	    }, function(results, status) {
	      if (status == google.maps.GeocoderStatus.OK) {
	        if (status != google.maps.GeocoderStatus.ZERO_RESULTS) {
	          map.setCenter(results[0].geometry.location);

	          var infowindow = new google.maps.InfoWindow({
	            content: '<b>' + address1 + '</b>',
	            size: new google.maps.Size(150, 50)
	          });

	          var marker = new google.maps.Marker({
	            position: results[0].geometry.location,
	            map: map1,
	            title: address
	          });
	          google.maps.event.addListener(marker, 'click', function() {
	            infowindow.open(map1, marker);
	          });

	        } else {
	          alert("No results found");
	        }
	      } else {
	        alert("Geocode was not successful for the following reason: " + status);
	      }
	    });
	  }
} 

    </script>
    <script type="text/javascript">
            var directionDisplay;
            var directionsService = new google.maps.DirectionsService();
            var map;

            function initialize() {
            	
                directionsDisplay = new google.maps.DirectionsRenderer();
             
                var myOptions= {
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
       
       if(markerLat.length<=23){
       for (var j = 1; j <  markerLat.length-1; j++) {
         
           waypts.push({
             location: new google.maps.LatLng(markerLat[j], markerLong[j]),
             stopover: true
           });
         
       }

       } else if(markerLat.length>23 && markerLat.length<=46){
    	   
    	   for (var j = 1; j <  markerLat.length-1; j=j+2) {
    	         
               waypts.push({
                 location: new google.maps.LatLng(markerLat[j], markerLong[j]),
                 stopover: true
               });
             
           }
    	   
       }else{
        	   
        	   for (var j = 1; j <  markerLat.length-1; j=j+3) {
      	         
                   waypts.push({
                     location: new google.maps.LatLng(markerLat[j], markerLong[j]),
                     stopover: true
                   }); 
        	   
        	   
        	   
           }
           
           
    	   
    	   
    	   
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
    window.onload=function(){
    	initialize1();

    }
  
    </script>
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
                
            
                
                map = new google.maps.Map(document.getElementById("map_canvas2"), myOptions);
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
       
       if(markerLat.length<=23){
       for (var j = 1; j <  markerLat.length-1; j++) {
         
           waypts.push({
             location: new google.maps.LatLng(markerLat[j], markerLong[j]),
             stopover: true
           });
         
       }

       } else if(markerLat.length>23 && markerLat.length<=46){
    	   
    	   for (var j = 1; j <  markerLat.length-1; j=j+2) {
    	         
               waypts.push({
                 location: new google.maps.LatLng(markerLat[j], markerLong[j]),
                 stopover: true
               });
             
           }
    	   
       }else{
        	   
        	   for (var j = 1; j <  markerLat.length-1; j=j+3) {
      	         
                   waypts.push({
                     location: new google.maps.LatLng(markerLat[j], markerLong[j]),
                     stopover: true
                   }); 
        	   
        	   
        	   
           }
           
           
    	   
    	   
    	   
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
            <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWK67G2dser4HY7zGwOPHPlvNrORCRSzs">
    </script>
    </body>
</html>

