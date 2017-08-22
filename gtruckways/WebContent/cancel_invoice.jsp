<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Example 2</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <style>
      
      @font-face {
  font-family: SourceSansPro;
  src: url(SourceSansPro-Regular.ttf);
}

.clearfix:after {
  content: "";
  display: table;
  clear: both;
}

a {
  color: #0087C3;
  text-decoration: none;
}

body {
  position: relative;
  width:18cm;  
  height: 29.7cm; 
  margin: 0 auto; 
  color: #555555;
  background: #FFFFFF; 
  font-family: Arial, sans-serif; 
  font-size: 14px; 
  font-family: SourceSansPro;
}

header {
  padding: 10px 0;
  margin-bottom: 20px;
  border-bottom: 1px solid #AAAAAA;
}

#logo {
  float: left;
  margin-top: 8px;
}

#logo img {
  height: 70px;
}

#company {
  float: right;
  text-align: right;
}


#details {
  margin-bottom: 50px;
}

#client {
  padding-left: 6px;
  border-left: 6px solid #0087C3;
  float: left;
}

#client .to {
  color: #777777;
}

h2.name {
  font-size: 1.4em;
  font-weight: normal;
  margin: 0;
}

#invoice {
  float: right;
  text-align: right;
}

#invoice h1 {
  color: #0087C3;
  font-size: 2.4em;
  line-height: 1em;
  font-weight: normal;
  margin: 0  0 10px 0;
}

#invoice .date {
  font-size: 1.1em;
  color: #777777;
}

table {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 0;
  margin-bottom: 20px;
   
}

table th,
table td {
 padding: 4px;
  background: #EEEEEE;
  text-align: center;
  border-bottom: 1px solid #FFFFFF;
}

table th {
    border-right: 1px solid white;
    background: #0087C3;
    color:#000;
  white-space: nowrap;        
  font-weight: normal;
}

table td {
  text-align: center;
}

table td h3{
  color: #57B223;
  font-size: 1.2em;
  font-weight: normal;
  margin: 0 0 0.2em 0;
}

table .no {
  color: #FFFFFF;
  font-size: 1.6em;
  background: #57B223;
}

table .desc {
  text-align: left;
}

table .unit {
  background: #DDDDDD;
}

table .qty {
}

table .total {
  background: #57B223;
  color: #FFFFFF;
}

table td.unit,
table td.qty,
table td.total {
  font-size: 1.2em;
}

table tbody tr:last-child td {
  border: none;
}
tfoot{
    
}
tfoot td:last-child {
    border:1px solid black;
}
tfoot td:nth-last-child(2) {
   border:1px solid black;
} 
table tfoot td {
  padding: 5px 10px;
  background: #FFFFFF;
  border-bottom: none;
  font-size: 1em;
  white-space: nowrap; 
  
    
}



/*table tfoot tr:last-child td {
  color: #57B223;
  font-size: 1.4em;
  border-top: 1px solid #57B223; 

}*/

table tfoot tr td:first-child {
  border: none;
}

#thanks{
  font-size: 2em;
  margin-bottom: 50px;
}

#notices{
  padding-left: 6px;
  border-left: 6px solid #0087C3;  
}

#notices .notice {
  font-size: 1.2em;
}

footer {
  color: #777777;
  width: 100%;
  height: 30px;
  position: absolute;
  bottom: 0;
  border-top: 1px solid #AAAAAA;
  padding: 8px 0;
  text-align: center;
}
        input[id="test"]{
            
            width: 100%;
        }
        input[id="test1"]{
            width: 100%;
        }
        input[id="invoiceno"]{
            width: 58%;
        }
      </style>
  </head>
  <body>
  <br>
   <div style="border:1px solid gray; border-radius: 6px;padding:10px;">
    <header class="clearfix">
      <div id="logo">
        <img src="img/Logonew.png">
      </div>
      <div id="company">
        <h2 class="name">gtruckways</h2>
        <div>#1563,3 rd Floor,8th cross,<br>opposite BMTC Bus Depot,<br>Chandra Layout,Bangalore- 560040.<br></div>
        <div>+91 9590603333</div>
        <div><a href="#">info@gtruckways.com</a></div>
      </div>
    
    </header>
    <main>
     <div class="row">
      <div id="details" class="clearfix">
        <div id="client">
          <div class="to">INVOICE TO:</div>
          <h2 class="name"><input type="text" placeholder="Name"></h2>
          <h2 class="name"><input type="email" placeholder="email"></h2>
         <!-- <div class="address">banglore</div>
          <div class="email"><a href="#">example@gmail.com</a></div>-->
        </div>
        <div id="invoice">
        <label style="font-size:18px;color:#0087c3;">INVOICE</label>
         <input type="text" placeholder="Invoice No" id="invoiceno">
        <!--  <h1>INVOICE <input type="text"></h1>-->
          <div class="date"><label style="font-size:18px;color:#0087c3;">Date of Invoice:</label><input type="text"></div>
          <!--<div class="date">Due Date: 30/06/2014</div>-->
        </div>
      </div>
      <table border="0" cellspacing="0" cellpadding="0" >
        <thead>
          <tr>
           
            <th>Booking ID</th>
             <th class="">Vehicle Type</th>
            <th class="">Travel Date</th>
              <th class="">Cancellation Charge</th>
             <!-- <th>Extra km Ammount<span>(Rs.10/Km )</span></th>
              <th>Extra Hrs Amount<span>(Rs.120 per hr)</span></th>
              <th>Other Charges(Toll/Parking)</th>
              <th>Total</th>-->
          </tr>
        </thead>
        <tbody>
          <tr>
            
           <td><input type="text" id="test"></td>
            <td><input type="text" id="test"></td>
            <td><input type="text" id="test"></td>
            <td><input type="text" id="test"></td>
          
          </tr>
          
        </tbody>
        
        <tfoot>
        <tr></tr>
            <tr>   
            <td colspan=""></td>
            <td colspan=""></td>       
            <td colspan="1">Sub Total</td>
            <td><input type="text" id="test1"></td>
          </tr>
      
          <tr>
        
           
           
            <td colspan=""></td>
            <td colspan=""></td>
          
            <td colspan="1">Total</td>
            <td><input type="text" id="test1"></td>
          </tr>
          
         
        </tfoot>
      </table>
     </div>
  </body>
</html>