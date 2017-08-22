window.onload=initall;
var e_email,spr1,lmbl,l_mobile,emobile,spl,mobile,leml,lemail,prevAmount,trkType,nextAmount,userFromarea,time,userToarea,peakNewAmount,peakAmount,labour,helper,gstId;
function initall(){
	spl=document.getElementById('spl');
	emobile=document.getElementById('emobile');
	if(emobile!=null){
		emobile.onblur=chk;
	}
	e_email=document.getElementById('e_email');
	spr1=document.getElementById('spr1');
	if(e_email!=null){
		e_email.onchange=sendAjaxRequestChkeml;
	}
	l_mobile=document.getElementById('l_mobile');
	lmbl=document.getElementById('lmbl');
	if(l_mobile!=null){
		l_mobile.onblur=sendAjaxRequestChkmbl;
	}
	
	Gmobile=document.getElementById('Gmobile');
	leml=document.getElementById('leml');
	lemail=document.getElementById('lemail');
	gstId=document.getElementById('gstId');
	if(Gmobile!=null){
		Gmobile.onblur=sendAjaxReqGetEmail;
		
	}
	
	trkType=document.getElementById('trckType').value;

	

	 userFromarea=document.getElementById('userFromarea');
	 
	 userToarea=document.getElementById('userToarea');
	  
	 labour=document.getElementById("labourid").value; 
	 
	 helper=document.getElementById("helper").value; 
	 
	 prevAmount=document.getElementById('amountid');
	 
	 nextAmount=document.getElementById('amount');
	 
	 time=document.getElementById('date');
	 
	 if(trkType!=null){
		 
	  trkType.onchange=sendAjaxReqGetPrice;
	  
	 }
	
}

function chk(){
	if(emobile.value!=""){
	req=createRequestObject();
	
	req.open("get","chkMob?mobile="+emobile.value,true);
	req.onreadystatechange=showData;
	 req.send(null);
	}
}
function showData(){
	 if(req.readyState==4){
		 if(req.status==200){
			 var resp=eval('('+req.responseText+')');
			 if(resp.msg!=""){
				 spl.innerHTML=resp.msg;
				 emobile.focus();
				 }else
				 {
					 spl.innerHTML='';
					 
				 }
		 }
	 }
}
function sendAjaxRequestChkmbl(){
	 req=createRequestObject();

	 req.open('GET','chkLogMob?lmobile='+l_mobile.value,true);
	 req.onreadystatechange=showDataChkmbl;
	 req.send(null);
}

function showDataChkmbl(){
	 if(req.readyState==4){
		 if(req.status==200){
			 var resp=eval('('+req.responseText+')');
			 if(resp.msg!=""){
				 lmbl.innerHTML=resp.msg;
					l_mobile.focus();
				 }else
				 {
					 lmbl.innerHTML='';
				 }
		 }
	 }
}
function sendAjaxRequestChkeml(){

	 req=createRequestObject();
	
	 req.open('GET','checkEmail?email='+e_email.value,true);
	 req.onreadystatechange=showDataChkeml;
	 req.send(null);

	 }
	function showDataChkeml(){
		
	 if(req.readyState==4){
		 if(req.status==200){
			 var resp=eval('('+req.responseText+')');
			 if(resp.msg!=""){
				 spr1.innerHTML=resp.msg;
				 
				 e_email.focus();
			 }else
			 {
				 spr1.innerHTML='';
			 }
		 }
	 }
}
	
	function sendAjaxReqGetEmail(){
		
		if(Gmobile.value!=""){
			req=createRequestObject();
	
			 req.open('GET','getEmail?Gmobile='+Gmobile.value,true);
			 req.onreadystatechange=showDataGetMbl;
			 req.send(null);
		}
	}

	function showDataGetMbl(){
		 if(req.readyState==4){
			 if(req.status==200){
				 var resp=eval('('+req.responseText+')');
				 if(resp.msg!=""){
					 
					 lemail.value=resp.msg;
					 gstId.value=resp.gst;
					 document.getElementById("signUpDivId").style.display="none";
					 lemail.readOnly=true;
					 lemail.className="validate1";
					
					 }else
					 {
						 leml.innerHTML='';
						 lemail.value='';
						 gstId.value='';
						 document.getElementById("signUpDivId").style.display="block";
						 lemail.readOnly=false;
						 
					 }
			 }
		 }
	}
	
	function sendAjaxReqGetPrice(){
		
		  if(trkType.value!=""){
			 req=createRequestObject();
			
		    req.open('GET','ajaxGetPrice?truckType='+trkType.value+'&fromCity='+userFromarea.value+'&toCity='+userToarea.value,true);
		    req.onreadystatechange=showDataGetPrice;
		    req.send(null);
		  }
		 }

		 function showDataGetPrice(){
			
		    if(req.readyState==4){
		    if(req.status==200){
		     var resp=eval('('+req.responseText+')');
		     
		    if(resp.msg!=""){
		    	
		    	  var res = time.value.substr(11, 2);
		    	 
		    	   
		          var totalamount=parseFloat(resp.msg);
		        
		          var totalamount1=0;
		          if(parseInt(res)>=0 && parseInt(res)<8 || parseInt(res)>20 && parseInt(res)<=23  ){
		         
		        	  	totalamount1=parseFloat(totalamount*1.5);
		        	  	
		        
		          } else{
		        
		        	  	totalamount1=parseFloat(totalamount);
		        	  	 
		       }
		         
		          	nextAmount.value=parseFloat(totalamount1);
		          	document.getElementById('labourid').value=parseFloat(resp.labourprice);
			        prevAmount.value=parseFloat(resp.msg);
			     	document.getElementById('helper').value=0;
		    }
		    }
		    }
		    
		    
		    
		    
		 }	    
		    
		    
		    
		    /*function sendAjaxReqGetCouponAmount(){
				
				  if(trkType.value!=""){
					 req=createRequestObject();
					
				    req.open('GET','ajaxCoupon?promoCode='+promocode.value+'&totalAmount='+amountid.value,true);
				    req.onreadystatechange=showDataGetPrice;
				    req.send(null);
				  }
				 }

				 function showDataGetPrice(){
					
				    if(req.readyState==4){
				    if(req.status==200){
				     var resp=eval('('+req.responseText+')');
				     
				    if(resp.msg!=""){
				    	
				    	  var res = time.value.substr(11, 2);
				    	 
				    	   
				          var totalamount=parseFloat(resp.msg);
				        
				          var totalamount1=0;
				          if(parseInt(res)>=0 && parseInt(res)<8 || parseInt(res)>20 && parseInt(res)<=23  ){
				         
				        	  	totalamount1=parseFloat(totalamount*1.5);
				        	  	
				        
				          } else{
				        
				        	  	totalamount1=parseFloat(totalamount);
				        	  	 
				       }
				         
				       nextAmount.value=parseFloat(totalamount1);
				       
					        prevAmount.value=parseFloat(resp.msg);
					        
				    }
				    }
				    }
		    
		    
		    
		    
}*/