
  /* for enabling floorselect */
             document.getElementById("labourid").onclick= function (e) {
            	  
            	 
            	 if (this.value == 0) {
            		
            		
              		  
               document.getElementById("floorid").disabled=true;
            		
                
                } else {
             
                  document.getElementById("floorid").disabled=false;
               }
            	 
              }; 

      /*price calculation*/
              
              function totalprice(){
            	  
            	  var amount=document.getElementById("amountid").value; 
            	  var time=document.getElementById("date_foo1").value;
            	/*  var TruckType=document.getElementById("trckType").value;
            	  alert(TruckType);*/
           	   	  var res = time.substr(11, 2);
           	   	  var totalamount=parseFloat(amount);
           	   	  var totalamount1=0;
           	   if(parseInt(res)>=0 && parseInt(res)<8 || parseInt(res)>20 && parseInt(res)<=23  ){
           	   	 
           		 totalamount1=parseFloat(totalamount*1.5);
           		   
           	   }	else{
           		   
           		totalamount1=parseFloat(totalamount);
           	   }
           	   var tot=Math.ceil(totalamount1);
         	   var gst=tot*0.05;
         	   
         	   tot=tot+gst;
           	   
           	   		document.getElementById("amount").value=parseFloat(tot);
              }
              
             
              
             /* function totalprice(){
           	   
            	   var amount=document.getElementById("amountid").value;
            	   var labour=document.getElementById("labourid").value;
            	   var floor1=document.getElementById("floorid").value
            	   var totalamount=parseFloat(amount);
            	   var time=document.getElementById("date_foo1").value;
            	   var res = time.substr(11, 2);
            	   
            	   if(parseFloat(labour)>parseFloat(floor1) || (parseFloat(labour)==1 && parseFloat(floor1)==1) ){
            		  
            		if(parseFloat(floor1)==0){
            			
            		   totalamount= (labour*350)+(floor1*50)+parseFloat(amount); 
            		  }else{
            		  
            		totalamount= (labour*350)+(labour*50)+parseFloat(amount); 
            		  }
            	   } else if(parseFloat(floor1)>parseFloat(labour)){
            		   
            		   totalamount= (labour*350)+(floor1*50)+parseFloat(amount); 
            		   
            	   }else{
            	   
            	   totalamount=(labour*350)+(floor1*50)+(labour*50)+parseFloat(amount);
            	   }
            	   
            	   var totalamount1=0;
            	   if(parseInt(res)>=0 && parseInt(res)<8 || parseInt(res)>20 && parseInt(res)<=23  ){
            		   
            		   totalamount1=parseFloat(totalamount*1.5);
            		   
            		   
            	   } else{
            		   
            		   totalamount1=parseFloat(totalamount);
            	   }
            	   
            	   
            	   document.getElementById("amount").value=parseFloat(totalamount1);
            	  
            	   }*/