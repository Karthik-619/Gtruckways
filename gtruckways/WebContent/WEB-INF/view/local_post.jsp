 <jsp:include page="localheader.jsp" />
 <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<script type="text/javascript" src="js/jquery-dtpicker.js"></script>
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=true&libraries=places&key=AIzaSyDr96kKx9kn-kt3urNoG43U6u4GViFQXhU"></script>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Arvo" />
<script type="text/javascript" src="js/createReqObj.js" ></script>
<script type="text/javascript" src="js/register.js" ></script>

 <style>
 body{
   width: 100%;
  margin: 0 auto;
 height:auto;
 font-family: 'Raleway', sans-serif;
 
 }
table.centered thead tr th, table.centered tbody tr td {
    text-align: left;
}
tr.row1:nth-child(odd) {
    background-color: #dddddd;

}

td.data
{
 border: 1px solid #dddddd;
    text-align:left;
    display: table-cell;
    
 
    border-radius: 2px;
}

.btn {
    text-decoration: none;
    color: #fff;
    background-color:#01579b;
    text-align: center;
    letter-spacing: .5px;
   transition: .2s ease-out; 
    cursor: pointer;
    height:40px;
    border-radius:120px;
    padding-left: 20px;
}

label.diff{
color:#1253a4;
}
/* select option */
select {
    background-color:#eee;
    width: 100%;
    padding: 5px;
    border: 1px solid black;
    border-radius: 2px;
    height: 2rem;
}
.row .col {
    float: left;
    box-sizing: border-box;
    padding: 0.2rem;
}

td {
width:320px
    padding: 9px 5px;
    display: table-cell;
    text-align: left;
    vertical-align: middle;
    border-radius: 2px;
}
.row .userin {
padding-right:5px;
border-right:1px solid gray;
}
.vehicle{
padding-left:15px;
}
 /*  datepickerclose*/
.datepicker > .datepicker_header > .icon-close {
    position: absolute;
    display: block;
    width: 30px;
    height: 16px;
    vertical-align: middle;
    padding: 8px;
    top: 0;
    right: 0;
}
 .modal {

    max-height: 90%;
    width: 35%;

}
 input:not([type])+label:after, input[type=text]+label:after, input[type=password]+label:after, input[type=email]+label:after, input[type=url]+label:after, input[type=time]+label:after, input[type=date]+label:after, input[type=datetime]+label:after, input[type=datetime-local]+label:after, input[type=tel]+label:after, input[type=number]+label:after, input[type=search]+label:after, textarea.materialize-textarea+label:after {
    display: inline;
    content: "";
    position: relative;
    top: 48px;
    opacity: 0;
    transition: .2s opacity ease-out, .2s color ease-out;
} 
#recipent_details{
display:none;
}
 @media ( max-width:603px ){
.proceed{
width:80%;

}
.note{
margin-left:1rem;
}

 }
   box-shadow: 0 0 3px #ccc, 0 10px 15px #ebebeb inset;
	}
.app.inr{
  position: relative;
  color:#01579b;
  font-size: 15px;
}
	.app.inr input{
	  background: #fcfcfc;
  border: 1px solid #aaa;
  border-radius: 5px;
  box-shadow: 0 0 3px #ccc, 0 10px 15px #ebebeb inset;
	}
	.app.inr input{
	text-indent: 30px;
	}
	.app.inr .fa-inr{
	  position: absolute;
  top: 8px;
  left: 18px;
	}
	.btn.promosub{
height:26px;
width:50%;
border-radius:3px;
line-height:1px;
}
.input-field label {
    color: #1253a4;
    }
    input:not([type]), input[name="promoCode"] {
    height: 1.6rem;
color:black;
  background: #fcfcfc;
  border: 1px solid #aaa;
  border-radius: 5px;
  box-shadow: 0 0 3px #ccc, 0 10px 15px #ebebeb inset;
}
.promo.input-field label {
    color: #9e9e9e;
    position: absolute;
    top: 0.45rem;
    left: 0.75rem;
    font-size: 1rem;
    cursor: text;
    transition: .2s ease-out;
}
#closeButton{
position:absolute; right:-2px; top:-2px;
cursor: pointer;
}
input[class="terms"],[type="checkbox"].filled-in:not(:checked)+label:after {
    height: 14px;
    width: 14px;
    background-color: transparent;
    border: 2px solid #5a5a5a;
    top: 6px;
    left: -16px;
    z-index: 0;
}
input[class="terms"],[type="checkbox"].filled-in:checked+label:before {
    top: 0;
    left: -20px;
    width: 7px;
    height: 16px;
    border-top: 2px solid transparent;
    border-left: 2px solid transparent;
    border-right: 2px solid #fff;
    border-bottom: 2px solid #fff;
    -webkit-transform: rotateZ(37deg);
    transform: rotateZ(37deg);
    -webkit-transform-origin: 100% 100%;
    transform-origin: 100% 100%;
}
input[class="terms"],[type="checkbox"].filled-in+label:before, input[class="terms"],[type="checkbox"].filled-in+label:after {
    content: '';
    left: -20px;
    position: absolute;
    transition: border .25s, background-color .25s, width .20s .1s, height .20s .1s, top .20s .1s, left .20s .1s;
    z-index: 1;
}
input[class="terms"],[type="checkbox"]:checked+label:before {
    top: -4px;
    left: -3px;
    width: 12px;
    height: 18px;
    border-top: 2px solid transparent;
    border-left: 2px solid transparent;
    border-right: 2px solid #26a69a;
    border-bottom: 2px solid #26a69a;
    -webkit-transform: rotate(40deg);
    transform: rotate(40deg);
    -webkit-backface-visibility: hidden;
    backface-visibility: hidden;
    -webkit-transform-origin: 100% 100%;
    transform-origin: 100% 100%;
}
input[class="terms"],[type="checkbox"]+label:before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 18px;
    height: 18px;
    z-index: 0;
    border: 2px solid #5a5a5a;
    border-radius: 1px;
    margin-top: 2px;
    transition: .2s;
}
input[class="terms"],[type="checkbox"].filled-in:checked+label:after {
    top: 6px;
    width: 17px;
    height: 14px;
    border: 2px solid #01579b;
    background-color: #1253a4;
    z-index: 0;
}
[type="checkbox"]+label.signup,[type="checkbox"]+label.helper{
left:20px;
}

[type="checkbox"]+label {
    position: relative;
    padding-left: 13px;
    cursor: pointer;
    display: inline-block;
    height: 25px;
    line-height: 25px;
    font-size: 1rem;
    -webkit-user-select: none;
    -moz-user-select: none;
    -khtml-user-select: none;
    -ms-user-select: none;
}
.card .card-content .card-title {
    line-height: 0px;
}
.card {
    position: relative;
    margin: 0rem 0 1rem 0;
    background-color: #fff;
    transition: box-shadow .25s;
    border-radius: 2px;
    border: 1px solid rgba(0, 0, 255, 0.25);
}
.card .card-action {
    border-top: none;
    padding: 6px;
}
.card .card-title {
    font-size: 22px;
    /* border-bottom: 1px solid black; */
    font-weight: 300;
}
input[name="totalAmount"] {
    padding: .2rem;
    border: none;
    text-align: center;
    margin: 0rem 0 0 0rem;
    bold: 20px;
    font-size: 30px;
    height:40px;
    border:2px solid #1253a4;
    color:#1253a4;
    font-weight:500;
}
</style>



	<div class="row col s12 m12 l12 note center" ><b >Note:The price is an approximate.</b></div>
	
<!--main div  -->
<div class="row">
<!-- vehicle information and vehicle image -->
	<div class="card z-depth-4 col s12 m12 l4">
		<div class="card-content">
			<div class="card-title">
			<div style="color:#0a6ed2;font-family:Rockwell, 'Courier Bold', Courier, Georgia, Times, 'Times New Roman', serif;" class="center">Vehicle Information</div>
	
			</div>
			<br>
			<div class="card-action">
			 <table  class="bordered">
			 <tr>
			 <td>Vehicle Name</td>
			 <td><i class="fa fa-truck">&nbsp;${priceinfo.info.truckName}</i></td>
	
			 </tr>
			 <tr>
			  <td>Dimension</td>
			 <td><i class="fa fa-cube">&nbsp;${priceinfo.info.dimension} feet</i></td>
			 </tr>
			 <tr>
			  <td>Capacity</td>
			 <td><i class="fa fa-balance-scale"></i>&nbsp;${priceinfo.info.capacity}</td>
			 </tr>
			  <tr>
			  <td>Base Fare</td>
			 <td><i class="fa fa-rupee">&nbsp;${priceinfo.info.basePrice}&nbsp;for ${priceinfo.info.freeKm}&nbsp;kms & ${priceinfo.info.freeMins}&nbsp;mins free</i></td>
			 </tr>
			<c:choose> 
			 <c:when test="${priceinfo.info.truckId==1}">
			 
			 <tr>
			  <td>Additional KM</td>
			 <td><i class="fa fa-rupee">&nbsp;${priceinfo.info.additionalPrice}&nbsp;/km&nbsp;</i></i></td>
			 </tr>
			 
			 </c:when>
			 <c:otherwise>
			 
			 <tr>
			  <td>Additional KM</td>
			 <td><i class="fa fa-rupee">&nbsp;${priceinfo.info.additionalPrice}&nbsp;for next ${priceinfo.info.slab2Km}&nbsp;km&nbsp;after&nbsp;that&nbsp;<i class="fa fa-rupee">&nbsp;${priceinfo.info.secondPrice}&nbsp;/km</i></i></td>
			 </tr>
			 
			 </c:otherwise>
			 
			 </c:choose>
			  <tr>
			  <td>Additional Minutes</td>
			 <td><i class="fa fa-rupee">&nbsp;${priceinfo.info.additionalmins}&nbsp;/min</i></td>
			 </tr>
			  <tr>
			  <td>GST</td>
			 <td>5%&nbsp;<i class="fa fa-times">&nbsp;Total Price </i></td>
			 </tr>
			 </table>
			 
			 <c:choose>
<c:when test="${priceinfo.info.truckId==1}">

 <div class="row center">
<img src="img/Tata-Aceland.png" width="267px" height="200px"style=" " >
</div>
 </c:when>
 <c:when test="${priceinfo.info.truckId==2}">
<div class="row">
<img src="img/407.png" width="100%" height="200px" >
</div>
</c:when>
<c:when test="${priceinfo.info.truckId==6}">
<div class="row">
<img src="img/TataSuperAce.jpg" width="100%" height="230px">
</div>
</c:when>
<c:otherwise>
<div class="row">
<img src="img/canter17.jpg" width="100%" height="230px" >
</div>
</c:otherwise>

</c:choose>
			</div>
		</div>
		
	</div>
<!--./vehicle information and vehicle image -->


<!-- user information and price  -->

<div class="card col s12 m12 l4">
	<div class="card-content">
		<div class="card-title">
			<div style="color:#0a6ed2;font-family:Rockwell, 'Courier Bold', Courier, Georgia, Times, 'Times New Roman', serif;" class="center">Customer Information</div>
			
		</div>

		<div class="card-action">
	<table height="10"></table>


<c:choose>
<c:when test="${priceinfo.route.fromCity.equals(null)||postinfo.postId==0}">
	
  
   <!--  first time -->
 <table class="bordered">
<tr>
<td>Name</td>
<td><i class="fa fa-user"></i>&nbsp;${postinfo.user.userName}</td>
</tr>
<tr>
<td>Mobile No</td>
<td><i class="fa fa-mobile"></i>&nbsp;${postinfo.user.mobileNo}</td>
</tr>
<tr>
<td>Email-Id</td>
<td><i class="fa fa-envelope"></i>&nbsp;${postinfo.user.email}</td>
</tr>
<tr>
<td>Travel Date and Time</td>
<td><i class="fa fa-calendar"></i>&nbsp;${postinfo.travelDate}</td>
</tr>
<tr>
<td>Material</td>
<td><i class="fa fa-archive"></i>&nbsp;${postinfo.material}</td>
</tr>
<tr>
<td>Pickup</td>
<td><textarea style="border:none;background-color: #e6e6e6;height:20px" readonly>${postinfo.pickUpArea}</textarea></td>
</tr>
<tr>
<td>Drop</td>
<td><textarea style="border:none;background-color: #e6e6e6;height:20px;" readonly>${postinfo.dropArea}</textarea></td>
</tr>
</table>  
  
  <div class=" row ">
 <div class=" center black-text rupee " style="" >
<br>
 <!-- <span>Total Price:</span> -->

 <div style="border:1px solid rgba(0, 0, 0, 0.28)" class="col s12 m12 l8 push-l2">
  <span class="fa fa-rupee"></span>
 <b style="font-size:23px;">${postinfo.totalAmount}</b></div>
  
   </div><br><br>

 <form  action="confirm" method="Post" id="frm1">
 <p style="text-align:center;font-size:10px;font-weight:300">${errormsg} </p> 
  <div class="input-field pencil col s12 m12 l8 push-l2" style="padding:0px;">
  <span class="fa fa-pencil" style="font-size:20px"></span>
			 <input  type="password" name="otp" style="" pattern="^[0-9]*$" class="validate otp" placeholder="Enter OTP" required>
			 </div>
			 <div>	
			 <div class="input-field col s12 l12 confirm">
		 	<input type="submit" value="Confirm Booking" class="btn proceed col " id="send1"  style="background-color:#3366CC;width:100%;font-size:15px;border-radius:0px"   >	 	
		 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
		</div>	
		</div>
		</form>
	</div>    
</c:when>



 <c:when test="${postinfo.user.otp.otpId!=0}">
<!--/user info  -->
<!--  second time -->

<form action="getprice" method="Post" id="frm">
<c:choose>
 <c:when test="${userinfo.loginStatusCode==200 || userinfo.loginStatusCode==204}">  
 
 
 <div class="row">
         <div class="input-field col s12 l6 user">
          <span class="fa fa-user"></span>
		   <input  id="lname" type="text" name="userName" value="${userinfo.userName}" readonly>
		</div>
		 

	<div class="input-field col s12 l6  phone-square">
					 <span class="fa fa-phone-square"></span> 
										
					 <input   type="text" name="mobileNo" value="${userinfo.mobileNo}" readonly/> 
					 
		</div>
	</div>
 	<div class="row">
		  <div class="input-field col s12 l6 envelope">
		   <span> <i class="fa fa-envelope"></i></span>
			 <input type="text" name="email" value="${userinfo.email}" readonly>
			 
		</div>
		
		
		
		<div class="input-field col s12 l6 credit-card">
		<span class="fa fa-credit-card"></span>
		<c:choose>
		<c:when test="${userinfo.gstNumber ne 'GGGG' }">
		<input type="text" name="gstNumber" placeholder="GST No (for business)" value="${userinfo.gstNumber}" readonly>
		</c:when>
		<c:otherwise>
		<input type="text" name="gstNumber" placeholder="GST No (for business)" >
		</c:otherwise>
		</c:choose>
		</div>
		

		</div>
<span id="dateerror" style="font-size:11px;margin-left:15rem;color:red;"></span>
 			 <span id="dateerror1" style="font-size:11px;color:red;"></span>

 
 
		</c:when>
		<c:otherwise>
		
 <div class="row">
         <div class="input-field col s12 l6 user">
          <span class="fa fa-user"></span>
		   <input  id="lname" type="text" name="userName" class="validate"   pattern="^[a-zA-Z-_\s'.]{1,}$" placeholder="Name" maxlength="45" required>
			<label for="lname" data-error="Invalid Name" ></label>
		 </div>
		 

	<div class="input-field col s12 l6  phone-square">
					 <span class="fa fa-phone-square"></span> 
										
					 <input   type="text" name="mobileNo" id="Gmobile" class="validate" placeholder="Mobile Number" pattern="^[789]\d{9}$" maxlength="10" value="${mobileNo}" required/> 
					 <span id="leml"></span>
		 			<label for="Gmobile" data-error="InvalidNo"></label>
		</div>
	</div>		
	<div class="row">
		  <div class="input-field col s12 l6 envelope">
		   <span> <i class="fa fa-envelope"></i></span>
			 <input  id="lemail" type="text" name="email" class="validate" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})"  placeholder="Email Id" required>
			 <label for="lemail" data-error="Invalid Email"> </label>
		</div>


		<div class="input-field col s12 l6 credit-card">
		<span class="fa fa-credit-card"></span>
		<input type="text" name="gstNumber" placeholder="GST No (for business)" id="gstId" class="validate" pattern="[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{2}" maxlength="15">
		</div>



		</div>
			 <span id="dateerror" style="font-size:11px;margin-left:15rem;color:red;"></span>
			 <span id="dateerror1" style="font-size:11px;color:red;"></span>	
	</c:otherwise>
		</c:choose>
	<div class="row">
		<div class="input-field col s12 l6 suitcase">
	
		<span class="fa fa-suitcase"></span>
		<label class="hide" >Select Material</label>
								<select class="browser-default" name="material" id="mat" required="required" >
								   <option selected disabled value="" >Select Material</option>
								   <c:forEach var="item" items="${MaterialList}">
    						 		<option>${item}</option>
   									</c:forEach>
								
							</select>
		</div>
		<div class="input-field col s12 m6 l6 calendar">
		<span class="fa fa-calendar"></span>
			<!-- <input type="text" name="travelDate" placeholder="Date&Time" id="date_foo" onchange="totalprice()" class="validate" pattern="(\d{4}-\d{2}-\d{2} \d{2}:\d{2})" required>
			<label for="date_foo" data-error="Invalid Date"></label>  -->
			<input type="hidden" value="${priceinfo.serverDate}" id="serverdate">
			<input type="hidden" value="${priceinfo.serverTime}" id="servertime">
			<input type="hidden" value="${priceinfo.nextDate}" id="nextDate">
			<input type="text" name="travelDate" placeholder="Date&Time" id="date_foo" onchange="totalprice();datepicker1();"  class="readonly dtpicker2"  autocomplete="off"  required>
			<label for="date_foo" ></label>
			 <script type="text/javascript">
			 $('#date_foo').appendDtpicker({
					"autodateOnStart": false,
					 "closeOnSelected": true,
					 "futureOnly": true,
						/* "amPmInTimeList": true, */
						"closeButton": true,
					
				});
				
			
					
						
					
					 		$( document ).ready(function() {
					 	
							
							// -- append by class just for lower strings count --
					
							var milliseconds = new Date().getTime() + (2 * 60 * 60 * 1000); //2 hours diffrence
							var later = new Date(milliseconds);
						
							var time=(later.toTimeString().substring(0, 5));//to get only hours and minitues
						
						var start=new Date().toISOString().substring(0, 10); //to get only current date 
						
						var dateTime=start+ ' '+time; //concatinating date and time
					
							 $('#date_foo').handleDtpicker('setDate', dateTime);	  //set date time to the input field
							//$("#date_foo").val("");
							 
							   var de = new Date($('#date_foo').handleDtpicker('getDate')); // constructor need to avoid linking object
							 de.setDate(de.getDate() + 7);//current date+7days
							 
								 	$('#date_foo').handleDtpicker('setMaxDate', de);  //set min end date is 7 day later then start date to display it on datepicker
								 	  $("#date_foo").val(""); 
								 	
						
						});
			
						 
			 </script>
		</div>
	</div>
	<!-- <div class="row">
		<div class="input-field app inr col s12 m12 l6 ">
		<span><i class="fa fa-inr"  style="font-size:15px;color:#01579b;margin-top:0.2rem;"></i></span>
		<input type="number" name="valueOfGoods" min="0"    placeholder="Value Of Goods"  class="validate" required>
		<label for=""></label>
		</div>
		
		<div class="row">
			<div class="input-field col s12 m12 l6 balance-scale">
			
			<span class="fa fa-balance-scale" style="font-size:15px;color:#01579b;margin-top:0.2rem;"></span>
			<input type="number" name="approximateWeight" min="0"   placeholder="Apprx Weight" class="validate" required>
			<label for=""></label>
			</div>
		</div>
	</div> -->
		<div class="row" style="margin-top:2px;">
		<div class="input-fiels col s12 l6 map-marker">
		<span class="fa fa-map-marker"></span>
		 <textarea  name="pickupArea" class="text_content" style="height:50px;font-family: Roboto, sans-serif;" maxlength="150" placeholder="Pickup point (optional)" ></textarea>
		</div>
		<div class="input-fiels col s12 l6  map-marker">
				 <span class="fa fa-map-marker"></span>
		 <textarea cols="12" rows="12" name="dropArea" style="height:50px;font-family: Roboto, sans-serif;" maxlength="150" class="text_content" placeholder="Drop point (optional)" ></textarea>
		</div>					
		</div>

<div class="row">

   
    </div>
<div class="row">
  <input type="hidden" name="labour" id="labourid" value="${priceinfo.info.labourPrice}">
 <div class="input-field col s12 l6 ">
     <span>  <input type="checkbox" name="helper" class="filled-in" id="driverasHelper" value="1" onchange="totalprice()"/>
      <label for="driverasHelper"  style="font-size:14px;" class="diff left helper"> <b>Driver As Helper</b></label>
     
    </span>
    </div>
    <div class="input-field col s12 l6 ">
     <span>  <input type="checkbox" name="diffRecepient" class="filled-in" id="diff_recipent"  value="1"  />
      <label for="diff_recipent" class="diff left" > <b>Different Recipient</b></label>
    </span>
    </div>
    </div>
    
     <div class="row "  id="recipent_details" style="padding:0;">
         <div class="input-field col s12 l6 user">
          <span class="fa fa-user"></span>
		   <input  id="rlname" type="text" name="recepientName" class="validate z-depth-3" pattern="^[a-zA-Z-_\s'.]{1,}$" maxlength="45" placeholder="Name" >
			<label for="rlname" data-error="Invalid Name"></label>
		 </div>
		<div class="input-field col s12 l6  phone-square">
		<span class="fa fa-phone-square"></span>
		 <input  id="rlmobile" type="text" name="recepientMobileNo" pattern="^[789]\d{9}$" maxlength="10" class="validate" placeholder="Mobile No" >
		 <label for="rlmobile" data-error="Invalid No"> </label>
		</div>
		</div>

<c:choose>
 <c:when test="${userinfo.loginStatusCode!=200}">  
<div class="input-field col s12 l6" id="signUpDivId" style="padding:0;">
   <span> <input type="checkbox"  name="autoRegister" class="filled-in" checked="checked" value="1" id="test5" />
      <label for="test5" class="diff left signup"> <b>Signup for gtruckways</b></label>
    </span> 
    </div>
</c:when>
</c:choose>
 

 
 <br>
 <div class="row">



<div class="row ">
<br>
 <span id="promomsg1" style="font-size:13px;margin-left:5rem;margin-top:-2rem;"></span>
<div class="row">

<div class="input-field  inr " style="margin-top:0rem;">
<span style="padding:0px;font-family:Verdana, Geneva, sans-serif">Total Price:</span>
<span class="fa fa-inr" style="color:#1253a4;" ></span> 

<input type="text" name="totalAmount" id="amount" style="padding:0px;" class="col s12 m12 l8 offset-l2" value=" ${priceinfo.totalAmount}" readonly> 
  <input type="hidden" name="amount" id="amountid" value="${priceinfo.approximateAmount}"/> 
   <input type="hidden" name="approxAmount" id="approxAmountid" value="${priceinfo.totalAmount}"/> 
</div>

</div>
</div>
</div>
<div class=" row  ">
<div class="col s12 m12 l12 ">
<a href="#" class="col offset-l3" id="promocode" style="font-size:13px;color:#0a6ed2;text-transform:none;">Have a Promocode?Apply here!</a> 
<div class="row hidden" id="applypromocode">
<div class="input-field promo col s12 m12 l4 offset-l3">
<input type="text" name="promoCode" id="promocodeId" placeholder="Enter Promocode"  style="font-size:12px;"class="validate" >
</div>
<div class="row input-field col s12 m12 l5">
<input type="button" class="btn promosub" value="Apply" onClick="sendCoupon()">
</div>
</div>
</div>
<input type="hidden" name="status" id="statuscodeid" value="0"/> 


<form name="couponForm">
<div class="row hidden" id="applypromocode">
<div class="input-field promo col s12 m12 l4 offset-l3">
<input type="text" name="promoCode" id="promocodeId" placeholder="Enter Promocode"  style="font-size:12px;"class="validate" >
</div>
<div class="row input-field col s12 m12 l5">
<input type="button" class="btn promosub" value="Apply" onClick="sendCoupon()">
</div>


</div>
</form>
<input type="hidden" name="promocode" id="promoId" value="Not Applied" /> 
<input type="hidden" name="discountAmount" id="discountId" value="0"/> 

<div class="row" style="margin-top:-10px;">
<span> &nbsp;&nbsp; <input type="checkbox"  name="" class="filled-in terms" value="" id="terms" />
      <label for="terms" class="diff accept" style="margin-left:28%;font-size:13px;"> I accept&nbsp;<a href="terms" target="_blank" style="color:#9c27b0;font-size:14px;text-transform:none;"><u>terms&conditions</u></a></label>
</div>
<div class="input-field " id="proceed" >
<div>	
	<input type="submit" value="Proceed"  class="btn  proceed" id="send"  style="width:100%;font-size:15px;background-color:#3366CC;border-radius:0;"  disabled >
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
</div>
</div>
</div>

 </form>
</c:when>
</c:choose>

 </div>

		</div>
	</div>


	


<!--./user information and price  -->



<!-- trip detailas and map  -->
<div class="card col s12 m12 l4">
	<div class="card-content">
		<div class="card-title">
			<div style="color:#0a6ed2;font-family:Rockwell, 'Courier Bold', Courier, Georgia, Times, 'Times New Roman', serif;" class="center">  Trip Details</div>
			<br>
		
		</div>
		<div class="card-action">
		<br>
		<div>
			<div id="map"  style="height:265px;opacity: 1;box-shadow: rgb(102, 102, 102) 0px 0px 0.8em; position: relative; overflow: hidden;"></div> 
         <input type="text" value="${priceinfo.route.fromCity}" id="src" style="display:none">
          <input type="text" value="${priceinfo.route.toCity} " id="dest" style="display:none">
          </div>
          <br>
          <div class="row">
         
          	<table class="bordered">
	<tr>
	<td>Distance</td>
	<td><i class="fa fa-road">&nbsp;${priceinfo.route.distance} km</i></td>
	</tr>
	<tr>
	<td>Travel Time</td>
	<td><i class="fa fa-clock-o">&nbsp;${priceinfo.route.time} mins</i> [&nbsp;${priceinfo.info.freeMins}&nbsp;mins free ] </td>
	</tr>
	<tr>
	<td>Driver As Helper</td>
	<td><i class="fa fa-rupee">&nbsp;${priceinfo.info.labourPrice}&nbsp;[If required ] </i></td>
	</tr>
	<tr>
	<td>Night Charges</td>
	<td><i class="fa fa-rupee">&nbsp;${priceinfo.info.nightPrice}&nbsp;<i class="fa fa-times">&nbsp;Total Price </i> </i></td>
	</tr>
	</table>

	</div>
	<br>
	
		</div>
	</div>
	<table height="10"></table>
</div>
<!--./user information and price  -->


</div>
 

<!-- 
<div class="row center" style="padding:5px;background-color: rgba(15, 41, 28, 0.5) !important;">
<b>Note:The above price is an approximate  and it excludes GST</b>
</div> -->

<div id="modal3" class="modal col s12 l12 m6">
   
  <div class="modal-content ">
    <a href="#" class="fa fa-close modal-action modal-close right"  ></a>
   <h4 class="center mtitle" style="font-size:20px;">Price Chart</h4>
					<div class="" >						    	 	 		 
						   <table class="centered" >
						   
						                <tr class="row1">
						                <td class="price data">Base Fare &nbsp;<small>(2 km and 60 min free)</small></td>
						                <td class="price data"><i class="fa fa-rupee">&nbsp;${priceinfo.info.basePrice}</i></td>
						                </tr>
						                 <tr class="row1">
						                <td class="price data">Additional Km</td>
						                <%--   <td class="price data"><i class="fa fa-rupee">&nbsp;</i>${priceinfo.info.additionalPrice}&nbsp;<i class="fa fa-times">&nbsp;</i><fmt:formatNumber type="number" maxFractionDigits="2" value="5"/>&nbsp;km</td> --%>
						                <td class="price data"><i class="fa fa-rupee">&nbsp;</i>${priceinfo.info.secondPrice}&nbsp;<%-- <i class="fa fa-times">&nbsp;</i><fmt:formatNumber type="number" maxFractionDigits="2" value="${priceinfo.extraDistance}"/> --%>/km</td>
						                </tr>
						                  <tr class="row1">
						                <td class="price data">Additional Mins</td>
						                <td class="price data"><i class="fa fa-rupee">&nbsp;</i>${priceinfo.info.additionalmins}&nbsp;<%-- <i class="fa fa-times">&nbsp;</i>${priceinfo.extraMins} --%>/min</td>
						                </tr>
						          
										    <tr class="row1">
						                <td class="price data">Driver As Helper &nbsp;<small>( If required )</small></td>
						                <td class="price data"><i class="fa fa-rupee">&nbsp;</i>${priceinfo.info.labourPrice}&nbsp;</td>
						                </tr>
						          
																          
						                  <tr class="row1">
						                <td class="price data">Night Charges</td>
						                <td class="price data"><i class="fa fa-rupee">&nbsp;${priceinfo.info.nightPrice}&nbsp;<i class="fa fa-times">&nbsp;Total Price </i> </i></td>
						                </tr>
						                  <tr class="row1">
										  <td class="price data">GST</td>
										 <td class="price data">5%&nbsp;<i class="fa fa-times">&nbsp;Total Price </i></td>
										 </tr>
						                </table>
						                
						  </div>
  
   

  </div>
  </div>

<script>  
$('#terms').change(function () {
    if (this.checked) {
        $(".proceed").removeAttr('disabled');
    } else {
        $(".proceed").attr("disabled", "true");
    }
});





document.getElementById('closeButton').addEventListener('click', function(e) {
    e.preventDefault();
    this.parentNode.style.display = 'none';
}, false);

var request;  
function sendCoupon() 
{  

var amount=document.getElementById("amount").value;  
var travelDate=document.getElementById("date_foo").value;
var promoCode=document.getElementById("promocodeId").value;  
var statusCode=document.getElementById("statuscodeid").value; 

var url="ajaxCoupon?promoCode="+promoCode+"&totalAmount="+amount+"&status="+statusCode+"&travelDate="+travelDate;  

if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try  
{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}  
catch(e)  
{  
alert("Unable to connect to server");  
}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;

var obj=JSON.parse(val);
var tot=obj.amount
document.getElementById('amount').value=Math.ceil(tot);  
document.getElementById('promomsg1').innerHTML=obj.msg
document.getElementById('statuscodeid').value=obj.status
document.getElementById('promoId').value=obj.promocode;
document.getElementById('discountId').value=obj.discount;
}

}  
  
</script> 











<script>
$(document).ready(function()
		{
		    $('#promocodeId').keyup(function()
		    {
		        $(this).val($(this).val().toUpperCase());
		    });
		});
$("#promocode").click(function(){
	$("#applypromocode").toggle();
});
$(".promosub").click(function(){
	$("#applypromocode").hide();
});
document.getElementById("labourid").onclick=function(e){
	if(this.value==0){
		document.getElementById("floorid").disabled=true;
		document.getElementById("floorid").value=0;
	}else if(this.value==1 || this.value==2){
		document.getElementById("floorid").value=0;
		document.getElementById("floorid").disabled=false;
	}
}
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
  
$('#diff_recipent').change(function() {
    if(!$(this).is(':checked'))
    	
     $("#rlname").val("");
   
 $("#rlmobile").val("");

 
});

</script>
<script>

$('#frm,#frm1').bind('submit', function (e) {
    var button = $('#send,#send1');

    // Disable the submit button while evaluating if the form should be submitted
    button.prop('disabled', true);

    var valid = true;    

    // Do stuff (validations, etc) here and set
    // "valid" to false if the validation fails

    if (!valid) { 
        // Prevent form from submitting if validation failed
        e.preventDefault();

        // Reactivate the button if the form was not submitted
        button.prop('disabled', false);
    }
});




  

</script> 


<script type="text/javascript" src="js/local_pricing.js"></script>
  
<script>
    $(".readonly,readonly1").on('keydown paste', function(e){
        e.preventDefault();
    });
</script>
