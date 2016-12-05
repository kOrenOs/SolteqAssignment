<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="guiComponents.GuiServices" %>
<%@ page import="guiComponents.FormularData" %>
<%@ page import="guiComponents.FormularTaskData" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<%
	GuiServices service = new GuiServices();
	out.write(service.getMainMenu());
	FormularData taskData = service.getInsertFormStaffMemberForm();
	List<FormularTaskData> formularData = taskData.getFormularDataList();
%>
<title>Add Staff member or Salary</title>
</head>
<body>
</body>
</html>