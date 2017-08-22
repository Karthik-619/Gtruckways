<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
 <link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/enterprise.css" />	
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
      <script src="http://maps.googleapis.com/maps/api/js"></script>
<script src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery-dtpicker.js"></script>
<script type="text/javascript" src="js/materialize.js" ></script>
<script type="text/javascript" src="js/materialize.min.js" ></script> 
<script type="text/javascript" src="js/enterprise.js" ></script> 
<style>

.pwdcard{
background-color:#1253A4;
margin-top:30%;
height:250px;
}
input[type="text"],input[type="password"]{
background-color:white;
}
label.active{
color:white;
}
.pwdbtn{
background-color:rgb(255, 255, 255);
border1px solid #9E9E9E;
color:#0288d1;
font-weight:600;
margin-left:10%;

}
body{
background-image:url('img/truck-image.jpg');
background-repeat:no-repeat;
 background-size:100% 660px;
}
.pwdbtn:hover{
background-color:white;
}
.pwdform{
margin-top:5%;
}
label.active{

color:white;
}
</style>
</head>

<body background="">
<div class="navbar-fixed"><!-- Header -->
<nav>
    <div class="nav-wrapper" >
     <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars"></i></a>
    	<a href="home.jsp"><img src="img/gtlogo.jpg" height="60%" width="10%"  class="logo" alt="" /></a>
     <ul class="side-nav" id="mobile-demo">
     <li> <img src="img/gtlogo.jpg" class="logo1"  alt=""  /></li>
      </ul>
   
    </div>
  </nav>
  </div> 
  
   <div class="row" > 
    <div class="col s12 l12 ">
      <div class="col s12 m5 l4 offset-l4">
  
        <div class="card-panel pwdcard  z-depth-5">
             <span>${msg}</span>
        <h5 class="white-text center-align">Reset Password</h5>
        <form action="resetpass" method="post" class="pwdform">
        <div class="input-field">
        <input type="text" name="enterpriseEmail" id="enterpriseEmail" required>
        <label for="email" class="active"><i class="fa fa-lock" style="font-size:17px;"></i>&nbsp;&nbsp;Email</label>
        </div>
       <div class="input-field">
        <input type="password" name="newpass" id="new_pwd" required>
        <label for="new_pwd" class="active"><i class="fa fa-lock" style="font-size:17px;"></i>&nbsp;&nbsp;New Password</label>
        </div>
        
        <div class="input-field">
        <input type="password" name="confirmnewpass" id="confirm_pwd" requireds>
        <label for="confirm_pwd"><i class="fa fa-lock" style="font-size:17px;"></i>&nbsp;&nbsp;Confirm Password</label>
        </div>
        <div class="input-field">
        <input type="submit" value="Submit" class="btn pwdbtn right">
        <br> <br> 
      </div>
      <br> <br>
         </form>
      </div>
   
    </div>
    </div>
    </div> 
   
<!--    <div class="row">
      <div class="col s12 m5 l4 offset-l4 changepwd">
        
        <div class="card-panel pwdcard">
        <form action="" method="post">
        <h5 class="white-text center-align">Change Password</h5>
        <div class="input-field">
        <input type="password" name="cust_new_pwd" id="curr_pwd">
        <label for="curr_pwd"><i class="fa fa-lock" style="font-size:17px;"></i>&nbsp;&nbsp;Current Password</label>
        </div>
        <div class="input-field">
        <input type="password" name="cust_new_pwd" id="new_pwd">
        <label for="new_pwd"><i class="fa fa-lock" style="font-size:17px;"></i>&nbsp;&nbsp;New Password</label>
        </div>
        <div class="input-field">
        <input type="password" name="cust_confirm_pwd" id="confirm_pwd">
        <label for="confirm_pwd" ><i class="fa fa-lock" style="font-size:17px;"></i>&nbsp;&nbsp;Confirm Password</label>
        </div>
        <div class="input-field">
        <input type="submit" value="Submit" class="btn pwdbtn right"> 
      </div>
      <br>
      <br><br>
         </form>
      </div>
   
    </div>
 
    </div>  -->
</body>
 
<%--  <jsp:include page="footer.jsp"/>	 --%>	
</html>