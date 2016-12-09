<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="guiComponents.FormularTaskData"%>
<%@page import="java.util.List"%>
<%@page import="guiComponents.FormularData"%>
<%@page import="guiComponents.GuiServices"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link type="text/css" rel="stylesheet"
	href="resources/jsAndCssFiles/theme.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="resources/jsAndCssFiles/ajaxSendLib.js"></script>

<%
	GuiServices service = new GuiServices();
	out.write(service.getMainMenu());
	
	FormularData taskDataEditStaffPerson = service.getEditFormStaffMemberForm();
	List<FormularTaskData> formularDataEditStaffPerson = taskDataEditStaffPerson.getFormularDataList();
	
	FormularData taskDataEditSalary = service.getEditFormSalaryForm();
	List<FormularTaskData> formularDataEditSalary = taskDataEditSalary.getFormularDataList();
	
	FormularData taskDataDeleteStaffPerson = service.getDeleteFormStaffMemberForm();
	List<FormularTaskData> formularDataDeleteStaffPerson = taskDataDeleteStaffPerson.getFormularDataList();
	
	FormularData taskDataDeleteSalary = service.getDeleteFormSalaryForm();
	List<FormularTaskData> formularDataDeleteSalary  = taskDataDeleteSalary .getFormularDataList();
%>

<script type="text/javascript">
	$(document).ready(
			function() {
				clicked($('#<%out.write(taskDataEditStaffPerson.getName());%>'), '<%out.write(taskDataEditStaffPerson.getAction());%>',
						$('#outputTablePlatform'));
				clicked($('#<%out.write(taskDataEditSalary.getName());%>'), '<%out.write(taskDataEditSalary.getAction());%>',
						$('#outputTablePlatform'));
				clicked($('#<%out.write(taskDataDeleteStaffPerson.getName());%>'), '<%out.write(taskDataDeleteStaffPerson.getAction());%>',
						$('#outputTablePlatform'));
				clicked($('#<%out.write(taskDataDeleteSalary.getName());%>'), '<%out.write(taskDataDeleteSalary.getAction());%>',
						$('#outputTablePlatform'));
			});
</script>

<title>Edit/Delete Entity</title>
</head>
<body>
	<h2>Edit staff member of salary</h2>

	<table>
		<tr>
			<td valign="top">

				<form id="<%out.write(taskDataEditStaffPerson.getName());%>"
					method="<%out.write(taskDataEditStaffPerson.getMethod());%>"
					action="<%out.write(taskDataEditStaffPerson.getAction());%>">
					<table>
						<%
							for (int i = 0; i < formularDataEditStaffPerson.size(); i++) {
						%>
						<tr>
							<td>
								<%
									out.write(formularDataEditStaffPerson.get(i).getTaskLabelText());
								%>
							</td>
							<td><input
								type="<%out.write(formularDataEditStaffPerson.get(i).getType());%>"
								name="<%out.write(formularDataEditStaffPerson.get(i).getName());%>"></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td></td>
							<td><input type="<%out.write(taskDataEditStaffPerson.getType());%>"
								value="<%out.write(taskDataEditStaffPerson.getValue());%>"></td>
						</tr>
					</table>
				</form>

			</td>
			<td valign="top">
				<form id="<%out.write(taskDataEditSalary.getName());%>"
					method="<%out.write(taskDataEditSalary.getMethod());%>"
					action="<%out.write(taskDataEditSalary.getAction());%>">
					<table>
						<%
							for (int i = 0; i < formularDataEditSalary.size(); i++) {
						%>
						<tr>
							<td>
								<%
									out.write(formularDataEditSalary.get(i).getTaskLabelText());
								%>
							</td>
							<td><input
								type="<%out.write(formularDataEditSalary.get(i).getType());%>"
								name="<%out.write(formularDataEditSalary.get(i).getName());%>"></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td></td>
							<td><input type="<%out.write(taskDataEditSalary.getType());%>"
								value="<%out.write(taskDataEditSalary.getValue());%>"></td>
						</tr>
					</table>
				</form>

			</td>
		</tr>
	</table>
	<h2>Delete staff member of salary</h2>
	<table>
		<tr>
			<td valign="top">

				<form id="<%out.write(taskDataDeleteStaffPerson.getName());%>"
					method="<%out.write(taskDataDeleteStaffPerson.getMethod());%>"
					action="<%out.write(taskDataDeleteStaffPerson.getAction());%>">
					<table>
						<%
							for (FormularTaskData oneFormularTaskData : formularDataDeleteStaffPerson) {
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
							<td><input type="<%out.write(taskDataDeleteStaffPerson.getType());%>"
								value="<%out.write(taskDataDeleteStaffPerson.getValue());%>"></td>
						</tr>
					</table>
				</form>

			</td>
			<td valign="top">
				<form id="<%out.write(taskDataDeleteSalary.getName());%>">
					<table>
						<%
							for (FormularTaskData oneFormularTaskData : formularDataDeleteSalary) {
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
							<td><input type="<%out.write(taskDataDeleteSalary.getType());%>"
								value="<%out.write(taskDataDeleteSalary.getValue());%>"></td>
						</tr>
					</table>
				</form>

			</td>
		</tr>
	</table>

	<div id="outputTablePlatform"></div>
	<div id="outputTablePlatform"></div>
</body>
</html>