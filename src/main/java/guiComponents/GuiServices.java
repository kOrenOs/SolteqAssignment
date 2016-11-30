package guiComponents;

import guiComponents.FormularData;

/*
 * This class provides services necessary in JSP files
 */

public class GuiServices {
	
	/*
	 * Method send created menu template to JSP file
	 */
	public String getMainMenu(){
		return StaticGuiComponents.mainMenuCode;
	}
	
	/*
	 * Method, which sent all data for create form for add roww to StaffMember database table
	 */
	public FormularData getInsertFormStaffMemberForm(){
		return StaticGuiComponents.insertFormStaffMember;
	}
	
	/*
	 * Method, which sent all data for create form for add roww to Salary database table
	 */
	public FormularData getInsertFormSalaryForm(){
		return StaticGuiComponents.insertFormSalary;
	}
	
	public String[] getDatabaseColumns(){							//this method is just temporary
		return StaticGuiComponents.fictiveDatabaseColumnNames;
	}
}
