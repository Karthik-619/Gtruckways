<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>gTruckWays</title>
 <meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/enterprise.css" />
	
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      	  
      	 <!--   <script type="text/javascript" src="js/createReqObj.js" ></script>
      	  <script type="text/javascript" src="js/register.js" ></script> -->
      	<style>
      /* .enterprise{
      	border:1px solid black;
      	    background-color: rgba(245, 245, 245, 0.63);
      	    background-size: 400% auto	;
      	 
      	} 
      	
      	@media only screen and (max-width: 640px){
      body { background-image: url(img/enterprise.jpg); 
      	 } } 
      	 style="background-image:url(img/enterprise.jpg);background-repeat:no-repeat; background-size: 100% 90%; " */
     .sign{
background:rgba($form-bg,.9);
  padding: 40px;
  max-width:600px;
  margin:40px auto;
  border-radius:$br;
  box-shadow:0 4px 10px 4px rgba($form-bg,.3);
  }
  #test1{
  margin-left:5px;
  }
      	</style>
	</head>
<body>
         <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
       <a href="home.jsp"><img src="img/Logonew.png" class="hide-on-small-only" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
      <ul class="right hide-on-med-and-down ">
        <li><a href="home.jsp" class="tooltipped" data-position="bottom" data-delay="25" data-tooltip="Home" ><i class="material-icons" ">home</i></a></li>
   
      </ul>
  
      <ul class="side-nav" id="mobile-demo">
       <li> <img src="img/gtlogo.jpg" class="logo1"  alt="" /></li>
         <li><a href="home.jsp"><i class="fa fa-home"></i>Home</a></li>
         
         
      </ul>
    </div>
  </nav>
  </div> 
  <br>
  <br>
<div class="row">
<div class="container">
<div class="col s12 l12 m12">
      <ul class="tabs">
        <li class="tab col s3"><a class="active" href="#test1">Sign Up</a></li>
        <li class="tab col s3"><a  href="#test2">Sign In</a></li>
      </ul>
    </div>

         <!-- ******* Signup Tab******  -->
    
    <div id="test1">
    <br>
       <br>
    <h5 class="center">Sign-up</h5>
    <span>${entrMsg}</span>
     <form action="enterprise" method="post" class="enterprise"  autocomplete="on">
    <div class="row">
     	<div class="input-field col s12 m12 l6 ">
            <input  id="ename" type="text" name="enterpriseName" class="validate"   pattern="^[a-zA-Z0-9-\s'.]{1,}$" placeholder="Enterprise Name" required>
   		</div>
   		<div class="input-field col s12 m12 l6 ">
            <input  id="e_contname" type="text" name="contactPerson" class="validate"   pattern="^[a-zA-Z-\s'.]{1,}$" placeholder="Contact Name" required>
  		</div>
   </div>
   
   
   <div class="row">
   	  <div class="input-field col s12 m12 l6">
      <input  id="emobile" type="text" name="enterpriseMobile" pattern="^[789]\d{9}$" maxlength="10" class="validate" placeholder="Mobile No" required>
   <span id="spl" style="color:red;"></span>
  
     </div>
   <div class="input-field col s12 m12 l6">
      <input  id="e_email" type="text" name="enterpriseEmail" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})" class="validate" placeholder="Email Id" required>
  <span id="spr1" style="color:red;"></span>
   </div>
   </div>
   <div class="row">
  
    <div class="input-field col s12 m6 l12">
     <textarea cols="5" rows="2" id="address" name="enterpriseAddress" class="text_content1 materialize-textarea" placeholder="Enter Address" required></textarea>
     </div>
    </div>
      <div class="input-field col s12 l12 m12">
    			<input type="submit" value="Save" class="btn" style="width:100%;height:40px; font-size:20px;background-color:#3366CC;" id="submit"  >
     <br><br>
    </div>
    </form>
</div>

<!--./ ******* Signup Tab ******  -->



<!-- ****Login tab**** -->

<div id="test2">
<br>
<br>
<h5 class="center">Sign-In</h5>

<!--****Form Login**** -->

<div class="row">
<form action="enterpriseLogin" method="post">
   	  <div class="input-field col s12 m12 l12">
   	  <span><i class="fa fa-mobile"></i>&nbsp;<b>Email Id</b></span>
     	<input  id="email" type="text" name="emailId" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})"  class="validate"  required>
   		<span id="spl" style="color:red;"></span>
  	</div>
  	 <div class="input-field col s12 m12 l12">
  	  <span><i class="fa fa-key"></i>&nbsp;<b>Password</b></span>
     	<input  id="epswd" type="password" name="password"  class="validate" required>
   		<span id="spl" style="color:red;"></span>
  	</div>
  
  
  	<a href="#" style="margin-left:10px;margin-top:20px;"><u>ForgotPassword</u></a>
  
  	 <div class="input-field col s12 l12 m12">
    			<input type="submit" value="Save" class="btn" style="width:100%;height:40px; font-size:20px;background-color:#3366CC;" id="submit"  >
   
    </div>
  
  	</form>
 </div>
 <!--./ **** Form Login**** -->

</div>
<!--./ ****Login tab**** -->

  </div>
  </div>
 
 <jsp:include page="WEB-INF/view/footer.jsp"/>		

	  <script>
	  
	  $(document).ready(function(){
		  initall();
			if (typeof initalls == 'function') { 
				initalls(); 
				}
			
		  });
	  $(".button-collapse").sideNav();
	  </script>
  </body>