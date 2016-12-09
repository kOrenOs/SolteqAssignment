package guiComponents;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Class for storing form data- type, method, name,... It is easier to manipulate with forms stored in application
 **/

public class FormularData {

	private String name;		//mane of form
	private String method;		//method of sending- POST/GET
	private String action;		//destination URL address
	private String type;		//type of input- most submit
	private String value;		//text of input button

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

	/**
	 * Get form input name mapped to text representative name (representative names from GUIConstantsAndTexts class). 
	 * It is possible to task data from form easier with names visible on the form. CHange of names in form will not 
	 * affect usability of forms.
	 * @param paRepresentativeName textbox representative name
	 * @return return string- name of tasked input in form
	 */
	public String findTaskName(String paRepresentativeName) {
		for (FormularTaskData formularTask : formularData) {
			if (formularTask.getRepresentativeName().compareTo(paRepresentativeName) == 0) {
				return formularTask.getName();
			}
		}

		return null;
	}

	/**
	 * Add new input to form
	 * @param paRepresentativeName input representative name
	 * @param paType type of input
	 * @param paName name/id of input
	 * @param paTaskLabelText label of input
	 * @param paSelectOptions select options in case of select type of input
	 */
	public void addFormularTaskData(@NotNull String paRepresentativeName, @NotNull FormularTypes paType,
			@NotNull String paName, String paTaskLabelText, List<String> paSelectOptions) {
		formularData.add(new FormularTaskData(paRepresentativeName, decodeFormularTypes(paType), paName,
				paTaskLabelText, paSelectOptions));
	}

	/**
	 * Decode enum form type to string
	 * @param paFormulaType name of enum type
	 * @return return string value of enum type
	 */
	private String decodeFormularTypes(FormularTypes paFormulaType) {
		return paFormulaType.toString();
	}

	
	/**
	 * Enum for coding allowed input types
	 */
	public enum FormularTypes {
		text, checkbox, password, select
	}
}
