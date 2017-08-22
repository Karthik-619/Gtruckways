<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
<title>gTruckWays</title>
 <meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!-- <meta name="keywords" content="Classy Booking Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> -->
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link rel="stylesheet" href="css/local.css" />
	
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/materialize.js" ></script>	
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      	  
      	   <script type="text/javascript" src="js/createReqObj.js" ></script>
      	  <script type="text/javascript" src="js/register.js" ></script>
      	<style>
      	* {
    box-sizing: border-box;
}
 nav
{
background-color:#1253A4;
}
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
  
  
 *, *:before, *:after {
  box-sizing: border-box;
}

html {
  overflow-y: scroll;
}

body {
  background: #ffffff;
  font-family: 'Titillium Web', sans-serif;
}

a {
  text-decoration: none;
  color: #000;
  -webkit-transition: .5s ease;
  transition: .5s ease;
}

.form {
  background: rgba(19, 35, 47, 0.9);
  padding: 40px;
  max-width: 600px;
  margin: 40px auto;
  border-radius: 4px;
  box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
}

.tab-group {
  list-style: none;
  padding: 0;
  margin: 0 0 40px 0;
}
.tab-group:after {
  content: "";
  display: table;
  clear: both;
}
.tab-group li a {
  display: block;
  text-decoration: none;
  padding: 15px;
  background: rgba(160, 179, 176, 0.25);
  color: #ffffff;
  font-size: 20px;
  float: left;
  width: 50%;
  text-align: center;
  cursor: pointer;
  -webkit-transition: .5s ease;
  transition: .5s ease;
}
.tab-group li a:hover {
  background:#439fe8;
  color: #ffffff;
}
.tab-group .active a {
  background:#3366CC;
  color: #ffffff;
}

.tab-content > div:last-child {
  display: none;
}

h4{
  text-align: center;
  color: #ffffff;
  font-weight: 300;
  margin: 0 0 40px;
}
/* 
label {
  position: absolute;
 -webkit-transform: translateY(6px);
          transform: translateY(6px);
  left: 13px;
  color:gray;
  
 -webkit-transition: all 0.25s ease;
  transition: all 0.25s ease;
  -webkit-backface-visibility: hidden; 
  pointer-events: none;
  font-size: 15px;
}
label .req {
  margin: 2px;
  color: #1ab188;
}

label.active {
-webkit-transform: translateY(50px);
          transform: translateY(50px); 
  left: 2px;
  font-size: 14px;
}
label.active .req {
  opacity: 0;
}

label.highlight {
  color: #ffffff;
}
 */
 label.active {
-webkit-transform: translateY(50px);
          transform: translateY(50px); 
  left: 2px;
  font-size: 14px;
}
input, textarea {
  font-size: 22px;
  display: block;
  width: 100%;
  height: 100%;
  padding: 5px 10px;
  background: none;
  background-image: none;
  border: 1px solid #a0b3b0;
  color: black;
  border-radius: 0;
  -webkit-transition: border-color .25s ease, box-shadow .25s ease;
  transition: border-color .25s ease, box-shadow .25s ease;
}
input:focus, textarea:focus {
  outline: 0;
  border-color: #1ab188;
}

textarea {
  border: 2px solid #a0b3b0;
  resize: vertical;
}

.field-wrap {
  position: relative;
  margin-bottom: 40px;
}

.top-row:after {
  content: "";
  display: table;
  clear: both;
}
.top-row > div {
  float: left;
  width: 48%;
  margin-right: 4%;
}
.top-row > div:last-child {
  margin: 0;
}

.button {
  border: 0;
  outline: none;
  border-radius: 0;
  padding: 15px 0;
  font-size: 2rem;
  font-weight: 600;
  text-transform: uppercase;
  letter-spacing: .1em;
  background: #1ab188;
  color: #ffffff;
  -webkit-transition: all 0.5s ease;
  transition: all 0.5s ease;
  -webkit-appearance: none;
}
.btn:hover, .btn:focus {
  background: #179b77;
}

.btn-block {
  display: block;
  width: 100%;
}

.forgot {
  margin-top: -20px;
  text-align: right;
}

  @media only screen and (max-width: 500px) {
  .logo1{
  height:100px;
  margin-top:1rem;
 }
}

 		</style>
	</head>
<body>
         <div class="navbar-fixed">
<nav>
    <div class="nav-wrapper" >
  
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="fa fa-bars"></i></a>
       <a href="homePage"><img src="img/Logonew.png" class="hide-on-small-only" height="155%" style="margin-left:50px;" class="logo" alt="" /></a>
     <ul class="right hide-on-med-and-down ">
        <li><a href="homePage"  >Home</a></li>
   
      </ul>
 
      <ul class="side-nav" id="mobile-demo">
       <li> <img src="img/Logonew.png" width="50%" class="logo1"  alt="" /></li>
         <li><a href="homePage"><i class="fa fa-home"></i><b>Home</b></a></li>
         
         
      </ul>
    </div>
  </nav>
  </div> 
  <br>
  <br>

  
  
  
 
  
  <span class="center" style="margin-left:25rem;">${entrMsg}</span>
  <span>${msg}</span>
  <span>${errmsg}</span>
   
  <div class="form">
      
      <ul class="tab-group">
      <li class="tab active"><a href="#login">Log In</a></li>
        <li class="tab"><a href="#signup">Sign Up</a></li>
        
      </ul>
      
      <div class="tab-content">
           <!-- Login -->
        
        <div id="login">   
         
          
          <form action="enterpriseLogin" method="post">
          
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
        	<input  id="email" type="text" name="emailId" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})"  class="validate"  required>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
          <input  id="epswd" type="password" name="password"  class="validate"  required>
          </div>
          
          <p class="forgot"><a href="#modal5" class="modal-trigger" style="color:rgba(244, 67, 54, 0.98)">Forgot Password?</a></p>
           <div class="input-field col s12 l12 m12">
    			<input type="submit" value="Log In" class="btn" style="width:100%;height:40px; font-size:20px;background-color:#3366CC;" id="submit"  >
   
    </div>
        
          
          </form>

        </div>
         <!-- Login -->
        <div id="signup">   
          <h5 class="center" style="color:white;">New User</h5>
          
          <form action="enterprise" method="post" class="enterprise"  autocomplete="on">
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
               Enterprise Name<span class="req">*</span>
              </label>
             <input  id="ename" type="text" name="enterpriseName" class="validate"   pattern="^[a-zA-Z0-9-\s'.]{1,}$"  required autocomplete="off" />
            </div>
        
            <div class="field-wrap">
              <label>
              Contact Name<span class="req">*</span>
              </label>
                
              <input type="text"  id="e_contname" type="text" name="contactPerson" class="validate"   pattern="^[a-zA-Z-\s'.]{1,}$"required autocomplete="off"/>
            </div>
          </div>
			<div class="top-row">
			
			
			 <div class="field-wrap">
        		<label>
             		 Email Id<span class="req">*</span>
            	</label>
            	<input type="email" id="e_email" name="enterpriseEmail" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})" class="validate"required autocomplete="off"/>
          	</div>
          
	          <div class="field-wrap">
	            <label>
	              Mobile No<span class="req">*</span>
	            </label>
	            <input type="text" id="emobile" name="enterpriseMobile" pattern="^[789]\d{9}$" maxlength="10" class="validate"required autocomplete="off"/>
	          </div>
	          
       	</div>
       	
          
          <div class="field-wrap">
            <label>
             Address<span class="req">*</span>
            </label>
            <textarea cols="5" rows="2" id="address" name="enterpriseAddress" class="text_content1 materialize-textarea"  required></textarea>
          </div>
          
         
          <div class="input-field col s12 l12 m12">
    			<input type="submit" value="Create Account" class="btn" style="width:100%;height:40px; font-size:20px;background-color:#3366CC;" id="submit"  >
     <br><br>
    </div>
          
          </form>

        </div>
        
        
        
        
   
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  
   <div id="modal5" class="modal">
		<div class="modal-content">

         <a href="#" class="fa fa-close modal-action modal-close right"  ></a>
    <h5 class="center mtitle black-text" >Forgot Password?</h5>
        <div class="row " >
             <form action="forgot" method="POST" >
              <div class="input-field col s12 l12 m12">
           
        	<input  id="email" type="text" name="email" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})" placeholder="Email Address"  class="validate"  required>
          </div>
			<div class="input-field col s12 l12 m12">
    			<input type="submit" value="Get Link" class="btn" style="width:100%;height:40px; font-size:20px;background-color:#3366CC;" id="submit"  >
   
    </div>		
					
				</form>
         
        </div>
      
   
	
		</div>
		</div>	
		
 
  
  </body>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
 <jsp:include page="footer.jsp"/>		

	  <script>
	  
	  $(document).ready(function(){
		  initall();
		
		  });
	  $(".button-collapse").sideNav();
	  
	  
	  
	  
	  
	  
	  
	  
	  
/* 	  $('.form').find('input, textarea').on('keyup blur focus', function (e) {
		  
		  var $this = $(this),
		      label = $this.prev('label');

			  if (e.type === 'keyup') {
					if ($this.val() === '') {
		          label.removeClass('active highlight');
		        } else {
		          label.addClass('active highlight');
		        }
		    } else if (e.type === 'blur') {
		    	if( $this.val() === '' ) {
		    		label.removeClass('active highlight'); 
					} else {
				    label.removeClass('highlight');   
					}   
		    } else if (e.type === 'focus') {
		      
		      if( $this.val() === '' ) {
		    		label.removeClass('highlight'); 
					} 
		      else if( $this.val() !== '' ) {
				    label.addClass('highlight');
					}
		    }

		}); */

		$('.tab a').on('click', function (e) {
		  
		  e.preventDefault();
		  
		  $(this).parent().addClass('active');
		  $(this).parent().siblings().removeClass('active');
		  
		  target = $(this).attr('href');

		  $('.tab-content > div').not(target).hide();
		  
		  $(target).fadeIn(600);
		  
		});
	  
	  
		 $(document).keyup(function(e) {
	          if (e.keyCode == 27) { // escape key maps to keycode `27`
	             $('#modal5').closeModal();
	            
	         }
	     });
		  
	  
	  
		  $(document).ready(function(){
				// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
				$('.modal-trigger').leanModal({
	            dismissible: false
	        });
		  });
		 
	  
	  
	  
	  
	  
	  
	  </script>
  </body>