<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>gtruckways</title>
	<link rel="stylesheet" type="text/css" href="css/materialize.min.css" />
	<link rel="stylesheet"  type="text/css" href="css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css"  href="css/local.css" />

<style>

form {
    border: 3px solid #f1f1f1;
    width:40%;
    margin-left:25rem;
    margin-top:7rem;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #1253a4;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    font-size:1.2rem;
}

button:hover {
    opacity: 0.8;
}


.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container1 {
    padding: 16px;
 
}

span.psw {
    float: right;
    padding-top: 16px;
}


@media only screen and (max-width: 500px) {
form {
    border: 3px solid #f1f1f1;
width:100%;
    margin-left:0rem;
    margin-top:0rem;
}
}
.navbar{
background-color:#1253a4;
padding:5px;
}
nav{
background-color: #1253a4;
}
</style>
</head>
<body>
 <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo"><img src="img/Logonew.png" alt="logoicon" width="" height="80px;" /></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        
      </ul>
    </div>
  </nav>
        

  
  <form action="alogin" method="GET" class="pwdform">
  <div class="imgcontainer">
 
  </div>
 
 <span style="margin-left:10rem">${error}</span>
  <div class="container1">
    <label><b>Email-ID</b></label>
    <input type="text" name="userName" placeholder="Enter Email-ID" pattern="[A-Za-z0-9._%+-]{1,}@[a-zA-Z0-9]{1,}([.]{1}[a-zA-Z0-9]{2,}|[.]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,})" required>

    <label><b>Password</b></label>
    <input type="password"  placeholder="Enter  Password" name="password" required>
     <input type="hidden" name="userType" value="SEO"/>
        
    <button type="submit">Submit</button>
   
  </div>

  <div class="container1" style="background-color:#f1f1f1">
 
  
  </div>
</form>
</body>
</html>