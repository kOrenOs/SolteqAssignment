<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="guiComponents.GuiServices" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	GuiServices service = new GuiServices();
	out.write(service.getMainMenu());
%>
<title>Search entity</title>
</head>
<body>
<h2>Search entity</h2>

<input id="clickMe" type="button" value="+" onclick="add();" />
<input id="clickMe" type="button" value="-" onclick="remove();" />
<script>
	var optionPool = [
	<%
		String[] columnNames = service.getDatabaseColumns();
	
		for(int i = 0; i < columnNames.length; i++){
			out.write("\""+columnNames[i]+"\"");
			if(i < columnNames.length-1){
				out.write(",");
			}
		}
	%>];

	var idIdentifier = 'identifier';
	var idIterator = 0;

	function add(){
		if(optionPool.length > idIterator){
			idIterator++;
			var platform = document.getElementById("place");
			var newSelectForm = document.createElement("form");
			newSelectForm.setAttribute("id", idIdentifier.concat(idIterator));
				
			var newSelect = document.createElement("select");
	
			for(i = 0; i < optionPool.length; i++){
				var option = document.createElement("option");
				option.text = optionPool[i];
				newSelect.appendChild(option);
			}
						
			newSelectForm.appendChild(newSelect);
			platform.appendChild(newSelectForm);
			
			formPool.push(newSelectForm);
		}
	}
	
	function remove(){
		if(idIterator > 0){
			var element = document.getElementById(idIdentifier.concat(idIterator));
			alert(element.value);
			optionPool.push(element.options[element.selectedIndex].value);
			document.getElementById(idIdentifier.concat(idIterator)).remove();
			idIterator--;
		}
	}
</script>
</body>
</html>