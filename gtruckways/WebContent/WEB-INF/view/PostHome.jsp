<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="<%=request.getContextPath()%>/img/logo.png" type="image/gif" sizes="16x16">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/materialize.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css" />
	 <link rel="stylesheet" href="<%=request.getContextPath()%>/css/tele.css" /> 
	<link type="text/css" href="<%=request.getContextPath()%>/css/jquery.simple-dtpicker.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/materialize.js" ></script>
	

	
	
	
		<style>
	/* fieldset {
    border: 1px solid #b1dcfb;
    margin: 0 2px;
    padding: 0.35em 0.625em 0.75em;
    background: rgba(104, 160, 202, 0.55);
} */
		.card .card-action a:not(.btn):not(.btn-large):not(.btn-floating) {
    color: #0089ec;
    margin-right: 20px;
    transition: color .3s ease;
    text-transform: uppercase;
}
	.logo{
	margin-top:1rem ;
}
		nav
{
background-color:#0288d1;
}


/* th.head {
  
    text-align:left;
    padding: 5px;
    background:#75caeb;
     
    color:white;
} */
/* td.data
{
 border: none; 
    text-align:center;
    padding:0px;
    padding-top: 1%x;
    padding-right: 0px;
    padding-bottom: 0px;
    padding-left: 0px;
    display: table-cell;
    text-align: left;
    vertical-align: middle;
   
} */

/* tr.row1:nth-child(odd) {
    background-color: #dddddd;
      text-align:center;
}
tr.row1:nth-child(even) {
    background-color: white;
      text-align:center;
} */
.modal {
    display: none;
    position: fixed;
    left: 0;
    right: 0;
    background-color: #fafafa;
    padding: 0;
    max-height: 70%;
    width: 75%;
    margin: auto;
    overflow-y: auto;
    border-radius: 2px;
    will-change: top, opacity;
}
.truck:hover, .trans:hover {
 text-decoration: underline;
color:#0288d1;
}	
 .tab{
border:1px solid black;
} 
 .tabs{

background-color:rgba(128, 128, 128, 0.36);
}
.tabs .indicator {
    position: absolute;
    bottom: 0;
    height: 2px;
    background-color: black;
    will-change: left, right;
}
.tabs .tab a {
    color: black;
    display: block;
    width: 100%;
    height: 100%;
    text-overflow: ellipsis;
    overflow: hidden;
    transition: color .28s ease;
}
.tab a.active {
    background-color:rgb(117, 202, 235);
border:2px solid black;
color:black; 
  
}
.tabs .tab a:hover, .tabs .tab a.active {

    color: white;
    font-weight:900;
} 
/* td {
    padding: 20px 20px;
    padding-top: 1%x;
    padding-right: 0px;
    padding-bottom: 0px;
  
    display: table-cell;
    text-align: left;
    vertical-align: middle;
    border-radius: 2px;
} */

input:not([type]), input[type=text], input[type=password], input[type=email], input[type=url], input[type=time], input[type=date], input[type=datetime-local], input[type=tel], input[type=number], input[type=search], textarea.materialize-textarea {
    background-color: #eee;
    border: 1px solid black;
    border-radius: 0;
    outline: none;
    height: 2rem;
    width: 100%;
    font-size: 1rem;
    margin: 0 0 0px 0;
    padding: 0;
    box-shadow: none;
    box-sizing: content-box;
    transition: all .3s;
}
 input[name="postDateTime"],input[name="postSource" ],input[name="postDestination"],input[name="postTravelDate"],input[name="postVehicleType"],input[name="postMaterialName"],input[name="P_MaterialNAme"],input[name="postStatus"],input[name="PostId"],input[name="transByMob"]
{
  background-color:transparent;
   border: 1px solid transparent;
    border-radius: 0;
    outline: none;
    height: 2rem;
    width: 100%;
    font-size: 1rem;
    margin: 0 0 0px 0;
    padding: 0;
    box-shadow: none;
    box-sizing: content-box;
    transition: all .3s;
}
 input[name="userName"],input[name="password" ]{
  background-color:transparent;
   border: 1px solid transparent;
      border-bottom: 1px solid black;
    border-radius: 0;
    outline: none;
    height: 2rem;
    width: 100%;
    font-size: 1rem;
    margin: 0 0 0px 0;
    padding: 0;
    box-shadow: none;
    box-sizing: content-box;
    transition: all .3s;
 }

input[name="PostId"],input[name="transByMob"],input[name="userName"],input[name="password" ]
{
 cursor:default;
    border-bottom:1px solid #9e9e9e;
    border-radius: 0;
    outline: none;
    height: 2rem;
    width: 100%;
    font-size: 1rem;
    margin: 0 0 0px 0;
    padding: 0;
    box-shadow: none;
    box-sizing: content-box;
    transition: all .3s;
}
#state_per{
display:none;
}
input:not([type])+label:after, input[type=text]+label:after, input[type=password]+label:after, input[type=email]+label:after, input[type=url]+label:after, input[type=time]+label:after, input[type=date]+label:after, input[type=datetime]+label:after, input[type=datetime-local]+label:after, input[type=tel]+label:after, input[type=number]+label:after, input[type=search]+label:after, textarea.materialize-textarea+label:after {
    display: inline;
    content: "";
    position: relative;
    top: 0px;
    opacity: 0;
    transition: .2s opacity ease-out, .2s color ease-out;
}

 select {
    background-color: transparent;
    width: 92%;
    padding: 5px;
    border: 1px solid #9e9e9e;
    border-radius: 2px;
    margin: 0 0 1px 0;
    height: 1.2rem;
    color: black;
    box-sizing: content-box;
    font-size: 1rem;
    transition: all .3s;
    outline: none;
}

textarea{
border:none;
}
       .upload {
  position: relative;
  color:#01579b;
  font-size: 20px;
}

.upload input {
 text-indent: 20px;
color:black;
  background: #fcfcfc;
  border: 1px solid #aaa;
  border-radius: 5px;
  box-shadow: 0 0 3px #ccc, 0 10px 15px #ebebeb inset;
}


.upload .fa-upload { 
  position: absolute;
  top: 24px;
  left: 20px;
}
roboto {
  font-family: 'Roboto', sans-serif;
  font-weight: bold;
}
.paging-nav {
  text-align: right;
  padding-top: 2px;
}

.paging-nav a {
  margin: auto 1px;
  text-decoration: none;
  display: inline-block;
  padding: 1px 7px;
  background: #91b9e6;
  color: white;
  border-radius: 3px;
}

.paging-nav .selected-page {
  background: #187ed5;
  font-weight: bold;
}

.paging-nav,
#tableData {
  width: 400px;
  margin: 0 auto;
  font-family: Arial, sans-serif;
}

	.collapsible-header {
    display: block;
    cursor: pointer;
    min-height: 3rem;
    line-height: 3rem;
    padding: 0 1rem;
    background-color: #03b6ef;
    border-bottom: 1px solid #ddd;
    color:#fff;
    font-size:20px;
}
.backimage{
background-image: url(img/telecaller3.jpg);
background-repeat:no-repeat; 

}

@-moz-document url-prefix() {
   .back-color{
 height:280px;
   }
  input[type="submit"]{

   margin-left:-10%;
   }
}
	</style>

</head>
<body>

 <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      	<img src="<%=request.getContextPath()%>/img/Logonew.png" height="70%" width="10%"  alt="logo" style="margin-top:15px;" /><span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;"><img src="img/customer-service.png" > Customer Care</span>
  
     <!--logout  -->
    <ul id="" class="right logged-in">
			<c:choose>
			<c:when test="${TelecallerInfo.telecallerActive==0}">
			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;${TelecallerInfo.telecallerName} </a></li>
		
			  <ul id="dropdown_local" class="dropdown-content">
			 
			    <li><a href="<%=request.getContextPath()%>/teleLogout" onclick="" id="signout" >Sign out</a></li>
			    
			  </ul>
			  </c:when>
		</c:choose>	
		</ul>
   
    </div>
  </nav>
  </div> <!--./ Local Header -->
  
  
  <c:choose>
  <c:when test="${TelecallerInfo.telecallerActive!=0}">
  
  
  <div id="backimage" style="background-image:url(img/telecaller3.jpg);background-repeat:no-repeat; background-size: cover ;">
    <br>
<form action="<%=request.getContextPath()%>/teleLogin" method="GET">
 <div class="row"  style="margin-top:5rem;">
        <div class="col s12 m5">
          <div class="card back-color" style="background-color: rgba(0,0,0,.5);">
            <div class="card-content">
              <span class="card-title center-align"  style="color:white;"> Login </span>
              <div class="input-field col s12 l12" style="color:white;">
				  <input id="emp2" type="text" name="userName"  class="validate" >
				  <label for="" data-error=" " style="color:white;top:-0.2rem" ><i class="fa fa-user"></i> &nbsp;User Name</label>
				</div>
				  <div class="input-field col s12" style="color:white;">
				 <input type="password" name="password" id="pass" class="validate" minlength="6" maxlength="30"   required>
				 <input type="hidden" name="telecallerActive" value="0"/>
                <label for="" data-error="Min 6 and Max 30 charact" style="color:white;"  ><i class="fa fa-key"></i>&nbsp; Password</label>
               </div>
			<!-- 	<div class="input-field col s12 l12"> 
                    <a class="waves-effect waves-light modal-trigger" href="#modal3" id="forget" style="color:white;"><u>Forgot password</u></a>
                </div> -->
            </div>
            <p style="color:red;margin-left:40px;font-size:18px;">${error}</p>
              <br>  <br> 
            <div class="card-action" style="margin-left:60%;margin-top:8%;">
           
          <input type="submit" value="login" class="btn " >
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
            </div>
             
          </div>
        </div>
      </div>
      <table height="165"></table>
       </form>       
</div>

  </c:when>
  
  
  
  
  <c:when test="${TelecallerInfo.telecallerActive==0}">
  
  <div class="row">
  
   <div class="col s12 l12 m12">
      <ul class="tabs" >
        <li class="tab col s3" style="width:220px;"><a href="#Bookings">Bookings</a></li>
        <li class="tab col s3" style="width:220px;"><a href="custInfo"  target="_blank">Customer Details</a></li>
        <li class="tab col s3" style="width:220px;"><a   href="#transporter">Transporter</a></li>
                <li class="tab col s3" style="width:220px;"><a  target="_blank" href="dmForm">Driver Management</a></li>     
        <li class="tab col s3" ><a  href="#transreg">Transporter Information</a></li>
          <li class="tab col s3" style="width:220px;"><a href="#enterprise">Enterprise/Potential</a></li>
   
      </ul>
    </div>
    <!-- Bookings -->
     
    <div id="Bookings" class="col l12 s12 m12">
 
  <div class="row col l12 s12 m12">

 <form action="postID" method="GET" >
	<div class="row">
  	<div class="input-field col s12 m6 l6" style="width:150px;">
		  
  	<input type="text" class="validate" id="pd" name="PostId"  placeholder="Booking id" pattern="^[G]{1}[A-Z]{2,3}[0-9]{1,}" required>
			  <label for="pd" class="hide" >Booking id</label>
			  </div>
			<div class=" input-field col s12 m12 l12" style="width:150px;">
					<button type="submit" class="waves-effect waves-white btn right "  id="search"  >search</button>
	 </div>
			
	</div>
	<span style="margin-left:38rem;">${message}</span>
</form> 
			
        
   </div>
   
<div class="row col s12 l12 m12">
<h5 class="center">Active - Non Confirmed Bookings</h5>
 <table class="responsive-table striped bordered" >
              
                    <tr class="">
                      <th class="head">Booking ID</th>
                      <th class="head">Date of travel</th>
                    <th class="head">Source</th>
                    <th class="head">Destination</th>
                    <th class="head">Booking Date & Time</th>
                    <th class="head">Vehicle Type</th>
                    <th class="head">User Name</th>
                    <th class="head">Material Name</th> 
                    <th class="head">Status</th>
                    </tr>
               
              <c:forEach var="pos" items="${PostDetail}">
                
                <c:choose>
    <c:when test="${pos.status.equals('Booking Accepted')}">
               
               
                      <tr class="">
                  
                  <td class="head" > <span><a href="postID?PostId=${pos.bookingId}" class="roboto"><b>${pos.bookingId}</b></a></span></td>
                   <td class="head"><input  name="postTravelDate"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.travelDate}" readonly/></td>
                    <td class="head"><textarea  name="postSource"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.fromCity}" readonly>${pos.fromCity}</textarea></td>
                    <td class="head"><textarea  name="postDestination"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.toCity}" readonly>${pos.toCity}</textarea></td>
                                       <td class="data"><input  name="postDateTime"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.postDate}" readonly/></td>
                    <td class="head"><input  name="postVehicleType"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.infoTruck.truckName}" readonly/></td>
                      <td class="head"><input  name="postMaterialName"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.user.userName}" readonly/></td>
                    <td class="head"><input  name="postMaterialName"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.material}" readonly/></td>
                     
                    <td class="head"><input  name="postStatus"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.status}" readonly/></td>
                    </tr> 
                 
        
           </c:when>
    </c:choose>
            </c:forEach>
            
     </table>
     </div>
   
<div class="row col s12 l12 m12">
<h5 class="center">Active Bookings</h5>
 <table class="responsive-table striped bordered" >
             
                    <tr class="">
                      <th class="head">Booking ID</th>
                       <th class="head">Date of travel</th>
                    <th class="head">Source</th>
                    <th class="head">Destination</th>
                   <th class="head">Booking Date & Time</th>
                    <th class="head">Vehicle Type</th>
                      <th class="head">User Name</th>
                    <th class="head">Material Name</th> 
                    <th class="head">Status</th>
                    </tr>
                
              <c:forEach var="pos" items="${PostDetail}">
                
                <c:choose>
    <c:when test="${pos.status.equals('Customer Confirmed')|| pos.status.equals('Vehicle Arranged')||pos.status.equals('Loading Completed') ||pos.status.equals('Source Reached') ||pos.status.equals('Destination Reached') || pos.status.equals('Unloading Finished')||pos.status.equals('Trip Finished')}">
               
             
                      <tr class="">
                  
                  <td class="head"> <span><a href="postID?PostId=${pos.bookingId}" class="roboto"><b>${pos.bookingId}</b></a></span></td>
                  <td class="head"><input  name="postTravelDate"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.travelDate}" readonly/></td>
                    <td class="head"><textarea  name="postSource"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.fromCity}" readonly>${pos.fromCity}</textarea></td>
                    <td class="head"><textarea  name="postDestination"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.toCity}" readonly>${pos.toCity}</textarea></td>
                     <td class="head"><input  name="postDateTime"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.postDate}" readonly/></td>
                    <td class="head"><input  name="postVehicleType"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.infoTruck.truckName}" readonly/></td>
                      <td class="head"><input  name="postMaterialName"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.user.userName}" readonly/></td>
                    <td class="head"><input  name="postMaterialName"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.material}" readonly/></td>
                    <td class="head"><input  name="postStatus"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.status}" readonly/></td>
                    </tr> 
                 
          
           </c:when>
    </c:choose>
            </c:forEach>
            
     </table>
     </div>
      <div class="row col s12 l12 m12 ">
 
  
 </div>
     <div class="row col s12 l12 m12 ">
         
     <ul class="collapsible" data-collapsible="accordion">
    <li>
      <div class="collapsible-header">Completed/Canceled <i class="fa fa-arrow-circle-down right" aria-hidden="true"></i></div>
      <div class="collapsible-body">
      <br>
    <table class="responsive-table striped bordered" >
    			
	                  	<tr class="">
	                 		 	<th class="head">Booking ID</th>
	                 		 	 <th class="head">Date of travel</th>
				                <th class="head">Source</th>
				                <th class="head">Destination</th>
				               <th class="head">Booking Date & Time</th>
				                <th class="head">Vehicle Type</th>
				                    <th class="head">User Name</th>
				                <th class="head">Material Name</th> 
				                <th class="head">Status</th>
	                  	</tr>
               
               <c:forEach var="pos" items="${PostDetail}">   
               <c:choose>
				<c:when test="${pos.status.equals('Canceled') || pos.status.equals('Completed')}">
               
               
           
                  		  <tr class="">
                 
				              <td class="head"> <span><a href="postID?PostId=${pos.bookingId}"><b>${pos.bookingId}</b></a></span></td>
				               <td class="head"><input  name="postTravelDate"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.travelDate}" readonly/></td>
				                <td class="head"><textarea  name="postSource"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.fromCity}" readonly>${pos.fromCity}</textarea></td>
				                <td class="head"><textarea  name="postDestination"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.toCity}" readonly>${pos.toCity}</textarea></td>
				                <td class="head"><input  name="postDateTime"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.postDate}" readonly/></td>				                
				                <td class="head"><input  name="postVehicleType"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.infoTruck.truckName}" readonly/></td>
				                   <td class="head"><input  name="postMaterialName"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.user.userName}" readonly/></td>
				                <td class="head"><input  name="postMaterialName"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.material}" readonly/></td>
				                <td class="head"><input  name="postStatus"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.status}" readonly/></td>
                 		 </tr> 
                 
                 
                 
                 
                 
                 
                 
         		
         		</c:when>
				</c:choose>
          		</c:forEach> 
          		</table> 
      
      </div>
    </li>
   
  </ul>
        
   <%--   <h5 class="center">Completed/Canceled</h5>
     <table class="responsive-table striped bordered" >
    			
	                  	<tr class="">
	                 		 	<th class="head">Booking ID</th>
	                 		 	 <th class="head">Date of travel</th>
				                <th class="head">Source</th>
				                <th class="head">Destination</th>
				               <th class="head">Booking Date & Time</th>
				                <th class="head">Vehicle Type</th>
				                    <th class="head">User Name</th>
				                <th class="head">Material Name</th> 
				                <th class="head">Status</th>
	                  	</tr>
               
               <c:forEach var="pos" items="${PostDetail}">   
               <c:choose>
				<c:when test="${pos.status.equals('Canceled') || pos.status.equals('Completed')}">
               
               
           
                  		  <tr class="">
                 
				              <td class="head"> <span><a href="postID?PostId=${pos.refPostId}"><b>${pos.refPostId}</b></a></span></td>
				               <td class="head"><input  name="postTravelDate"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.travelDate}" readonly/></td>
				                <td class="head"><textarea  name="postSource"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.fromCity}" readonly>${pos.fromCity}</textarea></td>
				                <td class="head"><textarea  name="postDestination"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.toCity}" readonly>${pos.toCity}</textarea></td>
				                <td class="head"><input  name="postDateTime"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.postDate}" readonly/></td>				                
				                <td class="head"><input  name="postVehicleType"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.truckId.truckName}" readonly/></td>
				                   <td class="head"><input  name="postMaterialName"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.user.userName}" readonly/></td>
				                <td class="head"><input  name="postMaterialName"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.material}" readonly/></td>
				                <td class="head"><input  name="postStatus"  style="border-bottom:1px solid transparent;text-align:center" value="${pos.status}" readonly/></td>
                 		 </tr> 
                 
                 
                 
                 
                 
                 
                 
         		
         		</c:when>
				</c:choose>
          		</c:forEach> 
          		</table>   --%>
 </div>




    
    </div>
    <!--/Bookings end  -->
    
    <!-- TransporterReg-->
  <div id="transporter" class="col s12 l12">
  <br>
  <span style="margin-left:15rem">${transMobMsg}</span>


<!--  <div class="card-content">

<form action="transMob" method="Post" target="_blank">
	<div class="row">
  	<div class="input-field col s12 m6 l6" style="width:150px;">
		  
  	<input type="text" class="validate" id="pd" name="transByMob"  placeholder="Transporter Mobile" required>
			  </div>
			<div class=" input-field col s12 m12 l12" style="width:150px;">
					<button type="submit" class="waves-effect waves-white btn right "  id="search"  >search</button>
					
					
	</div>
	
	
	</div>
</form> 
			
        
   </div> -->

<div class="row">
<div class="col s12 l10 m6 offset-l1">
<table class="responsive-table striped bordered">

		<tr class="">
				<th class="head">Transporter Id</th>
				<th class="head">Transporter Name</th>
				<th class="head">Mobile No</th>
				<th class="head">Contact Person</th>
				<th class="head">Address</th>
				<th class="head">Details</th>
				
		</tr>

	<c:forEach var="tr" items="${listTrans}">
	

	
		<tr class="">
		
				<td class="head" style="font-size:13px;">${tr.transporterId}</td>
				<td class="head" style="font-size:13px;">${tr.transporterName}</td>
				<td class="head" style="font-size:13px;">${tr.mobileNo}</td>
				<td  class="head" style="font-size:13px;">${tr.contactPersonName}</td> 
				<td class="head" style="font-size:13px;"><textarea readonly>${tr.address}</textarea></td>
				<td class="head" style="font-size:13px;"><a href="transDetails?transById=${tr.transporterId}" target="_blank"><i class="fa fa-user"></i>&nbsp;&nbsp;View</a></td>
				
		</tr>
		

	
	</c:forEach>
</table>

</div>

</div>

</div>
<!-- /Trannsporterreg end -->
       
 <!-- Transporter/Vehicle Register -->      
   
 <div id="transreg" class="col s12">

    <div class="col s12 l12 m12 input-field">
     <span>${truckMsg}</span>
     <br>
     <input class="with-gap" name="LoadUnload" value="Unloading Finished" type="radio" id="test4" required checked />
			      <label for="test4">Transporter Registration</label>
			      <input class="with-gap" name="LoadUnload" value="Unloading Finished" type="radio" id="test5" required />
			      <label for="test5">Vehicle/Driver Registration</label>
    </div>

     

<div class="col l12 s12 m12" id="personal">

<br>

	
	<div class=" row col s12 l12 m12">
<form action="transReg" method="Post">
<fieldset>
<!-- <span style="color:red;">*All fields are mandatory</span> -->
<legend></legend>
	
	<div class=" row col s12 l12 m12">
	
	<div class="col s12 l6 m12">
	<h5 style="color: #0e58e4;" class="center">Personal Information</h5>
	
	<table>
			<tr>
					<td>
						<b>Transport Name<Span style="color:red">*</Span></b>
					</td>
					<td>
					  	<input  id="tr_name" type="text" name="transportName" class="validate z-depth-3"   pattern="^[a-zA-Z-_\s'.]{1,}$" maxlength="45" required>
						<label for="tr_name" data-error="Invalid Name"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>Contact Person<Span style="color:red">*</Span></b>
					</td>
					<td>
					  	<input  id="tr_name" type="text" name="contactName" class="validate z-depth-3"   maxlength="45"  pattern="^[a-zA-Z-_\s'.]{1,}$" required>
						<label for="tr_name" data-error="Invalid Name"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>Mobile&nbsp;No<Span style="color:red">*</Span></b>
					</td>
					
					<td>
					  	<input  id="tr_mobile" type="text" name="transportMobileNo" class="validate"   pattern="^[789]\d{9}$" maxlength="10" class="validate" required>
								<label for="tr_mobile" data-error="Invalid Num"></label>
					</td>
					</tr>
					
					<tr>
					<td>
						<b>Address<Span style="color:red">*</Span></b>
					</td>
					<td>
					  	<textarea id="address" type="text" name="transportAddress" class="validate"  maxlength="150" style="border:1px solid black;" required></textarea>
								<label for="address"></label>
					</td>
					</tr>
					
					<tr>
					<td>
						<b>Email-Id</b>
					</td>
					<td>
					
				    	<input class="validate" id="tr_email" name="transportEmail" type="text" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})">
								<label for="tr_email" data-error="InvalidName"></label>
					  
					</td>
			
			</tr>
			<tr>
					<td>
						<b>PAN card<Span style="color:red">*</Span></b>
					</td>
					<td>
<input  id="pan_no" type="text" name="transportPan" class="validate z-depth-3" placeholder="Enter Pancard No"   pattern="^[A-Z]{5}[0-9]{4}[A-Z]{1}$" maxlength="10" required>
	  <label for="pan_no" data-error="EX:XUTGH1234F"></label>						
					</td>
					</tr>
					<tr>
					<td>
					<b>Adhar No</b>
										</td>
					<td>
					
	  <input  id="text1" type="text" name="transportAdhar" class="form-control validate" placeholder="Enter Adhar No"  pattern="^[0-9]{12}" maxlength="12" >
	  <label for="text1" data-error="Ex:234567891234"></label>
					</td>
					</tr>
					<!-- <tr>
					 <td>
					 	<span><b>Owner&nbsp;Photo</b></span>
					</td>
				 <td class="file-field input-field upload"  name="myfile" >
     
      <input type="file" id="myFile"  name="myfile" >
      <i class="fa fa-upload" aria-hidden="true"></i>
         <input class="file-path validate" name="myfile" type="text" placeholder="UploadPhoto">
          </td> 
				      </tr> -->
				     <!--  <td>
					<b>Cancel Cheque</b>
					</td>
					<td class="file-field input-field">
					 <input type="file" id="myFile" name="myfile">
				    <input class="file-path validate" type="text" placeholder="Upload Scan Copy">
					  
					</td> -->
					
	<!-- <tr>
	<td>
	<b>Bank Code</b>
	</td>
	<td>  <input  id="tr_name" type="text" name="pancard" class="validate z-depth-3" placeholder="Enter Bank Code"   pattern="^[0-9]{6}$"  required></td>
	</tr>
	 -->
	
	
		</table><br>
		
	</div>
	<!-- ./Personal Information -->
	<div class="col offset-l1">
	<input class="with-gap" name="transporterActive" value="1" type="radio" id="test6" required  />
			      <label for="test6">Active</label>
			      <input class="with-gap" name="transporterActive" value="0" type="radio" id="test7"required  checked/>
			      <label for="test7">Non Active</label>
	</div>
     
 
  
  
      <div class="col  s12 l6 m12 bankdetails" style="display:none;">
	
	<legend style="color:#55a5de">
		
	</legend>
	<h5 style="color: #0e58e4;" class="center">Bank Details</h5>
	<table >
			<tr>
					<td>
						<b>Account&nbsp;Holder</b>
					</td>
					<td>
					 	 <input  id="ac_name" type="text" name="accHolderName" class="validate z-depth-3"  pattern="^[a-zA-Z-_\s'.]{1,}$" minlength="3" maxlength="45" placeholder="Enter Name">
	 <label for="ac_name" data-error="Invalid input"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>IFSC&nbsp;Code</b>
					</td>
					<td>
					 	 <input  id="ifsc" type="text" name="ifscCode" class="validate z-depth-3" placeholder=":Ex:ABCD0112367"  pattern="[A-Z|a-z]{4}[0][A-Z|a-z|0-9]{6}$" maxlength="11" >
	 <label for="ifsc" data-error="Invalid no"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>Account&nbsp;No</b>
					</td>
					<td>
					  <input  id="ac_num" type="text" name="accNumber" class="validate z-depth-3"   pattern="^([0-9]{10,})$" >
	 <label for="ac_num" data-error="Invalid num"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>Bank&nbsp;Name</b>
					</td>
					<td>
					 		 <input  id="bank_name" type="text" name="bankName" class="validate z-depth-3" pattern="^[a-zA-Z][a-zA-Z0-9-_\s'.]{1,}$" maxlength="45" >
	 <label for="bank_name" data-error="Invalid Name"></label>

					</td>
			</tr>
			<tr>
			
					<td>
						<b>Branch</b>
					</td>
					<td>
						<input  id="branch" type="text" name="bankBranch" class="validate z-depth-3"   pattern="^[a-zA-Z][a-zA-Z0-9-_\s'.]{1,}$" maxlength="45">
	 <label for="branch" data-error="Invalid Input"></label>
					</td>
			</tr>
			<tr>
					<td>
						<b>Cheque No</b>
					</td>
					<td>
					 	 <input  id="tr_name" type="text" name="transportCheque" class="validate z-depth-3" placeholder="Enter cheque No"   pattern="^[0-9]{6,}$"  minlength="6" maxlength="9" >
	  <label for="tr_name" data-error="Invalid num"></label>
					</td>
			
			
			</tr>
			<tr>
					<td></td>
			</tr>
	</table>


		
	</div>
     
      
  
	
 <input type="submit" value="submit" class="btn col offset-l6">

</div>

</fieldset>
</form>

</div>
<!-- <input type="submit" class="btn col offset-l6"> -->


</div>

 

<!-- VehicleDetails -->
  <div class="col s12 l12 m12" id="vehicle" style="display:none;">
 <br>

 <form action="vehicleReg" method="post">
<br>
<fieldset>
<!--  <span style="color:red;margin-left:-12rem;">*All fields are mandatory except <u>Driver Mail-ID</u></span>
 --><span><h5 class="col push-s3" style="color: #0e58e4;float:left">Vehicle Details</h5></span><span><h5 class="col pull-s1"style="color: #0e58e4;float:right">Driver Details</h5></span>
<legend></legend>
 

 <div class=" row col s12 l12 m12">
	
	<!-- Rc Details -->
	<div class="col  s12 l4 m12">
	<fieldset>
	
	<legend style="color:#ee6e73">
	<b>RC Details</b>
	</legend>
	<table>
	
			<tr>
					<td>
						<b>Transporter&nbsp;Id<Span style="color:red">*</Span></b>
					</td>
					<td>
					 		 <input  id="tranId" type="text" name="transportID" class="validate z-depth-3" required>
	 						<label for="tranId" data-error="Enter Transporter Id"></label>
					</td>
			</tr>
			<tr>
					<td>
						<b>Vehicle&nbsp;No<Span style="color:red">*</Span></b>
					</td>
					<td>
					 		 <input  id="vehicle_no" type="text" name="vehicleNum" class="validate z-depth-3" placeholder="Ex:KA08WE1234"  pattern="[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4,}" required>
	 						<label for="vehicle_no" data-error="Ex:KA08WE1234"></label>
					</td>
			</tr>
			<tr>
					<td>
						<b>User Type<Span style="color:red">*</Span></b>
					</td>
					<td>
					 		
					 	<select name="userType" class="form-control browser-default" required>
					 	<option value="Enterprise">Enterprise</option>
					 	<option value="Individual">Individual</option>
					 	<option value="Spare">Enterprise Spare Truck</option>
				
					 	</select>
					</td>
			</tr>
			<tr>
					<td>
						<b>Vehicle&nbsp;Reg&nbsp;Date<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	 <input  id="date_foo" type="text" name="vehRegDate" class="validate z-depth-3"  pattern="(\d{4}-\d{2}-\d{2})" required>
		 				<label for="date_foo" data-error="Invalid Date"></label>
					 
					</td>
			</tr>
			<tr>
					<td>
						<b>Reg&nbsp;Valid&nbsp;Till&nbsp;Date<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	 <input  id="rvtdate" type="text" name="regValidTillDate" class="validate z-depth-3" pattern="(\d{4}-\d{2}-\d{2})" required>
	 					<label for="rvdate" data-error="Invalid Date"></label>
					</td>
			</tr>
			<tr>
					<td>
						<b>Engine&nbsp;no<Span style="color:red">*</Span></b>
					</td>
					
				
					<td>
					 	 <input  id="engin_no" type="text" name="engineNum" class="validate z-depth-3"   required>
	 					<label for="engin_no" data-error="Invalid Input"></label>
					</td>
			</tr>
	
			<tr>
			
			</tr>
	
			<tr>
					<td>
						<b>Chassis&nbsp;No<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	 <input  id="chassis_no" type="text" name="chassisNum" class="validate z-depth-3"     required>
						 <label for="chassis_no" data-error="Invalid Input"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>FC&nbsp;No</b>
					</td>
					<td>
 							<input  id="fc_no" type="text" name="FCNum" class="validate z-depth-3" >
	 						<label for="fc_no" data-error="Invalid Input"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>FC&nbsp;Valid&nbsp;Till&nbsp;Date</b>
					</td>
					
					<td>
					 	<input  id="fvtdate" type="text" name="FCValidTillDate" class="validate z-depth-3" pattern="(\d{4}-\d{2}-\d{2})" >
						<label for="fvtdate" data-error="Invalid Date"></label>
					</td>
			</tr>
	
	

	</table>
	</fieldset>
		<fieldset>
	<legend style="color:#ee6e73">
	<b>Physical Specification</b>
	</legend>

	<table>
			<tr>
					<td>
						<b>Type Of Body<Span style="color:red">*</Span></b>
					</td>
					<td>
					
					 	<select name="typeOfBody" class="form-control browser-default">
					 	<option value="open">Open</option>
					 	<option value="closed">Closed</option>
					 	<option value="withdoor">With Door</option>
					 	<option value="withoutdoor">Without Door</option>
					 	</select>
					</td>
					</tr>
					<tr>
					<td>
						<b>Dimension<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	 <input  id="dimension" type="text" name="dimension" class="validate" placeholder="length*breadth*height"  pattern="[0-9.]{1,}[*]{1}[0-9.]{1,}[*][0-9.]{1,}" required>
						<label for="dimension" data-error="Invalid Input"></label>
					</td>
			</tr>
	
	
	
	</table>
	</fieldset>
	<fieldset>
	<legend style="color:#ee6e73">
	<b>PUCC Details</b>
	</legend>
	<table>
			<tr>
					<td>
						<b>PUCC Number &nbsp; &nbsp; &nbsp; &nbsp;</b>
					</td>
					<td>
						 <input  id="pucc" type="text" name="PUCCNum" class="validate"  placeholder="Polution Under Check Certificate No">
	 					<label for="pucc" data-error="Invalid Input"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>Expiry Date</b>
					</td>
					<td>
					 	 <input  id="pucc_exp" type="text" name="PUCCExpDate" class="validate"  pattern="(\d{4}-\d{2}-\d{2})" >
	 					<label for="pucc_exp" data-error="Invalid Date"></label>
					</td>
			</tr>
	
	
	
	</table>
	</fieldset>
	</div><!--./ Rc Details -->
	
	
	<!--Type of Vehicle -->
	<div class="col  s12 l4 m12">
	<fieldset>
	<legend style="color:#ee6e73">
	<b>Type Of Vehicle</b>
	</legend>
	<table>
			<tr>
					<td>
						<b>Name Of Vehicle<Span style="color:red">*</Span></b>
					</td>
					<td>
	 					 <select name="vehicleName" class="browser-default"  required="required">
                  <option value="" disabled selected>Vehicle Type</option>
                  <option value="1">TATA ACE</option>
                  <option value="2" >TATA 407</option>
                  <option value="6" >TATA SUPER ACE</option>
                <!--   <option value="" >CANTER 14FT</option>
                   <option value="CANTER 17FT" >CANTER 17FT</option>
                   <option value="CANTER 19FT"  >CANTER 19FT</option>
                  -->
               </select>
					</td>
					</tr>
					<tr>
					<td>
						<b>Maker&nbsp;Name<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	 <input  id="maker_name" type="text" name="makerName" class="validate z-depth-3" placeholder="Ex:TATA"  maxlength="45"  required>
	 					<label for="maker_name" data-error="Invalid Input"></label> 
					</td>
					</tr>
					<tr>
					<td>
						<b>Cubic&nbsp;Capacity<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	<input  id="capacity" type="text" name="cubicCapacity" class="validate z-depth-3"    pattern="[0-9.]{1,}" required>
	 					<label for="capacity" data-error="Invalid Input"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>BHP<Span style="color:red">*</Span></b>
					</td>
					
					<td>
					 	 <input  id="bhp" type="text" name="BHP" class="validate z-depth-3"  placeholder="Break Horse Porwer"  pattern="[0-9.\s]{1,}"  required>
	 					<label for="bhp" data-error="Invalid Input"></label>
					</td>
					</tr>
		
	
			<tr>
					<td>
						<b>Pay-Load Capacity<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	 <input  id="payload" type="text" name="payLoadCap" class="validate z-depth-3"  placeholder="in Tons"  pattern="[0-9.]{1,}"  required>
	 					<label for="payload" data-error="Invalid Input"></label>
					</td>
			</tr>
	
	</table>
	</fieldset>
	
	<fieldset>
	<legend style="color:#ee6e73">
	<b>Insurance Details</b>
	</legend>
	<table>
			<tr>
					<td>
						<b>Policy No<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	 <input  id="policy" type="text" name="policyNum" class="validate z-depth-3"    required>
	 					<label for="policy" data-error="Invalid num"></label>
					</td>
			</tr>
			<tr>
					<td>
						<b>Policy Owner Name<Span style="color:red">*</Span></b>
					</td>
					<td>
					  	<input  id="powner_name" type="text" name="policyOwnName" class="validate z-depth-3" pattern="^[a-zA-Z-_\s'.]{1,}$" minlength="3" maxlength="45" required>
	  					<label for="powner_name" data-error="Invalid Name"></label>
					</td>
			</tr>
			<tr>
					<td>
						<b>Policy Expire Date<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	<input  id="policy_exp" type="text" name="policyExpDate" class="validate z-depth-3"  pattern="(\d{4}-\d{2}-\d{2})" required>
	  					<label for="policy_exp" data-error="Invalid date"></label>
					</td>
			</tr>
	
	</table>
	</fieldset>
	
	<fieldset>
	<legend style="color:#ee6e73">
	<b>Goods Carrier Permit</b>
	</legend>
	                  <div class="col s12 l3 l12">
						<p><b>Type Of Permit</b><Span style="color:red">*</Span></p>
					 	<!-- <input  id="tr_name" type="text" name="transportName" class="validate z-depth-3"  placeholder="Enter Policy No"  pattern="[a-zA-Z\s]{3,15}" required> -->
					 	<input type="radio" name="typeOfPermit" value="National Permit" id="nat_permit" required>
					 	<label for="nat_permit">National Permit</label>
				</div>
					<div class="col s12 l3 l12">
					 	<input type="radio" name="typeOfPermit" value="State Permit" id="state_permit" required>
						<label for="state_permit">State Permit</label>
		</div>
					<div class="col s12 l12 m12" id="state_per">
					   <select name="stateName"    MULTIPLE size="4" >
							<option value="Select" disabled selected>Select States</option>
							<option value="Andhra Pradesh">Andhrapradesh</option>
							<option value="Arunachal Pradesh">Arunachal Pradesh</option>
							<option value="	Assam">Assam</option>
							<option value="Bihar">Bihar</option>
							<option value="Chhattisgarh">Chhattisgarh</option>
							<option value="Goa">Goa</option>
							<option value="Gujarat">Gujarat</option>
							<option value="Haryana">Haryana</option>
							<option value="Himachal Pradesh">Himachal Pradesh</option>
							<option value="Jammu and Kashmir">Jammu and Kashmir</option>
							<option value="Jharkhand">Jharkhand</option>
							<option value="Karnataka">Karnataka</option>
							<option value="Kerala">Kerala</option>
							<option value="Madhya Pradesh">Madhya Pradesh</option>
							<option value="	Maharashtra">Maharashtra</option>
							<option value="Manipur">Manipur</option>
							<option value="	Meghalaya">Meghalaya</option>
							<option value="	Mizoram">Mizoram</option>
							<option value="Nagaland">Nagaland</option>
							<option value="Odisha">Odisha</option>
							<option value="Punjab">Punjab</option>
							<option value="Rajasthan">Rajasthan</option>
							<option value="Sikkim">Sikkim</option>
							<option value="Tamil Nadu">Tamil Nadu</option>
							<option value="Telangana">Telangana</option>
							<option value="Tripura">Tripura</option>
							<option value="Uttar Pradesh">Uttar Pradesh</option>
							<option value="	Uttarakhand">Uttarakhand</option>
							<option value="West Bengal">West Bengal</option>
						</select>
                       
					</div>
			                   
                             
       
	<div class="row">
	<div class="col s12 l4 m6">
	<b>Permit Valid Till Date<Span style="color:red">*</Span> </b>
	</div>
						
					<div class="col s12 l8 m6">
					<input  id="permit_valid" type="text" name="permitValidTillDate" class="validate"  pattern="(\d{4}-\d{2}-\d{2})" required>
						  <label for="permit_valid" data-error="Invalid Date"></label>
					</div>
					 </div>	
		
	</fieldset>
	
	
	</div>
	<!--./Type of Vehicle -->
	
	<!--Type of Vehicle -->
		<div class="col s12 l4 m12">

<fieldset>
<legend style="color: #ee6e73;">
<b>Personal Details<Span style="color:red">*</Span></b></legend>
	
	<div class=" row col s12 l12 m12">

	<div class="col s12 l12 m12">
	<table>
			<tr>
					<td>
						<b>Driver Name<Span style="color:red">*</Span></b>
					</td>
					<td>
					    <input  id="driver_name" type="text" name="driverName" class="validate z-depth-3" pattern="^[a-zA-Z-_\s'.]{1,}$"  minlength="3"  maxlength="45" required>
	  					<label for="driver_name" data-error="Invalid Name"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>Address<Span style="color:red">*</Span></b>
					</td>
					
					<td>
					  	<textarea  id="dr_address" type="text" name="driverAddress" class="validate" maxlength="150" style="border:1px solid black;"  required></textarea>
					</td>
			</tr>
		<tr>
					<td>
						<b>Mobile&nbsp;No<Span style="color:red">*</Span></b>
					</td>
					<td>
					  	  <input  id="ph_no" type="text" name="driverMobile" class="validate z-depth-3"  pattern="^[789]\d{9}$" maxlength="10" required>
	   					  <label for="ph_no" data-error="Invalid Num"></label>
					</td>
					</tr>
					<tr>
					<td>
						<b>Email-Id</b>
					</td>
					<td>
					  	<input  id="d_email" type="text" name="driverEmail" class="validate z-depth-3"  pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})">
	  					<label for="d_email" data-error="Invalid Email-Id"></label>
					  
					</td>
			</tr>
	</table>
	</div>
	</div>
	</fieldset>

	<div class="col  s12 l12 m12">
	<fieldset>
	<legend style="color:#ee6e73">
	<b>DL Details</b>
	</legend>
	<table>
			<tr>
					<td>
						<b>DL No<Span style="color:red">*</Span></b>
					</td>
					<td>
					  	<input  id="dl_no" type="text" name="DLNum" class="validate z-depth-3"    pattern="^[a-zA-Z]{2}[0-9]{2}[0-9]{4,}$" minlength="10" maxlength="20" required>
	 					<label for="dl_no" data-error="Invalid Num"></label>  
					</td>
			</tr>
			<tr>
			
					<td>
						<b>Issue Date<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	 <input type="text" name="DLissueDate" value=""  pattern="(\d{4}-\d{2}-\d{2})" id="idate" placeholder="DD-MM-YY" required>
	  					<label for="idate" data-error="Invalid Date"></label>
					
					</td>
			</tr>
			<tr>
			
					<td>
						<b>Valid Till Date<Span style="color:red">*</Span></b>
					</td>
					<td>
					 	<input  id="vtdate" type="text" name="DLValidTillDate" class="validate"  pattern="(\d{4}-\d{2}-\d{2})" required>
	 					<label for="vtdate" data-error="Invalid Date"></label>
					</td>
			</tr>
	
	
	
	</table>
	</fieldset>
	</div>


</div>
	

</div>
<input type="submit" value="submit" class="btn col offset-l6">
</fieldset>
</form>
</div>

</div> 
 <!--./ VehicleDetails End-->
       
      <!--./Transporter Information-->

   
   
       <!-- ./Transporter/Vehicle Register End -->   
       <!-- Enterprise Details -->
       <br><br><br>
       
              <div id="enterprise" class=" row col s12">
 
    
<div class="col s12 l12 m6">
       <h5 class="center">Potential Customers</h5>
       	<table class="responsive-table striped bordered">
       	<tr class="">
       		<th class="head">Mobile No</th>
       		<th class="head">Truck Type</th>
       		<th class="head">From City</th>
       		<th class="head">To City</th>
       		<th class="head">Date & Time</th>
       		<th class="head">Action</th>
       		</tr>
       		
      <c:forEach var="land" items="${landPageInfo}"> 		
       		<tr>
       		
       			<td class="head" style="text-align: center;">${land.mobileNo}</td>
				<td  class="head" style="text-align: center;">${land.truckType}</td>
				<td class="head" style="text-align: center;">${land.fromCity}</td>
				<td class="head" style="text-align: center;">${land.toCity}</td>
       			<td class="head" style="text-align: center;">${land.postDate}</td>
       			<td class="head" style="text-align: center;"><a href="landConfirm/${land.mobileNo}/${land.invoiceId}" class="">Confirm</a>&nbsp;&nbsp;&nbsp;<a href="landCancel/${land.invoiceId}"class="red-text">Cancel</a></td>
       		</tr>
       		</c:forEach>
       	</table>
       	</div>

  <div class="row">
<div class="col s12 l12 m6">
<h5 class="center">Enterprise Customers</h5>
<table class="responsive-table striped bordered">
	
		<tr class="">
				<th class="head">Enterprise Id</th>
				<th class="head">Enterprise Name</th>
				<th class="head">Contact Name</th>
				<th class="head">Mobile No</th>
				<th class="head">Email Id</th>
				<th class="head">Address</th>
				
		</tr>
	
	<c:forEach var="enterprise" items="${ec}">
	

	
		<tr class="">
		
				<td class="head">${enterprise.enterpriseCustomerId}</td>
				<td  class="head">${enterprise.enterpriseName}</td>
				<td class="head">${enterprise.contactPerson}</td>
				<td class="head">${enterprise.contactNumber}</td>
				<td class="head">${enterprise.email}</td>
				<td class="head">${enterprise.address}</td>
				
		</tr>

	
	</c:forEach>
</table>


</div>
</div>
       </div>
        <div id="enterprise" class=" row col s12">
  <div class="row col s12 l12 m12">


</div>


        
       
  </div><!--./ Enterprise Details -->
  
  </div><!-- /main div -->   
 </c:when> 
 </c:choose> 
  
<script type="text/javascript" src="js/paging.js"></script>    
  <script type="text/javascript" src="js/jquery-dtpicker.js"></script>
</body>
<script>/* to hid and show the vehicle&driver details */
$('ul.tabs a').on('click', function(e){

	  if($(this).attr("target") ) {
	    window.location = $(this).attr("href");
	  }
	}); 
	
$('#test4').click(function(){
        if (this.checked) {
        	  $('#personal').show();
        	  $('#vehicle').hide();
        }
        else {
           
        }                   
    });
$('#test5').click(function(){
    if (this.checked) {
    	  $('#vehicle').show();
    	  $('#personal').hide();
    }
    else {
       
    }                   
});
$('#test6').click(function(){
    if (this.checked) {
    	$(".bankdetails").show();
    	 
    }
    else {
       
    }                   
});
$('#test7').click(function(){
    if (this.checked) {
    	$(".bankdetails").hide();
    }
    else {
       
    }                   
});
</script>
 <script> 
$('#pan_no,#dimension,#capacity,#bhp,#payload,#policy,#dl_no,#tr_email,#d_email').on("keydown", function (e) {
    return e.which !== 32;
});
</script>

<script>
/*uppercase for characters*/
$(document).ready(function()
{
    $('#pd,#pan_no,#text2,#vehicle_no,#chassis_no,#dl_no,#vehicle_name,#ifsc').keyup(function()
    {
        $(this).val($(this).val().toUpperCase());
    });
});
</script>


<script>
$(document).ready(function() {
  $('select').material_select();
}); 


</script>
<!--enable/disable of address proff  -->
<script type="text/javascript">	 
	 document.getElementById("state_permit").onclick=function (e) {
	  document.getElementById("state_per").style.display="block";
	  document.getElementById("nat_permit").required=false;
	 };
	 document.getElementById("nat_permit").onclick=function (e) {
	  document.getElementById("state_per").style.display="none";
	  document.getElementById("state_permit").required=false;
	 };
</script>

<script>
  $(function(){
     $('#vtdate,#rvtdate,#fvtdate,#pucc_exp,#policy_exp,#permit_valid').appendDtpicker({
     "autodateOnStart":false,
   "closeOnSelected": true,
   "futureOnly": true,
   "amPmInTimeList":false,
   "closeButton": true,
   "dateOnly":true,
   "dateFormat":"YYYY-MM-DD",
     });
    });
	
	 $(function(){
	     $('#date_foo,#idate').appendDtpicker({
	    	"autodateOnStart":false,
			 "closeOnSelected": true,
				"amPmInTimeList":false,
				"closeButton": true,
				"dateOnly":true,
				"dateFormat":"YYYY-MM-DD",
				 "prevMonth":'fgdfgdgd',
				 "maxDate":new Date,
	     });
	    });
	 
	 $('.dropdown-button').dropdown({
	      inDuration: 300,
	      outDuration: 225,
	      constrain_width: false, // Does not change width of dropdown to that of the activator
	      hover: false, // Activate on hover
	      gutter: 0, // Spacing from edge
	      belowOrigin: false, // Displays dropdown below the button
	      alignment: 'left' // Displays dropdown with edge aligned to the left of button
	    }
	  );
  </script>
 
	
        

 
</html>