<%@page import="com.ignite.jdbcdao.Asset_MasterJdbcDao"%>
<%@page import="com.ignite.beans.Asset_Master"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%
	if (session.getAttribute("username") != null) {
		ArrayList<Asset_Master> asset_masters = (ArrayList)new Asset_MasterJdbcDao().findAll();
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
  <h2 align ="center">Asset Definition </h2>
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
      <input type="text" name="am_myear" id="am_myear">
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
        <label for="am_warranty">Asset Master Warranty</label>
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
<div class="container" style="margin-top: 2px">
<div align="center">
	<h2 >Details Asset Master</h2>
	<table border="1" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<th>ID</th>
			<th>Asset Master Type</th>
			<th>Asset Master Make</th>
			<th>Asset Master Model</th>
			<th>Serial Number</th>
			<th>Purchase Date</th>
			<th>Warranty</th>
			<th>Asset Master from</th>
			<th>Asset Master To</th>
			<th>Edit/Delete</th>
		</tr>
		<%
for(Asset_Master asset_master : asset_masters){
%>
<tr>
<td><%= asset_master.getAm_id() %></td>
<td><%= asset_master.getAm_type() %></td>
<td><%= asset_master.getAm_make() %></td>
<td><%= asset_master.getAm_model() %></td>
<td><%= asset_master.getAm_snumber() %></td>
<td><%= asset_master.getAm_pdate() %></td>
<td><%= asset_master.getAm_warranty() %></td>
<td><%= asset_master.getAm_from() %></td>
<td><%= asset_master.getAm_to() %></td>
<td>
					<a href="EditassetMaster.jsp?am_id=<%=asset_master.getAm_id()%>">Edit</a>|
					<a href="deleteassetmaster?am_id=<%=asset_master.getAm_id()%>">Delete</a>
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
		<jsp:useBean id="asset_master" class="com.ignite.beans.Asset_Master" scope="request"/>
		<jsp:setProperty property="*" name="asset_master"/>
		<jsp:forward page="assetmaster"/>
		<%
	}
	} //end of session
	else { // session not found
		response.sendRedirect("Login.jsp");
	}
%>