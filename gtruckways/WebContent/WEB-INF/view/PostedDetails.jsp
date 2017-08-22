<jsp:include page="localheader.jsp" /> 
  <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>

	<style>
nav
{
background-color:#1253A4;
}

	.modal {
    display: none;
    position: fixed;
    left: 0;
    right: 0;
    background-color: #fafafa;
    padding: 0;
    max-height: 90%;
    height:350px;
    width:70%;
    margin: auto;
    overflow-y: auto;
    border-radius: 2px;
    will-change: top, opacity;
}

h5{
color:#00aced;
}
.head {
    border: 1px solid #75caeb;
    text-align:center;
    padding: 8px;
    background:#51a9cc;
    color:white;
}
.data
{
 border: 1px solid #dddddd;
    text-align:left;
    padding: 8px;
}
.datatrack
{
 border: 1px solid #dddddd;
    text-align:center;
    padding: 8px;
    width:20%;
}

.row1:nth-child(odd) {
    background-color: #dddddd;
}
#dropdown_local{
	margin-top: 63px;
}
.dropdown-content li>a, .dropdown-content li>span {
    font-size: 16px;
    color: #1253a4;
    display: block;
    line-height: 22px;
    padding: 14px 16px;
    border:1px solid black;
}
.nobookings{
/* background-color: skyblue;
padding:5px;
margin-top:5rem; */
text-decoration: none;
    background: #c4d1d6;
    color: #fff;
    padding: 10px 20px;
    font-size: 20px;
    font-weight: 700;
    line-height: normal;
    text-transform: uppercase;
    border-radius: 3px;
    -webkit-transform: scale(1);
    -moz-transform: scale(1);
    transform: scale(1);
    transition: all 0.5s ease-out;
    text-align:center;
    margin:115px;
}
.nobookings h5{
color:red;
}
.back {
    text-decoration: none;
    background: #5b5a5a;
    color: #fff;
    padding: 10px 20px;
    font-size: 20px;
    font-weight: 700;
    line-height: normal;
    text-transform: uppercase;
    border-radius: 3px;
    -webkit-transform: scale(1);
    -moz-transform: scale(1);
    transform: scale(1);
    transition: all 0.5s ease-out;
}
	</style>
</head>
<body>


     <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>

        
 <c:choose>
<c:when test="${userinfo.loginStatusCode==200}">
<div>    

   
      
       
     
       <div class="container col s12 l12 m12">


<h5 class="" > Active Booking Details</h5>
<br>
<form action="#">
<table class="responsive-table">
<tr class="row1">
<th class="head">Booking Id</th>
<th class="head">Source</th>
<th class="head">Destination</th>
<th class="head">Amount</th>
<th class="head">Status</th>
<th class="head">Track</th> 
</tr>

 
<c:forEach var="post" items="${listPostinfo}"> 
<c:choose>
<c:when test="${post.status.equals('Booking Accepted')||post.status.equals('Customer Confirmed')||post.status.equals('Vehicle Arranged')||post.status.equals('Loading Completed')}">
<tr class="row1">
<td class="data">${post.bookingId}</td>
<td class="data">${post.price.route.fromCity}</td>
<td class="data">${post.price.route.toCity}</td>
<td class="data">${post.totalAmount}</td>
<td class="data">${post.status} </td>
<td class="datatrack"><a class="waves-effect waves-light" href="track?postid=${post.bookingId}&mobile=${post.user.mobileNo}">Track this order</a></td>
</tr>
</c:when>
</c:choose>
</c:forEach> 

</table>
</form>


<!--Modal Structure-->




</div>

<br>

<div class="container col l12 s12 m6">

<h5>Canceled&nbsp;/&nbsp;Completed Booking Details</h5>
<br>
<table class="responsive-table">
<tr class="row1">
<th class="head">Booking Id</th>
<th class="head">Source</th>
<th class="head">Destination</th>
<th class="head">Amount</th>
<th class="head">Status</th>
<th class="head">Track</th> 
</tr>
<c:forEach var="post" items="${listPostinfo}"> 
<c:choose>
<c:when test="${post.status.equals('Unloading Finished')||post.status.equals('Canceled')||post.status.equals('Completed')}"> 
<tr class="row1">
<td class="data">${post.bookingId}</td>
<td class="data">${post.price.route.fromCity}</td>
<td class="data">${post.price.route.toCity}</td>
<td class="data">${post.totalAmount}</td>
<td class="data">${post.status} </td>
<td class="datatrack"><a class="waves-effect waves-light" href="track?postid=${post.bookingId}&mobile=${post.user.mobileNo}">Show Details</a></td>
</tr>


</c:when>
</c:choose>
</c:forEach> 
</table>

</div>
</div>


 </c:when>
 
 <c:when test="${userinfo.loginStatusCode==204}">
 
 
 
 <div class="row">
 
  <div class="col s12 m12 l3 offset-l5 nobookings" >

 <h5 class="" style="font-family: 'Open Sans';">No Bookings Found</h5>
 </div>

 </div>

 
 



 </c:when>
 
 
 <c:when test="${saltString ne 'AAAA' && not empty loginerror}">
 
  <p style="margin-top:4rem"></p>
 <span  style="margin-left:35rem;">${loginerror}</span>
 <table height="80"> </table>
 </c:when>
 
  <c:when test="${saltString eq 'AAAA' && not empty loginerror}">
  
  <p style="margin-top:4rem"></p>
 <span  style="margin-left:35rem;">${loginerror}</span>
 <p></p>
 <div class="row">

 				 <form action="retforgot" method="post" id="fform" class="row"  >
 				 <div class="col s12 m12 l3 offset-l4">
 				 <fieldset>
               <h4 style="font-size:20px;margin-left:4rem">Forgot Password</h4>
			     <div class="input-field col s12 l10 offset-l1">
				  <input id="email_id"  name="email" type="text" class="validate" required /><span id="sp" style="color:#00BFFF"></span> 
				  <label for="email_id" style="top:0.60rem;color:#0288d1;">&nbsp;<i class="fa fa-user" ></i> &nbsp; Enter Your Email</label>
				</div> 
				
				
				<div class="input-field col s12 l10"  >
                  
                    <button id="last_name" type="submit" class="btn get validate" style="margin-left:1.8rem;width:100%;height:35px; font-size:20px;background-color:#3366CC;">Submit</button>
				
				</div>
				</fieldset>
				</div>    							
			</form>
			
			</div>
<table height="50"> </table>
 
 

 </c:when>
 
 
 
 
 
 
 
 
<c:when test="${userinfo.loginStatusCode==401}">
<div class="row">
  <div class="container" >
    <div class="row  center " >
      <br>

     <span>${loginerr}</span>
     <br><br>
     
        <form action="login" method="get" class="col l4 offset-m3 offset-l4" style="border:1px solid black;"   id="lform">
          <h5>Login</h5>
            <div class="input-field col s12 l12">
				       <input id="l_mobile"  type="text" name="mobileNo" class="validate" placeholder="Mobile Number" required/>
              
              <span id="sp"></span>
            </div>
            <div class="input-field col s12 l12" style="margin-bottom:20px;">
				       <input  name="password" id="pwd" type="password" class="validate" placeholder="Password" required/>      
					    <span id="forget" class="left"><a href="#"  style="color:rgba(255, 0, 0, 0.87)"><u>Forgot password?</u></a></span>
            </div>
            
            	
				
			<input type="submit" value="Login" class="btn" style="width:100%;height:40px; font-size:20px;background-color:#3366CC;" id="submit"  >
           <br><br>
        </form>
         <form action="retforgot" method="post" id="fform" class="col l4 offset-m3 offset-l4"style="display:none;border:1px solid black;" >
                <h5 class="center">  <span> <i class="fa fa-arrow-left" style="font-size:20px;cursor:pointer;" id="llink"></i></span>&nbsp;&nbsp;Forget Password</h5>
			     <div class="input-field col s12 l10 offset-l1">
				  <input id="email_id"  name="email" type="text" class="validate" required /><span id="sp" style="color:#00BFFF"></span> 
				  <label for="email_id" style="top:0.60rem;color:#0288d1;">&nbsp;<i class="fa fa-user" ></i> &nbsp; Enter Your Email</label>
				
				</div> 
				
				
				<div class="input-field col s12 l10"  >
                  
                    <button id="last_name" type="submit" class="btn get validate" style="margin-left:1.8rem;width:100%;height:35px; font-size:20px;background-color:#3366CC;margin-bottom:20px;">Get Link</button>
				
				</div>  
				 						
			</form>
			
    </div>
</div>

   
         
  </div>
 </c:when>
</c:choose>		
	
</body>
<jsp:include page="footer.jsp"/>
<script>
$("#forget").click(function(){
	$("#fform").show();
	$("#lform").hide();
})
$("#llink").click(function(){
	$("#lform").show();
	$("#fform").hide();
})
$("#signupclose").click(function(){
	  $("#fform").hide();
      $("#lform").show();
	});
$(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal-trigger').leanModal();
  });

$(document).keyup(function(e) {
    if (e.keyCode == 27) { // escape key maps to keycode `27`
       $('#modal1').closeModal();
   
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
</html>