<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
 <jsp:include page="localheader.jsp" />
	  <style>
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
<body>


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
<a href="#" style="color:white;" class="ent_dash">&nbsp;&nbsp;Balance KM</a>
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
<table height="70">

</table>
</div>
<div class="card col s12 m12 l10">
<div class="card-content ">
              <span class="card-title">Balance Kilometer </span>
              
            </div>

<c:choose>
 <c:when test="${not empty balanceInfo}">

      <div class="col s12 m12 l12">

 <ul class="collection">

     <li class="collection-item avatar  z-depth-5">
     
      <table width="" class="resposive-table centered striped" >
      
        <c:forEach var="bal" items="${balanceInfo}"> 
      <tr>
     <c:choose>
	<c:when test="${bal.vehicleType.equals('TATA ACE')}">	
      <td> <img src="img/tata-ace.jpg"  height="50" ></td>
     </c:when>
     <c:when test="${bal.vehicleType.equals('TATA 407')}">	
      <td> <img src="img/tata-407.jpg"  height="50" ></td>
     </c:when>
     <c:otherwise> 
      <td> <img src="img/TataSuperAce.jpg"  height="50" ></td>
     </c:otherwise>
     </c:choose> 
      <th>Vehicle Reg-no</th>
      <th>Frequency of vehicle</th>
      <th>No of km/month</th>
      <th>No of Hours/day</th>
      <th>Travelled Km/Month</th>
      <th>Remining Km/Month</th>
      </tr>
   
    
     <tr>
      <td>${bal.vehicleType}</td>
      <td>${bal.vehicelRegNo}</td>
      <td>${bal.frequencyOfVehicle}</td>
      <td>${bal.noOfKms}</td>
      <td>${bal.noOfhoursPerDay}</td>
      <td>${bal.travelledKm}</td>
      <td>${bal.remainingKm}</td>
      </tr>
      </c:forEach>
      </table>

  
      
    </li>
  </ul>
            



</div>

</c:when>
<c:otherwise>

<span> Truck is Not Assigned for You </span>
</c:otherwise>
</c:choose>
</div>


</body>
</html>