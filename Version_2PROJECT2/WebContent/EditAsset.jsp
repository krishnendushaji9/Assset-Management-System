<%@page import="com.ignite.jdbcdao.Asset_detJdbcDao"%>
<%@page import="com.ignite.beans.Asset_det"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("username")!=null){
if(request.getMethod().equalsIgnoreCase("get")){
	int ad_id = Integer.parseInt(request.getParameter("ad_id"));
	Asset_det asset_det = new Asset_detJdbcDao().find(ad_id);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/1stpage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Details</title>
<title>Edit Asset</title>
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
            <li class="logout">
                <a href="logout" class="dropbuton">Logout</a>
            </li>
        </ul>
    </nav>
    <div class="container" style="margin-top: 0px;">
	<form method="post">
	<div class="row">
      <div class="col-25">
        <label for="country">ID </label>
      </div>
      <div class="col-75">
      <div class="col-65" style="width: 3%">
       <input type="text" name="ad_id" id="ad_id" value="<%= asset_det.getAd_id()%>" readonly="readonly">
        </div>
        </div>
    </div>
	
	
		
	<div class="row">
      <div class="col-25">
        <label for="country">Asset Name</label>
      </div>
      <div class="col-75">
      
        <select id="ad_name" name="ad_name">
         <option selected value="0" disabled="disabled"><%= asset_det.getAd_name() %></option>
          <option value="Laptop">Laptop</option>
          <option value="Mobile Charger">Mobile Charger</option>
          <option value="Printer Charger">Printer Charger</option>
          <option value="Geo Magnetic Sensor â Ground">Geo Magnetic Sensor â Ground</option>
          <option value="LoRaGetwayâ Tata">LoRaGetwayâ Tata</option>
          <option value="Mobile Phone">Mobile Phone</option>
          <option value="Laser Printer â Colour">Laser Printer â Colour</option>
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
        <option selected value="0" disabled="disabled"><%= asset_det.getAd_type() %></option>
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
         <option selected value="0" disabled="disabled"><%= asset_det.getAd_class()%></option>
          <option value="HardWare">HardWare</option>
          <option value="SoftWare">SoftWare</option>
        </select>
    </div>
    </div>
		<input type="submit" value="Update">
	<!-- 	<input type="reset" value="Cancel"> -->
	</form>
</div>
</body>
</html>
<%
}
if(request.getMethod().equalsIgnoreCase("post")){
	
	%>
	<jsp:useBean id="asset_det" class="com.ignite.beans.Asset_det" scope="request"/>
	<jsp:setProperty property="*" name="asset_det"/>
	<jsp:forward page="updateAsset"/>
	<%
}
}
else{
	response.sendRedirect("Login.jsp");
}
%>