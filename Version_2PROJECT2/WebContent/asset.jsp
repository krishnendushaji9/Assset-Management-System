<%@page import="com.ignite.jdbcdao.Asset_detJdbcDao"%>
<%@page import="com.ignite.beans.Asset_det"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%
	if (session.getAttribute("username") != null) {
		ArrayList<Asset_det> asset_dets = (ArrayList)new Asset_detJdbcDao().findAll();
		if (request.getMethod().equalsIgnoreCase("get")) {
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/1stpage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
<div class="page-bg">
</div>
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
<div class="container" style="margin-top: 10px;">
  <form method="POST">
  <h2 align ="center">Asset Details</h2>
    <div class="row">
      <div class="col-25">
        <label for="country">Asset Name</label>
      </div>
      <div class="col-75">
      
        <select id="ad_name" name="ad_name">
        <option selected disabled hidden>select</options>
          <option value="Laptop">Laptop</option>
          <option value="Mobile Charger">Mobile Charger</option>
          <option value="Printer Charger">Printer Charger</option>
          <option value="Geo Magnetic Sensor – Ground">Geo Magnetic Sensor – Ground</option>
          <option value="LoRaGetway– Tata">LoRaGetway– Tata</option>
          <option value="Mobile Phone">Mobile Phone</option>
          <option value="Laser Printer – Colour">Laser Printer – Colour</option>
          <option value="Desktop">Laptop</option>
          <option value="Thermal Printer">Laptop</option>
          <option value="Lora Getaway - ICFOSS">Laptop</option>
        </select>
      </div>
      
    </div>
    <div class="row">
      <div class="col-25">
        <label for="ad_type">Asset type</label>
      </div>
      <div class="col-75">
      <select id="ad_type" name="ad_type">
        <option selected disabled hidden>select</options>
          <option value="Laptop">Laptop</option>
          <option value="Sensor">Sensor</option>
          <option value="Gateway">Gateway</option>
        </select>
    </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="asset_class">Asset Class</label>
      </div>
      <div class="col-75">
      <select id="ad_class" name="ad_class">
        <option selected disabled hidden>select</options>
          <option value="HardWare">HardWare</option>
          <option value="SoftWare">SoftWare</option>
        </select>
    </div>
    </div>
    
    
    <div class="col">
    <input type="submit" value="Submit">
    </div>
</form>
</div>
<div class="container" style="margin-top: 2px">
<div align="center">
	<h2 >List of Assets</h2>
	<table border="1" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<th>ID</th>
			<th>Asset Name</th>
			<th>Asset type</th>
			<th>Asset Class</th>
			<th>Edit/Delete</th>
		</tr>
		<%
for(Asset_det asset_det : asset_dets){
%>
<tr>
<td><%= asset_det.getAd_id() %></td>
<td><%= asset_det.getAd_name() %></td>
<td><%= asset_det.getAd_type() %></td>
<td><%= asset_det.getAd_class() %></td>
<td>
					<a href="EditAsset.jsp?ad_id=<%=asset_det.getAd_id()%>">Edit</a>|
					<a href="deleteasset?ad_id=<%=asset_det.getAd_id()%>">Delete</a>
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
		<jsp:useBean id="asset_det" class="com.ignite.beans.Asset_det" scope="request"/>
		<jsp:setProperty property="*" name="asset_det"/>
		<jsp:forward page="asset_det"/>
		<%
	}
	} //end of session
	else { // session not found
		response.sendRedirect("Login.jsp");
	}
%>