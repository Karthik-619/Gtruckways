<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Local Header -->
    <html>
       
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Online Mini Truck Booking in Bangalore | Tata Ace & Tata 407 </title>   
 <meta charset="UTF-8">
	<title>gTruckWays</title>
	 <!-- SEO -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- meta tag keywords -->
	<meta name="keywords" content="Mini Truck for rent in Bangalore, 407 rentals in Bangalore, House shifting in Bangalore,Tata ace rentals Bangalore, mini trucks in Bangalore, mini truck for hire in bangalore, Truck Service in Bangalore, gTruck Transport, truck rentals in Bangalore, Truck Service in Bangalore, Mini Trucks for shifting in Bangalore" /> 	
    <meta name="description" content="" >
    
 <!-- Open Graph Tags -->
	<meta property="og:title" content="gTruckways"/>
	<meta property="og:type" content="website"/>
	<meta property="og:url" content="https://www.gtruckways.com"/>
	<meta property="og:image" content=""/>
	<meta property="fb:admins" content="365844223786038"/>
	 
<!-- Twitter Card -->
	<meta name="twitter:card" content="summary">
	<meta name="twitter:url" content="https://gtruckways.com">
	<meta name="twitter:title" content="gtruckways - Deliver Your Goods Faster Than Ever">
	<meta name="twitter:image" content="">
		 	

	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/local.css" />
	
	<script type="text/javascript" src="js/local_pricing.js"></script>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<style>

.backgroundimage 
{ 
position: relative; 
top: 0; 
left: 0;
} 
.overlaytruck
{
width:auto; 
position:absolute; 
bottom:1px;
-webkit-animation: mymove 11s infinite;/*  / Safari 4.0 - 8.0 / */
 animation: mymove 11s infinite;
} 
/*  Safari 4.0 - 8.0  */
-webkit-keyframes mymove {
    from {right: -12px;}
    to {right:100%;}
}

@keyframes mymove {
    from {right: 12px;}
    to {right:100%;}
}

.btn {
    height: 35px; 
}
.modal .modal-content {
    padding: 10px;
   
}

.modal .modal-close {
    cursor: pointer;
    font-size: large;
    color: black;
}

 #deletesuccess{
 padding:10px;
 background-color:gray;
 color:white;
 width:40%;
 margin:5px;
 }
 
 
.modal{
   display: none;
    position: fixed;
    left: 0;
    right: 0;
    background-color: #fafafa;
    padding: 0;
    max-height: 90%;
    width: 30%;
    margin: auto;
    overflow-y: auto;
    border-radius: 2px;
    will-change: top, opacity;
}

.user .fa-user,.phone-square .fa-phone-square,.envelope .fa-envelope,.calendar .fa-calendar,.suitcase .fa-suitcase,.map-marker .fa-map-marker,.building-o .fa-building-o,.pencil .fa-pencil,.balance-scale .fa-balance-scale{ 
  position: absolute;
  top: 13px;
  left: 18px;
}
/*App Details Row */
/* .appstore
{
	background-color:#01579b;
	color:#ffffff"
} */
/*App Details Row */
.inputfield
{
	background-color:#01579b;
	color:#ffffff";
	height:1%;
}
.input-field label {
    color: #9e9e9e;
    position: absolute;
    top: 0.45rem;
    left: 0.75rem;
    font-size: 1rem;
    cursor: text;
    transition: .2s ease-out;
}
.btn.apk{
height:30px;
line-height:10px;

}

 	@media ( max-width:603px ){
 #getapp{
width:40%;
   margin-left:2%;
 }
 @media(max-width:603px){
 #msg{
 margin-left:1rem;
 }
 }
 #mobileno{
 width:55%;
 margin-left:9rem;
 }
 #apkbtn{
 width:30%;
 margin-left:8rem;
 }
 .modal-content.getapp{
 background: url("WebContent/img/mobile_device.png")  no-repeat scroll top left;;
    background-color: #cccccc;
    background-repeat:no-repeat;
background-size:100% 200px;
 }
 @media ( max-width:1024px){

  .modal-content.getapp{
 background: url("img/mobile_device1.png")  no-repeat scroll top left;;
    background-color: #cccccc;
    background-repeat:no-repeat;
background-size:50%;
 }
 }

 }.emailphone{
              background-color:#25ae88;
          
            font-size:15px;
          }
          .phone,.email{
              padding:0rem;
          }
          .peoplesay{
           background-image:linear-gradient(rgba(0,0,0,0.19),rgba(0,0,0,0.19)),url(img/road2.jpg);
               
    background-position: center;
    background-size: cover;
          }
          #backgroungimg{
              background-image: url(img/Main-Bg.jpg);
               height:500px;
    background-position: center;
    background-size: cover;
          }
          nav{
            background-color:#1a2f4a;
          }
          #fromtofield{
              background-color: rgba(2, 55, 97, 0.89);
              margin-top: 5rem;
          }
          @media(max-width:603px){
          #fromtofield{
              background-color: rgba(2, 55, 97, 0.89);
              margin-top: 0rem;
          }
          .booktruckmsg{
          margin-left:0rem;
          }
            #booktruck{
            margin-left:0rem;
              font-size: 25px;
          }
          }
          #booktruck{
              font-size: 25px;
          }
          h3 {
    font-size: 2.92rem;
    line-height: 110%;
    margin: 1rem 0 0rem 0;
              color: #fff;
}

        .map-marker input {
 text-indent: 20px;
color:black;
  background: #fcfcfc;
  border: 1px solid #1e4d72;
  border-radius: 0px;
  box-shadow: 0 0 3px #ccc, 0 10px 15px #ebebeb inset;
}
          input:not([type]), input[type=text], input[type=password], input[type=email], input[type=url], input[type=time], input[type=date], input[type=datetime-local], input[type=tel], input[type=number], input[type=search], textarea.materialize-textarea {
    background-color: #eee;
    border: 1px solid black;
    border-radius: 0;
    outline: none;
    height: 2.5rem;
    width: 100%;
    font-size: 1rem;
    margin: 0 0 4px 0;
    padding: 0;
    box-shadow: none;
    box-sizing: content-box;
    transition: all .3s;
}
      
 .truck .fa-truck, .suitcase .fa-suitcase, .male .fa-male {
    position: absolute;
    top: 13px;
    left: 20px;
}         
.truck select,.suitcase select,.male select {

color:black;
  background: #fcfcfc;
  border: 1px solid #1e4d72;
  border-radius: 0px;
  box-shadow: 0 0 3px #ccc, 0 10px 15px #ebebeb inset;
}
    
          #getquote{
    text-decoration: none;
    color:#ffffff;
    background-color:#089de3;
    text-align: center;
    letter-spacing: .2px;
    transition:.2s ease-out; 
    cursor:pointer;
    height:35px;
    width:270px;
    font-size:18px;
    font-family:Franklin Gothic Medium; 
    margin-top:13px;
    /*  margin-left:7.2rem; */
    } 
          #howwework{
              background-color: #1a2f4a;
          }
          html {
    font-family: GillSans, Calibri, Trebuchet, sans-serif;
  }
        
      .pre {

white-space: pre-wrap;
white-space: -moz-pre-wrap;
white-space: -pre-wrap;
white-space: -o-pre-wrap;
word-wrap: break-word;
line-height: 1;   
/*word-break: break-all;*/
white-space: pre;
white-space: pre\9; /* IE7+ */
display: block;
color: #fff;
font-size: 20px;
font-weight: 900;
}
 
          .appstore
{
	width:100%;
	height:auto;
	background:#1a2f4a;
}
.apppic
{
	width:60%;
	height:auto;
	margin-top:40px;
}
.play_store
{
	width:30%;
	height:auto;
	
}
          /* Page footer */
footer.page-footer{
	background:#000000;
}
.page-footer a{
	color: white;
	font-family:Cambria;
}

      .card .card-content {
    padding: 24px;
    border-radius: 0 0 2px 2px;
    background-color: #1a2f4a;
    color: wheat;
}   
 #carousel1 {
	margin:0 auto;
	padding: 0 20px;
	width:100%;
	height:500px;
	overflow:scroll;
	border:2px solid #999;
}

.slider .indicators .indicator-item {
    /* display: inline-block; */
    position: relative;
    cursor: pointer;
    height: 0px;
    width: 0px;
    margin: 0;
    background-color: #e0e0e0;
    transition: background-color .3s;
    /* border-radius: 50%; */
}
element.style {
    margin-top: 3rem;
    height: 340px;
    touch-action: pan-y;
    -webkit-user-drag: none;
    -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
}
@media only screen and (min-width: 993px)
{
.row .col.offset-l4{
    margin-left: 30.3333333333%;
}
}


}
#modal3{
width:24%;
}

.card .card-image img {
    display: block;
    border-radius: 2px 2px 0 0;
    position: relative;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    border: 1px solid#1a2f4a;
    width: 100%;
}

.lean-overlay {
    position: fixed;
    z-index: 999;
    top: -100px;
    left: 0;
    bottom: 0;
    right: 0;
    height: 125%;
    width: 100%;
    background: rgba(0, 0, 0, 0.01);
    display: none;
    will-change: opacity;
}
	</style> 
</head>
<!--body  -->
<body>
<% if(session.getAttribute("postinfo")!= null)
{
session.removeAttribute("postinfo"); 
}
%>
  
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
             

 <div class="row">
    <c:choose> 
 <c:when test="${userinfo.loginStatusCode==1 && userinfo.isActive()}">      
       <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
<a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars" aria-hidden="true"></i></a>
      	<a href="homePage"><img src="img/Logonew.png" alt="gtrucklogo" height="60%" width="10%"class="logo" alt="" /></a>
     <ul id="" class="right logged-in">
   <!--      <li><a href="#modal3" data-position="bottom" data-delay="25" class=" modal-trigger tooltipped"  data-tooltip="Track Order"><i class="material-icons">room</i></a></li> -->
			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;${userinfo.userName} </a></li>
			
			  <ul id='dropdown_local' class='dropdown-content'>
	            <li><a href="login?mobileNo=${userinfo.mobileNo}&password=${userinfo.password}" onclick="" id="" >My Bookings</a></li>
			    <li><a href="logout?mobile=${userinfo.mobileNo}" onclick="" id="signout" >Sign out</a></li>
			    
			  </ul>
		</ul> 
		
	</div>
  </nav>
  </div>	
  
     <!--After Login  -->
 </c:when> 
<c:otherwise> 
  
 
  
          <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars" aria-hidden="true"></i></a>
      	<a href="#"><img src="img/Logonew.png" class="hide-on-small-only" alt="gtrucklogo" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
     
	<!-- Before Login -->
 
     <!-- navigation for home page -->
      <ul class="right hide-on-med-and-down ">
     <li style="padding-right:20px;"><a href="#modal3" class=" modal-trigger" style="font-size:18px;" ><b>TRACK ORDER</b></a></li>
         <li></li>
                <!--  <li><a href="#about">ABOUT US</a></li> -->
      <!--   <li><a href="#service" ></a></li> -->
      <li style="padding-right:20px;"><a href="enterpriseAppForm" style="font-size:18px;"><b>ENTERPRISE</b></a>
        <li style="padding-right:20px;"><a href="#modal4" class="modal-trigger" id="llogin" style="font-size:18px;"><b>SIGN IN</b> </a></li>
        
        <li><a href="http://blog.gtruckways.com" style="font-size:18px;"><b>BLOG</b></a></li>
          <!--       <li><a href="http://blog.gtruckways.com" style="font-size:23px;"><b>+919590603333</b></a></li> -->
        
         <li></li>
      </ul>
      
     <!--Mobile Device Demo  -->
          <ul class="side-nav" id="mobile-demo">
        <li> <img src="img/Logonew.png" class="logo1" alt="gtrucklogo" width="50%" alt="" /></li>
        <li><a href="#modal3" class="modal-trigger"><i class="fa fa-map-marker"></i>&nbsp;TRACK ORDER</a></li>
    
        <li><a href="enterpriseAppForm"><i class="fa fa-building-o" aria-hidden="true"></i>&nbsp;ENTERPRISE</a></li>
            <li><a href="#modal4" class="modal-trigger"><i class="fa fa-sign-in"></i>&nbsp;SIGN IN</a></li>
   <!--      <li><a href="http://blog.gtruckways.com"><i class="fa fa-rss"></i>&nbsp;BLOG</a></li> -->  
      </ul>
     
          <ul class="side-nav" id="mobile-demo">
       <li> <img src="img/Logonew.png" class="logo1"  alt="gtrucklogo" width="50%" alt="" /></li>
        <li><a href="#modal3" class="modal-trigger"><i class="fa fa-map-marker"></i>&nbsp;TRACK ORDER</a></li>
        <li><a href="#modal4" class="modal-trigger"><i class="fa fa-sign-in"></i>&nbsp;LOGIN</a></li>
        <li><a href="enterpriseAppForm"><i class="fa fa-building-o" aria-hidden="true"></i>&nbsp;ENTERPRISE</a></li>
        <li><a href="http://blog.gtruckways.com"><i class="fa fa-rss"></i>&nbsp;BLOG</a></li>         
      </ul>
    </div>
  </nav>
  </div> <!--./ Local Header -->
   </c:otherwise>
</c:choose>	
  </div>
  
  <!--posting form-->
        
        <div class="row" id="backgroungimg">
        
           
            <div class="emailphone col s12 m12 l4 offset-l8 center" style=" padding:5px;padding-left:13px;margin-top:0rem;">
              <!-- <span style="font-size:2rem;"><i class="fa fa-truck"></i>&nbsp;&nbsp;&nbsp;Book A Truck </span><br>
              <span style="font-size:1.5rem;"> Just @199</span><br>
              <a href="offers"  class="btn" style="background:rgb(14, 38, 57);">Click Here For More Details</a> -->
						
                     <a href="#" class="phone white-text" style="font-size:22px;"><i class="fa fa-phone" style="">&nbsp;<b>+919590603333</b></i></a>
                     <a href="mailto:info@gtruckways.com" class="email white-text" style="font-size:22px;"><i class="fa fa-envelope">&nbsp;<b>info@gtruckways.com</b></i></a>
               </div> 
           <div class="col s12 m12 l5 offset-l4" id="fromtofield">
           
              <h3 id="booktruck" class="center" style="font-family:Verdana, Geneva, sans-serif;margin-top:20px;"><b>TRUCK BOOKING @199*</b><span></span></h3>
              <!-- <span style="color:#fff;font-size:14px;margin-left:11rem;" class="center booktruckmsg" id="msg" >We are bringing new level of comfort</span> -->
              <!-- <span style="color:#fff;font-size:14px;margin-left:11rem;" class="center booktruckmsg" id="msg" ><span style="font-size:23px;">Call:<b>+91&nbsp;9590603333</b></span></span> -->
              <div style="font-size:23px;color:#fff" class="center">Call:<b>+91&nbsp;9590603333</b></div>
                <form action="getQuote" method="Post" id="myform" style="margin-top:9px;">
               <div class="row">
                 <div class="col s12 m12 l6 input-field map-marker">
					 <span class="fa fa-map-marker"></span>
					  <input list="from1"  name="fromCity" id="frmarea" placeholder="From" type="text" onfocusout="myFunction()"class="validate" required>
					  <label for="frmarea" data-error="" ></label><p id="h_frm" style="color:red;font-size:13px;"></p>
					 	<datalist id="from1">
				 		</datalist>
               </div>
                     <div class="col s12 m12 l6 input-field map-marker">
				 <span class="fa fa-map-marker"></span>
				 <input list="to1"  name="toCity" id="tooarea"placeholder="To" type="text" class="validate"  onfocusout="myFunction1()" required />
				 <label for="tooarea" data-error="" ></label><p id="h1_frm" style="color:red;font-size:13px;"></p>
				 <datalist id="to1">
			 	</datalist>
           </div>
             </div>
               <div class="row">      
         </div>
             <div class="row">
            <div class="col s12 l6 m12 input-field truck" >
			<span class="fa fa-truck"></span>
		   <select  name="truckType"   class="browser-default"  required="required" style="height:2.5rem;">
        <option value="" disabled selected>Select Vehicle Type</option> 
   	  <c:forEach var="item" items="${VehicleTypeList}">
     <option value="${item.truckId}" >${item.truckName}</option>
   	 </c:forEach>                
               </select>
 			</div>
 			<div class="row">
 			   <div class="col s12 l6 m12 input-field phone-square">
 			   <span class="fa fa-phone-square"></span>
              	 <input   name="mobileNo" id="mobilNo"  placeholder="MobileNo" type="text" pattern="^[789]\d{9}$" maxlength="10"  class="validate" onclick="samecity()" required>
					  <label for="mobilNo" data-error="" ></label>
              </div>
              </div>
            </div>              
               <div class="row">
               <div class="input-field col s12 l12 m12 offset-l3">
                  <input type="submit"  class="btn center " id ="getquote" value="Get Quote"><br>
                  <p class="center"><a href="offers"  target="_blank"class="white-text" style="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*Click Here For More Details</a></p>
                
                </div>               
           </div> 
           </form>
            </div>
          </div>          
        <!--/.Postingform-->        
        <!--How it works-->
          <div class="row">
              <div class="col s12 m12 l12" id="howwework">
                  <h4 class="center white-text" ><b>HOW WE WORK ?</b></h4>
                      <div class="container">
                            <div class="col s12 m12 l3">
                                <img src="img/quote.png" alt="getqoute" width="60%">
    <span class="pre">                            
  Get Quote for your
source and destination
for the selected vehicle
    </span>                        
                              
                               
                              </div>
                              <div class="col s12 m12 l3">
                                <img src="img/book-truck.png" alt="booktruck" width="60%">
    <span class="pre">                            
Book Your Truck Online
    </span> 
                              </div>
                              <div class="col s12 m12 l3">
                                <img src="img/SMS.png" alt="sms/webbased" width="60%">
      <span class="pre">                            
 SMS/Web Based  
Tracking Activated
    </span>                                 
                              </div>
                              <div class="col s12 m12 l3">
                                <img src="img/shift-goods.png" alt="trainedhelpers" width="60%">
                                 
  <span class="pre">                            
Shift Your Goods Safely
   (Trained Helpers)
    </span>                                 
                              </div>
                      </div>
              </div>              
          </div>
          <!--/how we work-->                  
          <!--WHY CHOOSE gTruckways-->
		    <div class="container">
						 
			<h4 style="font-family:'Raleway', 'Open Sans', Arial, sans-serif;padding:15px;font-weight:600" class="center black-text"> WHY CHOOSE GTRUCKWAYS </h4>
			   <div class="row center">			
				<div class="row ">				
					<div class="col s12 l6 m6">						
						<h5 style="font-family:Trebuchet MS; color:#023761;">Technology Driven Solution</h5>
						<p style="font-size:17px;">We provide you a technology driven solution  <br> to move your goods faster and safer.</p>					
					</div>				
					<div class="col s12 l6 m6 center">					
						<img src="img/smartphone%20(1).png" alt="onlinebooking" width="20%">					
					</div>			 
				</div>												
				<div class="row ">				
					<div class="col s12 l6 m6 center">					
							<img src="img/hand-gesture%20(2).png" alt="bookfrommobile" width="20%">					
					</div>					
					<div class="col s12 l6 m6">						
					<!-- 	<h5 style="font-family:Trebuchet MS; color:#023761;">Book from Mobile or Web</h5>
						<p style="font-size:17px;">Just place your order and we will provide you on <br> demand mini trucks to move your goods.</p>						 -->
						<h5 style="font-family:Trebuchet MS; color:#023761;">Cash Less Trips</h5>
						<p style="font-size:17px;">Accepting payments Made easy <br> for every one through <b>Paytm</b>.</p>
					</div>							 
				</div>			 						 
			 <div class="row ">				
					<div class="col s12 l6 m6 ">						
						<h5 style="font-family:Trebuchet MS; color:#023761;">Real Time Tracking & Alerts</h5>
						<p style="font-size:17px;">Get vehicle tracking info via SMS and Email <br>alerts and check the trip status. </p>						
					</div>				
					<div class="col s12 l6 m6 center">					
						<img src="img/tracking%20(1).png" alt="track" width="20%">					
					</div>			 
				</div>			 						 
			 <div class="row ">				
				<div class="col s12 l6 m6 center bounceIn">					
					<img src="img\truckss.png"  width="25%">					
					</div>
					<div class="col s12 l6 m6">
						
						<h5 style="font-family:Trebuchet MS; color:#023761;">Reliable Trucks & Trained Drivers</h5>
						<p style="font-size:15px;">Our Vehicles are thoroughly checked and Drivers <br> are professionally trained by experts.</p>						
					</div>		 
				</div>
			</div> 			 
			 </div>
		 <br>
		 <!--../WHY CHOOSE gTruckways -->
		 					   
         <!--App store information--> 
		<div class="appstore" >
			 <div class="container">
				 <div class="row">
					 <div class="col s12 l6 m12 apppic">
						<img src="img/mobile_app.png" width="45%">	
					 </div>				 
					 <div class="col s12 l6 m12" style="margin-top:30px;">					
						<p class="white-text" style="font-size: 28px;font-weight: 600;color: rgba(0, 0, 0, 0.92); margin-bottom: 5px; display: block;">
                          Book an Gtruckways from the App. </p>
						  <p class="white-text" style="font-size:15px;">Download the app for exclusive deals and ease of booking</p>
						<a href="https://play.google.com/store/apps/details?id=com.cogzytech.truckways" target="_blank">
						<img src="img/playstore.png" class="play_store"></a>
					</div>			   
				 </div>
			 </div>	
		</div>
		 
		  <!--../App store information-->
		  
		  
		  <!--Vehicle Information-->
          <div class="row container">
        <h4 class="center black-text" style="font-family:'Raleway', 'Open Sans', Arial, sans-serif;padding:15px;font-weight:600">VEHICLE INFORMATION</h4>
    <div class="col s12 m6 l6">
      <div class="card z-depth-5">
        <div class="card-image">
          <img src="img/407.jpg" class="circle" >
        
          <!-- <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a> -->
       </div>
        <div class="card-content">
        <p><i class="fa fa-truck"></i>&nbsp;<b style="font-size:20px;">Vehicle Name</b>:&nbsp;<b>Tata 407</b></p>
        <p><i class="fa fa-truck"></i>&nbsp;<b style="font-size:20px;">Vehicle Type</b>:&nbsp;&nbsp;<b>Mini Truck</b></p>
        <p><i class="fa fa-balance-scale" aria-hidden="true"></i>&nbsp;<b style="font-size:20px;">Max.Capacity</b>:&nbsp;<b>2500kg</b></p>
        </div>
      </div>
    </div>
  
         <div class="col s12 m6 l6">
      <div class="card z-depth-5">
        <div class="card-image">
          <img src="img/Tata Aceland.png"  width="100%" height="210px">
        
        <!--   <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a> -->
        </div>
        <div class="card-content">
        <p><i class="fa fa-truck"></i>&nbsp;<b style="font-size:20px;">Vehicle Name</b>:&nbsp;<b>Tata Ace</b></p>
        <p><i class="fa fa-truck"></i>&nbsp;<b style="font-size:20px;">Vehicle Type</b>:&nbsp;&nbsp;<b>Mini Truck</b></p>
        <p><i class="fa fa-balance-scale" aria-hidden="true"></i>&nbsp;<b style="font-size:20px;">Max.Capacity</b>:&nbsp;<b>800kg</b></p>
        </div>
         
      </div>
    
    </div>
  
  <!--           <div class="col s12 m6 l4">
      <div class="card z-depth-5">
        <div class="card-image">
          <img src="img/superace-gallery.jpg"  class="circle" width="100%" height="200px">
        
          <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
        </div>
        <div class="card-content">
        <p><i class="fa fa-truck"></i>&nbsp;<b style="font-size:20px;">Vehicle Name</b>:&nbsp;<b>Tata Super Ace</b></p>
        <p><i class="fa fa-truck"></i>&nbsp;<b style="font-size:20px;">Vehicle Type</b>:&nbsp;&nbsp;<b>Mini Truck</b></p>
        <p><i class="fa fa-balance-scale" aria-hidden="true"></i>&nbsp;<b style="font-size:20px;">Max.Capacity</b>:&nbsp;<b>1250kg</b></p>
        </div>
      
      </div>
    </div> -->
      </div>
          <!--//..Vechicle information--> 
          
         <!--what people say about us  -->
  <div class="slider" style="margin-top:3rem;">
    <ul class="slides peoplesay">
    <li>
        <img src="img/road2.jpg"> <!-- random image -->
        <div class="caption center-align">
         <h3 style="color:#ff9;">What People Say About Us</h3>
          <h5 class="light grey-text text-lighten-3">"gtruckways.com is my Last mile Deliver Partner for office Appliances shifting.
					 
					 We expereience Quick ResponseTime,Good Tracking Sysytem,Most Competitive Rates 
					 
					             and One-Time Delivery safety in gtruckways"</h5>
        </div>
      </li>
      <li>
         <!-- random image -->
        <div class="caption center-align">
          <h3 style="color:#ff9;">What People Say About Us</h3>
          <h5 class="light grey-text text-lighten-3">"gTruckways is always been a reliable last minute truck service to opt of while transporting the good!"
- Mohan C
</h5>
        </div>
      </li>
      
        <li>
         <!-- random image -->
        <div class="caption center-align">
        <h3 style="color:#ff9;">What People Say About Us</h3>
          <h5 class="light grey-text text-lighten-3">"gtruckways.com is my Last mile Deliver Partner for office Appliances shifting.
					 
					 We expereience Quick ResponseTime,Good Tracking Sysytem,Most Competitive Rates 
					 
					             and One-Time Delivery safety in gtruckways"</h5>
        </div>
      </li>
    </ul>
  </div>
      
		  <!--../People say about us  -->
    
     

<div id="modal3" class="modal col s12 l12 m6">
   
  <div class="modal-content ">
    <a href="#" class="fa fa-close modal-action modal-close right"  ></a>
   <h4 class="center mtitle" style="font-size:20px;">Track Order</h4>
       <div class="row" >
             <form action="track" method="Get">
              <div class="input-field col s12 m6 l10 push-l1 ">

				       <input  id="book_id"  type="text" name="postid" class="validate"  required/>
				       <label data-error="" style="color:#0288d1">&nbsp;<i class="fa fa-newspaper-o" aria-hidden="true"></i>&nbsp;Booking Id</label>
					  
					</div>
					
					<div class="row  ">
					 <div class="input-field col s12 m6 l10 push-l1 ">
			
					    <input  name="mobile" type="text" class="validate"   id="t_mobile" pattern="^[789]\d{9}$" maxlength="10" required/>
					    <label style="color:#0288d1">&nbsp;<i class="fa fa-phone"></i>&nbsp;Mobile No</label>
					</div>
					<div class="input-field col s12 m6 l10 offset-l1 " >
			<input type="submit" value="Track"  class="btn" style="width:100%; height:35px;font-size:15px;background-color:#1d4c72;" id="submit"  >

			</div>
		
					</div>
				</form>
         
        </div>
   
  
   

  </div>
  </div>
  				
    <div id="modal4" class="modal">
		<div class="modal-content">

         <a href="#" class="fa fa-close modal-action modal-close right"  ></a>
 
        <div class="row " >
             <form action="login" method="Get" id="lform" >
                <h4 class="center mtitle" style="font-size:20px;">Sign In</h4>
              <div class="input-field col s12 m6 l10 offset-l1 ">
				       <input id="l_mobile"  type="text" name="mobileNo" class="validate"  pattern="^[789]\d{9}$" maxlength="10" required/>
				       <label for="l_mobile" style="color:#0288d1">&nbsp;<i class="fa fa-phone"></i>&nbsp;MobileNo</label>
					   <span id="lmbl" style="color:red;"></span>
					</div>
					
					<div class="row  ">
					 <div class="input-field col s12 m6 l10 offset-l1 ">
				       <input  name="password" id="pwd" type="password" class="validate" required/>
				         <label for="pwd" style="color:#0288d1">&nbsp;<i class="fa fa-lock"></i>&nbsp;Password</label>
					    <span id="forget"><a href="#"  style="color:rgba(255, 0, 0, 0.87)"><u>Forgot password?</u></a></span>
					</div>
					<div class="input-field col s12 m6 l10 center " >
			<input type="submit" value="Sign In" class="btn" style="width:100%;height:35px; font-size:20px;background-color:#1d4c72;margin-left:1.8rem;" id="submit"  >

			</div>
		
					</div>
				</form>
			 <form action="retforgot" method="post" id="fform" class="row" style="display:none" >
                <h5 class="center">  <span> <i class="fa fa-arrow-left" style="font-size:20px;cursor:pointer;" id="llink"></i></span>&nbsp;&nbsp;Forget Password</h5>
			     <div class="input-field col s12 l10 offset-l1">
				  <input id="email_id"  name="email" type="text" class="validate" required /><span id="sp" style="color:#00BFFF"></span> 
				  <label for="email_id" style="top:0.60rem;color:#0288d1;">&nbsp;<i class="fa fa-user" ></i> &nbsp; Enter Your Email</label>
				</div> 
				
				
				<div class="input-field col s12 l10"  >
                  
                    <button id="last_name" type="submit" class="btn get validate" style="margin-left:1.8rem;width:100%;height:35px; font-size:20px;background-color:#1d4c72;">Get Link</button>
				
				</div>    							
			</form>
         
        </div>
      
   
	
		</div>
		</div>	
	<!--  <div id="getapp" class="modal">
		<div class="modal-content" >
 
  <a href="#" class="fa fa-close modal-action modal-close right" id="closeBtn" ></a>
  <br>
	<div class="row">
				<h4 class="center"><b>Get a Vehicle</b></h4>
				<span class="center col s12 m12 l10 offset-l1">@ Just Rs <b>199</b></span>
				<div class="input-field col s12 m12 l10 offset-l2">
						<a href="offers"  class="btn" style="background:rgb(14, 38, 57);">Click Here For More Details</a>
						<p class="center modal-action modal-close" id="closeBtn"><u style="font-size:12px;">NO THANKS</u></p>
				</div>
				</div>
   				</div>
		</div> 
	 -->
		
	
	  <!-- Footer-->
		 <footer class="page-footer">
          <div class="container">
            <div class="row">
           <div class="col s12  m12 l4 white-text">
             <h5 class="">Contact Us</h5>       
		         <p>#1563,3 <sup>rd</sup> Floor,8th cross,<br>opposite BMTC Bus Depot,<br> Chandra Layout,<br>Bangalore - 560040.</p>
               	<p class="concolor" style="font-size:15px;"><span class="concolor" style="font-size:15px;"><span style="font-size:17px;">Email:</span>&nbsp;info@gtruckways.com</span></p>
            
                  
            </div>
            
              <div class="col s12 m12 l4">
               <h5 class="white-text">Terms and Condition</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="privacy">PrivacyPolicy</a></li>
                  <li><a class="grey-text text-lighten-3" href="terms">Terms Of Service</a></li>
                  <li><a class="grey-text text-lighten-3" href="https://play.google.com/store/apps/details?id=com.cogzytech.truckways" target="_blank">Download App</a></li>
                 
                </ul>
              </div>
              
              
              <div class="col s12 m12 l4">
               <h5 class="white-text">City</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Bangalore</a></li>
                 
                </ul>
                 <div class="social">
              	 <h5  class="white-text">Follow Us</h5>
                     <a href="https://www.facebook.com/GTruckways-365844223786038/" target="_blank">  <i class="small fa fa-facebook" ></i></a>
                      &nbsp;&nbsp;&nbsp; <a href="https://twitter.com/gtruckways" target="_blank">  <i class="small fa fa-twitter" ></i></a>
                      
		
                   </div>
                 
              </div>
             
              
             
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2017 gTruckways powered by Cogzy Technologies Pvt Ltd.
      <!--  <a class="grey-text text-lighten-4 right" href="#!">More Links</a>  -->
            </div>
          </div>
        </footer>  
		
		<!-- ../Footer-->

    </body>
    </html>
<script type="text/javascript">
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/591ec1b88028bb7327046b15/default';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script>
     <script>
   /*   $('#getapp').openModal(); */ 
    
      $(document).ready(function(){
    $('.button-collapse').sideNav();
    });
   
     $("#forget").click(function(){
    		$("#fform").show();
    		$("#lform").hide();
    	})
    	$("#llink").click(function(){
    		$("#lform").show();
    		$("#fform").hide();
    	})
    	$("#closeBtn").click(function(){
    		  $("#fform").toggle("slow");
    	      $("#lform").toggle("slow");
    		}); 
    
  
	    $(document).ready(function(){
	        $('.slider').slider({full_width: true});
	      });
	    
	    function samecity(){
	    	   var frmarea=document.getElementById("frmarea");
	    	   var tooarea=document.getElementById("tooarea");
	    	   if((frmarea.value && tooarea.value)){
	    	   if(frmarea.value==tooarea.value){
	    	    
	    	    tooarea.value="";
	    	    tooarea.focus();
	    	    document.getElementById("h_frm").innerHTML="From and To Area can not be same";
	    	    document.getElementById("tooarea").style="border:3px solid red";
	    	    document.getElementById("tooarea").style="border-bottom:none";
	    	    return false;
	    	   }else{
	    	  
	    	    document.getElementById("h_frm").innerHTML="";
	    	    return true;
	    	   }
	    	  }
	    }

	    function myFunction() {
	        var str = document.getElementById("frmarea").value;
	        var str1 = document.getElementById("tooarea").value;
	        var n = str.endsWith("Bengaluru, Karnataka, India");
	       // var n1 = str1.endsWith("Bengaluru, Karnataka, India");
	        
	        if(n==0 ){
	      /*  document.getElementById("h_frm").innerHTML="From and To City can not be same";
  
	       document.getElementById("city").value="";
	     document.getElementById("city").focus(); */
	     frmarea.value="";
	    /*  frmarea.focus(); */
	   
	     document.getElementById("h_frm").innerHTML="Enter areas with in Bengaluru";
	     
	     
	        return false;
	        }
	        else{
	        	document.getElementById("h_frm").innerHTML=" ";
	        }
	    }

	    function myFunction1() {
	      
	        var str1 = document.getElementById("tooarea").value;
	       var n1 = str1.endsWith("Bengaluru, Karnataka, India");
	        
	        if(n1==0 ){
	      /*  document.getElementById("h_frm").innerHTML="From and To City can not be same";

	       document.getElementById("city").value="";
	     document.getElementById("city").focus(); */
	     tooarea.value="";
	    /*  frmarea.focus(); */
	   
	     document.getElementById("h1_frm").innerHTML="Enter areas with in Bengaluru";
	     
	     
	        return false;
	        }
	        else{
	        	document.getElementById("h1_frm").innerHTML=" ";
	        }
	    }
	  </script>
    <script>
 

   
   
    </script>

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=true&libraries=places&key=AIzaSyDmfsnWuRT_lsvnEPJWmoFPPMsIr6N_mus"></script>


<script type="text/javascript">
function initialize() {   
	var defaultBounds = new google.maps.LatLngBounds(
			  new google.maps.LatLng(12.9538477,77.3507369),
			  new google.maps.LatLng(12.9538477,77.3507369));
var options = {
	types: ['geocode'], 
	bounds: defaultBounds,
    componentRestrictions: {country: "in"}
  };
  var input = document.getElementById('frmarea');
  var toarea =document.getElementById('tooarea');
  var autocomplete = new google.maps.places.Autocomplete(input, options);

  var autocomplete = new google.maps.places.Autocomplete(toarea, options);
  //autocomplete.bindTo('bounds', map);
 }
google.maps.event.addDomListener(window, 'load', initialize);
</script>
<!-- <script type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
	setTimeout("noBack()", -1);
</script> -->
<script type="text/javascript">
	
document.getElementById("myform").reset();
	
	$(".modal-close").click(function(){
		   $("#t_mobile,#book_id,#l_mobile,#pwd,#ename,#emobile,#e_email,#address,#e_contname").val("");
		 
		 
		  });
	  $(document).keyup(function(e) {
          if (e.keyCode == 27) { // escape key maps to keycode `27`
             $('#modal3').closeModal();
             $('#modal4').closeModal();
         }
     });
	  
	  $(document).ready(function(){
			// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
			$('.modal-trigger').leanModal({
            dismissible: false
        });
	  });
	  
	  $(document).ready(function(){
		  initall();
			if (typeof initalls == 'function') { 
				initalls(); 
				}
			
		  });
	  $('.dropdown-button').dropdown({
	      inDuration: 300,
	      outDuration: 225,
	      constrain_width: false, // Does not change width of dropdown to that of the activator
	      hover: true, // Activate on hover
	      gutter: 0, // Spacing from edge
	      belowOrigin: false, // Displays dropdown below the button
	      alignment: 'left' // Displays dropdown with edge aligned to the left of button
	    }
	  );
</script>



<script>
/* var div = document.createElement("div");
div.innerHTML = "<!--[if lt IE 9]><i></i><![endif]-->";
var isIeLessThan9 = (div.getElementsByTagName("i").length == 1);
if (isIeLessThan9) {
    alert("WE DON'T LIKE YOUR BROWSER");
} */
if (document.all && !document.addEventListener) {
    alert('To open www.gtruckways.com, upgrade your browser to IE 11');
}
</script>

		
		<script>/* carousel */
	$(document).ready(function(){
      $('.carousel').carousel({
            dist:0,
            shift:0,
            padding:20,

      });

    });
		
	$('.carousel.carousel-slider').carousel({fullWidth: true});
</script>
<script type="text/javascript">
$(function(){
	$('#carousel1').infiniteCarousel({
		displayThumbnailNumbers:1,
		displayThumbnailBackground:0,
		thumbnailWidth:'40px',
		thumbnailHeight:'40px',
		thumbnailFontSize:'1em'
	});
});
$(document).ready(function(){
    $('.slider').slider();
    
  });
      
</script>

    </html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          </html>