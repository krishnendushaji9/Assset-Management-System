<%@page import="com.ignite.beans.Asset_det"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit page</title>
</head>
<body>
<jsp:useBean id="Asset_det" class="com.ignite.beans.Asset_det" scope="session"/>
<jsp:setProperty name="Asset_det" property="ad_name" param="ad_name"/>
<jsp:setProperty name="Asset_det" property="ad_type" param="ad_type"/>
<jsp:setProperty name="Asset_det" property="ad_class" param="ad_class"/>
Asset_det:
<%=Asset_det %><br>
</body>
</html>