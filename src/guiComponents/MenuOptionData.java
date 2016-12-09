package guiComponents;

import javax.validation.constraints.NotNull;

/*
 * Data storing class for MenuComposer, it describes menu behavior 
 */
public class MenuOptionData {

	private String destinationURL;			//destination address of option
	private String menuOptionLabelText;		//name of option

	public MenuOptionData(@NotNull String paDestinationURL, @NotNull String paMenuOptionLabelText) {
		destinationURL = paDestinationURL;
		menuOptionLabelText = paMenuOptionLabelText;
	}

	public String getMenuOptionLabelText() {
		return menuOptionLabelText;
	}

	public String getDestinationURL() {
		return destinationURL;
	}
}
