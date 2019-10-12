<%@page import="com.ignite.jdbcdao.Purchase_DetJdbcDao"%>
<%@page import="com.ignite.beans.Purchase_Det"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%
	if (session.getAttribute("username") != null) {
		ArrayList<Purchase_Det> purchase_dets = (ArrayList)new Purchase_DetJdbcDao().findAll();
		if (request.getMethod().equalsIgnoreCase("get")) {
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/1stpage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Details</title>
</head>
<body>
<div class="page-bg"></div>
<nav>
        <ul>
            <li class="dropdown">
                <a href="Homepage.jsp" class="dropbuton">Home</a>
                <div class="ddc">
                    <a href="##"></a>
                    <a href="###"></a>
                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbuton">About</a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbuton">Asset Management</a>
                <div class="ddc">
                    <a href="asset.jsp">Asset Details</a>                  
                    <a href="vendor.jsp">Vendor Creation</a>
                    <a href="Purchase.jsp">Purchase Order Creation</a>
                    <a href="asset_master.jsp">Asset Definition</a>
                    

                </div>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbuton">Services</a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropbuton">Contact</a>
            </li>
            <li class="dropdown" style="margin-left: 5%;">
                <a href="#" class="dropbuton">Welcome   <%= session.getAttribute("username") %></a>
            </li>
            <li class="dropdown" style="margin-left: 40%;">
                <a href="logout" class="dropbuton">Logout</a>
            </li>
        </ul>
    </nav>
    

  <div class="container" style="margin-top: 0px;">
  <form method="POST">
    <h2 align ="center">Purchase Details</h2>
  
   <div class="row">
      <div class="col-25">
        <label for="country">Purchase Order Number</label>
       </div>
      <div class="col-75">
      <div class="col-65">
       <input type="text" name="pd_order" placeholder="Type order id" autofocus="autofocus"  required>
       </div>
       </div>
       </div>
    
    <div class="row">
      <div class="col-25">
   
        <label for="pd_type">Purchase type</label>
       </div>
      <div class="col-75">
      <select id="pd_type" name="pd_type">
        <option selected disabled hidden>select</option>
        <option value="Mobile">Mobile</option>
	    <option value="Thermal Printer">Thermal Printer</option>
	    <option value="Sensor"> Sensor</option>
	    <option value="Gateway">Gateway</option>
	    <option value="Laptop">Laptop</option>
	    <option value="Boom Barrier">Boom Barrier</option>
        </select>
        </div>
        </div>
   
      <div class="row">
      <div class="col-25">
   
        <label for="country">Purchase Quantity</label>
      </div>
      <div class="col-75">
      <div class="col-65">
       <input type="text" name="pd_qty" placeholder="Enter the number" autofocus="autofocus" value required>
       </div>
       </div>
       </div>
       
     <div class="row">
      <div class="col-25">
   
        <label for="country">Vendor Name</label>
      </div>
      <div class="col-75">
        <select id="pd_vendor" name="pd_vendor">
        <option selected disabled hidden>select</options>
          <option value="Samsung">Samsung</option>
          <option value="MI">MI</option>
          <option value="Vivo">Vivo</option>
          <option value="GSoftland India">Softland India</option>
          <option value="LoRaGetway– Tata">LoRaGetway– Tata</option>
          <option value="Mobio">Mobio</option>
          <option value="ICOFSS">ICOFSS</option>
          <option value="WiFi solutions">WiFi solutions</option>
          <option value="TTalent Services">Talent Services</option>
        </select>
   </div>
   </div>
   
   <div class="row">
      <div class="col-25">
        <label for="country">Order Date</label>
     </div>
      <div class="col-75">
      <div class="col-65">
       <input type="date" name="pd_date" placeholder="mm/dd/yyyy" required>
</div>
     </div>
     </div>
    <div class="row">
      <div class="col-25">
   
        <label for="country">Delivery Date</label>
      </div>
      <div class="col-75">
     <div class="col-65">
       <input type="date" name="pd_ddate" placeholder="mm/dd/yyyy" autofocus="autofocus"required>
     </div>
     </div>
     </div>
     
     <div class="row">
      <div class="col-25">
   
        <label for="country">Purchase Status</label>
    </div>
      <div class="col-75">
     
        <select id="pd_status" name="pd_status" required>
        <option selected disabled hidden>select</options>
          <option value="PO - Raised with Supplier">PO - Raised with Supplier</option>
          <option value="Awaiting Delivery by Supplier">Awaiting Delivery by Supplier</option>
          <option value="Consignment Received">Consignment Received</option>
          <option value="Asset Details registered internally">Asset Details registered internally</option>
          <option value="Asset Allocated to Resources">Asset Allocated to Resources</option>
          <option value="Identified Faulty">Identified Faulty</option>
          <option value="Replaced- Repaired">Replaced- Repaired</option>
         
        </select>
    </div>
    </div>
  
    <input type="submit" value="Submit">
 
  </form>
</div>
  <div class="container" style="margin-top: 2px">
  <div align="center">
	<h2>List of Purchase</h2>
<table border="1" cellpadding="5" cellspacing="0" align="center">
			<tr>
			<th> ID </th>
			<th>Purchase Order</th>
			<th>Purchase Type</th>
			<th>Purchase Quantity</th>
			<th>Purchase Vendor Name</th>
			<th>Purchase Date</th>
			<th>Purchase Delivery Date</th>
			<th>Purchase status</th>
			<th>Edit/Delete</th>
			
</tr>

		<%
for(Purchase_Det purchase_det : purchase_dets){
%>

<tr>
<td><%= purchase_det.getPd_id() %></td>
<td><%= purchase_det.getPd_order() %></td>
<td><%= purchase_det.getPd_type() %></td>
<td><%= purchase_det.getPd_qty() %></td>
<td><%= purchase_det.getPd_vendor()%></td>
<td><%= purchase_det.getPd_date() %></td>
<td><%= purchase_det.getPd_ddate() %></td>
<td><%= purchase_det.getPd_status() %></td>
<td>
					<a href="EditPurchase.jsp?pd_id=<%=purchase_det.getPd_id()%>">Edit</a>|
					<a href="deletepurchase?pd_id=<%=purchase_det.getPd_id()%>">Delete</a>
</td>
</tr>
<%
}
%>	

	</table>

</div>
</div>
</body>
</html>
<%
	} // end of GET
	if (request.getMethod().equalsIgnoreCase("POST")) {  //POST
		%>
		<jsp:useBean id="purchase_det" class="com.ignite.beans.Purchase_Det" scope="request"/>
		<jsp:setProperty property="*" name="purchase_det"/>
		<jsp:forward page="purchase_det"/>
		<%
	}
	} //end of session
	else { // session no t found
		response.sendRedirect("Login.jsp");
	}
%>




