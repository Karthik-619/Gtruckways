<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
</head>
<body>
<div class="row">
	

<fieldset>

<legend style="font-size:20px;">Sales Details</legend>
 	
	
	<form action="entsrch" method="Post">
	<div class="container">
	
			  	<div class="row">
					 <div class="input-field col s12 m6 l4" >
						  
				  		<input type="text"  class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
							  <label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Salesman Name</label>
							  <span id="ent-name"></span>
					
					 </div>
				 
					  	<div class="input-field col s12 m6 l4" >
					  	
						  	<input type="text"  class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
							<label for="Enterprisesrchname" style="font-size:13px;">&nbsp;&nbsp;Salesman ID</label>
							 <span id="ent-name"></span>
							 
						</div>
						
						 <div class="input-field col s12 m6 l4" >
						  
				  			<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
							 <label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Customer Name</label>
							 <span id="ent-name"></span>
					
					 </div>
			  </div>
			
			
			
			<div class="row">
			
					
							
					  <div class="input-field col s12 m6 l4" >
						  
				  			<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
							 <label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Address</label>
							 <span id="ent-name"></span>
					
					 </div>
					 
					  <div class="input-field col s12 m6 l4" >
				  
		  	<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
					  <label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Contact Person</label>
					  <span id="ent-name"></span>
			
			 </div>
			  <div class="input-field col s12 m6 l4" >
				  
		  	<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
					  <label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Contact Person Designation</label>
					  <span id="ent-name"></span>
			
			 </div>
					 
			</div>
			
			
			
		<div class="row">
				  <div class="input-field col s12 m6 l4" >
					  
			  			<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
						 <label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Contact Number</label>
						 <span id="ent-name"></span>
				
				 </div>
				 
				  <div class="input-field col s12 m6 l4" > 
	   	 			<select class="browser-default" name="" required>
					   	   <option value="" disabled selected style="font-size:13px;" >Select EnterpriseName</option>
					  
					     <option></option>
	
	  
	   	 				</select> 
	
				  </div>
				   <div class="input-field col s12 m6 l4" >
				  
		  				<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
					 	<label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Nature of Products</label>
					  	<span id="ent-name"></span>
			
			 </div>
		</div>
		
		
		
		<div class="row">
		
			 
			 
			  <div class="input-field col s12 m6 l4" >
				  
			  			<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
						<label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Transportation Locations</label>
						 <span id="ent-name"></span>
				</div>
				 <div class="input-field col s12 m6 l4" >
				  
		  			<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
					<label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Types of vehicles used</label>
					<span id="ent-name"></span>
			
			 </div>
			  <div class="input-field col s12 m6 l4" >
				  
		  			<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
					 <label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Present Transporter</label>
					 <span id="ent-name"></span>
			
			 </div>
		</div>
		
		
		
		
		<div class="row">
		
			  <div class="input-field col s12 m6 l4" >
				  
		  			<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
					 <label for="Enterprisesrchname" style="font-size:12px;" >&nbsp;&nbsp;Average Monthly Payout account </label>
					 <span id="ent-name"></span>
			
			 </div>
			  <div class="input-field col s12 m6 l4" >
				  
		  			<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
					 <label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Transportation</label>
					 <span id="ent-name"></span>
			
			 </div>
			  <div class="input-field col s12 m6 l4" >
				  
		  			<input type="text" list="e_name_srch" class="validate" id="Enterprisesrchname" name="enterpriseName"   required>
					 <label for="Enterprisesrchname" style="font-size:13px;" >&nbsp;&nbsp;Points discussed</label>
					 <span id="ent-name"></span>
			
			 </div>
		</div>
		
		
		<div class="row">
			 
			 
			 <div class="input-field col s12 m12 l12" >
				  
		  		<select class="browser-default" name="" required>
		  		
				   	  	<option value="" disabled selected>Status of business </option>
				  		<option></option>
				</select> 
			
			 </div>
			 
		</div>	
		<div class="row center">
		
			<div class="col s12 m4 l2 col s6 offset-s3">
		 		<input type="submit" value="Submit" class="btn" >
		 	</div>	
		 	
		 	<div class="col s12 m4 l1">
		 		<input type="submit" value="Cancel" class="btn" >
		 	</div>	
		</div>
	</div>	

	
	 </form>
	 </fieldset>
	 
</div>
</body>
</html>