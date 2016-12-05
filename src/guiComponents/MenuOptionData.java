package guiComponents;

import javax.validation.constraints.NotNull;

/*
 * Data storing class for MenuComposer, here are data describing menu behavior
 */
public class MenuOptionData {
	
	private String destinationURL;
	private String menuOptionLabelText;
	
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
