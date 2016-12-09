<%@page import="guiComponents.FormularTaskData"%>
<%@page import="guiComponents.FormularData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="guiComponents.GuiServices" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link type="text/css" rel="stylesheet" href="resources/jsAndCssFiles/theme.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="resources/jsAndCssFiles/ajaxSendLib.js"></script>

<%
	GuiServices service = new GuiServices();
	out.write(service.getMainMenu());
	
	FormularData taskDataStaffPerson = service.getSearchFormStaffMemberForm();
	List<FormularTaskData> formularDataStaffPerson = taskDataStaffPerson.getFormularDataList();
	
	FormularData taskDataSalary = service.getSearchFormSalaryForm();
	List<FormularTaskData> formularDataSalary = taskDataSalary.getFormularDataList();
%>

<script type="text/javascript">
$(document).ready(function(){
	clicked($('#<% out.write(taskDataStaffPerson.getName()); %>'), '<% out.write(taskDataStaffPerson.getAction()); %>', $('#staffPersonTable'));
	clicked($('#<% out.write(taskDataSalary.getName()); %>'), '<% out.write(taskDataSalary.getAction()); %>', $('#salaryTable'));
});
</script>
<title>Search entity</title>

</head>
<body>
<h2>Search entity</h2>
<br>
You can pass logical code to text fields. For example: <10, >15, =13, ='c',...
<br>
<br>
<table>

<tr><td valign="top">

<form id="<% out.write(taskDataStaffPerson.getName()); %>" method="<% out.write(taskDataStaffPerson.getMethod()); %>" action="<% out.write(taskDataStaffPerson.getAction()); %>">
<table>
<% for(int i = 0; i< formularDataStaffPerson.size(); i++) { %>
<tr>
<td><% out.write(formularDataStaffPerson.get(i).getTaskLabelText()); %></td>

<%
	if(formularDataStaffPerson.get(i).getType().compareTo("select")==0){
		%>
		<td><select name="<% out.write(formularDataStaffPerson.get(i).getName()); %>">
		<%
		for(String option : formularDataStaffPerson.get(i).getSelectOptions()){
			%>
			<option><% out.write(option); %></option>
			<%		
		}
		%>
		</select></td>
		<%
	}else{
		%>
		<td><input type="<% out.write(formularDataStaffPerson.get(i).getType()); %>" name="<% out.write(formularDataStaffPerson.get(i).getName()); %>"></td>
		<%
	}
%>
</tr>
<% } %>
<tr>
<td></td><td><input type="<% out.write(taskDataStaffPerson.getType()); %>" value="<% out.write(taskDataStaffPerson.getValue()); %>"></td>
</tr>
</table>
</form> 
</td>
<td valign="top">
<form id="<% out.write(taskDataSalary.getName()); %>" method="<% out.write(taskDataSalary.getMethod()); %>" action="<% out.write(taskDataSalary.getAction()); %>">
<table>
<% for(int i = 0; i< formularDataSalary.size(); i++) { %>
<tr>
<td><% out.write(formularDataSalary.get(i).getTaskLabelText()); %></td>

<%
	if(formularDataSalary.get(i).getType().compareTo("select")==0){
		%>
		<td><select name="<% out.write(formularDataSalary.get(i).getName()); %>">
		<%
		for(String option : formularDataSalary.get(i).getSelectOptions()){
			%>
			<option><% out.write(option); %></option>
			<%		
		}
		%>
		</select></td>
		<%
	}else{
		%>
		<td><input type="<% out.write(formularDataSalary.get(i).getType()); %>" name="<% out.write(formularDataSalary.get(i).getName()); %>"></td>
		<%
	}
%>
</tr>
<% } %>
<tr>
<td></td><td><input type="<% out.write(taskDataSalary.getType()); %>" value="<% out.write(taskDataSalary.getValue()); %>"></td>
</tr>
</table>
</form> 
</td>
</tr>
</table>
<br>
<h2>Staff person entities</h2>
<div id="staffPersonTable">
</div>
<br>
<h2>Salary entities</h2>
<div id="salaryTable">
</div>
</body>
</html>