<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>gTruckWays</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="icon" href="img/logo.png" type="image/gif" sizes="16x16">

<style>
  @import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);
  body { margin: 0; padding: 0; background: #e1e1e1; }
   div, p, a, li, td { -webkit-text-size-adjust: none; }
  body { width: 100%; height: 100%; background-color: #e1e1e1; margin: 0; padding: 0; -webkit-font-smoothing: antialiased; }
  html { width: 100%; }
    p { padding: 0 !important; margin-top: 0 !important; margin-right: 0 !important; margin-bottom: 0 !important; margin-left: 0 !important; }
  .visibleMobile { display: none; }
  .hiddenMobile { display: block; }
     @media only screen and (max-width: 600px) {
  body { width: auto !important; }
  table[class=fullTable] { width: 96% !important; clear: both; }
  table[class=fullPadding] { width: 85% !important; clear: both; }
  table[class=col] { width: 45% !important; }
  .erase { display: none; }
  }

  @media only screen and (max-width: 420px) {
  table[class=fullTable] { width: 100% !important; clear: both; }
  table[class=fullPadding] { width: 85% !important; clear: both; }
  table[class=col] { width: 100% !important; clear: both; }
  table[class=col] td { text-align: left !important; }
  .erase { display: none; font-size: 0; max-height: 0; line-height: 0; padding: 0; }
  .visibleMobile { display: block !important; }
  .hiddenMobile { display: none !important; }
  }
</style> 
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="fulltable" bgcolor="#e1e1e1">
<tr>
<td height="20"></td>
</tr>

<tr>
<td>
<table width="800" border="0" cellpadding="0" cellspacing="0" align="center" class="fulltable" bgcolor="#ffffff" style="border-radius:10px 10px 0 0">
<tr class="hiddenMobile">
<td height="40"></td>
</tr>
<tr class="visibleMobile">
<td height="30"></td>
</tr>
<tr>
<td>
<table width="700" border="0" cellpadding="0" cellspacing="0" align="center" class="fullPadding">
<tbody>
<tr>
<td>
<table width="220" border="0" cellpadding="0" cellspacing="0" align="left" class="col">
<tbody>
<tr>
<td align="left"><img src="img/gtlogo.jpg" width="40%" height="32" alt="logo" border="0"/></td>
</tr>
<tr class="hiddenMobile">
<td height="40"></td>
</tr>
<tr class="visibleMobile">
<td height="20"></td>
</tr>
<tr>
<td style="font-size:12px;color:#5b5b5b;font-family: 'Open Sans', sans-serif;line-height:18px;vertical-align:top;text-align:left;">
 Gtruckways
  <br>No.1108 / L, 2 nd Floor,
Near Hampinagar Bus Stand,
RPC Layout,Vijayanagar,
Bangalore - 560104
 <br>
</td>
</tr>
</tbody>
</table>
<table width="220" cellspacing="0" cellpadding="0" align="right" class="col">
<tbody>
<tr class="visibleMobile">
<td height="20"></td>
</tr>
<tr>
<td height="5"></td>
</tr>
<tr>
<td style="font-size:21px;color:#0288d1;letter-spacing:-1; font-family: 'Open Sans', sans-serif;line-height:1;vertical-align:top;text-align:right;">
<b>Invoice</b>
</td>
</tr>
<tr class="hiddenMobile">
<td height="50"></td>
</tr>
<tr class="visibleMobile">
<td height="20"></td>
</tr>
<tr>
<td style="font-size:12px;color:#5b5b5b;font-family: 'Open Sans', sans-serif;line-hight:18px;vertical-align:top;text-align:right;">
<small>Enterprise ID</small>#77979779000<br/>
<small>MARCH 4TH 2016</small><br>
<small>MobileNo:84858788</small><br/>
<small>Email-Id:ddddd@gmail.com</small>
</td>
</tr>
</tbody>
</table>
</td>
</tr>
</tbody>

</table>
</td>

</tr>
</table>


</td>
</tr>
</table>
<!--Header-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="fullTable" bgcolor="#e1e1e1">
<tbody>
<tr>
<td>
<table width="800" border="0" cellpadding="0" cellspacing="0" align="center" class="fullTable" bgcolor="#ffffff">
<tbody>
<tr>
<tr class="hiddenMobile">
<td height="60"></td>
</tr>
<tr class="visibleMobile">
<td height="40"></td>
</tr>
<tr>
<td>
<table width="700" border="0" cellspacing="0" cellpadding="0" align="center" class="fullTable"  >
<tbody>
<tr style="border:1px solid red;">
<th style="font-size:12px;font-family: 'Open Sans', sans-serif;color:#0288d1;font-weight:normal;line-height:1;vertical-align:top;padding: 0 0px 7px 0; "align="center">
<b>SL.NO</b>
</th>
<th style="font-size:12px;font-family: 'Open Sans', sans-serif;color:#0288d1;font-weight:normal;line-height:1;vertical-align:top;padding: 0 0px 7px 0; "align="center">
<b>Vehicle Regno#</b>
</th>
<th style="font-size:12px;font-family: 'Open Sans', sans-serif;color:#0288d1;font-weight:normal;line-height:1;vertical-align:top;padding: 0 0px 7px 0; "  align="center">
<b>Vehicle Type</b>
</th>
  <th style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #0288d1; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 0 7px; " align="center">
<b>Distance</b>
   </th>
     <th style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #0288d1; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 0 7px; " align="center">
<b>Start Date</b>
   </th>
    <th style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #0288d1; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 0 7px; " align="center">
<b>End Date</b>
   </th>
     <th style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #0288d1; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 0 7px;" align="center">
<b>Amount</b>
   </th>
</tr>
<tr>
<td height="1" style="background:#bebebe" colspan="7"></td>
</tr>
<tr>
<td height="10" colspan="7"></td>
</tr>
<tr>
<td style="font-size:12px;font-family: 'Open Sans', sans-serif; color: #646a6e;line-height:15px;vertical-align:top;padding:10px 5px; " align="center" class="artical"><small>1</small></td>
<td style="font-size:12px;font-family: 'Open Sans', sans-serif; color: #646a6e;line-height:15px;vertical-align:top;padding:10px 5px;" class="artical" align="center"><small><a href="">KA1234</a></small></td>
 <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e;  line-height: 15px;  vertical-align: top; padding:10px 5px;" align="center"><small>TATA ACE</small></td>
 <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e;  line-height: 15px;  vertical-align: top; padding:10px 5px;" align="center">200</td>
 <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #1e2b33;  line-height: 15px;  vertical-align: top; padding:10px 5px;" align="center">20-10-17</td>
   <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #1e2b33;  line-height: 15px;  vertical-align: top; padding:10px 5px;" align="center">24-10-17</td>
  <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #1e2b33;  line-height: 15px;  vertical-align: top; padding:10px 5px;" align="center">5000</td>
</tr>
<tr>
<td height="1" colspan="7" style="border-bottom:1px solid #e4e4e4"></td>
</tr>

</tbody>
</table>
</td>
</tr>
<tr>
<td height="20"></td>
</tr>

</tbody>
</table>
</td>
</tr>
</tbody>
</table>
<!-- order details -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="fullTable" bgcolor="#e1e1e1">
  <tbody>
    <tr>
      <td>
        <table width="800" border="0" cellpadding="0" cellspacing="0" align="center" class="fullTable" bgcolor="#ffffff">
          <tbody>
            <tr>
              <td>

                <!-- Table Total -->
                <table width="690" border="0" cellpadding="0" cellspacing="0" align="center" class="fullPadding">
                  <tbody>
                    <tr>
                      <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e; line-height: 22px; vertical-align: top; text-align:right; ">
                        Subtotal
                      </td>
                      <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e; line-height: 22px; vertical-align: top; text-align:right; white-space:nowrap;" width="80">
                    5000.00
                      </td>
                    </tr>
                    <tr>
                      <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e; line-height: 22px; vertical-align: top; text-align:right; ">
                        Additional Charges
                      </td>
                      <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e; line-height: 22px; vertical-align: top; text-align:right; ">
                     300.00
                      </td>
                    </tr>
                    <tr>
                      <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #000; line-height: 22px; vertical-align: top; text-align:right; ">
                        <strong>Grand Total</strong>
                      </td>
                      <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #000; line-height: 22px; vertical-align: top; text-align:right; ">
                        <strong>5300.00</strong>
                      </td>
                    </tr>

                  </tbody>
                </table>
                <!-- /Table Total -->

              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  
  </tbody>
</table>
<!-- /Total -->

<!-- /Information -->




<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="fullTable" bgcolor="#e1e1e1">

<tbody>

<tr>
<td>

<table width="800" border="0" cellpadding="0" cellspacing="0" align="center" class="fullTable" bgcolor="#ffffff">
<tbody>

<tr>
<td>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="left" class="col">
<tbody >
<tr>
<td align="left" style="" ><h5 style="background-color:rgba(128, 128, 128, 0.53);">Trip Details</h5></td>
</tr>


</tbody>
</table>
<table width="220"  cellspacing="0" cellpadding="0" align="right">
<tbody>
<tr class="visibleMobile">
<td height="20"></td>
</tr>
<tr>
<td style="font-size:12px;color:#5b5b5b;font-family: 'Open Sans', sans-serif;line-hight:18px;vertical-align:top;text-align:center;">
<span><b>VEHICLE TYPE:</b></span>Tata Ace<br/>
<span><b>Vehicle RegNo#:</b></span>ka1234<br>
</td>
</tr>
</tbody>
</table>
</td>
</tr>
<tr>
<td>
<table width="700" border="0" cellspacing="0" cellpadding="0" align="center" class="fullTable"  >
<tbody>

<tr style="border:1px solid red;">

<th style="font-size:12px;font-family: 'Open Sans', sans-serif;color:#0288d1;font-weight:normal;line-height:1;vertical-align:top;padding: 0 0px 7px 0; "align="center">
<b>SL.NO</b>
</th>

  <th style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #0288d1; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 0 7px; " align="center">
<b>Date of Travel</b>
   </th>
    <th style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #0288d1; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 0 7px; " align="center">
<b>No of KM/Day</b>
   </th>
       <th style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #0288d1; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 0 7px; " align="center">
<b>No of Hr/Day</b>
   </th>
     <th style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #0288d1; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 0 7px; " align="center">
<b>Additional Time</b>
   </th>
    <th style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #0288d1; font-weight: normal; line-height: 1; vertical-align: top; padding: 0 0 7px; " align="center">
<b>Distance</b>
   </th>

</tr>
<tr>
<td height="1" style="background:#bebebe" colspan="8"></td>
</tr>
<tr>
<td height="10" colspan="8"></td>
</tr>
<tr>
<td style="font-size:12px;font-family: 'Open Sans', sans-serif; color: #646a6e;line-height:15px;vertical-align:top;padding:10px 5px; " align="center" class="artical"><small>1</small></td>
 <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e;  line-height: 15px;  vertical-align: top; padding:10px 5px;" align="center">200</td>
  <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #646a6e;  line-height: 15px;  vertical-align: top; padding:10px 5px;" align="center">12-01-17</td>
 <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #1e2b33;  line-height: 15px;  vertical-align: top; padding:10px 5px;" align="center">10:10</td>
   <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #1e2b33;  line-height: 15px;  vertical-align: top; padding:10px 5px;" align="center">1</td>
</tr>
<tr>
<td height="1" colspan="7" style="border-bottom:1px solid #e4e4e4"></td>
</tr>

</tbody>
</table>
</td>
</tr>
<tr>
<td height="20"></td>
</tr>

</tbody>
</table>
</td>
</tr>
</tbody>
</table>
</fieldset>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="fullTable" bgcolor="#e1e1e1" >
  <tbody>
    <tr>
      <td>
        <table width="800" border="0" cellpadding="0" cellspacing="0" align="center" class="fullTable" bgcolor="#ffffff" style="border-radius:0px 0px 10px 10px;">
          <tbody>
            <tr>
              <td>

                <!-- Table Total -->
                <table width="690" border="0" cellpadding="0" cellspacing="0" align="center" class="fullPadding">
                  <tbody>
                    <tr>
                      <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #000; line-height: 22px; vertical-align: top; text-align:right; ">
                              <strong>Total Distance</strong>
                      </td>
                      <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #000; line-height: 22px; vertical-align: top; text-align:right; white-space:nowrap;" width="80">
                   <strong>5300.00</strong>
                      </td>
                    </tr>
                  <tr>
                    <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #000; line-height: 22px; vertical-align: top; text-align:right; ">
                              <strong>Additional Time</strong>
                      </td>
                          <td style="font-size: 12px; font-family: 'Open Sans', sans-serif; color: #000; line-height: 22px; vertical-align: top; text-align:right; white-space:nowrap;" width="80">
                   <strong>10</strong>
                      </td>
                  </tr>
                   

                  </tbody>
                </table>
                <!-- /Table Total -->

              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </tbody>
</table>
</body>
</html>