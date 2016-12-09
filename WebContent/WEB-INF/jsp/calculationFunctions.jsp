<%@page import="guiComponents.FormularTaskData"%>
<%@page import="java.util.List"%>
<%@page import="guiComponents.FormularData"%>
<%@page import="guiComponents.GuiServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	FormularData taskData = service.getAverageSalaryForm();
	List<FormularTaskData> formularData = taskData.getFormularDataList();
%>

<script type="text/javascript">
$(document).ready(function(){
	clicked($('#<%out.write(taskData.getName());%>'), '<%out.write(taskData.getAction());%>',$('#solutionField'));
});
</script>

<title>Calculation functions</title>
</head>
<body>
<h2>Get average salary in selected month</h2>
<br>

	<form id="<%out.write(taskData.getName());%>"
		method="<%out.write(taskData.getMethod());%>"
		action="<%out.write(taskData.getAction());%>">
		<table>
			<%
				for (FormularTaskData oneFormularTaskData : formularData) {
			%>
			<tr>
				<td>
					<%
						out.write(oneFormularTaskData.getTaskLabelText());
					%>
				</td>
				<td><input type="<%out.write(oneFormularTaskData.getType());%>"
					name="<%out.write(oneFormularTaskData.getName());%>"></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td></td>
				<td><input type="<%out.write(taskData.getType());%>"
					value="<%out.write(taskData.getValue());%>"></td>
			</tr>
		</table>
	</form>
<br>
<div id="solutionField">
</div>
</body>
</html>