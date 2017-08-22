<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>gtruckways</title>
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
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
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
</style>
</head>
<body>
<div class="navbar">
<nav>
<div class="nav-wrap">
<ul>
<li></li>
</ul>
</div>

</nav>

</div>

  
  <form action="respass" method="post" class="pwdform">
  <div class="imgcontainer">
 <span>${msg}</span>
  </div>
 	<input type="hidden" name="enterpriseEmail"  value="${saltcode}"/>
  <div class="container">
    <label><b>New Password</b></label>
    <input type="password" placeholder="Enter New Password" name="newpass" required>

    <label><b>Confirm Password</b></label>
    <input type="password" placeholder="Enter Confirm Password" name="confirmnewpass" required>
        
    <button type="submit">Reset Password</button>
   
  </div>

  <div class="container" style="background-color:#f1f1f1">
 
  
  </div>
</form>
</body>
</html>