<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/local.css" />
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
	 <script type="text/javascript" src="js/createReqObj.js" ></script>
	  <script type="text/javascript" src="js/register.js" ></script>
	  <style>
	
	   .card-content
	  {
	  height:70%;
	  }
	
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 80%;
        width:100%;
        margin: 0;
        padding: 0;
      }
      
    </style>
	</head>
<body>
<div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      
      	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a><span style="font-size:35px;margin-left:32rem;padding-bottom:1rem;color:#fff">Enterprise</span>
      <ul class="right hide-on-med-and-down ">
 
       
      </ul>
   
    </div>
  </nav>
  </div> <!--./ Local Header -->

<div class="row">
<div class="card col s12 m12 l2">

<div class="card-content">

<a href="EnterpriseDashboard.jsp"><img src="img/user.jpg" width="60%"></a>

</div>
<div class="card-content">

<b>GTRENT1001</b>

</div>
<div class="card-content">

<a href="#"><i class="fa fa-truck"></i>&nbsp;&nbsp;Track Truck</a>
</div>
<div class="card-content">

<a href="BalanceKm.jsp"><i class="fa fa-balance-scale"></i>&nbsp;&nbsp;Balance KM</a>
</div>
<div class="card-content">

<a href="#"><i class="fa fa-rupee"></i>&nbsp;&nbsp;Billing Details</a>
</div>

<div class="card-content">

<a href="AccountSettings.jsp"><i class="fa fa-cog"></i>&nbsp;&nbsp;Account Settings</a>
</div>
<div class="card-content">


</div>



</div>
<div class="card col s12 m12 l10">
<div class="card-content ">
              <span class="card-title"><b>Track Truck</b></span>
              
            </div>
<div class="card-action center">
    <div id="map" style="width:100%;height:360px;background:#ffffff">
    </div>
</div>

</div>
</div>
<script>
    $('#test1').click(function(e) {

   
    	if($(this).attr('href')=='#test1'){
    	    var center = map.getCenter();
    	    google.maps.event.trigger(map, "resize");
    	    map.setCenter(center);
    	}
    });
    </script>
    <script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          zoom: 10,
          center: new google.maps.LatLng(12.9538477,77.3507369),
          mapTypeId: 'roadmap'
        });

        var iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
        var icons = {
       
          info: {
            icon: iconBase + 'truck.png'
          }
        };

        function addMarker(feature) {
          var marker = new google.maps.Marker({
            position: feature.position,
            icon: icons[feature.type].icon,
            map: map
          });
        }

        var features = [
          {
            position: new google.maps.LatLng(12.9538477,77.3507369),
            type: 'info'
          }, {
            position: new google.maps.LatLng(12.9706513,77.5152328,14),
            type: 'info'
          }, {
            position: new google.maps.LatLng(12.9756588,77.5726373),
            type: 'info'
          }
        ];

        for (var i = 0, feature; feature = features[i]; i++) {
          addMarker(feature);
        }
      }
    </script>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery-dtpicker.js"></script>
<script type="text/javascript" src="js/materialize.js" ></script>
<script type="text/javascript" src="js/materialize.min.js" ></script> 
<script type="text/javascript" src="js/enterprise.js" ></script> 
   <script  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDmfsnWuRT_lsvnEPJWmoFPPMsIr6N_mus&callback=initMap">
    </script> 
</body>
</html>