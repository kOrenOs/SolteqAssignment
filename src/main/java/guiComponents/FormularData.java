package guiComponents;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

/** 
 * Class for storing form data- type, method, name,... It is easier to manipulate with formulars from 
 * Java side of application
**/

public class FormularData {
	
	private String name;
	private String method;
	private String action;
	private String type;
	private String value;
	
	private List<FormularTaskData> formularData;
	
	public FormularData(String paName, String paMethod, String paAction, String paType, String paValue) {
		name = paName;
		method = paMethod;
		action = paAction;
		type = paType;
		value = paValue;
		
		formularData = new ArrayList<FormularTaskData>();
	}

	public String getName() {
		return name;
	}

	public String getMethod() {
		return method;
	}

	public String getAction() {
		return action;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public List<FormularTaskData> getFormularDataList() {
		return formularData;
	}
	
	public String findTaskName(String paRepresentativeName){
		for(FormularTaskData formularTask : formularData){
			if(formularTask.getRepresentativeName().compareTo(paRepresentativeName)==0){
				return formularTask.getName();
			}
		}
		
		return null;
	}
	
	public void addFormularTaskData(@NotNull String paRepresentativeName, @NotNull FormularTypes paType,@NotNull String paName, String paValue, String paTaskLabelText){
		formularData.add(new FormularTaskData(paRepresentativeName, decodeFormularTypes(paType), paName, paValue, paTaskLabelText));
	}
	
	private String decodeFormularTypes(FormularTypes paFormulaType){
		return paFormulaType.toString();
	}
	
	
	public enum FormularTypes{
		text, checkbox, password
	}
}
