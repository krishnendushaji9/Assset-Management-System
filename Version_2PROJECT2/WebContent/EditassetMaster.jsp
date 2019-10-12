<%@page import="com.ignite.jdbcdao.Asset_MasterJdbcDao"%>
<%@page import="com.ignite.beans.Asset_Master"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%

ArrayList<Asset_Master> asset_masters = (ArrayList)new Asset_MasterJdbcDao().findAll();

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
  <h2 align ="center">Asset Master </h2>
    <div class="row">
      <div class="col-25">
        <label for="country">Asset Master Type</label>
      </div>
      <div class="col-75">
     
        <select id="am_type" name="am_type">
        <option selected disabled hidden>select</options>
         <option value="Mobile">Mobile</option>
          <option value="Thermal Printer">Thermal Printer</option>
          <option value="Sensor">Sensor</option>
          <option value="Gateway">Gateway</option>
          <option value="Laptop">Laptop</option>
          <option value="Booom Barrier">Boom Barrier</option>
        </select>
      </div>
     
    </div>
    <div class="row">
      <div class="col-25">
        <label for="am_make">Asset Master Make</label>
      </div>
      <div class="col-75">
      <select id="am_tmake" name="am_make">
        <option selected disabled hidden>select</options>
           <option value="Samsung">Samsung</option>
          <option value="MI">MI</option>
          <option value="Vivo">Vivo</option>
          <option value="Softland India">Softland India</option>
          <option value="Mobio">Mobio</option>
          <option value="ICOFSS">ICOFSS</option>
          <option value="WiFi solutions">Wifi Solutions</option>
          <option value="Talent Services">Talent Services</option>
        </select>
    </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="asset_class">Asset Master Model</label>
      </div>
      <div class="col-75">
     <input type="text" name="am_model" id="am_model">
    </div>
    </div>
   
     <div class="row">
      <div class="col-25">
        <label for="asset_class">Serial Number</label>
      </div>
      <div class="col-75">
      <input type="text" name="am_snumber" id="am_snumber">
    </div>
    </div>
   
     <div class="row">
      <div class="col-25">
        <label for="asset_class">Asset Master year</label>
      </div>
      <div class="col-75">
   
     <select id="am_myear" name="am_myear">
     <option selected disabled hidden>select</options>
     <option value="2019">2019</option>
     <option value="2018">2018</option>
    <option value="2017">2017</option>
    <option value="2016">2016</option>
    <option value="2015">2015</option>
    <option value="2014">2014</option>
    <option value="2013">2013</option>
    <option value="2012">2012</option>
    <option value="2011">2011</option>
    <option value="2010">2010</option>
    <option value="2009">2009</option>
    <option value="2008">2008</option>
    <option value="2007">2007</option>
    <option value="2006">2006</option>
    <option value="2005">2005</option>
    <option value="2004">2004</option>
    <option value="2003">2003</option>
    <option value="2002">2002</option>
    <option value="2001">2001</option>
    <option value="2000">2000</option>
    </select>
    </div>
    </div>
   
    <div class="row">
      <div class="col-25">
        <label for="country">Purchase Date</label>
     </div>
      <div class="col-75">
      <div class="col-65">
       <input type="date" name="am_pdate" placeholder="mm/dd/yyyy" >
</div>
     </div>
     </div>
     
       <div class="row">
      <div class="col-25">
        <label for="asset_class">Asset Master Warranty</label>
      </div>
      <div class="col-75">
      <select id="am_warranty" name="am_warranty">
        <option selected disabled hidden>select</options>
          <option value="Y">YES</option>
          <option value="N">NO</option>
        </select>
    </div>
    </div>
     
     <div class="row">
      <div class="col-25">
        <label for="country">Asset Master From</label>
     </div>
      <div class="col-75">
      <div class="col-65">
       <input type="date" name="am_from" placeholder="mm/dd/yyyy" >
</div>
     </div>
     </div>
     
     <div class="row">
      <div class="col-25">
        <label for="country">Asset Master To</label>
     </div>
      <div class="col-75">
      <div class="col-65">
       <input type="date" name="am_to" placeholder="mm/dd/yyyy" >
</div>
     </div>
     </div>
   
   
    <div class="col">
    <input type="submit" value="Submit">
    </div>
</form>
</div>

<%
if (request.getMethod().equalsIgnoreCase("POST")) {  //POST
%>
<jsp:useBean id="asset_master" class="com.ignite.beans.Asset_Master" scope="request"/>
<jsp:setProperty property="*" name="asset_master"/>
<jsp:forward page="updateassetmaster"/>
<%}%>