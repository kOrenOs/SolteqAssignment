package guiComponents;

import java.util.List;

/*
 * This method can compose menu template for use in JSP file. This template is created to String variable
 */
public class MenuComposer {

	private final String optionTextTemplate = "<li><a href= %s >%s</a></li>";
	private final String menuOpenStartTag = "<ul>";
	private final String menuCloseStartTag = "</ul>";
	
	private List<MenuOptionData> menuOptionList;
	
	public MenuComposer(List<MenuOptionData> paMenuOptionList) {
		menuOptionList = paMenuOptionList;
	}
	
	public String composeMenu(){
		StringBuilder composedMenu = new StringBuilder(menuOpenStartTag);
		for(MenuOptionData menuOption : menuOptionList){
			composedMenu.append(fillMenuOptionTemplate(menuOption.getDestinationURL(), 
					menuOption.getMenuOptionLabelText()));
		}
		composedMenu.append(menuCloseStartTag);
		
		return composedMenu.toString();
	}
	
	private String fillMenuOptionTemplate(String paDestinationURL, String paOptionTextLabel){
		return String.format(optionTextTemplate, paDestinationURL, paOptionTextLabel);
	}
}