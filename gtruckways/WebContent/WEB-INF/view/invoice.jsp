 <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
   
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <style>
      
      @font-face {
  font-family: SourceSansPro;
  src: url(SourceSansPro-Regular.ttf);
}

.clearfix:after {
  content: "";
  display: table;
  clear: both;
}

a {
  color: #0087C3;
  text-decoration: none;
}

body {
  position: relative;
  width:23cm;  
  height: 10.7cm; 
  /* margin: 0 auto;  */
  margin:0rem auto 0rem auto;
  color: #555555;
  background: #FFFFFF; 
  font-family: Arial, sans-serif; 
  font-size: 14px; 
  font-family: SourceSansPro;
}

header {
  padding: 10px 0;
  margin-bottom: 20px;
  border-bottom: 1px solid #AAAAAA;
}

#logo {
  float: left;
  margin-top: 8px;
}

#logo img {
  height: 70px;
}

#company {
  float: right;
  text-align: right;
}


#details {
  margin-bottom: 50px;
}

#client {
  padding-left: 6px;
  border-left: 6px solid #0087C3;
  float: left;
}

#client .to {
  color: #777777;
}

h2.name {
  font-size: 1.4em;
  font-weight: normal;
  margin: 0;
}

#invoice {
  float: right;
  text-align: right;
}

#invoice h1 {
  color: #0087C3;
  font-size: 2.4em;
  line-height: 1em;
  font-weight: normal;
  margin: 0  0 10px 0;
}

#invoice .date {
  font-size: 1.1em;
  color: #777777;
}

table {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 0;
  margin-bottom: 20px;
   
}

table th,
table td {
 padding: 5px;
  background: #EEEEEE;
  text-align: center;
  border-bottom: 1px solid #FFFFFF;
}

table th {
    border-right: 1px solid white;
    background: #8cc0d8;
    color:#000;
  white-space: nowrap;        
  font-weight: normal;
}

table td {
  text-align: left;
}

table td h3{
  color: #57B223;
  font-size: 1.2em;
  font-weight: normal;
  margin: 0 0 0.2em 0;
}

table .no {
  color: #FFFFFF;
  font-size: 1.6em;
  background: #57B223;
}

table .desc {
  text-align: left;
}

table .unit {
  background: #DDDDDD;
}

table .qty {
}

table .total {
  background: #57B223;
  color: #FFFFFF;
}

table td.unit,
table td.qty,
table td.total {
  font-size: 1.2em;
}


tfoot{
    
}
tfoot td:last-child {
    border:1px solid black;
}
tfoot td:nth-last-child(2) {
   border:1px solid black;
} 
table tfoot td {
  padding: 5px 10px;
  background: #FFFFFF;
  border-bottom: none;
  font-size: 1em;
  white-space: nowrap; 
  
    
}



/*table tfoot tr:last-child td {
  color: #57B223;
  font-size: 1.4em;
  border-top: 1px solid #57B223; 

}*/

table tfoot tr td:first-child {
  border: none;
}

#thanks{
  font-size: 2em;
  margin-bottom: 50px;
}

#notices{
  padding-left: 6px;
  border-left: 6px solid #0087C3;  
}

#notices .notice {
  font-size: 1.2em;
}

footer {
top:63rem;
  color: #777777;
  width: 100%;
  height: 30px;
  position: absolute;
  bottom: 0;
  border-top: 1px solid #AAAAAA;
  padding: 8px 0;
  text-align: center;
}
      
        #page-wrap {
    border: solid 1px white;
    width: 880px;
   
    position: relative;

}

#left {
    border: solid 1px #fff;
    width: 32%;
    /* height:100px; */
    background-color: #fff;
    float: left;
}

#mid {
    width: 33%;
    /* height:100px; */
    float: left;
    border: solid 1px #fff;
    background-color: #fff;
}

#right {
    border: solid 1px #fff;
    width: 33%;
     /* height:100px; */
    float: left;
    background-color: #fff;
	

}
.formfield * {
  vertical-align: top;
}
    
    table tr td.info1{
    padding:9px;
    background: rgba(238, 238, 238, 0.62);
    }

      </style>
  </head>
  <body >
  <div >
  	<h2 style="text-align:center;color:#0087c3">INVOICE</h2>
	  	  <header class="clearfix">
	      <div id="logo">
	        <img src="img/Logonew.png">
	      </div>
	      <div id="company">
	        <h2 class="name">gTruckways</h2>
	        <div>#1563,3 rd Floor,8th cross,<br>opposite BMTC Bus Depot,<br>Chandra Layout,Bangalore- 560040.<br></div>
	        <div>+91 9590603333</div>
	        <div><a href="#">info@gtruckways.com</a></div>
	      </div>
	    </header>
  	
  	<main>
  	<div id="details" class="clearfix">
        <div id="client">
          <div class="to" style="font-size:15px;color:#0087c3;">INVOICE TO:</div><br>
      		<div style="font-size:14px;">&nbsp;${telePostinfo.user.userName}</div>
           <div style="font-size:14px;">&nbsp;${telePostinfo.user.email}</div>
          <div style="font-size:14px;">&nbsp;${telePostinfo.user.mobileNo}</div> 
     
       <c:if test= "${telePostinfo.gstNumber ne'GGGG'}">
        <div> <label style="font-size:16px;color:#0087c3;">Customer GST No:</label>&nbsp;${telePostinfo.gstNumber}</div>
      </c:if>
        </div>
        
        <div id="invoice">
        <label style="font-size:16px;color:#0087c3;">Invoice No:</label>
         <b>${telePostinfo.invoiceId}</b>
          <div class="date"><label style="font-size:16px;color:#0087c3;">Date of Invoice:</label>${telePostinfo.acceptedTime}</div>
           <div class="date"><label style="font-size:16px;color:#0087c3;">GST No:&nbsp;</label>29ASMPK8075F1Z7</div>
        </div>
      </div>
      
      <table border="0" cellspacing="0" cellpadding="0" >
      		 <thead style="border:1px solid black;">
          	<tr style="border:1px solid black;">
             <th>Booking ID</th>
             <th>Vehicle Type</th>
             <th>Vehicle Reg No</th>
             <th>Free KM</th>
             <th>Free Min</th>
             <th>Total KM</th>
             <th>Total Time</th>
             <th>Extra Km</th>
             <th>Extra Time</th>
             <th style="border-right:1px solid black;">Helpers</th>
          </tr>
        </thead>
      <tbody>  
          <tr>
            <td class="info" style="border:1px solid black;">${telePostinfo.bookingId}</td>
            <td class="info" style="border:1px solid black;">${telePostinfo.infoTruck.truckName}</td>
             <td class="info" style="border:1px solid black;">${telePostinfo.vehi.vehicleRegistrationNo}</td>
            <td class="info" style="border:1px solid black;">${telePostinfo.freeKm}</td>
            <td class="info" style="border:1px solid black;">${telePostinfo.freeMins}&nbsp;min</td>
            <td class="info" style="border:1px solid black;">${telePostinfo.totalKm}</td>
            <td class="info" style="border:1px solid black;">${telePostinfo.totalMins}&nbsp;min</td>
            <td class="info" style="border:1px solid black;">${telePostinfo.extraKm}</td>
            <td class="info" style="border:1px solid black;">${telePostinfo.extraMins}&nbsp;min</td>          
            <td class="info" style="border:1px solid black;">${telePostinfo.helper}</td>
          </tr>    
     </tbody>
      </table> 
  	</main>
  	<br>
  	 <div id="page-wrap">

		<div id="left">
		<p class="formfield">
  <label for="textarea">Pickup Point:</label>
  <textarea id="textarea"  cols="23" rows="3" style="border:none; font-family: SourceSansPro;color:#555555;" readonly>${telePostinfo.fromCity}</textarea>

</p>
       <p class="formfield">
  <label for="textarea">Drop Point:</label>
  &nbsp;&nbsp;&nbsp;<textarea id="textarea" cols="23" rows="3" style="border:none;font-family: SourceSansPro;color:#555555; " readonly>${telePostinfo.toCity}</textarea>
</p>
	<p>
		<label>Start Time:<span>&nbsp;&nbsp;${telePostinfo.srcReachedDateTime}</span></label>
	
	</p>		
		<p>
		<label>End Time: <span>&nbsp;&nbsp;${telePostinfo.unloadingDateTime}</span></label>
	
	</p>	
		</div>		
		<div id="right">
		<div id="map" style="width:97%; height: 310px;"> 
		</div>
		    <input type="hidden" value="${telePostinfo.fromCity}" id="src" >
          <input type="hidden" value="${telePostinfo.toCity}" id="dest" >
		</div>			
        <div id="mid">
		<div id="main-content">       
 <table >
          <tr><td class="info1">Base Fare</td><td>${telePostinfo.basePrice}</td></tr>
          <tr><td class="info1">Extra KM Amount</td><td>${telePostinfo.extraKmAmount}</td></tr>
          <tr><td class="info1">Extra Time Amount</td><td>${telePostinfo.extraMinsAmount}</td></tr>
          <tr><td class="info1">Helper Amount</td><td>${telePostinfo.helperAmount}</td></tr> 
          <tr><td class="info1">Night Charges</td><td>${telePostinfo.nightCharges}</td></tr>
          <tr><td class="info1">Other Charges</td><td>${telePostinfo.otherAmount}</td></tr>
          <tr><td class="info1">Discount Amount</td><td>-${telePostinfo.discountAmount}</td></tr>
          <tr><td class="info1">GST <small>(CGST-2.5%+SGST-2.5%)</small></td><td>${telePostinfo.gstAmount}</td></tr>
          <tr><td class="info1"><strong>Total Amount</strong></td><td>${telePostinfo.totalAmount}</td></tr>
        
      </table>
		<div style="clear:both;"></div>
	</div>	
</div>
     </div>
     
     <div id="page-wrap" style="margin-top:23rem;">
     <div id="left"  >
	<span>Account Holder&nbsp;:&nbsp;&nbsp;&nbsp;Cogzy technologies pvt ltd</span><br>
	<span>Bank Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp; HDFC bank</span><br>
	<span>Bank Branch   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;  Chandra layout.</span><br>
	<span>Account No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp; 50200016907644</span><br>
	<span>IFSC Code No&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;HDFC0001757</span><br>
</div>
<div id="right">
</div>
<div id="mid" >
	<img src="img/seal1.png" width="30%" height="85px" style="float:right"><br><br><br><br><br><br>
	<span style="float:right"><i><strong>Signature & Seal</strong></i></span>
	</div>
	</div>
	 <footer>
     
    </footer> 
	</div>	
  
  

 
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=true&libraries=places&key=AIzaSyDr96kKx9kn-kt3urNoG43U6u4GViFQXhU"></script>
        <script>
      /*showing map*/
            var directionsService = new google.maps.DirectionsService();
         var directionsDisplay = new google.maps.DirectionsRenderer();
        
         var map = new google.maps.Map(document.getElementById('map'), {
           zoom:50,
           mapTypeId: google.maps.MapTypeId.ROADMAP,
       
         });
        
         directionsDisplay.setMap(map);
       /   directionsDisplay.setPanel(document.getElementById('panel')); /
         var source= document.getElementById('src').value;
    
         var dest= document.getElementById('dest').value;
          
         var request = {
             
           origin: source, 
           destination: dest,
           travelMode: google.maps.DirectionsTravelMode.DRIVING,
        
         };
    
        directionsService.route(request, function(response, status) {
           if (status == google.maps.DirectionsStatus.OK) {
             directionsDisplay.setDirections(response);
           }
         }); 
      </script>


     </body>
</html>