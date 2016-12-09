<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="guiComponents.GuiServices"%>
<%@ page import="guiComponents.FormularData"%>
<%@ page import="guiComponents.FormularTaskData"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="resources/jsAndCssFiles/theme.css" />

<%
	GuiServices service = new GuiServices();
	out.write(service.getMainMenu());
%>
<title>Add Staff member or Salary</title>
</head>
<body>
</body>
</html>