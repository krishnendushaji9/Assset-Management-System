<%@page import="com.ignite.jdbcdao.Vendor_detJdbcDao"%>
<%@page import="com.ignite.beans.Vendor_Det"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("username")!=null){
if(request.getMethod().equalsIgnoreCase("get")){
	int vd_id = Integer.parseInt(request.getParameter("vd_id"));
	Vendor_Det vendor_det = new Vendor_detJdbcDao().find(vd_id);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/1stpage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Details</title>
<title>Edit Vendor</title>
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
       <input type="text" name="vd_id" value="<%= vendor_det.getVd_id()%>" readonly="readonly">
        </div>
        </div>
    </div>
	
	
		
	<div class="row">
      <div class="col-25">
        <label for="country">Vendor Name</label>
      </div>
      <div class="col-75">
      
        <select id="vd_name" name="vd_name">
        <option selected value="0" disabled="disabled"><%= vendor_det.getVd_name() %></option>
        <option value="Samsung">Samsung</option>
	    <option value="MI">MI</option>
	    <option value=" Vivo"> Vivo</option>
	    <option value="Softland India">Softland India</option>
	    <option value="Mobio">Mobio</option>
	    <option value="ICOFSS">ICOFSS</option>
	    <option value="WiFi solutions">WiFi solutions</option>
	    <option value="Talent Services">Talent Services</option>
        </select>
      </div>
      </div>
      
	<div class="row">
      <div class="col-25">
        <label for="vd_type">Vendor type</label>
      </div>
      <div class="col-75">
      <select id="vd_type" name="vd_type">
        <option selected disabled hidden>select</options>
           <option value="Supplier">Supplier</option>
        </select>
    </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="vd_atype">Vendor Asset type</label>
      </div>
      <div class="col-75">
      <select id="vd_atype" name="vd_atype">
        <option selected value="0" disabled="disabled"><%= vendor_det.getVd_atype() %></option>
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
        <label for="vd_from">Valid From</label>
      </div>
      <div class="col-75">
      
           <input type="date" name="vd_from">
       
    </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="vd_to">Valid To</label>
      </div>
      <div class="col-75">
      
        
          <input type="date" name="vd_to" >
        
    </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="vd_addr">Vendor Address</label>
      </div>
      <div class="col-75">
     
        <input type="text" name="vd_addr" value="<%= vendor_det.getVd_addr()%>">
        
        
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
	<jsp:useBean id="vendor_det" class="com.ignite.beans.Vendor_Det" scope="request"/>
	<jsp:setProperty property="*" name="vendor_det"/>
	<jsp:forward page="updatevendor"/>
	<%
}
}
else{
	response.sendRedirect("Login.jsp");
}
%>