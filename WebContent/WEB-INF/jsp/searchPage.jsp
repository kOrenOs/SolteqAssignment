<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="guiComponents.GuiServices" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	GuiServices service = new GuiServices();
	out.write(service.getMainMenu());
%>
<title>Search entity</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#formID').submit(function(event){
		event.preventDefault();

		var $form = $('#formID');
		var formData = $form.serialize();	
		$.ajax({
		    type: 'POST',
		    url: 'getDataTable.html',
		    data: formData,
		    success: function(msg){
		    	var $table = $('#outputTablePlatform');
		    	$table.append(msg);
		    }
		});
	});
});
</script>

<script>
	var optionPool = [
	<%
		List<String> columnNames = service.getDatabaseColumns();
		
		for(int i = 0; i < columnNames.size(); i++){
			out.write("\""+columnNames.get(i)+"\"");
			if(i < columnNames.size()-1){
				out.write(",");
			}
		}
	%>];

	var idIdentifier = 'identifier';
	var idRow = 'row';
	var idTextBox = 'textBox';
	var idIterator = 0;

	function add(){
		if(optionPool.length > idIterator){
			idIterator++;
			var table = document.getElementById("rowChooseTable");
			var row = table.insertRow(-1);
			row.setAttribute("id", idRow.concat(idIterator));
			
			var cell = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var textBox = document.createElement("input");
			textBox.setAttribute("name", idTextBox.concat(idIterator));
			cell2.appendChild(textBox);
							
			var newSelect = document.createElement("select");
			newSelect.setAttribute("name", idIdentifier.concat(idIterator));
				
			getOptions(newSelect);
			newSelect.value = optionPool[0];
			
			cell.appendChild(newSelect);
		}
	}
	
	function remove(){
		if(idIterator > 0){
			document.getElementById(idRow.concat(idIterator)).remove();
			idIterator--;
		}
	}
	
	function getOptions(element){
		for(i = 0; i < optionPool.length; i++){
			var option = document.createElement("option");
			option.text = optionPool[i];
			element.appendChild(option);
		}
	}
</script>
</head>
<body>
<h2>Search entity</h2>
<div>
<input id="clickMe" type="button" value="+" onclick="add();" />
<input id="clickMe" type="button" value="-" onclick="remove();" />
</div>
<form id="formID">
<table id="rowChooseTable">
</table>
<input type="submit" value="submit">
</form> 
<br>
<div id="outputTablePlatform">
</div>
</body>
</html>