<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="localheader.jsp" />
	  <style>
	
	  #map {
        height: 500px;
        width: 100%;
       }
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
<a href="balance" style="color:white;" class="ent_dash">&nbsp;&nbsp;Balance KM</a>
</div>
<hr>
<div class="card-content">
<p><i class="fa fa-rupee" style="font-size:20px;color:white;margin-left:30px;"></i></p>
<a href="#" style="color:white;" class="ent_dash">&nbsp;&nbsp;Billing Details</a>
</div>
<hr>
<div class="card-content">
<p><i class="fa fa-cog" style="font-size:20px;color:white;margin-left:25px;"></i></p>
<a href="#" class="ent_dash" style="color:white;">Account Settings</a>
</div>
<div class="card-content">


</div>
<table height="100">

</table>
</div>
 
<div class="card col s12 m12 l10">
<div class="card-content ">
              <span class="card-title">Change Password</span>
              
            </div>
    <span style="margin-left:30rem;">${msg}</span>    
<div class="card-action center">

  <div class="row">
     <form action="changepwd" method="post" class="enterprise"  autocomplete="on">
    <div class="row">
     <div class="input-field col s12 m12 l3 ">
            <input   type="password" name="oldEnterPrisePassword"  class="validate"   placeholder="Current Password" required>
  		</div>
  		 <div class="input-field col s12 m12 l3 ">
            <input   type="password" name="enterPrisePassword"  class="validate"  placeholder="New Password" required>
  		</div>
  		 <div class="input-field col s12 m12 l3 ">
            <input   type="password"  class="validate" name="confirmPassword"  placeholder="Confirm Password" required>
  		</div>
  		<div class="input-field col s12 l3 m12">
    			<input type="submit" value="Submit" class="btn" style="width:100%;height:40px; font-size:20px;background-color:#3366CC;" id="submit"  >
  
    </div>
  		</div>
  		
          </form>
   		</div>
   	
   		
   		
   		
   
  
  
    

     
      </div>
</div>
</div>
</div>

</body>
</html>