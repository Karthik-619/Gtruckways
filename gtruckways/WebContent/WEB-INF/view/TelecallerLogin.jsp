<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/tele.css" />	
<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>
<style>
		
	.logo{
	margin-top:1rem ;
}
		nav
{
background-color:#0288d1;
}
@-moz-document url-prefix() {
   .back-color{
 height:280px;
   }
  input[type="submit"]{
   margin-top:80%;
   margin-left:-80%;
   }
}
	</style>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>gTruckways Telecaller Login</title>
</head>
<body style="background-image:url(img/telecaller3.jpg);background-repeat:no-repeat; background-size: 100% 150%; ">
<div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      
      	<a href="home.jsp"><img src="img/Logonew.png" height="60%" width="10%"  class="logo" alt="" /></a><span style="font-size:35px;margin-left:25rem;padding-bottom:1rem;color:#fff">Customer Care</span>
      <ul class="right hide-on-med-and-down ">
 
       
      </ul>
   
    </div>
  </nav>
  </div> <!--./ Local Header -->

<div >
    
<form action="<%=request.getContextPath()%>/teleLogin" method="GET">
 <div class="row" style="margin-top:5%;">
        <div class="col s12 m5">
          <div class="card back-color" style="background-color: rgba(0,0,0,.5);">
            <div class="card-content">
              <span class="card-title center-align"  style="color:white;"> Login </span>
              <div class="input-field col s12 l12" style="color:white;">
				  <input id="emp2" type="text" name="userName"  class="validate" >
				  <label for="" data-error=" " style="color:white;"><i class="fa fa-user"></i> &nbsp;User Name</label>
				</div>
				  <div class="input-field col s12" style="color:white;">
				 <input type="password" name="password" id="pass" class="validate" minlength="6" maxlength="30"   required>
				 <input type="hidden" name="telecallerActive" value="0"/>
				  <input type="hidden" name="userType" value="TELECALLER"/>
                <label for="" data-error="Min 6 and Max 30 charact" style="color:white;" ><i class="fa fa-key"></i>&nbsp; Password</label>
               </div>
			<!-- 	<div class="input-field col s12 l12"> 
                    <a class="waves-effect waves-light modal-trigger" href="#modal3" id="forget" style="color:white;"><u>Forgot password</u></a>
                </div> -->
            </div>
            <p style="color:red;margin-left:40px;font-size:18px;">${error}</p>
            <div class="card-action" style="margin-left:60%;margin-top:-10%;">
             
          <input type="submit" value="login" class="btn " >
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
            </div>
             
          </div>
        </div>
      </div>
       </form>    
</div>
</body>
</html>