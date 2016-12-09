<%@page import="databaseEntity.Staffperson"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="guiComponents.GuiServices"%>
<%@ page import="guiComponents.FormularData"%>
<%@ page import="guiComponents.FormularTaskData"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link type="text/css" rel="stylesheet"
	href="resources/jsAndCssFiles/theme.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript"
	src="resources/jsAndCssFiles/ajaxSendLib.js"></script>

<%
	GuiServices service = new GuiServices();
	out.write(service.getMainMenu());
	
	FormularData taskDataStaffPerson = service.getInsertFormStaffMemberForm();
	List<FormularTaskData> formularDataStaffPerson = taskDataStaffPerson.getFormularDataList();
	
	FormularData taskDataSalary = service.getInsertFormSalaryForm();
	List<FormularTaskData> formularDataSalary = taskDataSalary.getFormularDataList();
%>
<title>Add Staff member or Salary</title>
</head>
<body>
	<h2>Add Staff member or Salary entity to database</h2>

	<script type="text/javascript">
		$(document).ready(
				function() {
					clicked($('#<% out.write(taskDataStaffPerson.getName()); %>'), '<% out.write(taskDataStaffPerson.getAction()); %>',
							$('#outputTablePlatform'));
					clicked($('#<% out.write(taskDataSalary.getName()); %>'), '<% out.write(taskDataSalary.getAction()); %>',
							$('#outputTablePlatform'));
				});
	</script>

	<table>
		<tr>
			<td valign="top">

				<form id="<%out.write(taskDataStaffPerson.getName());%>"
					method="<%out.write(taskDataStaffPerson.getMethod());%>"
					action="<%out.write(taskDataStaffPerson.getAction());%>">
					<table>
						<%
							for (FormularTaskData oneFormularTaskData : formularDataStaffPerson) {
						%>
						<tr>
							<td>
								<%
									out.write(oneFormularTaskData.getTaskLabelText());
								%>
							</td>
							<td><input
								type="<%out.write(oneFormularTaskData.getType());%>"
								name="<%out.write(oneFormularTaskData.getName());%>"></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td></td>
							<td><input
								type="<%out.write(taskDataStaffPerson.getType());%>"
								value="<%out.write(taskDataStaffPerson.getValue());%>"></td>
						</tr>
					</table>
				</form>

			</td>
			<td valign="top">
				<form id="<%out.write(taskDataSalary.getName());%>"
					method="<%out.write(taskDataSalary.getMethod());%>"
					action="<%out.write(taskDataSalary.getAction());%>">
					<table>
						<%
							for (FormularTaskData oneFormularTaskData : formularDataSalary) {
						%>
						<tr>
							<td>
								<%
									out.write(oneFormularTaskData.getTaskLabelText());
								%>
							</td>
							<td><input
								type="<%out.write(oneFormularTaskData.getType());%>"
								name="<%out.write(oneFormularTaskData.getName());%>"></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td></td>
							<td><input type="<%out.write(taskDataSalary.getType());%>"
								value="<%out.write(taskDataSalary.getValue());%>"></td>
						</tr>
					</table>
				</form>

			</td>
		</tr>
	</table>

	<div id="outputTablePlatform"></div>
</body>
</html>