function clicked(formName, address, resultField){
	formName.submit(function(event){
		event.preventDefault();

		var $form = formName;
		var formData = $form.serialize();	
		$.ajax({
		    type: 'POST',
		    url: address,
		    data: formData,
		    success: function(msg){
		    	$table = resultField;
		    	$table.html(msg);
		    }
		});
	})
};