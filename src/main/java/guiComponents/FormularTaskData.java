package guiComponents;

import javax.validation.constraints.NotNull;

/**
 *	Class for storing certain task form
 */

public class FormularTaskData {
	private String representativeName;
	private String type;
	private String name;
	private String value;
	private String taskLabelText;
	
	public FormularTaskData(@NotNull String paRepresentativeName, @NotNull String paType,@NotNull String paName, String paValue, String paTaskLabelText) {
		representativeName = paRepresentativeName;
		type = paType;
		name = paName;
		value = paValue;
		taskLabelText = paTaskLabelText;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public String getTaskLabelText() {
		return taskLabelText;
	}

	public String getRepresentativeName() {
		return representativeName;
	}
}
