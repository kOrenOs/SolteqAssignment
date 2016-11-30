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
<h2>Add Staff member or Salary entity to database</h2>

<table>
<tr><td valign="top">

<form name="<% out.write(taskData.getName()); %>" method="<% out.write(taskData.getMethod()); %>" action="<% out.write(taskData.getAction()); %>">
<table>
<% for(FormularTaskData oneFormularTaskData : formularData) { %>
<tr>
<td><% out.write(oneFormularTaskData.getTaskLabelText()); %></td>
<td><input type="<% out.write(oneFormularTaskData.getType()); %>" name="<% out.write(oneFormularTaskData.getName()); %>"></td>
</tr>
<% } %>
<tr>
<td></td><td><input type="<% out.write(taskData.getType()); %>" value="<% out.write(taskData.getValue()); %>"></td>
</tr>
</table>
</form> 

</td>
<td valign="top">

<% 
	taskData = service.getInsertFormSalaryForm();
	formularData = taskData.getFormularDataList();
%>

<form name="<% out.write(taskData.getName()); %>" method="<% out.write(taskData.getMethod()); %>" action="<% out.write(taskData.getAction()); %>">
<table>
<% for(FormularTaskData oneFormularTaskData : formularData) { %>
<tr>
<td><% out.write(oneFormularTaskData.getTaskLabelText()); %></td>
<td><input type="<% out.write(oneFormularTaskData.getType()); %>" name="<% out.write(oneFormularTaskData.getName()); %>"></td>
</tr>
<% } %>
<tr>
<td></td><td><input type="<% out.write(taskData.getType()); %>" value="<% out.write(taskData.getValue()); %>"></td>
</tr>
</table>
</form> 

</td></tr>
</table>
  
</body>
</html>