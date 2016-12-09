package guiComponents;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Class for storing certain task in form- inputs
 */

public class FormularTaskData {
	private String representativeName;  //input representative name
	private String type;				//type of input
	private String name;				//name/id of input
	private String taskLabelText;		//label of input
	private List<String> selectOptions;	//select options in case of select type of input
	
	public FormularTaskData(@NotNull String paRepresentativeName, @NotNull String paType, @NotNull String paName,
			String paTaskLabelText, List<String> paSelectOptions) {
		representativeName = paRepresentativeName;
		type = paType;
		name = paName;
		taskLabelText = paTaskLabelText;
		selectOptions = paSelectOptions;
	}

	public List<String> getSelectOptions() {
		return selectOptions;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getTaskLabelText() {
		return taskLabelText;
	}

	public String getRepresentativeName() {
		return representativeName;
	}
}
