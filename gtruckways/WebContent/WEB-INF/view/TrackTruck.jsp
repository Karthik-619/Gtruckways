<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
 <jsp:include page="localheader.jsp" />
<style>

 #map {
        height: 550px;
        width: 100%;
       }
       	nav {
    background: #1253A4;
}
.card .card-content {
    padding: 10px;
    padding-left:3.4rem;
    border-radius: 0 0 2px 2px;
}
	   .card-content
	  {
	  height:70%;
	  }
	  .collection .collection-item.avatar .circle {
    position: absolute;
    width: 101px;
    height: 63px;
    overflow: hidden;
    left: 15px;
    display: inline-block;
    vertical-align: middle;
}
.collection .collection-item.avatar {
    min-height: 84px;
    padding-left: 13px;
    position: relative;
}
.card.balance{
background-color:#3d4a53;
margin-top:0px;
}
a.ent_dash{
margin-left:-5px;
}
</style> 
</head>

<body >
<!-- <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      
      	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a><span style="font-size:35px;margin-left:32rem;padding-bottom:1rem;color:#fff">Enterprise</span>
      <ul class="right hide-on-med-and-down ">
 
       
      </ul>
   
    </div>
  </nav>
  </div> --> <!--./ Local Header -->



	<div class="row">


 <div class="card col s12 m12 l2 balance">

<div class="card-content">

<a href="entDashBoard"><img src="img/user.png" width="60%"></a>

</div>
<div class="card-content">

<b style="color:white">GTRENT-${enterpriseInfo.enterpriseCustomerId}</b>

</div>
<hr>
<div class="card-content">
<p ><i class="fa fa-truck" style="font-size:20px;color:white;margin-left:25px;"></i></p>
<a href="trackform" style="color:white;" class="ent_dash">&nbsp;&nbsp;Track Truck</a>
</div>
<hr>
<div class="card-content">
<p><i class="fa fa-balance-scale" style="font-size:20px;color:white;margin-left:25px;"></i></p>
<a href="balance" style="color:white;" class="ent_dash">&nbsp;&nbsp;Balance KM</a>
</div>
<hr>
<div class="card-content">
<p><i class="fa fa-rupee" style="font-size:20px;color:white;margin-left:30px;"></i></p>
<a href="#" style="color:white;" class="ent_dash">&nbsp;&nbsp;Billing Details</a>
</div>
<hr>
<div class="card-content">
<p><i class="fa fa-cog" style="font-size:20px;color:white;margin-left:25px;"></i></p>
<a href="accountForm" class="ent_dash" style="color:white;">Account Settings</a>
</div>
<div class="card-content">


</div>
<table height="100">

</table>
</div>
 <c:choose>
 <c:when test="${not empty enterpriseInfo.locationStatus}">
<div class="col s12 l10">
<fieldset>
<legend><b>Status of Truck</b></legend>
   <div id="map"></div>
 </fieldset>
 </div>
 </c:when>
 <c:otherwise>
 
 <span>No Truck is Found</span>
 
 </c:otherwise>
 </c:choose>
</div>
<!--script for map  -->
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
    		   <c:forEach var="s" items="${enterpriseInfo.locationStatus}">
    	        <c:out value="${s.currentLat}"/>,
    	    </c:forEach>
    	    ];
    	   
    	    markerLong = [
    		   <c:forEach var="s" items="${enterpriseInfo.locationStatus}">
    	        <c:out value="${s.currentLong}"/>,
    	    </c:forEach>
    	    ];
    	   
    	                        
    	    // Info Window Content
    	    var infoWindowContent = [
    	    	 
    	    	<c:forEach var="s" items="${enterpriseInfo.locationStatus}">
    	    	  '<b>' + '${s.vehicelRegNo}' + '</b><p><b>' + '${s.vehicleType}' + '</b></p>',
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
      /* window.eqfeed_callback = function(results) {
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
    	/*  if (typeof initMap == 'function') { 
    		 initMap(); 
    	 	} */
     })
    </script>
</body>
</html>