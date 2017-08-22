 <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<script src="js/jquery.js"></script>
 <jsp:include page="localheader.jsp" />
<style>

body,
html {
  background: #eee;
  font-size: 14px;
  color: #333;
  font-family: "Open Sans", "Helvetica Neue", "sans-serif";
}

* {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}


.step-container {
  margin: 3% auto;
  text-align: center;
}
.step-container .step {
  position: relative;
  z-index: 2;
  display: inline-block;k
  text-align: center;
  background: #000;
     width: 72px;
    height: 67px;
  font-weight: bold;
    border-radius: 36%;
    padding-top: 15px;
  transition: background 1000ms ease, color 1000ms ease;
  transition-delay: 800ms;
  background:  linear-gradient(to right, #1253a4 50%, rgba(158, 158, 158, 0.69) 50%);
     font-size: 13px;
  background-size: 200% 100%;
  background-position: right bottom;

}
.step-container .step.active {
  background-position: left bottom;
  color: #fff;
}
.step-container .step-separator {

  position: relative;
  z-index: 1;
  background: #444;
    height: 19px;
  width: 100px;
 margin: 0 -8px 2px -9px;
  display: inline-block;
     background:linear-gradient(to right, #1253a4 50%, rgb(183, 183, 183) 50%);
  background-size: 200% 100%;
  background-position: right bottom;
  transition: background 1000ms ease;
}
.step-container .step-separator.active {
  background-position: left bottom;
}

.step-container .step1 {
    position: relative;
    z-index: 2;
    display: inline-block;
    background: #000;
    width: 100px;
    height: 80px;
    font-weight: bold;
    border-radius: 50%;
    padding-top: 20px;
    transition: background 1000ms ease, color 1000ms ease;
    transition-delay: 800ms;
    background: linear-gradient(to right, #79A529 50%, rgba(244, 67, 54, 0.77) 50%);
    background-size: 200% 100%;
    background-position: right bottom;
}
.step-container .step-separator1 {
    position: relative;
    z-index: 1;
    background: #444;
    height: 20px;
    width: 100px;
    margin: 0 -9px 5px -9px;
    display: inline-block;
    background: linear-gradient(to right, #79A529 50%, rgb(183, 183, 183) 50%);
    background-size: 200% 100%;
    background-position: right bottom;
    transition: background 1000ms ease;
}
@media ( max-width:603px ){
 .step-container .step{
position: relative;
  z-index: 2;
  display: inline-block;
  text-align: center;
  background: #000;
     width:80%;
    height: 37px;
  font-weight: bold;
    border-radius: 25%;
    padding-top: 10px;
  transition: background 1000ms ease, color 1000ms ease;
  transition-delay: 800ms;
background:  linear-gradient(to right, #1253a4 50%, rgba(158, 158, 158, 0.69) 50%);
     font-size: 13px;
  background-size: 200% 100%;
  background-position: right bottom;
  margin-bottom:4px;
 }
 @media(max-width:603px){
 .step-container .step.active {
  background-position: left bottom;
  color: #fff;
}
 }
 
 @media(max-width:603px)
 {
 .step-container .step-separator {

  position: relative;
  z-index: 1;
  background: #444;
    height: 0px;
  width: 0px;
 margin: 0 -8px 10px -9px;
  display: inline-block;
     background: linear-gradient(to right, rgb(18, 83, 164) 50%, rgb(183, 183, 183) 50%);
  background-size: 200% 100%;
  background-position: right bottom;
  transition: background 1000ms ease;
}
 
 }
 @media(max-width:603px){

 .step-container .step-separator.active {
  background-position: left bottom;
 
 }
 }
</style>

<body>

<c:choose>
<c:when test="${empty error && !postinfo.equals(null)}">



<div class="row col s12 l12 m6">
<span>${error}</span>
 <h5 class="center">
    Track Your Freight
  </h5>
<div class='step-container'>

 <c:choose>
<c:when test="${postinfo.status.equals('Booking Accepted')}"> 
  <div class='step active'>
   Booking Accepted
  </div>
 <div class='step-separator'></div>
<div class='step' >
    Customer Confirmed
  </div>
  <div class='step-separator'></div>
  <div class='step'>
   Vehicle Arranged
  </div>
  <div class='step-separator'></div>
   <div class='step' >
    Source Reached
  </div>
  <div class='step-separator'></div>
   <div class='step' >
    Loading Completed
  </div>
  <div class='step-separator'></div>
   <div class='step'>
    Destination Reached
  </div>
  <div class='step-separator' data-step='4'></div>
   <div class='step' data-step='5'>
   Unloading Finished	
 
  </div>
    <div class='step-separator'></div>
   <div class='step'>
   Trip Finished
  </div>

 </c:when> 
 
 

<c:when test="${postinfo.status.equals('Customer Confirmed')}"> 
<div class='step active'>
       Booking Accepted
  </div>
  <div class='step-separator active'></div>
  <div class='step active' >
    Customer Confirmed
  </div>
 <div class='step-separator'></div>
  <div class='step'>
    Vehicle Arranged
  </div>
    <div class='step-separator'></div>
   <div class='step' >
    Source Reached
  </div>
  <div class='step-separator'></div>
   <div class='step' >
    Loading Completed
  </div>
  <div class='step-separator'></div>
   <div class='step'>
    Destination Reached
  </div>
  <div class='step-separator'></div>
   <div class='step'>
  Unloading Finished
  </div>
    <div class='step-separator'></div>
   <div class='step'>
   Trip Finished
  </div>
</c:when> 

 <c:when test="${postinfo.status.equals('Vehicle Arranged')}"> 
 <div class='step active'>
       Booking Accepted
  </div>
  <div class='step-separator active'></div>
  <div class='step active' >
   Customer Confirmed
  </div>
  <div class='step-separator active'></div>
  <div class='step active'>
   Vehicle Arranged
  </div>
   <div class='step-separator'></div>
   <div class='step' >
    Source Reached
  </div>
  <div class='step-separator'></div>
   <div class='step' >
    Loading Completed
  </div>
  <div class='step-separator'></div>
   <div class='step'>
    Destination Reached
  </div>
  <div class='step-separator'></div>
   <div class='step'>
   Unloading Finished
  </div>
    <div class='step-separator'></div>
   <div class='step'>
   Trip Finished
  </div>
</c:when>
 
 <c:when test="${postinfo.status.equals('Source Reached')}"> 
 <div class='step active'>
      Booking Accepted
  </div>
  <div class='step-separator active'></div>
  <div class='step active' >
  Customer Confirmed 
  </div>
  <div class='step-separator active'></div>
  <div class='step active'>
    Vehicle Arranged 
  </div>
 <div class='step-separator active' ></div>
   <div class='step active' >
  Source Reached
  </div>
  <div class='step-separator'></div>
   <div class='step' >
    Loading Completed
  </div>
  <div class='step-separator'></div>
   <div class='step'>
    Destination Reached
  </div>
  <div class='step-separator '></div>
   <div class='step'>
    Unloading Finished
  </div>
    <div class='step-separator'></div>
   <div class='step'>
   Trip Finished
  </div>
</c:when>

<c:when test="${postinfo.status.equals('Loading Completed')}">
<div class='step active'>
      Booking Accepted
  </div>
  <div class='step-separator active'></div>
  <div class='step active' >
    Customer Confirmed
  </div>
  <div class='step-separator active'></div>
  <div class='step active'>
    Vehicle Arranged
  </div>
 <div class='step-separator active' ></div>
   <div class='step active' >
   Source Reached 
  </div>
  <div class='step-separator active'></div>
   <div class='step active' >
    Loading Completed
  </div>
  <div class='step-separator'></div>
   <div class='step'>
    Destination Reached
  </div>
  
  <div class='step-separator'></div>
   <div class='step'>
   Unloading Finished
  </div>
    <div class='step-separator'></div>
   <div class='step'>
   Trip Finished
  </div>

</c:when> 

<c:when test="${postinfo.status.equals('Destination Reached')}">
<div class='step active'>
      Booking Accepted
  </div>
  <div class='step-separator active'></div>
  <div class='step active' >
    Customer Confirmed
  </div>
  <div class='step-separator active'></div>
  <div class='step active'>
    Vehicle Arranged
  </div>
 <div class='step-separator active' ></div>
   <div class='step active' >
   Source Reached 
  </div>
  <div class='step-separator active'></div>
   <div class='step active' >
    Loading Completed
  </div>
  <div class='step-separator active'></div>
   <div class='step active'>
    Destination Reached
  </div>
  
  <div class='step-separator'></div>
   <div class='step'>
   Unloading Finished
  </div>
    <div class='step-separator'></div>
   <div class='step'>
   Trip Finished
  </div>

</c:when>


<c:when test="${postinfo.status.equals('Unloading Finished')}">
<div class='step active'>
      Booking Accepted
  </div>
  <div class='step-separator active'></div>
  <div class='step active' >
    Customer Confirmed
  </div>
  <div class='step-separator active'></div>
  <div class='step active'>
    Vehicle Arranged
  </div>
 <div class='step-separator active' ></div>
   <div class='step active' >
   Source Reached 
  </div>
  <div class='step-separator active'></div>
   <div class='step active' >
    Loading Completed
  </div>
  <div class='step-separator active'></div>
   <div class='step active'>
    Destination Reached
  </div>
  
  <div class='step-separator active'></div>
   <div class='step active'>
   Unloading Finished
  </div>
  <div class='step-separator'></div>
   <div class='step'>
   Trip Finished
  </div>

</c:when>

<c:when test="${postinfo.status.equals('Completed')|| postinfo.status.equals('Trip Finished')}">

<div class='step active'>
      Booking Accepted
  </div>
  <div class='step-separator active'></div>
  <div class='step active' >
    Customer Confirmed
  </div>
  <div class='step-separator active'></div>
  <div class='step active'>
    Vehicle Arranged
  </div>
 <div class='step-separator active' ></div>
   <div class='step active' >
   Source Reached 
  </div>
  <div class='step-separator active'></div>
   <div class='step active' >
    Loading Completed
  </div>
  <div class='step-separator active'></div>
   <div class='step active'>
    Destination Reached
  </div>
  
  <div class='step-separator active'></div>
   <div class='step active'>
   Unloading Finished
  </div>

<div class='step-separator active'></div>
   <div class='step active'>
   Trip Finished
  </div>	
	

</c:when>

<c:otherwise>



<div class='step active'>
      Booking Accepted
  </div>
<div class='step-separator1 '></div>
<div class='step-separator1 '></div>
<div class='step-separator1 '></div>
<div class='step-separator1 '></div>
<div class='step-separator1 '></div>
<div class='step-separator1 '></div>
 <div class='step1'>
Booking Canceled
</div>
</c:otherwise>
 </c:choose>
</div>
<div class="row">
<span  class="col push-s2"style="float:left;font-size:19px;"><b>Booking Id:</b>&nbsp;${postinfo.refPostId}</span>
<span  class="col push-s5" style="font-size:19px;"><b>Booking Date & Time:</b>&nbsp;${postinfo.postDate}</span>

</div>

 

        <br>
         <div class="row col s12 l12 m12">
<div class="col s12 m6 l8 " >

    <table class="responsive-table centered striped" style="border:1px solid gray">
              
                  <tr>
                 
                  <th><i class="fa fa-map-marker"></i>&nbsp;Source</th>
                   <td>
                    <textarea rows="5" cols="5" style="border:none;background-color:#eeeeee;font-family:Roboto, sans-serif;font-size:15px" readonly>${postinfo.price.route.fromCity}</textarea>
                  </td>
                    <th><i class="fa fa-map-marker"></i>&nbsp;Destination</th>
                    <td>
  <textarea rows="5" cols="5" style="border:none;background-color:#eeeeee;font-family:Roboto, sans-serif;font-size:15px" readonly>${postinfo.price.route.toCity}</textarea>
                    </td>
                    </tr>
                    <tr>
                    <th><i class="fa fa-map-marker"></i>&nbsp;Pickup Location</th>
                    <td>
                     <textarea rows="5" cols="5" style="border:none;background-color:#eeeeee;font-family:Roboto, sans-serif;font-size:15px" readonly>${postinfo.pickUpArea}</textarea>
                <%-- 	 <textarea style="border:none;width:200px" rows="6">${postinfo.pickUp}</textarea> --%>
                    </td>
                 
                     <th><i class="fa fa-map-marker"></i>&nbsp;Drop Location</th>
                     <td>
                <textarea rows="5" cols="5" style="border:none;background-color:#eeeeee;font-family:Roboto, sans-serif;font-size:15px" readonly>${postinfo.dropArea}</textarea>
                  </tr>
                    <tr>
                
                <th ><i class="fa fa-suitcase"></i>&nbsp;Material</th>
                <td><input type="text" value="${postinfo.material}" style="border:none;" readonly></td>
                <th><i class="fa fa-truck"></i>&nbsp;TruckType</th>
                <td><input type="text" value="${postinfo.price.info.truckName}" style="border:none;" readonly></td>
              </tr>
            <%--   <tr>
              <th><i class="fa fa-male"></i>&nbsp;Helpers</th> 
              <td>
             <input type="text" value="${postinfo.helper}" style="border:none;" />
              </td>
              <th><i class="fa fa-building"></i>&nbsp;Floor</th> 
              <td><input type="text" value="${postinfo.floor}" style="border:none;" /></td>
              </tr> --%>
              <tr>
                <th><i class="fa fa-calendar"></i>&nbsp;TravelDate</th>
                <td> 
               <input type="text" value="${postinfo.travelDate}" style="border:none;" readonly /> 
                </td>
                <th><i class="fa fa-rupee"></i>&nbsp;Amount</th>
                <td> <input type="text" value="${postinfo.totalAmount}" style="border:none;" readonly/></td>
                
                
                </table>
           <br><br>
           
           <c:choose>
<c:when test="${postinfo.status.equals('Booking Accepted')||postinfo.status.equals('Customer Confirmed')}"> 
                    <a href="cancelbooking?postid=${postinfo.refPostId}&mobile=${postinfo.user.mobileNo}" class="btn col offset-l5" style="height:30px;margin-bottom:10px;background-color:#3366CC;line-height:31px;">cancel order</a>
          
           
</c:when>
</c:choose>
 </div>
 <%-- <span>${error}</span> --%>
    
 <div class="col s12 m3 l4" style="border:1px solid gray">  
   <h5 class="center mtitle" >Track another order</h5>

       <div class="row" >
             <form action="track" method="Get" id="sampleForm">
              <div class="input-field col s12 m6 l12 ">

				       <input  id="book_id"  type="text" name="postid" class="validate" placeholder="Booking Id" required/>
					  
					</div>
					 <br><br>
					 <div class="input-field col s12 m6 l12 ">
			<c:choose>
			<c:when test="${userinfo.mobileNo!=null}"> 
			
					<input  id="t_mobile" name="mobile" type="text" value="${userinfo.mobileNo}"  maxlength="10" readonly/>
			
			 </c:when>
			<c:otherwise> 
			
					<input  id="t_mobile" name="mobile" type="text" class="validate" placeholder="Mobile No"  pattern="^[789]\d{9}$" maxlength="10" required/>
					
			</c:otherwise>
			</c:choose>  	
			</div> <br><br>
					<span id="spl" style="color:#00BFFF"></span>
					<!-- <div id="info" style="color: green;"></div> -->
					<div class="input-field col s12 m6 l6 center offset-l3 " >

			<input type="submit" value="Track" class="btn"  style="width:100%; height:30px;font-size:15px;background-color:#3366CC;line-height:31px;" id="submit">
 <br><br>
			</div>
		
					
				</form>
         
        </div>
        </div>
       
  </div>
  </div>
  
  </c:when>
  <c:otherwise>
 
<div class="row">

 
  <div class="container" >
    <div class="row  center " >
      <br>
     <span>${error}</span>
     <br><br>
        <form action="track" method="get" class="col l4 offset-m3 offset-l4" style="border:1px solid black;" >
          <h5>Track order</h5>
            <div class="input-field col s12 l12">
                 <input  id="book_id"  type="text" name="postid" class="validate" placeholder="Booking Id" required/>
              
              <span id="sp"></span>
            </div>
            <div class="input-field col s12 l12" style="margin-bottom:20px;">
              <c:choose>
			<c:when test="${userinfo.mobileNo!=null}"> 
			
					<input  id="t_mobile" name="mobile" type="text" value="${userinfo.mobileNo}"  maxlength="10" readonly/>
			
			 </c:when>
			<c:otherwise> 
			
					<input  id="t_mobile" name="mobile" type="text" class="validate" placeholder="Mobile No"  pattern="^[789]\d{9}$" maxlength="10" required/>
					
			</c:otherwise>
			</c:choose> 
            </div>
            <input type="submit" value="Track" class="btn"  style="width:70%; height:40px;font-size:15px;background-color:#3366CC;" id="submit"  >
           <br><br>
        </form>
    </div>
</div>

   
         
  </div>
  
  </c:otherwise>
</c:choose>

 

<jsp:include page="footer.jsp"/>

       
   
</body>