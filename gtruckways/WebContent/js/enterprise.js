/*
var e_name_srch,Enterprisesrchname;
e_name_srch=document.getElementById('e_name_srch');
Enterprisesrchname=document.getElementById('Enterprisesrchname');
if(Enterprisesrchname!=null){
	Enterprisesrchname.onkeyup=function(e){
           if (e.keyCode > 65) { // escape key maps to keycode `27`
           	sendAjaxRequest();
       }
	};

}

function sendAjaxRequest(){
	 if(Enterprisesrchname.value.length>0 ){
	 req=createRequestObject();
	 req.open('GET','enterpriseSearch?enterpriseName='+Enterprisesrchname.value,true);
	 req.onreadystatechange=showDatas;
	 req.send(null);
	 }
	 }

function showDatas(){
	 if(req.readyState==4){
		 if(req.status==200){
			 var resp=eval('('+req.responseText+')');
			 alert(resp);
			 if(resp!=""){
				 e_name_srch.innerHTML='';
			 document.getElementById("ent-name").innerHTML="";
			for(var j=0;j<resp.length;j++){
				var opt=document.createElement('option');
				 opt.value=resp[j].city;
				 opt.innerHTML=resp[j].city;
				 e_name_srch.appendChild(opt);
			}
			 }else{
				 document.getElementById("ent-name").innerHTML="Name not found";
				 Enterprisesrchname.focus();
				 }
		 }
	 }
}
*/
/*window.onload=initall;
var truckType;
function initall(){
	truckType=document.getElementById('vehicleTypeId');
	alert(trucktype);
	truckType.onchange=sendAjaxRequestRegNo;

}

function sendAjaxRequestRegNo(){
	 req=createRequestObject();
	alert("trucktype");
	 req.open('GET','rgNo?vehicleType='+truckType.value,true);
	 req.onreadystatechange=showDataRegNo;
	 req.send(null);
	 
	 }

function showDataRegNo(){
	 if(req.readyState==4){
		 if(req.status==200){
			 var resp=eval('('+req.responseText+')');
				 var vehi=document.getElementById('vehicle');
				 vehi.innerHTML=' <option value="0" >Truck Reg no</option>';
				//var city=document.getElementById('city');
					//var district=document.getElementById('district');
					//var state=document.getElementById('state');
					
	for(j=0;j<resp.length;j++){
		 var opt=document.createElement("option");
		 opt.value=resp[j].regisNo;
		 opt.innerHTML=resp[j].vehi;

		 vehi.appendChild(opt);

			 
			 }
			 for(i=0;i<resp.length;i++){
				 city.value=resp[i].cityId;
				 city.innerHTML=resp[i].city;
				 district.value=resp[i].districtId;
				 district.innerHTML=resp[i].district;
				 state.value=resp[i].stateId;
				 state.innerHTML=resp[i].state;
				 }
		 }
	 }
}*/




window.onload=initall;

var vehicleTypeId,vehicle,model;
function initall(){
	vehicleTypeId=document.getElementById("vehicleTypeId");
	
	vehicle=document.getElementById("vehicle");
	
	if(vehicleTypeId!=null){
		
		vehicleTypeId.onchange=sendAjaxRequest;
		
		}else{}
	
	
}
function sendAjaxRequest(){

	 req=createRequestObject();
	
	 req.open("get","rgNo?vehicleType="+vehicleTypeId.value,true);

	 req.onreadystatechange=showData1;
	 req.send(null);
}
function showData1(){
	
	 if(req.readyState==4){
		 if(req.status==200){
			 var resp=eval('('+req.responseText+')');
			 vehicle.innerHTML="<option value=''>Select One </option>";
			 /*var sel = document.createElement("select");
			 sel.id="trm";
			 sel.name="trm";*/
			 for(var j=0;j<resp.length;j++){
				 var opt=document.createElement("option");
				 opt.value=resp[j].regisNo;
				 opt.innerHTML=resp[j].regisNo;
				 vehicle.appendChild(opt);
				 $('select').material_select();
			}
			 
			 /*model.appendChild(sel);*/
			 
			
					
				
		 }
	 }
}
