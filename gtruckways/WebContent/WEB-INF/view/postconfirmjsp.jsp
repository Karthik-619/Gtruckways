 <jsp:include page="localheader.jsp" />
  <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
  <style>
 td {
width:250px;
    padding: 9px 3rem;
    display: table-cell;
    text-align: left;
    vertical-align: middle;
    border-radius: 2px;
}
input:not([type]), input[type=text] {
    border-radius: 8px;
}
.btn {
    text-decoration: none;
    color: #fff;
    background-color:#01579b;
    text-align: center;
    letter-spacing: .1px;
   transition: .2s ease-out; 
    cursor: pointer;
    
    border-radius:120px;

}
.card .card-content {
    padding: 20px;
    border-radius: 0 0 2px 2px;
    background:rgb(44, 105, 113);
     text-align: center;
     color:white;
  
}

.card .card-action {
    border-top: 0;
    padding: 20px;
}

.row .col {
    float: left;
    box-sizing: border-box;
    padding: 0;
   
}
.title{
color:white;
font-size:20px;


}
table.bordered>thead>tr, table.bordered>tbody>tr {
    border-bottom: none;
}
/* .successs{
 margin-left:23rem;
 margin-top:5rem;
} */
 	@media ( max-width:603px ){
 .btn{
margin-left:40px;
 }
</style>

 <br><br>
 <div class="row center">
 <div class=" col s12 l12"><!-- main div -->


<div class="card col s12 l6 successs offset-l3" style="background: linear-gradient(141deg,#b3e0ff 0%, #b3e0ff 51%,#99b3ff 75%);">
<br>
<h5 style="color: #01579b !important;text-align:center"><i class="fa fa-check-circle" ></i>&nbsp;Booking Successful.</h5>
<p style="text-align:center">Thanks for using <b>gtruckways</b></p>
<p style="text-align:center">Your Booking Id: <b> ${postinfo.bookingId}</b></p>
<h5 style="text-align:center">We will contact you soon.</h5>
<br>

<a href="homePage" class="btn col s12 l3 offset-l5" style="font-size:20px;background-color:#1253a4;">&nbsp;Close</a>
<br>
<br>
<br><br>
</div>

 </div><!-- /main div -->
 </div>

 <jsp:include page="footer.jsp"/>		
