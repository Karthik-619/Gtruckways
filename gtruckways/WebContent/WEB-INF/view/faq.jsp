<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>gTruckWays</title>
 <meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/local.css" />
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	 <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>          
	 <script type="text/javascript" src="js/createReqObj.js" ></script>
	  <script type="text/javascript" src="js/register.js" ></script>
	  <style>
	  h4{
	      margin: 40px 0 0;
    text-transform: uppercase;
    font-weight: 600;
    color: #1253A4;
    font-size: 20px;
	  }
	  body{
	  background-color:#f5f5f5;
	      font-family: proxima-nova;
	      font-size:16px;
	  }
	  p{
	  text-align:justify;
	  }
	  .card-panel {
    transition: box-shadow .25s;
    padding: 20px;
    margin: 0.5rem 0 1rem 0;
    border-radius: 15px;
    background-color: #fff;
}
ul li.term {
    list-style-type: disc;
}
.faqimg{
background-image: url("img/download.gif");
width:100%;
height:180px;
}
.faq{
    color: #fff;
    font-size: 55px;
    font-family: "Open Sans", sans-serif;
    font-weight: normal;
    letter-spacing: -2px;
}
.collapsible-body {
    display: none;
    border-bottom: 1px solid #ddd;
    box-sizing: border-box;
    padding: 20px;
}
.collapsible-header.active{

    background-color: #00a0d4;
    color:white;
}
	  </style>
</head>
<body>

        <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      <a href="#" data-activates="mobile-demo" class="button-collapse"><<i class="fa fa-bars" aria-hidden="true"></i></a>
      	<a href="homePage"><img src="img/Logonew.png" class="hide-on-small-only" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
     
	<!-- Before Login -->
 
     
      <ul class="right hide-on-med-and-down ">
        <li><a href="homePage">HOME</a></li>
         
       
      </ul>
     
          <ul class="side-nav" id="mobile-demo">
       <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
        <!--  <li><a href="home.jsp">HOME</a></li> -->
           <li><a href="home.jsp">HOME</a></li>
        
       
      </ul>
     
          
    </div>
  </nav>
  </div> <!--./ Local Header -->

<!------------ FAQ Heading-------------->

<div class="row">
	<div class="faqimg">
		<br>
		<span  class="faq" style="margin-left: 40rem;margin-top:20px;">FAQs</span>
		<span class=" white-text col offset-l5" style="margin-top:1px;">-Frequently Asked Questions-</span>
																
	</div>
	
</div>
<!----------- End Faq Heading  --------->

<!----------- Faqs details   --------->
<div class="row">
	<div class="container">
  <ul class="collapsible" data-collapsible="accordion">
    <li>
      <div class="collapsible-header active"><i class="fa fa-plus" style="font-size:20px;"></i>Should a customer pay for the return trip?</div>
      <div class="collapsible-body"><span>No, customer needs to pay only from his pick up to drop location.<br>(Customer needs to pay for the return toll if any)</span></div>
    </li>
    <li>
      <div class="collapsible-header"><i class="fa fa-plus" style="font-size:20px;"></i>Will customer be charged for the vehicle till it reaches the pick-up location?</div>
      <div class="collapsible-body"><span>No, the time & the KM&#146;S starts only after the vehicle reaching the pick-up location</span></div>
    </li>
    <li>
      <div class="collapsible-header"><i class="fa fa-plus" style="font-size:20px;"></i>Is the estimated fare displayed is inclusive of all taxes?</div>
      <div class="collapsible-body"><span>Yes, the estimated fare displayed is inclusive of all the taxes.</span></div>
    </li>
     <li>
      <div class="collapsible-header"><i class="fa fa-plus" style="font-size:20px;"></i>Does gTruckways charge for the insurance of goods?</div>
      <div class="collapsible-body"><span>No, gTruckways doesn't charge for the insurance of the goods.</span></div>
    </li>
     <li>
      <div class="collapsible-header"><i class="fa fa-plus" style="font-size:20px;"></i>What is the process in case of damage/theft of goods?</div>
      <div class="collapsible-body"><span>If the customer has taken an insurance for his goods, then the customer should inform to us that he / she wishes to lodge an insurance claim.gTruckways will help to survey process initiated by the Insurer to the customer. </span></div>
    </li>
     <li>
      <div class="collapsible-header"><i class="fa fa-plus" style="font-size:20px;"></i>In case of damage or theft to the customer&#146;s goods or theft during the trip, what is the liability from gTruckways side?</div>
      <div class="collapsible-body"><span>
      gTruckways will pay the amount of either<br>
a) value of goods damaged / theft or<br>
b) ten times of the freight amount whichever is lower.<br>
the above liabilities come into effect only after it is established with a conclusive evidence that it happened due to reckless driving or theft by the driver.  
      
      
      
      
      
      
      
      
      </span></div>
    </li>
  </ul>
   </div>
</div>
<!----------- //Faqs details   --------->










<script type="text/javascript">
$(document).ready(function(){
    $('.collapsible').collapsible();
  });
</script>


</body>
</html>