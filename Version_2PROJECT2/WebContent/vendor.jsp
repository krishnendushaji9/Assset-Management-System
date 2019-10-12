 <%@page import="com.ignite.jdbcdao.Vendor_detJdbcDao"%>
<%@page import="com.ignite.beans.Vendor_Det"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%
	if (session.getAttribute("username") != null) {
		ArrayList<Vendor_Det> vendor_dets = (ArrayList)new Vendor_detJdbcDao().findAll();
		if (request.getMethod().equalsIgnoreCase("get")) {
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/1stpage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Details</title>
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
    

<div class="container" style="margin-top: 10px;">
  <form method="POST">
 <h2 align ="center">Vendor Details</h2> 
    <div class="row">
      <div class="col-25">
        <label for="country">Vendor Name</label>
      </div>
      <div class="col-75">
     <Select name="vd_name" size="1" id="vd_name">
    <option selected value="0" disabled="disabled">Select a Vendor Name</option>
    <option value="Samsung">Samsung</option>
    <option value="MI">MI</option>
    <option value=" Vivo"> Vivo</option>
    <option value="Softland India">Softland India</option>
    <option value="Mobio">Mobio</option>
    <option value="ICOFSS">ICOFSS</option>
    <option value="WiFi solutions">WiFi solutions</option>
    <option value="Talent Services">Talent Services</option>
    </Select>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="country">Vendor type</label>
      </div>
      <div class="col-75">
      <Select name="vd_type" size="1" id="vd_type">
    <option selected value="0" disabled="disabled">Select a Vendor Type</option>
    <option value="Supplier">Supplier</option>
    </Select>
    </div>
    </div>
    
      <div class="row">
      <div class="col-25">
        <label for="vd_type">Vendor Asset Type</label>
      </div>
      <div class="col-75">
     <Select name="vd_atype" size="1" id="vd_atype">
    <option selected value="0" disabled="disabled">Select a Asset Type</option>
    <option value="Mobile">Mobile</option>
    <option value="Thermal Printer">Thermal Printer</option>
    <option value="Sensor"> Sensor</option>
    <option value="Gateway">Gateway</option>
    <option value="Laptop">Laptop</option>
    <option value="Boom Barrier">Boom Barrier</option>
    </Select>
    </div>
    </div>
  
    
       <div class="row">
      <div class="col-25">
        <label for="country">Valid from</label>
      </div>
      <div class="col-75">
      
       <input type="date" name="vd_from" placeholder="mm/dd/yyyy" required><br><br>
        
        </div>
    </div>
    
     <div class="row">
      <div class="col-25">
        <label for="country">Valid to</label>
      </div>
      <div class="col-75">
       <input type="date" name="vd_to" placeholder="mm/dd/yyyy" required><br><br>
        </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="country">Address*</label>
      </div>
      <div class="col-75">
      <div class="col-65">
       <input type="text" name="vd_addr" placeholder="Enter Address" autofocus="autofocus" value required><br>
        </div>
    </div>
    </div>
    
    <div class="col" style="width: 200%; margin-top: 35px;margin-left:500; height: 10px; ">
    <input type="submit" value="Submit">
    </div>
</form>
</div>

<div class="container" style="margin-top: 2px">
<div align="center">
	<h2>List of Vendors</h2>
	<table border="1" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<th>ID</th>
			<th>Vendor Name</th>
			<th>Vendor type</th>
			<th>Vendor Asset Type</th>
			<th>Vendor Valid From</th>
			<th>Vendor Valid To</th>
			<th>Vendor Address</th>
			<th>Edit/Delete</th>
		</tr>
	<%
	for(Vendor_Det vendor_det : vendor_dets){
	%>
	
	<tr>
	<td><%= vendor_det.getVd_id() %></td>
	<td><%= vendor_det.getVd_name() %></td>
	<td><%= vendor_det.getVd_type() %></td>
	<td><%= vendor_det.getVd_atype() %></td>
	<td><%= vendor_det.getVd_from() %></td>
	<td><%= vendor_det.getVd_to() %></td>
	<td><%= vendor_det.getVd_addr() %></td>
	<td>
	<a href="EditVendor.jsp?vd_id=<%=vendor_det.getVd_id()%>">Edit</a>|
	<a href="deletevendor?vd_id=<%=vendor_det.getVd_id()%>">Delete</a>
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
		<jsp:useBean id="vendor_det" class="com.ignite.beans.Vendor_Det" scope="request"/>
		<jsp:setProperty property="*" name="vendor_det"/>
		<jsp:forward page="vendor_det"/>
		<%
	}
	} //end of session
	else { // session not found
		response.sendRedirect("Login.jsp");
	}
%>