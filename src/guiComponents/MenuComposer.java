package guiComponents;

import java.util.List;

/*
 * This method can compose menu template for use in JSP file. This template is created to String variable
 */
public class MenuComposer {

	private final String optionTextTemplate = "<li><a href= %s >%s</a></li>";		//inner part of menu
	private final String menuOpenTag = "<ul>";										//init of menu option
	private final String menuCloseTag = "</ul>";									//end of menu option

	private List<MenuOptionData> menuOptionList;									//list of options in menu
	
	/**
	 * Set init options for creation of menu
	 * @param paMenuOptionList menu options
	 */
	public MenuComposer(List<MenuOptionData> paMenuOptionList) {
		menuOptionList = paMenuOptionList;
	}

	/**
	 * Compose menu to html form
	 * @return return composed menu in html form
	 */
	public String composeMenu() {
		StringBuilder composedMenu = new StringBuilder(menuOpenTag);
		for (MenuOptionData menuOption : menuOptionList) {
			composedMenu.append(
					fillMenuOptionTemplate(menuOption.getDestinationURL(), menuOption.getMenuOptionLabelText()));
		}
		composedMenu.append(menuCloseTag);

		return composedMenu.toString();
	}

	/**
	 * compose one option of menu
	 * @param paDestinationURL destination part of option
	 * @param paOptionTextLabel label name of option
	 * @return return one part of menu
	 */
	private String fillMenuOptionTemplate(String paDestinationURL, String paOptionTextLabel) {
		return String.format(optionTextTemplate, paDestinationURL, paOptionTextLabel);
	}
}