<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
      function initMap(){
    	    // Asynchronously Load the map API 
    	    var script = document.createElement('script');
    	    script.src = "//maps.googleapis.com/maps/api/js?key=AIzaSyBFhu4jaAf4efq2YfG20ypzNNdKvOlG-LI&sensor=false&callback=initialize";
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
    	    	 
    	    ];
    	        
    	    // Display multiple markers on a map
    	    var infoWindow = new google.maps.InfoWindow(), marker, i;
    	    var marker;
    	    // Loop through our array of markers & place each one on the map  
    	    for( i = 0; i < markerLat.length; i++ ) {
    	        var position = new google.maps.LatLng(markerLat[i], markerLong[i]);
    	        bounds.extend(position);
    	        marker = new google.maps.Marker({
    	            position: position,
    	            map: map    	            
    	        });
    	        
    	        // Allow each marker to have an info window    
    	        google.maps.event.addListener(marker, 'click', (function(marker, i) {
    	            return function() {
    	                infoWindow.setContent(infoWindowContent[i][0]);
    	                infoWindow.open(map, marker);
    	            }
    	        })(marker, i));

    	        // Automatically center the map fitting all markers on the screen
    	        map.fitBounds(bounds);
    	    }
    	    
    	 // Override our map zoom level once our fitBounds function runs (Make sure it only runs once)
    	    var boundsListener = google.maps.event.addListener((map), 'bounds_changed', function(event) {
    	        this.setZoom(14);
    	        google.maps.event.removeListener(boundsListener);
    	    });
    	    
    	}

      // Loop through the results array and place a marker for each
      // set of coordinates.
      window.eqfeed_callback = function(results) {
        for (var i = 0; i < results.features.length; i++) {
          var coords = results.features[i].geometry.coordinates;
          var latLng = new google.maps.LatLng(coords[1],coords[0]);
          var marker = new google.maps.Marker({
            position: latLng,
            map: map
          });
        }
      }
    </script>
     
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBFhu4jaAf4efq2YfG20ypzNNdKvOlG-LI&callback=initMap">  			  
    </script>
    

</body>
</html>