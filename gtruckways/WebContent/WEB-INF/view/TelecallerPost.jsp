<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>gTruckWays</title>
 <meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="<%=request.getContextPath()%>/img/logo.png" type="image/gif" sizes="16x16">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/materialize.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/tele.css" />
	<link type="text/css" href="<%=request.getContextPath()%>/css/jquery.simple-dtpicker.css/" rel="stylesheet" />	
	  <script type="text/javascript" src="<%=request.getContextPath()%>/js/materialize.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/materialize.js" ></script>
	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/createReqObj.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/register.js" ></script>
		<style>
	.logo{
	margin-top:1rem ;
}
		nav
{
background-color:#0288d1;
}
input[type=text], input[type=password], input[type=email], input[type=url], input[type=time], input[type=date], input[type=datetime-local], input[type=tel], input[type=number], input[type=search], textarea.materialize-textarea {
    background-color: transparent;
    border-bottom: 1px solid #9e9e9e;
    color: black;
    outline: none;
    height: 2rem;
    width: 100%;
    font-size: 1rem;
    margin: 0 0 0 0;
    padding: 0;
    box-shadow: none;
    box-sizing: content-box;
    transition: all .3s;
}
.input-field label {
    color: #0288d1;
    position: absolute;
    top: 0.8rem;
    left: 0.75rem;
    font-size: 1rem;
    cursor: text;
    transition: .2s ease-out;
}
select {
    background-color: transparent;
    width: 92%;
    padding: 5px;
    border-bottom: 1px solid #9e9e9e;
    border-radius: 2px;
    margin: 0 0 15px 0;
    height: 2.3rem;
    color: #0288d1;
    box-sizing: content-box;
    font-size: 1rem;
    transition: all .3s;
    outline: none;
}
.input-field label.active{
transform:translateY(-120);
}
.confirm,.cancel{
padding: 1px 5px 1px 5px;
	background-color:#0288d1;
	text-align: center;
}
btn.resendBtn{
padding: 1px 5px 1px 5px;
	background-color:#0288d1;
	text-align: center;
	width:15%;
	
}
th {
    padding-top: 1%;
    padding-bottom:1%;
    padding-right:0;
    padding-left:0;
}
td{
padding:0px 5px;
}
 .genarate{
 padding: 1px 5px 1px 5px;
	background-color:#0288d1;
	text-align: center;
	height:20%;
	color:white;
 }
 
 input:not([type])+label:after, input[type=text]+label:after{
    display: block;
    content: "";
    position: absolute;
    top:16px;
    opacity: 0;
    transition: .2s opacity ease-out, .2s color ease-out;
}


	</style>
	
</head>
<body>

 
  <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  

      	<img src="<%=request.getContextPath()%>/img/Logonew.png/"  height="70%" width="10%"  class="logo" alt="" /><span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;">Customer Care</span>
     
      
    <!--logout  -->
    <ul id="" class="right logged-in">
    <li><a href="<%=request.getContextPath()%>/bookHome"><i class="fa fa-arrow-left"></i>&nbsp;Go Back</a></li>
			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;${TelecallerInfo.telecallerName}</a></li>
			
			  <ul id="dropdown_local" class="dropdown-content">
			 
			    <li><a href="<%=request.getContextPath()%>/teleLogout" onclick="" id="signout" >Sign out</a></li>
			    
			  </ul>
		</ul>
	  <!--/logout  -->
    </div>
  </nav>
  </div> 
  
  
  <!--/ Local Header END -->

<!-- Body Starts -->

<div class="col s11 l12 m12 " style="margin:10px 15px;">

<span style="color:#1253A4;" ><b><i class="fa fa-id-card "></i>&nbsp;Booking Id:</b>&nbsp;${telePostinfo.bookingId}</span>
<span style="margin-left:30rem;">${message}</span>

		     <span style="float:right;color:#1253A4;"><b ><i class="fa fa-calendar"></i>&nbsp;Booking Date and Time :</b>&nbsp;${telePostinfo.postDate}</span>
	  
  </div>
  <div class="row">
  <!-- Customer details -->
  	<div class="col s12 m12 l5">
  <fieldset>
<legend style="color:#1253A4;"><i class="fa fa-user"></i>&nbsp;<b>Customer Details</b></legend>
 <span style="color:#1253A4" class="right"><i class="fa fa-info-circle"></i><b>&nbsp;Status:&nbsp;${telePostinfo.status}</b></span>
<br>
<c:choose>
<c:when test="${telePostinfo.status.equals('Booking Accepted')}">
<form action="confirmPost" method="post">

	
	
	<div class="input-field col s12 l6">
  	<input type="text" name="userName" value="${telePostinfo.user.userName}" readonly/>
  	<label for="">Name</label>
  	</div>
  	<div class="input-field col s12 l6">
  	<input type="text" name="userContact" value="${telePostinfo.user.mobileNo}" readonly>
  	<label for="">Contact No#</label>
  	</div>
  	<div class="input-field col s12 l6 m12">
  	<input type="text" class="validate" name="userRecipientName" value="${telePostinfo.recepientName}" pattern="^[a-zA-Z-_\s'.]{1,}$"  maxlength="45" required />
  	<label for="">Recipient Name</label>
  	</div>
  	<div class="input-field col s12 l6 m12">
  	<input type="text" class="validate" name="userRecipientContact" pattern="^[789]\d{9}$" maxlength="10"  value="${telePostinfo.recepientMobile}" required />
  	<label for="">Recipient Contact</label>
  	</div>
  	<div class="input-field col s12 l6 m12">
  	<textarea name="userFrom" value="" id="frmarea" placeholder="From" readonly>${telePostinfo.fromCity}</textarea>
  		<label for="">From</label>
  <%-- 	<input type="text" id="userFromarea" name="userFrom" value="${telePostinfo.fromCity}" id="frmarea" readonly />
  	<label for="">From</label> --%>
  	</div>
  	 <div class="input-field col s12 l6 m12">
  	 <textarea rows="" cols="" name="userTo" value="" id="tooarea" placeholder="To"readonly>${telePostinfo.toCity}</textarea>
  	 	<label for="">To</label>
  <%-- 	<input type="text" id="userToarea" name="userTo" value="${telePostinfo.toCity}" id="tooarea" readonly />
  	<label for="">To</label> --%>
  	</div>
  	 <div class="input-field col s12 l6 m12">
  	<textarea name="userPickup"  pattern="^([^\s])([\sa-zA-Z0-9_\-]*)([^\s])$"  minlength="3" required>${telePostinfo.pickUpArea}</textarea>
  	<label for="">Pick up</label>
  	</div>
  	 <div class="input-field col s12 l6 m12">
  	<textarea class="validate" name="userDrop"  pattern="^([^\s])([\sa-zA-Z0-9_\-]*)([^\s])$"  minlength="3" required>${telePostinfo.dropArea}</textarea>
  	<label for="">Drop</label>
  	</div>
  		 <div class="input-field col s12 l6 m12">
  		 <input type="text" name="approximateKm" value="${telePostinfo.approximateKm}" readonly>
  		   	<label for="">Approximate KM</label>
  	</div>
  	 <div class="input-field col s12 l6 m12">
  		 <input type="text" name="approximateMins" value="${telePostinfo.approximateMins}" readonly>
  		   	<label for="">Approximate Mins</label>
  	</div>
  	
  		 <div class="input-field col s12 l6 m12">
  		 <input type="text" name="valueOfGoods" value="${telePostinfo.valueOfGoods}" >
  		   	<label for="">Value Of Goods</label>
  	</div>
  	 <div class="input-field col s12 l6 m12">
  		 <input type="text" name="approximateWeight" value="${telePostinfo.approximateWeight}">
  		   	<label for="">Approximate Weight</label>
  	</div>
  	
  	
  	
  	
  	 <div class="input-field col s12 l6 m12">
  	<select name="trucktype" class="browser-default" id="trckType" style="height:20px;margin-bottom:0px">
  		 <option  value="${telePostinfo.infoTruck.truckName}"  selected="selected">${telePostinfo.infoTruck.truckName}</option>
	  <!--     <option value="TATA ACE/MAXIMO">TATA ACE/MAXIMO</option>
	       <option value="TATA 407">TATA 407</option> -->
	     

 	<c:forEach var="item" items="${VehicleTypeList}">
     <option value="${item.truckName}">${item.truckName}</option>
   	 </c:forEach> 
	 
	 
  	</select>
  	</div>
  	 <div class="input-field col s12 l6 m12">
	
<select class="browser-default" name="userMaterial" id="mat" style="height:20px;margin-bottom:0px">
								   <option value="${telePostinfo.material}" selected="selected">${telePostinfo.material}</option>
								   <c:forEach var="item" items="${MaterialList}">
    						 		<option>${item}</option>
   									</c:forEach>
								
							</select>
	
	
  	</div>
  		<div class="input-field col s12 l6">
   <input type="text" name="userTravelDate"  value="${telePostinfo.travelDate}"  id="date" onchange="totalprice()"  required>
	<label for=""><i class="fa fa-calendar"></i>&nbsp;Date of travel</label>
	</div>
	<div class="input-field col s12 l5">
  <input type="hidden" value="${telePostinfo.approximateAmount}" id="amountid">
  <input type="hidden" value="${telePostinfo.infoTruck.labourPrice}" id="labourid">
			      <input type="text"  width="20%;" name="userQuotedAmount" value="${telePostinfo.totalAmount}"  id="amount" readonly/>
			      	<label for=""><i class="fa fa-rupee"></i>&nbsp;Approximate Amount</label>

	</div>
	<div class="input-field col s12 l1">
	<p></p>
			<span ><a class="waves-effect waves-light modal-trigger" href="#modal6" style="font-size:14px"><u>View</u></a></span>
	
	</div>

<div class="row">



<div class="input-field col s12 m12 l6">
<input type="number" name="userHelper" max="4" min="0" id="helper" value="${telePostinfo.helper}" onchange="totalprice()" >
<label for="">Helper</label>
</div>
<c:choose>
<c:when test="${telePostinfo.discountAmount!=0}">
<span style="font-size:13px;color:green;">The Promocode ${telePostinfo.promocode} is Applied of Rs  ${telePostinfo.discountAmount} </span>
</c:when>
<c:otherwise>
<div class="input-field col s12 m12 l6">
<span style="font-size:13px;color:red;"> Promocode is Not Applied</span>
</div>
</c:otherwise>

</c:choose>



</div>

  	<div>
  	
  		<input type="submit" name="Button"  class="btn confirm col push-s3"  id="subbtn" value="Confirm">
		
		&nbsp;<a href="cancel"  ><input type="button" name="Button"  id="hidebtn" class="btn cancel col push-s4"   value="Cancel"></a>
	</div>
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>					
</form>

</c:when>
<c:otherwise>
<table class="bordered">
			<tr>
				<th> Name</th>
						<td>
				${telePostinfo.user.userName}
						</td>
				<th>Contact&nbsp;No#</th>
						<td>
						${telePostinfo.user.mobileNo}
						</td>
			</tr>
			<tr>
				<th>Recipient Name</th>
						<td>
					${telePostinfo.recepientName}
						</td>
				<th>Recipient Contact</th>
						<td>
					${telePostinfo.recepientMobile}
						</td>
			</tr>
			<tr>
				<th>From</th>
						<td>
				<textarea  style="border-bottom:none;">${telePostinfo.fromCity}</textarea>
						</td>
				<th>To</th>
						<td>
						<textarea  style="border-bottom:none;" >${telePostinfo.toCity}</textarea>
						</td>
			</tr>
		
			<tr>
				<th "style="border-bottom:none;">Pick-Up</th>
						<td>
						<textarea>${telePostinfo.pickUpArea}</textarea>
						</td>
				<th style="border-bottom:none;">Drop</th>
						<td>
						<textarea>${telePostinfo.dropArea}</textarea>
						</td>
			</tr>
			<tr>
				<th>Approximate KM</th>
						<td>
						${telePostinfo.approximateKm}&nbsp;Km
						</td>
				<th>Approximate Min</th>
						<td>
						${telePostinfo.approximateMins}&nbsp;Mins
						</td>
			</tr>

			<tr>
				<th>Value Of Goods</th>
						<td>
						${telePostinfo.valueOfGoods}&nbsp;Rs
						</td>
				<th>Approximate Weight</th>
						<td>
						${telePostinfo.approximateWeight}&nbsp;Kgs
						</td>
			</tr>
			



			<tr>
				<th>VehicleType</th>
						<td>
						${telePostinfo.infoTruck.truckName}
						</td>
				<th>Material</th>
						<td>
						${telePostinfo.material}
						</td>
			</tr>

			
			<tr>
				<th>Date of travel</th>
						<td>
					${telePostinfo.travelDate}
						</td> 
				<th>Approximate Amount</th>
						<td>
					${telePostinfo.approximateAmount}
						</td>
						
			</tr>
				<tr>
				<th>Helper</th>
						<td>
				${telePostinfo.helper}
						</td> 
				<th>Promocode </th>
						<td>
						${telePostinfo.promocode}
						</td>
						
			</tr>
			
			
			
		</table>
		
		
		
		
  <c:choose>
  <c:when test="${telePostinfo.status.equals('Booking Accepted') || telePostinfo.status.equals('Customer Confirmed')}">

		
		<fieldset>
		<legend><b style="color:#1253A4">Notification</b></legend>
		<span style="color:red;">${driverNotificationMsg}</span>
		
		<table>
		<tr>
		 <th>Driver Name</th>
		      <td>
		      ${telePostinfo.driver.driverName}
		      </td> 
		    <th>Driver Mobile</th>
		      <td>
		     ${telePostinfo.driver.mobile}
		      </td>
	      
	   </tr>
   		   
</table> 
</fieldset>
</c:when>
    </c:choose>
    
    
    
    
    
<br>
<c:choose>
<c:when test="${telePostinfo.status.equals('Customer Confirmed')}">
<a href="resendPost"  id="hidebtn"><input type="submit" name="Resend" 
 class="btn  resendBtn col push-l3"  id="resendBtn" value="Resend"></a>
 &nbsp;&nbsp;
<a href="cancel"  ><input type="button" name="Button"  id="hidebtn" class="btn cancel col push-s4"   value="Cancel"></a> 
<br><br>
</c:when>
<c:when test="${telePostinfo.status.equals('Vehicle Arranged') || telePostinfo.status.equals('Source Reached') }">
<a href="cancel"  ><input type="button" name="Button"  id="hidebtn" class="btn cancel col push-s4"   value="Cancel"></a> 
</c:when>
</c:choose>


<%-- <c:choose>

<c:when test="${telePostinfo.status.equals('Customer Confirmed') && telePostinfo.driver.driverId!=0}">


<fieldset>
<legend  style="color:#1253A4"><b>Trip Cancellation by driver </b></legend>
<div class="row">
<button type="button" id="cancelbtn"class=" left">Not interested</button>&nbsp;&nbsp;&nbsp;&nbsp;
<form action="noResponse" method="GET" style="margin-top:-1.5rem;margin-left:10rem;'">
<button type="submit" id="norespbtn"class="">No Response</button>
</form>
</div>
<div id="drive_can" style="display:none;">
<form action="driverCancel" method="GET">
<p>
      <input name="group1" type="radio" id="withPenalty" value="1" />
      <label for="withPenalty">With Penalty</label>
    
      <input name="group1" type="radio" id="withoutPenalty" value="0" />
      <label for="withoutPenalty">Without Penalty</label>
    </p>
<input type="submit" value="submit" style="background-color:#1253A4;" class="btn dri_sub">

</form>

</div>
</fieldset>

</c:when>
</c:choose>
--%>
</c:otherwise>
</c:choose>
 
   

</fieldset>
  </div>
  
  <!--Driver Details  -->
  

<div class="col s12 l3 m4" id="content">
  <c:choose>
<c:when test="${telePostinfo.status.equals('Customer Confirmed')}">
<fieldset>
<legend style="color:#1253A4"><i class="fa fa-user"></i>&nbsp;<b>Driver Details</b></legend>
<span style="float:left;font-size:14px;">${driverMsg}</span>
<span style="font-size:20px;"><a class="waves-effect waves-light modal-trigger col offset-l4" href="#SearchTransporter"><u>Select Driver</u></a></span>


</fieldset>
</c:when>
</c:choose>

<c:choose>
<c:when test="${!telePostinfo.status.equals('Canceled') && !telePostinfo.status.equals('Customer Confirmed') && !telePostinfo.status.equals('Booking Accepted') &&  !telePostinfo.status.equals('Vehicle Arranged') }">
<fieldset>
<legend style="color:#1253A4"><i class="fa fa-user"></i>&nbsp;<b>Driver Details</b></legend>
<table>

			<tr>
					<th>Truck&nbsp;Regno#</th>
						<td>
						${transinfo.vehicleRegistrationNo}
						</td>
			</tr>
			<tr>
					<th>Vehicle&nbsp;Name</th>
						<td>
						${telePostinfo.infoTruck.truckName}
						</td>
			</tr>
			
			<tr>
					<th>Driver&nbsp;Name</th>
						<td>
						${transinfo.driverId.driverName}
						
						</td>
			</tr>
			<tr>
					<th>Driver&nbsp;Contact</th>
						<td>
						${transinfo.driverId.mobile}
						</td>
			</tr>
						
</table>
</fieldset>

<!-- enter Trip details -->

<c:choose>
<c:when test="${telePostinfo.status.equals('Unloading Finished')}">
<fieldset>
	<legend style="color:#1253A4"><i class="fa fa-truck"></i>&nbsp;Trip Details</legend>
	<form action="addPrice" method="Post">
<table>
<tr>
<td> <input type="text" class="validate" name="actualKm" id="kmId"  placeholder="Actual Kilometer" required /> 

</td>
</tr>
<tr>
 <td><input type="hidden" class="validate" name="otherAmount" id="minsId" value="0"  placeholder="Other Amount" required /> 
</td>
</tr>
</table>
<br>
<input type="submit" value="Trip Finished" class="btn col push-l2" style="height:20px;line-height:20px;">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
</form>
</fieldset>
</c:when>

<c:when test="${telePostinfo.status.equals('Trip Finished') || telePostinfo.status.equals('Completed')}">
<!-- Show trip details -->
<fieldset>
	<legend style="color:#1253A4"><i class="fa fa-truck"></i>&nbsp;<b>Trip Details</b></legend>
	<form>
	<table>
		<tr>
			<th>Total Km</th>
			<td><i class="fa fa-road"></i>&nbsp;${telePostinfo.totalKm}</td>
		</tr>
		<tr>
			<th>Total Mins</th>
			<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.totalMins}</td>
		</tr>
		
		<tr>
			<th>Extra Km</th>
			<td><i class="fa fa-road"></i>&nbsp;${telePostinfo.extraKm}</td>
		</tr>
		
		
			<tr>
			<th>Extra Mins</th>
			<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.extraMins}</td>
		</tr>
			
			<tr>
			<th>Base Fare</th>
			<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.basePrice}</td>
		</tr>
		
		
			<tr>
			<th>Extra Km Amount</th>
			<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.extraKmAmount}</td>
			</tr>
		
			<tr>
			<th>Extra Time Amount</th>
			<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.extraMinsAmount}</td>
		</tr>
		
			<tr>
			<th>Helper Charges</th>
			<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.helperAmount}</td>
		</tr>
		
			<tr>
			<th>Night Charges</th>
			<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.nightCharges}</td>
		</tr>
		
		<c:choose>
		<c:when test="${telePostinfo.status eq 'Completed'}">
			<tr>
			<th>Other Charges</th>
			<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.otherAmount}</td>
			</tr>
		
			<tr>
			<th>Discount</th>
			<td><i class="fa fa-rupee"></i>&nbsp;-${telePostinfo.discountAmount}</td>
			</tr>
			
			<tr>
			<th>GST <small>(CGST-2.5%+SGST-2.5%)</small></th>
			<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.gstAmount}</td>
			</tr>
		</c:when>
		</c:choose>
		
			<tr style="border-top:5px solid #0288d1">
			
			<td><b>Total Amount</b></td>
			<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.totalAmount}</td>
		</tr>
	</table>
	</form>
</fieldset>
</c:when>
</c:choose>

</c:when>
<c:when test="${telePostinfo.status.equals('Vehicle Arranged')}">

<fieldset>
<legend><i class="fa fa-user"></i>&nbsp;<b>Driver Details</b></legend>
<span style="float:right;font-size:14px;"><a class="waves-effect waves-light modal-trigger" href="#SearchTransporter"><u>Select Driver</u></a></span>
<br>
<table>

			<tr>
					<th>Truck&nbsp;Regno#</th>
						<td>
						${transinfo.vehicleRegistrationNo}
						</td>
			</tr>
			<tr>
					<th>Vehicle&nbsp;Name</th>
						<td>
						${telePostinfo.infoTruck.truckName}
						</td>
			</tr>
			
			<tr>
					<th>Driver&nbsp;Name</th>
						<td>
						${transinfo.driverId.driverName}
						
						</td>
			</tr>
			<tr>
					<th>Driver&nbsp;Contact</th>
						<td>
						${transinfo.driverId.mobile}
						</td>
			</tr>		
				
</table>
<br>
<form action="confirmTrans" method="Post">
 <input type="hidden" value="${transinfo.driverId.driverId}" name="driverId"/>
<input type="submit" name="Resend" class="btn col offset-l4" style="height:20px;line-height:20px;" id="resendBtn" value="Resend">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
 </form>
</fieldset>


</c:when>
</c:choose> 
 </div>











  
  
  


<!-- Status Update -->
<div class="col s12 m12 l4">
<div>

<c:choose>
<c:when test="${!telePostinfo.status.equals('Canceled') && !telePostinfo.status.equals('Booking Accepted') && !telePostinfo.status.equals('Customer Confirmed') }">

<fieldset>
<legend style="color:#1253A4;"><i class="fa fa-info-circle"></i>&nbsp;<b>Status Update</b></legend>

<!-- Status of driver automate -->
 <div class="row" id="automateshow">
 <button id="manualprocess" class="right" style="overflow: visible; background-color:#26a69a;color: white;height: 25px;border: 1px solid beige;">Manual Update<i class="fa fa-arrow-right"></i></button>
<div>

<c:choose>
<c:when test="${telePostinfo.status.equals('Source Reached')}">
<form>
<div>

</div>
</form>
<form action="loadUnload" method="post">
<table>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;">&nbsp;&nbsp;&nbsp;&nbsp;Source Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.srcReachedDateTime}</td>
</tr>
<tr>
<td>
<input class="with-gap" name="LoadUnload" value="Loading Completed" type="radio" id="loading" required />
			      <label for="loading">Loading Completed</label>
</td>
</tr>
<tr>
<td>
<input class="with-gap" name="LoadUnload" value="Destination Reached" type="radio" id="destReached" required />
			      <label for="destReached">Destination Reached</label>
</td>
</tr>
<tr>
<td>
	<input class="with-gap" name="LoadUnload" value="Unloading Finished" type="radio" id="unloading" required />
			      <label for="unloading">Unloading Finished</label>
</td>
</tr>
</table>
</form>
</c:when>


<c:when test="${telePostinfo.status.equals('Loading Completed')}">
	<form action="loadUnload" method="post">		
	<table>
	<tr>
	<td><i class="fa fa-check offset-l2" aria-hidden="true" style="color:green;">&nbsp;&nbsp;Source Reached</i></td>
	<td>${telePostinfo.srcReachedDateTime}</td>
	</tr>
	<tr>
	<td><i class="fa fa-check offset-l2" aria-hidden="true" style="color:green;">&nbsp;&nbsp;Loading Completed</i></td>
	<td>${telePostinfo.loadingDateTime}</td>
	</tr>
	<tr>
	<td>
	<input class="with-gap" name="LoadUnload" value="Destination Reached" type="radio" id="destReached" required />
			      <label for="destReached">Destination Reached</label>
	</td>
	</tr>
	<tr>
	<td>
	<input class="with-gap" name="LoadUnload" value="Unloading Finished" type="radio" id="unloading" required />
			      <label for="unloading">Unloading Finished</label>
	</td>
	</tr>
	</table>
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
			</form>
</c:when>

<c:when test="${telePostinfo.status.equals('Destination Reached')}">
<form action="loadUnload" method="post">
<table>
<tr>
<td><i class="fa fa-check offset-l2"  style="color:green;">&nbsp;&nbsp;Source Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.srcReachedDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check offset-l2"  style="color:green;">&nbsp;&nbsp;Loading Completed</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.loadingDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check offset-l2"  style="color:green;">&nbsp;&nbsp;Destination Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.destReachedDateTime}</td>
</tr>
<tr>
<td><input class="with-gap" name="LoadUnload" value="Unloading Finished" type="radio" id="unloading" required />
  <label for="unloading">Unloading Finished</label></td>

</tr>
</table>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>				
</form>
</c:when>


 <c:when test="${telePostinfo.status.equals('Booking Accepted')||telePostinfo.status.equals('Vehicle Arranged')||telePostinfo.status.equals('Customer Confirmed')}">
<form action="loadUnload" method="post">
<input class="with-gap" name="LoadUnload" value="Source Reached" type="radio" id="srcReached" required />
			      <label for="srcReached">Source Reached</label>
			      
			      <br>
		<input class="with-gap" name="LoadUnload" value="Loading Completed" type="radio" id="loading" required />
			      <label for="loading">Loading Completed</label>
			      
			  
			<br>
			
			<input class="with-gap" name="LoadUnload" value="Destination Reached" type="radio" id="destReached" required />
			      <label for="destReached">Destination Reached</label>
			      <br>
			<input class="with-gap" name="LoadUnload" value="Unloading Finished" type="radio" id="unloading" required />
			      <label for="unloading">Unloading Finished</label>
			<!-- <br><br>
			<input type="submit" class="btn col push s12"  id="submit_up" value="Update">   -->
			
			
</form>

</c:when>	
<c:when test="${telePostinfo.transporterAmount!=0}">
<table>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Source Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.srcReachedDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Loading Completed</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.loadingDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Destination Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.destReachedDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Unloading Finished</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.unloadingDateTime}</td>
</tr>
</table>




<c:choose>
<c:when test="${telePostinfo.status.equals('Completed')}">
<fieldset>
 <legend style="color:#1253A4;">
<i class="fa fa-rupee"></i>&nbsp;<b>Payment Details</b>
 </legend>
 <form action="invoice" method="Get" target="TheWindow">
 <table>
 <tr>
 <td>
 <b>Customer Amount</b>
 </td>
 
 <td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.totalAmount}</td>
 </tr>
 <tr>
 <td>
  <b>Gtruckways Amount</b>
 </td>
 <td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.gtruckwaysAmount}</td>
 </tr>
 <tr>
 <td>
 <b>transporter Amount</b>
 </td>
 <td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.transporterAmount}</td>

 </tr>
<tr height="20">
<td></td>
</tr>
 <tr><td><input type="submit" value="Show Invoice" onclick="window.open('', 'TheWindow');" class="genarate col push-l4"></td></tr> 
  </table>
 </form>
 </fieldset>

 </c:when>
 </c:choose>
</c:when>
<c:otherwise>
<table>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Source Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.srcReachedDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Loading Completed</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.loadingDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Destination Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.destReachedDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Unloading Finished</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.unloadingDateTime}</td>
</tr>
</table>	 
			

</c:otherwise> 
</c:choose>

<!--display data  -->

</div>
</div>
<div class="row" id="manualprocshow" style="display:none;">
	 <button id="automate" style="overflow: visible; background-color: #26a69a;color: white;height: 25px;border: 1px solid beige;" class="right"><i class="fa fa-arrow-left"></i>Driver App Update</button>
	
	 <div class="row">
 <c:choose>
 <c:when test="${telePostinfo.status.equals('Booking Accepted')||telePostinfo.status.equals('Vehicle Arranged')||telePostinfo.status.equals('Customer Confirmed')}">
  
  <form action="loadUnload" method="post">
 <div class="row"><br>
 <div class="input-field col s12 m12 l6">
 <input class="with-gap" name="LoadUnload" type="radio" value="Source Reached" id="test1" required />
      <label for="test1">Source Reached</label>
 </div>
 <div class="input-field col s12 m12 l6">
 <input type="text" name="webtime" placeholder="Time" class="validate" pattern="([01]?[0-9]{1}|2[0-3]{1}):[0-5]{1}[0-9]{1}" required>
 <label for="" data-error="ex:HH:MM"></label>
 </div>
 </div><br>
 <div class="input-field">
  <input type="submit" class="btn col offset-l1" value="Update" style="width:80%;height:27px;padding-bottom: 32px;">
 </div>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
 </form>
</c:when>



<c:when test="${telePostinfo.status.equals('Source Reached')}">
<form action="loadUnload" method="post">
<table>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;">&nbsp;&nbsp;Source Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.srcReachedDateTime}</td>
</tr>
</table>
<table>
<tr>
<td>

<input class="with-gap" name="LoadUnload" type="radio" value="Loading Completed"  id="test1" required/>
      <label for="test1">Loading Completed</label>

</td>
<td>

 <input type="text" name="webtime" placeholder="Time" class="validate"  pattern="([01]?[0-9]{1}|2[0-3]{1}):[0-5]{1}[0-9]{1}"  required>
 <label for="" data-error="ex:HH:MM"></label>

</td>
</tr>

</table> 
<br>
 <div class="input-field">
  <input type="submit" class="btn col offset-l1" value="Update" style="width:80%;height:27px;padding-bottom: 32px;">
 </div>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
</form>
</c:when>

<c:when test="${telePostinfo.status.equals('Loading Completed')}">		
<form action="loadUnload" method="post">
	<table>
	<tr>
	<td><i class="fa fa-check offset-l2" aria-hidden="true" style="color:green;">&nbsp;&nbsp;Source Reached</i></td>
	<td>${telePostinfo.srcReachedDateTime}</td>
	</tr>
	<tr>
	<td><i class="fa fa-check offset-l2" aria-hidden="true" style="color:green;">&nbsp;&nbsp;Loading Completed</i></td>
	<td>${telePostinfo.loadingDateTime}</td>
	</tr>
	</table>
<table>
<tr>
<td>
	<input class="with-gap" name="LoadUnload" type="radio"  value="Destination Reached" id="test1" required/>
   <label for="test1">Destination Reached</label>
</td>
<td>
	<input type="text" name="webtime" placeholder="Time" pattern="^(?:([01]?\d|2[0-3]):([0-5]?\d))$" required>
	 <label for="" data-error="ex:HH:MM"></label>
</td>
</tr>
</table>
<br>
 	<div class="input-field">
 	 <input type="submit" class="btn col offset-l1" value="Update" style="width:80%;height:27px;padding-bottom: 32px;">
 	</div>
 	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
</form>

</c:when>

<c:when test="${telePostinfo.status.equals('Destination Reached')}">
<form action="loadUnload" method="post">
<table>
<tr>
<td><i class="fa fa-check offset-l2"  style="color:green;">&nbsp;&nbsp;Source Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.srcReachedDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check offset-l2"  style="color:green;">&nbsp;&nbsp;Loading Completed</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.loadingDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check offset-l2"  style="color:green;">&nbsp;&nbsp;Destination Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.destReachedDateTime}</td>
</tr>
</table>
<table>
<tr>
<td>
	<input class="with-gap" name="LoadUnload" type="radio" value="Unloading Finished" id="test1" required/>
      <label for="test1">Unloading Finished</label>
</td>
<td>	<input type="text" name="webtime" placeholder="Time" pattern="^(?:([01]?\d|2[0-3]):([0-5]?\d))$" required>
 <label for="" data-error="ex:HH:MM"></label>
</td>
</tr>
</table>

 	<br>
 	<div class="input-field">
 	 <input type="submit" class="btn col offset-l1" value="Update" style="width:80%;height:27px;padding-bottom: 32px;">
 	</div>

 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
</form>
</c:when>







<c:otherwise>
<table>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Source Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.srcReachedDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Loading Completed</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.loadingDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Destination Reached</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.destReachedDateTime}</td>
</tr>
<tr>
<td><i class="fa fa-check" aria-hidden="true" style="color:green;font-size:17px;">&nbsp;&nbsp;Unloading Finished</i></td>
<td><i class="fa fa-clock-o"></i>&nbsp;${telePostinfo.unloadingDateTime}</td>
</tr>
</table>





</c:otherwise>




</c:choose>
 


 
 </c:when>
</c:choose>
</div>
</div>

</fieldset>

<c:choose>
<c:when test="${telePostinfo.status.equals('Trip Finished')}">
<fieldset>
	<legend style="color:#1253A4;"><i class="fa fa-rupee"></i>&nbsp;<b>Payment</b></legend>
	<form action="custPayment" method="Post">
	
	<table>
	<tr>
		<td>Total Amount</td>
		<td><input type="text" name="totalAmount1" value="${telePostinfo.totalAmount}"></td>
		<td>
		<input type="submit" class="btn" value="Confirm Payment"style="height: 20px;line-height: 20px;">
		</td>
	</tr>

	</table>
		

		 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
		
	</form>
</fieldset>
</c:when>

<c:when test="${telePostinfo.status.equals('Completed')}">
<fieldset>
<legend style="color:#1253A4;"><i class="fa fa-rupee"></i>&nbsp;<b>Payment Details</b></legend>
<form action="invoice" method="Get" target="TheWindow">
<table>
	<tr>
	<th>Customer Amount</th>
	<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.totalAmount}</td>
	</tr>
	<tr>
	<th>Gtruckways Amount</th>
	<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.gtruckwaysAmount}</td>
	</tr>
	<tr>
	<th>Driver Amount</th>
	<td><i class="fa fa-rupee"></i>&nbsp;${telePostinfo.driverAmount}</td>
	</tr>
	<tr>
	<td><input type="submit" value="Show Invoice" onclick="window.open('', 'TheWindow');" class=" genarate col push-l6"></td>
	
	</tr>
</table>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
</form>
</fieldset>
</c:when>
</c:choose>
</div>






</div>




</div>









<!-- Extra Charges -->


<!-- ./row -->

<c:choose>
<c:when test="${telePostinfo.status != 'Canceled'}">

<c:choose>
<c:when test="${TransList != null}">
<div id="SearchTransporter" class="modal">
  <div class="modal-content">
  <!-- <form action="confirmTrans" method="post"> -->
    <h5 class="center" style="color:#0288d1">Active Driver Details</h5>

    <table class="responsive-table centered" >
                <thead>
                  <tr class="row1">
                  		<th class="head" >Driver Id</th>
                  		<th class="head" >Vehicle&nbsp;Name</th>
                  		<th class="head" >Truck&nbsp;Reg&nbsp;Num</th>
                  		<th class="head" >Driver&nbsp;Name</th>
                      	<th class="head" >Driver&nbsp;Contact</th>
                     
                      	
                    
                    
                  <th class="head">Confirmation</th> 
                  </tr>
                </thead>
                
                <c:forEach var="tr" items="${TransList}">
                  
                <tbody>
               
                  <tr class="row1">
                  		<td class="data"><input type="text" name="vehDriverId" value="${tr.driverId.driverId}" readonly/></td>
                  		<td class="data"><input type="text" name="vehName" value="${tr.vehicleName}" readonly/></td>
                  		<td class="data"><input type="text" name="vehRegNo" value="${tr.vehicleRegistrationNo}" readonly/></td>
                 		<td class="data"><input type="text" name="driver" value="${tr.driverId.driverName}" readonly/></td>
                     	<td class="data"><input type="text" name="driverMobile" value="${tr.driverId.mobile}" readonly/></td>
         
                    <form action="confirmTrans" method="Post">   
                   <input type="hidden" name="driverId" value="${tr.driverId.driverId}"></td>                   
                  <td class="data"><input type="submit" class="btn" value="confirm"></td> 
                   </form>
                  </tr>
            
                </tbody>
            
                </c:forEach>
                 
                </table>
               
<!--       </form>  -->           
                
  </div>
  <div class="modal-footer">
    <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Close</a>
  </div>
</div>
</c:when>
<c:otherwise>
<div id="SearchTransporter" class="modal">
  <div class="modal-content">
  <!-- <form action="confirmTrans" method="post"> -->
    <h6 class="center" style="color:red">No transporter available for selected vehicle type </h6>
</div>
<div class="modal-footer">
    <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Close</a>
  </div>
</div>
</c:otherwise>
</c:choose>

 </c:when>
</c:choose>   


<!-- Modal Structure -->
						<div id="modal6" class="modal">
						  <div class="modal-content">
						  
						    <h5 class="center" style="color:#0288d1">Pricing Details</h5>
						    <table class="responsive-table centered" >
						                <thead>
						                  <tr class="row1">
						                  <th class="head">Truck Type</th>
						                <th class="head">Base fair</th>
						                <th class="head">Additional Price/Km</th>
						               <th class="head">Additional Price/Min</th>
						               <th class="head">Helper Charge</th> 
						                <th class="head">Night hour charges</th>
						                <th class="head">Dimension</th>
						                  </tr>
						                </thead>
						                <c:forEach var="truck" items="${TruckInfo}">
						                <tbody>
						                 <tr class="row1">
						                 <td>${truck.truckName}</td>
						                <td><i class="fa fa-rupee">&nbsp;${truck.basePrice}&nbsp;for 2&nbsp;kms & 60&nbsp;mins free</i></td>
						                <td><i class="fa fa-rupee">&nbsp;${truck.additionalPrice}&nbsp;for next 5&nbsp;km&nbsp;after&nbsp;that&nbsp;<i class="fa fa-rupee">&nbsp;${truck.secondPrice}&nbsp;/km</i></i></td>
						            	<td>${truck.additionalmins}&nbsp;Mins</td> 
						                <td>${truck.labourPrice}&nbsp;Rs</td>
						                <td>${truck.nightPrice}&nbsp;<i class="fa fa-times">&nbsp;TA</i></td>
						                <td>${truck.dimension}</td>
						                  </tr>
						                  
						                </tbody>
						                 </c:forEach>
						                </table>
						                
						  </div>
						  <div class="modal-footer">
						    <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Close</a>
						  </div>
						</div>
						<!-- Modal Structure 2-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-dtpicker.js"></script>   
</body>



<script type="text/javascript">

$("#manualprocess,#automate").click(function(){
    $("#manualprocshow,#totalpay").toggle("slow");
    $("#automateshow,#editpay").toggle("slow");
});

 document.getElementById('loading').onclick = function() {
      document.getElementById('loadind_det').style.display = 'block';
  }; 

 $("#srcReached,#destReached,#unloading").on('click', function() {
	    $('#loadind_det').hide();
	  
	});
   </script> 
 <!--  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->

 <script type="text/javascript">
			         $(function(){
			          $('*[name=userTravelDate]').appendDtpicker({
			           "autodateOnStart": false,
			            "closeOnSelected": true,
			            "futureOnly": true,
			            "closeButton": true,
			          });
			         });
			        </script> 

<script>
$(document).ready(function(){
	// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
	$('.modal-trigger').leanModal();
	initall();
		if (typeof initalls == 'function') { 
			initalls(); 
			}
	  });
$("#cancelbtn").click(function(){
	 $("#drive_can").show();
	});
	</script>
	
	<script>
  /*uppercase for license number*/
      $(document).ready(function()
      {
          $('#truckreg').keyup(function(){
              $(this).val($(this).val().toUpperCase());
          });
      });
  
      $("#hidebtn").click(function () {
     	 $("#content,#content1,#subbtn").remove();
     	$("#hidebtn").attr('value', 'Canceled');
     	 });
    </script>    
 <script type="text/javascript" src="js/telecallerPricing.js"></script>
    
  <script type="text/javascript" >
    
    function additionaPrice() {
    	
    	var additionalAmount;
    	var approximateAmount;
    	var kmPrice=document.getElementById("kmPriceId").value;
    	var MinsPrice=document.getElementById("minsPriceId").value; 
    	var extraKm=document.getElementById("kmId").value;
    	var extraMins=document.getElementById("minsId").value;
    	approximateAmount=document.getElementById("totalAmountId").value;
    	
    	additionalAmount=parseFloat(extraKm)*parseFloat(kmPrice);
    	additionalAmount=parseFloat(additionalAmount)+(parseFloat(extraMins)*parseFloat(MinsPrice));
    	//actualAmount=parseFloat(addtionalAmount)+parseFloat(approximateAmount);
    	
    	  document.getElementById("additionalPriceId").value=parseFloat(additionalAmount);
    	 // document.getElementById("totalAmountId").value=parseFloat(actualAmount);
    	
    }
    
  
    function  totalAmountPrice(){
    	
    	var actualAmount;
    	var additionalAmount=document.getElementById("additionalPriceId").value;
    	var approximateAmount=document.getElementById("totalId").value;
    	actualAmount=parseFloat(additionalAmount)+parseFloat(approximateAmount);
    	
    	document.getElementById("totalAmountId").value=parseFloat(actualAmount);
    	
    }
    
    </script> 
<script>
function totalprice(){
   
   var helper=0;
   var amount=document.getElementById("amountid").value; 
   var time=document.getElementById("date").value;
   var labour=document.getElementById("labourid").value; 
    helper=document.getElementById("helper").value; 

  
       var res = time.substr(11,2);
   
       var totalamount=parseFloat(amount);
      
      
       var totalamount1=0;
      
    if(((parseInt(res)>=0 && parseInt(res)<8) || (parseInt(res)>=20 && parseInt(res)<=23)) && helper!=0 ){
  	   	 
  		 totalamount1=parseFloat(totalamount)+parseFloat(labour)*helper;
  		 totalamount1= parseFloat(totalamount1*1.5); 
  		 
  	   } else if(((parseInt(res)>=0 && parseInt(res)<8) || (parseInt(res)>=20 && parseInt(res)<=23)) && helper==0 ){
  		   
  		 totalamount1=parseFloat(totalamount*1.5);
  		   
  	   }
  	   else if(helper!=0){
  		   
  		totalamount1=parseFloat(totalamount)+parseFloat(labour)*helper;
  	  
  	   }else{
  		   
  		totalamount1=parseFloat(totalamount);
  	   }
  	 
   
  	var tot=Math.ceil(totalamount1);
  	 var gst;
  	if(tot>=1500){
   		
		gst=tot*0.05;
 	   tot=tot+gst;
 	   
	   } else{
		
		 gst=0;
		 tot=tot+gst;
		   
	   } 	
  	
  	document.getElementById("amount").value=parseFloat(tot);
 
}







</script>
<script>

</script>
</html>