<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>gtruckways</title>
<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">
 <link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
      <script src="http://maps.googleapis.com/maps/api/js"></script>
<script src="js/jquery.js"></script>	
<script type="text/javascript" src="js/jquery-dtpicker.js"></script>
<script type="text/javascript" src="js/materialize.js" ></script>
<script type="text/javascript" src="js/materialize.min.js" ></script> 
<style>
nav{
background-color: #1253a4;
}
th.daily{
	padding:0px;
	background-color:rgb(117, 202, 235);
	text-align:center;
	font-size:12px;
  padding-right: 1em;
      border: 1px solid #FFF;
}
td.daily{
	padding:3px;
	font-size:12px;
}
.btn.edit,.btn.delet,.btn.addnew,btn.chooseimg {
	background-color:#0288d1;

color:white;
font-size:13px;
height:28px;
line-height:10px;
padding:8px;
}
.file-field .btn, .file-field .btn-large {
	padding:2px;
	background-color:#0288d1;
    float: left;
    height: 2rem;
    line-height: 2rem;
}
input:not([type]), input[type=text]:not(.browser-default), input[type=password]:not(.browser-default), input[type=email]:not(.browser-default), input[type=url]:not(.browser-default), input[type=time]:not(.browser-default), input[type=date]:not(.browser-default), input[type=datetime]:not(.browser-default), input[type=datetime-local]:not(.browser-default), input[type=tel]:not(.browser-default), input[type=number]:not(.browser-default), input[type=search]:not(.browser-default), textarea.materialize-textarea {
    background-color: transparent;
    border: none;
    border-bottom: 1px solid #9e9e9e;
    border-radius: 0;
    outline: none;
    height: 2rem;    
    width: 100%;
    font-size: 1rem;
    margin: 0 0 20px 0;
    padding: 0;
    -webkit-box-shadow: none;
    box-shadow: none;
    -webkit-box-sizing: content-box;
    box-sizing: content-box;
    -webkit-transition: all 0.3s;
    transition: all 0.3s;
}
.input-field .prefix ~ input, .input-field .prefix ~ textarea, .input-field .prefix ~ label, .input-field .prefix ~ .validate ~ label, .input-field .prefix ~ .autocomplete-content {
    margin-left: 2.5rem;
    width: 92%;
    width: calc(100% - 2.5rem);
}
</style>
</head>
<body>
 <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo"><img src="img/Logonew.png" alt="logoicon" width="" height="80px;" /></a>
      <!-- sign in dropdown -->
       <ul id="" class="right logged-in">
			<li><a class="dropdown-button" data-activates='dropdown_local' href="" ><i class="fa fa-user"></i>&nbsp;${seoInfo.telecallerName}</a></li>			
			  <ul id="dropdown_local" class="dropdown-content">
			 <li><a href="admin" onclick="" id="signout" >Sign out</a></li> 
	 </ul>
		</ul>
    </div>
  </nav>
      <br>
      <fieldset>
      <legend></legend>
      <span class="right"><a href="#addnew" class="btn addnew modal-trigger" >Add New</a></span><br><br>
      <table class="responsive-table striped bordered">
      	<thead>
      	<tr>
      		<th class="daily">Date</th>
      		<th class="daily">Image</th>
      		<th class="daily">Title</th>
      		<th class="daily">content</th>
      		<th class="daily">Edit</th>
      		<th class="daily">Action</th>
      	</tr>	
      	</thead>
      	<tbody>
      	
      	 <c:forEach items="${seoImageInfo}" var="seo">
      		<tr>
      		<form action="seoUpdate" method="GET">
      			
      			<td class="daily">${seo.uploadDate}</td>
      			<td class="daily" width="200px"><img src="<%=request.getContextPath()%>/something/getImg${seo.imageId}" style="width:auto; height:100px;"></td>
      			
      			<td class="daily"><input type="text" name="title" value="${seo.title}" readonly>  <input type="hidden" name="imageId" value="${seo.imageId}"></td>
      			<td class="daily"><textarea disabled name="content">${seo.content}</textarea></td>
      			<td class="daily" style="text-align:center"><button class="btn edit  ent_edit" value="">Edit</button></td>
      			<td class="daily" style="text-align:center"><input type="submit" class="btn delet" value="Save" disabled> &nbsp;&nbsp;&nbsp;&nbsp;<a class="btn delet" href="seoDelete?id=${seo.imageId}" >Delete</a></td>
      		</form>
      		</tr>
      		</c:forEach>
      	</tbody>
      </table>  
      </fieldset>
      
      
      <div class="modal"id="addnew" style="width:30%;border:6px solid #1253a4;">
      	<div class="modal-content">
      		<div class="row">
      		<h5 class="center">Add New</h5>
    <form action="seoUploadFile" method="Post" enctype="multipart/form-data" class="col s12">
      <div class="row">
         <div class="input-field">
          <i class="material-icons prefix">account_circle</i>
          <input id="icon_prefix" type="text" name="title" class="validate" tabindex="9">
          <label for="icon_prefix">Title</label>
        </div>
        <div class="input-field ">
           <i class="material-icons prefix">mode_edit</i>
          <textarea id="icon_prefix2" name="content" class="materialize-textarea"></textarea>
          <label for="icon_prefix2">Content	</label>
        </div>
          <div class="file-field input-field">
      <div class="btn " >
        <span>choose image</span>
        <input type="file" name="file" style="margin-bottom: 2rem;">
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text">
      </div>
    </div>
    <div class="input-field col offset-l1">
    	<input type="submit" class="btn blue lighten-2" value="Upload">&nbsp;&nbsp;&nbsp;&nbsp;<span><button  class="btn  red lighten-2">Cancel</button></span>
    </div>
      </div>
    </form>
  </div>
        
      	</div>
      </div>
      <script type="text/javascript">
      $(document).ready(function(){
    	    $('.button-collapse').sideNav();
    	    });

 	 $('.dropdown-button').dropdown({
 	      inDuration: 300,
 	      outDuration: 225,
 	      constrain_width: false, // Does not change width of dropdown to that of the activator
 	      hover: false, // Activate on hover
 	      gutter: 0, // Spacing from edge
 	      belowOrigin: false, // Displays dropdown below the button
 	      alignment: 'left' // Displays dropdown with edge aligned to the left of button
 	    }
 	  ); 
      $('.ent_edit').click(function(){
    	  		
    		    $(this).closest('tr').find('input,textarea,a').removeAttr('disabled');
    		    $(this).closest('tr').find('textarea,input').removeAttr('readonly');
    	 		$(this).first().remove();
    	    //$(this).parent('td.save').last().show();

    	    //$('.existing_enter tr:eq(1) td:eq(12)').show();
    	    //$(this).parents('td.save').last().show();
    	    //$('td:last').show();
    	});
      
      $(document).ready(function(){
			// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
			$('.modal-trigger').leanModal({
          dismissible: true
      });
	  });
      </script>
</body>
</html>