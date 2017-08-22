/*showing map*/
            var directionsService = new google.maps.DirectionsService();
         var directionsDisplay = new google.maps.DirectionsRenderer();
        
         var map = new google.maps.Map(document.getElementById('map'), {
           zoom:50,
           mapTypeId: google.maps.MapTypeId.ROADMAP,
       
         });
        
         directionsDisplay.setMap(map);
       //  directionsDisplay.setPanel(document.getElementById('panel')); 
         var source= document.getElementById('src').value;
    
         var dest= document.getElementById('dest').value;
          
         var request = {
             
           origin: source, 
           destination: dest,
           travelMode: google.maps.DirectionsTravelMode.DRIVING,
        
         };
    
        directionsService.route(request, function(response, status) {
           if (status == google.maps.DirectionsStatus.OK) {
             directionsDisplay.setDirections(response);
           }
         }); 
      
           
/* for showing diff recipent div*/
              document.getElementById('diff_recipent').onchange = function() {
                  document.getElementById('recipent_details').style.display = this.checked ? 'block' : 'none';
              };
        
/*price calculation*/
             
   function datepicker1(){
	  
	   var time=document.getElementById("date_foo").value;
	   var res = time.substr(11, 2);
	   var inputDate=time.substr(0,10);
	   	  var td=new Date();
	      var todayDate= td.toISOString().substring(0, 10);
	      var curr_hour = td.getHours();
	      
       var curr_min = td.getMinutes();
       var curtime= curr_hour + ":" + curr_min;
      
   	  var inputtime=time.substr(11,5);
   	  var today = new Date();
   	  var tomorrow = new Date(today);
       tomorrow.setDate(today.getDate()+1);
   	  var nextday_date=tomorrow.toISOString().substring(0, 10);
   	  var constTime="20";
       var bookTime="09:00";

	   /*	  var res = time.substr(11, 2);
	   var totalamount=parseFloat(amount);
	   var totalamount1=0;     	   
	   		var res = time.substr(11, 2);
  		   var totalamount=parseFloat(amount);
  	 	   var totalamount1=0;  
  		 var serverdate=document.getElementById("serverdate").value;
  		 var servertime=document.getElementById("servertime").value;
  		 var servernextdate=document.getElementById("nextDate").value;
  	
  	var todayDate= serverdate.substr(0,10);
  		 var curtime=servertime.substr(0,2);
  		 
  	var inputDate=time.substr(0,10);
  	var td=new Date();
	var todayDate= td.toISOString().substring(0, 10);
  	var curr_hour = td.getHours();
  	var curr_min = td.getMinutes();
  	
  	var curtime= curr_hour + ":" + curr_min;
  		 var inputtime=time.substr(11,5);
  	var inputtime1=time.substr(11,2);
  	  		   var today = new Date();
  		var tomorrow = new Date(today);
  		tomorrow.setDate(today.getDate()+1);
  		var nextday_date=tomorrow.toISOString().substring(0, 10);
  	// alert(nextday_date);
  	var constTime="20";
  	var bookTime="09";*/
  	

/* 	  if((inputDate==todayDate)&&(inputtime>=constTime)&&(curtime>=constTime)){
 document.getElementById("dateerror").innerHTML="Please Book after 9AM Tomorrow";
 document.getElementById("dateerror").style.display="block"; 
  document.getElementById("date_foo").value="";

 }

 else if((inputDate==servernextdate)&&(inputtime<bookTime)&&(curtime>=constTime)){
	 document.getElementById("dateerror").style.display="block"; 
document.getElementById("date_foo").value="";
 }
 else{
  document.getElementById("dateerror").innerHTML="";
 }*/
	 

   	
       
       if((inputDate==todayDate)&&(inputtime>=constTime)&&(curr_hour>=constTime)){
 
         	 document.getElementById("dateerror").innerHTML="Please Book after 9AM Tomorrow";
 
    	 document.getElementById("date_foo").value="";
    	document.getElementById("dateerror1").innerHTML="";
                	 
               }
               
               else if((inputDate==nextday_date)&&(inputtime<bookTime)&&(curr_hour>=constTime)){
            
                 	 document.getElementById("dateerror1").innerHTML="Please Book after 9AM Tomorrow";
              	 document.getElementById("date_foo").value="";
               }
               else{
              	 document.getElementById("dateerror").innerHTML="";
              	
              	 document.getElementById("dateerror1").innerHTML="";
               }
              	
 
	
 
   }

              function totalprice(){
            	
            	 
            	  var helper=false;
            	
            	  var amount=document.getElementById("amountid").value;
            	  var statusCode=document.getElementById("statuscodeid").value;  
            	  var time=document.getElementById("date_foo").value;
            	  var labour=document.getElementById("labourid").value;        
           	   	  helper=document.getElementById("driverasHelper").checked;
		          
           
      
           	   	  
           	   	  var res = time.substr(11, 2);
		          var totalamount=parseFloat(amount);
		          var totalamount1=0;  
		          if(((parseInt(res)>=0 && parseInt(res)<8) || (parseInt(res)>=20 && parseInt(res)<=23)) && helper==true ){
		           	   	 
		           		 totalamount1=parseFloat(totalamount)+parseFloat(labour);
		           		 totalamount1=parseFloat(totalamount1*1.5);
		           		   
		           	   } else if((parseInt(res)>=0 && parseInt(res)<8 || parseInt(res)>=20 && parseInt(res)<=23) && helper==false ){
		           		   
		           		 totalamount1=parseFloat(totalamount*1.5);
		           		   
		           	   }
		           	   else if(helper==true){
		           		   
		           		totalamount1=parseFloat(totalamount)+parseFloat(labour);
		           	   }else{
		           		totalamount1=parseFloat(totalamount);
		           	   }
		           	   var tot=Math.ceil(totalamount1);
		           	 
		           	  
		           	   
		           	   
		           	   document.getElementById("amount").value=parseFloat(tot);
		           	   document.getElementById("statuscodeid").value=0;
		           	   document.getElementById("promomsg1").innerHTML="";	
		           }
		              
              function initialize() {
            		var defaultBounds = new google.maps.LatLngBounds(
            				  new google.maps.LatLng(12.9538477,77.3507369),
            				  new google.maps.LatLng(12.9538477,77.3507369));
            	var options = {
            		types: ['geocode'], 
            		bounds: defaultBounds,
            	    componentRestrictions: {country: "in"}
            	  };
            	  var input = document.getElementById('frmarea');
            	  var toarea =document.getElementById('tooarea');
            	  var autocomplete = new google.maps.places.Autocomplete(input, options);

            	  var autocomplete = new google.maps.places.Autocomplete(toarea, options);
            	  //autocomplete.bindTo('bounds', map);
            	 }
            	google.maps.event.addDomListener(window, 'load', initialize);    
		          
		          
		          
		          
           
		          
		          
		          
		          
		   	   	 
              
        
